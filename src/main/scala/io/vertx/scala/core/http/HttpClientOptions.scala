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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options describing how an [[io.vertx.scala.core.http.HttpClient]] will make connections.
  */

class HttpClientOptions(val asJava: io.vertx.core.http.HttpClientOptions) {
  def setAlpnVersions(value:scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }
  def setConnectTimeout(value:Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
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
  def setDefaultHost(value:String) = {
    asJava.setDefaultHost(value)
    this
  }
  def getDefaultHost = {
    asJava.getDefaultHost()
  }
  def setDefaultPort(value:Int) = {
    asJava.setDefaultPort(value)
    this
  }
  def getDefaultPort = {
    asJava.getDefaultPort()
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
  def setHttp2ClearTextUpgrade(value:Boolean) = {
    asJava.setHttp2ClearTextUpgrade(value)
    this
  }
  def isHttp2ClearTextUpgrade = {
    asJava.isHttp2ClearTextUpgrade()
  }
  def setHttp2ConnectionWindowSize(value:Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    asJava.getHttp2ConnectionWindowSize()
  }
  def setHttp2MaxPoolSize(value:Int) = {
    asJava.setHttp2MaxPoolSize(value)
    this
  }
  def getHttp2MaxPoolSize = {
    asJava.getHttp2MaxPoolSize()
  }
  def setHttp2MultiplexingLimit(value:Int) = {
    asJava.setHttp2MultiplexingLimit(value)
    this
  }
  def getHttp2MultiplexingLimit = {
    asJava.getHttp2MultiplexingLimit()
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
  def setJdkSslEngineOptions(value:io.vertx.scala.core.net.JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  def setKeepAlive(value:Boolean) = {
    asJava.setKeepAlive(value)
    this
  }
  def isKeepAlive = {
    asJava.isKeepAlive()
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
  def setMaxPoolSize(value:Int) = {
    asJava.setMaxPoolSize(value)
    this
  }
  def getMaxPoolSize = {
    asJava.getMaxPoolSize()
  }
  def setMaxWaitQueueSize(value:Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }
  def getMaxWaitQueueSize = {
    asJava.getMaxWaitQueueSize()
  }
  def setMaxWebsocketFrameSize(value:Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    asJava.getMaxWebsocketFrameSize()
  }
  def setMetricsName(value:String) = {
    asJava.setMetricsName(value)
    this
  }
  def getMetricsName = {
    asJava.getMetricsName()
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
  def setPipelining(value:Boolean) = {
    asJava.setPipelining(value)
    this
  }
  def isPipelining = {
    asJava.isPipelining()
  }
  def setPipeliningLimit(value:Int) = {
    asJava.setPipeliningLimit(value)
    this
  }
  def getPipeliningLimit = {
    asJava.getPipeliningLimit()
  }
  def setProtocolVersion(value:io.vertx.core.http.HttpVersion) = {
    asJava.setProtocolVersion(value)
    this
  }
  def getProtocolVersion = {
    asJava.getProtocolVersion()
  }
  def setProxyOptions(value:io.vertx.scala.core.net.ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }
  def getProxyOptions = {
    asJava.getProxyOptions()
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
  def setSoLinger(value:Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
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
  def setTrafficClass(value:Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }
  def setTrustAll(value:Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }
  def setTrustStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }
  def setTryUseCompression(value:Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }
  def isTryUseCompression = {
    asJava.isTryUseCompression()
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
  def setVerifyHost(value:Boolean) = {
    asJava.setVerifyHost(value)
    this
  }
  def isVerifyHost = {
    asJava.isVerifyHost()
  }
}

object HttpClientOptions {
  type HttpClientOptionsJava = io.vertx.core.http.HttpClientOptions
  
  def apply(t: HttpClientOptionsJava) = {
    if(t != null)
      new HttpClientOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):HttpClientOptions = {
    if(json != null)
      new HttpClientOptions(new HttpClientOptionsJava(json))
    else
      null
  }
}
