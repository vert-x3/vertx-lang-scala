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

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{EventOptions => JEventOptions}

/**
 * Options used to trigger a new user event.
 */

class EventOptions(private val _asJava: JEventOptions) {
  def asJava = _asJava
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

}


object EventOptions {
  
  def apply() = {
    new EventOptions(new JEventOptions(emptyObj()))
  }
  
  def apply(t: JEventOptions) = {
    if (t != null) {
      new EventOptions(t)
    } else {
      new EventOptions(new JEventOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): EventOptions = {
    if (json != null) {
      new EventOptions(new JEventOptions(json))
    } else {
      new EventOptions(new JEventOptions(emptyObj()))
    }
  }
}

