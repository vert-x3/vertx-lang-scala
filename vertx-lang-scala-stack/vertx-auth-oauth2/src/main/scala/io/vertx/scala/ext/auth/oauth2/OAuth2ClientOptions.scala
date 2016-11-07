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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.core.http.HttpVersion
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.json.JsonObject
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.scala.core.http.Http2Settings
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PfxOptions
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.scala.core.net.ProxyOptions

/**
  * Options describing how an OAuth2  will make connections.
  */

class OAuth2ClientOptions(val asJava: JOAuth2ClientOptions) {
  def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }
  def getAlpnVersions = {
    asJava.getAlpnVersions()
  }
  def setAuthorizationPath(value: String) = {
    asJava.setAuthorizationPath(value)
    this
  }
  def getAuthorizationPath = {
    asJava.getAuthorizationPath()
  }
  def setClientID(value: String) = {
    asJava.setClientID(value)
    this
  }
  def getClientID = {
    asJava.getClientID()
  }
  def setClientSecret(value: String) = {
    asJava.setClientSecret(value)
    this
  }
  def getClientSecret = {
    asJava.getClientSecret()
  }
  def setClientSecretParameterName(value: String) = {
    asJava.setClientSecretParameterName(value)
    this
  }
  def getClientSecretParameterName = {
    asJava.getClientSecretParameterName()
  }
  def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
  }
  def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }
  def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asJava)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }
  def setDefaultHost(value: String) = {
    asJava.setDefaultHost(value)
    this
  }
  def getDefaultHost = {
    asJava.getDefaultHost()
  }
  def setDefaultPort(value: Int) = {
    asJava.setDefaultPort(value)
    this
  }
  def getDefaultPort = {
    asJava.getDefaultPort()
  }
  def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }
  def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }
  def setHeaders(value: JsonObject) = {
    asJava.setHeaders(value)
    this
  }
  def getHeaders = {
    asJava.getHeaders()
  }
  def setHttp2ClearTextUpgrade(value: Boolean) = {
    asJava.setHttp2ClearTextUpgrade(value)
    this
  }
  def isHttp2ClearTextUpgrade = {
    asJava.isHttp2ClearTextUpgrade()
  }
  def setHttp2ConnectionWindowSize(value: Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }
  def getHttp2ConnectionWindowSize = {
    asJava.getHttp2ConnectionWindowSize()
  }
  def setHttp2MaxPoolSize(value: Int) = {
    asJava.setHttp2MaxPoolSize(value)
    this
  }
  def getHttp2MaxPoolSize = {
    asJava.getHttp2MaxPoolSize()
  }
  def setHttp2MultiplexingLimit(value: Int) = {
    asJava.setHttp2MultiplexingLimit(value)
    this
  }
  def getHttp2MultiplexingLimit = {
    asJava.getHttp2MultiplexingLimit()
  }
  def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }
  def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  def getInitialSettings = {
    asJava.getInitialSettings()
  }
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }
  def setJwtToken(value: Boolean) = {
    asJava.setJwtToken(value)
    this
  }
  def isJwtToken = {
    asJava.isJwtToken()
  }
  def setKeepAlive(value: Boolean) = {
    asJava.setKeepAlive(value)
    this
  }
  def isKeepAlive = {
    asJava.isKeepAlive()
  }
  def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }
  def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }
  def getLocalAddress = {
    asJava.getLocalAddress()
  }
  def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setLogoutPath(value: String) = {
    asJava.setLogoutPath(value)
    this
  }
  def getLogoutPath = {
    asJava.getLogoutPath()
  }
  def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }
  def getMaxChunkSize = {
    asJava.getMaxChunkSize()
  }
  def setMaxPoolSize(value: Int) = {
    asJava.setMaxPoolSize(value)
    this
  }
  def getMaxPoolSize = {
    asJava.getMaxPoolSize()
  }
  def setMaxWaitQueueSize(value: Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }
  def getMaxWaitQueueSize = {
    asJava.getMaxWaitQueueSize()
  }
  def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  def getMaxWebsocketFrameSize = {
    asJava.getMaxWebsocketFrameSize()
  }
  def setMetricsName(value: String) = {
    asJava.setMetricsName(value)
    this
  }
  def getMetricsName = {
    asJava.getMetricsName()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }
  def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }
  def setPipelining(value: Boolean) = {
    asJava.setPipelining(value)
    this
  }
  def isPipelining = {
    asJava.isPipelining()
  }
  def setPipeliningLimit(value: Int) = {
    asJava.setPipeliningLimit(value)
    this
  }
  def getPipeliningLimit = {
    asJava.getPipeliningLimit()
  }
  def setProtocolVersion(value: io.vertx.core.http.HttpVersion) = {
    asJava.setProtocolVersion(value)
    this
  }
  def getProtocolVersion = {
    asJava.getProtocolVersion()
  }
  def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }
  def getProxyOptions = {
    asJava.getProxyOptions()
  }
  def setPublicKey(value: String) = {
    asJava.setPublicKey(value)
    this
  }
  def getPublicKey = {
    asJava.getPublicKey()
  }
  def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }
  def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }
  def setRevocationPath(value: String) = {
    asJava.setRevocationPath(value)
    this
  }
  def getRevocationPath = {
    asJava.getRevocationPath()
  }
  def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }
  def setSite(value: String) = {
    asJava.setSite(value)
    this
  }
  def getSite = {
    asJava.getSite()
  }
  def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }
  def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }
  def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }
  def setTokenPath(value: String) = {
    asJava.setTokenPath(value)
    this
  }
  def getTokenPath = {
    asJava.getTokenPath()
  }
  def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }
  def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }
  def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }
  def setTryUseCompression(value: Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }
  def isTryUseCompression = {
    asJava.isTryUseCompression()
  }
  def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }
  def setUseBasicAuthorizationHeader(value: Boolean) = {
    asJava.setUseBasicAuthorizationHeader(value)
    this
  }
  def isUseBasicAuthorizationHeader = {
    asJava.isUseBasicAuthorizationHeader()
  }
  def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }
  def setUserAgent(value: String) = {
    asJava.setUserAgent(value)
    this
  }
  def getUserAgent = {
    asJava.getUserAgent()
  }
  def setUserInfoPath(value: String) = {
    asJava.setUserInfoPath(value)
    this
  }
  def getUserInfoPath = {
    asJava.getUserInfoPath()
  }
  def setVerifyHost(value: Boolean) = {
    asJava.setVerifyHost(value)
    this
  }
  def isVerifyHost = {
    asJava.isVerifyHost()
  }
}

object OAuth2ClientOptions {
  
  def apply() = {
    new OAuth2ClientOptions(new JOAuth2ClientOptions(emptyObj()))
  }
  
  def apply(t: JOAuth2ClientOptions) = {
    if(t != null)
      new OAuth2ClientOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):OAuth2ClientOptions = {
    if(json != null)
      new OAuth2ClientOptions(new JOAuth2ClientOptions(json))
    else
      null
  }
}
