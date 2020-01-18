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

package io.vertx.scala.kafka.admin

import io.vertx.kafka.admin.{ConsumerGroupListing => JConsumerGroupListing}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A listing of a consumer group in the cluster.

 */

class ConsumerGroupListing(private val _asJava: JConsumerGroupListing) {
  def asJava = _asJava
  /**
   * Set the consumer group id
   */
  def setGroupId(value: String) = {
    asJava.setGroupId(value)
    this
  }

  def getGroupId: String = {
    asJava.getGroupId().asInstanceOf[String]
  }

  /**
   * Set if consumer group is simple or not
   */
  def setSimpleConsumerGroup(value: Boolean) = {
    asJava.setSimpleConsumerGroup(value)
    this
  }

  def isSimpleConsumerGroup: Boolean = {
    asJava.isSimpleConsumerGroup().asInstanceOf[Boolean]
  }

}


object ConsumerGroupListing {

  def apply() = {
    new ConsumerGroupListing(new JConsumerGroupListing(emptyObj()))
  }

  def apply(t: JConsumerGroupListing) = {
    if (t != null) {
      new ConsumerGroupListing(t)
    } else {
      new ConsumerGroupListing(new JConsumerGroupListing(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ConsumerGroupListing = {
    if (json != null) {
      new ConsumerGroupListing(new JConsumerGroupListing(json))
    } else {
      new ConsumerGroupListing(new JConsumerGroupListing(emptyObj()))
    }
  }
}

