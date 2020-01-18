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

package io.vertx.scala.kafka.client.common

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}

/**
 * Represent information related to a partition for a topic

 */

class TopicPartition(private val _asJava: JTopicPartition) {
  def asJava = _asJava
  /**
   * Set the partition number
   */
  def setPartition(value: Int) = {
    asJava.setPartition(value)
    this
  }

  def getPartition: Int = {
    asJava.getPartition().asInstanceOf[Int]
  }

  /**
   * Set the topic name
   */
  def setTopic(value: String) = {
    asJava.setTopic(value)
    this
  }

  def getTopic: String = {
    asJava.getTopic().asInstanceOf[String]
  }

}


object TopicPartition {

  def apply() = {
    new TopicPartition(new JTopicPartition(emptyObj()))
  }

  def apply(t: JTopicPartition) = {
    if (t != null) {
      new TopicPartition(t)
    } else {
      new TopicPartition(new JTopicPartition(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): TopicPartition = {
    if (json != null) {
      new TopicPartition(new JTopicPartition(json))
    } else {
      new TopicPartition(new JTopicPartition(emptyObj()))
    }
  }
}

