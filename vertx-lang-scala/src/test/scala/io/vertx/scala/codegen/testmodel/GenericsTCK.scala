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
import io.vertx.codegen.testmodel.{GenericNullableRefedInterface => JGenericNullableRefedInterface}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.{InterfaceWithVariableArg => JInterfaceWithVariableArg}
import io.vertx.codegen.testmodel.TestGenEnum

/**
  */
class GenericsTCK(private val _asJava: Object) {

  def asJava: Object = _asJava

  def methodWithByteParameterizedReturn(): GenericRefedInterface[Byte] = {
    GenericRefedInterface.apply[Byte](asJava.asInstanceOf[JGenericsTCK].methodWithByteParameterizedReturn())
  }

  def methodWithShortParameterizedReturn(): GenericRefedInterface[Short] = {
    GenericRefedInterface.apply[Short](asJava.asInstanceOf[JGenericsTCK].methodWithShortParameterizedReturn())
  }

  def methodWithIntegerParameterizedReturn(): GenericRefedInterface[Int] = {
    GenericRefedInterface.apply[Int](asJava.asInstanceOf[JGenericsTCK].methodWithIntegerParameterizedReturn())
  }

  def methodWithLongParameterizedReturn(): GenericRefedInterface[Long] = {
    GenericRefedInterface.apply[Long](asJava.asInstanceOf[JGenericsTCK].methodWithLongParameterizedReturn())
  }

  def methodWithFloatParameterizedReturn(): GenericRefedInterface[Float] = {
    GenericRefedInterface.apply[Float](asJava.asInstanceOf[JGenericsTCK].methodWithFloatParameterizedReturn())
  }

  def methodWithDoubleParameterizedReturn(): GenericRefedInterface[Double] = {
    GenericRefedInterface.apply[Double](asJava.asInstanceOf[JGenericsTCK].methodWithDoubleParameterizedReturn())
  }

  def methodWithBooleanParameterizedReturn(): GenericRefedInterface[Boolean] = {
    GenericRefedInterface.apply[Boolean](asJava.asInstanceOf[JGenericsTCK].methodWithBooleanParameterizedReturn())
  }

  def methodWithCharacterParameterizedReturn(): GenericRefedInterface[Char] = {
    GenericRefedInterface.apply[Char](asJava.asInstanceOf[JGenericsTCK].methodWithCharacterParameterizedReturn())
  }

  def methodWithStringParameterizedReturn(): GenericRefedInterface[String] = {
    GenericRefedInterface.apply[String](asJava.asInstanceOf[JGenericsTCK].methodWithStringParameterizedReturn())
  }

  def methodWithJsonObjectParameterizedReturn(): GenericRefedInterface[JsonObject] = {
    GenericRefedInterface.apply[JsonObject](asJava.asInstanceOf[JGenericsTCK].methodWithJsonObjectParameterizedReturn())
  }

  def methodWithJsonArrayParameterizedReturn(): GenericRefedInterface[JsonArray] = {
    GenericRefedInterface.apply[JsonArray](asJava.asInstanceOf[JGenericsTCK].methodWithJsonArrayParameterizedReturn())
  }

  def methodWithDataObjectParameterizedReturn(): GenericRefedInterface[TestDataObject] = {
    GenericRefedInterface.apply[TestDataObject](asJava.asInstanceOf[JGenericsTCK].methodWithDataObjectParameterizedReturn())
  }

  def methodWithEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](asJava.asInstanceOf[JGenericsTCK].methodWithEnumParameterizedReturn())
  }

  def methodWithGenEnumParameterizedReturn(): GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum] = {
    GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](asJava.asInstanceOf[JGenericsTCK].methodWithGenEnumParameterizedReturn())
  }

  def methodWithUserTypeParameterizedReturn(): GenericRefedInterface[RefedInterface1] = {
    GenericRefedInterface.apply[RefedInterface1](asJava.asInstanceOf[JGenericsTCK].methodWithUserTypeParameterizedReturn())
  }

  def methodWithHandlerByteParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Byte]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerByteParameterized(funcToMappedHandler[JGenericRefedInterface[Byte], GenericRefedInterface[Byte]](GenericRefedInterface.apply[Byte])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]])
  }

  def methodWithHandlerShortParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Short]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerShortParameterized(funcToMappedHandler[JGenericRefedInterface[Short], GenericRefedInterface[Short]](GenericRefedInterface.apply[Short])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]])
  }

  def methodWithHandlerIntegerParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Int]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerIntegerParameterized(funcToMappedHandler[JGenericRefedInterface[Integer], GenericRefedInterface[Int]](GenericRefedInterface.apply[Int])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]])
  }

  def methodWithHandlerLongParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Long]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerLongParameterized(funcToMappedHandler[JGenericRefedInterface[Long], GenericRefedInterface[Long]](GenericRefedInterface.apply[Long])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]])
  }

  def methodWithHandlerFloatParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Float]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerFloatParameterized(funcToMappedHandler[JGenericRefedInterface[Float], GenericRefedInterface[Float]](GenericRefedInterface.apply[Float])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]])
  }

  def methodWithHandlerDoubleParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Double]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerDoubleParameterized(funcToMappedHandler[JGenericRefedInterface[Double], GenericRefedInterface[Double]](GenericRefedInterface.apply[Double])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]])
  }

  def methodWithHandlerBooleanParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Boolean]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerBooleanParameterized(funcToMappedHandler[JGenericRefedInterface[Boolean], GenericRefedInterface[Boolean]](GenericRefedInterface.apply[Boolean])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]])
  }

  def methodWithHandlerCharacterParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[Char]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerCharacterParameterized(funcToMappedHandler[JGenericRefedInterface[Character], GenericRefedInterface[Char]](GenericRefedInterface.apply[Char])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]])
  }

  def methodWithHandlerStringParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[String]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerStringParameterized(funcToMappedHandler[JGenericRefedInterface[String], GenericRefedInterface[String]](GenericRefedInterface.apply[String])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]])
  }

  def methodWithHandlerJsonObjectParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[JsonObject]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerJsonObjectParameterized(funcToMappedHandler[GenericRefedInterface[JsonObject], GenericRefedInterface[JsonObject]](GenericRefedInterface.apply[JsonObject])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerJsonArrayParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[JsonArray]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerJsonArrayParameterized(funcToMappedHandler[GenericRefedInterface[JsonArray], GenericRefedInterface[JsonArray]](GenericRefedInterface.apply[JsonArray])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerDataObjectParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerDataObjectParameterized(funcToMappedHandler[JGenericRefedInterface[TestDataObject], GenericRefedInterface[TestDataObject]](GenericRefedInterface.apply[TestDataObject])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithHandlerEnumParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerEnumParameterized(funcToMappedHandler[JGenericRefedInterface[TestEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]](GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithHandlerGenEnumParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerGenEnumParameterized(funcToMappedHandler[JGenericRefedInterface[TestGenEnum], GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]](GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithHandlerUserTypeParameterized(handler: io.vertx.core.Handler[GenericRefedInterface[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerUserTypeParameterized(funcToMappedHandler[JGenericRefedInterface[RefedInterface1], GenericRefedInterface[RefedInterface1]](GenericRefedInterface.apply[RefedInterface1])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithHandlerAsyncResultByteParameterizedFuture(): concurrent.Future[GenericRefedInterface[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Byte]]((x => if (x == null) null else GenericRefedInterface.apply[Byte](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultByteParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultShortParameterizedFuture(): concurrent.Future[GenericRefedInterface[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Short]]((x => if (x == null) null else GenericRefedInterface.apply[Short](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultShortParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultIntegerParameterizedFuture(): concurrent.Future[GenericRefedInterface[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Int]]((x => if (x == null) null else GenericRefedInterface.apply[Int](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultIntegerParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultLongParameterizedFuture(): concurrent.Future[GenericRefedInterface[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Long]]((x => if (x == null) null else GenericRefedInterface.apply[Long](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultLongParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultFloatParameterizedFuture(): concurrent.Future[GenericRefedInterface[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Float]]((x => if (x == null) null else GenericRefedInterface.apply[Float](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultFloatParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDoubleParameterizedFuture(): concurrent.Future[GenericRefedInterface[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Double]]((x => if (x == null) null else GenericRefedInterface.apply[Double](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDoubleParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultBooleanParameterizedFuture(): concurrent.Future[GenericRefedInterface[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Boolean]]((x => if (x == null) null else GenericRefedInterface.apply[Boolean](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultBooleanParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultCharacterParameterizedFuture(): concurrent.Future[GenericRefedInterface[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[Char]]((x => if (x == null) null else GenericRefedInterface.apply[Char](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultCharacterParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultStringParameterizedFuture(): concurrent.Future[GenericRefedInterface[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[String]]((x => if (x == null) null else GenericRefedInterface.apply[String](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultStringParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonObject]]((x => if (x == null) null else GenericRefedInterface.apply[JsonObject](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonObjectParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultJsonArrayParameterizedFuture(): concurrent.Future[GenericRefedInterface[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[JsonArray]]((x => if (x == null) null else GenericRefedInterface.apply[JsonArray](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultJsonArrayParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultDataObjectParameterizedFuture(): concurrent.Future[GenericRefedInterface[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[TestDataObject]]((x => if (x == null) null else GenericRefedInterface.apply[TestDataObject](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultDataObjectParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestEnum](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultEnumParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultGenEnumParameterizedFuture(): concurrent.Future[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else GenericRefedInterface.apply[io.vertx.codegen.testmodel.TestGenEnum](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenEnumParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultUserTypeParameterizedFuture(): concurrent.Future[GenericRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[RefedInterface1]]((x => if (x == null) null else GenericRefedInterface.apply[RefedInterface1](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultUserTypeParameterized(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamByteParameterized(handler: JGenericRefedInterface[Byte] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamByteParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Byte],java.lang.String]])
  }

  def methodWithFunctionParamShortParameterized(handler: JGenericRefedInterface[Short] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamShortParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Short],java.lang.String]])
  }

  def methodWithFunctionParamIntegerParameterized(handler: JGenericRefedInterface[Integer] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamIntegerParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Integer],java.lang.String]])
  }

  def methodWithFunctionParamLongParameterized(handler: JGenericRefedInterface[Long] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamLongParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Long],java.lang.String]])
  }

  def methodWithFunctionParamFloatParameterized(handler: JGenericRefedInterface[Float] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamFloatParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Float],java.lang.String]])
  }

  def methodWithFunctionParamDoubleParameterized(handler: JGenericRefedInterface[Double] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamDoubleParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Double],java.lang.String]])
  }

  def methodWithFunctionParamBooleanParameterized(handler: JGenericRefedInterface[Boolean] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamBooleanParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Boolean],java.lang.String]])
  }

  def methodWithFunctionParamCharacterParameterized(handler: JGenericRefedInterface[Character] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamCharacterParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.Character],java.lang.String]])
  }

  def methodWithFunctionParamStringParameterized(handler: JGenericRefedInterface[String] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamStringParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[java.lang.String],java.lang.String]])
  }

  def methodWithFunctionParamJsonObjectParameterized(handler: GenericRefedInterface[JsonObject] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamJsonObjectParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonObject],java.lang.String]])
  }

  def methodWithFunctionParamJsonArrayParameterized(handler: GenericRefedInterface[JsonArray] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamJsonArrayParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.core.json.JsonArray],java.lang.String]])
  }

  def methodWithFunctionParamDataObjectParameterized(handler: JGenericRefedInterface[TestDataObject] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamDataObjectParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestDataObject],java.lang.String]])
  }

  def methodWithFunctionParamEnumParameterized(handler: JGenericRefedInterface[TestEnum] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamEnumParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestEnum],java.lang.String]])
  }

  def methodWithFunctionParamGenEnumParameterized(handler: JGenericRefedInterface[TestGenEnum] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamGenEnumParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.TestGenEnum],java.lang.String]])
  }

  def methodWithFunctionParamUserTypeParameterized(handler: JGenericRefedInterface[RefedInterface1] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamUserTypeParameterized(asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[io.vertx.codegen.testmodel.RefedInterface1],java.lang.String]])
  }

  def methodWithClassTypeParameterizedReturn[U: TypeTag](`type`: java.lang.Class[U]): GenericRefedInterface[U] = {
    GenericRefedInterface.apply[U](asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeParameterizedReturn(`type`.asInstanceOf[java.lang.Class[Object]]))
  }

  def methodWithHandlerClassTypeParameterized[U: TypeTag](`type`: java.lang.Class[U], handler: io.vertx.core.Handler[GenericRefedInterface[U]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], funcToMappedHandler[JGenericRefedInterface[U], GenericRefedInterface[U]](GenericRefedInterface.apply[U])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]])
  }

  def methodWithHandlerAsyncResultClassTypeParameterizedFuture[U: TypeTag](`type`: java.lang.Class[U]): concurrent.Future[GenericRefedInterface[U]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericRefedInterface[U]]((x => if (x == null) null else GenericRefedInterface.apply[U](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericRefedInterface[Object]]]])
    promiseAndHandler._2.future
  }

  def methodWithFunctionParamClassTypeParameterized[U: TypeTag](`type`: java.lang.Class[U], handler: JGenericRefedInterface[U] => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithFunctionParamClassTypeParameterized(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(handler).asInstanceOf[java.util.function.Function[io.vertx.codegen.testmodel.GenericRefedInterface[Object],java.lang.String]])
  }

  def methodWithClassTypeParam[U: TypeTag](`type`: java.lang.Class[U], u: U): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeParam(`type`.asInstanceOf[java.lang.Class[Object]], toJava[U](u).asInstanceOf[Object])
  }

  def methodWithClassTypeReturn[U: TypeTag](`type`: java.lang.Class[U]): U = {
    toScala[U](asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeReturn(`type`.asInstanceOf[java.lang.Class[Object]]))
  }

  def methodWithClassTypeHandler[U: TypeTag](`type`: java.lang.Class[U], f: io.vertx.core.Handler[U]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeHandler(`type`.asInstanceOf[java.lang.Class[Object]], (f).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithClassTypeHandlerAsyncResultFuture[U: TypeTag](`type`: java.lang.Class[U]): concurrent.Future[U] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[U]((x => x.asInstanceOf))
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeHandlerAsyncResult(`type`.asInstanceOf[java.lang.Class[Object]], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def methodWithClassTypeFunctionParam[U: TypeTag](`type`: java.lang.Class[U], f: U => java.lang.String): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeFunctionParam(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(f).asInstanceOf[java.util.function.Function[Object,java.lang.String]])
  }

  def methodWithClassTypeFunctionReturn[U: TypeTag](`type`: java.lang.Class[U], f: java.lang.String => U): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithClassTypeFunctionReturn(`type`.asInstanceOf[java.lang.Class[Object]], asJavaFunction(f).asInstanceOf[java.util.function.Function[java.lang.String,Object]])
  }

  def interfaceWithApiArg(value: RefedInterface1): InterfaceWithApiArg = {
    InterfaceWithApiArg.apply(asJava.asInstanceOf[JGenericsTCK].interfaceWithApiArg(value.asJava.asInstanceOf[JRefedInterface1]))
  }

  def interfaceWithStringArg(value: String): InterfaceWithStringArg = {
    InterfaceWithStringArg.apply(asJava.asInstanceOf[JGenericsTCK].interfaceWithStringArg(value))
  }

  def interfaceWithVariableArg[T: TypeTag, U: TypeTag](value1: T, `type`: java.lang.Class[U], value2: U): InterfaceWithVariableArg[T, U] = {
    InterfaceWithVariableArg.apply[T,U](asJava.asInstanceOf[JGenericsTCK].interfaceWithVariableArg(toJava[T](value1).asInstanceOf[Object], `type`.asInstanceOf[java.lang.Class[Object]], toJava[U](value2).asInstanceOf[Object]))
  }

  def methodWithHandlerGenericNullableApi(notNull: Boolean, handler: io.vertx.core.Handler[GenericNullableRefedInterface[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerGenericNullableApi(notNull, funcToMappedHandler[JGenericNullableRefedInterface[RefedInterface1], GenericNullableRefedInterface[RefedInterface1]](GenericNullableRefedInterface.apply[RefedInterface1])(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithHandlerAsyncResultGenericNullableApiFuture(notNull: Boolean): concurrent.Future[GenericNullableRefedInterface[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[GenericNullableRefedInterface[RefedInterface1]]((x => if (x == null) null else GenericNullableRefedInterface.apply[RefedInterface1](x.asInstanceOf)))
    asJava.asInstanceOf[JGenericsTCK].methodWithHandlerAsyncResultGenericNullableApi(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.GenericNullableRefedInterface[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithGenericNullableApiReturn(notNull: Boolean): GenericNullableRefedInterface[RefedInterface1] = {
    GenericNullableRefedInterface.apply[RefedInterface1](asJava.asInstanceOf[JGenericsTCK].methodWithGenericNullableApiReturn(notNull))
  }

}

object GenericsTCK {

  def apply(_asJava: Object): GenericsTCK =
    new GenericsTCK(_asJava)

}
