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
import io.vertx.ext.mongo.{MongoClientBulkWriteResult => JMongoClientBulkWriteResult}
import io.vertx.ext.mongo.{MongoClient => JMongoClient}
import io.vertx.ext.mongo.{MongoClientDeleteResult => JMongoClientDeleteResult}
import io.vertx.ext.mongo.{FindOptions => JFindOptions}
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.{IndexOptions => JIndexOptions}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.json.JsonArray
import io.vertx.ext.mongo.{BulkOperation => JBulkOperation}
import io.vertx.ext.mongo.{BulkWriteOptions => JBulkWriteOptions}
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

  /**
    * Save a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def save(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[String]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String], document, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Save a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def saveWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[String]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Insert a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insert(collection: String, document: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[String]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String], document, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Insert a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    * @param resultHandler result handler will be provided with the id if document didn't already have one
    */
  def insertWithOptions(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[String]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, {x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Update matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def update(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be called when complete
    */
  def updateCollection(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult, MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def updateCollectionWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult, MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Replace matching documents in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param resultHandler will be called when complete
    */
  def replaceDocuments(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult, MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be called when complete
    */
  def replaceDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions, resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, {x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult, MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Execute a bulk operation. Can insert, update, replace, and/or delete multiple documents with one request.
    * @param collection the collection
    * @param operations the operations to execute
    * @param resultHandler will be called with a MongoClientBulkWriteResult when complete
    */
  def bulkWrite(collection: String, operations: scala.collection.mutable.Buffer[BulkOperation], resultHandler: Handler[AsyncResult[MongoClientBulkWriteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].bulkWrite(collection.asInstanceOf[java.lang.String], operations.map(x => x.asJava).asJava, {x: AsyncResult[JMongoClientBulkWriteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientBulkWriteResult, MongoClientBulkWriteResult](x, a => MongoClientBulkWriteResult(a)))})
    this
  }

  /**
    * Execute a bulk operation with the specified write options. Can insert, update, replace, and/or delete multiple
    * documents with one request.
    * @param collection the collection
    * @param operations the operations to execute
    * @param bulkWriteOptions the write optionssee <a href="../../../../../../../cheatsheet/BulkWriteOptions.html">BulkWriteOptions</a>
    * @param resultHandler will be called with a MongoClientBulkWriteResult when complete
    */
  def bulkWriteWithOptions(collection: String, operations: scala.collection.mutable.Buffer[BulkOperation], bulkWriteOptions: BulkWriteOptions, resultHandler: Handler[AsyncResult[MongoClientBulkWriteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].bulkWriteWithOptions(collection.asInstanceOf[java.lang.String], operations.map(x => x.asJava).asJava, bulkWriteOptions.asJava, {x: AsyncResult[JMongoClientBulkWriteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientBulkWriteResult, MongoClientBulkWriteResult](x, a => MongoClientBulkWriteResult(a)))})
    this
  }

  /**
    * Find matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with list of documents
    */
  def find(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  /**
    * Find matching documents in the specified collection.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with each found document
    */
  def findBatch(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with list of documents
    */
  def findWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions, resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, {x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with each found document
    */
  def findBatchWithOptions(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param fields the fields
    * @param resultHandler will be provided with the document, if any
    */
  def findOne(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String], query, fields, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and update it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param update used to describe how the documents will be updated
    * @param resultHandler will be provided with the document, if any
    */
  def findOneAndUpdate(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String], query, update, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and update it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param update used to describe how the documents will be updated
    * @param findOptions options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param updateOptions options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be provided with the document, if any
    */
  def findOneAndUpdateWithOptions(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and replace it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param replace the replacement document
    * @param resultHandler will be provided with the document, if any
    */
  def findOneAndReplace(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String], query, replace, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and replace it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param replace the replacement document
    * @param findOptions options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param updateOptions options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    * @param resultHandler will be provided with the document, if any
    */
  def findOneAndReplaceWithOptions(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, findOptions.asJava, updateOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and delete it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param resultHandler will be provided with the deleted document, if any
    */
  def findOneAndDelete(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and delete it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param findOptions options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    * @param resultHandler will be provided with the deleted document, if any
    */
  def findOneAndDeleteWithOptions(collection: String, query: io.vertx.core.json.JsonObject, findOptions: FindOptions, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String], query, findOptions.asJava, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Count matching documents in a collection.
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be provided with the number of matching documents
    */
  def count(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Long]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long, Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove matching documents from a collection
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def remove(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param resultHandler will be called when complete
    */
  def removeDocuments(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult, MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentsWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult, MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove a single matching document from a collection
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeOne(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param resultHandler will be called when complete
    */
  def removeDocument(collection: String, query: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String], query, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult, MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeOneWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    * @param resultHandler will be called when complete
    */
  def removeDocumentWithOptions(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption, resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, {x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult, MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Create a new collection
    * @param collectionName the name of the collection
    * @param resultHandler will be called when complete
    */
  def createCollection(collectionName: String, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Get a list of all collections in the database.
    * @param resultHandler will be called with a list of collections.
    */
  def getCollections(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].getCollections({x: AsyncResult[java.util.List[java.lang.String]] => resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
    * Drop a collection
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def dropCollection(collection: String, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param resultHandler will be called when complete
    */
  def createIndex(collection: String, key: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String], key, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
    * @param resultHandler will be called when complete
    */
  def createIndexWithOptions(collection: String, key: io.vertx.core.json.JsonObject, options: IndexOptions, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String], key, options.asJava, {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Get all the indexes in this collection.
    * @param collection the collection
    * @param resultHandler will be called when complete
    */
  def listIndexes(collection: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Drops the index given its name.
    * @param collection the collection
    * @param indexName the name of the index to remove
    * @param resultHandler will be called when complete
    */
  def dropIndex(collection: String, indexName: String, resultHandler: Handler[AsyncResult[Unit]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String], indexName.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Run an arbitrary MongoDB command.
    * @param commandName the name of the command
    * @param command the command
    * @param resultHandler will be called with the result.
    */
  def runCommand(commandName: String, command: io.vertx.core.json.JsonObject, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String], command, {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with array of values.
    */
  def distinct(collection: String, fieldName: String, resultClassname: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * This method use batchCursor for returning each found value.
    * Each value is a json fragment with fieldName key (eg: {"num": 1`).
    * @param collection the collection
    * @param fieldName the field name
    * @param resultHandler will be provided with each found value
    */
  def distinctBatch(collection: String, fieldName: String, resultClassname: String, resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]): MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], {x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject, io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Close the client and release its resources
    */
  def close(): Unit = {
    asJava.asInstanceOf[JMongoClient].close()
  }

 /**
   * Like [[save]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def saveFuture(collection: String, document: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String], document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[saveWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def saveWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[insert]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def insertFuture(collection: String, document: io.vertx.core.json.JsonObject): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String], document, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[insertWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def insertWithOptionsFuture(collection: String, document: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String], document, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[updateCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateCollectionFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[updateWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[updateCollectionWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def updateCollectionWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String], query, update, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[replace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[replaceDocuments]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[replaceWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[replaceDocumentsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def replaceDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, options: UpdateOptions): scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, replace, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[bulkWrite]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def bulkWriteFuture(collection: String, operations: scala.collection.mutable.Buffer[BulkOperation]): scala.concurrent.Future[MongoClientBulkWriteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientBulkWriteResult, MongoClientBulkWriteResult](x => MongoClientBulkWriteResult(x))
    asJava.asInstanceOf[JMongoClient].bulkWrite(collection.asInstanceOf[java.lang.String], operations.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[bulkWriteWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def bulkWriteWithOptionsFuture(collection: String, operations: scala.collection.mutable.Buffer[BulkOperation], bulkWriteOptions: BulkWriteOptions): scala.concurrent.Future[MongoClientBulkWriteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientBulkWriteResult, MongoClientBulkWriteResult](x => MongoClientBulkWriteResult(x))
    asJava.asInstanceOf[JMongoClient].bulkWriteWithOptions(collection.asInstanceOf[java.lang.String], operations.map(x => x.asJava).asJava, bulkWriteOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[find]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findBatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findBatchFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions): scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findBatchWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findBatchWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, options: FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String], query, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOne]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneFuture(collection: String, query: io.vertx.core.json.JsonObject, fields: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String], query, fields, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndUpdate]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndUpdateFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String], query, update, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndUpdateWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndUpdateWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, update: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String], query, update, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndReplace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndReplaceFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String], query, replace, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndReplaceWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndReplaceWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, replace: io.vertx.core.json.JsonObject, findOptions: FindOptions, updateOptions: UpdateOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String], query, replace, findOptions.asJava, updateOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndDelete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndDeleteFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[findOneAndDeleteWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def findOneAndDeleteWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, findOptions: FindOptions): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String], query, findOptions.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[count]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def countFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[remove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeDocuments]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeDocumentsFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeDocumentsWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeDocumentsWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeOne]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeOneFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeDocument]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeDocumentFuture(collection: String, query: io.vertx.core.json.JsonObject): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String], query, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeOneWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeOneWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[removeDocumentWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def removeDocumentWithOptionsFuture(collection: String, query: io.vertx.core.json.JsonObject, writeOption: io.vertx.ext.mongo.WriteOption): scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String], query, writeOption, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[createCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def createCollectionFuture(collectionName: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getCollections]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getCollectionsFuture(): scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JMongoClient].getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[dropCollection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def dropCollectionFuture(collection: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[createIndex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def createIndexFuture(collection: String, key: io.vertx.core.json.JsonObject): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String], key, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[createIndexWithOptions]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def createIndexWithOptionsFuture(collection: String, key: io.vertx.core.json.JsonObject, options: IndexOptions): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String], key, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[listIndexes]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def listIndexesFuture(collection: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[dropIndex]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def dropIndexFuture(collection: String, indexName: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String], indexName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[runCommand]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def runCommandFuture(commandName: String, command: io.vertx.core.json.JsonObject): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String], command, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[distinct]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def distinctFuture(collection: String, fieldName: String, resultClassname: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[distinctBatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def distinctBatchFuture(collection: String, fieldName: String, resultClassname: String): scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String], fieldName.asInstanceOf[java.lang.String], resultClassname.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MongoClient {
  def apply(asJava: JMongoClient) = new MongoClient(asJava)  
  /**
    * Create a Mongo client which maintains its own data source.
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createNonShared(vertx: Vertx, config: io.vertx.core.json.JsonObject): MongoClient = {
    MongoClient(JMongoClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

  /**
    * Create a Mongo client which shares its data source with any other Mongo clients created with the same
    * data source name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @param dataSourceName the data source name
    * @return the client
    */
  def createShared(vertx: Vertx, config: io.vertx.core.json.JsonObject, dataSourceName: String): MongoClient = {
    MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx], config, dataSourceName.asInstanceOf[java.lang.String]))
  }

  /**
    * Like [[io.vertx.scala.ext.mongo.MongoClient#createShared]] but with the default data source name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createShared(vertx: Vertx, config: io.vertx.core.json.JsonObject): MongoClient = {
    MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
