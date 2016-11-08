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

package io.vertx.scala.ext.stomp

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.stomp.{StompClientOptions => JStompClientOptions}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.json.JsonObject
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
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.scala.core.net.ProxyOptions

/**
  * Options used to configure a STOMP client. As a STOMP client wraps a Net client, you can also configure the
  * underlying NET client.
  */

class StompClientOptions(val asJava: JStompClientOptions) {

  /**
    * Sets the list of STOMP protocol versions accepted by the client. The list must be ordered from the lowest
    * version to the highest. By default the following list is used: `1.0, 1.1, 1.2`
    */
  def setAcceptedVersions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAcceptedVersions(value.asJava)
    this
  }
  def getAcceptedVersions = {
    asJava.getAcceptedVersions()
  }

  /**
    * Sets whether or not the automatic computation of the `content-length` header is enabled. If enabled, the
    * `content-length` header is set in all frame with a body that do not explicitly set the header. The option
    * is enabled by default.
    */
  def setAutoComputeContentLength(value: Boolean) = {
    asJava.setAutoComputeContentLength(value)
    this
  }
  def isAutoComputeContentLength = {
    asJava.isAutoComputeContentLength()
  }

  /**
    * Sets whether or not the `host` header must be dropped from the `CONNECT/STOMP` frame. Server may
    * be picky about this header (such as RabbitMQ that does not support it). Options disabled by default.
    */
  def setBypassHostHeader(value: Boolean) = {
    asJava.setBypassHostHeader(value)
    this
  }
  def isBypassHostHeader = {
    asJava.isBypassHostHeader()
  }
  def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
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

  /**
    * Sets the heartbeat configuration.
    */
  def setHeartbeat(value: JsonObject) = {
    asJava.setHeartbeat(value)
    this
  }
  def getHeartbeat = {
    asJava.getHeartbeat()
  }

  /**
    * Sets the STOMP server host. `0.0.0.0` by default.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }
  def setHostnameVerificationAlgorithm(value: String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }
  def getHostnameVerificationAlgorithm = {
    asJava.getHostnameVerificationAlgorithm()
  }
  def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }
  def getLocalAddress = {
    asJava.getLocalAddress()
  }
  def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }

  /**
    * Sets the login to use if the STOMP server is secured.
    */
  def setLogin(value: String) = {
    asJava.setLogin(value)
    this
  }
  def getLogin = {
    asJava.getLogin()
  }
  def setMetricsName(value: String) = {
    asJava.setMetricsName(value)
    this
  }
  def getMetricsName = {
    asJava.getMetricsName()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Sets the passcode to use if the STOMP server is secured.
    */
  def setPasscode(value: String) = {
    asJava.setPasscode(value)
    this
  }
  def getPasscode = {
    asJava.getPasscode()
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

  /**
    * Sets the STOMP server port. `61613` by default.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }
  def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }
  def getProxyOptions = {
    asJava.getProxyOptions()
  }
  def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }
  def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }
  def getReconnectAttempts = {
    asJava.getReconnectAttempts()
  }
  def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }
  def getReconnectInterval = {
    asJava.getReconnectInterval()
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

  /**
    * Sets whether or not an empty line should be appended to the written STOMP frame. This option is disabled by
    * default. This option is not compliant with the STOMP specification, and so is not documented on purpose.
    */
  def setTrailingLine(value: Boolean) = {
    asJava.setTrailingLine(value)
    this
  }
  def isTrailingLine = {
    asJava.isTrailingLine()
  }
  def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
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

  /**
    * Sets whether or not the connection is made using the `STOMP` command instead of the `CONNECT` command.
    * The `STOMP` command has been introduced in the 1.2 version of the protocol to ease the network analysis
    * (as `CONNECT` is also used by HTTP. To be compliant with server not implementing the 1.2 specification,
    * this option should be disabled. This option is disabled by default.
    */
  def setUseStompFrame(value: Boolean) = {
    asJava.setUseStompFrame(value)
    this
  }
  def isUseStompFrame = {
    asJava.isUseStompFrame()
  }

  /**
    * Sets the virtual host that will be used as "host" header value in the `CONNECT` frame.
    */
  def setVirtualHost(value: String) = {
    asJava.setVirtualHost(value)
    this
  }
  def getVirtualHost = {
    asJava.getVirtualHost()
  }
}

object StompClientOptions {
  
  def apply() = {
    new StompClientOptions(new JStompClientOptions(emptyObj()))
  }
  
  def apply(t: JStompClientOptions) = {
    if(t != null)
      new StompClientOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):StompClientOptions = {
    if(json != null)
      new StompClientOptions(new JStompClientOptions(json))
    else
      null
  }
}
