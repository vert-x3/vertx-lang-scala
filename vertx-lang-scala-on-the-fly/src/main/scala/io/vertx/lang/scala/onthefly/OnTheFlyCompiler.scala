package io.vertx.lang.scala.onthefly

import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

import scala.collection.mutable
import scala.io.Source.fromInputStream
import scala.reflect.internal.util.{AbstractFileClassLoader, BatchSourceFile}
import scala.tools.nsc.Settings
import scala.tools.nsc.io.{AbstractFile, VirtualDirectory}
import scala.util.Success

/**
  * This compiler is used to compile both scriplets and scala-files contained in the classpath.
  * The basic idea is taken from here: Taken from https://eknet.org/main/dev/runtimecompilescala.html
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class OnTheFlyCompiler(targetDir: Option[File]) {

  val defaultName = "(inline)"
  val reg         = "import\\s(.*)".r
  val that        = this

  val storageForCompiledClasses = targetDir match {
    case Some(dir) => AbstractFile.getDirectory(dir)
    case None      => new VirtualDirectory("(memory)", None)
  }

  val cacheForCompiledClasses = mutable.Map[String, Class[_]]()

  private val settings = new Settings()
  settings.deprecation.value = true // enable detailed deprecation warnings
  settings.unchecked.value = true   // enable detailed unchecked warnings
  settings.outputDirs.setSingleOutput(storageForCompiledClasses)
  settings.usejavacp.value = true

  val compiler = ReusableCompiler(settings)

  val classLoader = new AbstractFileClassLoader(storageForCompiledClasses,
                                                this.getClass.getClassLoader)

  /**
    * Compiles the code as a class into the class loader of this compiler.
    *
    * @param code
    * @return
    */
  def compileClass(code: String) = {
    reg.findAllIn(code).matchData.foreach { m =>
      findClass(m.group(1))
    }
    compiler.compileSources(List(new BatchSourceFile(defaultName, code)))
  }

  /**
    * Compiles the code-snippet as a class into the class loader of this compiler.
    *
    * @param code
    * @return
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
    * @param code
    * @tparam T
    * @return
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
    * @param className
    * @return
    */
  def findClass(className: String): Option[Class[_]] = {
    synchronized {
      cacheForCompiledClasses.get(className).orElse {
        classLoader.tryToLoadClass(className) match {
          case Some(c) => Some(c)
          case None    => tryToCompileClass(className)
        }
      }
    }
  }

  /**
    * Checks if there is a src-file in the classpath for the given classname.
    *
    * @param className
    * @return
    */
  def tryToCompileClass(className: String): Option[Class[_]] = {
    val res =
      classLoader.getResourceAsStream(className.replace(".", "/") + ".scala")
    if (res == null)
      None
    else {
      compileClass(fromInputStream(res).getLines().mkString("\n"))
      findClass(className)
    }
  }

  /**
    * Generate a classname based on the hashcode of the code.
    *
    * @param code
    * @return
    */
  protected def classNameForCode(code: String): String = {
    val digest = MessageDigest.getInstance("SHA-1").digest(code.getBytes)
    s"sha${ new BigInteger(1, digest).toString(16) }"
  }

  /**
    * Wrap source code in a new class with an apply method.
    */
  private def wrapCodeInClass(className: String, code: String) = {
    s"class ${ className } extends (() => Any) {" +
    s"  def apply() = {${ code }}" +
    s"}"
  }
}
