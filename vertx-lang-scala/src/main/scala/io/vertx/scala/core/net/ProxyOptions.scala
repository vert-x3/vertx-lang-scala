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
import scala.collection.JavaConversions._
import io.vertx.core.net.{ProxyOptions => JProxyOptions}

/**
  * Proxy options for a net client or a net client.
  */

class ProxyOptions(val asJava: JProxyOptions) {

  /**
    * Set proxy host.
    */
  def setHost(value:String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Set proxy password.
    */
  def setPassword(value:String) = {
    asJava.setPassword(value)
    this
  }
  def getPassword = {
    asJava.getPassword()
  }

  /**
    * Set proxy port.
    */
  def setPort(value:Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set proxy type.
    *
    * ProxyType can be HTTP, SOCKS4 and SOCKS5
    */
  def setType(value:io.vertx.core.net.ProxyType) = {
    asJava.setType(value)
    this
  }
  def getType = {
    asJava.getType()
  }

  /**
    * Set proxy username.
    */
  def setUsername(value:String) = {
    asJava.setUsername(value)
    this
  }
  def getUsername = {
    asJava.getUsername()
  }
}

object ProxyOptions {
  
  def apply() = {
    new ProxyOptions(new JProxyOptions(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JProxyOptions) = {
    if(t != null)
      new ProxyOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):ProxyOptions = {
    if(json != null)
      new ProxyOptions(new JProxyOptions(json))
    else
      null
  }
}
