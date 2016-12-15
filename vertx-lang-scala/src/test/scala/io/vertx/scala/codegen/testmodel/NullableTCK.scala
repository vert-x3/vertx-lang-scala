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
import io.vertx.codegen.testmodel.{NullableTCK => JNullableTCK}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject
import io.vertx.codegen.testmodel.TestGenEnum

/**
  * The TCK for @Nullable.
  */
class NullableTCK(private val _asJava: Object) {

  def asJava: Object = _asJava

  def methodWithNonNullableByteParam(param: Byte): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableByteParam(param)
  }

  def methodWithNullableByteParam(expectNull: Boolean, param: scala.Option[Byte]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Byte]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteHandler(notNull, funcToMappedHandler[java.lang.Byte, Byte](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Byte]])
  }

  def methodWithNullableByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Byte] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Byte]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Byte]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableByteReturn(notNull: Boolean): scala.Option[Byte] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableByteReturn(notNull))
  }

  def methodWithNonNullableShortParam(param: Short): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableShortParam(param)
  }

  def methodWithNullableShortParam(expectNull: Boolean, param: scala.Option[Short]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Short]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortHandler(notNull, funcToMappedHandler[java.lang.Short, Short](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Short]])
  }

  def methodWithNullableShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Short] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Short]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Short]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableShortReturn(notNull: Boolean): scala.Option[Short] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableShortReturn(notNull))
  }

  def methodWithNonNullableIntegerParam(param: Int): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableIntegerParam(param)
  }

  def methodWithNullableIntegerParam(expectNull: Boolean, param: scala.Option[Int]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Int]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerHandler(notNull, funcToMappedHandler[java.lang.Integer, Int](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Integer]])
  }

  def methodWithNullableIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Int]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Integer]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableIntegerReturn(notNull: Boolean): scala.Option[Int] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerReturn(notNull))
  }

  def methodWithNonNullableLongParam(param: Long): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableLongParam(param)
  }

  def methodWithNullableLongParam(expectNull: Boolean, param: scala.Option[Long]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Long]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongHandler(notNull, funcToMappedHandler[java.lang.Long, Long](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Long]])
  }

  def methodWithNullableLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Long]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Long]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableLongReturn(notNull: Boolean): scala.Option[Long] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableLongReturn(notNull))
  }

  def methodWithNonNullableFloatParam(param: Float): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableFloatParam(param)
  }

  def methodWithNullableFloatParam(expectNull: Boolean, param: scala.Option[Float]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Float]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatHandler(notNull, funcToMappedHandler[java.lang.Float, Float](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Float]])
  }

  def methodWithNullableFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Float] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Float]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Float]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableFloatReturn(notNull: Boolean): scala.Option[Float] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatReturn(notNull))
  }

  def methodWithNonNullableDoubleParam(param: Double): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableDoubleParam(param)
  }

  def methodWithNullableDoubleParam(expectNull: Boolean, param: scala.Option[Double]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Double]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleHandler(notNull, funcToMappedHandler[java.lang.Double, Double](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Double]])
  }

  def methodWithNullableDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Double] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Double]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Double]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableDoubleReturn(notNull: Boolean): scala.Option[Double] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleReturn(notNull))
  }

  def methodWithNonNullableBooleanParam(param: Boolean): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableBooleanParam(param)
  }

  def methodWithNullableBooleanParam(expectNull: Boolean, param: scala.Option[Boolean]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Boolean]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanHandler(notNull, funcToMappedHandler[java.lang.Boolean, Boolean](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Boolean]])
  }

  def methodWithNullableBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableBooleanReturn(notNull: Boolean): scala.Option[Boolean] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanReturn(notNull))
  }

  def methodWithNonNullableStringParam(param: String): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableStringParam(param)
  }

  def methodWithNullableStringParam(expectNull: Boolean, param: scala.Option[String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringHandler(notNull, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithNullableStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableStringReturn(notNull: Boolean): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableStringReturn(notNull))
  }

  def methodWithNonNullableCharParam(param: Char): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableCharParam(param)
  }

  def methodWithNullableCharParam(expectNull: Boolean, param: scala.Option[Char]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Char]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharHandler(notNull, funcToMappedHandler[java.lang.Character, Char](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Character]])
  }

  def methodWithNullableCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Char] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Char]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Character]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableCharReturn(notNull: Boolean): scala.Option[Char] = {
    nullsafeConvToOption(asJava.asInstanceOf[JNullableTCK].methodWithNullableCharReturn(notNull))
  }

  def methodWithNonNullableJsonObjectParam(param: JsonObject): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableJsonObjectParam(param)
  }

  def methodWithNullableJsonObjectParam(expectNull: Boolean, param: scala.Option[JsonObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[JsonObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectHandler(notNull, funcToMappedHandler[JsonObject, JsonObject](x => x)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableJsonObjectReturn(notNull: Boolean): scala.Option[JsonObject] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectReturn(notNull))
  }

  def methodWithNonNullableJsonArrayParam(param: JsonArray): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableJsonArrayParam(param)
  }

  def methodWithNullableJsonArrayParam(expectNull: Boolean, param: scala.Option[JsonArray]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayHandler(notNull, funcToMappedHandler[JsonArray, JsonArray](x => x)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableJsonArrayReturn(notNull: Boolean): scala.Option[JsonArray] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayReturn(notNull))
  }

  def methodWithNonNullableApiParam(param: RefedInterface1): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableApiParam(param.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithNullableApiParam(expectNull: Boolean, param: scala.Option[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiParam(expectNull, (if (param.isDefined) param.get.asJava else null))
  }

  def methodWithNullableApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiHandler(notNull, funcToMappedHandler[JRefedInterface1, RefedInterface1](RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[RefedInterface1] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[RefedInterface1]((x => if (x == null) null else RefedInterface1.apply(x.asInstanceOf)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableApiReturn(notNull: Boolean): scala.Option[RefedInterface1] = {
    scala.Option(RefedInterface1.apply(asJava.asInstanceOf[JNullableTCK].methodWithNullableApiReturn(notNull)))
  }

  def methodWithNonNullableDataObjectParam(param: TestDataObject): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableDataObjectParam(param.asJava)
  }

  def methodWithNullableDataObjectParam(expectNull: Boolean, param: scala.Option[TestDataObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectParam(expectNull, (if (param.isDefined) param.get.asJava else null))
  }

  def methodWithNullableDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[TestDataObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectHandler(notNull, funcToMappedHandler[JTestDataObject, TestDataObject](a => TestDataObject(a))(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[TestDataObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TestDataObject]((x => io.vertx.scala.codegen.testmodel.TestDataObject(x.asInstanceOf)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestDataObject]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableDataObjectReturn(notNull: Boolean): scala.Option[TestDataObject] = {
    scala.Option(TestDataObject(asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectReturn(notNull)))
  }

  def methodWithNonNullableEnumParam(param: io.vertx.codegen.testmodel.TestEnum): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableEnumParam(param)
  }

  def methodWithNullableEnumParam(expectNull: Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumHandler(notNull, (handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[io.vertx.codegen.testmodel.TestEnum] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.codegen.testmodel.TestEnum]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestEnum]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableEnumReturn(notNull: Boolean): scala.Option[io.vertx.codegen.testmodel.TestEnum] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumReturn(notNull))
  }

  def methodWithNonNullableGenEnumParam(param: io.vertx.codegen.testmodel.TestGenEnum): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableGenEnumParam(param)
  }

  def methodWithNullableGenEnumParam(expectNull: Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumHandler(notNull, (handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[io.vertx.codegen.testmodel.TestGenEnum] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.codegen.testmodel.TestGenEnum]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestGenEnum]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableGenEnumReturn(notNull: Boolean): scala.Option[io.vertx.codegen.testmodel.TestGenEnum] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumReturn(notNull))
  }

  def methodWithNullableTypeVariableParam[T: TypeTag](expectNull: Boolean, param: T): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableParam(expectNull, toJava[T](param).asInstanceOf[Object])
  }

  def methodWithNullableTypeVariableHandler[T: TypeTag](notNull: Boolean, value: T, handler: io.vertx.core.Handler[T]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableHandler(notNull, toJava[T](value).asInstanceOf[Object], (handler).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithNullableTypeVariableHandlerAsyncResultFuture[T: TypeTag](notNull: Boolean, value: T): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableHandlerAsyncResult(notNull, toJava[T](value).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableTypeVariableReturn[T: TypeTag](notNull: Boolean, value: T): T = {
    toScala[T](asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableReturn(notNull, toJava[T](value).asInstanceOf[Object]))
  }

  def methodWithNullableObjectParam(expectNull: Boolean, param: AnyRef): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableObjectParam(expectNull, toJava[java.lang.Object](param).asInstanceOf[Object])
  }

  def methodWithNonNullableListByteParam(param: scala.collection.mutable.Buffer[Byte]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithNullableListByteParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Byte).asJava else null.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithNullableListByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Byte], scala.collection.mutable.Buffer[Byte]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Byte]]])
  }

  def methodWithNullableListByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListByteReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Byte]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteReturn(notNull)).map(_.asScala.map(x => x:Byte))
  }

  def methodWithNonNullableListShortParam(param: scala.collection.mutable.Buffer[Short]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithNullableListShortParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Short).asJava else null.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithNullableListShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Short], scala.collection.mutable.Buffer[Short]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Short]]])
  }

  def methodWithNullableListShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListShortReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Short]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortReturn(notNull)).map(_.asScala.map(x => x:Short))
  }

  def methodWithNonNullableListIntegerParam(param: scala.collection.mutable.Buffer[Int]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithNullableListIntegerParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Integer).asJava else null.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithNullableListIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Integer]]])
  }

  def methodWithNullableListIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListIntegerReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Int]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerReturn(notNull)).map(_.asScala.map(x => x:Int))
  }

  def methodWithNonNullableListLongParam(param: scala.collection.mutable.Buffer[Long]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithNullableListLongParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Long).asJava else null.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithNullableListLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Long], scala.collection.mutable.Buffer[Long]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Long]]])
  }

  def methodWithNullableListLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListLongReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Long]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongReturn(notNull)).map(_.asScala.map(x => x:Long))
  }

  def methodWithNonNullableListFloatParam(param: scala.collection.mutable.Buffer[Float]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithNullableListFloatParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Float).asJava else null.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithNullableListFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Float], scala.collection.mutable.Buffer[Float]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Float]]])
  }

  def methodWithNullableListFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListFloatReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Float]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatReturn(notNull)).map(_.asScala.map(x => x:Float))
  }

  def methodWithNonNullableListDoubleParam(param: scala.collection.mutable.Buffer[Double]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithNullableListDoubleParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Double).asJava else null.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithNullableListDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Double], scala.collection.mutable.Buffer[Double]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Double]]])
  }

  def methodWithNullableListDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListDoubleReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Double]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleReturn(notNull)).map(_.asScala.map(x => x:Double))
  }

  def methodWithNonNullableListBooleanParam(param: scala.collection.mutable.Buffer[Boolean]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithNullableListBooleanParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Boolean).asJava else null.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithNullableListBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Boolean], scala.collection.mutable.Buffer[Boolean]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Boolean]]])
  }

  def methodWithNullableListBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListBooleanReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Boolean]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanReturn(notNull)).map(_.asScala.map(x => x:Boolean))
  }

  def methodWithNonNullableListStringParam(param: scala.collection.mutable.Buffer[String]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithNullableListStringParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.String).asJava else null.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithNullableListStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringHandler(notNull, funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.String]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.String]]])
  }

  def methodWithNullableListStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListStringReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[String]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringReturn(notNull)).map(_.asScala.map(x => x:String))
  }

  def methodWithNonNullableListCharParam(param: scala.collection.mutable.Buffer[Char]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithNullableListCharParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Character).asJava else null.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithNullableListCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Character], scala.collection.mutable.Buffer[Char]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Character]]])
  }

  def methodWithNullableListCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListCharReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Char]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharReturn(notNull)).map(_.asScala.map(x => x:Char))
  }

  def methodWithNonNullableListJsonObjectParam(param: scala.collection.mutable.Buffer[JsonObject]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableListJsonObjectParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonObject).asJava else null.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableListJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableListJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListJsonObjectReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[JsonObject]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectReturn(notNull)).map(_.asScala.map(x => x:JsonObject))
  }

  def methodWithNonNullableListJsonArrayParam(param: scala.collection.mutable.Buffer[JsonArray]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableListJsonArrayParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonArray).asJava else null.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableListJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableListJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListJsonArrayReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[JsonArray]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayReturn(notNull)).map(_.asScala.map(x => x:JsonArray))
  }

  def methodWithNonNullableListApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListApiParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableListApiParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]) else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableListApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithNullableListApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply)))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListApiReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[RefedInterface1]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiReturn(notNull)).map(_.asScala.map(RefedInterface1.apply))
  }

  def methodWithNonNullableListDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListDataObjectParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableListDataObjectParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]) else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableListDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithNullableListDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x))))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListDataObjectReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[TestDataObject]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectReturn(notNull)).map(_.asScala.map(x => TestDataObject(x)))
  }

  def methodWithNonNullableListEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableListEnumParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableListEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithNullableListEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListEnumReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum))
  }

  def methodWithNonNullableListGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableListGenEnumParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableListGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithNullableListGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListGenEnumReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum))
  }

  def methodWithNonNullableSetByteParam(param: Set[Byte]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithNullableSetByteParam(expectNull: Boolean, param: scala.Option[Set[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Byte).asJava else null.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithNullableSetByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Byte], Set[Byte]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Byte]]])
  }

  def methodWithNullableSetByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetByteReturn(notNull: Boolean): scala.Option[Set[Byte]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteReturn(notNull)).map(_.asScala.map(x => x:Byte).toSet)
  }

  def methodWithNonNullableSetShortParam(param: Set[Short]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithNullableSetShortParam(expectNull: Boolean, param: scala.Option[Set[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Short).asJava else null.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithNullableSetShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Short], Set[Short]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Short]]])
  }

  def methodWithNullableSetShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetShortReturn(notNull: Boolean): scala.Option[Set[Short]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortReturn(notNull)).map(_.asScala.map(x => x:Short).toSet)
  }

  def methodWithNonNullableSetIntegerParam(param: Set[Int]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithNullableSetIntegerParam(expectNull: Boolean, param: scala.Option[Set[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Integer).asJava else null.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithNullableSetIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Integer]]])
  }

  def methodWithNullableSetIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetIntegerReturn(notNull: Boolean): scala.Option[Set[Int]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerReturn(notNull)).map(_.asScala.map(x => x:Int).toSet)
  }

  def methodWithNonNullableSetLongParam(param: Set[Long]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithNullableSetLongParam(expectNull: Boolean, param: scala.Option[Set[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Long).asJava else null.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithNullableSetLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Long], Set[Long]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Long]]])
  }

  def methodWithNullableSetLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetLongReturn(notNull: Boolean): scala.Option[Set[Long]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongReturn(notNull)).map(_.asScala.map(x => x:Long).toSet)
  }

  def methodWithNonNullableSetFloatParam(param: Set[Float]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithNullableSetFloatParam(expectNull: Boolean, param: scala.Option[Set[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Float).asJava else null.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithNullableSetFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Float], Set[Float]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Float]]])
  }

  def methodWithNullableSetFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetFloatReturn(notNull: Boolean): scala.Option[Set[Float]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatReturn(notNull)).map(_.asScala.map(x => x:Float).toSet)
  }

  def methodWithNonNullableSetDoubleParam(param: Set[Double]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithNullableSetDoubleParam(expectNull: Boolean, param: scala.Option[Set[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Double).asJava else null.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithNullableSetDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Double], Set[Double]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Double]]])
  }

  def methodWithNullableSetDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetDoubleReturn(notNull: Boolean): scala.Option[Set[Double]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleReturn(notNull)).map(_.asScala.map(x => x:Double).toSet)
  }

  def methodWithNonNullableSetBooleanParam(param: Set[Boolean]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithNullableSetBooleanParam(expectNull: Boolean, param: scala.Option[Set[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Boolean).asJava else null.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithNullableSetBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Boolean], Set[Boolean]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Boolean]]])
  }

  def methodWithNullableSetBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetBooleanReturn(notNull: Boolean): scala.Option[Set[Boolean]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanReturn(notNull)).map(_.asScala.map(x => x:Boolean).toSet)
  }

  def methodWithNonNullableSetStringParam(param: Set[String]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithNullableSetStringParam(expectNull: Boolean, param: scala.Option[Set[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.String).asJava else null.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithNullableSetStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.String]]])
  }

  def methodWithNullableSetStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[String]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetStringReturn(notNull: Boolean): scala.Option[Set[String]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringReturn(notNull)).map(_.asScala.map(x => x:String).toSet)
  }

  def methodWithNonNullableSetCharParam(param: Set[Char]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithNullableSetCharParam(expectNull: Boolean, param: scala.Option[Set[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Character).asJava else null.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithNullableSetCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Character], Set[Char]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Character]]])
  }

  def methodWithNullableSetCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetCharReturn(notNull: Boolean): scala.Option[Set[Char]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharReturn(notNull)).map(_.asScala.map(x => x:Char).toSet)
  }

  def methodWithNonNullableSetJsonObjectParam(param: Set[JsonObject]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableSetJsonObjectParam(expectNull: Boolean, param: scala.Option[Set[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonObject).asJava else null.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableSetJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableSetJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetJsonObjectReturn(notNull: Boolean): scala.Option[Set[JsonObject]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectReturn(notNull)).map(_.asScala.map(x => x:JsonObject).toSet)
  }

  def methodWithNonNullableSetJsonArrayParam(param: Set[JsonArray]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableSetJsonArrayParam(expectNull: Boolean, param: scala.Option[Set[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonArray).asJava else null.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableSetJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableSetJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetJsonArrayReturn(notNull: Boolean): scala.Option[Set[JsonArray]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayReturn(notNull)).map(_.asScala.map(x => x:JsonArray).toSet)
  }

  def methodWithNonNullableSetApiParam(param: Set[RefedInterface1]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetApiParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableSetApiParam(expectNull: Boolean, param: scala.Option[Set[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]) else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableSetApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithNullableSetApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetApiReturn(notNull: Boolean): scala.Option[Set[RefedInterface1]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiReturn(notNull)).map(_.asScala.map(RefedInterface1.apply).toSet)
  }

  def methodWithNonNullableSetDataObjectParam(param: Set[TestDataObject]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetDataObjectParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableSetDataObjectParam(expectNull: Boolean, param: scala.Option[Set[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]) else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableSetDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithNullableSetDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetDataObjectReturn(notNull: Boolean): scala.Option[Set[TestDataObject]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectReturn(notNull)).map(_.asScala.map(x => TestDataObject(x)).toSet)
  }

  def methodWithNonNullableSetEnumParam(param: Set[io.vertx.codegen.testmodel.TestEnum]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableSetEnumParam(expectNull: Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableSetEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithNullableSetEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetEnumReturn(notNull: Boolean): scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet)
  }

  def methodWithNonNullableSetGenEnumParam(param: Set[io.vertx.codegen.testmodel.TestGenEnum]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableSetGenEnumParam(expectNull: Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableSetGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum], Set[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithNullableSetGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetGenEnumReturn(notNull: Boolean): scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).toSet)
  }

  def methodWithNonNullableMapByteParam(param: Map[String, Byte]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapByteParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithNullableMapByteParam(expectNull: Boolean, param: scala.Option[Map[String, Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithNullableMapByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Byte], Map[String, Byte]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Byte]]])
  }

  def methodWithNullableMapByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapByteReturn(notNull: Boolean): scala.Option[Map[String, Byte]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Byte)).toMap)
  }

  def methodWithNonNullableMapShortParam(param: Map[String, Short]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapShortParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithNullableMapShortParam(expectNull: Boolean, param: scala.Option[Map[String, Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithNullableMapShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Short], Map[String, Short]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Short]]])
  }

  def methodWithNullableMapShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapShortReturn(notNull: Boolean): scala.Option[Map[String, Short]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Short)).toMap)
  }

  def methodWithNonNullableMapIntegerParam(param: Map[String, Int]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapIntegerParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithNullableMapIntegerParam(expectNull: Boolean, param: scala.Option[Map[String, Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithNullableMapIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Integer], Map[String, Int]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Integer]]])
  }

  def methodWithNullableMapIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapIntegerReturn(notNull: Boolean): scala.Option[Map[String, Int]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Int)).toMap)
  }

  def methodWithNonNullableMapLongParam(param: Map[String, Long]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapLongParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithNullableMapLongParam(expectNull: Boolean, param: scala.Option[Map[String, Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithNullableMapLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Long], Map[String, Long]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Long]]])
  }

  def methodWithNullableMapLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapLongReturn(notNull: Boolean): scala.Option[Map[String, Long]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Long)).toMap)
  }

  def methodWithNonNullableMapFloatParam(param: Map[String, Float]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapFloatParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithNullableMapFloatParam(expectNull: Boolean, param: scala.Option[Map[String, Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithNullableMapFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Float], Map[String, Float]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Float]]])
  }

  def methodWithNullableMapFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapFloatReturn(notNull: Boolean): scala.Option[Map[String, Float]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Float)).toMap)
  }

  def methodWithNonNullableMapDoubleParam(param: Map[String, Double]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapDoubleParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithNullableMapDoubleParam(expectNull: Boolean, param: scala.Option[Map[String, Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithNullableMapDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Double], Map[String, Double]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Double]]])
  }

  def methodWithNullableMapDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapDoubleReturn(notNull: Boolean): scala.Option[Map[String, Double]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Double)).toMap)
  }

  def methodWithNonNullableMapBooleanParam(param: Map[String, Boolean]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapBooleanParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithNullableMapBooleanParam(expectNull: Boolean, param: scala.Option[Map[String, Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithNullableMapBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Boolean], Map[String, Boolean]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Boolean]]])
  }

  def methodWithNullableMapBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapBooleanReturn(notNull: Boolean): scala.Option[Map[String, Boolean]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Boolean)).toMap)
  }

  def methodWithNonNullableMapStringParam(param: Map[String, String]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapStringParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithNullableMapStringParam(expectNull: Boolean, param: scala.Option[Map[String, String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithNullableMapStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.String], Map[String, String]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.String]]])
  }

  def methodWithNullableMapStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, String]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapStringReturn(notNull: Boolean): scala.Option[Map[String, String]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapCharParam(param: Map[String, Char]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapCharParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithNullableMapCharParam(expectNull: Boolean, param: scala.Option[Map[String, Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithNullableMapCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Character], Map[String, Char]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Character]]])
  }

  def methodWithNullableMapCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapCharReturn(notNull: Boolean): scala.Option[Map[String, Char]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Char)).toMap)
  }

  def methodWithNonNullableMapJsonObjectParam(param: Map[String, JsonObject]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapJsonObjectParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableMapJsonObjectParam(expectNull: Boolean, param: scala.Option[Map[String, JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableMapJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject], Map[String, JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableMapJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapJsonObjectReturn(notNull: Boolean): scala.Option[Map[String, JsonObject]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapJsonArrayParam(param: Map[String, JsonArray]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapJsonArrayParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableMapJsonArrayParam(expectNull: Boolean, param: scala.Option[Map[String, JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableMapJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray], Map[String, JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableMapJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapJsonArrayReturn(notNull: Boolean): scala.Option[Map[String, JsonArray]] = {
    scala.Option(asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapApiParam(param: Map[String, RefedInterface1]): Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapApiParam(param.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableMapApiParam(expectNull: Boolean, param: scala.Option[Map[String, RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapApiParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithListNullableByteParam(param: scala.collection.mutable.Buffer[Byte]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithListNullableByteHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteHandler(funcToMappedHandler[java.util.List[java.lang.Byte], scala.collection.mutable.Buffer[Byte]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Byte]]])
  }

  def methodWithListNullableByteHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableByteReturn(): scala.collection.mutable.Buffer[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteReturn().asScala.map(x => x:Byte)
  }

  def methodWithListNullableShortParam(param: scala.collection.mutable.Buffer[Short]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithListNullableShortHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortHandler(funcToMappedHandler[java.util.List[java.lang.Short], scala.collection.mutable.Buffer[Short]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Short]]])
  }

  def methodWithListNullableShortHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableShortReturn(): scala.collection.mutable.Buffer[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortReturn().asScala.map(x => x:Short)
  }

  def methodWithListNullableIntegerParam(param: scala.collection.mutable.Buffer[Int]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithListNullableIntegerHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerHandler(funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Integer]]])
  }

  def methodWithListNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableIntegerReturn(): scala.collection.mutable.Buffer[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerReturn().asScala.map(x => x:Int)
  }

  def methodWithListNullableLongParam(param: scala.collection.mutable.Buffer[Long]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithListNullableLongHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongHandler(funcToMappedHandler[java.util.List[java.lang.Long], scala.collection.mutable.Buffer[Long]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Long]]])
  }

  def methodWithListNullableLongHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableLongReturn(): scala.collection.mutable.Buffer[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongReturn().asScala.map(x => x:Long)
  }

  def methodWithListNullableBooleanParam(param: scala.collection.mutable.Buffer[Boolean]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithListNullableBooleanHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanHandler(funcToMappedHandler[java.util.List[java.lang.Boolean], scala.collection.mutable.Buffer[Boolean]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Boolean]]])
  }

  def methodWithListNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableBooleanReturn(): scala.collection.mutable.Buffer[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanReturn().asScala.map(x => x:Boolean)
  }

  def methodWithListNullableFloatParam(param: scala.collection.mutable.Buffer[Float]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithListNullableFloatHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatHandler(funcToMappedHandler[java.util.List[java.lang.Float], scala.collection.mutable.Buffer[Float]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Float]]])
  }

  def methodWithListNullableFloatHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableFloatReturn(): scala.collection.mutable.Buffer[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatReturn().asScala.map(x => x:Float)
  }

  def methodWithListNullableDoubleParam(param: scala.collection.mutable.Buffer[Double]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithListNullableDoubleHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleHandler(funcToMappedHandler[java.util.List[java.lang.Double], scala.collection.mutable.Buffer[Double]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Double]]])
  }

  def methodWithListNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableDoubleReturn(): scala.collection.mutable.Buffer[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleReturn().asScala.map(x => x:Double)
  }

  def methodWithListNullableStringParam(param: scala.collection.mutable.Buffer[String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithListNullableStringHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringHandler(funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.String]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.String]]])
  }

  def methodWithListNullableStringHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableStringReturn(): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringReturn().asScala.map(x => x:String)
  }

  def methodWithListNullableCharParam(param: scala.collection.mutable.Buffer[Char]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithListNullableCharHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharHandler(funcToMappedHandler[java.util.List[java.lang.Character], scala.collection.mutable.Buffer[Char]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Character]]])
  }

  def methodWithListNullableCharHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableCharReturn(): scala.collection.mutable.Buffer[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharReturn().asScala.map(x => x:Char)
  }

  def methodWithListNullableJsonObjectParam(param: scala.collection.mutable.Buffer[JsonObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithListNullableJsonObjectHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectHandler(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithListNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListNullableJsonArrayParam(param: scala.collection.mutable.Buffer[JsonArray]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithListNullableJsonArrayHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayHandler(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithListNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListNullableApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithListNullableApiHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithListNullableApiHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply)))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableApiReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiReturn().asScala.map(RefedInterface1.apply)
  }

  def methodWithListNullableDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithListNullableDataObjectHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithListNullableDataObjectHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x))))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableDataObjectReturn(): scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListNullableEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithListNullableEnumHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithListNullableEnumHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum)
  }

  def methodWithListNullableGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithListNullableGenEnumHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithListNullableGenEnumHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala))
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableGenEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum)
  }

  def methodWithSetNullableByteParam(param: Set[Byte]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithSetNullableByteHandler(handler: io.vertx.core.Handler[Set[Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteHandler(funcToMappedHandler[java.util.Set[java.lang.Byte], Set[Byte]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Byte]]])
  }

  def methodWithSetNullableByteHandlerAsyncResultFuture(): concurrent.Future[Set[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableByteReturn(): Set[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteReturn().asScala.map(x => x:Byte).toSet
  }

  def methodWithSetNullableShortParam(param: Set[Short]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithSetNullableShortHandler(handler: io.vertx.core.Handler[Set[Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortHandler(funcToMappedHandler[java.util.Set[java.lang.Short], Set[Short]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Short]]])
  }

  def methodWithSetNullableShortHandlerAsyncResultFuture(): concurrent.Future[Set[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableShortReturn(): Set[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortReturn().asScala.map(x => x:Short).toSet
  }

  def methodWithSetNullableIntegerParam(param: Set[Int]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithSetNullableIntegerHandler(handler: io.vertx.core.Handler[Set[Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerHandler(funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Integer]]])
  }

  def methodWithSetNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableIntegerReturn(): Set[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerReturn().asScala.map(x => x:Int).toSet
  }

  def methodWithSetNullableLongParam(param: Set[Long]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithSetNullableLongHandler(handler: io.vertx.core.Handler[Set[Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongHandler(funcToMappedHandler[java.util.Set[java.lang.Long], Set[Long]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Long]]])
  }

  def methodWithSetNullableLongHandlerAsyncResultFuture(): concurrent.Future[Set[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableLongReturn(): Set[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongReturn().asScala.map(x => x:Long).toSet
  }

  def methodWithSetNullableBooleanParam(param: Set[Boolean]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithSetNullableBooleanHandler(handler: io.vertx.core.Handler[Set[Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanHandler(funcToMappedHandler[java.util.Set[java.lang.Boolean], Set[Boolean]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Boolean]]])
  }

  def methodWithSetNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[Set[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableBooleanReturn(): Set[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanReturn().asScala.map(x => x:Boolean).toSet
  }

  def methodWithSetNullableFloatParam(param: Set[Float]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithSetNullableFloatHandler(handler: io.vertx.core.Handler[Set[Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatHandler(funcToMappedHandler[java.util.Set[java.lang.Float], Set[Float]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Float]]])
  }

  def methodWithSetNullableFloatHandlerAsyncResultFuture(): concurrent.Future[Set[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableFloatReturn(): Set[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatReturn().asScala.map(x => x:Float).toSet
  }

  def methodWithSetNullableDoubleParam(param: Set[Double]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithSetNullableDoubleHandler(handler: io.vertx.core.Handler[Set[Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleHandler(funcToMappedHandler[java.util.Set[java.lang.Double], Set[Double]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Double]]])
  }

  def methodWithSetNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[Set[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableDoubleReturn(): Set[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleReturn().asScala.map(x => x:Double).toSet
  }

  def methodWithSetNullableStringParam(param: Set[String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithSetNullableStringHandler(handler: io.vertx.core.Handler[Set[String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringHandler(funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.String]]])
  }

  def methodWithSetNullableStringHandlerAsyncResultFuture(): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[String]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableStringReturn(): Set[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringReturn().asScala.map(x => x:String).toSet
  }

  def methodWithSetNullableCharParam(param: Set[Char]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithSetNullableCharHandler(handler: io.vertx.core.Handler[Set[Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharHandler(funcToMappedHandler[java.util.Set[java.lang.Character], Set[Char]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Character]]])
  }

  def methodWithSetNullableCharHandlerAsyncResultFuture(): concurrent.Future[Set[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableCharReturn(): Set[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharReturn().asScala.map(x => x:Char).toSet
  }

  def methodWithSetNullableJsonObjectParam(param: Set[JsonObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithSetNullableJsonObjectHandler(handler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectHandler(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithSetNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableJsonObjectReturn(): Set[JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetNullableJsonArrayParam(param: Set[JsonArray]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithSetNullableJsonArrayHandler(handler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayHandler(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithSetNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableJsonArrayReturn(): Set[JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetNullableApiParam(param: Set[RefedInterface1]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithSetNullableApiHandler(handler: io.vertx.core.Handler[Set[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithSetNullableApiHandlerAsyncResultFuture(): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableApiReturn(): Set[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiReturn().asScala.map(RefedInterface1.apply).toSet
  }

  def methodWithSetNullableDataObjectParam(param: Set[TestDataObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectParam(param.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithSetNullableDataObjectHandler(handler: io.vertx.core.Handler[Set[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithSetNullableDataObjectHandlerAsyncResultFuture(): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableDataObjectReturn(): Set[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectReturn().asScala.map(x => TestDataObject(x)).toSet
  }

  def methodWithSetNullableEnumParam(param: Set[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithSetNullableEnumHandler(handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithSetNullableEnumHandlerAsyncResultFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableEnumReturn(): Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet
  }

  def methodWithSetNullableGenEnumParam(param: Set[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithSetNullableGenEnumHandler(handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum], Set[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithSetNullableGenEnumHandlerAsyncResultFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet))
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableGenEnumReturn(): Set[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).toSet
  }

  def methodWithMapNullableByteParam(param: Map[String, Byte]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithMapNullableByteHandler(handler: io.vertx.core.Handler[Map[String, Byte]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Byte], Map[String, Byte]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Byte]]])
  }

  def methodWithMapNullableByteHandlerAsyncResultFuture(): concurrent.Future[Map[String, Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableByteReturn(): Map[String, Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteReturn().asScala.map(kv => (kv._1, kv._2: Byte)).toMap
  }

  def methodWithMapNullableShortParam(param: Map[String, Short]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithMapNullableShortHandler(handler: io.vertx.core.Handler[Map[String, Short]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Short], Map[String, Short]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Short]]])
  }

  def methodWithMapNullableShortHandlerAsyncResultFuture(): concurrent.Future[Map[String, Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableShortReturn(): Map[String, Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortReturn().asScala.map(kv => (kv._1, kv._2: Short)).toMap
  }

  def methodWithMapNullableIntegerParam(param: Map[String, Int]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithMapNullableIntegerHandler(handler: io.vertx.core.Handler[Map[String, Int]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Integer], Map[String, Int]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Integer]]])
  }

  def methodWithMapNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[Map[String, Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableIntegerReturn(): Map[String, Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerReturn().asScala.map(kv => (kv._1, kv._2: Int)).toMap
  }

  def methodWithMapNullableLongParam(param: Map[String, Long]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithMapNullableLongHandler(handler: io.vertx.core.Handler[Map[String, Long]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Long], Map[String, Long]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Long]]])
  }

  def methodWithMapNullableLongHandlerAsyncResultFuture(): concurrent.Future[Map[String, Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableLongReturn(): Map[String, Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongReturn().asScala.map(kv => (kv._1, kv._2: Long)).toMap
  }

  def methodWithMapNullableBooleanParam(param: Map[String, Boolean]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithMapNullableBooleanHandler(handler: io.vertx.core.Handler[Map[String, Boolean]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Boolean], Map[String, Boolean]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Boolean]]])
  }

  def methodWithMapNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[Map[String, Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableBooleanReturn(): Map[String, Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanReturn().asScala.map(kv => (kv._1, kv._2: Boolean)).toMap
  }

  def methodWithMapNullableFloatParam(param: Map[String, Float]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithMapNullableFloatHandler(handler: io.vertx.core.Handler[Map[String, Float]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Float], Map[String, Float]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Float]]])
  }

  def methodWithMapNullableFloatHandlerAsyncResultFuture(): concurrent.Future[Map[String, Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableFloatReturn(): Map[String, Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatReturn().asScala.map(kv => (kv._1, kv._2: Float)).toMap
  }

  def methodWithMapNullableDoubleParam(param: Map[String, Double]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithMapNullableDoubleHandler(handler: io.vertx.core.Handler[Map[String, Double]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Double], Map[String, Double]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Double]]])
  }

  def methodWithMapNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[Map[String, Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableDoubleReturn(): Map[String, Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleReturn().asScala.map(kv => (kv._1, kv._2: Double)).toMap
  }

  def methodWithMapNullableStringParam(param: Map[String, String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithMapNullableStringHandler(handler: io.vertx.core.Handler[Map[String, String]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.String], Map[String, String]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.String]]])
  }

  def methodWithMapNullableStringHandlerAsyncResultFuture(): concurrent.Future[Map[String, String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, String]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableStringReturn(): Map[String, String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringReturn().asScala.toMap
  }

  def methodWithMapNullableCharParam(param: Map[String, Char]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithMapNullableCharHandler(handler: io.vertx.core.Handler[Map[String, Char]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Character], Map[String, Char]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Character]]])
  }

  def methodWithMapNullableCharHandlerAsyncResultFuture(): concurrent.Future[Map[String, Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableCharReturn(): Map[String, Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharReturn().asScala.map(kv => (kv._1, kv._2: Char)).toMap
  }

  def methodWithMapNullableJsonObjectParam(param: Map[String, JsonObject]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithMapNullableJsonObjectHandler(handler: io.vertx.core.Handler[Map[String, JsonObject]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectHandler(funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject], Map[String, JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]])
  }

  def methodWithMapNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[Map[String, JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableJsonObjectReturn(): Map[String, JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectReturn().asScala.toMap
  }

  def methodWithMapNullableJsonArrayParam(param: Map[String, JsonArray]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithMapNullableJsonArrayHandler(handler: io.vertx.core.Handler[Map[String, JsonArray]]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayHandler(funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray], Map[String, JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]])
  }

  def methodWithMapNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[Map[String, JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableJsonArrayReturn(): Map[String, JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayReturn().asScala.toMap
  }

  def methodWithMapNullableApiParam(param: Map[String, RefedInterface1]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableApiParam(param.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableHandler(expectNull: Boolean, handler: io.vertx.core.Handler[String]): Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableHandler(expectNull, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithNullableHandlerAsyncResultFuture(expectNull: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.asInstanceOf[JNullableTCK].methodWithNullableHandlerAsyncResult(expectNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

}

object NullableTCK {

  def apply(_asJava: Object): NullableTCK =
    new NullableTCK(_asJava)

}
