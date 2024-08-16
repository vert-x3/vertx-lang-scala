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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.consul.{NodeQueryOptions => JNodeQueryOptions}
package object consul{


  type AclToken = io.vertx.ext.consul.AclToken
  object AclToken {
    def apply() = new AclToken()
    def apply(json: JsonObject) = new AclToken(json)
    def apply( id: java.lang.String = null, name: java.lang.String = null, rules: java.lang.String = null, `type`: io.vertx.ext.consul.AclTokenType = null): AclToken = {
      val ret = new AclToken(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (id != null) ret.setId(id) 
      if (name != null) ret.setName(name) 
      if (rules != null) ret.setRules(rules) 
      if (`type` != null) ret.setType(`type`) 
      ret
    }
  }



  type BlockingQueryOptions = io.vertx.ext.consul.BlockingQueryOptions
  object BlockingQueryOptions {
    def apply() = new BlockingQueryOptions()
    def apply(json: JsonObject) = new BlockingQueryOptions(json)
    def apply( index: java.lang.Long = null, wait: java.lang.String = null): BlockingQueryOptions = {
      val ret = new BlockingQueryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (wait != null) ret.setWait(wait) 
      ret
    }
  }



  type Check = io.vertx.ext.consul.Check
  object Check {
    def apply() = new Check()
    def apply(json: JsonObject) = new Check(json)
    def apply( id: java.lang.String = null, name: java.lang.String = null, nodeName: java.lang.String = null, notes: java.lang.String = null, output: java.lang.String = null, serviceId: java.lang.String = null, serviceName: java.lang.String = null, status: io.vertx.ext.consul.CheckStatus = null): Check = {
      val ret = new Check(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (id != null) ret.setId(id) 
      if (name != null) ret.setName(name) 
      if (nodeName != null) ret.setNodeName(nodeName) 
      if (notes != null) ret.setNotes(notes) 
      if (output != null) ret.setOutput(output) 
      if (serviceId != null) ret.setServiceId(serviceId) 
      if (serviceName != null) ret.setServiceName(serviceName) 
      if (status != null) ret.setStatus(status) 
      ret
    }
  }



  type CheckList = io.vertx.ext.consul.CheckList
  object CheckList {
    def apply() = new CheckList()
    def apply(json: JsonObject) = new CheckList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Check] = null): CheckList = {
      val ret = new CheckList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type CheckOptions = io.vertx.ext.consul.CheckOptions
  object CheckOptions {
    def apply() = new CheckOptions()
    def apply(json: JsonObject) = new CheckOptions(json)
    def apply( deregisterAfter: java.lang.String = null, grpc: java.lang.String = null, grpcTls: java.lang.Boolean = null, http: java.lang.String = null, id: java.lang.String = null, interval: java.lang.String = null, name: java.lang.String = null, notes: java.lang.String = null, scriptArgs: scala.collection.immutable.List[java.lang.String] = null, serviceId: java.lang.String = null, status: io.vertx.ext.consul.CheckStatus = null, tcp: java.lang.String = null, tlsSkipVerify: java.lang.Boolean = null, ttl: java.lang.String = null): CheckOptions = {
      val ret = new CheckOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (deregisterAfter != null) ret.setDeregisterAfter(deregisterAfter) 
      if (grpc != null) ret.setGrpc(grpc) 
      if (grpcTls != null) ret.setGrpcTls(grpcTls) 
      if (http != null) ret.setHttp(http) 
      if (id != null) ret.setId(id) 
      if (interval != null) ret.setInterval(interval) 
      if (name != null) ret.setName(name) 
      if (notes != null) ret.setNotes(notes) 
      if (scriptArgs != null) ret.setScriptArgs(scriptArgs.asJava) 
      if (serviceId != null) ret.setServiceId(serviceId) 
      if (status != null) ret.setStatus(status) 
      if (tcp != null) ret.setTcp(tcp) 
      if (tlsSkipVerify != null) ret.setTlsSkipVerify(tlsSkipVerify) 
      if (ttl != null) ret.setTtl(ttl) 
      ret
    }
  }



  type CheckQueryOptions = io.vertx.ext.consul.CheckQueryOptions
  object CheckQueryOptions {
    def apply() = new CheckQueryOptions()
    def apply(json: JsonObject) = new CheckQueryOptions(json)
    def apply( blockingOptions: io.vertx.ext.consul.BlockingQueryOptions = null, near: java.lang.String = null): CheckQueryOptions = {
      val ret = new CheckQueryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (blockingOptions != null) ret.setBlockingOptions(blockingOptions) 
      if (near != null) ret.setNear(near) 
      ret
    }
  }



  type ConsulClientOptions = io.vertx.ext.consul.ConsulClientOptions
  object ConsulClientOptions {
    def apply() = new ConsulClientOptions()
    def apply(json: JsonObject) = new ConsulClientOptions(json)
    def apply( aclToken: java.lang.String = null, alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, connectTimeout: java.lang.Integer = null, dc: java.lang.String = null, decoderInitialBufferSize: java.lang.Integer = null, defaultHost: java.lang.String = null, defaultPort: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, followRedirects: java.lang.Boolean = null, forceSni: java.lang.Boolean = null, http2ClearTextUpgrade: java.lang.Boolean = null, http2ConnectionWindowSize: java.lang.Integer = null, http2KeepAliveTimeout: java.lang.Integer = null, http2MaxPoolSize: java.lang.Integer = null, http2MultiplexingLimit: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keepAlive: java.lang.Boolean = null, keepAliveTimeout: java.lang.Integer = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxPoolSize: java.lang.Integer = null, maxRedirects: java.lang.Integer = null, maxWaitQueueSize: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, maxWebSockets: java.lang.Integer = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, pipelining: java.lang.Boolean = null, pipeliningLimit: java.lang.Integer = null, poolCleanerPeriod: java.lang.Integer = null, protocolVersion: io.vertx.core.http.HttpVersion = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, readIdleTimeout: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sendUnmaskedFrames: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, timeout: java.lang.Long = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, tryUseCompression: java.lang.Boolean = null, tryUsePerFrameWebSocketCompression: java.lang.Boolean = null, tryUsePerMessageWebSocketCompression: java.lang.Boolean = null, tryWebSocketDeflateFrameCompression: java.lang.Boolean = null, useAlpn: java.lang.Boolean = null, userAgent: java.lang.String = null, userAgentEnabled: java.lang.Boolean = null, verifyHost: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionAllowClientNoContext: java.lang.Boolean = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketCompressionRequestServerNoContext: java.lang.Boolean = null, writeIdleTimeout: java.lang.Integer = null): ConsulClientOptions = {
      val ret = new ConsulClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (aclToken != null) ret.setAclToken(aclToken) 
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (dc != null) ret.setDc(dc) 
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
      if (timeout != null) ret.setTimeout(timeout) 
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



  type Coordinate = io.vertx.ext.consul.Coordinate
  object Coordinate {
    def apply() = new Coordinate()
    def apply(json: JsonObject) = new Coordinate(json)
    def apply( adj: java.lang.Float = null, err: java.lang.Float = null, height: java.lang.Float = null, node: java.lang.String = null, vec: scala.collection.immutable.List[java.lang.Float] = null): Coordinate = {
      val ret = new Coordinate(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (adj != null) ret.setAdj(adj) 
      if (err != null) ret.setErr(err) 
      if (height != null) ret.setHeight(height) 
      if (node != null) ret.setNode(node) 
      if (vec != null) ret.setVec(vec.asJava) 
      ret
    }
  }



  type CoordinateList = io.vertx.ext.consul.CoordinateList
  object CoordinateList {
    def apply() = new CoordinateList()
    def apply(json: JsonObject) = new CoordinateList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Coordinate] = null): CoordinateList = {
      val ret = new CoordinateList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type DcCoordinates = io.vertx.ext.consul.DcCoordinates
  object DcCoordinates {
    def apply() = new DcCoordinates()
    def apply(json: JsonObject) = new DcCoordinates(json)
    def apply( datacenter: java.lang.String = null, servers: scala.collection.immutable.List[io.vertx.ext.consul.Coordinate] = null): DcCoordinates = {
      val ret = new DcCoordinates(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (datacenter != null) ret.setDatacenter(datacenter) 
      if (servers != null) ret.setServers(servers.asJava) 
      ret
    }
  }



  type Event = io.vertx.ext.consul.Event
  object Event {
    def apply() = new Event()
    def apply(json: JsonObject) = new Event(json)
    def apply( id: java.lang.String = null, lTime: java.lang.Integer = null, name: java.lang.String = null, node: java.lang.String = null, payload: java.lang.String = null, service: java.lang.String = null, tag: java.lang.String = null, version: java.lang.Integer = null): Event = {
      val ret = new Event(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (id != null) ret.setId(id) 
      if (lTime != null) ret.setLTime(lTime) 
      if (name != null) ret.setName(name) 
      if (node != null) ret.setNode(node) 
      if (payload != null) ret.setPayload(payload) 
      if (service != null) ret.setService(service) 
      if (tag != null) ret.setTag(tag) 
      if (version != null) ret.setVersion(version) 
      ret
    }
  }



  type EventList = io.vertx.ext.consul.EventList
  object EventList {
    def apply() = new EventList()
    def apply(json: JsonObject) = new EventList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Event] = null): EventList = {
      val ret = new EventList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type EventListOptions = io.vertx.ext.consul.EventListOptions
  object EventListOptions {
    def apply() = new EventListOptions()
    def apply(json: JsonObject) = new EventListOptions(json)
    def apply( blockingOptions: io.vertx.ext.consul.BlockingQueryOptions = null, name: java.lang.String = null): EventListOptions = {
      val ret = new EventListOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (blockingOptions != null) ret.setBlockingOptions(blockingOptions) 
      if (name != null) ret.setName(name) 
      ret
    }
  }



  type EventOptions = io.vertx.ext.consul.EventOptions
  object EventOptions {
    def apply() = new EventOptions()
    def apply(json: JsonObject) = new EventOptions(json)
    def apply( node: java.lang.String = null, payload: java.lang.String = null, service: java.lang.String = null, tag: java.lang.String = null): EventOptions = {
      val ret = new EventOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (node != null) ret.setNode(node) 
      if (payload != null) ret.setPayload(payload) 
      if (service != null) ret.setService(service) 
      if (tag != null) ret.setTag(tag) 
      ret
    }
  }



  type KeyValue = io.vertx.ext.consul.KeyValue
  object KeyValue {
    def apply() = new KeyValue()
    def apply(json: JsonObject) = new KeyValue(json)
    def apply( createIndex: java.lang.Long = null, flags: java.lang.Long = null, key: java.lang.String = null, lockIndex: java.lang.Long = null, modifyIndex: java.lang.Long = null, session: java.lang.String = null, value: java.lang.String = null): KeyValue = {
      val ret = new KeyValue(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (createIndex != null) ret.setCreateIndex(createIndex) 
      if (flags != null) ret.setFlags(flags) 
      if (key != null) ret.setKey(key) 
      if (lockIndex != null) ret.setLockIndex(lockIndex) 
      if (modifyIndex != null) ret.setModifyIndex(modifyIndex) 
      if (session != null) ret.setSession(session) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type KeyValueList = io.vertx.ext.consul.KeyValueList
  object KeyValueList {
    def apply() = new KeyValueList()
    def apply(json: JsonObject) = new KeyValueList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.KeyValue] = null): KeyValueList = {
      val ret = new KeyValueList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type KeyValueOptions = io.vertx.ext.consul.KeyValueOptions
  object KeyValueOptions {
    def apply() = new KeyValueOptions()
    def apply(json: JsonObject) = new KeyValueOptions(json)
    def apply( acquireSession: java.lang.String = null, casIndex: java.lang.Long = null, flags: java.lang.Long = null, releaseSession: java.lang.String = null): KeyValueOptions = {
      val ret = new KeyValueOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acquireSession != null) ret.setAcquireSession(acquireSession) 
      if (casIndex != null) ret.setCasIndex(casIndex) 
      if (flags != null) ret.setFlags(flags) 
      if (releaseSession != null) ret.setReleaseSession(releaseSession) 
      ret
    }
  }



  type MaintenanceOptions = io.vertx.ext.consul.MaintenanceOptions
  object MaintenanceOptions {
    def apply() = new MaintenanceOptions()
    def apply(json: JsonObject) = new MaintenanceOptions(json)
    def apply( enable: java.lang.Boolean = null, id: java.lang.String = null, reason: java.lang.String = null): MaintenanceOptions = {
      val ret = new MaintenanceOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (enable != null) ret.setEnable(enable) 
      if (id != null) ret.setId(id) 
      if (reason != null) ret.setReason(reason) 
      ret
    }
  }



  type Node = io.vertx.ext.consul.Node
  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
    def apply( address: java.lang.String = null, datacenter: java.lang.String = null, id: java.lang.String = null, lanAddress: java.lang.String = null, name: java.lang.String = null, nodeMeta: scala.collection.immutable.Map[String,java.lang.String] = null, wanAddress: java.lang.String = null): Node = {
      val ret = new Node(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (address != null) ret.setAddress(address) 
      if (datacenter != null) ret.setDatacenter(datacenter) 
      if (id != null) ret.setId(id) 
      if (lanAddress != null) ret.setLanAddress(lanAddress) 
      if (name != null) ret.setName(name) 
      if (nodeMeta != null) ret.setNodeMeta(nodeMeta.asJava) 
      if (wanAddress != null) ret.setWanAddress(wanAddress) 
      ret
    }
  }



  type NodeList = io.vertx.ext.consul.NodeList
  object NodeList {
    def apply() = new NodeList()
    def apply(json: JsonObject) = new NodeList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Node] = null): NodeList = {
      val ret = new NodeList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type NodeQueryOptions = io.vertx.ext.consul.NodeQueryOptions
  object NodeQueryOptions {
    def apply() = new NodeQueryOptions()
    def apply(json: JsonObject) = new NodeQueryOptions(json)
    def apply( blockingOptions: io.vertx.ext.consul.BlockingQueryOptions = null, near: java.lang.String = null): NodeQueryOptions = {
      val ret = new NodeQueryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (blockingOptions != null) ret.setBlockingOptions(blockingOptions) 
      if (near != null) ret.setNear(near) 
      ret
    }
  }



  type PreparedQueryDefinition = io.vertx.ext.consul.PreparedQueryDefinition
  object PreparedQueryDefinition {
    def apply() = new PreparedQueryDefinition()
    def apply(json: JsonObject) = new PreparedQueryDefinition(json)
    def apply( dcs: scala.collection.immutable.List[java.lang.String] = null, dnsTtl: java.lang.String = null, id: java.lang.String = null, meta: scala.collection.immutable.Map[String,java.lang.String] = null, name: java.lang.String = null, nearestN: java.lang.Integer = null, passing: java.lang.Boolean = null, service: java.lang.String = null, session: java.lang.String = null, tags: scala.collection.immutable.List[java.lang.String] = null, templateRegexp: java.lang.String = null, templateType: java.lang.String = null, token: java.lang.String = null): PreparedQueryDefinition = {
      val ret = new PreparedQueryDefinition(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (dcs != null) ret.setDcs(dcs.asJava) 
      if (dnsTtl != null) ret.setDnsTtl(dnsTtl) 
      if (id != null) ret.setId(id) 
      if (meta != null) ret.setMeta(meta.asJava) 
      if (name != null) ret.setName(name) 
      if (nearestN != null) ret.setNearestN(nearestN) 
      if (passing != null) ret.setPassing(passing) 
      if (service != null) ret.setService(service) 
      if (session != null) ret.setSession(session) 
      if (tags != null) ret.setTags(tags.asJava) 
      if (templateRegexp != null) ret.setTemplateRegexp(templateRegexp) 
      if (templateType != null) ret.setTemplateType(templateType) 
      if (token != null) ret.setToken(token) 
      ret
    }
  }



  type PreparedQueryExecuteOptions = io.vertx.ext.consul.PreparedQueryExecuteOptions
  object PreparedQueryExecuteOptions {
    def apply() = new PreparedQueryExecuteOptions()
    def apply(json: JsonObject) = new PreparedQueryExecuteOptions(json)
    def apply( limit: java.lang.Integer = null, near: java.lang.String = null): PreparedQueryExecuteOptions = {
      val ret = new PreparedQueryExecuteOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (limit != null) ret.setLimit(limit) 
      if (near != null) ret.setNear(near) 
      ret
    }
  }



  type PreparedQueryExecuteResponse = io.vertx.ext.consul.PreparedQueryExecuteResponse
  object PreparedQueryExecuteResponse {
    def apply() = new PreparedQueryExecuteResponse()
    def apply(json: JsonObject) = new PreparedQueryExecuteResponse(json)
    def apply( dc: java.lang.String = null, dnsTtl: java.lang.String = null, failovers: java.lang.Integer = null, nodes: scala.collection.immutable.List[io.vertx.ext.consul.ServiceEntry] = null, service: java.lang.String = null): PreparedQueryExecuteResponse = {
      val ret = new PreparedQueryExecuteResponse(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (dc != null) ret.setDc(dc) 
      if (dnsTtl != null) ret.setDnsTtl(dnsTtl) 
      if (failovers != null) ret.setFailovers(failovers) 
      if (nodes != null) ret.setNodes(nodes.asJava) 
      if (service != null) ret.setService(service) 
      ret
    }
  }



  type Service = io.vertx.ext.consul.Service
  object Service {
    def apply() = new Service()
    def apply(json: JsonObject) = new Service(json)
    def apply( address: java.lang.String = null, id: java.lang.String = null, meta: scala.collection.immutable.Map[String,java.lang.String] = null, name: java.lang.String = null, node: java.lang.String = null, nodeAddress: java.lang.String = null, port: java.lang.Integer = null, tags: scala.collection.immutable.List[java.lang.String] = null): Service = {
      val ret = new Service(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (address != null) ret.setAddress(address) 
      if (id != null) ret.setId(id) 
      if (meta != null) ret.setMeta(meta.asJava) 
      if (name != null) ret.setName(name) 
      if (node != null) ret.setNode(node) 
      if (nodeAddress != null) ret.setNodeAddress(nodeAddress) 
      if (port != null) ret.setPort(port) 
      if (tags != null) ret.setTags(tags.asJava) 
      ret
    }
  }



  type ServiceEntry = io.vertx.ext.consul.ServiceEntry
  object ServiceEntry {
    def apply() = new ServiceEntry()
    def apply(json: JsonObject) = new ServiceEntry(json)
    def apply( checks: scala.collection.immutable.List[io.vertx.ext.consul.Check] = null, node: io.vertx.ext.consul.Node = null, service: io.vertx.ext.consul.Service = null): ServiceEntry = {
      val ret = new ServiceEntry(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (checks != null) ret.setChecks(checks.asJava) 
      if (node != null) ret.setNode(node) 
      if (service != null) ret.setService(service) 
      ret
    }
  }



  type ServiceEntryList = io.vertx.ext.consul.ServiceEntryList
  object ServiceEntryList {
    def apply() = new ServiceEntryList()
    def apply(json: JsonObject) = new ServiceEntryList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.ServiceEntry] = null): ServiceEntryList = {
      val ret = new ServiceEntryList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type ServiceList = io.vertx.ext.consul.ServiceList
  object ServiceList {
    def apply() = new ServiceList()
    def apply(json: JsonObject) = new ServiceList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Service] = null): ServiceList = {
      val ret = new ServiceList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type ServiceOptions = io.vertx.ext.consul.ServiceOptions
  object ServiceOptions {
    def apply() = new ServiceOptions()
    def apply(json: JsonObject) = new ServiceOptions(json)
    def apply( address: java.lang.String = null, checkListOptions: scala.collection.immutable.List[io.vertx.ext.consul.CheckOptions] = null, checkOptions: io.vertx.ext.consul.CheckOptions = null, id: java.lang.String = null, meta: scala.collection.immutable.Map[String,java.lang.String] = null, name: java.lang.String = null, port: java.lang.Integer = null, tags: scala.collection.immutable.List[java.lang.String] = null): ServiceOptions = {
      val ret = new ServiceOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (address != null) ret.setAddress(address) 
      if (checkListOptions != null) ret.setCheckListOptions(checkListOptions.asJava) 
      if (checkOptions != null) ret.setCheckOptions(checkOptions) 
      if (id != null) ret.setId(id) 
      if (meta != null) ret.setMeta(meta.asJava) 
      if (name != null) ret.setName(name) 
      if (port != null) ret.setPort(port) 
      if (tags != null) ret.setTags(tags.asJava) 
      ret
    }
  }



  type ServiceQueryOptions = io.vertx.ext.consul.ServiceQueryOptions
  object ServiceQueryOptions {
    def apply() = new ServiceQueryOptions()
    def apply(json: JsonObject) = new ServiceQueryOptions(json)
    def apply( blockingOptions: io.vertx.ext.consul.BlockingQueryOptions = null, near: java.lang.String = null, tag: java.lang.String = null): ServiceQueryOptions = {
      val ret = new ServiceQueryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (blockingOptions != null) ret.setBlockingOptions(blockingOptions) 
      if (near != null) ret.setNear(near) 
      if (tag != null) ret.setTag(tag) 
      ret
    }
  }



  type Session = io.vertx.ext.consul.Session
  object Session {
    def apply() = new Session()
    def apply(json: JsonObject) = new Session(json)
    def apply( checks: scala.collection.immutable.List[java.lang.String] = null, createIndex: java.lang.Long = null, id: java.lang.String = null, index: java.lang.Long = null, lockDelay: java.lang.Long = null, node: java.lang.String = null): Session = {
      val ret = new Session(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (checks != null) ret.setChecks(checks.asJava) 
      if (createIndex != null) ret.setCreateIndex(createIndex) 
      if (id != null) ret.setId(id) 
      if (index != null) ret.setIndex(index) 
      if (lockDelay != null) ret.setLockDelay(lockDelay) 
      if (node != null) ret.setNode(node) 
      ret
    }
  }



  type SessionList = io.vertx.ext.consul.SessionList
  object SessionList {
    def apply() = new SessionList()
    def apply(json: JsonObject) = new SessionList(json)
    def apply( index: java.lang.Long = null, list: scala.collection.immutable.List[io.vertx.ext.consul.Session] = null): SessionList = {
      val ret = new SessionList(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (index != null) ret.setIndex(index) 
      if (list != null) ret.setList(list.asJava) 
      ret
    }
  }



  type SessionOptions = io.vertx.ext.consul.SessionOptions
  object SessionOptions {
    def apply() = new SessionOptions()
    def apply(json: JsonObject) = new SessionOptions(json)
    def apply( behavior: io.vertx.ext.consul.SessionBehavior = null, checks: scala.collection.immutable.List[java.lang.String] = null, lockDelay: java.lang.Long = null, name: java.lang.String = null, node: java.lang.String = null, ttl: java.lang.Long = null): SessionOptions = {
      val ret = new SessionOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (behavior != null) ret.setBehavior(behavior) 
      if (checks != null) ret.setChecks(checks.asJava) 
      if (lockDelay != null) ret.setLockDelay(lockDelay) 
      if (name != null) ret.setName(name) 
      if (node != null) ret.setNode(node) 
      if (ttl != null) ret.setTtl(ttl) 
      ret
    }
  }



  type TxnError = io.vertx.ext.consul.TxnError
  object TxnError {
    def apply() = new TxnError()
    def apply(json: JsonObject) = new TxnError(json)
    def apply( opIndex: java.lang.Integer = null, what: java.lang.String = null): TxnError = {
      val ret = new TxnError(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (opIndex != null) ret.setOpIndex(opIndex) 
      if (what != null) ret.setWhat(what) 
      ret
    }
  }



  type TxnKVOperation = io.vertx.ext.consul.TxnKVOperation
  object TxnKVOperation {
    def apply() = new TxnKVOperation()
    def apply(json: JsonObject) = new TxnKVOperation(json)
    def apply( flags: java.lang.Long = null, index: java.lang.Long = null, key: java.lang.String = null, session: java.lang.String = null, `type`: io.vertx.ext.consul.TxnKVVerb = null, value: java.lang.String = null): TxnKVOperation = {
      val ret = new TxnKVOperation(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (flags != null) ret.setFlags(flags) 
      if (index != null) ret.setIndex(index) 
      if (key != null) ret.setKey(key) 
      if (session != null) ret.setSession(session) 
      if (`type` != null) ret.setType(`type`) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type TxnRequest = io.vertx.ext.consul.TxnRequest
  object TxnRequest {
    def apply() = new TxnRequest()
    def apply(json: JsonObject) = new TxnRequest(json)

  }



  type TxnResponse = io.vertx.ext.consul.TxnResponse
  object TxnResponse {
    def apply() = new TxnResponse()
    def apply(json: JsonObject) = new TxnResponse(json)

  }



}
