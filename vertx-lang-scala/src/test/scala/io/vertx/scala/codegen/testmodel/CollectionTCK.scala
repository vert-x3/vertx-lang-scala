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
import io.vertx.codegen.testmodel.{CollectionTCK => JCollectionTCK}
import io.vertx.codegen.testmodel.{TestDataObject => JTestDataObject}
import io.vertx.codegen.testmodel.{RefedInterface1 => JRefedInterface1}
import io.vertx.codegen.testmodel.{RefedInterface2 => JRefedInterface2}
import io.vertx.core.json.JsonArray
import io.vertx.codegen.testmodel.TestEnum
import io.vertx.core.json.JsonObject

/**
  */
class CollectionTCK(private val _asJava: JCollectionTCK) {

  def asJava: JCollectionTCK = _asJava

  def methodWithListParams(listString: scala.collection.mutable.Buffer[String], listByte: scala.collection.mutable.Buffer[Byte], listShort: scala.collection.mutable.Buffer[Short], listInt: scala.collection.mutable.Buffer[Int], listLong: scala.collection.mutable.Buffer[Long], listJsonObject: scala.collection.mutable.Buffer[JsonObject], listJsonArray: scala.collection.mutable.Buffer[JsonArray], listVertxGen: scala.collection.mutable.Buffer[RefedInterface1], listDataObject: scala.collection.mutable.Buffer[TestDataObject], listEnum: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    _asJava.methodWithListParams(listString.map(x => if (x == null) null else x:java.lang.String).asJava, listByte.map(x => if (x == null) null else x:java.lang.Byte).asJava, listShort.map(x => if (x == null) null else x:java.lang.Short).asJava, listInt.map(x => if (x == null) null else x:java.lang.Integer).asJava, listLong.map(x => if (x == null) null else x:java.lang.Long).asJava, listJsonObject.map(x => if (x == null) null else x:io.vertx.core.json.JsonObject).asJava, listJsonArray.map(x => if (x == null) null else x:io.vertx.core.json.JsonArray).asJava, listVertxGen.map(x => if (x == null) null else x.asJava).asJava, listDataObject.map(x => if (x == null) null else x.asJava).asJava, listEnum.map(x => if (x == null) null else x:io.vertx.codegen.testmodel.TestEnum).asJava)
  }

  def methodWithSetParams(setString: Set[String], setByte: Set[Byte], setShort: Set[Short], setInt: Set[Int], setLong: Set[Long], setJsonObject: Set[JsonObject], setJsonArray: Set[JsonArray], setVertxGen: Set[RefedInterface1], setDataObject: Set[TestDataObject], setEnum: Set[io.vertx.codegen.testmodel.TestEnum]): Unit = {
    _asJava.methodWithSetParams(setString.map(x => if (x == null) null else x:java.lang.String).asJava, setByte.map(x => if (x == null) null else x:java.lang.Byte).asJava, setShort.map(x => if (x == null) null else x:java.lang.Short).asJava, setInt.map(x => if (x == null) null else x:java.lang.Integer).asJava, setLong.map(x => if (x == null) null else x:java.lang.Long).asJava, setJsonObject.map(x => if (x == null) null else x:io.vertx.core.json.JsonObject).asJava, setJsonArray.map(x => if (x == null) null else x:io.vertx.core.json.JsonArray).asJava, setVertxGen.map(x => if (x == null) null else x.asJava).asJava, setDataObject.map(x => if (x == null) null else x.asJava).asJava, setEnum.map(x => if (x == null) null else x:io.vertx.codegen.testmodel.TestEnum).asJava)
  }

  def methodWithMapParams(mapString: Map[String, String], mapByte: Map[String, Byte], mapShort: Map[String, Short], mapInt: Map[String, Int], mapLong: Map[String, Long], mapJsonObject: Map[String, JsonObject], mapJsonArray: Map[String, JsonArray], mapVertxGen: Map[String, RefedInterface1]): Unit = {
    _asJava.methodWithMapParams(mapString.map(kv => (kv._1:java.lang.String, kv._2:java.lang.String)).asJava, mapByte.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Byte)).asJava, mapShort.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Short)).asJava, mapInt.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Integer)).asJava, mapLong.map(kv => (kv._1:java.lang.String, kv._2:java.lang.Long)).asJava, mapJsonObject.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonObject)).asJava, mapJsonArray.map(kv => (kv._1:java.lang.String, kv._2:io.vertx.core.json.JsonArray)).asJava, mapVertxGen.map(kv => (kv._1:java.lang.String, if (kv._2 != null) kv._2.asJava.asInstanceOf[JRefedInterface1] else null)).asJava)
  }

  def methodWithHandlerListAndSet(listStringHandler: scala.collection.mutable.Buffer[String] => Unit, listIntHandler: scala.collection.mutable.Buffer[Int] => Unit, setStringHandler: Set[String] => Unit, setIntHandler: Set[Int] => Unit): Unit = {
    _asJava.methodWithHandlerListAndSet(funcToMappedHandler[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x != null) x.asScala else null)(listStringHandler), funcToMappedHandler[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x != null) x.asScala.map(x => x:Int) else null)(listIntHandler), funcToMappedHandler[java.util.Set[java.lang.String], Set[String]](x => if (x != null) x.asScala.toSet else null)(setStringHandler), funcToMappedHandler[java.util.Set[java.lang.Integer], Set[Int]](x => if (x != null) x.asScala.map(x => x:Int).toSet else null)(setIntHandler))
  }

  def methodWithHandlerAsyncResultListStringFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListString(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListIntegerFuture(): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asScala.map(x => x:Int)))
    _asJava.methodWithHandlerAsyncResultListInteger(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerListVertxGen(listHandler: scala.collection.mutable.Buffer[RefedInterface1] => Unit): Unit = {
    _asJava.methodWithHandlerListVertxGen(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface1], scala.collection.mutable.Buffer[RefedInterface1]](x => if (x != null) x.asScala.map(RefedInterface1.apply) else null)(listHandler))
  }

  def methodWithHandlerListAbstractVertxGen(listHandler: scala.collection.mutable.Buffer[RefedInterface2] => Unit): Unit = {
    _asJava.methodWithHandlerListAbstractVertxGen(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.RefedInterface2], scala.collection.mutable.Buffer[RefedInterface2]](x => if (x != null) x.asScala.map(RefedInterface2.apply) else null)(listHandler))
  }

  def methodWithHandlerListJsonObject(listHandler: scala.collection.mutable.Buffer[JsonObject] => Unit): Unit = {
    _asJava.methodWithHandlerListJsonObject(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asScala else null)(listHandler))
  }

  def methodWithHandlerListComplexJsonObject(listHandler: scala.collection.mutable.Buffer[JsonObject] => Unit): Unit = {
    _asJava.methodWithHandlerListComplexJsonObject(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonObject], scala.collection.mutable.Buffer[JsonObject]](x => if (x != null) x.asScala else null)(listHandler))
  }

  def methodWithHandlerListJsonArray(listHandler: scala.collection.mutable.Buffer[JsonArray] => Unit): Unit = {
    _asJava.methodWithHandlerListJsonArray(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asScala else null)(listHandler))
  }

  def methodWithHandlerListComplexJsonArray(listHandler: scala.collection.mutable.Buffer[JsonArray] => Unit): Unit = {
    _asJava.methodWithHandlerListComplexJsonArray(funcToMappedHandler[java.util.List[io.vertx.core.json.JsonArray], scala.collection.mutable.Buffer[JsonArray]](x => if (x != null) x.asScala else null)(listHandler))
  }

  def methodWithHandlerListDataObject(listHandler: scala.collection.mutable.Buffer[TestDataObject] => Unit): Unit = {
    _asJava.methodWithHandlerListDataObject(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestDataObject], scala.collection.mutable.Buffer[TestDataObject]](x => if (x != null) x.asScala.map(x => TestDataObject(x)) else null)(listHandler))
  }

  def methodWithHandlerListEnum(listHandler: scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    _asJava.methodWithHandlerListEnum(funcToMappedHandler[java.util.List[io.vertx.codegen.testmodel.TestEnum], scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asScala else null)(listHandler))
  }

  def methodWithHandlerAsyncResultSetStringFuture(): concurrent.Future[Set[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[java.lang.String],Set[String]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetString(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetIntegerFuture(): concurrent.Future[Set[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[java.lang.Integer],Set[Int]]((x => if (x == null) null else x.asScala.map(x => x:Int).toSet))
    _asJava.methodWithHandlerAsyncResultSetInteger(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerSetVertxGen(listHandler: Set[RefedInterface1] => Unit): Unit = {
    _asJava.methodWithHandlerSetVertxGen(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1], Set[RefedInterface1]](x => if (x != null) x.asScala.map(RefedInterface1.apply).toSet else null)(listHandler))
  }

  def methodWithHandlerSetAbstractVertxGen(listHandler: Set[RefedInterface2] => Unit): Unit = {
    _asJava.methodWithHandlerSetAbstractVertxGen(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2], Set[RefedInterface2]](x => if (x != null) x.asScala.map(RefedInterface2.apply).toSet else null)(listHandler))
  }

  def methodWithHandlerSetJsonObject(listHandler: Set[JsonObject] => Unit): Unit = {
    _asJava.methodWithHandlerSetJsonObject(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asScala.toSet else null)(listHandler))
  }

  def methodWithHandlerSetComplexJsonObject(listHandler: Set[JsonObject] => Unit): Unit = {
    _asJava.methodWithHandlerSetComplexJsonObject(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonObject], Set[JsonObject]](x => if (x != null) x.asScala.toSet else null)(listHandler))
  }

  def methodWithHandlerSetJsonArray(listHandler: Set[JsonArray] => Unit): Unit = {
    _asJava.methodWithHandlerSetJsonArray(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asScala.toSet else null)(listHandler))
  }

  def methodWithHandlerSetComplexJsonArray(setHandler: Set[JsonArray] => Unit): Unit = {
    _asJava.methodWithHandlerSetComplexJsonArray(funcToMappedHandler[java.util.Set[io.vertx.core.json.JsonArray], Set[JsonArray]](x => if (x != null) x.asScala.toSet else null)(setHandler))
  }

  def methodWithHandlerSetDataObject(setHandler: Set[TestDataObject] => Unit): Unit = {
    _asJava.methodWithHandlerSetDataObject(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestDataObject], Set[TestDataObject]](x => if (x != null) x.asScala.map(x => TestDataObject(x)).toSet else null)(setHandler))
  }

  def methodWithHandlerSetEnum(setHandler: Set[io.vertx.codegen.testmodel.TestEnum] => Unit): Unit = {
    _asJava.methodWithHandlerSetEnum(funcToMappedHandler[java.util.Set[io.vertx.codegen.testmodel.TestEnum], Set[io.vertx.codegen.testmodel.TestEnum]](x => if (x != null) x.asScala.toSet else null)(setHandler))
  }

  def methodWithHandlerAsyncResultListVertxGenFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.codegen.testmodel.RefedInterface1],scala.collection.mutable.Buffer[RefedInterface1]]((x => if (x == null) null else x.asScala.map(RefedInterface1.apply)))
    _asJava.methodWithHandlerAsyncResultListVertxGen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListAbstractVertxGenFuture(): concurrent.Future[scala.collection.mutable.Buffer[RefedInterface2]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.codegen.testmodel.RefedInterface2],scala.collection.mutable.Buffer[RefedInterface2]]((x => if (x == null) null else x.asScala.map(RefedInterface2.apply)))
    _asJava.methodWithHandlerAsyncResultListAbstractVertxGen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListJsonObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListComplexJsonObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListComplexJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListJsonArrayFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonArray],scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListComplexJsonArrayFuture(): concurrent.Future[scala.collection.mutable.Buffer[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonArray],scala.collection.mutable.Buffer[JsonArray]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListComplexJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListDataObjectFuture(): concurrent.Future[scala.collection.mutable.Buffer[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.codegen.testmodel.TestDataObject],scala.collection.mutable.Buffer[TestDataObject]]((x => if (x == null) null else x.asScala.map(x => TestDataObject(x))))
    _asJava.methodWithHandlerAsyncResultListDataObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultListEnumFuture(): concurrent.Future[scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.codegen.testmodel.TestEnum],scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asScala))
    _asJava.methodWithHandlerAsyncResultListEnum(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetVertxGenFuture(): concurrent.Future[Set[RefedInterface1]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.codegen.testmodel.RefedInterface1],Set[RefedInterface1]]((x => if (x == null) null else x.asScala.map(RefedInterface1.apply).toSet))
    _asJava.methodWithHandlerAsyncResultSetVertxGen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetAbstractVertxGenFuture(): concurrent.Future[Set[RefedInterface2]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.codegen.testmodel.RefedInterface2],Set[RefedInterface2]]((x => if (x == null) null else x.asScala.map(RefedInterface2.apply).toSet))
    _asJava.methodWithHandlerAsyncResultSetAbstractVertxGen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetJsonObjectFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.core.json.JsonObject],Set[JsonObject]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonObjectFuture(): concurrent.Future[Set[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.core.json.JsonObject],Set[JsonObject]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetComplexJsonObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetJsonArrayFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.core.json.JsonArray],Set[JsonArray]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetComplexJsonArrayFuture(): concurrent.Future[Set[JsonArray]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.core.json.JsonArray],Set[JsonArray]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetComplexJsonArray(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetDataObjectFuture(): concurrent.Future[Set[TestDataObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.codegen.testmodel.TestDataObject],Set[TestDataObject]]((x => if (x == null) null else x.asScala.map(x => TestDataObject(x)).toSet))
    _asJava.methodWithHandlerAsyncResultSetDataObject(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithHandlerAsyncResultSetEnumFuture(): concurrent.Future[Set[io.vertx.codegen.testmodel.TestEnum]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[io.vertx.codegen.testmodel.TestEnum],Set[io.vertx.codegen.testmodel.TestEnum]]((x => if (x == null) null else x.asScala.toSet))
    _asJava.methodWithHandlerAsyncResultSetEnum(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def methodWithMapReturn(handler: String => Unit): Map[String, String] = {
    _asJava.methodWithMapReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithMapStringReturn(handler: String => Unit): Map[String, String] = {
    _asJava.methodWithMapStringReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithMapLongReturn(handler: String => Unit): Map[String, Long] = {
    _asJava.methodWithMapLongReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Long)).toMap
  }

  def methodWithMapIntegerReturn(handler: String => Unit): Map[String, Int] = {
    _asJava.methodWithMapIntegerReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Int)).toMap
  }

  def methodWithMapShortReturn(handler: String => Unit): Map[String, Short] = {
    _asJava.methodWithMapShortReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Short)).toMap
  }

  def methodWithMapByteReturn(handler: String => Unit): Map[String, Byte] = {
    _asJava.methodWithMapByteReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Byte)).toMap
  }

  def methodWithMapCharacterReturn(handler: String => Unit): Map[String, Char] = {
    _asJava.methodWithMapCharacterReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Char)).toMap
  }

  def methodWithMapBooleanReturn(handler: String => Unit): Map[String, Boolean] = {
    _asJava.methodWithMapBooleanReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Boolean)).toMap
  }

  def methodWithMapFloatReturn(handler: String => Unit): Map[String, Float] = {
    _asJava.methodWithMapFloatReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Float)).toMap
  }

  def methodWithMapDoubleReturn(handler: String => Unit): Map[String, Double] = {
    _asJava.methodWithMapDoubleReturn(funcToHandler[java.lang.String](handler)).asScala.map(kv => (kv._1, kv._2: Double)).toMap
  }

  def methodWithMapJsonObjectReturn(handler: String => Unit): Map[String, JsonObject] = {
    _asJava.methodWithMapJsonObjectReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithMapComplexJsonObjectReturn(handler: String => Unit): Map[String, JsonObject] = {
    _asJava.methodWithMapComplexJsonObjectReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithMapJsonArrayReturn(handler: String => Unit): Map[String, JsonArray] = {
    _asJava.methodWithMapJsonArrayReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithMapComplexJsonArrayReturn(handler: String => Unit): Map[String, JsonArray] = {
    _asJava.methodWithMapComplexJsonArrayReturn(funcToHandler[java.lang.String](handler)).asScala.toMap
  }

  def methodWithListStringReturn(): scala.collection.mutable.Buffer[String] = {
    _asJava.methodWithListStringReturn().asScala.map(x => x:String)
  }

  def methodWithListLongReturn(): scala.collection.mutable.Buffer[Long] = {
    _asJava.methodWithListLongReturn().asScala.map(x => x:Long)
  }

  def methodWithListVertxGenReturn(): scala.collection.mutable.Buffer[RefedInterface1] = {
    _asJava.methodWithListVertxGenReturn().asScala.map(RefedInterface1.apply)
  }

  def methodWithListJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    _asJava.methodWithListJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListComplexJsonObjectReturn(): scala.collection.mutable.Buffer[JsonObject] = {
    _asJava.methodWithListComplexJsonObjectReturn().asScala.map(x => x:JsonObject)
  }

  def methodWithListJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    _asJava.methodWithListJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListComplexJsonArrayReturn(): scala.collection.mutable.Buffer[JsonArray] = {
    _asJava.methodWithListComplexJsonArrayReturn().asScala.map(x => x:JsonArray)
  }

  def methodWithListDataObjectReturn(): scala.collection.mutable.Buffer[TestDataObject] = {
    _asJava.methodWithListDataObjectReturn().asScala.map(x => TestDataObject(x))
  }

  def methodWithListEnumReturn(): scala.collection.mutable.Buffer[io.vertx.codegen.testmodel.TestEnum] = {
    _asJava.methodWithListEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum)
  }

  def methodWithSetStringReturn(): Set[String] = {
    _asJava.methodWithSetStringReturn().asScala.map(x => x:String).toSet
  }

  def methodWithSetLongReturn(): Set[Long] = {
    _asJava.methodWithSetLongReturn().asScala.map(x => x:Long).toSet
  }

  def methodWithSetVertxGenReturn(): Set[RefedInterface1] = {
    _asJava.methodWithSetVertxGenReturn().asScala.map(RefedInterface1.apply).toSet
  }

  def methodWithSetJsonObjectReturn(): Set[JsonObject] = {
    _asJava.methodWithSetJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetComplexJsonObjectReturn(): Set[JsonObject] = {
    _asJava.methodWithSetComplexJsonObjectReturn().asScala.map(x => x:JsonObject).toSet
  }

  def methodWithSetJsonArrayReturn(): Set[JsonArray] = {
    _asJava.methodWithSetJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetComplexJsonArrayReturn(): Set[JsonArray] = {
    _asJava.methodWithSetComplexJsonArrayReturn().asScala.map(x => x:JsonArray).toSet
  }

  def methodWithSetDataObjectReturn(): Set[TestDataObject] = {
    _asJava.methodWithSetDataObjectReturn().asScala.map(x => TestDataObject(x)).toSet
  }

  def methodWithSetEnumReturn(): Set[io.vertx.codegen.testmodel.TestEnum] = {
    _asJava.methodWithSetEnumReturn().asScala.map(x => x:io.vertx.codegen.testmodel.TestEnum).toSet
  }

}

object CollectionTCK {

  def apply(_asJava: JCollectionTCK): CollectionTCK =
    new CollectionTCK(_asJava)

}
