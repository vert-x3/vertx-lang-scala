package io.vertx.lang.scala.onthefly

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{ FlatSpec, Matchers }

@RunWith(classOf[JUnitRunner])
class OnTheFlyCompilerTest extends FlatSpec with Matchers {

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
    val compiler = new OnTheFlyCompiler(None)
    val clazz = compiler
      .tryToCompileClass("/Users/jochen/Development/8_vertx/vertx-lang-scala/vertx-lang-scala-on-the-fly/src/test/resources/SourceClass.scala")
      .get

    val method = clazz.getDeclaredMethod("doIt")
    val inst = clazz.newInstance()
    method.invoke(inst) should equal("works")
  }
}
