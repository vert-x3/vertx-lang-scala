/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License") you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.lang.scala.tck

import com.acme.scala.pkg.MyInterface
import io.vertx.codegen.testmodel._
import io.vertx.core.http.HttpServerOptions
import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.core.{Future, VertxException}
import io.vertx.lang.scala.ScalaAsyncResult
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json.arr
import io.vertx.scala.codegen.testmodel
import io.vertx.scala.codegen.testmodel.{ConcreteHandlerUserTypeExtension, Factory, RefedInterface1, TestDataObject, TestInterface}
import org.junit.ComparisonFailure
import org.junit.runner.RunWith
import org.scalatest.concurrent.Waiters.Waiter
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.ExecutionContext
import scala.language.postfixOps
import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ApiTest extends FlatSpec with Matchers {

  val obj = TestInterface(new TestInterfaceImpl())

  implicit val execCtx = new ExecutionContext {
    override def reportFailure(cause: Throwable): Unit = ???

    override def execute(runnable: Runnable): Unit = runnable.run()
  }

  "testMethodWithBasicParams" should "work" in {
    obj.methodWithBasicParams(123, 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar")
  }

  "testMethodWithBasicBoxedParams" should "work" in {
    obj.methodWithBasicBoxedParams(123, 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X')
  }

  "testMethodWithHandlerBasicTypes" should "work" in {
    obj.methodWithHandlerBasicTypes(
      b => assert(123 == b),
      s => assert(12345 == s),
      i => assert(1234567 == i),
      l => assert(1265615234l == l),
      f => assert(12.345f == f),
      d => assert(12.34566d == d),
      b => assert(b),
      c => assert('X' == c),
      s => assert("quux!" == s)
    )
  }

  "testMethodWithHandlerAsyncResultBasicTypes" should "work" in {
    exec(18)(w => {
      obj.methodWithHandlerAsyncResultByteFuture(false).foreach(b => {
        w {
          assert(123 == b)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultShortFuture(false).foreach(s => {
        w {
          assert(12345 == s)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultIntegerFuture(false).foreach(i => {
        w {
          assert(1234567 == i)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultLongFuture(false).foreach(l => {
        w {
          assert(1265615234l == l)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultFloatFuture(false).foreach(f => {
        w {
          assert(12.345f == f)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultDoubleFuture(false).foreach(d => {
        w {
          assert(12.34566d == d)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultBooleanFuture(false).foreach(b => {
        w {
          assert(true == b)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultCharacterFuture(false).foreach(c => {
        w {
          assert('X' == c)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultStringFuture(false).foreach(s => {
        w {
          assert("quux!" == s)
        }
        w.dismiss()
      })

      obj.methodWithHandlerAsyncResultByteFuture(true).onComplete {
        case Success(_) => {
          w {
            fail("Should have failed!")
          }
          w.dismiss()
        }
        case Failure(t) => {
          w {
            assert("foobar!" == t.getMessage)
          }
          w.dismiss()
        }
      }
      obj.methodWithHandlerAsyncResultShortFuture(true).onComplete {
        case Success(_) => {
          w {
            fail("Should have failed!")
          }
          w.dismiss()
        }
        case Failure(t) => {
          w {
            assert("foobar!" == t.getMessage)
          }
          w.dismiss()
        }
      }
      obj.methodWithHandlerAsyncResultIntegerFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultLongFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultFloatFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultDoubleFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultBooleanFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultCharacterFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
      obj.methodWithHandlerAsyncResultStringFuture(true).onComplete { case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
      }
    })
  }

  "testMethodWithUserTypes" should "work" in {
    val refed = RefedInterface1(new RefedInterface1Impl())
    refed.setString("aardvarks")
    obj.methodWithUserTypes(refed)
  }


  "testObjectParam" should "work" in {
    obj.methodWithObjectParam("null", null)
    obj.methodWithObjectParam("string", "wibble")
    obj.methodWithObjectParam("true", true.asInstanceOf[Object])
    obj.methodWithObjectParam("false", false.asInstanceOf[Object])
    obj.methodWithObjectParam("long", 123.toLong.asInstanceOf[Object])
    obj.methodWithObjectParam("double", 123.456.asInstanceOf[Object])
    obj.methodWithObjectParam("JsonObject", Json.obj(("foo", "hello"), ("bar", 123)))
    val hello = "hello"
    obj.methodWithObjectParam("JsonObject", Json.obj(("foo", hello), ("bar", 123)))
    val foo = "foo"
    obj.methodWithObjectParam("JsonArray", arr(foo, "bar", "wib"))
  }

  "testDataObjectParam" should "work" in {
    obj.methodWithDataObjectParam(testmodel.TestDataObject.fromJson(Json.obj().put("bar", 123).put("foo", "hello").put("wibble", 1.23)))
  }

  "testMethodWithHandlerDataObject" should "work" in {
    val dataObject = TestDataObject.fromJson(Json.obj().put("foo", "foo").put("bar", 123))

    exec1(w =>
      obj.methodWithHandlerDataObject(it => {
        w {
          assert(dataObject.getFoo == it.getFoo)
          assert(dataObject.getBar == it.getBar)
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithHandlerAsyncResultDataObject" should "work" in {
    val dataObject = TestDataObject.fromJson(Json.obj().put("foo", "foo").put("bar", 123))

    exec1(w => obj.methodWithHandlerAsyncResultDataObjectFuture(false).foreach(result => {
      w {
        assert(dataObject.getFoo == result.getFoo)
        assert(dataObject.getBar == result.getBar)
      }
      w.dismiss()
    }))
    exec1(w => obj.methodWithHandlerAsyncResultDataObjectFuture(true).onComplete {
      case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foobar!" == t.getMessage)
        }
        w.dismiss()
      }
    })
  }

  "testMethodWithHandlerStringReturn" should "work" in {
    val handler = obj.methodWithHandlerStringReturn("the-result")
    handler.handle("the-result")
    def failed = false
    intercept[ComparisonFailure](
      handler.handle("not-expected")
    )
  }

  "testMethodWithHandlerGenericReturn" should "work" in {
    obj.methodWithHandlerGenericReturn[String](res =>
      assert("the-result" == res)).handle("the-result")
    obj.methodWithHandlerGenericReturn[TestInterface](res =>
      assert(obj.asJava == res.asJava)).handle(obj)
  }

  "testMethodWithHandlerVertxGenReturn" should "work" in {
    val handler = obj.methodWithHandlerVertxGenReturn("wibble")
    handler.handle(RefedInterface1(new RefedInterface1Impl().setString("wibble")))
  }

  "testMethodWithHandlerAsyncResultStringReturn" should "work" in {
    val succeedingHandler = obj.methodWithHandlerAsyncResultStringReturn("the-result", false)
    succeedingHandler.handle(Future.succeededFuture("the-result"))
    intercept[ComparisonFailure](
      succeedingHandler.handle(Future.succeededFuture("not-expected"))
    )

    val failingHandler = obj.methodWithHandlerAsyncResultStringReturn("an-error", true)
    failingHandler.handle(Future.failedFuture("an-error"))
    intercept[ComparisonFailure](
      succeedingHandler.handle(Future.succeededFuture("whatever"))
    )
  }

  "testMethodWithHandlerAsyncResultGenericReturn" should "work" in {
    val w = new Waiter()
    def stringHandler = obj.methodWithHandlerAsyncResultGenericReturn[String](a => {
      w {
        assert(a.result() == "the-result")
      }
      w.dismiss()
    })
    stringHandler.handle(ScalaAsyncResult("the-result"))
    w.await()

    val w2 = new Waiter
    def objHandler = obj.methodWithHandlerAsyncResultGenericReturn[TestInterface](a => {
      w2 {
        assert(a.result().asJava == obj.asJava)
      }
      w2.dismiss()
    })
    objHandler.handle(ScalaAsyncResult(obj))
    w2.await()
  }

  "testMethodWithHandlerAsyncResultVertxGenReturn" should "work" in {
    var handler = obj.methodWithHandlerAsyncResultVertxGenReturn("wibble", false)
    handler.handle(Future.succeededFuture(RefedInterface1(new RefedInterface1Impl().setString("wibble"))))
    handler = obj.methodWithHandlerAsyncResultVertxGenReturn("oh-no", true)
    handler.handle(Future.failedFuture("oh-no"))
  }

  "testMethodWithHandlerUserTypes" should "work" in {
    obj.methodWithHandlerUserTypes(it => assert(it.getString == "echidnas"))
  }

  "testMethodWithHandlerAsyncResultUserTypes" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultUserTypesFuture().foreach(it => {
      w {
        assert(it.getString == "cheetahs")
      }
      w.dismiss()
    }))
  }

  "testMethodWithConcreteHandlerUserTypesSubtype" should "work" in {
    obj.methodWithConcreteHandlerUserTypeSubtype(Factory.createConcreteHandlerUserType(it => assert(it.getString == "echidnas")))
  }

  "testMethodWithAbstractHandlerUserTypesSubtype" should "work" in {
    obj.methodWithAbstractHandlerUserTypeSubtype(Factory.createAbstractHandlerUserType(it => assert(it.getString == "echidnas")))
  }

  "testMethodWithConcreteHandlerUserTypesSubtypeExtension" should "work" in {
    obj.methodWithConcreteHandlerUserTypeSubtypeExtension(
      new ConcreteHandlerUserTypeExtension(new io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension() {
        override def handle(event: io.vertx.codegen.testmodel.RefedInterface1): Unit = {
          assert("echidnas" == event.getString)
        }
      }))
  }

  "testMethodWithHandlerVoid" should "work" in {
    obj.methodWithHandlerVoid((event:Unit) => assert(true))
  }

  "testMethodWithHandlerAsyncResultVoid" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultVoidFuture(false).foreach((res) => {
      w.dismiss()
    }))
  }

  "testMethodWithHandlerAsyncResultVoidFails" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultVoidFuture(true).onComplete {
      case Success(_) => {
        w {
          fail("Should have failed!")
        }
        w.dismiss()
      }
      case Failure(t) => {
        w {
          assert("foo!" == t.getMessage)
        }
        w.dismiss()
      }
    })
  }

  "testMethodWithHandlerThrowable" should "work" in {
    obj.methodWithHandlerThrowable((res) => {
      assert(res.isInstanceOf[VertxException])
      assert("cheese!" == res.getMessage)
    })
  }

  "testMethodWithHandlerGenericUserType" should "work" in {
    obj.methodWithHandlerGenericUserType[String]("string_value", (res) => {
      assert("string_value" == res.getValue())
    })
  }

  "testMethodWithHandlerAsyncResultGenericUserType" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericUserTypeFuture[String]("string_value_2").foreach((res) => {
        w {
          assert(res.getValue == "string_value_2")
        }
        w.dismiss()
      })
    )
  }

  "testMethodWithGenericParam" should "work" in {
    obj.methodWithGenericParam("String", "foo")
    obj.methodWithGenericParam("Ref", new RefedInterface1Impl().setString("bar"))
    obj.methodWithGenericParam("JsonObject", Json.obj(("foo", "hello"), ("bar", 123)))
    obj.methodWithGenericParam("JsonArray", arr("foo", "bar", "wib"))
  }

  "testMethodWithGenericHandler" should "work" in {
    obj.methodWithGenericHandler[String]("String", (res) => assert(res == "foo"))
    obj.methodWithGenericHandler[io.vertx.codegen.testmodel.RefedInterface1]("Ref", (res) => assert(res.getString == "bar"))
    obj.methodWithGenericHandler[JsonObject]("JsonObject", (res) => assert(res == Json.obj(("foo", "hello"), ("bar", 123))))
    obj.methodWithGenericHandler[JsonArray]("JsonArray", (res) => assert(res == arr("foo", "bar", "wib")))
    obj.methodWithGenericHandler[JsonObject]("JsonObjectComplex", (res) => assert(res == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that")))))
  }

  "testMethodWithGenericHandlerAsyncResult" should "work" in {
    exec(5)(w => {
      obj.methodWithGenericHandlerAsyncResultFuture[String]("String").foreach((res) => {
        w {
          assert(res == "foo")
        }
        w.dismiss()
      })
      obj.methodWithGenericHandlerAsyncResultFuture[io.vertx.codegen.testmodel.RefedInterface1]("Ref").foreach((res) => {
        w {
          assert(res.getString == "bar")
        }
        w.dismiss()
      })
      obj.methodWithGenericHandlerAsyncResultFuture[JsonObject]("JsonObject").foreach((res) => {
        w {
          assert(res == Json.obj(("foo", "hello"), ("bar", 123)))
        }
        w.dismiss()
      })
      obj.methodWithGenericHandlerAsyncResultFuture[JsonArray]("JsonArray").foreach((res) => {
        w {
          assert(res == arr("foo", "bar", "wib"))
        }
        w.dismiss()
      })
      obj.methodWithGenericHandlerAsyncResultFuture[JsonObject]("JsonObjectComplex").foreach((res) => {
        w {
          assert(res == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that"))))
        }
        w.dismiss()
      })
    })
  }

  "testBasicReturns" should "work" in {
    assert(123 == obj.methodWithByteReturn())
    assert(12345 == obj.methodWithShortReturn())
    assert(12345464 == obj.methodWithIntReturn())
    assert(65675123 == obj.methodWithLongReturn())
    assert(1.23f == obj.methodWithFloatReturn())
    assert(3.34535 == obj.methodWithDoubleReturn())
    assert(obj.methodWithBooleanReturn())
    assert('Y' == obj.methodWithCharReturn())
    assert("orangutan" == obj.methodWithStringReturn())
  }

  "testVertxGenReturn" should "work" in {
    val r = obj.methodWithVertxGenReturn()
    assert("chaffinch" == r.getString())
  }

  "testVertxGenNullReturn" should "work" in {
    val r = obj.methodWithVertxGenNullReturn()
    assert(null == r.asJava)
  }

  "testVertxAbstractGenReturn" should "work" in {
    val r = obj.methodWithAbstractVertxGenReturn()
    assert("abstractchaffinch" == r.getString())
  }

  "testDataObjectReturn" should "work" in {
    val r = obj.methodWithDataObjectReturn()
    assert("foo" == r.getFoo)
    assert(123 == r.getBar)
  }

  "testDataObjectNullReturn" should "work" in {
    //DataObjects created with apply(null) will be filled with an empty dataobject instead of null
    val r = obj.methodWithDataObjectNullReturn()
    assert(null != r.asJava)
  }



  "testOverloadedMethods" should "work" in {
    val refed = new RefedInterface1(new RefedInterface1Impl())
    refed.setString("dog")
    assert("meth1" == obj.overloadedMethod("cat", refed))
    var counter = 0
    assert("meth2" == obj.overloadedMethod("cat", refed, 12345, it => {
      assert("giraffe" == it)
      counter += 1
    }))
    assert(counter == 1)
    assert("meth3" == obj.overloadedMethod("cat", it => {
      assert("giraffe" == it)
      counter += 1
    }))
    assert(counter == 2)
    //TODO reenable!
    //    assert("meth4" == obj.overloadedMethod("cat", refed,it => {
    //      assert("giraffe" == it) counter += 1
    //    }))
    //    assert(counter == 3)
  }

  "testSuperInterfaces" should "work" in {
    obj.methodWithBasicParams(123.toByte, 12345.toShort, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar")
    obj.otherSuperMethodWithBasicParams(123.toByte, 12345.toShort, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar")
  }

  "testMethodWithGenericReturn" should "work" in {
    val ret = obj.methodWithGenericReturn[JsonObject]("JsonObject")
    assert(Json.obj(("foo", "hello"), ("bar", 123)) == ret)
    val ret2 = obj.methodWithGenericReturn[JsonArray]("JsonArray")
    assert(arr("foo", "bar", "wib") == ret2)
  }

  "testFluentMethod" should "work" in {
    assert(obj.eq(obj.fluentMethod("bar")))
  }

  "testStaticFactoryMethod" should "work" in {
    assert("bar" == TestInterface.staticFactoryMethod("bar").getString())
  }

  "testMethodWithCachedReturn" should "work" in {
    val ret1 = obj.methodWithCachedReturn("bar")
    assert("bar" == ret1.getString())
    val ret2 = obj.methodWithCachedReturn("bar")
    assert(ret1.eq(ret2))
    val ret3 = obj.methodWithCachedReturn("bar")
    assert(ret1.eq(ret3))
  }

  "methodWithCachedReturnPrimitive" should "work" in {
    val ret1 = obj.methodWithCachedReturnPrimitive(2)
    assert(2 == ret1)
    val ret2 = obj.methodWithCachedReturnPrimitive(2)
    assert(ret1 == ret2)
    val ret3 = obj.methodWithCachedReturnPrimitive(2)
    assert(ret1 == ret3)
  }

  "testMethodWithCachedListReturn" should "work" in {
    val ret1 = obj.methodWithCachedListReturn()
    assert(2 == ret1.size)
    assert("foo" == ret1.head.getString)
    assert("bar" == ret1(1).getString)
    val ret2 = obj.methodWithCachedListReturn()
    assert(ret1.eq(ret2))
    val ret3 = obj.methodWithCachedListReturn()
    assert(ret1.eq(ret3))
  }

  "testJsonReturns" should "work" in {
    val ret = obj.methodWithJsonObjectReturn()
    assert(Json.obj(("cheese", "stilton")) == ret)
    val ret2 = obj.methodWithJsonArrayReturn()
    assert(arr("socks", "shoes") == ret2)
  }

  "testNullJsonReturns" should "work" in {
    val ret = obj.methodWithNullJsonObjectReturn()
    assert(null == ret)
  }

  "testComplexJsonReturns" should "work" in {
    val ret = obj.methodWithComplexJsonObjectReturn()
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == ret)
    val ret2 = obj.methodWithComplexJsonArrayReturn()
    assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == ret2)
  }

  "testJsonParams" should "work" in {
    obj.methodWithJsonParams(Json.obj(("cat", "lion"), ("cheese", "cheddar")), arr("house", "spider"))
  }

  "testNullJsonParams" should "work" in {
    obj.methodWithNullJsonParams(null, null)
  }

  "testJsonHandlerParams" should "work" in {
    var count = 0
    obj.methodWithHandlerJson(it => {
      assert(Json.obj(("cheese", "stilton")) == it)
      count += 1
    }, it => {
      assert(arr("socks", "shoes") == it)
      count -= 1
    })
    assert(0 == count)
  }

  "testComplexJsonHandlerParams" should "work" in {
    var count = 0
    obj.methodWithHandlerComplexJson(it => {
      assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == it)
      count += 1
    }, it => {
      assert(arr(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye")))) == it)
      count -= 1
    })
    assert(0 == count)
  }

  "testJsonHandlerAsyncResultParams" should "work" in {
    exec(2)(w => {
      obj.methodWithHandlerAsyncResultJsonObjectFuture().foreach(it => {
        w {
          assert(Json.obj(("cheese", "stilton")) == it)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultJsonArrayFuture().foreach(it => {
        w {
          assert(arr("socks", "shoes") == it)
        }
        w.dismiss()
      })
    })
  }

  "testNullJsonHandlerAsyncResultParams" should "work" in {
    exec(2)(w => {
      obj.methodWithHandlerAsyncResultNullJsonObjectFuture().foreach(it => {
        w {
          assert(null == it)
        }
        w.dismiss()
      })

      obj.methodWithHandlerAsyncResultNullJsonArrayFuture().foreach(it => {
        w {
          assert(null == it)
        }
        w.dismiss()
      })
    })
  }

  "testComplexJsonHandlerAsyncResultParams" should "work" in {
    exec(2)(w => {
      obj.methodWithHandlerAsyncResultComplexJsonObjectFuture().foreach(it => {
        w {
          assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == it)
        }
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultComplexJsonArrayFuture().foreach(it => {
        w {
          assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == it)
        }
        w.dismiss()
      })
    })
  }

  "testMethodWithEnumParam" should "work" in {
    val ret = obj.methodWithEnumParam("cabbages", TestEnum.JULIEN)
    assert("cabbagesJULIEN" == ret)
  }

  "testMethodWithThrowableParam" should "work" in {
    val ret = obj.methodWithThrowableParam(new Exception("the_exception"))
    assert("the_exception" == ret)
  }

  "testMethodWithEnumReturn" should "work" in {
    val ret = obj.methodWithEnumReturn("JULIEN")
    assert(TestEnum.JULIEN == ret)
  }

  "testMethodWithThrowableReturn" should "work" in {
    val ret = obj.methodWithThrowableReturn("bogies")
    assert("bogies" == ret.getMessage)
  }

  "testCustomModule" should "work" in {
    val my = MyInterface.create()
    val testInterface = my.method()
    testInterface.methodWithBasicParams(123.toByte, 12345.toShort, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar")
    val sub = my.sub()
    assert("olleh" == sub.reverse("hello"))
  }

  "testHttpServerOptionsJson" should "work" in {
    val json = Json.obj(("compressionSupported", true), ("ssl", true), ("sendBufferSize", 65000))
    val options = new HttpServerOptions().setCompressionSupported(true).setSsl(true).setSendBufferSize(65000)
    val actualOptions = new HttpServerOptions(json)
    assert(actualOptions.isCompressionSupported == options.isCompressionSupported)
    assert(actualOptions.isSsl == options.isSsl)
    assert(actualOptions.getSendBufferSize == options.getSendBufferSize)
  }
}
