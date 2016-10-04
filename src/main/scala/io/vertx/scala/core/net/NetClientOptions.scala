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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options for configuring a [[io.vertx.scala.core.net.NetClient]].
  */

class NetClientOptions(val asJava: io.vertx.core.net.NetClientOptions) {

  /**
    * Set the connect timeout
    */
  def setConnectTimeout(value:Int) = {
    asJava.setConnectTimeout(value)
    this
  }
  def getConnectTimeout = {
    asJava.getConnectTimeout()
  }

  /**
    * Add a CRL path
    */
  def addCrlPath(value:String) = {
    asJava.addCrlPath(value)
    this
  }
  def getCrlPaths = {
    asJava.getCrlPaths()
  }

  /**
    * Add a CRL value
    */
  def addCrlValue(value:io.vertx.core.buffer.Buffer) = {
    asJava.addCrlValue(value)
    this
  }
  def getCrlValues = {
    asJava.getCrlValues()
  }

  /**
    * Add an enabled cipher suite, appended to the ordered suites.
    */
  def addEnabledCipherSuite(value:String) = {
    asJava.addEnabledCipherSuite(value)
    this
  }
  def getEnabledCipherSuites = {
    asJava.getEnabledCipherSuites()
  }

  /**
    * Add an enabled SSL/TLS protocols, appended to the ordered protocols.
    */
  def addEnabledSecureTransportProtocol(value:String) = {
    asJava.addEnabledSecureTransportProtocol(value)
    this
  }
  def getEnabledSecureTransportProtocols = {
    asJava.getEnabledSecureTransportProtocols()
  }

  /**
    * Set the hostname verification algorithm interval
    * To disable hostname verification, set hostnameVerificationAlgorithm to an empty String
    */
  def setHostnameVerificationAlgorithm(value:String) = {
    asJava.setHostnameVerificationAlgorithm(value)
    this
  }
  def getHostnameVerificationAlgorithm = {
    asJava.getHostnameVerificationAlgorithm()
  }

  /**
    * Set the idle timeout, in seconds. zero means don't timeout.
    * This determines if a connection will timeout and be closed if no data is received within the timeout.
    */
  def setIdleTimeout(value:Int) = {
    asJava.setIdleTimeout(value)
    this
  }
  def getIdleTimeout = {
    asJava.getIdleTimeout()
  }
  def setJdkSslEngineOptions(value:io.vertx.scala.core.net.JdkSSLEngineOptions) = {
    asJava.setJdkSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in jks format, aka Java keystore.
    */
  def setKeyStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setKeyStoreOptions(value.asJava)
    this
  }

  /**
    * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
    */
  def setLogActivity(value:Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }

  /**
    * Set the metrics name identifying the reported metrics, useful for grouping metrics
    * with the same name.
    */
  def setMetricsName(value:String) = {
    asJava.setMetricsName(value)
    this
  }
  def getMetricsName = {
    asJava.getMetricsName()
  }
  def setOpenSslEngineOptions(value:io.vertx.scala.core.net.OpenSSLEngineOptions) = {
    asJava.setOpenSslEngineOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert store options in pem format.
    */
  def setPemKeyCertOptions(value:io.vertx.scala.core.net.PemKeyCertOptions) = {
    asJava.setPemKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pem format
    */
  def setPemTrustOptions(value:io.vertx.scala.core.net.PemTrustOptions) = {
    asJava.setPemTrustOptions(value.asJava)
    this
  }

  /**
    * Set the key/cert options in pfx format.
    */
  def setPfxKeyCertOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxKeyCertOptions(value.asJava)
    this
  }

  /**
    * Set the trust options in pfx format
    */
  def setPfxTrustOptions(value:io.vertx.scala.core.net.PfxOptions) = {
    asJava.setPfxTrustOptions(value.asJava)
    this
  }

  /**
    * Set proxy options for connections via CONNECT proxy (e.g. Squid) or a SOCKS proxy.
    */
  def setProxyOptions(value:io.vertx.scala.core.net.ProxyOptions) = {
    asJava.setProxyOptions(value.asJava)
    this
  }
  def getProxyOptions = {
    asJava.getProxyOptions()
  }

  /**
    * Set the TCP receive buffer size
    */
  def setReceiveBufferSize(value:Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }

  /**
    * Set the value of reconnect attempts
    */
  def setReconnectAttempts(value:Int) = {
    asJava.setReconnectAttempts(value)
    this
  }
  def getReconnectAttempts = {
    asJava.getReconnectAttempts()
  }

  /**
    * Set the reconnect interval
    */
  def setReconnectInterval(value:Long) = {
    asJava.setReconnectInterval(value)
    this
  }
  def getReconnectInterval = {
    asJava.getReconnectInterval()
  }

  /**
    * Set the value of reuse address
    */
  def setReuseAddress(value:Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }

  /**
    * Set the TCP send buffer size
    */
  def setSendBufferSize(value:Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }

  /**
    * Set whether SO_linger keep alive is enabled
    */
  def setSoLinger(value:Int) = {
    asJava.setSoLinger(value)
    this
  }
  def getSoLinger = {
    asJava.getSoLinger()
  }

  /**
    * Set whether SSL/TLS is enabled
    */
  def setSsl(value:Boolean) = {
    asJava.setSsl(value)
    this
  }
  def isSsl = {
    asJava.isSsl()
  }

  /**
    * Set whether TCP keep alive is enabled
    */
  def setTcpKeepAlive(value:Boolean) = {
    asJava.setTcpKeepAlive(value)
    this
  }
  def isTcpKeepAlive = {
    asJava.isTcpKeepAlive()
  }

  /**
    * Set whether TCP no delay is enabled
    */
  def setTcpNoDelay(value:Boolean) = {
    asJava.setTcpNoDelay(value)
    this
  }
  def isTcpNoDelay = {
    asJava.isTcpNoDelay()
  }

  /**
    * Set the value of traffic class
    */
  def setTrafficClass(value:Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }

  /**
    * Set whether all server certificates should be trusted
    */
  def setTrustAll(value:Boolean) = {
    asJava.setTrustAll(value)
    this
  }
  def isTrustAll = {
    asJava.isTrustAll()
  }

  /**
    * Set the trust options in jks format, aka Java trustore
    */
  def setTrustStoreOptions(value:io.vertx.scala.core.net.JksOptions) = {
    asJava.setTrustStoreOptions(value.asJava)
    this
  }

  /**
    * Set the ALPN usage.
    */
  def setUseAlpn(value:Boolean) = {
    asJava.setUseAlpn(value)
    this
  }
  def isUseAlpn = {
    asJava.isUseAlpn()
  }

  /**
    * Set whether Netty pooled buffers are enabled
    */
  def setUsePooledBuffers(value:Boolean) = {
    asJava.setUsePooledBuffers(value)
    this
  }
  def isUsePooledBuffers = {
    asJava.isUsePooledBuffers()
  }
}

object NetClientOptions {
  type NetClientOptionsJava = io.vertx.core.net.NetClientOptions
  
  def apply() = {
    new NetClientOptions(new NetClientOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
   
  }
  
  def apply(t: NetClientOptionsJava) = {
    if(t != null)
      new NetClientOptions(t)
    else
      null
   
  }
  
  def fromJson(json: JsonObject):NetClientOptions = {
    if(json != null)
      new NetClientOptions(new NetClientOptionsJava(json))
    else
      null
  }
}
