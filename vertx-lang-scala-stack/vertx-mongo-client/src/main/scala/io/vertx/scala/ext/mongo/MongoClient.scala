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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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
import io.vertx.ext.mongo.{UpdateOptions => JUpdateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo.{MongoClientUpdateResult => JMongoClientUpdateResult}

/**
  * A Vert.x service used to interact with MongoDB server instances.
  * 
  * Some of the operations might change <i>_id</i> field of passed  document.
  */
class MongoClient(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def save(collection: String,document: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String],document,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def saveWithOptions(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def insert(collection: String,document: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String],document,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def insertWithOptions(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  def update(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def updateCollection(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  def updateWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def updateCollectionWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  def replace(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def replaceDocuments(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  def replaceWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def replaceDocumentsWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  def find(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
    this
  }

  def findBatch(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findWithOptions(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions,resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,{x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala.map(x => x)))})
    this
  }

  def findBatchWithOptions(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOne(collection: String,query: io.vertx.core.json.JsonObject,fields: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String],query,fields,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndUpdate(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndUpdateWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String],query,update,findOptions.asJava,updateOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndReplace(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndReplaceWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,findOptions.asJava,updateOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndDelete(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def findOneAndDeleteWithOptions(collection: String,query: io.vertx.core.json.JsonObject,findOptions: FindOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String],query,findOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def count(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Long]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  def remove(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def removeDocuments(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  def removeWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def removeDocumentsWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  def removeOne(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def removeDocument(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  def removeOneWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def removeDocumentWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  def createCollection(collectionName: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def getCollections(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].getCollections({x: AsyncResult[java.util.List[java.lang.String]] => resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  def dropCollection(collection: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createIndex(collection: String,key: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String],key,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def createIndexWithOptions(collection: String,key: io.vertx.core.json.JsonObject,options: IndexOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String],key,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def listIndexes(collection: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  def dropIndex(collection: String,indexName: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String],indexName.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def runCommand(commandName: String,command: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String],command,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  def distinct(collection: String,fieldName: String,resultClassname: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  def distinctBatch(collection: String,fieldName: String,resultClassname: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

//default methods
//basic methods
  def close():Unit = {
    asJava.asInstanceOf[JMongoClient].close()
  }

//future methods
    def saveFuture(collection: String,document: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String],document,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def saveWithOptionsFuture(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def insertFuture(collection: String,document: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String],document,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def insertWithOptionsFuture(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => if (x == null) null.asInstanceOf[String] else x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateCollectionFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => if (x == null) null.asInstanceOf[MongoClientUpdateResult] else MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateCollectionWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => if (x == null) null.asInstanceOf[MongoClientUpdateResult] else MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def replaceFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def replaceDocumentsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => if (x == null) null.asInstanceOf[MongoClientUpdateResult] else MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def replaceWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def replaceDocumentsWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => if (x == null) null.asInstanceOf[MongoClientUpdateResult] else MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] else x.asScala.map(x => x))
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findBatchFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions):scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] else x.asScala.map(x => x))
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findBatchWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneFuture(collection: String,query: io.vertx.core.json.JsonObject,fields: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String],query,fields,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndUpdateFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndUpdateWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String],query,update,findOptions.asJava,updateOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndReplaceFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndReplaceWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,findOptions.asJava,updateOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndDeleteFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def findOneAndDeleteWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,findOptions: FindOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String],query,findOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def countFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => if (x == null) null.asInstanceOf[Long] else x.asInstanceOf[Long])
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeDocumentsFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => if (x == null) null.asInstanceOf[MongoClientDeleteResult] else MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeDocumentsWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => if (x == null) null.asInstanceOf[MongoClientDeleteResult] else MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeOneFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeDocumentFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => if (x == null) null.asInstanceOf[MongoClientDeleteResult] else MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeOneWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def removeDocumentWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => if (x == null) null.asInstanceOf[MongoClientDeleteResult] else MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def createCollectionFuture(collectionName: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def getCollectionsFuture():scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[String]] else x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JMongoClient].getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def dropCollectionFuture(collection: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def createIndexFuture(collection: String,key: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String],key,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def createIndexWithOptionsFuture(collection: String,key: io.vertx.core.json.JsonObject,options: IndexOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String],key,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def listIndexesFuture(collection: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonArray] else x)
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def dropIndexFuture(collection: String,indexName: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String],indexName.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def runCommandFuture(commandName: String,command: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String],command,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def distinctFuture(collection: String,fieldName: String,resultClassname: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonArray] else x)
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def distinctBatchFuture(collection: String,fieldName: String,resultClassname: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => if (x == null) null.asInstanceOf[io.vertx.core.json.JsonObject] else x)
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object MongoClient{
    def apply(asJava: JMongoClient) = new MongoClient(asJava)  
  //static methods
    def createNonShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):MongoClient = {
      MongoClient(JMongoClient.createNonShared(vertx.asJava.asInstanceOf[JVertx],config))
    }

    def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject,dataSourceName: String):MongoClient = {
      MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx],config,dataSourceName.asInstanceOf[java.lang.String]))
    }

    def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):MongoClient = {
      MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx],config))
    }

  }
