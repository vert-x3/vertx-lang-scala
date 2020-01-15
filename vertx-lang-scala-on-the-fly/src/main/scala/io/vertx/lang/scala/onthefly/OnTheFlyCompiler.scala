/*
 * Copyright 2010 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License. You may obtain
 * a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.vertx.lang.scala.onthefly

import java.io.File
import java.math.BigInteger
import java.nio.file.Paths
import java.security.MessageDigest

import scala.collection.mutable
import scala.io.Source
import scala.io.Source.fromInputStream
import scala.reflect.internal.util.{AbstractFileClassLoader, BatchSourceFile}
import scala.tools.nsc.Settings
import scala.tools.nsc.io.{AbstractFile, VirtualDirectory}

/**
  * This compiler is used to compile both scriplets and scala-files contained in the classpath.
  * The original class has been taken from https://github.com/twitter/util/blob/master/util-eval/src/main/scala/com/twitter/util/Eval.scala.
  * It was modified in this blog post https://eknet.org/main/dev/runtimecompilescala.html
  *
  * We kept the original license from Twitter.
  *
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
class OnTheFlyCompiler(targetDir: Option[File]) {

  val defaultName = "(inline)"
  val reg = "import\\s(.*)".r
  val that = this

  val storageForCompiledClasses = targetDir match {
    case Some(dir) => AbstractFile.getDirectory(dir)
    case None => new VirtualDirectory("(memory)", None)
  }

  val cacheForCompiledClasses = mutable.Map[String, Class[_]]()

  private val settings = new Settings()
  settings.deprecation.value = true // enable detailed deprecation warnings
  settings.unchecked.value = true // enable detailed unchecked warnings
  settings.outputDirs.setSingleOutput(storageForCompiledClasses)
  settings.usejavacp.value = true

  val compiler = ReusableCompiler(settings)

  val classLoader = new AbstractFileClassLoader(storageForCompiledClasses,
    this.getClass.getClassLoader)

  /**
    * Compiles the code as a class into the class loader of this compiler.
    *
    * @param code the class to be compile
    */
  def compileClass(code: String): Unit = {
    reg.findAllIn(code).matchData.foreach { m =>
      findClass(m.group(1))
    }
    compiler.compileSources(List(new BatchSourceFile(defaultName, code)))
  }

  /**
    * Compiles the code-snippet as a class into the class loader of this compiler.
    *
    * @param code the snipped to be compile
    * @return the class resulting from the compilation
    */
  def compileScript(code: String): Class[_] = {
    val className = classNameForCode(code)
    reg.findAllIn(code).matchData.foreach { m =>
      findClass(m.group(1))
    }
    findClass(className).getOrElse {
      val sourceFiles = List(
        new BatchSourceFile(defaultName, wrapCodeInClass(className, code))
      )
      compiler.compileSources(sourceFiles)
      findClass(className).get
    }
  }

  /**
    * Compiles the source string into the class loader and
    * evaluates it.
    *
    * @param code the snipped to be compile
    * @tparam T the resulting class
    * @return an instance of the compiled-code
    */
  def eval[T](code: String): T = {
    val cls = compileScript(code)
    cls
      .getConstructor()
      .newInstance()
      .asInstanceOf[() => Any]
      .apply()
      .asInstanceOf[T]
  }

  /**
    * Checks if the given classname is available in the current classloader.
    *
    * @param className name of the class to be found
    * @return the class looked for if it exists
    */
  def findClass(className: String): Option[Class[_]] = {
    synchronized {
      cacheForCompiledClasses.get(className).orElse {
        classLoader.tryToLoadClass(className) match {
          case Some(c) => Some(c)
          case None => tryToCompileClass(className)
        }
      }
    }
  }

  /**
    * Checks if there is a src-file in the classpath for the given classname.
    *
    * @param className name of the class to look for
    * @return the class looked for if it exists
    */
  def tryToCompileClass(className: String): Option[Class[_]] = {
    if(className.endsWith(".scala")) {
      val file = new File(className)
      val source = if(file.exists())
                  Source.fromFile(Paths.get(className).toFile)
                else
                  Source.fromInputStream(classLoader.getResourceAsStream(className))
      if (source == null)
        None
      else {
        compileClass(source.getLines().mkString("\n"))
        findClass(Paths.get(className).getFileName.toString.replace(".scala",""))
      }
    } else {
      val res =
        classLoader.getResourceAsStream(className.replace(".", "/") + ".scala")
      if (res == null)
        None
      else {
        compileClass(fromInputStream(res).getLines().mkString("\n"))
        findClass(className)
      }
    }
  }

  /**
    * Generate a classname based on the hashcode of the code.
    *
    * @param code the code be used for generating the hashcode
    * @return the generated hashcode
    */
  protected def classNameForCode(code: String): String = {
    val digest = MessageDigest.getInstance("SHA-1").digest(code.getBytes)
    s"sha${new BigInteger(1, digest).toString(16)}"
  }

  /**
    * Wrap source code in a new class with an apply method.
    *
    * @param className name of the resulting class
    * @param code      the code snipped that should be wrapped into a class
    * @return the resulting, wrapped code
    */
  private def wrapCodeInClass(className: String, code: String): String = {
    s"class ${className} extends (() => Any) {" +
      s"  def apply() = {${code}}" +
      s"}"
  }
}
