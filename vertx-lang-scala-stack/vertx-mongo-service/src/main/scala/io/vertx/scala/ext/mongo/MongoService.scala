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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.mongo.WriteOption
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.ext.mongo.{MongoClientDeleteResult => JMongoClientDeleteResult}
import io.vertx.ext.mongo.{FindOptions => JFindOptions}
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.{IndexOptions => JIndexOptions}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.{MongoService => JMongoService}
import io.vertx.ext.mongo.{UpdateOptions => JUpdateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo.{MongoClientUpdateResult => JMongoClientUpdateResult}

/**
  */
class MongoService(private val _asJava: Object)
    extends MongoClient(_asJava)  {


  override def save(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[String]]): MongoService = {
    asJava.asInstanceOf[JMongoService].save(collection.asInstanceOf[java.lang.String], document, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  override def saveWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[String]]): MongoService = {
    asJava.asInstanceOf[JMongoService].saveWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  override def insert(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[String]]): MongoService = {
    asJava.asInstanceOf[JMongoService].insert(collection.asInstanceOf[java.lang.String], document, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  override def insertWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[String]]): MongoService = {
    asJava.asInstanceOf[JMongoService].insertWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  override def update(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].update(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def updateCollection(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].updateCollection(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  override def updateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].updateWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def updateCollectionWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  override def replace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].replace(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def replaceDocuments(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].replaceDocuments(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  override def replaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].replaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def replaceDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  override def find(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]): MongoService = {
    asJava.asInstanceOf[JMongoService].find(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  override def findBatch(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findBatch(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, {x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  override def findBatchWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findBatchWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOne(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOne(collection.asInstanceOf[java.lang.String], query, fields, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndUpdate(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndUpdate(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndUpdateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndReplace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndReplace(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndReplaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndDelete(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndDelete(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def findOneAndDeleteWithOptions(collection: String, query: io.vertx.core.json.JsonObject, findOptions: FindOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String], query, findOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def count(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Long]]): MongoService = {
    asJava.asInstanceOf[JMongoService].count(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  override def remove(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].remove(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def removeDocuments(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeDocuments(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  override def removeWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def removeDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  override def removeOne(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeOne(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def removeDocument(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeDocument(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  override def removeOneWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeOneWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def removeDocumentWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoService = {
    asJava.asInstanceOf[JMongoService].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  override def createCollection(collectionName: String, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].createCollection(collectionName.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def getCollections(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): MongoService = {
    asJava.asInstanceOf[JMongoService].getCollections({x: AsyncResult[java.util.List[java.lang.String]] => resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  override def dropCollection(collection: String, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].dropCollection(collection.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def createIndex(collection: String, key: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].createIndex(collection.asInstanceOf[java.lang.String], key, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def createIndexWithOptions(collection: String, key: io.vertx.core.json.JsonObject, options: IndexOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].createIndexWithOptions(collection.asInstanceOf[java.lang.String], key, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def listIndexes(collection: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): MongoService = {
    asJava.asInstanceOf[JMongoService].listIndexes(collection.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  override def dropIndex(collection: String, indexName: String, resultHandler: Handler[AsyncResult[Unit]]): MongoService = {
    asJava.asInstanceOf[JMongoService].dropIndex(collection.asInstanceOf[java.lang.String], indexName.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  override def runCommand(commandName: String, command: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].runCommand(commandName.asInstanceOf[java.lang.String], command, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def distinct(collection: String, fieldName: String, resultClassname: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): MongoService = {
    asJava.asInstanceOf[JMongoService].distinct(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  override def distinctBatch(collection: String, fieldName: String, resultClassname: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoService = {
    asJava.asInstanceOf[JMongoService].distinctBatch(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  override def close(): Unit = {
    asJava.asInstanceOf[JMongoService].close()
  }

  override def saveFuture(collection: String, document: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoService].save(collection.asInstanceOf[java.lang.String], document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def saveWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoService].saveWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def insertFuture(collection: String, document: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoService].insert(collection.asInstanceOf[java.lang.String], document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def insertWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoService].insertWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def updateFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].update(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def updateCollectionFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoService].updateCollection(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def updateWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].updateWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def updateCollectionWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoService].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def replaceFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].replace(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def replaceDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoService].replaceDocuments(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def replaceWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].replaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def replaceDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoService].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoService].find(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findBatchFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findBatch(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions): scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoService].findWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findBatchWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findBatchWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneFuture(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOne(collection.asInstanceOf[java.lang.String], query, fields, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndUpdateFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndUpdate(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndUpdateWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndReplaceFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndReplace(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndReplaceWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndDeleteFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndDelete(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def findOneAndDeleteWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, findOptions: FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String], query, findOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def countFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JMongoService].count(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].remove(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoService].removeDocuments(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].removeWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoService].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeOneFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].removeOne(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeDocumentFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoService].removeDocument(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeOneWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].removeOneWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def removeDocumentWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoService].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def createCollectionFuture(collectionName: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].createCollection(collectionName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def getCollectionsFuture(): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JMongoService].getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def dropCollectionFuture(collection: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].dropCollection(collection.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def createIndexFuture(collection: String, key: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].createIndex(collection.asInstanceOf[java.lang.String], key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def createIndexWithOptionsFuture(collection: String, key: io.vertx.core.json.JsonObject, options: IndexOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].createIndexWithOptions(collection.asInstanceOf[java.lang.String], key, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def listIndexesFuture(collection: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoService].listIndexes(collection.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def dropIndexFuture(collection: String, indexName: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoService].dropIndex(collection.asInstanceOf[java.lang.String], indexName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def runCommandFuture(commandName: String, command: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].runCommand(commandName.asInstanceOf[java.lang.String], command, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def distinctFuture(collection: String, fieldName: String, resultClassname: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoService].distinct(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  override def distinctBatchFuture(collection: String, fieldName: String, resultClassname: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoService].distinctBatch(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MongoService {
  def apply(asJava: JMongoService) = new MongoService(asJava)  
  /**
    * Create a proxy to a service that is deployed somewhere on the event bus
    * @param vertx the Vert.x instance
    * @param address the address the service is listening on on the event bus
    * @return the service
    */
  def createEventBusProxy(vertx: Vertx, address: String): MongoService = {
    MongoService(JMongoService.createEventBusProxy(vertx.asJava.asInstanceOf[JVertx], address.asInstanceOf[java.lang.String]))
  }

}
