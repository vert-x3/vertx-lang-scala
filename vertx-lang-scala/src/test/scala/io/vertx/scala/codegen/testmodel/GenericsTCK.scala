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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{GenericsTCK => JGenericsTCK}
import io.vertx.codegen.testmodel.{GenericRefedInterface => JGenericRefedInterface}
import io.vertx.codegen.testmodel.{InterfaceWithApiArg => JInterfaceWithApiArg}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{InterfaceWithStringArg => JInterfaceWithStringArg}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import java.util.function.{Function => JFunction}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
class GenericsTCK(private val _asJava: JGenericsTCK) {

  def asJava: JGenericsTCK = _asJava

  def methodWithByteParameterizedReturn(): GenericRefedInterface[Byte] = {
    GenericRefedInterface.apply[java.lang.Byte](_asJava.methodWithByteParameterizedReturn())
  }

  def methodWithShortParameterizedReturn(): GenericRefedInterface[Short] = {
    GenericRefedInterface.apply[java.lang.Short](_asJava.methodWithShortParameterizedReturn())
  }

  def methodWithIntegerParameterizedReturn(): GenericRefedInterface[Int] = {
    GenericRefedInterface.apply[java.lang.Integer](_asJava.methodWithIntegerParameterizedReturn())
  }

  def methodWithLongParameterizedReturn(): GenericRefedInterface[Long] = {
    GenericRefedInterface.apply[java.lang.Long](_asJava.methodWithLongParameterizedReturn())
  }

  def methodWithFloatParameterizedReturn(): GenericRefedInterface[Float] = {
    GenericRefedInterface.apply[java.lang.Float](_asJava.methodWithFloatParameterizedReturn())
  }

  def methodWithDoubleParameterizedReturn(): GenericRefedInterface[Double] = {
    GenericRefedInterface.apply[java.lang.Double](_asJava.methodWithDoubleParameterizedReturn())
  }

  def methodWithBooleanParameterizedReturn(): GenericRefedInterface[Boolean] = {
    GenericRefedInterface.apply[java.lang.Boolean](_asJava.methodWithBooleanParameterizedReturn())
  }

  def methodWithCharacterParameterizedReturn(): GenericRefedInterface[Char] = {
    GenericRefedInterface.apply[java.lang.Character](_asJava.methodWithCharacterParameterizedReturn())
  }

  def methodWithStringParameterizedReturn(): GenericRefedInterface[String] = {
    GenericRefedInterface.apply[java.lang.String](_asJava.methodWithStringParameterizedReturn())
  }

  def methodWithJsonObjectParameterizedReturn(): GenericRefedInterface[JsonObject] = {
    GenericRefedInterface.apply[io.vertx.core.json.JsonObject](_asJava.methodWithJsonObjectParameterizedReturn())
  }

  def methodWithJsonArrayParameterizedReturn(): GenericRefedInterface[JsonArray] = {
    GenericRefedInterface.apply[io.vertx.core.json.JsonArray](_asJava.methodWithJsonArrayParameterizedReturn())
  }

  def methodWithDataObjectParameterizedReturn(): GenericRefedInterface[TestDataObject] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestDataObject](_asJava.methodWithDataObjectParameterizedReturn())
  }

  def methodWithEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](_asJava.methodWithEnumParameterizedReturn())
  }

  def methodWithGenEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](_asJava.methodWithGenEnumParameterizedReturn())
  }

  def methodWithUserTypeParameterizedReturn(): GenericRefedInterface[RefedInterface1] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.RefedInterface1](_asJava.methodWithUserTypeParameterizedReturn())
  }

  def methodWithHandlerByteParameterized(handler: GenericRefedInterface[Byte] => Unit): Unit = {
    _asJava.methodWithHandlerByteParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Byte])(handler))
  }

  def methodWithHandlerShortParameterized(handler: GenericRefedInterface[Short] => Unit): Unit = {
    _asJava.methodWithHandlerShortParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Short])(handler))
  }

  def methodWithHandlerIntegerParameterized(handler: GenericRefedInterface[Int] => Unit): Unit = {
    _asJava.methodWithHandlerIntegerParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Integer])(handler))
  }

  def methodWithHandlerLongParameterized(handler: GenericRefedInterface[Long] => Unit): Unit = {
    _asJava.methodWithHandlerLongParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Long])(handler))
  }

  def methodWithHandlerFloatParameterized(handler: GenericRefedInterface[Float] => Unit): Unit = {
    _asJava.methodWithHandlerFloatParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Float])(handler))
  }

  def methodWithHandlerDoubleParameterized(handler: GenericRefedInterface[Double] => Unit): Unit = {
    _asJava.methodWithHandlerDoubleParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Double])(handler))
  }

  def methodWithHandlerBooleanParameterized(handler: GenericRefedInterface[Boolean] => Unit): Unit = {
    _asJava.methodWithHandlerBooleanParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Boolean])(handler))
  }

  def methodWithHandlerCharacterParameterized(handler: GenericRefedInterface[Char] => Unit): Unit = {
    _asJava.methodWithHandlerCharacterParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.Character])(handler))
  }

  def methodWithHandlerStringParameterized(handler: GenericRefedInterface[String] => Unit): Unit = {
    _asJava.methodWithHandlerStringParameterized(funcToMappedHandler(GenericRefedInterface.apply[java.lang.String])(handler))
  }

  def methodWithHandlerJsonObjectParameterized(handler: GenericRefedInterface[JsonObject] => Unit): Unit = {
    _asJava.methodWithHandlerJsonObjectParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.core.json.JsonObject])(handler))
  }

  def methodWithHandlerJsonArrayParameterized(handler: GenericRefedInterface[JsonArray] => Unit): Unit = {
    _asJava.methodWithHandlerJsonArrayParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.core.json.JsonArray])(handler))
  }

  def methodWithHandlerDataObjectParameterized(handler: GenericRefedInterface[TestDataObject] => Unit): Unit = {
    _asJava.methodWithHandlerDataObjectParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestDataObject])(handler))
  }

  def methodWithHandlerEnumParameterized(handler: GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    _asJava.methodWithHandlerEnumParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum])(handler))
  }

  def methodWithHandlerGenEnumParameterized(handler: GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] => Unit): Unit = {
    _asJava.methodWithHandlerGenEnumParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum])(handler))
  }

  def methodWithHandlerUserTypeParameterized(handler: GenericRefedInterface[RefedInterface1] => Unit): Unit = {
    _asJava.methodWithHandlerUserTypeParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.RefedInterface1])(handler))
  }

  def methodWithHandlerAsyncResultByteParameterizedFuture(): concurrent.Future[GenericRefedInterface[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Byte],GenericRefedInterface[Byte]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Byte](x)))
    _asJava.methodWithHandlerAsyncResultByteParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortParameterizedFuture(): concurrent.Future[GenericRefedInterface[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Short],GenericRefedInterface[Short]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Short](x)))
    _asJava.methodWithHandlerAsyncResultShortParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerParameterizedFuture(): concurrent.Future[GenericRefedInterface[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Integer],GenericRefedInterface[Int]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Integer](x)))
    _asJava.methodWithHandlerAsyncResultIntegerParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongParameterizedFuture(): concurrent.Future[GenericRefedInterface[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Long],GenericRefedInterface[Long]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Long](x)))
    _asJava.methodWithHandlerAsyncResultLongParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatParameterizedFuture(): concurrent.Future[GenericRefedInterface[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Float],GenericRefedInterface[Float]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Float](x)))
    _asJava.methodWithHandlerAsyncResultFloatParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleParameterizedFuture(): concurrent.Future[GenericRefedInterface[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Double],GenericRefedInterface[Double]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Double](x)))
    _asJava.methodWithHandlerAsyncResultDoubleParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanParameterizedFuture(): concurrent.Future[GenericRefedInterface[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Boolean],GenericRefedInterface[Boolean]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Boolean](x)))
    _asJava.methodWithHandlerAsyncResultBooleanParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterParameterizedFuture(): concurrent.Future[GenericRefedInterface[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[Character],GenericRefedInterface[Char]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.Character](x)))
    _asJava.methodWithHandlerAsyncResultCharacterParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringParameterizedFuture(): concurrent.Future[GenericRefedInterface[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[String],GenericRefedInterface[String]]((x => if (x == null) null else GenericRefedInterface.apply[java.lang.String](x)))
    _asJava.methodWithHandlerAsyncResultStringParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonObject],GenericRefedInterface[JsonObject]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.core.json.JsonObject](x)))
    _asJava.methodWithHandlerAsyncResultJsonObjectParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonArray],GenericRefedInterface[JsonArray]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.core.json.JsonArray](x)))
    _asJava.methodWithHandlerAsyncResultJsonArrayParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[TestDataObject],GenericRefedInterface[TestDataObject]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestDataObject](x)))
    _asJava.methodWithHandlerAsyncResultDataObjectParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[TestEnum],GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](x)))
    _asJava.methodWithHandlerAsyncResultEnumParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[TestGenEnum],GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](x)))
    _asJava.methodWithHandlerAsyncResultGenEnumParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): concurrent.Future[GenericRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[RefedInterface1],GenericRefedInterface[RefedInterface1]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.RefedInterface1](x)))
    _asJava.methodWithHandlerAsyncResultUserTypeParameterized(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamByteParameterized(handler: JGenericRefedInterface[Byte] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamByteParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamShortParameterized(handler: JGenericRefedInterface[Short] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamShortParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamIntegerParameterized(handler: JGenericRefedInterface[Integer] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamIntegerParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamLongParameterized(handler: JGenericRefedInterface[Long] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamLongParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamFloatParameterized(handler: JGenericRefedInterface[Float] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamFloatParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamDoubleParameterized(handler: JGenericRefedInterface[Double] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamDoubleParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamBooleanParameterized(handler: JGenericRefedInterface[Boolean] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamBooleanParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamCharacterParameterized(handler: JGenericRefedInterface[Character] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamCharacterParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamStringParameterized(handler: JGenericRefedInterface[String] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamStringParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamJsonObjectParameterized(handler: GenericRefedInterface[JsonObject] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamJsonObjectParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamJsonArrayParameterized(handler: GenericRefedInterface[JsonArray] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamJsonArrayParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamDataObjectParameterized(handler: JGenericRefedInterface[TestDataObject] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamDataObjectParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamEnumParameterized(handler: JGenericRefedInterface[TestEnum] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamEnumParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamGenEnumParameterized(handler: JGenericRefedInterface[TestGenEnum] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamGenEnumParameterized(asJavaFunction(handler))
  }

  def methodWithFunctionParamUserTypeParameterized(handler: JGenericRefedInterface[RefedInterface1] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamUserTypeParameterized(asJavaFunction(handler))
  }

  def methodWithClassTypeParameterizedReturn[U](`type`: java.lang.Class[U]): GenericRefedInterface[U] = {
    GenericRefedInterface.apply[U](_asJava.methodWithClassTypeParameterizedReturn(`type`))
  }

  def methodWithHandlerClassTypeParameterized[U](`type`: java.lang.Class[U], handler: GenericRefedInterface[U] => Unit): Unit = {
    _asJava.methodWithHandlerClassTypeParameterized(`type`, funcToMappedHandler(GenericRefedInterface.apply[U])(handler))
  }

  def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U](`type`: java.lang.Class[U]): concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JGenericRefedInterface[U],GenericRefedInterface[U]]((x => if (x == null) null else GenericRefedInterface.apply[U](x)))
    _asJava.methodWithHandlerAsyncResultClassTypeParameterized(`type`, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamClassTypeParameterized[U](`type`: java.lang.Class[U], handler: JGenericRefedInterface[U] => java.lang.String): Unit = {
    _asJava.methodWithFunctionParamClassTypeParameterized(`type`, asJavaFunction(handler))
  }

  def methodWithClassTypeParam[U](`type`: java.lang.Class[U], u: U): Unit = {
    _asJava.methodWithClassTypeParam(`type`, u)
  }

  def methodWithClassTypeReturn[U](`type`: java.lang.Class[U]): U = {
    _asJava.methodWithClassTypeReturn(`type`)
  }

  def methodWithClassTypeHandler[U](`type`: java.lang.Class[U], f: U => Unit): Unit = {
    _asJava.methodWithClassTypeHandler(`type`, funcToHandler(f))
  }

  def methodWithClassTypeHandlerAsyncResultFuture[U](`type`: java.lang.Class[U]): concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[U,U]((x => x))
    _asJava.methodWithClassTypeHandlerAsyncResult(`type`, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithClassTypeFunctionParam[U](`type`: java.lang.Class[U], f: U => java.lang.String): Unit = {
    _asJava.methodWithClassTypeFunctionParam(`type`, asJavaFunction(f))
  }

  def methodWithClassTypeFunctionReturn[U](`type`: java.lang.Class[U], f: java.lang.String => U): Unit = {
    _asJava.methodWithClassTypeFunctionReturn(`type`, asJavaFunction(f))
  }

  def interfaceWithApiArg(value: RefedInterface1): InterfaceWithApiArg = {
    InterfaceWithApiArg.apply(_asJava.interfaceWithApiArg(value.asJava.asInstanceOf[JRefedInterface1]))
  }

  def interfaceWithStringArg(value: String): InterfaceWithStringArg = {
    InterfaceWithStringArg.apply(_asJava.interfaceWithStringArg(value))
  }

  def interfaceWithVariableArg[T, U](value1: T, `type`: java.lang.Class[U], value2: U): InterfaceWithVariableArg[T, U] = {
    InterfaceWithVariableArg.apply[T,U](_asJava.interfaceWithVariableArg(value1, `type`, value2))
  }

}

object GenericsTCK {

  def apply(_asJava: JGenericsTCK): GenericsTCK =
    new GenericsTCK(_asJava)

}
