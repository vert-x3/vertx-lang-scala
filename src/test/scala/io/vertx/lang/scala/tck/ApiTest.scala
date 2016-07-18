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
import io.vertx.scala.codegen.testmodel
import io.vertx.scala.codegen.testmodel.{ConcreteHandlerUserTypeExtension, Factory, RefedInterface1, TestInterface}
import org.junit.ComparisonFailure
import org.junit.runner.RunWith
import org.scalatest.concurrent.AsyncAssertions._
import org.scalatest.concurrent.AsyncAssertions.Waiter
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable.ArrayBuffer
import scala.concurrent.duration.DurationLong
import scala.language.postfixOps

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
      obj.methodWithNullDataObjectParam(None)
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

  //NullableTCK

  val nullableTCK = testmodel.NullableTCK(new NullableTCKImpl)

  "testNullableByte" should "work" in {
    val testByte = 67.toByte
    nullableTCK.methodWithNullableByteParam(true, None)
    nullableTCK.methodWithNullableByteParam(false, Option(testByte))
    nullableTCK.methodWithNullableByteHandler(true, b => assert(testByte == b))
    //TODO: Missing @Nullable
//    nullableTCK.methodWithNullableByteHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableByteHandlerAsyncResult(true, b => {w{assert(testByte == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableByteHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableByteReturn(true)
    nullableTCK.methodWithNullableByteReturn(false)
  }

  "testNullableShort" should "work" in {
    val testShort = 1024.toShort
    nullableTCK.methodWithNullableShortParam(true, None)
    nullableTCK.methodWithNullableShortParam(false, Option(testShort))
    nullableTCK.methodWithNullableShortHandler(true, b => assert(testShort == b))
    //TODO: Missing @Nullable
//    nullableTCK.methodWithNullableShortHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableShortHandlerAsyncResult(true, b => {w{assert(testShort == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableShortHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableShortReturn(true)
    nullableTCK.methodWithNullableShortReturn(false)
  }

  "testNullableInteger" should "work" in {
    val testInteger = 1234567
    nullableTCK.methodWithNullableIntegerParam(true, None)
    nullableTCK.methodWithNullableIntegerParam(false, Option(testInteger))
    nullableTCK.methodWithNullableIntegerHandler(true, b => assert(testInteger == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableIntegerHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableIntegerHandlerAsyncResult(true, b => {w{assert(testInteger == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableIntegerHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableIntegerReturn(true)
    nullableTCK.methodWithNullableIntegerReturn(false)
  }

  "testNullableLong" should "work" in {
    val testLong = 9876543210l
    nullableTCK.methodWithNullableLongParam(true, None)
    nullableTCK.methodWithNullableLongParam(false, Option(testLong))
    nullableTCK.methodWithNullableLongHandler(true, b => assert(testLong == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableLongHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableLongHandlerAsyncResult(true, b => {w{assert(testLong == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableLongHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableLongReturn(true)
    nullableTCK.methodWithNullableLongReturn(false)
  }

  "testNullableFloat" should "work" in {
    val testFloat = 3.14.toFloat
    nullableTCK.methodWithNullableFloatParam(true, None)
    nullableTCK.methodWithNullableFloatParam(false, Option(testFloat))
    nullableTCK.methodWithNullableFloatHandler(true, b => assert(testFloat == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableFloatHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableFloatHandlerAsyncResult(true, b => {w{assert(testFloat == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableFloatHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableFloatReturn(true)
    nullableTCK.methodWithNullableFloatReturn(false)
  }

  "testNullableDouble" should "work" in {
    val testDouble = 3.1415926
    nullableTCK.methodWithNullableDoubleParam(true, None)
    nullableTCK.methodWithNullableDoubleParam(false, Option(testDouble))
    nullableTCK.methodWithNullableDoubleHandler(true, b => assert(testDouble == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableDoubleHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableDoubleHandlerAsyncResult(true, b => {w{assert(testDouble == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableDoubleHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableDoubleReturn(true)
    nullableTCK.methodWithNullableDoubleReturn(false)
  }

  "testNullableBoolean" should "work" in {
    val testBoolean = true
    nullableTCK.methodWithNullableBooleanParam(true, None)
    nullableTCK.methodWithNullableBooleanParam(false, Option(testBoolean))
    nullableTCK.methodWithNullableBooleanHandler(true, b => assert(testBoolean == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableBooleanHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableBooleanHandlerAsyncResult(true, b => {w{assert(testBoolean == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableBooleanHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableBooleanReturn(true)
    nullableTCK.methodWithNullableBooleanReturn(false)
  }

  "testNullableChar" should "work" in {
    val testChar = 'f'
    nullableTCK.methodWithNullableCharParam(true, None)
    nullableTCK.methodWithNullableCharParam(false, Option(testChar))
    nullableTCK.methodWithNullableCharHandler(true, b => assert(testChar == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableCharHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableCharHandlerAsyncResult(true, b => {w{assert(testChar == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableCharHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableCharReturn(true)
    nullableTCK.methodWithNullableCharReturn(false)
  }

  "testNullableJsonObject" should "work" in {
    val testJsonObject = Json.obj(("foo","wibble"),("bar",3))
    nullableTCK.methodWithNullableJsonObjectParam(true, None)
    nullableTCK.methodWithNullableJsonObjectParam(false, Option(testJsonObject))
    nullableTCK.methodWithNullableJsonObjectHandler(true, b => assert(testJsonObject == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableJsonObjectHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableJsonObjectHandlerAsyncResult(true, b => {w{assert(testJsonObject == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableJsonObjectHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableJsonObjectReturn(true)
    nullableTCK.methodWithNullableJsonObjectReturn(false)
  }

  "testNullableJsonArray" should "work" in {
    val testJsonArray = Json.arr("one","two","three")
    nullableTCK.methodWithNullableJsonArrayParam(true, None)
    nullableTCK.methodWithNullableJsonArrayParam(false, Option(testJsonArray))
    nullableTCK.methodWithNullableJsonArrayHandler(true, b => assert(testJsonArray == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableJsonArrayHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableJsonArrayHandlerAsyncResult(true, b => {w{assert(testJsonArray == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableJsonArrayHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableJsonArrayReturn(true)
    nullableTCK.methodWithNullableJsonArrayReturn(false)
  }

  "testNullableApi" should "work" in {
    val testApi = RefedInterface1(new RefedInterface1Impl().setString("lovely_dae"))
    nullableTCK.methodWithNullableApiParam(true, None)
    nullableTCK.methodWithNullableApiParam(false, Option(testApi))
    nullableTCK.methodWithNullableApiHandler(true, b => assert(testApi.asJava == b.asJava))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableApiHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableApiHandlerAsyncResult(true, b => {w{assert(testApi.asJava == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableApiHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableApiReturn(true)
    nullableTCK.methodWithNullableApiReturn(false)
  }

  "testNullableDataObject" should "work" in {
    val testDataObject = new TestDataObject(Json.obj(("foo","foo_value"), ("bar",12345), ("wibble", 3.5)))
    nullableTCK.methodWithNullableDataObjectParam(true, None)
    nullableTCK.methodWithNullableDataObjectParam(false, Option(testDataObject))
    nullableTCK.methodWithNullableDataObjectHandler(true, b => assert(testDataObject.toJson == b.toJson))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableDataObjectHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableDataObjectHandlerAsyncResult(true, b => {w{assert(testDataObject.toJson == b.result().toJson)}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableDataObjectHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableDataObjectReturn(true)
    nullableTCK.methodWithNullableDataObjectReturn(false)
  }

  "testNullableEnum" should "work" in {
    val testEnum = TestEnum.TIM
    nullableTCK.methodWithNullableEnumParam(true, None)
    nullableTCK.methodWithNullableEnumParam(false, Option(testEnum))
    nullableTCK.methodWithNullableEnumHandler(true, b => assert(testEnum == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableEnumHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableEnumHandlerAsyncResult(true, b => {w{assert(testEnum == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableEnumHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableEnumReturn(true)
    nullableTCK.methodWithNullableEnumReturn(false)
  }

  "testNullableGenEnum" should "work" in {
    val testGenEnum = TestGenEnum.MIKE
    nullableTCK.methodWithNullableGenEnumParam(true, None)
    nullableTCK.methodWithNullableGenEnumParam(false, Option(testGenEnum))
    nullableTCK.methodWithNullableGenEnumHandler(true, b => assert(testGenEnum == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableGenEnumHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableGenEnumHandlerAsyncResult(true, b => {w{assert(testGenEnum == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableGenEnumHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableGenEnumReturn(true)
    nullableTCK.methodWithNullableGenEnumReturn(false)
  }

  "testNullableTypeVariable" should "work" in {
    nullableTCK.methodWithNullableTypeVariableParam(false, "whatever")
    nullableTCK.methodWithNullableTypeVariableParam(true, null)
    val w1 = new Waiter()
    nullableTCK.methodWithNullableTypeVariableHandler[String](true, "wibble", a => {w1{assert(a == "wibble")}; w1.dismiss()})
    w1.await()
    val w2 = new Waiter()
    nullableTCK.methodWithNullableTypeVariableHandler[String](true, null, b => {w1{assert(b == "sausages")}; w2.dismiss()})
    w2.await()
    val w3 = new Waiter()
    nullableTCK.methodWithNullableTypeVariableHandlerAsyncResult[String](true, "sausages", c => {w3{assert(c.result() == "sausages")};w3.dismiss()})
    w3.await()
    val w4 = new Waiter()
    nullableTCK.methodWithNullableTypeVariableHandlerAsyncResult[String](true, null, d => {w4{assert(d.result() == null)};w4.dismiss()})
    assert("fizz1" == nullableTCK.methodWithNullableTypeVariableReturn[String](true, "fizz1"))
    //TODO: Missing @Nullable
    assert(null == nullableTCK.methodWithNullableTypeVariableReturn(false, "fizz2"))
    w4.await()
  }

  "testNullableObjectParam" should "work" in {
    nullableTCK.methodWithNullableObjectParam(true, null)
    nullableTCK.methodWithNullableObjectParam(false, "object_param")
  }


  "testNullableListByte" should "work" in {
    import collection.JavaConverters._
    val testListByte = List(12.toByte,24.toByte,(-12).toByte)
    nullableTCK.methodWithNullableListByteParam(true, None)
    nullableTCK.methodWithNullableListByteParam(false, Option(testListByte))
    nullableTCK.methodWithNullableListByteHandler(true, b => assert(testListByte == b))
    //TODO: Missing @Nullable
    //    nullableTCK.methodWithNullableListByteHandler(false, b => println(b))
    val w = new Waiter()
    nullableTCK.methodWithNullableListByteHandlerAsyncResult(true, b => {w{assert(testListByte.asJava == b.result())}; w.dismiss()})
    w.await()
    val w2= new Waiter()
    //TODO: Missing @Nullable
    nullableTCK.methodWithNullableListByteHandlerAsyncResult(false, b => {w2{assert(null == b.result())}; w2.dismiss()})
    w2.await()
    nullableTCK.methodWithNullableListByteReturn(true)
    nullableTCK.methodWithNullableListByteReturn(false)
  }

//  shared test void testNullableListByte() => testNullableList(ArrayList { 12.byte,24.byte,(-12).byte }, nullableTCK.methodWithNullableListByteParam, nullableTCK.methodWithNullableListByteHandler, nullableTCK.methodWithNullableListByteHandlerAsyncResult, nullableTCK.methodWithNullableListByteReturn);
//  shared test void testNullableListShort() => testNullableList(ArrayList { 520,1040,-520 }, nullableTCK.methodWithNullableListShortParam, nullableTCK.methodWithNullableListShortHandler, nullableTCK.methodWithNullableListShortHandlerAsyncResult, nullableTCK.methodWithNullableListShortReturn);
//  shared test void testNullableListInteger() => testNullableList(ArrayList { 12345,54321,-12345 }, nullableTCK.methodWithNullableListIntegerParam, nullableTCK.methodWithNullableListIntegerHandler, nullableTCK.methodWithNullableListIntegerHandlerAsyncResult, nullableTCK.methodWithNullableListIntegerReturn);
//  shared test void testNullableListLong() => testNullableList(ArrayList { 123456789,987654321,-123456789 }, nullableTCK.methodWithNullableListLongParam, nullableTCK.methodWithNullableListLongHandler, nullableTCK.methodWithNullableListLongHandlerAsyncResult, nullableTCK.methodWithNullableListLongReturn);
//  shared test void testNullableListFloat() => testNullableList(ArrayList { 1.1,2.2,3.3 }, nullableTCK.methodWithNullableListFloatParam, nullableTCK.methodWithNullableListFloatHandler, nullableTCK.methodWithNullableListFloatHandlerAsyncResult, nullableTCK.methodWithNullableListFloatReturn, assertFloatEquals);
//  shared test void testNullableListDouble() => testNullableList(ArrayList { 1.11,2.22,3.33 }, nullableTCK.methodWithNullableListDoubleParam, nullableTCK.methodWithNullableListDoubleHandler, nullableTCK.methodWithNullableListDoubleHandlerAsyncResult, nullableTCK.methodWithNullableListDoubleReturn, assertFloatEquals);
//  shared test void testNullableListBoolean() => testNullableList(ArrayList { true,false,true }, nullableTCK.methodWithNullableListBooleanParam, nullableTCK.methodWithNullableListBooleanHandler, nullableTCK.methodWithNullableListBooleanHandlerAsyncResult, nullableTCK.methodWithNullableListBooleanReturn);
//  shared test void testNullableListString() => testNullableList(ArrayList { "first","second","third" }, nullableTCK.methodWithNullableListStringParam, nullableTCK.methodWithNullableListStringHandler, nullableTCK.methodWithNullableListStringHandlerAsyncResult, nullableTCK.methodWithNullableListStringReturn);
//  shared test void testNullableListChar() => testNullableList(ArrayList { 'x','y','z' }, nullableTCK.methodWithNullableListCharParam, nullableTCK.methodWithNullableListCharHandler, nullableTCK.methodWithNullableListCharHandlerAsyncResult, nullableTCK.methodWithNullableListCharReturn);
//  shared test void testNullableListJsonObject() => testNullableList(ArrayList { JsonObject { "foo"->"bar" }, JsonObject { "juu"->3 } }, nullableTCK.methodWithNullableListJsonObjectParam, nullableTCK.methodWithNullableListJsonObjectHandler, nullableTCK.methodWithNullableListJsonObjectHandlerAsyncResult, nullableTCK.methodWithNullableListJsonObjectReturn);
//  shared test void testNullableListJsonArray() => testNullableList(ArrayList { JsonArray { "foo","bar" }, JsonArray { "juu" } }, nullableTCK.methodWithNullableListJsonArrayParam, nullableTCK.methodWithNullableListJsonArrayHandler, nullableTCK.methodWithNullableListJsonArrayHandlerAsyncResult, nullableTCK.methodWithNullableListJsonArrayReturn);
//  shared test void testNullableListApi() => testNullableList(ArrayList { RefedInterface1(RefedInterface1Impl().setString("refed_is_here")) }, nullableTCK.methodWithNullableListApiParam, nullableTCK.methodWithNullableListApiHandler, nullableTCK.methodWithNullableListApiHandlerAsyncResult, nullableTCK.methodWithNullableListApiReturn, assertRefedInterface1Equals);
//  shared test void testNullableListDataObject() => testNullableList(ArrayList { TestDataObject { foo="foo_value"; bar=12345; wibble=5.6; } }, nullableTCK.methodWithNullableListDataObjectParam, nullableTCK.methodWithNullableListDataObjectHandler, nullableTCK.methodWithNullableListDataObjectHandlerAsyncResult, nullableTCK.methodWithNullableListDataObjectReturn, assertTestDataObjectEquals);
//  shared test void testNullableListEnum() => testNullableList(ArrayList { "TIM", "JULIEN" }, nullableTCK.methodWithNullableListEnumParam, nullableTCK.methodWithNullableListEnumHandler, nullableTCK.methodWithNullableListEnumHandlerAsyncResult, nullableTCK.methodWithNullableListEnumReturn);
//  shared test void testNullableListGenEnum() => testNullableList(ArrayList { bob, leland }, nullableTCK.methodWithNullableListGenEnumParam, nullableTCK.methodWithNullableListGenEnumHandler, nullableTCK.methodWithNullableListGenEnumHandlerAsyncResult, nullableTCK.methodWithNullableListGenEnumReturn);
//
//  shared void testNullableList<T>(
//    List<T> expected,
//    Anything(Boolean,List<T>?) nullableListParamFunction,
//    Anything(Boolean,Anything(List<T>?)) nullableListHandlerFunction,
//    Anything(Boolean,Anything(List<T>?|Throwable)) nullableListHandlerAsyncResultFunction,
//    List<T>?(Boolean) nullableListReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    void checkList(Anything actual) {
//      assert(is List<T> actual);
//      assertEquals(expected.size, actual.size);
//      for (index->item in expected.indexed) {
//        check(item, actual[index]);
//      }
//    }
//    nullableListParamFunction(false, expected);
//    nullableListParamFunction(true, null);
//    variable Integer count = 0;
//    void a(List<T>? list) {
//      assertNull(list);
//      count++;
//    }
//    nullableListHandlerFunction(false, a);
//    void b(List<T>? list) {
//      checkList(list);
//      count++;
//    }
//    nullableListHandlerFunction(true, b);
//    void c(List<T>?|Throwable list) {
//      assertNull(list);
//      count++;
//    }
//    nullableListHandlerAsyncResultFunction(false, c);
//    void d(List<T>?|Throwable list) {
//      checkList(list);
//      count++;
//    }
//    nullableListHandlerAsyncResultFunction(true, d);
//    assertNull(nullableListReturnFunction(false));
//    checkList(nullableListReturnFunction(true));
//    assertEquals(4, count);
//  }
//
//  shared test void testNullableSetByte() => testNullableSet(HashSet { 12.byte,24.byte,(-12).byte }, nullableTCK.methodWithNullableSetByteParam, nullableTCK.methodWithNullableSetByteHandler, nullableTCK.methodWithNullableSetByteHandlerAsyncResult, nullableTCK.methodWithNullableSetByteReturn);
//  shared test void testNullableSetShort() => testNullableSet(HashSet { 520,1040,-520 }, nullableTCK.methodWithNullableSetShortParam, nullableTCK.methodWithNullableSetShortHandler, nullableTCK.methodWithNullableSetShortHandlerAsyncResult, nullableTCK.methodWithNullableSetShortReturn);
//  shared test void testNullableSetInteger() => testNullableSet(HashSet { 12345,54321,-12345 }, nullableTCK.methodWithNullableSetIntegerParam, nullableTCK.methodWithNullableSetIntegerHandler, nullableTCK.methodWithNullableSetIntegerHandlerAsyncResult, nullableTCK.methodWithNullableSetIntegerReturn);
//  shared test void testNullableSetLong() => testNullableSet(HashSet { 123456789,987654321,-123456789 }, nullableTCK.methodWithNullableSetLongParam, nullableTCK.methodWithNullableSetLongHandler, nullableTCK.methodWithNullableSetLongHandlerAsyncResult, nullableTCK.methodWithNullableSetLongReturn);
//  shared test void testNullableSetFloat() => testNullableSet(HashSet { 1.1,2.2,3.3 }, nullableTCK.methodWithNullableSetFloatParam, nullableTCK.methodWithNullableSetFloatHandler, nullableTCK.methodWithNullableSetFloatHandlerAsyncResult, nullableTCK.methodWithNullableSetFloatReturn, assertFloatEquals);
//  shared test void testNullableSetDouble() => testNullableSet(HashSet { 1.11,2.22,3.33 }, nullableTCK.methodWithNullableSetDoubleParam, nullableTCK.methodWithNullableSetDoubleHandler, nullableTCK.methodWithNullableSetDoubleHandlerAsyncResult, nullableTCK.methodWithNullableSetDoubleReturn, assertFloatEquals);
//  shared test void testNullableSetBoolean() => testNullableSet(HashSet { true,false }, nullableTCK.methodWithNullableSetBooleanParam, nullableTCK.methodWithNullableSetBooleanHandler, nullableTCK.methodWithNullableSetBooleanHandlerAsyncResult, nullableTCK.methodWithNullableSetBooleanReturn);
//  shared test void testNullableSetString() => testNullableSet(HashSet { "first","second","third" }, nullableTCK.methodWithNullableSetStringParam, nullableTCK.methodWithNullableSetStringHandler, nullableTCK.methodWithNullableSetStringHandlerAsyncResult, nullableTCK.methodWithNullableSetStringReturn);
//  shared test void testNullableSetChar() => testNullableSet(HashSet { 'x','y','z' }, nullableTCK.methodWithNullableSetCharParam, nullableTCK.methodWithNullableSetCharHandler, nullableTCK.methodWithNullableSetCharHandlerAsyncResult, nullableTCK.methodWithNullableSetCharReturn);
//  shared test void testNullableSetJsonObject() => testNullableSet(HashSet { JsonObject { "foo"->"bar" }, JsonObject { "juu"->3 } }, nullableTCK.methodWithNullableSetJsonObjectParam, nullableTCK.methodWithNullableSetJsonObjectHandler, nullableTCK.methodWithNullableSetJsonObjectHandlerAsyncResult, nullableTCK.methodWithNullableSetJsonObjectReturn);
//  shared test void testNullableSetJsonArray() => testNullableSet(HashSet { JsonArray { "foo","bar" }, JsonArray { "juu" } }, nullableTCK.methodWithNullableSetJsonArrayParam, nullableTCK.methodWithNullableSetJsonArrayHandler, nullableTCK.methodWithNullableSetJsonArrayHandlerAsyncResult, nullableTCK.methodWithNullableSetJsonArrayReturn);
//  shared test void testNullableSetApi() => testNullableSet(HashSet { RefedInterface1(RefedInterface1Impl().setString("refed_is_here")) }, nullableTCK.methodWithNullableSetApiParam, nullableTCK.methodWithNullableSetApiHandler, nullableTCK.methodWithNullableSetApiHandlerAsyncResult, nullableTCK.methodWithNullableSetApiReturn, assertRefedInterface1Equals);
//  shared test void testNullableSetDataObject() => testNullableSet(HashSet { TestDataObject { foo="foo_value"; bar=12345; wibble=5.6; } }, nullableTCK.methodWithNullableSetDataObjectParam, nullableTCK.methodWithNullableSetDataObjectHandler, nullableTCK.methodWithNullableSetDataObjectHandlerAsyncResult, nullableTCK.methodWithNullableSetDataObjectReturn, assertTestDataObjectEquals);
//  shared test void testNullableSetEnum() => testNullableSet(HashSet { "TIM", "JULIEN" }, nullableTCK.methodWithNullableSetEnumParam, nullableTCK.methodWithNullableSetEnumHandler, nullableTCK.methodWithNullableSetEnumHandlerAsyncResult, nullableTCK.methodWithNullableSetEnumReturn);
//  shared test void testNullableSetGenEnum() => testNullableSet(HashSet { bob, leland }, nullableTCK.methodWithNullableSetGenEnumParam, nullableTCK.methodWithNullableSetGenEnumHandler, nullableTCK.methodWithNullableSetGenEnumHandlerAsyncResult, nullableTCK.methodWithNullableSetGenEnumReturn);
//
//  shared void testNullableSet<T>(
//    Set<T> expected,
//    Anything(Boolean,Set<T>?) nullableSetParamFunction,
//    Anything(Boolean,Anything(Set<T>?)) nullableSetHandlerFunction,
//    Anything(Boolean,Anything(Set<T>?|Throwable)) nullableSetHandlerAsyncResultFunction,
//    Set<T>?(Boolean) nullableSetReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    void checkSet(Anything actual) {
//      assert(is Set<T> actual);
//      assertEquals(expected.size, actual.size);
//      variable Integer count = 0;
//      for (expectedItem in expected) {
//        for (actualItem in actual) {
//          try {
//            check(expectedItem, actualItem);
//            count++;
//            break;
//          } catch (Throwable ignore) {
//          }
//        }
//      }
//      assertEquals(expected.size, count);
//    }
//    nullableSetParamFunction(false, expected);
//    nullableSetParamFunction(true, null);
//    variable Integer count = 0;
//    void a(Set<T>? set) {
//      assertNull(set);
//      count++;
//    }
//    nullableSetHandlerFunction(false, a);
//    void b(Set<T>? set) {
//      checkSet(set);
//      count++;
//    }
//    nullableSetHandlerFunction(true, b);
//    void c(Set<T>?|Throwable set) {
//      assertNull(set);
//      count++;
//    }
//    nullableSetHandlerAsyncResultFunction(false, c);
//    void d(Set<T>?|Throwable set) {
//      checkSet(set);
//      count++;
//    }
//    nullableSetHandlerAsyncResultFunction(true, d);
//    assertNull(nullableSetReturnFunction(false));
//    checkSet(nullableSetReturnFunction(true));
//    assertEquals(4, count);
//  }
//
//  shared test void testNullableMapByte() => testNullableMap(ArrayList { 1.byte,2.byte,3.byte }, nullableTCK.methodWithNullableMapByteParam, nullableTCK.methodWithNullableMapByteHandler, nullableTCK.methodWithNullableMapByteHandlerAsyncResult, nullableTCK.methodWithNullableMapByteReturn);
//  shared test void testNullableMapShort() => testNullableMap(ArrayList { 1,2,3 }, nullableTCK.methodWithNullableMapShortParam, nullableTCK.methodWithNullableMapShortHandler, nullableTCK.methodWithNullableMapShortHandlerAsyncResult, nullableTCK.methodWithNullableMapShortReturn);
//  shared test void testNullableMapInteger() => testNullableMap(ArrayList { 1,2,3 }, nullableTCK.methodWithNullableMapIntegerParam, nullableTCK.methodWithNullableMapIntegerHandler, nullableTCK.methodWithNullableMapIntegerHandlerAsyncResult, nullableTCK.methodWithNullableMapIntegerReturn);
//  shared test void testNullableMapLong() => testNullableMap(ArrayList { 1,2,3 }, nullableTCK.methodWithNullableMapLongParam, nullableTCK.methodWithNullableMapLongHandler, nullableTCK.methodWithNullableMapLongHandlerAsyncResult, nullableTCK.methodWithNullableMapLongReturn);
//  shared test void testNullableMapFloat() => testNullableMap(ArrayList { 1.1,2.2,3.3 }, nullableTCK.methodWithNullableMapFloatParam, nullableTCK.methodWithNullableMapFloatHandler, nullableTCK.methodWithNullableMapFloatHandlerAsyncResult, nullableTCK.methodWithNullableMapFloatReturn, assertFloatEquals);
//  shared test void testNullableMapDouble() => testNullableMap(ArrayList { 1.11,2.22,3.33 }, nullableTCK.methodWithNullableMapDoubleParam, nullableTCK.methodWithNullableMapDoubleHandler, nullableTCK.methodWithNullableMapDoubleHandlerAsyncResult, nullableTCK.methodWithNullableMapDoubleReturn, assertFloatEquals);
//  shared test void testNullableMapBoolean() => testNullableMap(ArrayList { true, false, true }, nullableTCK.methodWithNullableMapBooleanParam, nullableTCK.methodWithNullableMapBooleanHandler, nullableTCK.methodWithNullableMapBooleanHandlerAsyncResult, nullableTCK.methodWithNullableMapBooleanReturn);
//  shared test void testNullableMapString() => testNullableMap(ArrayList { "first","second","third" }, nullableTCK.methodWithNullableMapStringParam, nullableTCK.methodWithNullableMapStringHandler, nullableTCK.methodWithNullableMapStringHandlerAsyncResult, nullableTCK.methodWithNullableMapStringReturn);
//  shared test void testNullableMapChar() => testNullableMap(ArrayList { 'x','y','z' }, nullableTCK.methodWithNullableMapCharParam, nullableTCK.methodWithNullableMapCharHandler, nullableTCK.methodWithNullableMapCharHandlerAsyncResult, nullableTCK.methodWithNullableMapCharReturn);
//  shared test void testNullableMapJsonObject() => testNullableMap(ArrayList { JsonObject { "foo"->"bar" }, JsonObject { "juu"->3 } }, nullableTCK.methodWithNullableMapJsonObjectParam, nullableTCK.methodWithNullableMapJsonObjectHandler, nullableTCK.methodWithNullableMapJsonObjectHandlerAsyncResult, nullableTCK.methodWithNullableMapJsonObjectReturn);
//  shared test void testNullableMapJsonArray() => testNullableMap(ArrayList { JsonArray { "foo","bar" }, JsonArray { "juu" } }, nullableTCK.methodWithNullableMapJsonArrayParam, nullableTCK.methodWithNullableMapJsonArrayHandler, nullableTCK.methodWithNullableMapJsonArrayHandlerAsyncResult, nullableTCK.methodWithNullableMapJsonArrayReturn);
//  shared test void testNullableMapApi() => testNullableMapIn(ArrayList { RefedInterface1(RefedInterface1Impl().setString("refed_is_here")) }, nullableTCK.methodWithNullableMapApiParam, assertRefedInterface1Equals);
//
//  shared void testNullableMap<T>(
//    List<T> expected,
//    Anything(Boolean,Map<String, T>?) nullableMapParamFunction,
//    Anything(Boolean,Anything(Map<String, T>?)) nullableMapHandlerFunction,
//    Anything(Boolean,Anything(Map<String, T>?|Throwable)) nullableMapHandlerAsyncResultFunction,
//    Map<String, T>?(Boolean) nullableMapReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    testNullableMapIn(expected, nullableMapParamFunction, check);
//    testNullableMapOut(expected, nullableMapHandlerFunction, nullableMapHandlerAsyncResultFunction, nullableMapReturnFunction, check);
//  }
//
//  shared void testNullableMapIn<T>(
//    List<T> expected,
//    Anything(Boolean,Map<String, T>?) nullableMapParamFunction,
//    Anything(Anything,Anything) check
//    ) {
//    HashMap<String, T> map = HashMap<String, T>();
//    for (index->item in expected.indexed) {
//      map.put("``(index + 1)``", item);
//    }
//    nullableMapParamFunction(false, map);
//    nullableMapParamFunction(true, null);
//  }
//
//  shared void testNullableMapOut<T>(
//    List<T> expected,
//    Anything(Boolean,Anything(Map<String, T>?)) nullableMapHandlerFunction,
//    Anything(Boolean,Anything(Map<String, T>?|Throwable)) nullableMapHandlerAsyncResultFunction,
//    Map<String, T>?(Boolean) nullableMapReturnFunction,
//    Anything(Anything,Anything) check
//    ) {
//    void checkMap(Anything actual) {
//      assert(is Map<String, T> actual);
//      assertEquals(expected.size, actual.size);
//      for (index->item in expected.indexed) {
//        check(item, actual["``(index + 1)``"]);
//      }
//    }
//    variable Integer count = 0;
//    void a(Map<String, T>? set) {
//      assertNull(set);
//      count++;
//    }
//    nullableMapHandlerFunction(false, a);
//    void b(Map<String, T>? set) {
//      checkMap(set);
//      count++;
//    }
//    nullableMapHandlerFunction(true, b);
//    void c(Map<String, T>?|Throwable set) {
//      assertNull(set);
//      count++;
//    }
//    nullableMapHandlerAsyncResultFunction(false, c);
//    void d(Map<String, T>?|Throwable set) {
//      checkMap(set);
//      count++;
//    }
//    nullableMapHandlerAsyncResultFunction(true, d);
//    assertNull(nullableMapReturnFunction(false));
//    checkMap(nullableMapReturnFunction(true));
//    assertEquals(4, count);
//  }
//
//  shared test void testListNullableByte() => testListNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithListNullableByteParam, nullableTCK.methodWithListNullableByteHandler, nullableTCK.methodWithListNullableByteHandlerAsyncResult, nullableTCK.methodWithListNullableByteReturn);
//  shared test void testListNullableShort() => testListNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithListNullableShortParam, nullableTCK.methodWithListNullableShortHandler, nullableTCK.methodWithListNullableShortHandlerAsyncResult, nullableTCK.methodWithListNullableShortReturn);
//  shared test void testListNullableInteger() => testListNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithListNullableIntegerParam, nullableTCK.methodWithListNullableIntegerHandler, nullableTCK.methodWithListNullableIntegerHandlerAsyncResult, nullableTCK.methodWithListNullableIntegerReturn);
//  shared test void testListNullableLong() => testListNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithListNullableLongParam, nullableTCK.methodWithListNullableLongHandler, nullableTCK.methodWithListNullableLongHandlerAsyncResult, nullableTCK.methodWithListNullableLongReturn);
//  shared test void testListNullableFloat() => testListNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithListNullableFloatParam, nullableTCK.methodWithListNullableFloatHandler, nullableTCK.methodWithListNullableFloatHandlerAsyncResult, nullableTCK.methodWithListNullableFloatReturn, assertFloatEquals);
//  shared test void testListNullableDouble() => testListNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithListNullableDoubleParam, nullableTCK.methodWithListNullableDoubleHandler, nullableTCK.methodWithListNullableDoubleHandlerAsyncResult, nullableTCK.methodWithListNullableDoubleReturn, assertFloatEquals);
//  shared test void testListNullableBoolean() => testListNullable(ArrayList { true,null,false }, nullableTCK.methodWithListNullableBooleanParam, nullableTCK.methodWithListNullableBooleanHandler, nullableTCK.methodWithListNullableBooleanHandlerAsyncResult, nullableTCK.methodWithListNullableBooleanReturn);
//  shared test void testListNullableString() => testListNullable(ArrayList { "first",null,"third" }, nullableTCK.methodWithListNullableStringParam, nullableTCK.methodWithListNullableStringHandler, nullableTCK.methodWithListNullableStringHandlerAsyncResult, nullableTCK.methodWithListNullableStringReturn);
//  shared test void testListNullableChar() => testListNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithListNullableCharParam, nullableTCK.methodWithListNullableCharHandler, nullableTCK.methodWithListNullableCharHandlerAsyncResult, nullableTCK.methodWithListNullableCharReturn);
//  shared test void testListNullableJsonObject() => testListNullable(ArrayList { JsonObject { "foo"->"bar" }, null, JsonObject { "juu"->3 } }, nullableTCK.methodWithListNullableJsonObjectParam, nullableTCK.methodWithListNullableJsonObjectHandler, nullableTCK.methodWithListNullableJsonObjectHandlerAsyncResult, nullableTCK.methodWithListNullableJsonObjectReturn);
//  shared test void testListNullableJsonArray() => testListNullable(ArrayList { JsonArray { "foo","bar" }, null, JsonArray { "juu" } }, nullableTCK.methodWithListNullableJsonArrayParam, nullableTCK.methodWithListNullableJsonArrayHandler, nullableTCK.methodWithListNullableJsonArrayHandlerAsyncResult, nullableTCK.methodWithListNullableJsonArrayReturn);
//  shared test void testListNullableApi() => testListNullable(ArrayList { RefedInterface1(RefedInterface1Impl().setString("first")), null, RefedInterface1(RefedInterface1Impl().setString("third")) }, nullableTCK.methodWithListNullableApiParam, nullableTCK.methodWithListNullableApiHandler, nullableTCK.methodWithListNullableApiHandlerAsyncResult, nullableTCK.methodWithListNullableApiReturn, assertRefedInterface1Equals);
//  shared test void testListNullableDataObject() => testListNullable(ArrayList { TestDataObject { foo="first"; bar=1; wibble=1.1; }, null, TestDataObject { foo="third"; bar=3; wibble=3.3; } }, nullableTCK.methodWithListNullableDataObjectParam, nullableTCK.methodWithListNullableDataObjectHandler, nullableTCK.methodWithListNullableDataObjectHandlerAsyncResult, nullableTCK.methodWithListNullableDataObjectReturn, assertTestDataObjectEquals);
//  shared test void testListNullableGenEnum() => testListNullable(ArrayList { bob, null, leland }, nullableTCK.methodWithListNullableGenEnumParam, nullableTCK.methodWithListNullableGenEnumHandler, nullableTCK.methodWithListNullableGenEnumHandlerAsyncResult, nullableTCK.methodWithListNullableGenEnumReturn);
//
//  shared void testListNullable<T>(
//    List<T?> expected,
//    Anything(List<T?>) listNullableParamFunction,
//    Anything(Anything(List<T?>)) listNullableHandlerFunction,
//    Anything(Anything(List<T?>|Throwable)) listNullableHandlerAsyncResultFunction,
//    List<T?>() listNullableReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    void checkList(List<T?> actual) {
//      assertEquals(expected.size, actual.size);
//      for (index->item in expected.indexed) {
//        if (exists item) {
//          check(item, actual[index]);
//        } else {
//          assertNull(actual[index]);
//        }
//      }
//    }
//    listNullableParamFunction(expected);
//    variable Integer count = 0;
//    void a(List<T?> list) {
//      checkList(list);
//      count++;
//    }
//    listNullableHandlerFunction(a);
//    void b(List<T?>|Throwable list) {
//      assert(is List<T?> list);
//      checkList(list);
//      count++;
//    }
//    listNullableHandlerAsyncResultFunction(b);
//    checkList(listNullableReturnFunction());
//    assertEquals(2, count);
//  }
//
//  shared test void testSetNullableByte() => testSetNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithSetNullableByteParam, nullableTCK.methodWithSetNullableByteHandler, nullableTCK.methodWithSetNullableByteHandlerAsyncResult, nullableTCK.methodWithSetNullableByteReturn);
//  shared test void testSetNullableShort() => testSetNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithSetNullableShortParam, nullableTCK.methodWithSetNullableShortHandler, nullableTCK.methodWithSetNullableShortHandlerAsyncResult, nullableTCK.methodWithSetNullableShortReturn);
//  shared test void testSetNullableInteger() => testSetNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithSetNullableIntegerParam, nullableTCK.methodWithSetNullableIntegerHandler, nullableTCK.methodWithSetNullableIntegerHandlerAsyncResult, nullableTCK.methodWithSetNullableIntegerReturn);
//  shared test void testSetNullableLong() => testSetNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithSetNullableLongParam, nullableTCK.methodWithSetNullableLongHandler, nullableTCK.methodWithSetNullableLongHandlerAsyncResult, nullableTCK.methodWithSetNullableLongReturn);
//  shared test void testSetNullableFloat() => testSetNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithSetNullableFloatParam, nullableTCK.methodWithSetNullableFloatHandler, nullableTCK.methodWithSetNullableFloatHandlerAsyncResult, nullableTCK.methodWithSetNullableFloatReturn, assertFloatEquals);
//  shared test void testSetNullableDouble() => testSetNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithSetNullableDoubleParam, nullableTCK.methodWithSetNullableDoubleHandler, nullableTCK.methodWithSetNullableDoubleHandlerAsyncResult, nullableTCK.methodWithSetNullableDoubleReturn, assertFloatEquals);
//  shared test void testSetNullableBoolean() => testSetNullable(ArrayList { true,null,false }, nullableTCK.methodWithSetNullableBooleanParam, nullableTCK.methodWithSetNullableBooleanHandler, nullableTCK.methodWithSetNullableBooleanHandlerAsyncResult, nullableTCK.methodWithSetNullableBooleanReturn);
//  shared test void testSetNullableString() => testSetNullable(ArrayList { "first",null,"third" }, nullableTCK.methodWithSetNullableStringParam, nullableTCK.methodWithSetNullableStringHandler, nullableTCK.methodWithSetNullableStringHandlerAsyncResult, nullableTCK.methodWithSetNullableStringReturn);
//  shared test void testSetNullableChar() => testSetNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithSetNullableCharParam, nullableTCK.methodWithSetNullableCharHandler, nullableTCK.methodWithSetNullableCharHandlerAsyncResult, nullableTCK.methodWithSetNullableCharReturn);
//  shared test void testSetNullableJsonObject() => testSetNullable(ArrayList { JsonObject { "foo"->"bar" }, null, JsonObject { "juu"->3 } }, nullableTCK.methodWithSetNullableJsonObjectParam, nullableTCK.methodWithSetNullableJsonObjectHandler, nullableTCK.methodWithSetNullableJsonObjectHandlerAsyncResult, nullableTCK.methodWithSetNullableJsonObjectReturn);
//  shared test void testSetNullableJsonArray() => testSetNullable(ArrayList { JsonArray { "foo","bar" }, null, JsonArray { "juu" } }, nullableTCK.methodWithSetNullableJsonArrayParam, nullableTCK.methodWithSetNullableJsonArrayHandler, nullableTCK.methodWithSetNullableJsonArrayHandlerAsyncResult, nullableTCK.methodWithSetNullableJsonArrayReturn);
//  shared test void testSetNullableApi() => testSetNullable(ArrayList { RefedInterface1(RefedInterface1Impl().setString("first")), null, RefedInterface1(RefedInterface1Impl().setString("third")) }, nullableTCK.methodWithSetNullableApiParam, nullableTCK.methodWithSetNullableApiHandler, nullableTCK.methodWithSetNullableApiHandlerAsyncResult, nullableTCK.methodWithSetNullableApiReturn, assertRefedInterface1Equals);
//  shared test void testSetNullableDataObject() => testSetNullable(ArrayList { TestDataObject { foo="first"; bar=1; wibble=1.1; }, null, TestDataObject { foo="third"; bar=3; wibble=3.3; } }, nullableTCK.methodWithSetNullableDataObjectParam, nullableTCK.methodWithSetNullableDataObjectHandler, nullableTCK.methodWithSetNullableDataObjectHandlerAsyncResult, nullableTCK.methodWithSetNullableDataObjectReturn, assertTestDataObjectEquals);
//  shared test void testSetNullableGenEnum() => testSetNullable(ArrayList { bob, null, leland }, nullableTCK.methodWithSetNullableGenEnumParam, nullableTCK.methodWithSetNullableGenEnumHandler, nullableTCK.methodWithSetNullableGenEnumHandlerAsyncResult, nullableTCK.methodWithSetNullableGenEnumReturn);
//
//  shared void testSetNullable<T>(
//    List<T?> expected,
//    Anything(Collection<T?>) setNullableParamFunction,
//    Anything(Anything(Collection<T?>)) setNullableHandlerFunction,
//    Anything(Anything(Collection<T?>|Throwable)) setNullableHandlerAsyncResultFunction,
//    Collection<T?>() setNullableReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    void checkSet(Collection<T?> actual) {
//      assertEquals(expected.size, actual.size);
//      variable Integer count = 0;
//      for (expectedItem in expected) {
//        for (actualItem in actual) {
//          try {
//            if (exists expectedItem) {
//              check(expectedItem, actualItem);
//            } else {
//              assertNull(actualItem);
//            }
//            count++;
//            break;
//          } catch (Throwable ignore) {
//          }
//        }
//      }
//      assertEquals(expected.size, count);
//    }
//    setNullableParamFunction(expected);
//    variable Integer count = 0;
//    void a(Collection<T?> set) {
//      checkSet(set);
//      count++;
//    }
//    setNullableHandlerFunction(a);
//    void b(Collection<T?>|Throwable set) {
//      assert(is Collection<T?> set);
//      checkSet(set);
//      count++;
//    }
//    setNullableHandlerAsyncResultFunction(b);
//    checkSet(setNullableReturnFunction());
//    assertEquals(2, count);
//  }
//
//  shared test void testMapNullableByte() => testMapNullable(ArrayList { 12.byte,null,24.byte }, nullableTCK.methodWithMapNullableByteParam, nullableTCK.methodWithMapNullableByteHandler, nullableTCK.methodWithMapNullableByteHandlerAsyncResult, nullableTCK.methodWithMapNullableByteReturn);
//  shared test void testMapNullableShort() => testMapNullable(ArrayList { 520,null,1040 }, nullableTCK.methodWithMapNullableShortParam, nullableTCK.methodWithMapNullableShortHandler, nullableTCK.methodWithMapNullableShortHandlerAsyncResult, nullableTCK.methodWithMapNullableShortReturn);
//  shared test void testMapNullableInteger() => testMapNullable(ArrayList { 12345,null,54321 }, nullableTCK.methodWithMapNullableIntegerParam, nullableTCK.methodWithMapNullableIntegerHandler, nullableTCK.methodWithMapNullableIntegerHandlerAsyncResult, nullableTCK.methodWithMapNullableIntegerReturn);
//  shared test void testMapNullableLong() => testMapNullable(ArrayList { 123456789,null,987654321 }, nullableTCK.methodWithMapNullableLongParam, nullableTCK.methodWithMapNullableLongHandler, nullableTCK.methodWithMapNullableLongHandlerAsyncResult, nullableTCK.methodWithMapNullableLongReturn);
//  shared test void testMapNullableFloat() => testMapNullable(ArrayList { 1.1,null,3.3 }, nullableTCK.methodWithMapNullableFloatParam, nullableTCK.methodWithMapNullableFloatHandler, nullableTCK.methodWithMapNullableFloatHandlerAsyncResult, nullableTCK.methodWithMapNullableFloatReturn, assertFloatEquals);
//  shared test void testMapNullableDouble() => testMapNullable(ArrayList { 1.11,null,3.33 }, nullableTCK.methodWithMapNullableDoubleParam, nullableTCK.methodWithMapNullableDoubleHandler, nullableTCK.methodWithMapNullableDoubleHandlerAsyncResult, nullableTCK.methodWithMapNullableDoubleReturn, assertFloatEquals);
//  shared test void testMapNullableBoolean() => testMapNullable(ArrayList { true, null, false }, nullableTCK.methodWithMapNullableBooleanParam, nullableTCK.methodWithMapNullableBooleanHandler, nullableTCK.methodWithMapNullableBooleanHandlerAsyncResult, nullableTCK.methodWithMapNullableBooleanReturn);
//  shared test void testMapNullableString() => testMapNullable(ArrayList { "first",null,"third" }, nullableTCK.methodWithMapNullableStringParam, nullableTCK.methodWithMapNullableStringHandler, nullableTCK.methodWithMapNullableStringHandlerAsyncResult, nullableTCK.methodWithMapNullableStringReturn);
//  shared test void testMapNullableChar() => testMapNullable(ArrayList { 'F',null,'R' }, nullableTCK.methodWithMapNullableCharParam, nullableTCK.methodWithMapNullableCharHandler, nullableTCK.methodWithMapNullableCharHandlerAsyncResult, nullableTCK.methodWithMapNullableCharReturn);
//  shared test void testMapNullableJsonObject() => testMapNullable(ArrayList { JsonObject { "foo"->"bar" }, null, JsonObject { "juu"->3 } }, nullableTCK.methodWithMapNullableJsonObjectParam, nullableTCK.methodWithMapNullableJsonObjectHandler, nullableTCK.methodWithMapNullableJsonObjectHandlerAsyncResult, nullableTCK.methodWithMapNullableJsonObjectReturn);
//  shared test void testMapNullableJsonArray() => testMapNullable(ArrayList { JsonArray { "foo","bar" }, null, JsonArray { "juu" } }, nullableTCK.methodWithMapNullableJsonArrayParam, nullableTCK.methodWithMapNullableJsonArrayHandler, nullableTCK.methodWithMapNullableJsonArrayHandlerAsyncResult, nullableTCK.methodWithMapNullableJsonArrayReturn);
//  shared test void testMapNullableApi() => testMapNullableIn(ArrayList { RefedInterface1(RefedInterface1Impl().setString("first")), null, RefedInterface1(RefedInterface1Impl().setString("third")) }, nullableTCK.methodWithMapNullableApiParam, assertRefedInterface1Equals);
//
//  shared void testMapNullable<T>(
//    List<T> expected,
//    Anything(Map<String, T?>) mapNullableParamFunction,
//    Anything(Anything(Map<String, T?>)) mapNullableHandlerFunction,
//    Anything(Anything(Map<String, T?>|Throwable)) mapNullableHandlerAsyncResultFunction,
//    Map<String, T?>() mapNullableReturnFunction,
//    Anything(Anything,Anything) check = assertEquals
//    ) {
//    testMapNullableIn(expected, mapNullableParamFunction, check);
//    testMapNullableOut(expected, mapNullableHandlerFunction, mapNullableHandlerAsyncResultFunction, mapNullableReturnFunction, check);
//  }
//
//  shared void testMapNullableIn<T>(
//    List<T> expected,
//    Anything(Map<String, T?>) mapNullableParamFunction,
//    Anything(Anything,Anything) check
//    ) {
//    HashMap<String, T> map = HashMap<String, T>();
//    for (index->item in expected.indexed) {
//      map.put("``(index + 1)``", item);
//    }
//    mapNullableParamFunction(map);
//  }
//
//  shared void testMapNullableOut<T>(
//    List<T> expected,
//    Anything(Anything(Map<String, T?>)) mapNullableHandlerFunction,
//    Anything(Anything(Map<String, T?>|Throwable)) mapNullableHandlerAsyncResultFunction,
//    Map<String, T?>() mapNullableReturnFunction,
//    Anything(Anything,Anything) check
//    ) {
//    void checkMap(Anything actual) {
//      assert(is Map<String, T?> actual);
//      assertEquals(expected.size, actual.size);
//      for (index->item in expected.indexed) {
//        if (exists item) {
//          check(item, actual["``(index + 1)``"]);
//        } else {
//          assertNull(actual["``(index + 1)``"]);
//        }
//      }
//    }
//    variable Integer count = 0;
//    void a(Map<String, T?> set) {
//      checkMap(set);
//      count++;
//    }
//    mapNullableHandlerFunction(a);
//    void b(Map<String, T?>|Throwable set) {
//      checkMap(set);
//      count++;
//    }
//    mapNullableHandlerAsyncResultFunction(b);
//    checkMap(mapNullableReturnFunction());
//    assertEquals(2, count);
//  }
//
//  shared test void testNullableHandler() {
//    variable Integer count = 0;
//    nullableTCK.methodWithNullableHandler(true, null);
//    void a(String s) {
//      assertEquals("the_string_value", s);
//      count++;
//    }
//    nullableTCK.methodWithNullableHandler(false, a);
//    nullableTCK.methodWithNullableHandlerAsyncResult(true, null);
//    void b(String|Throwable s) {
//      assertEquals("the_string_value", s);
//      count++;
//    }
//    nullableTCK.methodWithNullableHandlerAsyncResult(false, b);
//    assertEquals(2, count);
//  }
//
//  "Test that HttpServerOptions properly serialize to and deserialize from json"
//  shared test void testHttpServerOptionsJson() {
//    value options = HttpServerOptions {
//      compressionSupported = true;
//      ssl = true;
//      sendBufferSize = 65000;
//    };
//    value json = options.toJson();
//    value actualOptions = httpServerOptions.fromJson(json);
//    assertEquals(actualOptions.compressionSupported, options.compressionSupported);
//    assertEquals(actualOptions.ssl, options.ssl);
//    assertEquals(actualOptions.sendBufferSize, options.sendBufferSize);
//  }
//
//  void assertTestDataObjectEquals(Anything actual, Anything expected) {
//    assert(is TestDataObject actual);
//    assert(is TestDataObject expected);
//    assertEquals(actual.foo, expected.foo);
//    assertEquals(actual.bar, expected.bar);
//    assertEquals(actual.wibble, expected.wibble);
//  }
//
//  void assertRefedInterface1Equals(Anything actual, Anything expected) {
//    assert(is RefedInterface1 actual);
//    assert(is RefedInterface1 expected);
//    assertEquals(actual.getString(), expected.getString());
//  }
//
//  void assertFloatEquals(Anything actual, Anything expected) {
//    assert(is Float actual);
//    assert(is Float expected);
//    variable value diff = expected - actual;
//    if (diff < 0.float) {
//      diff -= diff;
//    }
//    assertTrue(diff < 0.0001);
//  }
}
