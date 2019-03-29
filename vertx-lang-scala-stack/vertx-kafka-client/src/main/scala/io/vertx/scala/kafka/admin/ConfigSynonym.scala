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

import org.apache.kafka.clients.admin.ConfigEntry.ConfigSource
import io.vertx.kafka.admin.{ConfigSynonym => JConfigSynonym}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Class representing a configuration synonym of a <a href="../../../../../../../cheatsheet/ConfigEntry.html">ConfigEntry</a>

 */

class ConfigSynonym(private val _asJava: JConfigSynonym) {
  def asJava = _asJava
  /**
   * Set the name of this configuration
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set the source of this configuration
   */
  def setSource(value: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource) = {
    asJava.setSource(value)
    this
  }

  def getSource: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource = {
    asJava.getSource()
  }

  /**
   * Set the value of this configuration, which may be null if the configuration is sensitive
   */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }

  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }

}


object ConfigSynonym {
  
  def apply() = {
    new ConfigSynonym(new JConfigSynonym(emptyObj()))
  }
  
  def apply(t: JConfigSynonym) = {
    if (t != null) {
      new ConfigSynonym(t)
    } else {
      new ConfigSynonym(new JConfigSynonym(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ConfigSynonym = {
    if (json != null) {
      new ConfigSynonym(new JConfigSynonym(json))
    } else {
      new ConfigSynonym(new JConfigSynonym(emptyObj()))
    }
  }
}

