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

package io.vertx.scala.proton

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.scala.core.net.PfxOptions
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.proton.{ProtonClientOptions => JProtonClientOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Options for configuring [[io.vertx.scala.proton.ProtonClient]] connect operations.
  */
class ProtonClientOptions(private val _asJava: JProtonClientOptions) 
    extends ExtNetClientOptions(_asJava) {

  override def asJava = _asJava
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
  override def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  override def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
    asJava.getEnabledCipherSuites().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * Adds a mechanism name that the client may use during SASL negotiation.
    */
  def addEnabledSaslMechanism(value: String) = {
    asJava.addEnabledSaslMechanism(value)
    this
  }
  def getEnabledSaslMechanisms: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSaslMechanisms().asScala.map(x => x.asInstanceOf[String])
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
    * Set the heartbeat (in milliseconds) as maximum delay between sending frames for the remote peers.
    * If no frames are received within 2*heartbeat, the connection is closed
    */
  def setHeartbeat(value: Int) = {
    asJava.setHeartbeat(value)
    this
  }
  def getHeartbeat: Int = {
    asJava.getHeartbeat().asInstanceOf[Int]
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
    * Sets the maximum frame size to announce in the AMQP <em>OPEN</em> frame.
    * 
    * If this property is not set explicitly, a reasonable default value is used.
    * 
    * Setting this property to a negative value will result in no maximum frame size being announced at all.
    */
  def setMaxFrameSize(value: Int) = {
    asJava.setMaxFrameSize(value)
    this
  }
  def getMaxFrameSize: Int = {
    asJava.getMaxFrameSize().asInstanceOf[Int]
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
    * Explicitly override the hostname to use for the TLS SNI server name.
    *
    * If neither the <a href="../../../../../../cheatsheet/ProtonClientOptions.html">ProtonClientOptions</a> or SNI server name is explicitly
    * overridden, the hostname specified in [[io.vertx.scala.proton.ProtonClient]] will be used, with SNI performed implicitly
    * where a FQDN was specified.
    *
    * This method should typically only be needed to set different values for the [virtual] hostname and SNI server name.
    */
  def setSniServerName(value: String) = {
    asJava.setSniServerName(value)
    this
  }
  def getSniServerName: String = {
    asJava.getSniServerName().asInstanceOf[String]
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

  /**
    * Override the hostname value used in the connection AMQP Open frame and TLS SNI server name (if TLS is in use).
    * By default, the hostname specified in [[io.vertx.scala.proton.ProtonClient]] will be used for both, with SNI performed
    * implicit where a FQDN was specified.
    *
    * The SNI server name can also be overridden explicitly using <a href="../../../../../../cheatsheet/ProtonClientOptions.html">ProtonClientOptions</a>.
    */
  def setVirtualHost(value: String) = {
    asJava.setVirtualHost(value)
    this
  }
  def getVirtualHost: String = {
    asJava.getVirtualHost().asInstanceOf[String]
  }
}

object ProtonClientOptions {
  
  def apply() = {
    new ProtonClientOptions(new JProtonClientOptions(emptyObj()))
  }
  
  def apply(t: JProtonClientOptions) = {
    if (t != null) {
      new ProtonClientOptions(t)
    } else {
      new ProtonClientOptions(new JProtonClientOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): ProtonClientOptions = {
    if (json != null) {
      new ProtonClientOptions(new JProtonClientOptions(json))
    } else {
      new ProtonClientOptions(new JProtonClientOptions(emptyObj()))
    }
  }
}
