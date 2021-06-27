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
  }



}
