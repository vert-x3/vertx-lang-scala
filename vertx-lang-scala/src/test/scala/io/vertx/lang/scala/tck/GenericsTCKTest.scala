package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.{GenericsTCKImpl, RefedInterface1Impl, TestEnum, TestGenEnum}
import io.vertx.lang.scala.json.Json
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import io.vertx.scala.codegen.testmodel.{GenericsTCK, RefedInterface1, TestDataObject}

/**
  * Created by jochen on 30.12.16.
  */
@RunWith(classOf[JUnitRunner])
class GenericsTCKTest extends FlatSpec with Matchers {
  val obj = GenericsTCK(new GenericsTCKImpl)

  "testMethodWithByteParameterizedReturn" should "work" in {
    val res = obj.methodWithByteParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithShortParameterizedReturn" should "work" in {
    val res = obj.methodWithShortParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithIntegerParameterizedReturn" should "work" in {
    val res = obj.methodWithIntegerParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithLongParameterizedReturn" should "work" in {
    val res = obj.methodWithLongParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithFloatParameterizedReturn" should "work" in {
    val res = obj.methodWithFloatParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithDoubleParameterizedReturn" should "work" in {
    val res = obj.methodWithDoubleParameterizedReturn()
    res.setValue(12)
    assert(res.getValue() == 12)
  }

  "testMethodWithBooleanParameterizedReturn" should "work" in {
    val res = obj.methodWithBooleanParameterizedReturn()
    res.setValue(true)
    assert(res.getValue() == true)
  }

  "testMethodWithCharacterParameterizedReturn" should "work" in {
    val res = obj.methodWithCharacterParameterizedReturn()
    res.setValue('a')
    assert(res.getValue() == 'a')
  }

  "testMethodWithStringParameterizedReturn" should "work" in {
    val res = obj.methodWithStringParameterizedReturn()
    res.setValue("abc")
    assert(res.getValue() == "abc")
  }

  "testMethodWithJsonObjectParameterizedReturn" should "work" in {
    val res = obj.methodWithJsonObjectParameterizedReturn()
    res.setValue(Json.obj(("a", "a")))
    assert(res.getValue() == Json.obj(("a", "a")))
  }

  "testMethodWithJsonArrayParameterizedReturn" should "work" in {
    val res = obj.methodWithJsonArrayParameterizedReturn()
    res.setValue(Json.arr("a", "a"))
    assert(res.getValue() == Json.arr("a", "a"))
  }

  "testMethodWithDataObjectParameterizedReturn" should "work" in {
    val res = obj.methodWithDataObjectParameterizedReturn()
    res.setValue(TestDataObject().setBar(10))
    assert(res.getValue().getBar == 10)
  }

  "testMethodWithEnumParameterizedReturn" should "work" in {
    val res = obj.methodWithEnumParameterizedReturn()
    res.setValue(TestEnum.JULIEN)
    assert(res.getValue() == TestEnum.JULIEN)
  }

  "testMethodWithGenEnumParameterizedReturn" should "work" in {
    val res = obj.methodWithGenEnumParameterizedReturn()
    res.setValue(TestGenEnum.LAURA)
    assert(res.getValue() == TestGenEnum.LAURA)
  }

  "testMethodWithUserTypeParameterizedReturn" should "work" in {
    val res = obj.methodWithUserTypeParameterizedReturn()
    val refed = RefedInterface1(new RefedInterface1Impl)
    res.setValue(refed)
    assert(res.getValue() == refed)
  }


}
