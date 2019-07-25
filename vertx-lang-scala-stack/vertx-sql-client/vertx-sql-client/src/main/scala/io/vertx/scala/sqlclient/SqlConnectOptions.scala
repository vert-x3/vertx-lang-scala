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

package io.vertx.scala.sqlclient

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.sqlclient.{SqlConnectOptions => JSqlConnectOptions}
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * Connect options for configuring [[io.vertx.scala.sqlclient.SqlConnection]] or [[io.vertx.scala.sqlclient.Pool]].

 */

abstract class SqlConnectOptions(private val _asJava: JSqlConnectOptions) extends ExtNetClientOptions(_asJava) {

  /**
   * Set whether prepared statements cache should be enabled.
   */
  def setCachePreparedStatements(value: Boolean): SqlConnectOptions

  def getCachePreparedStatements: Boolean

  def setConnectTimeout(value: Int): SqlConnectOptions

  def getConnectTimeout: Int

  def addCrlPath(value: String): SqlConnectOptions

  def getCrlPaths: scala.collection.mutable.Buffer[String]

  def addCrlValue(value: io.vertx.core.buffer.Buffer): SqlConnectOptions

  def getCrlValues: scala.collection.mutable.Buffer[io.vertx.core.buffer.Buffer]

  /**
   * Specify the default database for the connection.
   */
  def setDatabase(value: String): SqlConnectOptions

  def getDatabase: String

  def addEnabledCipherSuite(value: String): SqlConnectOptions

  def getEnabledCipherSuites: scala.collection.mutable.Set[String]

  def addEnabledSecureTransportProtocol(value: String): SqlConnectOptions

  def setEnabledSecureTransportProtocols(value: Set[String]): SqlConnectOptions

  def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String]

  /**
   * Specify the host for connecting to the server.
   */
  def setHost(value: String): SqlConnectOptions

  def getHost: String

  def setHostnameVerificationAlgorithm(value: String): SqlConnectOptions

  def getHostnameVerificationAlgorithm: String

  def setIdleTimeout(value: Int): SqlConnectOptions

  def getIdleTimeout: Int

  def setIdleTimeoutUnit(value: java.util.concurrent.TimeUnit): SqlConnectOptions

  def getIdleTimeoutUnit: java.util.concurrent.TimeUnit

  def setJdkSslEngineOptions(value: JdkSSLEngineOptions): SqlConnectOptions

  def getJdkSslEngineOptions: JdkSSLEngineOptions

  def setKeyStoreOptions(value: JksOptions): SqlConnectOptions

  def getKeyStoreOptions: JksOptions

  def setLocalAddress(value: String): SqlConnectOptions

  def getLocalAddress: String

  def setLogActivity(value: Boolean): SqlConnectOptions

  def getLogActivity: Boolean

  def setMetricsName(value: String): SqlConnectOptions

  def getMetricsName: String

  def setOpenSslEngineOptions(value: OpenSSLEngineOptions): SqlConnectOptions

  def getOpenSslEngineOptions: OpenSSLEngineOptions

  /**
   * Specify the user password to be used for the authentication.
   */
  def setPassword(value: String): SqlConnectOptions

  def getPassword: String

  def setPemKeyCertOptions(value: PemKeyCertOptions): SqlConnectOptions

  def getPemKeyCertOptions: PemKeyCertOptions

  def setPemTrustOptions(value: PemTrustOptions): SqlConnectOptions

  def getPemTrustOptions: PemTrustOptions

  def setPfxKeyCertOptions(value: PfxOptions): SqlConnectOptions

  def getPfxKeyCertOptions: PfxOptions

  def setPfxTrustOptions(value: PfxOptions): SqlConnectOptions

  def getPfxTrustOptions: PfxOptions

  /**
   * Specify the port for connecting to the server.
   */
  def setPort(value: Int): SqlConnectOptions

  def getPort: Int

  /**
   * Set the maximum number of prepared statements that the connection will cache.
   */
  def setPreparedStatementCacheMaxSize(value: Int): SqlConnectOptions

  def getPreparedStatementCacheMaxSize: Int

  /**
   * Set the maximum length of prepared statement SQL string that the connection will cache.
   */
  def setPreparedStatementCacheSqlLimit(value: Int): SqlConnectOptions

  def getPreparedStatementCacheSqlLimit: Int

  def setProxyOptions(value: ProxyOptions): SqlConnectOptions

  def getProxyOptions: ProxyOptions

  def setReceiveBufferSize(value: Int): SqlConnectOptions

  def getReceiveBufferSize: Int

  def setReconnectAttempts(value: Int): SqlConnectOptions

  def getReconnectAttempts: Int

  def setReconnectInterval(value: Long): SqlConnectOptions

  def getReconnectInterval: Long

  def setReuseAddress(value: Boolean): SqlConnectOptions

  def isReuseAddress: Boolean

  def setReusePort(value: Boolean): SqlConnectOptions

  def isReusePort: Boolean

  def setSendBufferSize(value: Int): SqlConnectOptions

  def getSendBufferSize: Int

  def setSoLinger(value: Int): SqlConnectOptions

  def getSoLinger: Int

  def setSsl(value: Boolean): SqlConnectOptions

  def isSsl: Boolean

  def setSslHandshakeTimeout(value: Long): SqlConnectOptions

  def getSslHandshakeTimeout: Long

  def setSslHandshakeTimeoutUnit(value: java.util.concurrent.TimeUnit): SqlConnectOptions

  def getSslHandshakeTimeoutUnit: java.util.concurrent.TimeUnit

  def setTcpCork(value: Boolean): SqlConnectOptions

  def isTcpCork: Boolean

  def setTcpFastOpen(value: Boolean): SqlConnectOptions

  def isTcpFastOpen: Boolean

  def setTcpKeepAlive(value: Boolean): SqlConnectOptions

  def isTcpKeepAlive: Boolean

  def setTcpNoDelay(value: Boolean): SqlConnectOptions

  def isTcpNoDelay: Boolean

  def setTcpQuickAck(value: Boolean): SqlConnectOptions

  def isTcpQuickAck: Boolean

  def setTrafficClass(value: Int): SqlConnectOptions

  def getTrafficClass: Int

  def setTrustAll(value: Boolean): SqlConnectOptions

  def isTrustAll: Boolean

  def setTrustStoreOptions(value: JksOptions): SqlConnectOptions

  def getTrustStoreOptions: JksOptions

  def setUseAlpn(value: Boolean): SqlConnectOptions

  def isUseAlpn: Boolean

  def setUsePooledBuffers(value: Boolean): SqlConnectOptions

  def isUsePooledBuffers: Boolean

  /**
   * Specify the user account to be used for the authentication.
   */
  def setUser(value: String): SqlConnectOptions

  def getUser: String

}
