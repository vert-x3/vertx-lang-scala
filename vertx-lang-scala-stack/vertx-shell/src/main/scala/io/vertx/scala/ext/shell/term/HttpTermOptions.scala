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

package io.vertx.scala.ext.shell.term

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.http.{HttpServerOptions => ExtHttpServerOptions}
import io.vertx.scala.core.http.Http2Settings
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.ext.auth.{AuthOptions => JAuthOptions}
import io.vertx.scala.core.net.PfxOptions
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.ext.web.handler.sockjs.{SockJSHandlerOptions => JSockJSHandlerOptions}
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.ext.web.handler.sockjs.SockJSHandlerOptions
import io.vertx.ext.shell.term.{HttpTermOptions => JHttpTermOptions}
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.scala.ext.auth.AuthOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * The web term configuration options.
  */
class HttpTermOptions(private val _asJava: JHttpTermOptions) 
    extends ExtHttpServerOptions(_asJava) {

  override def asJava = _asJava
  override def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  override def getAcceptBacklog: Int = {
    asJava.getAcceptBacklog().asInstanceOf[Int]
  }
  override def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }
  override def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
    asJava.getAlpnVersions().asScala.map(x => x)
  }

  /**
    */

  /**
    * Set the charset used for encoding / decoding text data from/to SockJS
    */
  def setCharset(value: String) = {
    asJava.setCharset(value)
    this
  }
  def getCharset: String = {
    asJava.getCharset().asInstanceOf[String]
  }
  override def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  override def getClientAuth: io.vertx.core.http.ClientAuth = {
    asJava.getClientAuth()
  }
  override def setClientAuthRequired(value: Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  override def isClientAuthRequired: Boolean = {
    asJava.isClientAuthRequired().asInstanceOf[Boolean]
  }
  override def setCompressionLevel(value: Int) = {
    asJava.setCompressionLevel(value)
    this
  }
  override def getCompressionLevel: Int = {
    asJava.getCompressionLevel().asInstanceOf[Int]
  }
  override def setCompressionSupported(value: Boolean) = {
    asJava.setCompressionSupported(value)
    this
  }
  override def isCompressionSupported: Boolean = {
    asJava.isCompressionSupported().asInstanceOf[Boolean]
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
  override def setDecompressionSupported(value: Boolean) = {
    asJava.setDecompressionSupported(value)
    this
  }
  override def isDecompressionSupported: Boolean = {
    asJava.isDecompressionSupported().asInstanceOf[Boolean]
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
  override def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSecureTransportProtocols().asScala.map(x => x.asInstanceOf[String])
  }
  override def setHandle100ContinueAutomatically(value: Boolean) = {
    asJava.setHandle100ContinueAutomatically(value)
    this
  }
  override def isHandle100ContinueAutomatically: Boolean = {
    asJava.isHandle100ContinueAutomatically().asInstanceOf[Boolean]
  }
  override def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  override def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }
  override def setHttp2ConnectionWindowSize(value: Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  override def getHttp2ConnectionWindowSize: Int = {
    asJava.getHttp2ConnectionWindowSize().asInstanceOf[Int]
  }
  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout().asInstanceOf[Int]
  }
  override def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  override def getInitialSettings: Http2Settings = {
    Http2Settings(asJava.getInitialSettings())
  }

  /**
    * The path of the <i>inputrc</i> config.
    */
  def setIntputrc(value: String) = {
    asJava.setIntputrc(value)
    this
  }
  def getIntputrc: String = {
    asJava.getIntputrc().asInstanceOf[String]
  }
  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }
  override def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  override def getMaxChunkSize: Int = {
    asJava.getMaxChunkSize().asInstanceOf[Int]
  }
  override def setMaxHeaderSize(value: Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }
  override def getMaxHeaderSize: Int = {
    asJava.getMaxHeaderSize().asInstanceOf[Int]
  }
  override def setMaxInitialLineLength(value: Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }
  override def getMaxInitialLineLength: Int = {
    asJava.getMaxInitialLineLength().asInstanceOf[Int]
  }
  override def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  override def getMaxWebsocketFrameSize: Int = {
    asJava.getMaxWebsocketFrameSize().asInstanceOf[Int]
  }
  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }
  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }
  override def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  override def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }
  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }
  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }
  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
    * Set `shell.html` resource to use.
    */
  def setShellHtmlResource(value: io.vertx.core.buffer.Buffer) = {
    asJava.setShellHtmlResource(value)
    this
  }
  def getShellHtmlResource: io.vertx.core.buffer.Buffer = {
    asJava.getShellHtmlResource()
  }
  override def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  override def getSoLinger: Int = {
    asJava.getSoLinger().asInstanceOf[Int]
  }

  /**
    * The SockJS handler options.
    */
  def setSockJSHandlerOptions(value: SockJSHandlerOptions) = {
    asJava.setSockJSHandlerOptions(value.asJava)
    this
  }
  def getSockJSHandlerOptions: SockJSHandlerOptions = {
    SockJSHandlerOptions(asJava.getSockJSHandlerOptions())
  }

  /**
    * Configure the SockJS path, the default value is `/term/\*`.
    */
  def setSockJSPath(value: String) = {
    asJava.setSockJSPath(value)
    this
  }
  def getSockJSPath: String = {
    asJava.getSockJSPath().asInstanceOf[String]
  }
  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  override def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
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

  /**
    * Set `term.js` resource to use.
    */
  def setTermJsResource(value: io.vertx.core.buffer.Buffer) = {
    asJava.setTermJsResource(value)
    this
  }
  def getTermJsResource: io.vertx.core.buffer.Buffer = {
    asJava.getTermJsResource()
  }
  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  override def getTrafficClass: Int = {
    asJava.getTrafficClass().asInstanceOf[Int]
  }
  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
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
    * Set `vertxshell.js` resource to use.
    */
  def setVertsShellJsResource(value: io.vertx.core.buffer.Buffer) = {
    asJava.setVertsShellJsResource(value)
    this
  }
  def getVertsShellJsResource: io.vertx.core.buffer.Buffer = {
    asJava.getVertsShellJsResource()
  }
  override def setWebsocketSubProtocols(value: String) = {
    asJava.setWebsocketSubProtocols(value)
    this
  }
  override def getWebsocketSubProtocols: String = {
    asJava.getWebsocketSubProtocols().asInstanceOf[String]
  }
}

object HttpTermOptions {
  
  def apply() = {
    new HttpTermOptions(new JHttpTermOptions(emptyObj()))
  }
  
  def apply(t: JHttpTermOptions) = {
    if(t != null)
      new HttpTermOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):HttpTermOptions = {
    if(json != null)
      new HttpTermOptions(new JHttpTermOptions(json))
    else
      null
  }
}
