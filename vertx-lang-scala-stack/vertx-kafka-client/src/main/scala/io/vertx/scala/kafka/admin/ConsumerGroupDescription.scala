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

import io.vertx.kafka.client.common.{Node => JNode}
import org.apache.kafka.common.ConsumerGroupState
import io.vertx.core.json.JsonObject
import io.vertx.kafka.admin.{ConsumerGroupDescription => JConsumerGroupDescription}
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.scala.kafka.client.common.Node

/**
 * A detailed description of a single consumer group in the cluster

 */

class ConsumerGroupDescription(private val _asJava: JConsumerGroupDescription) {
  def asJava = _asJava
  /**
   * Set the consumer group coordinator, or null if the coordinator is not known
   */
  def setCoordinator(value: Node) = {
    asJava.setCoordinator(value.asJava)
    this
  }

  def getCoordinator: Node = {
    Node(asJava.getCoordinator())
  }

  /**
   * Set the id of the consumer group
   */
  def setGroupId(value: String) = {
    asJava.setGroupId(value)
    this
  }

  def getGroupId: String = {
    asJava.getGroupId().asInstanceOf[String]
  }

  /**
   * Set a list of the members of the consumer group
   */
  def setMembers(value: scala.collection.mutable.Buffer[MemberDescription]) = {
    asJava.setMembers(value.map(_.asJava).asJava)
    this
  }

  def getMembers: scala.collection.mutable.Buffer[MemberDescription] = {
    asJava.getMembers().asScala.map(x => MemberDescription(x))
  }

  /**
   * Set the consumer group partition assignor
   */
  def setPartitionAssignor(value: String) = {
    asJava.setPartitionAssignor(value)
    this
  }

  def getPartitionAssignor: String = {
    asJava.getPartitionAssignor().asInstanceOf[String]
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

  /**
   * Set the consumer group state, or UNKNOWN if the state is too new for us to parse
   */
  def setState(value: org.apache.kafka.common.ConsumerGroupState) = {
    asJava.setState(value)
    this
  }

  def getState: org.apache.kafka.common.ConsumerGroupState = {
    asJava.getState()
  }

}


object ConsumerGroupDescription {
  
  def apply() = {
    new ConsumerGroupDescription(new JConsumerGroupDescription(emptyObj()))
  }
  
  def apply(t: JConsumerGroupDescription) = {
    if (t != null) {
      new ConsumerGroupDescription(t)
    } else {
      new ConsumerGroupDescription(new JConsumerGroupDescription(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ConsumerGroupDescription = {
    if (json != null) {
      new ConsumerGroupDescription(new JConsumerGroupDescription(json))
    } else {
      new ConsumerGroupDescription(new JConsumerGroupDescription(emptyObj()))
    }
  }
}

