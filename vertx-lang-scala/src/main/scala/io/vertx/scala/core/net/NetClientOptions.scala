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

package io.vertx.scala.core.net

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.scala.core.buffer.Buffer

/**
  * Options for configuring a [[io.vertx.scala.core.net.NetClient]].
  */
class NetClientOptions(private val _asJava: JNetClientOptions) 
    extends ClientOptionsBase {

  def asJava = _asJava

  /**
    * Set the connect timeout
    */
  override def setConnectTimeout(value: Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  override def getConnectTimeout: Int = {
    asJava.getConnectTimeout()
  }

  /**
    * Add a CRL path
    */
  override def addCrlPath(value: String) = {
    asJava.addCrlPath(value)
    this
  }
  override def getCrlPaths: scala.collection.mutable.Buffer[String] = {
    asJava.getCrlPaths().asScala.map(x => x)
  }

  /**
    * Add a CRL value
    */
  override def addCrlValue(value: Buffer) = {
    asJava.addCrlValue(value.asInstanceOf)
    this
  }
  override def getCrlValues: scala.collection.mutable.Buffer[Buffer] = {
    asJava.getCrlValues().asScala.map(x => Buffer(x))
  }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  override def addEnabledCipherSuite(value: String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  override def getEnabledCipherSuites: scala.collection.mutable.Set[String] = {
    asJava.getEnabledCipherSuites().asScala.map(x => x)
  }

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  override def addEnabledSecureTransportProtocol(value: String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  override def getEnabledSecureTransportProtocols: scala.collection.mutable.Set[String] = {
    asJava.getEnabledSecureTransportProtocols().asScala.map(x => x)
  }

  /**
    * Set the hostname verification algorithm interval
    * To disable hostname verification, set hostnameVerificationAlgorithm to an empty String
    */
  def setHostnameVerificationAlgorithm(value: String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }
  def getHostnameVerificationAlgorithm: String = {
    asJava.getHostnameVerificationAlgorithm()
  }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  override def setIdleTimeout(value: Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  override def getIdleTimeout: Int = {
    asJava.getIdleTimeout()
  }
  override def setJdkSslEngineOptions(value: JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  override def setKeyStoreOptions(value: JksOptions) = {
    asJava.setKeyStoreOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the local interface to bind for network connections. When the local address is null,
    * it will pick any local address, the default local address is null.
    */
  override def setLocalAddress(value: String) = {
    asJava.setLocalAddress(value)
    this
  }
  override def getLocalAddress: String = {
    asJava.getLocalAddress()
  }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  override def getLogActivity: Boolean = {
    asJava.getLogActivity()
  }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
  override def setMetricsName(value: String) = {
    asJava.setMetricsName(value)
    this
  }
  override def getMetricsName: String = {
    asJava.getMetricsName()
  }
  override def setOpenSslEngineOptions(value: OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the key/cert store options in pem format.
    */
  override def setPemKeyCertOptions(value: PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the trust options in pem format
    */
  override def setPemTrustOptions(value: PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the key/cert options in pfx format.
    */
  override def setPfxKeyCertOptions(value: PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the trust options in pfx format
    */
  override def setPfxTrustOptions(value: PfxOptions) = {
    asJava.setPfxTrustOptions(value.asInstanceOf)
    this
  }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
  override def setProxyOptions(value: ProxyOptions) = {
    asJava.setProxyOptions(value.asInstanceOf)
    this
  }
  override def getProxyOptions: ProxyOptions = {
    ProxyOptions(asJava.getProxyOptions())
  }

  /**
    * Set the TCP receive buffer size
    */
  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize()
  }

  /**
    * Set the value of reconnect attempts
    */
  def setReconnectAttempts(value: Int) = {
    asJava.setReconnectAttempts(value)
    this
  }
  def getReconnectAttempts: Int = {
    asJava.getReconnectAttempts()
  }

  /**
    * Set the reconnect interval
    */
  def setReconnectInterval(value: Long) = {
    asJava.setReconnectInterval(value)
    this
  }
  def getReconnectInterval: Long = {
    asJava.getReconnectInterval()
  }

  /**
    * Set the value of reuse address
    */
  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress()
  }

  /**
    * Set the TCP send buffer size
    */
  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize()
  }

  /**
    * Set whether SO_linger keep alive is enabled
    */
  override def setSoLinger(value: Int) = {
    asJava.setSoLinger(value)
    this
  }
  override def getSoLinger: Int = {
    asJava.getSoLinger()
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  override def setSsl(value: Boolean) = {
    asJava.setSsl(value)
    this
  }
  override def isSsl: Boolean = {
    asJava.isSsl()
  }

  /**
    * Set whether TCP keep alive is enabled
    */
  override def setTcpKeepAlive(value: Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  override def isTcpKeepAlive: Boolean = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set whether TCP no delay is enabled
    */
  override def setTcpNoDelay(value: Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  override def isTcpNoDelay: Boolean = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set the value of traffic class
    */
  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }
  override def getTrafficClass: Int = {
    asJava.getTrafficClass()
  }

  /**
    * Set whether all server certificates should be trusted
    */
  override def setTrustAll(value: Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  override def isTrustAll: Boolean = {
    asJava.isTrustAll()
  }

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  override def setTrustStoreOptions(value: JksOptions) = {
    asJava.setTrustStoreOptions(value.asInstanceOf)
    this
  }

  /**
    * Set the ALPN usage.
    */
  override def setUseAlpn(value: Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  override def isUseAlpn: Boolean = {
    asJava.isUseAlpn()
  }

  /**
    * Set whether Netty pooled buffers are enabled
    */
  override def setUsePooledBuffers(value: Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  override def isUsePooledBuffers: Boolean = {
    asJava.isUsePooledBuffers()
  }
}

object NetClientOptions {
  
  def apply() = {
    new NetClientOptions(new JNetClientOptions(emptyObj()))
  }
  
  def apply(t: JNetClientOptions) = {
    if(t != null)
      new NetClientOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):NetClientOptions = {
    if(json != null)
      new NetClientOptions(new JNetClientOptions(json))
    else
      null
  }
}
