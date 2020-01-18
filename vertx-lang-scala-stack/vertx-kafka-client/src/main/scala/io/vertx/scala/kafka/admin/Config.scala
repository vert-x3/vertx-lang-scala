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

import io.vertx.kafka.admin.{Config => JConfig}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A configuration object containing the configuration entries for a resource

 */

class Config(private val _asJava: JConfig) {
  def asJava = _asJava
  /**
   * Set the configuration entries for a resource
   */
  def setEntries(value: scala.collection.mutable.Buffer[ConfigEntry]) = {
    asJava.setEntries(value.map(_.asJava).asJava)
    this
  }

  def getEntries: scala.collection.mutable.Buffer[ConfigEntry] = {
    asJava.getEntries().asScala.map(x => ConfigEntry(x))
  }

}


object Config {

  def apply() = {
    new Config(new JConfig(emptyObj()))
  }

  def apply(t: JConfig) = {
    if (t != null) {
      new Config(t)
    } else {
      new Config(new JConfig(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): Config = {
    if (json != null) {
      new Config(new JConfig(json))
    } else {
      new Config(new JConfig(emptyObj()))
    }
  }
}

