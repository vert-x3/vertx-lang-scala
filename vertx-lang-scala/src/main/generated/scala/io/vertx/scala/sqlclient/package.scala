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

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
package object sqlclient{


  type PoolOptions = io.vertx.sqlclient.PoolOptions
  object PoolOptions {
    def apply() = new PoolOptions()
    def apply(json: JsonObject) = new PoolOptions(json)
    def apply( maxSize: java.lang.Integer = null, maxWaitQueueSize: java.lang.Integer = null): PoolOptions = {
      val ret = new PoolOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (maxSize != null) ret.setMaxSize(maxSize) 
      if (maxWaitQueueSize != null) ret.setMaxWaitQueueSize(maxWaitQueueSize) 
      ret
    }
  }



  type SqlConnectOptions = io.vertx.sqlclient.SqlConnectOptions
  object SqlConnectOptions {
    def apply() = new SqlConnectOptions()
    def apply(json: JsonObject) = new SqlConnectOptions(json)
    def apply( cachePreparedStatements: java.lang.Boolean = null, connectTimeout: java.lang.Integer = null, database: java.lang.String = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, host: java.lang.String = null, hostnameVerificationAlgorithm: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, metricsName: java.lang.String = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, password: java.lang.String = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, preparedStatementCacheMaxSize: java.lang.Integer = null, preparedStatementCacheSqlLimit: java.lang.Integer = null, properties: scala.collection.immutable.Map[String,java.lang.String] = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, user: java.lang.String = null): SqlConnectOptions = {
      val ret = new SqlConnectOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (cachePreparedStatements != null) ret.setCachePreparedStatements(cachePreparedStatements) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (database != null) ret.setDatabase(database) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (host != null) ret.setHost(host) 
      if (hostnameVerificationAlgorithm != null) ret.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (password != null) ret.setPassword(password) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
      if (preparedStatementCacheMaxSize != null) ret.setPreparedStatementCacheMaxSize(preparedStatementCacheMaxSize) 
      if (preparedStatementCacheSqlLimit != null) ret.setPreparedStatementCacheSqlLimit(preparedStatementCacheSqlLimit) 
      if (properties != null) ret.setProperties(properties.asJava) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
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
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (user != null) ret.setUser(user) 
      ret
    }
  }



}
