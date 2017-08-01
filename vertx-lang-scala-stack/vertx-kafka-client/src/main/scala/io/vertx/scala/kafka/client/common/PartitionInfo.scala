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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.kafka.client.common.{PartitionInfo => JPartitionInfo}

/**
  * Information about a specific Kafka topic partition
  */
class PartitionInfo(private val _asJava: JPartitionInfo) {

  def asJava = _asJava

  /**
    * Set the subset of the replicas that are in sync
    */
  def setInSyncReplicas(value: scala.collection.mutable.Buffer[Node]) = {
    asJava.setInSyncReplicas(value.map(_.asJava).asJava)
    this
  }
  def getInSyncReplicas: scala.collection.mutable.Buffer[Node] = {
    asJava.getInSyncReplicas().asScala.map(x => Node(x))
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

object PartitionInfo {
  
  def apply() = {
    new PartitionInfo(new JPartitionInfo(emptyObj()))
  }
  
  def apply(t: JPartitionInfo) = {
    if (t != null) {
      new PartitionInfo(t)
    } else {
      new PartitionInfo(new JPartitionInfo(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): PartitionInfo = {
    if (json != null) {
      new PartitionInfo(new JPartitionInfo(json))
    } else {
      new PartitionInfo(new JPartitionInfo(emptyObj()))
    }
  }
}
