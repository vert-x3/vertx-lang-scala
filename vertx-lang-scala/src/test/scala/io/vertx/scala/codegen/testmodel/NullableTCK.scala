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
class NullableTCK(private val _asJava: JNullableTCK) {

  def asJava: JNullableTCK = _asJava

  def methodWithNonNullableByteParam(param: Byte): Boolean = {
    asJava.methodWithNonNullableByteParam(param)
  }

  def methodWithNullableByteParam(expectNull: Boolean, param: scala.Option[Byte]): Unit = {
    asJava.methodWithNullableByteParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Byte]): Unit = {
    asJava.methodWithNullableByteHandler(notNull, funcToMappedHandler[java.lang.Byte, Byte](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Byte]])
  }

  def methodWithNullableByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Byte] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Byte]((x => x.asInstanceOf))
    asJava.methodWithNullableByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Byte]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableByteReturn(notNull: Boolean): scala.Option[Byte] = {
    nullsafeConvToOption(asJava.methodWithNullableByteReturn(notNull))
  }

  def methodWithNonNullableShortParam(param: Short): Boolean = {
    asJava.methodWithNonNullableShortParam(param)
  }

  def methodWithNullableShortParam(expectNull: Boolean, param: scala.Option[Short]): Unit = {
    asJava.methodWithNullableShortParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Short]): Unit = {
    asJava.methodWithNullableShortHandler(notNull, funcToMappedHandler[java.lang.Short, Short](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Short]])
  }

  def methodWithNullableShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Short] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Short]((x => x.asInstanceOf))
    asJava.methodWithNullableShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Short]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableShortReturn(notNull: Boolean): scala.Option[Short] = {
    nullsafeConvToOption(asJava.methodWithNullableShortReturn(notNull))
  }

  def methodWithNonNullableIntegerParam(param: Int): Boolean = {
    asJava.methodWithNonNullableIntegerParam(param)
  }

  def methodWithNullableIntegerParam(expectNull: Boolean, param: scala.Option[Int]): Unit = {
    asJava.methodWithNullableIntegerParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Int]): Unit = {
    asJava.methodWithNullableIntegerHandler(notNull, funcToMappedHandler[java.lang.Integer, Int](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Integer]])
  }

  def methodWithNullableIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Int]((x => x.asInstanceOf))
    asJava.methodWithNullableIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Integer]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableIntegerReturn(notNull: Boolean): scala.Option[Int] = {
    nullsafeConvToOption(asJava.methodWithNullableIntegerReturn(notNull))
  }

  def methodWithNonNullableLongParam(param: Long): Boolean = {
    asJava.methodWithNonNullableLongParam(param)
  }

  def methodWithNullableLongParam(expectNull: Boolean, param: scala.Option[Long]): Unit = {
    asJava.methodWithNullableLongParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Long]): Unit = {
    asJava.methodWithNullableLongHandler(notNull, funcToMappedHandler[java.lang.Long, Long](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Long]])
  }

  def methodWithNullableLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Long]((x => x.asInstanceOf))
    asJava.methodWithNullableLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Long]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableLongReturn(notNull: Boolean): scala.Option[Long] = {
    nullsafeConvToOption(asJava.methodWithNullableLongReturn(notNull))
  }

  def methodWithNonNullableFloatParam(param: Float): Boolean = {
    asJava.methodWithNonNullableFloatParam(param)
  }

  def methodWithNullableFloatParam(expectNull: Boolean, param: scala.Option[Float]): Unit = {
    asJava.methodWithNullableFloatParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Float]): Unit = {
    asJava.methodWithNullableFloatHandler(notNull, funcToMappedHandler[java.lang.Float, Float](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Float]])
  }

  def methodWithNullableFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Float] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Float]((x => x.asInstanceOf))
    asJava.methodWithNullableFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Float]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableFloatReturn(notNull: Boolean): scala.Option[Float] = {
    nullsafeConvToOption(asJava.methodWithNullableFloatReturn(notNull))
  }

  def methodWithNonNullableDoubleParam(param: Double): Boolean = {
    asJava.methodWithNonNullableDoubleParam(param)
  }

  def methodWithNullableDoubleParam(expectNull: Boolean, param: scala.Option[Double]): Unit = {
    asJava.methodWithNullableDoubleParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Double]): Unit = {
    asJava.methodWithNullableDoubleHandler(notNull, funcToMappedHandler[java.lang.Double, Double](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Double]])
  }

  def methodWithNullableDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Double] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Double]((x => x.asInstanceOf))
    asJava.methodWithNullableDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Double]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableDoubleReturn(notNull: Boolean): scala.Option[Double] = {
    nullsafeConvToOption(asJava.methodWithNullableDoubleReturn(notNull))
  }

  def methodWithNonNullableBooleanParam(param: Boolean): Boolean = {
    asJava.methodWithNonNullableBooleanParam(param)
  }

  def methodWithNullableBooleanParam(expectNull: Boolean, param: scala.Option[Boolean]): Unit = {
    asJava.methodWithNullableBooleanParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Boolean]): Unit = {
    asJava.methodWithNullableBooleanHandler(notNull, funcToMappedHandler[java.lang.Boolean, Boolean](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Boolean]])
  }

  def methodWithNullableBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.methodWithNullableBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableBooleanReturn(notNull: Boolean): scala.Option[Boolean] = {
    nullsafeConvToOption(asJava.methodWithNullableBooleanReturn(notNull))
  }

  def methodWithNonNullableStringParam(param: String): Boolean = {
    asJava.methodWithNonNullableStringParam(param)
  }

  def methodWithNullableStringParam(expectNull: Boolean, param: scala.Option[String]): Unit = {
    asJava.methodWithNullableStringParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[String]): Unit = {
    asJava.methodWithNullableStringHandler(notNull, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithNullableStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.methodWithNullableStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableStringReturn(notNull: Boolean): scala.Option[String] = {
    scala.Option(asJava.methodWithNullableStringReturn(notNull))
  }

  def methodWithNonNullableCharParam(param: Char): Boolean = {
    asJava.methodWithNonNullableCharParam(param)
  }

  def methodWithNullableCharParam(expectNull: Boolean, param: scala.Option[Char]): Unit = {
    asJava.methodWithNullableCharParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Char]): Unit = {
    asJava.methodWithNullableCharHandler(notNull, funcToMappedHandler[java.lang.Character, Char](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Character]])
  }

  def methodWithNullableCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Char] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Char]((x => x.asInstanceOf))
    asJava.methodWithNullableCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Character]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableCharReturn(notNull: Boolean): scala.Option[Char] = {
    nullsafeConvToOption(asJava.methodWithNullableCharReturn(notNull))
  }

  def methodWithNonNullableJsonObjectParam(param: JsonObject): Boolean = {
    asJava.methodWithNonNullableJsonObjectParam(param)
  }

  def methodWithNullableJsonObjectParam(expectNull: Boolean, param: scala.Option[JsonObject]): Unit = {
    asJava.methodWithNullableJsonObjectParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[JsonObject]): Unit = {
    asJava.methodWithNullableJsonObjectHandler(notNull, funcToMappedHandler[JsonObject, JsonObject](x => x)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject]((x => x.asInstanceOf))
    asJava.methodWithNullableJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonObject]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableJsonObjectReturn(notNull: Boolean): scala.Option[JsonObject] = {
    scala.Option(asJava.methodWithNullableJsonObjectReturn(notNull))
  }

  def methodWithNonNullableJsonArrayParam(param: JsonArray): Boolean = {
    asJava.methodWithNonNullableJsonArrayParam(param)
  }

  def methodWithNullableJsonArrayParam(expectNull: Boolean, param: scala.Option[JsonArray]): Unit = {
    asJava.methodWithNullableJsonArrayParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[JsonArray]): Unit = {
    asJava.methodWithNullableJsonArrayHandler(notNull, funcToMappedHandler[JsonArray, JsonArray](x => x)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray]((x => x.asInstanceOf))
    asJava.methodWithNullableJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.json.JsonArray]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableJsonArrayReturn(notNull: Boolean): scala.Option[JsonArray] = {
    scala.Option(asJava.methodWithNullableJsonArrayReturn(notNull))
  }

  def methodWithNonNullableApiParam(param: RefedInterface1): Boolean = {
    asJava.methodWithNonNullableApiParam(param.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithNullableApiParam(expectNull: Boolean, param: scala.Option[RefedInterface1]): Unit = {
    asJava.methodWithNullableApiParam(expectNull, (if (param.isDefined) param.get.asJava else null))
  }

  def methodWithNullableApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[RefedInterface1]): Unit = {
    asJava.methodWithNullableApiHandler(notNull, funcToMappedHandler(RefedInterface1.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[RefedInterface1] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[RefedInterface1]((x => if (x == null) null else RefedInterface1.apply(x.asInstanceOf)))
    asJava.methodWithNullableApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.RefedInterface1]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableApiReturn(notNull: Boolean): scala.Option[RefedInterface1] = {
    scala.Option(RefedInterface1.apply(asJava.methodWithNullableApiReturn(notNull)))
  }

  def methodWithNonNullableDataObjectParam(param: TestDataObject): Boolean = {
    asJava.methodWithNonNullableDataObjectParam(param.asJava)
  }

  def methodWithNullableDataObjectParam(expectNull: Boolean, param: scala.Option[TestDataObject]): Unit = {
    asJava.methodWithNullableDataObjectParam(expectNull, (if (param.isDefined) param.get.asJava else null))
  }

  def methodWithNullableDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[TestDataObject]): Unit = {
    asJava.methodWithNullableDataObjectHandler(notNull, funcToMappedHandler[JTestDataObject, TestDataObject](a => TestDataObject(a))(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[TestDataObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TestDataObject]((x => io.vertx.scala.codegen.testmodel.TestDataObject(x.asInstanceOf)))
    asJava.methodWithNullableDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestDataObject]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableDataObjectReturn(notNull: Boolean): scala.Option[TestDataObject] = {
    scala.Option(TestDataObject(asJava.methodWithNullableDataObjectReturn(notNull)))
  }

  def methodWithNonNullableEnumParam(param: io.vertx.codegen.testmodel.TestEnum): Boolean = {
    asJava.methodWithNonNullableEnumParam(param)
  }

  def methodWithNullableEnumParam(expectNull: Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithNullableEnumParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithNullableEnumHandler(notNull, (handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[io.vertx.codegen.testmodel.TestEnum] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.codegen.testmodel.TestEnum]((x => x.asInstanceOf))
    asJava.methodWithNullableEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestEnum]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableEnumReturn(notNull: Boolean): scala.Option[io.vertx.codegen.testmodel.TestEnum] = {
    scala.Option(asJava.methodWithNullableEnumReturn(notNull))
  }

  def methodWithNonNullableGenEnumParam(param: io.vertx.codegen.testmodel.TestGenEnum): Boolean = {
    asJava.methodWithNonNullableGenEnumParam(param)
  }

  def methodWithNullableGenEnumParam(expectNull: Boolean, param: scala.Option[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.methodWithNullableGenEnumParam(expectNull, (if (param.isDefined) param.get else null))
  }

  def methodWithNullableGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.methodWithNullableGenEnumHandler(notNull, (handler).asInstanceOf[io.vertx.core.Handler[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[io.vertx.codegen.testmodel.TestGenEnum] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.codegen.testmodel.TestGenEnum]((x => x.asInstanceOf))
    asJava.methodWithNullableGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.codegen.testmodel.TestGenEnum]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableGenEnumReturn(notNull: Boolean): scala.Option[io.vertx.codegen.testmodel.TestGenEnum] = {
    scala.Option(asJava.methodWithNullableGenEnumReturn(notNull))
  }

  def methodWithNullableTypeVariableParam[T: TypeTag](expectNull: Boolean, param: T): Unit = {
    asJava.methodWithNullableTypeVariableParam(expectNull, toJava[T](param).asInstanceOf[Object])
  }

  def methodWithNullableTypeVariableHandler[T: TypeTag](notNull: Boolean, value: T, handler: io.vertx.core.Handler[T]): Unit = {
    asJava.methodWithNullableTypeVariableHandler(notNull, toJava[T](value).asInstanceOf[Object], (handler).asInstanceOf[io.vertx.core.Handler[Object]])
  }

  def methodWithNullableTypeVariableHandlerAsyncResultFuture[T: TypeTag](notNull: Boolean, value: T): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T]((x => x.asInstanceOf))
    asJava.methodWithNullableTypeVariableHandlerAsyncResult(notNull, toJava[T](value).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableTypeVariableReturn[T: TypeTag](notNull: Boolean, value: T): T = {
    toScala[T](asJava.methodWithNullableTypeVariableReturn(notNull, toJava[T](value).asInstanceOf[Object]))
  }

  def methodWithNullableObjectParam(expectNull: Boolean, param: AnyRef): Unit = {
    asJava.methodWithNullableObjectParam(expectNull, toJava[java.lang.Object](param).asInstanceOf[Object])
  }

  def methodWithNonNullableListByteParam(param: scala.collection.mutable.Buffer[Byte]): Boolean = {
    asJava.methodWithNonNullableListByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithNullableListByteParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.methodWithNullableListByteParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Byte).asJava else null.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithNullableListByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.methodWithNullableListByteHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Byte], scala.collection.mutable.Buffer[Byte]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Byte]]])
  }

  def methodWithNullableListByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte)))
    asJava.methodWithNullableListByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListByteReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Byte]] = {
    scala.Option(asJava.methodWithNullableListByteReturn(notNull)).map(_.asScala.map(x => x:Byte))
  }

  def methodWithNonNullableListShortParam(param: scala.collection.mutable.Buffer[Short]): Boolean = {
    asJava.methodWithNonNullableListShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithNullableListShortParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.methodWithNullableListShortParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Short).asJava else null.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithNullableListShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.methodWithNullableListShortHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Short], scala.collection.mutable.Buffer[Short]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Short]]])
  }

  def methodWithNullableListShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short)))
    asJava.methodWithNullableListShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListShortReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Short]] = {
    scala.Option(asJava.methodWithNullableListShortReturn(notNull)).map(_.asScala.map(x => x:Short))
  }

  def methodWithNonNullableListIntegerParam(param: scala.collection.mutable.Buffer[Int]): Boolean = {
    asJava.methodWithNonNullableListIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithNullableListIntegerParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.methodWithNullableListIntegerParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Integer).asJava else null.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithNullableListIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.methodWithNullableListIntegerHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Integer]]])
  }

  def methodWithNullableListIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int)))
    asJava.methodWithNullableListIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListIntegerReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Int]] = {
    scala.Option(asJava.methodWithNullableListIntegerReturn(notNull)).map(_.asScala.map(x => x:Int))
  }

  def methodWithNonNullableListLongParam(param: scala.collection.mutable.Buffer[Long]): Boolean = {
    asJava.methodWithNonNullableListLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithNullableListLongParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.methodWithNullableListLongParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Long).asJava else null.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithNullableListLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.methodWithNullableListLongHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Long], scala.collection.mutable.Buffer[Long]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Long]]])
  }

  def methodWithNullableListLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long)))
    asJava.methodWithNullableListLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListLongReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Long]] = {
    scala.Option(asJava.methodWithNullableListLongReturn(notNull)).map(_.asScala.map(x => x:Long))
  }

  def methodWithNonNullableListFloatParam(param: scala.collection.mutable.Buffer[Float]): Boolean = {
    asJava.methodWithNonNullableListFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithNullableListFloatParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.methodWithNullableListFloatParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Float).asJava else null.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithNullableListFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.methodWithNullableListFloatHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Float], scala.collection.mutable.Buffer[Float]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Float]]])
  }

  def methodWithNullableListFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float)))
    asJava.methodWithNullableListFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListFloatReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Float]] = {
    scala.Option(asJava.methodWithNullableListFloatReturn(notNull)).map(_.asScala.map(x => x:Float))
  }

  def methodWithNonNullableListDoubleParam(param: scala.collection.mutable.Buffer[Double]): Boolean = {
    asJava.methodWithNonNullableListDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithNullableListDoubleParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.methodWithNullableListDoubleParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Double).asJava else null.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithNullableListDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.methodWithNullableListDoubleHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Double], scala.collection.mutable.Buffer[Double]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Double]]])
  }

  def methodWithNullableListDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double)))
    asJava.methodWithNullableListDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListDoubleReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Double]] = {
    scala.Option(asJava.methodWithNullableListDoubleReturn(notNull)).map(_.asScala.map(x => x:Double))
  }

  def methodWithNonNullableListBooleanParam(param: scala.collection.mutable.Buffer[Boolean]): Boolean = {
    asJava.methodWithNonNullableListBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithNullableListBooleanParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.methodWithNullableListBooleanParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Boolean).asJava else null.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithNullableListBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.methodWithNullableListBooleanHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Boolean], scala.collection.mutable.Buffer[Boolean]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Boolean]]])
  }

  def methodWithNullableListBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean)))
    asJava.methodWithNullableListBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListBooleanReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Boolean]] = {
    scala.Option(asJava.methodWithNullableListBooleanReturn(notNull)).map(_.asScala.map(x => x:Boolean))
  }

  def methodWithNonNullableListStringParam(param: scala.collection.mutable.Buffer[String]): Boolean = {
    asJava.methodWithNonNullableListStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithNullableListStringParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.methodWithNullableListStringParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.String).asJava else null.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithNullableListStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.methodWithNullableListStringHandler(notNull, funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.String]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.String]]])
  }

  def methodWithNullableListStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.methodWithNullableListStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListStringReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[String]] = {
    scala.Option(asJava.methodWithNullableListStringReturn(notNull)).map(_.asScala.map(x => x:String))
  }

  def methodWithNonNullableListCharParam(param: scala.collection.mutable.Buffer[Char]): Boolean = {
    asJava.methodWithNonNullableListCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithNullableListCharParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.methodWithNullableListCharParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Character).asJava else null.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithNullableListCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.methodWithNullableListCharHandler(notNull, funcToMappedHandler[java.util.List[java.lang.Character], scala.collection.mutable.Buffer[Char]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Character]]])
  }

  def methodWithNullableListCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char)))
    asJava.methodWithNullableListCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListCharReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[Char]] = {
    scala.Option(asJava.methodWithNullableListCharReturn(notNull)).map(_.asScala.map(x => x:Char))
  }

  def methodWithNonNullableListJsonObjectParam(param: scala.collection.mutable.Buffer[JsonObject]): Boolean = {
    asJava.methodWithNonNullableListJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableListJsonObjectParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.methodWithNullableListJsonObjectParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonObject).asJava else null.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableListJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.methodWithNullableListJsonObjectHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableListJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.methodWithNullableListJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListJsonObjectReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[JsonObject]] = {
    scala.Option(asJava.methodWithNullableListJsonObjectReturn(notNull)).map(_.asScala.map(x => x:JsonObject))
  }

  def methodWithNonNullableListJsonArrayParam(param: scala.collection.mutable.Buffer[JsonArray]): Boolean = {
    asJava.methodWithNonNullableListJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableListJsonArrayParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.methodWithNullableListJsonArrayParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonArray).asJava else null.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableListJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.methodWithNullableListJsonArrayHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableListJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.methodWithNullableListJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListJsonArrayReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[JsonArray]] = {
    scala.Option(asJava.methodWithNullableListJsonArrayReturn(notNull)).map(_.asScala.map(x => x:JsonArray))
  }

  def methodWithNonNullableListApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]): Boolean = {
    asJava.methodWithNonNullableListApiParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableListApiParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.methodWithNullableListApiParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableListApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.methodWithNullableListApiHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithNullableListApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply)))
    asJava.methodWithNullableListApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListApiReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[RefedInterface1]] = {
    scala.Option(asJava.methodWithNullableListApiReturn(notNull)).map(_.asScala.map(RefedInterface1.apply))
  }

  def methodWithNonNullableListDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]): Boolean = {
    asJava.methodWithNonNullableListDataObjectParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableListDataObjectParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.methodWithNullableListDataObjectParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableListDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.methodWithNullableListDataObjectHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithNullableListDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x))))
    asJava.methodWithNullableListDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListDataObjectReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[TestDataObject]] = {
    scala.Option(asJava.methodWithNullableListDataObjectReturn(notNull)).map(_.asScala.map(x => TestDataObject(x)))
  }

  def methodWithNonNullableListEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Boolean = {
    asJava.methodWithNonNullableListEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableListEnumParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableListEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableListEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableListEnumHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithNullableListEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala))
    asJava.methodWithNullableListEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListEnumReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.methodWithNullableListEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum))
  }

  def methodWithNonNullableListGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]): Boolean = {
    asJava.methodWithNonNullableListGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableListGenEnumParam(expectNull: Boolean, param: scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableListGenEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava else null.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableListGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableListGenEnumHandler(notNull, funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithNullableListGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala))
    asJava.methodWithNullableListGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableListGenEnumReturn(notNull: Boolean): scala.Option[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.methodWithNullableListGenEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum))
  }

  def methodWithNonNullableSetByteParam(param: Set[Byte]): Boolean = {
    asJava.methodWithNonNullableSetByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithNullableSetByteParam(expectNull: Boolean, param: scala.Option[Set[Byte]]): Unit = {
    asJava.methodWithNullableSetByteParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Byte).asJava else null.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithNullableSetByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Byte]]): Unit = {
    asJava.methodWithNullableSetByteHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Byte], Set[Byte]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Byte]]])
  }

  def methodWithNullableSetByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet))
    asJava.methodWithNullableSetByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetByteReturn(notNull: Boolean): scala.Option[Set[Byte]] = {
    scala.Option(asJava.methodWithNullableSetByteReturn(notNull)).map(_.asScala.map(x => x:Byte).toSet)
  }

  def methodWithNonNullableSetShortParam(param: Set[Short]): Boolean = {
    asJava.methodWithNonNullableSetShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithNullableSetShortParam(expectNull: Boolean, param: scala.Option[Set[Short]]): Unit = {
    asJava.methodWithNullableSetShortParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Short).asJava else null.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithNullableSetShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Short]]): Unit = {
    asJava.methodWithNullableSetShortHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Short], Set[Short]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Short]]])
  }

  def methodWithNullableSetShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet))
    asJava.methodWithNullableSetShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetShortReturn(notNull: Boolean): scala.Option[Set[Short]] = {
    scala.Option(asJava.methodWithNullableSetShortReturn(notNull)).map(_.asScala.map(x => x:Short).toSet)
  }

  def methodWithNonNullableSetIntegerParam(param: Set[Int]): Boolean = {
    asJava.methodWithNonNullableSetIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithNullableSetIntegerParam(expectNull: Boolean, param: scala.Option[Set[Int]]): Unit = {
    asJava.methodWithNullableSetIntegerParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Integer).asJava else null.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithNullableSetIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Int]]): Unit = {
    asJava.methodWithNullableSetIntegerHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Integer]]])
  }

  def methodWithNullableSetIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet))
    asJava.methodWithNullableSetIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetIntegerReturn(notNull: Boolean): scala.Option[Set[Int]] = {
    scala.Option(asJava.methodWithNullableSetIntegerReturn(notNull)).map(_.asScala.map(x => x:Int).toSet)
  }

  def methodWithNonNullableSetLongParam(param: Set[Long]): Boolean = {
    asJava.methodWithNonNullableSetLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithNullableSetLongParam(expectNull: Boolean, param: scala.Option[Set[Long]]): Unit = {
    asJava.methodWithNullableSetLongParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Long).asJava else null.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithNullableSetLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Long]]): Unit = {
    asJava.methodWithNullableSetLongHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Long], Set[Long]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Long]]])
  }

  def methodWithNullableSetLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet))
    asJava.methodWithNullableSetLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetLongReturn(notNull: Boolean): scala.Option[Set[Long]] = {
    scala.Option(asJava.methodWithNullableSetLongReturn(notNull)).map(_.asScala.map(x => x:Long).toSet)
  }

  def methodWithNonNullableSetFloatParam(param: Set[Float]): Boolean = {
    asJava.methodWithNonNullableSetFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithNullableSetFloatParam(expectNull: Boolean, param: scala.Option[Set[Float]]): Unit = {
    asJava.methodWithNullableSetFloatParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Float).asJava else null.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithNullableSetFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Float]]): Unit = {
    asJava.methodWithNullableSetFloatHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Float], Set[Float]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Float]]])
  }

  def methodWithNullableSetFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet))
    asJava.methodWithNullableSetFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetFloatReturn(notNull: Boolean): scala.Option[Set[Float]] = {
    scala.Option(asJava.methodWithNullableSetFloatReturn(notNull)).map(_.asScala.map(x => x:Float).toSet)
  }

  def methodWithNonNullableSetDoubleParam(param: Set[Double]): Boolean = {
    asJava.methodWithNonNullableSetDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithNullableSetDoubleParam(expectNull: Boolean, param: scala.Option[Set[Double]]): Unit = {
    asJava.methodWithNullableSetDoubleParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Double).asJava else null.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithNullableSetDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Double]]): Unit = {
    asJava.methodWithNullableSetDoubleHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Double], Set[Double]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Double]]])
  }

  def methodWithNullableSetDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet))
    asJava.methodWithNullableSetDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetDoubleReturn(notNull: Boolean): scala.Option[Set[Double]] = {
    scala.Option(asJava.methodWithNullableSetDoubleReturn(notNull)).map(_.asScala.map(x => x:Double).toSet)
  }

  def methodWithNonNullableSetBooleanParam(param: Set[Boolean]): Boolean = {
    asJava.methodWithNonNullableSetBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithNullableSetBooleanParam(expectNull: Boolean, param: scala.Option[Set[Boolean]]): Unit = {
    asJava.methodWithNullableSetBooleanParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Boolean).asJava else null.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithNullableSetBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Boolean]]): Unit = {
    asJava.methodWithNullableSetBooleanHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Boolean], Set[Boolean]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Boolean]]])
  }

  def methodWithNullableSetBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet))
    asJava.methodWithNullableSetBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetBooleanReturn(notNull: Boolean): scala.Option[Set[Boolean]] = {
    scala.Option(asJava.methodWithNullableSetBooleanReturn(notNull)).map(_.asScala.map(x => x:Boolean).toSet)
  }

  def methodWithNonNullableSetStringParam(param: Set[String]): Boolean = {
    asJava.methodWithNonNullableSetStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithNullableSetStringParam(expectNull: Boolean, param: scala.Option[Set[String]]): Unit = {
    asJava.methodWithNullableSetStringParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.String).asJava else null.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithNullableSetStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[String]]): Unit = {
    asJava.methodWithNullableSetStringHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.String]]])
  }

  def methodWithNullableSetStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[String]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet))
    asJava.methodWithNullableSetStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetStringReturn(notNull: Boolean): scala.Option[Set[String]] = {
    scala.Option(asJava.methodWithNullableSetStringReturn(notNull)).map(_.asScala.map(x => x:String).toSet)
  }

  def methodWithNonNullableSetCharParam(param: Set[Char]): Boolean = {
    asJava.methodWithNonNullableSetCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithNullableSetCharParam(expectNull: Boolean, param: scala.Option[Set[Char]]): Unit = {
    asJava.methodWithNullableSetCharParam(expectNull, if (param.isDefined) param.get.map(x => x:java.lang.Character).asJava else null.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithNullableSetCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[Char]]): Unit = {
    asJava.methodWithNullableSetCharHandler(notNull, funcToMappedHandler[java.util.Set[java.lang.Character], Set[Char]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Character]]])
  }

  def methodWithNullableSetCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet))
    asJava.methodWithNullableSetCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetCharReturn(notNull: Boolean): scala.Option[Set[Char]] = {
    scala.Option(asJava.methodWithNullableSetCharReturn(notNull)).map(_.asScala.map(x => x:Char).toSet)
  }

  def methodWithNonNullableSetJsonObjectParam(param: Set[JsonObject]): Boolean = {
    asJava.methodWithNonNullableSetJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableSetJsonObjectParam(expectNull: Boolean, param: scala.Option[Set[JsonObject]]): Unit = {
    asJava.methodWithNullableSetJsonObjectParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonObject).asJava else null.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableSetJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.methodWithNullableSetJsonObjectHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableSetJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.methodWithNullableSetJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetJsonObjectReturn(notNull: Boolean): scala.Option[Set[JsonObject]] = {
    scala.Option(asJava.methodWithNullableSetJsonObjectReturn(notNull)).map(_.asScala.map(x => x:JsonObject).toSet)
  }

  def methodWithNonNullableSetJsonArrayParam(param: Set[JsonArray]): Boolean = {
    asJava.methodWithNonNullableSetJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableSetJsonArrayParam(expectNull: Boolean, param: scala.Option[Set[JsonArray]]): Unit = {
    asJava.methodWithNullableSetJsonArrayParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.core.json.JsonArray).asJava else null.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableSetJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.methodWithNullableSetJsonArrayHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableSetJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.methodWithNullableSetJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetJsonArrayReturn(notNull: Boolean): scala.Option[Set[JsonArray]] = {
    scala.Option(asJava.methodWithNullableSetJsonArrayReturn(notNull)).map(_.asScala.map(x => x:JsonArray).toSet)
  }

  def methodWithNonNullableSetApiParam(param: Set[RefedInterface1]): Boolean = {
    asJava.methodWithNonNullableSetApiParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableSetApiParam(expectNull: Boolean, param: scala.Option[Set[RefedInterface1]]): Unit = {
    asJava.methodWithNullableSetApiParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableSetApiHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[RefedInterface1]]): Unit = {
    asJava.methodWithNullableSetApiHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithNullableSetApiHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet))
    asJava.methodWithNullableSetApiHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetApiReturn(notNull: Boolean): scala.Option[Set[RefedInterface1]] = {
    scala.Option(asJava.methodWithNullableSetApiReturn(notNull)).map(_.asScala.map(RefedInterface1.apply).toSet)
  }

  def methodWithNonNullableSetDataObjectParam(param: Set[TestDataObject]): Boolean = {
    asJava.methodWithNonNullableSetDataObjectParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableSetDataObjectParam(expectNull: Boolean, param: scala.Option[Set[TestDataObject]]): Unit = {
    asJava.methodWithNullableSetDataObjectParam(expectNull, if (param.isDefined) param.get.map(x => if (x == null) null else x.asJava).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithNullableSetDataObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[TestDataObject]]): Unit = {
    asJava.methodWithNullableSetDataObjectHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithNullableSetDataObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet))
    asJava.methodWithNullableSetDataObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetDataObjectReturn(notNull: Boolean): scala.Option[Set[TestDataObject]] = {
    scala.Option(asJava.methodWithNullableSetDataObjectReturn(notNull)).map(_.asScala.map(x => TestDataObject(x)).toSet)
  }

  def methodWithNonNullableSetEnumParam(param: Set[io.vertx.codegen.testmodel.TestEnum]): Boolean = {
    asJava.methodWithNonNullableSetEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableSetEnumParam(expectNull: Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableSetEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithNullableSetEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithNullableSetEnumHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithNullableSetEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet))
    asJava.methodWithNullableSetEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetEnumReturn(notNull: Boolean): scala.Option[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    scala.Option(asJava.methodWithNullableSetEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet)
  }

  def methodWithNonNullableSetGenEnumParam(param: Set[io.vertx.codegen.testmodel.TestGenEnum]): Boolean = {
    asJava.methodWithNonNullableSetGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableSetGenEnumParam(expectNull: Boolean, param: scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableSetGenEnumParam(expectNull, if (param.isDefined) param.get.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava else null.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithNullableSetGenEnumHandler(notNull: Boolean, handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithNullableSetGenEnumHandler(notNull, funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum], Set[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithNullableSetGenEnumHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet))
    asJava.methodWithNullableSetGenEnumHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableSetGenEnumReturn(notNull: Boolean): scala.Option[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    scala.Option(asJava.methodWithNullableSetGenEnumReturn(notNull)).map(_.asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).toSet)
  }

  def methodWithNonNullableMapByteParam(param: Map[String, Byte]): Boolean = {
    asJava.methodWithNonNullableMapByteParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithNullableMapByteParam(expectNull: Boolean, param: scala.Option[Map[String, Byte]]): Unit = {
    asJava.methodWithNullableMapByteParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithNullableMapByteHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Byte]]): Unit = {
    asJava.methodWithNullableMapByteHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Byte], Map[String, Byte]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Byte]]])
  }

  def methodWithNullableMapByteHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap))
    asJava.methodWithNullableMapByteHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapByteReturn(notNull: Boolean): scala.Option[Map[String, Byte]] = {
    scala.Option(asJava.methodWithNullableMapByteReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Byte)).toMap)
  }

  def methodWithNonNullableMapShortParam(param: Map[String, Short]): Boolean = {
    asJava.methodWithNonNullableMapShortParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithNullableMapShortParam(expectNull: Boolean, param: scala.Option[Map[String, Short]]): Unit = {
    asJava.methodWithNullableMapShortParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithNullableMapShortHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Short]]): Unit = {
    asJava.methodWithNullableMapShortHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Short], Map[String, Short]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Short]]])
  }

  def methodWithNullableMapShortHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap))
    asJava.methodWithNullableMapShortHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapShortReturn(notNull: Boolean): scala.Option[Map[String, Short]] = {
    scala.Option(asJava.methodWithNullableMapShortReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Short)).toMap)
  }

  def methodWithNonNullableMapIntegerParam(param: Map[String, Int]): Boolean = {
    asJava.methodWithNonNullableMapIntegerParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithNullableMapIntegerParam(expectNull: Boolean, param: scala.Option[Map[String, Int]]): Unit = {
    asJava.methodWithNullableMapIntegerParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithNullableMapIntegerHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Int]]): Unit = {
    asJava.methodWithNullableMapIntegerHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Integer], Map[String, Int]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Integer]]])
  }

  def methodWithNullableMapIntegerHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap))
    asJava.methodWithNullableMapIntegerHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapIntegerReturn(notNull: Boolean): scala.Option[Map[String, Int]] = {
    scala.Option(asJava.methodWithNullableMapIntegerReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Int)).toMap)
  }

  def methodWithNonNullableMapLongParam(param: Map[String, Long]): Boolean = {
    asJava.methodWithNonNullableMapLongParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithNullableMapLongParam(expectNull: Boolean, param: scala.Option[Map[String, Long]]): Unit = {
    asJava.methodWithNullableMapLongParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithNullableMapLongHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Long]]): Unit = {
    asJava.methodWithNullableMapLongHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Long], Map[String, Long]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Long]]])
  }

  def methodWithNullableMapLongHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap))
    asJava.methodWithNullableMapLongHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapLongReturn(notNull: Boolean): scala.Option[Map[String, Long]] = {
    scala.Option(asJava.methodWithNullableMapLongReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Long)).toMap)
  }

  def methodWithNonNullableMapFloatParam(param: Map[String, Float]): Boolean = {
    asJava.methodWithNonNullableMapFloatParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithNullableMapFloatParam(expectNull: Boolean, param: scala.Option[Map[String, Float]]): Unit = {
    asJava.methodWithNullableMapFloatParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithNullableMapFloatHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Float]]): Unit = {
    asJava.methodWithNullableMapFloatHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Float], Map[String, Float]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Float]]])
  }

  def methodWithNullableMapFloatHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap))
    asJava.methodWithNullableMapFloatHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapFloatReturn(notNull: Boolean): scala.Option[Map[String, Float]] = {
    scala.Option(asJava.methodWithNullableMapFloatReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Float)).toMap)
  }

  def methodWithNonNullableMapDoubleParam(param: Map[String, Double]): Boolean = {
    asJava.methodWithNonNullableMapDoubleParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithNullableMapDoubleParam(expectNull: Boolean, param: scala.Option[Map[String, Double]]): Unit = {
    asJava.methodWithNullableMapDoubleParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithNullableMapDoubleHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Double]]): Unit = {
    asJava.methodWithNullableMapDoubleHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Double], Map[String, Double]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Double]]])
  }

  def methodWithNullableMapDoubleHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap))
    asJava.methodWithNullableMapDoubleHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapDoubleReturn(notNull: Boolean): scala.Option[Map[String, Double]] = {
    scala.Option(asJava.methodWithNullableMapDoubleReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Double)).toMap)
  }

  def methodWithNonNullableMapBooleanParam(param: Map[String, Boolean]): Boolean = {
    asJava.methodWithNonNullableMapBooleanParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithNullableMapBooleanParam(expectNull: Boolean, param: scala.Option[Map[String, Boolean]]): Unit = {
    asJava.methodWithNullableMapBooleanParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithNullableMapBooleanHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Boolean]]): Unit = {
    asJava.methodWithNullableMapBooleanHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Boolean], Map[String, Boolean]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Boolean]]])
  }

  def methodWithNullableMapBooleanHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap))
    asJava.methodWithNullableMapBooleanHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapBooleanReturn(notNull: Boolean): scala.Option[Map[String, Boolean]] = {
    scala.Option(asJava.methodWithNullableMapBooleanReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Boolean)).toMap)
  }

  def methodWithNonNullableMapStringParam(param: Map[String, String]): Boolean = {
    asJava.methodWithNonNullableMapStringParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithNullableMapStringParam(expectNull: Boolean, param: scala.Option[Map[String, String]]): Unit = {
    asJava.methodWithNullableMapStringParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithNullableMapStringHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, String]]): Unit = {
    asJava.methodWithNullableMapStringHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.String], Map[String, String]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.String]]])
  }

  def methodWithNullableMapStringHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, String]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithNullableMapStringHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapStringReturn(notNull: Boolean): scala.Option[Map[String, String]] = {
    scala.Option(asJava.methodWithNullableMapStringReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapCharParam(param: Map[String, Char]): Boolean = {
    asJava.methodWithNonNullableMapCharParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithNullableMapCharParam(expectNull: Boolean, param: scala.Option[Map[String, Char]]): Unit = {
    asJava.methodWithNullableMapCharParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithNullableMapCharHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, Char]]): Unit = {
    asJava.methodWithNullableMapCharHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Character], Map[String, Char]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Character]]])
  }

  def methodWithNullableMapCharHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap))
    asJava.methodWithNullableMapCharHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapCharReturn(notNull: Boolean): scala.Option[Map[String, Char]] = {
    scala.Option(asJava.methodWithNullableMapCharReturn(notNull)).map(_.asScala.map(kv => (kv._1, kv._2: Char)).toMap)
  }

  def methodWithNonNullableMapJsonObjectParam(param: Map[String, JsonObject]): Boolean = {
    asJava.methodWithNonNullableMapJsonObjectParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableMapJsonObjectParam(expectNull: Boolean, param: scala.Option[Map[String, JsonObject]]): Unit = {
    asJava.methodWithNullableMapJsonObjectParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithNullableMapJsonObjectHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, JsonObject]]): Unit = {
    asJava.methodWithNullableMapJsonObjectHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject], Map[String, JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]])
  }

  def methodWithNullableMapJsonObjectHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithNullableMapJsonObjectHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapJsonObjectReturn(notNull: Boolean): scala.Option[Map[String, JsonObject]] = {
    scala.Option(asJava.methodWithNullableMapJsonObjectReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapJsonArrayParam(param: Map[String, JsonArray]): Boolean = {
    asJava.methodWithNonNullableMapJsonArrayParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableMapJsonArrayParam(expectNull: Boolean, param: scala.Option[Map[String, JsonArray]]): Unit = {
    asJava.methodWithNullableMapJsonArrayParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithNullableMapJsonArrayHandler(notNull: Boolean, handler: io.vertx.core.Handler[Map[String, JsonArray]]): Unit = {
    asJava.methodWithNullableMapJsonArrayHandler(notNull, funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray], Map[String, JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]])
  }

  def methodWithNullableMapJsonArrayHandlerAsyncResultFuture(notNull: Boolean): concurrent.Future[Map[String, JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithNullableMapJsonArrayHandlerAsyncResult(notNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithNullableMapJsonArrayReturn(notNull: Boolean): scala.Option[Map[String, JsonArray]] = {
    scala.Option(asJava.methodWithNullableMapJsonArrayReturn(notNull)).map(_.asScala.toMap)
  }

  def methodWithNonNullableMapApiParam(param: Map[String, RefedInterface1]): Boolean = {
    asJava.methodWithNonNullableMapApiParam(param.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableMapApiParam(expectNull: Boolean, param: scala.Option[Map[String, RefedInterface1]]): Unit = {
    asJava.methodWithNullableMapApiParam(expectNull, if (param.isDefined) param.get.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava else null.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithListNullableByteParam(param: scala.collection.mutable.Buffer[Byte]): Unit = {
    asJava.methodWithListNullableByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.List[java.lang.Byte]])
  }

  def methodWithListNullableByteHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Byte]]): Unit = {
    asJava.methodWithListNullableByteHandler(funcToMappedHandler[java.util.List[java.lang.Byte], scala.collection.mutable.Buffer[Byte]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Byte]]])
  }

  def methodWithListNullableByteHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Byte]].asScala.map(x => x:Byte)))
    asJava.methodWithListNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableByteReturn(): scala.collection.mutable.Buffer[Byte] = {
    asJava.methodWithListNullableByteReturn().asScala.map(x => x:Byte)
  }

  def methodWithListNullableShortParam(param: scala.collection.mutable.Buffer[Short]): Unit = {
    asJava.methodWithListNullableShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.List[java.lang.Short]])
  }

  def methodWithListNullableShortHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Short]]): Unit = {
    asJava.methodWithListNullableShortHandler(funcToMappedHandler[java.util.List[java.lang.Short], scala.collection.mutable.Buffer[Short]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Short]]])
  }

  def methodWithListNullableShortHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Short]].asScala.map(x => x:Short)))
    asJava.methodWithListNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableShortReturn(): scala.collection.mutable.Buffer[Short] = {
    asJava.methodWithListNullableShortReturn().asScala.map(x => x:Short)
  }

  def methodWithListNullableIntegerParam(param: scala.collection.mutable.Buffer[Int]): Unit = {
    asJava.methodWithListNullableIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.List[java.lang.Integer]])
  }

  def methodWithListNullableIntegerHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Int]]): Unit = {
    asJava.methodWithListNullableIntegerHandler(funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Integer]]])
  }

  def methodWithListNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int)))
    asJava.methodWithListNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableIntegerReturn(): scala.collection.mutable.Buffer[Int] = {
    asJava.methodWithListNullableIntegerReturn().asScala.map(x => x:Int)
  }

  def methodWithListNullableLongParam(param: scala.collection.mutable.Buffer[Long]): Unit = {
    asJava.methodWithListNullableLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.List[java.lang.Long]])
  }

  def methodWithListNullableLongHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Long]]): Unit = {
    asJava.methodWithListNullableLongHandler(funcToMappedHandler[java.util.List[java.lang.Long], scala.collection.mutable.Buffer[Long]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Long]]])
  }

  def methodWithListNullableLongHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Long]].asScala.map(x => x:Long)))
    asJava.methodWithListNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableLongReturn(): scala.collection.mutable.Buffer[Long] = {
    asJava.methodWithListNullableLongReturn().asScala.map(x => x:Long)
  }

  def methodWithListNullableBooleanParam(param: scala.collection.mutable.Buffer[Boolean]): Unit = {
    asJava.methodWithListNullableBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.List[java.lang.Boolean]])
  }

  def methodWithListNullableBooleanHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Boolean]]): Unit = {
    asJava.methodWithListNullableBooleanHandler(funcToMappedHandler[java.util.List[java.lang.Boolean], scala.collection.mutable.Buffer[Boolean]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Boolean]]])
  }

  def methodWithListNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Boolean]].asScala.map(x => x:Boolean)))
    asJava.methodWithListNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableBooleanReturn(): scala.collection.mutable.Buffer[Boolean] = {
    asJava.methodWithListNullableBooleanReturn().asScala.map(x => x:Boolean)
  }

  def methodWithListNullableFloatParam(param: scala.collection.mutable.Buffer[Float]): Unit = {
    asJava.methodWithListNullableFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.List[java.lang.Float]])
  }

  def methodWithListNullableFloatHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Float]]): Unit = {
    asJava.methodWithListNullableFloatHandler(funcToMappedHandler[java.util.List[java.lang.Float], scala.collection.mutable.Buffer[Float]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Float]]])
  }

  def methodWithListNullableFloatHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Float]].asScala.map(x => x:Float)))
    asJava.methodWithListNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableFloatReturn(): scala.collection.mutable.Buffer[Float] = {
    asJava.methodWithListNullableFloatReturn().asScala.map(x => x:Float)
  }

  def methodWithListNullableDoubleParam(param: scala.collection.mutable.Buffer[Double]): Unit = {
    asJava.methodWithListNullableDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.List[java.lang.Double]])
  }

  def methodWithListNullableDoubleHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Double]]): Unit = {
    asJava.methodWithListNullableDoubleHandler(funcToMappedHandler[java.util.List[java.lang.Double], scala.collection.mutable.Buffer[Double]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Double]]])
  }

  def methodWithListNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Double]].asScala.map(x => x:Double)))
    asJava.methodWithListNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableDoubleReturn(): scala.collection.mutable.Buffer[Double] = {
    asJava.methodWithListNullableDoubleReturn().asScala.map(x => x:Double)
  }

  def methodWithListNullableStringParam(param: scala.collection.mutable.Buffer[String]): Unit = {
    asJava.methodWithListNullableStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.List[java.lang.String]])
  }

  def methodWithListNullableStringHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[String]]): Unit = {
    asJava.methodWithListNullableStringHandler(funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.String]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.String]]])
  }

  def methodWithListNullableStringHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.methodWithListNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableStringReturn(): scala.collection.mutable.Buffer[String] = {
    asJava.methodWithListNullableStringReturn().asScala.map(x => x:String)
  }

  def methodWithListNullableCharParam(param: scala.collection.mutable.Buffer[Char]): Unit = {
    asJava.methodWithListNullableCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.List[java.lang.Character]])
  }

  def methodWithListNullableCharHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Char]]): Unit = {
    asJava.methodWithListNullableCharHandler(funcToMappedHandler[java.util.List[java.lang.Character], scala.collection.mutable.Buffer[Char]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Character]]])
  }

  def methodWithListNullableCharHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Character]].asScala.map(x => x:Char)))
    asJava.methodWithListNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableCharReturn(): scala.collection.mutable.Buffer[Char] = {
    asJava.methodWithListNullableCharReturn().asScala.map(x => x:Char)
  }

  def methodWithListNullableJsonObjectParam(param: scala.collection.mutable.Buffer[JsonObject]): Unit = {
    asJava.methodWithListNullableJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]])
  }

  def methodWithListNullableJsonObjectHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.methodWithListNullableJsonObjectHandler(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithListNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.methodWithListNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    asJava.methodWithListNullableJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListNullableJsonArrayParam(param: scala.collection.mutable.Buffer[JsonArray]): Unit = {
    asJava.methodWithListNullableJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]])
  }

  def methodWithListNullableJsonArrayHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.methodWithListNullableJsonArrayHandler(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithListNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.methodWithListNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    asJava.methodWithListNullableJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListNullableApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]): Unit = {
    asJava.methodWithListNullableApiParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithListNullableApiHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.methodWithListNullableApiHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithListNullableApiHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply)))
    asJava.methodWithListNullableApiHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableApiReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.methodWithListNullableApiReturn().asScala.map(RefedInterface1.apply)
  }

  def methodWithListNullableDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]): Unit = {
    asJava.methodWithListNullableDataObjectParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithListNullableDataObjectHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.methodWithListNullableDataObjectHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)) else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithListNullableDataObjectHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x))))
    asJava.methodWithListNullableDataObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableDataObjectReturn(): scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.methodWithListNullableDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListNullableEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithListNullableEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithListNullableEnumHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithListNullableEnumHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithListNullableEnumHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala))
    asJava.methodWithListNullableEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.methodWithListNullableEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum)
  }

  def methodWithListNullableGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.methodWithListNullableGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithListNullableGenEnumHandler(handler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithListNullableGenEnumHandler(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithListNullableGenEnumHandlerAsyncResultFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]].asScala))
    asJava.methodWithListNullableGenEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithListNullableGenEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.methodWithListNullableGenEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum)
  }

  def methodWithSetNullableByteParam(param: Set[Byte]): Unit = {
    asJava.methodWithSetNullableByteParam(param.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.Set[java.lang.Byte]])
  }

  def methodWithSetNullableByteHandler(handler: io.vertx.core.Handler[Set[Byte]]): Unit = {
    asJava.methodWithSetNullableByteHandler(funcToMappedHandler[java.util.Set[java.lang.Byte], Set[Byte]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Byte]]])
  }

  def methodWithSetNullableByteHandlerAsyncResultFuture(): concurrent.Future[Set[Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Byte]].asScala.map(x => x:Byte).toSet))
    asJava.methodWithSetNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableByteReturn(): Set[Byte] = {
    asJava.methodWithSetNullableByteReturn().asScala.map(x => x:Byte).toSet
  }

  def methodWithSetNullableShortParam(param: Set[Short]): Unit = {
    asJava.methodWithSetNullableShortParam(param.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.Set[java.lang.Short]])
  }

  def methodWithSetNullableShortHandler(handler: io.vertx.core.Handler[Set[Short]]): Unit = {
    asJava.methodWithSetNullableShortHandler(funcToMappedHandler[java.util.Set[java.lang.Short], Set[Short]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Short]]])
  }

  def methodWithSetNullableShortHandlerAsyncResultFuture(): concurrent.Future[Set[Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Short]].asScala.map(x => x:Short).toSet))
    asJava.methodWithSetNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableShortReturn(): Set[Short] = {
    asJava.methodWithSetNullableShortReturn().asScala.map(x => x:Short).toSet
  }

  def methodWithSetNullableIntegerParam(param: Set[Int]): Unit = {
    asJava.methodWithSetNullableIntegerParam(param.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.Set[java.lang.Integer]])
  }

  def methodWithSetNullableIntegerHandler(handler: io.vertx.core.Handler[Set[Int]]): Unit = {
    asJava.methodWithSetNullableIntegerHandler(funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Integer]]])
  }

  def methodWithSetNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet))
    asJava.methodWithSetNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableIntegerReturn(): Set[Int] = {
    asJava.methodWithSetNullableIntegerReturn().asScala.map(x => x:Int).toSet
  }

  def methodWithSetNullableLongParam(param: Set[Long]): Unit = {
    asJava.methodWithSetNullableLongParam(param.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.Set[java.lang.Long]])
  }

  def methodWithSetNullableLongHandler(handler: io.vertx.core.Handler[Set[Long]]): Unit = {
    asJava.methodWithSetNullableLongHandler(funcToMappedHandler[java.util.Set[java.lang.Long], Set[Long]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Long]]])
  }

  def methodWithSetNullableLongHandlerAsyncResultFuture(): concurrent.Future[Set[Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Long]].asScala.map(x => x:Long).toSet))
    asJava.methodWithSetNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableLongReturn(): Set[Long] = {
    asJava.methodWithSetNullableLongReturn().asScala.map(x => x:Long).toSet
  }

  def methodWithSetNullableBooleanParam(param: Set[Boolean]): Unit = {
    asJava.methodWithSetNullableBooleanParam(param.map(x => x:java.lang.Boolean).asJava.asInstanceOf[java.util.Set[java.lang.Boolean]])
  }

  def methodWithSetNullableBooleanHandler(handler: io.vertx.core.Handler[Set[Boolean]]): Unit = {
    asJava.methodWithSetNullableBooleanHandler(funcToMappedHandler[java.util.Set[java.lang.Boolean], Set[Boolean]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Boolean]]])
  }

  def methodWithSetNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[Set[Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Boolean]].asScala.map(x => x:Boolean).toSet))
    asJava.methodWithSetNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableBooleanReturn(): Set[Boolean] = {
    asJava.methodWithSetNullableBooleanReturn().asScala.map(x => x:Boolean).toSet
  }

  def methodWithSetNullableFloatParam(param: Set[Float]): Unit = {
    asJava.methodWithSetNullableFloatParam(param.map(x => x:java.lang.Float).asJava.asInstanceOf[java.util.Set[java.lang.Float]])
  }

  def methodWithSetNullableFloatHandler(handler: io.vertx.core.Handler[Set[Float]]): Unit = {
    asJava.methodWithSetNullableFloatHandler(funcToMappedHandler[java.util.Set[java.lang.Float], Set[Float]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Float]]])
  }

  def methodWithSetNullableFloatHandlerAsyncResultFuture(): concurrent.Future[Set[Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Float]].asScala.map(x => x:Float).toSet))
    asJava.methodWithSetNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableFloatReturn(): Set[Float] = {
    asJava.methodWithSetNullableFloatReturn().asScala.map(x => x:Float).toSet
  }

  def methodWithSetNullableDoubleParam(param: Set[Double]): Unit = {
    asJava.methodWithSetNullableDoubleParam(param.map(x => x:java.lang.Double).asJava.asInstanceOf[java.util.Set[java.lang.Double]])
  }

  def methodWithSetNullableDoubleHandler(handler: io.vertx.core.Handler[Set[Double]]): Unit = {
    asJava.methodWithSetNullableDoubleHandler(funcToMappedHandler[java.util.Set[java.lang.Double], Set[Double]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Double]]])
  }

  def methodWithSetNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[Set[Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Double]].asScala.map(x => x:Double).toSet))
    asJava.methodWithSetNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableDoubleReturn(): Set[Double] = {
    asJava.methodWithSetNullableDoubleReturn().asScala.map(x => x:Double).toSet
  }

  def methodWithSetNullableStringParam(param: Set[String]): Unit = {
    asJava.methodWithSetNullableStringParam(param.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.Set[java.lang.String]])
  }

  def methodWithSetNullableStringHandler(handler: io.vertx.core.Handler[Set[String]]): Unit = {
    asJava.methodWithSetNullableStringHandler(funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.String]]])
  }

  def methodWithSetNullableStringHandlerAsyncResultFuture(): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[String]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet))
    asJava.methodWithSetNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableStringReturn(): Set[String] = {
    asJava.methodWithSetNullableStringReturn().asScala.map(x => x:String).toSet
  }

  def methodWithSetNullableCharParam(param: Set[Char]): Unit = {
    asJava.methodWithSetNullableCharParam(param.map(x => x:java.lang.Character).asJava.asInstanceOf[java.util.Set[java.lang.Character]])
  }

  def methodWithSetNullableCharHandler(handler: io.vertx.core.Handler[Set[Char]]): Unit = {
    asJava.methodWithSetNullableCharHandler(funcToMappedHandler[java.util.Set[java.lang.Character], Set[Char]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Character]]])
  }

  def methodWithSetNullableCharHandlerAsyncResultFuture(): concurrent.Future[Set[Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Character]].asScala.map(x => x:Char).toSet))
    asJava.methodWithSetNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableCharReturn(): Set[Char] = {
    asJava.methodWithSetNullableCharReturn().asScala.map(x => x:Char).toSet
  }

  def methodWithSetNullableJsonObjectParam(param: Set[JsonObject]): Unit = {
    asJava.methodWithSetNullableJsonObjectParam(param.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]])
  }

  def methodWithSetNullableJsonObjectHandler(handler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.methodWithSetNullableJsonObjectHandler(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithSetNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.methodWithSetNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableJsonObjectReturn(): Set[JsonObject] = {
    asJava.methodWithSetNullableJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetNullableJsonArrayParam(param: Set[JsonArray]): Unit = {
    asJava.methodWithSetNullableJsonArrayParam(param.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]])
  }

  def methodWithSetNullableJsonArrayHandler(handler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.methodWithSetNullableJsonArrayHandler(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithSetNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.methodWithSetNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableJsonArrayReturn(): Set[JsonArray] = {
    asJava.methodWithSetNullableJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetNullableApiParam(param: Set[RefedInterface1]): Unit = {
    asJava.methodWithSetNullableApiParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithSetNullableApiHandler(handler: io.vertx.core.Handler[Set[RefedInterface1]]): Unit = {
    asJava.methodWithSetNullableApiHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithSetNullableApiHandlerAsyncResultFuture(): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet))
    asJava.methodWithSetNullableApiHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableApiReturn(): Set[RefedInterface1] = {
    asJava.methodWithSetNullableApiReturn().asScala.map(RefedInterface1.apply).toSet
  }

  def methodWithSetNullableDataObjectParam(param: Set[TestDataObject]): Unit = {
    asJava.methodWithSetNullableDataObjectParam(param.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]])
  }

  def methodWithSetNullableDataObjectHandler(handler: io.vertx.core.Handler[Set[TestDataObject]]): Unit = {
    asJava.methodWithSetNullableDataObjectHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithSetNullableDataObjectHandlerAsyncResultFuture(): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet))
    asJava.methodWithSetNullableDataObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableDataObjectReturn(): Set[TestDataObject] = {
    asJava.methodWithSetNullableDataObjectReturn().asScala.map(x => TestDataObject(x)).toSet
  }

  def methodWithSetNullableEnumParam(param: Set[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.methodWithSetNullableEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithSetNullableEnumHandler(handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.methodWithSetNullableEnumHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithSetNullableEnumHandlerAsyncResultFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet))
    asJava.methodWithSetNullableEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableEnumReturn(): Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.methodWithSetNullableEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet
  }

  def methodWithSetNullableGenEnumParam(param: Set[io.vertx.codegen.testmodel.TestGenEnum]): Unit = {
    asJava.methodWithSetNullableGenEnumParam(param.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]])
  }

  def methodWithSetNullableGenEnumHandler(handler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestGenEnum]]): Unit = {
    asJava.methodWithSetNullableGenEnumHandler(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum], Set[io.vertx.codegen.testmodel.TestGenEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]])
  }

  def methodWithSetNullableGenEnumHandlerAsyncResultFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestGenEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestGenEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]].asScala.toSet))
    asJava.methodWithSetNullableGenEnumHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestGenEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithSetNullableGenEnumReturn(): Set[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.methodWithSetNullableGenEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestGenEnum).toSet
  }

  def methodWithMapNullableByteParam(param: Map[String, Byte]): Unit = {
    asJava.methodWithMapNullableByteParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]])
  }

  def methodWithMapNullableByteHandler(handler: io.vertx.core.Handler[Map[String, Byte]]): Unit = {
    asJava.methodWithMapNullableByteHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Byte], Map[String, Byte]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Byte]]])
  }

  def methodWithMapNullableByteHandlerAsyncResultFuture(): concurrent.Future[Map[String, Byte]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Byte]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]].asScala.map((a) => (a._1,a._2:Byte)).toMap))
    asJava.methodWithMapNullableByteHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Byte]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableByteReturn(): Map[String, Byte] = {
    asJava.methodWithMapNullableByteReturn().asScala.map(kv => (kv._1, kv._2: Byte)).toMap
  }

  def methodWithMapNullableShortParam(param: Map[String, Short]): Unit = {
    asJava.methodWithMapNullableShortParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]])
  }

  def methodWithMapNullableShortHandler(handler: io.vertx.core.Handler[Map[String, Short]]): Unit = {
    asJava.methodWithMapNullableShortHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Short], Map[String, Short]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Short]]])
  }

  def methodWithMapNullableShortHandlerAsyncResultFuture(): concurrent.Future[Map[String, Short]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Short]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]].asScala.map((a) => (a._1,a._2:Short)).toMap))
    asJava.methodWithMapNullableShortHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Short]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableShortReturn(): Map[String, Short] = {
    asJava.methodWithMapNullableShortReturn().asScala.map(kv => (kv._1, kv._2: Short)).toMap
  }

  def methodWithMapNullableIntegerParam(param: Map[String, Int]): Unit = {
    asJava.methodWithMapNullableIntegerParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]])
  }

  def methodWithMapNullableIntegerHandler(handler: io.vertx.core.Handler[Map[String, Int]]): Unit = {
    asJava.methodWithMapNullableIntegerHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Integer], Map[String, Int]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Integer]]])
  }

  def methodWithMapNullableIntegerHandlerAsyncResultFuture(): concurrent.Future[Map[String, Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]].asScala.map((a) => (a._1,a._2:Int)).toMap))
    asJava.methodWithMapNullableIntegerHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableIntegerReturn(): Map[String, Int] = {
    asJava.methodWithMapNullableIntegerReturn().asScala.map(kv => (kv._1, kv._2: Int)).toMap
  }

  def methodWithMapNullableLongParam(param: Map[String, Long]): Unit = {
    asJava.methodWithMapNullableLongParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]])
  }

  def methodWithMapNullableLongHandler(handler: io.vertx.core.Handler[Map[String, Long]]): Unit = {
    asJava.methodWithMapNullableLongHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Long], Map[String, Long]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Long]]])
  }

  def methodWithMapNullableLongHandlerAsyncResultFuture(): concurrent.Future[Map[String, Long]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Long]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]].asScala.map((a) => (a._1,a._2:Long)).toMap))
    asJava.methodWithMapNullableLongHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Long]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableLongReturn(): Map[String, Long] = {
    asJava.methodWithMapNullableLongReturn().asScala.map(kv => (kv._1, kv._2: Long)).toMap
  }

  def methodWithMapNullableBooleanParam(param: Map[String, Boolean]): Unit = {
    asJava.methodWithMapNullableBooleanParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Boolean)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]])
  }

  def methodWithMapNullableBooleanHandler(handler: io.vertx.core.Handler[Map[String, Boolean]]): Unit = {
    asJava.methodWithMapNullableBooleanHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Boolean], Map[String, Boolean]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Boolean]]])
  }

  def methodWithMapNullableBooleanHandlerAsyncResultFuture(): concurrent.Future[Map[String, Boolean]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Boolean]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Boolean]].asScala.map((a) => (a._1,a._2:Boolean)).toMap))
    asJava.methodWithMapNullableBooleanHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Boolean]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableBooleanReturn(): Map[String, Boolean] = {
    asJava.methodWithMapNullableBooleanReturn().asScala.map(kv => (kv._1, kv._2: Boolean)).toMap
  }

  def methodWithMapNullableFloatParam(param: Map[String, Float]): Unit = {
    asJava.methodWithMapNullableFloatParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Float)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]])
  }

  def methodWithMapNullableFloatHandler(handler: io.vertx.core.Handler[Map[String, Float]]): Unit = {
    asJava.methodWithMapNullableFloatHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Float], Map[String, Float]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Float]]])
  }

  def methodWithMapNullableFloatHandlerAsyncResultFuture(): concurrent.Future[Map[String, Float]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Float]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Float]].asScala.map((a) => (a._1,a._2:Float)).toMap))
    asJava.methodWithMapNullableFloatHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Float]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableFloatReturn(): Map[String, Float] = {
    asJava.methodWithMapNullableFloatReturn().asScala.map(kv => (kv._1, kv._2: Float)).toMap
  }

  def methodWithMapNullableDoubleParam(param: Map[String, Double]): Unit = {
    asJava.methodWithMapNullableDoubleParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Double)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]])
  }

  def methodWithMapNullableDoubleHandler(handler: io.vertx.core.Handler[Map[String, Double]]): Unit = {
    asJava.methodWithMapNullableDoubleHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Double], Map[String, Double]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Double]]])
  }

  def methodWithMapNullableDoubleHandlerAsyncResultFuture(): concurrent.Future[Map[String, Double]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Double]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Double]].asScala.map((a) => (a._1,a._2:Double)).toMap))
    asJava.methodWithMapNullableDoubleHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Double]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableDoubleReturn(): Map[String, Double] = {
    asJava.methodWithMapNullableDoubleReturn().asScala.map(kv => (kv._1, kv._2: Double)).toMap
  }

  def methodWithMapNullableStringParam(param: Map[String, String]): Unit = {
    asJava.methodWithMapNullableStringParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]])
  }

  def methodWithMapNullableStringHandler(handler: io.vertx.core.Handler[Map[String, String]]): Unit = {
    asJava.methodWithMapNullableStringHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.String], Map[String, String]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.String]]])
  }

  def methodWithMapNullableStringHandlerAsyncResultFuture(): concurrent.Future[Map[String, String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, String]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithMapNullableStringHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableStringReturn(): Map[String, String] = {
    asJava.methodWithMapNullableStringReturn().asScala.toMap
  }

  def methodWithMapNullableCharParam(param: Map[String, Char]): Unit = {
    asJava.methodWithMapNullableCharParam(param.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Character)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]])
  }

  def methodWithMapNullableCharHandler(handler: io.vertx.core.Handler[Map[String, Char]]): Unit = {
    asJava.methodWithMapNullableCharHandler(funcToMappedHandler[java.util.Map[java.lang.String,java.lang.Character], Map[String, Char]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,java.lang.Character]]])
  }

  def methodWithMapNullableCharHandlerAsyncResultFuture(): concurrent.Future[Map[String, Char]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, Char]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,java.lang.Character]].asScala.map((a) => (a._1,a._2:Char)).toMap))
    asJava.methodWithMapNullableCharHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,java.lang.Character]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableCharReturn(): Map[String, Char] = {
    asJava.methodWithMapNullableCharReturn().asScala.map(kv => (kv._1, kv._2: Char)).toMap
  }

  def methodWithMapNullableJsonObjectParam(param: Map[String, JsonObject]): Unit = {
    asJava.methodWithMapNullableJsonObjectParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]])
  }

  def methodWithMapNullableJsonObjectHandler(handler: io.vertx.core.Handler[Map[String, JsonObject]]): Unit = {
    asJava.methodWithMapNullableJsonObjectHandler(funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject], Map[String, JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]])
  }

  def methodWithMapNullableJsonObjectHandlerAsyncResultFuture(): concurrent.Future[Map[String, JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithMapNullableJsonObjectHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableJsonObjectReturn(): Map[String, JsonObject] = {
    asJava.methodWithMapNullableJsonObjectReturn().asScala.toMap
  }

  def methodWithMapNullableJsonArrayParam(param: Map[String, JsonArray]): Unit = {
    asJava.methodWithMapNullableJsonArrayParam(param.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]])
  }

  def methodWithMapNullableJsonArrayHandler(handler: io.vertx.core.Handler[Map[String, JsonArray]]): Unit = {
    asJava.methodWithMapNullableJsonArrayHandler(funcToMappedHandler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray], Map[String, JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap else null)(handler).asInstanceOf[io.vertx.core.Handler[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]])
  }

  def methodWithMapNullableJsonArrayHandlerAsyncResultFuture(): concurrent.Future[Map[String, JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Map[String, JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]].asScala.map((a) => (a._1,a._2)).toMap))
    asJava.methodWithMapNullableJsonArrayHandlerAsyncResult(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapNullableJsonArrayReturn(): Map[String, JsonArray] = {
    asJava.methodWithMapNullableJsonArrayReturn().asScala.toMap
  }

  def methodWithMapNullableApiParam(param: Map[String, RefedInterface1]): Unit = {
    asJava.methodWithMapNullableApiParam(param.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithNullableHandler(expectNull: Boolean, handler: io.vertx.core.Handler[String]): Unit = {
    asJava.methodWithNullableHandler(expectNull, funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]])
  }

  def methodWithNullableHandlerAsyncResultFuture(expectNull: Boolean): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[String]((x => x.asInstanceOf))
    asJava.methodWithNullableHandlerAsyncResult(expectNull, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.String]]])
    promiseAndHandler._2.future
  }

}

object NullableTCK {

  def apply(_asJava: JNullableTCK): NullableTCK =
    new NullableTCK(_asJava)

}
