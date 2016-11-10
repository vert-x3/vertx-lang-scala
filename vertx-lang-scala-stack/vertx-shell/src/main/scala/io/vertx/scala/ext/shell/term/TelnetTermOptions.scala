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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.shell.term.{TelnetTermOptions => JTelnetTermOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PfxOptions

/**
  * Telnet terminal options configuration, extends <a href="../../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a>.
  */

class TelnetTermOptions(val asJava: JTelnetTermOptions) {

  def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  def getAcceptBacklog = {
    asJava.getAcceptBacklog()
  }

  /**
    * Set the charset to use when binary mode is active, see <a href="../../../../../../../../cheatsheet/TelnetTermOptions.html">TelnetTermOptions</a> and <a href="../../../../../../../../cheatsheet/TelnetTermOptions.html">TelnetTermOptions</a>.
    */
  def setCharset(value: String) = {
    asJava.setCharset(value)
    this
  }
  def getCharset = {
    asJava.getCharset()
  }
  def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  def getClientAuth = {
    asJava.getClientAuth()
  }
  def setClientAuthRequired(value: Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  def isClientAuthRequired = {
    asJava.isClientAuthRequired()
  }
  def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }
  def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asJava)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }
  def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }
  def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }
  def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }

  /**
    * Set the telnet connection to negociate binary data format when receiving from the client, the default value is true. This
    * allows to send data in 8 bit format and thus charset like UTF-8.
    */
  def setInBinary(value: Boolean) = {
    asJava.setInBinary(value)
    this
  }
  def getInBinary = {
    asJava.getInBinary()
  }

  /**
    * The path of the <i>inputrc</i> config.
    */
  def setIntputrc(value: String) = {
    asJava.setIntputrc(value)
    this
  }
  def getIntputrc = {
    asJava.getIntputrc()
  }
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the telnet connection to negociate binary data format when sending to the client, the default value is true. This
    * allows to send data in 8 bit format and thus charset like UTF-8.
    */
  def setOutBinary(value: Boolean) = {
    asJava.setOutBinary(value)
    this
  }
  def getOutBinary = {
    asJava.getOutBinary()
  }
  def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }
  def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }
  def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }
  def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }
  def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }
  def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }
  def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }
  def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }
  def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }
  def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }
  def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }
}

object TelnetTermOptions {
  
  def apply() = {
    new TelnetTermOptions(new JTelnetTermOptions(emptyObj()))
  }
  
  def apply(t: JTelnetTermOptions) = {
    if(t != null)
      new TelnetTermOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):TelnetTermOptions = {
    if(json != null)
      new TelnetTermOptions(new JTelnetTermOptions(json))
    else
      null
  }
}
