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

import io.vertx.core.Future
import java.util.stream.Collectors

import com.acme.scala.pkg.MyInterface
import com.acme.scala.pkg.sub.SubInterface
import io.vertx.codegen.testmodel._
import io.vertx.core.AsyncResult
import io.vertx.core.VertxException
import io.vertx.core.json.{JsonArray, JsonObject}
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json.arr
import io.vertx.scala.codegen.testmodel.ConcreteHandlerUserTypeExtension
import io.vertx.scala.codegen.testmodel.GenericRefedInterface
import io.vertx.scala.codegen.testmodel.RefedInterface1
import io.vertx.scala.codegen.testmodel.RefedInterface2
import io.vertx.scala.codegen.testmodel.TestInterface
import io.vertx.scala.codegen.testmodel.Factory
import org.junit.ComparisonFailure
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class HandlerOpsTest extends FlatSpec with Matchers {

  val obj = TestInterface(new TestInterfaceImpl())

  "testMethodWithBasicParams" should "work" in {
    obj.methodWithBasicParams( 123,  12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X', "foobar");
  }

  "testMethodWithBasicBoxedParams" should "work" in {
    obj.methodWithBasicBoxedParams(123, 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X');
  }

  "testMethodWithHandlerBasicTypes" should "work" in {
    obj.methodWithHandlerBasicTypes(
      b => assert(123 == b),
      s => assert(12345 == s),
      i => assert(1234567 == i),
      l => assert(1265615234l == l),
      f => assert(12.345f == f),
      d => assert(12.34566d == d),
      b => assert(true == b),
      c => assert('X' == c),
      s => assert("quux!" == s)
    )
  }

  "testMethodWithHandlerAsyncResultBasicTypes" should "work" in {
    obj.methodWithHandlerAsyncResultByte(false ,b => assert(123 == b.result()))
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
//    obj.methodWithObjectParam("true", true)
//    obj.methodWithObjectParam("false", false)
//    obj.methodWithObjectParam("long", 123)
//    obj.methodWithObjectParam("double", 123.456)
    obj.methodWithObjectParam("JsonObject", Json.obj(("foo","hello"), ("bar", 123)))
    val hello = "hello"
    obj.methodWithObjectParam("JsonObject", Json.obj(("foo",hello), ("bar", 123)))
    val foo = "foo"
    obj.methodWithObjectParam("JsonArray", arr(foo, "bar", "wib"))
  }
//
//  @Test
//  public void testDataObjectParam() {
//    def dataObject = [
//      foo: "hello",
//      bar: 123,
//      wibble: 1.23
//    ];
//    obj.methodWithDataObjectParam(dataObject);
//    def hell = "hell"
//    dataObject = [
//        foo: "${hell}o",
//        bar: 123,
//        wibble: 1.23
//    ];
//    obj.methodWithDataObjectParam(dataObject);
//  }
//
//  @Test
//  public void testListOfDataObjectsParam() {
//    def list = [
//            [foo: "hello",
//            bar: 123,
//            wibble: 1.23],
//            [foo: "world",
//             bar: 123,
//             wibble: 1.23]
//    ];
//    obj.methodWithListOfDataObjectsParam(list);
//  }
//
//  @Test
//  public void testSetOfDataObjectsParam() {
//    def set = new LinkedHashSet()
//    set << [foo: "hello",
//             bar: 123,
//             wibble: 1.23]
//    set << [foo: "world",
//             bar: 123,
//             wibble: 1.23]
//    obj.methodWithSetOfDataObjectsParam(set);
//  }
//
//  @Test
//  public void testNullDataObjectParam() {
//    obj.methodWithNullDataObjectParam(null);
//  }
//
//  @Test
//  public void testMethodWithHandlerDataObject() {
//    def dataObject = new TestDataObject()
//    dataObject.foo = "foo"
//    dataObject.bar = 123
//    def count = 0
//    obj.methodWithHandlerDataObject({
//      assertEquals(dataObject.foo, it.foo)
//      assertEquals(dataObject.bar, it.bar)
//      //assertNull(it.wibble)
//      count++
//    })
//    assertEquals(1, count)
//  }
//
//  @Test
//  public void testMethodWithHandlerAsyncResultDataObject() {
//    def dataObject = new TestDataObject()
//    dataObject.foo = "foo"
//    dataObject.bar = 123
//    def checker = new AsyncResultChecker()
//    obj.methodWithHandlerAsyncResultDataObject(false, { result ->
//      assertTrue(result.succeeded())
//      assertFalse(result.failed())
//      def res = result.result()
//      assertEquals(dataObject.foo, res.foo)
//      assertEquals(dataObject.bar, res.bar)
//      assertNull(result.cause())
//      checker.count++
//    })
//    obj.methodWithHandlerAsyncResultDataObject(true, { checker.assertAsyncFailure("foobar!", it) })
//    assertEquals(2, checker.count);
//  }
//
  "testMethodWithHandlerStringReturn" should "work" in {
    val handler = obj.methodWithHandlerStringReturn("the-result")
    handler("the-result")
    def failed = false
    intercept[ComparisonFailure](
      handler("not-expected")
    )
  }

  "testMethodWithHandlerGenericReturn" should "work" in {
    var stringResult = ""
    def stringHandler = obj.methodWithHandlerGenericReturn[String](res =>
      stringResult = res)
    stringHandler("the-result")
    assert("the-result" == stringResult)
    var objResult:TestInterface = null
    def objHandler = obj.methodWithHandlerGenericReturn[TestInterface](res =>
      objResult = res)
    objHandler(obj)
    assert(objResult == obj)
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
    var resultString:String = null
    var resultObj:TestInterface = null
    def stringHandler = obj.methodWithHandlerAsyncResultGenericReturn[String](ar =>  resultString = ar.result())
    def objHandler = obj.methodWithHandlerAsyncResultGenericReturn[TestInterface](ar =>  resultObj = ar.result())

    stringHandler(Future.succeededFuture("the-result"))
    assert("the-result" == resultString)
    objHandler(Future.succeededFuture(obj))
    assert(obj == resultObj)
  }

  "testMethodWithHandlerAsyncResultVertxGenReturn" should "work" in {
    var handler = obj.methodWithHandlerAsyncResultVertxGenReturn("wibble", false)
    //TODO: shouldn't require the asJava-call
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
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListString(it => assert(List("foo", "bar", "wibble") == it.result()))
    obj.methodWithHandlerAsyncResultListInteger(it => assert(List(5, 12, 100) == it.result()))
    obj.methodWithHandlerAsyncResultSetString(it => assert(Set("foo", "bar", "wibble") == it.result()))
    obj.methodWithHandlerAsyncResultSetInteger(it => assert(Set(5, 12, 100) == it.result()))
  }

  "testMethodWithHandlerListVertxGen" should "work" in {
    obj.methodWithHandlerListVertxGen(it => assert(it.map(_.getString()).mkString(",") == "foo,bar"))
  }

  "testMethodWithHandlerListAbstractVertxGen" should "work" in {
    obj.methodWithHandlerListAbstractVertxGen(it => assert(it.map(_.getString()).mkString(",") == "abstractfoo,abstractbar"))
  }

  "testMethodWithHandlerAsyncResultListVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListVertxGen(it => assert(it.result().map(_.getString()).mkString(",") == "foo,bar"))
  }

  "testMethodWithHandlerAsyncResultListAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListAbstractVertxGen(it => assert(it.result().map(_.getString()).mkString(",") == "abstractfoo,abstractbar"))
  }

  "testMethodWithHandlerSetVertxGen" should "work" in {
    obj.methodWithHandlerSetVertxGen(it => assert(it.map(_.getString()) == Set("bar","foo")))
  }

  "testMethodWithHandlerSetAbstractVertxGen" should "work" in {
    obj.methodWithHandlerSetAbstractVertxGen(it => assert(it.map(_.getString()).mkString(",") == "abstractfoo,abstractbar"))
  }

  "testMethodWithHandlerAsyncResultSetVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultSetVertxGen(it => assert(it.result().map(_.getString()).mkString(",") == "bar,foo"))

  }

  "testMethodWithHandlerAsyncResultSetAbstractVertxGen" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultSetAbstractVertxGen(it => assert(it.result().map(_.getString()).mkString(",") == "abstractbar,abstractfoo"))
  }

  "testMethodWithHandlerListJsonObject" should "work" in {
    obj.methodWithHandlerListJsonObject(it => assert(it == List(Json.obj(("cheese","stilton")),Json.obj(("socks","tartan")))))
  }

  "testMethodWithHandlerListNullJsonObject" should "work" in {
    obj.methodWithHandlerListNullJsonObject(it => assert(it == List(null)))
  }

  "testMethodWithHandlerListComplexJsonObject" should "work" in {
    obj.methodWithHandlerListComplexJsonObject(it => assert(it == List(Json.obj(("outer",Json.obj(("socks","tartan"))), ("list", arr("yellow","blue"))))))
  }

  "testMethodWithHandlerAsyncResultListJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListJsonObject(it => assert(List(Json.obj(("cheese","stilton")), Json.obj(("socks","tartan"))).sameElements(it.result())))
  }

  "testMethodWithHandlerAsyncResultListNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListNullJsonObject(it => assert(List(null).sameElements(it.result())))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultListComplexJsonObject(it => assert(List(Json.obj(("outer",Json.obj(("socks","tartan"))), ("list", arr("yellow","blue")))).sameElements(it.result())))
  }

  "testMethodWithHandlerSetJsonObject" should "work" in {
    obj.methodWithHandlerSetJsonObject(it => assert(it == Set(Json.obj(("cheese","stilton")),Json.obj(("socks","tartan")))))
  }

  "testMethodWithHandlerSetNullJsonObject" should "work" in {
    obj.methodWithHandlerSetNullJsonObject(it => assert(it == Set(null)))
  }

  "testMethodWithHandlerSetComplexJsonObject" should "work" in {
    obj.methodWithHandlerSetComplexJsonObject(it => assert(it == Set(Json.obj(("outer",Json.obj(("socks","tartan"))), ("list", arr("yellow","blue"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultSetJsonObject(it => assert(Set(Json.obj(("cheese","stilton")), Json.obj(("socks","tartan"))).sameElements(it.result())))
  }

  "testMethodWithHandlerAsyncResultSetNullJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultSetNullJsonObject(it => assert(Set(null).sameElements(it.result())))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonObject" should "work" in {
    import scala.collection.JavaConversions._
    obj.methodWithHandlerAsyncResultSetComplexJsonObject(it => assert(Set(Json.obj(("outer",Json.obj(("socks","tartan"))), ("list", arr("yellow","blue")))).sameElements(it.result())))
  }

  "testMethodWithHandlerListJsonArray" should "work" in {
    obj.methodWithHandlerListJsonArray(it => assert(it == List(arr("green","blue"), arr("yellow","purple"))))
  }

  "testMethodWithHandlerListNullJsonArray" should "work" in {
    obj.methodWithHandlerListNullJsonArray(it => assert(it == List(null)))
  }

  "testMethodWithHandlerListComplexJsonArray" should "work" in {
    obj.methodWithHandlerListComplexJsonArray(it => assert(it == List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

//  @Test
//  public void testMethodWithHandlerListDataObject() {
//    def count = 0
//    obj.methodWithHandlerListDataObject({
//      assertTrue(it[0] instanceof Map);
//      assertEquals("String 1", it[0].foo);
//      assertEquals(1, it[0].bar);
//      assertEquals(1.1, it[0].wibble, 0);
//      assertTrue(it[1] instanceof Map);
//      assertEquals("String 2", it[1].foo);
//      assertEquals(2, it[1].bar);
//      assertEquals(2.2, it[1].wibble, 0);
//      count++;
//    });
//    assertEquals(1, count);
//  }
//
//  @Test
//  public void testMethodWithHandlerNullListDataObject() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerListNullDataObject({
//      checker.assertResult([null], it)
//    });
//    assertEquals(1, checker.count);
//  }
//
//  @Test
//  public void testMethodWithHandlerSetDataObject() {
//    def count = 0
//    obj.methodWithHandlerSetDataObject({
//      assertEquals(2, it.size());
//      assertTrue(it.contains([foo:"String 1",bar: 1,wibble: 1.1d]));
//      assertTrue(it.contains([foo:"String 2",bar: 2,wibble: 2.2d]));
//      count++;
//    });
//    assertEquals(1, count);
//  }
//
//  @Test
//  public void testMethodWithHandlerNullSetDataObject() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerSetNullDataObject({
//      checker.assertResult([null] as Set, it)
//    });
//    assertEquals(1, checker.count);
//  }
//

  "testMethodWithHandlerAsyncResultListJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultListJsonArray(it => assert(it.result() == List(arr("green","blue"), arr("yellow","purple")).asJava))
  }

  "testMethodWithHandlerAsyncResultListNullJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultListNullJsonArray(it => assert(it.result() == List(null).asJava))
  }

  "testMethodWithHandlerAsyncResultListComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultListComplexJsonArray(it => assert(it.result() == List(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye")))).asJava))
  }

  "testMethodWithHandlerSetJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerSetJsonArray(it => assert(it == Set(arr("green","blue"), arr("yellow","purple"))))
  }

  "testMethodWithHandlerSetNullJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerSetNullJsonArray(it => assert(it == Set(null)))
  }

  "testMethodWithHandlerSetComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerSetComplexJsonArray(it => assert(it == Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye"))))))
  }

  "testMethodWithHandlerAsyncResultSetJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultSetJsonArray(it => assert(it.result() == Set(arr("green","blue"), arr("yellow","purple")).asJava))
  }

  "testMethodWithHandlerAsyncResultNullSetJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultSetNullJsonArray(it => assert(it.result() == Set(null).asJava))
  }

  "testMethodWithHandlerAsyncResultSetComplexJsonArray" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultSetComplexJsonArray(it => assert(it.result() == Set(arr(Json.obj(("foo", "hello"))), arr(Json.obj(("bar", "bye")))).asJava))
  }

//  @Test
//  public void testMethodWithHandlerAsyncResultListDataObject() {
//    def count = 0
//    obj.methodWithHandlerAsyncResultListDataObject({
//      List<TestDataObject> result = it.result();
//      assertTrue(result[0] instanceof Map);
//      assertEquals("String 1", result[0].foo);
//      assertEquals(1, result[0].bar);
//      assertEquals(1.1, result[0].wibble, 0);
//      assertTrue(result[1] instanceof Map);
//      assertEquals("String 2", result[1].foo);
//      assertEquals(2, result[1].bar);
//      assertEquals(2.2, result[1].wibble, 0);
//      count++;
//    });
//    assertEquals(1, count);
//  }
//
//  @Test
//  public void testMethodWithHandlerAsyncResultNullListDataObject() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerAsyncResultListNullDataObject({
//      checker.assertAsyncResult([null], it)
//    });
//    assertEquals(1, checker.count);
//  }
//
//  @Test
//  public void testMethodWithHandlerAsyncResultSetDataObject() {
//    def count = 0
//    obj.methodWithHandlerAsyncResultSetDataObject({
//      assertEquals(2, it.result().size());
//      assertTrue(it.result().contains([foo:"String 1",bar: 1,wibble: 1.1d]));
//      assertTrue(it.result().contains([foo:"String 2",bar: 2,wibble: 2.2d]));
//      count++;
//    });
//    assertEquals(1, count);
//  }
//
//  @Test
//  public void testMethodWithHandlerAsyncResultNullSetDataObject() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerAsyncResultSetNullDataObject({
//      checker.assertAsyncResult([null] as Set, it)
//    });
//    assertEquals(1, checker.count);
//  }
//

  "testMethodWithHandlerUserTypes" should "work" in {
    obj.methodWithHandlerUserTypes(it => assert(it.getString() == "echidnas"))
  }

  "testMethodWithHandlerAsyncResultUserTypes" should "work" in {
    obj.methodWithHandlerAsyncResultUserTypes(it => assert(it.result().getString() == "cheetahs"))
  }

  "testMethodWithConcreteHandlerUserTypesSubtype" should "work" in {
    obj.methodWithConcreteHandlerUserTypeSubtype(Factory.createConcreteHandlerUserType(it => assert(it.getString() == "echidnas")))
  }

  "testMethodWithAbstractHandlerUserTypesSubtype" should "work" in {
    obj.methodWithAbstractHandlerUserTypeSubtype(Factory.createAbstractHandlerUserType(it => assert(it.getString() == "echidnas")))
  }

  "testMethodWithConcreteHandlerUserTypesSubtypeExtension" should "work" in {
    obj.methodWithConcreteHandlerUserTypeSubtypeExtension(
      new ConcreteHandlerUserTypeExtension(new io.vertx.codegen.testmodel.ConcreteHandlerUserTypeExtension() {
        override def handle(event: io.vertx.codegen.testmodel.RefedInterface1): Unit = {
          assert("echidnas" == event.getString())
        }
      }))
  }

  "testMethodWithHandlerVoid" should "work" in {
    obj.methodWithHandlerVoid(() => assert(true))
  }

  "testMethodWithHandlerAsyncResultVoid" should "work" in {
    obj.methodWithHandlerAsyncResultVoid(false, (res) => assert(res.succeeded()))
  }

  "testMethodWithHandlerAsyncResultVoidFails" should "work" in {
    obj.methodWithHandlerAsyncResultVoid(true, (res) => {
      assert(res.failed())
      assert(res.cause().getMessage == "foo!")
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
    obj.methodWithHandlerAsyncResultGenericUserType[String]("string_value_2", (res) => {
      assert(res.result().getValue() == "string_value_2")
    })
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
    obj.methodWithGenericHandlerAsyncResult[String]("String", (res) => assert(res.result() == "foo"))
    obj.methodWithGenericHandlerAsyncResult[io.vertx.codegen.testmodel.RefedInterface1]("Ref", (res) => assert(res.result().getString == "bar"))
    obj.methodWithGenericHandlerAsyncResult[JsonObject]("JsonObject", (res) => assert(res.result() == Json.obj(("foo", "hello"), ("bar", 123))))
    obj.methodWithGenericHandlerAsyncResult[JsonArray]("JsonArray", (res) => assert(res.result() == arr("foo", "bar", "wib")))
    obj.methodWithGenericHandlerAsyncResult[JsonObject]("JsonObjectComplex", (res) => assert(res.result() == Json.obj(("outer", Json.obj(("foo", "hello"))), ("bar", arr("this", "that")))))
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
      List(TestEnum.JULIEN,TestEnum.TIM))
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
      Set(TestEnum.JULIEN,TestEnum.TIM))
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
        Map("foo"-> arr("foo"), "eek" -> arr("blah")),
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
    obj.methodWithHandlerAsyncResultListEnum(it => assert(it.result() == List(TestEnum.TIM, TestEnum.JULIEN).asJava))
  }

  "testMethodWithHandlerAsyncResultSetEnum" should "work" in {
    import collection.JavaConverters._
    obj.methodWithHandlerAsyncResultSetEnum(it => assert(it.result() == Set(TestEnum.TIM, TestEnum.JULIEN).asJava))
  }
//
//  // Returns
//
//  // FIXME - currently missing tests for returns of all List<T>, Set<T>, Map<T> types
//

  "testBasicReturns" should "work" in {
    assert(123 == obj.methodWithByteReturn())
    assert(12345 == obj.methodWithShortReturn())
    assert(12345464 == obj.methodWithIntReturn())
    assert(65675123 == obj.methodWithLongReturn())
    assert(1.23f == obj.methodWithFloatReturn())
    assert(3.34535 == obj.methodWithDoubleReturn())
    assert(true == obj.methodWithBooleanReturn())
    assert('Y' == obj.methodWithCharReturn())
    assert("orangutan" == obj.methodWithStringReturn())
  }

  "testVertxGenReturn" should "work" in {
    val r = obj.methodWithVertxGenReturn()
    assert("chaffinch" == r.getString())
  }

  "testVertxGenNullReturn" should "work" in {
    //FIXME that's not right, I think the method should directly return null
    val r = obj.methodWithVertxGenNullReturn()
    assert(null == r.asJava)
  }

  "testVertxAbstractGenReturn" should "work" in {
    val r = obj.methodWithAbstractVertxGenReturn()
    assert("abstractchaffinch" == r.getString())
  }

  "testDataObjectReturn" should "work" in {
    val r = obj.methodWithDataObjectReturn()
    assert("foo" == r.getFoo())
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
    assert("bar" == list(0).getString("foo"))
    assert("eek" == list(1).getString("blah"))
  }

  "testListComplexJsonObjectReturn" should "work" in {
    val list = obj.methodWithListComplexJsonObjectReturn()
    assert(1 == list.size)
    val json1 = list(0)
    assert(Json.obj(("outer", Json.obj(("socks", "tartan"))), ("list", arr("yellow", "blue"))) == json1)
  }

  "testListJsonArrayReturn" should "work" in {
    var list = obj.methodWithListJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list(0)
    assert("foo" == json1.getString(0))
    val json2 = list(1)
    assert("blah" == json2.getString(0))
  }

  "testListComplexJsonArrayReturn" should "work" in {
    val list = obj.methodWithListComplexJsonArrayReturn()
    assert(2 == list.size)
    val json1 = list(0)
    assert(arr(Json.obj(("foo", "hello"))) == json1)
    val json2 = list(1)
    assert(arr(Json.obj(("bar", "bye"))) == json2)
  }

  "testListVertxGenReturn" should "work" in {
    val list = obj.methodWithListVertxGenReturn()
    assert(2 == list.size)
    val refed1 = list(0)
    val refed2 = list(1)
    assert("foo" == refed1.getString())
    assert("bar"== refed2.getString())
  }

  "testListDataObjectReturn" should "work" in {
    val list = obj.methodWithListDataObjectReturn();
    assert("String 1" == list(0).getFoo())
    assert(1 == list(0).getBar())
    assert(1.1 == list(0).getWibble())
    assert("String 2" == list(1).getFoo())
    assert(2 == list(1).getBar())
    assert(2.2 == list(1).getWibble())
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
//
//  @Test
//  public void testSetJsonArrayReturn() {
//    Set<List<Object>> set = obj.methodWithSetJsonArrayReturn();
//    assertEquals(2, set.size());
//    List<Object> json1 = new ArrayList<>();
//    json1.add("foo");
//    assertTrue(set.contains(json1));
//    List<Object> json2 = new ArrayList<>();
//    json2.add("blah");
//    assertTrue(set.contains(json2));
//  }
//
//  @Test
//  public void testSetComplexJsonArrayReturn() {
//    Set<List<Object>> set = obj.methodWithSetComplexJsonArrayReturn();
//    assertEquals(2, set.size());
//    assertTrue(set.contains([[foo: "hello"]]));
//    assertTrue(set.contains([[bar: "bye"]]));
//  }
//
//  @Test
//  public void testSetVertxGenReturn() {
//    Set<io.vertx.groovy.codegen.testmodel.RefedInterface1> set = obj.methodWithSetVertxGenReturn();
//    assertEquals(2, set.size());
//    RefedInterface1 refed1 = new RefedInterface1(new RefedInterface1Impl());
//    refed1.setString("foo");
//    RefedInterface1 refed2 = new RefedInterface1(new RefedInterface1Impl());
//    refed2.setString("bar");
//    List<RefedInterface1> list = new ArrayList<>(set);
//    assertTrue((list.get(0).getString().equals("foo") && list.get(1).getString().equals("bar")) || (list.get(0).getString().equals("bar") && list.get(1).getString().equals("foo")))
//  }
//
//  @Test
//  public void testSetDataObjectReturn() {
//    Set<Map<String, Object>> set = obj.methodWithSetDataObjectReturn();
//    assertEquals(2, set.size());
//    assertTrue(set.contains([foo:"String 1",bar: 1,wibble: 1.1d]));
//    assertTrue(set.contains([foo:"String 2",bar: 2,wibble: 2.2d]));
//  }
//
//  @Test
//  public void testMapStringReturn() {
//    Map<String, String> map = obj.methodWithMapStringReturn({});
//    assertEquals("bar", map.get("foo"));
//  }
//
//  @Test
//  public void testMapLongReturn() {
//    Map<String, Long> map = obj.methodWithMapLongReturn({});
//    assertEquals(123l, map.get("foo"));
//  }
//
//  @Test
//  public void testMapJsonObjectReturn() {
//    Map<String, Map<String, Object>> map = obj.methodWithMapJsonObjectReturn({});
//    Map<String, Object> m = map.get("foo");
//    assertEquals("eek", m.get("wibble"));
//  }
//
//  @Test
//  public void testMapComplexJsonObjectReturn() {
//    Map<String, Map<String, Object>> map = obj.methodWithMapComplexJsonObjectReturn({});
//    Map<String, Object> m = map.get("foo");
//    assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], m);
//  }
//
//  @Test
//  public void testMapJsonArrayReturn() {
//    Map<String, List<Object>> map = obj.methodWithMapJsonArrayReturn({});
//    List<Object> m = map.get("foo");
//    assertEquals("wibble", m.get(0));
//  }
//
//  @Test
//  public void testMapComplexJsonArrayReturn() {
//    Map<String, List<Object>> map = obj.methodWithMapComplexJsonArrayReturn({});
//    List<Object> m = map.get("foo");
//    assertEquals([[foo: "hello"], [bar: "bye"]], m);
//  }
//
//  @Test
//  public void testOverloadedMethods() {
//    RefedInterface1 refed = new RefedInterface1(new RefedInterface1Impl())
//    refed.setString("dog")
//    assertEquals("meth1", obj.overloadedMethod("cat", refed))
//    def called = false
//    assertEquals("meth2", obj.overloadedMethod("cat", refed, 12345) { assertEquals("giraffe", it); called = true })
//    assertTrue(called)
//    called = false
//    assertEquals("meth3", obj.overloadedMethod("cat", { assertEquals("giraffe", it); called = true }))
//    assertTrue(called)
//    called = false
//    assertEquals("meth4", obj.overloadedMethod("cat", refed, { assertEquals("giraffe", it); called = true }))
//    assertTrue(called)
//  }
//
//  @Test
//  public void testSuperInterfaces() {
//    obj.superMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar')
//    obj.otherSuperMethodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, 'foobar');
//  }
//
//  @Test
//  public void testMethodWithGenericReturn() {
//    def ret = obj.methodWithGenericReturn("JsonObject");
//    assertTrue("Was expecting " + ret + " to implement Map", ret instanceof Map);
//    assertEquals([foo:"hello",bar:123], ret);
//    ret = obj.methodWithGenericReturn("JsonArray");
//    assertTrue("Was expecting " + ret + " to implement List", ret instanceof List);
//    assertEquals(["foo","bar","wib"], ret);
//  }
//
//  @Test
//  public void testFluentMethod() {
//    def ret = obj.fluentMethod("bar");
//    assertSame(obj, ret)
//  }
//
//  @Test
//  public void testStaticFactoryMethod() {
//    def ret = TestInterface.staticFactoryMethod("bar");
//    assertEquals("bar", ret.string);
//  }
//
//  @Test
//  public void testMethodWithCachedReturn() {
//    def ret1 = obj.methodWithCachedReturn("bar");
//    assertEquals("bar", ret1.string);
//    def ret2 = obj.methodWithCachedReturn("bar");
//    assertSame(ret1, ret2);
//    def ret3 = obj.methodWithCachedReturn("bar");
//    assertSame(ret1, ret3);
//  }
//
//  @Test
//  public void testMethodWithCachedListReturn() {
//    def ret1 = obj.methodWithCachedListReturn();
//    assertEquals(2, ret1.size());
//    assertEquals("foo", ret1[0].string);
//    assertEquals("bar", ret1[1].string);
//    def ret2 = obj.methodWithCachedListReturn();
//    assertSame(ret1, ret2);
//    def ret3 = obj.methodWithCachedListReturn();
//    assertSame(ret1, ret3);
//  }
//
//  @Test
//  public void testJsonReturns() {
//    def ret = obj.methodWithJsonObjectReturn();
//    assertEquals([cheese:"stilton"], ret);
//    ret = obj.methodWithJsonArrayReturn();
//    assertEquals(["socks", "shoes"], ret);
//  }
//
//  @Test
//  public void testNullJsonReturns() {
//    def ret = obj.methodWithNullJsonObjectReturn();
//    assertEquals(null, ret);
//    ret = obj.methodWithNullJsonArrayReturn();
//    assertEquals(null, ret);
//  }
//
//  @Test
//  public void testComplexJsonReturns() {
//    def ret = obj.methodWithComplexJsonObjectReturn();
//    assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], ret);
//    ret = obj.methodWithComplexJsonArrayReturn();
//    assertEquals([[foo: "hello"], [bar: "bye"]], ret);
//  }
//
//  @Test
//  public void testJsonParams() {
//    obj.methodWithJsonParams([cat:"lion",cheese:"cheddar"], ["house","spider"]);
//  }
//
//  @Test
//  public void testNullJsonParams() {
//    obj.methodWithNullJsonParams(null, null);
//  }
//
//  @Test
//  public void testJsonHandlerParams() {
//    def count = 0;
//    obj.methodWithHandlerJson({
//      assertEquals([cheese:"stilton"], it)
//      count++;
//    }, {
//      assertEquals(["socks","shoes"], it)
//      count++;
//    });
//    assertEquals(2, count);
//  }
//
//  @Test
//  public void testNullJsonHandlerParams() {
//    def count = 0;
//    obj.methodWithHandlerNullJson({
//      assertEquals(null, it)
//      count++;
//    }, {
//      assertEquals(null, it)
//      count++;
//    });
//    assertEquals(2, count);
//  }
//
//
//  @Test
//  public void testComplexJsonHandlerParams() {
//    def count = 0;
//    obj.methodWithHandlerComplexJson({
//      assertEquals([outer: [socks: "tartan"], list: ["yellow", "blue"]], it)
//      count++;
//    }, {
//      assertEquals([[[foo: "hello"]], [[bar: "bye"]]], it)
//      count++;
//    });
//    assertEquals(2, count);
//  }
//
//  @Test
//  public void testJsonHandlerAsyncResultParams() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerAsyncResultJsonObject({
//      checker.assertAsyncResult([cheese:"stilton"], it)
//    });
//    obj.methodWithHandlerAsyncResultJsonArray({
//      checker.assertAsyncResult(["socks","shoes"], it)
//    });
//    assertEquals(2, checker.count);
//  }
//
//  @Test
//  public void testNullJsonHandlerAsyncResultParams() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerAsyncResultNullJsonObject({
//      checker.assertAsyncResult(null, it)
//    });
//    obj.methodWithHandlerAsyncResultNullJsonArray({
//      checker.assertAsyncResult(null, it)
//    });
//    assertEquals(2, checker.count);
//  }
//
//  @Test
//  public void testComplexJsonHandlerAsyncResultParams() {
//    def checker = new AsyncResultChecker();
//    obj.methodWithHandlerAsyncResultComplexJsonObject({
//      checker.assertAsyncResult([outer: [socks: "tartan"], list: ["yellow", "blue"]], it)
//    });
//    obj.methodWithHandlerAsyncResultComplexJsonArray({
//      checker.assertAsyncResult([[foo: "hello"], [bar: "bye"]], it)
//    });
//    assertEquals(2, checker.count);
//  }
//
//  @Test
//  public void testMethodWithListEnumReturn() {
//    assertEquals([TestEnum.JULIEN,TestEnum.TIM], obj.methodWithListEnumReturn());
//  }
//
//  @Test
//  public void testMethodWithSetEnumReturn() {
//    assertEquals([TestEnum.JULIEN,TestEnum.TIM] as Set, obj.methodWithSetEnumReturn());
//  }
//
//  @Test
//  public void testMethodWithEnumParam() {
//    def ret = obj.methodWithEnumParam("cabbages", TestEnum.JULIEN);
//    assertEquals("cabbagesJULIEN", ret);
//  }
//
//  @Test
//  public void testMethodWithThrowableParam() {
//    def ret = obj.methodWithThrowableParam(new Exception("the_exception"));
//    assertEquals("the_exception", ret);
//  }
//
//  @Test
//  public void testMethodWithEnumReturn() {
//    TestEnum ret = obj.methodWithEnumReturn("JULIEN");
//    assertEquals(TestEnum.JULIEN, ret);
//  }
//
//  @Test
//  public void testMethodWithThrowableReturn() {
//    Throwable ret = obj.methodWithThrowableReturn("bogies");
//    assertEquals("bogies", ret.getMessage());
//  }
//
//  @Test
//  public void testCustomModule() {
//    MyInterface my = MyInterface.create();
//    TestInterface testInterface = my.method();
//    testInterface.methodWithBasicParams((byte) 123, (short) 12345, 1234567, 1265615234l, 12.345f, 12.34566d, true, 'X' as char, "foobar");
//    SubInterface sub = my.sub();
//    assertEquals("olleh", sub.reverse("hello"))
//  }
}
