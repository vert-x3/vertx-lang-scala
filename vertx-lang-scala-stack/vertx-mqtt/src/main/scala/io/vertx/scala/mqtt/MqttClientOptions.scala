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

package io.vertx.scala.mqtt

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.mqtt.{MqttClientOptions => JMqttClientOptions}
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
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
  * Represents options used by the MQTT client.
  */
class MqttClientOptions(private val _asJava: JMqttClientOptions) 
    extends ExtNetClientOptions(_asJava) {

  override def asJava = _asJava

  /**
    * Set if the MQTT client must generate clientId automatically
    * (default is true)
    */
  def setAutoGeneratedClientId(value: Boolean) = {
    asJava.setAutoGeneratedClientId(value)
    this
  }
  def isAutoGeneratedClientId: Boolean = {
    asJava.isAutoGeneratedClientId().asInstanceOf[Boolean]
  }

  /**
    * Set if the MQTT client must handle PINGREQ automatically
    * (default is true)
    */
  def setAutoKeepAlive(value: Boolean) = {
    asJava.setAutoKeepAlive(value)
    this
  }
  def isAutoKeepAlive: Boolean = {
    asJava.isAutoKeepAlive().asInstanceOf[Boolean]
  }

  /**
    * Set to start with a clean session (or not)
    */
  def setCleanSession(value: Boolean) = {
    asJava.setCleanSession(value)
    this
  }
  def isCleanSession: Boolean = {
    asJava.isCleanSession().asInstanceOf[Boolean]
  }

  /**
    * Set the client identifier
    */
  def setClientId(value: String) = {
    asJava.setClientId(value)
    this
  }
  def getClientId: String = {
    asJava.getClientId().asInstanceOf[String]
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
  override def setHostnameVerificationAlgorithm(value: String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }
  override def getHostnameVerificationAlgorithm: String = {
    asJava.getHostnameVerificationAlgorithm().asInstanceOf[String]
  }

  /**
    * Do the same thing as <a href="../../../../../../cheatsheet/MqttClientOptions.html">MqttClientOptions</a>. Use it instead.
    */
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

  /**
    * Set the keep alive timeout in seconds
    */
  def setKeepAliveTimeSeconds(value: Int) = {
    asJava.setKeepAliveTimeSeconds(value)
    this
  }
  def getKeepAliveTimeSeconds: Int = {
    asJava.getKeepAliveTimeSeconds().asInstanceOf[Int]
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
    * Set max count of unacknowledged messages
    */
  def setMaxInflightQueue(value: Int) = {
    asJava.setMaxInflightQueue(value)
    this
  }
  def getMaxInflightQueue: Int = {
    asJava.getMaxInflightQueue().asInstanceOf[Int]
  }

  /**
    * Set max MQTT message size
    */
  def setMaxMessageSize(value: Int) = {
    asJava.setMaxMessageSize(value)
    this
  }
  def getMaxMessageSize: Int = {
    asJava.getMaxMessageSize().asInstanceOf[Int]
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

  /**
    * Set the password
    */
  def setPassword(value: String) = {
    asJava.setPassword(value)
    this
  }
  def getPassword: String = {
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
    * Set the username
    */
  def setUsername(value: String) = {
    asJava.setUsername(value)
    this
  }
  def getUsername: String = {
    asJava.getUsername().asInstanceOf[String]
  }

  /**
    * Set if will information are provided on connection
    */
  def setWillFlag(value: Boolean) = {
    asJava.setWillFlag(value)
    this
  }
  def isWillFlag: Boolean = {
    asJava.isWillFlag().asInstanceOf[Boolean]
  }

  /**
    * Set the content of the will message
    */
  def setWillMessage(value: String) = {
    asJava.setWillMessage(value)
    this
  }
  def getWillMessage: String = {
    asJava.getWillMessage().asInstanceOf[String]
  }

  /**
    * Set the QoS level for the will message
    */
  def setWillQoS(value: Int) = {
    asJava.setWillQoS(value)
    this
  }
  def getWillQoS: Int = {
    asJava.getWillQoS().asInstanceOf[Int]
  }

  /**
    * Set if the will message must be retained
    */
  def setWillRetain(value: Boolean) = {
    asJava.setWillRetain(value)
    this
  }
  def isWillRetain: Boolean = {
    asJava.isWillRetain().asInstanceOf[Boolean]
  }

  /**
    * Set the topic on which the will message will be published
    */
  def setWillTopic(value: String) = {
    asJava.setWillTopic(value)
    this
  }
  def getWillTopic: String = {
    asJava.getWillTopic().asInstanceOf[String]
  }
}

object MqttClientOptions {
  
  def apply() = {
    new MqttClientOptions(new JMqttClientOptions(emptyObj()))
  }
  
  def apply(t: JMqttClientOptions) = {
    if (t != null) {
      new MqttClientOptions(t)
    } else {
      new MqttClientOptions(new JMqttClientOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MqttClientOptions = {
    if (json != null) {
      new MqttClientOptions(new JMqttClientOptions(json))
    } else {
      new MqttClientOptions(new JMqttClientOptions(emptyObj()))
    }
  }
}
