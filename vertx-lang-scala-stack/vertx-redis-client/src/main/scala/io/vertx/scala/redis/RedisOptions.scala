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

package io.vertx.scala.redis

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.redis.{RedisOptions => JRedisOptions}
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * This object controls the connection setting to the Redis Server. There is no need to specify most of the settings
 * since it has built the following sensible defaults:
 * 
 * * `encoding`: `UTF-8`
 * * `host`: `localhost`
 * * `port`: 6379
 * * `tcpKeepAlive`: true
 * * `tcpNoDelay`: true
 * * `binary`: false
 * 
 * However there are two extra properties that have no defaults since they are optional:
 * 
 * * `auth`
 * * `select`
 * 
 * The usage of this two extra properties is to setup required authentication and optionally the selection of the active
 * database at connection time. If you define this extra properties on every connection to Redis server this client
 * will perform the authentication handshake and database selection, however if you don't do this and call [[io.vertx.scala.redis.RedisClient]]
 * yourself in case of connection failure the client will not be able to perform the correct authentication handshake.

 */

class RedisOptions(private val _asJava: JRedisOptions) extends ExtNetClientOptions(_asJava) {
  override def asJava = _asJava
  /**
   * Set the eventbus address prefix for `PUB/SUB`.
   * * @param address address prefix.
   */
  def setAddress(value: String) = {
    asJava.setAddress(value)
    this
  }

  def getAddress: String = {
    asJava.getAddress().asInstanceOf[String]
  }

  /**
   * Set the password for authentication at connection time.
   */
  def setAuth(value: String) = {
    asJava.setAuth(value)
    this
  }

  def getAuth: String = {
    asJava.getAuth().asInstanceOf[String]
  }

  /**
   * Set the messages to/from redis as binary, default `false`.
   * * @param binary use binary messages
   */
  def setBinary(value: Boolean) = {
    asJava.setBinary(value)
    this
  }

  def isBinary: Boolean = {
    asJava.isBinary().asInstanceOf[Boolean]
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

  /**
   * Set the domain socket enabled option, default `false`.
   */
  def setDomainSocket(value: Boolean) = {
    asJava.setDomainSocket(value)
    this
  }

  def isDomainSocket: Boolean = {
    asJava.isDomainSocket().asInstanceOf[Boolean]
  }

  /**
   * Set the domain socket address where the Redis server is listening.
   */
  def setDomainSocketAddress(value: String) = {
    asJava.setDomainSocketAddress(value)
    this
  }

  def getDomainSocketAddress: String = {
    asJava.getDomainSocketAddress().asInstanceOf[String]
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
   * Set the user defined character encoding, e.g.: `iso-8859-1`.
   * * @param encoding the user character encoding
   */
  def setEncoding(value: String) = {
    asJava.setEncoding(value)
    this
  }

  def getEncoding: String = {
    asJava.getEncoding().asInstanceOf[String]
  }

  /**
   * Set the host name where the Redis server is listening.
   * * @param host host name
   */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  def getHost: String = {
    asJava.getHost().asInstanceOf[String]
  }

  override def setHostnameVerificationAlgorithm(value: String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }

  override def getHostnameVerificationAlgorithm: String = {
    asJava.getHostnameVerificationAlgorithm().asInstanceOf[String]
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

  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  override def getJdkSslEngineOptions: JdkSSLEngineOptions = {
    JdkSSLEngineOptions(asJava.getJdkSslEngineOptions())
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
   * Set name of Redis master (used with Sentinel).
   */
  def setMasterName(value: String) = {
    asJava.setMasterName(value)
    this
  }

  def getMasterName: String = {
    asJava.getMasterName().asInstanceOf[String]
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

  /**
   * Set the tcp port where the Redis server is listening.
   */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  override def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }

  override def getProxyOptions: ProxyOptions = {
    ProxyOptions(asJava.getProxyOptions())
  }

  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }

  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }

  override def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }

  override def getReconnectAttempts: Int = {
    asJava.getReconnectAttempts().asInstanceOf[Int]
  }

  override def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }

  override def getReconnectInterval: Long = {
    asJava.getReconnectInterval().asInstanceOf[Long]
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
   * Set the database to select at connection time.
   * * @param select database id
   */
  def setSelect(value: Int) = {
    asJava.setSelect(value)
    this
  }

  def getSelect: Int = {
    asJava.getSelect().asInstanceOf[Int]
  }

  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
   * Set the list of Sentinels.
   */
  def addSentinel(value: String) = {
    asJava.addSentinel(value)
    this
  }

  def setSentinels(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setSentinels(value.asJava)
    this
  }

  def getSentinels: scala.collection.mutable.Buffer[String] = {
    asJava.getSentinels().asScala.map(x => x.asInstanceOf[String])
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

  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }

  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn().asInstanceOf[Boolean]
  }

  override def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }

  override def isUsePooledBuffers: Boolean = {
    asJava.isUsePooledBuffers().asInstanceOf[Boolean]
  }

}


object RedisOptions {
  
  def apply() = {
    new RedisOptions(new JRedisOptions(emptyObj()))
  }
  
  def apply(t: JRedisOptions) = {
    if (t != null) {
      new RedisOptions(t)
    } else {
      new RedisOptions(new JRedisOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): RedisOptions = {
    if (json != null) {
      new RedisOptions(new JRedisOptions(json))
    } else {
      new RedisOptions(new JRedisOptions(emptyObj()))
    }
  }
}

