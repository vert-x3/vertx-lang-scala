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

import io.vertx.core.buffer.Buffer
import io.vertx.ext.stomp.{Frame => JFrame}
package object stomp{


  type BridgeOptions = io.vertx.ext.stomp.BridgeOptions
  object BridgeOptions {
    def apply() = new BridgeOptions()
    def apply(json: JsonObject) = new BridgeOptions(json)
    def apply( inboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null, outboundPermitteds: scala.collection.immutable.List[io.vertx.ext.bridge.PermittedOptions] = null, pointToPoint: java.lang.Boolean = null): BridgeOptions = {
      val ret = new BridgeOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (inboundPermitteds != null) ret.setInboundPermitteds(inboundPermitteds.asJava) 
      if (outboundPermitteds != null) ret.setOutboundPermitteds(outboundPermitteds.asJava) 
      if (pointToPoint != null) ret.setPointToPoint(pointToPoint) 
      ret
    }
  }



  type Frame = io.vertx.ext.stomp.Frame
  object Frame {
    def apply() = new Frame()
    def apply(json: JsonObject) = new Frame(json)
    def apply( ack: java.lang.String = null, body: io.vertx.core.buffer.Buffer = null, bodyAsString: java.lang.String = null, command: io.vertx.ext.stomp.Command = null, destination: java.lang.String = null, headers: scala.collection.immutable.Map[String,java.lang.String] = null, id: java.lang.String = null, receipt: java.lang.String = null, transaction: java.lang.String = null): Frame = {
      val ret = new Frame(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (body != null) ret.setBody(body) 
      if (command != null) ret.setCommand(command) 
      if (destination != null) ret.setDestination(destination) 
      if (headers != null) ret.setHeaders(headers.asJava) 
      if (id != null) ret.setId(id) 
      if (transaction != null) ret.setTransaction(transaction) 
      ret
    }
  }



  type StompClientOptions = io.vertx.ext.stomp.StompClientOptions
  object StompClientOptions {
    def apply() = new StompClientOptions()
    def apply(json: JsonObject) = new StompClientOptions(json)
    def apply( acceptedVersions: scala.collection.immutable.List[java.lang.String] = null, activityLogDataFormat: io.netty.handler.logging.ByteBufFormat = null, applicationLayerProtocols: scala.collection.immutable.List[java.lang.String] = null, autoComputeContentLength: java.lang.Boolean = null, bypassHostHeader: java.lang.Boolean = null, connectTimeout: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, heartbeat: io.vertx.core.json.JsonObject = null, host: java.lang.String = null, hostnameVerificationAlgorithm: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, login: java.lang.String = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, passcode: java.lang.String = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trailingLine: java.lang.Boolean = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useStompFrame: java.lang.Boolean = null, virtualHost: java.lang.String = null, writeIdleTimeout: java.lang.Integer = null): StompClientOptions = {
      val ret = new StompClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptedVersions != null) ret.setAcceptedVersions(acceptedVersions.asJava) 
      if (activityLogDataFormat != null) ret.setActivityLogDataFormat(activityLogDataFormat) 
      if (applicationLayerProtocols != null) ret.setApplicationLayerProtocols(applicationLayerProtocols.asJava) 
      if (autoComputeContentLength != null) ret.setAutoComputeContentLength(autoComputeContentLength) 
      if (bypassHostHeader != null) ret.setBypassHostHeader(bypassHostHeader) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (heartbeat != null) ret.setHeartbeat(heartbeat) 
      if (host != null) ret.setHost(host) 
      if (hostnameVerificationAlgorithm != null) ret.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (login != null) ret.setLogin(login) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (passcode != null) ret.setPasscode(passcode) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (readIdleTimeout != null) ret.setReadIdleTimeout(readIdleTimeout) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reconnectAttempts != null) ret.setReconnectAttempts(reconnectAttempts) 
      if (reconnectInterval != null) ret.setReconnectInterval(reconnectInterval) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
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
      if (trailingLine != null) ret.setTrailingLine(trailingLine) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (useStompFrame != null) ret.setUseStompFrame(useStompFrame) 
      if (virtualHost != null) ret.setVirtualHost(virtualHost) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



  type StompServerOptions = io.vertx.ext.stomp.StompServerOptions
  object StompServerOptions {
    def apply() = new StompServerOptions()
    def apply(json: JsonObject) = new StompServerOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, activityLogDataFormat: io.netty.handler.logging.ByteBufFormat = null, clientAuth: io.vertx.core.http.ClientAuth = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, heartbeat: io.vertx.core.json.JsonObject = null, host: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, maxBodyLength: java.lang.Integer = null, maxFrameInTransaction: java.lang.Integer = null, maxHeaderLength: java.lang.Integer = null, maxHeaders: java.lang.Integer = null, maxSubscriptionsByClient: java.lang.Integer = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyProtocolTimeout: java.lang.Long = null, proxyProtocolTimeoutUnit: java.util.concurrent.TimeUnit = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, secured: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sendErrorOnNoSubscriptions: java.lang.Boolean = null, sni: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, supportedVersions: scala.collection.immutable.List[java.lang.String] = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, timeFactor: java.lang.Integer = null, trafficClass: java.lang.Integer = null, trailingLine: java.lang.Boolean = null, transactionChunkSize: java.lang.Integer = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useProxyProtocol: java.lang.Boolean = null, websocketBridge: java.lang.Boolean = null, websocketPath: java.lang.String = null, writeIdleTimeout: java.lang.Integer = null): StompServerOptions = {
      val ret = new StompServerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (activityLogDataFormat != null) ret.setActivityLogDataFormat(activityLogDataFormat) 
      if (clientAuth != null) ret.setClientAuth(clientAuth) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (heartbeat != null) ret.setHeartbeat(heartbeat) 
      if (host != null) ret.setHost(host) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (maxBodyLength != null) ret.setMaxBodyLength(maxBodyLength) 
      if (maxFrameInTransaction != null) ret.setMaxFrameInTransaction(maxFrameInTransaction) 
      if (maxHeaderLength != null) ret.setMaxHeaderLength(maxHeaderLength) 
      if (maxHeaders != null) ret.setMaxHeaders(maxHeaders) 
      if (maxSubscriptionsByClient != null) ret.setMaxSubscriptionsByClient(maxSubscriptionsByClient) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
      if (proxyProtocolTimeout != null) ret.setProxyProtocolTimeout(proxyProtocolTimeout) 
      if (proxyProtocolTimeoutUnit != null) ret.setProxyProtocolTimeoutUnit(proxyProtocolTimeoutUnit) 
      if (readIdleTimeout != null) ret.setReadIdleTimeout(readIdleTimeout) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (secured != null) ret.setSecured(secured) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (sendErrorOnNoSubscriptions != null) ret.setSendErrorOnNoSubscriptions(sendErrorOnNoSubscriptions) 
      if (sni != null) ret.setSni(sni) 
      if (soLinger != null) ret.setSoLinger(soLinger) 
      if (ssl != null) ret.setSsl(ssl) 
      if (sslEngineOptions != null) ret.setSslEngineOptions(sslEngineOptions) 
      if (sslHandshakeTimeout != null) ret.setSslHandshakeTimeout(sslHandshakeTimeout) 
      if (sslHandshakeTimeoutUnit != null) ret.setSslHandshakeTimeoutUnit(sslHandshakeTimeoutUnit) 
      if (supportedVersions != null) ret.setSupportedVersions(supportedVersions.asJava) 
      if (tcpCork != null) ret.setTcpCork(tcpCork) 
      if (tcpFastOpen != null) ret.setTcpFastOpen(tcpFastOpen) 
      if (tcpKeepAlive != null) ret.setTcpKeepAlive(tcpKeepAlive) 
      if (tcpNoDelay != null) ret.setTcpNoDelay(tcpNoDelay) 
      if (tcpQuickAck != null) ret.setTcpQuickAck(tcpQuickAck) 
      if (timeFactor != null) ret.setTimeFactor(timeFactor) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trailingLine != null) ret.setTrailingLine(trailingLine) 
      if (transactionChunkSize != null) ret.setTransactionChunkSize(transactionChunkSize) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (useProxyProtocol != null) ret.setUseProxyProtocol(useProxyProtocol) 
      if (websocketBridge != null) ret.setWebsocketBridge(websocketBridge) 
      if (websocketPath != null) ret.setWebsocketPath(websocketPath) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



}
