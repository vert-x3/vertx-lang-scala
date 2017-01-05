package io.vertx.lang.scala.tck

import java.lang.Boolean

import io.vertx.codegen.testmodel.{FunctionParamTCKImpl, RefedInterface1Impl, TestEnum}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json.arr
import io.vertx.scala.codegen.testmodel.{FunctionParamTCK, RefedInterface1, TestDataObject}
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

import scala.collection.mutable

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class FunctionParamTCKTest extends FlatSpec with Matchers {
  val obj = FunctionParamTCK(new FunctionParamTCKImpl())
  "testBasicParam" should "work" in {
    val ret = obj.methodWithBasicParam(
      it => { assert(100.toByte == it); "ok0" },
      it => { assert(1000.toShort == it); "ok1" },
      it => { assert(100000 == it); "ok2" },
      it => { assert(10000000000L == it); "ok3" },
      it => { assert(3.5.toFloat == it); "ok4" },
      it => { assert(0.01 == it); "ok5" },
      it => { assert(true == it); "ok6" },
      it => { assert('F' == it); "ok7" },
      it => { assert("wibble" == it); "ok8" })
    assert(List("ok0","ok1","ok2","ok3","ok4","ok5","ok6","ok7","ok8") == ret)
  }

  "testJsonParam" should "work" in {
    val ret = obj.methodWithJsonParam(
      it => { assert(Json.obj(("one",1),("two",2),("three",3)) == it); "ok0" },
      it => { assert(arr("one","two","three") == it); "ok1" })
    assert(List("ok0","ok1") == ret)
  }

  "testVoidParam" should "work" in {
    assert("ok" == obj.methodWithVoidParam(() => { assert(true); "ok" }))
  }

  "testUserTypeParam" should "work" in {
    val refed = new RefedInterface1(new RefedInterface1Impl())
    assert("ok" == obj.methodWithUserTypeParam(refed, it => {
      it.setString("foobarjuu")
      assert("foobarjuu" == it.getString())
      "ok"
    }))
  }

  "testObjectParam" should "work" in {
    assert("ok" == obj.methodWithObjectParam(123.asInstanceOf[Object], it => {
      assert(123 == it)
      "ok"
    }))
    assert("ok" == obj.methodWithObjectParam("the-string-arg", it => {
      assert("the-string-arg" == it)
      "ok"
    }))
  }

  "testDataObjectParam" should "work" in {
    assert("ok" == obj.methodWithDataObjectParam(it => {
      assert("foo_value" == it.getFoo)
      assert(3 == it.getBar)
      assert(0.01 == it.getWibble)
      "ok"
    }))
  }

  "testEnumParam" should "work" in {
    assert("ok" == obj.methodWithEnumParam(it => {
      assert(TestEnum.TIM == it)
      "ok"
    }))
  }

  "testListParam" should "work" in {
    assert("ok" == obj.methodWithListParam(it => {
      assert(List("one", "two", "three") == it)
      "ok"
    }))
  }

  "testSetParam" should "work" in {
    assert("ok" == obj.methodWithSetParam(it => {
      assert(Set("one", "two", "three") == it)
      "ok"
    }))
  }

  "testMapParam" should "work" in {
    assert("ok" == obj.methodWithMapParam(it => {
      assert(Map("one" ->"one", "two" -> "two", "three" -> "three") == it)
      "ok"
    }))
  }

  "testGenericParam" should "work" in {
    assert("ok" == obj.methodWithGenericParam[Int](123, it => {
      assert(123 == it)
      "ok"
    }))
    assert("ok" == obj.methodWithGenericParam[String]("the-string-arg", it => {
      assert("the-string-arg" == it)
      "ok"
    }))
  }

  "testGenericUserTypeParam" should "work" in {
    assert("ok" == obj.methodWithGenericUserTypeParam[Int](123, it => {
      assert(123 == it.getValue())
      "ok"
    }))
    assert("ok" == obj.methodWithGenericUserTypeParam[String]("the-string-arg", it => {
      assert("the-string-arg" == it.getValue())
      "ok"
    }))
  }

  "testNullableListParam" should "work" ignore {
    assert("ok" == obj.methodWithNullableListParam(it => {
      assert(null == it)
      "ok"
    }))
  }

  "testBasicReturn" should "work" in {
    assert("ok" == obj.methodWithBasicReturn(
      it => { 10.toByte },
      it => { 1000.toShort },
      it => { 100000 },
      it => { 10000000000l },
      it => { 0.01f },
      it => { 0.00001 },
      it => { true },
      it => { 'C' },
      it => { "the-return" }
    ))
  }

  "testJsonReturn" should "work" in {
    assert("ok" == obj.methodWithJsonReturn(
      it => { Json.obj(("foo","foo_value"),("bar",10),("wibble",0.1)) },
      it => { arr("one","two","three") }
    ))
  }

  "testObjectReturn" should "work" in {
    assert("ok" == obj.methodWithObjectReturn(
      it => it match {
          case 0 => "the-string".asInstanceOf[Object]
          case 1 => 123.asInstanceOf[Object]
          case 2 => true.asInstanceOf[Object]
          case 3 => Json.obj(("foo","foo_value")).asInstanceOf[Object]
          case 4 => arr("foo","bar").asInstanceOf[Object]
          case _ => throw new Exception()
        }
    ))
  }

  "testDataObjectReturn" should "work" in {
    assert("ok" == obj.methodWithDataObjectReturn(it => {TestDataObject(new JTestDataObject().setFoo("wasabi").setBar(6).setWibble(0.01))}))
  }

  "testEnumReturn" should "work" in {
    assert("ok" == obj.methodWithEnumReturn(it => {TestEnum.NICK}))
  }

  "testListReturn" should "work" in {
    assert("ok" == obj.methodWithListReturn(it => {mutable.Buffer("one", "two", "three")}))
  }

  "testSetReturn" should "work" in {
    assert("ok" == obj.methodWithSetReturn(it => {mutable.Set("one", "two", "three")}))
  }

  "testMapReturn" should "work" in {
    assert("ok" == obj.methodWithMapReturn(it => {mutable.Map("one" -> "one", "two" -> "two", "three" -> "three")}))
  }

  "testGenericReturn" should "work" in {
    //This feels a lot like tricking the type-system
    assert("ok" == obj.methodWithGenericReturn[Object]( it => {
      if (it == 0) new String("the-string").asInstanceOf[Object]
      else if (it == 1) Integer.valueOf(123)
      else if (it == 2) Boolean.valueOf(true)
      else if (it == 3) Json.obj(("foo", "foo_value"))
      else Json.arr("foo", "bar")

    }))
  }

  "testGenericUserTypeReturn" should "work" in {
    assert("ok" == obj.methodWithGenericUserTypeReturn[Int](it => { it }))
  }

  "testNullableListReturn" should "work" ignore {
    assert("ok" == obj.methodWithNullableListReturn(it => { null }))
  }
}
