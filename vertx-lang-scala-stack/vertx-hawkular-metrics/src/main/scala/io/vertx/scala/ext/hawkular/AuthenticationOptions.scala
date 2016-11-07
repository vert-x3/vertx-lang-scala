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

package io.vertx.scala.ext.hawkular

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.hawkular.{AuthenticationOptions => JAuthenticationOptions}

/**
  * Authentication options.
  */

class AuthenticationOptions(val asJava: JAuthenticationOptions) {

  /**
    * Set whether authentication is enabled. Defaults to `false`.
    */
  def setEnabled(value: Boolean) = {
    asJava.setEnabled(value)
    this
  }
  def isEnabled = {
    asJava.isEnabled()
  }

  /**
    * Set the identifier used for authentication.
    */
  def setId(value: String) = {
    asJava.setId(value)
    this
  }
  def getId = {
    asJava.getId()
  }

  /**
    * Set the secret used for authentication.
    */
  def setSecret(value: String) = {
    asJava.setSecret(value)
    this
  }
  def getSecret = {
    asJava.getSecret()
  }
}

object AuthenticationOptions {
  
  def apply() = {
    new AuthenticationOptions(new JAuthenticationOptions(emptyObj()))
  }
  
  def apply(t: JAuthenticationOptions) = {
    if(t != null)
      new AuthenticationOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):AuthenticationOptions = {
    if(json != null)
      new AuthenticationOptions(new JAuthenticationOptions(json))
    else
      null
  }
}
