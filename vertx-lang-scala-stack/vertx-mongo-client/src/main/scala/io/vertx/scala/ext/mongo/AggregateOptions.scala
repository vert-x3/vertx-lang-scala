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

import io.vertx.ext.mongo.{AggregateOptions => JAggregateOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options used to configure aggregate operations.
 */

class AggregateOptions(private val _asJava: JAggregateOptions) {
  def asJava = _asJava
  /**
   * Set the flag if writing to temporary files is enabled.
   */
  def setAllowDiskUse(value: Boolean) = {
    asJava.setAllowDiskUse(value)
    this
  }

  def getAllowDiskUse: Boolean = {
    asJava.getAllowDiskUse().asInstanceOf[Boolean]
  }

  /**
   * Set the batch size for methods loading found data in batches.
   */
  def setBatchSize(value: Int) = {
    asJava.setBatchSize(value)
    this
  }

  def getBatchSize: Int = {
    asJava.getBatchSize().asInstanceOf[Int]
  }

  /**
   * The maximum amount of time for the server to wait on new documents to satisfy a $changeStream aggregation.
   */
  def setMaxAwaitTime(value: Long) = {
    asJava.setMaxAwaitTime(value)
    this
  }

  def getMaxAwaitTime: Long = {
    asJava.getMaxAwaitTime().asInstanceOf[Long]
  }

  /**
   * Set the time limit in milliseconds for processing operations on a cursor.
   */
  def setMaxTime(value: Long) = {
    asJava.setMaxTime(value)
    this
  }

  def getMaxTime: Long = {
    asJava.getMaxTime().asInstanceOf[Long]
  }

}


object AggregateOptions {

  def apply() = {
    new AggregateOptions(new JAggregateOptions(emptyObj()))
  }

  def apply(t: JAggregateOptions) = {
    if (t != null) {
      new AggregateOptions(t)
    } else {
      new AggregateOptions(new JAggregateOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): AggregateOptions = {
    if (json != null) {
      new AggregateOptions(new JAggregateOptions(json))
    } else {
      new AggregateOptions(new JAggregateOptions(emptyObj()))
    }
  }
}

