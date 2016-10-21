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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * The web term configuration options.
  */

class HttpTermOptions(val asJava: io.vertx.ext.shell.term.HttpTermOptions) {
  def setAcceptBacklog(value:Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  def getAcceptBacklog = {
    asJava.getAcceptBacklog()
  }
  def setAlpnVersions(value:scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }

  /**
    */

  /**
    * Set the charset used for encoding / decoding text data from/to SockJS
    */
  def setCharset(value:String) = {
    asJava.setCharset(value)
    this
  }
  def getCharset = {
    asJava.getCharset()
  }
  def setClientAuth(value:io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  def getClientAuth = {
    asJava.getClientAuth()
  }
  def setClientAuthRequired(value:Boolean) = {
    asJava.setClientAuthRequired(value)
    this
  }
  def isClientAuthRequired = {
    asJava.isClientAuthRequired()
  }
  def setCompressionSupported(value:Boolean) = {
    asJava.setCompressionSupported(value)
    this
  }
  def isCompressionSupported = {
    asJava.isCompressionSupported()
  }
  def addCrlPath(value:String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }
  def addCrlValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }
  def addEnabledCipherSuite(value:String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }
  def addEnabledSecureTransportProtocol(value:String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }
  def setHandle100ContinueAutomatically(value:Boolean) = {
    asJava.setHandle100ContinueAutomatically(value)
    this
  }
  def isHandle100ContinueAutomatically = {
    asJava.isHandle100ContinueAutomatically()
  }
  def setHost(value:String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }
  def setHttp2ConnectionWindowSize(value:Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    asJava.getHttp2ConnectionWindowSize()
  }
  def setIdleTimeout(value:Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }
  def setInitialSettings(value:io.vertx.scala.core.http.Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  def getInitialSettings = {
    asJava.getInitialSettings()
  }

  /**
    * The path of the <i>inputrc</i> config.
    */
  def setIntputrc(value:String) = {
    asJava.setIntputrc(value)
    this
  }
  def getIntputrc = {
    asJava.getIntputrc()
  }
  def setJdkSslEngineOptions(value:io.vertx.scala.core.net.JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  def setKeyStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  def setLogActivity(value:Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setMaxChunkSize(value:Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize = {
    asJava.getMaxChunkSize()
  }
  def setMaxHeaderSize(value:Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }
  def getMaxHeaderSize = {
    asJava.getMaxHeaderSize()
  }
  def setMaxInitialLineLength(value:Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }
  def getMaxInitialLineLength = {
    asJava.getMaxInitialLineLength()
  }
  def setMaxWebsocketFrameSize(value:Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    asJava.getMaxWebsocketFrameSize()
  }
  def setOpenSslEngineOptions(value:io.vertx.scala.core.net.OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }
  def setPemKeyCertOptions(value:io.vertx.scala.core.net.PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  def setPemTrustOptions(value:io.vertx.scala.core.net.PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  def setPfxKeyCertOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  def setPfxTrustOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }
  def setPort(value:Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }
  def setReceiveBufferSize(value:Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }
  def setReuseAddress(value:Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }
  def setSendBufferSize(value:Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Set `shell.html` resource to use.
    */
  def setShellHtmlResource(value:io.vertx.core.buffer.Buffer) = {
    asJava.setShellHtmlResource(value)
    this
  }
  def getShellHtmlResource = {
    asJava.getShellHtmlResource()
  }
  def setSoLinger(value:Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }

  /**
    * The SockJS handler options.
    */
  def setSockJSHandlerOptions(value:io.vertx.scala.ext.web.handler.sockjs.SockJSHandlerOptions) = {
    asJava.setSockJSHandlerOptions(value.asJava)
    this
  }
  def getSockJSHandlerOptions = {
    asJava.getSockJSHandlerOptions()
  }

  /**
    * Configure the SockJS path, the default value is `/term/\*`.
    */
  def setSockJSPath(value:String) = {
    asJava.setSockJSPath(value)
    this
  }
  def getSockJSPath = {
    asJava.getSockJSPath()
  }
  def setSsl(value:Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }
  def setTcpKeepAlive(value:Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }
  def setTcpNoDelay(value:Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set `term.js` resource to use.
    */
  def setTermJsResource(value:io.vertx.core.buffer.Buffer) = {
    asJava.setTermJsResource(value)
    this
  }
  def getTermJsResource = {
    asJava.getTermJsResource()
  }
  def setTrafficClass(value:Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }
  def setTrustStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }
  def setUseAlpn(value:Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }
  def setUsePooledBuffers(value:Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }

  /**
    * Set `vertxshell.js` resource to use.
    */
  def setVertsShellJsResource(value:io.vertx.core.buffer.Buffer) = {
    asJava.setVertsShellJsResource(value)
    this
  }
  def getVertsShellJsResource = {
    asJava.getVertsShellJsResource()
  }
  def setWebsocketSubProtocols(value:String) = {
    asJava.setWebsocketSubProtocols(value)
    this
  }
  def getWebsocketSubProtocols = {
    asJava.getWebsocketSubProtocols()
  }
}

object HttpTermOptions {
  type HttpTermOptionsJava = io.vertx.ext.shell.term.HttpTermOptions
  
  def apply() = {
    new HttpTermOptions(new HttpTermOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: HttpTermOptionsJava) = {
    if(t != null)
      new HttpTermOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):HttpTermOptions = {
    if(json != null)
      new HttpTermOptions(new HttpTermOptionsJava(json))
    else
      null
  }
}
