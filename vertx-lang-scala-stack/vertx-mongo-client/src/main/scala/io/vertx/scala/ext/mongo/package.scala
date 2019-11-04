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

package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.collection.JavaConverters._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.ext.mongo.{MongoGridFsClient => JMongoGridFsClient}
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams
import io.vertx.core.{Future => JFuture}
import io.vertx.ext.mongo.{GridFsUploadOptions => JGridFsUploadOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo.{GridFsDownloadOptions => JGridFsDownloadOptions}

package object mongo{


  type AggregateOptions = io.vertx.ext.mongo.AggregateOptions
  object AggregateOptions {
    def apply() = new AggregateOptions()
    def apply(json: JsonObject) = new AggregateOptions(json)
  }




  type BulkOperation = io.vertx.ext.mongo.BulkOperation
  object BulkOperation {
    
    def apply(json: JsonObject) = new BulkOperation(json)
  }




  type BulkWriteOptions = io.vertx.ext.mongo.BulkWriteOptions
  object BulkWriteOptions {
    def apply() = new BulkWriteOptions()
    def apply(json: JsonObject) = new BulkWriteOptions(json)
  }




  type FindOptions = io.vertx.ext.mongo.FindOptions
  object FindOptions {
    def apply() = new FindOptions()
    def apply(json: JsonObject) = new FindOptions(json)
  }




  type GridFsDownloadOptions = io.vertx.ext.mongo.GridFsDownloadOptions
  object GridFsDownloadOptions {
    def apply() = new GridFsDownloadOptions()
    def apply(json: JsonObject) = new GridFsDownloadOptions(json)
  }




  type GridFsUploadOptions = io.vertx.ext.mongo.GridFsUploadOptions
  object GridFsUploadOptions {
    def apply() = new GridFsUploadOptions()
    def apply(json: JsonObject) = new GridFsUploadOptions(json)
  }




  type IndexModel = io.vertx.ext.mongo.IndexModel
  object IndexModel {
    
    def apply(json: JsonObject) = new IndexModel(json)
  }




  type IndexOptions = io.vertx.ext.mongo.IndexOptions
  object IndexOptions {
    def apply() = new IndexOptions()
    def apply(json: JsonObject) = new IndexOptions(json)
  }




  /**
    * A Vert.x service used to interact with MongoDB server instances.
    * 
    * Some of the operations might change <i>_id</i> field of passed  document.
    */

  implicit class MongoClientScala(val asJava: io.vertx.ext.mongo.MongoClient) extends AnyVal {


    /**
     * Like [[saveWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveWithOptions(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[java.lang.String] => Unit): io.vertx.ext.mongo.MongoClient = {
      asJava.saveWithOptions(collection, document, writeOption.orNull, {p:AsyncResult[java.lang.String] => resultHandler(p)})
    }


    /**
     * Like [[insertWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def insertWithOptions(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[java.lang.String] => Unit): io.vertx.ext.mongo.MongoClient = {
      asJava.insertWithOptions(collection, document, writeOption.orNull, {p:AsyncResult[java.lang.String] => resultHandler(p)})
    }


    /**
     * Like [[findOne]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOne(collection: java.lang.String,query: io.vertx.core.json.JsonObject,fields: scala.Option[io.vertx.core.json.JsonObject],resultHandler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.ext.mongo.MongoClient = {
      asJava.findOne(collection, query, fields.orNull, {p:AsyncResult[io.vertx.core.json.JsonObject] => resultHandler(p)})
    }


    /**
     * Like [[removeDocumentsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentsWithOptions(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.ext.mongo.MongoClient = {
      asJava.removeDocumentsWithOptions(collection, query, writeOption.orNull, {p:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => resultHandler(p)})
    }


    /**
     * Like [[removeDocumentWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentWithOptions(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.ext.mongo.MongoClient = {
      asJava.removeDocumentWithOptions(collection, query, writeOption.orNull, {p:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => resultHandler(p)})
    }

    /**
     * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.save(collection, document, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[saveWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def saveWithOptionsFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.saveWithOptions(collection, document, writeOption.map(x => x).orNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[insert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def insertFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.insert(collection, document, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[insertWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def insertWithOptionsFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.insertWithOptions(collection, document, writeOption.map(x => x).orNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateCollectionFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.updateCollection(collection, query, update, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[updateCollectionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def updateCollectionWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.updateCollectionWithOptions(collection, query, update, options, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replaceDocuments]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replaceDocumentsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.replaceDocuments(collection, query, replace, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[replaceDocumentsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def replaceDocumentsWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.replaceDocumentsWithOptions(collection, query, replace, options, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bulkWrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bulkWriteFuture(collection: java.lang.String,operations: java.util.List[io.vertx.ext.mongo.BulkOperation]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]()
      asJava.bulkWrite(collection, operations, {a:AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[bulkWriteWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def bulkWriteWithOptionsFuture(collection: java.lang.String,operations: java.util.List[io.vertx.ext.mongo.BulkOperation],bulkWriteOptions: io.vertx.ext.mongo.BulkWriteOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]()
      asJava.bulkWriteWithOptions(collection, operations, bulkWriteOptions, {a:AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[find]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.find(collection, query, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.FindOptions): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.findWithOptions(collection, query, options, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOne]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,fields: scala.Option[io.vertx.core.json.JsonObject]): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOne(collection, query, fields.map(x => x).orNull, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndUpdate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndUpdateFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndUpdate(collection, query, update, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndUpdateWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndUpdateWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions,updateOptions: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndUpdateWithOptions(collection, query, update, findOptions, updateOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndReplace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndReplaceFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndReplace(collection, query, replace, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndReplaceWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndReplaceWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions,updateOptions: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndReplaceWithOptions(collection, query, replace, findOptions, updateOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndDelete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndDeleteFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndDelete(collection, query, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findOneAndDeleteWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findOneAndDeleteWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndDeleteWithOptions(collection, query, findOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[count]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def countFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.count(collection, query, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[removeDocuments]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocuments(collection, query, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[removeDocumentsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentsWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocumentsWithOptions(collection, query, writeOption.map(x => x).orNull, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[removeDocument]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocument(collection, query, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[removeDocumentWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def removeDocumentWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocumentWithOptions(collection, query, writeOption.map(x => x).orNull, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createCollectionFuture(collectionName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createCollection(collectionName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getCollections]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getCollectionsFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.getCollections({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dropCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dropCollectionFuture(collection: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.dropCollection(collection, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createIndex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createIndexFuture(collection: java.lang.String,key: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createIndex(collection, key, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createIndexWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createIndexWithOptionsFuture(collection: java.lang.String,key: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.IndexOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createIndexWithOptions(collection, key, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createIndexes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createIndexesFuture(collection: java.lang.String,indexes: java.util.List[io.vertx.ext.mongo.IndexModel]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createIndexes(collection, indexes, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listIndexes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listIndexesFuture(collection: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.listIndexes(collection, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[dropIndex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dropIndexFuture(collection: java.lang.String,indexName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.dropIndex(collection, indexName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[runCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def runCommandFuture(commandName: java.lang.String,command: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.runCommand(commandName, command, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[distinct]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def distinctFuture(collection: java.lang.String,fieldName: java.lang.String,resultClassname: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.distinct(collection, fieldName, resultClassname, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[distinctWithQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def distinctWithQueryFuture(collection: java.lang.String,fieldName: java.lang.String,resultClassname: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.distinctWithQuery(collection, fieldName, resultClassname, query, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createDefaultGridFsBucketService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createDefaultGridFsBucketServiceFuture(): scala.concurrent.Future[io.vertx.ext.mongo.MongoGridFsClient] = {
      val promise = Promise[io.vertx.ext.mongo.MongoGridFsClient]()
      asJava.createDefaultGridFsBucketService({a:AsyncResult[io.vertx.ext.mongo.MongoGridFsClient] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createGridFsBucketService]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createGridFsBucketServiceFuture(bucketName: java.lang.String): scala.concurrent.Future[io.vertx.ext.mongo.MongoGridFsClient] = {
      val promise = Promise[io.vertx.ext.mongo.MongoGridFsClient]()
      asJava.createGridFsBucketService(bucketName, {a:AsyncResult[io.vertx.ext.mongo.MongoGridFsClient] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type MongoClientBulkWriteResult = io.vertx.ext.mongo.MongoClientBulkWriteResult
  object MongoClientBulkWriteResult {
    def apply() = new MongoClientBulkWriteResult()
    def apply(json: JsonObject) = new MongoClientBulkWriteResult(json)
  }




  type MongoClientDeleteResult = io.vertx.ext.mongo.MongoClientDeleteResult
  object MongoClientDeleteResult {
    def apply() = new MongoClientDeleteResult()
    def apply(json: JsonObject) = new MongoClientDeleteResult(json)
  }




  type MongoClientUpdateResult = io.vertx.ext.mongo.MongoClientUpdateResult
  object MongoClientUpdateResult {
    def apply() = new MongoClientUpdateResult()
    def apply(json: JsonObject) = new MongoClientUpdateResult(json)
  }





  implicit class MongoGridFsClientScala(val asJava: io.vertx.ext.mongo.MongoGridFsClient) extends AnyVal {

    /**
     * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteFuture(id: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.delete(id, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def downloadByFileNameFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer],fileName: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadByFileName(stream, fileName, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def downloadByFileNameWithOptionsFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer],fileName: java.lang.String,options: io.vertx.ext.mongo.GridFsDownloadOptions): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadByFileNameWithOptions(stream, fileName, options, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def downloadByIdFuture(stream: io.vertx.core.streams.WriteStream[io.vertx.core.buffer.Buffer],id: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadById(stream, id, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[downloadFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def downloadFileFuture(fileName: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadFile(fileName, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[downloadFileAs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def downloadFileAsFuture(fileName: java.lang.String,newFileName: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadFileAs(fileName, newFileName, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[downloadFileByID]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def downloadFileByIDFuture(id: java.lang.String,fileName: java.lang.String): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.downloadFileByID(id, fileName, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[drop]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def dropFuture(): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.drop({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findAllIds]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findAllIdsFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.findAllIds({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[findIds]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def findIdsFuture(query: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.findIds(query, {a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def uploadByFileNameFuture(stream: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer],fileName: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.uploadByFileName(stream, fileName, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def uploadByFileNameWithOptionsFuture(stream: io.vertx.core.streams.ReadStream[io.vertx.core.buffer.Buffer],fileName: java.lang.String,options: io.vertx.ext.mongo.GridFsUploadOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.uploadByFileNameWithOptions(stream, fileName, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[uploadFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def uploadFileFuture(fileName: java.lang.String): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.uploadFile(fileName, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[uploadFileWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def uploadFileWithOptionsFuture(fileName: java.lang.String,options: io.vertx.ext.mongo.GridFsUploadOptions): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.uploadFileWithOptions(fileName, options, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type UpdateOptions = io.vertx.ext.mongo.UpdateOptions
  object UpdateOptions {
    def apply() = new UpdateOptions()
    def apply(json: JsonObject) = new UpdateOptions(json)
  }



}
