package io.vertx.lang.scala


import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.Handler
import io.vertx.lang.scala.Converter.{toJava, toScala}
import io.vertx.lang.scala.HandlerOps.funcToMappedHandler
import io.vertx.lang.scala.json.{Json, JsonObject}
import io.vertx.scala.codegen.testmodel.TestDataObject
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

import scala.reflect.runtime.universe._
/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ConversionTest extends FlatSpec with Matchers {

  "A generic method " should "return a Java instance" in {
    val j = new Con().returnsJava[JTestDataObject]()
    assert(j.isInstanceOf[JTestDataObject])
  }

  "A generic method " should "return a Scala instance" in {
    val s = new Con().returnsScala[TestDataObject]()
    assert(s.isInstanceOf[TestDataObject])
  }

  "A generic method " should "returns a JsonObject for Scala" in {
    val s = new Con().returnsJsonObjectScala[JsonObject]()
    assert(s.isInstanceOf[JsonObject])
  }

  "A generic method " should "returns a JsonObject for Java" in {
    val j = new Con().returnsJsonObjectJava[JsonObject]()
    assert(j.isInstanceOf[JsonObject])
  }


  "A generic method " should "dubbidu1" in {
    val j:Int = new Con().convertParamToScala[java.lang.Integer, Int](1)
  }

  "A generic method " should "dubbidu" in {
    val j:java.lang.Integer = new Con().convertParamToJava[Int, java.lang.Integer](Integer.valueOf(1))
  }

  class Con {
    def returnsScala[T:TypeTag](): T = {
      toScala[T](new JTestDataObject())
    }

    def returnsJava[T:TypeTag](): T = {
      toJava[T](TestDataObject())
    }

    def returnsJsonObjectJava[T:TypeTag](): T = {
      toJava[T](Json.obj(("hallo","welt")))
    }

    def returnsJsonObjectScala[T:TypeTag](): T = {
      toJava[T](Json.obj(("hallo","welt")))
    }

    def convertParamToJava[T:TypeTag, V:TypeTag](param:V): T = {
      toJava[T](param.asInstanceOf[Object])
    }

    def convertParamToScala[T:TypeTag, V:TypeTag](param:V): T = {
      toScala[T](param.asInstanceOf[Object])
    }
  }
}
