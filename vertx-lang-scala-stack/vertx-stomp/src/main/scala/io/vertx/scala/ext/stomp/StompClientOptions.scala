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

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.ext.stomp.{StompClientOptions => JStompClientOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * Options used to configure a STOMP client. As a STOMP client wraps a Net client, you can also configure the
 * underlying NET client.
 */

class StompClientOptions(private val _asJava: JStompClientOptions) extends ExtNetClientOptions(_asJava) {
  override def asJava = _asJava
  /**
   * Sets the list of STOMP protocol versions accepted by the client. The list must be ordered from the lowest
   * version to the highest. By default the following list is used: `1.0, 1.1, 1.2`
   */
  def setAcceptedVersions(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setAcceptedVersions(value.asJava)
    this
  }

  def getAcceptedVersions: scala.collection.mutable.Buffer[String] = {
    asJava.getAcceptedVersions().asScala.map(x => x.asInstanceOf[String])
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

  def isAutoComputeContentLength: Boolean = {
    asJava.isAutoComputeContentLength().asInstanceOf[Boolean]
  }

  /**
   * Sets whether or not the `host` header must be dropped from the `CONNECT/STOMP` frame. Server may
   * be picky about this header (such as RabbitMQ that does not support it). Options disabled by default.
   */
  def setBypassHostHeader(value: Boolean) = {
    asJava.setBypassHostHeader(value)
    this
  }

  def isBypassHostHeader: Boolean = {
    asJava.isBypassHostHeader().asInstanceOf[Boolean]
  }

  override def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }

  override def getConnectTimeout: Int = {
    asJava.getConnectTimeout().asInstanceOf[Int]
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

  override def setEnabledSecureTransportProtocols(value: Set[String]) = {
    asJava.setEnabledSecureTransportProtocols(value.asJava)
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

  /**
   * Sets the STOMP server host. `0.0.0.0` by default.
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  override def setHostnameVerificationAlgorithm(value: String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }

  override def getHostnameVerificationAlgorithm: String = {
    asJava.getHostnameVerificationAlgorithm().asInstanceOf[String]
  }

  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }

  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout().asInstanceOf[Int]
  }

  override def setIdleTimeoutUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setIdleTimeoutUnit(value)
    this
  }

  override def getIdleTimeoutUnit: java.util.concurrent.TimeUnit = {
    asJava.getIdleTimeoutUnit()
  }

  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  override def getJdkSslEngineOptions: JdkSSLEngineOptions = {
    JdkSSLEngineOptions(asJava.getJdkSslEngineOptions())
  }

  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  override def getKeyStoreOptions: JksOptions = {
    JksOptions(asJava.getKeyStoreOptions())
  }

  override def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }

  override def getLocalAddress: String = {
    asJava.getLocalAddress().asInstanceOf[String]
  }

  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }

  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }

  /**
   * Sets the login to use if the STOMP server is secured.
   */
  def setLogin(value: String) = {
    asJava.setLogin(value)
    this
  }

  def getLogin: String = {
    asJava.getLogin().asInstanceOf[String]
  }

  override def setMetricsName(value: String) = {
    asJava.setMetricsName(value)
    this
  }

  override def getMetricsName: String = {
    asJava.getMetricsName().asInstanceOf[String]
  }

  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  override def getOpenSslEngineOptions: OpenSSLEngineOptions = {
    OpenSSLEngineOptions(asJava.getOpenSslEngineOptions())
  }

  /**
   * Sets the passcode to use if the STOMP server is secured.
   */
  def setPasscode(value: String) = {
    asJava.setPasscode(value)
    this
  }

  def getPasscode: String = {
    asJava.getPasscode().asInstanceOf[String]
  }

  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  override def getPemKeyCertOptions: PemKeyCertOptions = {
    PemKeyCertOptions(asJava.getPemKeyCertOptions())
  }

  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  override def getPemTrustOptions: PemTrustOptions = {
    PemTrustOptions(asJava.getPemTrustOptions())
  }

  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  override def getPfxKeyCertOptions: PfxOptions = {
    PfxOptions(asJava.getPfxKeyCertOptions())
  }

  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  override def getPfxTrustOptions: PfxOptions = {
    PfxOptions(asJava.getPfxTrustOptions())
  }

  /**
   * Sets the STOMP server port. `61613` by default.
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  override def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }

  override def getProxyOptions: ProxyOptions = {
    ProxyOptions(asJava.getProxyOptions())
  }

  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }

  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }

  override def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }

  override def getReconnectAttempts: Int = {
    asJava.getReconnectAttempts().asInstanceOf[Int]
  }

  override def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }

  override def getReconnectInterval: Long = {
    asJava.getReconnectInterval().asInstanceOf[Long]
  }

  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }

  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }

  override def setReusePort(value: Boolean) = {
    asJava.setReusePort(value)
    this
  }

  override def isReusePort: Boolean = {
    asJava.isReusePort().asInstanceOf[Boolean]
  }

  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
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

  override def setSslHandshakeTimeout(value: Long) = {
    asJava.setSslHandshakeTimeout(value)
    this
  }

  override def getSslHandshakeTimeout: Long = {
    asJava.getSslHandshakeTimeout().asInstanceOf[Long]
  }

  override def setSslHandshakeTimeoutUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setSslHandshakeTimeoutUnit(value)
    this
  }

  override def getSslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = {
    asJava.getSslHandshakeTimeoutUnit()
  }

  override def setTcpCork(value: Boolean) = {
    asJava.setTcpCork(value)
    this
  }

  override def isTcpCork: Boolean = {
    asJava.isTcpCork().asInstanceOf[Boolean]
  }

  override def setTcpFastOpen(value: Boolean) = {
    asJava.setTcpFastOpen(value)
    this
  }

  override def isTcpFastOpen: Boolean = {
    asJava.isTcpFastOpen().asInstanceOf[Boolean]
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

  override def setTcpQuickAck(value: Boolean) = {
    asJava.setTcpQuickAck(value)
    this
  }

  override def isTcpQuickAck: Boolean = {
    asJava.isTcpQuickAck().asInstanceOf[Boolean]
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

  override def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }

  override def isTrustAll: Boolean = {
    asJava.isTrustAll().asInstanceOf[Boolean]
  }

  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  override def getTrustStoreOptions: JksOptions = {
    JksOptions(asJava.getTrustStoreOptions())
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
   * Sets whether or not the connection is made using the `STOMP` command instead of the `CONNECT` command.
   * The `STOMP` command has been introduced in the 1.2 version of the protocol to ease the network analysis
   * (as `CONNECT` is also used by HTTP. To be compliant with server not implementing the 1.2 specification,
   * this option should be disabled. This option is disabled by default.
   */
  def setUseStompFrame(value: Boolean) = {
    asJava.setUseStompFrame(value)
    this
  }

  def isUseStompFrame: Boolean = {
    asJava.isUseStompFrame().asInstanceOf[Boolean]
  }

  /**
   * Sets the virtual host that will be used as "host" header value in the `CONNECT` frame.
   */
  def setVirtualHost(value: String) = {
    asJava.setVirtualHost(value)
    this
  }

  def getVirtualHost: String = {
    asJava.getVirtualHost().asInstanceOf[String]
  }

}


object StompClientOptions {

  def apply() = {
    new StompClientOptions(new JStompClientOptions(emptyObj()))
  }

  def apply(t: JStompClientOptions) = {
    if (t != null) {
      new StompClientOptions(t)
    } else {
      new StompClientOptions(new JStompClientOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): StompClientOptions = {
    if (json != null) {
      new StompClientOptions(new JStompClientOptions(json))
    } else {
      new StompClientOptions(new JStompClientOptions(emptyObj()))
    }
  }
}

