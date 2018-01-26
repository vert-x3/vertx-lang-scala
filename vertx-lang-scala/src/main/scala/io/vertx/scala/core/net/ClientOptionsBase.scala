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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{TCPSSLOptions => ExtTCPSSLOptions}
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{ClientOptionsBase => JClientOptionsBase}

/**
  * Base class for Client options
  */
trait ClientOptionsBase 
    extends ExtTCPSSLOptions {


  /**
    * Set the connect timeout
    */
  def setConnectTimeout(value: Int): ClientOptionsBase
  def getConnectTimeout: Int 

  /**
    * Add a CRL path
    */
  def addCrlPath(value: String): ClientOptionsBase
  def getCrlPaths: scala.collection.mutable.Buffer[String] 

  /**
    * Add a CRL value
    */
  def addCrlValue(value: io.vertx.core.buffer.Buffer): ClientOptionsBase
  def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] 

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value: String): ClientOptionsBase
  def getEnabledCipherSuites: scala.collection.mutable.Set[String] 

  /**
    * Sets the list of enabled SSL/TLS protocols.
    */
  def addEnabledSecureTransportProtocol(value: String): ClientOptionsBase
  def setEnabledSecureTransportProtocols(value: Set[String]): ClientOptionsBase
  def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] 

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value: Int): ClientOptionsBase
  def getIdleTimeout: Int 
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions): ClientOptionsBase
  def getJdkSslEngineOptions: JdkSSLEngineOptions 

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value: JksOptions): ClientOptionsBase
  def getKeyStoreOptions: JksOptions 

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
  def setLocalAddress(value: String): ClientOptionsBase
  def getLocalAddress: String 

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean): ClientOptionsBase
  def getLogActivity: Boolean 

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
  def setMetricsName(value: String): ClientOptionsBase
  def getMetricsName: String 
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions): ClientOptionsBase
  def getOpenSslEngineOptions: OpenSSLEngineOptions 

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value: PemKeyCertOptions): ClientOptionsBase
  def getPemKeyCertOptions: PemKeyCertOptions 

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value: PemTrustOptions): ClientOptionsBase
  def getPemTrustOptions: PemTrustOptions 

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value: PfxOptions): ClientOptionsBase
  def getPfxKeyCertOptions: PfxOptions 

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value: PfxOptions): ClientOptionsBase
  def getPfxTrustOptions: PfxOptions 

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
  def setProxyOptions(value: ProxyOptions): ClientOptionsBase
  def getProxyOptions: ProxyOptions 

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int): ClientOptionsBase
  def getReceiveBufferSize: Int 

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean): ClientOptionsBase
  def isReuseAddress: Boolean 

  /**
    * Set the value of reuse port.
    * <p/>
    * This is only supported by native transports.
    */
  def setReusePort(value: Boolean): ClientOptionsBase
  def isReusePort: Boolean 

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int): ClientOptionsBase
  def getSendBufferSize: Int 

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value: Int): ClientOptionsBase
  def getSoLinger: Int 

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean): ClientOptionsBase
  def isSsl: Boolean 

  /**
    * Enable the `TCP_CORK` option - only with linux native transport.
    */
  def setTcpCork(value: Boolean): ClientOptionsBase
  def isTcpCork: Boolean 

  /**
    * Enable the `TCP_FASTOPEN` option - only with linux native transport.
    */
  def setTcpFastOpen(value: Boolean): ClientOptionsBase
  def isTcpFastOpen: Boolean 

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value: Boolean): ClientOptionsBase
  def isTcpKeepAlive: Boolean 

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value: Boolean): ClientOptionsBase
  def isTcpNoDelay: Boolean 

  /**
    * Enable the `TCP_QUICKACK` option - only with linux native transport.
    */
  def setTcpQuickAck(value: Boolean): ClientOptionsBase
  def isTcpQuickAck: Boolean 

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int): ClientOptionsBase
  def getTrafficClass: Int 

  /**
    * Set whether all server certificates should be trusted
    */
  def setTrustAll(value: Boolean): ClientOptionsBase
  def isTrustAll: Boolean 

  /**
    * Set the trust options in jks format, aka Java truststore
    */
  def setTrustStoreOptions(value: JksOptions): ClientOptionsBase
  def getTrustStoreOptions: JksOptions 

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value: Boolean): ClientOptionsBase
  def isUseAlpn: Boolean 

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value: Boolean): ClientOptionsBase
  def isUsePooledBuffers: Boolean 
}

