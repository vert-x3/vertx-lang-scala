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

import io.vertx.ext.mongo.WriteOption
import io.vertx.ext.mongo.{MongoClientBulkWriteResult => JMongoClientBulkWriteResult}
import io.vertx.core
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.ext.mongo.{MongoClientDeleteResult => JMongoClientDeleteResult}
import io.vertx.ext.mongo.{FindOptions => JFindOptions}
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.{IndexOptions => JIndexOptions}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.{MongoService => JMongoService}
import io.vertx.ext.mongo.{BulkOperation => JBulkOperation}
import io.vertx.ext.mongo.{BulkWriteOptions => JBulkWriteOptions}
import io.vertx.ext.mongo.{UpdateOptions => JUpdateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.mongo.{MongoClientUpdateResult => JMongoClientUpdateResult}

package object mongo{


  /**

    */

  implicit class MongoServiceScala(val asJava: io.vertx.ext.mongo.MongoService) extends AnyVal {


    def saveWithOptions(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[java.lang.String] => Unit): io.vertx.ext.mongo.MongoService = {
      asJava.saveWithOptions(collection, document, writeOption.orNull, {p:AsyncResult[java.lang.String] => resultHandler(p)})
    }


    def insertWithOptions(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[java.lang.String] => Unit): io.vertx.ext.mongo.MongoService = {
      asJava.insertWithOptions(collection, document, writeOption.orNull, {p:AsyncResult[java.lang.String] => resultHandler(p)})
    }


    def findOne(collection: java.lang.String,query: io.vertx.core.json.JsonObject,fields: scala.Option[io.vertx.core.json.JsonObject],resultHandler: AsyncResult[io.vertx.core.json.JsonObject] => Unit): io.vertx.ext.mongo.MongoService = {
      asJava.findOne(collection, query, fields.orNull, {p:AsyncResult[io.vertx.core.json.JsonObject] => resultHandler(p)})
    }


    def removeDocumentsWithOptions(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.ext.mongo.MongoService = {
      asJava.removeDocumentsWithOptions(collection, query, writeOption.orNull, {p:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => resultHandler(p)})
    }


    def removeDocumentWithOptions(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption],resultHandler: AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => Unit): io.vertx.ext.mongo.MongoService = {
      asJava.removeDocumentWithOptions(collection, query, writeOption.orNull, {p:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => resultHandler(p)})
    }

    def saveFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.save(collection, document, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def saveWithOptionsFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.saveWithOptions(collection, document, writeOption.map(x => x).orNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def insertFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.insert(collection, document, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def insertWithOptionsFuture(collection: java.lang.String,document: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[java.lang.String] = {
      val promise = Promise[java.lang.String]()
      asJava.insertWithOptions(collection, document, writeOption.map(x => x).orNull, {a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.update(collection, query, update, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateCollectionFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.updateCollection(collection, query, update, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.updateWithOptions(collection, query, update, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def updateCollectionWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.updateCollectionWithOptions(collection, query, update, options, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replaceFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.replace(collection, query, replace, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replaceDocumentsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.replaceDocuments(collection, query, replace, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replaceWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.replaceWithOptions(collection, query, replace, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def replaceDocumentsWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientUpdateResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientUpdateResult]()
      asJava.replaceDocumentsWithOptions(collection, query, replace, options, {a:AsyncResult[io.vertx.ext.mongo.MongoClientUpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bulkWriteFuture(collection: java.lang.String,operations: java.util.List[io.vertx.ext.mongo.BulkOperation]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]()
      asJava.bulkWrite(collection, operations, {a:AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def bulkWriteWithOptionsFuture(collection: java.lang.String,operations: java.util.List[io.vertx.ext.mongo.BulkOperation],bulkWriteOptions: io.vertx.ext.mongo.BulkWriteOptions): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientBulkWriteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientBulkWriteResult]()
      asJava.bulkWriteWithOptions(collection, operations, bulkWriteOptions, {a:AsyncResult[io.vertx.ext.mongo.MongoClientBulkWriteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.find(collection, query, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.FindOptions): scala.concurrent.Future[java.util.List[io.vertx.core.json.JsonObject]] = {
      val promise = Promise[java.util.List[io.vertx.core.json.JsonObject]]()
      asJava.findWithOptions(collection, query, options, {a:AsyncResult[java.util.List[io.vertx.core.json.JsonObject]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,fields: scala.Option[io.vertx.core.json.JsonObject]): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOne(collection, query, fields.map(x => x).orNull, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndUpdateFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndUpdate(collection, query, update, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndUpdateWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions,updateOptions: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndUpdateWithOptions(collection, query, update, findOptions, updateOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndReplaceFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndReplace(collection, query, replace, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndReplaceWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions,updateOptions: io.vertx.ext.mongo.UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndReplaceWithOptions(collection, query, update, findOptions, updateOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndDeleteFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndDelete(collection, query, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def findOneAndDeleteWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,findOptions: io.vertx.ext.mongo.FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.findOneAndDeleteWithOptions(collection, query, findOptions, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def countFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[java.lang.Long] = {
      val promise = Promise[java.lang.Long]()
      asJava.count(collection, query, {a:AsyncResult[java.lang.Long] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.remove(collection, query, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeDocumentsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocuments(collection, query, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.removeWithOptions(collection, query, writeOption, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeDocumentsWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocumentsWithOptions(collection, query, writeOption.map(x => x).orNull, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeOneFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.removeOne(collection, query, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeDocumentFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocument(collection, query, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeOneWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.removeOneWithOptions(collection, query, writeOption, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def removeDocumentWithOptionsFuture(collection: java.lang.String,query: io.vertx.core.json.JsonObject,writeOption: scala.Option[io.vertx.ext.mongo.WriteOption]): scala.concurrent.Future[io.vertx.ext.mongo.MongoClientDeleteResult] = {
      val promise = Promise[io.vertx.ext.mongo.MongoClientDeleteResult]()
      asJava.removeDocumentWithOptions(collection, query, writeOption.map(x => x).orNull, {a:AsyncResult[io.vertx.ext.mongo.MongoClientDeleteResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createCollectionFuture(collectionName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createCollection(collectionName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def getCollectionsFuture(): scala.concurrent.Future[java.util.List[java.lang.String]] = {
      val promise = Promise[java.util.List[java.lang.String]]()
      asJava.getCollections({a:AsyncResult[java.util.List[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def dropCollectionFuture(collection: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.dropCollection(collection, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createIndexFuture(collection: java.lang.String,key: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createIndex(collection, key, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def createIndexWithOptionsFuture(collection: java.lang.String,key: io.vertx.core.json.JsonObject,options: io.vertx.ext.mongo.IndexOptions): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createIndexWithOptions(collection, key, options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def listIndexesFuture(collection: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.listIndexes(collection, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def dropIndexFuture(collection: java.lang.String,indexName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.dropIndex(collection, indexName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def runCommandFuture(commandName: java.lang.String,command: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
      val promise = Promise[io.vertx.core.json.JsonObject]()
      asJava.runCommand(commandName, command, {a:AsyncResult[io.vertx.core.json.JsonObject] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def distinctFuture(collection: java.lang.String,fieldName: java.lang.String,resultClassname: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.distinct(collection, fieldName, resultClassname, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def distinctWithQueryFuture(collection: java.lang.String,fieldName: java.lang.String,resultClassname: java.lang.String,query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = Promise[io.vertx.core.json.JsonArray]()
      asJava.distinctWithQuery(collection, fieldName, resultClassname, query, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }

}
