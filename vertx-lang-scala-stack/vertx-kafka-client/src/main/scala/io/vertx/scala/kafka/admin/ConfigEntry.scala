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
import io.vertx.kafka.admin.{ConfigEntry => JConfigEntry}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A class representing a configuration entry containing name, value and additional metadata

 */

class ConfigEntry(private val _asJava: JConfigEntry) {
  def asJava = _asJava
  /**
   * Set whether the config value is the default or if it's been explicitly set
   */
  def setDefault(value: Boolean) = {
    asJava.setDefault(value)
    this
  }

  def isDefault: Boolean = {
    asJava.isDefault().asInstanceOf[Boolean]
  }

  /**
   * Set the config name
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set whether the config is read-only and cannot be updated
   */
  def setReadOnly(value: Boolean) = {
    asJava.setReadOnly(value)
    this
  }

  def isReadOnly: Boolean = {
    asJava.isReadOnly().asInstanceOf[Boolean]
  }

  /**
   * Set whether the config value is sensitive. The value is always set to null by the broker if the config value is sensitive
   */
  def setSensitive(value: Boolean) = {
    asJava.setSensitive(value)
    this
  }

  def isSensitive: Boolean = {
    asJava.isSensitive().asInstanceOf[Boolean]
  }

  /**
   * Set the source of this configuration entry
   */
  def setSource(value: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource) = {
    asJava.setSource(value)
    this
  }

  def getSource: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource = {
    asJava.getSource()
  }

  /**
   * Set all config values that may be used as the value of this config along with their source, in the order of precedence
   */
  def setSynonyms(value: scala.collection.mutable.Buffer[ConfigSynonym]) = {
    asJava.setSynonyms(value.map(_.asJava).asJava)
    this
  }

  def getSynonyms: scala.collection.mutable.Buffer[ConfigSynonym] = {
    asJava.getSynonyms().asScala.map(x => ConfigSynonym(x))
  }

  /**
   * Set the value or null. Null is returned if the config is unset or if isSensitive is true
   */
  def setValue(value: String) = {
    asJava.setValue(value)
    this
  }

  def getValue: String = {
    asJava.getValue().asInstanceOf[String]
  }

}


object ConfigEntry {

  def apply() = {
    new ConfigEntry(new JConfigEntry(emptyObj()))
  }

  def apply(t: JConfigEntry) = {
    if (t != null) {
      new ConfigEntry(t)
    } else {
      new ConfigEntry(new JConfigEntry(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ConfigEntry = {
    if (json != null) {
      new ConfigEntry(new JConfigEntry(json))
    } else {
      new ConfigEntry(new JConfigEntry(emptyObj()))
    }
  }
}

