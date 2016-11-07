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

package io.vertx.scala.core.http

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
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
  * Represents options used by an [[io.vertx.scala.core.http.HttpServer]] instance
  */

class HttpServerOptions(val asJava: JHttpServerOptions) {

  /**
    * Set the accept back log
    */
  def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  def getAcceptBacklog = {
    asJava.getAcceptBacklog()
  }

  /**
    * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiatiation.
    */
  def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }

  /**
    * Set whether client auth is required
    */
  def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  def getClientAuth = {
    asJava.getClientAuth()
  }

  /**
    * Set whether client auth is required
    */
  def setClientAuthRequired(value: Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  def isClientAuthRequired = {
    asJava.isClientAuthRequired()
  }

  /**
    * Set whether the server supports compression
    */
  def setCompressionSupported(value: Boolean) = {
    asJava.setCompressionSupported(value)
    this
  }
  def isCompressionSupported = {
    asJava.isCompressionSupported()
  }

  /**
    * Add a CRL path
    */
  def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }

  /**
    * Add a CRL value
    */
  def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asJava)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }

  /**
    * Set whether the server supports decompression
    */
  def setDecompressionSupported(value: Boolean) = {
    asJava.setDecompressionSupported(value)
    this
  }
  def isDecompressionSupported = {
    asJava.isDecompressionSupported()
  }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }

  /**
    * Set whether 100 Continue should be handled automatically
    */
  def setHandle100ContinueAutomatically(value: Boolean) = {
    asJava.setHandle100ContinueAutomatically(value)
    this
  }
  def isHandle100ContinueAutomatically = {
    asJava.isHandle100ContinueAutomatically()
  }

  /**
    * Set the host
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Set the default HTTP/2 connection window size. It overrides the initial window
    * size set by <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>, so the connection window size
    * is greater than for its streams, in order the data throughput.
    * <p/>
    * A value of `-1` reuses the initial window size setting.
    */
  def setHttp2ConnectionWindowSize(value: Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    asJava.getHttp2ConnectionWindowSize()
  }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }

  /**
    * Set the HTTP/2 connection settings immediatly sent by the server when a client connects.
    */
  def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  def getInitialSettings = {
    asJava.getInitialSettings()
  }
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }

  /**
    * Set the maximum HTTP chunk size
    */
  def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize = {
    asJava.getMaxChunkSize()
  }

  /**
    * Set the maximum length of all headers for HTTP/1.x .
    */
  def setMaxHeaderSize(value: Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }
  def getMaxHeaderSize = {
    asJava.getMaxHeaderSize()
  }

  /**
    * Set the maximum length of the initial line for HTTP/1.x (e.g. `"GET / HTTP/1.0"`)
    */
  def setMaxInitialLineLength(value: Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }
  def getMaxInitialLineLength = {
    asJava.getMaxInitialLineLength()
  }

  /**
    * Set the maximum websocket frames size
    */
  def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    asJava.getMaxWebsocketFrameSize()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  /**
    * Set the port
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }

  /**
    * Set the websocket subprotocols supported by the server.
    */
  def setWebsocketSubProtocols(value: String) = {
    asJava.setWebsocketSubProtocols(value)
    this
  }
  def getWebsocketSubProtocols = {
    asJava.getWebsocketSubProtocols()
  }
}

object HttpServerOptions {
  
  def apply() = {
    new HttpServerOptions(new JHttpServerOptions(emptyObj()))
  }
  
  def apply(t: JHttpServerOptions) = {
    if(t != null)
      new HttpServerOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):HttpServerOptions = {
    if(json != null)
      new HttpServerOptions(new JHttpServerOptions(json))
    else
      null
  }
}
