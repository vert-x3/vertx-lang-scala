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
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.kafka.admin.{ClusterDescription => JClusterDescription}
import io.vertx.scala.kafka.client.common.Node

/**
 * A detailed description of the cluster

 */

class ClusterDescription(private val _asJava: JClusterDescription) {
  def asJava = _asJava
  /**
   * Set the cluster ID
   */
  def setClusterId(value: String) = {
    asJava.setClusterId(value)
    this
  }

  def getClusterId: String = {
    asJava.getClusterId().asInstanceOf[String]
  }

  /**
   * Set the controller node.
   */
  def setController(value: Node) = {
    asJava.setController(value.asJava)
    this
  }

  def getController: Node = {
    Node(asJava.getController())
  }

  /**
   * Set the nodes belonging to this cluster
   */
  def addNode(value: Node) = {
    asJava.addNode(value.asJava)
    this
  }

  def setNodes(value: scala.collection.mutable.Buffer[Node]) = {
    asJava.setNodes(value.map(_.asJava).asJava)
    this
  }

  def getNodes: scala.collection.mutable.Buffer[Node] = {
    asJava.getNodes().asScala.map(x => Node(x))
  }

}


object ClusterDescription {

  def apply() = {
    new ClusterDescription(new JClusterDescription(emptyObj()))
  }

  def apply(t: JClusterDescription) = {
    if (t != null) {
      new ClusterDescription(t)
    } else {
      new ClusterDescription(new JClusterDescription(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ClusterDescription = {
    if (json != null) {
      new ClusterDescription(new JClusterDescription(json))
    } else {
      new ClusterDescription(new JClusterDescription(emptyObj()))
    }
  }
}

