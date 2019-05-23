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

package io.vertx.scala.ext.consul

import io.vertx.scala.core.http.Http2Settings
import io.vertx.scala.ext.web.client.{WebClientOptions => ExtWebClientOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.consul.{ConsulClientOptions => JConsulClientOptions}
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * Options used to create Consul client.
 */

class ConsulClientOptions(private val _asJava: JConsulClientOptions) extends ExtWebClientOptions(_asJava) {
  override def asJava = _asJava
  /**
   * Set the ACL token. When provided, the client will use this token when making requests to the Consul
   * by providing the "?token" query parameter. When not provided, the empty token, which maps to the 'anonymous'
   * ACL policy, is used.
   */
  def setAclToken(value: String) = {
    asJava.setAclToken(value)
    this
  }

  def getAclToken: String = {
    asJava.getAclToken().asInstanceOf[String]
  }

  /**
   * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiation.
   * When the list is empty, the client provides a best effort list according to <a href="../../../../../../../cheatsheet/ConsulClientOptions.html">ConsulClientOptions</a>:
   *
   * <ul>
   *   <li>: [ "h2", "http/1.1" ]</li>
   *   <li>otherwise: [<a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>]</li>
   * </ul>
   */
  override def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }

  override def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
    asJava.getAlpnVersions().asScala.map(x => x)
  }

  /**
   * Set the connect timeout
   */
  override def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }

  override def getConnectTimeout: Int = {
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
   * Set the datacenter name. When provided, the client will use it when making requests to the Consul
   * by providing the "?dc" query parameter. When not provided, the datacenter of the consul agent is queried.
   */
  def setDc(value: String) = {
    asJava.setDc(value)
    this
  }

  def getDc: String = {
    asJava.getDc().asInstanceOf[String]
  }

  /**
   * set to `initialBufferSizeHttpDecoder` the initial buffer of the HttpDecoder.
   */
  override def setDecoderInitialBufferSize(value: Int) = {
    asJava.setDecoderInitialBufferSize(value)
    this
  }

  override def getDecoderInitialBufferSize: Int = {
    asJava.getDecoderInitialBufferSize().asInstanceOf[Int]
  }

  /**
   * Set the default host name to be used by this client in requests if none is provided when making the request.
   */
  override def setDefaultHost(value: String) = {
    asJava.setDefaultHost(value)
    this
  }

  override def getDefaultHost: String = {
    asJava.getDefaultHost().asInstanceOf[String]
  }

  /**
   * Set the default port to be used by this client in requests if none is provided when making the request.
   */
  override def setDefaultPort(value: Int) = {
    asJava.setDefaultPort(value)
    this
  }

  override def getDefaultPort: Int = {
    asJava.getDefaultPort().asInstanceOf[Int]
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
   * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
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
   * Configure the default behavior of the client to follow HTTP `30x` redirections.
   */
  override def setFollowRedirects(value: Boolean) = {
    asJava.setFollowRedirects(value)
    this
  }

  override def isFollowRedirects: Boolean = {
    asJava.isFollowRedirects().asInstanceOf[Boolean]
  }

  /**
   * By default, the server name is only sent for Fully Qualified Domain Name (FQDN), setting
   * this property to `true` forces the server name to be always sent.
   */
  override def setForceSni(value: Boolean) = {
    asJava.setForceSni(value)
    this
  }

  override def isForceSni: Boolean = {
    asJava.isForceSni().asInstanceOf[Boolean]
  }

  /**
   * Set to `true` when an <i>h2c</i> connection is established using an HTTP/1.1 upgrade request, and `false`
   * when an <i>h2c</i> connection is established directly (with prior knowledge).
   */
  override def setHttp2ClearTextUpgrade(value: Boolean) = {
    asJava.setHttp2ClearTextUpgrade(value)
    this
  }

  override def isHttp2ClearTextUpgrade: Boolean = {
    asJava.isHttp2ClearTextUpgrade().asInstanceOf[Boolean]
  }

  /**
   * Set the default HTTP/2 connection window size. It overrides the initial window
   * size set by , so the connection window size
   * is greater than for its streams, in order the data throughput.
   * <p/>
   * A value of `-1` reuses the initial window size setting.
   */
  override def setHttp2ConnectionWindowSize(value: Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }

  override def getHttp2ConnectionWindowSize: Int = {
    asJava.getHttp2ConnectionWindowSize().asInstanceOf[Int]
  }

  override def setHttp2KeepAliveTimeout(value: Int) = {
    asJava.setHttp2KeepAliveTimeout(value)
    this
  }

  override def getHttp2KeepAliveTimeout: Int = {
    asJava.getHttp2KeepAliveTimeout().asInstanceOf[Int]
  }

  /**
   * Set the maximum pool size for HTTP/2 connections
   */
  override def setHttp2MaxPoolSize(value: Int) = {
    asJava.setHttp2MaxPoolSize(value)
    this
  }

  override def getHttp2MaxPoolSize: Int = {
    asJava.getHttp2MaxPoolSize().asInstanceOf[Int]
  }

  /**
   * Set a client limit of the number concurrent streams for each HTTP/2 connection, this limits the number
   * of streams the client can create for a connection. The effective number of streams for a
   * connection is the min of this value and the server's initial settings.
   * <p/>
   * Setting the value to `-1` means to use the value sent by the server's initial settings.
   * `-1` is the default value.
   */
  override def setHttp2MultiplexingLimit(value: Int) = {
    asJava.setHttp2MultiplexingLimit(value)
    this
  }

  override def getHttp2MultiplexingLimit: Int = {
    asJava.getHttp2MultiplexingLimit().asInstanceOf[Int]
  }

  /**
   * Set the idle timeout, in seconds. zero means don't timeout.
   * This determines if a connection will timeout and be closed if no data is received within the timeout.
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

  /**
   * Set the HTTP/2 connection settings immediately sent by to the server when the client connects.
   */
  override def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }

  override def getInitialSettings: Http2Settings = {
    Http2Settings(asJava.getInitialSettings())
  }

  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  override def getJdkSslEngineOptions: JdkSSLEngineOptions = {
    JdkSSLEngineOptions(asJava.getJdkSslEngineOptions())
  }

  /**
   * Set whether keep alive is enabled on the client
   */
  override def setKeepAlive(value: Boolean) = {
    asJava.setKeepAlive(value)
    this
  }

  override def isKeepAlive: Boolean = {
    asJava.isKeepAlive().asInstanceOf[Boolean]
  }

  override def setKeepAliveTimeout(value: Int) = {
    asJava.setKeepAliveTimeout(value)
    this
  }

  override def getKeepAliveTimeout: Int = {
    asJava.getKeepAliveTimeout().asInstanceOf[Int]
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
   * Set the local interface to bind for network connections. When the local address is null,
   * it will pick any local address, the default local address is null.
   */
  override def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }

  override def getLocalAddress: String = {
    asJava.getLocalAddress().asInstanceOf[String]
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

  /**
   * Set the maximum HTTP chunk size
   */
  override def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }

  override def getMaxChunkSize: Int = {
    asJava.getMaxChunkSize().asInstanceOf[Int]
  }

  /**
   * Set the maximum length of all headers for HTTP/1.x .
   */
  override def setMaxHeaderSize(value: Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }

  override def getMaxHeaderSize: Int = {
    asJava.getMaxHeaderSize().asInstanceOf[Int]
  }

  /**
   * Set the maximum length of the initial line for HTTP/1.x (e.g. `"HTTP/1.1 200 OK"`)
   */
  override def setMaxInitialLineLength(value: Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }

  override def getMaxInitialLineLength: Int = {
    asJava.getMaxInitialLineLength().asInstanceOf[Int]
  }

  /**
   * Set the maximum pool size for connections
   */
  override def setMaxPoolSize(value: Int) = {
    asJava.setMaxPoolSize(value)
    this
  }

  override def getMaxPoolSize: Int = {
    asJava.getMaxPoolSize().asInstanceOf[Int]
  }

  /**
   * Set to `maxRedirects` the maximum number of redirection a request can follow.
   */
  override def setMaxRedirects(value: Int) = {
    asJava.setMaxRedirects(value)
    this
  }

  override def getMaxRedirects: Int = {
    asJava.getMaxRedirects().asInstanceOf[Int]
  }

  /**
   * Set the maximum requests allowed in the wait queue, any requests beyond the max size will result in
   * a ConnectionPoolTooBusyException.  If the value is set to a negative number then the queue will be unbounded.
   */
  override def setMaxWaitQueueSize(value: Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }

  override def getMaxWaitQueueSize: Int = {
    asJava.getMaxWaitQueueSize().asInstanceOf[Int]
  }

  /**
   * Set the max websocket frame size
   */
  override def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }

  override def getMaxWebsocketFrameSize: Int = {
    asJava.getMaxWebsocketFrameSize().asInstanceOf[Int]
  }

  /**
   * Set the max websocket message size
   */
  override def setMaxWebsocketMessageSize(value: Int) = {
    asJava.setMaxWebsocketMessageSize(value)
    this
  }

  override def getMaxWebsocketMessageSize: Int = {
    asJava.getMaxWebsocketMessageSize().asInstanceOf[Int]
  }

  /**
   * Set the metrics name identifying the reported metrics, useful for grouping metrics
   * with the same name.
   */
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
   * Set the trust options.
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
   * Set whether pipe-lining is enabled on the client
   */
  override def setPipelining(value: Boolean) = {
    asJava.setPipelining(value)
    this
  }

  override def isPipelining: Boolean = {
    asJava.isPipelining().asInstanceOf[Boolean]
  }

  /**
   * Set the limit of pending requests a pipe-lined HTTP/1 connection can send.
   */
  override def setPipeliningLimit(value: Int) = {
    asJava.setPipeliningLimit(value)
    this
  }

  override def getPipeliningLimit: Int = {
    asJava.getPipeliningLimit().asInstanceOf[Int]
  }

  override def setPoolCleanerPeriod(value: Int) = {
    asJava.setPoolCleanerPeriod(value)
    this
  }

  override def getPoolCleanerPeriod: Int = {
    asJava.getPoolCleanerPeriod().asInstanceOf[Int]
  }

  /**
   * Set the protocol version.
   */
  override def setProtocolVersion(value: io.vertx.core.http.HttpVersion) = {
    asJava.setProtocolVersion(value)
    this
  }

  override def getProtocolVersion: io.vertx.core.http.HttpVersion = {
    asJava.getProtocolVersion()
  }

  /**
   * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
   */
  override def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }

  override def getProxyOptions: ProxyOptions = {
    ProxyOptions(asJava.getProxyOptions())
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
   * Set true when the client wants to skip frame masking.
   * You may want to set it true on server by server websocket communication: In this case you are by passing RFC6455 protocol.
   * It's false as default.
   */
  override def setSendUnmaskedFrames(value: Boolean) = {
    asJava.setSendUnmaskedFrames(value)
    this
  }

  override def isSendUnmaskedFrames: Boolean = {
    asJava.isSendUnmaskedFrames().asInstanceOf[Boolean]
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
   * Sets the amount of time (in milliseconds) after which if the request does not return any data
   * within the timeout period an failure will be passed to the handler and the request will be closed.
   */
  def setTimeout(value: Long) = {
    asJava.setTimeout(value)
    this
  }

  def getTimeout: Long = {
    asJava.getTimeout().asInstanceOf[Long]
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
   * Set whether all server certificates should be trusted
   */
  override def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }

  override def isTrustAll: Boolean = {
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
   * Set whether compression is enabled
   */
  override def setTryUseCompression(value: Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }

  override def isTryUseCompression: Boolean = {
    asJava.isTryUseCompression().asInstanceOf[Boolean]
  }

  override def setTryUsePerFrameWebsocketCompression(value: Boolean) = {
    asJava.setTryUsePerFrameWebsocketCompression(value)
    this
  }

  override def setTryUsePerMessageWebsocketCompression(value: Boolean) = {
    asJava.setTryUsePerMessageWebsocketCompression(value)
    this
  }

  override def getTryUsePerMessageWebsocketCompression: Boolean = {
    asJava.getTryUsePerMessageWebsocketCompression().asInstanceOf[Boolean]
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

  /**
   * Sets the Web Client user agent header. Defaults to Vert.x-WebClient/&lt;version&gt;.
   */
  override def setUserAgent(value: String) = {
    asJava.setUserAgent(value)
    this
  }

  override def getUserAgent: String = {
    asJava.getUserAgent().asInstanceOf[String]
  }

  /**
   * Sets whether the Web Client should send a user agent header. Defaults to true.
   */
  override def setUserAgentEnabled(value: Boolean) = {
    asJava.setUserAgentEnabled(value)
    this
  }

  override def isUserAgentEnabled: Boolean = {
    asJava.isUserAgentEnabled().asInstanceOf[Boolean]
  }

  /**
   * Set whether hostname verification is enabled
   */
  override def setVerifyHost(value: Boolean) = {
    asJava.setVerifyHost(value)
    this
  }

  override def isVerifyHost: Boolean = {
    asJava.isVerifyHost().asInstanceOf[Boolean]
  }

  override def setWebsocketCompressionAllowClientNoContext(value: Boolean) = {
    asJava.setWebsocketCompressionAllowClientNoContext(value)
    this
  }

  override def getWebsocketCompressionAllowClientNoContext: Boolean = {
    asJava.getWebsocketCompressionAllowClientNoContext().asInstanceOf[Boolean]
  }

  override def setWebsocketCompressionLevel(value: Int) = {
    asJava.setWebsocketCompressionLevel(value)
    this
  }

  override def getWebsocketCompressionLevel: Int = {
    asJava.getWebsocketCompressionLevel().asInstanceOf[Int]
  }

  override def setWebsocketCompressionRequestServerNoContext(value: Boolean) = {
    asJava.setWebsocketCompressionRequestServerNoContext(value)
    this
  }

  override def getWebsocketCompressionRequestServerNoContext: Boolean = {
    asJava.getWebsocketCompressionRequestServerNoContext().asInstanceOf[Boolean]
  }

}


object ConsulClientOptions {
  
  def apply() = {
    new ConsulClientOptions(new JConsulClientOptions(emptyObj()))
  }
  
  def apply(t: JConsulClientOptions) = {
    if (t != null) {
      new ConsulClientOptions(t)
    } else {
      new ConsulClientOptions(new JConsulClientOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ConsulClientOptions = {
    if (json != null) {
      new ConsulClientOptions(new JConsulClientOptions(json))
    } else {
      new ConsulClientOptions(new JConsulClientOptions(emptyObj()))
    }
  }
}

