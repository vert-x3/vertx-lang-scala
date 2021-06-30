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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.shell.term.{SSHTermOptions => JSSHTermOptions}
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net
import io.vertx.core.net.{JksOptions => JJksOptions}
package object shell{


  type HttpTermOptions = io.vertx.ext.shell.term.HttpTermOptions
  object HttpTermOptions {
    def apply() = new HttpTermOptions()
    def apply(json: JsonObject) = new HttpTermOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, acceptUnmaskedFrames: java.lang.Boolean = null, alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, authOptions: io.vertx.core.json.JsonObject = null, charset: java.lang.String = null, clientAuth: io.vertx.core.http.ClientAuth = null, compressionLevel: java.lang.Integer = null, compressionSupported: java.lang.Boolean = null, decoderInitialBufferSize: java.lang.Integer = null, decompressionSupported: java.lang.Boolean = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, handle100ContinueAutomatically: java.lang.Boolean = null, host: java.lang.String = null, http2ConnectionWindowSize: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, intputrc: java.lang.String = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, perFrameWebSocketCompressionSupported: java.lang.Boolean = null, perMessageWebSocketCompressionSupported: java.lang.Boolean = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyProtocolTimeout: java.lang.Long = null, proxyProtocolTimeoutUnit: java.util.concurrent.TimeUnit = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, shellHtmlResource: io.vertx.core.buffer.Buffer = null, sni: java.lang.Boolean = null, soLinger: java.lang.Integer = null, sockJSHandlerOptions: io.vertx.ext.web.handler.sockjs.SockJSHandlerOptions = null, sockJSPath: java.lang.String = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, termJsResource: io.vertx.core.buffer.Buffer = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useProxyProtocol: java.lang.Boolean = null, vertsShellJsResource: io.vertx.core.buffer.Buffer = null, webSocketAllowServerNoContext: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketPreferredClientNoContext: java.lang.Boolean = null, webSocketSubProtocols: scala.collection.immutable.List[java.lang.String] = null): HttpTermOptions = {
      val ret = new HttpTermOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (acceptUnmaskedFrames != null) ret.setAcceptUnmaskedFrames(acceptUnmaskedFrames) 
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
      if (authOptions != null) ret.setAuthOptions(authOptions) 
      if (charset != null) ret.setCharset(charset) 
      if (clientAuth != null) ret.setClientAuth(clientAuth) 
      if (compressionLevel != null) ret.setCompressionLevel(compressionLevel) 
      if (compressionSupported != null) ret.setCompressionSupported(compressionSupported) 
      if (decoderInitialBufferSize != null) ret.setDecoderInitialBufferSize(decoderInitialBufferSize) 
      if (decompressionSupported != null) ret.setDecompressionSupported(decompressionSupported) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (handle100ContinueAutomatically != null) ret.setHandle100ContinueAutomatically(handle100ContinueAutomatically) 
      if (host != null) ret.setHost(host) 
      if (http2ConnectionWindowSize != null) ret.setHttp2ConnectionWindowSize(http2ConnectionWindowSize) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (initialSettings != null) ret.setInitialSettings(initialSettings) 
      if (intputrc != null) ret.setIntputrc(intputrc) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (maxChunkSize != null) ret.setMaxChunkSize(maxChunkSize) 
      if (maxHeaderSize != null) ret.setMaxHeaderSize(maxHeaderSize) 
      if (maxInitialLineLength != null) ret.setMaxInitialLineLength(maxInitialLineLength) 
      if (maxWebSocketFrameSize != null) ret.setMaxWebSocketFrameSize(maxWebSocketFrameSize) 
      if (maxWebSocketMessageSize != null) ret.setMaxWebSocketMessageSize(maxWebSocketMessageSize) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (perFrameWebSocketCompressionSupported != null) ret.setPerFrameWebSocketCompressionSupported(perFrameWebSocketCompressionSupported) 
      if (perMessageWebSocketCompressionSupported != null) ret.setPerMessageWebSocketCompressionSupported(perMessageWebSocketCompressionSupported) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
      if (proxyProtocolTimeout != null) ret.setProxyProtocolTimeout(proxyProtocolTimeout) 
      if (proxyProtocolTimeoutUnit != null) ret.setProxyProtocolTimeoutUnit(proxyProtocolTimeoutUnit) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (shellHtmlResource != null) ret.setShellHtmlResource(shellHtmlResource) 
      if (sni != null) ret.setSni(sni) 
      if (soLinger != null) ret.setSoLinger(soLinger) 
      if (sockJSHandlerOptions != null) ret.setSockJSHandlerOptions(sockJSHandlerOptions) 
      if (sockJSPath != null) ret.setSockJSPath(sockJSPath) 
      if (ssl != null) ret.setSsl(ssl) 
      if (sslEngineOptions != null) ret.setSslEngineOptions(sslEngineOptions) 
      if (sslHandshakeTimeout != null) ret.setSslHandshakeTimeout(sslHandshakeTimeout) 
      if (sslHandshakeTimeoutUnit != null) ret.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit) 
      if (tcpCork != null) ret.setTcpCork(tcpCork) 
      if (tcpFastOpen != null) ret.setTcpFastOpen(tcpFastOpen) 
      if (tcpKeepAlive != null) ret.setTcpKeepAlive(tcpKeepAlive) 
      if (tcpNoDelay != null) ret.setTcpNoDelay(tcpNoDelay) 
      if (tcpQuickAck != null) ret.setTcpQuickAck(tcpQuickAck) 
      if (termJsResource != null) ret.setTermJsResource(termJsResource) 
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (useProxyProtocol != null) ret.setUseProxyProtocol(useProxyProtocol) 
      if (vertsShellJsResource != null) ret.setVertsShellJsResource(vertsShellJsResource) 
      if (webSocketAllowServerNoContext != null) ret.setWebSocketAllowServerNoContext(webSocketAllowServerNoContext) 
      if (webSocketClosingTimeout != null) ret.setWebSocketClosingTimeout(webSocketClosingTimeout) 
      if (webSocketCompressionLevel != null) ret.setWebSocketCompressionLevel(webSocketCompressionLevel) 
      if (webSocketPreferredClientNoContext != null) ret.setWebSocketPreferredClientNoContext(webSocketPreferredClientNoContext) 
      if (webSocketSubProtocols != null) ret.setWebSocketSubProtocols(webSocketSubProtocols.asJava) 
      ret
    }
  }



  type SSHTermOptions = io.vertx.ext.shell.term.SSHTermOptions
  object SSHTermOptions {
    def apply() = new SSHTermOptions()
    def apply(json: JsonObject) = new SSHTermOptions(json)
    def apply( authOptions: io.vertx.core.json.JsonObject = null, defaultCharset: java.lang.String = null, host: java.lang.String = null, intputrc: java.lang.String = null, keyPairOptions: io.vertx.core.net.JksOptions = null, pemKeyPairOptions: io.vertx.core.net.PemKeyCertOptions = null, pfxKeyPairOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null): SSHTermOptions = {
      val ret = new SSHTermOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (authOptions != null) ret.setAuthOptions(authOptions) 
      if (defaultCharset != null) ret.setDefaultCharset(defaultCharset) 
      if (host != null) ret.setHost(host) 
      if (intputrc != null) ret.setIntputrc(intputrc) 
      if (keyPairOptions != null) ret.setKeyPairOptions(keyPairOptions) 
      if (pemKeyPairOptions != null) ret.setPemKeyPairOptions(pemKeyPairOptions) 
      if (pfxKeyPairOptions != null) ret.setPfxKeyPairOptions(pfxKeyPairOptions) 
      if (port != null) ret.setPort(port) 
      ret
    }
  }



  type ShellServerOptions = io.vertx.ext.shell.ShellServerOptions
  object ShellServerOptions {
    def apply() = new ShellServerOptions()
    def apply(json: JsonObject) = new ShellServerOptions(json)
    def apply( reaperInterval: java.lang.Long = null, sessionTimeout: java.lang.Long = null, welcomeMessage: java.lang.String = null): ShellServerOptions = {
      val ret = new ShellServerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (reaperInterval != null) ret.setReaperInterval(reaperInterval) 
      if (sessionTimeout != null) ret.setSessionTimeout(sessionTimeout) 
      if (welcomeMessage != null) ret.setWelcomeMessage(welcomeMessage) 
      ret
    }
  }



  type ShellServiceOptions = io.vertx.ext.shell.ShellServiceOptions
  object ShellServiceOptions {
    def apply() = new ShellServiceOptions()
    def apply(json: JsonObject) = new ShellServiceOptions(json)
    def apply( httpOptions: io.vertx.ext.shell.term.HttpTermOptions = null, reaperInterval: java.lang.Long = null, sessionTimeout: java.lang.Long = null, sshOptions: io.vertx.ext.shell.term.SSHTermOptions = null, telnetOptions: io.vertx.ext.shell.term.TelnetTermOptions = null, welcomeMessage: java.lang.String = null): ShellServiceOptions = {
      val ret = new ShellServiceOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (httpOptions != null) ret.setHttpOptions(httpOptions) 
      if (reaperInterval != null) ret.setReaperInterval(reaperInterval) 
      if (sessionTimeout != null) ret.setSessionTimeout(sessionTimeout) 
      if (sshOptions != null) ret.setSSHOptions(sshOptions) 
      if (telnetOptions != null) ret.setTelnetOptions(telnetOptions) 
      if (welcomeMessage != null) ret.setWelcomeMessage(welcomeMessage) 
      ret
    }
  }



  type TelnetTermOptions = io.vertx.ext.shell.term.TelnetTermOptions
  object TelnetTermOptions {
    def apply() = new TelnetTermOptions()
    def apply(json: JsonObject) = new TelnetTermOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, charset: java.lang.String = null, clientAuth: io.vertx.core.http.ClientAuth = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, host: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, inBinary: java.lang.Boolean = null, intputrc: java.lang.String = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, outBinary: java.lang.Boolean = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyProtocolTimeout: java.lang.Long = null, proxyProtocolTimeoutUnit: java.util.concurrent.TimeUnit = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sni: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useProxyProtocol: java.lang.Boolean = null): TelnetTermOptions = {
      val ret = new TelnetTermOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (charset != null) ret.setCharset(charset) 
      if (clientAuth != null) ret.setClientAuth(clientAuth) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (host != null) ret.setHost(host) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (inBinary != null) ret.setInBinary(inBinary) 
      if (intputrc != null) ret.setIntputrc(intputrc) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (outBinary != null) ret.setOutBinary(outBinary) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
      if (proxyProtocolTimeout != null) ret.setProxyProtocolTimeout(proxyProtocolTimeout) 
      if (proxyProtocolTimeoutUnit != null) ret.setProxyProtocolTimeoutUnit(proxyProtocolTimeoutUnit) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (sni != null) ret.setSni(sni) 
      if (soLinger != null) ret.setSoLinger(soLinger) 
      if (ssl != null) ret.setSsl(ssl) 
      if (sslEngineOptions != null) ret.setSslEngineOptions(sslEngineOptions) 
      if (sslHandshakeTimeout != null) ret.setSslHandshakeTimeout(sslHandshakeTimeout) 
      if (sslHandshakeTimeoutUnit != null) ret.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit) 
      if (tcpCork != null) ret.setTcpCork(tcpCork) 
      if (tcpFastOpen != null) ret.setTcpFastOpen(tcpFastOpen) 
      if (tcpKeepAlive != null) ret.setTcpKeepAlive(tcpKeepAlive) 
      if (tcpNoDelay != null) ret.setTcpNoDelay(tcpNoDelay) 
      if (tcpQuickAck != null) ret.setTcpQuickAck(tcpQuickAck) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (useProxyProtocol != null) ret.setUseProxyProtocol(useProxyProtocol) 
      ret
    }
  }



}
