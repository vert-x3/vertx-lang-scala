package io.vertx.lang.scala


import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.lang.scala.Converter.{toJava, toScala}
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.scala.codegen.testmodel.TestDataObject
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ConversionTest extends FlatSpec with Matchers {

  "A generic method " should "return a Java instance" in {
    assert(toScala(TestDataObject()).isInstanceOf[JTestDataObject])
  }

  "A generic method " should "return a Scala instance" in {
    assert(toScala(new JTestDataObject()).isInstanceOf[TestDataObject])
  }

  "A generic method " should "returns a JsonObject for Scala" in {
    assert(toScala(Json.obj(("hallo","welt"))).isInstanceOf[JsonObject])
  }

  "A generic method " should "returns a JsonObject for Java" in {
    assert(toJava(Json.obj(("hallo","welt"))).isInstanceOf[JsonObject])
  }

  "A generic method " should "won't convert Int" in {
    assert(toScala(10000.asInstanceOf[java.lang.Integer]).isInstanceOf[Int])
  }

  "A generic method " should "won't convert java.lang.Integer" in {
    assert(toJava(10000.asInstanceOf[Int]).isInstanceOf[java.lang.Integer])
  }

}
