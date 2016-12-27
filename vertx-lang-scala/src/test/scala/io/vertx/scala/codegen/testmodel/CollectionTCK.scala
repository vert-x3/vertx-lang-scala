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
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.core.Handler
import io.vertx.codegen.testmodel.{CollectionTCK => JCollectionTCK}

/**
  */
class CollectionTCK(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def methodWithListParams(listString: scala.collection.mutable.Buffer[String],listByte: scala.collection.mutable.Buffer[Byte],listShort: scala.collection.mutable.Buffer[Short],listInt: scala.collection.mutable.Buffer[Int],listLong: scala.collection.mutable.Buffer[Long],listJsonObject: scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject],listJsonArray: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray],listVertxGen: scala.collection.mutable.Buffer[RefedInterface1],listDataObject: scala.collection.mutable.Buffer[TestDataObject],listEnum: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListParams(listString.map(x => x).asJava,listByte.map(x => x).asJava,listShort.map(x => x).asJava,listInt.map(x => x).asJava,listLong.map(x => x).asJava,listJsonObject.map(x => x).asJava,listJsonArray.map(x => x).asJava,listVertxGen.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava,listDataObject.map(x => x.asJava).asJava,listEnum.map(x => x).asJava)
  }

  def methodWithSetParams(setString: scala.collection.mutable.Set[String],setByte: scala.collection.mutable.Set[Byte],setShort: scala.collection.mutable.Set[Short],setInt: scala.collection.mutable.Set[Int],setLong: scala.collection.mutable.Set[Long],setJsonObject: scala.collection.mutable.Set[io.vertx.core.json.JsonObject],setJsonArray: scala.collection.mutable.Set[io.vertx.core.json.JsonArray],setVertxGen: scala.collection.mutable.Set[RefedInterface1],setDataObject: scala.collection.mutable.Set[TestDataObject],setEnum: scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetParams(setString.map(x => x).asJava,setByte.map(x => x).asJava,setShort.map(x => x).asJava,setInt.map(x => x).asJava,setLong.map(x => x).asJava,setJsonObject.map(x => x).asJava,setJsonArray.map(x => x).asJava,setVertxGen.map(x => x.asJava.asInstanceOf[JRefedInterface1]).asJava,setDataObject.map(x => x.asJava).asJava,setEnum.map(x => x).asJava)
  }

  def methodWithMapParams(mapString: Map[String, String],mapByte: Map[String, Byte],mapShort: Map[String, Short],mapInt: Map[String, Int],mapLong: Map[String, Long],mapJsonObject: Map[String, io.vertx.core.json.JsonObject],mapJsonArray: Map[String, io.vertx.core.json.JsonArray],mapVertxGen: Map[String, RefedInterface1]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapParams(mapString.mapValues(x => x).asJava,mapByte.mapValues(x => x).asJava,mapShort.mapValues(x => x).asJava,mapInt.mapValues(x => x).asJava,mapLong.mapValues(x => x).asJava,mapJsonObject.mapValues(x => x).asJava,mapJsonArray.mapValues(x => x).asJava,mapVertxGen.mapValues(x => x).asJava)
  }

  def methodWithHandlerListAndSet(listStringHandler: Handler[scala.collection.mutable.Buffer[String]],listIntHandler: Handler[scala.collection.mutable.Buffer[Int]],setStringHandler: Handler[scala.collection.mutable.Set[String]],setIntHandler: Handler[scala.collection.mutable.Set[Int]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListAndSet({x: java.util.List[java.lang.String] => listStringHandler.handle(x.asScala.map(x => x))},{x: java.util.List[java.lang.Integer] => listIntHandler.handle(x.asScala.map(x => x))},{x: java.util.Set[java.lang.String] => setStringHandler.handle(x.asScala.map(x => x))},{x: java.util.Set[java.lang.Integer] => setIntHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerAsyncResultListString(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListString({x: AsyncResult[java.util.List[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultListInteger(handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListInteger({x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerListVertxGen(listHandler: Handler[scala.collection.mutable.Buffer[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListVertxGen({x: java.util.List[JRefedInterface1] => listHandler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithHandlerListAbstractVertxGen(listHandler: Handler[scala.collection.mutable.Buffer[RefedInterface2]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListAbstractVertxGen({x: java.util.List[JRefedInterface2] => listHandler.handle(x.asScala.map(x => RefedInterface2(x)))})
  }

  def methodWithHandlerListJsonObject(listHandler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListJsonObject({x: java.util.List[JsonObject] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerListComplexJsonObject(listHandler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListComplexJsonObject({x: java.util.List[JsonObject] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerListJsonArray(listHandler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListJsonArray({x: java.util.List[JsonArray] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerListComplexJsonArray(listHandler: Handler[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListComplexJsonArray({x: java.util.List[JsonArray] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerListDataObject(listHandler: Handler[scala.collection.mutable.Buffer[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListDataObject({x: java.util.List[JTestDataObject] => listHandler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithHandlerListEnum(listHandler: Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListEnum({x: java.util.List[TestEnum] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerAsyncResultSetString(handler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetString({x: AsyncResult[java.util.Set[java.lang.String]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.String],scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetInteger(handler: Handler[AsyncResult[scala.collection.mutable.Set[Int]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetInteger({x: AsyncResult[java.util.Set[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.Set[java.lang.Integer],scala.collection.mutable.Set[Int]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerSetVertxGen(listHandler: Handler[scala.collection.mutable.Set[RefedInterface1]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetVertxGen({x: java.util.Set[JRefedInterface1] => listHandler.handle(x.asScala.map(x => RefedInterface1(x)))})
  }

  def methodWithHandlerSetAbstractVertxGen(listHandler: Handler[scala.collection.mutable.Set[RefedInterface2]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetAbstractVertxGen({x: java.util.Set[JRefedInterface2] => listHandler.handle(x.asScala.map(x => RefedInterface2(x)))})
  }

  def methodWithHandlerSetJsonObject(listHandler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetJsonObject({x: java.util.Set[JsonObject] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerSetComplexJsonObject(listHandler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetComplexJsonObject({x: java.util.Set[JsonObject] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerSetJsonArray(listHandler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetJsonArray({x: java.util.Set[JsonArray] => listHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerSetComplexJsonArray(setHandler: Handler[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetComplexJsonArray({x: java.util.Set[JsonArray] => setHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerSetDataObject(setHandler: Handler[scala.collection.mutable.Set[TestDataObject]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetDataObject({x: java.util.Set[JTestDataObject] => setHandler.handle(x.asScala.map(x => TestDataObject(x)))})
  }

  def methodWithHandlerSetEnum(setHandler: Handler[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetEnum({x: java.util.Set[TestEnum] => setHandler.handle(x.asScala.map(x => x))})
  }

  def methodWithHandlerAsyncResultListVertxGen(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListVertxGen({x: AsyncResult[java.util.List[JRefedInterface1]] => listHandler.handle(AsyncResultWrapper[java.util.List[JRefedInterface1],scala.collection.mutable.Buffer[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithHandlerAsyncResultListAbstractVertxGen(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[RefedInterface2]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListAbstractVertxGen({x: AsyncResult[java.util.List[JRefedInterface2]] => listHandler.handle(AsyncResultWrapper[java.util.List[JRefedInterface2],scala.collection.mutable.Buffer[RefedInterface2]](x, a => a.asScala.map(x => RefedInterface2(x))))})
  }

  def methodWithHandlerAsyncResultListJsonObject(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListJsonObject({x: AsyncResult[java.util.List[JsonObject]] => listHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultListComplexJsonObject(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListComplexJsonObject({x: AsyncResult[java.util.List[JsonObject]] => listHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultListJsonArray(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListJsonArray({x: AsyncResult[java.util.List[JsonArray]] => listHandler.handle(AsyncResultWrapper[java.util.List[JsonArray],scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultListComplexJsonArray(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListComplexJsonArray({x: AsyncResult[java.util.List[JsonArray]] => listHandler.handle(AsyncResultWrapper[java.util.List[JsonArray],scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultListDataObject(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListDataObject({x: AsyncResult[java.util.List[JTestDataObject]] => listHandler.handle(AsyncResultWrapper[java.util.List[JTestDataObject],scala.collection.mutable.Buffer[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithHandlerAsyncResultListEnum(listHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListEnum({x: AsyncResult[java.util.List[TestEnum]] => listHandler.handle(AsyncResultWrapper[java.util.List[TestEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetVertxGen(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[RefedInterface1]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetVertxGen({x: AsyncResult[java.util.Set[JRefedInterface1]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JRefedInterface1],scala.collection.mutable.Set[RefedInterface1]](x, a => a.asScala.map(x => RefedInterface1(x))))})
  }

  def methodWithHandlerAsyncResultSetAbstractVertxGen(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[RefedInterface2]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetAbstractVertxGen({x: AsyncResult[java.util.Set[JRefedInterface2]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JRefedInterface2],scala.collection.mutable.Set[RefedInterface2]](x, a => a.asScala.map(x => RefedInterface2(x))))})
  }

  def methodWithHandlerAsyncResultSetJsonObject(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetJsonObject({x: AsyncResult[java.util.Set[JsonObject]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JsonObject],scala.collection.mutable.Set[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetComplexJsonObject(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetComplexJsonObject({x: AsyncResult[java.util.Set[JsonObject]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JsonObject],scala.collection.mutable.Set[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetJsonArray(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetJsonArray({x: AsyncResult[java.util.Set[JsonArray]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JsonArray],scala.collection.mutable.Set[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetComplexJsonArray(listHandler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.core.json.JsonArray]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetComplexJsonArray({x: AsyncResult[java.util.Set[JsonArray]] => listHandler.handle(AsyncResultWrapper[java.util.Set[JsonArray],scala.collection.mutable.Set[io.vertx.core.json.JsonArray]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithHandlerAsyncResultSetDataObject(setHandler: Handler[AsyncResult[scala.collection.mutable.Set[TestDataObject]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetDataObject({x: AsyncResult[java.util.Set[JTestDataObject]] => setHandler.handle(AsyncResultWrapper[java.util.Set[JTestDataObject],scala.collection.mutable.Set[TestDataObject]](x, a => a.asScala.map(x => TestDataObject(x))))})
  }

  def methodWithHandlerAsyncResultSetEnum(setHandler: Handler[AsyncResult[scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]]]):Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetEnum({x: AsyncResult[java.util.Set[TestEnum]] => setHandler.handle(AsyncResultWrapper[java.util.Set[TestEnum],scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum]](x, a => a.asScala.map(x => x)))})
  }

  def methodWithMapReturn(handler: Handler[String]):Map[String, String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapStringReturn(handler: Handler[String]):Map[String, String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapStringReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapLongReturn(handler: Handler[String]):Map[String, Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapLongReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapIntegerReturn(handler: Handler[String]):Map[String, Int] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapIntegerReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapShortReturn(handler: Handler[String]):Map[String, Short] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapShortReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapByteReturn(handler: Handler[String]):Map[String, Byte] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapByteReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapCharacterReturn(handler: Handler[String]):Map[String, Char] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapCharacterReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapBooleanReturn(handler: Handler[String]):Map[String, Boolean] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapBooleanReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapFloatReturn(handler: Handler[String]):Map[String, Float] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapFloatReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapDoubleReturn(handler: Handler[String]):Map[String, Double] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapDoubleReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapJsonObjectReturn(handler: Handler[String]):Map[String, io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapJsonObjectReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapComplexJsonObjectReturn(handler: Handler[String]):Map[String, io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapComplexJsonObjectReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapJsonArrayReturn(handler: Handler[String]):Map[String, io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapJsonArrayReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithMapComplexJsonArrayReturn(handler: Handler[String]):Map[String, io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapComplexJsonArrayReturn({x: java.lang.String => handler.handle(x)}).asScala.mapValues(x => x)
  }

  def methodWithListStringReturn():scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListStringReturn().asScala.map(x => x)
  }

  def methodWithListLongReturn():scala.collection.mutable.Buffer[Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListLongReturn().asScala.map(x => x)
  }

  def methodWithListVertxGenReturn():scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListVertxGenReturn().asScala.map(x => RefedInterface1(x))
  }

  def methodWithListJsonObjectReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithListComplexJsonObjectReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListComplexJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithListJsonArrayReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithListComplexJsonArrayReturn():scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListComplexJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithListDataObjectReturn():scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListEnumReturn():scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListEnumReturn().asScala.map(x => x)
  }

  def methodWithSetStringReturn():scala.collection.mutable.Set[String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetStringReturn().asScala.map(x => x)
  }

  def methodWithSetLongReturn():scala.collection.mutable.Set[Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetLongReturn().asScala.map(x => x)
  }

  def methodWithSetVertxGenReturn():scala.collection.mutable.Set[RefedInterface1] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetVertxGenReturn().asScala.map(x => RefedInterface1(x))
  }

  def methodWithSetJsonObjectReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithSetComplexJsonObjectReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetComplexJsonObjectReturn().asScala.map(x => x)
  }

  def methodWithSetJsonArrayReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithSetComplexJsonArrayReturn():scala.collection.mutable.Set[io.vertx.core.json.JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetComplexJsonArrayReturn().asScala.map(x => x)
  }

  def methodWithSetDataObjectReturn():scala.collection.mutable.Set[TestDataObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithSetEnumReturn():scala.collection.mutable.Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetEnumReturn().asScala.map(x => x)
  }

}

  object CollectionTCK{
    def apply(asJava: JCollectionTCK) = new CollectionTCK(asJava)  
  //static methods
  }
