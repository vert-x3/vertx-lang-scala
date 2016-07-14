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
import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.core.{Future, VertxException}
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json.arr
import io.vertx.scala.codegen.testmodel.{ConcreteHandlerUserTypeExtension, Factory, RefedInterface1, TestInterface}
import org.junit.ComparisonFailure
import org.junit.runner.RunWith
import org.scalatest.concurrent.AsyncAssertions._
import org.scalatest.concurrent.AsyncAssertions.Waiter
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.duration.DurationLong

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class ApiTest extends FlatSpec with Matchers {

  val obj = TestInterface(new TestInterfaceImpl())

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
    obj.methodWithHandlerAsyncResultByte(false, b => assert(123 == b.result()))
    obj.methodWithHandlerAsyncResultShort(false, s => assert(12345 == s.result()))
    obj.methodWithHandlerAsyncResultInteger(false, i => assert(1234567 == i.result()))
    obj.methodWithHandlerAsyncResultLong(false, l => assert(1265615234l == l.result()))
    obj.methodWithHandlerAsyncResultFloat(false, f => assert(12.345f == f.result()))
    obj.methodWithHandlerAsyncResultDouble(false, d => assert(12.34566d == d.result()))
    obj.methodWithHandlerAsyncResultBoolean(false, b => assert(true == b.result()))
    obj.methodWithHandlerAsyncResultCharacter(false, c => assert('X' == c.result()))
    obj.methodWithHandlerAsyncResultString(false, s => assert("quux!" == s.result()))

    obj.methodWithHandlerAsyncResultByte(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultShort(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultInteger(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultLong(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultFloat(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultDouble(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultBoolean(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultCharacter(true, r => assert(r.cause().getMessage == "foobar!"))
    obj.methodWithHandlerAsyncResultString(true, r => assert(r.cause().getMessage == "foobar!"))

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
    obj.methodWithDataObjectParam(new TestDataObject().setBar(123).setFoo("hello").setWibble(1.23))
  }

  "testListOfDataObjectsParam" should "work" in {
    obj.methodWithListOfDataObjectsParam(List(new TestDataObject().setBar(123).setFoo("hello").setWibble(1.23), new TestDataObject().setBar(123).setFoo("world").setWibble(1.23)))
  }

  "testSetOfDataObjectsParam" should "work" in {
    obj.methodWithSetOfDataObjectsParam(Set(new TestDataObject().setBar(123).setFoo("hello").setWibble(1.23), new TestDataObject().setBar(123).setFoo("world").setWibble(1.23)))
  }

  "testNullDataObjectParam" should "work" in {
    obj.methodWithNullDataObjectParam(null)
  }

  "testMethodWithHandlerDataObject" should "work" in {
    val dataObject = new TestDataObject()
    dataObject.setFoo("foo")
    dataObject.setBar(123)

    val w = new Waiter
    obj.methodWithHandlerDataObject(it => {
      w {
        assert(dataObject.getFoo == it.getFoo)
        assert(dataObject.getBar == it.getBar)
      }
      w.dismiss()
    })
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultDataObject" should "work" in {
    val dataObject = new TestDataObject()
    dataObject.setFoo("foo")
    dataObject.setBar(123)

    val w = new Waiter
    obj.methodWithHandlerAsyncResultDataObject(false, result => {
      w {
        assert(result.succeeded())
        assert(!result.failed())
        val res = result.result()
        assert(dataObject.getFoo == res.getFoo)
        assert(dataObject.getBar == res.getBar)
        assert(null == result.cause())
      }
      w.dismiss()
    })
    w.await(timeout(50 millis))
    val w2 = new Waiter
    obj.methodWithHandlerAsyncResultDataObject(true, result => {
      w2 {
        assert(result.failed())
        assert("foobar!" == result.cause().getMessage)
      }
      w2.dismiss()
    })
    w2.await(timeout(50 millis))
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
    val w = new Waiter
    def stringHandler = obj.methodWithHandlerAsyncResultGenericReturn[String](ar =>
       {w { assert("the-result" == ar.result()) };w.dismiss()})
    stringHandler(Future.succeededFuture("the-result"))
    w.await(timeout(50 millis))

    val w2 = new Waiter
    def objHandler = obj.methodWithHandlerAsyncResultGenericReturn[TestInterface](ar =>
      { w2 { assert(obj == ar.result())}; w2.dismiss()} )
    objHandler(Future.succeededFuture(obj))
    w2.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultVertxGenReturn" should "work" in {
    var handler = obj.methodWithHandlerAsyncResultVertxGenReturn("wibble", false)
    handler(Future.succeededFuture(RefedInterface1(new RefedInterface1Impl().setString("wibble")).asJava))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListString(it => {w {assert(List("foo", "bar", "wibble").asJava == it.result())}; w.dismiss()})
    obj.methodWithHandlerAsyncResultListInteger(it => {w {assert(List(5, 12, 100).asJava == it.result())}; w.dismiss()})
    obj.methodWithHandlerAsyncResultSetString(it => {w {assert(Set("foo", "bar", "wibble").asJava == it.result())}; w.dismiss()})
    obj.methodWithHandlerAsyncResultSetInteger(it => {w {assert(Set(5, 12, 100).asJava == it.result())}; w.dismiss()})
    w.await(timeout(50 millis), dismissals(4))
  }

  "testMethodWithHandlerListVertxGen" should "work" in {
    obj.methodWithHandlerListVertxGen(it => assert(it.map(_.getString()) == List("foo", "bar")))
  }

  "testMethodWithHandlerListAbstractVertxGen" should "work" in {
    obj.methodWithHandlerListAbstractVertxGen(it => assert(it.map(_.getString()) == List("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultListVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListVertxGen(it => { w {assert(it.result().map(_.getString()) == ArrayBuffer("foo", "bar"))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListAbstractVertxGen(it => { w {assert(it.result().map(_.getString()) == ArrayBuffer("abstractfoo", "abstractbar"))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerSetVertxGen" should "work" in {
    obj.methodWithHandlerSetVertxGen(it => assert(it.map(_.getString()) == Set("bar", "foo")))
  }

  "testMethodWithHandlerSetAbstractVertxGen" should "work" in {
    obj.methodWithHandlerSetAbstractVertxGen(it => assert(it.map(_.getString()) == Set("abstractfoo", "abstractbar")))
  }

  "testMethodWithHandlerAsyncResultSetVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetVertxGen(it => { w {assert(it.result().map(_.getString()) == Set("bar", "foo"))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultSetAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetAbstractVertxGen(it => { w {assert(it.result().map(_.getString()) == Set("abstractbar", "abstractfoo"))}; w.dismiss()})
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListJsonObject(it => { w {assert(List(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListNullJsonObject(it => { w {assert(List(null).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListComplexJsonObject(it => { w {assert(List(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetJsonObject(it => { w {assert(Set(Json.obj(("cheese", "stilton")), Json.obj(("socks", "tartan"))).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultSetNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetNullJsonObject(it => { w {assert(Set(null).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetComplexJsonObject(it => { w {assert(Set(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue")))).sameElements(it.result()))}; w.dismiss()})
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListJsonArray(it => { w {assert(it.result() == List(arr("green", "blue"), arr("yellow", "purple")).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListNullJsonArray" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListNullJsonArray(it => { w {assert(it.result() == List(null).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListComplexJsonArray(it => { w {assert(it.result() == List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye")))).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetJsonArray(it => { w {assert(it.result() == Set(arr("green", "blue"), arr("yellow", "purple")).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultNullSetJsonArray" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetNullJsonArray(it => { w {assert(it.result() == Set(null).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetComplexJsonArray(it => { w {assert(it.result() == Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye")))).asJava)}; w.dismiss()})
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultListDataObject" should "work" in {
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListDataObject(it => {
      w {
        assert("String 1" == it.result().get(0).getFoo)
        assert(1 == it.result().get(0).getBar)
        assert(1.1 == it.result().get(0).getWibble)

        assert("String 2" == it.result().get(1).getFoo)
        assert(2 == it.result().get(1).getBar)
        assert(2.2 == it.result().get(1).getWibble)
      }
      w.dismiss()
    })
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultNullListDataObject" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListNullDataObject(it => {
      w { assert(List(null).asJava == it.result()) }
      w.dismiss()
    })
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultSetDataObject" should "work" in {
    import collection.JavaConversions._
    val w = new Waiter
    var checkVar = 0
    obj.methodWithHandlerAsyncResultSetDataObject(it => {
      val coll = it.result()
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
    })
    w.await(timeout(50 millis))
    assert(checkVar == 0)
  }


  "testMethodWithHandlerAsyncResultNullSetDataObject" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetNullDataObject(it => {
      w{ assert(Set(null).asJava == it.result())}
      w.dismiss()
    })
    w.await(timeout(50 millis))
  }


  "testMethodWithHandlerUserTypes" should "work" in {
    obj.methodWithHandlerUserTypes(it => assert(it.getString == "echidnas"))
  }

  "testMethodWithHandlerAsyncResultUserTypes" should "work" in {
    val w = new Waiter
    obj.methodWithHandlerAsyncResultUserTypes(it => {
      w{assert(it.result.getString == "cheetahs")}
      w.dismiss()
    })
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultVoid(false, (res) => {
      w { assert(res.succeeded()) }
      w.dismiss()
    })
    w.await(timeout(50 millis))
  }

  "testMethodWithHandlerAsyncResultVoidFails" should "work" in {
    val w = new Waiter
    obj.methodWithHandlerAsyncResultVoid(true, (res) => {
      w {
        assert(res.failed())
        assert(res.cause().getMessage == "foo!")
      }
      w.dismiss()
    })
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultGenericUserType[String]("string_value_2", (res) => {
      w {assert(res.result.getValue == "string_value_2") }
      w.dismiss()
    })
    w.await(timeout(50 millis))
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
    val w = new Waiter
    obj.methodWithGenericHandlerAsyncResult[String]("String", (res) => { w {assert(res.result() == "foo")}; w.dismiss()})
    obj.methodWithGenericHandlerAsyncResult[io.vertx.codegen.testmodel.RefedInterface1]("Ref", (res) => { w {assert(res.result().getString == "bar")}; w.dismiss()})
    obj.methodWithGenericHandlerAsyncResult[JsonObject]("JsonObject", (res) => { w { assert(res.result() == Json.obj(("foo", "hello"), ("bar", 123)))}; w.dismiss()})
    obj.methodWithGenericHandlerAsyncResult[JsonArray]("JsonArray", (res) => { w { assert(res.result() == arr("foo", "bar", "wib"))}; w.dismiss()})
    obj.methodWithGenericHandlerAsyncResult[JsonObject]("JsonObjectComplex", (res) => { w {assert(res.result() == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that"))))}; w.dismiss()})
    w.await(timeout(50 millis), dismissals(5))
  }

  "testMethodListParams" should "work" in {
    val refed1 = new RefedInterface1(new RefedInterface1Impl())
    refed1.setString("foo")
    val refed2 = new RefedInterface1(new RefedInterface1Impl())
    refed2.setString("bar")

    obj.methodWithListParams(
      List("foo", "bar"),
      List(2.toByte, 3.toByte),
      List(12.toShort, 13.toShort),
      List(1234, 1345),
      List(123l, 456l),
      List(Json.obj(("foo", "bar")), Json.obj(("eek", "wibble"))),
      List(arr("foo"), arr("blah")),
      List(refed1, refed2),
      List(new TestDataObject().setBar(1).setWibble(1.1).setFoo("String 1"), new TestDataObject().setBar(2).setWibble(2.2).setFoo("String 2")),
      List(TestEnum.JULIEN, TestEnum.TIM))
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
      Set(new TestDataObject().setBar(1).setWibble(1.1).setFoo("String 1"), new TestDataObject().setBar(2).setWibble(2.2).setFoo("String 2")),
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultListEnum(it => { w{assert(it.result() == List(TestEnum.TIM, TestEnum.JULIEN).asJava)}; w.dismiss()})
    w.await(timeout(50 millis), dismissals(1))
  }

  "testMethodWithHandlerAsyncResultSetEnum" should "work" in {
    import collection.JavaConverters._
    val w = new Waiter
    obj.methodWithHandlerAsyncResultSetEnum(it => { w{assert(it.result() == Set(TestEnum.TIM, TestEnum.JULIEN).asJava)}; w.dismiss()})
    w.await(timeout(50 millis), dismissals(1))
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
    assert("meth2" == obj.overloadedMethod("cat", refed, 12345, it => {
      assert("giraffe" == it); counter += 1
    }))
    assert(counter == 1)
    assert("meth3" == obj.overloadedMethod("cat", it => {
      assert("giraffe" == it); counter += 1
    }))
    assert(counter == 2)
    assert("meth4" == obj.overloadedMethod("cat", refed, it => {
      assert("giraffe" == it); counter += 1
    }))
    assert(counter == 3)
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
    val w = new Waiter
    obj.methodWithHandlerAsyncResultJsonObject(it => {
      w{assert(Json.obj(("cheese", "stilton")) == it.result())}
      w.dismiss()
    })
    w.await(timeout(50 millis))
    val w2 = new Waiter
    obj.methodWithHandlerAsyncResultJsonArray(it => {
      w2{assert(arr("socks", "shoes") == it.result())}
      w2.dismiss()
    })
    w2.await(timeout(50 millis))
  }

  "testNullJsonHandlerAsyncResultParams" should "work" in {
    val w = new Waiter

    obj.methodWithHandlerAsyncResultNullJsonObject(it => {
      w{assert(null == it.result())}
      w.dismiss()
    })

    w.await(timeout(50 millis))
    val w2 = new Waiter
    obj.methodWithHandlerAsyncResultNullJsonArray(it => {
      w2{assert(null == it.result())}
      w2.dismiss()
    })

    w2.await(timeout(50 millis))
  }

  "testComplexJsonHandlerAsyncResultParams" should "work" in {
    val w = new Waiter

    obj.methodWithHandlerAsyncResultComplexJsonObject(it => {
      w{assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == it.result())}
      w.dismiss()
    })

    w.await(timeout(50 millis))
    val w2 = new Waiter
    obj.methodWithHandlerAsyncResultComplexJsonArray(it => {
      w{assert(arr(Json.obj(("foo", "hello")), Json.obj(("bar", "bye"))) == it.result())}
      w2.dismiss()
    })

    w2.await(timeout(50 millis))
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
}
