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

package io.vertx.scala.core.eventbus

import io.vertx.core.eventbus.{EventBusOptions => JEventBusOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{TCPSSLOptions => ExtTCPSSLOptions}
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * Options to configure the event bus.
 */

class EventBusOptions(private val _asJava: JEventBusOptions) extends ExtTCPSSLOptions(_asJava) {
  def asJava = _asJava
  /**
   * Set the accept back log.
   */
  def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }

  def getAcceptBacklog: Int = {
    asJava.getAcceptBacklog().asInstanceOf[Int]
  }

  /**
   * Set whether client auth is required
   */
  def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }

  def getClientAuth: io.vertx.core.http.ClientAuth = {
    asJava.getClientAuth()
  }

  /**
   * Set the value of cluster ping interval, in ms.
   */
  def setClusterPingInterval(value: Long) = {
    asJava.setClusterPingInterval(value)
    this
  }

  def getClusterPingInterval: Long = {
    asJava.getClusterPingInterval().asInstanceOf[Long]
  }

  /**
   * Set the value of cluster ping reply interval, in ms.
   */
  def setClusterPingReplyInterval(value: Long) = {
    asJava.setClusterPingReplyInterval(value)
    this
  }

  def getClusterPingReplyInterval: Long = {
    asJava.getClusterPingReplyInterval().asInstanceOf[Long]
  }

  /**
   * Set the public facing hostname to be used for clustering.
   * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is
   * not the same address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of
   * proxying. If this is the case you can specify a public hostname which is different from the hostname the
   * server listens at.
   * 
   * The default value is null which means use the same as the cluster hostname.
   */
  def setClusterPublicHost(value: String) = {
    asJava.setClusterPublicHost(value)
    this
  }

  def getClusterPublicHost: String = {
    asJava.getClusterPublicHost().asInstanceOf[String]
  }

  /**
   * See <a href="../../../../../../../cheatsheet/EventBusOptions.html">EventBusOptions</a> for an explanation.
   */
  def setClusterPublicPort(value: Int) = {
    asJava.setClusterPublicPort(value)
    this
  }

  def getClusterPublicPort: Int = {
    asJava.getClusterPublicPort().asInstanceOf[Int]
  }

  /**
   * Sets whether or not the event bus is clustered.
   */
  def setClustered(value: Boolean) = {
    asJava.setClustered(value)
    this
  }

  def isClustered: Boolean = {
    asJava.isClustered().asInstanceOf[Boolean]
  }

  /**
   * Sets the connect timeout
   */
  def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }

  def getConnectTimeout: Int = {
    asJava.getConnectTimeout().asInstanceOf[Int]
  }

  /**
   * Add a CRL path
   */
  override def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }

  override def getCrlPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getCrlPaths().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Add a CRL value
   */
  override def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }

  override def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
    asJava.getCrlValues().asScala.map(x => x)
  }

  /**
   * Add an enabled cipher suite, appended to the ordered suites.
   */
  override def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }

  override def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
    asJava.getEnabledCipherSuites().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Sets the list of enabled SSL/TLS protocols.
   */
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
   * Sets the host.
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  /**
   * Set the idle timeout, default time unit is seconds. Zero means don't timeout.
   * This determines if a connection will timeout and be closed if no data is received within the timeout.
   *
   * If you want change default time unit, use <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a>
   */
  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }

  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout().asInstanceOf[Int]
  }

  /**
   * Set the idle timeout unit. If not specified, default is seconds.
   */
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

  /**
   * Set the key/cert options in jks format, aka Java keystore.
   */
  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  override def getKeyStoreOptions: JksOptions = {
    JksOptions(asJava.getKeyStoreOptions())
  }

  /**
   * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
   */
  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }

  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }

  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  override def getOpenSslEngineOptions: OpenSSLEngineOptions = {
    OpenSSLEngineOptions(asJava.getOpenSslEngineOptions())
  }

  /**
   * Set the key/cert store options in pem format.
   */
  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  override def getPemKeyCertOptions: PemKeyCertOptions = {
    PemKeyCertOptions(asJava.getPemKeyCertOptions())
  }

  /**
   * Set the trust options in pem format
   */
  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  override def getPemTrustOptions: PemTrustOptions = {
    PemTrustOptions(asJava.getPemTrustOptions())
  }

  /**
   * Set the key/cert options in pfx format.
   */
  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  override def getPfxKeyCertOptions: PfxOptions = {
    PfxOptions(asJava.getPfxKeyCertOptions())
  }

  /**
   * Set the trust options in pfx format
   */
  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  override def getPfxTrustOptions: PfxOptions = {
    PfxOptions(asJava.getPfxTrustOptions())
  }

  /**
   * Sets the port.
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  /**
   * Set the TCP receive buffer size
   */
  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }

  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }

  /**
   * Sets the value of reconnect attempts.
   */
  def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }

  def getReconnectAttempts: Int = {
    asJava.getReconnectAttempts().asInstanceOf[Int]
  }

  /**
   * Set the reconnect interval.
   */
  def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }

  def getReconnectInterval: Long = {
    asJava.getReconnectInterval().asInstanceOf[Long]
  }

  /**
   * Set the value of reuse address
   */
  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }

  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }

  /**
   * Set the value of reuse port.
   * <p/>
   * This is only supported by native transports.
   */
  override def setReusePort(value: Boolean) = {
    asJava.setReusePort(value)
    this
  }

  override def isReusePort: Boolean = {
    asJava.isReusePort().asInstanceOf[Boolean]
  }

  /**
   * Set the TCP send buffer size
   */
  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
   * Set whether SO_linger keep alive is enabled
   */
  override def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }

  override def getSoLinger: Int = {
    asJava.getSoLinger().asInstanceOf[Int]
  }

  /**
   * Set whether SSL/TLS is enabled
   */
  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }

  override def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
  }

  /**
   * Set the SSL handshake timeout, default time unit is seconds.
   */
  override def setSslHandshakeTimeout(value: Long) = {
    asJava.setSslHandshakeTimeout(value)
    this
  }

  override def getSslHandshakeTimeout: Long = {
    asJava.getSslHandshakeTimeout().asInstanceOf[Long]
  }

  /**
   * Set the SSL handshake timeout unit. If not specified, default is seconds.
   */
  override def setSslHandshakeTimeoutUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setSslHandshakeTimeoutUnit(value)
    this
  }

  override def getSslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = {
    asJava.getSslHandshakeTimeoutUnit()
  }

  /**
   * Enable the `TCP_CORK` option - only with linux native transport.
   */
  override def setTcpCork(value: Boolean) = {
    asJava.setTcpCork(value)
    this
  }

  override def isTcpCork: Boolean = {
    asJava.isTcpCork().asInstanceOf[Boolean]
  }

  /**
   * Enable the `TCP_FASTOPEN` option - only with linux native transport.
   */
  override def setTcpFastOpen(value: Boolean) = {
    asJava.setTcpFastOpen(value)
    this
  }

  override def isTcpFastOpen: Boolean = {
    asJava.isTcpFastOpen().asInstanceOf[Boolean]
  }

  /**
   * Set whether TCP keep alive is enabled
   */
  override def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }

  override def isTcpKeepAlive: Boolean = {
    asJava.isTcpKeepAlive().asInstanceOf[Boolean]
  }

  /**
   * Set whether TCP no delay is enabled
   */
  override def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }

  override def isTcpNoDelay: Boolean = {
    asJava.isTcpNoDelay().asInstanceOf[Boolean]
  }

  /**
   * Enable the `TCP_QUICKACK` option - only with linux native transport.
   */
  override def setTcpQuickAck(value: Boolean) = {
    asJava.setTcpQuickAck(value)
    this
  }

  override def isTcpQuickAck: Boolean = {
    asJava.isTcpQuickAck().asInstanceOf[Boolean]
  }

  /**
   * Set the value of traffic class
   */
  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }

  override def getTrafficClass: Int = {
    asJava.getTrafficClass().asInstanceOf[Int]
  }

  /**
   * Set whether all server certificates should be trusted.
   */
  def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }

  def isTrustAll: Boolean = {
    asJava.isTrustAll().asInstanceOf[Boolean]
  }

  /**
   * Set the trust options in jks format, aka Java truststore
   */
  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  override def getTrustStoreOptions: JksOptions = {
    JksOptions(asJava.getTrustStoreOptions())
  }

  /**
   * Set the ALPN usage.
   */
  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }

  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn().asInstanceOf[Boolean]
  }

  /**
   * Set whether Netty pooled buffers are enabled
   */
  override def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }

  override def isUsePooledBuffers: Boolean = {
    asJava.isUsePooledBuffers().asInstanceOf[Boolean]
  }

}


object EventBusOptions {
  
  def apply() = {
    new EventBusOptions(new JEventBusOptions(emptyObj()))
  }
  
  def apply(t: JEventBusOptions) = {
    if (t != null) {
      new EventBusOptions(t)
    } else {
      new EventBusOptions(new JEventBusOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): EventBusOptions = {
    if (json != null) {
      new EventBusOptions(new JEventBusOptions(json))
    } else {
      new EventBusOptions(new JEventBusOptions(emptyObj()))
    }
  }
}

