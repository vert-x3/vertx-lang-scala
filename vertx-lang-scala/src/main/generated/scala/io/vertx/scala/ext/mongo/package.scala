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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.mongo.{BulkWriteOptions => JBulkWriteOptions}
package object mongo{


  type AggregateOptions = io.vertx.ext.mongo.AggregateOptions
  object AggregateOptions {
    def apply() = new AggregateOptions()
    def apply(json: JsonObject) = new AggregateOptions(json)
    def apply( allowDiskUse: java.lang.Boolean = null, batchSize: java.lang.Integer = null, maxTime: java.lang.Long = null): AggregateOptions = {
      val ret = new AggregateOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (allowDiskUse != null) ret.setAllowDiskUse(allowDiskUse) 
      if (batchSize != null) ret.setBatchSize(batchSize) 
      if (maxTime != null) ret.setMaxTime(maxTime) 
      ret
    }
  }



  type BulkOperation = io.vertx.ext.mongo.BulkOperation
  object BulkOperation {
    def apply(json: JsonObject) = new BulkOperation(json)
    def apply( document: io.vertx.core.json.JsonObject = null, filter: io.vertx.core.json.JsonObject = null, multi: java.lang.Boolean = null, `type`: io.vertx.ext.mongo.BulkOperationType = null, upsert: java.lang.Boolean = null): BulkOperation = {
      val ret = new BulkOperation(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (document != null) ret.setDocument(document) 
      if (filter != null) ret.setFilter(filter) 
      if (multi != null) ret.setMulti(multi) 
      if (`type` != null) ret.setType(`type`) 
      if (upsert != null) ret.setUpsert(upsert) 
      ret
    }
  }



  type BulkWriteOptions = io.vertx.ext.mongo.BulkWriteOptions
  object BulkWriteOptions {
    def apply() = new BulkWriteOptions()
    def apply(json: JsonObject) = new BulkWriteOptions(json)
    def apply( ordered: java.lang.Boolean = null, writeOption: io.vertx.ext.mongo.WriteOption = null): BulkWriteOptions = {
      val ret = new BulkWriteOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (ordered != null) ret.setOrdered(ordered) 
      if (writeOption != null) ret.setWriteOption(writeOption) 
      ret
    }
  }



  type FindOptions = io.vertx.ext.mongo.FindOptions
  object FindOptions {
    def apply() = new FindOptions()
    def apply(json: JsonObject) = new FindOptions(json)
    def apply( batchSize: java.lang.Integer = null, fields: io.vertx.core.json.JsonObject = null, hint: java.lang.String = null, limit: java.lang.Integer = null, skip: java.lang.Integer = null, sort: io.vertx.core.json.JsonObject = null): FindOptions = {
      val ret = new FindOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (batchSize != null) ret.setBatchSize(batchSize) 
      if (fields != null) ret.setFields(fields) 
      if (hint != null) ret.setHint(hint) 
      if (limit != null) ret.setLimit(limit) 
      if (skip != null) ret.setSkip(skip) 
      if (sort != null) ret.setSort(sort) 
      ret
    }
  }



  type GridFsDownloadOptions = io.vertx.ext.mongo.GridFsDownloadOptions
  object GridFsDownloadOptions {
    def apply() = new GridFsDownloadOptions()
    def apply(json: JsonObject) = new GridFsDownloadOptions(json)
    def apply( revision: java.lang.Integer = null): GridFsDownloadOptions = {
      val ret = new GridFsDownloadOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (revision != null) ret.setRevision(revision) 
      ret
    }
  }



  type GridFsUploadOptions = io.vertx.ext.mongo.GridFsUploadOptions
  object GridFsUploadOptions {
    def apply() = new GridFsUploadOptions()
    def apply(json: JsonObject) = new GridFsUploadOptions(json)
    def apply( chunkSizeBytes: java.lang.Integer = null, metadata: io.vertx.core.json.JsonObject = null): GridFsUploadOptions = {
      val ret = new GridFsUploadOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (chunkSizeBytes != null) ret.setChunkSizeBytes(chunkSizeBytes) 
      if (metadata != null) ret.setMetadata(metadata) 
      ret
    }
  }



  type IndexModel = io.vertx.ext.mongo.IndexModel
  object IndexModel {
    def apply() = new IndexModel()
    def apply(json: JsonObject) = new IndexModel(json)
    def apply( key: io.vertx.core.json.JsonObject = null, options: io.vertx.ext.mongo.IndexOptions = null): IndexModel = {
      val ret = new IndexModel(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (key != null) ret.setKey(key) 
      if (options != null) ret.setOptions(options) 
      ret
    }
  }



  type IndexOptions = io.vertx.ext.mongo.IndexOptions
  object IndexOptions {
    def apply() = new IndexOptions()
    def apply(json: JsonObject) = new IndexOptions(json)

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



  type UpdateOptions = io.vertx.ext.mongo.UpdateOptions
  object UpdateOptions {
    def apply() = new UpdateOptions()
    def apply(json: JsonObject) = new UpdateOptions(json)
    def apply( arrayFilters: io.vertx.core.json.JsonArray = null, multi: java.lang.Boolean = null, returningNewDocument: java.lang.Boolean = null, upsert: java.lang.Boolean = null, writeOption: io.vertx.ext.mongo.WriteOption = null): UpdateOptions = {
      val ret = new UpdateOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (arrayFilters != null) ret.setArrayFilters(arrayFilters) 
      if (multi != null) ret.setMulti(multi) 
      if (returningNewDocument != null) ret.setReturningNewDocument(returningNewDocument) 
      if (upsert != null) ret.setUpsert(upsert) 
      if (writeOption != null) ret.setWriteOption(writeOption) 
      ret
    }
  }



}
