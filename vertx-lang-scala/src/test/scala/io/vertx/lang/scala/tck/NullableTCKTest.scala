package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel._
import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.lang.scala.json.Json
import io.vertx.scala.codegen.testmodel.{NullableTCK, RefedInterface1, TestDataObject}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers, OptionValues}

import scala.collection.mutable
import scala.concurrent.ExecutionContext
import scala.language.postfixOps
import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class NullableTCKTest extends FlatSpec with Matchers with OptionValues {
  implicit val execCtx = new ExecutionContext {
    override def reportFailure(cause: Throwable): Unit = ???

    override def execute(runnable: Runnable): Unit = runnable.run()
  }

  val nullableTCK = NullableTCK(new NullableTCKImpl)

  "testNullableByte" should "work" in {
    val testByte = 67.toByte
    nullableTCK.methodWithNullableByteParam(true, None)
    nullableTCK.methodWithNullableByteParam(false, Option(testByte))
    nullableTCK.methodWithNullableByteHandler(true, b => assert(b.contains(testByte)))
    nullableTCK.methodWithNullableByteHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableByteHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testByte))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableByteHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableByteReturn(true)
    nullableTCK.methodWithNullableByteReturn(false)
  }

  "testNullableShort" should "work" in {
    val testShort = 1024.toShort
    nullableTCK.methodWithNullableShortParam(true, None)
    nullableTCK.methodWithNullableShortParam(false, Option(testShort))
    nullableTCK.methodWithNullableShortHandler(true, b => assert(b.contains(testShort)))
    nullableTCK.methodWithNullableShortHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableShortHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testShort))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableShortHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableShortReturn(true)
    nullableTCK.methodWithNullableShortReturn(false)
  }

  "testNullableInteger" should "work" in {
    val testInteger = 1234567
    nullableTCK.methodWithNullableIntegerParam(true, None)
    nullableTCK.methodWithNullableIntegerParam(false, Option(testInteger))
    nullableTCK.methodWithNullableIntegerHandler(true, b => assert(b.contains(testInteger)))
    nullableTCK.methodWithNullableIntegerHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableIntegerHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testInteger))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableIntegerHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableIntegerReturn(true)
    nullableTCK.methodWithNullableIntegerReturn(false)
  }

  "testNullableLong" should "work" in {
    val testLong = 9876543210l
    nullableTCK.methodWithNullableLongParam(true, None)
    nullableTCK.methodWithNullableLongParam(false, Option(testLong))
    nullableTCK.methodWithNullableLongHandler(true, b => assert(b.contains(testLong)))
    nullableTCK.methodWithNullableLongHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableLongHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testLong))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableLongHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableLongReturn(true)
    nullableTCK.methodWithNullableLongReturn(false)
  }

  "testNullableFloat" should "work" in {
    val testFloat = 3.14.toFloat
    nullableTCK.methodWithNullableFloatParam(true, None)
    nullableTCK.methodWithNullableFloatParam(false, Option(testFloat))
    nullableTCK.methodWithNullableFloatHandler(true, b => assert(b.contains(testFloat)))
    nullableTCK.methodWithNullableFloatHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableFloatHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testFloat))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableFloatHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableFloatReturn(true)
    nullableTCK.methodWithNullableFloatReturn(false)
  }

  "testNullableDouble" should "work" in {
    val testDouble = 3.1415926
    nullableTCK.methodWithNullableDoubleParam(true, None)
    nullableTCK.methodWithNullableDoubleParam(false, Option(testDouble))
    nullableTCK.methodWithNullableDoubleHandler(true, b => assert(b.contains(testDouble)))
    nullableTCK.methodWithNullableDoubleHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableDoubleHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testDouble))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableDoubleHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableDoubleReturn(true)
    nullableTCK.methodWithNullableDoubleReturn(false)
  }

  "testNullableBoolean" should "work" in {
    val testBoolean = true
    nullableTCK.methodWithNullableBooleanParam(true, None)
    nullableTCK.methodWithNullableBooleanParam(false, Option(testBoolean))
    nullableTCK.methodWithNullableBooleanHandler(true, b => assert(b.contains(testBoolean)))
    nullableTCK.methodWithNullableBooleanHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableBooleanHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testBoolean))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableBooleanHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableBooleanReturn(true)
    nullableTCK.methodWithNullableBooleanReturn(false)
  }

  "testNullableChar" should "work" in {
    val testChar = 'f'
    nullableTCK.methodWithNullableCharParam(true, None)
    nullableTCK.methodWithNullableCharParam(false, Option(testChar))
    nullableTCK.methodWithNullableCharHandler(true, b => assert(b.contains(testChar)))
    nullableTCK.methodWithNullableCharHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableCharHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testChar))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableCharHandlerAsyncResultFuture(false).onComplete {
      case Failure(t) => {
        w {
          fail()
        }
        w.dismiss()
      }
      case Success(r) => {
        w {
          assert(r.isEmpty)
        }
        w.dismiss()
      }
    })
    nullableTCK.methodWithNullableCharReturn(true)
    nullableTCK.methodWithNullableCharReturn(false)
  }

  "testNullableJsonObject" should "work" in {
    val testJsonObject = Json.obj(("foo", "wibble"), ("bar", 3))
    nullableTCK.methodWithNullableJsonObjectParam(true, None)
    nullableTCK.methodWithNullableJsonObjectParam(false, Option(testJsonObject))
    nullableTCK.methodWithNullableJsonObjectHandler(true, b => assert(b.contains(testJsonObject)))
    nullableTCK.methodWithNullableJsonObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableJsonObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testJsonObject))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableJsonObjectHandlerAsyncResultFuture(false).foreach(t => {
      w {
        assert(t.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableJsonObjectReturn(true)
    nullableTCK.methodWithNullableJsonObjectReturn(false)
  }

  "testNullableJsonArray" should "work" in {
    val testJsonArray = Json.arr("one", "two", "three")
    nullableTCK.methodWithNullableJsonArrayParam(true, None)
    nullableTCK.methodWithNullableJsonArrayParam(false, Option(testJsonArray))
    nullableTCK.methodWithNullableJsonArrayHandler(true, b => assert(b.contains(testJsonArray)))
    nullableTCK.methodWithNullableJsonArrayHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableJsonArrayHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testJsonArray))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableJsonArrayHandlerAsyncResultFuture(false).foreach(t => {
      w {
        assert(t.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableJsonArrayReturn(true)
    nullableTCK.methodWithNullableJsonArrayReturn(false)
  }

  "testNullableApi" should "work" ignore {
    val testApi = RefedInterface1(new RefedInterface1Impl().setString("lovely_dae"))
    nullableTCK.methodWithNullableApiParam(true, None)
    nullableTCK.methodWithNullableApiParam(false, Option(testApi))
    nullableTCK.methodWithNullableApiHandler(true, b => assert(testApi.asJava == b.get.asJava))
    nullableTCK.methodWithNullableApiHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableApiHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testApi.asJava == b.get.asJava)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableApiHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableApiReturn(true)
    nullableTCK.methodWithNullableApiReturn(false)
  }

  "testNullableDataObject" should "work" in {
    val testDataObject = TestDataObject.fromJson(Json.obj(("foo", "foo_value"), ("bar", 12345), ("wibble", 3.5)))
    nullableTCK.methodWithNullableDataObjectParam(true, None)
    nullableTCK.methodWithNullableDataObjectParam(false, Option(testDataObject))
    nullableTCK.methodWithNullableDataObjectHandler(true, b => assert(testDataObject.asJava.toJson == b.get.asJava.toJson))
    nullableTCK.methodWithNullableDataObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableDataObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testDataObject.asJava.toJson == b.get.asJava.toJson)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableDataObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableDataObjectReturn(true)
    nullableTCK.methodWithNullableDataObjectReturn(false)
  }

  "testNullableEnum" should "work" in {
    val testEnum = TestEnum.TIM
    nullableTCK.methodWithNullableEnumParam(true, None)
    nullableTCK.methodWithNullableEnumParam(false, Option(testEnum))
    nullableTCK.methodWithNullableEnumHandler(true, b => assert(b.contains(testEnum)))
    nullableTCK.methodWithNullableEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testEnum))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableEnumReturn(true)
    nullableTCK.methodWithNullableEnumReturn(false)
  }

  "testNullableGenEnum" should "work" in {
    val testGenEnum = TestGenEnum.MIKE
    nullableTCK.methodWithNullableGenEnumParam(true, None)
    nullableTCK.methodWithNullableGenEnumParam(false, Option(testGenEnum))
    nullableTCK.methodWithNullableGenEnumHandler(true, b => assert(b.contains(testGenEnum)))
    nullableTCK.methodWithNullableGenEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableGenEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.contains(testGenEnum))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableGenEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableGenEnumReturn(true)
    nullableTCK.methodWithNullableGenEnumReturn(false)
  }

  "testNullableTypeVariable" should "work" in {
    nullableTCK.methodWithNullableTypeVariableParam(false, "whatever")
    nullableTCK.methodWithNullableTypeVariableParam(true, null)
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandler[String](true, "wibble", a => {
      w {
        assert(a == "wibble")
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandler[String](true, null, b => {
      w {
        assert(b == null)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandlerAsyncResultFuture[String](true, "sausages").foreach(c => {
      w {
        assert(c == "sausages")
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandlerAsyncResultFuture[String](true, null).foreach(d => {
      w {
        assert(d == null)
      }
      w.dismiss()
    }))
    assert("fizz1" == nullableTCK.methodWithNullableTypeVariableReturn[String](true, "fizz1").value)
    assert(nullableTCK.methodWithNullableTypeVariableReturn(false, "fizz2").isEmpty)
  }

  "testNullableObjectParam" should "work" in {
    nullableTCK.methodWithNullableObjectParam(true, null)
    nullableTCK.methodWithNullableObjectParam(false, "object_param")
  }








  "testNullableListByte" should "work" ignore {
    val testListByte = mutable.Buffer(12.toByte, 24.toByte, (-12).toByte)
    nullableTCK.methodWithNullableListByteParam(true, None)
    nullableTCK.methodWithNullableListByteParam(false, Option(testListByte))
    nullableTCK.methodWithNullableListByteHandler(true, b => assert(b.contains(testListByte)))
    nullableTCK.methodWithNullableListByteHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListByteHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListByte.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListByteHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListByteReturn(true)
    nullableTCK.methodWithNullableListByteReturn(false)
  }

  "testNullableListShort" should "work" ignore {
    val testListShort = mutable.Buffer(520.toShort, 1040.toShort, (-520).toShort)
    nullableTCK.methodWithNullableListShortParam(true, None)
    nullableTCK.methodWithNullableListShortParam(false, Option(testListShort))
    nullableTCK.methodWithNullableListShortHandler(true, b => assert(b.contains(testListShort)))
    nullableTCK.methodWithNullableListShortHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListShortHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListShort.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListShortHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListShortReturn(true)
    nullableTCK.methodWithNullableListShortReturn(false)
  }

  "testNullableListInteger" should "work" ignore {
    val testListInteger = mutable.Buffer(12345, 54321, -12345)
    nullableTCK.methodWithNullableListIntegerParam(true, None)
    nullableTCK.methodWithNullableListIntegerParam(false, Option(testListInteger))
    nullableTCK.methodWithNullableListIntegerHandler(true, b => assert(b.contains(testListInteger)))
    nullableTCK.methodWithNullableListIntegerHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListIntegerHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListInteger.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListIntegerHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListIntegerReturn(true)
    nullableTCK.methodWithNullableListIntegerReturn(false)
  }

  "testNullableListLong" should "work" ignore {
    val testListLong = mutable.Buffer(123456789l, 987654321l, -123456789l)
    nullableTCK.methodWithNullableListLongParam(true, None)
    nullableTCK.methodWithNullableListLongParam(false, Option(testListLong))
    nullableTCK.methodWithNullableListLongHandler(true, b => assert(b.contains(testListLong)))
    nullableTCK.methodWithNullableListLongHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListLongHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListLong.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListLongHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListLongReturn(true)
    nullableTCK.methodWithNullableListLongReturn(false)
  }

  "testNullableListFloat" should "work" ignore {
    val testListFloat = mutable.Buffer(1.1f, 2.2f, 3.3f)
    nullableTCK.methodWithNullableListFloatParam(true, None)
    nullableTCK.methodWithNullableListFloatParam(false, Option(testListFloat))
    nullableTCK.methodWithNullableListFloatHandler(true, b => assert(b.contains(testListFloat)))
    nullableTCK.methodWithNullableListFloatHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListFloatHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListFloat.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListFloatHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListFloatReturn(true)
    nullableTCK.methodWithNullableListFloatReturn(false)
  }

  "testNullableListDouble" should "work" ignore {
    val testListDouble = mutable.Buffer(1.11, 2.22, 3.33)
    nullableTCK.methodWithNullableListDoubleParam(true, None)
    nullableTCK.methodWithNullableListDoubleParam(false, Option(testListDouble))
    nullableTCK.methodWithNullableListDoubleHandler(true, b => assert(b.contains(testListDouble)))
    nullableTCK.methodWithNullableListDoubleHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListDoubleHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListDouble.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListDoubleHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListDoubleReturn(true)
    nullableTCK.methodWithNullableListDoubleReturn(false)
  }

  "testNullableListBoolean" should "work" ignore {
    val testListBoolean = mutable.Buffer(true, false, true)
    nullableTCK.methodWithNullableListBooleanParam(true, None)
    nullableTCK.methodWithNullableListBooleanParam(false, Option(testListBoolean))
    nullableTCK.methodWithNullableListBooleanHandler(true, b => assert(b.contains(testListBoolean)))
    nullableTCK.methodWithNullableListBooleanHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListBooleanHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListBoolean.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListBooleanHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListBooleanReturn(true)
    nullableTCK.methodWithNullableListBooleanReturn(false)
  }

  "testNullableListString" should "work" ignore {
    val testListString = mutable.Buffer("first", "second", "third")
    nullableTCK.methodWithNullableListStringParam(true, None)
    nullableTCK.methodWithNullableListStringParam(false, Option(testListString))
    nullableTCK.methodWithNullableListStringHandler(true, b => assert(b.contains(testListString)))
    nullableTCK.methodWithNullableListStringHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListStringHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListString.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListStringHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListStringReturn(true)
    nullableTCK.methodWithNullableListStringReturn(false)
  }

  "testNullableListChar" should "work" ignore {
    val testListChar = mutable.Buffer('x', 'y', 'z')
    nullableTCK.methodWithNullableListCharParam(true, None)
    nullableTCK.methodWithNullableListCharParam(false, Option(testListChar))
    nullableTCK.methodWithNullableListCharHandler(true, b => assert(b.contains(testListChar)))
    nullableTCK.methodWithNullableListCharHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListCharHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListChar.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListCharHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListCharReturn(true)
    nullableTCK.methodWithNullableListCharReturn(false)
  }

  "testNullableListJsonObject" should "work" ignore {
    val testListJsonObject = mutable.Buffer(Json.obj(("foo", "bar")), Json.obj(("juu", 3)))
    nullableTCK.methodWithNullableListJsonObjectParam(true, None)
    nullableTCK.methodWithNullableListJsonObjectParam(false, Option(testListJsonObject))
    nullableTCK.methodWithNullableListJsonObjectHandler(true, b => assert(b.contains(testListJsonObject)))
    nullableTCK.methodWithNullableListJsonObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListJsonObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListJsonObject.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListJsonObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListJsonObjectReturn(true)
    nullableTCK.methodWithNullableListJsonObjectReturn(false)
  }

  "testNullableListJsonArray" should "work" ignore {
    val testListJsonArray = mutable.Buffer(Json.arr("foo", "bar"), Json.arr("juu"))
    nullableTCK.methodWithNullableListJsonArrayParam(true, None)
    nullableTCK.methodWithNullableListJsonArrayParam(false, Option(testListJsonArray))
    nullableTCK.methodWithNullableListJsonArrayHandler(true, b => assert(b.contains(testListJsonArray)))
    nullableTCK.methodWithNullableListJsonArrayHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListJsonArrayHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListJsonArray.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListJsonArrayHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListJsonArrayReturn(true)
    nullableTCK.methodWithNullableListJsonArrayReturn(false)
  }

  "testNullableListApi" should "work" ignore {
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testListApi = mutable.Buffer(RefedInterface1(iface))
    nullableTCK.methodWithNullableListApiParam(true, None)
    nullableTCK.methodWithNullableListApiParam(false, Option(testListApi))
    nullableTCK.methodWithNullableListApiHandler(true, b => assert(b.get.forall(a => a.asJava == iface)))
    nullableTCK.methodWithNullableListApiHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListApiHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.get.forall(a => a.asJava == iface))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListApiHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListApiReturn(true)
    nullableTCK.methodWithNullableListApiReturn(false)
  }

  "testNullableListDataObject" should "work" ignore {
    val json = Json.obj(("foo", "foo_value"), ("bar", 12345), ("wibble", 5.6))
    val testListDataObject = mutable.Buffer(TestDataObject.fromJson(json))
    nullableTCK.methodWithNullableListDataObjectParam(true, None)
    nullableTCK.methodWithNullableListDataObjectParam(false, Option(testListDataObject))
    nullableTCK.methodWithNullableListDataObjectHandler(true, b => assert(b.get.forall(a => a.asJava.toJson == json)))
    nullableTCK.methodWithNullableListDataObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListDataObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListDataObject.forall(a => a.asJava.toJson == Json.obj(("foo", "foo_value"), ("bar", 12345), ("wibble", 5.6))))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListDataObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListDataObjectReturn(true)
    nullableTCK.methodWithNullableListDataObjectReturn(false)
  }

  "testNullableListEnum" should "work" ignore {
    val testListEnum = mutable.Buffer(TestEnum.TIM, TestEnum.JULIEN)
    nullableTCK.methodWithNullableListEnumParam(true, None)
    nullableTCK.methodWithNullableListEnumParam(false, Option(testListEnum))
    nullableTCK.methodWithNullableListEnumHandler(true, b => assert(b.contains(testListEnum)))
    nullableTCK.methodWithNullableListEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListEnum.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListEnumReturn(true)
    nullableTCK.methodWithNullableListEnumReturn(false)
  }

  "testNullableListGenEnum" should "work" ignore {
    val testListGenEnum = mutable.Buffer(TestGenEnum.BOB, TestGenEnum.LELAND)
    nullableTCK.methodWithNullableListGenEnumParam(true, None)
    nullableTCK.methodWithNullableListGenEnumParam(false, Option(testListGenEnum))
    nullableTCK.methodWithNullableListGenEnumHandler(true, b => assert(b.contains(testListGenEnum)))
    nullableTCK.methodWithNullableListGenEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableListGenEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testListGenEnum.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableListGenEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableListGenEnumReturn(true)
    nullableTCK.methodWithNullableListGenEnumReturn(false)
  }











  "testNullableSetByte" should "work" ignore {
    val testSetByte = mutable.Set(12.toByte, 24.toByte, (-12).toByte)
    nullableTCK.methodWithNullableSetByteParam(true, None)
    nullableTCK.methodWithNullableSetByteParam(false, Option(testSetByte))
    nullableTCK.methodWithNullableSetByteHandler(true, b => assert(b.contains(testSetByte)))
    nullableTCK.methodWithNullableSetByteHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetByteHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetByte.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetByteHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetByteReturn(true)
    nullableTCK.methodWithNullableSetByteReturn(false)
  }

  "testNullableSetShort" should "work" ignore {
    val testSetShort = mutable.Set(520.toShort, 1040.toShort, (-520).toShort)
    nullableTCK.methodWithNullableSetShortParam(true, None)
    nullableTCK.methodWithNullableSetShortParam(false, Option(testSetShort))
    nullableTCK.methodWithNullableSetShortHandler(true, b => assert(b.contains(testSetShort)))
    nullableTCK.methodWithNullableSetShortHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetShortHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetShort.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetShortHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetShortReturn(true)
    nullableTCK.methodWithNullableSetShortReturn(false)
  }

  "testNullableSetInteger" should "work" ignore {
    val testSetInteger = mutable.Set(12345, 54321, -12345)
    nullableTCK.methodWithNullableSetIntegerParam(true, None)
    nullableTCK.methodWithNullableSetIntegerParam(false, Option(testSetInteger))
    nullableTCK.methodWithNullableSetIntegerHandler(true, b => assert(b.contains(testSetInteger)))
    nullableTCK.methodWithNullableSetIntegerHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetIntegerHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetInteger.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetIntegerHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetIntegerReturn(true)
    nullableTCK.methodWithNullableSetIntegerReturn(false)
  }

  "testNullableSetLong" should "work" ignore {
    val testSetLong = mutable.Set(123456789l, 987654321l, -123456789l)
    nullableTCK.methodWithNullableSetLongParam(true, None)
    nullableTCK.methodWithNullableSetLongParam(false, Option(testSetLong))
    nullableTCK.methodWithNullableSetLongHandler(true, b => assert(b.contains(testSetLong)))
    nullableTCK.methodWithNullableSetLongHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetLongHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetLong.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetLongHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetLongReturn(true)
    nullableTCK.methodWithNullableSetLongReturn(false)
  }

  "testNullableSetFloat" should "work" ignore {
    val testSetFloat = mutable.Set(1.1f, 2.2f, 3.3f)
    nullableTCK.methodWithNullableSetFloatParam(true, None)
    nullableTCK.methodWithNullableSetFloatParam(false, Option(testSetFloat))
    nullableTCK.methodWithNullableSetFloatHandler(true, b => assert(b.contains(testSetFloat)))
    nullableTCK.methodWithNullableSetFloatHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetFloatHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetFloat.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetFloatHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetFloatReturn(true)
    nullableTCK.methodWithNullableSetFloatReturn(false)
  }

  "testNullableSetDouble" should "work" ignore {
    val testSetDouble = mutable.Set(1.11, 2.22, 3.33)
    nullableTCK.methodWithNullableSetDoubleParam(true, None)
    nullableTCK.methodWithNullableSetDoubleParam(false, Option(testSetDouble))
    nullableTCK.methodWithNullableSetDoubleHandler(true, b => assert(b.contains(testSetDouble)))
    nullableTCK.methodWithNullableSetDoubleHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetDoubleHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetDouble.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetDoubleHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetDoubleReturn(true)
    nullableTCK.methodWithNullableSetDoubleReturn(false)
  }

  "testNullableSetBoolean" should "work" ignore {
    val testSetBoolean = mutable.Set(true, false, true)
    nullableTCK.methodWithNullableSetBooleanParam(true, None)
    nullableTCK.methodWithNullableSetBooleanParam(false, Option(testSetBoolean))
    nullableTCK.methodWithNullableSetBooleanHandler(true, b => assert(b.contains(testSetBoolean)))
    nullableTCK.methodWithNullableSetBooleanHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetBooleanHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetBoolean.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetBooleanHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetBooleanReturn(true)
    nullableTCK.methodWithNullableSetBooleanReturn(false)
  }

  "testNullableSetString" should "work" ignore {
    val testSetString = mutable.Set("first", "second", "third")
    nullableTCK.methodWithNullableSetStringParam(true, None)
    nullableTCK.methodWithNullableSetStringParam(false, Option(testSetString))
    nullableTCK.methodWithNullableSetStringHandler(true, b => assert(b.contains(testSetString)))
    nullableTCK.methodWithNullableSetStringHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetStringHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetString.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetStringHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetStringReturn(true)
    nullableTCK.methodWithNullableSetStringReturn(false)
  }

  "testNullableSetChar" should "work" ignore {
    val testSetChar = mutable.Set('x', 'y', 'z')
    nullableTCK.methodWithNullableSetCharParam(true, None)
    nullableTCK.methodWithNullableSetCharParam(false, Option(testSetChar))
    nullableTCK.methodWithNullableSetCharHandler(true, b => assert(b.contains(testSetChar)))
    nullableTCK.methodWithNullableSetCharHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetCharHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetChar.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetCharHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetCharReturn(true)
    nullableTCK.methodWithNullableSetCharReturn(false)
  }

  "testNullableSetJsonObject" should "work" ignore {
    val testSetJsonObject = mutable.Set(Json.obj(("foo", "bar")), Json.obj(("juu", 3)))
    nullableTCK.methodWithNullableSetJsonObjectParam(true, None)
    nullableTCK.methodWithNullableSetJsonObjectParam(false, Option(testSetJsonObject))
    nullableTCK.methodWithNullableSetJsonObjectHandler(true, b => assert(b.contains(testSetJsonObject)))
    nullableTCK.methodWithNullableSetJsonObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetJsonObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetJsonObject.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetJsonObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetJsonObjectReturn(true)
    nullableTCK.methodWithNullableSetJsonObjectReturn(false)
  }

  "testNullableSetJsonArray" should "work" ignore {
    val testSetJsonArray = mutable.Set(Json.arr("foo", "bar"), Json.arr("juu"))
    nullableTCK.methodWithNullableSetJsonArrayParam(true, None)
    nullableTCK.methodWithNullableSetJsonArrayParam(false, Option(testSetJsonArray))
    nullableTCK.methodWithNullableSetJsonArrayHandler(true, b => assert(b.contains(testSetJsonArray)))
    nullableTCK.methodWithNullableSetJsonArrayHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetJsonArrayHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetJsonArray.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetJsonArrayHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetJsonArrayReturn(true)
    nullableTCK.methodWithNullableSetJsonArrayReturn(false)
  }

  "testNullableSetApi" should "work" ignore {
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testSetApi = mutable.Set(RefedInterface1(iface))
    nullableTCK.methodWithNullableSetApiParam(true, None)
    nullableTCK.methodWithNullableSetApiParam(false, Option(testSetApi))
    nullableTCK.methodWithNullableSetApiHandler(true, b => assert(b.get.forall(a => a.asJava == iface)))
    nullableTCK.methodWithNullableSetApiHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetApiHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(b.get.forall(a => a.asJava == iface))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetApiHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetApiReturn(true)
    nullableTCK.methodWithNullableSetApiReturn(false)
  }

  "testNullableSetDataObject" should "work" ignore {
    val json = Json.obj(("foo", "foo_value"), ("bar", 12345), ("wibble", 5.6))
    val testSetDataObject= mutable.Set(TestDataObject.fromJson(json))
    nullableTCK.methodWithNullableSetDataObjectParam(true, None)
    nullableTCK.methodWithNullableSetDataObjectParam(false, Option(testSetDataObject))
    nullableTCK.methodWithNullableSetDataObjectHandler(true, b => assert(b.get.forall(a => a.asJava.toJson == json)))
    nullableTCK.methodWithNullableSetDataObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetDataObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetDataObject.forall(a => a.asJava.toJson == Json.obj(("foo", "foo_value"), ("bar", 12345), ("wibble", 5.6))))
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetDataObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetDataObjectReturn(true)
    nullableTCK.methodWithNullableSetDataObjectReturn(false)
  }

  "testNullableSetEnum" should "work" ignore {
    val testSetEnum= mutable.Set(TestEnum.TIM, TestEnum.JULIEN)
    nullableTCK.methodWithNullableSetEnumParam(true, None)
    nullableTCK.methodWithNullableSetEnumParam(false, Option(testSetEnum))
    nullableTCK.methodWithNullableSetEnumHandler(true, b => assert(b.contains(testSetEnum)))
    nullableTCK.methodWithNullableSetEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetEnum.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetEnumReturn(true)
    nullableTCK.methodWithNullableSetEnumReturn(false)
  }

  "testNullableSetGenEnum" should "work" ignore {
    val testSetGenEnum= mutable.Set(TestGenEnum.BOB, TestGenEnum.LELAND)
    nullableTCK.methodWithNullableSetGenEnumParam(true, None)
    nullableTCK.methodWithNullableSetGenEnumParam(false, Option(testSetGenEnum))
    nullableTCK.methodWithNullableSetGenEnumHandler(true, b => assert(b.contains(testSetGenEnum)))
    nullableTCK.methodWithNullableSetGenEnumHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableSetGenEnumHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testSetGenEnum.diff(b.get).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableSetGenEnumHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableSetGenEnumReturn(true)
    nullableTCK.methodWithNullableSetGenEnumReturn(false)
  }














  "testNullableMapByte" should "work" ignore {
    val testMapByte = mutable.Map("1" -> 1.toByte, "2" -> 2.toByte, "3" -> 3.toByte)
    nullableTCK.methodWithNullableMapByteParam(true, None)
    nullableTCK.methodWithNullableMapByteParam(false, Option(testMapByte))
    nullableTCK.methodWithNullableMapByteHandler(true, b => assert(b.contains(testMapByte)))
    nullableTCK.methodWithNullableMapByteHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapByteHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapByte.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapByteHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapByteReturn(true)
    nullableTCK.methodWithNullableMapByteReturn(false)
  }

  "testNullableMapShort" should "work" ignore {
    val testMapShort = mutable.Map("1" -> 1.toShort, "2" -> 2.toShort, "3" -> 3.toShort)
    nullableTCK.methodWithNullableMapShortParam(true, None)
    nullableTCK.methodWithNullableMapShortParam(false, Option(testMapShort))
    nullableTCK.methodWithNullableMapShortHandler(true, b => assert(b.contains(testMapShort)))
    nullableTCK.methodWithNullableMapShortHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapShortHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapShort.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapShortHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapShortReturn(true)
    nullableTCK.methodWithNullableMapShortReturn(false)
  }

  "testNullableMapInteger" should "work" ignore {
    val testMapInteger = mutable.Map("1" -> 1, "2" -> 2, "3" -> 3)
    nullableTCK.methodWithNullableMapIntegerParam(true, None)
    nullableTCK.methodWithNullableMapIntegerParam(false, Option(testMapInteger))
    nullableTCK.methodWithNullableMapIntegerHandler(true, b => assert(b.contains(testMapInteger)))
    nullableTCK.methodWithNullableMapIntegerHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapIntegerHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapInteger.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapIntegerHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapIntegerReturn(true)
    nullableTCK.methodWithNullableMapIntegerReturn(false)
  }

  "testNullableMapLong" should "work" ignore {
    val testMapLong = mutable.Map("1" -> 1l, "2" -> 2l, "3" -> 3l)
    nullableTCK.methodWithNullableMapLongParam(true, None)
    nullableTCK.methodWithNullableMapLongParam(false, Option(testMapLong))
    nullableTCK.methodWithNullableMapLongHandler(true, b => assert(b.contains(testMapLong)))
    nullableTCK.methodWithNullableMapLongHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapLongHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapLong.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapLongHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapLongReturn(true)
    nullableTCK.methodWithNullableMapLongReturn(false)
  }

  "testNullableMapFloat" should "work" ignore {
    val testMapFloat = mutable.Map("1" -> 1.1f, "2" -> 2.2f, "3" -> 3.3f)
    nullableTCK.methodWithNullableMapFloatParam(true, None)
    nullableTCK.methodWithNullableMapFloatParam(false, Option(testMapFloat))
    nullableTCK.methodWithNullableMapFloatHandler(true, b => assert(b.contains(testMapFloat)))
    nullableTCK.methodWithNullableMapFloatHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapFloatHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapFloat.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapFloatHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapFloatReturn(true)
    nullableTCK.methodWithNullableMapFloatReturn(false)
  }

  "testNullableMapDouble" should "work" ignore {
    val testMapDouble = mutable.Map("1" -> 1.11, "2" -> 2.22, "3" -> 3.33)
    nullableTCK.methodWithNullableMapDoubleParam(true, None)
    nullableTCK.methodWithNullableMapDoubleParam(false, Option(testMapDouble))
    nullableTCK.methodWithNullableMapDoubleHandler(true, b => assert(b.contains(testMapDouble)))
    nullableTCK.methodWithNullableMapDoubleHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapDoubleHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapDouble.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapDoubleHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapDoubleReturn(true)
    nullableTCK.methodWithNullableMapDoubleReturn(false)
  }

  "testNullableMapBoolean" should "work" ignore {
    val testMapBoolean = mutable.Map("1" -> true, "2" -> false, "3" -> true)
    nullableTCK.methodWithNullableMapBooleanParam(true, None)
    nullableTCK.methodWithNullableMapBooleanParam(false, Option(testMapBoolean))
    nullableTCK.methodWithNullableMapBooleanHandler(true, b => assert(b.contains(testMapBoolean)))
    nullableTCK.methodWithNullableMapBooleanHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapBooleanHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapBoolean.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapBooleanHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapBooleanReturn(true)
    nullableTCK.methodWithNullableMapBooleanReturn(false)
  }

  "testNullableMapString" should "work" ignore {
    val testMapString = mutable.Map("1" -> "first", "2" -> "second", "3" -> "third")
    nullableTCK.methodWithNullableMapStringParam(true, None)
    nullableTCK.methodWithNullableMapStringParam(false, Option(testMapString))
    nullableTCK.methodWithNullableMapStringHandler(true, b => assert(b.contains(testMapString)))
    nullableTCK.methodWithNullableMapStringHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapStringHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapString.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapStringHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapStringReturn(true)
    nullableTCK.methodWithNullableMapStringReturn(false)
  }

  "testNullableMapChar" should "work" ignore {
    val testMapChar = mutable.Map("1" -> 'x', "2" -> 'y', "3" -> 'z')
    nullableTCK.methodWithNullableMapCharParam(true, None)
    nullableTCK.methodWithNullableMapCharParam(false, Option(testMapChar))
    nullableTCK.methodWithNullableMapCharHandler(true, b => assert(b.contains(testMapChar)))
    nullableTCK.methodWithNullableMapCharHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapCharHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapChar.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapCharHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapCharReturn(true)
    nullableTCK.methodWithNullableMapCharReturn(false)
  }

  "testNullableMapJsonObject" should "work" ignore {
    val testMapJsonObject = mutable.Map("1" -> Json.obj(("foo", "bar")), "2" -> Json.obj(("juu", 3)))
    nullableTCK.methodWithNullableMapJsonObjectParam(true, None)
    nullableTCK.methodWithNullableMapJsonObjectParam(false, Option(testMapJsonObject))
    nullableTCK.methodWithNullableMapJsonObjectHandler(true, b => assert(b.contains(testMapJsonObject)))
    nullableTCK.methodWithNullableMapJsonObjectHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapJsonObjectHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapJsonObject.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapJsonObjectHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapJsonObjectReturn(true)
    nullableTCK.methodWithNullableMapJsonObjectReturn(false)
  }

  "testNullableMapJsonArray" should "work" ignore {
    val testMapJsonArray: mutable.Map[String, JsonArray] = mutable.Map("2" -> Json.arr("juu"), "1" -> Json.arr("foo", "bar"))
    nullableTCK.methodWithNullableMapJsonArrayParam(true, None)
    nullableTCK.methodWithNullableMapJsonArrayParam(false, Option(testMapJsonArray))
    nullableTCK.methodWithNullableMapJsonArrayHandler(true, b => assert(testMapJsonArray.toSet.diff(b.get.toSet).isEmpty))
    nullableTCK.methodWithNullableMapJsonArrayHandler(false, b => assert(b.isEmpty))
    exec1(w => nullableTCK.methodWithNullableMapJsonArrayHandlerAsyncResultFuture(true).foreach(b => {
      w {
        assert(testMapJsonArray.toSet.diff(b.get.toSet).isEmpty)
      }
      w.dismiss()
    }))
    exec1(w => nullableTCK.methodWithNullableMapJsonArrayHandlerAsyncResultFuture(false).foreach(b => {
      w {
        assert(b.isEmpty)
      }
      w.dismiss()
    }))
    nullableTCK.methodWithNullableMapJsonArrayReturn(true)
    nullableTCK.methodWithNullableMapJsonArrayReturn(false)
  }

  "testNullableMapApi" should "work" in {
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testMapApi = mutable.Map("1" -> RefedInterface1(iface))
    nullableTCK.methodWithNullableMapApiParam(true, None)
    nullableTCK.methodWithNullableMapApiParam(false, Option(testMapApi))
  }







  //There is no meaningful way to implement these in Scala as primitve nulls aren't possible
  //  shared test void testListNullableByte() => testListNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithListNullableByteParam, nullableTCK.methodWithListNullableByteHandler, nullableTCK.methodWithListNullableByteHandlerAsyncResult, nullableTCK.methodWithListNullableByteReturn)
  //  shared test void testListNullableShort() => testListNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithListNullableShortParam, nullableTCK.methodWithListNullableShortHandler, nullableTCK.methodWithListNullableShortHandlerAsyncResult, nullableTCK.methodWithListNullableShortReturn)
  //  shared test void testListNullableInteger() => testListNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithListNullableIntegerParam, nullableTCK.methodWithListNullableIntegerHandler, nullableTCK.methodWithListNullableIntegerHandlerAsyncResult, nullableTCK.methodWithListNullableIntegerReturn)
  //  shared test void testListNullableLong() => testListNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithListNullableLongParam, nullableTCK.methodWithListNullableLongHandler, nullableTCK.methodWithListNullableLongHandlerAsyncResult, nullableTCK.methodWithListNullableLongReturn)
  //  shared test void testListNullableFloat() => testListNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithListNullableFloatParam, nullableTCK.methodWithListNullableFloatHandler, nullableTCK.methodWithListNullableFloatHandlerAsyncResult, nullableTCK.methodWithListNullableFloatReturn, assertFloatEquals)
  //  shared test void testListNullableDouble() => testListNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithListNullableDoubleParam, nullableTCK.methodWithListNullableDoubleHandler, nullableTCK.methodWithListNullableDoubleHandlerAsyncResult, nullableTCK.methodWithListNullableDoubleReturn, assertFloatEquals)
  //  shared test void testListNullableBoolean() => testListNullable(ArrayList { true,null,false }, nullableTCK.methodWithListNullableBooleanParam, nullableTCK.methodWithListNullableBooleanHandler, nullableTCK.methodWithListNullableBooleanHandlerAsyncResult, nullableTCK.methodWithListNullableBooleanReturn)
  //  shared test void testListNullableChar() => testListNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithListNullableCharParam, nullableTCK.methodWithListNullableCharHandler, nullableTCK.methodWithListNullableCharHandlerAsyncResult, nullableTCK.methodWithListNullableCharReturn)


  "testListNullableString" should "work" in {
    val testListString: mutable.Buffer[Option[String]] = mutable.Buffer(Some("first"), None, Some("third"))
    nullableTCK.methodWithListNullableStringParam(testListString)
    nullableTCK.methodWithListNullableStringHandler(b => assert(testListString.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableStringHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListString.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testListString == nullableTCK.methodWithListNullableStringReturn())
  }

  "testListNullableJsonObject" should "work" in {
    val testListJsonObject: mutable.Buffer[Option[JsonObject]] = mutable.Buffer(Some(Json.obj(("foo", "bar"))), None, Some(Json.obj(("juu", 3))))
    nullableTCK.methodWithListNullableJsonObjectParam(testListJsonObject)
    nullableTCK.methodWithListNullableJsonObjectHandler(b => assert(testListJsonObject.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListJsonObject.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testListJsonObject == nullableTCK.methodWithListNullableJsonObjectReturn())
  }

  "testListNullableJsonArray" should "work" in {
    val testListJsonArray: mutable.Buffer[Option[JsonArray]] = mutable.Buffer(Some(Json.arr("foo", "bar")), None, Some(Json.arr("juu")))
    nullableTCK.methodWithListNullableJsonArrayParam(testListJsonArray)
    nullableTCK.methodWithListNullableJsonArrayHandler(b => assert(testListJsonArray.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListJsonArray.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testListJsonArray == nullableTCK.methodWithListNullableJsonArrayReturn())
  }

  "testListNullableApi" should "work" ignore {
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testListApi: mutable.Buffer[Option[RefedInterface1]] = mutable.Buffer(Some(RefedInterface1(iface1)), None, Some(RefedInterface1(iface2)))
    nullableTCK.methodWithListNullableApiParam(testListApi)
    nullableTCK.methodWithListNullableApiHandler(b => assert(testListApi.map(x => refedIfaceToJavaOrNull(x.get)) == b.map(x => refedIfaceToJavaOrNull(x.get))))
    exec1(w => nullableTCK.methodWithListNullableApiHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListApi.map(x => refedIfaceToJavaOrNull(x.get)).diff(b.map(a => refedIfaceToJavaOrNull(a.get))).isEmpty)
      }
      w.dismiss()
    }))
    assert(testListApi.map(x => refedIfaceToJavaOrNull(x.get)) == nullableTCK.methodWithListNullableApiReturn().map(x => refedIfaceToJavaOrNull(x.get)))
  }

  "testListNullableDataObject" should "work" ignore {
    val json1 = Json.obj(("foo", "first"), ("bar", 1), ("wibble", 1.1))
    val json2 = Json.obj(("foo", "third"), ("bar", 3), ("wibble", 3.3))
    val testListDataObject: mutable.Buffer[Option[TestDataObject]] = mutable.Buffer(Some(TestDataObject.fromJson(json1)), None, Some(TestDataObject.fromJson(json2)))
    nullableTCK.methodWithListNullableDataObjectParam(testListDataObject)
    nullableTCK.methodWithListNullableDataObjectHandler(b => assert(testListDataObject.map(x => dataObjectToJsonOrNull(x.get)) == b.map(x => dataObjectToJsonOrNull(x.get))))
    exec1(w => nullableTCK.methodWithListNullableDataObjectHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListDataObject.map(x => dataObjectToJsonOrNull(x.get)) == b.map(x => dataObjectToJsonOrNull(x.get)))
      }
      w.dismiss()
    }))
    assert(testListDataObject.map(x => dataObjectToJsonOrNull(x.get)) == nullableTCK.methodWithListNullableDataObjectReturn().map(x => dataObjectToJsonOrNull(x.get)))
  }

  "testListNullableGenEnum" should "work" in {
    val testListGenEnum: mutable.Buffer[Option[TestGenEnum]] = mutable.Buffer(Some(TestGenEnum.BOB), None, Some(TestGenEnum.LELAND))
    nullableTCK.methodWithListNullableGenEnumParam(testListGenEnum)
    nullableTCK.methodWithListNullableGenEnumHandler(b => assert(testListGenEnum.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableGenEnumHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testListGenEnum.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testListGenEnum == nullableTCK.methodWithListNullableGenEnumReturn())
  }

  //There is no meaningful way to implement these in Scala as primitve nulls aren't possible
  //  shared test void testSetNullableByte() => testSetNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithSetNullableByteParam, nullableTCK.methodWithSetNullableByteHandler, nullableTCK.methodWithSetNullableByteHandlerAsyncResult, nullableTCK.methodWithSetNullableByteReturn)
  //  shared test void testSetNullableShort() => testSetNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithSetNullableShortParam, nullableTCK.methodWithSetNullableShortHandler, nullableTCK.methodWithSetNullableShortHandlerAsyncResult, nullableTCK.methodWithSetNullableShortReturn)
  //  shared test void testSetNullableInteger() => testSetNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithSetNullableIntegerParam, nullableTCK.methodWithSetNullableIntegerHandler, nullableTCK.methodWithSetNullableIntegerHandlerAsyncResult, nullableTCK.methodWithSetNullableIntegerReturn)
  //  shared test void testSetNullableLong() => testSetNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithSetNullableLongParam, nullableTCK.methodWithSetNullableLongHandler, nullableTCK.methodWithSetNullableLongHandlerAsyncResult, nullableTCK.methodWithSetNullableLongReturn)
  //  shared test void testSetNullableFloat() => testSetNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithSetNullableFloatParam, nullableTCK.methodWithSetNullableFloatHandler, nullableTCK.methodWithSetNullableFloatHandlerAsyncResult, nullableTCK.methodWithSetNullableFloatReturn, assertFloatEquals)
  //  shared test void testSetNullableDouble() => testSetNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithSetNullableDoubleParam, nullableTCK.methodWithSetNullableDoubleHandler, nullableTCK.methodWithSetNullableDoubleHandlerAsyncResult, nullableTCK.methodWithSetNullableDoubleReturn, assertFloatEquals)
  //  shared test void testSetNullableBoolean() => testSetNullable(ArrayList { true,null,false }, nullableTCK.methodWithSetNullableBooleanParam, nullableTCK.methodWithSetNullableBooleanHandler, nullableTCK.methodWithSetNullableBooleanHandlerAsyncResult, nullableTCK.methodWithSetNullableBooleanReturn)
  //  shared test void testSetNullableChar() => testSetNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithSetNullableCharParam, nullableTCK.methodWithSetNullableCharHandler, nullableTCK.methodWithSetNullableCharHandlerAsyncResult, nullableTCK.methodWithSetNullableCharReturn)

  "testSetNullableString" should "work" in {
    val testSetString: mutable.Set[Option[String]]= mutable.Set(Some("first"), None, Some("third"))
    nullableTCK.methodWithSetNullableStringParam(testSetString)
    nullableTCK.methodWithSetNullableStringHandler(b => assert(testSetString.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableStringHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testSetString.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testSetString == nullableTCK.methodWithSetNullableStringReturn())
  }

  "testSetNullableJsonObject" should "work" in {
    val testSetJsonObject: mutable.Set[Option[JsonObject]]= mutable.Set(Some(Json.obj(("foo", "bar"))), None, Some(Json.obj(("juu", 3))))
    nullableTCK.methodWithSetNullableJsonObjectParam(testSetJsonObject)
    nullableTCK.methodWithSetNullableJsonObjectHandler(b => assert(testSetJsonObject.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testSetJsonObject.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testSetJsonObject == nullableTCK.methodWithSetNullableJsonObjectReturn())
  }

  "testSetNullableJsonArray" should "work" in {
    val testSetJsonArray: mutable.Set[Option[JsonArray]]= mutable.Set(Some(Json.arr("foo", "bar")), None, Some(Json.arr("juu")))
    nullableTCK.methodWithSetNullableJsonArrayParam(testSetJsonArray)
    nullableTCK.methodWithSetNullableJsonArrayHandler(b => assert(testSetJsonArray.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testSetJsonArray.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testSetJsonArray == nullableTCK.methodWithSetNullableJsonArrayReturn())
  }

  "testSetNullableApi" should "work" in {
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testSetApi: mutable.Set[Option[RefedInterface1]]= mutable.Set(Some(RefedInterface1(iface1)), None, Some(RefedInterface1(iface2)))
    val setForComparison: mutable.Set[Option[JRefedInterface1]]= mutable.Set(Some(iface1), None, Some(iface2))
    //TODO: RefedInterface1Impl needs a nullsafe equals method!
    nullableTCK.methodWithSetNullableApiParam(testSetApi)
    nullableTCK.methodWithSetNullableApiHandler(returnedSet => returnedSet.map(maybeRefedInterface => maybeRefedInterface.flatMap(refedInterface => Some(refedInterface.asJava.asInstanceOf[JRefedInterface1]))) == setForComparison)
    exec1(w => nullableTCK.methodWithSetNullableApiHandlerAsyncResultFuture().foreach(maybeRefedInterfaces => {
      w {
        assert(setForComparison == maybeRefedInterfaces.map(maybeRefedInterface => maybeRefedInterface.flatMap(refedInterface => Some(refedInterface.asJava.asInstanceOf[JRefedInterface1]))))
      }
      w.dismiss()
    }))
    assert(setForComparison == nullableTCK.methodWithSetNullableApiReturn().map(maybeRefedInterface => maybeRefedInterface.flatMap(refedInterface => Some(refedInterface.asJava.asInstanceOf[JRefedInterface1]))))
  }

  "testSetNullableDataObject" should "work" ignore {
    val json1 = Json.obj(("foo", "first"), ("bar", 1), ("wibble", 1.1))
    val json2 = Json.obj(("foo", "third"), ("bar", 3), ("wibble", 3.3))
    val testSetDataObject: mutable.Set[Option[TestDataObject]]= mutable.Set(Some(TestDataObject.fromJson(json1)), None, Some(TestDataObject.fromJson(json2)))
    nullableTCK.methodWithSetNullableDataObjectParam(testSetDataObject)
    nullableTCK.methodWithSetNullableDataObjectHandler(b => assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x.get)) == b.map(x => dataObjectToJsonOrNull(x.get))))
    exec1(w => nullableTCK.methodWithSetNullableDataObjectHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x.get)) == b.map(x => dataObjectToJsonOrNull(x.get)))
      }
      w.dismiss()
    }))
    assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x.get)) == nullableTCK.methodWithSetNullableDataObjectReturn().map(x => dataObjectToJsonOrNull(x.get)))
  }



  "testSetNullableGenEnum" should "work" in {
    val testSetGenEnum: mutable.Set[Option[TestGenEnum]]= mutable.Set(Some(TestGenEnum.BOB), None, Some(TestGenEnum.LELAND))
    nullableTCK.methodWithSetNullableGenEnumParam(testSetGenEnum)
    nullableTCK.methodWithSetNullableGenEnumHandler(b => assert(testSetGenEnum.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableGenEnumHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testSetGenEnum.diff(b).isEmpty)
      }
      w.dismiss()
    }))
    assert(testSetGenEnum == nullableTCK.methodWithSetNullableGenEnumReturn())
  }

  //There is no meaningful way to implement these in Scala as primitve nulls aren't possible
  //  shared test void testMapNullableByte() => testMapNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithMapNullableByteParam, nullableTCK.methodWithMapNullableByteHandler, nullableTCK.methodWithMapNullableByteHandlerAsyncResult, nullableTCK.methodWithMapNullableByteReturn)
  //  shared test void testMapNullableShort() => testMapNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithMapNullableShortParam, nullableTCK.methodWithMapNullableShortHandler, nullableTCK.methodWithMapNullableShortHandlerAsyncResult, nullableTCK.methodWithMapNullableShortReturn)
  //  shared test void testMapNullableInteger() => testMapNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithMapNullableIntegerParam, nullableTCK.methodWithMapNullableIntegerHandler, nullableTCK.methodWithMapNullableIntegerHandlerAsyncResult, nullableTCK.methodWithMapNullableIntegerReturn)
  //  shared test void testMapNullableLong() => testMapNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithMapNullableLongParam, nullableTCK.methodWithMapNullableLongHandler, nullableTCK.methodWithMapNullableLongHandlerAsyncResult, nullableTCK.methodWithMapNullableLongReturn)
  //  shared test void testMapNullableFloat() => testMapNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithMapNullableFloatParam, nullableTCK.methodWithMapNullableFloatHandler, nullableTCK.methodWithMapNullableFloatHandlerAsyncResult, nullableTCK.methodWithMapNullableFloatReturn, assertFloatEquals)
  //  shared test void testMapNullableDouble() => testMapNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithMapNullableDoubleParam, nullableTCK.methodWithMapNullableDoubleHandler, nullableTCK.methodWithMapNullableDoubleHandlerAsyncResult, nullableTCK.methodWithMapNullableDoubleReturn, assertFloatEquals)
  //  shared test void testMapNullableBoolean() => testMapNullable(ArrayList { true, null, false }, nullableTCK.methodWithMapNullableBooleanParam, nullableTCK.methodWithMapNullableBooleanHandler, nullableTCK.methodWithMapNullableBooleanHandlerAsyncResult, nullableTCK.methodWithMapNullableBooleanReturn)
  //  shared test void testMapNullableChar() => testMapNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithMapNullableCharParam, nullableTCK.methodWithMapNullableCharHandler, nullableTCK.methodWithMapNullableCharHandlerAsyncResult, nullableTCK.methodWithMapNullableCharReturn)

  "testMapNullableString" should "work" in {
    val testMapString: mutable.Map[String, Option[String]] = mutable.Map("1" -> Some("first"), "2" -> None, "3" -> Some("third"))
    nullableTCK.methodWithMapNullableStringParam(testMapString)
    nullableTCK.methodWithMapNullableStringHandler(b => assert(testMapString.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableStringHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testMapString.toSet.diff(b.toSet).isEmpty)
      }
      w.dismiss()
    }))
    assert(testMapString == nullableTCK.methodWithMapNullableStringReturn())
  }

  "testMapNullableJsonObject" should "work" in {
    val testMapJsonObject: mutable.Map[String, Option[JsonObject]] = mutable.Map("1" -> Some(Json.obj(("foo", "bar"))), "2" -> None, "3" -> Some(Json.obj(("juu", 3))))
    nullableTCK.methodWithMapNullableJsonObjectParam(testMapJsonObject)
    nullableTCK.methodWithMapNullableJsonObjectHandler(b => assert(testMapJsonObject.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testMapJsonObject.toSet.diff(b.toSet).isEmpty)
      }
      w.dismiss()
    }))
    assert(testMapJsonObject == nullableTCK.methodWithMapNullableJsonObjectReturn())
  }

  "testMapNullableJsonArray" should "work" in {
    val testMapJsonArray: mutable.Map[String, Option[JsonArray]] = mutable.Map("1" -> Some(Json.arr("foo", "bar")), "2" -> None, "3" -> Some(Json.arr("juu")))
    nullableTCK.methodWithMapNullableJsonArrayParam(testMapJsonArray)
    nullableTCK.methodWithMapNullableJsonArrayHandler(b => assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {
      w {
        assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty)
      }
      w.dismiss()
    }))
    assert(testMapJsonArray == nullableTCK.methodWithMapNullableJsonArrayReturn())
  }

  "testMapNullableApi" should "work" ignore {
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testMapApi: mutable.Map[String, Option[RefedInterface1]] = mutable.Map("1" -> Some(RefedInterface1(iface1)), "2" -> None, "3" -> Some(RefedInterface1(iface2)))
    nullableTCK.methodWithMapNullableApiParam(testMapApi)
  }

  "testNullableHandler" should "work" ignore {
    nullableTCK.methodWithNullableHandler(true, null)
    exec1(w => nullableTCK.methodWithNullableHandler(false, a => {
      w {
        assert("the_string_value" == a)
      }
      w.dismiss()
    }))
    //Test makes no sense as the handlers are created inside the method => vertx-lang-scala specific
    //exec1(w => nullableTCK.methodWithNullableHandlerAsyncResultFuture(true))
    exec1(w => nullableTCK.methodWithNullableHandlerAsyncResultFuture(false).foreach(a => {
      w {
        assert("the_string_value" == a)
      }
      w.dismiss()
    }))
  }

  def dataObjectToJsonOrNull(x: TestDataObject): JsonObject = {
    if (x != null) x.asJava.toJson else null
  }

  def refedIfaceToJavaOrNull(x: RefedInterface1): io.vertx.codegen.testmodel.RefedInterface1 = {
    if (x != null) x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1] else null
  }
}
