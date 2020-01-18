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

package io.vertx.scala.core.datagram

import io.vertx.core.datagram.{DatagramSocketOptions => JDatagramSocketOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.scala.core.net.{NetworkOptions => ExtNetworkOptions}

/**
 * Options used to configure a datagram socket.
 */

class DatagramSocketOptions(private val _asJava: JDatagramSocketOptions) extends ExtNetworkOptions(_asJava) {
  def asJava = _asJava
  /**
   * Set if the socket can send or receive broadcast packets
   */
  def setBroadcast(value: Boolean) = {
    asJava.setBroadcast(value)
    this
  }

  def isBroadcast: Boolean = {
    asJava.isBroadcast().asInstanceOf[Boolean]
  }

  /**
   * Set if IP v6 should be used
   */
  def setIpV6(value: Boolean) = {
    asJava.setIpV6(value)
    this
  }

  def isIpV6: Boolean = {
    asJava.isIpV6().asInstanceOf[Boolean]
  }

  /**
   * Set to true to enabled network activity logging: Netty's pipeline is configured for logging on Netty's logger.
   */
  override def setLogActivity(value: Boolean) = {
    asJava.setLogActivity(value)
    this
  }

  override def getLogActivity: Boolean = {
    asJava.getLogActivity().asInstanceOf[Boolean]
  }

  /**
   * Set if loopback mode is disabled
   */
  def setLoopbackModeDisabled(value: Boolean) = {
    asJava.setLoopbackModeDisabled(value)
    this
  }

  def isLoopbackModeDisabled: Boolean = {
    asJava.isLoopbackModeDisabled().asInstanceOf[Boolean]
  }

  /**
   * Set the multicast network interface address
   */
  def setMulticastNetworkInterface(value: String) = {
    asJava.setMulticastNetworkInterface(value)
    this
  }

  def getMulticastNetworkInterface: String = {
    asJava.getMulticastNetworkInterface().asInstanceOf[String]
  }

  /**
   * Set the multicast ttl value
   */
  def setMulticastTimeToLive(value: Int) = {
    asJava.setMulticastTimeToLive(value)
    this
  }

  def getMulticastTimeToLive: Int = {
    asJava.getMulticastTimeToLive().asInstanceOf[Int]
  }

  /**
   * Set the TCP receive buffer size
   */
  override def setReceiveBufferSize(value: Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }

  override def getReceiveBufferSize: Int = {
    asJava.getReceiveBufferSize().asInstanceOf[Int]
  }

  /**
   * Set the value of reuse address
   */
  override def setReuseAddress(value: Boolean) = {
    asJava.setReuseAddress(value)
    this
  }

  override def isReuseAddress: Boolean = {
    asJava.isReuseAddress().asInstanceOf[Boolean]
  }

  /**
   * Set the value of reuse port.
   * <p/>
   * This is only supported by native transports.
   */
  override def setReusePort(value: Boolean) = {
    asJava.setReusePort(value)
    this
  }

  override def isReusePort: Boolean = {
    asJava.isReusePort().asInstanceOf[Boolean]
  }

  /**
   * Set the TCP send buffer size
   */
  override def setSendBufferSize(value: Int) = {
    asJava.setSendBufferSize(value)
    this
  }

  override def getSendBufferSize: Int = {
    asJava.getSendBufferSize().asInstanceOf[Int]
  }

  /**
   * Set the value of traffic class
   */
  override def setTrafficClass(value: Int) = {
    asJava.setTrafficClass(value)
    this
  }

  override def getTrafficClass: Int = {
    asJava.getTrafficClass().asInstanceOf[Int]
  }

}


object DatagramSocketOptions {

  def apply() = {
    new DatagramSocketOptions(new JDatagramSocketOptions(emptyObj()))
  }

  def apply(t: JDatagramSocketOptions) = {
    if (t != null) {
      new DatagramSocketOptions(t)
    } else {
      new DatagramSocketOptions(new JDatagramSocketOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): DatagramSocketOptions = {
    if (json != null) {
      new DatagramSocketOptions(new JDatagramSocketOptions(json))
    } else {
      new DatagramSocketOptions(new JDatagramSocketOptions(emptyObj()))
    }
  }
}

