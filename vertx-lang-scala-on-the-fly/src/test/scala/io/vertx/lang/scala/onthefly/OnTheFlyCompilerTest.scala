package io.vertx.lang.scala.onthefly

import java.io.File
import java.nio.file.Files
import org.junit.runner.RunWith
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatestplus.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class OnTheFlyCompilerTest extends AnyFlatSpec with Matchers {

"A simple test class" should "should be compiled" in {
    val compiler = new OnTheFlyCompiler(None)
    val script   = "class Test{}"
    compiler.compileClass(script)
    compiler.findClass("Test") shouldBe defined
  }

  "A method executed on a onthefly-compiled test class" should "return the expected value" in {
    val compiler = new OnTheFlyCompiler(None)
    val script = "import io.vertx.lang.scala.onthefly.Extendthis\n" +
        "class Test extends Extendthis{\n" +
        "override def hello():String = \"hello\"\n" +
        "}"
    compiler.compileClass(script)
    compiler
      .findClass("Test")
      .get
      .getDeclaredConstructor()
      .newInstance()
      .asInstanceOf[Extendthis]
      .hello() shouldBe "hello"
  }

  "A class depending on another uncompiled class" should "compile and do stuff" in {
    val compiler = new OnTheFlyCompiler(None)
    val script = "import io.vertx.lang.scala.onthefly.Extendthis\n" +
        "import io.vertx.lang.scala.onthefly.NotCompiled\n" +
        "class Test extends Extendthis{\n" +
        "override def hello():String = \"hello\"\n" +
        "}"
    compiler.compileClass(script)
    compiler
      .findClass("Test")
      .get
      .getDeclaredConstructor()
      .newInstance()
      .asInstanceOf[Extendthis]
      .hello() shouldBe "hello"
  }

  "Compiling a broken class" should "should throw a ClassNotFoundException" in {
    val compiler = new OnTheFlyCompiler(None)
    val script = "import io.vertx.lang.scala.onthefly.Extendthis\n" +
      "class Test extends Extendthis<AAAA>{\n" +
      "override def hello():String = \"hello\"\n" +
      "}"
    intercept[ClassNotFoundException] {
      compiler.compileClass(script)
    }
  }

  "Compiling a class depending on a broken uncompiled class" should "should throw a ClassNotFoundException" in {
    val compiler = new OnTheFlyCompiler(None)
    val script = "import io.vertx.lang.scala.onthefly.Broken\n" +
      "class Test {}"
    intercept[ClassNotFoundException] {
      compiler.compileClass(script)
    }
  }

  "Some test code" should "be compiled and evaluted" in {
    val compiler = new OnTheFlyCompiler(None)
    val script   = "println(\"you should see me\")"
    compiler.eval[Unit](script)
  }

  "A non-existent class for witch the classpath contains source-code" should "be automatically compiled and made available" in {
    val compiler = new OnTheFlyCompiler(None)
    compiler
      .findClass("io.vertx.lang.scala.onthefly.TestClass") shouldBe defined
  }

  "TestClass" should "be compiled and evaluted" in {
    val compiler = new OnTheFlyCompiler(None)
    val script =
      "import io.vertx.lang.scala.onthefly.TestClass\nprintln(new TestClass())"
    compiler.eval[Unit](script)
  }

  "A non-existent class for witch there is no source-code available on the classpath" should "result in a None-value" in {
    val compiler = new OnTheFlyCompiler(None)
    compiler
      .findClass("io.vertx.lang.scala.onthefly.IDontExist") shouldBe None
  }

  "A source file" should "be compiled" in {
    val dir = Files.createTempDirectory("clazzes")
    val file = new File(dir.toString, "SourceClass.scala")
    val rs = getClass.getClassLoader.getResourceAsStream("SourceClass.scala")
    Files.copy(rs, file.toPath)
    val compiler = new OnTheFlyCompiler(None)
    val clazz = compiler
      .tryToCompileClass(file.toPath.toAbsolutePath.toString)
      .get

    val method = clazz.getDeclaredMethod("doIt")
    val inst = clazz.getDeclaredConstructor().newInstance()
    method.invoke(inst) should equal("works")
  }

  "A source file from the classpath" should "be compiled" in {
    val compiler = new OnTheFlyCompiler(None)
    val clazz = compiler
      .tryToCompileClass("SourceFromClassPath.scala")
      .get

    val method = clazz.getDeclaredMethod("doIt")
    val inst = clazz.getDeclaredConstructor().newInstance()
    method.invoke(inst) should equal("works2")
  }
}
