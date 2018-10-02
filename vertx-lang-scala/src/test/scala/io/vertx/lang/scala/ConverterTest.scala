package io.vertx.lang.scala


import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.scala.codegen.testmodel.TestDataObject
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

/**
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ConverterTest extends FlatSpec with Matchers {

  "toJava" should "return a Java instance of the given Scala-type" in {
    assert(toJava[TestDataObject](TestDataObject()).isInstanceOf[JTestDataObject])
  }

  "toScala" should "return a Scala instance of the given Java-type" in {
    assert(toScala[TestDataObject](new JTestDataObject()).isInstanceOf[TestDataObject])
  }

  "toScala" should "return a JsonObject for a JsonObject" in {
    assert(toScala[JsonObject](Json.obj(("hallo","welt"))).isInstanceOf[JsonObject])
  }

  "toJava" should "return a JsonObject for a JsonObject" in {
    assert(toJava(Json.obj(("hallo","welt"))).isInstanceOf[JsonObject])
  }

  "toScala" should "convert java.lang.Integer to Scala-Int" in {
    assert(toScala[Int](10000.asInstanceOf[java.lang.Integer]).isInstanceOf[Int])
  }

  "toJava" should "convert a Scala-Int to java.lang.Integer" in {
    assert(toJava[java.lang.Integer](10000.asInstanceOf[Int]).isInstanceOf[java.lang.Integer])
  }

  "toJavaClass" should "should give the Java-class for the given Scala-class" in {
    assert(toJavaClass(classOf[TestDataObject]) == classOf[JTestDataObject])
  }

  "toScalaClass" should "should give the Scala-class for the given Java-class" in {
    assert(toScalaClass(classOf[JTestDataObject]) == classOf[TestDataObject])
  }
}
