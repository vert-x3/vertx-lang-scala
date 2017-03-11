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

package io.vertx.scala.config

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.config.{ConfigChange => JConfigChange}
import io.vertx.core.json.JsonObject

/**
  * A structure representing a configuration change.
  */
class ConfigChange(private val _asJava: JConfigChange) {

  def asJava = _asJava

  /**
    * Sets the new configuration.
    */
  def setNewConfiguration(value: io.vertx.core.json.JsonObject) = {
    asJava.setNewConfiguration(value)
    this
  }
  def getNewConfiguration: io.vertx.core.json.JsonObject = {
    asJava.getNewConfiguration()
  }

  /**
    * Sets the previous configuration.
    */
  def setPreviousConfiguration(value: io.vertx.core.json.JsonObject) = {
    asJava.setPreviousConfiguration(value)
    this
  }
  def getPreviousConfiguration: io.vertx.core.json.JsonObject = {
    asJava.getPreviousConfiguration()
  }
}

object ConfigChange {
  
  def apply() = {
    new ConfigChange(new JConfigChange(emptyObj()))
  }
  
  def apply(t: JConfigChange) = {
    if (t != null) {
      new ConfigChange(t)
    } else {
      null
    }
  }
  
  def fromJson(json: JsonObject): ConfigChange = {
    if (json != null) {
      new ConfigChange(new JConfigChange(json))
    } else {
      null
    }
  }
}
