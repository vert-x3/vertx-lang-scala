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

package io.vertx.scala.codegen.testmodel

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import scala.collection.JavaConverters._
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
class TestInterface(private val _asJava: Object)
    extends SuperInterface1(_asJava) with SuperInterface2  {

  private var cached_0: Option[RefedInterface1] = None
  private var cached_1: Option[Int] = None
  private var cached_2: Option[scala.collection.mutable.Buffer[RefedInterface1]] = None

  def methodWithCachedReturn(foo: String): RefedInterface1 = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedReturn(foo.asInstanceOf[java.lang.String])
      cached_0 = Some(RefedInterface1(tmp))
    }
    cached_0.get
  }

  def methodWithCachedReturnPrimitive(arg: Int): Int = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedReturnPrimitive(arg.asInstanceOf[java.lang.Integer])
      cached_1 = Some(tmp.asInstanceOf[Int])
    }
    cached_1.get
  }

  def methodWithCachedListReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JTestInterface].methodWithCachedListReturn()
      cached_2 = Some(tmp.asScala.map(x => RefedInterface1(x)))
    }
    cached_2.get
  }

  def fluentMethod(str: String): TestInterface = {
    asJava.asInstanceOf[JTestInterface].fluentMethod(str.asInstanceOf[java.lang.String])
    this
  }

  override def otherSuperMethodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.asInstanceOf[JTestInterface].otherSuperMethodWithBasicParams(b.asInstanceOf[java.lang.Byte], s.asInstanceOf[java.lang.Short], i.asInstanceOf[java.lang.Integer], l.asInstanceOf[java.lang.Long], f.asInstanceOf[java.lang.Float], d.asInstanceOf[java.lang.Double], bool.asInstanceOf[java.lang.Boolean], ch.asInstanceOf[java.lang.Character], str.asInstanceOf[java.lang.String])
  }

  def methodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicParams(b.asInstanceOf[java.lang.Byte], s.asInstanceOf[java.lang.Short], i.asInstanceOf[java.lang.Integer], l.asInstanceOf[java.lang.Long], f.asInstanceOf[java.lang.Float], d.asInstanceOf[java.lang.Double], bool.asInstanceOf[java.lang.Boolean], ch.asInstanceOf[java.lang.Character], str.asInstanceOf[java.lang.String])
  }

  def methodWithBasicBoxedParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicBoxedParams(b.asInstanceOf[java.lang.Byte], s.asInstanceOf[java.lang.Short], i.asInstanceOf[java.lang.Integer], l.asInstanceOf[java.lang.Long], f.asInstanceOf[java.lang.Float], d.asInstanceOf[java.lang.Double], bool.asInstanceOf[java.lang.Boolean], ch.asInstanceOf[java.lang.Character])
  }

  def methodWithHandlerBasicTypes(byteHandler: Handler[Byte], shortHandler: Handler[Short], intHandler: Handler[Int], longHandler: Handler[Long], floatHandler: Handler[Float], doubleHandler: Handler[Double], booleanHandler: Handler[Boolean], charHandler: Handler[Char], stringHandler: Handler[String]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerBasicTypes({x: java.lang.Byte => byteHandler.handle(x.asInstanceOf[Byte])}, {x: java.lang.Short => shortHandler.handle(x.asInstanceOf[Short])}, {x: java.lang.Integer => intHandler.handle(x.asInstanceOf[Int])}, {x: java.lang.Long => longHandler.handle(x.asInstanceOf[Long])}, {x: java.lang.Float => floatHandler.handle(x.asInstanceOf[Float])}, {x: java.lang.Double => doubleHandler.handle(x.asInstanceOf[Double])}, {x: java.lang.Boolean => booleanHandler.handle(x.asInstanceOf[Boolean])}, {x: java.lang.Character => charHandler.handle(x.asInstanceOf[Char])}, {x: java.lang.String => stringHandler.handle(x.asInstanceOf[String])})
  }

  def methodWithHandlerStringReturn(expected: String): Handler[String] = {
    {x: String => asJava.asInstanceOf[JTestInterface].methodWithHandlerStringReturn(expected.asInstanceOf[java.lang.String]).handle(x.asInstanceOf[java.lang.String])}
  }

  def methodWithHandlerGenericReturn[T: TypeTag](handler: Handler[T]): Handler[T] = {
    {x: T => asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericReturn[Object]({x: Object => handler.handle(toScala[T](x))}).handle(toJava[T](x))}
  }

  def methodWithHandlerVertxGenReturn(expected: String): Handler[RefedInterface1] = {
    {x: RefedInterface1 => asJava.asInstanceOf[JTestInterface].methodWithHandlerVertxGenReturn(expected.asInstanceOf[java.lang.String]).handle(x.asJava.asInstanceOf[JRefedInterface1])}
  }

  def methodWithHandlerAsyncResultByte(sendFailure: Boolean, handler: Handler[AsyncResult[Byte]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultByte(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Byte] => handler.handle(AsyncResultWrapper[java.lang.Byte, Byte](x, a => a.asInstanceOf[Byte]))})
  }

  def methodWithHandlerAsyncResultShort(sendFailure: Boolean, handler: Handler[AsyncResult[Short]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultShort(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Short] => handler.handle(AsyncResultWrapper[java.lang.Short, Short](x, a => a.asInstanceOf[Short]))})
  }

  def methodWithHandlerAsyncResultInteger(sendFailure: Boolean, handler: Handler[AsyncResult[Int]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultInteger(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Integer] => handler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))})
  }

  def methodWithHandlerAsyncResultLong(sendFailure: Boolean, handler: Handler[AsyncResult[Long]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultLong(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
  }

  def methodWithHandlerAsyncResultFloat(sendFailure: Boolean, handler: Handler[AsyncResult[Float]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultFloat(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Float] => handler.handle(AsyncResultWrapper[java.lang.Float, Float](x, a => a.asInstanceOf[Float]))})
  }

  def methodWithHandlerAsyncResultDouble(sendFailure: Boolean, handler: Handler[AsyncResult[Double]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDouble(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Double] => handler.handle(AsyncResultWrapper[java.lang.Double, Double](x, a => a.asInstanceOf[Double]))})
  }

  def methodWithHandlerAsyncResultBoolean(sendFailure: Boolean, handler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultBoolean(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  def methodWithHandlerAsyncResultCharacter(sendFailure: Boolean, handler: Handler[AsyncResult[Char]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultCharacter(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.Character] => handler.handle(AsyncResultWrapper[java.lang.Character, Char](x, a => a.asInstanceOf[Char]))})
  }

  def methodWithHandlerAsyncResultString(sendFailure: Boolean, handler: Handler[AsyncResult[String]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultString(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))})
  }

  def methodWithHandlerAsyncResultDataObject(sendFailure: Boolean, handler: Handler[AsyncResult[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDataObject(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JTestDataObject] => handler.handle(AsyncResultWrapper[JTestDataObject, TestDataObject](x, a => TestDataObject(a)))})
  }

  def methodWithHandlerAsyncResultStringReturn(expected: String, fail: Boolean): Handler[AsyncResult[String]] = {
    {x: AsyncResult[String] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultStringReturn(expected.asInstanceOf[java.lang.String], fail.asInstanceOf[java.lang.Boolean]).handle(AsyncResultWrapper[String, java.lang.String](x, a => a.asInstanceOf[java.lang.String]))}
  }

  def methodWithHandlerAsyncResultGenericReturn[T: TypeTag](handler: Handler[AsyncResult[T]]): Handler[AsyncResult[T]] = {
    {x: AsyncResult[T] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericReturn[Object]({x: AsyncResult[Object] => handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}).handle(AsyncResultWrapper[T, Object](x, a => toJava[T](a)))}
  }

  def methodWithHandlerAsyncResultVertxGenReturn(expected: String, fail: Boolean): Handler[AsyncResult[RefedInterface1]] = {
    {x: AsyncResult[RefedInterface1] => asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVertxGenReturn(expected.asInstanceOf[java.lang.String], fail.asInstanceOf[java.lang.Boolean]).handle(AsyncResultWrapper[RefedInterface1, JRefedInterface1](x, a => a.asJava.asInstanceOf[JRefedInterface1]))}
  }

  def methodWithUserTypes(refed: RefedInterface1): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithUserTypes(refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithObjectParam(str: String, obj: AnyRef): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithObjectParam(str.asInstanceOf[java.lang.String], obj)
  }

  def methodWithDataObjectParam(dataObject: TestDataObject): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithDataObjectParam(dataObject.asJava)
  }

  def methodWithHandlerUserTypes(handler: Handler[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerUserTypes({x: JRefedInterface1 => handler.handle(RefedInterface1(x))})
  }

  def methodWithHandlerAsyncResultUserTypes(handler: Handler[AsyncResult[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultUserTypes({x: AsyncResult[JRefedInterface1] => handler.handle(AsyncResultWrapper[JRefedInterface1, RefedInterface1](x, a => RefedInterface1(a)))})
  }

  def methodWithConcreteHandlerUserTypeSubtype(handler: ConcreteHandlerUserType): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithConcreteHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JConcreteHandlerUserType])
  }

  def methodWithAbstractHandlerUserTypeSubtype(handler: AbstractHandlerUserType): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithAbstractHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JAbstractHandlerUserType])
  }

  def methodWithConcreteHandlerUserTypeSubtypeExtension(handler: ConcreteHandlerUserTypeExtension): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithConcreteHandlerUserTypeSubtypeExtension(handler.asJava.asInstanceOf[JConcreteHandlerUserTypeExtension])
  }

  def methodWithHandlerVoid(handler: Handler[Unit]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerVoid({x: Void => handler.handle(x)})
  }

  def methodWithHandlerAsyncResultVoid(sendFailure: Boolean, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVoid(sendFailure.asInstanceOf[java.lang.Boolean], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  def methodWithHandlerThrowable(handler: Handler[Throwable]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerThrowable({x: Throwable => handler.handle(x)})
  }

  def methodWithHandlerDataObject(handler: Handler[TestDataObject]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerDataObject({x: JTestDataObject => handler.handle(TestDataObject(x))})
  }

  def methodWithHandlerGenericUserType[U: TypeTag](value: U, handler: Handler[GenericRefedInterface[U]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericUserType[Object](toJava[U](value), {x: JGenericRefedInterface[Object] => handler.handle(GenericRefedInterface[U](x))})
  }

  def methodWithHandlerAsyncResultGenericUserType[U: TypeTag](value: U, handler: Handler[AsyncResult[GenericRefedInterface[U]]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericUserType[Object](toJava[U](value), {x: AsyncResult[JGenericRefedInterface[Object]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[Object], GenericRefedInterface[U]](x, a => GenericRefedInterface[U](a)))})
  }

  def methodWithByteReturn(): Byte = {
    asJava.asInstanceOf[JTestInterface].methodWithByteReturn().asInstanceOf[Byte]
  }

  def methodWithShortReturn(): Short = {
    asJava.asInstanceOf[JTestInterface].methodWithShortReturn().asInstanceOf[Short]
  }

  def methodWithIntReturn(): Int = {
    asJava.asInstanceOf[JTestInterface].methodWithIntReturn().asInstanceOf[Int]
  }

  def methodWithLongReturn(): Long = {
    asJava.asInstanceOf[JTestInterface].methodWithLongReturn().asInstanceOf[Long]
  }

  def methodWithFloatReturn(): Float = {
    asJava.asInstanceOf[JTestInterface].methodWithFloatReturn().asInstanceOf[Float]
  }

  def methodWithDoubleReturn(): Double = {
    asJava.asInstanceOf[JTestInterface].methodWithDoubleReturn().asInstanceOf[Double]
  }

  def methodWithBooleanReturn(): Boolean = {
    asJava.asInstanceOf[JTestInterface].methodWithBooleanReturn().asInstanceOf[Boolean]
  }

  def methodWithCharReturn(): Char = {
    asJava.asInstanceOf[JTestInterface].methodWithCharReturn().asInstanceOf[Char]
  }

  def methodWithStringReturn(): String = {
    asJava.asInstanceOf[JTestInterface].methodWithStringReturn().asInstanceOf[String]
  }

  def methodWithVertxGenReturn(): RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JTestInterface].methodWithVertxGenReturn())
  }

  def methodWithVertxGenNullReturn(): RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JTestInterface].methodWithVertxGenNullReturn())
  }

  def methodWithAbstractVertxGenReturn(): RefedInterface2 = {
    RefedInterface2(asJava.asInstanceOf[JTestInterface].methodWithAbstractVertxGenReturn())
  }

  def methodWithDataObjectReturn(): TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectReturn())
  }

  def methodWithDataObjectNullReturn(): TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectNullReturn())
  }

  def methodWithGenericUserTypeReturn[U: TypeTag](value: U): GenericRefedInterface[U] = {
    GenericRefedInterface[U](asJava.asInstanceOf[JTestInterface].methodWithGenericUserTypeReturn[Object](toJava[U](value)))
  }

  def overloadedMethod(str: String, handler: Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str.asInstanceOf[java.lang.String], {x: java.lang.String => handler.handle(x.asInstanceOf[String])}).asInstanceOf[String]
  }

  def overloadedMethod(str: String, refed: RefedInterface1): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str.asInstanceOf[java.lang.String], refed.asJava.asInstanceOf[JRefedInterface1]).asInstanceOf[String]
  }

  def overloadedMethod(str: String, refed: RefedInterface1, handler: Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str.asInstanceOf[java.lang.String], refed.asJava.asInstanceOf[JRefedInterface1], {x: java.lang.String => handler.handle(x.asInstanceOf[String])}).asInstanceOf[String]
  }

  def overloadedMethod(str: String, refed: RefedInterface1, period: Long, handler: Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str.asInstanceOf[java.lang.String], refed.asJava.asInstanceOf[JRefedInterface1], period.asInstanceOf[java.lang.Long], {x: java.lang.String => handler.handle(x.asInstanceOf[String])}).asInstanceOf[String]
  }

  def methodWithGenericReturn[U: TypeTag](`type`: String): U = {
    toScala[U](asJava.asInstanceOf[JTestInterface].methodWithGenericReturn[Object](`type`.asInstanceOf[java.lang.String]))
  }

  def methodWithGenericParam[U: TypeTag](`type`: String, u: U): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericParam[Object](`type`.asInstanceOf[java.lang.String], toJava[U](u))
  }

  def methodWithGenericHandler[U: TypeTag](`type`: String, handler: Handler[U]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandler[Object](`type`.asInstanceOf[java.lang.String], {x: Object => handler.handle(toScala[U](x))})
  }

  def methodWithGenericHandlerAsyncResult[U: TypeTag](`type`: String, asyncResultHandler: Handler[AsyncResult[U]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandlerAsyncResult[Object](`type`.asInstanceOf[java.lang.String], {x: AsyncResult[Object] => asyncResultHandler.handle(AsyncResultWrapper[Object, U](x, a => toScala[U](a)))})
  }

  def methodWithJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonObjectReturn()
  }

  def methodWithNullJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonObjectReturn()
  }

  def methodWithComplexJsonObjectReturn(): io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonObjectReturn()
  }

  def methodWithJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonArrayReturn()
  }

  def methodWithNullJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonArrayReturn()
  }

  def methodWithComplexJsonArrayReturn(): io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonArrayReturn()
  }

  def methodWithJsonParams(jsonObject: io.vertx.core.json.JsonObject, jsonArray: io.vertx.core.json.JsonArray): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonParams(jsonObject, jsonArray)
  }

  def methodWithNullJsonParams(jsonObject: io.vertx.core.json.JsonObject, jsonArray: io.vertx.core.json.JsonArray): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonParams(jsonObject, jsonArray)
  }

  def methodWithHandlerJson(jsonObjectHandler: Handler[io.vertx.core.json.JsonObject], jsonArrayHandler: Handler[io.vertx.core.json.JsonArray]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerJson({x: JsonObject => jsonObjectHandler.handle(x)}, {x: JsonArray => jsonArrayHandler.handle(x)})
  }

  def methodWithHandlerComplexJson(jsonObjectHandler: Handler[io.vertx.core.json.JsonObject], jsonArrayHandler: Handler[io.vertx.core.json.JsonArray]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerComplexJson({x: JsonObject => jsonObjectHandler.handle(x)}, {x: JsonArray => jsonArrayHandler.handle(x)})
  }

  def methodWithHandlerAsyncResultJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultNullJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultComplexJsonObject(handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonObject({x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithHandlerAsyncResultJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithHandlerAsyncResultNullJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithHandlerAsyncResultComplexJsonArray(handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonArray({x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestEnum): String = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumParam(strVal.asInstanceOf[java.lang.String], weirdo).asInstanceOf[String]
  }

  def methodWithEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumReturn(strVal.asInstanceOf[java.lang.String])
  }

  def methodWithGenEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestGenEnum): String = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumParam(strVal.asInstanceOf[java.lang.String], weirdo).asInstanceOf[String]
  }

  def methodWithGenEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumReturn(strVal.asInstanceOf[java.lang.String])
  }

  def methodWithThrowableReturn(strVal: String): Throwable = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableReturn(strVal.asInstanceOf[java.lang.String])
  }

  def methodWithThrowableParam(t: Throwable): String = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableParam(t).asInstanceOf[String]
  }

  def superMethodOverloadedBySubclass(s: String): Int = {
    asJava.asInstanceOf[JTestInterface].superMethodOverloadedBySubclass(s.asInstanceOf[java.lang.String]).asInstanceOf[Int]
  }

  def methodWithHandlerAsyncResultByteFuture(sendFailure: Boolean): scala.concurrent.Future[Byte] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Byte, Byte](x => x.asInstanceOf[Byte])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultByte(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortFuture(sendFailure: Boolean): scala.concurrent.Future[Short] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Short, Short](x => x.asInstanceOf[Short])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultShort(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerFuture(sendFailure: Boolean): scala.concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultInteger(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongFuture(sendFailure: Boolean): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultLong(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatFuture(sendFailure: Boolean): scala.concurrent.Future[Float] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Float, Float](x => x.asInstanceOf[Float])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultFloat(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleFuture(sendFailure: Boolean): scala.concurrent.Future[Double] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Double, Double](x => x.asInstanceOf[Double])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDouble(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanFuture(sendFailure: Boolean): scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultBoolean(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterFuture(sendFailure: Boolean): scala.concurrent.Future[Char] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Character, Char](x => x.asInstanceOf[Char])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultCharacter(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringFuture(sendFailure: Boolean): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultString(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: Boolean): scala.concurrent.Future[TestDataObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTestDataObject, TestDataObject](x => TestDataObject(x))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDataObject(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultUserTypesFuture(): scala.concurrent.Future[RefedInterface1] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRefedInterface1, RefedInterface1](x => RefedInterface1(x))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultUserTypes(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultVoidFuture(sendFailure: Boolean): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVoid(sendFailure.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenericUserTypeFuture[U: TypeTag](value: U): scala.concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Object], GenericRefedInterface[U]](x => GenericRefedInterface[U](x))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericUserType[Object](toJava[U](value), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithGenericHandlerAsyncResultFuture[U: TypeTag](`type`: String): scala.concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, U](x => toScala[U](x))
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandlerAsyncResult[Object](`type`.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonObjectFuture(): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonArrayFuture(): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TestInterface {
  def apply(asJava: JTestInterface) = new TestInterface(asJava)  
  def staticFactoryMethod(foo: String): RefedInterface1 = {
    RefedInterface1(JTestInterface.staticFactoryMethod(foo.asInstanceOf[java.lang.String]))
  }

}
