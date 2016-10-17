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
import scala.collection.JavaConversions._

/**
  * Options describing how an [[io.vertx.scala.core.http.HttpClient]] will make connections.
  */

class HttpClientOptions(val asJava: io.vertx.core.http.HttpClientOptions) {

  /**
    * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiation.
    * When the list is empty, the client provides a best effort list according to <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>:
    *
    * <ul>
    *   <li>: [ "h2", "http/1.1" ]</li>
    *   <li>otherwise: [<a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>]</li>
    * </ul>
    */
  def setAlpnVersions(value:scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }

  /**
    * Set the connect timeout
    */
  def setConnectTimeout(value:Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
  }

  /**
    * Add a CRL path
    */
  def addCrlPath(value:String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }

  /**
    * Add a CRL value
    */
  def addCrlValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }

  /**
    * Set the default host name to be used by this client in requests if none is provided when making the request.
    */
  def setDefaultHost(value:String) = {
    asJava.setDefaultHost(value)
    this
  }
  def getDefaultHost = {
    asJava.getDefaultHost()
  }

  /**
    * Set the default port to be used by this client in requests if none is provided when making the request.
    */
  def setDefaultPort(value:Int) = {
    asJava.setDefaultPort(value)
    this
  }
  def getDefaultPort = {
    asJava.getDefaultPort()
  }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value:String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value:String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }

  /**
    * Set to `true` when an <i>h2c</i> connection is established using an HTTP/1.1 upgrade request, and `false`
    * when an <i>h2c</i> connection is established directly (with prior knowledge).
    */
  def setHttp2ClearTextUpgrade(value:Boolean) = {
    asJava.setHttp2ClearTextUpgrade(value)
    this
  }
  def isHttp2ClearTextUpgrade = {
    asJava.isHttp2ClearTextUpgrade()
  }

  /**
    * Set the default HTTP/2 connection window size. It overrides the initial window
    * size set by <a href="../../../../../../../cheatsheet/Http2Settings.html">Http2Settings</a>, so the connection window size
    * is greater than for its streams, in order the data throughput.
    * <p/>
    * A value of `-1` reuses the initial window size setting.
    */
  def setHttp2ConnectionWindowSize(value:Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    asJava.getHttp2ConnectionWindowSize()
  }

  /**
    * Set the maximum pool size for HTTP/2 connections
    */
  def setHttp2MaxPoolSize(value:Int) = {
    asJava.setHttp2MaxPoolSize(value)
    this
  }
  def getHttp2MaxPoolSize = {
    asJava.getHttp2MaxPoolSize()
  }

  /**
    * Set a client limit of the number concurrent streams for each HTTP/2 connection, this limits the number
    * of streams the client can create for a connection. The effective number of streams for a
    * connection is the min of this value and the server's initial settings.
    * <p/>
    * Setting the value to `-1` means to use the value sent by the server's initial settings.
    * `-1` is the default value.
    */
  def setHttp2MultiplexingLimit(value:Int) = {
    asJava.setHttp2MultiplexingLimit(value)
    this
  }
  def getHttp2MultiplexingLimit = {
    asJava.getHttp2MultiplexingLimit()
  }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value:Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }

  /**
    * Set the HTTP/2 connection settings immediately sent by to the server when the client connects.
    */
  def setInitialSettings(value:io.vertx.scala.core.http.Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  def getInitialSettings = {
    asJava.getInitialSettings()
  }
  def setJdkSslEngineOptions(value:io.vertx.scala.core.net.JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set whether keep alive is enabled on the client
    */
  def setKeepAlive(value:Boolean) = {
    asJava.setKeepAlive(value)
    this
  }
  def isKeepAlive = {
    asJava.isKeepAlive()
  }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
  def setLocalAddress(value:String) = {
    asJava.setLocalAddress(value)
    this
  }
  def getLocalAddress = {
    asJava.getLocalAddress()
  }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value:Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }

  /**
    * Set the maximum HTTP chunk size
    */
  def setMaxChunkSize(value:Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize = {
    asJava.getMaxChunkSize()
  }

  /**
    * Set the maximum pool size for connections
    */
  def setMaxPoolSize(value:Int) = {
    asJava.setMaxPoolSize(value)
    this
  }
  def getMaxPoolSize = {
    asJava.getMaxPoolSize()
  }

  /**
    * Set the maximum requests allowed in the wait queue, any requests beyond the max size will result in
    * a ConnectionPoolTooBusyException.  If the value is set to a negative number then the queue will be unbounded.
    */
  def setMaxWaitQueueSize(value:Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }
  def getMaxWaitQueueSize = {
    asJava.getMaxWaitQueueSize()
  }

  /**
    * Set the max websocket frame size
    */
  def setMaxWebsocketFrameSize(value:Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    asJava.getMaxWebsocketFrameSize()
  }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
  def setMetricsName(value:String) = {
    asJava.setMetricsName(value)
    this
  }
  def getMetricsName = {
    asJava.getMetricsName()
  }
  def setOpenSslEngineOptions(value:io.vertx.scala.core.net.OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value:io.vertx.scala.core.net.PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value:io.vertx.scala.core.net.PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  /**
    * Set whether pipe-lining is enabled on the client
    */
  def setPipelining(value:Boolean) = {
    asJava.setPipelining(value)
    this
  }
  def isPipelining = {
    asJava.isPipelining()
  }

  /**
    * Set the limit of pending requests a pipe-lined HTTP/1 connection can send.
    */
  def setPipeliningLimit(value:Int) = {
    asJava.setPipeliningLimit(value)
    this
  }
  def getPipeliningLimit = {
    asJava.getPipeliningLimit()
  }

  /**
    * Set the protocol version.
    */
  def setProtocolVersion(value:io.vertx.core.http.HttpVersion) = {
    asJava.setProtocolVersion(value)
    this
  }
  def getProtocolVersion = {
    asJava.getProtocolVersion()
  }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
  def setProxyOptions(value:io.vertx.scala.core.net.ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }
  def getProxyOptions = {
    asJava.getProxyOptions()
  }

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value:Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value:Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value:Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value:Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value:Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value:Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value:Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value:Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }

  /**
    * Set whether all server certificates should be trusted
    */
  def setTrustAll(value:Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  /**
    * Set whether compression is enabled
    */
  def setTryUseCompression(value:Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }
  def isTryUseCompression = {
    asJava.isTryUseCompression()
  }

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value:Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value:Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }

  /**
    * Set whether hostname verification is enabled
    */
  def setVerifyHost(value:Boolean) = {
    asJava.setVerifyHost(value)
    this
  }
  def isVerifyHost = {
    asJava.isVerifyHost()
  }
}

object HttpClientOptions {
  type HttpClientOptionsJava = io.vertx.core.http.HttpClientOptions
  
  def apply() = {
    new HttpClientOptions(new HttpClientOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: HttpClientOptionsJava) = {
    if(t != null)
      new HttpClientOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):HttpClientOptions = {
    if(json != null)
      new HttpClientOptions(new HttpClientOptionsJava(json))
    else
      null
  }
}
