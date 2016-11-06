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
import io.vertx.ext.stomp.{StompServerOptions => JStompServerOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
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
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
import io.vertx.scala.core.net.NetServerOptions

/**
  * STOMP Server options. You can also configure the Net Server used by the STOMP server from these options.
  */

class StompServerOptions(val asJava: JStompServerOptions) {
  def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  def getAcceptBacklog = {
    asJava.getAcceptBacklog()
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
  def addCrlValue(value: JBuffer) = {
    asJava.addCrlValue(value)
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

  /**
    * Sets the max body length accepted by the server. 10 Mb by default.
    */
  def setMaxBodyLength(value: Int) = {
    asJava.setMaxBodyLength(value)
    this
  }
  def getMaxBodyLength = {
    asJava.getMaxBodyLength()
  }

  /**
    * Sets the maximum number of frame that can be added in a transaction. If the number of frame added to a
    * transaction exceeds this threshold, the client receives an `ERROR` frame and is disconnected. The default
    * is 1000.
    */
  def setMaxFrameInTransaction(value: Int) = {
    asJava.setMaxFrameInTransaction(value)
    this
  }
  def getMaxFrameInTransaction = {
    asJava.getMaxFrameInTransaction()
  }

  /**
    * Sets the max header length.
    */
  def setMaxHeaderLength(value: Int) = {
    asJava.setMaxHeaderLength(value)
    this
  }
  def getMaxHeaderLength = {
    asJava.getMaxHeaderLength()
  }

  /**
    * Sets the maximum number of headers. 1000 by default.
    */
  def setMaxHeaders(value: Int) = {
    asJava.setMaxHeaders(value)
    this
  }
  def getMaxHeaders = {
    asJava.getMaxHeaders()
  }

  /**
    * Sets the maximum of subscriptions a client is allowed to register. If a client exceeds this number, it receives
    * an error and the connection is closed.
    */
  def setMaxSubscriptionsByClient(value: Int) = {
    asJava.setMaxSubscriptionsByClient(value)
    this
  }
  def getMaxSubscriptionsByClient = {
    asJava.getMaxSubscriptionsByClient()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
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
    * Sets the port on which the server is going to listen for TCP connection.
    */
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

  /**
    * Enables or disables the server security feature. It requires an [[io.vertx.scala.ext.auth.AuthProvider]] handler.
    */
  def setSecured(value: Boolean) = {
    asJava.setSecured(value)
    this
  }
  def isSecured = {
    asJava.isSecured()
  }
  def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Sets whether or not an error is sent to the client when this client sends a message to an not subscribed
    * destinations (no subscriptions on this destination).
    */
  def setSendErrorOnNoSubscriptions(value: Boolean) = {
    asJava.setSendErrorOnNoSubscriptions(value)
    this
  }
  def isSendErrorOnNoSubscriptions = {
    asJava.isSendErrorOnNoSubscriptions()
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

  /**
    * Sets the STOMP protocol versions supported by the server. Versions must be given in the decreasing order.
    */
  def setSupportedVersions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setSupportedVersions(value.asJava)
    this
  }
  def getSupportedVersions = {
    asJava.getSupportedVersions()
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

  /**
    * Sets the time factor.
    */
  def setTimeFactor(value: Int) = {
    asJava.setTimeFactor(value)
    this
  }
  def getTimeFactor = {
    asJava.getTimeFactor()
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

  /**
    * Sets the chunk size when replaying a transaction. To avoid blocking the event loop for too long, large
    * transactions are split into chunks, replayed one by one. This settings sets the chunk size.
    */
  def setTransactionChunkSize(value: Int) = {
    asJava.setTransactionChunkSize(value)
    this
  }
  def getTransactionChunkSize = {
    asJava.getTransactionChunkSize()
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
    * Enables or disables the web socket bridge.
    */
  def setWebsocketBridge(value: Boolean) = {
    asJava.setWebsocketBridge(value)
    this
  }
  def isWebsocketBridge = {
    asJava.isWebsocketBridge()
  }

  /**
    * Sets the websocket path. Only frames received on this path would be considered as STOMP frame.
    */
  def setWebsocketPath(value: String) = {
    asJava.setWebsocketPath(value)
    this
  }
  def getWebsocketPath = {
    asJava.getWebsocketPath()
  }
}

object StompServerOptions {
  
  def apply() = {
    new StompServerOptions(new JStompServerOptions(emptyObj()))
  }
  
  def apply(t: JStompServerOptions) = {
    if(t != null)
      new StompServerOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):StompServerOptions = {
    if(json != null)
      new StompServerOptions(new JStompServerOptions(json))
    else
      null
  }
}
