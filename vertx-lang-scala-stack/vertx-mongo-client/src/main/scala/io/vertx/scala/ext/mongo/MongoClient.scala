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
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.String>>
  def save(collection: String,document: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String],document,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Save a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.String>>
  def saveWithOptions(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Insert a document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.String>>
  def insert(collection: String,document: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String],document,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Insert a document in the specified collection with the specified write option
    * 
    * This operation might change <i>_id</i> field of <i>document</i> parameter
    * @param collection the collection
    * @param document the document
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.String>>
  def insertWithOptions(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[String]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,{x: AsyncResult[java.lang.String] => resultHandler.handle(AsyncResultWrapper[java.lang.String,String](x, a => a.asInstanceOf[String]))})
    this
  }

  /**
    * Update matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def update(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientUpdateResult>>
  def updateCollection(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def updateWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param update used to describe how the documents will be updated
    * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientUpdateResult>>
  def updateCollectionWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Replace matching documents in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>replace</i> parameter
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def replace(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientUpdateResult>>
  def replaceDocuments(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
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
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def replaceWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
    * @param collection the collection
    * @param query query used to match the documents
    * @param replace all matching documents will be replaced with this
    * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientUpdateResult>>
  def replaceDocumentsWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions,resultHandler: Handler[AsyncResult[MongoClientUpdateResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,{x: AsyncResult[JMongoClientUpdateResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientUpdateResult,MongoClientUpdateResult](x, a => MongoClientUpdateResult(a)))})
    this
  }

  /**
    * Find matching documents in the specified collection
    * @param collection the collection
    * @param query query used to match documents
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>
  def find(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  /**
    * Find matching documents in the specified collection.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findBatch(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.FindOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<io.vertx.core.json.JsonObject>>>
  def findWithOptions(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions,resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,{x: AsyncResult[java.util.List[JsonObject]] => resultHandler.handle(AsyncResultWrapper[java.util.List[JsonObject],scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x, a => a.asScala))})
    this
  }

  /**
    * Find matching documents in the specified collection, specifying options.
    * This method use batchCursor for returning each found document.
    * @param collection the collection
    * @param query query used to match documents
    * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.FindOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findBatchWithOptions(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param fields the fields
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOne(collection: String,query: io.vertx.core.json.JsonObject,fields: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String],query,fields,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and update it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param update used to describe how the documents will be updated
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndUpdate(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String],query,update,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
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
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.FindOptions
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndUpdateWithOptions(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String],query,update,findOptions.asJava,updateOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and replace it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param replace the replacement document
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndReplace(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String],query,replace,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
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
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.FindOptions
//io.vertx.ext.mongo.UpdateOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndReplaceWithOptions(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,findOptions.asJava,updateOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and delete it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndDelete(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Find a single matching document in the specified collection and delete it.
    * 
    * This operation might change <i>_id</i> field of <i>query</i> parameter
    * @param collection the collection
    * @param query the query used to match the document
    * @param findOptions options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.FindOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def findOneAndDeleteWithOptions(collection: String,query: io.vertx.core.json.JsonObject,findOptions: FindOptions,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String],query,findOptions.asJava,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Count matching documents in a collection.
    * @param collection the collection
    * @param query query used to match documents
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Long>>
  def count(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Long]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[java.lang.Long] => resultHandler.handle(AsyncResultWrapper[java.lang.Long,Long](x, a => a.asInstanceOf[Long]))})
    this
  }

  /**
    * Remove matching documents from a collection
    * @param collection the collection
    * @param query query used to match documents
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def remove(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientDeleteResult>>
  def removeDocuments(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def removeWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match documents
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientDeleteResult>>
  def removeDocumentsWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove a single matching document from a collection
    * @param collection the collection
    * @param query query used to match document
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def removeOne(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientDeleteResult>>
  def removeDocument(collection: String,query: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String],query,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def removeOneWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
    * @param collection the collection
    * @param query query used to match document
    * @param writeOption the write option to use
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.WriteOption
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.ext.mongo.MongoClientDeleteResult>>
  def removeDocumentWithOptions(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption,resultHandler: Handler[AsyncResult[MongoClientDeleteResult]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,{x: AsyncResult[JMongoClientDeleteResult] => resultHandler.handle(AsyncResultWrapper[JMongoClientDeleteResult,MongoClientDeleteResult](x, a => MongoClientDeleteResult(a)))})
    this
  }

  /**
    * Create a new collection
    * @param collectionName the name of the collection
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def createCollection(collectionName: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Get a list of all collections in the database.
    */
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.util.List<java.lang.String>>>
  def getCollections(resultHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[String]]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].getCollections({x: AsyncResult[java.util.List[java.lang.String]] => resultHandler.handle(AsyncResultWrapper[java.util.List[java.lang.String],scala.collection.mutable.Buffer[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))})
    this
  }

  /**
    * Drop a collection
    * @param collection the collection
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def dropCollection(collection: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def createIndex(collection: String,key: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String],key,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Creates an index.
    * @param collection the collection
    * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
    * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.ext.mongo.IndexOptions
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def createIndexWithOptions(collection: String,key: io.vertx.core.json.JsonObject,options: IndexOptions,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String],key,options.asJava,{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Get all the indexes in this collection.
    * @param collection the collection
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonArray>>
  def listIndexes(collection: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Drops the index given its name.
    * @param collection the collection
    * @param indexName the name of the index to remove
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<java.lang.Void>>
  def dropIndex(collection: String,indexName: String,resultHandler: Handler[AsyncResult[Unit]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String],indexName.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  /**
    * Run an arbitrary MongoDB command.
    * @param commandName the name of the command
    * @param command the command
    */
//java.lang.String
//io.vertx.core.json.JsonObject
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def runCommand(commandName: String,command: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String],command,{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
    * @param collection the collection
    * @param fieldName the field name
    */
//java.lang.String
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonArray>>
  def distinct(collection: String,fieldName: String,resultClassname: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],{x: AsyncResult[JsonArray] => resultHandler.handle(AsyncResultWrapper[JsonArray,io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Gets the distinct values of the specified field name.
    * This method use batchCursor for returning each found value.
    * Each value is a json fragment with fieldName key (eg: {"num": 1`).
    * @param collection the collection
    * @param fieldName the field name
    */
//java.lang.String
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.AsyncResult<io.vertx.core.json.JsonObject>>
  def distinctBatch(collection: String,fieldName: String,resultClassname: String,resultHandler: Handler[AsyncResult[io.vertx.core.json.JsonObject]]):MongoClient = {
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],{x: AsyncResult[JsonObject] => resultHandler.handle(AsyncResultWrapper[JsonObject,io.vertx.core.json.JsonObject](x, a => a))})
    this
  }

  /**
    * Close the client and release its resources
    */
  def close():Unit = {
    asJava.asInstanceOf[JMongoClient].close()
  }

 /**
   * Save a document in the specified collection
   * 
   * This operation might change <i>_id</i> field of <i>document</i> parameter
   * @param collection the collection
   * @param document the document
   * @return result future will be provided with the id if document didn't already have one
   */
    def saveFuture(collection: String,document: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].save(collection.asInstanceOf[java.lang.String],document,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Save a document in the specified collection with the specified write option
   * 
   * This operation might change <i>_id</i> field of <i>document</i> parameter
   * @param collection the collection
   * @param document the document
   * @param writeOption the write option to use
   * @return result future will be provided with the id if document didn't already have one
   */
    def saveWithOptionsFuture(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].saveWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Insert a document in the specified collection
   * 
   * This operation might change <i>_id</i> field of <i>document</i> parameter
   * @param collection the collection
   * @param document the document
   * @return result future will be provided with the id if document didn't already have one
   */
    def insertFuture(collection: String,document: io.vertx.core.json.JsonObject):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insert(collection.asInstanceOf[java.lang.String],document,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Insert a document in the specified collection with the specified write option
   * 
   * This operation might change <i>_id</i> field of <i>document</i> parameter
   * @param collection the collection
   * @param document the document
   * @param writeOption the write option to use
   * @return result future will be provided with the id if document didn't already have one
   */
    def insertWithOptionsFuture(collection: String,document: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[String] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMongoClient].insertWithOptions(collection.asInstanceOf[java.lang.String],document,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Update matching documents in the specified collection
   * @param collection the collection
   * @param query query used to match the documents
   * @param update used to describe how the documents will be updated
   * @return will be called when complete
   */
    def updateFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].update(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Update matching documents in the specified collection and return the handler with MongoClientUpdateResult result
   * @param collection the collection
   * @param query query used to match the documents
   * @param update used to describe how the documents will be updated
   * @return will be called when complete
   */
    def updateCollectionFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollection(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Update matching documents in the specified collection, specifying options
   * @param collection the collection
   * @param query query used to match the documents
   * @param update used to describe how the documents will be updated
   * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
   * @return will be called when complete
   */
    def updateWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].updateWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Update matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
   * @param collection the collection
   * @param query query used to match the documents
   * @param update used to describe how the documents will be updated
   * @param options options to configure the updatesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
   * @return will be called when complete
   */
    def updateCollectionWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].updateCollectionWithOptions(collection.asInstanceOf[java.lang.String],query,update,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace matching documents in the specified collection
   * 
   * This operation might change <i>_id</i> field of <i>replace</i> parameter
   * @param collection the collection
   * @param query query used to match the documents
   * @param replace all matching documents will be replaced with this
   * @return will be called when complete
   */
    def replaceFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].replace(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace matching documents in the specified collection and return the handler with MongoClientUpdateResult result
   * @param collection the collection
   * @param query query used to match the documents
   * @param replace all matching documents will be replaced with this
   * @return will be called when complete
   */
    def replaceDocumentsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocuments(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace matching documents in the specified collection, specifying options
   * 
   * This operation might change <i>_id</i> field of <i>replace</i> parameter
   * @param collection the collection
   * @param query query used to match the documents
   * @param replace all matching documents will be replaced with this
   * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
   * @return will be called when complete
   */
    def replaceWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].replaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace matching documents in the specified collection, specifying options and return the handler with MongoClientUpdateResult result
   * @param collection the collection
   * @param query query used to match the documents
   * @param replace all matching documents will be replaced with this
   * @param options options to configure the replacesee <a href="../../../../../../../cheatsheet/UpdateOptions.html">UpdateOptions</a>
   * @return will be called when complete
   */
    def replaceDocumentsWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,options: UpdateOptions):scala.concurrent.Future[MongoClientUpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientUpdateResult, MongoClientUpdateResult](x => MongoClientUpdateResult(x))
    asJava.asInstanceOf[JMongoClient].replaceDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,replace,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find matching documents in the specified collection
   * @param collection the collection
   * @param query query used to match documents
   * @return will be provided with list of documents
   */
    def findFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoClient].find(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find matching documents in the specified collection.
   * This method use batchCursor for returning each found document.
   * @param collection the collection
   * @param query query used to match documents
   * @return will be provided with each found document
   */
    def findBatchFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findBatch(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find matching documents in the specified collection, specifying options
   * @param collection the collection
   * @param query query used to match documents
   * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
   * @return will be provided with list of documents
   */
    def findWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions):scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JsonObject], scala.collection.mutable.Buffer[io.vertx.core.json.JsonObject]](x => x.asScala)
    asJava.asInstanceOf[JMongoClient].findWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find matching documents in the specified collection, specifying options.
   * This method use batchCursor for returning each found document.
   * @param collection the collection
   * @param query query used to match documents
   * @param options options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
   * @return will be provided with each found document
   */
    def findBatchWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,options: FindOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findBatchWithOptions(collection.asInstanceOf[java.lang.String],query,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find a single matching document in the specified collection
   * 
   * This operation might change <i>_id</i> field of <i>query</i> parameter
   * @param collection the collection
   * @param query the query used to match the document
   * @param fields the fields
   * @return will be provided with the document, if any
   */
    def findOneFuture(collection: String,query: io.vertx.core.json.JsonObject,fields: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOne(collection.asInstanceOf[java.lang.String],query,fields,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find a single matching document in the specified collection and update it.
   * 
   * This operation might change <i>_id</i> field of <i>query</i> parameter
   * @param collection the collection
   * @param query the query used to match the document
   * @param update used to describe how the documents will be updated
   * @return will be provided with the document, if any
   */
    def findOneAndUpdateFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdate(collection.asInstanceOf[java.lang.String],query,update,promiseAndHandler._1)
    promiseAndHandler._2.future
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
   * @return will be provided with the document, if any
   */
    def findOneAndUpdateWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,update: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndUpdateWithOptions(collection.asInstanceOf[java.lang.String],query,update,findOptions.asJava,updateOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find a single matching document in the specified collection and replace it.
   * 
   * This operation might change <i>_id</i> field of <i>query</i> parameter
   * @param collection the collection
   * @param query the query used to match the document
   * @param replace the replacement document
   * @return will be provided with the document, if any
   */
    def findOneAndReplaceFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplace(collection.asInstanceOf[java.lang.String],query,replace,promiseAndHandler._1)
    promiseAndHandler._2.future
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
   * @return will be provided with the document, if any
   */
    def findOneAndReplaceWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,replace: io.vertx.core.json.JsonObject,findOptions: FindOptions,updateOptions: UpdateOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndReplaceWithOptions(collection.asInstanceOf[java.lang.String],query,replace,findOptions.asJava,updateOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find a single matching document in the specified collection and delete it.
   * 
   * This operation might change <i>_id</i> field of <i>query</i> parameter
   * @param collection the collection
   * @param query the query used to match the document
   * @return will be provided with the deleted document, if any
   */
    def findOneAndDeleteFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndDelete(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Find a single matching document in the specified collection and delete it.
   * 
   * This operation might change <i>_id</i> field of <i>query</i> parameter
   * @param collection the collection
   * @param query the query used to match the document
   * @param findOptions options to configure the findsee <a href="../../../../../../../cheatsheet/FindOptions.html">FindOptions</a>
   * @return will be provided with the deleted document, if any
   */
    def findOneAndDeleteWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,findOptions: FindOptions):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].findOneAndDeleteWithOptions(collection.asInstanceOf[java.lang.String],query,findOptions.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Count matching documents in a collection.
   * @param collection the collection
   * @param query query used to match documents
   * @return will be provided with the number of matching documents
   */
    def countFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long, Long](x => x.asInstanceOf[Long])
    asJava.asInstanceOf[JMongoClient].count(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove matching documents from a collection
   * @param collection the collection
   * @param query query used to match documents
   * @return will be called when complete
   */
    def removeFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].remove(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove matching documents from a collection and return the handler with MongoClientDeleteResult result
   * @param collection the collection
   * @param query query used to match documents
   * @return will be called when complete
   */
    def removeDocumentsFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocuments(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove matching documents from a collection with the specified write option
   * @param collection the collection
   * @param query query used to match documents
   * @param writeOption the write option to use
   * @return will be called when complete
   */
    def removeWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove matching documents from a collection with the specified write option and return the handler with MongoClientDeleteResult result
   * @param collection the collection
   * @param query query used to match documents
   * @param writeOption the write option to use
   * @return will be called when complete
   */
    def removeDocumentsWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentsWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a single matching document from a collection
   * @param collection the collection
   * @param query query used to match document
   * @return will be called when complete
   */
    def removeOneFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeOne(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a single matching document from a collection and return the handler with MongoClientDeleteResult result
   * @param collection the collection
   * @param query query used to match document
   * @return will be called when complete
   */
    def removeDocumentFuture(collection: String,query: io.vertx.core.json.JsonObject):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocument(collection.asInstanceOf[java.lang.String],query,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a single matching document from a collection with the specified write option
   * @param collection the collection
   * @param query query used to match document
   * @param writeOption the write option to use
   * @return will be called when complete
   */
    def removeOneWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].removeOneWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a single matching document from a collection with the specified write option and return the handler with MongoClientDeleteResult result
   * @param collection the collection
   * @param query query used to match document
   * @param writeOption the write option to use
   * @return will be called when complete
   */
    def removeDocumentWithOptionsFuture(collection: String,query: io.vertx.core.json.JsonObject,writeOption: io.vertx.ext.mongo.WriteOption):scala.concurrent.Future[MongoClientDeleteResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMongoClientDeleteResult, MongoClientDeleteResult](x => MongoClientDeleteResult(x))
    asJava.asInstanceOf[JMongoClient].removeDocumentWithOptions(collection.asInstanceOf[java.lang.String],query,writeOption,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Create a new collection
   * @param collectionName the name of the collection
   * @return will be called when complete
   */
    def createCollectionFuture(collectionName: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createCollection(collectionName.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get a list of all collections in the database.
   * @return will be called with a list of collections.
   */
    def getCollectionsFuture():scala.concurrent.Future[scala.collection.mutable.Buffer[String]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.String], scala.collection.mutable.Buffer[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JMongoClient].getCollections(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Drop a collection
   * @param collection the collection
   * @return will be called when complete
   */
    def dropCollectionFuture(collection: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].dropCollection(collection.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Creates an index.
   * @param collection the collection
   * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
   * @return will be called when complete
   */
    def createIndexFuture(collection: String,key: io.vertx.core.json.JsonObject):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createIndex(collection.asInstanceOf[java.lang.String],key,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Creates an index.
   * @param collection the collection
   * @param key A document that contains the field and value pairs where the field is the index key and the value describes the type of index for that field. For an ascending index on a field, specify a value of 1; for descending index, specify a value of -1.
   * @param options the options for the indexsee <a href="../../../../../../../cheatsheet/IndexOptions.html">IndexOptions</a>
   * @return will be called when complete
   */
    def createIndexWithOptionsFuture(collection: String,key: io.vertx.core.json.JsonObject,options: IndexOptions):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].createIndexWithOptions(collection.asInstanceOf[java.lang.String],key,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Get all the indexes in this collection.
   * @param collection the collection
   * @return will be called when complete
   */
    def listIndexesFuture(collection: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoClient].listIndexes(collection.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Drops the index given its name.
   * @param collection the collection
   * @param indexName the name of the index to remove
   * @return will be called when complete
   */
    def dropIndexFuture(collection: String,indexName: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMongoClient].dropIndex(collection.asInstanceOf[java.lang.String],indexName.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Run an arbitrary MongoDB command.
   * @param commandName the name of the command
   * @param command the command
   * @return will be called with the result.
   */
    def runCommandFuture(commandName: String,command: io.vertx.core.json.JsonObject):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].runCommand(commandName.asInstanceOf[java.lang.String],command,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Gets the distinct values of the specified field name.
   * Return a JsonArray containing distinct values (eg: [ 1 , 89 ])
   * @param collection the collection
   * @param fieldName the field name
   * @return will be provided with array of values.
   */
    def distinctFuture(collection: String,fieldName: String,resultClassname: String):scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JMongoClient].distinct(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Gets the distinct values of the specified field name.
   * This method use batchCursor for returning each found value.
   * Each value is a json fragment with fieldName key (eg: {"num": 1`).
   * @param collection the collection
   * @param fieldName the field name
   * @return will be provided with each found value
   */
    def distinctBatchFuture(collection: String,fieldName: String,resultClassname: String):scala.concurrent.Future[io.vertx.core.json.JsonObject] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonObject, io.vertx.core.json.JsonObject](x => x)
    asJava.asInstanceOf[JMongoClient].distinctBatch(collection.asInstanceOf[java.lang.String],fieldName.asInstanceOf[java.lang.String],resultClassname.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MongoClient{
  def apply(asJava: JMongoClient) = new MongoClient(asJava)  
  /**
    * Create a Mongo client which maintains its own data source.
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createNonShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):MongoClient = {
    MongoClient(JMongoClient.createNonShared(vertx.asJava.asInstanceOf[JVertx],config))
  }

  /**
    * Create a Mongo client which shares its data source with any other Mongo clients created with the same
    * data source name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @param dataSourceName the data source name
    * @return the client
    */
  def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject,dataSourceName: String):MongoClient = {
    MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx],config,dataSourceName.asInstanceOf[java.lang.String]))
  }

  /**
    * Like [[io.vertx.scala.ext.mongo.MongoClient#createShared]] but with the default data source name
    * @param vertx the Vert.x instance
    * @param config the configuration
    * @return the client
    */
  def createShared(vertx: Vertx,config: io.vertx.core.json.JsonObject):MongoClient = {
    MongoClient(JMongoClient.createShared(vertx.asJava.asInstanceOf[JVertx],config))
  }

}
