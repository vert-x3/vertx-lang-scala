package io.vertx.lang.scala.tck

import io.vertx.codegen.testmodel.{GenericsTCKImpl, TestEnum, TestGenEnum}
import io.vertx.lang.scala.json.Json
import io.vertx.scala.codegen.testmodel._
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

  val obj: GenericsTCKImpl = new GenericsTCKImpl

  "testMethodWithHandlerAsyncResultByteParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultByteParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 123)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultShortParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultShortParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 1234)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultIntegerParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultIntegerParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 123456)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultLongParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultLongParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 123456789)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultFloatParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultFloatParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 0.34f)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultDoubleParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultDoubleParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 0.314)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultBooleanParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultBooleanParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultCharacterParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultCharacterParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == 'F')
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultStringParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultStringParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == "zoumbawe")
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultJsonObjectParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultJsonObjectParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == Json.obj(("cheese", "stilton")))
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultJsonArrayParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultJsonArrayParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == Json.arr("cheese", "stilton"))
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultDataObjectParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultDataObjectParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue.getBar == 123456)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultEnumParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultEnumParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == TestEnum.WESTON)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultGenEnumParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenEnumParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue == TestGenEnum.LELAND)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultUserTypeParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultUserTypeParameterizedFuture().foreach(result => {
        w {
          assert(result.getValue.getString == "foo")
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultGenericNullableApiFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericNullableApiFuture(true).foreach(result => {
        w {
          assert(result.getValue.getString == "the_string_value")
        }
        w.dismiss()
      })
    )

    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericNullableApiFuture(false).foreach(result => {
        w {
          assert(result.getValue == null )
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultClassTypeParameterizedFuture" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultClassTypeParameterizedFuture[String](classOf[String]).foreach(result => {
        w {
          assert(result.getValue == "zoumbawe")
        }
        w.dismiss()
      })
    )
  }

}
