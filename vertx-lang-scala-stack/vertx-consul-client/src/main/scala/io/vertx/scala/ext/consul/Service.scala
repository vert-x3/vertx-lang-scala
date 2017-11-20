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
import io.vertx.ext.consul.{Service => JService}

/**
  * Holds properties of service and node that its containing
  */
class Service(private val _asJava: JService) {

  def asJava = _asJava

  /**
    * Set service address
    */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }
  def getAddress: String = {
    asJava.getAddress().asInstanceOf[String]
  }

  /**
    * Set ID of service
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
    * Set service name
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
    * Set node name
    */
  def setNode(value: String) = {
    asJava.setNode(value)
    this
  }
  def getNode: String = {
    asJava.getNode().asInstanceOf[String]
  }

  /**
    * Set node address
    */
  def setNodeAddress(value: String) = {
    asJava.setNodeAddress(value)
    this
  }
  def getNodeAddress: String = {
    asJava.getNodeAddress().asInstanceOf[String]
  }

  /**
    * Set service port
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
    * Set list of service tags
    */
  def setTags(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setTags(value.asJava)
    this
  }
  def getTags: scala.collection.mutable.Buffer[String] = {
    asJava.getTags().asScala.map(x => x.asInstanceOf[String])
  }
}

object Service {
  
  def apply() = {
    new Service(new JService(emptyObj()))
  }
  
  def apply(t: JService) = {
    if (t != null) {
      new Service(t)
    } else {
      new Service(new JService(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Service = {
    if (json != null) {
      new Service(new JService(json))
    } else {
      new Service(new JService(emptyObj()))
    }
  }
}
