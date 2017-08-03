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
import io.vertx.ext.mongo.{BulkWriteOptions => JBulkWriteOptions}

/**
  * Options for configuring bulk write operations.
  */
class BulkWriteOptions(private val _asJava: JBulkWriteOptions) {

  def asJava = _asJava

  /**
    * Set the ordered option
    */
  def setOrdered(value: Boolean) = {
    asJava.setOrdered(value)
    this
  }
  def isOrdered: Boolean = {
    asJava.isOrdered().asInstanceOf[Boolean]
  }

  /**
    * Set the write option
    */
  def setWriteOption(value: io.vertx.ext.mongo.WriteOption) = {
    asJava.setWriteOption(value)
    this
  }
  def getWriteOption: io.vertx.ext.mongo.WriteOption = {
    asJava.getWriteOption()
  }
}

object BulkWriteOptions {
  
  def apply() = {
    new BulkWriteOptions(new JBulkWriteOptions(emptyObj()))
  }
  
  def apply(t: JBulkWriteOptions) = {
    if (t != null) {
      new BulkWriteOptions(t)
    } else {
      new BulkWriteOptions(new JBulkWriteOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): BulkWriteOptions = {
    if (json != null) {
      new BulkWriteOptions(new JBulkWriteOptions(json))
    } else {
      new BulkWriteOptions(new JBulkWriteOptions(emptyObj()))
    }
  }
}
