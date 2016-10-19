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

package io.vertx.scala.ext.auth.shiro

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Shiro auth configuration options, see Vert.x Auth Shiro component and/or Apache Shiro project.
  */

class ShiroAuthOptions(val asJava: io.vertx.ext.auth.shiro.ShiroAuthOptions) {

  /**
    * Set the Shiro auth config.
    */
  def setConfig(value:io.vertx.core.json.JsonObject) = {
    asJava.setConfig(value)
    this
  }
  def getConfig = {
    asJava.getConfig()
  }

  /**
    * Set the Shiro auth options type.
    */
  def setType(value:io.vertx.ext.auth.shiro.ShiroAuthRealmType) = {
    asJava.setType(value)
    this
  }
  def getType = {
    asJava.getType()
  }
}

object ShiroAuthOptions {
  type ShiroAuthOptionsJava = io.vertx.ext.auth.shiro.ShiroAuthOptions
  
  def apply() = {
    new ShiroAuthOptions(new ShiroAuthOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: ShiroAuthOptionsJava) = {
    if(t != null)
      new ShiroAuthOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):ShiroAuthOptions = {
    if(json != null)
      new ShiroAuthOptions(new ShiroAuthOptionsJava(json))
    else
      null
  }
}
