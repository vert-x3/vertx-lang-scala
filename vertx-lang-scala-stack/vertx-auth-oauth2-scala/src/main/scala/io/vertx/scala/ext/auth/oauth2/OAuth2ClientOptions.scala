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

package io.vertx.scala.ext.auth.oauth2

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options describing how an OAuth2  will make connections.
  */

class OAuth2ClientOptions(val asJava: io.vertx.ext.auth.oauth2.OAuth2ClientOptions) {
  def setAlpnVersions(value:scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }
  def setAuthorizationPath(value:String) = {
    asJava.setAuthorizationPath(value)
    this
  }
  def getAuthorizationPath = {
    asJava.getAuthorizationPath()
  }
  def setClientID(value:String) = {
    asJava.setClientID(value)
    this
  }
  def getClientID = {
    asJava.getClientID()
  }
  def setClientSecret(value:String) = {
    asJava.setClientSecret(value)
    this
  }
  def getClientSecret = {
    asJava.getClientSecret()
  }
  def setClientSecretParameterName(value:String) = {
    asJava.setClientSecretParameterName(value)
    this
  }
  def getClientSecretParameterName = {
    asJava.getClientSecretParameterName()
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
  def setHeaders(value:io.vertx.core.json.JsonObject) = {
    asJava.setHeaders(value)
    this
  }
  def getHeaders = {
    asJava.getHeaders()
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
  def setJwtToken(value:Boolean) = {
    asJava.setJwtToken(value)
    this
  }
  def isJwtToken = {
    asJava.isJwtToken()
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
  def setLocalAddress(value:String) = {
    asJava.setLocalAddress(value)
    this
  }
  def getLocalAddress = {
    asJava.getLocalAddress()
  }
  def setLogActivity(value:Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setLogoutPath(value:String) = {
    asJava.setLogoutPath(value)
    this
  }
  def getLogoutPath = {
    asJava.getLogoutPath()
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
  def setPublicKey(value:String) = {
    asJava.setPublicKey(value)
    this
  }
  def getPublicKey = {
    asJava.getPublicKey()
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
  def setRevocationPath(value:String) = {
    asJava.setRevocationPath(value)
    this
  }
  def getRevocationPath = {
    asJava.getRevocationPath()
  }
  def setSendBufferSize(value:Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }
  def setSite(value:String) = {
    asJava.setSite(value)
    this
  }
  def getSite = {
    asJava.getSite()
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
  def setTokenPath(value:String) = {
    asJava.setTokenPath(value)
    this
  }
  def getTokenPath = {
    asJava.getTokenPath()
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
  def setUseBasicAuthorizationHeader(value:Boolean) = {
    asJava.setUseBasicAuthorizationHeader(value)
    this
  }
  def isUseBasicAuthorizationHeader = {
    asJava.isUseBasicAuthorizationHeader()
  }
  def setUsePooledBuffers(value:Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }
  def setUserAgent(value:String) = {
    asJava.setUserAgent(value)
    this
  }
  def getUserAgent = {
    asJava.getUserAgent()
  }
  def setUserInfoPath(value:String) = {
    asJava.setUserInfoPath(value)
    this
  }
  def getUserInfoPath = {
    asJava.getUserInfoPath()
  }
  def setVerifyHost(value:Boolean) = {
    asJava.setVerifyHost(value)
    this
  }
  def isVerifyHost = {
    asJava.isVerifyHost()
  }
}

object OAuth2ClientOptions {
  type OAuth2ClientOptionsJava = io.vertx.ext.auth.oauth2.OAuth2ClientOptions
  
  def apply() = {
    new OAuth2ClientOptions(new OAuth2ClientOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: OAuth2ClientOptionsJava) = {
    if(t != null)
      new OAuth2ClientOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):OAuth2ClientOptions = {
    if(json != null)
      new OAuth2ClientOptions(new OAuth2ClientOptionsJava(json))
    else
      null
  }
}
