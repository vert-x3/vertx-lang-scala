/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
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
import org.scalatest.concurrent.AsyncAssertions._
import org.scalatest.concurrent.AsyncAssertions.Waiter
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.concurrent.ExecutionContext
import scala.concurrent.duration.DurationLong
import scala.language.postfixOps

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ApiTest extends FlatSpec with Matchers {

  val obj = TestInterface(new TestInterfaceImpl())

  implicit val execCtx = new ExecutionContext {override def reportFailure(cause: Throwable): Unit = ???
    override def execute(runnable: Runnable): Unit = runnable.run()
  }


  def exec(dis:Int = 1)(fun: Waiter => Unit): Unit = {
    val w = new Waiter
    fun(w)
    w.await(dismissals(dis))
  }

  val exec1 = exec(1) _

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
      obj.methodWithHandlerAsyncResultByteFuture(false).foreach(b => {w{assert(123 == b)};w.dismiss()})
      obj.methodWithHandlerAsyncResultShortFuture(false).foreach(s => {w{assert(12345 == s)};w.dismiss()})
      obj.methodWithHandlerAsyncResultIntegerFuture(false).foreach(i => {w{assert(1234567 == i)};w.dismiss()})
      obj.methodWithHandlerAsyncResultLongFuture(false).foreach(l => {w{assert(1265615234l == l)};w.dismiss()})
      obj.methodWithHandlerAsyncResultFloatFuture(false).foreach(f => {w{assert(12.345f == f)};w.dismiss()})
      obj.methodWithHandlerAsyncResultDoubleFuture(false).foreach(d => {w{assert(12.34566d == d)};w.dismiss()})
      obj.methodWithHandlerAsyncResultBooleanFuture(false).foreach(b => {w{assert(true == b)};w.dismiss()})
      obj.methodWithHandlerAsyncResultCharacterFuture(false).foreach(c => {w{assert('X' == c)};w.dismiss()})
      obj.methodWithHandlerAsyncResultStringFuture(false).foreach(s => {w{assert("quux!" == s)};w.dismiss()})

      obj.methodWithHandlerAsyncResultByteFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultShortFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultIntegerFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultLongFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultFloatFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultDoubleFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultBooleanFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultCharacterFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
      obj.methodWithHandlerAsyncResultStringFuture(true).onFailure{case t => w{assert(t.getMessage == "foobar!")};w.dismiss()}
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
    obj.methodWithDataObjectParam(testmodel.TestDataObject.fromJson(Json.obj().put("bar",123).put("foo", "hello").put("wibble", 1.23)))
  }

  "testListOfDataObjectsParam" should "work" in {
    obj.methodWithListOfDataObjectsParam(mutable.Buffer(testmodel.TestDataObject.fromJson(Json.obj().put("bar",123).put("foo", "hello").put("wibble", 1.23)), testmodel.TestDataObject.fromJson(Json.obj().put("bar",123).put("foo", "world").put("wibble", 1.23))))
  }

  "testSetOfDataObjectsParam" should "work" in {
    obj.methodWithSetOfDataObjectsParam(Set(testmodel.TestDataObject.fromJson(Json.obj().put("bar",123).put("foo", "hello").put("wibble", 1.23)), testmodel.TestDataObject.fromJson(Json.obj().put("bar",123).put("foo", "world").put("wibble", 1.23))))
  }

  "testNullDataObjectParam" should "work" in {
      obj.methodWithNullDataObjectParam(None)
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
    val dataObject = TestDataObject.fromJson(Json.obj().put("foo", "foo").put("bar",123))

    exec1(w => obj.methodWithHandlerAsyncResultDataObjectFuture(false).foreach(result => {
      w {
        assert(dataObject.getFoo == result.getFoo)
        assert(dataObject.getBar == result.getBar)
      }
      w.dismiss()
    }))
    exec1(w => obj.methodWithHandlerAsyncResultDataObjectFuture(true).onFailure{case t =>
      w { assert("foobar!" == t.getMessage) }
      w.dismiss()
    })
  }

  "testMethodWithHandlerStringReturn" should "work" in {
    val handler = obj.methodWithHandlerStringReturn("the-result")
    handler("the-result")
    def failed = false
    intercept[ComparisonFailure](
      handler("not-expected")
    )
  }

  "testMethodWithHandlerGenericReturn" should "work" in {
    obj.methodWithHandlerGenericReturn[String](res =>
      assert("the-result" == res))("the-result")
    obj.methodWithHandlerGenericReturn[TestInterface](res =>
      assert(obj == res))(obj)
  }

  "testMethodWithHandlerVertxGenReturn" should "work" in {
    val handler = obj.methodWithHandlerVertxGenReturn("wibble")
    handler(RefedInterface1(new RefedInterface1Impl().setString("wibble")))
  }

  "testMethodWithHandlerAsyncResultStringReturn" should "work" in {
    val succeedingHandler = obj.methodWithHandlerAsyncResultStringReturn("the-result", false)
    succeedingHandler(Future.succeededFuture("the-result"))
    intercept[ComparisonFailure](
      succeedingHandler(Future.succeededFuture("not-expected"))
    )

    val failingHandler = obj.methodWithHandlerAsyncResultStringReturn("an-error", true)
    failingHandler(Future.failedFuture("an-error"))
    intercept[ComparisonFailure](
      succeedingHandler(Future.succeededFuture("whatever"))
    )
  }

  "testMethodWithHandlerAsyncResultGenericReturn" should "work" in {
    val w = new Waiter()
    def stringHandler = obj.methodWithHandlerAsyncResultGenericReturn[String](a => {w{assert(a.result() == "the-result")}; w.dismiss();})
    stringHandler(ScalaAsyncResult("the-result"))
    w.await()

    val w2 = new Waiter
    def objHandler = obj.methodWithHandlerAsyncResultGenericReturn[TestInterface](a => {w2{assert(a.result() == obj)};w2.dismiss();})
    objHandler(ScalaAsyncResult(obj))
    w2.await()
  }

  "testMethodWithHandlerAsyncResultVertxGenReturn" should "work" in {
    var handler = obj.methodWithHandlerAsyncResultVertxGenReturn("wibble", false)
    handler(Future.succeededFuture(RefedInterface1(new RefedInterface1Impl().setString("wibble"))))
    handler = obj.methodWithHandlerAsyncResultVertxGenReturn("oh-no", true)
    handler(Future.failedFuture("oh-no"))
  }

  "testMethodWithHandlerListAndSet" should "work" in {
    obj.methodWithHandlerListAndSet(
      it => assert(List("foo", "bar", "wibble") == it),
      it => assert(List(5, 12, 100) == it),
      it => assert(Set("foo", "bar", "wibble") == it),
      it => assert(Set(5, 12, 100) == it)
    )
  }

  "testMethodWithHandlerAsyncResultListAndSet" should "work" in {
    import collection.JavaConverters._
    exec(4)(w => {
      obj.methodWithHandlerAsyncResultListStringFuture().foreach(it => {w {assert(List("foo", "bar", "wibble").diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultListIntegerFuture().foreach(it => {w {assert(List(5, 12, 100).diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultSetStringFuture().foreach(it => {w {assert(Set("foo", "bar", "wibble").diff(it).isEmpty)}; w.dismiss()})
      obj.methodWithHandlerAsyncResultSetIntegerFuture().foreach(it => {w {assert(Set(5, 12, 100).diff(it).isEmpty)}; w.dismiss()})
    })
  }

  "testMethodWithHandlerListVertxGen" should "work" in {
    obj.methodWithHandlerListVertxGen(it => assert(it.map(_.getString()) == List("foo", "bar")))
  }

  "testMethodWithHandlerListAbstractVertxGen" should "work" in {
    obj.methodWithHandlerListAbstractVertxGen(it => assert(it.map(_.getString()) == List("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultListVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == ArrayBuffer("foo", "bar"))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListAbstractVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == ArrayBuffer("abstractfoo", "abstractbar"))}; w.dismiss()}))
  }

  "testMethodWithHandlerSetVertxGen" should "work" in {
    obj.methodWithHandlerSetVertxGen(it => assert(it.map(_.getString()) == Set("bar", "foo")))
  }

  "testMethodWithHandlerSetAbstractVertxGen" should "work" in {
    obj.methodWithHandlerSetAbstractVertxGen(it => assert(it.map(_.getString()) == Set("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultSetVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == Set("bar", "foo"))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetAbstractVertxGenFuture().foreach(it => { w {assert(it.map(_.getString()) == Set("abstractbar", "abstractfoo"))}; w.dismiss()}))
  }

  "testMethodWithHandlerListJsonObject" should "work" in {
    obj.methodWithHandlerListJsonObject(it => assert(it == List(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan")))))
  }

  "testMethodWithHandlerListNullJsonObject" should "work" in {
    obj.methodWithHandlerListNullJsonObject(it => assert(it == List(null)))
  }

  "testMethodWithHandlerListComplexJsonObject" should "work" in {
    obj.methodWithHandlerListComplexJsonObject(it => assert(it == List(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))))))
  }

  "testMethodWithHandlerAsyncResultListJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListJsonObjectFuture().foreach(it => { w {assert(List(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListNullJsonObjectFuture().foreach(it => { w {assert(List(null).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultListComplexJsonObjectFuture().foreach(it => { w {assert(List(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerSetJsonObject" should "work" in {
    obj.methodWithHandlerSetJsonObject(it => assert(it == Set(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan")))))
  }

  "testMethodWithHandlerSetNullJsonObject" should "work" in {
    obj.methodWithHandlerSetNullJsonObject(it => assert(it == Set(null)))
  }

  "testMethodWithHandlerSetComplexJsonObject" should "work" in {
    obj.methodWithHandlerSetComplexJsonObject(it => assert(it == Set(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetJsonObjectFuture().foreach(it => { w {assert(Set(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetNullJsonObjectFuture().foreach(it => { w {assert(Set(null).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    exec1(w => obj.methodWithHandlerAsyncResultSetComplexJsonObjectFuture().foreach(it => { w {assert(Set(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it))}; w.dismiss()}))
  }

  "testMethodWithHandlerListJsonArray" should "work" in {
    obj.methodWithHandlerListJsonArray(it => assert(it == List(arr("green", "blue"), arr("yellow", "purple"))))
  }

  "testMethodWithHandlerListNullJsonArray" should "work" in {
    obj.methodWithHandlerListNullJsonArray(it => assert(it == List(null)))
  }

  "testMethodWithHandlerListComplexJsonArray" should "work" in {
    obj.methodWithHandlerListComplexJsonArray(it => assert(it == List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

  "testMethodWithHandlerListDataObject" should "work" in {
    obj.methodWithHandlerListDataObject(it => {
      assert("String 1" == it.head.getFoo)
      assert(1 == it.head.getBar)
      assert(1.1 == it.head.getWibble)
      assert("String 2" == it(1).getFoo)
      assert(2 == it(1).getBar)
      assert(2.2 == it(1).getWibble)
    })
  }

  "testMethodWithHandlerNullListDataObject" should "work" in {
    obj.methodWithHandlerListNullDataObject(it => assert(List(null) == it))
  }


  "testMethodWithHandlerSetDataObject" should "work" in {
    var checkVar = 0
    obj.methodWithHandlerSetDataObject(it => {
      it.forall(td => {
        if ("String 1" == td.getFoo) {
          assert(1 == td.getBar)
          assert(1.1 == td.getWibble)
          checkVar += 1
        }
        else if ("String 2" == td.getFoo) {
          assert(2 == td.getBar)
          assert(2.2 == td.getWibble)
          checkVar -= 1
        }
        true
      })
    })
    assert(checkVar == 0)
  }

  "testMethodWithHandlerNullSetDataObject" should "work" in {
    obj.methodWithHandlerSetNullDataObject(it => assert(Set(null) == it))
  }

  "testMethodWithHandlerAsyncResultListJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListJsonArrayFuture().foreach(it => { w {assert(it.diff(List(arr("green", "blue"), arr("yellow", "purple"))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListNullJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListNullJsonArrayFuture().foreach(it => { w {assert(it == List(null))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListComplexJsonArrayFuture().foreach(it => { w {assert(it.diff(List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerSetJsonArray" should "work" in {
    obj.methodWithHandlerSetJsonArray(it => assert(it == Set(arr("green", "blue"), arr("yellow", "purple"))))
  }

  "testMethodWithHandlerSetNullJsonArray" should "work" in {
    obj.methodWithHandlerSetNullJsonArray(it => assert(it == Set(null)))
  }

  "testMethodWithHandlerSetComplexJsonArray" should "work" in {
    obj.methodWithHandlerSetComplexJsonArray(it => assert(it == Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetJsonArrayFuture().foreach(it => { w {assert(it.diff(Set(arr("green", "blue"), arr("yellow", "purple"))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultNullSetJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetNullJsonArrayFuture().foreach(it => { w {assert(it == Set(null))}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetComplexJsonArrayFuture().foreach(it => { w {assert(it.diff(Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultListDataObject" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultListDataObjectFuture().foreach(it => {
      w {
        assert("String 1" == it(0).getFoo)
        assert(1 == it(0).getBar)
        assert(1.1 == it(0).getWibble)

        assert("String 2" == it(1).getFoo)
        assert(2 == it(1).getBar)
        assert(2.2 == it(1).getWibble)
      }
      w.dismiss()
    }))
  }

  "testMethodWithHandlerAsyncResultNullListDataObject" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListNullDataObjectFuture().foreach(it => {
      w { assert(List(null) == it) }
      w.dismiss()
    }))
  }

  "testMethodWithHandlerAsyncResultSetDataObject" should "work" in {
    import collection.JavaConversions._
    var checkVar = 0
    exec1(w => obj.methodWithHandlerAsyncResultSetDataObjectFuture().foreach(it => {
      val coll = it
      coll.forall(td => {
        if ("String 1" == td.getFoo) {
          assert(1 == td.getBar)
          assert(1.1 == td.getWibble)
          checkVar += 1
          w.dismiss()
        }
        else if ("String 2" == td.getFoo) {
          assert(2 == td.getBar)
          assert(2.2 == td.getWibble)
          checkVar -= 1
          w.dismiss()
        }
        true
      })
    }))
    assert(checkVar == 0)
  }


  "testMethodWithHandlerAsyncResultNullSetDataObject" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetNullDataObjectFuture().foreach(it => {
      w{ assert(Set(null) == it)}
      w.dismiss()
    }))
  }


  "testMethodWithHandlerUserTypes" should "work" in {
    obj.methodWithHandlerUserTypes(it => assert(it.getString == "echidnas"))
  }

  "testMethodWithHandlerAsyncResultUserTypes" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultUserTypesFuture().foreach(it => {
      w{assert(it.getString == "cheetahs")}
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
    obj.methodWithHandlerVoid(() => assert(true))
  }

  "testMethodWithHandlerAsyncResultVoid" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultVoidFuture(false).foreach((res) => {
      w.dismiss()
    }))
  }

  "testMethodWithHandlerAsyncResultVoidFails" should "work" in {
    exec1(w => obj.methodWithHandlerAsyncResultVoidFuture(true).onFailure{
      case t => {
        w { assert(t.getMessage == "foo!") }
        w.dismiss()
      };
    })
  }

  "testMethodWithHandlerThrowable" should "work" in {
    obj.methodWithHandlerThrowable((res) => {
      assert(res.isInstanceOf[VertxException])
      assert("cheese!" == res.getMessage)
    })
  }

  "testMethodWithHandlerGenericUserType" should "work" in {
    obj.methodWithHandlerGenericUserType[String]("string_value",(res) => {
      assert("string_value" == res.getValue())
    })
  }

  "testMethodWithHandlerAsyncResultGenericUserType" should "work" in {
    exec1(w =>
      obj.methodWithHandlerAsyncResultGenericUserTypeFuture[String]("string_value_2").foreach((res) => {
        w {assert(res.getValue == "string_value_2") }
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
    obj.methodWithGenericHandler[String]("String",(res) => assert(res == "foo"))
    obj.methodWithGenericHandler[io.vertx.codegen.testmodel.RefedInterface1]("Ref",(res) => assert(res.getString == "bar"))
    obj.methodWithGenericHandler[JsonObject]("JsonObject",(res) => assert(res == Json.obj(("foo", "hello"), ("bar", 123))))
    obj.methodWithGenericHandler[JsonArray]("JsonArray",(res) => assert(res == arr("foo", "bar", "wib")))
    obj.methodWithGenericHandler[JsonObject]("JsonObjectComplex",(res) => assert(res == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that")))))
  }

  "testMethodWithGenericHandlerAsyncResult" should "work" in {
    exec(5)(w => {
      obj.methodWithGenericHandlerAsyncResultFuture[String]("String").foreach((res) => { w {assert(res == "foo")}; w.dismiss()})
      obj.methodWithGenericHandlerAsyncResultFuture[io.vertx.codegen.testmodel.RefedInterface1]("Ref").foreach((res) => { w {assert(res.getString == "bar")}; w.dismiss()})
      obj.methodWithGenericHandlerAsyncResultFuture[JsonObject]("JsonObject").foreach((res) => { w { assert(res == Json.obj(("foo", "hello"), ("bar", 123)))}; w.dismiss()})
      obj.methodWithGenericHandlerAsyncResultFuture[JsonArray]("JsonArray").foreach((res) => { w { assert(res == arr("foo", "bar", "wib"))}; w.dismiss()})
      obj.methodWithGenericHandlerAsyncResultFuture[JsonObject]("JsonObjectComplex").foreach((res) => { w {assert(res == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that"))))}; w.dismiss()})
    })
  }

  "testMethodListParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")

    obj.methodWithListParams(
      mutable.Buffer("foo", "bar"),
      mutable.Buffer(2.toByte, 3.toByte),
      mutable.Buffer(12.toShort, 13.toShort),
      mutable.Buffer(1234, 1345),
      mutable.Buffer(123l, 456l),
      mutable.Buffer(Json.obj(("foo", "bar")), Json.obj(("eek", "wibble"))),
      mutable.Buffer(arr("foo"), arr("blah")),
      mutable.Buffer(refed1, refed2),
      mutable.Buffer(TestDataObject.fromJson(Json.obj().put("bar", 1).put("wibble", 1.1).put("foo", "String 1")), TestDataObject.fromJson(Json.obj().put("bar", 2).put("wibble", 2.2).put("foo", "String 2"))),
      mutable.Buffer(TestEnum.JULIEN, TestEnum.TIM))
  }

  "testMethodSetParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")

    obj.methodWithSetParams(
      Set("foo", "bar"),
      Set(2.toByte, 3.toByte),
      Set(12.toShort, 13.toShort),
      Set(1234, 1345),
      Set(123l, 456l),
      Set(Json.obj(("foo", "bar")), Json.obj(("eek", "wibble"))),
      Set(arr("foo"), arr("blah")),
      Set(refed1, refed2),
      Set(TestDataObject.fromJson(Json.obj().put("bar", 1).put("wibble", 1.1).put("foo", "String 1")), TestDataObject.fromJson(Json.obj().put("bar", 2).put("wibble", 2.2).put("foo", "String 2"))),
      Set(TestEnum.JULIEN, TestEnum.TIM))
  }

  "testMethodMapParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")
    obj.methodWithMapParams(
      Map("foo" -> "bar", "eek" -> "wibble"),
      Map("foo" -> 2.toByte, "eek" -> 3.toByte),
      Map("foo" -> 12.toShort, "eek" -> 13.toShort),
      Map("foo" -> 1234, "eek" -> 1345),
      Map("foo" -> 123l, "eek" -> 456l),
      Map("foo" -> Json.obj(("foo", "bar")), "eek" -> Json.obj(("eek", "wibble"))),
      Map("foo" -> arr("foo"), "eek" -> arr("blah")),
      Map("foo" -> refed1, "eek" -> refed2)
    )
  }

  "testMethodWithHandlerListEnum" should "work" in {
    obj.methodWithHandlerListEnum(it => assert(it == List(TestEnum.TIM, TestEnum.JULIEN)))
  }

  "testMethodWithHandlerSetEnum" should "work" in {
    obj.methodWithHandlerSetEnum(it => assert(it == Set(TestEnum.TIM, TestEnum.JULIEN)))
  }

  "testMethodWithHandlerAsyncResultListEnum" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultListEnumFuture().foreach(it => { w{assert(it.toSet.diff(Set(TestEnum.TIM, TestEnum.JULIEN)).isEmpty)}; w.dismiss()}))
  }

  "testMethodWithHandlerAsyncResultSetEnum" should "work" in {
    import collection.JavaConverters._
    exec1(w => obj.methodWithHandlerAsyncResultSetEnumFuture().foreach(it => { w{assert(it.diff(Set(TestEnum.TIM, TestEnum.JULIEN)).isEmpty)}; w.dismiss()}))
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
    val r = obj.methodWithDataObjectNullReturn()
    assert(null == r)
  }

  "testListStringReturn" should "work" in {
    assert(List("foo", "bar", "wibble") == obj.methodWithListStringReturn())
  }

  "testListLongReturn" should "work" in {
    assert(List(123l, 456l) == obj.methodWithListLongReturn())
  }

  "testListJsonObjectReturn" should "work" in {
    val list = obj.methodWithListJsonObjectReturn()
    assert(2 == list.size)
    assert("bar" == list.head.getString("foo"))
    assert("eek" == list(1).getString("blah"))
  }

  "testListComplexJsonObjectReturn" should "work" in {
    val list = obj.methodWithListComplexJsonObjectReturn()
    assert(1 == list.size)
    val json1 = list.head
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == json1)
  }

  "testListJsonArrayReturn" should "work" in {
    var list = obj.methodWithListJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list.head
    assert("foo" == json1.getString(0))
    val json2 = list(1)
    assert("blah" == json2.getString(0))
  }

  "testListComplexJsonArrayReturn" should "work" in {
    val list = obj.methodWithListComplexJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list.head
    assert(arr(Json.obj(("foo", "hello"))) == json1)
    val json2 = list(1)
    assert(arr(Json.obj(("bar", "bye"))) == json2)
  }

  "testListVertxGenReturn" should "work" in {
    val list = obj.methodWithListVertxGenReturn()
    assert(2 == list.size)
    val refed1 = list.head
    val refed2 = list(1)
    assert("foo" == refed1.getString())
    assert("bar" == refed2.getString())
  }

  "testListDataObjectReturn" should "work" in {
    val list = obj.methodWithListDataObjectReturn()
    assert("String 1" == list.head.getFoo)
    assert(1 == list.head.getBar)
    assert(1.1 == list.head.getWibble)
    assert("String 2" == list(1).getFoo)
    assert(2 == list(1).getBar)
    assert(2.2 == list(1).getWibble)
  }

  "testSetStringReturn" should "work" in {
    assert(Set("foo", "bar", "wibble") == obj.methodWithSetStringReturn())
  }

  "testSetLongReturn" should "work" in {
    assert(Set(123l, 456l) == obj.methodWithSetLongReturn())
  }

  "testSetJsonObjectReturn" should "work" in {
    val set = obj.methodWithSetJsonObjectReturn()
    assert(2 == set.size)
    val json1 = Json.obj(("foo", "bar"))
    assert(set.contains(json1))
    val json2 = Json.obj(("blah", "eek"))
    assert(set.contains(json2))
  }


  "testSetComplexJsonObjectReturn" should "work" in {
    val set = obj.methodWithSetComplexJsonObjectReturn()
    assert(1 == set.size)
    assert(set.contains(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))))
  }

  "testSetJsonArrayReturn" should "work" in {
    val set = obj.methodWithSetJsonArrayReturn()
    assert(2 == set.size)
    assert(set.contains(Json.arr("foo")))
    assert(set.contains(Json.arr("blah")))
  }

  "testSetComplexJsonArrayReturn" should "work" in {
    val set = obj.methodWithSetComplexJsonArrayReturn()
    assert(2 == set.size)
    assert(set.contains(arr(Json.obj(("foo", "hello")))))
    assert(set.contains(arr(Json.obj(("bar", "bye")))))
  }

  "testSetVertxGenReturn" should "work" in {
    val set = obj.methodWithSetVertxGenReturn()
    assert(2 == set.size)
    assert(set.map(_.getString()).size == 2)
  }

  "testSetDataObjectReturn" should "work" in {
    var checkVar = 0
    val coll = obj.methodWithSetDataObjectReturn()
    val allok = coll.forall(td => {
      if ("String 1" == td.getFoo) {
        assert(1 == td.getBar)
        assert(1.1 == td.getWibble)
        checkVar += 1
        true
      }
      else if ("String 2" == td.getFoo) {
        assert(2 == td.getBar)
        assert(2.2 == td.getWibble)
        checkVar -= 1
        true
      }
      else
        false
    })

    assert(allok)
    assert(checkVar == 0)
  }

  "testMapStringReturn" should "work" in {
    val map = obj.methodWithMapStringReturn(a => {})
    assert("bar" == map("foo"))
  }

  "testMapLongReturn" should "work" in {
    val map = obj.methodWithMapLongReturn(a => {})
    assert(123l == map("foo"))
  }

  "testMapJsonObjectReturn" should "work" in {
    val map = obj.methodWithMapJsonObjectReturn(a => {})
    val m = map("foo")
    assert("eek" == m.getString("wibble"))
  }

  "testMapComplexJsonObjectReturn" should "work" in {
    val map = obj.methodWithMapComplexJsonObjectReturn(a => {})
    val m = map("foo")
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == m)
  }

  "testMapJsonArrayReturn" should "work" in {
    val map = obj.methodWithMapJsonArrayReturn(a => {})
    val m = map("foo")
    assert("wibble" == m.getString(0))
  }

  "testMapComplexJsonArrayReturn" should "work" in {
    val map = obj.methodWithMapComplexJsonArrayReturn(a => {})
    val m = map("foo")
    assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == m)
  }

  "testOverloadedMethods" should "work" in {
    val refed = new RefedInterface1(new RefedInterface1Impl())
    refed.setString("dog")
    assert("meth1" == obj.overloadedMethod("cat", refed))
    var counter = 0
    assert("meth2" == obj.overloadedMethod("cat", refed, 12345,it => {
      assert("giraffe" == it); counter += 1
    }))
    assert(counter == 1)
    assert("meth3" == obj.overloadedMethod("cat",it => {
      assert("giraffe" == it); counter += 1
    }))
    assert(counter == 2)
    //TODO reenable!
//    assert("meth4" == obj.overloadedMethod("cat", refed,it => {
//      assert("giraffe" == it); counter += 1
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
    val ret2 = obj.methodWithNullJsonObjectReturn()
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

  "testNullJsonHandlerParams" should "work" in {
    var count = 0
    obj.methodWithHandlerNullJson(it => {
      assert(null == it)
      count += 1
    }, it => {
      assert(null == it)
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
        w{assert(Json.obj(("cheese", "stilton")) == it)}
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultJsonArrayFuture().foreach(it => {
        w{assert(arr("socks", "shoes") == it)}
        w.dismiss()
      })
    })
  }

  "testNullJsonHandlerAsyncResultParams" should "work" in {
    exec(2)(w => {
      obj.methodWithHandlerAsyncResultNullJsonObjectFuture().foreach(it => {
        w{assert(null == it)}
        w.dismiss()
      })

      obj.methodWithHandlerAsyncResultNullJsonArrayFuture().foreach(it => {
        w{assert(null == it)}
        w.dismiss()
      })
    })
  }

  "testComplexJsonHandlerAsyncResultParams" should "work" in {
    exec(2)(w => {
      obj.methodWithHandlerAsyncResultComplexJsonObjectFuture().foreach(it => {
        w{assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == it)}
        w.dismiss()
      })
      obj.methodWithHandlerAsyncResultComplexJsonArrayFuture().foreach(it => {
        w{assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == it)}
        w.dismiss()
      })
    })
  }

  "testMethodWithListEnumReturn" should "work" in {
    assert(List(TestEnum.JULIEN, TestEnum.TIM) == obj.methodWithListEnumReturn())
  }

  "testMethodWithSetEnumReturn" should "work" in {
    assert(Set(TestEnum.JULIEN, TestEnum.TIM) == obj.methodWithSetEnumReturn())
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

  //NullableTCK

  val nullableTCK = testmodel.NullableTCK(new NullableTCKImpl)

  "testNullableByte" should "work" in {
    val testByte = 67.toByte
    nullableTCK.methodWithNullableByteParam(true, None)
    nullableTCK.methodWithNullableByteParam(false, Option(testByte))
    nullableTCK.methodWithNullableByteHandler(true,b => assert(testByte == b))
    nullableTCK.methodWithNullableByteHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableByteHandlerAsyncResultFuture(true).foreach(b => {w{assert(testByte == b)}; w.dismiss()}))
    //TODO: Is this behavior correct? Check with other params, too
    exec1(w => nullableTCK.methodWithNullableByteHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableByteReturn(true)
    nullableTCK.methodWithNullableByteReturn(false)
  }

  "testNullableShort" should "work" in {
    val testShort = 1024.toShort
    nullableTCK.methodWithNullableShortParam(true, None)
    nullableTCK.methodWithNullableShortParam(false, Option(testShort))
    nullableTCK.methodWithNullableShortHandler(true,b => assert(testShort == b))
    nullableTCK.methodWithNullableShortHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableShortHandlerAsyncResultFuture(true).foreach(b => {w{assert(testShort == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableShortHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableShortReturn(true)
    nullableTCK.methodWithNullableShortReturn(false)
  }

  "testNullableInteger" should "work" in {
    val testInteger = 1234567
    nullableTCK.methodWithNullableIntegerParam(true, None)
    nullableTCK.methodWithNullableIntegerParam(false, Option(testInteger))
    nullableTCK.methodWithNullableIntegerHandler(true,b => assert(testInteger == b))
    nullableTCK.methodWithNullableIntegerHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableIntegerHandlerAsyncResultFuture(true).foreach(b => {w{assert(testInteger == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableIntegerHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableIntegerReturn(true)
    nullableTCK.methodWithNullableIntegerReturn(false)
  }

  "testNullableLong" should "work" in {
    val testLong = 9876543210l
    nullableTCK.methodWithNullableLongParam(true, None)
    nullableTCK.methodWithNullableLongParam(false, Option(testLong))
    nullableTCK.methodWithNullableLongHandler(true,b => assert(testLong == b))
    nullableTCK.methodWithNullableLongHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableLongHandlerAsyncResultFuture(true).foreach(b => {w{assert(testLong == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableLongHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableLongReturn(true)
    nullableTCK.methodWithNullableLongReturn(false)
  }

  "testNullableFloat" should "work" in {
    val testFloat = 3.14.toFloat
    nullableTCK.methodWithNullableFloatParam(true, None)
    nullableTCK.methodWithNullableFloatParam(false, Option(testFloat))
    nullableTCK.methodWithNullableFloatHandler(true,b => assert(testFloat == b))
    nullableTCK.methodWithNullableFloatHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableFloatHandlerAsyncResultFuture(true).foreach(b => {w{assert(testFloat == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableFloatHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableFloatReturn(true)
    nullableTCK.methodWithNullableFloatReturn(false)
  }

  "testNullableDouble" should "work" in {
    val testDouble = 3.1415926
    nullableTCK.methodWithNullableDoubleParam(true, None)
    nullableTCK.methodWithNullableDoubleParam(false, Option(testDouble))
    nullableTCK.methodWithNullableDoubleHandler(true,b => assert(testDouble == b))
    nullableTCK.methodWithNullableDoubleHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableDoubleHandlerAsyncResultFuture(true).foreach(b => {w{assert(testDouble == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableDoubleHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableDoubleReturn(true)
    nullableTCK.methodWithNullableDoubleReturn(false)
  }

  "testNullableBoolean" should "work" in {
    val testBoolean = true
    nullableTCK.methodWithNullableBooleanParam(true, None)
    nullableTCK.methodWithNullableBooleanParam(false, Option(testBoolean))
    nullableTCK.methodWithNullableBooleanHandler(true,b => assert(testBoolean == b))
    nullableTCK.methodWithNullableBooleanHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableBooleanHandlerAsyncResultFuture(true).foreach(b => {w{assert(testBoolean == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableBooleanHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableBooleanReturn(true)
    nullableTCK.methodWithNullableBooleanReturn(false)
  }

  "testNullableChar" should "work" in {
    val testChar = 'f'
    nullableTCK.methodWithNullableCharParam(true, None)
    nullableTCK.methodWithNullableCharParam(false, Option(testChar))
    nullableTCK.methodWithNullableCharHandler(true,b => assert(testChar == b))
    nullableTCK.methodWithNullableCharHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableCharHandlerAsyncResultFuture(true).foreach(b => {w{assert(testChar == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableCharHandlerAsyncResultFuture(false).onFailure{case t => {w{assert(t.isInstanceOf[NullPointerException])}; w.dismiss()}})
    nullableTCK.methodWithNullableCharReturn(true)
    nullableTCK.methodWithNullableCharReturn(false)
  }

  "testNullableJsonObject" should "work" in {
    val testJsonObject = Json.obj(("foo","wibble"),("bar",3))
    nullableTCK.methodWithNullableJsonObjectParam(true, None)
    nullableTCK.methodWithNullableJsonObjectParam(false, Option(testJsonObject))
    nullableTCK.methodWithNullableJsonObjectHandler(true,b => assert(testJsonObject == b))
    nullableTCK.methodWithNullableJsonObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableJsonObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testJsonObject == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableJsonObjectHandlerAsyncResultFuture(false).foreach(t => {w{assert(t == null)}; w.dismiss()}))
    nullableTCK.methodWithNullableJsonObjectReturn(true)
    nullableTCK.methodWithNullableJsonObjectReturn(false)
  }

  "testNullableJsonArray" should "work" in {
    val testJsonArray = Json.arr("one","two","three")
    nullableTCK.methodWithNullableJsonArrayParam(true, None)
    nullableTCK.methodWithNullableJsonArrayParam(false, Option(testJsonArray))
    nullableTCK.methodWithNullableJsonArrayHandler(true,b => assert(testJsonArray == b))
    nullableTCK.methodWithNullableJsonArrayHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableJsonArrayHandlerAsyncResultFuture(true).foreach(b => {w{assert(testJsonArray == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableJsonArrayHandlerAsyncResultFuture(false).foreach(t => {w{assert(t == null)}; w.dismiss()}))
    nullableTCK.methodWithNullableJsonArrayReturn(true)
    nullableTCK.methodWithNullableJsonArrayReturn(false)
  }

  "testNullableApi" should "work" in {
    val testApi = RefedInterface1(new RefedInterface1Impl().setString("lovely_dae"))
    nullableTCK.methodWithNullableApiParam(true, None)
    nullableTCK.methodWithNullableApiParam(false, Option(testApi))
    nullableTCK.methodWithNullableApiHandler(true,b => assert(testApi.asJava == b.asJava))
    nullableTCK.methodWithNullableApiHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableApiHandlerAsyncResultFuture(true).foreach(b => {w{assert(testApi.asJava == b.asJava)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableApiHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableApiReturn(true)
    nullableTCK.methodWithNullableApiReturn(false)
  }

  "testNullableDataObject" should "work" in {
    val testDataObject = TestDataObject.fromJson(Json.obj(("foo","foo_value"), ("bar",12345), ("wibble", 3.5)))
    nullableTCK.methodWithNullableDataObjectParam(true, None)
    nullableTCK.methodWithNullableDataObjectParam(false, Option(testDataObject))
    nullableTCK.methodWithNullableDataObjectHandler(true,b => assert(testDataObject.asJava.toJson == b.asJava.toJson))
    nullableTCK.methodWithNullableDataObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableDataObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testDataObject.asJava.toJson == b.asJava.toJson)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableDataObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableDataObjectReturn(true)
    nullableTCK.methodWithNullableDataObjectReturn(false)
  }

  "testNullableEnum" should "work" in {
    val testEnum = TestEnum.TIM
    nullableTCK.methodWithNullableEnumParam(true, None)
    nullableTCK.methodWithNullableEnumParam(false, Option(testEnum))
    nullableTCK.methodWithNullableEnumHandler(true,b => assert(testEnum == b))
    nullableTCK.methodWithNullableEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testEnum == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableEnumReturn(true)
    nullableTCK.methodWithNullableEnumReturn(false)
  }

  "testNullableGenEnum" should "work" in {
    val testGenEnum = TestGenEnum.MIKE
    nullableTCK.methodWithNullableGenEnumParam(true, None)
    nullableTCK.methodWithNullableGenEnumParam(false, Option(testGenEnum))
    nullableTCK.methodWithNullableGenEnumHandler(true,b => assert(testGenEnum == b))
    nullableTCK.methodWithNullableGenEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableGenEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testGenEnum == b)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableGenEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableGenEnumReturn(true)
    nullableTCK.methodWithNullableGenEnumReturn(false)
  }

  "testNullableTypeVariable" should "work" in {
    nullableTCK.methodWithNullableTypeVariableParam(false, "whatever")
    nullableTCK.methodWithNullableTypeVariableParam(true, null)
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandler[String](true, "wibble",a => {w{assert(a == "wibble")}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandler[String](true, null,b => {w{assert(b == null)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandlerAsyncResultFuture[String](true, "sausages").foreach(c => {w{assert(c == "sausages")};w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableTypeVariableHandlerAsyncResultFuture[String](true, null).foreach(d => {w{assert(d == null)};w.dismiss()}))
    assert("fizz1" == nullableTCK.methodWithNullableTypeVariableReturn[String](true, "fizz1"))
    assert(null == nullableTCK.methodWithNullableTypeVariableReturn(false, "fizz2"))
  }

  "testNullableObjectParam" should "work" in {
    nullableTCK.methodWithNullableObjectParam(true, null)
    nullableTCK.methodWithNullableObjectParam(false, "object_param")
  }








  "testNullableListByte" should "work" in {
    import collection.JavaConverters._
    val testListByte = mutable.Buffer(12.toByte,24.toByte,(-12).toByte)
    nullableTCK.methodWithNullableListByteParam(true, None)
    nullableTCK.methodWithNullableListByteParam(false, Option(testListByte))
    nullableTCK.methodWithNullableListByteHandler(true,b => assert(testListByte == b))
    nullableTCK.methodWithNullableListByteHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListByteHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListByte.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListByteHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListByteReturn(true)
    nullableTCK.methodWithNullableListByteReturn(false)
  }

  "testNullableListShort" should "work" in {
    import collection.JavaConverters._
    val testListShort = mutable.Buffer(520.toShort,1040.toShort,(-520).toShort)
    nullableTCK.methodWithNullableListShortParam(true, None)
    nullableTCK.methodWithNullableListShortParam(false, Option(testListShort))
    nullableTCK.methodWithNullableListShortHandler(true,b => assert(testListShort == b))
    nullableTCK.methodWithNullableListShortHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListShortHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListShort.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListShortHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListShortReturn(true)
    nullableTCK.methodWithNullableListShortReturn(false)
  }

  "testNullableListInteger" should "work" in {
    import collection.JavaConverters._
    val testListInteger = mutable.Buffer(12345,54321,-12345)
    nullableTCK.methodWithNullableListIntegerParam(true, None)
    nullableTCK.methodWithNullableListIntegerParam(false, Option(testListInteger))
    nullableTCK.methodWithNullableListIntegerHandler(true,b => assert(testListInteger == b))
    nullableTCK.methodWithNullableListIntegerHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListIntegerHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListInteger.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListIntegerHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListIntegerReturn(true)
    nullableTCK.methodWithNullableListIntegerReturn(false)
  }

  "testNullableListLong" should "work" in {
    import collection.JavaConverters._
    val testListLong = mutable.Buffer(123456789l,987654321l,-123456789l)
    nullableTCK.methodWithNullableListLongParam(true, None)
    nullableTCK.methodWithNullableListLongParam(false, Option(testListLong))
    nullableTCK.methodWithNullableListLongHandler(true,b => assert(testListLong == b))
    nullableTCK.methodWithNullableListLongHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListLongHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListLong.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListLongHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListLongReturn(true)
    nullableTCK.methodWithNullableListLongReturn(false)
  }

  "testNullableListFloat" should "work" in {
    import collection.JavaConverters._
    val testListFloat = mutable.Buffer(1.1f,2.2f,3.3f)
    nullableTCK.methodWithNullableListFloatParam(true, None)
    nullableTCK.methodWithNullableListFloatParam(false, Option(testListFloat))
    nullableTCK.methodWithNullableListFloatHandler(true,b => assert(testListFloat == b))
    nullableTCK.methodWithNullableListFloatHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListFloatHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListFloat.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListFloatHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListFloatReturn(true)
    nullableTCK.methodWithNullableListFloatReturn(false)
  }

  "testNullableListDouble" should "work" in {
    import collection.JavaConverters._
    val testListDouble = mutable.Buffer(1.11,2.22,3.33)
    nullableTCK.methodWithNullableListDoubleParam(true, None)
    nullableTCK.methodWithNullableListDoubleParam(false, Option(testListDouble))
    nullableTCK.methodWithNullableListDoubleHandler(true,b => assert(testListDouble == b))
    nullableTCK.methodWithNullableListDoubleHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListDoubleHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListDouble.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListDoubleHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListDoubleReturn(true)
    nullableTCK.methodWithNullableListDoubleReturn(false)
  }

  "testNullableListBoolean" should "work" in {
    import collection.JavaConverters._
    val testListBoolean = mutable.Buffer( true,false,true)
    nullableTCK.methodWithNullableListBooleanParam(true, None)
    nullableTCK.methodWithNullableListBooleanParam(false, Option(testListBoolean))
    nullableTCK.methodWithNullableListBooleanHandler(true,b => assert(testListBoolean == b))
    nullableTCK.methodWithNullableListBooleanHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListBooleanHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListBoolean.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListBooleanHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListBooleanReturn(true)
    nullableTCK.methodWithNullableListBooleanReturn(false)
  }

  "testNullableListString" should "work" in {
    import collection.JavaConverters._
    val testListString = mutable.Buffer("first","second","third")
    nullableTCK.methodWithNullableListStringParam(true, None)
    nullableTCK.methodWithNullableListStringParam(false, Option(testListString))
    nullableTCK.methodWithNullableListStringHandler(true,b => assert(testListString == b))
    nullableTCK.methodWithNullableListStringHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListStringHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListString.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListStringHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListStringReturn(true)
    nullableTCK.methodWithNullableListStringReturn(false)
  }

  "testNullableListChar" should "work" in {
    import collection.JavaConverters._
    val testListChar = mutable.Buffer('x','y','z')
    nullableTCK.methodWithNullableListCharParam(true, None)
    nullableTCK.methodWithNullableListCharParam(false, Option(testListChar))
    nullableTCK.methodWithNullableListCharHandler(true,b => assert(testListChar == b))
    nullableTCK.methodWithNullableListCharHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListCharHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListChar.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListCharHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListCharReturn(true)
    nullableTCK.methodWithNullableListCharReturn(false)
  }

  "testNullableListJsonObject" should "work" in {
    import collection.JavaConverters._
    val testListJsonObject = mutable.Buffer(Json.obj(("foo","bar")), Json.obj(("juu",3)))
    nullableTCK.methodWithNullableListJsonObjectParam(true, None)
    nullableTCK.methodWithNullableListJsonObjectParam(false, Option(testListJsonObject))
    nullableTCK.methodWithNullableListJsonObjectHandler(true,b => assert(testListJsonObject == b))
    nullableTCK.methodWithNullableListJsonObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListJsonObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListJsonObject.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListJsonObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListJsonObjectReturn(true)
    nullableTCK.methodWithNullableListJsonObjectReturn(false)
  }

  "testNullableListJsonArray" should "work" in {
    import collection.JavaConverters._
    val testListJsonArray = mutable.Buffer(Json.arr("foo","bar"), Json.arr("juu"))
    nullableTCK.methodWithNullableListJsonArrayParam(true, None)
    nullableTCK.methodWithNullableListJsonArrayParam(false, Option(testListJsonArray))
    nullableTCK.methodWithNullableListJsonArrayHandler(true,b => assert(testListJsonArray == b))
    nullableTCK.methodWithNullableListJsonArrayHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListJsonArrayHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListJsonArray.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListJsonArrayHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListJsonArrayReturn(true)
    nullableTCK.methodWithNullableListJsonArrayReturn(false)
  }

  "testNullableListApi" should "work" in {
    import collection.JavaConverters._
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testListApi = mutable.Buffer(RefedInterface1(iface))
    nullableTCK.methodWithNullableListApiParam(true, None)
    nullableTCK.methodWithNullableListApiParam(false, Option(testListApi))
    nullableTCK.methodWithNullableListApiHandler(true,b => assert(b.forall(a => a.asJava == iface)))
    nullableTCK.methodWithNullableListApiHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListApiHandlerAsyncResultFuture(true).foreach(b => {w{assert(b.forall(a => a.asJava == iface))}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListApiHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListApiReturn(true)
    nullableTCK.methodWithNullableListApiReturn(false)
  }

  "testNullableListDataObject" should "work" in {
    import collection.JavaConverters._
    val json = Json.obj(("foo","foo_value"), ("bar",12345), ("wibble",5.6))
    val testListDataObject = mutable.Buffer(TestDataObject.fromJson(json))
    nullableTCK.methodWithNullableListDataObjectParam(true, None)
    nullableTCK.methodWithNullableListDataObjectParam(false, Option(testListDataObject))
    nullableTCK.methodWithNullableListDataObjectHandler(true,b => assert(b.forall(a => a.asJava.toJson == json)))
    nullableTCK.methodWithNullableListDataObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListDataObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListDataObject.forall(a => a.asJava.toJson == Json.obj(("foo","foo_value"), ("bar",12345), ("wibble",5.6))))}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListDataObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListDataObjectReturn(true)
    nullableTCK.methodWithNullableListDataObjectReturn(false)
  }

  "testNullableListEnum" should "work" in {
    import collection.JavaConverters._
    val testListEnum = mutable.Buffer(TestEnum.TIM, TestEnum.JULIEN)
    nullableTCK.methodWithNullableListEnumParam(true, None)
    nullableTCK.methodWithNullableListEnumParam(false, Option(testListEnum))
    nullableTCK.methodWithNullableListEnumHandler(true,b => assert(testListEnum == b))
    nullableTCK.methodWithNullableListEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListEnum.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListEnumReturn(true)
    nullableTCK.methodWithNullableListEnumReturn(false)
  }

  "testNullableListGenEnum" should "work" in {
    import collection.JavaConverters._
    val testListGenEnum = mutable.Buffer(TestGenEnum.BOB, TestGenEnum.LELAND)
    nullableTCK.methodWithNullableListGenEnumParam(true, None)
    nullableTCK.methodWithNullableListGenEnumParam(false, Option(testListGenEnum))
    nullableTCK.methodWithNullableListGenEnumHandler(true,b => assert(testListGenEnum == b))
    nullableTCK.methodWithNullableListGenEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableListGenEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testListGenEnum.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableListGenEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableListGenEnumReturn(true)
    nullableTCK.methodWithNullableListGenEnumReturn(false)
  }











  "testNullableSetByte" should "work" in {
    import collection.JavaConverters._
    val testSetByte = Set(12.toByte,24.toByte,(-12).toByte)
    nullableTCK.methodWithNullableSetByteParam(true, None)
    nullableTCK.methodWithNullableSetByteParam(false, Option(testSetByte))
    nullableTCK.methodWithNullableSetByteHandler(true,b => assert(testSetByte == b))
    nullableTCK.methodWithNullableSetByteHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetByteHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetByte.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetByteHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetByteReturn(true)
    nullableTCK.methodWithNullableSetByteReturn(false)
  }

  "testNullableSetShort" should "work" in {
    import collection.JavaConverters._
    val testSetShort = Set(520.toShort,1040.toShort,(-520).toShort)
    nullableTCK.methodWithNullableSetShortParam(true, None)
    nullableTCK.methodWithNullableSetShortParam(false, Option(testSetShort))
    nullableTCK.methodWithNullableSetShortHandler(true,b => assert(testSetShort == b))
    nullableTCK.methodWithNullableSetShortHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetShortHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetShort.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetShortHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetShortReturn(true)
    nullableTCK.methodWithNullableSetShortReturn(false)
  }

  "testNullableSetInteger" should "work" in {
    import collection.JavaConverters._
    val testSetInteger = Set(12345,54321,-12345)
    nullableTCK.methodWithNullableSetIntegerParam(true, None)
    nullableTCK.methodWithNullableSetIntegerParam(false, Option(testSetInteger))
    nullableTCK.methodWithNullableSetIntegerHandler(true,b => assert(testSetInteger == b))
    nullableTCK.methodWithNullableSetIntegerHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetIntegerHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetInteger.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetIntegerHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetIntegerReturn(true)
    nullableTCK.methodWithNullableSetIntegerReturn(false)
  }

  "testNullableSetLong" should "work" in {
    import collection.JavaConverters._
    val testSetLong = Set(123456789l,987654321l,-123456789l)
    nullableTCK.methodWithNullableSetLongParam(true, None)
    nullableTCK.methodWithNullableSetLongParam(false, Option(testSetLong))
    nullableTCK.methodWithNullableSetLongHandler(true,b => assert(testSetLong == b))
    nullableTCK.methodWithNullableSetLongHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetLongHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetLong.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetLongHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetLongReturn(true)
    nullableTCK.methodWithNullableSetLongReturn(false)
  }

  "testNullableSetFloat" should "work" in {
    import collection.JavaConverters._
    val testSetFloat = Set(1.1f,2.2f,3.3f)
    nullableTCK.methodWithNullableSetFloatParam(true, None)
    nullableTCK.methodWithNullableSetFloatParam(false, Option(testSetFloat))
    nullableTCK.methodWithNullableSetFloatHandler(true,b => assert(testSetFloat == b))
    nullableTCK.methodWithNullableSetFloatHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetFloatHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetFloat.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetFloatHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetFloatReturn(true)
    nullableTCK.methodWithNullableSetFloatReturn(false)
  }

  "testNullableSetDouble" should "work" in {
    import collection.JavaConverters._
    val testSetDouble = Set(1.11,2.22,3.33)
    nullableTCK.methodWithNullableSetDoubleParam(true, None)
    nullableTCK.methodWithNullableSetDoubleParam(false, Option(testSetDouble))
    nullableTCK.methodWithNullableSetDoubleHandler(true,b => assert(testSetDouble == b))
    nullableTCK.methodWithNullableSetDoubleHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetDoubleHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetDouble.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetDoubleHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetDoubleReturn(true)
    nullableTCK.methodWithNullableSetDoubleReturn(false)
  }

  "testNullableSetBoolean" should "work" in {
    import collection.JavaConverters._
    val testSetBoolean = Set( true,false,true)
    nullableTCK.methodWithNullableSetBooleanParam(true, None)
    nullableTCK.methodWithNullableSetBooleanParam(false, Option(testSetBoolean))
    nullableTCK.methodWithNullableSetBooleanHandler(true,b => assert(testSetBoolean == b))
    nullableTCK.methodWithNullableSetBooleanHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetBooleanHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetBoolean.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetBooleanHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetBooleanReturn(true)
    nullableTCK.methodWithNullableSetBooleanReturn(false)
  }

  "testNullableSetString" should "work" in {
    import collection.JavaConverters._
    val testSetString = Set("first","second","third")
    nullableTCK.methodWithNullableSetStringParam(true, None)
    nullableTCK.methodWithNullableSetStringParam(false, Option(testSetString))
    nullableTCK.methodWithNullableSetStringHandler(true,b => assert(testSetString == b))
    nullableTCK.methodWithNullableSetStringHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetStringHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetString.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetStringHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetStringReturn(true)
    nullableTCK.methodWithNullableSetStringReturn(false)
  }

  "testNullableSetChar" should "work" in {
    import collection.JavaConverters._
    val testSetChar = Set('x','y','z')
    nullableTCK.methodWithNullableSetCharParam(true, None)
    nullableTCK.methodWithNullableSetCharParam(false, Option(testSetChar))
    nullableTCK.methodWithNullableSetCharHandler(true,b => assert(testSetChar == b))
    nullableTCK.methodWithNullableSetCharHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetCharHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetChar.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetCharHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetCharReturn(true)
    nullableTCK.methodWithNullableSetCharReturn(false)
  }

  "testNullableSetJsonObject" should "work" in {
    import collection.JavaConverters._
    val testSetJsonObject = Set(Json.obj(("foo","bar")), Json.obj(("juu",3)))
    nullableTCK.methodWithNullableSetJsonObjectParam(true, None)
    nullableTCK.methodWithNullableSetJsonObjectParam(false, Option(testSetJsonObject))
    nullableTCK.methodWithNullableSetJsonObjectHandler(true,b => assert(testSetJsonObject == b))
    nullableTCK.methodWithNullableSetJsonObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetJsonObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetJsonObject.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetJsonObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetJsonObjectReturn(true)
    nullableTCK.methodWithNullableSetJsonObjectReturn(false)
  }

  "testNullableSetJsonArray" should "work" in {
    import collection.JavaConverters._
    val testSetJsonArray = Set(Json.arr("foo","bar"), Json.arr("juu"))
    nullableTCK.methodWithNullableSetJsonArrayParam(true, None)
    nullableTCK.methodWithNullableSetJsonArrayParam(false, Option(testSetJsonArray))
    nullableTCK.methodWithNullableSetJsonArrayHandler(true,b => assert(testSetJsonArray == b))
    nullableTCK.methodWithNullableSetJsonArrayHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetJsonArrayHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetJsonArray.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetJsonArrayHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetJsonArrayReturn(true)
    nullableTCK.methodWithNullableSetJsonArrayReturn(false)
  }

  "testNullableSetApi" should "work" in {
    import collection.JavaConverters._
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testSetApi = Set(RefedInterface1(iface))
    nullableTCK.methodWithNullableSetApiParam(true, None)
    nullableTCK.methodWithNullableSetApiParam(false, Option(testSetApi))
    nullableTCK.methodWithNullableSetApiHandler(true,b => assert(b.forall(a => a.asJava == iface)))
    nullableTCK.methodWithNullableSetApiHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetApiHandlerAsyncResultFuture(true).foreach(b => {w{assert(b.forall(a => a.asJava == iface))}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetApiHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetApiReturn(true)
    nullableTCK.methodWithNullableSetApiReturn(false)
  }

  "testNullableSetDataObject" should "work" in {
    import collection.JavaConverters._
    val json = Json.obj(("foo","foo_value"), ("bar",12345), ("wibble",5.6))
    val testSetDataObject = Set(TestDataObject.fromJson(json))
    nullableTCK.methodWithNullableSetDataObjectParam(true, None)
    nullableTCK.methodWithNullableSetDataObjectParam(false, Option(testSetDataObject))
    nullableTCK.methodWithNullableSetDataObjectHandler(true,b => assert(b.forall(a => a.asJava.toJson == json)))
    nullableTCK.methodWithNullableSetDataObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetDataObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetDataObject.forall(a => a.asJava.toJson == Json.obj(("foo","foo_value"), ("bar",12345), ("wibble",5.6))))}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetDataObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetDataObjectReturn(true)
    nullableTCK.methodWithNullableSetDataObjectReturn(false)
  }

  "testNullableSetEnum" should "work" in {
    import collection.JavaConverters._
    val testSetEnum = Set(TestEnum.TIM, TestEnum.JULIEN)
    nullableTCK.methodWithNullableSetEnumParam(true, None)
    nullableTCK.methodWithNullableSetEnumParam(false, Option(testSetEnum))
    nullableTCK.methodWithNullableSetEnumHandler(true,b => assert(testSetEnum == b))
    nullableTCK.methodWithNullableSetEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetEnum.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetEnumReturn(true)
    nullableTCK.methodWithNullableSetEnumReturn(false)
  }

  "testNullableSetGenEnum" should "work" in {
    import collection.JavaConverters._
    val testSetGenEnum = Set(TestGenEnum.BOB, TestGenEnum.LELAND)
    nullableTCK.methodWithNullableSetGenEnumParam(true, None)
    nullableTCK.methodWithNullableSetGenEnumParam(false, Option(testSetGenEnum))
    nullableTCK.methodWithNullableSetGenEnumHandler(true,b => assert(testSetGenEnum == b))
    nullableTCK.methodWithNullableSetGenEnumHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableSetGenEnumHandlerAsyncResultFuture(true).foreach(b => {w{assert(testSetGenEnum.diff(b).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableSetGenEnumHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableSetGenEnumReturn(true)
    nullableTCK.methodWithNullableSetGenEnumReturn(false)
  }














  "testNullableMapByte" should "work" in {
    import collection.JavaConverters._
    val testMapByte = Map("1" -> 1.toByte, "2" -> 2.toByte, "3" -> 3.toByte)
    nullableTCK.methodWithNullableMapByteParam(true, None)
    nullableTCK.methodWithNullableMapByteParam(false, Option(testMapByte))
    nullableTCK.methodWithNullableMapByteHandler(true,b => assert(testMapByte == b))
    nullableTCK.methodWithNullableMapByteHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapByteHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapByte.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapByteHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapByteReturn(true)
    nullableTCK.methodWithNullableMapByteReturn(false)
  }

  "testNullableMapShort" should "work" in {
    import collection.JavaConverters._
    val testMapShort = Map("1" -> 1.toShort, "2" -> 2.toShort, "3" -> 3.toShort)
    nullableTCK.methodWithNullableMapShortParam(true, None)
    nullableTCK.methodWithNullableMapShortParam(false, Option(testMapShort))
    nullableTCK.methodWithNullableMapShortHandler(true,b => assert(testMapShort == b))
    nullableTCK.methodWithNullableMapShortHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapShortHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapShort.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapShortHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapShortReturn(true)
    nullableTCK.methodWithNullableMapShortReturn(false)
  }

  "testNullableMapInteger" should "work" in {
    import collection.JavaConverters._
    val testMapInteger = Map("1" -> 1,"2" -> 2, "3" -> 3)
    nullableTCK.methodWithNullableMapIntegerParam(true, None)
    nullableTCK.methodWithNullableMapIntegerParam(false, Option(testMapInteger))
    nullableTCK.methodWithNullableMapIntegerHandler(true,b => assert(testMapInteger == b))
    nullableTCK.methodWithNullableMapIntegerHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapIntegerHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapInteger.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapIntegerHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapIntegerReturn(true)
    nullableTCK.methodWithNullableMapIntegerReturn(false)
  }

  "testNullableMapLong" should "work" in {
    import collection.JavaConverters._
    val testMapLong = Map("1" -> 1l, "2" -> 2l, "3" -> 3l)
    nullableTCK.methodWithNullableMapLongParam(true, None)
    nullableTCK.methodWithNullableMapLongParam(false, Option(testMapLong))
    nullableTCK.methodWithNullableMapLongHandler(true,b => assert(testMapLong == b))
    nullableTCK.methodWithNullableMapLongHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapLongHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapLong.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapLongHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapLongReturn(true)
    nullableTCK.methodWithNullableMapLongReturn(false)
  }

  "testNullableMapFloat" should "work" in {
    import collection.JavaConverters._
    val testMapFloat = Map("1" -> 1.1f, "2" -> 2.2f, "3" -> 3.3f)
    nullableTCK.methodWithNullableMapFloatParam(true, None)
    nullableTCK.methodWithNullableMapFloatParam(false, Option(testMapFloat))
    nullableTCK.methodWithNullableMapFloatHandler(true,b => assert(testMapFloat == b))
    nullableTCK.methodWithNullableMapFloatHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapFloatHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapFloat.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapFloatHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapFloatReturn(true)
    nullableTCK.methodWithNullableMapFloatReturn(false)
  }

  "testNullableMapDouble" should "work" in {
    import collection.JavaConverters._
    val testMapDouble = Map("1" -> 1.11, "2" -> 2.22, "3" ->3.33)
    nullableTCK.methodWithNullableMapDoubleParam(true, None)
    nullableTCK.methodWithNullableMapDoubleParam(false, Option(testMapDouble))
    nullableTCK.methodWithNullableMapDoubleHandler(true,b => assert(testMapDouble == b))
    nullableTCK.methodWithNullableMapDoubleHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapDoubleHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapDouble.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapDoubleHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapDoubleReturn(true)
    nullableTCK.methodWithNullableMapDoubleReturn(false)
  }

  "testNullableMapBoolean" should "work" in {
    import collection.JavaConverters._
    val testMapBoolean = Map( "1" -> true, "2" -> false, "3" -> true)
    nullableTCK.methodWithNullableMapBooleanParam(true, None)
    nullableTCK.methodWithNullableMapBooleanParam(false, Option(testMapBoolean))
    nullableTCK.methodWithNullableMapBooleanHandler(true,b => assert(testMapBoolean == b))
    nullableTCK.methodWithNullableMapBooleanHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapBooleanHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapBoolean.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapBooleanHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapBooleanReturn(true)
    nullableTCK.methodWithNullableMapBooleanReturn(false)
  }

  "testNullableMapString" should "work" in {
    import collection.JavaConverters._
    val testMapString = Map("1" -> "first", "2" -> "second", "3" -> "third")
    nullableTCK.methodWithNullableMapStringParam(true, None)
    nullableTCK.methodWithNullableMapStringParam(false, Option(testMapString))
    nullableTCK.methodWithNullableMapStringHandler(true,b => assert(testMapString == b))
    nullableTCK.methodWithNullableMapStringHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapStringHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapString.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapStringHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapStringReturn(true)
    nullableTCK.methodWithNullableMapStringReturn(false)
  }

  "testNullableMapChar" should "work" in {
    import collection.JavaConverters._
    val testMapChar = Map("1" -> 'x', "2" -> 'y', "3" -> 'z')
    nullableTCK.methodWithNullableMapCharParam(true, None)
    nullableTCK.methodWithNullableMapCharParam(false, Option(testMapChar))
    nullableTCK.methodWithNullableMapCharHandler(true,b => assert(testMapChar == b))
    nullableTCK.methodWithNullableMapCharHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapCharHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapChar.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapCharHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapCharReturn(true)
    nullableTCK.methodWithNullableMapCharReturn(false)
  }

  "testNullableMapJsonObject" should "work" in {
    import collection.JavaConverters._
    val testMapJsonObject = Map("1" -> Json.obj(("foo","bar")), "2" -> Json.obj(("juu",3)))
    nullableTCK.methodWithNullableMapJsonObjectParam(true, None)
    nullableTCK.methodWithNullableMapJsonObjectParam(false, Option(testMapJsonObject))
    nullableTCK.methodWithNullableMapJsonObjectHandler(true,b => assert(testMapJsonObject == b))
    nullableTCK.methodWithNullableMapJsonObjectHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapJsonObjectHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapJsonObject.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapJsonObjectHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapJsonObjectReturn(true)
    nullableTCK.methodWithNullableMapJsonObjectReturn(false)
  }

  "testNullableMapJsonArray" should "work" in {
    import collection.JavaConverters._
    val testMapJsonArray:Map[String, JsonArray] = Map("2" -> Json.arr("juu"), "1" -> Json.arr("foo","bar"))
    nullableTCK.methodWithNullableMapJsonArrayParam(true, None)
    nullableTCK.methodWithNullableMapJsonArrayParam(false, Option(testMapJsonArray))
    nullableTCK.methodWithNullableMapJsonArrayHandler(true,b => assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty))
    nullableTCK.methodWithNullableMapJsonArrayHandler(false,b => assert(null == b))
    exec1(w => nullableTCK.methodWithNullableMapJsonArrayHandlerAsyncResultFuture(true).foreach(b => {w{assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    exec1(w => nullableTCK.methodWithNullableMapJsonArrayHandlerAsyncResultFuture(false).foreach(b => {w{assert(null == b)}; w.dismiss()}))
    nullableTCK.methodWithNullableMapJsonArrayReturn(true)
    nullableTCK.methodWithNullableMapJsonArrayReturn(false)
  }

  "testNullableMapApi" should "work" in {
    import collection.JavaConverters._
    val iface = new RefedInterface1Impl().setString("refed_is_here")
    val testMapApi = Map("1" -> RefedInterface1(iface))
    nullableTCK.methodWithNullableMapApiParam(true, None)
    nullableTCK.methodWithNullableMapApiParam(false, Option(testMapApi))
  }







//There is no meaningful way to implement these in Scala as primitve nulls aren't possible
//  shared test void testListNullableByte() => testListNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithListNullableByteParam, nullableTCK.methodWithListNullableByteHandler, nullableTCK.methodWithListNullableByteHandlerAsyncResult, nullableTCK.methodWithListNullableByteReturn);
//  shared test void testListNullableShort() => testListNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithListNullableShortParam, nullableTCK.methodWithListNullableShortHandler, nullableTCK.methodWithListNullableShortHandlerAsyncResult, nullableTCK.methodWithListNullableShortReturn);
//  shared test void testListNullableInteger() => testListNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithListNullableIntegerParam, nullableTCK.methodWithListNullableIntegerHandler, nullableTCK.methodWithListNullableIntegerHandlerAsyncResult, nullableTCK.methodWithListNullableIntegerReturn);
//  shared test void testListNullableLong() => testListNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithListNullableLongParam, nullableTCK.methodWithListNullableLongHandler, nullableTCK.methodWithListNullableLongHandlerAsyncResult, nullableTCK.methodWithListNullableLongReturn);
//  shared test void testListNullableFloat() => testListNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithListNullableFloatParam, nullableTCK.methodWithListNullableFloatHandler, nullableTCK.methodWithListNullableFloatHandlerAsyncResult, nullableTCK.methodWithListNullableFloatReturn, assertFloatEquals);
//  shared test void testListNullableDouble() => testListNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithListNullableDoubleParam, nullableTCK.methodWithListNullableDoubleHandler, nullableTCK.methodWithListNullableDoubleHandlerAsyncResult, nullableTCK.methodWithListNullableDoubleReturn, assertFloatEquals);
//  shared test void testListNullableBoolean() => testListNullable(ArrayList { true,null,false }, nullableTCK.methodWithListNullableBooleanParam, nullableTCK.methodWithListNullableBooleanHandler, nullableTCK.methodWithListNullableBooleanHandlerAsyncResult, nullableTCK.methodWithListNullableBooleanReturn);
//  shared test void testListNullableChar() => testListNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithListNullableCharParam, nullableTCK.methodWithListNullableCharHandler, nullableTCK.methodWithListNullableCharHandlerAsyncResult, nullableTCK.methodWithListNullableCharReturn);


  "testListNullableString" should "work" in {
    import collection.JavaConverters._
    val testListString:mutable.Buffer[String] = mutable.Buffer("first",null,"third")
    nullableTCK.methodWithListNullableStringParam(testListString)
    nullableTCK.methodWithListNullableStringHandler(b => assert(testListString.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableStringHandlerAsyncResultFuture().foreach(b => {w{assert(testListString.diff(b).isEmpty)}; w.dismiss()}))
    assert(testListString == nullableTCK.methodWithListNullableStringReturn())
  }

  "testListNullableJsonObject" should "work" in {
    import collection.JavaConverters._
    val testListJsonObject:mutable.Buffer[JsonObject] = mutable.Buffer(Json.obj(("foo","bar")), null, Json.obj(("juu",3)))
    nullableTCK.methodWithListNullableJsonObjectParam(testListJsonObject)
    nullableTCK.methodWithListNullableJsonObjectHandler(b => assert(testListJsonObject.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {w{assert(testListJsonObject.diff(b).isEmpty)}; w.dismiss()}))
    assert(testListJsonObject == nullableTCK.methodWithListNullableJsonObjectReturn())
  }

  "testListNullableJsonArray" should "work" in {
    import collection.JavaConverters._
    val testListJsonArray:mutable.Buffer[JsonArray] = mutable.Buffer(Json.arr("foo","bar"), null, Json.arr("juu"))
    nullableTCK.methodWithListNullableJsonArrayParam(testListJsonArray)
    nullableTCK.methodWithListNullableJsonArrayHandler(b => assert(testListJsonArray.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {w{assert(testListJsonArray.diff(b).isEmpty)}; w.dismiss()}))
    assert(testListJsonArray == nullableTCK.methodWithListNullableJsonArrayReturn())
  }

  "testListNullableApi" should "work" ignore {
    import collection.JavaConverters._
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testListApi:mutable.Buffer[RefedInterface1] = mutable.Buffer(RefedInterface1(iface1), null, RefedInterface1(iface2))
    nullableTCK.methodWithListNullableApiParam(testListApi)
    nullableTCK.methodWithListNullableApiHandler(b => assert(testListApi.map(x => refedIfaceToJavaOrNull(x)) == b.map(x => refedIfaceToJavaOrNull(x))))
    exec1(w => nullableTCK.methodWithListNullableApiHandlerAsyncResultFuture().foreach(b => {w{assert(testListApi.map(x => refedIfaceToJavaOrNull(x)).diff(b.map(a => refedIfaceToJavaOrNull(a))).isEmpty)}; w.dismiss()}))
    assert(testListApi.map(x => refedIfaceToJavaOrNull(x)) == nullableTCK.methodWithListNullableApiReturn().map(x => refedIfaceToJavaOrNull(x)))
  }

  "testListNullableDataObject" should "work" in {
    import collection.JavaConverters._
    val json1 = Json.obj(("foo","first"), ("bar",1), ("wibble",1.1))
    val json2 = Json.obj(("foo","third"), ("bar",3), ("wibble",3.3))
    val testListDataObject:mutable.Buffer[TestDataObject] = mutable.Buffer(TestDataObject.fromJson(json1), null, TestDataObject.fromJson(json2))
    nullableTCK.methodWithListNullableDataObjectParam(testListDataObject)
    nullableTCK.methodWithListNullableDataObjectHandler(b => assert(testListDataObject.map(x => dataObjectToJsonOrNull(x)) == b.map(x => dataObjectToJsonOrNull(x))))
    exec1(w => nullableTCK.methodWithListNullableDataObjectHandlerAsyncResultFuture().foreach(b => {w{assert(testListDataObject.map(x => dataObjectToJsonOrNull(x)) == b.map(x => dataObjectToJsonOrNull(x)))}; w.dismiss()}))
    assert(testListDataObject.map(x => dataObjectToJsonOrNull(x)) == nullableTCK.methodWithListNullableDataObjectReturn().map(x => dataObjectToJsonOrNull(x)))
  }

  "testListNullableGenEnum" should "work" in {
    import collection.JavaConverters._
    val testListGenEnum:mutable.Buffer[TestGenEnum] = mutable.Buffer(TestGenEnum.BOB,null,TestGenEnum.LELAND)
    nullableTCK.methodWithListNullableGenEnumParam(testListGenEnum)
    nullableTCK.methodWithListNullableGenEnumHandler(b => assert(testListGenEnum.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithListNullableGenEnumHandlerAsyncResultFuture().foreach(b => {w{assert(testListGenEnum.diff(b).isEmpty)}; w.dismiss()}))
    assert(testListGenEnum == nullableTCK.methodWithListNullableGenEnumReturn())
  }

  //There is no meaningful way to implement these in Scala as primitve nulls aren't possible
  //  shared test void testSetNullableByte() => testSetNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithSetNullableByteParam, nullableTCK.methodWithSetNullableByteHandler, nullableTCK.methodWithSetNullableByteHandlerAsyncResult, nullableTCK.methodWithSetNullableByteReturn);
//  shared test void testSetNullableShort() => testSetNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithSetNullableShortParam, nullableTCK.methodWithSetNullableShortHandler, nullableTCK.methodWithSetNullableShortHandlerAsyncResult, nullableTCK.methodWithSetNullableShortReturn);
//  shared test void testSetNullableInteger() => testSetNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithSetNullableIntegerParam, nullableTCK.methodWithSetNullableIntegerHandler, nullableTCK.methodWithSetNullableIntegerHandlerAsyncResult, nullableTCK.methodWithSetNullableIntegerReturn);
//  shared test void testSetNullableLong() => testSetNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithSetNullableLongParam, nullableTCK.methodWithSetNullableLongHandler, nullableTCK.methodWithSetNullableLongHandlerAsyncResult, nullableTCK.methodWithSetNullableLongReturn);
//  shared test void testSetNullableFloat() => testSetNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithSetNullableFloatParam, nullableTCK.methodWithSetNullableFloatHandler, nullableTCK.methodWithSetNullableFloatHandlerAsyncResult, nullableTCK.methodWithSetNullableFloatReturn, assertFloatEquals);
//  shared test void testSetNullableDouble() => testSetNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithSetNullableDoubleParam, nullableTCK.methodWithSetNullableDoubleHandler, nullableTCK.methodWithSetNullableDoubleHandlerAsyncResult, nullableTCK.methodWithSetNullableDoubleReturn, assertFloatEquals);
//  shared test void testSetNullableBoolean() => testSetNullable(ArrayList { true,null,false }, nullableTCK.methodWithSetNullableBooleanParam, nullableTCK.methodWithSetNullableBooleanHandler, nullableTCK.methodWithSetNullableBooleanHandlerAsyncResult, nullableTCK.methodWithSetNullableBooleanReturn);
//  shared test void testSetNullableChar() => testSetNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithSetNullableCharParam, nullableTCK.methodWithSetNullableCharHandler, nullableTCK.methodWithSetNullableCharHandlerAsyncResult, nullableTCK.methodWithSetNullableCharReturn);

  "testSetNullableString" should "work" in {
    import collection.JavaConverters._
    val testSetString:Set[String] = Set("first",null,"third")
    nullableTCK.methodWithSetNullableStringParam(testSetString)
    nullableTCK.methodWithSetNullableStringHandler(b => assert(testSetString.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableStringHandlerAsyncResultFuture().foreach(b => {w{assert(testSetString.diff(b).isEmpty)}; w.dismiss()}))
    assert(testSetString == nullableTCK.methodWithSetNullableStringReturn())
  }

  "testSetNullableJsonObject" should "work" in {
    import collection.JavaConverters._
    val testSetJsonObject:Set[JsonObject] = Set(Json.obj(("foo","bar")), null, Json.obj(("juu",3)))
    nullableTCK.methodWithSetNullableJsonObjectParam(testSetJsonObject)
    nullableTCK.methodWithSetNullableJsonObjectHandler(b => assert(testSetJsonObject.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {w{assert(testSetJsonObject.diff(b).isEmpty)}; w.dismiss()}))
    assert(testSetJsonObject == nullableTCK.methodWithSetNullableJsonObjectReturn())
  }

  "testSetNullableJsonArray" should "work" in {
    import collection.JavaConverters._
    val testSetJsonArray:Set[JsonArray] = Set(Json.arr("foo","bar"), null, Json.arr("juu"))
    nullableTCK.methodWithSetNullableJsonArrayParam(testSetJsonArray)
    nullableTCK.methodWithSetNullableJsonArrayHandler(b => assert(testSetJsonArray.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {w{assert(testSetJsonArray.diff(b).isEmpty)}; w.dismiss()}))
    assert(testSetJsonArray == nullableTCK.methodWithSetNullableJsonArrayReturn())
  }

  "testSetNullableApi" should "work" in {
    import collection.JavaConverters._
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testSetApi:Set[RefedInterface1] = Set(RefedInterface1(iface1), null, RefedInterface1(iface2))
    //TODO: RefedInterface1Impl needs a nullsafe equals method!
//    nullableTCK.methodWithSetNullableApiParam(testSetApi)
//    nullableTCK.methodWithSetNullableApiHandler(b => assert(testSetApi.map(x => refedIfaceToJavaOrNull(x)) == b.map(x => refedIfaceToJavaOrNull(x))))
//    exec1(w => nullableTCK.methodWithSetNullableApiHandlerAsyncResultFuture().foreach(b => {w{assert(testSetApi.map(x => refedIfaceToJavaOrNull(x)).asJava == b)}; w.dismiss()}))
//    assert(testSetApi.map(x => refedIfaceToJavaOrNull(x)) == nullableTCK.methodWithSetNullableApiReturn().map(x => refedIfaceToJavaOrNull(x)))
  }

  "testSetNullableDataObject" should "work" in {
    import collection.JavaConverters._
    val json1 = Json.obj(("foo","first"), ("bar",1), ("wibble",1.1))
    val json2 = Json.obj(("foo","third"), ("bar",3), ("wibble",3.3))
    val testSetDataObject:Set[TestDataObject] = Set(TestDataObject.fromJson(json1), null, TestDataObject.fromJson(json2))
    nullableTCK.methodWithSetNullableDataObjectParam(testSetDataObject)
    nullableTCK.methodWithSetNullableDataObjectHandler(b => assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x)) == b.map(x => dataObjectToJsonOrNull(x))))
    exec1(w => nullableTCK.methodWithSetNullableDataObjectHandlerAsyncResultFuture().foreach(b => {w{assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x)) == b.map(x => dataObjectToJsonOrNull(x)))}; w.dismiss()}))
    assert(testSetDataObject.map(x => dataObjectToJsonOrNull(x)) == nullableTCK.methodWithSetNullableDataObjectReturn().map(x => dataObjectToJsonOrNull(x)))
  }



  "testSetNullableGenEnum" should "work" in {
    import collection.JavaConverters._
    val testSetGenEnum:Set[TestGenEnum] = Set(TestGenEnum.BOB,null,TestGenEnum.LELAND)
    nullableTCK.methodWithSetNullableGenEnumParam(testSetGenEnum)
    nullableTCK.methodWithSetNullableGenEnumHandler(b => assert(testSetGenEnum.diff(b).isEmpty))
    exec1(w => nullableTCK.methodWithSetNullableGenEnumHandlerAsyncResultFuture().foreach(b => {w{assert(testSetGenEnum.diff(b).isEmpty)}; w.dismiss()}))
    assert(testSetGenEnum == nullableTCK.methodWithSetNullableGenEnumReturn())
  }

  //There is no meaningful way to implement these in Scala as primitve nulls aren't possible
//  shared test void testMapNullableByte() => testMapNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithMapNullableByteParam, nullableTCK.methodWithMapNullableByteHandler, nullableTCK.methodWithMapNullableByteHandlerAsyncResult, nullableTCK.methodWithMapNullableByteReturn);
//  shared test void testMapNullableShort() => testMapNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithMapNullableShortParam, nullableTCK.methodWithMapNullableShortHandler, nullableTCK.methodWithMapNullableShortHandlerAsyncResult, nullableTCK.methodWithMapNullableShortReturn);
//  shared test void testMapNullableInteger() => testMapNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithMapNullableIntegerParam, nullableTCK.methodWithMapNullableIntegerHandler, nullableTCK.methodWithMapNullableIntegerHandlerAsyncResult, nullableTCK.methodWithMapNullableIntegerReturn);
//  shared test void testMapNullableLong() => testMapNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithMapNullableLongParam, nullableTCK.methodWithMapNullableLongHandler, nullableTCK.methodWithMapNullableLongHandlerAsyncResult, nullableTCK.methodWithMapNullableLongReturn);
//  shared test void testMapNullableFloat() => testMapNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithMapNullableFloatParam, nullableTCK.methodWithMapNullableFloatHandler, nullableTCK.methodWithMapNullableFloatHandlerAsyncResult, nullableTCK.methodWithMapNullableFloatReturn, assertFloatEquals);
//  shared test void testMapNullableDouble() => testMapNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithMapNullableDoubleParam, nullableTCK.methodWithMapNullableDoubleHandler, nullableTCK.methodWithMapNullableDoubleHandlerAsyncResult, nullableTCK.methodWithMapNullableDoubleReturn, assertFloatEquals);
//  shared test void testMapNullableBoolean() => testMapNullable(ArrayList { true, null, false }, nullableTCK.methodWithMapNullableBooleanParam, nullableTCK.methodWithMapNullableBooleanHandler, nullableTCK.methodWithMapNullableBooleanHandlerAsyncResult, nullableTCK.methodWithMapNullableBooleanReturn);
//  shared test void testMapNullableChar() => testMapNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithMapNullableCharParam, nullableTCK.methodWithMapNullableCharHandler, nullableTCK.methodWithMapNullableCharHandlerAsyncResult, nullableTCK.methodWithMapNullableCharReturn);

  "testMapNullableString" should "work" in {
    import collection.JavaConverters._
    val testMapString:Map[String, String] = Map("1" -> "first","2" -> null, "3" -> "third")
    nullableTCK.methodWithMapNullableStringParam(testMapString)
    nullableTCK.methodWithMapNullableStringHandler(b => assert(testMapString.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableStringHandlerAsyncResultFuture().foreach(b => {w{assert(testMapString.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    assert(testMapString == nullableTCK.methodWithMapNullableStringReturn())
  }

  "testMapNullableJsonObject" should "work" in {
    import collection.JavaConverters._
    val testMapJsonObject:Map[String, JsonObject] = Map("1" -> Json.obj(("foo","bar")), "2" -> null, "3" -> Json.obj(("juu",3)))
    nullableTCK.methodWithMapNullableJsonObjectParam(testMapJsonObject)
    nullableTCK.methodWithMapNullableJsonObjectHandler(b => assert(testMapJsonObject.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableJsonObjectHandlerAsyncResultFuture().foreach(b => {w{assert(testMapJsonObject.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    assert(testMapJsonObject == nullableTCK.methodWithMapNullableJsonObjectReturn())
  }

  "testMapNullableJsonArray" should "work" in {
    import collection.JavaConverters._
    val testMapJsonArray:Map[String, JsonArray] = Map("1" -> Json.arr("foo","bar"), "2" -> null, "3" -> Json.arr("juu"))
    nullableTCK.methodWithMapNullableJsonArrayParam(testMapJsonArray)
    nullableTCK.methodWithMapNullableJsonArrayHandler(b => assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty))
    exec1(w => nullableTCK.methodWithMapNullableJsonArrayHandlerAsyncResultFuture().foreach(b => {w{assert(testMapJsonArray.toSet.diff(b.toSet).isEmpty)}; w.dismiss()}))
    assert(testMapJsonArray == nullableTCK.methodWithMapNullableJsonArrayReturn())
  }

  "testMapNullableApi" should "work" in {
    import collection.JavaConverters._
    val iface1 = new RefedInterface1Impl().setString("first")
    val iface2 = new RefedInterface1Impl().setString("third")
    val testMapApi:Map[String, RefedInterface1] = Map("1" -> RefedInterface1(iface1), "2" -> null, "3" -> RefedInterface1(iface2))
    nullableTCK.methodWithMapNullableApiParam(testMapApi)
  }

  "testNullableHandler" should "work" in {
    nullableTCK.methodWithNullableHandler(true,null)
    exec1(w => nullableTCK.methodWithNullableHandler(false,a => {w{assert("the_string_value" == a)};w.dismiss()}))
    //Test makes no sense as the handlers are created inside the method => vertx-lang-scala specific
    //exec1(w => nullableTCK.methodWithNullableHandlerAsyncResultFuture(true))
    exec1(w => nullableTCK.methodWithNullableHandlerAsyncResultFuture(false).foreach(a => {w{assert("the_string_value" == a)};w.dismiss()}))
  }

  "testHttpServerOptionsJson" should "work" in {
    val json = Json.obj(("compressionSupported", true), ("ssl",true), ("sendBufferSize", 65000))
    val options = new HttpServerOptions().setCompressionSupported(true).setSsl(true).setSendBufferSize(65000)
    val actualOptions =  new HttpServerOptions(json)
    assert(actualOptions.isCompressionSupported == options.isCompressionSupported)
    assert(actualOptions.isSsl == options.isSsl)
    assert(actualOptions.getSendBufferSize == options.getSendBufferSize)
  }

  def dataObjectToJsonOrNull(x: TestDataObject): JsonObject = {
    if(x!=null) x.asJava.toJson else null
  }

  def refedIfaceToJavaOrNull(x: RefedInterface1):io.vertx.codegen.testmodel.RefedInterface1 = {
    if( x!= null) x.asJava else null
  }
}
