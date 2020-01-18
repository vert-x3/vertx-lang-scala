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

import io.vertx.ext.consul.{Event => JEvent}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds properties of Consul event
 */

class Event(private val _asJava: JEvent) {
  def asJava = _asJava
  /**
   * Set ID of event
   */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }

  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
   * Set the Lamport clock time
   */
  def setLTime(value: Int) = {
    asJava.setLTime(value)
    this
  }

  def getLTime: Int = {
    asJava.getLTime().asInstanceOf[Int]
  }

  /**
   * Set name of event
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set regular expression to filter by node name
   */
  def setNode(value: String) = {
    asJava.setNode(value)
    this
  }

  def getNode: String = {
    asJava.getNode().asInstanceOf[String]
  }

  /**
   * Set payload of event
   */
  def setPayload(value: String) = {
    asJava.setPayload(value)
    this
  }

  def getPayload: String = {
    asJava.getPayload().asInstanceOf[String]
  }

  /**
   * Set regular expression to filter by service
   */
  def setService(value: String) = {
    asJava.setService(value)
    this
  }

  def getService: String = {
    asJava.getService().asInstanceOf[String]
  }

  /**
   * Set regular expression to filter by tag
   */
  def setTag(value: String) = {
    asJava.setTag(value)
    this
  }

  def getTag: String = {
    asJava.getTag().asInstanceOf[String]
  }

  /**
   * Set version
   */
  def setVersion(value: Int) = {
    asJava.setVersion(value)
    this
  }

  def getVersion: Int = {
    asJava.getVersion().asInstanceOf[Int]
  }

}


object Event {

  def apply() = {
    new Event(new JEvent(emptyObj()))
  }

  def apply(t: JEvent) = {
    if (t != null) {
      new Event(t)
    } else {
      new Event(new JEvent(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): Event = {
    if (json != null) {
      new Event(new JEvent(json))
    } else {
      new Event(new JEvent(emptyObj()))
    }
  }
}

