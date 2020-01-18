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

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.config.{ConfigStoreOptions => JConfigStoreOptions}

/**
 * Data object representing the configuration of a configuration store. This object describes the configuration of a
 * chunk of configuration that you retrieve. It specifies its type (type of configuration store), the format of the
 * retrieved configuration chunk, and you can also configures the store if it needs configuration to
 * retrieve the configuration chunk.
 */

class ConfigStoreOptions(private val _asJava: JConfigStoreOptions) {
  def asJava = _asJava
  /**
   * Sets the configuration of the store
   */
  def setConfig(value: io.vertx.core.json.JsonObject) = {
    asJava.setConfig(value)
    this
  }

  def getConfig: io.vertx.core.json.JsonObject = {
    asJava.getConfig()
  }

  /**
   * Sets the format of the configuration that is retrieved from the store.
   */
  def setFormat(value: String) = {
    asJava.setFormat(value)
    this
  }

  def getFormat: String = {
    asJava.getFormat().asInstanceOf[String]
  }

  /**
   * Sets whether or not the store is optional. When the configuration is retrieve, if an optional store
   * returns a failure, the failure is ignored and an empty json object is used instead (for this store).
   */
  def setOptional(value: Boolean) = {
    asJava.setOptional(value)
    this
  }

  def isOptional: Boolean = {
    asJava.isOptional().asInstanceOf[Boolean]
  }

  /**
   * Sets the configuration type
   */
  def setType(value: String) = {
    asJava.setType(value)
    this
  }

  def getType: String = {
    asJava.getType().asInstanceOf[String]
  }

}


object ConfigStoreOptions {

  def apply() = {
    new ConfigStoreOptions(new JConfigStoreOptions(emptyObj()))
  }

  def apply(t: JConfigStoreOptions) = {
    if (t != null) {
      new ConfigStoreOptions(t)
    } else {
      new ConfigStoreOptions(new JConfigStoreOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): ConfigStoreOptions = {
    if (json != null) {
      new ConfigStoreOptions(new JConfigStoreOptions(json))
    } else {
      new ConfigStoreOptions(new JConfigStoreOptions(emptyObj()))
    }
  }
}

