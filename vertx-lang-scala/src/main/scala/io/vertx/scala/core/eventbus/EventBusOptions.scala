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

package io.vertx.scala.core.eventbus

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.core.eventbus.{EventBusOptions => JEventBusOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
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

/**
  * Options to configure the event bus.
  */

class EventBusOptions(val asJava: JEventBusOptions) {

  /**
    * Set the accept back log.
    */
  def setAcceptBacklog(value: Int) = {
    asJava.setAcceptBacklog(value)
    this
  }
  def getAcceptBacklog = {
    asJava.getAcceptBacklog()
  }

  /**
    * Set whether client auth is required
    */
  def setClientAuth(value: io.vertx.core.http.ClientAuth) = {
    asJava.setClientAuth(value)
    this
  }
  def getClientAuth = {
    asJava.getClientAuth()
  }

  /**
    * Set the value of cluster ping interval, in ms.
    */
  def setClusterPingInterval(value: Long) = {
    asJava.setClusterPingInterval(value)
    this
  }
  def getClusterPingInterval = {
    asJava.getClusterPingInterval()
  }

  /**
    * Set the value of cluster ping reply interval, in ms.
    */
  def setClusterPingReplyInterval(value: Long) = {
    asJava.setClusterPingReplyInterval(value)
    this
  }
  def getClusterPingReplyInterval = {
    asJava.getClusterPingReplyInterval()
  }

  /**
    * Set the public facing hostname to be used for clustering.
    * Sometimes, e.g. when running on certain clouds, the local address the server listens on for clustering is
    * not the same address that other nodes connect to it at, as the OS / cloud infrastructure does some kind of
    * proxying. If this is the case you can specify a public hostname which is different from the hostname the
    * server listens at.
    * 
    * The default value is null which means use the same as the cluster hostname.
    */
  def setClusterPublicHost(value: String) = {
    asJava.setClusterPublicHost(value)
    this
  }
  def getClusterPublicHost = {
    asJava.getClusterPublicHost()
  }

  /**
    * See <a href="../../../../../../../cheatsheet/EventBusOptions.html">EventBusOptions</a> for an explanation.
    */
  def setClusterPublicPort(value: Int) = {
    asJava.setClusterPublicPort(value)
    this
  }
  def getClusterPublicPort = {
    asJava.getClusterPublicPort()
  }

  /**
    * Sets whether or not the event bus is clustered.
    */
  def setClustered(value: Boolean) = {
    asJava.setClustered(value)
    this
  }
  def isClustered = {
    asJava.isClustered()
  }

  /**
    * Sets the connect timeout
    */
  def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
  }

  /**
    * Add a CRL path
    */
  def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }

  /**
    * Add a CRL value
    */
  def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asJava)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }

  /**
    * Sets the host.
    */
  def setHost(value: String) = {
    asJava.setHost(value)
    this
  }
  def getHost = {
    asJava.getHost()
  }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }
  def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  /**
    * Sets the port.
    */
  def setPort(value: Int) = {
    asJava.setPort(value)
    this
  }
  def getPort = {
    asJava.getPort()
  }

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }

  /**
    * Sets the value of reconnect attempts.
    */
  def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }
  def getReconnectAttempts = {
    asJava.getReconnectAttempts()
  }

  /**
    * Set the reconnect interval.
    */
  def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }
  def getReconnectInterval = {
    asJava.getReconnectInterval()
  }

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }

  /**
    * Set whether all server certificates should be trusted.
    */
  def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }
}

object EventBusOptions {
  
  def apply() = {
    new EventBusOptions(new JEventBusOptions(emptyObj()))
  }
  
  def apply(t: JEventBusOptions) = {
    if(t != null)
      new EventBusOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):EventBusOptions = {
    if(json != null)
      new EventBusOptions(new JEventBusOptions(json))
    else
      null
  }
}
