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

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.http.HttpVersion
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.scala.ext.auth.PubSecKeyOptions
import io.vertx.ext.auth.{JWTOptions => JJWTOptions}
import io.vertx.scala.core.http.Http2Settings
import io.vertx.ext.auth.{PubSecKeyOptions => JPubSecKeyOptions}
import io.vertx.scala.core.http.{HttpClientOptions => ExtHttpClientOptions}
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.scala.ext.auth.JWTOptions
import java.util.concurrent.TimeUnit
import io.vertx.core.buffer.Buffer
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}

/**
 * Options describing how an OAuth2  will make connections.
 */

class OAuth2ClientOptions(private val _asJava: JOAuth2ClientOptions) extends ExtHttpClientOptions(_asJava) {
  override def asJava = _asJava
  override def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asJava)
    this
  }

  override def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
    asJava.getAlpnVersions().asScala.map(x => x)
  }

  /**
   * Get the Oauth2 authorization resource path. e.g.: /oauth/authorize
   */
  def setAuthorizationPath(value: String) = {
    asJava.setAuthorizationPath(value)
    this
  }

  def getAuthorizationPath: String = {
    asJava.getAuthorizationPath().asInstanceOf[String]
  }

  /**
   * Set the provider client id
   */
  def setClientID(value: String) = {
    asJava.setClientID(value)
    this
  }

  def getClientID: String = {
    asJava.getClientID().asInstanceOf[String]
  }

  /**
   * Set the provider client secret
   */
  def setClientSecret(value: String) = {
    asJava.setClientSecret(value)
    this
  }

  def getClientSecret: String = {
    asJava.getClientSecret().asInstanceOf[String]
  }

  /**
   * Override the HTTP form field name for client secret
   */
  def setClientSecretParameterName(value: String) = {
    asJava.setClientSecretParameterName(value)
    this
  }

  def getClientSecretParameterName: String = {
    asJava.getClientSecretParameterName().asInstanceOf[String]
  }

  override def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }

  override def getConnectTimeout: Int = {
    asJava.getConnectTimeout().asInstanceOf[Int]
  }

  override def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }

  override def getCrlPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getCrlPaths().asScala.map(x => x.asInstanceOf[String])
  }

  override def addCrlValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }

  override def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer] = {
    asJava.getCrlValues().asScala.map(x => x)
  }

  override def setDecoderInitialBufferSize(value: Int) = {
    asJava.setDecoderInitialBufferSize(value)
    this
  }

  override def getDecoderInitialBufferSize: Int = {
    asJava.getDecoderInitialBufferSize().asInstanceOf[Int]
  }

  override def setDefaultHost(value: String) = {
    asJava.setDefaultHost(value)
    this
  }

  override def getDefaultHost: String = {
    asJava.getDefaultHost().asInstanceOf[String]
  }

  override def setDefaultPort(value: Int) = {
    asJava.setDefaultPort(value)
    this
  }

  override def getDefaultPort: Int = {
    asJava.getDefaultPort().asInstanceOf[Int]
  }

  override def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }

  override def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
    asJava.getEnabledCipherSuites().asScala.map(x => x.asInstanceOf[String])
  }

  override def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }

  override def setEnabledSecureTransportProtocols(value: Set[String]) = {
    asJava.setEnabledSecureTransportProtocols(value.asJava)
    this
  }

  override def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSecureTransportProtocols().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set extra parameters to be sent to the provider on each request
   */
  def setExtraParameters(value: io.vertx.core.json.JsonObject) = {
    asJava.setExtraParameters(value)
    this
  }

  def getExtraParameters: io.vertx.core.json.JsonObject = {
    asJava.getExtraParameters()
  }

  def setFlow(value: io.vertx.ext.auth.oauth2.OAuth2FlowType) = {
    asJava.setFlow(value)
    this
  }

  def getFlow: io.vertx.ext.auth.oauth2.OAuth2FlowType = {
    asJava.getFlow()
  }

  override def setForceSni(value: Boolean) = {
    asJava.setForceSni(value)
    this
  }

  override def isForceSni: Boolean = {
    asJava.isForceSni().asInstanceOf[Boolean]
  }

  /**
   * Set custom headers to be sent with every request to the provider
   */
  def setHeaders(value: io.vertx.core.json.JsonObject) = {
    asJava.setHeaders(value)
    this
  }

  def getHeaders: io.vertx.core.json.JsonObject = {
    asJava.getHeaders()
  }

  override def setHttp2ClearTextUpgrade(value: Boolean) = {
    asJava.setHttp2ClearTextUpgrade(value)
    this
  }

  override def isHttp2ClearTextUpgrade: Boolean = {
    asJava.isHttp2ClearTextUpgrade().asInstanceOf[Boolean]
  }

  override def setHttp2ConnectionWindowSize(value: Int) = {
    asJava.setHttp2ConnectionWindowSize(value)
    this
  }

  override def getHttp2ConnectionWindowSize: Int = {
    asJava.getHttp2ConnectionWindowSize().asInstanceOf[Int]
  }

  override def setHttp2KeepAliveTimeout(value: Int) = {
    asJava.setHttp2KeepAliveTimeout(value)
    this
  }

  override def getHttp2KeepAliveTimeout: Int = {
    asJava.getHttp2KeepAliveTimeout().asInstanceOf[Int]
  }

  override def setHttp2MaxPoolSize(value: Int) = {
    asJava.setHttp2MaxPoolSize(value)
    this
  }

  override def getHttp2MaxPoolSize: Int = {
    asJava.getHttp2MaxPoolSize().asInstanceOf[Int]
  }

  override def setHttp2MultiplexingLimit(value: Int) = {
    asJava.setHttp2MultiplexingLimit(value)
    this
  }

  override def getHttp2MultiplexingLimit: Int = {
    asJava.getHttp2MultiplexingLimit().asInstanceOf[Int]
  }

  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }

  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout().asInstanceOf[Int]
  }

  override def setIdleTimeoutUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setIdleTimeoutUnit(value)
    this
  }

  override def getIdleTimeoutUnit: java.util.concurrent.TimeUnit = {
    asJava.getIdleTimeoutUnit()
  }

  override def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }

  override def getInitialSettings: Http2Settings = {
    Http2Settings(asJava.getInitialSettings())
  }

  /**
   * Set the provider token introspection resource path
   */
  def setIntrospectionPath(value: String) = {
    asJava.setIntrospectionPath(value)
    this
  }

  def getIntrospectionPath: String = {
    asJava.getIntrospectionPath().asInstanceOf[String]
  }

  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  override def getJdkSslEngineOptions: JdkSSLEngineOptions = {
    JdkSSLEngineOptions(asJava.getJdkSslEngineOptions())
  }

  def setJwkPath(value: String) = {
    asJava.setJwkPath(value)
    this
  }

  def getJwkPath: String = {
    asJava.getJwkPath().asInstanceOf[String]
  }

  def setJWTOptions(value: JWTOptions) = {
    asJava.setJWTOptions(value.asJava)
    this
  }

  def getJWTOptions: JWTOptions = {
    JWTOptions(asJava.getJWTOptions())
  }

  override def setKeepAlive(value: Boolean) = {
    asJava.setKeepAlive(value)
    this
  }

  override def isKeepAlive: Boolean = {
    asJava.isKeepAlive().asInstanceOf[Boolean]
  }

  override def setKeepAliveTimeout(value: Int) = {
    asJava.setKeepAliveTimeout(value)
    this
  }

  override def getKeepAliveTimeout: Int = {
    asJava.getKeepAliveTimeout().asInstanceOf[Int]
  }

  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  override def getKeyStoreOptions: JksOptions = {
    JksOptions(asJava.getKeyStoreOptions())
  }

  override def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }

  override def getLocalAddress: String = {
    asJava.getLocalAddress().asInstanceOf[String]
  }

  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }

  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }

  /**
   * Set the provider logout path
   */
  def setLogoutPath(value: String) = {
    asJava.setLogoutPath(value)
    this
  }

  def getLogoutPath: String = {
    asJava.getLogoutPath().asInstanceOf[String]
  }

  override def setMaxChunkSize(value: Int) = {
    asJava.setMaxChunkSize(value)
    this
  }

  override def getMaxChunkSize: Int = {
    asJava.getMaxChunkSize().asInstanceOf[Int]
  }

  override def setMaxHeaderSize(value: Int) = {
    asJava.setMaxHeaderSize(value)
    this
  }

  override def getMaxHeaderSize: Int = {
    asJava.getMaxHeaderSize().asInstanceOf[Int]
  }

  override def setMaxInitialLineLength(value: Int) = {
    asJava.setMaxInitialLineLength(value)
    this
  }

  override def getMaxInitialLineLength: Int = {
    asJava.getMaxInitialLineLength().asInstanceOf[Int]
  }

  override def setMaxPoolSize(value: Int) = {
    asJava.setMaxPoolSize(value)
    this
  }

  override def getMaxPoolSize: Int = {
    asJava.getMaxPoolSize().asInstanceOf[Int]
  }

  override def setMaxRedirects(value: Int) = {
    asJava.setMaxRedirects(value)
    this
  }

  override def getMaxRedirects: Int = {
    asJava.getMaxRedirects().asInstanceOf[Int]
  }

  override def setMaxWaitQueueSize(value: Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }

  override def getMaxWaitQueueSize: Int = {
    asJava.getMaxWaitQueueSize().asInstanceOf[Int]
  }

  override def setMaxWebSocketFrameSize(value: Int) = {
    asJava.setMaxWebSocketFrameSize(value)
    this
  }

  override def getMaxWebSocketFrameSize: Int = {
    asJava.getMaxWebSocketFrameSize().asInstanceOf[Int]
  }

  override def setMaxWebSocketMessageSize(value: Int) = {
    asJava.setMaxWebSocketMessageSize(value)
    this
  }

  override def getMaxWebSocketMessageSize: Int = {
    asJava.getMaxWebSocketMessageSize().asInstanceOf[Int]
  }

  override def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }

  override def getMaxWebsocketFrameSize: Int = {
    asJava.getMaxWebsocketFrameSize().asInstanceOf[Int]
  }

  override def setMaxWebsocketMessageSize(value: Int) = {
    asJava.setMaxWebsocketMessageSize(value)
    this
  }

  override def getMaxWebsocketMessageSize: Int = {
    asJava.getMaxWebsocketMessageSize().asInstanceOf[Int]
  }

  override def setMetricsName(value: String) = {
    asJava.setMetricsName(value)
    this
  }

  override def getMetricsName: String = {
    asJava.getMetricsName().asInstanceOf[String]
  }

  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  override def getOpenSslEngineOptions: OpenSSLEngineOptions = {
    OpenSSLEngineOptions(asJava.getOpenSslEngineOptions())
  }

  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  override def getPemKeyCertOptions: PemKeyCertOptions = {
    PemKeyCertOptions(asJava.getPemKeyCertOptions())
  }

  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  override def getPemTrustOptions: PemTrustOptions = {
    PemTrustOptions(asJava.getPemTrustOptions())
  }

  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  override def getPfxKeyCertOptions: PfxOptions = {
    PfxOptions(asJava.getPfxKeyCertOptions())
  }

  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  override def getPfxTrustOptions: PfxOptions = {
    PfxOptions(asJava.getPfxTrustOptions())
  }

  override def setPipelining(value: Boolean) = {
    asJava.setPipelining(value)
    this
  }

  override def isPipelining: Boolean = {
    asJava.isPipelining().asInstanceOf[Boolean]
  }

  override def setPipeliningLimit(value: Int) = {
    asJava.setPipeliningLimit(value)
    this
  }

  override def getPipeliningLimit: Int = {
    asJava.getPipeliningLimit().asInstanceOf[Int]
  }

  override def setPoolCleanerPeriod(value: Int) = {
    asJava.setPoolCleanerPeriod(value)
    this
  }

  override def getPoolCleanerPeriod: Int = {
    asJava.getPoolCleanerPeriod().asInstanceOf[Int]
  }

  override def setProtocolVersion(value: io.vertx.core.http.HttpVersion) = {
    asJava.setProtocolVersion(value)
    this
  }

  override def getProtocolVersion: io.vertx.core.http.HttpVersion = {
    asJava.getProtocolVersion()
  }

  override def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }

  override def getProxyOptions: ProxyOptions = {
    ProxyOptions(asJava.getProxyOptions())
  }

  /**
   * The provider PubSec key options
   */
  def addPubSecKey(value: PubSecKeyOptions) = {
    asJava.addPubSecKey(value.asJava)
    this
  }

  def setPubSecKeys(value: scala.collection.mutable.Buffer[PubSecKeyOptions]) = {
    asJava.setPubSecKeys(value.map(_.asJava).asJava)
    this
  }

  def getPubSecKeys: scala.collection.mutable.Buffer[PubSecKeyOptions] = {
    asJava.getPubSecKeys().asScala.map(x => PubSecKeyOptions(x))
  }

  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }

  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }

  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }

  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }

  override def setReusePort(value: Boolean) = {
    asJava.setReusePort(value)
    this
  }

  override def isReusePort: Boolean = {
    asJava.isReusePort().asInstanceOf[Boolean]
  }

  /**
   * Set the Oauth2 revocation resource path. e.g.: /oauth/revoke
   */
  def setRevocationPath(value: String) = {
    asJava.setRevocationPath(value)
    this
  }

  def getRevocationPath: String = {
    asJava.getRevocationPath().asInstanceOf[String]
  }

  /**
   * Set the provider scope separator
   */
  def setScopeSeparator(value: String) = {
    asJava.setScopeSeparator(value)
    this
  }

  def getScopeSeparator: String = {
    asJava.getScopeSeparator().asInstanceOf[String]
  }

  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  override def setSendUnmaskedFrames(value: Boolean) = {
    asJava.setSendUnmaskedFrames(value)
    this
  }

  override def isSendUnmaskedFrames: Boolean = {
    asJava.isSendUnmaskedFrames().asInstanceOf[Boolean]
  }

  /**
   * Root URL for the provider
   */
  def setSite(value: String) = {
    asJava.setSite(value)
    this
  }

  def getSite: String = {
    asJava.getSite().asInstanceOf[String]
  }

  override def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }

  override def getSoLinger: Int = {
    asJava.getSoLinger().asInstanceOf[Int]
  }

  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }

  override def isSsl: Boolean = {
    asJava.isSsl().asInstanceOf[Boolean]
  }

  override def setSslHandshakeTimeout(value: Long) = {
    asJava.setSslHandshakeTimeout(value)
    this
  }

  override def getSslHandshakeTimeout: Long = {
    asJava.getSslHandshakeTimeout().asInstanceOf[Long]
  }

  override def setSslHandshakeTimeoutUnit(value: java.util.concurrent.TimeUnit) = {
    asJava.setSslHandshakeTimeoutUnit(value)
    this
  }

  override def getSslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit = {
    asJava.getSslHandshakeTimeoutUnit()
  }

  override def setTcpCork(value: Boolean) = {
    asJava.setTcpCork(value)
    this
  }

  override def isTcpCork: Boolean = {
    asJava.isTcpCork().asInstanceOf[Boolean]
  }

  override def setTcpFastOpen(value: Boolean) = {
    asJava.setTcpFastOpen(value)
    this
  }

  override def isTcpFastOpen: Boolean = {
    asJava.isTcpFastOpen().asInstanceOf[Boolean]
  }

  override def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }

  override def isTcpKeepAlive: Boolean = {
    asJava.isTcpKeepAlive().asInstanceOf[Boolean]
  }

  override def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }

  override def isTcpNoDelay: Boolean = {
    asJava.isTcpNoDelay().asInstanceOf[Boolean]
  }

  override def setTcpQuickAck(value: Boolean) = {
    asJava.setTcpQuickAck(value)
    this
  }

  override def isTcpQuickAck: Boolean = {
    asJava.isTcpQuickAck().asInstanceOf[Boolean]
  }

  /**
   * Get the Oauth2 token resource path. e.g.: /oauth/token
   */
  def setTokenPath(value: String) = {
    asJava.setTokenPath(value)
    this
  }

  def getTokenPath: String = {
    asJava.getTokenPath().asInstanceOf[String]
  }

  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }

  override def getTrafficClass: Int = {
    asJava.getTrafficClass().asInstanceOf[Int]
  }

  override def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }

  override def isTrustAll: Boolean = {
    asJava.isTrustAll().asInstanceOf[Boolean]
  }

  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  override def getTrustStoreOptions: JksOptions = {
    JksOptions(asJava.getTrustStoreOptions())
  }

  override def setTryUseCompression(value: Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }

  override def isTryUseCompression: Boolean = {
    asJava.isTryUseCompression().asInstanceOf[Boolean]
  }

  override def setTryUsePerFrameWebSocketCompression(value: Boolean) = {
    asJava.setTryUsePerFrameWebSocketCompression(value)
    this
  }

  override def setTryUsePerFrameWebsocketCompression(value: Boolean) = {
    asJava.setTryUsePerFrameWebsocketCompression(value)
    this
  }

  override def setTryUsePerMessageWebSocketCompression(value: Boolean) = {
    asJava.setTryUsePerMessageWebSocketCompression(value)
    this
  }

  override def getTryUsePerMessageWebSocketCompression: Boolean = {
    asJava.getTryUsePerMessageWebSocketCompression().asInstanceOf[Boolean]
  }

  override def setTryUsePerMessageWebsocketCompression(value: Boolean) = {
    asJava.setTryUsePerMessageWebsocketCompression(value)
    this
  }

  override def getTryUsePerMessageWebsocketCompression: Boolean = {
    asJava.getTryUsePerMessageWebsocketCompression().asInstanceOf[Boolean]
  }

  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }

  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn().asInstanceOf[Boolean]
  }

  /**
   * Flag to use HTTP basic auth header with client id, client secret.
   */
  def setUseBasicAuthorizationHeader(value: Boolean) = {
    asJava.setUseBasicAuthorizationHeader(value)
    this
  }

  def isUseBasicAuthorizationHeader: Boolean = {
    asJava.isUseBasicAuthorizationHeader().asInstanceOf[Boolean]
  }

  override def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }

  override def isUsePooledBuffers: Boolean = {
    asJava.isUsePooledBuffers().asInstanceOf[Boolean]
  }

  /**
   * Set a custom user agent to use when communicating to a provider
   */
  def setUserAgent(value: String) = {
    asJava.setUserAgent(value)
    this
  }

  def getUserAgent: String = {
    asJava.getUserAgent().asInstanceOf[String]
  }

  /**
   * Set custom parameters to be sent during the userInfo resource request
   */
  def setUserInfoParameters(value: io.vertx.core.json.JsonObject) = {
    asJava.setUserInfoParameters(value)
    this
  }

  def getUserInfoParameters: io.vertx.core.json.JsonObject = {
    asJava.getUserInfoParameters()
  }

  /**
   * Set the provider userInfo resource path
   */
  def setUserInfoPath(value: String) = {
    asJava.setUserInfoPath(value)
    this
  }

  def getUserInfoPath: String = {
    asJava.getUserInfoPath().asInstanceOf[String]
  }

  def setValidateIssuer(value: Boolean) = {
    asJava.setValidateIssuer(value)
    this
  }

  def isValidateIssuer: Boolean = {
    asJava.isValidateIssuer().asInstanceOf[Boolean]
  }

  override def setVerifyHost(value: Boolean) = {
    asJava.setVerifyHost(value)
    this
  }

  override def isVerifyHost: Boolean = {
    asJava.isVerifyHost().asInstanceOf[Boolean]
  }

  override def setWebSocketCompressionAllowClientNoContext(value: Boolean) = {
    asJava.setWebSocketCompressionAllowClientNoContext(value)
    this
  }

  override def getWebSocketCompressionAllowClientNoContext: Boolean = {
    asJava.getWebSocketCompressionAllowClientNoContext().asInstanceOf[Boolean]
  }

  override def setWebSocketCompressionLevel(value: Int) = {
    asJava.setWebSocketCompressionLevel(value)
    this
  }

  override def getWebSocketCompressionLevel: Int = {
    asJava.getWebSocketCompressionLevel().asInstanceOf[Int]
  }

  override def setWebSocketCompressionRequestServerNoContext(value: Boolean) = {
    asJava.setWebSocketCompressionRequestServerNoContext(value)
    this
  }

  override def getWebSocketCompressionRequestServerNoContext: Boolean = {
    asJava.getWebSocketCompressionRequestServerNoContext().asInstanceOf[Boolean]
  }

  override def setWebsocketCompressionAllowClientNoContext(value: Boolean) = {
    asJava.setWebsocketCompressionAllowClientNoContext(value)
    this
  }

  override def getWebsocketCompressionAllowClientNoContext: Boolean = {
    asJava.getWebsocketCompressionAllowClientNoContext().asInstanceOf[Boolean]
  }

  override def setWebsocketCompressionLevel(value: Int) = {
    asJava.setWebsocketCompressionLevel(value)
    this
  }

  override def getWebsocketCompressionLevel: Int = {
    asJava.getWebsocketCompressionLevel().asInstanceOf[Int]
  }

  override def setWebsocketCompressionRequestServerNoContext(value: Boolean) = {
    asJava.setWebsocketCompressionRequestServerNoContext(value)
    this
  }

  override def getWebsocketCompressionRequestServerNoContext: Boolean = {
    asJava.getWebsocketCompressionRequestServerNoContext().asInstanceOf[Boolean]
  }

}


object OAuth2ClientOptions {

  def apply() = {
    new OAuth2ClientOptions(new JOAuth2ClientOptions(emptyObj()))
  }

  def apply(t: JOAuth2ClientOptions) = {
    if (t != null) {
      new OAuth2ClientOptions(t)
    } else {
      new OAuth2ClientOptions(new JOAuth2ClientOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): OAuth2ClientOptions = {
    if (json != null) {
      new OAuth2ClientOptions(new JOAuth2ClientOptions(json))
    } else {
      new OAuth2ClientOptions(new JOAuth2ClientOptions(emptyObj()))
    }
  }
}

