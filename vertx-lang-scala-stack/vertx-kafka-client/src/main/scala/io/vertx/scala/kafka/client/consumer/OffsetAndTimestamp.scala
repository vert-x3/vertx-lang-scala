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

package io.vertx.scala.kafka.client.consumer

import io.vertx.kafka.client.consumer.{OffsetAndTimestamp => JOffsetAndTimestamp}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Represent information related to a Offset with timestamp information

 */

class OffsetAndTimestamp(private val _asJava: JOffsetAndTimestamp) {
  def asJava = _asJava
  /**
   * Set the offset
   */
  def setOffset(value: Long) = {
    asJava.setOffset(value)
    this
  }

  def getOffset: Long = {
    asJava.getOffset().asInstanceOf[Long]
  }

  /**
   * Set the timestamp
   */
  def setTimestamp(value: Long) = {
    asJava.setTimestamp(value)
    this
  }

  def getTimestamp: Long = {
    asJava.getTimestamp().asInstanceOf[Long]
  }

}


object OffsetAndTimestamp {

  def apply() = {
    new OffsetAndTimestamp(new JOffsetAndTimestamp(emptyObj()))
  }

  def apply(t: JOffsetAndTimestamp) = {
    if (t != null) {
      new OffsetAndTimestamp(t)
    } else {
      new OffsetAndTimestamp(new JOffsetAndTimestamp(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): OffsetAndTimestamp = {
    if (json != null) {
      new OffsetAndTimestamp(new JOffsetAndTimestamp(json))
    } else {
      new OffsetAndTimestamp(new JOffsetAndTimestamp(emptyObj()))
    }
  }
}

