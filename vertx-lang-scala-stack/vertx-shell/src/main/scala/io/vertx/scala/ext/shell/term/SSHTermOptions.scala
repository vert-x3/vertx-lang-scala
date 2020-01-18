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

import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.scala.core.net.JksOptions
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.json.JsonObject
import io.vertx.ext.auth.{AuthOptions => JAuthOptions}
import io.vertx.lang.scala.json.Json._
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import io.vertx.scala.ext.auth.AuthOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * The SSH term configuration options.
 */

class SSHTermOptions(private val _asJava: JSSHTermOptions) {
  def asJava = _asJava
  /**

   */
  /**
   * Set the default charset to use when the client does not specifies one.
   */
  def setDefaultCharset(value: String) = {
    asJava.setDefaultCharset(value)
    this
  }

  def getDefaultCharset: String = {
    asJava.getDefaultCharset().asInstanceOf[String]
  }

  /**
   * Set the host
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
   * The path of the <i>inputrc</i> config.
   */
  def setIntputrc(value: String) = {
    asJava.setIntputrc(value)
    this
  }

  def getIntputrc: String = {
    asJava.getIntputrc().asInstanceOf[String]
  }

  /**
   * Set the key pair options in jks format, aka Java keystore.
   */
  def setKeyPairOptions(value: JksOptions) = {
    asJava.setKeyPairOptions(value.asJava)
    this
  }

  /**
   * Set the key pair store options in pem format.
   */
  def setPemKeyPairOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyPairOptions(value.asJava)
    this
  }

  /**
   * Set the key pair options in pfx format.
   */
  def setPfxKeyPairOptions(value: PfxOptions) = {
    asJava.setPfxKeyPairOptions(value.asJava)
    this
  }

  /**
   * Set the port
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

}


object SSHTermOptions {

  def apply() = {
    new SSHTermOptions(new JSSHTermOptions(emptyObj()))
  }

  def apply(t: JSSHTermOptions) = {
    if (t != null) {
      new SSHTermOptions(t)
    } else {
      new SSHTermOptions(new JSSHTermOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): SSHTermOptions = {
    if (json != null) {
      new SSHTermOptions(new JSSHTermOptions(json))
    } else {
      new SSHTermOptions(new JSSHTermOptions(emptyObj()))
    }
  }
}

