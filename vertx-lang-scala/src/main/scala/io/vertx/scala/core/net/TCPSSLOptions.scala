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
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.net.{TCPSSLOptions => JTCPSSLOptions}
import io.vertx.scala.core.buffer.Buffer

/**
  * Base class. TCP and SSL related options
  */
trait TCPSSLOptions 
    extends NetworkOptions {


  /**
    * Add a CRL path
    */
  def addCrlPath(value: String):TCPSSLOptions

  /**
    * Add a CRL value
    */
  def addCrlValue(value: Buffer):TCPSSLOptions

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value: String):TCPSSLOptions

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value: String):TCPSSLOptions

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value: Int):TCPSSLOptions
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions):TCPSSLOptions

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value: JksOptions):TCPSSLOptions

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean):TCPSSLOptions
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions):TCPSSLOptions

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value: PemKeyCertOptions):TCPSSLOptions

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value: PemTrustOptions):TCPSSLOptions

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value: PfxOptions):TCPSSLOptions

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value: PfxOptions):TCPSSLOptions

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int):TCPSSLOptions

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean):TCPSSLOptions

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int):TCPSSLOptions

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value: Int):TCPSSLOptions

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean):TCPSSLOptions

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value: Boolean):TCPSSLOptions

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value: Boolean):TCPSSLOptions

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int):TCPSSLOptions

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value: JksOptions):TCPSSLOptions

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value: Boolean):TCPSSLOptions

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value: Boolean):TCPSSLOptions
}

