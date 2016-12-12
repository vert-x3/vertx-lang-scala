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
class TestInterface(private val _asJava: JTestInterface) 
    extends SuperInterface2 {

  def asJava: JTestInterface = _asJava

  def otherSuperMethodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.otherSuperMethodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char, str: String): Unit = {
    asJava.methodWithBasicParams(b, s, i, l, f, d, bool, ch, str)
  }

  def methodWithBasicBoxedParams(b: Byte, s: Short, i: Int, l: Long, f: Float, d: Double, bool: Boolean, ch: Char): Unit = {
    asJava.methodWithBasicBoxedParams(b, s, i, l, f, d, bool, ch)
  }

  def methodWithHandlerBasicTypes(byteHandler: io.vertx.core.Handler[Byte], shortHandler: io.vertx.core.Handler[Short], intHandler: io.vertx.core.Handler[Int], longHandler: io.vertx.core.Handler[Long], floatHandler: io.vertx.core.Handler[Float], doubleHandler: io.vertx.core.Handler[Double], booleanHandler: io.vertx.core.Handler[Boolean], charHandler: io.vertx.core.Handler[Char], stringHandler: io.vertx.core.Handler[String]): Unit = {
    asJava.methodWithHandlerBasicTypes(funcToMappedHandler[java.lang.Byte, Byte](x => x)(byteHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Byte]], funcToMappedHandler[java.lang.Short, Short](x => x)(shortHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Short]], funcToMappedHandler[java.lang.Integer, Int](x => x)(intHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Integer]], funcToMappedHandler[java.lang.Long, Long](x => x)(longHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Long]], funcToMappedHandler[java.lang.Float, Float](x => x)(floatHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Float]], funcToMappedHandler[java.lang.Double, Double](x => x)(doubleHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Double]], funcToMappedHandler[java.lang.Boolean, Boolean](x => x)(booleanHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Boolean]], funcToMappedHandler[java.lang.Character, Char](x => x)(charHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Character]], funcToMappedHandler[java.lang.String, String](x => x)(stringHandler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithHandlerStringReturn(expected: String): io.vertx.core.Handler[String] = {
    (asJava.methodWithHandlerStringReturn(expected))
  }

  def methodWithHandlerGenericReturn[T: TypeTag](handler: io.vertx.core.Handler[T]): io.vertx.core.Handler[T] = {
    (asJava.methodWithHandlerGenericReturn((handler).asInstanceOf[io.vertx.core.Handler[Object]]))
  }

  def methodWithHandlerVertxGenReturn(expected: String): io.vertx.core.Handler[RefedInterface1] = {
    handlerToMappedFunction[JRefedInterface1, RefedInterface1](x => x.asJava)(asJava.methodWithHandlerVertxGenReturn(expected))
  }

  def methodWithHandlerAsyncResultByteFuture(sendFailure: Boolean): concurrent.Future[Byte] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Byte]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultByte(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Byte]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortFuture(sendFailure: Boolean): concurrent.Future[Short] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Short]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultShort(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Short]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerFuture(sendFailure: Boolean): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Int]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultInteger(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Integer]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongFuture(sendFailure: Boolean): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Long]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultLong(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Long]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatFuture(sendFailure: Boolean): concurrent.Future[Float] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Float]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultFloat(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Float]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleFuture(sendFailure: Boolean): concurrent.Future[Double] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Double]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultDouble(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Double]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanFuture(sendFailure: Boolean): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultBoolean(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterFuture(sendFailure: Boolean): concurrent.Future[Char] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Char]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultCharacter(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Character]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringFuture(sendFailure: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultString(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectFuture(sendFailure: Boolean): concurrent.Future[TestDataObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TestDataObject]((x => io.vertx.scala.codegen.testmodel.TestDataObject(x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultDataObject(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestDataObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringReturn(expected: String, fail: Boolean): io.vertx.core.Handler[io.vertx.core.AsyncResult[String]] = {
    asJava.methodWithHandlerAsyncResultStringReturn(expected, fail)
  }

  def methodWithHandlerAsyncResultGenericReturn[T: TypeTag](handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]): io.vertx.core.Handler[io.vertx.core.AsyncResult[T]] = {
    asJava.methodWithHandlerAsyncResultGenericReturn((handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
  }

  def methodWithHandlerAsyncResultVertxGenReturn(expected: String, fail: Boolean): io.vertx.core.Handler[io.vertx.core.AsyncResult[RefedInterface1]] = {
    handlerToMappedFunction[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1], io.vertx.core.AsyncResult[RefedInterface1]](s => if (s.failed()) io.vertx.lang.scala.ScalaAsyncResult(cause = s.cause()) else io.vertx.lang.scala.ScalaAsyncResult(result = s.result.asJava)) (asJava.methodWithHandlerAsyncResultVertxGenReturn(expected, fail))
  }

  def methodWithUserTypes(refed: RefedInterface1): Unit = {
    asJava.methodWithUserTypes(refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithObjectParam(str: String, obj: AnyRef): Unit = {
    asJava.methodWithObjectParam(str, toJava[java.lang.Object](obj).asInstanceOf[Object])
  }

  def methodWithDataObjectParam(dataObject: TestDataObject): Unit = {
    asJava.methodWithDataObjectParam(dataObject.asJava)
  }

  def methodWithHandlerUserTypes(handler: io.vertx.core.Handler[RefedInterface1]): Unit = {
    asJava.methodWithHandlerUserTypes(funcToMappedHandler(RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithHandlerAsyncResultUserTypesFuture(): concurrent.Future[RefedInterface1] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[RefedInterface1]((x => if (x == null) null else RefedInterface1.apply(x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultUserTypes(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]]])
    promiseAndHandler._2.future
  }

  def methodWithConcreteHandlerUserTypeSubtype(handler: ConcreteHandlerUserType): Unit = {
    asJava.methodWithConcreteHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JConcreteHandlerUserType])
  }

  def methodWithAbstractHandlerUserTypeSubtype(handler: AbstractHandlerUserType): Unit = {
    asJava.methodWithAbstractHandlerUserTypeSubtype(handler.asJava.asInstanceOf[JAbstractHandlerUserType])
  }

  def methodWithConcreteHandlerUserTypeSubtypeExtension(handler: ConcreteHandlerUserTypeExtension): Unit = {
    asJava.methodWithConcreteHandlerUserTypeSubtypeExtension(handler.asJava.asInstanceOf[JConcreteHandlerUserTypeExtension])
  }

  def methodWithHandlerVoid(handler: io.vertx.core.Handler[Unit]): Unit = {
    asJava.methodWithHandlerVoid(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
  }

  def methodWithHandlerAsyncResultVoidFuture(sendFailure: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.methodWithHandlerAsyncResultVoid(sendFailure, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerThrowable(handler: io.vertx.core.Handler[Throwable]): Unit = {
    asJava.methodWithHandlerThrowable(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
  }

  def methodWithHandlerDataObject(handler: io.vertx.core.Handler[TestDataObject]): Unit = {
    asJava.methodWithHandlerDataObject(funcToMappedHandler[JTestDataObject, TestDataObject](a => TestDataObject(a))(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithHandlerGenericUserType[U: TypeTag](value: U, handler: io.vertx.core.Handler[GenericRefedInterface[U]]): Unit = {
    asJava.methodWithHandlerGenericUserType(toJava[U](value).asInstanceOf[Object], funcToMappedHandler(GenericRefedInterface.apply[U])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]])
  }

  def methodWithHandlerAsyncResultGenericUserTypeFuture[U: TypeTag](value: U): concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[U]]((x => if (x == null) null else GenericRefedInterface.apply[U](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultGenericUserType(toJava[U](value).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]]])
    promiseAndHandler._2.future
  }

  def methodWithByteReturn(): Byte = {
    asJava.methodWithByteReturn()
  }

  def methodWithShortReturn(): Short = {
    asJava.methodWithShortReturn()
  }

  def methodWithIntReturn(): Int = {
    asJava.methodWithIntReturn()
  }

  def methodWithLongReturn(): Long = {
    asJava.methodWithLongReturn()
  }

  def methodWithFloatReturn(): Float = {
    asJava.methodWithFloatReturn()
  }

  def methodWithDoubleReturn(): Double = {
    asJava.methodWithDoubleReturn()
  }

  def methodWithBooleanReturn(): Boolean = {
    asJava.methodWithBooleanReturn()
  }

  def methodWithCharReturn(): Char = {
    asJava.methodWithCharReturn()
  }

  def methodWithStringReturn(): String = {
    asJava.methodWithStringReturn()
  }

  def methodWithVertxGenReturn(): RefedInterface1 = {
    RefedInterface1.apply(asJava.methodWithVertxGenReturn())
  }

  def methodWithVertxGenNullReturn(): RefedInterface1 = {
    RefedInterface1.apply(asJava.methodWithVertxGenNullReturn())
  }

  def methodWithAbstractVertxGenReturn(): RefedInterface2 = {
    RefedInterface2.apply(asJava.methodWithAbstractVertxGenReturn())
  }

  def methodWithDataObjectReturn(): TestDataObject = {
    TestDataObject(asJava.methodWithDataObjectReturn())
  }

  def methodWithDataObjectNullReturn(): TestDataObject = {
    TestDataObject(asJava.methodWithDataObjectNullReturn())
  }

  def methodWithGenericUserTypeReturn[U: TypeTag](value: U): GenericRefedInterface[U] = {
    GenericRefedInterface.apply[U](asJava.methodWithGenericUserTypeReturn(toJava[U](value).asInstanceOf[Object]))
  }

  def overloadedMethod(str: String, handler: io.vertx.core.Handler[String]): String = {
    asJava.overloadedMethod(str, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def overloadedMethod(str: String, refed: RefedInterface1): String = {
    asJava.overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1])
  }

  def overloadedMethod(str: String, refed: RefedInterface1, handler: io.vertx.core.Handler[String]): String = {
    asJava.overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1], funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def overloadedMethod(str: String, refed: RefedInterface1, period: Long, handler: io.vertx.core.Handler[String]): String = {
    asJava.overloadedMethod(str, refed.asJava.asInstanceOf[JRefedInterface1], period, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithGenericReturn[U: TypeTag](`type`: String): U = {
    toScala[U](asJava.methodWithGenericReturn(`type`))
  }

  def methodWithGenericParam[U: TypeTag](`type`: String, u: U): Unit = {
    asJava.methodWithGenericParam(`type`, toJava[U](u).asInstanceOf[Object])
  }

  def methodWithGenericHandler[U: TypeTag](`type`: String, handler: io.vertx.core.Handler[U]): Unit = {
    asJava.methodWithGenericHandler(`type`, (handler).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithGenericHandlerAsyncResultFuture[U: TypeTag](`type`: String): concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[U]((x => x.asInstanceOf))
    asJava.methodWithGenericHandlerAsyncResult(`type`, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def fluentMethod(str: String): TestInterface = {
    asJava.fluentMethod(str)
    this
  }

  def methodWithCachedReturn(foo: String): RefedInterface1 = {
    if (cached_0 == null) {
      cached_0 = RefedInterface1.apply(asJava.methodWithCachedReturn(foo)).asInstanceOf
    }
    cached_0
  }

  def methodWithCachedReturnPrimitive(arg: Int): Int = {
    if (cached_1 == null) {
      cached_1 = asJava.methodWithCachedReturnPrimitive(arg).asInstanceOf
    }
    cached_1
  }

  def methodWithCachedListReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    if (cached_2 == null) {
      cached_2 = asJava.methodWithCachedListReturn().asScala.map(RefedInterface1.apply).asInstanceOf
    }
    cached_2
  }

  def methodWithJsonObjectReturn(): JsonObject = {
    asJava.methodWithJsonObjectReturn()
  }

  def methodWithNullJsonObjectReturn(): JsonObject = {
    asJava.methodWithNullJsonObjectReturn()
  }

  def methodWithComplexJsonObjectReturn(): JsonObject = {
    asJava.methodWithComplexJsonObjectReturn()
  }

  def methodWithJsonArrayReturn(): JsonArray = {
    asJava.methodWithJsonArrayReturn()
  }

  def methodWithNullJsonArrayReturn(): JsonArray = {
    asJava.methodWithNullJsonArrayReturn()
  }

  def methodWithComplexJsonArrayReturn(): JsonArray = {
    asJava.methodWithComplexJsonArrayReturn()
  }

  def methodWithJsonParams(jsonObject: JsonObject, jsonArray: JsonArray): Unit = {
    asJava.methodWithJsonParams(jsonObject, jsonArray)
  }

  def methodWithNullJsonParams(jsonObject: JsonObject, jsonArray: JsonArray): Unit = {
    asJava.methodWithNullJsonParams(jsonObject, jsonArray)
  }

  def methodWithHandlerJson(jsonObjectHandler: io.vertx.core.Handler[JsonObject], jsonArrayHandler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.methodWithHandlerJson(funcToMappedHandler[JsonObject, JsonObject](x => x)(jsonObjectHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]], funcToMappedHandler[JsonArray, JsonArray](x => x)(jsonArrayHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithHandlerComplexJson(jsonObjectHandler: io.vertx.core.Handler[JsonObject], jsonArrayHandler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.methodWithHandlerComplexJson(funcToMappedHandler[JsonObject, JsonObject](x => x)(jsonObjectHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]], funcToMappedHandler[JsonArray, JsonArray](x => x)(jsonArrayHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithHandlerAsyncResultJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultNullJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonObjectFuture(): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultComplexJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultNullJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultNullJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultComplexJsonArrayFuture(): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.methodWithHandlerAsyncResultComplexJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestEnum): String = {
    asJava.methodWithEnumParam(strVal, weirdo)
  }

  def methodWithEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestEnum = {
    asJava.methodWithEnumReturn(strVal)
  }

  def methodWithGenEnumParam(strVal: String, weirdo: io.vertx.codegen.testmodel.TestGenEnum): String = {
    asJava.methodWithGenEnumParam(strVal, weirdo)
  }

  def methodWithGenEnumReturn(strVal: String): io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.methodWithGenEnumReturn(strVal)
  }

  def methodWithThrowableReturn(strVal: String): Throwable = {
    asJava.methodWithThrowableReturn(strVal)
  }

  def methodWithThrowableParam(t: Throwable): String = {
    asJava.methodWithThrowableParam(t)
  }

  def superMethodOverloadedBySubclass(s: String): Int = {
    asJava.superMethodOverloadedBySubclass(s)
  }

  private var cached_0: RefedInterface1 = _
  private var cached_1: Int = _
  private var cached_2: scala.collection.mutable.Buffer[RefedInterface1] = _
}

object TestInterface {

  def apply(_asJava: JTestInterface): TestInterface =
    new TestInterface(_asJava)

  def staticFactoryMethod(foo: String): RefedInterface1 = {
    RefedInterface1.apply(io.vertx.codegen.testmodel.TestInterface.staticFactoryMethod(foo))
  }

}
