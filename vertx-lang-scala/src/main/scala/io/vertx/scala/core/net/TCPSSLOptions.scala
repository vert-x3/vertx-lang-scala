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

import java.util.concurrent.TimeUnit
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{TCPSSLOptions => JTCPSSLOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetworkOptions => ExtNetworkOptions}

/**
 * Base class. TCP and SSL related options
 */

abstract class TCPSSLOptions(private val _asJava: JTCPSSLOptions) extends ExtNetworkOptions(_asJava) {

  /**
   * Add a CRL path
   */
  def addCrlPath(value: String): TCPSSLOptions

  def getCrlPaths: scala.collection.mutable.Buffer[String]

  /**
   * Add a CRL value
   */
  def addCrlValue(value: io.vertx.core.buffer.Buffer): TCPSSLOptions

  def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer]

  /**
   * Add an enabled cipher suite, appended to the ordered suites.
   */
  def addEnabledCipherSuite(value: String): TCPSSLOptions

  def getEnabledCipherSuites: scala.collection.mutable.Set[String]

  /**
   * Sets the list of enabled SSL/TLS protocols.
   */
  def addEnabledSecureTransportProtocol(value: String): TCPSSLOptions

  def setEnabledSecureTransportProtocols(value: Set[String]): TCPSSLOptions

  def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String]

  /**
   * Set the idle timeout, default time unit is seconds. Zero means don't timeout.
   * This determines if a connection will timeout and be closed if no data is received within the timeout.
   *
   * If you want change default time unit, use <a href="../../../../../../../cheatsheet/TCPSSLOptions.html">TCPSSLOptions</a>
   */
  def setIdleTimeout(value: Int): TCPSSLOptions

  def getIdleTimeout: Int

  /**
   * Set the idle timeout unit. If not specified, default is seconds.
   */
  def setIdleTimeoutUnit(value: java.util.concurrent.TimeUnit): TCPSSLOptions

  def getIdleTimeoutUnit: java.util.concurrent.TimeUnit

  def setJdkSslEngineOptions(value: JdkSSLEngineOptions): TCPSSLOptions

  def getJdkSslEngineOptions: JdkSSLEngineOptions

  /**
   * Set the key/cert options in jks format, aka Java keystore.
   */
  def setKeyStoreOptions(value: JksOptions): TCPSSLOptions

  def getKeyStoreOptions: JksOptions

  /**
   * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
   */
  def setLogActivity(value: Boolean): TCPSSLOptions

  def getLogActivity: Boolean

  def setOpenSslEngineOptions(value: OpenSSLEngineOptions): TCPSSLOptions

  def getOpenSslEngineOptions: OpenSSLEngineOptions

  /**
   * Set the key/cert store options in pem format.
   */
  def setPemKeyCertOptions(value: PemKeyCertOptions): TCPSSLOptions

  def getPemKeyCertOptions: PemKeyCertOptions

  /**
   * Set the trust options in pem format
   */
  def setPemTrustOptions(value: PemTrustOptions): TCPSSLOptions

  def getPemTrustOptions: PemTrustOptions

  /**
   * Set the key/cert options in pfx format.
   */
  def setPfxKeyCertOptions(value: PfxOptions): TCPSSLOptions

  def getPfxKeyCertOptions: PfxOptions

  /**
   * Set the trust options in pfx format
   */
  def setPfxTrustOptions(value: PfxOptions): TCPSSLOptions

  def getPfxTrustOptions: PfxOptions

  /**
   * Set the TCP receive buffer size
   */
  def setReceiveBufferSize(value: Int): TCPSSLOptions

  def getReceiveBufferSize: Int

  /**
   * Set the value of reuse address
   */
  def setReuseAddress(value: Boolean): TCPSSLOptions

  def isReuseAddress: Boolean

  /**
   * Set the value of reuse port.
   * <p/>
   * This is only supported by native transports.
   */
  def setReusePort(value: Boolean): TCPSSLOptions

  def isReusePort: Boolean

  /**
   * Set the TCP send buffer size
   */
  def setSendBufferSize(value: Int): TCPSSLOptions

  def getSendBufferSize: Int

  /**
   * Set whether SO_linger keep alive is enabled
   */
  def setSoLinger(value: Int): TCPSSLOptions

  def getSoLinger: Int

  /**
   * Set whether SSL/TLS is enabled
   */
  def setSsl(value: Boolean): TCPSSLOptions

  def isSsl: Boolean

  /**
   * Set the SSL handshake timeout, default time unit is seconds.
   */
  def setSslHandshakeTimeout(value: Long): TCPSSLOptions

  def getSslHandshakeTimeout: Long

  /**
   * Set the SSL handshake timeout unit. If not specified, default is seconds.
   */
  def setSslHandshakeTimeoutUnit(value: java.util.concurrent.TimeUnit): TCPSSLOptions

  def getSslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit

  /**
   * Enable the `TCP_CORK` option - only with linux native transport.
   */
  def setTcpCork(value: Boolean): TCPSSLOptions

  def isTcpCork: Boolean

  /**
   * Enable the `TCP_FASTOPEN` option - only with linux native transport.
   */
  def setTcpFastOpen(value: Boolean): TCPSSLOptions

  def isTcpFastOpen: Boolean

  /**
   * Set whether TCP keep alive is enabled
   */
  def setTcpKeepAlive(value: Boolean): TCPSSLOptions

  def isTcpKeepAlive: Boolean

  /**
   * Set whether TCP no delay is enabled
   */
  def setTcpNoDelay(value: Boolean): TCPSSLOptions

  def isTcpNoDelay: Boolean

  /**
   * Enable the `TCP_QUICKACK` option - only with linux native transport.
   */
  def setTcpQuickAck(value: Boolean): TCPSSLOptions

  def isTcpQuickAck: Boolean

  /**
   * Set the value of traffic class
   */
  def setTrafficClass(value: Int): TCPSSLOptions

  def getTrafficClass: Int

  /**
   * Set the trust options in jks format, aka Java truststore
   */
  def setTrustStoreOptions(value: JksOptions): TCPSSLOptions

  def getTrustStoreOptions: JksOptions

  /**
   * Set the ALPN usage.
   */
  def setUseAlpn(value: Boolean): TCPSSLOptions

  def isUseAlpn: Boolean

  /**
   * Set whether Netty pooled buffers are enabled
   */
  def setUsePooledBuffers(value: Boolean): TCPSSLOptions

  def isUsePooledBuffers: Boolean

}
