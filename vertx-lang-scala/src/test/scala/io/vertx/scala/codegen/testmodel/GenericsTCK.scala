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
    GenericRefedInterface.apply[Byte](asJava.methodWithByteParameterizedReturn())
  }

  def methodWithShortParameterizedReturn(): GenericRefedInterface[Short] = {
    GenericRefedInterface.apply[Short](asJava.methodWithShortParameterizedReturn())
  }

  def methodWithIntegerParameterizedReturn(): GenericRefedInterface[Int] = {
    GenericRefedInterface.apply[Int](asJava.methodWithIntegerParameterizedReturn())
  }

  def methodWithLongParameterizedReturn(): GenericRefedInterface[Long] = {
    GenericRefedInterface.apply[Long](asJava.methodWithLongParameterizedReturn())
  }

  def methodWithFloatParameterizedReturn(): GenericRefedInterface[Float] = {
    GenericRefedInterface.apply[Float](asJava.methodWithFloatParameterizedReturn())
  }

  def methodWithDoubleParameterizedReturn(): GenericRefedInterface[Double] = {
    GenericRefedInterface.apply[Double](asJava.methodWithDoubleParameterizedReturn())
  }

  def methodWithBooleanParameterizedReturn(): GenericRefedInterface[Boolean] = {
    GenericRefedInterface.apply[Boolean](asJava.methodWithBooleanParameterizedReturn())
  }

  def methodWithCharacterParameterizedReturn(): GenericRefedInterface[Char] = {
    GenericRefedInterface.apply[Char](asJava.methodWithCharacterParameterizedReturn())
  }

  def methodWithStringParameterizedReturn(): GenericRefedInterface[String] = {
    GenericRefedInterface.apply[String](asJava.methodWithStringParameterizedReturn())
  }

  def methodWithJsonObjectParameterizedReturn(): GenericRefedInterface[JsonObject] = {
    GenericRefedInterface.apply[JsonObject](asJava.methodWithJsonObjectParameterizedReturn())
  }

  def methodWithJsonArrayParameterizedReturn(): GenericRefedInterface[JsonArray] = {
    GenericRefedInterface.apply[JsonArray](asJava.methodWithJsonArrayParameterizedReturn())
  }

  def methodWithDataObjectParameterizedReturn(): GenericRefedInterface[TestDataObject] = {
    GenericRefedInterface.apply[TestDataObject](asJava.methodWithDataObjectParameterizedReturn())
  }

  def methodWithEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](asJava.methodWithEnumParameterizedReturn())
  }

  def methodWithGenEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](asJava.methodWithGenEnumParameterizedReturn())
  }

  def methodWithUserTypeParameterizedReturn(): GenericRefedInterface[RefedInterface1] = {
    GenericRefedInterface.apply[RefedInterface1](asJava.methodWithUserTypeParameterizedReturn())
  }

  def methodWithHandlerByteParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Byte]]): Unit = {
    asJava.methodWithHandlerByteParameterized(funcToMappedHandler(GenericRefedInterface.apply[Byte])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]])
  }

  def methodWithHandlerShortParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Short]]): Unit = {
    asJava.methodWithHandlerShortParameterized(funcToMappedHandler(GenericRefedInterface.apply[Short])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]])
  }

  def methodWithHandlerIntegerParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Int]]): Unit = {
    asJava.methodWithHandlerIntegerParameterized(funcToMappedHandler(GenericRefedInterface.apply[Int])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]])
  }

  def methodWithHandlerLongParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Long]]): Unit = {
    asJava.methodWithHandlerLongParameterized(funcToMappedHandler(GenericRefedInterface.apply[Long])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]])
  }

  def methodWithHandlerFloatParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Float]]): Unit = {
    asJava.methodWithHandlerFloatParameterized(funcToMappedHandler(GenericRefedInterface.apply[Float])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]])
  }

  def methodWithHandlerDoubleParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Double]]): Unit = {
    asJava.methodWithHandlerDoubleParameterized(funcToMappedHandler(GenericRefedInterface.apply[Double])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]])
  }

  def methodWithHandlerBooleanParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Boolean]]): Unit = {
    asJava.methodWithHandlerBooleanParameterized(funcToMappedHandler(GenericRefedInterface.apply[Boolean])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]])
  }

  def methodWithHandlerCharacterParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Char]]): Unit = {
    asJava.methodWithHandlerCharacterParameterized(funcToMappedHandler(GenericRefedInterface.apply[Char])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]])
  }

  def methodWithHandlerStringParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[String]]): Unit = {
    asJava.methodWithHandlerStringParameterized(funcToMappedHandler(GenericRefedInterface.apply[String])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]])
  }

  def methodWithHandlerJsonObjectParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[JsonObject]]): Unit = {
    asJava.methodWithHandlerJsonObjectParameterized(funcToMappedHandler(GenericRefedInterface.apply[JsonObject])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerJsonArrayParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[JsonArray]]): Unit = {
    asJava.methodWithHandlerJsonArrayParameterized(funcToMappedHandler(GenericRefedInterface.apply[JsonArray])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerDataObjectParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[TestDataObject]]): Unit = {
    asJava.methodWithHandlerDataObjectParameterized(funcToMappedHandler(GenericRefedInterface.apply[TestDataObject])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithHandlerEnumParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithHandlerEnumParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithHandlerGenEnumParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithHandlerGenEnumParameterized(funcToMappedHandler(GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithHandlerUserTypeParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[RefedInterface1]]): Unit = {
    asJava.methodWithHandlerUserTypeParameterized(funcToMappedHandler(GenericRefedInterface.apply[RefedInterface1])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithHandlerAsyncResultByteParameterizedFuture(): concurrent.Future[GenericRefedInterface[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Byte]]((x => if (x == null) null else GenericRefedInterface.apply[Byte](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultByteParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortParameterizedFuture(): concurrent.Future[GenericRefedInterface[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Short]]((x => if (x == null) null else GenericRefedInterface.apply[Short](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultShortParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerParameterizedFuture(): concurrent.Future[GenericRefedInterface[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Int]]((x => if (x == null) null else GenericRefedInterface.apply[Int](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultIntegerParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongParameterizedFuture(): concurrent.Future[GenericRefedInterface[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Long]]((x => if (x == null) null else GenericRefedInterface.apply[Long](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultLongParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatParameterizedFuture(): concurrent.Future[GenericRefedInterface[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Float]]((x => if (x == null) null else GenericRefedInterface.apply[Float](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultFloatParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleParameterizedFuture(): concurrent.Future[GenericRefedInterface[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Double]]((x => if (x == null) null else GenericRefedInterface.apply[Double](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultDoubleParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanParameterizedFuture(): concurrent.Future[GenericRefedInterface[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Boolean]]((x => if (x == null) null else GenericRefedInterface.apply[Boolean](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultBooleanParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterParameterizedFuture(): concurrent.Future[GenericRefedInterface[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Char]]((x => if (x == null) null else GenericRefedInterface.apply[Char](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultCharacterParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringParameterizedFuture(): concurrent.Future[GenericRefedInterface[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[String]]((x => if (x == null) null else GenericRefedInterface.apply[String](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultStringParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonObject]]((x => if (x == null) null else GenericRefedInterface.apply[JsonObject](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultJsonObjectParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonArray]]((x => if (x == null) null else GenericRefedInterface.apply[JsonArray](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultJsonArrayParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[TestDataObject]]((x => if (x == null) null else GenericRefedInterface.apply[TestDataObject](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultDataObjectParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultEnumParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultGenEnumParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): concurrent.Future[GenericRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[RefedInterface1]]((x => if (x == null) null else GenericRefedInterface.apply[RefedInterface1](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultUserTypeParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamByteParameterized(handler: JGenericRefedInterface[Byte] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamByteParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte],java.lang.String]])
  }

  def methodWithFunctionParamShortParameterized(handler: JGenericRefedInterface[Short] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamShortParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short],java.lang.String]])
  }

  def methodWithFunctionParamIntegerParameterized(handler: JGenericRefedInterface[Integer] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamIntegerParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer],java.lang.String]])
  }

  def methodWithFunctionParamLongParameterized(handler: JGenericRefedInterface[Long] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamLongParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long],java.lang.String]])
  }

  def methodWithFunctionParamFloatParameterized(handler: JGenericRefedInterface[Float] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamFloatParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float],java.lang.String]])
  }

  def methodWithFunctionParamDoubleParameterized(handler: JGenericRefedInterface[Double] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamDoubleParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double],java.lang.String]])
  }

  def methodWithFunctionParamBooleanParameterized(handler: JGenericRefedInterface[Boolean] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamBooleanParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean],java.lang.String]])
  }

  def methodWithFunctionParamCharacterParameterized(handler: JGenericRefedInterface[Character] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamCharacterParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character],java.lang.String]])
  }

  def methodWithFunctionParamStringParameterized(handler: JGenericRefedInterface[String] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamStringParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String],java.lang.String]])
  }

  def methodWithFunctionParamJsonObjectParameterized(handler: GenericRefedInterface[JsonObject] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamJsonObjectParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject],java.lang.String]])
  }

  def methodWithFunctionParamJsonArrayParameterized(handler: GenericRefedInterface[JsonArray] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamJsonArrayParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray],java.lang.String]])
  }

  def methodWithFunctionParamDataObjectParameterized(handler: JGenericRefedInterface[TestDataObject] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamDataObjectParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject],java.lang.String]])
  }

  def methodWithFunctionParamEnumParameterized(handler: JGenericRefedInterface[TestEnum] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamEnumParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum],java.lang.String]])
  }

  def methodWithFunctionParamGenEnumParameterized(handler: JGenericRefedInterface[TestGenEnum] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamGenEnumParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum],java.lang.String]])
  }

  def methodWithFunctionParamUserTypeParameterized(handler: JGenericRefedInterface[RefedInterface1] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamUserTypeParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1],java.lang.String]])
  }

  def methodWithClassTypeParameterizedReturn[U: TypeTag](`type`: java.lang.Class[U]): GenericRefedInterface[U] = {
    GenericRefedInterface.apply[U](asJava.methodWithClassTypeParameterizedReturn(`type`.asInstanceOf[java.lang.Class[Object]]))
  }

  def methodWithHandlerClassTypeParameterized[U: TypeTag](`type`: java.lang.Class[U], handler: io.vertx.core.Handler[GenericRefedInterface[U]]): Unit = {
    asJava.methodWithHandlerClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], funcToMappedHandler(GenericRefedInterface.apply[U])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]])
  }

  def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U: TypeTag](`type`: java.lang.Class[U]): concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[U]]((x => if (x == null) null else GenericRefedInterface.apply[U](x.asInstanceOf)))
    asJava.methodWithHandlerAsyncResultClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]]])
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamClassTypeParameterized[U: TypeTag](`type`: java.lang.Class[U], handler: JGenericRefedInterface[U] => java.lang.String): Unit = {
    asJava.methodWithFunctionParamClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[Object],java.lang.String]])
  }

  def methodWithClassTypeParam[U: TypeTag](`type`: java.lang.Class[U], u: U): Unit = {
    asJava.methodWithClassTypeParam(`type`.asInstanceOf[java.lang.Class[Object]], toJava[U](u).asInstanceOf[Object])
  }

  def methodWithClassTypeReturn[U: TypeTag](`type`: java.lang.Class[U]): U = {
    toScala[U](asJava.methodWithClassTypeReturn(`type`.asInstanceOf[java.lang.Class[Object]]))
  }

  def methodWithClassTypeHandler[U: TypeTag](`type`: java.lang.Class[U], f: io.vertx.core.Handler[U]): Unit = {
    asJava.methodWithClassTypeHandler(`type`.asInstanceOf[java.lang.Class[Object]], (f).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithClassTypeHandlerAsyncResultFuture[U: TypeTag](`type`: java.lang.Class[U]): concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[U]((x => x.asInstanceOf))
    asJava.methodWithClassTypeHandlerAsyncResult(`type`.asInstanceOf[java.lang.Class[Object]], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def methodWithClassTypeFunctionParam[U: TypeTag](`type`: java.lang.Class[U], f: U => java.lang.String): Unit = {
    asJava.methodWithClassTypeFunctionParam(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(f).asInstanceOf[java.util.function.Function[Object,java.lang.String]])
  }

  def methodWithClassTypeFunctionReturn[U: TypeTag](`type`: java.lang.Class[U], f: java.lang.String => U): Unit = {
    asJava.methodWithClassTypeFunctionReturn(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(f).asInstanceOf[java.util.function.Function[java.lang.String,Object]])
  }

  def interfaceWithApiArg(value: RefedInterface1): InterfaceWithApiArg = {
    InterfaceWithApiArg.apply(asJava.interfaceWithApiArg(value.asJava.asInstanceOf[JRefedInterface1]))
  }

  def interfaceWithStringArg(value: String): InterfaceWithStringArg = {
    InterfaceWithStringArg.apply(asJava.interfaceWithStringArg(value))
  }

  def interfaceWithVariableArg[T: TypeTag, U: TypeTag](value1: T, `type`: java.lang.Class[U], value2: U): InterfaceWithVariableArg[T, U] = {
    InterfaceWithVariableArg.apply[T,U](asJava.interfaceWithVariableArg(toJava[T](value1).asInstanceOf[Object], `type`.asInstanceOf[java.lang.Class[Object]], toJava[U](value2).asInstanceOf[Object]))
  }

}

object GenericsTCK {

  def apply(_asJava: JGenericsTCK): GenericsTCK =
    new GenericsTCK(_asJava)

}
