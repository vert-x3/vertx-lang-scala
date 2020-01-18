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

import io.vertx.ext.consul.{AclToken => JAclToken}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Holds properties of Acl token
 */

class AclToken(private val _asJava: JAclToken) {
  def asJava = _asJava
  /**
   * Set ID of token
   */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }

  def getId: String = {
    asJava.getId().asInstanceOf[String]
  }

  /**
   * Set name of token
   */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }

  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }

  /**
   * Set rules for token
   */
  def setRules(value: String) = {
    asJava.setRules(value)
    this
  }

  def getRules: String = {
    asJava.getRules().asInstanceOf[String]
  }

  /**
   * Set type of token
   */
  def setType(value: io.vertx.ext.consul.AclTokenType) = {
    asJava.setType(value)
    this
  }

  def getType: io.vertx.ext.consul.AclTokenType = {
    asJava.getType()
  }

}


object AclToken {

  def apply() = {
    new AclToken(new JAclToken(emptyObj()))
  }

  def apply(t: JAclToken) = {
    if (t != null) {
      new AclToken(t)
    } else {
      new AclToken(new JAclToken(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): AclToken = {
    if (json != null) {
      new AclToken(new JAclToken(json))
    } else {
      new AclToken(new JAclToken(emptyObj()))
    }
  }
}

