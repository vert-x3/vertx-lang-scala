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

class HttpClientOptions(val java: io.vertx.core.http.HttpClientOptions) {
  def setAlpnVersions(value:scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    java.setAlpnVersions(value)
    this
  }
  def getAlpnVersions = {
    java.getAlpnVersions()
  }
  def setConnectTimeout(value:Int) = {
    java.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    java.getConnectTimeout()
  }
  def addCrlPath(value:String) = {
    java.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    java.getCrlPaths()
  }
  def addCrlValue(value:io.vertx.core.buffer.Buffer) = {
    java.addCrlValue(value)
    this
  }
  def getCrlValues = {
    java.getCrlValues()
  }
  def setDefaultHost(value:String) = {
    java.setDefaultHost(value)
    this
  }
  def getDefaultHost = {
    java.getDefaultHost()
  }
  def setDefaultPort(value:Int) = {
    java.setDefaultPort(value)
    this
  }
  def getDefaultPort = {
    java.getDefaultPort()
  }
  def addEnabledCipherSuite(value:String) = {
    java.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    java.getEnabledCipherSuites()
  }
  def addEnabledSecureTransportProtocol(value:String) = {
    java.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    java.getEnabledSecureTransportProtocols()
  }
  def setHttp2ClearTextUpgrade(value:Boolean) = {
    java.setHttp2ClearTextUpgrade(value)
    this
  }
  def isHttp2ClearTextUpgrade = {
    java.isHttp2ClearTextUpgrade()
  }
  def setHttp2ConnectionWindowSize(value:Int) = {
    java.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    java.getHttp2ConnectionWindowSize()
  }
  def setHttp2MaxPoolSize(value:Int) = {
    java.setHttp2MaxPoolSize(value)
    this
  }
  def getHttp2MaxPoolSize = {
    java.getHttp2MaxPoolSize()
  }
  def setHttp2MultiplexingLimit(value:Int) = {
    java.setHttp2MultiplexingLimit(value)
    this
  }
  def getHttp2MultiplexingLimit = {
    java.getHttp2MultiplexingLimit()
  }
  def setIdleTimeout(value:Int) = {
    java.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    java.getIdleTimeout()
  }
  def setInitialSettings(value:io.vertx.scala.core.http.Http2Settings) = {
    java.setInitialSettings(value.java)
    this
  }
  def getInitialSettings = {
    java.getInitialSettings()
  }
  def setJdkSslEngineOptions(value:io.vertx.scala.core.net.JdkSSLEngineOptions) = {
    java.setJdkSslEngineOptions(value.java)
    this
  }
  def setKeepAlive(value:Boolean) = {
    java.setKeepAlive(value)
    this
  }
  def isKeepAlive = {
    java.isKeepAlive()
  }
  def setKeyStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    java.setKeyStoreOptions(value.java)
    this
  }
  def setLogActivity(value:Boolean) = {
    java.setLogActivity(value)
    this
  }
  def getLogActivity = {
    java.getLogActivity()
  }
  def setMaxChunkSize(value:Int) = {
    java.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize = {
    java.getMaxChunkSize()
  }
  def setMaxPoolSize(value:Int) = {
    java.setMaxPoolSize(value)
    this
  }
  def getMaxPoolSize = {
    java.getMaxPoolSize()
  }
  def setMaxWaitQueueSize(value:Int) = {
    java.setMaxWaitQueueSize(value)
    this
  }
  def getMaxWaitQueueSize = {
    java.getMaxWaitQueueSize()
  }
  def setMaxWebsocketFrameSize(value:Int) = {
    java.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    java.getMaxWebsocketFrameSize()
  }
  def setMetricsName(value:String) = {
    java.setMetricsName(value)
    this
  }
  def getMetricsName = {
    java.getMetricsName()
  }
  def setOpenSslEngineOptions(value:io.vertx.scala.core.net.OpenSSLEngineOptions) = {
    java.setOpenSslEngineOptions(value.java)
    this
  }
  def setPemKeyCertOptions(value:io.vertx.scala.core.net.PemKeyCertOptions) = {
    java.setPemKeyCertOptions(value.java)
    this
  }
  def setPemTrustOptions(value:io.vertx.scala.core.net.PemTrustOptions) = {
    java.setPemTrustOptions(value.java)
    this
  }
  def setPfxKeyCertOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    java.setPfxKeyCertOptions(value.java)
    this
  }
  def setPfxTrustOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    java.setPfxTrustOptions(value.java)
    this
  }
  def setPipelining(value:Boolean) = {
    java.setPipelining(value)
    this
  }
  def isPipelining = {
    java.isPipelining()
  }
  def setPipeliningLimit(value:Int) = {
    java.setPipeliningLimit(value)
    this
  }
  def getPipeliningLimit = {
    java.getPipeliningLimit()
  }
  def setProtocolVersion(value:io.vertx.core.http.HttpVersion) = {
    java.setProtocolVersion(value)
    this
  }
  def getProtocolVersion = {
    java.getProtocolVersion()
  }
  def setProxyOptions(value:io.vertx.scala.core.net.ProxyOptions) = {
    java.setProxyOptions(value.java)
    this
  }
  def getProxyOptions = {
    java.getProxyOptions()
  }
  def setReceiveBufferSize(value:Int) = {
    java.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    java.getReceiveBufferSize()
  }
  def setReuseAddress(value:Boolean) = {
    java.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    java.isReuseAddress()
  }
  def setSendBufferSize(value:Int) = {
    java.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    java.getSendBufferSize()
  }
  def setSoLinger(value:Int) = {
    java.setSoLinger(value)
    this
  }
  def getSoLinger = {
    java.getSoLinger()
  }
  def setSsl(value:Boolean) = {
    java.setSsl(value)
    this
  }
  def isSsl = {
    java.isSsl()
  }
  def setTcpKeepAlive(value:Boolean) = {
    java.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    java.isTcpKeepAlive()
  }
  def setTcpNoDelay(value:Boolean) = {
    java.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    java.isTcpNoDelay()
  }
  def setTrafficClass(value:Int) = {
    java.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    java.getTrafficClass()
  }
  def setTrustAll(value:Boolean) = {
    java.setTrustAll(value)
    this
  }
  def isTrustAll = {
    java.isTrustAll()
  }
  def setTrustStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    java.setTrustStoreOptions(value.java)
    this
  }
  def setTryUseCompression(value:Boolean) = {
    java.setTryUseCompression(value)
    this
  }
  def isTryUseCompression = {
    java.isTryUseCompression()
  }
  def setUseAlpn(value:Boolean) = {
    java.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    java.isUseAlpn()
  }
  def setUsePooledBuffers(value:Boolean) = {
    java.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    java.isUsePooledBuffers()
  }
  def setVerifyHost(value:Boolean) = {
    java.setVerifyHost(value)
    this
  }
  def isVerifyHost = {
    java.isVerifyHost()
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
