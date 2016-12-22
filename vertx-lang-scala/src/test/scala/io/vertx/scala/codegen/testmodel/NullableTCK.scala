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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{NullableTCK => JNullableTCK}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.TestGenEnum

/**
  * The TCK for @Nullable.
  */
class NullableTCK(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def methodWithNonNullableByteParam(param: Byte):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableByteParam(param)
  }

  def methodWithNullableByteParam(expectNull: Boolean,param: Byte):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteParam(expectNull,param)
  }

  def methodWithNullableByteHandler(notNull: Boolean,handler: Handler[Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteHandler(notNull,{x: java.lang.Byte => handler.handle(x)})
  }

  def methodWithNullableByteHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Byte] => handler.handle(AsyncResultWrapper[java.lang.Byte,Byte](x, a => a))})
  }

  def methodWithNullableByteReturn(notNull: Boolean):Byte = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableByteReturn(notNull)
  }

  def methodWithNonNullableShortParam(param: Short):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableShortParam(param)
  }

  def methodWithNullableShortParam(expectNull: Boolean,param: Short):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortParam(expectNull,param)
  }

  def methodWithNullableShortHandler(notNull: Boolean,handler: Handler[Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortHandler(notNull,{x: java.lang.Short => handler.handle(x)})
  }

  def methodWithNullableShortHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Short] => handler.handle(AsyncResultWrapper[java.lang.Short,Short](x, a => a))})
  }

  def methodWithNullableShortReturn(notNull: Boolean):Short = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableShortReturn(notNull)
  }

  def methodWithNonNullableIntegerParam(param: Int):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableIntegerParam(param)
  }

  def methodWithNullableIntegerParam(expectNull: Boolean,param: Int):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerParam(expectNull,param)
  }

  def methodWithNullableIntegerHandler(notNull: Boolean,handler: Handler[Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerHandler(notNull,{x: java.lang.Integer => handler.handle(x)})
  }

  def methodWithNullableIntegerHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Integer] => handler.handle(AsyncResultWrapper[java.lang.Integer,Int](x, a => a))})
  }

  def methodWithNullableIntegerReturn(notNull: Boolean):Int = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableIntegerReturn(notNull)
  }

  def methodWithNonNullableLongParam(param: Long):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableLongParam(param)
  }

  def methodWithNullableLongParam(expectNull: Boolean,param: Long):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongParam(expectNull,param)
  }

  def methodWithNullableLongHandler(notNull: Boolean,handler: Handler[Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongHandler(notNull,{x: java.lang.Long => handler.handle(x)})
  }

  def methodWithNullableLongHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Long] => handler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a))})
  }

  def methodWithNullableLongReturn(notNull: Boolean):Long = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableLongReturn(notNull)
  }

  def methodWithNonNullableFloatParam(param: Float):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableFloatParam(param)
  }

  def methodWithNullableFloatParam(expectNull: Boolean,param: Float):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatParam(expectNull,param)
  }

  def methodWithNullableFloatHandler(notNull: Boolean,handler: Handler[Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatHandler(notNull,{x: java.lang.Float => handler.handle(x)})
  }

  def methodWithNullableFloatHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Float] => handler.handle(AsyncResultWrapper[java.lang.Float,Float](x, a => a))})
  }

  def methodWithNullableFloatReturn(notNull: Boolean):Float = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableFloatReturn(notNull)
  }

  def methodWithNonNullableDoubleParam(param: Double):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableDoubleParam(param)
  }

  def methodWithNullableDoubleParam(expectNull: Boolean,param: Double):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleParam(expectNull,param)
  }

  def methodWithNullableDoubleHandler(notNull: Boolean,handler: Handler[Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleHandler(notNull,{x: java.lang.Double => handler.handle(x)})
  }

  def methodWithNullableDoubleHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Double] => handler.handle(AsyncResultWrapper[java.lang.Double,Double](x, a => a))})
  }

  def methodWithNullableDoubleReturn(notNull: Boolean):Double = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDoubleReturn(notNull)
  }

  def methodWithNonNullableBooleanParam(param: Boolean):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableBooleanParam(param)
  }

  def methodWithNullableBooleanParam(expectNull: Boolean,param: Boolean):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanParam(expectNull,param)
  }

  def methodWithNullableBooleanHandler(notNull: Boolean,handler: Handler[Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanHandler(notNull,{x: java.lang.Boolean => handler.handle(x)})
  }

  def methodWithNullableBooleanHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Boolean] => handler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a))})
  }

  def methodWithNullableBooleanReturn(notNull: Boolean):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableBooleanReturn(notNull)
  }

  def methodWithNonNullableStringParam(param: String):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableStringParam(param)
  }

  def methodWithNullableStringParam(expectNull: Boolean,param: String):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringParam(expectNull,param)
  }

  def methodWithNullableStringHandler(notNull: Boolean,handler: Handler[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringHandler(notNull,{x: java.lang.String => handler.handle(x)})
  }

  def methodWithNullableStringHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
  }

  def methodWithNullableStringReturn(notNull: Boolean):String = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableStringReturn(notNull)
  }

  def methodWithNonNullableCharParam(param: Char):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableCharParam(param)
  }

  def methodWithNullableCharParam(expectNull: Boolean,param: Char):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharParam(expectNull,param)
  }

  def methodWithNullableCharHandler(notNull: Boolean,handler: Handler[Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharHandler(notNull,{x: java.lang.Character => handler.handle(x)})
  }

  def methodWithNullableCharHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharHandlerAsyncResult(notNull,{x: AsyncResult[java.lang.Character] => handler.handle(AsyncResultWrapper[java.lang.Character,Char](x, a => a))})
  }

  def methodWithNullableCharReturn(notNull: Boolean):Char = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableCharReturn(notNull)
  }

  def methodWithNonNullableJsonObjectParam(param: io.vertx.core.json.JsonObject):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableJsonObjectParam(param)
  }

  def methodWithNullableJsonObjectParam(expectNull: Boolean,param: io.vertx.core.json.JsonObject):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectParam(expectNull,param)
  }

  def methodWithNullableJsonObjectHandler(notNull: Boolean,handler: Handler[io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectHandler(notNull,{x: JsonObject => handler.handle(x)})
  }

  def methodWithNullableJsonObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectHandlerAsyncResult(notNull,{x: AsyncResult[JsonObject] => handler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
  }

  def methodWithNullableJsonObjectReturn(notNull: Boolean):io.vertx.core.json.JsonObject = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonObjectReturn(notNull)
  }

  def methodWithNonNullableJsonArrayParam(param: io.vertx.core.json.JsonArray):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableJsonArrayParam(param)
  }

  def methodWithNullableJsonArrayParam(expectNull: Boolean,param: io.vertx.core.json.JsonArray):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayParam(expectNull,param)
  }

  def methodWithNullableJsonArrayHandler(notNull: Boolean,handler: Handler[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayHandler(notNull,{x: JsonArray => handler.handle(x)})
  }

  def methodWithNullableJsonArrayHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayHandlerAsyncResult(notNull,{x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
  }

  def methodWithNullableJsonArrayReturn(notNull: Boolean):io.vertx.core.json.JsonArray = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableJsonArrayReturn(notNull)
  }

  def methodWithNonNullableApiParam(param: RefedInterface1):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableApiParam(param.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithNullableApiParam(expectNull: Boolean,param: RefedInterface1):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiParam(expectNull,param.asJava.asInstanceOf[JRefedInterface1])
  }

  def methodWithNullableApiHandler(notNull: Boolean,handler: Handler[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiHandler(notNull,{x: JRefedInterface1 => handler.handle(RefedInterface1(x))})
  }

  def methodWithNullableApiHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableApiHandlerAsyncResult(notNull,{x: AsyncResult[JRefedInterface1] => handler.handle(AsyncResultWrapper[JRefedInterface1,RefedInterface1](x, a => RefedInterface1(a)))})
  }

  def methodWithNullableApiReturn(notNull: Boolean):RefedInterface1 = {
    RefedInterface1(asJava.asInstanceOf[JNullableTCK].methodWithNullableApiReturn(notNull))
  }

  def methodWithNonNullableDataObjectParam(param: TestDataObject):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableDataObjectParam(param.asJava)
  }

  def methodWithNullableDataObjectParam(expectNull: Boolean,param: TestDataObject):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectParam(expectNull,param.asJava)
  }

  def methodWithNullableDataObjectHandler(notNull: Boolean,handler: Handler[TestDataObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectHandler(notNull,{x: JTestDataObject => handler.handle(TestDataObject(x))})
  }

  def methodWithNullableDataObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectHandlerAsyncResult(notNull,{x: AsyncResult[JTestDataObject] => handler.handle(AsyncResultWrapper[JTestDataObject,TestDataObject](x, a => TestDataObject(a)))})
  }

  def methodWithNullableDataObjectReturn(notNull: Boolean):TestDataObject = {
    TestDataObject(asJava.asInstanceOf[JNullableTCK].methodWithNullableDataObjectReturn(notNull))
  }

  def methodWithNonNullableEnumParam(param: io.vertx.codegen.testmodel.TestEnum):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableEnumParam(param)
  }

  def methodWithNullableEnumParam(expectNull: Boolean,param: io.vertx.codegen.testmodel.TestEnum):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumParam(expectNull,param)
  }

  def methodWithNullableEnumHandler(notNull: Boolean,handler: Handler[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumHandler(notNull,{x: TestEnum => handler.handle(x)})
  }

  def methodWithNullableEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumHandlerAsyncResult(notNull,{x: AsyncResult[TestEnum] => handler.handle(AsyncResultWrapper[TestEnum,io.vertx.codegen.testmodel.TestEnum](x, a => a))})
  }

  def methodWithNullableEnumReturn(notNull: Boolean):io.vertx.codegen.testmodel.TestEnum = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableEnumReturn(notNull)
  }

  def methodWithNonNullableGenEnumParam(param: io.vertx.codegen.testmodel.TestGenEnum):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableGenEnumParam(param)
  }

  def methodWithNullableGenEnumParam(expectNull: Boolean,param: io.vertx.codegen.testmodel.TestGenEnum):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumParam(expectNull,param)
  }

  def methodWithNullableGenEnumHandler(notNull: Boolean,handler: Handler[io.vertx.codegen.testmodel.TestGenEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumHandler(notNull,{x: TestGenEnum => handler.handle(x)})
  }

  def methodWithNullableGenEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[io.vertx.codegen.testmodel.TestGenEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumHandlerAsyncResult(notNull,{x: AsyncResult[TestGenEnum] => handler.handle(AsyncResultWrapper[TestGenEnum,io.vertx.codegen.testmodel.TestGenEnum](x, a => a))})
  }

  def methodWithNullableGenEnumReturn(notNull: Boolean):io.vertx.codegen.testmodel.TestGenEnum = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableGenEnumReturn(notNull)
  }

  def methodWithNullableTypeVariableParam[T](expectNull: Boolean,param: T):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableParam[T](expectNull,param)
  }

  def methodWithNullableTypeVariableHandler[T](notNull: Boolean,value: T,handler: Handler[T]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableHandler[T](notNull,value,{x: T => handler.handle(x)})
  }

  def methodWithNullableTypeVariableHandlerAsyncResult[T](notNull: Boolean,value: T,handler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableHandlerAsyncResult[T](notNull,value,{x: AsyncResult[T] => handler.handle(AsyncResultWrapper[T,T](x, a => a))})
  }

  def methodWithNullableTypeVariableReturn[T](notNull: Boolean,value: T):T = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableTypeVariableReturn[T](notNull,value)
  }

  def methodWithNullableObjectParam(expectNull: Boolean,param: AnyRef):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableObjectParam(expectNull,param)
  }

  def methodWithNonNullableListByteParam(param: scala.collection.mutable.Buffer[Byte]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListByteParam(param.map(x => x).asJava)
  }

  def methodWithNullableListByteParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListByteHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteHandler(notNull,{x: java.util.List[java.lang.Byte] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListByteHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Byte]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Byte],scala.collection.mutable.Buffer[Byte]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListByteReturn(notNull: Boolean):scala.collection.mutable.Buffer[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListByteReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListShortParam(param: scala.collection.mutable.Buffer[Short]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListShortParam(param.map(x => x).asJava)
  }

  def methodWithNullableListShortParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListShortHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortHandler(notNull,{x: java.util.List[java.lang.Short] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListShortHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Short]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Short],scala.collection.mutable.Buffer[Short]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListShortReturn(notNull: Boolean):scala.collection.mutable.Buffer[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListShortReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListIntegerParam(param: scala.collection.mutable.Buffer[Int]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListIntegerParam(param.map(x => x).asJava)
  }

  def methodWithNullableListIntegerParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListIntegerHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerHandler(notNull,{x: java.util.List[java.lang.Integer] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListIntegerHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListIntegerReturn(notNull: Boolean):scala.collection.mutable.Buffer[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListIntegerReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListLongParam(param: scala.collection.mutable.Buffer[Long]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListLongParam(param.map(x => x).asJava)
  }

  def methodWithNullableListLongParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListLongHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongHandler(notNull,{x: java.util.List[java.lang.Long] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListLongHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Long]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Long],scala.collection.mutable.Buffer[Long]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListLongReturn(notNull: Boolean):scala.collection.mutable.Buffer[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListLongReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListFloatParam(param: scala.collection.mutable.Buffer[Float]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListFloatParam(param.map(x => x).asJava)
  }

  def methodWithNullableListFloatParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListFloatHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatHandler(notNull,{x: java.util.List[java.lang.Float] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListFloatHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Float]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Float],scala.collection.mutable.Buffer[Float]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListFloatReturn(notNull: Boolean):scala.collection.mutable.Buffer[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListFloatReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListDoubleParam(param: scala.collection.mutable.Buffer[Double]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListDoubleParam(param.map(x => x).asJava)
  }

  def methodWithNullableListDoubleParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListDoubleHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleHandler(notNull,{x: java.util.List[java.lang.Double] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListDoubleHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Double]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Double],scala.collection.mutable.Buffer[Double]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListDoubleReturn(notNull: Boolean):scala.collection.mutable.Buffer[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDoubleReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListBooleanParam(param: scala.collection.mutable.Buffer[Boolean]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListBooleanParam(param.map(x => x).asJava)
  }

  def methodWithNullableListBooleanParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListBooleanHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanHandler(notNull,{x: java.util.List[java.lang.Boolean] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListBooleanHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Boolean]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Boolean],scala.collection.mutable.Buffer[Boolean]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListBooleanReturn(notNull: Boolean):scala.collection.mutable.Buffer[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListBooleanReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListStringParam(param: scala.collection.mutable.Buffer[String]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListStringParam(param.map(x => x).asJava)
  }

  def methodWithNullableListStringParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListStringHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringHandler(notNull,{x: java.util.List[java.lang.String] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListStringHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListStringReturn(notNull: Boolean):scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListStringReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListCharParam(param: scala.collection.mutable.Buffer[Char]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListCharParam(param.map(x => x).asJava)
  }

  def methodWithNullableListCharParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListCharHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharHandler(notNull,{x: java.util.List[java.lang.Character] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListCharHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[java.lang.Character]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Character],scala.collection.mutable.Buffer[Char]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListCharReturn(notNull: Boolean):scala.collection.mutable.Buffer[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListCharReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListJsonObjectParam(param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListJsonObjectParam(param.map(x => x).asJava)
  }

  def methodWithNullableListJsonObjectParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListJsonObjectHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectHandler(notNull,{x: java.util.List[JsonObject] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListJsonObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[JsonObject]] => handler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListJsonObjectReturn(notNull: Boolean):scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonObjectReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListJsonArrayParam(param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListJsonArrayParam(param.map(x => x).asJava)
  }

  def methodWithNullableListJsonArrayParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListJsonArrayHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayHandler(notNull,{x: java.util.List[JsonArray] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListJsonArrayHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[JsonArray]] => handler.handle(AsyncResultWrapper[java.util.List[JsonArray],scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListJsonArrayReturn(notNull: Boolean):scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListJsonArrayReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListApiParam(param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithNullableListApiParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiParam(expectNull,param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithNullableListApiHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiHandler(notNull,{x: java.util.List[JRefedInterface1] => handler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithNullableListApiHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[JRefedInterface1]] => handler.handle(AsyncResultWrapper[java.util.List[JRefedInterface1],scala.collection.mutable.Buffer[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithNullableListApiReturn(notNull: Boolean):scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListApiReturn(notNull).asScala.map(x => RefedInterface1(x))
  }

  def methodWithNonNullableListDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListDataObjectParam(param.map(x => x.asJava).asJava)
  }

  def methodWithNullableListDataObjectParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[TestDataObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectParam(expectNull,param.map(x => x.asJava).asJava)
  }

  def methodWithNullableListDataObjectHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectHandler(notNull,{x: java.util.List[JTestDataObject] => handler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithNullableListDataObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[JTestDataObject]] => handler.handle(AsyncResultWrapper[java.util.List[JTestDataObject],scala.collection.mutable.Buffer[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithNullableListDataObjectReturn(notNull: Boolean):scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListDataObjectReturn(notNull).asScala.map(x => TestDataObject(x))
  }

  def methodWithNonNullableListEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListEnumParam(param.map(x => x).asJava)
  }

  def methodWithNullableListEnumParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListEnumHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumHandler(notNull,{x: java.util.List[TestEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[TestEnum]] => handler.handle(AsyncResultWrapper[java.util.List[TestEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListEnumReturn(notNull: Boolean):scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListEnumReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableListGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableListGenEnumParam(param.map(x => x).asJava)
  }

  def methodWithNullableListGenEnumParam(expectNull: Boolean,param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableListGenEnumHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumHandler(notNull,{x: java.util.List[TestGenEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableListGenEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumHandlerAsyncResult(notNull,{x: AsyncResult[java.util.List[TestGenEnum]] => handler.handle(AsyncResultWrapper[java.util.List[TestGenEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableListGenEnumReturn(notNull: Boolean):scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableListGenEnumReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetByteParam(param: scala.collection.mutable.Set[Byte]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetByteParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetByteParam(expectNull: Boolean,param: scala.collection.mutable.Set[Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetByteHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteHandler(notNull,{x: java.util.Set[java.lang.Byte] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetByteHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Byte]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Byte],scala.collection.mutable.Set[Byte]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetByteReturn(notNull: Boolean):scala.collection.mutable.Set[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetByteReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetShortParam(param: scala.collection.mutable.Set[Short]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetShortParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetShortParam(expectNull: Boolean,param: scala.collection.mutable.Set[Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetShortHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortHandler(notNull,{x: java.util.Set[java.lang.Short] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetShortHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Short]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Short],scala.collection.mutable.Set[Short]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetShortReturn(notNull: Boolean):scala.collection.mutable.Set[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetShortReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetIntegerParam(param: scala.collection.mutable.Set[Int]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetIntegerParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetIntegerParam(expectNull: Boolean,param: scala.collection.mutable.Set[Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetIntegerHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerHandler(notNull,{x: java.util.Set[java.lang.Integer] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetIntegerHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Integer],scala.collection.mutable.Set[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetIntegerReturn(notNull: Boolean):scala.collection.mutable.Set[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetIntegerReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetLongParam(param: scala.collection.mutable.Set[Long]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetLongParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetLongParam(expectNull: Boolean,param: scala.collection.mutable.Set[Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetLongHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongHandler(notNull,{x: java.util.Set[java.lang.Long] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetLongHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Long]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Long],scala.collection.mutable.Set[Long]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetLongReturn(notNull: Boolean):scala.collection.mutable.Set[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetLongReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetFloatParam(param: scala.collection.mutable.Set[Float]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetFloatParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetFloatParam(expectNull: Boolean,param: scala.collection.mutable.Set[Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetFloatHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatHandler(notNull,{x: java.util.Set[java.lang.Float] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetFloatHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Float]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Float],scala.collection.mutable.Set[Float]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetFloatReturn(notNull: Boolean):scala.collection.mutable.Set[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetFloatReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetDoubleParam(param: scala.collection.mutable.Set[Double]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetDoubleParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetDoubleParam(expectNull: Boolean,param: scala.collection.mutable.Set[Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetDoubleHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleHandler(notNull,{x: java.util.Set[java.lang.Double] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetDoubleHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Double]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Double],scala.collection.mutable.Set[Double]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetDoubleReturn(notNull: Boolean):scala.collection.mutable.Set[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDoubleReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetBooleanParam(param: scala.collection.mutable.Set[Boolean]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetBooleanParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetBooleanParam(expectNull: Boolean,param: scala.collection.mutable.Set[Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetBooleanHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanHandler(notNull,{x: java.util.Set[java.lang.Boolean] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetBooleanHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Boolean]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Boolean],scala.collection.mutable.Set[Boolean]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetBooleanReturn(notNull: Boolean):scala.collection.mutable.Set[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetBooleanReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetStringParam(param: scala.collection.mutable.Set[String]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetStringParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetStringParam(expectNull: Boolean,param: scala.collection.mutable.Set[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetStringHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringHandler(notNull,{x: java.util.Set[java.lang.String] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetStringHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.String],scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetStringReturn(notNull: Boolean):scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetStringReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetCharParam(param: scala.collection.mutable.Set[Char]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetCharParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetCharParam(expectNull: Boolean,param: scala.collection.mutable.Set[Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetCharHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharHandler(notNull,{x: java.util.Set[java.lang.Character] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetCharHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[java.lang.Character]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Character],scala.collection.mutable.Set[Char]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetCharReturn(notNull: Boolean):scala.collection.mutable.Set[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetCharReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetJsonObjectParam(param: scala.collection.mutable.Set[io.vertx.core.json.JsonObject]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetJsonObjectParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetJsonObjectParam(expectNull: Boolean,param: scala.collection.mutable.Set[io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetJsonObjectHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectHandler(notNull,{x: java.util.Set[JsonObject] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetJsonObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[JsonObject]] => handler.handle(AsyncResultWrapper[java.util.Set[JsonObject],scala.collection.mutable.Set[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetJsonObjectReturn(notNull: Boolean):scala.collection.mutable.Set[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonObjectReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetJsonArrayParam(param: scala.collection.mutable.Set[io.vertx.core.json.JsonArray]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetJsonArrayParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetJsonArrayParam(expectNull: Boolean,param: scala.collection.mutable.Set[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetJsonArrayHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayHandler(notNull,{x: java.util.Set[JsonArray] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetJsonArrayHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[JsonArray]] => handler.handle(AsyncResultWrapper[java.util.Set[JsonArray],scala.collection.mutable.Set[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetJsonArrayReturn(notNull: Boolean):scala.collection.mutable.Set[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetJsonArrayReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetApiParam(param: scala.collection.mutable.Set[RefedInterface1]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetApiParam(param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithNullableSetApiParam(expectNull: Boolean,param: scala.collection.mutable.Set[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiParam(expectNull,param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithNullableSetApiHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiHandler(notNull,{x: java.util.Set[JRefedInterface1] => handler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithNullableSetApiHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[JRefedInterface1]] => handler.handle(AsyncResultWrapper[java.util.Set[JRefedInterface1],scala.collection.mutable.Set[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithNullableSetApiReturn(notNull: Boolean):scala.collection.mutable.Set[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetApiReturn(notNull).asScala.map(x => RefedInterface1(x))
  }

  def methodWithNonNullableSetDataObjectParam(param: scala.collection.mutable.Set[TestDataObject]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetDataObjectParam(param.map(x => x.asJava).asJava)
  }

  def methodWithNullableSetDataObjectParam(expectNull: Boolean,param: scala.collection.mutable.Set[TestDataObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectParam(expectNull,param.map(x => x.asJava).asJava)
  }

  def methodWithNullableSetDataObjectHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectHandler(notNull,{x: java.util.Set[JTestDataObject] => handler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithNullableSetDataObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[JTestDataObject]] => handler.handle(AsyncResultWrapper[java.util.Set[JTestDataObject],scala.collection.mutable.Set[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithNullableSetDataObjectReturn(notNull: Boolean):scala.collection.mutable.Set[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetDataObjectReturn(notNull).asScala.map(x => TestDataObject(x))
  }

  def methodWithNonNullableSetEnumParam(param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetEnumParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetEnumParam(expectNull: Boolean,param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetEnumHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumHandler(notNull,{x: java.util.Set[TestEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[TestEnum]] => handler.handle(AsyncResultWrapper[java.util.Set[TestEnum],scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetEnumReturn(notNull: Boolean):scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetEnumReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableSetGenEnumParam(param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableSetGenEnumParam(param.map(x => x).asJava)
  }

  def methodWithNullableSetGenEnumParam(expectNull: Boolean,param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumParam(expectNull,param.map(x => x).asJava)
  }

  def methodWithNullableSetGenEnumHandler(notNull: Boolean,handler: Handler[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumHandler(notNull,{x: java.util.Set[TestGenEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithNullableSetGenEnumHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Set[TestGenEnum]] => handler.handle(AsyncResultWrapper[java.util.Set[TestGenEnum],scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithNullableSetGenEnumReturn(notNull: Boolean):scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableSetGenEnumReturn(notNull).asScala.map(x => x)
  }

  def methodWithNonNullableMapByteParam(param: Map[String, Byte]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapByteParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapByteParam(expectNull: Boolean,param: Map[String, Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapByteHandler(notNull: Boolean,handler: Handler[Map[String, Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapByteHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Byte]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapByteReturn(notNull: Boolean):Map[String, Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapByteReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapShortParam(param: Map[String, Short]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapShortParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapShortParam(expectNull: Boolean,param: Map[String, Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapShortHandler(notNull: Boolean,handler: Handler[Map[String, Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapShortHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Short]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapShortReturn(notNull: Boolean):Map[String, Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapShortReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapIntegerParam(param: Map[String, Int]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapIntegerParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapIntegerParam(expectNull: Boolean,param: Map[String, Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapIntegerHandler(notNull: Boolean,handler: Handler[Map[String, Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapIntegerHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Int]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapIntegerReturn(notNull: Boolean):Map[String, Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapIntegerReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapLongParam(param: Map[String, Long]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapLongParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapLongParam(expectNull: Boolean,param: Map[String, Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapLongHandler(notNull: Boolean,handler: Handler[Map[String, Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapLongHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Long]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapLongReturn(notNull: Boolean):Map[String, Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapLongReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapFloatParam(param: Map[String, Float]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapFloatParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapFloatParam(expectNull: Boolean,param: Map[String, Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapFloatHandler(notNull: Boolean,handler: Handler[Map[String, Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapFloatHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Float]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapFloatReturn(notNull: Boolean):Map[String, Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapFloatReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapDoubleParam(param: Map[String, Double]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapDoubleParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapDoubleParam(expectNull: Boolean,param: Map[String, Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapDoubleHandler(notNull: Boolean,handler: Handler[Map[String, Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapDoubleHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Double]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapDoubleReturn(notNull: Boolean):Map[String, Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapDoubleReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapBooleanParam(param: Map[String, Boolean]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapBooleanParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapBooleanParam(expectNull: Boolean,param: Map[String, Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapBooleanHandler(notNull: Boolean,handler: Handler[Map[String, Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapBooleanHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Boolean]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapBooleanReturn(notNull: Boolean):Map[String, Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapBooleanReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapStringParam(param: Map[String, String]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapStringParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapStringParam(expectNull: Boolean,param: Map[String, String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapStringHandler(notNull: Boolean,handler: Handler[Map[String, String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapStringHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, String]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapStringReturn(notNull: Boolean):Map[String, String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapStringReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapCharParam(param: Map[String, Char]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapCharParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapCharParam(expectNull: Boolean,param: Map[String, Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapCharHandler(notNull: Boolean,handler: Handler[Map[String, Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapCharHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Char]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapCharReturn(notNull: Boolean):Map[String, Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapCharReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapJsonObjectParam(param: Map[String, io.vertx.core.json.JsonObject]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapJsonObjectParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapJsonObjectParam(expectNull: Boolean,param: Map[String, io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapJsonObjectHandler(notNull: Boolean,handler: Handler[Map[String, io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapJsonObjectHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, io.vertx.core.json.JsonObject]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapJsonObjectReturn(notNull: Boolean):Map[String, io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonObjectReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapJsonArrayParam(param: Map[String, io.vertx.core.json.JsonArray]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapJsonArrayParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapJsonArrayParam(expectNull: Boolean,param: Map[String, io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapJsonArrayHandler(notNull: Boolean,handler: Handler[Map[String, io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayHandler(notNull,{x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithNullableMapJsonArrayHandlerAsyncResult(notNull: Boolean,handler: Handler[AsyncResult[Map[String, io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayHandlerAsyncResult(notNull,{x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, io.vertx.core.json.JsonArray]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithNullableMapJsonArrayReturn(notNull: Boolean):Map[String, io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapJsonArrayReturn(notNull).asScala.mapValues(x => x)
  }

  def methodWithNonNullableMapApiParam(param: Map[String, RefedInterface1]):Boolean = {
    asJava.asInstanceOf[JNullableTCK].methodWithNonNullableMapApiParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableMapApiParam(expectNull: Boolean,param: Map[String, RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableMapApiParam(expectNull,param.mapValues(x => x).asJava)
  }

  def methodWithListNullableByteParam(param: scala.collection.mutable.Buffer[Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteParam(param.map(x => x).asJava)
  }

  def methodWithListNullableByteHandler(handler: Handler[scala.collection.mutable.Buffer[Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteHandler({x: java.util.List[java.lang.Byte] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableByteHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Byte]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Byte],scala.collection.mutable.Buffer[Byte]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableByteReturn():scala.collection.mutable.Buffer[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableByteReturn().asScala.map(x => x)
  }

  def methodWithListNullableShortParam(param: scala.collection.mutable.Buffer[Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortParam(param.map(x => x).asJava)
  }

  def methodWithListNullableShortHandler(handler: Handler[scala.collection.mutable.Buffer[Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortHandler({x: java.util.List[java.lang.Short] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableShortHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Short]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Short],scala.collection.mutable.Buffer[Short]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableShortReturn():scala.collection.mutable.Buffer[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableShortReturn().asScala.map(x => x)
  }

  def methodWithListNullableIntegerParam(param: scala.collection.mutable.Buffer[Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerParam(param.map(x => x).asJava)
  }

  def methodWithListNullableIntegerHandler(handler: Handler[scala.collection.mutable.Buffer[Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerHandler({x: java.util.List[java.lang.Integer] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableIntegerHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableIntegerReturn():scala.collection.mutable.Buffer[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableIntegerReturn().asScala.map(x => x)
  }

  def methodWithListNullableLongParam(param: scala.collection.mutable.Buffer[Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongParam(param.map(x => x).asJava)
  }

  def methodWithListNullableLongHandler(handler: Handler[scala.collection.mutable.Buffer[Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongHandler({x: java.util.List[java.lang.Long] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableLongHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Long]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Long],scala.collection.mutable.Buffer[Long]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableLongReturn():scala.collection.mutable.Buffer[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableLongReturn().asScala.map(x => x)
  }

  def methodWithListNullableBooleanParam(param: scala.collection.mutable.Buffer[Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanParam(param.map(x => x).asJava)
  }

  def methodWithListNullableBooleanHandler(handler: Handler[scala.collection.mutable.Buffer[Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanHandler({x: java.util.List[java.lang.Boolean] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableBooleanHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Boolean]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Boolean],scala.collection.mutable.Buffer[Boolean]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableBooleanReturn():scala.collection.mutable.Buffer[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableBooleanReturn().asScala.map(x => x)
  }

  def methodWithListNullableFloatParam(param: scala.collection.mutable.Buffer[Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatParam(param.map(x => x).asJava)
  }

  def methodWithListNullableFloatHandler(handler: Handler[scala.collection.mutable.Buffer[Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatHandler({x: java.util.List[java.lang.Float] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableFloatHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Float]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Float],scala.collection.mutable.Buffer[Float]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableFloatReturn():scala.collection.mutable.Buffer[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableFloatReturn().asScala.map(x => x)
  }

  def methodWithListNullableDoubleParam(param: scala.collection.mutable.Buffer[Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleParam(param.map(x => x).asJava)
  }

  def methodWithListNullableDoubleHandler(handler: Handler[scala.collection.mutable.Buffer[Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleHandler({x: java.util.List[java.lang.Double] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableDoubleHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Double]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Double],scala.collection.mutable.Buffer[Double]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableDoubleReturn():scala.collection.mutable.Buffer[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDoubleReturn().asScala.map(x => x)
  }

  def methodWithListNullableStringParam(param: scala.collection.mutable.Buffer[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringParam(param.map(x => x).asJava)
  }

  def methodWithListNullableStringHandler(handler: Handler[scala.collection.mutable.Buffer[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringHandler({x: java.util.List[java.lang.String] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableStringHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableStringReturn():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableStringReturn().asScala.map(x => x)
  }

  def methodWithListNullableCharParam(param: scala.collection.mutable.Buffer[Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharParam(param.map(x => x).asJava)
  }

  def methodWithListNullableCharHandler(handler: Handler[scala.collection.mutable.Buffer[Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharHandler({x: java.util.List[java.lang.Character] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableCharHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharHandlerAsyncResult({x: AsyncResult[java.util.List[java.lang.Character]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Character],scala.collection.mutable.Buffer[Char]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableCharReturn():scala.collection.mutable.Buffer[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableCharReturn().asScala.map(x => x)
  }

  def methodWithListNullableJsonObjectParam(param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectParam(param.map(x => x).asJava)
  }

  def methodWithListNullableJsonObjectHandler(handler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectHandler({x: java.util.List[JsonObject] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableJsonObjectHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectHandlerAsyncResult({x: AsyncResult[java.util.List[JsonObject]] => handler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableJsonObjectReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithListNullableJsonArrayParam(param: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayParam(param.map(x => x).asJava)
  }

  def methodWithListNullableJsonArrayHandler(handler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayHandler({x: java.util.List[JsonArray] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableJsonArrayHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayHandlerAsyncResult({x: AsyncResult[java.util.List[JsonArray]] => handler.handle(AsyncResultWrapper[java.util.List[JsonArray],scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableJsonArrayReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithListNullableApiParam(param: scala.collection.mutable.Buffer[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiParam(param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithListNullableApiHandler(handler: Handler[scala.collection.mutable.Buffer[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiHandler({x: java.util.List[JRefedInterface1] => handler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithListNullableApiHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiHandlerAsyncResult({x: AsyncResult[java.util.List[JRefedInterface1]] => handler.handle(AsyncResultWrapper[java.util.List[JRefedInterface1],scala.collection.mutable.Buffer[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithListNullableApiReturn():scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableApiReturn().asScala.map(x => RefedInterface1(x))
  }

  def methodWithListNullableDataObjectParam(param: scala.collection.mutable.Buffer[TestDataObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectParam(param.map(x => x.asJava).asJava)
  }

  def methodWithListNullableDataObjectHandler(handler: Handler[scala.collection.mutable.Buffer[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectHandler({x: java.util.List[JTestDataObject] => handler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithListNullableDataObjectHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectHandlerAsyncResult({x: AsyncResult[java.util.List[JTestDataObject]] => handler.handle(AsyncResultWrapper[java.util.List[JTestDataObject],scala.collection.mutable.Buffer[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithListNullableDataObjectReturn():scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListNullableEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumParam(param.map(x => x).asJava)
  }

  def methodWithListNullableEnumHandler(handler: Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumHandler({x: java.util.List[TestEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableEnumHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumHandlerAsyncResult({x: AsyncResult[java.util.List[TestEnum]] => handler.handle(AsyncResultWrapper[java.util.List[TestEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableEnumReturn():scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableEnumReturn().asScala.map(x => x)
  }

  def methodWithListNullableGenEnumParam(param: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumParam(param.map(x => x).asJava)
  }

  def methodWithListNullableGenEnumHandler(handler: Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumHandler({x: java.util.List[TestGenEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithListNullableGenEnumHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumHandlerAsyncResult({x: AsyncResult[java.util.List[TestGenEnum]] => handler.handle(AsyncResultWrapper[java.util.List[TestGenEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithListNullableGenEnumReturn():scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithListNullableGenEnumReturn().asScala.map(x => x)
  }

  def methodWithSetNullableByteParam(param: scala.collection.mutable.Set[Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableByteHandler(handler: Handler[scala.collection.mutable.Set[Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteHandler({x: java.util.Set[java.lang.Byte] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableByteHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Byte]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Byte],scala.collection.mutable.Set[Byte]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableByteReturn():scala.collection.mutable.Set[Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableByteReturn().asScala.map(x => x)
  }

  def methodWithSetNullableShortParam(param: scala.collection.mutable.Set[Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableShortHandler(handler: Handler[scala.collection.mutable.Set[Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortHandler({x: java.util.Set[java.lang.Short] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableShortHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Short]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Short],scala.collection.mutable.Set[Short]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableShortReturn():scala.collection.mutable.Set[Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableShortReturn().asScala.map(x => x)
  }

  def methodWithSetNullableIntegerParam(param: scala.collection.mutable.Set[Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableIntegerHandler(handler: Handler[scala.collection.mutable.Set[Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerHandler({x: java.util.Set[java.lang.Integer] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableIntegerHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Integer],scala.collection.mutable.Set[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableIntegerReturn():scala.collection.mutable.Set[Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableIntegerReturn().asScala.map(x => x)
  }

  def methodWithSetNullableLongParam(param: scala.collection.mutable.Set[Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableLongHandler(handler: Handler[scala.collection.mutable.Set[Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongHandler({x: java.util.Set[java.lang.Long] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableLongHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Long]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Long],scala.collection.mutable.Set[Long]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableLongReturn():scala.collection.mutable.Set[Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableLongReturn().asScala.map(x => x)
  }

  def methodWithSetNullableBooleanParam(param: scala.collection.mutable.Set[Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableBooleanHandler(handler: Handler[scala.collection.mutable.Set[Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanHandler({x: java.util.Set[java.lang.Boolean] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableBooleanHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Boolean]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Boolean],scala.collection.mutable.Set[Boolean]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableBooleanReturn():scala.collection.mutable.Set[Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableBooleanReturn().asScala.map(x => x)
  }

  def methodWithSetNullableFloatParam(param: scala.collection.mutable.Set[Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableFloatHandler(handler: Handler[scala.collection.mutable.Set[Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatHandler({x: java.util.Set[java.lang.Float] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableFloatHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Float]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Float],scala.collection.mutable.Set[Float]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableFloatReturn():scala.collection.mutable.Set[Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableFloatReturn().asScala.map(x => x)
  }

  def methodWithSetNullableDoubleParam(param: scala.collection.mutable.Set[Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableDoubleHandler(handler: Handler[scala.collection.mutable.Set[Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleHandler({x: java.util.Set[java.lang.Double] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableDoubleHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Double]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Double],scala.collection.mutable.Set[Double]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableDoubleReturn():scala.collection.mutable.Set[Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDoubleReturn().asScala.map(x => x)
  }

  def methodWithSetNullableStringParam(param: scala.collection.mutable.Set[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableStringHandler(handler: Handler[scala.collection.mutable.Set[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringHandler({x: java.util.Set[java.lang.String] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableStringHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.String],scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableStringReturn():scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableStringReturn().asScala.map(x => x)
  }

  def methodWithSetNullableCharParam(param: scala.collection.mutable.Set[Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableCharHandler(handler: Handler[scala.collection.mutable.Set[Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharHandler({x: java.util.Set[java.lang.Character] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableCharHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharHandlerAsyncResult({x: AsyncResult[java.util.Set[java.lang.Character]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Character],scala.collection.mutable.Set[Char]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableCharReturn():scala.collection.mutable.Set[Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableCharReturn().asScala.map(x => x)
  }

  def methodWithSetNullableJsonObjectParam(param: scala.collection.mutable.Set[io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableJsonObjectHandler(handler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectHandler({x: java.util.Set[JsonObject] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableJsonObjectHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectHandlerAsyncResult({x: AsyncResult[java.util.Set[JsonObject]] => handler.handle(AsyncResultWrapper[java.util.Set[JsonObject],scala.collection.mutable.Set[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableJsonObjectReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithSetNullableJsonArrayParam(param: scala.collection.mutable.Set[io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableJsonArrayHandler(handler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayHandler({x: java.util.Set[JsonArray] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableJsonArrayHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayHandlerAsyncResult({x: AsyncResult[java.util.Set[JsonArray]] => handler.handle(AsyncResultWrapper[java.util.Set[JsonArray],scala.collection.mutable.Set[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableJsonArrayReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithSetNullableApiParam(param: scala.collection.mutable.Set[RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiParam(param.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava)
  }

  def methodWithSetNullableApiHandler(handler: Handler[scala.collection.mutable.Set[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiHandler({x: java.util.Set[JRefedInterface1] => handler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithSetNullableApiHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiHandlerAsyncResult({x: AsyncResult[java.util.Set[JRefedInterface1]] => handler.handle(AsyncResultWrapper[java.util.Set[JRefedInterface1],scala.collection.mutable.Set[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithSetNullableApiReturn():scala.collection.mutable.Set[RefedInterface1] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableApiReturn().asScala.map(x => RefedInterface1(x))
  }

  def methodWithSetNullableDataObjectParam(param: scala.collection.mutable.Set[TestDataObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectParam(param.map(x => x.asJava).asJava)
  }

  def methodWithSetNullableDataObjectHandler(handler: Handler[scala.collection.mutable.Set[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectHandler({x: java.util.Set[JTestDataObject] => handler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithSetNullableDataObjectHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectHandlerAsyncResult({x: AsyncResult[java.util.Set[JTestDataObject]] => handler.handle(AsyncResultWrapper[java.util.Set[JTestDataObject],scala.collection.mutable.Set[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithSetNullableDataObjectReturn():scala.collection.mutable.Set[TestDataObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithSetNullableEnumParam(param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableEnumHandler(handler: Handler[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumHandler({x: java.util.Set[TestEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableEnumHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumHandlerAsyncResult({x: AsyncResult[java.util.Set[TestEnum]] => handler.handle(AsyncResultWrapper[java.util.Set[TestEnum],scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableEnumReturn():scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableEnumReturn().asScala.map(x => x)
  }

  def methodWithSetNullableGenEnumParam(param: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumParam(param.map(x => x).asJava)
  }

  def methodWithSetNullableGenEnumHandler(handler: Handler[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumHandler({x: java.util.Set[TestGenEnum] => handler.handle(x.asScala.map(x => x))})
  }

  def methodWithSetNullableGenEnumHandlerAsyncResult(handler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumHandlerAsyncResult({x: AsyncResult[java.util.Set[TestGenEnum]] => handler.handle(AsyncResultWrapper[java.util.Set[TestGenEnum],scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithSetNullableGenEnumReturn():scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestGenEnum] = {
    asJava.asInstanceOf[JNullableTCK].methodWithSetNullableGenEnumReturn().asScala.map(x => x)
  }

  def methodWithMapNullableByteParam(param: Map[String, Byte]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableByteHandler(handler: Handler[Map[String, Byte]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableByteHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Byte]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Byte]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableByteReturn():Map[String, Byte] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableByteReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableShortParam(param: Map[String, Short]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableShortHandler(handler: Handler[Map[String, Short]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableShortHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Short]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Short]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableShortReturn():Map[String, Short] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableShortReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableIntegerParam(param: Map[String, Int]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableIntegerHandler(handler: Handler[Map[String, Int]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableIntegerHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Int]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Int]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableIntegerReturn():Map[String, Int] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableIntegerReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableLongParam(param: Map[String, Long]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableLongHandler(handler: Handler[Map[String, Long]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableLongHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Long]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Long]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableLongReturn():Map[String, Long] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableLongReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableBooleanParam(param: Map[String, Boolean]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableBooleanHandler(handler: Handler[Map[String, Boolean]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableBooleanHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Boolean]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Boolean]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableBooleanReturn():Map[String, Boolean] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableBooleanReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableFloatParam(param: Map[String, Float]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableFloatHandler(handler: Handler[Map[String, Float]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableFloatHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Float]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Float]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableFloatReturn():Map[String, Float] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableFloatReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableDoubleParam(param: Map[String, Double]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableDoubleHandler(handler: Handler[Map[String, Double]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableDoubleHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Double]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Double]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableDoubleReturn():Map[String, Double] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableDoubleReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableStringParam(param: Map[String, String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableStringHandler(handler: Handler[Map[String, String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableStringHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, String]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, String]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableStringReturn():Map[String, String] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableStringReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableCharParam(param: Map[String, Char]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableCharHandler(handler: Handler[Map[String, Char]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableCharHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, Char]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, Char]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableCharReturn():Map[String, Char] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableCharReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableJsonObjectParam(param: Map[String, io.vertx.core.json.JsonObject]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableJsonObjectHandler(handler: Handler[Map[String, io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableJsonObjectHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, io.vertx.core.json.JsonObject]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableJsonObjectReturn():Map[String, io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonObjectReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableJsonArrayParam(param: Map[String, io.vertx.core.json.JsonArray]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayParam(param.mapValues(x => x).asJava)
  }

  def methodWithMapNullableJsonArrayHandler(handler: Handler[Map[String, io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayHandler({x: java.util.Map[String, java.lang.String] => handler.handle(x.asScala.mapValues(x => x))})
  }

  def methodWithMapNullableJsonArrayHandlerAsyncResult(handler: Handler[AsyncResult[Map[String, io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayHandlerAsyncResult({x: AsyncResult[java.util.Map[String, java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Map[String, java.lang.String],Map[String, io.vertx.core.json.JsonArray]](x, a => a.asScala.mapValues(x => x)))})
  }

  def methodWithMapNullableJsonArrayReturn():Map[String, io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableJsonArrayReturn().asScala.mapValues(x => x)
  }

  def methodWithMapNullableApiParam(param: Map[String, RefedInterface1]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithMapNullableApiParam(param.mapValues(x => x).asJava)
  }

  def methodWithNullableHandler(expectNull: Boolean,handler: Handler[String]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableHandler(expectNull,{x: java.lang.String => handler.handle(x)})
  }

  def methodWithNullableHandlerAsyncResult(expectNull: Boolean,handler: Handler[AsyncResult[String]]):Unit = {
    asJava.asInstanceOf[JNullableTCK].methodWithNullableHandlerAsyncResult(expectNull,{x: AsyncResult[java.lang.String] => handler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a))})
  }

}

  object NullableTCK{
    def apply(asJava: JNullableTCK) = new NullableTCK(asJava)  
  //static methods
  }
