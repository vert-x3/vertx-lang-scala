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


package io.vertx.scala

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.amqp.{AmqpSenderOptions => JAmqpSenderOptions}
package object amqp{


  type AmqpClientOptions = io.vertx.amqp.AmqpClientOptions
  object AmqpClientOptions {
    def apply() = new AmqpClientOptions()
    def apply(json: JsonObject) = new AmqpClientOptions(json)
    def apply( applicationLayerProtocols: scala.collection.immutable.List[java.lang.String] = null, connectTimeout: java.lang.Integer = null, connectionHostname: java.lang.String = null, containerId: java.lang.String = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, heartbeat: java.lang.Integer = null, host: java.lang.String = null, hostnameVerificationAlgorithm: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, maxFrameSize: java.lang.Integer = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, password: java.lang.String = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sniServerName: java.lang.String = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, username: java.lang.String = null, virtualHost: java.lang.String = null, writeIdleTimeout: java.lang.Integer = null): AmqpClientOptions = {
      val ret = new AmqpClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (applicationLayerProtocols != null) ret.setApplicationLayerProtocols(applicationLayerProtocols.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (connectionHostname != null) ret.setConnectionHostname(connectionHostname) 
      if (containerId != null) ret.setContainerId(containerId) 
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
      if (maxFrameSize != null) ret.setMaxFrameSize(maxFrameSize) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (password != null) ret.setPassword(password) 
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
      if (sniServerName != null) ret.setSniServerName(sniServerName) 
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
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (username != null) ret.setUsername(username) 
      if (virtualHost != null) ret.setVirtualHost(virtualHost) 
      if (writeIdleTimeout != null) ret.setWriteIdleTimeout(writeIdleTimeout) 
      ret
    }
  }



  type AmqpReceiverOptions = io.vertx.amqp.AmqpReceiverOptions
  object AmqpReceiverOptions {
    def apply() = new AmqpReceiverOptions()
    def apply(json: JsonObject) = new AmqpReceiverOptions(json)
    def apply( autoAcknowledgement: java.lang.Boolean = null, capabilities: scala.collection.immutable.List[java.lang.String] = null, durable: java.lang.Boolean = null, dynamic: java.lang.Boolean = null, linkName: java.lang.String = null, maxBufferedMessages: java.lang.Integer = null, qos: java.lang.String = null): AmqpReceiverOptions = {
      val ret = new AmqpReceiverOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (autoAcknowledgement != null) ret.setAutoAcknowledgement(autoAcknowledgement) 
      if (capabilities != null) ret.setCapabilities(capabilities.asJava) 
      if (durable != null) ret.setDurable(durable) 
      if (dynamic != null) ret.setDynamic(dynamic) 
      if (linkName != null) ret.setLinkName(linkName) 
      if (maxBufferedMessages != null) ret.setMaxBufferedMessages(maxBufferedMessages) 
      if (qos != null) ret.setQos(qos) 
      ret
    }
  }



  type AmqpSenderOptions = io.vertx.amqp.AmqpSenderOptions
  object AmqpSenderOptions {
    def apply() = new AmqpSenderOptions()
    def apply(json: JsonObject) = new AmqpSenderOptions(json)
    def apply( autoDrained: java.lang.Boolean = null, capabilities: scala.collection.immutable.List[java.lang.String] = null, dynamic: java.lang.Boolean = null, linkName: java.lang.String = null): AmqpSenderOptions = {
      val ret = new AmqpSenderOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (autoDrained != null) ret.setAutoDrained(autoDrained) 
      if (capabilities != null) ret.setCapabilities(capabilities.asJava) 
      if (dynamic != null) ret.setDynamic(dynamic) 
      if (linkName != null) ret.setLinkName(linkName) 
      ret
    }
  }



}
