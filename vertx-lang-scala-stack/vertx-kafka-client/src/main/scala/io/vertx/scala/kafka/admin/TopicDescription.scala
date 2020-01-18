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

import io.vertx.kafka.client.common.{TopicPartitionInfo => JTopicPartitionInfo}
import io.vertx.scala.kafka.client.common.TopicPartitionInfo
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.kafka.admin.{TopicDescription => JTopicDescription}

/**
 * A detailed description of a single topic in the cluster

 */

class TopicDescription(private val _asJava: JTopicDescription) {
  def asJava = _asJava
  /**
   * Set whether the topic is internal to Kafka.
   */
  def setInternal(value: Boolean) = {
    asJava.setInternal(value)
    this
  }

  def isInternal: Boolean = {
    asJava.isInternal().asInstanceOf[Boolean]
  }

  /**
   * Set the name of the topic.
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set A list of partitions where the index represents the partition id and the element
   * contains leadership and replica information for that partition.
   */
  def setPartitions(value: scala.collection.mutable.Buffer[TopicPartitionInfo]) = {
    asJava.setPartitions(value.map(_.asJava).asJava)
    this
  }

  def getPartitions: scala.collection.mutable.Buffer[TopicPartitionInfo] = {
    asJava.getPartitions().asScala.map(x => TopicPartitionInfo(x))
  }

}


object TopicDescription {

  def apply() = {
    new TopicDescription(new JTopicDescription(emptyObj()))
  }

  def apply(t: JTopicDescription) = {
    if (t != null) {
      new TopicDescription(t)
    } else {
      new TopicDescription(new JTopicDescription(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): TopicDescription = {
    if (json != null) {
      new TopicDescription(new JTopicDescription(json))
    } else {
      new TopicDescription(new JTopicDescription(emptyObj()))
    }
  }
}

