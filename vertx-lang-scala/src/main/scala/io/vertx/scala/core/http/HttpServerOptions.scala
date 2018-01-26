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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetServerOptions => ExtNetServerOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.scala.core.net.PfxOptions
import io.vertx.core.http.{HttpServerOptions => JHttpServerOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Represents options used by an [[io.vertx.scala.core.http.HttpServer]] instance
  */
class HttpServerOptions(private val _asJava: JHttpServerOptions) 
    extends ExtNetServerOptions(_asJava) {

  override def asJava = _asJava

  /**
    * Set the accept back log
    */
  override def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  override def getAcceptBacklog: Int = {
    asJava.getAcceptBacklog().asInstanceOf[Int]
  }

  /**
    * Set true when the server accepts unmasked frame.
    * As default Server doesn't accept unmasked frame, you can bypass this behaviour (RFC 6455) setting true
    * It's set to false as default.
    */
  def setAcceptUnmaskedFrames(value: Boolean) = {
    asJava.setAcceptUnmaskedFrames(value)
    this
  }
  def isAcceptUnmaskedFrames: Boolean = {
    asJava.isAcceptUnmaskedFrames().asInstanceOf[Boolean]
  }

  /**
    * Set the list of protocol versions to provide to the server during the Application-Layer Protocol Negotiatiation.
    */
  def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }
  def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
    asJava.getAlpnVersions().asScala.map(x => x)
  }

  /**
    * Set whether client auth is required
    */
  override def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  override def getClientAuth: io.vertx.core.http.ClientAuth = {
    asJava.getClientAuth()
  }

  /**
    * Set whether client auth is required
    */
  override def setClientAuthRequired(value: Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  override def isClientAuthRequired: Boolean = {
    asJava.isClientAuthRequired().asInstanceOf[Boolean]
  }

  /**
    * This method allows to set the compression level to be used in http1.x/2 response bodies
    * when compression support is turned on (@see setCompressionSupported) and the client advertises
    * to support `deflate/gzip` compression in the `Accept-Encoding` header
    *
    * default value is : 6 (Netty legacy)
    *
    * The compression level determines how much the data is compressed on a scale from 1 to 9,
    * where '9' is trying to achieve the maximum compression ratio while '1' instead is giving
    * priority to speed instead of compression ratio using some algorithm optimizations and skipping
    * pedantic loops that usually gives just little improvements
    *
    * While one can think that best value is always the maximum compression ratio,
    * there's a trade-off to consider: the most compressed level requires the most
    * computational work to compress/decompress data, e.g. more dictionary lookups and loops.
    *
    * E.g. you have it set fairly high on a high-volume website, you may experience performance degradation
    * and latency on resource serving due to CPU overload, and, however - as the computational work is required also client side
    * while decompressing - setting an higher compression level can result in an overall higher page load time
    * especially nowadays when many clients are handled mobile devices with a low CPU profile.
    *
    * see also: http://www.gzip.org/algorithm.txt
    */
  def setCompressionLevel(value: Int) = {
    asJava.setCompressionLevel(value)
    this
  }
  def getCompressionLevel: Int = {
    asJava.getCompressionLevel().asInstanceOf[Int]
  }

  /**
    * Set whether the server should support gzip/deflate compression
    * (serving compressed responses to clients advertising support for them with Accept-Encoding header)
    */
  def setCompressionSupported(value: Boolean) = {
    asJava.setCompressionSupported(value)
    this
  }
  def isCompressionSupported: Boolean = {
    asJava.isCompressionSupported().asInstanceOf[Boolean]
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
    * Set the initial buffer size for the HTTP decoder
    */
  def setDecoderInitialBufferSize(value: Int) = {
    asJava.setDecoderInitialBufferSize(value)
    this
  }
  def getDecoderInitialBufferSize: Int = {
    asJava.getDecoderInitialBufferSize().asInstanceOf[Int]
  }

  /**
    * Set whether the server supports decompression
    */
  def setDecompressionSupported(value: Boolean) = {
    asJava.setDecompressionSupported(value)
    this
  }
  def isDecompressionSupported: Boolean = {
    asJava.isDecompressionSupported().asInstanceOf[Boolean]
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
    * Set whether 100 Continue should be handled automatically
    */
  def setHandle100ContinueAutomatically(value: Boolean) = {
    asJava.setHandle100ContinueAutomatically(value)
    this
  }
  def isHandle100ContinueAutomatically: Boolean = {
    asJava.isHandle100ContinueAutomatically().asInstanceOf[Boolean]
  }

  /**
    * Set the host
    */
  override def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  override def getHost: String = {
    asJava.getHost().asInstanceOf[String]
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
  def getHttp2ConnectionWindowSize: Int = {
    asJava.getHttp2ConnectionWindowSize().asInstanceOf[Int]
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
    * Set the HTTP/2 connection settings immediatly sent by the server when a client connects.
    */
  def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  def getInitialSettings: Http2Settings = {
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

  /**
    * Set the maximum HTTP chunk size
    */
  def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize: Int = {
    asJava.getMaxChunkSize().asInstanceOf[Int]
  }

  /**
    * Set the maximum length of all headers for HTTP/1.x .
    */
  def setMaxHeaderSize(value: Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }
  def getMaxHeaderSize: Int = {
    asJava.getMaxHeaderSize().asInstanceOf[Int]
  }

  /**
    * Set the maximum length of the initial line for HTTP/1.x (e.g. `"GET / HTTP/1.0"`)
    */
  def setMaxInitialLineLength(value: Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }
  def getMaxInitialLineLength: Int = {
    asJava.getMaxInitialLineLength().asInstanceOf[Int]
  }

  /**
    * Set the maximum websocket frames size
    */
  def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize: Int = {
    asJava.getMaxWebsocketFrameSize().asInstanceOf[Int]
  }

  /**
    * Set the maximum websocket message size
    */
  def setMaxWebsocketMessageSize(value: Int) = {
    asJava.setMaxWebsocketMessageSize(value)
    this
  }
  def getMaxWebsocketMessageSize: Int = {
    asJava.getMaxWebsocketMessageSize().asInstanceOf[Int]
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
    * Set the port
    */
  override def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  override def getPort: Int = {
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
    * Set whether the server supports Server Name Indiciation
    */
  override def setSni(value: Boolean) = {
    asJava.setSni(value)
    this
  }
  override def isSni: Boolean = {
    asJava.isSni().asInstanceOf[Boolean]
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

  /**
    * Set the websocket subprotocols supported by the server.
    */
  def setWebsocketSubProtocols(value: String) = {
    asJava.setWebsocketSubProtocols(value)
    this
  }
  def getWebsocketSubProtocols: String = {
    asJava.getWebsocketSubProtocols().asInstanceOf[String]
  }
}

object HttpServerOptions {
  
  def apply() = {
    new HttpServerOptions(new JHttpServerOptions(emptyObj()))
  }
  
  def apply(t: JHttpServerOptions) = {
    if (t != null) {
      new HttpServerOptions(t)
    } else {
      new HttpServerOptions(new JHttpServerOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): HttpServerOptions = {
    if (json != null) {
      new HttpServerOptions(new JHttpServerOptions(json))
    } else {
      new HttpServerOptions(new JHttpServerOptions(emptyObj()))
    }
  }
}
