package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.{RefedInterface1Impl, _}
import io.vertx.lang.scala.json.{Json, JsonArray, JsonObject}
import io.vertx.scala.codegen.testmodel.{GenericsTCK, RefedInterface1, TestDataObject}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers, OptionValues}

import scala.concurrent.ExecutionContext

/**
  * Created by jochen on 30.12.16.
  */
@RunWith(classOf[JUnitRunner])
class GenericsTCKTest extends FlatSpec with Matchers with OptionValues {
  implicit val execCtx = new ExecutionContext {
    override def reportFailure(cause: Throwable): Unit = ???

    override def execute(runnable: Runnable): Unit = runnable.run()
  }

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
    assert(res.getValue())
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
    assert(res.getValue().asJava == refed.asJava)
  }

  "testMethodWithHandlerByteParameterized" should "work" in {
    obj.methodWithHandlerByteParameterized(h => assert(h.getValue() == 123))
  }

  "testMethodWithHandlerShortParameterized" should "work" in {
    obj.methodWithHandlerShortParameterized(h => assert(h.getValue() == 1234))
  }

  "testMethodWithHandlerIntegerParameterized" should "work" in {
    obj.methodWithHandlerIntegerParameterized(h => assert(h.getValue() == 123456))
  }

  "testMethodWithHandlerLongParameterized" should "work" in {
    obj.methodWithHandlerLongParameterized(h => assert(h.getValue() == 123456789))
  }

  "testMethodWithHandlerFloatParameterized" should "work" in {
    obj.methodWithHandlerFloatParameterized(h => assert(h.getValue() == 0.34f))
  }

  "testMethodWithHandlerDoubleParameterized" should "work" in {
    obj.methodWithHandlerDoubleParameterized(h => assert(h.getValue() == 0.314))
  }

  "testMethodWithHandlerBooleanParameterized" should "work" in {
    obj.methodWithHandlerBooleanParameterized(h => assert(h.getValue()))
  }

  "testMethodWithHandlerCharacterParameterized" should "work" in {
    obj.methodWithHandlerCharacterParameterized(h => assert(h.getValue() == 'F'))
  }

  "testMethodWithHandlerStringParameterized" should "work" in {
    obj.methodWithHandlerStringParameterized(h => assert(h.getValue() == "zoumbawe"))
  }

  "testMethodWithHandlerJsonObjectParameterized" should "work" in {
    obj.methodWithHandlerJsonObjectParameterized(h => assert(h.getValue() == Json.obj(("cheese","stilton"))))
  }

  "testMethodWithHandlerJsonArrayParameterized" should "work" in {
    obj.methodWithHandlerJsonArrayParameterized(h => assert(h.getValue() == Json.arr("cheese","stilton")))
  }

  "testMethodWithHandlerDataObjectParameterized" should "work" in {
    obj.methodWithHandlerDataObjectParameterized(h => assert(h.getValue().getBar == 123456))
  }

  "testMethodWithHandlerEnumParameterized" should "work" in {
    obj.methodWithHandlerEnumParameterized(h => assert(h.getValue() == TestEnum.WESTON))
  }

  "testMethodWithHandlerGenEnumParameterized" should "work" in {
    obj.methodWithHandlerGenEnumParameterized(h => assert(h.getValue() == TestGenEnum.LELAND))
  }

  "testMethodWithHandlerUserTypeParameterized" should "work" in {
    obj.methodWithHandlerUserTypeParameterized(h => assert(h.getValue().getString() == "foo"))
  }

  "testMethodWithHandlerAsyncResultByteParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultByteParameterized(h => assert(h.result().getValue() == 123))
  }

  "testMethodWithHandlerAsyncResultShortParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultShortParameterized(h => assert(h.result().getValue() == 1234))
  }

  "testMethodWithHandlerAsyncResultIntegerParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultIntegerParameterized(h => assert(h.result().getValue() == 123456))
  }

  "testMethodWithHandlerAsyncResultLongParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultLongParameterized(h => assert(h.result().getValue() == 123456789))
  }

  "testMethodWithHandlerAsyncResultFloatParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultFloatParameterized(h => assert(h.result().getValue() == 0.34f))
  }

  "testMethodWithHandlerAsyncResultDoubleParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultDoubleParameterized(h => assert(h.result().getValue() == 0.314))
  }

  "testMethodWithHandlerAsyncResultBooleanParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultBooleanParameterized(h => assert(h.result().getValue()))
  }

  "testMethodWithHandlerAsyncResultCharacterParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultCharacterParameterized(h => assert(h.result().getValue() == 'F'))
  }

  "testMethodWithHandlerAsyncResultStringParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultStringParameterized(h => assert(h.result().getValue() == "zoumbawe"))
  }

  "testMethodWithHandlerAsyncResultJsonObjectParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultJsonObjectParameterized(h => assert(h.result().getValue() == Json.obj(("cheese","stilton"))))
  }

  "testMethodWithHandlerAsyncResultJsonArrayParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultJsonArrayParameterized(h => assert(h.result().getValue() == Json.arr("cheese","stilton")))
  }

  "testMethodWithHandlerAsyncResultEnumParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultEnumParameterized(h => assert(h.result().getValue() == TestEnum.WESTON))
  }

  "testMethodWithHandlerAsyncResultGenEnumParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultGenEnumParameterized(h => assert(h.result().getValue() == TestGenEnum.LELAND))
  }

  "testMethodWithHandlerAsyncResultUserTypeParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultUserTypeParameterized(h => assert(h.result().getValue().getString() == "foo"))
  }

  "testMethodWithHandlerAsyncResultDataObjectParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultDataObjectParameterized(h => assert(h.result().getValue().getBar == 123456))
  }

  "testMethodWithFunctionParamByteParameterized" should "work" in {
    var v:Byte = 0
    obj.methodWithFunctionParamByteParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 123)
  }

  "testMethodWithFunctionParamShortParameterized" should "work" in {
    var v:Short = 0
    obj.methodWithFunctionParamShortParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 1234)
  }

  "testMethodWithFunctionParamIntegerParameterized" should "work" in {
    var v:Integer = 0
    obj.methodWithFunctionParamIntegerParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 123456)
  }

  "testMethodWithFunctionParamLongParameterized" should "work" in {
    var v:Long = 0
    obj.methodWithFunctionParamLongParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 123456789)
  }

  "testMethodWithFunctionParamFloatParameterized" should "work" in {
    var v:Float = 0
    obj.methodWithFunctionParamFloatParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 0.34f)
  }

  "testMethodWithFunctionParamDoubleParameterized" should "work" in {
    var v:Double = 0
    obj.methodWithFunctionParamDoubleParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 0.314)
  }

  "testMethodWithFunctionParamBooleanParameterized" should "work" in {
    var v:Boolean = false
    obj.methodWithFunctionParamBooleanParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v)
  }

  "testMethodWithFunctionParamCharacterParameterized" should "work" in {
    var v:Character = 'A'
    obj.methodWithFunctionParamCharacterParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == 'F')
  }

  "testMethodWithFunctionParamStringParameterized" should "work" in {
    var v:String = "A"
    obj.methodWithFunctionParamStringParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == "zoumbawe")
  }

  "testMethodWithFunctionParamJsonObjectParameterized" should "work" in {
    var v:JsonObject =Json.obj()
    obj.methodWithFunctionParamJsonObjectParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == Json.obj(("cheese","stilton")))
  }

  "testMethodWithFunctionParamJsonArrayParameterized" should "work" in {
    var v:JsonArray =Json.arr()
    obj.methodWithFunctionParamJsonArrayParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == Json.arr("cheese","stilton"))
  }

  "testMethodWithFunctionParamEnumParameterized" should "work" in {
    var v:TestEnum = TestEnum.JULIEN
    obj.methodWithFunctionParamEnumParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == TestEnum.WESTON)
  }

  "testMethodWithFunctionParamGenEnumParameterized" should "work" in {
    var v:TestGenEnum = TestGenEnum.BOB
    obj.methodWithFunctionParamGenEnumParameterized(h => {
      v = h.getValue()
      h.getValue().toString})
    assert(v == TestGenEnum.LELAND)
  }

  "testMethodWithFunctionParamUserTypeParameterized" should "work" in {
    var v:String = "a"
    obj.methodWithFunctionParamUserTypeParameterized(h => {
      v = h.getValue().getString()
      h.getValue().toString})
    assert(v == "foo")
  }

  "testMethodWithFunctionParamDataObjectParameterized" should "work" in {
    var v:Int = 0
    obj.methodWithFunctionParamDataObjectParameterized(h => {
      v = h.getValue().getBar
      h.getValue().toString})
    assert(v == 123456)
  }

  "testMethodWithHandlerAsyncResultByteParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultByteParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 123)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultShortParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultShortParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 1234)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultIntegerParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultIntegerParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 123456)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultLongParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultLongParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 123456789)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultFloatParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultFloatParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 0.34f)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultDoubleParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultDoubleParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 0.314)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultBooleanParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultBooleanParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue())
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultCharacterParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultCharacterParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == 'F')
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultStringParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultStringParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == "zoumbawe")
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultJsonObjectParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultJsonObjectParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == Json.obj(("cheese","stilton")))
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultJsonArrayParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultJsonArrayParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == Json.arr("cheese","stilton"))
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultDataObjectParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultDataObjectParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue().getBar == 123456)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultEnumParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultEnumParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == TestEnum.WESTON)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultGenEnumParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenEnumParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue() == TestGenEnum.LELAND)
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultUserTypeParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultUserTypeParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue().getString() == "foo")
        }
        w.dismiss()})
    )
  }

  "testMethodWithHandlerAsyncResultGenericNullableApiFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericNullableApiFuture(true).foreach(result => {
        w {
          assert(result.getValue().get.getString() == "the_string_value")
        }
        w.dismiss()})
    )

    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericNullableApiFuture(false).foreach(result => {
        w {
          assert(result.getValue().isEmpty)
        }
        w.dismiss()})
    )
  }

  "testMethodWithClassTypeParameterizedReturn" should "work" in {
    val res = obj.methodWithClassTypeParameterizedReturn(classOf[String])
    assert(res.getValue() == "zoumbawe")
  }

  "testMethodWithHandlerClassTypeParameterized" should "work" in {
    obj.methodWithHandlerClassTypeParameterized[String](classOf[String], h => assert(h.getValue() == "zoumbawe"))
  }

  "testMethodWithFunctionParamClassTypeParameterized" should "work" in {
    obj.methodWithFunctionParamClassTypeParameterized[String](classOf[String], {
      h => {
        assert(h.getValue() == "zoumbawe")
        h.getValue()
      }
    })
  }

  "testMethodWithClassTypeParam" should "work" in {
     obj.methodWithClassTypeParam[String](classOf[String], "zoumbawe")
  }

  "testMethodWithClassTypeReturn" should "work" in {
    val res = obj.methodWithClassTypeReturn[String](classOf[String])
    assert(res == "zoumbawe")
  }

  "testMethodWithClassTypeHandler" should "work" in {
     obj.methodWithClassTypeHandler[String](classOf[String], h => assert(h == "zoumbawe"))
  }

  "testMethodWithClassTypeFunctionParam" should "work" in {
    val res = obj.methodWithClassTypeFunctionParam[String](classOf[String], h => {
      assert(h == "zoumbawe")
      h
    })
  }

  "testMethodWithClassTypeFunctionReturn" should "work" in {
    obj.methodWithClassTypeFunctionReturn[String](classOf[String], h => {
      assert(h == "whatever")
      "zoumbawe"
    })
  }

  "testInterfaceWithApiArg" should "work" in {
    val res = obj.interfaceWithApiArg(RefedInterface1(new RefedInterface1Impl))
    assert(res.getValue() != null)
  }

  "testInterfaceWithStringArg" should "work" in {
    val res = obj.interfaceWithStringArg("hhh")
    assert(res.getValue() == "hhh")
  }

  "testInterfaceWithVariableArg" should "work" in {
    val res = obj.interfaceWithVariableArg[Float, String](1.0f, classOf[String], "hhh")
    assert(res.getValue() == "hhh")
  }

  "testMethodWithHandlerGenericNullableApi" should "work" in {
    obj.methodWithHandlerGenericNullableApi(true, h => assert(h.getValue().get.getString() == "the_string_value"))
    obj.methodWithHandlerGenericNullableApi(false, h => assert(h.getValue().isEmpty))
  }

  "testMethodWithGenericNullableApiReturn" should "work" in {
    assert(obj.methodWithGenericNullableApiReturn(true).getValue().isDefined)
    assert(obj.methodWithGenericNullableApiReturn(false).getValue().isEmpty)
  }

  "testMethodWithHandlerAsyncResultClassTypeParameterized" should "work" in {
    obj.methodWithHandlerAsyncResultClassTypeParameterized[String](classOf[String], h => assert(h.result().getValue() == "zoumbawe"))
  }

  "testMethodWithHandlerAsyncResultGenericNullableApi" should "work" in {
    obj.methodWithHandlerAsyncResultGenericNullableApi(true, h => assert(h.result().getValue().isDefined))
    obj.methodWithHandlerAsyncResultGenericNullableApi(false, h => assert(h.result().getValue().isEmpty))
  }

  "testMethodWithHandlerAsyncResultClassTypeParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultClassTypeParameterizedFuture[String](classOf[String]).foreach(result => {
        w {
          assert(result.getValue() == "zoumbawe")
        }
        w.dismiss()})
    )
  }

  "testMethodWithClassTypeHandlerAsyncResult" should "work" in {
    obj.methodWithClassTypeHandlerAsyncResult[String](classOf[String], h => assert(h.result() == "zoumbawe"))
  }

}
