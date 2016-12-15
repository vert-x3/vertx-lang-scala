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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{TestInterface => JTestInterface}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{AbstractHandlerUserType => JAbstractHandlerUserType}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.{ConcreteHandlerUserType => JConcreteHandlerUserType}
import io.vertx.codegen.testmodel.{ConcreteHandlerUserTypeExtension => JConcreteHandlerUserTypeExtension}
import io.vertx.codegen.testmodel.TestGenEnum
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{SuperInterface1 => JSuperInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.codegen.testmodel.{SuperInterface2 => JSuperInterface2}
import io.vertx.core.json.JsonArray

/**
  */
class TestInterface(private val _asJava: Object) 
    extends SuperInterface2 {

  def asJava: Object = _asJava

  def otherSuperMethodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.asInstanceOf[JTestInterface].otherSuperMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicBoxedParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithBasicBoxedParams(b, s, i, l, f, d, bool, ch)
  }

  def methodWithHandlerBasicTypes(byteHandler: io.vertx.core.Handler[Byte], shortHandler: io.vertx.core.Handler[Short], intHandler: io.vertx.core.Handler[Int], longHandler: io.vertx.core.Handler[Long], floatHandler: io.vertx.core.Handler[Float], doubleHandler: io.vertx.core.Handler[Double], booleanHandler: io.vertx.core.Handler[Boolean], charHandler: io.vertx.core.Handler[Char], stringHandler: io.vertx.core.Handler[String]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerBasicTypes(funcToMappedHandler[java.lang.Byte, Byte](x => x)(byteHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Byte]], funcToMappedHandler[java.lang.Short, Short](x => x)(shortHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Short]], funcToMappedHandler[java.lang.Integer, Int](x => x)(intHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Integer]], funcToMappedHandler[java.lang.Long, Long](x => x)(longHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Long]], funcToMappedHandler[java.lang.Float, Float](x => x)(floatHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Float]], funcToMappedHandler[java.lang.Double, Double](x => x)(doubleHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Double]], funcToMappedHandler[java.lang.Boolean, Boolean](x => x)(booleanHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Boolean]], funcToMappedHandler[java.lang.Character, Char](x => x)(charHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Character]], funcToMappedHandler[java.lang.String, String](x => x)(stringHandler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithHandlerStringReturn(expected: String): io.vertx.core.Handler[String] = {
    (asJava.asInstanceOf[JTestInterface].methodWithHandlerStringReturn(expected))
  }

  def methodWithHandlerGenericReturn[T: TypeTag](handler: io.vertx.core.Handler[T]): io.vertx.core.Handler[T] = {
    (asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericReturn((handler).asInstanceOf[io.vertx.core.Handler[Object]]))
  }

  def methodWithHandlerVertxGenReturn(expected: String): io.vertx.core.Handler[RefedInterface1] = {
    handlerToMappedFunction[JRefedInterface1, RefedInterface1](x => x.asJava.asInstanceOf[JRefedInterface1])(asJava.asInstanceOf[JTestInterface].methodWithHandlerVertxGenReturn(expected))
  }

  def methodWithHandlerAsyncResultByteFuture(sendFailure: Boolean): concurrent.Future[Byte] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Byte]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultByte(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Byte]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortFuture(sendFailure: Boolean): concurrent.Future[Short] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Short]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultShort(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Short]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerFuture(sendFailure: Boolean): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Int]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultInteger(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Integer]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongFuture(sendFailure: Boolean): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Long]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultLong(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Long]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatFuture(sendFailure: Boolean): concurrent.Future[Float] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Float]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultFloat(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Float]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleFuture(sendFailure: Boolean): concurrent.Future[Double] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Double]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDouble(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Double]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanFuture(sendFailure: Boolean): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultBoolean(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterFuture(sendFailure: Boolean): concurrent.Future[Char] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Char]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultCharacter(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Character]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringFuture(sendFailure: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultString(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: Boolean): concurrent.Future[TestDataObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TestDataObject]((x => io.vertx.scala.codegen.testmodel.TestDataObject(x.asInstanceOf)))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultDataObject(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestDataObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringReturn(expected: String, fail: Boolean): io.vertx.core.Handler[io.vertx.core.AsyncResult[String]] = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultStringReturn(expected, fail)
  }

  def methodWithHandlerAsyncResultGenericReturn[T: TypeTag](handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]): io.vertx.core.Handler[io.vertx.core.AsyncResult[T]] = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericReturn((handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
  }

  def methodWithHandlerAsyncResultVertxGenReturn(expected: String, fail: Boolean): io.vertx.core.Handler[io.vertx.core.AsyncResult[RefedInterface1]] = {
    handlerToMappedFunction[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1], io.vertx.core.AsyncResult[RefedInterface1]](s => if (s.failed()) io.vertx.lang.scala.ScalaAsyncResult(cause = s.cause()) else io.vertx.lang.scala.ScalaAsyncResult(result = s.result.asJava.asInstanceOf[JRefedInterface1])) (asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVertxGenReturn(expected, fail))
  }

  def methodWithUserTypes(refed: RefedInterface1): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithUserTypes(refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithObjectParam(str: String, obj: AnyRef): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithObjectParam(str, toJava[java.lang.Object](obj).asInstanceOf[Object])
  }

  def methodWithDataObjectParam(dataObject: TestDataObject): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithDataObjectParam(dataObject.asJava)
  }

  def methodWithHandlerUserTypes(handler: io.vertx.core.Handler[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerUserTypes(funcToMappedHandler[JRefedInterface1, RefedInterface1](RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithHandlerAsyncResultUserTypesFuture(): concurrent.Future[RefedInterface1] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[RefedInterface1]((x => if (x == null) null else RefedInterface1.apply(x.asInstanceOf)))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultUserTypes(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]]])
    promiseAndHandler._2.future
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

  def methodWithHandlerVoid(handler: io.vertx.core.Handler[Unit]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerVoid(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
  }

  def methodWithHandlerAsyncResultVoidFuture(sendFailure: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultVoid(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerThrowable(handler: io.vertx.core.Handler[Throwable]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerThrowable(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
  }

  def methodWithHandlerDataObject(handler: io.vertx.core.Handler[TestDataObject]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerDataObject(funcToMappedHandler[JTestDataObject, TestDataObject](a => TestDataObject(a))(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithHandlerGenericUserType[U: TypeTag](value: U, handler: io.vertx.core.Handler[GenericRefedInterface[U]]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerGenericUserType(toJava[U](value).asInstanceOf[Object], funcToMappedHandler[JGenericRefedInterface[U], GenericRefedInterface[U]](GenericRefedInterface.apply[U])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]])
  }

  def methodWithHandlerAsyncResultGenericUserTypeFuture[U: TypeTag](value: U): concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[U]]((x => if (x == null) null else GenericRefedInterface.apply[U](x.asInstanceOf)))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultGenericUserType(toJava[U](value).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]]])
    promiseAndHandler._2.future
  }

  def methodWithByteReturn(): Byte = {
    asJava.asInstanceOf[JTestInterface].methodWithByteReturn()
  }

  def methodWithShortReturn(): Short = {
    asJava.asInstanceOf[JTestInterface].methodWithShortReturn()
  }

  def methodWithIntReturn(): Int = {
    asJava.asInstanceOf[JTestInterface].methodWithIntReturn()
  }

  def methodWithLongReturn(): Long = {
    asJava.asInstanceOf[JTestInterface].methodWithLongReturn()
  }

  def methodWithFloatReturn(): Float = {
    asJava.asInstanceOf[JTestInterface].methodWithFloatReturn()
  }

  def methodWithDoubleReturn(): Double = {
    asJava.asInstanceOf[JTestInterface].methodWithDoubleReturn()
  }

  def methodWithBooleanReturn(): Boolean = {
    asJava.asInstanceOf[JTestInterface].methodWithBooleanReturn()
  }

  def methodWithCharReturn(): Char = {
    asJava.asInstanceOf[JTestInterface].methodWithCharReturn()
  }

  def methodWithStringReturn(): String = {
    asJava.asInstanceOf[JTestInterface].methodWithStringReturn()
  }

  def methodWithVertxGenReturn(): RefedInterface1 = {
    RefedInterface1.apply(asJava.asInstanceOf[JTestInterface].methodWithVertxGenReturn())
  }

  def methodWithVertxGenNullReturn(): RefedInterface1 = {
    RefedInterface1.apply(asJava.asInstanceOf[JTestInterface].methodWithVertxGenNullReturn())
  }

  def methodWithAbstractVertxGenReturn(): RefedInterface2 = {
    RefedInterface2.apply(asJava.asInstanceOf[JTestInterface].methodWithAbstractVertxGenReturn())
  }

  def methodWithDataObjectReturn(): TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectReturn())
  }

  def methodWithDataObjectNullReturn(): TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JTestInterface].methodWithDataObjectNullReturn())
  }

  def methodWithGenericUserTypeReturn[U: TypeTag](value: U): GenericRefedInterface[U] = {
    GenericRefedInterface.apply[U](asJava.asInstanceOf[JTestInterface].methodWithGenericUserTypeReturn(toJava[U](value).asInstanceOf[Object]))
  }

  def overloadedMethod(str: String, handler: io.vertx.core.Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def overloadedMethod(str: String, refed: RefedInterface1): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def overloadedMethod(str: String, refed: RefedInterface1, handler: io.vertx.core.Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1], funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def overloadedMethod(str: String, refed: RefedInterface1, period: Long, handler: io.vertx.core.Handler[String]): String = {
    asJava.asInstanceOf[JTestInterface].overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1], period, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithGenericReturn[U: TypeTag](`type`: String): U = {
    toScala[U](asJava.asInstanceOf[JTestInterface].methodWithGenericReturn(`type`))
  }

  def methodWithGenericParam[U: TypeTag](`type`: String, u: U): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericParam(`type`, toJava[U](u).asInstanceOf[Object])
  }

  def methodWithGenericHandler[U: TypeTag](`type`: String, handler: io.vertx.core.Handler[U]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandler(`type`, (handler).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithGenericHandlerAsyncResultFuture[U: TypeTag](`type`: String): concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[U]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithGenericHandlerAsyncResult(`type`, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def fluentMethod(str: String): TestInterface = {
    asJava.asInstanceOf[JTestInterface].fluentMethod(str)
    this
  }

  def methodWithCachedReturn(foo: String): RefedInterface1 = {
    if (cached_0 == null) {
      cached_0 = RefedInterface1.apply(asJava.asInstanceOf[JTestInterface].methodWithCachedReturn(foo)).asInstanceOf
    }
    cached_0
  }

  def methodWithCachedReturnPrimitive(arg: Int): Int = {
    if (cached_1 == null) {
      cached_1 = asJava.asInstanceOf[JTestInterface].methodWithCachedReturnPrimitive(arg).asInstanceOf
    }
    cached_1
  }

  def methodWithCachedListReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    if (cached_2 == null) {
      cached_2 = asJava.asInstanceOf[JTestInterface].methodWithCachedListReturn().asScala.map(RefedInterface1.apply).asInstanceOf
    }
    cached_2
  }

  def methodWithJsonObjectReturn(): JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonObjectReturn()
  }

  def methodWithNullJsonObjectReturn(): JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonObjectReturn()
  }

  def methodWithComplexJsonObjectReturn(): JsonObject = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonObjectReturn()
  }

  def methodWithJsonArrayReturn(): JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonArrayReturn()
  }

  def methodWithNullJsonArrayReturn(): JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonArrayReturn()
  }

  def methodWithComplexJsonArrayReturn(): JsonArray = {
    asJava.asInstanceOf[JTestInterface].methodWithComplexJsonArrayReturn()
  }

  def methodWithJsonParams(jsonObject: JsonObject, jsonArray: JsonArray): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithJsonParams(jsonObject, jsonArray)
  }

  def methodWithNullJsonParams(jsonObject: JsonObject, jsonArray: JsonArray): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithNullJsonParams(jsonObject, jsonArray)
  }

  def methodWithHandlerJson(jsonObjectHandler: io.vertx.core.Handler[JsonObject], jsonArrayHandler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerJson(funcToMappedHandler[JsonObject, JsonObject](x => x)(jsonObjectHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]], funcToMappedHandler[JsonArray, JsonArray](x => x)(jsonArrayHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithHandlerComplexJson(jsonObjectHandler: io.vertx.core.Handler[JsonObject], jsonArrayHandler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.asInstanceOf[JTestInterface].methodWithHandlerComplexJson(funcToMappedHandler[JsonObject, JsonObject](x => x)(jsonObjectHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]], funcToMappedHandler[JsonArray, JsonArray](x => x)(jsonArrayHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithHandlerAsyncResultJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultNullJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.asInstanceOf[JTestInterface].methodWithHandlerAsyncResultComplexJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestEnum): String = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumParam(strVal, weirdo)
  }

  def methodWithEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithEnumReturn(strVal)
  }

  def methodWithGenEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestGenEnum): String = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumParam(strVal, weirdo)
  }

  def methodWithGenEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.asInstanceOf[JTestInterface].methodWithGenEnumReturn(strVal)
  }

  def methodWithThrowableReturn(strVal: String): Throwable = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableReturn(strVal)
  }

  def methodWithThrowableParam(t: Throwable): String = {
    asJava.asInstanceOf[JTestInterface].methodWithThrowableParam(t)
  }

  def superMethodOverloadedBySubclass(s: String): Int = {
    asJava.asInstanceOf[JTestInterface].superMethodOverloadedBySubclass(s)
  }

  private var cached_0: RefedInterface1 = _
  private var cached_1: Int = _
  private var cached_2: scala.collection.mutable.Buffer[RefedInterface1] = _
}

object TestInterface {

  def apply(_asJava: Object): TestInterface =
    new TestInterface(_asJava)

  def staticFactoryMethod(foo: String): RefedInterface1 = {
    RefedInterface1.apply(io.vertx.codegen.testmodel.TestInterface.staticFactoryMethod(foo))
  }

}
