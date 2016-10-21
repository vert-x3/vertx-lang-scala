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

package io.vertx.scala.ext.shell.term

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * The SSH term configuration options.
  */

class SSHTermOptions(val asJava: io.vertx.ext.shell.term.SSHTermOptions) {

  /**
    */

  /**
    * Set the default charset to use when the client does not specifies one.
    */
  def setDefaultCharset(value:String) = {
    asJava.setDefaultCharset(value)
    this
  }
  def getDefaultCharset = {
    asJava.getDefaultCharset()
  }

  /**
    * Set the host
    */
  def setHost(value:String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * The path of the <i>inputrc</i> config.
    */
  def setIntputrc(value:String) = {
    asJava.setIntputrc(value)
    this
  }
  def getIntputrc = {
    asJava.getIntputrc()
  }

  /**
    * Set the key pair options in jks format, aka Java keystore.
    */
  def setKeyPairOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setKeyPairOptions(value.asJava)
    this
  }

  /**
    * Set the key pair store options in pem format.
    */
  def setPemKeyPairOptions(value:io.vertx.scala.core.net.PemKeyCertOptions) = {
    asJava.setPemKeyPairOptions(value.asJava)
    this
  }

  /**
    * Set the key pair options in pfx format.
    */
  def setPfxKeyPairOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxKeyPairOptions(value.asJava)
    this
  }

  /**
    * Set the port
    */
  def setPort(value:Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }
}

object SSHTermOptions {
  type SSHTermOptionsJava = io.vertx.ext.shell.term.SSHTermOptions
  
  def apply() = {
    new SSHTermOptions(new SSHTermOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: SSHTermOptionsJava) = {
    if(t != null)
      new SSHTermOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):SSHTermOptions = {
    if(json != null)
      new SSHTermOptions(new SSHTermOptionsJava(json))
    else
      null
  }
}
