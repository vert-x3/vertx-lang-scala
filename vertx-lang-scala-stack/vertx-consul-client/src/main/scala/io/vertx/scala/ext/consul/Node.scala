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

package io.vertx.scala.ext.consul

import io.vertx.ext.consul.{Node => JNode}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**

 */

class Node(private val _asJava: JNode) {
  def asJava = _asJava
  /**
   * Set node address
   */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }

  def getAddress: String = {
    asJava.getAddress().asInstanceOf[String]
  }

  /**
   * Set node lan address
   */
  def setLanAddress(value: String) = {
    asJava.setLanAddress(value)
    this
  }

  def getLanAddress: String = {
    asJava.getLanAddress().asInstanceOf[String]
  }

  /**
   * Set node name
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set node wan address
   */
  def setWanAddress(value: String) = {
    asJava.setWanAddress(value)
    this
  }

  def getWanAddress: String = {
    asJava.getWanAddress().asInstanceOf[String]
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
      new Node(new JNode(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Node = {
    if (json != null) {
      new Node(new JNode(json))
    } else {
      new Node(new JNode(emptyObj()))
    }
  }
}

