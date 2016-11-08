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

package io.vertx.scala.core.net

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}

/**
  * Configures a <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a> to use OpenSsl.
  */

class OpenSSLEngineOptions(val asJava: JOpenSSLEngineOptions) {

  /**
    */

  /**
    */

  /**
    * Set whether session cache is enabled in open SSL session server context
    */
  def setSessionCacheEnabled(value: Boolean) = {
    asJava.setSessionCacheEnabled(value)
    this
  }
  def isSessionCacheEnabled = {
    asJava.isSessionCacheEnabled()
  }
}

object OpenSSLEngineOptions {
  
  def apply() = {
    new OpenSSLEngineOptions(new JOpenSSLEngineOptions(emptyObj()))
  }
  
  def apply(t: JOpenSSLEngineOptions) = {
    if(t != null)
      new OpenSSLEngineOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):OpenSSLEngineOptions = {
    if(json != null)
      new OpenSSLEngineOptions(new JOpenSSLEngineOptions(json))
    else
      null
  }
}
