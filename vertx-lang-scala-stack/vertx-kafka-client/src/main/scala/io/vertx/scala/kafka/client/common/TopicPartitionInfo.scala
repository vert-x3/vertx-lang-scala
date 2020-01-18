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

import io.vertx.kafka.client.common.{TopicPartitionInfo => JTopicPartitionInfo}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A class containing leadership, replicas and ISR information for a topic partition.

 */

class TopicPartitionInfo(private val _asJava: JTopicPartitionInfo) {
  def asJava = _asJava
  /**
   * Set the subset of the replicas that are in sync
   */
  def setIsr(value: scala.collection.mutable.Buffer[Node]) = {
    asJava.setIsr(value.map(_.asJava).asJava)
    this
  }

  def getIsr: scala.collection.mutable.Buffer[Node] = {
    asJava.getIsr().asScala.map(x => Node(x))
  }

  /**
   * Set the node id of the node currently acting as a leader
   */
  def setLeader(value: Node) = {
    asJava.setLeader(value.asJava)
    this
  }

  def getLeader: Node = {
    Node(asJava.getLeader())
  }

  /**
   * Set the partition id
   */
  def setPartition(value: Int) = {
    asJava.setPartition(value)
    this
  }

  def getPartition: Int = {
    asJava.getPartition().asInstanceOf[Int]
  }

  /**
   * Set the complete set of replicas for this partition
   */
  def setReplicas(value: scala.collection.mutable.Buffer[Node]) = {
    asJava.setReplicas(value.map(_.asJava).asJava)
    this
  }

  def getReplicas: scala.collection.mutable.Buffer[Node] = {
    asJava.getReplicas().asScala.map(x => Node(x))
  }

}


object TopicPartitionInfo {

  def apply() = {
    new TopicPartitionInfo(new JTopicPartitionInfo(emptyObj()))
  }

  def apply(t: JTopicPartitionInfo) = {
    if (t != null) {
      new TopicPartitionInfo(t)
    } else {
      new TopicPartitionInfo(new JTopicPartitionInfo(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): TopicPartitionInfo = {
    if (json != null) {
      new TopicPartitionInfo(new JTopicPartitionInfo(json))
    } else {
      new TopicPartitionInfo(new JTopicPartitionInfo(emptyObj()))
    }
  }
}

