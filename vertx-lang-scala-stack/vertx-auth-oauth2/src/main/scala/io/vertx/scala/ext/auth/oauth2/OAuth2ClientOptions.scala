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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.http.Http2Settings
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.http.{HttpClientOptions => JHttpClientOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.scala.core.net.PfxOptions
import io.vertx.ext.auth.oauth2.{OAuth2ClientOptions => JOAuth2ClientOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.http.HttpVersion
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.json.JsonObject
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.http.{Http2Settings => JHttp2Settings}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.scala.core.http.HttpClientOptions
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options describing how an OAuth2  will make connections.
  */
class OAuth2ClientOptions(private val _asJava: JOAuth2ClientOptions) 
    extends HttpClientOptions(_asJava) {

  override def asJava = _asJava
  override def setAlpnVersions(value: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion]) = {
    asJava.setAlpnVersions(value.asInstanceOf)
    this
  }
  override def getAlpnVersions: scala.collection.mutable.Buffer[io.vertx.core.http.HttpVersion] = {
    asJava.getAlpnVersions().asScala.map(x => x)
  }
  def setAuthorizationPath(value: String) = {
    asJava.setAuthorizationPath(value)
    this
  }
  def getAuthorizationPath: String = {
    asJava.getAuthorizationPath().asInstanceOf[String]
  }
  def setClientID(value: String) = {
    asJava.setClientID(value)
    this
  }
  def getClientID: String = {
    asJava.getClientID().asInstanceOf[String]
  }
  def setClientSecret(value: String) = {
    asJava.setClientSecret(value)
    this
  }
  def getClientSecret: String = {
    asJava.getClientSecret().asInstanceOf[String]
  }
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
  override def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asInstanceOf)
    this
  }
  override def getCrlValues: scala.collection.mutable.Buffer[Buffer] = {
    asJava.getCrlValues().asScala.map(x => Buffer(x))
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
  override def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSecureTransportProtocols().asScala.map(x => x.asInstanceOf[String])
  }
  def setExtraParameters(value: io.vertx.core.json.JsonObject) = {
    asJava.setExtraParameters(value)
    this
  }
  def getExtraParameters: io.vertx.core.json.JsonObject = {
    asJava.getExtraParameters()
  }
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
  override def setInitialSettings(value: Http2Settings) = {
    asJava.setInitialSettings(value.asJava)
    this
  }
  override def getInitialSettings: Http2Settings = {
    Http2Settings(asJava.getInitialSettings())
  }
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
  def setJwtToken(value: Boolean) = {
    asJava.setJwtToken(value)
    this
  }
  def isJwtToken: Boolean = {
    asJava.isJwtToken().asInstanceOf[Boolean]
  }
  override def setKeepAlive(value: Boolean) = {
    asJava.setKeepAlive(value)
    this
  }
  override def isKeepAlive: Boolean = {
    asJava.isKeepAlive().asInstanceOf[Boolean]
  }
  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
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
  override def setMaxWaitQueueSize(value: Int) = {
    asJava.setMaxWaitQueueSize(value)
    this
  }
  override def getMaxWaitQueueSize: Int = {
    asJava.getMaxWaitQueueSize().asInstanceOf[Int]
  }
  override def setMaxWebsocketFrameSize(value: Int) = {
    asJava.setMaxWebsocketFrameSize(value)
    this
  }
  override def getMaxWebsocketFrameSize: Int = {
    asJava.getMaxWebsocketFrameSize().asInstanceOf[Int]
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
  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }
  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }
  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }
  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
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
  def setPrivateKey(value: String) = {
    asJava.setPrivateKey(value)
    this
  }
  def getPrivateKey: String = {
    asJava.getPrivateKey().asInstanceOf[String]
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
  def setPublicKey(value: String) = {
    asJava.setPublicKey(value)
    this
  }
  def getPublicKey: String = {
    asJava.getPublicKey().asInstanceOf[String]
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
  def setRevocationPath(value: String) = {
    asJava.setRevocationPath(value)
    this
  }
  def getRevocationPath: String = {
    asJava.getRevocationPath().asInstanceOf[String]
  }
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
  override def setTryUseCompression(value: Boolean) = {
    asJava.setTryUseCompression(value)
    this
  }
  override def isTryUseCompression: Boolean = {
    asJava.isTryUseCompression().asInstanceOf[Boolean]
  }
  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn().asInstanceOf[Boolean]
  }
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
  def setUserAgent(value: String) = {
    asJava.setUserAgent(value)
    this
  }
  def getUserAgent: String = {
    asJava.getUserAgent().asInstanceOf[String]
  }
  def setUserInfoPath(value: String) = {
    asJava.setUserInfoPath(value)
    this
  }
  def getUserInfoPath: String = {
    asJava.getUserInfoPath().asInstanceOf[String]
  }
  override def setVerifyHost(value: Boolean) = {
    asJava.setVerifyHost(value)
    this
  }
  override def isVerifyHost: Boolean = {
    asJava.isVerifyHost().asInstanceOf[Boolean]
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
