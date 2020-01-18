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

import io.vertx.kafka.admin.{MemberDescription => JMemberDescription}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A detailed description of a single group instance in the cluster

 */

class MemberDescription(private val _asJava: JMemberDescription) {
  def asJava = _asJava
  /**
   * Set the assignment of the group member
   */
  def setAssignment(value: MemberAssignment) = {
    asJava.setAssignment(value.asJava)
    this
  }

  def getAssignment: MemberAssignment = {
    MemberAssignment(asJava.getAssignment())
  }

  /**
   * Set the client id of the group member
   */
  def setClientId(value: String) = {
    asJava.setClientId(value)
    this
  }

  def getClientId: String = {
    asJava.getClientId().asInstanceOf[String]
  }

  /**
   * Set the consumer id of the group member
   */
  def setConsumerId(value: String) = {
    asJava.setConsumerId(value)
    this
  }

  def getConsumerId: String = {
    asJava.getConsumerId().asInstanceOf[String]
  }

  /**
   * Set the host where the group member is running
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

}


object MemberDescription {

  def apply() = {
    new MemberDescription(new JMemberDescription(emptyObj()))
  }

  def apply(t: JMemberDescription) = {
    if (t != null) {
      new MemberDescription(t)
    } else {
      new MemberDescription(new JMemberDescription(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): MemberDescription = {
    if (json != null) {
      new MemberDescription(new JMemberDescription(json))
    } else {
      new MemberDescription(new JMemberDescription(emptyObj()))
    }
  }
}

