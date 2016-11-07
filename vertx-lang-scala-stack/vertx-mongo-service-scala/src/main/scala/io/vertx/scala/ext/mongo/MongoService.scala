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

package io.vertx.scala.ext.mongo

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.{MongoService => JMongoService}
import io.vertx.ext.mongo.{MongoClientDeleteResult => JMongoClientDeleteResult}
import io.vertx.scala.ext.mongo.MongoClientDeleteResult
import io.vertx.ext.mongo.WriteOption
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.{IndexOptions => JIndexOptions}
import io.vertx.scala.ext.mongo.IndexOptions
import io.vertx.ext.mongo.{FindOptions => JFindOptions}
import io.vertx.scala.ext.mongo.FindOptions
import io.vertx.core.json.JsonObject
import io.vertx.ext.mongo.{MongoClientUpdateResult => JMongoClientUpdateResult}
import io.vertx.scala.ext.mongo.MongoClientUpdateResult
import io.vertx.ext.mongo.{UpdateOptions => JUpdateOptions}
import io.vertx.scala.ext.mongo.UpdateOptions

/**
  */
class MongoService(private val _asJava: JMongoService) 
    extends  {

  def asJava: JMongoService = _asJava

  def saveFuture(collection: String, document: JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.save(collection, document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def saveWithOptionsFuture(collection: String, document: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.saveWithOptions(collection, document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def insertFuture(collection: String, document: JsonObject): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.insert(collection, document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def insertWithOptionsFuture(collection: String, document: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String,String]((x => x))
    _asJava.insertWithOptions(collection, document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def updateFuture(collection: String, query: JsonObject, update: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.update(collection, query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def updateCollectionFuture(collection: String, query: JsonObject, update: JsonObject): concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult,MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.updateCollection(collection, query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def updateWithOptionsFuture(collection: String, query: JsonObject, update: JsonObject, options: UpdateOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.updateWithOptions(collection, query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def updateCollectionWithOptionsFuture(collection: String, query: JsonObject, update: JsonObject, options: UpdateOptions): concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult,MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.updateCollectionWithOptions(collection, query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceFuture(collection: String, query: JsonObject, replace: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.replace(collection, query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceDocumentsFuture(collection: String, query: JsonObject, replace: JsonObject): concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult,MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.replaceDocuments(collection, query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceWithOptionsFuture(collection: String, query: JsonObject, replace: JsonObject, options: UpdateOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.replaceWithOptions(collection, query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceDocumentsWithOptionsFuture(collection: String, query: JsonObject, replace: JsonObject, options: UpdateOptions): concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult,MongoClientUpdateResult]((x => io.vertx.scala.ext.mongo.MongoClientUpdateResult(x)))
    _asJava.replaceDocumentsWithOptions(collection, query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findFuture(collection: String, query: JsonObject): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.find(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findBatchFuture(collection: String, query: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findBatch(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findWithOptionsFuture(collection: String, query: JsonObject, options: FindOptions): concurrent.Future[scala.collection.mutable.Buffer[JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[io.vertx.core.json.JsonObject],scala.collection.mutable.Buffer[JsonObject]]((x => if (x == null) null else x.asScala))
    _asJava.findWithOptions(collection, query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findBatchWithOptionsFuture(collection: String, query: JsonObject, options: FindOptions): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findBatchWithOptions(collection, query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneFuture(collection: String, query: JsonObject, fields: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOne(collection, query, fields, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndUpdateFuture(collection: String, query: JsonObject, update: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndUpdate(collection, query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndUpdateWithOptionsFuture(collection: String, query: JsonObject, update: JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndUpdateWithOptions(collection, query, update, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndReplaceFuture(collection: String, query: JsonObject, replace: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndReplace(collection, query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndReplaceWithOptionsFuture(collection: String, query: JsonObject, update: JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndReplaceWithOptions(collection, query, update, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndDeleteFuture(collection: String, query: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndDelete(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def findOneAndDeleteWithOptionsFuture(collection: String, query: JsonObject, findOptions: FindOptions): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.findOneAndDeleteWithOptions(collection, query, findOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def countFuture(collection: String, query: JsonObject): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.count(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeFuture(collection: String, query: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.remove(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeDocumentsFuture(collection: String, query: JsonObject): concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult,MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocuments(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeWithOptionsFuture(collection: String, query: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeDocumentsWithOptionsFuture(collection: String, query: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult,MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocumentsWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeOneFuture(collection: String, query: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeOne(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeDocumentFuture(collection: String, query: JsonObject): concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult,MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocument(collection, query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeOneWithOptionsFuture(collection: String, query: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.removeOneWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeDocumentWithOptionsFuture(collection: String, query: JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult,MongoClientDeleteResult]((x => io.vertx.scala.ext.mongo.MongoClientDeleteResult(x)))
    _asJava.removeDocumentWithOptions(collection, query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def createCollectionFuture(collectionName: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createCollection(collectionName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getCollectionsFuture(): concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]]((x => if (x == null) null else x.asScala))
    _asJava.getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def dropCollectionFuture(collection: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.dropCollection(collection, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def createIndexFuture(collection: String, key: JsonObject): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createIndex(collection, key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def createIndexWithOptionsFuture(collection: String, key: JsonObject, options: IndexOptions): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.createIndexWithOptions(collection, key, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def listIndexesFuture(collection: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.listIndexes(collection, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def dropIndexFuture(collection: String, indexName: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.dropIndex(collection, indexName, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def runCommandFuture(commandName: String, command: JsonObject): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.runCommand(commandName, command, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def distinctFuture(collection: String, fieldName: String, resultClassname: String): concurrent.Future[JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray,JsonArray]((x => x))
    _asJava.distinct(collection, fieldName, resultClassname, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def distinctBatchFuture(collection: String, fieldName: String, resultClassname: String): concurrent.Future[JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject,JsonObject]((x => x))
    _asJava.distinctBatch(collection, fieldName, resultClassname, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def close(): Unit = {
    _asJava.close()
  }

}

object MongoService {

  def apply(_asJava: JMongoService): MongoService =
    new MongoService(_asJava)

  def createEventBusProxy(vertx: Vertx, address: String): MongoService = {
    MongoService.apply(io.vertx.ext.mongo.MongoService.createEventBusProxy(vertx.asJava.asInstanceOf[JVertx], address))
  }

}
