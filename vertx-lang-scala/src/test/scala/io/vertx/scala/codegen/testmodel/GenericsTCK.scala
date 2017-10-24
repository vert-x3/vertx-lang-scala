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
import io.vertx.codegen.testmodel.{InterfaceWithStringArg => JInterfaceWithStringArg}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.scala.codegen.testmodel.GenericRefedInterface
import io.vertx.codegen.testmodel.{GenericsTCK => JGenericsTCK}
import io.vertx.codegen.testmodel.{GenericNullableRefedInterface => JGenericNullableRefedInterface}
import io.vertx.core.json.JsonArray
import io.vertx.scala.codegen.testmodel.GenericNullableRefedInterface
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.codegen.testmodel.{InterfaceWithApiArg => JInterfaceWithApiArg}
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
class GenericsTCK(private val _asJava: Object) {

  def asJava = _asJava


  def methodWithByteParameterizedReturn(): GenericRefedInterface[Byte] = {
    GenericRefedInterface[Byte](asJava.asInstanceOf[JGenericsTCK].methodWithByteParameterizedReturn())
  }

  def methodWithShortParameterizedReturn(): GenericRefedInterface[Short] = {
    GenericRefedInterface[Short](asJava.asInstanceOf[JGenericsTCK].methodWithShortParameterizedReturn())
  }

  def methodWithIntegerParameterizedReturn(): GenericRefedInterface[Int] = {
    GenericRefedInterface[Int](asJava.asInstanceOf[JGenericsTCK].methodWithIntegerParameterizedReturn())
  }

  def methodWithLongParameterizedReturn(): GenericRefedInterface[Long] = {
    GenericRefedInterface[Long](asJava.asInstanceOf[JGenericsTCK].methodWithLongParameterizedReturn())
  }

  def methodWithFloatParameterizedReturn(): GenericRefedInterface[Float] = {
    GenericRefedInterface[Float](asJava.asInstanceOf[JGenericsTCK].methodWithFloatParameterizedReturn())
  }

  def methodWithDoubleParameterizedReturn(): GenericRefedInterface[Double] = {
    GenericRefedInterface[Double](asJava.asInstanceOf[JGenericsTCK].methodWithDoubleParameterizedReturn())
  }

  def methodWithBooleanParameterizedReturn(): GenericRefedInterface[Boolean] = {
    GenericRefedInterface[Boolean](asJava.asInstanceOf[JGenericsTCK].methodWithBooleanParameterizedReturn())
  }

  def methodWithCharacterParameterizedReturn(): GenericRefedInterface[Char] = {
    GenericRefedInterface[Char](asJava.asInstanceOf[JGenericsTCK].methodWithCharacterParameterizedReturn())
  }

  def methodWithStringParameterizedReturn(): GenericRefedInterface[String] = {
    GenericRefedInterface[String](asJava.asInstanceOf[JGenericsTCK].methodWithStringParameterizedReturn())
  }

  def methodWithJsonObjectParameterizedReturn(): GenericRefedInterface[io.vertx.core.json.JsonObject] = {
    GenericRefedInterface[io.vertx.core.json.JsonObject](asJava.asInstanceOf[JGenericsTCK].methodWithJsonObjectParameterizedReturn())
  }

  def methodWithJsonArrayParameterizedReturn(): GenericRefedInterface[io.vertx.core.json.JsonArray] = {
    GenericRefedInterface[io.vertx.core.json.JsonArray](asJava.asInstanceOf[JGenericsTCK].methodWithJsonArrayParameterizedReturn())
  }

  def methodWithDataObjectParameterizedReturn(): GenericRefedInterface[TestDataObject] = {
    GenericRefedInterface[TestDataObject](asJava.asInstanceOf[JGenericsTCK].methodWithDataObjectParameterizedReturn())
  }

  def methodWithEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] = {
    GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum](asJava.asInstanceOf[JGenericsTCK].methodWithEnumParameterizedReturn())
  }

  def methodWithGenEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] = {
    GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum](asJava.asInstanceOf[JGenericsTCK].methodWithGenEnumParameterizedReturn())
  }

  def methodWithUserTypeParameterizedReturn(): GenericRefedInterface[RefedInterface1] = {
    GenericRefedInterface[RefedInterface1](asJava.asInstanceOf[JGenericsTCK].methodWithUserTypeParameterizedReturn())
  }

  def methodWithHandlerByteParameterized(handler: Handler[GenericRefedInterface[Byte]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerByteParameterized({x: JGenericRefedInterface[java.lang.Byte] => handler.handle(GenericRefedInterface[Byte](x))})
  }

  def methodWithHandlerShortParameterized(handler: Handler[GenericRefedInterface[Short]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerShortParameterized({x: JGenericRefedInterface[java.lang.Short] => handler.handle(GenericRefedInterface[Short](x))})
  }

  def methodWithHandlerIntegerParameterized(handler: Handler[GenericRefedInterface[Int]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerIntegerParameterized({x: JGenericRefedInterface[java.lang.Integer] => handler.handle(GenericRefedInterface[Int](x))})
  }

  def methodWithHandlerLongParameterized(handler: Handler[GenericRefedInterface[Long]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerLongParameterized({x: JGenericRefedInterface[java.lang.Long] => handler.handle(GenericRefedInterface[Long](x))})
  }

  def methodWithHandlerFloatParameterized(handler: Handler[GenericRefedInterface[Float]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerFloatParameterized({x: JGenericRefedInterface[java.lang.Float] => handler.handle(GenericRefedInterface[Float](x))})
  }

  def methodWithHandlerDoubleParameterized(handler: Handler[GenericRefedInterface[Double]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerDoubleParameterized({x: JGenericRefedInterface[java.lang.Double] => handler.handle(GenericRefedInterface[Double](x))})
  }

  def methodWithHandlerBooleanParameterized(handler: Handler[GenericRefedInterface[Boolean]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerBooleanParameterized({x: JGenericRefedInterface[java.lang.Boolean] => handler.handle(GenericRefedInterface[Boolean](x))})
  }

  def methodWithHandlerCharacterParameterized(handler: Handler[GenericRefedInterface[Char]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerCharacterParameterized({x: JGenericRefedInterface[java.lang.Character] => handler.handle(GenericRefedInterface[Char](x))})
  }

  def methodWithHandlerStringParameterized(handler: Handler[GenericRefedInterface[String]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerStringParameterized({x: JGenericRefedInterface[java.lang.String] => handler.handle(GenericRefedInterface[String](x))})
  }

  def methodWithHandlerJsonObjectParameterized(handler: Handler[GenericRefedInterface[io.vertx.core.json.JsonObject]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerJsonObjectParameterized({x: JGenericRefedInterface[JsonObject] => handler.handle(GenericRefedInterface[io.vertx.core.json.JsonObject](x))})
  }

  def methodWithHandlerJsonArrayParameterized(handler: Handler[GenericRefedInterface[io.vertx.core.json.JsonArray]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerJsonArrayParameterized({x: JGenericRefedInterface[JsonArray] => handler.handle(GenericRefedInterface[io.vertx.core.json.JsonArray](x))})
  }

  def methodWithHandlerDataObjectParameterized(handler: Handler[GenericRefedInterface[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerDataObjectParameterized({x: JGenericRefedInterface[JTestDataObject] => handler.handle(GenericRefedInterface[TestDataObject](x))})
  }

  def methodWithHandlerEnumParameterized(handler: Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerEnumParameterized({x: JGenericRefedInterface[TestEnum] => handler.handle(GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum](x))})
  }

  def methodWithHandlerGenEnumParameterized(handler: Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerGenEnumParameterized({x: JGenericRefedInterface[TestGenEnum] => handler.handle(GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum](x))})
  }

  def methodWithHandlerUserTypeParameterized(handler: Handler[GenericRefedInterface[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerUserTypeParameterized({x: JGenericRefedInterface[JRefedInterface1] => handler.handle(GenericRefedInterface[RefedInterface1](x))})
  }

  def methodWithHandlerAsyncResultByteParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Byte]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultByteParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Byte]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Byte], GenericRefedInterface[Byte]](x, a => GenericRefedInterface[Byte](a)))})
  }

  def methodWithHandlerAsyncResultShortParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Short]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultShortParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Short]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Short], GenericRefedInterface[Short]](x, a => GenericRefedInterface[Short](a)))})
  }

  def methodWithHandlerAsyncResultIntegerParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Int]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultIntegerParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Integer]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Integer], GenericRefedInterface[Int]](x, a => GenericRefedInterface[Int](a)))})
  }

  def methodWithHandlerAsyncResultLongParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Long]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultLongParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Long]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Long], GenericRefedInterface[Long]](x, a => GenericRefedInterface[Long](a)))})
  }

  def methodWithHandlerAsyncResultFloatParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Float]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultFloatParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Float]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Float], GenericRefedInterface[Float]](x, a => GenericRefedInterface[Float](a)))})
  }

  def methodWithHandlerAsyncResultDoubleParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Double]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDoubleParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Double]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Double], GenericRefedInterface[Double]](x, a => GenericRefedInterface[Double](a)))})
  }

  def methodWithHandlerAsyncResultBooleanParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Boolean]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultBooleanParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Boolean]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Boolean], GenericRefedInterface[Boolean]](x, a => GenericRefedInterface[Boolean](a)))})
  }

  def methodWithHandlerAsyncResultCharacterParameterized(handler: Handler[AsyncResult[GenericRefedInterface[Char]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultCharacterParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.Character]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.Character], GenericRefedInterface[Char]](x, a => GenericRefedInterface[Char](a)))})
  }

  def methodWithHandlerAsyncResultStringParameterized(handler: Handler[AsyncResult[GenericRefedInterface[String]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultStringParameterized({x: AsyncResult[JGenericRefedInterface[java.lang.String]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[java.lang.String], GenericRefedInterface[String]](x, a => GenericRefedInterface[String](a)))})
  }

  def methodWithHandlerAsyncResultJsonObjectParameterized(handler: Handler[AsyncResult[GenericRefedInterface[io.vertx.core.json.JsonObject]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonObjectParameterized({x: AsyncResult[JGenericRefedInterface[JsonObject]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[JsonObject], GenericRefedInterface[io.vertx.core.json.JsonObject]](x, a => GenericRefedInterface[io.vertx.core.json.JsonObject](a)))})
  }

  def methodWithHandlerAsyncResultJsonArrayParameterized(handler: Handler[AsyncResult[GenericRefedInterface[io.vertx.core.json.JsonArray]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonArrayParameterized({x: AsyncResult[JGenericRefedInterface[JsonArray]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[JsonArray], GenericRefedInterface[io.vertx.core.json.JsonArray]](x, a => GenericRefedInterface[io.vertx.core.json.JsonArray](a)))})
  }

  def methodWithHandlerAsyncResultDataObjectParameterized(handler: Handler[AsyncResult[GenericRefedInterface[TestDataObject]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDataObjectParameterized({x: AsyncResult[JGenericRefedInterface[JTestDataObject]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[JTestDataObject], GenericRefedInterface[TestDataObject]](x, a => GenericRefedInterface[TestDataObject](a)))})
  }

  def methodWithHandlerAsyncResultEnumParameterized(handler: Handler[AsyncResult[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultEnumParameterized({x: AsyncResult[JGenericRefedInterface[TestEnum]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[TestEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]](x, a => GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum](a)))})
  }

  def methodWithHandlerAsyncResultGenEnumParameterized(handler: Handler[AsyncResult[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenEnumParameterized({x: AsyncResult[JGenericRefedInterface[TestGenEnum]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[TestGenEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]](x, a => GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum](a)))})
  }

  def methodWithHandlerAsyncResultUserTypeParameterized(handler: Handler[AsyncResult[GenericRefedInterface[RefedInterface1]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultUserTypeParameterized({x: AsyncResult[JGenericRefedInterface[JRefedInterface1]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[JRefedInterface1], GenericRefedInterface[RefedInterface1]](x, a => GenericRefedInterface[RefedInterface1](a)))})
  }

  def methodWithFunctionParamByteParameterized(handler: GenericRefedInterface[Byte] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamByteParameterized({x: JGenericRefedInterface[java.lang.Byte] => handler(GenericRefedInterface[Byte](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamShortParameterized(handler: GenericRefedInterface[Short] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamShortParameterized({x: JGenericRefedInterface[java.lang.Short] => handler(GenericRefedInterface[Short](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamIntegerParameterized(handler: GenericRefedInterface[Int] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamIntegerParameterized({x: JGenericRefedInterface[java.lang.Integer] => handler(GenericRefedInterface[Int](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamLongParameterized(handler: GenericRefedInterface[Long] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamLongParameterized({x: JGenericRefedInterface[java.lang.Long] => handler(GenericRefedInterface[Long](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamFloatParameterized(handler: GenericRefedInterface[Float] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamFloatParameterized({x: JGenericRefedInterface[java.lang.Float] => handler(GenericRefedInterface[Float](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamDoubleParameterized(handler: GenericRefedInterface[Double] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamDoubleParameterized({x: JGenericRefedInterface[java.lang.Double] => handler(GenericRefedInterface[Double](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamBooleanParameterized(handler: GenericRefedInterface[Boolean] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamBooleanParameterized({x: JGenericRefedInterface[java.lang.Boolean] => handler(GenericRefedInterface[Boolean](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamCharacterParameterized(handler: GenericRefedInterface[Char] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamCharacterParameterized({x: JGenericRefedInterface[java.lang.Character] => handler(GenericRefedInterface[Char](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamStringParameterized(handler: GenericRefedInterface[String] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamStringParameterized({x: JGenericRefedInterface[java.lang.String] => handler(GenericRefedInterface[String](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamJsonObjectParameterized(handler: GenericRefedInterface[io.vertx.core.json.JsonObject] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamJsonObjectParameterized({x: JGenericRefedInterface[JsonObject] => handler(GenericRefedInterface[io.vertx.core.json.JsonObject](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamJsonArrayParameterized(handler: GenericRefedInterface[io.vertx.core.json.JsonArray] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamJsonArrayParameterized({x: JGenericRefedInterface[JsonArray] => handler(GenericRefedInterface[io.vertx.core.json.JsonArray](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamDataObjectParameterized(handler: GenericRefedInterface[TestDataObject] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamDataObjectParameterized({x: JGenericRefedInterface[JTestDataObject] => handler(GenericRefedInterface[TestDataObject](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamEnumParameterized(handler: GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamEnumParameterized({x: JGenericRefedInterface[TestEnum] => handler(GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamGenEnumParameterized(handler: GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamGenEnumParameterized({x: JGenericRefedInterface[TestGenEnum] => handler(GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithFunctionParamUserTypeParameterized(handler: GenericRefedInterface[RefedInterface1] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamUserTypeParameterized({x: JGenericRefedInterface[JRefedInterface1] => handler(GenericRefedInterface[RefedInterface1](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithClassTypeParameterizedReturn[U: TypeTag](`type`: Class[U]): GenericRefedInterface[U] = {
    GenericRefedInterface[U](asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeParameterizedReturn[Object](toJavaClass(`type`)))
  }

  def methodWithHandlerClassTypeParameterized[U: TypeTag](`type`: Class[U], handler: Handler[GenericRefedInterface[U]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerClassTypeParameterized[Object](toJavaClass(`type`), {x: JGenericRefedInterface[Object] => handler.handle(GenericRefedInterface[U](x))})
  }

  def methodWithHandlerAsyncResultClassTypeParameterized[U: TypeTag](`type`: Class[U], handler: Handler[AsyncResult[GenericRefedInterface[U]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultClassTypeParameterized[Object](toJavaClass(`type`), {x: AsyncResult[JGenericRefedInterface[Object]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[Object], GenericRefedInterface[U]](x, a => GenericRefedInterface[U](a)))})
  }

  def methodWithFunctionParamClassTypeParameterized[U: TypeTag](`type`: Class[U], handler: GenericRefedInterface[U] => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamClassTypeParameterized[Object](toJavaClass(`type`), {x: JGenericRefedInterface[Object] => handler(GenericRefedInterface[U](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithClassTypeParam[U: TypeTag](`type`: Class[U], u: U): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeParam[Object](toJavaClass(`type`), toJava[U](u))
  }

  def methodWithClassTypeReturn[U: TypeTag](`type`: Class[U]): U = {
    toScala[U](asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeReturn[Object](toJavaClass(`type`)))
  }

  def methodWithClassTypeHandler[U: TypeTag](`type`: Class[U], f: Handler[U]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeHandler[Object](toJavaClass(`type`), {x: Object => f.handle(toScala[U](x))})
  }

  def methodWithClassTypeHandlerAsyncResult[U: TypeTag](`type`: Class[U], f: Handler[AsyncResult[U]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeHandlerAsyncResult[Object](toJavaClass(`type`), {x: AsyncResult[Object] => f.handle(AsyncResultWrapper[Object, U](x, a => toScala[U](a)))})
  }

  def methodWithClassTypeFunctionParam[U: TypeTag](`type`: Class[U], f: U => String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeFunctionParam[Object](toJavaClass(`type`), {x: Object => f(toScala[U](x)).asInstanceOf[java.lang.String]})
  }

  def methodWithClassTypeFunctionReturn[U: TypeTag](`type`: Class[U], f: String => U): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeFunctionReturn[Object](toJavaClass(`type`), {x: java.lang.String => toJava[U](f(x.asInstanceOf[String]))})
  }

  def interfaceWithApiArg(value: RefedInterface1): InterfaceWithApiArg = {
    InterfaceWithApiArg(asJava.asInstanceOf[JGenericsTCK].interfaceWithApiArg(value.asJava.asInstanceOf[JRefedInterface1]))
  }

  def interfaceWithStringArg(value: String): InterfaceWithStringArg = {
    InterfaceWithStringArg(asJava.asInstanceOf[JGenericsTCK].interfaceWithStringArg(value.asInstanceOf[java.lang.String]))
  }

  def interfaceWithVariableArg[T: TypeTag, U: TypeTag](value1: T, `type`: Class[U], value2: U): InterfaceWithVariableArg[T, U] = {
    InterfaceWithVariableArg[T, U](asJava.asInstanceOf[JGenericsTCK].interfaceWithVariableArg[Object, Object](toJava[T](value1), toJavaClass(`type`), toJava[U](value2)))
  }

  def methodWithHandlerGenericNullableApi(notNull: Boolean, handler: Handler[GenericNullableRefedInterface[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerGenericNullableApi(notNull.asInstanceOf[java.lang.Boolean], {x: JGenericNullableRefedInterface[JRefedInterface1] => handler.handle(GenericNullableRefedInterface[RefedInterface1](x))})
  }

  def methodWithHandlerAsyncResultGenericNullableApi(notNull: Boolean, handler: Handler[AsyncResult[GenericNullableRefedInterface[RefedInterface1]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenericNullableApi(notNull.asInstanceOf[java.lang.Boolean], {x: AsyncResult[JGenericNullableRefedInterface[JRefedInterface1]] => handler.handle(AsyncResultWrapper[JGenericNullableRefedInterface[JRefedInterface1], GenericNullableRefedInterface[RefedInterface1]](x, a => GenericNullableRefedInterface[RefedInterface1](a)))})
  }

  def methodWithGenericNullableApiReturn(notNull: Boolean): GenericNullableRefedInterface[RefedInterface1] = {
    GenericNullableRefedInterface[RefedInterface1](asJava.asInstanceOf[JGenericsTCK].methodWithGenericNullableApiReturn(notNull.asInstanceOf[java.lang.Boolean]))
  }

  def methodWithParamInferedReturn[T: TypeTag](param: GenericRefedInterface[T]): GenericRefedInterface[T] = {
    GenericRefedInterface[T](asJava.asInstanceOf[JGenericsTCK].methodWithParamInferedReturn[Object](param.asJava.asInstanceOf[JGenericRefedInterface[Object]]))
  }

  def methodWithHandlerParamInfered[T: TypeTag](param: GenericRefedInterface[T], handler: Handler[GenericRefedInterface[T]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerParamInfered[Object](param.asJava.asInstanceOf[JGenericRefedInterface[Object]], {x: JGenericRefedInterface[Object] => handler.handle(GenericRefedInterface[T](x))})
  }

  def methodWithHandlerAsyncResultParamInfered[T: TypeTag](param: GenericRefedInterface[T], handler: Handler[AsyncResult[GenericRefedInterface[T]]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultParamInfered[Object](param.asJava.asInstanceOf[JGenericRefedInterface[Object]], {x: AsyncResult[JGenericRefedInterface[Object]] => handler.handle(AsyncResultWrapper[JGenericRefedInterface[Object], GenericRefedInterface[T]](x, a => GenericRefedInterface[T](a)))})
  }

  def methodWithHandlerAsyncResultByteParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Byte], GenericRefedInterface[Byte]](x => GenericRefedInterface[Byte](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultByteParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Short], GenericRefedInterface[Short]](x => GenericRefedInterface[Short](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultShortParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Integer], GenericRefedInterface[Int]](x => GenericRefedInterface[Int](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultIntegerParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Long], GenericRefedInterface[Long]](x => GenericRefedInterface[Long](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultLongParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Float], GenericRefedInterface[Float]](x => GenericRefedInterface[Float](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultFloatParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Double], GenericRefedInterface[Double]](x => GenericRefedInterface[Double](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDoubleParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Boolean], GenericRefedInterface[Boolean]](x => GenericRefedInterface[Boolean](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultBooleanParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.Character], GenericRefedInterface[Char]](x => GenericRefedInterface[Char](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultCharacterParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[java.lang.String], GenericRefedInterface[String]](x => GenericRefedInterface[String](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultStringParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[JsonObject], GenericRefedInterface[io.vertx.core.json.JsonObject]](x => GenericRefedInterface[io.vertx.core.json.JsonObject](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonObjectParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[io.vertx.core.json.JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[JsonArray], GenericRefedInterface[io.vertx.core.json.JsonArray]](x => GenericRefedInterface[io.vertx.core.json.JsonArray](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonArrayParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[JTestDataObject], GenericRefedInterface[TestDataObject]](x => GenericRefedInterface[TestDataObject](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDataObjectParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultEnumParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[TestEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]](x => GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultEnumParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[TestGenEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]](x => GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenEnumParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): scala.concurrent.Future[GenericRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[JRefedInterface1], GenericRefedInterface[RefedInterface1]](x => GenericRefedInterface[RefedInterface1](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultUserTypeParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U: TypeTag](`type`: Class[U]): scala.concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Object], GenericRefedInterface[U]](x => GenericRefedInterface[U](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultClassTypeParameterized[Object](toJavaClass(`type`), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithClassTypeHandlerAsyncResultFuture[U: TypeTag](`type`: Class[U]): scala.concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, U](x => toScala[U](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeHandlerAsyncResult[Object](toJavaClass(`type`), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenericNullableApiFuture(notNull: Boolean): scala.concurrent.Future[GenericNullableRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericNullableRefedInterface[JRefedInterface1], GenericNullableRefedInterface[RefedInterface1]](x => GenericNullableRefedInterface[RefedInterface1](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenericNullableApi(notNull.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultParamInferedFuture[T: TypeTag](param: GenericRefedInterface[T]): scala.concurrent.Future[GenericRefedInterface[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Object], GenericRefedInterface[T]](x => GenericRefedInterface[T](x))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultParamInfered[Object](param.asJava.asInstanceOf[JGenericRefedInterface[Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object GenericsTCK {
  def apply(asJava: JGenericsTCK) = new GenericsTCK(asJava)  
}
