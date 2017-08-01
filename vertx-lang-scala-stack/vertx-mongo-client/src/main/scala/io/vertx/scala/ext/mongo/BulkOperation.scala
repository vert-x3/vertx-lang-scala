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
import io.vertx.ext.mongo.{BulkOperation => JBulkOperation}
import io.vertx.ext.mongo.BulkOperation.BulkOperationType
import io.vertx.core.json.JsonObject

/**
  * Contains all data needed for one operation of a bulk write operation.
  */
class BulkOperation(private val _asJava: JBulkOperation) {

  def asJava = _asJava

  /**
    * Sets the document, used by insert, replace, and update operations
    */
  def setDocument(value: io.vertx.core.json.JsonObject) = {
    asJava.setDocument(value)
    this
  }
  def getDocument: io.vertx.core.json.JsonObject = {
    asJava.getDocument()
  }

  /**
    * Sets the filter document, used by replace, update, and delete operations
    */
  def setFilter(value: io.vertx.core.json.JsonObject) = {
    asJava.setFilter(value)
    this
  }
  def getFilter: io.vertx.core.json.JsonObject = {
    asJava.getFilter()
  }

  /**
    * Sets the multi flag, used by update and delete operations
    */
  def setMulti(value: Boolean) = {
    asJava.setMulti(value)
    this
  }
  def isMulti: Boolean = {
    asJava.isMulti().asInstanceOf[Boolean]
  }

  /**
    * Sets the operation type
    */
  def setType(value: io.vertx.ext.mongo.BulkOperation.BulkOperationType) = {
    asJava.setType(value)
    this
  }
  def getType: io.vertx.ext.mongo.BulkOperation.BulkOperationType = {
    asJava.getType()
  }

  /**
    * Sets the upsert flag, used by update and replace operations
    */
  def setUpsert(value: Boolean) = {
    asJava.setUpsert(value)
    this
  }
  def isUpsert: Boolean = {
    asJava.isUpsert().asInstanceOf[Boolean]
  }
}

object BulkOperation {
  
  def apply() = {
    new BulkOperation(new JBulkOperation(emptyObj()))
  }
  
  def apply(t: JBulkOperation) = {
    if (t != null) {
      new BulkOperation(t)
    } else {
      new BulkOperation(new JBulkOperation(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): BulkOperation = {
    if (json != null) {
      new BulkOperation(new JBulkOperation(json))
    } else {
      new BulkOperation(new JBulkOperation(emptyObj()))
    }
  }
}
