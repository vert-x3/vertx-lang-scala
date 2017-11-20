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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{NodeList => JNodeList}

/**
  * Holds result of nodes query
  */
class NodeList(private val _asJava: JNodeList) {

  def asJava = _asJava

  /**
    * Set Consul index, a unique identifier representing the current state of the requested list of nodes
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set list of nodes
    */
  def setList(value: scala.collection.mutable.Buffer[Node]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }
  def getList: scala.collection.mutable.Buffer[Node] = {
    asJava.getList().asScala.map(x => Node(x))
  }
}

object NodeList {
  
  def apply() = {
    new NodeList(new JNodeList(emptyObj()))
  }
  
  def apply(t: JNodeList) = {
    if (t != null) {
      new NodeList(t)
    } else {
      new NodeList(new JNodeList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): NodeList = {
    if (json != null) {
      new NodeList(new JNodeList(json))
    } else {
      new NodeList(new JNodeList(emptyObj()))
    }
  }
}
