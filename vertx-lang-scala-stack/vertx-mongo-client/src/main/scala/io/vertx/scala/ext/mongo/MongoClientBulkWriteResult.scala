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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.mongo.{MongoClientBulkWriteResult => JMongoClientBulkWriteResult}
import io.vertx.core.json.JsonObject

/**
  * Result propagated from mongodb driver bulk write result.
  */
class MongoClientBulkWriteResult(private val _asJava: JMongoClientBulkWriteResult) {

  def asJava = _asJava

  /**
    * Returns the number of deleted documents
    */

  /**
    * Returns the number of inserted documents
    */

  /**
    * Returns the number of matched documents
    */

  /**
    * Returns the number of modified documents
    */

  /**
    * An unmodifiable list of upsert data. Each entry has the index of the request that lead to the upsert, and the
    * generated ID of the upsert.
    */
}

object MongoClientBulkWriteResult {
  
  def apply() = {
    new MongoClientBulkWriteResult(new JMongoClientBulkWriteResult(emptyObj()))
  }
  
  def apply(t: JMongoClientBulkWriteResult) = {
    if (t != null) {
      new MongoClientBulkWriteResult(t)
    } else {
      new MongoClientBulkWriteResult(new JMongoClientBulkWriteResult(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MongoClientBulkWriteResult = {
    if (json != null) {
      new MongoClientBulkWriteResult(new JMongoClientBulkWriteResult(json))
    } else {
      new MongoClientBulkWriteResult(new JMongoClientBulkWriteResult(emptyObj()))
    }
  }
}
