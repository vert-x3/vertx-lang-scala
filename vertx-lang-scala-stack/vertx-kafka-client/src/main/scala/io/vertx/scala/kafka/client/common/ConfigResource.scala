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

package io.vertx.scala.kafka.client.common

import io.vertx.kafka.client.common.{ConfigResource => JConfigResource}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import org.apache.kafka.common.config.ConfigResource.Type

/**
 * A class representing resources that have configuration

 */

class ConfigResource(private val _asJava: JConfigResource) {
  def asJava = _asJava
  /**
   * Set if this is the default resource of a resource type. Resource name is empty for the default resource.
   */
  def setDefault(value: Boolean) = {
    asJava.setDefault(value)
    this
  }

  def isDefault: Boolean = {
    asJava.isDefault().asInstanceOf[Boolean]
  }

  /**
   * Set the resource name
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set the resource type
   */
  def setType(value: org.apache.kafka.common.config.ConfigResource.Type) = {
    asJava.setType(value)
    this
  }

  def getType: org.apache.kafka.common.config.ConfigResource.Type = {
    asJava.getType()
  }

}


object ConfigResource {
  
  def apply() = {
    new ConfigResource(new JConfigResource(emptyObj()))
  }
  
  def apply(t: JConfigResource) = {
    if (t != null) {
      new ConfigResource(t)
    } else {
      new ConfigResource(new JConfigResource(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ConfigResource = {
    if (json != null) {
      new ConfigResource(new JConfigResource(json))
    } else {
      new ConfigResource(new JConfigResource(emptyObj()))
    }
  }
}

