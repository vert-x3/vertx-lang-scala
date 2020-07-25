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

package io.vertx.scala.mysqlclient

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.mysqlclient.{MySQLConnectOptions => JMySQLConnectOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.scala.sqlclient.{SqlConnectOptions => ExtSqlConnectOptions}
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
 * Connect options for configuring [[io.vertx.scala.mysqlclient.MySQLConnection]] or [[io.vertx.scala.mysqlclient.MySQLPool]].

 */

class MySQLConnectOptions(private val _asJava: JMySQLConnectOptions) extends ExtSqlConnectOptions(_asJava) {
  override def asJava = _asJava
  override def setCachePreparedStatements(value: Boolean) = {
    asJava.setCachePreparedStatements(value)
    this
  }

  override def getCachePreparedStatements: Boolean = {
    asJava.getCachePreparedStatements().asInstanceOf[Boolean]
  }

  /**
   * Set the Java charset for encoding string values, this value is UTF-8 by default.
   */
  def setCharacterEncoding(value: String) = {
    asJava.setCharacterEncoding(value)
    this
  }

  def getCharacterEncoding: String = {
    asJava.getCharacterEncoding().asInstanceOf[String]
  }

  /**
   * Set the charset for the connection.
   */
  def setCharset(value: String) = {
    asJava.setCharset(value)
    this
  }

  def getCharset: String = {
    asJava.getCharset().asInstanceOf[String]
  }

  /**
   * Set the collation for the connection.
   */
  def setCollation(value: String) = {
    asJava.setCollation(value)
    this
  }

  def getCollation: String = {
    asJava.getCollation().asInstanceOf[String]
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

  override def setDatabase(value: String) = {
    asJava.setDatabase(value)
    this
  }

  override def getDatabase: String = {
    asJava.getDatabase().asInstanceOf[String]
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

  override def setHost(value: String) = {
    asJava.setHost(value)
    this
  }

  override def getHost: String = {
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

  override def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }

  override def getPassword: String = {
    asJava.getPassword().asInstanceOf[String]
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

  override def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }

  override def getPort: Int = {
    asJava.getPort().asInstanceOf[Int]
  }

  override def setPreparedStatementCacheMaxSize(value: Int) = {
    asJava.setPreparedStatementCacheMaxSize(value)
    this
  }

  override def getPreparedStatementCacheMaxSize: Int = {
    asJava.getPreparedStatementCacheMaxSize().asInstanceOf[Int]
  }

  override def setPreparedStatementCacheSqlLimit(value: Int) = {
    asJava.setPreparedStatementCacheSqlLimit(value)
    this
  }

  override def setProperties(value: Map[String, String]) = {
    asJava.setProperties(value.asJava)
    this
  }

  override def getProperties: scala.collection.mutable.Map[String, String] = {
    collection.mutable.Map(asJava.getProperties().asScala.mapValues(x => x.asInstanceOf[String]).toSeq: _*)
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

  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
   * Set the path of server RSA public key which is mostly used for encrypting password under insecure connections when performing authentication.
   */
  def setServerRsaPublicKeyPath(value: String) = {
    asJava.setServerRsaPublicKeyPath(value)
    this
  }

  def getServerRsaPublicKeyPath: String = {
    asJava.getServerRsaPublicKeyPath().asInstanceOf[String]
  }

  /**
   * Set the value of server RSA public key which is mostly used for encrypting password under insecure connections when performing authentication.
   */
  def setServerRsaPublicKeyValue(value: io.vertx.core.buffer.Buffer) = {
    asJava.setServerRsaPublicKeyValue(value)
    this
  }

  def getServerRsaPublicKeyValue: io.vertx.core.buffer.Buffer = {
    asJava.getServerRsaPublicKeyValue()
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

  /**
   * Set the [[io.vertx.mysqlclient.SslMode]] for the client, this option can be used to specify the desired security state of the connection to the server.
   */
  def setSslMode(value: io.vertx.mysqlclient.SslMode) = {
    asJava.setSslMode(value)
    this
  }

  def getSslMode: io.vertx.mysqlclient.SslMode = {
    asJava.getSslMode()
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

  /**
   * Sets how affected rows are calculated on update/delete/insert, if set to <code>true</code> an update that effectively
   * does not change any data returns zero affected rows.
   *
   * See <a href="https://dev.mysql.com/doc/refman/8.0/en/mysql-affected-rows.html">mysql-affected-rows</a> for details.
   */
  def setUseAffectedRows(value: Boolean) = {
    asJava.setUseAffectedRows(value)
    this
  }

  def isUseAffectedRows: Boolean = {
    asJava.isUseAffectedRows().asInstanceOf[Boolean]
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

  override def setUser(value: String) = {
    asJava.setUser(value)
    this
  }

  override def getUser: String = {
    asJava.getUser().asInstanceOf[String]
  }

}


object MySQLConnectOptions {

  def apply() = {
    new MySQLConnectOptions(new JMySQLConnectOptions(emptyObj()))
  }

  def apply(t: JMySQLConnectOptions) = {
    if (t != null) {
      new MySQLConnectOptions(t)
    } else {
      new MySQLConnectOptions(new JMySQLConnectOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): MySQLConnectOptions = {
    if (json != null) {
      new MySQLConnectOptions(new JMySQLConnectOptions(json))
    } else {
      new MySQLConnectOptions(new JMySQLConnectOptions(emptyObj()))
    }
  }
}

