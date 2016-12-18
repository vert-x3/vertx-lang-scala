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
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.net.{ClientOptionsBase => JClientOptionsBase}
import io.vertx.scala.core.buffer.Buffer

/**
  * Base class for Client options
  */
trait ClientOptionsBase 
    extends TCPSSLOptions(_asJava) {


  /**
    * Set the connect timeout
    */
  def setConnectTimeout(value: Int):ClientOptionsBase

  /**
    * Add a CRL path
    */
  def addCrlPath(value: String):ClientOptionsBase

  /**
    * Add a CRL value
    */
  def addCrlValue(value: Buffer):ClientOptionsBase

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value: String):ClientOptionsBase

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value: String):ClientOptionsBase

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value: Int):ClientOptionsBase
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions):ClientOptionsBase

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value: JksOptions):ClientOptionsBase

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
  def setLocalAddress(value: String):ClientOptionsBase

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean):ClientOptionsBase

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
  def setMetricsName(value: String):ClientOptionsBase
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions):ClientOptionsBase

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value: PemKeyCertOptions):ClientOptionsBase

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value: PemTrustOptions):ClientOptionsBase

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value: PfxOptions):ClientOptionsBase

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value: PfxOptions):ClientOptionsBase

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
  def setProxyOptions(value: ProxyOptions):ClientOptionsBase

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int):ClientOptionsBase

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean):ClientOptionsBase

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int):ClientOptionsBase

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value: Int):ClientOptionsBase

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean):ClientOptionsBase

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value: Boolean):ClientOptionsBase

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value: Boolean):ClientOptionsBase

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int):ClientOptionsBase

  /**
    * Set whether all server certificates should be trusted
    */
  def setTrustAll(value: Boolean):ClientOptionsBase

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value: JksOptions):ClientOptionsBase

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value: Boolean):ClientOptionsBase

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value: Boolean):ClientOptionsBase
}

