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


package io.vertx.scala.ext.web

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.web.client.{OAuth2WebClientOptions => JOAuth2WebClientOptions}
package object client{


  type CachingWebClientOptions = io.vertx.ext.web.client.CachingWebClientOptions
  object CachingWebClientOptions {
    def apply() = new CachingWebClientOptions()
    def apply(json: JsonObject) = new CachingWebClientOptions(json)
    def apply( alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, cachedMethods: scala.collection.immutable.Set[io.vertx.core.http.HttpMethod] = null, cachedStatusCodes: scala.collection.immutable.Set[java.lang.Integer] = null, connectTimeout: java.lang.Integer = null, decoderInitialBufferSize: java.lang.Integer = null, defaultHost: java.lang.String = null, defaultPort: java.lang.Integer = null, enableVaryCaching: java.lang.Boolean = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, followRedirects: java.lang.Boolean = null, forceSni: java.lang.Boolean = null, http2ClearTextUpgrade: java.lang.Boolean = null, http2ConnectionWindowSize: java.lang.Integer = null, http2KeepAliveTimeout: java.lang.Integer = null, http2MaxPoolSize: java.lang.Integer = null, http2MultiplexingLimit: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keepAlive: java.lang.Boolean = null, keepAliveTimeout: java.lang.Integer = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxPoolSize: java.lang.Integer = null, maxRedirects: java.lang.Integer = null, maxWaitQueueSize: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, maxWebSockets: java.lang.Integer = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, pipelining: java.lang.Boolean = null, pipeliningLimit: java.lang.Integer = null, poolCleanerPeriod: java.lang.Integer = null, protocolVersion: io.vertx.core.http.HttpVersion = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sendUnmaskedFrames: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, tryUseCompression: java.lang.Boolean = null, tryUsePerFrameWebSocketCompression: java.lang.Boolean = null, tryUsePerMessageWebSocketCompression: java.lang.Boolean = null, tryWebSocketDeflateFrameCompression: java.lang.Boolean = null, useAlpn: java.lang.Boolean = null, userAgent: java.lang.String = null, userAgentEnabled: java.lang.Boolean = null, varyCachingEnabled: java.lang.Boolean = null, verifyHost: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionAllowClientNoContext: java.lang.Boolean = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketCompressionRequestServerNoContext: java.lang.Boolean = null, writeIdleTimeout: java.lang.Integer = null): CachingWebClientOptions = {
      val ret = new CachingWebClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
      if (cachedMethods != null) ret.setCachedMethods(cachedMethods.asJava) 
      if (cachedStatusCodes != null) ret.setCachedStatusCodes(cachedStatusCodes.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (decoderInitialBufferSize != null) ret.setDecoderInitialBufferSize(decoderInitialBufferSize) 
      if (defaultHost != null) ret.setDefaultHost(defaultHost) 
      if (defaultPort != null) ret.setDefaultPort(defaultPort) 
      if (enableVaryCaching != null) ret.setEnableVaryCaching(enableVaryCaching) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (followRedirects != null) ret.setFollowRedirects(followRedirects) 
      if (forceSni != null) ret.setForceSni(forceSni) 
      if (http2ClearTextUpgrade != null) ret.setHttp2ClearTextUpgrade(http2ClearTextUpgrade) 
      if (http2ConnectionWindowSize != null) ret.setHttp2ConnectionWindowSize(http2ConnectionWindowSize) 
      if (http2KeepAliveTimeout != null) ret.setHttp2KeepAliveTimeout(http2KeepAliveTimeout) 
      if (http2MaxPoolSize != null) ret.setHttp2MaxPoolSize(http2MaxPoolSize) 
      if (http2MultiplexingLimit != null) ret.setHttp2MultiplexingLimit(http2MultiplexingLimit) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (initialSettings != null) ret.setInitialSettings(initialSettings) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keepAlive != null) ret.setKeepAlive(keepAlive) 
      if (keepAliveTimeout != null) ret.setKeepAliveTimeout(keepAliveTimeout) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (maxChunkSize != null) ret.setMaxChunkSize(maxChunkSize) 
      if (maxHeaderSize != null) ret.setMaxHeaderSize(maxHeaderSize) 
      if (maxInitialLineLength != null) ret.setMaxInitialLineLength(maxInitialLineLength) 
      if (maxPoolSize != null) ret.setMaxPoolSize(maxPoolSize) 
      if (maxRedirects != null) ret.setMaxRedirects(maxRedirects) 
      if (maxWaitQueueSize != null) ret.setMaxWaitQueueSize(maxWaitQueueSize) 
      if (maxWebSocketFrameSize != null) ret.setMaxWebSocketFrameSize(maxWebSocketFrameSize) 
      if (maxWebSocketMessageSize != null) ret.setMaxWebSocketMessageSize(maxWebSocketMessageSize) 
      if (maxWebSockets != null) ret.setMaxWebSockets(maxWebSockets) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (pipelining != null) ret.setPipelining(pipelining) 
      if (pipeliningLimit != null) ret.setPipeliningLimit(pipeliningLimit) 
      if (poolCleanerPeriod != null) ret.setPoolCleanerPeriod(poolCleanerPeriod) 
      if (protocolVersion != null) ret.setProtocolVersion(protocolVersion) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (readIdleTimeout != null) ret.setReadIdleTimeout(readIdleTimeout) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (sendUnmaskedFrames != null) ret.setSendUnmaskedFrames(sendUnmaskedFrames) 
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
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (tryUseCompression != null) ret.setTryUseCompression(tryUseCompression) 
      if (tryUsePerFrameWebSocketCompression != null) ret.setTryUsePerFrameWebSocketCompression(tryUsePerFrameWebSocketCompression) 
      if (tryUsePerMessageWebSocketCompression != null) ret.setTryUsePerMessageWebSocketCompression(tryUsePerMessageWebSocketCompression) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (userAgent != null) ret.setUserAgent(userAgent) 
      if (userAgentEnabled != null) ret.setUserAgentEnabled(userAgentEnabled) 
      if (verifyHost != null) ret.setVerifyHost(verifyHost) 
      if (webSocketClosingTimeout != null) ret.setWebSocketClosingTimeout(webSocketClosingTimeout) 
      if (webSocketCompressionAllowClientNoContext != null) ret.setWebSocketCompressionAllowClientNoContext(webSocketCompressionAllowClientNoContext) 
      if (webSocketCompressionLevel != null) ret.setWebSocketCompressionLevel(webSocketCompressionLevel) 
      if (webSocketCompressionRequestServerNoContext != null) ret.setWebSocketCompressionRequestServerNoContext(webSocketCompressionRequestServerNoContext) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



  type OAuth2WebClientOptions = io.vertx.ext.web.client.OAuth2WebClientOptions
  object OAuth2WebClientOptions {
    def apply() = new OAuth2WebClientOptions()
    def apply(json: JsonObject) = new OAuth2WebClientOptions(json)
    def apply( leeway: java.lang.Integer = null, renewTokenOnForbidden: java.lang.Boolean = null): OAuth2WebClientOptions = {
      val ret = new OAuth2WebClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (leeway != null) ret.setLeeway(leeway) 
      if (renewTokenOnForbidden != null) ret.setRenewTokenOnForbidden(renewTokenOnForbidden) 
      ret
    }
  }



  type WebClientOptions = io.vertx.ext.web.client.WebClientOptions
  object WebClientOptions {
    def apply() = new WebClientOptions()
    def apply(json: JsonObject) = new WebClientOptions(json)
    def apply( alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, connectTimeout: java.lang.Integer = null, decoderInitialBufferSize: java.lang.Integer = null, defaultHost: java.lang.String = null, defaultPort: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, followRedirects: java.lang.Boolean = null, forceSni: java.lang.Boolean = null, http2ClearTextUpgrade: java.lang.Boolean = null, http2ConnectionWindowSize: java.lang.Integer = null, http2KeepAliveTimeout: java.lang.Integer = null, http2MaxPoolSize: java.lang.Integer = null, http2MultiplexingLimit: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keepAlive: java.lang.Boolean = null, keepAliveTimeout: java.lang.Integer = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxPoolSize: java.lang.Integer = null, maxRedirects: java.lang.Integer = null, maxWaitQueueSize: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, maxWebSockets: java.lang.Integer = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, pipelining: java.lang.Boolean = null, pipeliningLimit: java.lang.Integer = null, poolCleanerPeriod: java.lang.Integer = null, protocolVersion: io.vertx.core.http.HttpVersion = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sendUnmaskedFrames: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, tryUseCompression: java.lang.Boolean = null, tryUsePerFrameWebSocketCompression: java.lang.Boolean = null, tryUsePerMessageWebSocketCompression: java.lang.Boolean = null, tryWebSocketDeflateFrameCompression: java.lang.Boolean = null, useAlpn: java.lang.Boolean = null, userAgent: java.lang.String = null, userAgentEnabled: java.lang.Boolean = null, verifyHost: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionAllowClientNoContext: java.lang.Boolean = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketCompressionRequestServerNoContext: java.lang.Boolean = null, writeIdleTimeout: java.lang.Integer = null): WebClientOptions = {
      val ret = new WebClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (decoderInitialBufferSize != null) ret.setDecoderInitialBufferSize(decoderInitialBufferSize) 
      if (defaultHost != null) ret.setDefaultHost(defaultHost) 
      if (defaultPort != null) ret.setDefaultPort(defaultPort) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (followRedirects != null) ret.setFollowRedirects(followRedirects) 
      if (forceSni != null) ret.setForceSni(forceSni) 
      if (http2ClearTextUpgrade != null) ret.setHttp2ClearTextUpgrade(http2ClearTextUpgrade) 
      if (http2ConnectionWindowSize != null) ret.setHttp2ConnectionWindowSize(http2ConnectionWindowSize) 
      if (http2KeepAliveTimeout != null) ret.setHttp2KeepAliveTimeout(http2KeepAliveTimeout) 
      if (http2MaxPoolSize != null) ret.setHttp2MaxPoolSize(http2MaxPoolSize) 
      if (http2MultiplexingLimit != null) ret.setHttp2MultiplexingLimit(http2MultiplexingLimit) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (initialSettings != null) ret.setInitialSettings(initialSettings) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keepAlive != null) ret.setKeepAlive(keepAlive) 
      if (keepAliveTimeout != null) ret.setKeepAliveTimeout(keepAliveTimeout) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (maxChunkSize != null) ret.setMaxChunkSize(maxChunkSize) 
      if (maxHeaderSize != null) ret.setMaxHeaderSize(maxHeaderSize) 
      if (maxInitialLineLength != null) ret.setMaxInitialLineLength(maxInitialLineLength) 
      if (maxPoolSize != null) ret.setMaxPoolSize(maxPoolSize) 
      if (maxRedirects != null) ret.setMaxRedirects(maxRedirects) 
      if (maxWaitQueueSize != null) ret.setMaxWaitQueueSize(maxWaitQueueSize) 
      if (maxWebSocketFrameSize != null) ret.setMaxWebSocketFrameSize(maxWebSocketFrameSize) 
      if (maxWebSocketMessageSize != null) ret.setMaxWebSocketMessageSize(maxWebSocketMessageSize) 
      if (maxWebSockets != null) ret.setMaxWebSockets(maxWebSockets) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (pipelining != null) ret.setPipelining(pipelining) 
      if (pipeliningLimit != null) ret.setPipeliningLimit(pipeliningLimit) 
      if (poolCleanerPeriod != null) ret.setPoolCleanerPeriod(poolCleanerPeriod) 
      if (protocolVersion != null) ret.setProtocolVersion(protocolVersion) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (readIdleTimeout != null) ret.setReadIdleTimeout(readIdleTimeout) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (sendUnmaskedFrames != null) ret.setSendUnmaskedFrames(sendUnmaskedFrames) 
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
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (tryUseCompression != null) ret.setTryUseCompression(tryUseCompression) 
      if (tryUsePerFrameWebSocketCompression != null) ret.setTryUsePerFrameWebSocketCompression(tryUsePerFrameWebSocketCompression) 
      if (tryUsePerMessageWebSocketCompression != null) ret.setTryUsePerMessageWebSocketCompression(tryUsePerMessageWebSocketCompression) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (userAgent != null) ret.setUserAgent(userAgent) 
      if (userAgentEnabled != null) ret.setUserAgentEnabled(userAgentEnabled) 
      if (verifyHost != null) ret.setVerifyHost(verifyHost) 
      if (webSocketClosingTimeout != null) ret.setWebSocketClosingTimeout(webSocketClosingTimeout) 
      if (webSocketCompressionAllowClientNoContext != null) ret.setWebSocketCompressionAllowClientNoContext(webSocketCompressionAllowClientNoContext) 
      if (webSocketCompressionLevel != null) ret.setWebSocketCompressionLevel(webSocketCompressionLevel) 
      if (webSocketCompressionRequestServerNoContext != null) ret.setWebSocketCompressionRequestServerNoContext(webSocketCompressionRequestServerNoContext) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



}
