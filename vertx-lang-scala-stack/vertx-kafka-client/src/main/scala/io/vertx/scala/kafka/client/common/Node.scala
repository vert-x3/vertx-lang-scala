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
import io.vertx.kafka.client.common.{Node => JNode}

/**
  * Information about a Kafka cluster node
  */
class Node(private val _asJava: JNode) {

  def asJava = _asJava

  /**
    */

  /**
    * Set if this node has a defined rack
    */
  def setHasRack(value: Boolean) = {
    asJava.setHasRack(value)
    this
  }

  /**
    * Set the host name for this node
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
    * Set the node id of this node
    */
  def setId(value: Int) = {
    asJava.setId(value)
    this
  }
  def getId: Int = {
    asJava.getId().asInstanceOf[Int]
  }

  /**
    * Set the string representation of the node id
    */
  def setIdString(value: String) = {
    asJava.setIdString(value)
    this
  }
  def getIdString: String = {
    asJava.getIdString().asInstanceOf[String]
  }

  /**
    * Set if this node is empty
    */
  def setIsEmpty(value: Boolean) = {
    asJava.setIsEmpty(value)
    this
  }

  /**
    * Set the port for this node
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
    * Set the rack for this node
    */
  def setRack(value: String) = {
    asJava.setRack(value)
    this
  }
}

object Node {
  
  def apply() = {
    new Node(new JNode(emptyObj()))
  }
  
  def apply(t: JNode) = {
    if (t != null) {
      new Node(t)
    } else {
      null
    }
  }
  
  def fromJson(json: JsonObject): Node = {
    if (json != null) {
      new Node(new JNode(json))
    } else {
      null
    }
  }
}
