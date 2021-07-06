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

import io.vertx.core.http.{HttpMethod => JHttpMethod}
package object core{


  import io.vertx.core.json.{JsonObject => JJsonObject}
  import io.vertx.core.json.{JsonArray => JJsonArray}

  type JsonObject = JJsonObject
  type JsonArray = JJsonArray

  object JsonObject {
    def apply(): JsonObject = new JJsonObject()
    def apply(json: String): JsonObject = new JJsonObject(json)
    def apply(fields: (String, Any)*): JsonObject = {
      val o = new JsonObject()
      fields.foreach {
        case (key, l: Array[_]) => o.put(key, listToJsArr(l))
        case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
        case (key, value) => o.put(key, value)
      }
      o
    }
  }

  object JsonArray {
    def apply(): JsonArray = new JJsonArray()
    def apply(json: String): JsonArray = new JJsonArray(json)
    def apply(fields: Any*): JsonArray = {
      val a = new JsonArray()
      fields.foreach {
        case array: Array[_] => a.add(listToJsArr(array))
        case seq: Seq[_] => a.add(listToJsArr(seq))
        case f => a.add(f)
      }
      a
    }
  }

  private def listToJsArr(a: Seq[_]) = JsonArray(a: _*)


  type AddressResolverOptions = io.vertx.core.dns.AddressResolverOptions
  object AddressResolverOptions {
    def apply() = new AddressResolverOptions()
    def apply(json: JsonObject) = new AddressResolverOptions(json)
    def apply( cacheMaxTimeToLive: java.lang.Integer = null, cacheMinTimeToLive: java.lang.Integer = null, cacheNegativeTimeToLive: java.lang.Integer = null, hostsPath: java.lang.String = null, hostsValue: io.vertx.core.buffer.Buffer = null, maxQueries: java.lang.Integer = null, ndots: java.lang.Integer = null, optResourceEnabled: java.lang.Boolean = null, queryTimeout: java.lang.Long = null, rdFlag: java.lang.Boolean = null, rotateServers: java.lang.Boolean = null, roundRobinInetAddress: java.lang.Boolean = null, searchDomains: scala.collection.immutable.List[java.lang.String] = null, servers: scala.collection.immutable.List[java.lang.String] = null): AddressResolverOptions = {
      val ret = new AddressResolverOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (cacheMaxTimeToLive != null) ret.setCacheMaxTimeToLive(cacheMaxTimeToLive) 
      if (cacheMinTimeToLive != null) ret.setCacheMinTimeToLive(cacheMinTimeToLive) 
      if (cacheNegativeTimeToLive != null) ret.setCacheNegativeTimeToLive(cacheNegativeTimeToLive) 
      if (hostsPath != null) ret.setHostsPath(hostsPath) 
      if (hostsValue != null) ret.setHostsValue(hostsValue) 
      if (maxQueries != null) ret.setMaxQueries(maxQueries) 
      if (ndots != null) ret.setNdots(ndots) 
      if (optResourceEnabled != null) ret.setOptResourceEnabled(optResourceEnabled) 
      if (queryTimeout != null) ret.setQueryTimeout(queryTimeout) 
      if (rdFlag != null) ret.setRdFlag(rdFlag) 
      if (rotateServers != null) ret.setRotateServers(rotateServers) 
      if (roundRobinInetAddress != null) ret.setRoundRobinInetAddress(roundRobinInetAddress) 
      if (searchDomains != null) ret.setSearchDomains(searchDomains.asJava) 
      if (servers != null) ret.setServers(servers.asJava) 
      ret
    }
  }



  type Argument = io.vertx.core.cli.Argument
  object Argument {
    def apply() = new Argument()
    def apply(json: JsonObject) = new Argument(json)
    def apply( argName: java.lang.String = null, defaultValue: java.lang.String = null, description: java.lang.String = null, hidden: java.lang.Boolean = null, index: java.lang.Integer = null, multiValued: java.lang.Boolean = null, required: java.lang.Boolean = null): Argument = {
      val ret = new Argument(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (argName != null) ret.setArgName(argName) 
      if (defaultValue != null) ret.setDefaultValue(defaultValue) 
      if (description != null) ret.setDescription(description) 
      if (hidden != null) ret.setHidden(hidden) 
      if (index != null) ret.setIndex(index) 
      if (multiValued != null) ret.setMultiValued(multiValued) 
      if (required != null) ret.setRequired(required) 
      ret
    }
  }






  type CopyOptions = io.vertx.core.file.CopyOptions
  object CopyOptions {
    def apply() = new CopyOptions()
    def apply(json: JsonObject) = new CopyOptions(json)
    def apply( atomicMove: java.lang.Boolean = null, copyAttributes: java.lang.Boolean = null, nofollowLinks: java.lang.Boolean = null, replaceExisting: java.lang.Boolean = null): CopyOptions = {
      val ret = new CopyOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (atomicMove != null) ret.setAtomicMove(atomicMove) 
      if (copyAttributes != null) ret.setCopyAttributes(copyAttributes) 
      if (nofollowLinks != null) ret.setNofollowLinks(nofollowLinks) 
      if (replaceExisting != null) ret.setReplaceExisting(replaceExisting) 
      ret
    }
  }



  type DatagramSocketOptions = io.vertx.core.datagram.DatagramSocketOptions
  object DatagramSocketOptions {
    def apply() = new DatagramSocketOptions()
    def apply(json: JsonObject) = new DatagramSocketOptions(json)
    def apply( broadcast: java.lang.Boolean = null, ipV6: java.lang.Boolean = null, logActivity: java.lang.Boolean = null, loopbackModeDisabled: java.lang.Boolean = null, multicastNetworkInterface: java.lang.String = null, multicastTimeToLive: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, trafficClass: java.lang.Integer = null): DatagramSocketOptions = {
      val ret = new DatagramSocketOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (broadcast != null) ret.setBroadcast(broadcast) 
      if (ipV6 != null) ret.setIpV6(ipV6) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (loopbackModeDisabled != null) ret.setLoopbackModeDisabled(loopbackModeDisabled) 
      if (multicastNetworkInterface != null) ret.setMulticastNetworkInterface(multicastNetworkInterface) 
      if (multicastTimeToLive != null) ret.setMulticastTimeToLive(multicastTimeToLive) 
      if (receiveBufferSize != null) ret.setReceiveBufferSize(receiveBufferSize) 
      if (reuseAddress != null) ret.setReuseAddress(reuseAddress) 
      if (reusePort != null) ret.setReusePort(reusePort) 
      if (sendBufferSize != null) ret.setSendBufferSize(sendBufferSize) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      ret
    }
  }



  type DeliveryOptions = io.vertx.core.eventbus.DeliveryOptions
  object DeliveryOptions {
    def apply() = new DeliveryOptions()
    def apply(json: JsonObject) = new DeliveryOptions(json)
    def apply( codecName: java.lang.String = null, localOnly: java.lang.Boolean = null, sendTimeout: java.lang.Long = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null): DeliveryOptions = {
      val ret = new DeliveryOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (codecName != null) ret.setCodecName(codecName) 
      if (localOnly != null) ret.setLocalOnly(localOnly) 
      if (sendTimeout != null) ret.setSendTimeout(sendTimeout) 
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      ret
    }
  }



  type DeploymentOptions = io.vertx.core.DeploymentOptions
  object DeploymentOptions {
    def apply() = new DeploymentOptions()
    def apply(json: JsonObject) = new DeploymentOptions(json)
    def apply( classLoader: java.lang.ClassLoader = null, config: io.vertx.core.json.JsonObject = null, ha: java.lang.Boolean = null, instances: java.lang.Integer = null, maxWorkerExecuteTime: java.lang.Long = null, maxWorkerExecuteTimeUnit: java.util.concurrent.TimeUnit = null, worker: java.lang.Boolean = null, workerPoolName: java.lang.String = null, workerPoolSize: java.lang.Integer = null): DeploymentOptions = {
      val ret = new DeploymentOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (classLoader != null) ret.setClassLoader(classLoader) 
      if (config != null) ret.setConfig(config) 
      if (ha != null) ret.setHa(ha) 
      if (instances != null) ret.setInstances(instances) 
      if (maxWorkerExecuteTime != null) ret.setMaxWorkerExecuteTime(maxWorkerExecuteTime) 
      if (maxWorkerExecuteTimeUnit != null) ret.setMaxWorkerExecuteTimeUnit(maxWorkerExecuteTimeUnit) 
      if (worker != null) ret.setWorker(worker) 
      if (workerPoolName != null) ret.setWorkerPoolName(workerPoolName) 
      if (workerPoolSize != null) ret.setWorkerPoolSize(workerPoolSize) 
      ret
    }
  }



  type DnsClientOptions = io.vertx.core.dns.DnsClientOptions
  object DnsClientOptions {
    def apply() = new DnsClientOptions()
    def apply(json: JsonObject) = new DnsClientOptions(json)
    def apply( host: java.lang.String = null, logActivity: java.lang.Boolean = null, port: java.lang.Integer = null, queryTimeout: java.lang.Long = null, recursionDesired: java.lang.Boolean = null): DnsClientOptions = {
      val ret = new DnsClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (host != null) ret.setHost(host) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (port != null) ret.setPort(port) 
      if (queryTimeout != null) ret.setQueryTimeout(queryTimeout) 
      if (recursionDesired != null) ret.setRecursionDesired(recursionDesired) 
      ret
    }
  }



  type EventBusOptions = io.vertx.core.eventbus.EventBusOptions
  object EventBusOptions {
    def apply() = new EventBusOptions()
    def apply(json: JsonObject) = new EventBusOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, clientAuth: io.vertx.core.http.ClientAuth = null, clusterNodeMetadata: io.vertx.core.json.JsonObject = null, clusterPingInterval: java.lang.Long = null, clusterPingReplyInterval: java.lang.Long = null, clusterPublicHost: java.lang.String = null, clusterPublicPort: java.lang.Integer = null, connectTimeout: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, host: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null): EventBusOptions = {
      val ret = new EventBusOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (clientAuth != null) ret.setClientAuth(clientAuth) 
      if (clusterNodeMetadata != null) ret.setClusterNodeMetadata(clusterNodeMetadata) 
      if (clusterPingInterval != null) ret.setClusterPingInterval(clusterPingInterval) 
      if (clusterPingReplyInterval != null) ret.setClusterPingReplyInterval(clusterPingReplyInterval) 
      if (clusterPublicHost != null) ret.setClusterPublicHost(clusterPublicHost) 
      if (clusterPublicPort != null) ret.setClusterPublicPort(clusterPublicPort) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (host != null) ret.setHost(host) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
      if (port != null) ret.setPort(port) 
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
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      ret
    }
  }



  type FileSystemOptions = io.vertx.core.file.FileSystemOptions
  object FileSystemOptions {
    def apply() = new FileSystemOptions()
    def apply(json: JsonObject) = new FileSystemOptions(json)
    def apply( classPathResolvingEnabled: java.lang.Boolean = null, fileCacheDir: java.lang.String = null, fileCachingEnabled: java.lang.Boolean = null): FileSystemOptions = {
      val ret = new FileSystemOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (classPathResolvingEnabled != null) ret.setClassPathResolvingEnabled(classPathResolvingEnabled) 
      if (fileCacheDir != null) ret.setFileCacheDir(fileCacheDir) 
      if (fileCachingEnabled != null) ret.setFileCachingEnabled(fileCachingEnabled) 
      ret
    }
  }



  type GoAway = io.vertx.core.http.GoAway
  object GoAway {
    def apply() = new GoAway()
    def apply(json: JsonObject) = new GoAway(json)
    def apply( debugData: io.vertx.core.buffer.Buffer = null, errorCode: java.lang.Long = null, lastStreamId: java.lang.Integer = null): GoAway = {
      val ret = new GoAway(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (debugData != null) ret.setDebugData(debugData) 
      if (errorCode != null) ret.setErrorCode(errorCode) 
      if (lastStreamId != null) ret.setLastStreamId(lastStreamId) 
      ret
    }
  }



  type Http2Settings = io.vertx.core.http.Http2Settings
  object Http2Settings {
    def apply() = new Http2Settings()
    def apply(json: JsonObject) = new Http2Settings(json)
    def apply( headerTableSize: java.lang.Long = null, initialWindowSize: java.lang.Integer = null, maxConcurrentStreams: java.lang.Long = null, maxFrameSize: java.lang.Integer = null, maxHeaderListSize: java.lang.Long = null, pushEnabled: java.lang.Boolean = null): Http2Settings = {
      val ret = new Http2Settings(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (headerTableSize != null) ret.setHeaderTableSize(headerTableSize) 
      if (initialWindowSize != null) ret.setInitialWindowSize(initialWindowSize) 
      if (maxConcurrentStreams != null) ret.setMaxConcurrentStreams(maxConcurrentStreams) 
      if (maxFrameSize != null) ret.setMaxFrameSize(maxFrameSize) 
      if (maxHeaderListSize != null) ret.setMaxHeaderListSize(maxHeaderListSize) 
      if (pushEnabled != null) ret.setPushEnabled(pushEnabled) 
      ret
    }
  }



  type HttpClientOptions = io.vertx.core.http.HttpClientOptions
  object HttpClientOptions {
    def apply() = new HttpClientOptions()
    def apply(json: JsonObject) = new HttpClientOptions(json)
    def apply( alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, connectTimeout: java.lang.Integer = null, decoderInitialBufferSize: java.lang.Integer = null, defaultHost: java.lang.String = null, defaultPort: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, forceSni: java.lang.Boolean = null, http2ClearTextUpgrade: java.lang.Boolean = null, http2ConnectionWindowSize: java.lang.Integer = null, http2KeepAliveTimeout: java.lang.Integer = null, http2MaxPoolSize: java.lang.Integer = null, http2MultiplexingLimit: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keepAlive: java.lang.Boolean = null, keepAliveTimeout: java.lang.Integer = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxPoolSize: java.lang.Integer = null, maxRedirects: java.lang.Integer = null, maxWaitQueueSize: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, maxWebSockets: java.lang.Integer = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, pipelining: java.lang.Boolean = null, pipeliningLimit: java.lang.Integer = null, poolCleanerPeriod: java.lang.Integer = null, protocolVersion: io.vertx.core.http.HttpVersion = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sendUnmaskedFrames: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, tryUseCompression: java.lang.Boolean = null, tryUsePerFrameWebSocketCompression: java.lang.Boolean = null, tryUsePerMessageWebSocketCompression: java.lang.Boolean = null, tryWebSocketDeflateFrameCompression: java.lang.Boolean = null, useAlpn: java.lang.Boolean = null, verifyHost: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionAllowClientNoContext: java.lang.Boolean = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketCompressionRequestServerNoContext: java.lang.Boolean = null): HttpClientOptions = {
      val ret = new HttpClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (decoderInitialBufferSize != null) ret.setDecoderInitialBufferSize(decoderInitialBufferSize) 
      if (defaultHost != null) ret.setDefaultHost(defaultHost) 
      if (defaultPort != null) ret.setDefaultPort(defaultPort) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
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
      if (verifyHost != null) ret.setVerifyHost(verifyHost) 
      if (webSocketClosingTimeout != null) ret.setWebSocketClosingTimeout(webSocketClosingTimeout) 
      if (webSocketCompressionAllowClientNoContext != null) ret.setWebSocketCompressionAllowClientNoContext(webSocketCompressionAllowClientNoContext) 
      if (webSocketCompressionLevel != null) ret.setWebSocketCompressionLevel(webSocketCompressionLevel) 
      if (webSocketCompressionRequestServerNoContext != null) ret.setWebSocketCompressionRequestServerNoContext(webSocketCompressionRequestServerNoContext) 
      ret
    }
  }



  type HttpMethod = io.vertx.core.http.HttpMethod
  object HttpMethod {
    def apply(str: String) = new HttpMethod(str)

  }



  type HttpServerOptions = io.vertx.core.http.HttpServerOptions
  object HttpServerOptions {
    def apply() = new HttpServerOptions()
    def apply(json: JsonObject) = new HttpServerOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, acceptUnmaskedFrames: java.lang.Boolean = null, alpnVersions: scala.collection.immutable.List[io.vertx.core.http.HttpVersion] = null, clientAuth: io.vertx.core.http.ClientAuth = null, compressionLevel: java.lang.Integer = null, compressionSupported: java.lang.Boolean = null, decoderInitialBufferSize: java.lang.Integer = null, decompressionSupported: java.lang.Boolean = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, handle100ContinueAutomatically: java.lang.Boolean = null, host: java.lang.String = null, http2ConnectionWindowSize: java.lang.Integer = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, initialSettings: io.vertx.core.http.Http2Settings = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, maxChunkSize: java.lang.Integer = null, maxFormAttributeSize: java.lang.Integer = null, maxHeaderSize: java.lang.Integer = null, maxInitialLineLength: java.lang.Integer = null, maxWebSocketFrameSize: java.lang.Integer = null, maxWebSocketMessageSize: java.lang.Integer = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, perFrameWebSocketCompressionSupported: java.lang.Boolean = null, perMessageWebSocketCompressionSupported: java.lang.Boolean = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyProtocolTimeout: java.lang.Long = null, proxyProtocolTimeoutUnit: java.util.concurrent.TimeUnit = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sni: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, trafficClass: java.lang.Integer = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useProxyProtocol: java.lang.Boolean = null, webSocketAllowServerNoContext: java.lang.Boolean = null, webSocketClosingTimeout: java.lang.Integer = null, webSocketCompressionLevel: java.lang.Integer = null, webSocketPreferredClientNoContext: java.lang.Boolean = null, webSocketSubProtocols: scala.collection.immutable.List[java.lang.String] = null): HttpServerOptions = {
      val ret = new HttpServerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (acceptUnmaskedFrames != null) ret.setAcceptUnmaskedFrames(acceptUnmaskedFrames) 
      if (alpnVersions != null) ret.setAlpnVersions(alpnVersions.asJava) 
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
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (maxChunkSize != null) ret.setMaxChunkSize(maxChunkSize) 
      if (maxFormAttributeSize != null) ret.setMaxFormAttributeSize(maxFormAttributeSize) 
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
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      if (useProxyProtocol != null) ret.setUseProxyProtocol(useProxyProtocol) 
      if (webSocketAllowServerNoContext != null) ret.setWebSocketAllowServerNoContext(webSocketAllowServerNoContext) 
      if (webSocketClosingTimeout != null) ret.setWebSocketClosingTimeout(webSocketClosingTimeout) 
      if (webSocketCompressionLevel != null) ret.setWebSocketCompressionLevel(webSocketCompressionLevel) 
      if (webSocketPreferredClientNoContext != null) ret.setWebSocketPreferredClientNoContext(webSocketPreferredClientNoContext) 
      if (webSocketSubProtocols != null) ret.setWebSocketSubProtocols(webSocketSubProtocols.asJava) 
      ret
    }
  }



  type JdkSSLEngineOptions = io.vertx.core.net.JdkSSLEngineOptions
  object JdkSSLEngineOptions {
    def apply() = new JdkSSLEngineOptions()
    def apply(json: JsonObject) = new JdkSSLEngineOptions(json)

  }



  type JksOptions = io.vertx.core.net.JksOptions
  object JksOptions {
    def apply() = new JksOptions()
    def apply(json: JsonObject) = new JksOptions(json)
    def apply( alias: java.lang.String = null, aliasPassword: java.lang.String = null, password: java.lang.String = null, path: java.lang.String = null, value: io.vertx.core.buffer.Buffer = null): JksOptions = {
      val ret = new JksOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alias != null) ret.setAlias(alias) 
      if (aliasPassword != null) ret.setAliasPassword(aliasPassword) 
      if (password != null) ret.setPassword(password) 
      if (path != null) ret.setPath(path) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type KeyStoreOptions = io.vertx.core.net.KeyStoreOptions
  object KeyStoreOptions {
    def apply() = new KeyStoreOptions()
    def apply(json: JsonObject) = new KeyStoreOptions(json)
    def apply( alias: java.lang.String = null, aliasPassword: java.lang.String = null, password: java.lang.String = null, path: java.lang.String = null, provider: java.lang.String = null, `type`: java.lang.String = null, value: io.vertx.core.buffer.Buffer = null): KeyStoreOptions = {
      val ret = new KeyStoreOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alias != null) ret.setAlias(alias) 
      if (aliasPassword != null) ret.setAliasPassword(aliasPassword) 
      if (password != null) ret.setPassword(password) 
      if (path != null) ret.setPath(path) 
      if (provider != null) ret.setProvider(provider) 
      if (`type` != null) ret.setType(`type`) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type MetricsOptions = io.vertx.core.metrics.MetricsOptions
  object MetricsOptions {
    def apply() = new MetricsOptions()
    def apply(json: JsonObject) = new MetricsOptions(json)
    def apply( enabled: java.lang.Boolean = null, factory: io.vertx.core.spi.VertxMetricsFactory = null): MetricsOptions = {
      val ret = new MetricsOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (enabled != null) ret.setEnabled(enabled) 
      if (factory != null) ret.setFactory(factory) 
      ret
    }
  }



  type NetClientOptions = io.vertx.core.net.NetClientOptions
  object NetClientOptions {
    def apply() = new NetClientOptions()
    def apply(json: JsonObject) = new NetClientOptions(json)
    def apply( applicationLayerProtocols: scala.collection.immutable.List[java.lang.String] = null, connectTimeout: java.lang.Integer = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, hostnameVerificationAlgorithm: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, localAddress: java.lang.String = null, logActivity: java.lang.Boolean = null, metricsName: java.lang.String = null, nonProxyHosts: scala.collection.immutable.List[java.lang.String] = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, receiveBufferSize: java.lang.Integer = null, reconnectAttempts: java.lang.Integer = null, reconnectInterval: java.lang.Long = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustAll: java.lang.Boolean = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null): NetClientOptions = {
      val ret = new NetClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (applicationLayerProtocols != null) ret.setApplicationLayerProtocols(applicationLayerProtocols.asJava) 
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (hostnameVerificationAlgorithm != null) ret.setHostnameVerificationAlgorithm(hostnameVerificationAlgorithm) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (localAddress != null) ret.setLocalAddress(localAddress) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (metricsName != null) ret.setMetricsName(metricsName) 
      if (nonProxyHosts != null) ret.setNonProxyHosts(nonProxyHosts.asJava) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
      if (pemKeyCertOptions != null) ret.setPemKeyCertOptions(pemKeyCertOptions) 
      if (pemTrustOptions != null) ret.setPemTrustOptions(pemTrustOptions) 
      if (pfxKeyCertOptions != null) ret.setPfxKeyCertOptions(pfxKeyCertOptions) 
      if (pfxTrustOptions != null) ret.setPfxTrustOptions(pfxTrustOptions) 
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
      if (trafficClass != null) ret.setTrafficClass(trafficClass) 
      if (trustAll != null) ret.setTrustAll(trustAll) 
      if (trustOptions != null) ret.setTrustOptions(trustOptions) 
      if (trustStoreOptions != null) ret.setTrustStoreOptions(trustStoreOptions) 
      if (useAlpn != null) ret.setUseAlpn(useAlpn) 
      ret
    }
  }



  type NetServerOptions = io.vertx.core.net.NetServerOptions
  object NetServerOptions {
    def apply() = new NetServerOptions()
    def apply(json: JsonObject) = new NetServerOptions(json)
    def apply( acceptBacklog: java.lang.Integer = null, clientAuth: io.vertx.core.http.ClientAuth = null, enabledSecureTransportProtocols: scala.collection.immutable.Set[java.lang.String] = null, host: java.lang.String = null, idleTimeout: java.lang.Integer = null, idleTimeoutUnit: java.util.concurrent.TimeUnit = null, jdkSslEngineOptions: io.vertx.core.net.JdkSSLEngineOptions = null, keyCertOptions: io.vertx.core.net.KeyCertOptions = null, keyStoreOptions: io.vertx.core.net.JksOptions = null, logActivity: java.lang.Boolean = null, openSslEngineOptions: io.vertx.core.net.OpenSSLEngineOptions = null, pemKeyCertOptions: io.vertx.core.net.PemKeyCertOptions = null, pemTrustOptions: io.vertx.core.net.PemTrustOptions = null, pfxKeyCertOptions: io.vertx.core.net.PfxOptions = null, pfxTrustOptions: io.vertx.core.net.PfxOptions = null, port: java.lang.Integer = null, proxyProtocolTimeout: java.lang.Long = null, proxyProtocolTimeoutUnit: java.util.concurrent.TimeUnit = null, receiveBufferSize: java.lang.Integer = null, reuseAddress: java.lang.Boolean = null, reusePort: java.lang.Boolean = null, sendBufferSize: java.lang.Integer = null, sni: java.lang.Boolean = null, soLinger: java.lang.Integer = null, ssl: java.lang.Boolean = null, sslEngineOptions: io.vertx.core.net.SSLEngineOptions = null, sslHandshakeTimeout: java.lang.Long = null, sslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = null, tcpCork: java.lang.Boolean = null, tcpFastOpen: java.lang.Boolean = null, tcpKeepAlive: java.lang.Boolean = null, tcpNoDelay: java.lang.Boolean = null, tcpQuickAck: java.lang.Boolean = null, trafficClass: java.lang.Integer = null, trustOptions: io.vertx.core.net.TrustOptions = null, trustStoreOptions: io.vertx.core.net.JksOptions = null, useAlpn: java.lang.Boolean = null, useProxyProtocol: java.lang.Boolean = null): NetServerOptions = {
      val ret = new NetServerOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (acceptBacklog != null) ret.setAcceptBacklog(acceptBacklog) 
      if (clientAuth != null) ret.setClientAuth(clientAuth) 
      if (enabledSecureTransportProtocols != null) ret.setEnabledSecureTransportProtocols(enabledSecureTransportProtocols.asJava) 
      if (host != null) ret.setHost(host) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (idleTimeoutUnit != null) ret.setIdleTimeoutUnit(idleTimeoutUnit) 
      if (jdkSslEngineOptions != null) ret.setJdkSslEngineOptions(jdkSslEngineOptions) 
      if (keyCertOptions != null) ret.setKeyCertOptions(keyCertOptions) 
      if (keyStoreOptions != null) ret.setKeyStoreOptions(keyStoreOptions) 
      if (logActivity != null) ret.setLogActivity(logActivity) 
      if (openSslEngineOptions != null) ret.setOpenSslEngineOptions(openSslEngineOptions) 
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






  type OpenOptions = io.vertx.core.file.OpenOptions
  object OpenOptions {
    def apply() = new OpenOptions()
    def apply(json: JsonObject) = new OpenOptions(json)
    def apply( append: java.lang.Boolean = null, create: java.lang.Boolean = null, createNew: java.lang.Boolean = null, deleteOnClose: java.lang.Boolean = null, dsync: java.lang.Boolean = null, perms: java.lang.String = null, read: java.lang.Boolean = null, sparse: java.lang.Boolean = null, sync: java.lang.Boolean = null, truncateExisting: java.lang.Boolean = null, write: java.lang.Boolean = null): OpenOptions = {
      val ret = new OpenOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (append != null) ret.setAppend(append) 
      if (create != null) ret.setCreate(create) 
      if (createNew != null) ret.setCreateNew(createNew) 
      if (deleteOnClose != null) ret.setDeleteOnClose(deleteOnClose) 
      if (dsync != null) ret.setDsync(dsync) 
      if (perms != null) ret.setPerms(perms) 
      if (read != null) ret.setRead(read) 
      if (sparse != null) ret.setSparse(sparse) 
      if (sync != null) ret.setSync(sync) 
      if (truncateExisting != null) ret.setTruncateExisting(truncateExisting) 
      if (write != null) ret.setWrite(write) 
      ret
    }
  }



  type OpenSSLEngineOptions = io.vertx.core.net.OpenSSLEngineOptions
  object OpenSSLEngineOptions {
    def apply() = new OpenSSLEngineOptions()
    def apply(json: JsonObject) = new OpenSSLEngineOptions(json)
    def apply( sessionCacheEnabled: java.lang.Boolean = null): OpenSSLEngineOptions = {
      val ret = new OpenSSLEngineOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (sessionCacheEnabled != null) ret.setSessionCacheEnabled(sessionCacheEnabled) 
      ret
    }
  }



  type Option = io.vertx.core.cli.Option
  object Option {
    def apply() = new Option()
    def apply(json: JsonObject) = new Option(json)
    def apply( argName: java.lang.String = null, choices: scala.collection.immutable.Set[java.lang.String] = null, defaultValue: java.lang.String = null, description: java.lang.String = null, flag: java.lang.Boolean = null, help: java.lang.Boolean = null, hidden: java.lang.Boolean = null, longName: java.lang.String = null, multiValued: java.lang.Boolean = null, name: java.lang.String = null, required: java.lang.Boolean = null, shortName: java.lang.String = null, singleValued: java.lang.Boolean = null): Option = {
      val ret = new Option(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (argName != null) ret.setArgName(argName) 
      if (choices != null) ret.setChoices(choices.asJava) 
      if (defaultValue != null) ret.setDefaultValue(defaultValue) 
      if (description != null) ret.setDescription(description) 
      if (flag != null) ret.setFlag(flag) 
      if (help != null) ret.setHelp(help) 
      if (hidden != null) ret.setHidden(hidden) 
      if (longName != null) ret.setLongName(longName) 
      if (multiValued != null) ret.setMultiValued(multiValued) 
      if (required != null) ret.setRequired(required) 
      if (shortName != null) ret.setShortName(shortName) 
      if (singleValued != null) ret.setSingleValued(singleValued) 
      ret
    }
  }



  type PemKeyCertOptions = io.vertx.core.net.PemKeyCertOptions
  object PemKeyCertOptions {
    def apply() = new PemKeyCertOptions()
    def apply(json: JsonObject) = new PemKeyCertOptions(json)
    def apply( certPath: java.lang.String = null, certPaths: scala.collection.immutable.List[java.lang.String] = null, certValue: io.vertx.core.buffer.Buffer = null, certValues: scala.collection.immutable.List[io.vertx.core.buffer.Buffer] = null, keyPath: java.lang.String = null, keyPaths: scala.collection.immutable.List[java.lang.String] = null, keyValue: io.vertx.core.buffer.Buffer = null, keyValues: scala.collection.immutable.List[io.vertx.core.buffer.Buffer] = null): PemKeyCertOptions = {
      val ret = new PemKeyCertOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (certPath != null) ret.setCertPath(certPath) 
      if (certPaths != null) ret.setCertPaths(certPaths.asJava) 
      if (certValue != null) ret.setCertValue(certValue) 
      if (certValues != null) ret.setCertValues(certValues.asJava) 
      if (keyPath != null) ret.setKeyPath(keyPath) 
      if (keyPaths != null) ret.setKeyPaths(keyPaths.asJava) 
      if (keyValue != null) ret.setKeyValue(keyValue) 
      if (keyValues != null) ret.setKeyValues(keyValues.asJava) 
      ret
    }
  }



  type PemTrustOptions = io.vertx.core.net.PemTrustOptions
  object PemTrustOptions {
    def apply() = new PemTrustOptions()
    def apply(json: JsonObject) = new PemTrustOptions(json)

  }



  type PfxOptions = io.vertx.core.net.PfxOptions
  object PfxOptions {
    def apply() = new PfxOptions()
    def apply(json: JsonObject) = new PfxOptions(json)
    def apply( alias: java.lang.String = null, aliasPassword: java.lang.String = null, password: java.lang.String = null, path: java.lang.String = null, value: io.vertx.core.buffer.Buffer = null): PfxOptions = {
      val ret = new PfxOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (alias != null) ret.setAlias(alias) 
      if (aliasPassword != null) ret.setAliasPassword(aliasPassword) 
      if (password != null) ret.setPassword(password) 
      if (path != null) ret.setPath(path) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type ProxyOptions = io.vertx.core.net.ProxyOptions
  object ProxyOptions {
    def apply() = new ProxyOptions()
    def apply(json: JsonObject) = new ProxyOptions(json)
    def apply( host: java.lang.String = null, password: java.lang.String = null, port: java.lang.Integer = null, `type`: io.vertx.core.net.ProxyType = null, username: java.lang.String = null): ProxyOptions = {
      val ret = new ProxyOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (host != null) ret.setHost(host) 
      if (password != null) ret.setPassword(password) 
      if (port != null) ret.setPort(port) 
      if (`type` != null) ret.setType(`type`) 
      if (username != null) ret.setUsername(username) 
      ret
    }
  }



  type RequestOptions = io.vertx.core.http.RequestOptions
  object RequestOptions {
    def apply() = new RequestOptions()
    def apply(json: JsonObject) = new RequestOptions(json)
    def apply( absoluteURI: java.lang.String = null, followRedirects: java.lang.Boolean = null, host: java.lang.String = null, port: java.lang.Integer = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, server: io.vertx.core.net.SocketAddress = null, ssl: java.lang.Boolean = null, timeout: java.lang.Long = null, uri: java.lang.String = null): RequestOptions = {
      val ret = new RequestOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (absoluteURI != null) ret.setAbsoluteURI(absoluteURI) 
      if (followRedirects != null) ret.setFollowRedirects(followRedirects) 
      if (host != null) ret.setHost(host) 
      if (port != null) ret.setPort(port) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (server != null) ret.setServer(server) 
      if (ssl != null) ret.setSsl(ssl) 
      if (timeout != null) ret.setTimeout(timeout) 
      if (uri != null) ret.setURI(uri) 
      ret
    }
  }



  type StreamPriority = io.vertx.core.http.StreamPriority
  object StreamPriority {
    def apply() = new StreamPriority()
    def apply(json: JsonObject) = new StreamPriority(json)
    def apply( dependency: java.lang.Integer = null, exclusive: java.lang.Boolean = null, weight: java.lang.Short = null): StreamPriority = {
      val ret = new StreamPriority(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (dependency != null) ret.setDependency(dependency) 
      if (exclusive != null) ret.setExclusive(exclusive) 
      if (weight != null) ret.setWeight(weight) 
      ret
    }
  }






  type TracingOptions = io.vertx.core.tracing.TracingOptions
  object TracingOptions {
    def apply() = new TracingOptions()
    def apply(json: JsonObject) = new TracingOptions(json)
    def apply( factory: io.vertx.core.spi.VertxTracerFactory = null): TracingOptions = {
      val ret = new TracingOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (factory != null) ret.setFactory(factory) 
      ret
    }
  }



  type VertxOptions = io.vertx.core.VertxOptions
  object VertxOptions {
    def apply() = new VertxOptions()
    def apply(json: JsonObject) = new VertxOptions(json)
    def apply( addressResolverOptions: io.vertx.core.dns.AddressResolverOptions = null, blockedThreadCheckInterval: java.lang.Long = null, blockedThreadCheckIntervalUnit: java.util.concurrent.TimeUnit = null, clusterManager: io.vertx.core.spi.cluster.ClusterManager = null, eventBusOptions: io.vertx.core.eventbus.EventBusOptions = null, eventLoopPoolSize: java.lang.Integer = null, fileSystemOptions: io.vertx.core.file.FileSystemOptions = null, haEnabled: java.lang.Boolean = null, haGroup: java.lang.String = null, internalBlockingPoolSize: java.lang.Integer = null, maxEventLoopExecuteTime: java.lang.Long = null, maxEventLoopExecuteTimeUnit: java.util.concurrent.TimeUnit = null, maxWorkerExecuteTime: java.lang.Long = null, maxWorkerExecuteTimeUnit: java.util.concurrent.TimeUnit = null, metricsOptions: io.vertx.core.metrics.MetricsOptions = null, preferNativeTransport: java.lang.Boolean = null, quorumSize: java.lang.Integer = null, tracingOptions: io.vertx.core.tracing.TracingOptions = null, warningExceptionTime: java.lang.Long = null, warningExceptionTimeUnit: java.util.concurrent.TimeUnit = null, workerPoolSize: java.lang.Integer = null): VertxOptions = {
      val ret = new VertxOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (addressResolverOptions != null) ret.setAddressResolverOptions(addressResolverOptions) 
      if (blockedThreadCheckInterval != null) ret.setBlockedThreadCheckInterval(blockedThreadCheckInterval) 
      if (blockedThreadCheckIntervalUnit != null) ret.setBlockedThreadCheckIntervalUnit(blockedThreadCheckIntervalUnit) 
      if (clusterManager != null) ret.setClusterManager(clusterManager) 
      if (eventBusOptions != null) ret.setEventBusOptions(eventBusOptions) 
      if (eventLoopPoolSize != null) ret.setEventLoopPoolSize(eventLoopPoolSize) 
      if (fileSystemOptions != null) ret.setFileSystemOptions(fileSystemOptions) 
      if (haEnabled != null) ret.setHAEnabled(haEnabled) 
      if (haGroup != null) ret.setHAGroup(haGroup) 
      if (internalBlockingPoolSize != null) ret.setInternalBlockingPoolSize(internalBlockingPoolSize) 
      if (maxEventLoopExecuteTime != null) ret.setMaxEventLoopExecuteTime(maxEventLoopExecuteTime) 
      if (maxEventLoopExecuteTimeUnit != null) ret.setMaxEventLoopExecuteTimeUnit(maxEventLoopExecuteTimeUnit) 
      if (maxWorkerExecuteTime != null) ret.setMaxWorkerExecuteTime(maxWorkerExecuteTime) 
      if (maxWorkerExecuteTimeUnit != null) ret.setMaxWorkerExecuteTimeUnit(maxWorkerExecuteTimeUnit) 
      if (metricsOptions != null) ret.setMetricsOptions(metricsOptions) 
      if (preferNativeTransport != null) ret.setPreferNativeTransport(preferNativeTransport) 
      if (quorumSize != null) ret.setQuorumSize(quorumSize) 
      if (tracingOptions != null) ret.setTracingOptions(tracingOptions) 
      if (warningExceptionTime != null) ret.setWarningExceptionTime(warningExceptionTime) 
      if (warningExceptionTimeUnit != null) ret.setWarningExceptionTimeUnit(warningExceptionTimeUnit) 
      if (workerPoolSize != null) ret.setWorkerPoolSize(workerPoolSize) 
      ret
    }
  }



  type WebSocketConnectOptions = io.vertx.core.http.WebSocketConnectOptions
  object WebSocketConnectOptions {
    def apply() = new WebSocketConnectOptions()
    def apply(json: JsonObject) = new WebSocketConnectOptions(json)
    def apply( absoluteURI: java.lang.String = null, followRedirects: java.lang.Boolean = null, host: java.lang.String = null, port: java.lang.Integer = null, proxyOptions: io.vertx.core.net.ProxyOptions = null, server: io.vertx.core.net.SocketAddress = null, ssl: java.lang.Boolean = null, subProtocols: scala.collection.immutable.List[java.lang.String] = null, timeout: java.lang.Long = null, uri: java.lang.String = null, version: io.vertx.core.http.WebsocketVersion = null): WebSocketConnectOptions = {
      val ret = new WebSocketConnectOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (absoluteURI != null) ret.setAbsoluteURI(absoluteURI) 
      if (followRedirects != null) ret.setFollowRedirects(followRedirects) 
      if (host != null) ret.setHost(host) 
      if (port != null) ret.setPort(port) 
      if (proxyOptions != null) ret.setProxyOptions(proxyOptions) 
      if (server != null) ret.setServer(server) 
      if (ssl != null) ret.setSsl(ssl) 
      if (subProtocols != null) ret.setSubProtocols(subProtocols.asJava) 
      if (timeout != null) ret.setTimeout(timeout) 
      if (uri != null) ret.setURI(uri) 
      if (version != null) ret.setVersion(version) 
      ret
    }
  }



}
