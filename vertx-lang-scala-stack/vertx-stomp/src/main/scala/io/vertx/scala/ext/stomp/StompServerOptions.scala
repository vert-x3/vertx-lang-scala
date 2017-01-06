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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetServerOptions => ExtNetServerOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.scala.core.net.PfxOptions
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.ext.stomp.{StompServerOptions => JStompServerOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * STOMP Server options. You can also configure the Net Server used by the STOMP server from these options.
  */
class StompServerOptions(private val _asJava: JStompServerOptions) 
    extends ExtNetServerOptions(_asJava) {

  override def asJava = _asJava
  override def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  override def getAcceptBacklog: Int = {
    asJava.getAcceptBacklog().asInstanceOf[Int]
  }
  override def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  override def getClientAuth: io.vertx.core.http.ClientAuth = {
    asJava.getClientAuth()
  }
  override def setClientAuthRequired(value: Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  override def isClientAuthRequired: Boolean = {
    asJava.isClientAuthRequired().asInstanceOf[Boolean]
  }
  override def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  override def getCrlPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getCrlPaths().asScala.map(x => x.asInstanceOf[String])
  }
  override def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }
  override def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
    asJava.getCrlValues().asScala.map(x => x)
  }
  override def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  override def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
    asJava.getEnabledCipherSuites().asScala.map(x => x.asInstanceOf[String])
  }
  override def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  override def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSecureTransportProtocols().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Sets the heartbeat configuration.
    */
  def setHeartbeat(value: io.vertx.core.json.JsonObject) = {
    asJava.setHeartbeat(value)
    this
  }
  def getHeartbeat: io.vertx.core.json.JsonObject = {
    asJava.getHeartbeat()
  }
  override def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  override def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }
  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout().asInstanceOf[Int]
  }
  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }

  /**
    * Sets the max body length accepted by the server. 10 Mb by default.
    */
  def setMaxBodyLength(value: Int) = {
    asJava.setMaxBodyLength(value)
    this
  }
  def getMaxBodyLength: Int = {
    asJava.getMaxBodyLength().asInstanceOf[Int]
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
  def getMaxFrameInTransaction: Int = {
    asJava.getMaxFrameInTransaction().asInstanceOf[Int]
  }

  /**
    * Sets the max header length.
    */
  def setMaxHeaderLength(value: Int) = {
    asJava.setMaxHeaderLength(value)
    this
  }
  def getMaxHeaderLength: Int = {
    asJava.getMaxHeaderLength().asInstanceOf[Int]
  }

  /**
    * Sets the maximum number of headers. 1000 by default.
    */
  def setMaxHeaders(value: Int) = {
    asJava.setMaxHeaders(value)
    this
  }
  def getMaxHeaders: Int = {
    asJava.getMaxHeaders().asInstanceOf[Int]
  }

  /**
    * Sets the maximum of subscriptions a client is allowed to register. If a client exceeds this number, it receives
    * an error and the connection is closed.
    */
  def setMaxSubscriptionsByClient(value: Int) = {
    asJava.setMaxSubscriptionsByClient(value)
    this
  }
  def getMaxSubscriptionsByClient: Int = {
    asJava.getMaxSubscriptionsByClient().asInstanceOf[Int]
  }
  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }
  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  /**
    * Sets the port on which the server is going to listen for TCP connection.
    */
  override def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  override def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }
  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }
  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }

  /**
    * Enables or disables the server security feature. It requires an [[io.vertx.scala.ext.auth.AuthProvider]] handler.
    */
  def setSecured(value: Boolean) = {
    asJava.setSecured(value)
    this
  }
  def isSecured: Boolean = {
    asJava.isSecured().asInstanceOf[Boolean]
  }
  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
    * Sets whether or not an error is sent to the client when this client sends a message to an not subscribed
    * destinations (no subscriptions on this destination).
    */
  def setSendErrorOnNoSubscriptions(value: Boolean) = {
    asJava.setSendErrorOnNoSubscriptions(value)
    this
  }
  def isSendErrorOnNoSubscriptions: Boolean = {
    asJava.isSendErrorOnNoSubscriptions().asInstanceOf[Boolean]
  }
  override def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  override def getSoLinger: Int = {
    asJava.getSoLinger().asInstanceOf[Int]
  }
  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  override def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
  }

  /**
    * Sets the STOMP protocol versions supported by the server. Versions must be given in the decreasing order.
    */
  def setSupportedVersions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setSupportedVersions(value.asJava)
    this
  }
  def getSupportedVersions: scala.collection.mutable.Buffer[String] = {
    asJava.getSupportedVersions().asScala.map(x => x.asInstanceOf[String])
  }
  override def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  override def isTcpKeepAlive: Boolean = {
    asJava.isTcpKeepAlive().asInstanceOf[Boolean]
  }
  override def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  override def isTcpNoDelay: Boolean = {
    asJava.isTcpNoDelay().asInstanceOf[Boolean]
  }

  /**
    * Sets the time factor.
    */
  def setTimeFactor(value: Int) = {
    asJava.setTimeFactor(value)
    this
  }
  def getTimeFactor: Int = {
    asJava.getTimeFactor().asInstanceOf[Int]
  }
  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  override def getTrafficClass: Int = {
    asJava.getTrafficClass().asInstanceOf[Int]
  }

  /**
    * Sets whether or not an empty line should be appended to the written STOMP frame. This option is disabled by
    * default. This option is not compliant with the STOMP specification, and so is not documented on purpose.
    */
  def setTrailingLine(value: Boolean) = {
    asJava.setTrailingLine(value)
    this
  }
  def isTrailingLine: Boolean = {
    asJava.isTrailingLine().asInstanceOf[Boolean]
  }

  /**
    * Sets the chunk size when replaying a transaction. To avoid blocking the event loop for too long, large
    * transactions are split into chunks, replayed one by one. This settings sets the chunk size.
    */
  def setTransactionChunkSize(value: Int) = {
    asJava.setTransactionChunkSize(value)
    this
  }
  def getTransactionChunkSize: Int = {
    asJava.getTransactionChunkSize().asInstanceOf[Int]
  }
  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }
  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn().asInstanceOf[Boolean]
  }
  override def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  override def isUsePooledBuffers: Boolean = {
    asJava.isUsePooledBuffers().asInstanceOf[Boolean]
  }

  /**
    * Enables or disables the web socket bridge.
    */
  def setWebsocketBridge(value: Boolean) = {
    asJava.setWebsocketBridge(value)
    this
  }
  def isWebsocketBridge: Boolean = {
    asJava.isWebsocketBridge().asInstanceOf[Boolean]
  }

  /**
    * Sets the websocket path. Only frames received on this path would be considered as STOMP frame.
    */
  def setWebsocketPath(value: String) = {
    asJava.setWebsocketPath(value)
    this
  }
  def getWebsocketPath: String = {
    asJava.getWebsocketPath().asInstanceOf[String]
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
