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
import io.vertx.codegen.testmodel.{CollectionTCK => JCollectionTCK}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject

/**
  */
class CollectionTCK(private val _asJava: Object) {

  def asJava: Object = _asJava

  def methodWithListParams(listString: scala.collection.mutable.Buffer[String], listByte: scala.collection.mutable.Buffer[Byte], listShort: scala.collection.mutable.Buffer[Short], listInt: scala.collection.mutable.Buffer[Int], listLong: scala.collection.mutable.Buffer[Long], listJsonObject: scala.collection.mutable.Buffer[JsonObject], listJsonArray: scala.collection.mutable.Buffer[JsonArray], listVertxGen: scala.collection.mutable.Buffer[RefedInterface1], listDataObject: scala.collection.mutable.Buffer[TestDataObject], listEnum: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListParams(listString.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.List[java.lang.String]], listByte.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.List[java.lang.Byte]], listShort.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.List[java.lang.Short]], listInt.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.List[java.lang.Integer]], listLong.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.List[java.lang.Long]], listJsonObject.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]], listJsonArray.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]], listVertxGen.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]], listDataObject.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]], listEnum.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithSetParams(setString: Set[String], setByte: Set[Byte], setShort: Set[Short], setInt: Set[Int], setLong: Set[Long], setJsonObject: Set[JsonObject], setJsonArray: Set[JsonArray], setVertxGen: Set[RefedInterface1], setDataObject: Set[TestDataObject], setEnum: Set[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetParams(setString.map(x => x:java.lang.String).asJava.asInstanceOf[java.util.Set[java.lang.String]], setByte.map(x => x:java.lang.Byte).asJava.asInstanceOf[java.util.Set[java.lang.Byte]], setShort.map(x => x:java.lang.Short).asJava.asInstanceOf[java.util.Set[java.lang.Short]], setInt.map(x => x:java.lang.Integer).asJava.asInstanceOf[java.util.Set[java.lang.Integer]], setLong.map(x => x:java.lang.Long).asJava.asInstanceOf[java.util.Set[java.lang.Long]], setJsonObject.map(x => x:io.vertx.core.json.JsonObject).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]], setJsonArray.map(x => x:io.vertx.core.json.JsonArray).asJava.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]], setVertxGen.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.RefedInterface1]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]], setDataObject.map(x => if (x == null) null else x.asJava.asInstanceOf[io.vertx.codegen.testmodel.TestDataObject]).asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]], setEnum.map(x => x:io.vertx.codegen.testmodel.TestEnum).asJava.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]])
  }

  def methodWithMapParams(mapString: Map[String, String], mapByte: Map[String, Byte], mapShort: Map[String, Short], mapInt: Map[String, Int], mapLong: Map[String, Long], mapJsonObject: Map[String, JsonObject], mapJsonArray: Map[String, JsonArray], mapVertxGen: Map[String, RefedInterface1]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapParams(mapString.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.String]], mapByte.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Byte]], mapShort.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Short]], mapInt.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Integer]], mapLong.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava.asInstanceOf[java.util.Map[java.lang.String,java.lang.Long]], mapJsonObject.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonObject]], mapJsonArray.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.core.json.JsonArray]], mapVertxGen.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava.asInstanceOf[java.util.Map[java.lang.String,io.vertx.codegen.testmodel.RefedInterface1]])
  }

  def methodWithHandlerListAndSet(listStringHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[String]], listIntHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[Int]], setStringHandler: io.vertx.core.Handler[Set[String]], setIntHandler: io.vertx.core.Handler[Set[Int]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListAndSet(funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.String]].asScala else null)(listStringHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.String]]], funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int) else null)(listIntHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[java.lang.Integer]]], funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet else null)(setStringHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.String]]], funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet else null)(setIntHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[java.lang.Integer]]])
  }

  def methodWithHandlerAsyncResultListStringFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.String]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListString(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListIntegerFuture(): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.List[java.lang.Integer]].asScala.map(x => x:Int)))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListInteger(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerListVertxGen(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListVertxGen(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply) else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithHandlerListAbstractVertxGen(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[RefedInterface2]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListAbstractVertxGen(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface2], scala.collection.mutable.Buffer[RefedInterface2]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]].asScala.map(RefedInterface2.apply) else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]]])
  }

  def methodWithHandlerListJsonObject(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListJsonObject(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerListComplexJsonObject(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListComplexJsonObject(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerListJsonArray(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListJsonArray(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerListComplexJsonArray(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[JsonArray]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListComplexJsonArray(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerListDataObject(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListDataObject(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)) else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithHandlerListEnum(listHandler: io.vertx.core.Handler[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerListEnum(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.List[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithHandlerAsyncResultSetStringFuture(): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[String]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.String]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetString(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.String]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetIntegerFuture(): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[Int]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[java.lang.Integer]].asScala.map(x => x:Int).toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetInteger(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[java.lang.Integer]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerSetVertxGen(listHandler: io.vertx.core.Handler[Set[RefedInterface1]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetVertxGen(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]])
  }

  def methodWithHandlerSetAbstractVertxGen(listHandler: io.vertx.core.Handler[Set[RefedInterface2]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetAbstractVertxGen(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2], Set[RefedInterface2]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]].asScala.map(RefedInterface2.apply).toSet else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]]])
  }

  def methodWithHandlerSetJsonObject(listHandler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetJsonObject(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerSetComplexJsonObject(listHandler: io.vertx.core.Handler[Set[JsonObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetComplexJsonObject(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonObject]]])
  }

  def methodWithHandlerSetJsonArray(listHandler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetJsonArray(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(listHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerSetComplexJsonArray(setHandler: io.vertx.core.Handler[Set[JsonArray]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetComplexJsonArray(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet else null)(setHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.core.json.JsonArray]]])
  }

  def methodWithHandlerSetDataObject(setHandler: io.vertx.core.Handler[Set[TestDataObject]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetDataObject(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet else null)(setHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]])
  }

  def methodWithHandlerSetEnum(setHandler: io.vertx.core.Handler[Set[io.vertx.codegen.testmodel.TestEnum]]): Unit = {
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerSetEnum(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet else null)(setHandler).asInstanceOf[io.vertx.core.Handler[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]])
  }

  def methodWithHandlerAsyncResultListVertxGenFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply)))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListVertxGen(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListAbstractVertxGenFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface2]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[RefedInterface2]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]].asScala.map(RefedInterface2.apply)))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListAbstractVertxGen(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.RefedInterface2]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListJsonObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListComplexJsonObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonObject]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListComplexJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListJsonArrayFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListComplexJsonArrayFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.core.json.JsonArray]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListComplexJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListDataObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x))))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListDataObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListEnumFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.List[io.vertx.codegen.testmodel.TestEnum]].asScala))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultListEnum(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.List[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetVertxGenFuture(): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface1]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]].asScala.map(RefedInterface1.apply).toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetVertxGen(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetAbstractVertxGenFuture(): concurrent.Future[Set[RefedInterface2]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[RefedInterface2]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]].asScala.map(RefedInterface2.apply).toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetAbstractVertxGen(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetJsonObjectFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonObjectFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonObject]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetComplexJsonObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetJsonArrayFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonArrayFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[JsonArray]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.core.json.JsonArray]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetComplexJsonArray(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.core.json.JsonArray]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetDataObjectFuture(): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[TestDataObject]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]].asScala.map(x => TestDataObject(x)).toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetDataObject(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestDataObject]]]])
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetEnumFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asInstanceOf[java.util.Set[io.vertx.codegen.testmodel.TestEnum]].asScala.toSet))
    asJava.asInstanceOf[JCollectionTCK].methodWithHandlerAsyncResultSetEnum(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.util.Set[io.vertx.codegen.testmodel.TestEnum]]]])
    promiseAndHandler._2.future
  }

  def methodWithMapReturn(handler: io.vertx.core.Handler[String]): Map[String, String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithMapStringReturn(handler: io.vertx.core.Handler[String]): Map[String, String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapStringReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithMapLongReturn(handler: io.vertx.core.Handler[String]): Map[String, Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapLongReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Long)).toMap
  }

  def methodWithMapIntegerReturn(handler: io.vertx.core.Handler[String]): Map[String, Int] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapIntegerReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Int)).toMap
  }

  def methodWithMapShortReturn(handler: io.vertx.core.Handler[String]): Map[String, Short] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapShortReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Short)).toMap
  }

  def methodWithMapByteReturn(handler: io.vertx.core.Handler[String]): Map[String, Byte] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapByteReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Byte)).toMap
  }

  def methodWithMapCharacterReturn(handler: io.vertx.core.Handler[String]): Map[String, Char] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapCharacterReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Char)).toMap
  }

  def methodWithMapBooleanReturn(handler: io.vertx.core.Handler[String]): Map[String, Boolean] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapBooleanReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Boolean)).toMap
  }

  def methodWithMapFloatReturn(handler: io.vertx.core.Handler[String]): Map[String, Float] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapFloatReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Float)).toMap
  }

  def methodWithMapDoubleReturn(handler: io.vertx.core.Handler[String]): Map[String, Double] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapDoubleReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.map(kv => (kv._1, kv._2: Double)).toMap
  }

  def methodWithMapJsonObjectReturn(handler: io.vertx.core.Handler[String]): Map[String, JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapJsonObjectReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithMapComplexJsonObjectReturn(handler: io.vertx.core.Handler[String]): Map[String, JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapComplexJsonObjectReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithMapJsonArrayReturn(handler: io.vertx.core.Handler[String]): Map[String, JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapJsonArrayReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithMapComplexJsonArrayReturn(handler: io.vertx.core.Handler[String]): Map[String, JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithMapComplexJsonArrayReturn(funcToMappedHandler[java.lang.String, String](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.String]]).asScala.toMap
  }

  def methodWithListStringReturn(): scala.collection.mutable.Buffer[String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListStringReturn().asScala.map(x => x:String)
  }

  def methodWithListLongReturn(): scala.collection.mutable.Buffer[Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListLongReturn().asScala.map(x => x:Long)
  }

  def methodWithListVertxGenReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListVertxGenReturn().asScala.map(RefedInterface1.apply)
  }

  def methodWithListJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListComplexJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListComplexJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListComplexJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListComplexJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListDataObjectReturn(): scala.collection.mutable.Buffer[TestDataObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithListEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum)
  }

  def methodWithSetStringReturn(): Set[String] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetStringReturn().asScala.map(x => x:String).toSet
  }

  def methodWithSetLongReturn(): Set[Long] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetLongReturn().asScala.map(x => x:Long).toSet
  }

  def methodWithSetVertxGenReturn(): Set[RefedInterface1] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetVertxGenReturn().asScala.map(RefedInterface1.apply).toSet
  }

  def methodWithSetJsonObjectReturn(): Set[JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetComplexJsonObjectReturn(): Set[JsonObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetComplexJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetJsonArrayReturn(): Set[JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetComplexJsonArrayReturn(): Set[JsonArray] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetComplexJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetDataObjectReturn(): Set[TestDataObject] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetDataObjectReturn().asScala.map(x => TestDataObject(x)).toSet
  }

  def methodWithSetEnumReturn(): Set[io.vertx.codegen.testmodel.TestEnum] = {
    asJava.asInstanceOf[JCollectionTCK].methodWithSetEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet
  }

}

object CollectionTCK {

  def apply(_asJava: Object): CollectionTCK =
    new CollectionTCK(_asJava)

}
