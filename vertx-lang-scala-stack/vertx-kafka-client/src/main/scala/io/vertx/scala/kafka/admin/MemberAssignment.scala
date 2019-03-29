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

import io.vertx.kafka.admin.{MemberAssignment => JMemberAssignment}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.scala.kafka.client.common.TopicPartition

/**
 * A description of the assignments of a specific group member

 */

class MemberAssignment(private val _asJava: JMemberAssignment) {
  def asJava = _asJava
  /**
   * Set the list of topic partitions
   */
  def setTopicPartitions(value: Set[TopicPartition]) = {
    asJava.setTopicPartitions(value.map(_.asJava).asJava)
    this
  }

  def getTopicPartitions: scala.collection.mutable.Set[TopicPartition] = {
    asJava.getTopicPartitions().asScala.map(x => TopicPartition(x))
  }

}


object MemberAssignment {
  
  def apply() = {
    new MemberAssignment(new JMemberAssignment(emptyObj()))
  }
  
  def apply(t: JMemberAssignment) = {
    if (t != null) {
      new MemberAssignment(t)
    } else {
      new MemberAssignment(new JMemberAssignment(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MemberAssignment = {
    if (json != null) {
      new MemberAssignment(new JMemberAssignment(json))
    } else {
      new MemberAssignment(new JMemberAssignment(emptyObj()))
    }
  }
}

