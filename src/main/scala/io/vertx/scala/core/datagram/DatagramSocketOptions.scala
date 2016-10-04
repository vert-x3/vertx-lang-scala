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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options used to configure a datagram socket.
  */

class DatagramSocketOptions(val asJava: io.vertx.core.datagram.DatagramSocketOptions) {

  /**
    * Set if the socket can receive broadcast packets
    */
  def setBroadcast(value:Boolean) = {
    asJava.setBroadcast(value)
    this
  }
  def isBroadcast = {
    asJava.isBroadcast()
  }

  /**
    * Set if IP v6 should be used
    */
  def setIpV6(value:Boolean) = {
    asJava.setIpV6(value)
    this
  }
  def isIpV6 = {
    asJava.isIpV6()
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
    * Set if loopback mode is disabled
    */
  def setLoopbackModeDisabled(value:Boolean) = {
    asJava.setLoopbackModeDisabled(value)
    this
  }
  def isLoopbackModeDisabled = {
    asJava.isLoopbackModeDisabled()
  }

  /**
    * Set the multicast network interface address
    */
  def setMulticastNetworkInterface(value:String) = {
    asJava.setMulticastNetworkInterface(value)
    this
  }
  def getMulticastNetworkInterface = {
    asJava.getMulticastNetworkInterface()
  }

  /**
    * Set the multicast ttl value
    */
  def setMulticastTimeToLive(value:Int) = {
    asJava.setMulticastTimeToLive(value)
    this
  }
  def getMulticastTimeToLive = {
    asJava.getMulticastTimeToLive()
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
    * Set the value of traffic class
    */
  def setTrafficClass(value:Int) = {
    asJava.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    asJava.getTrafficClass()
  }
}

object DatagramSocketOptions {
  type DatagramSocketOptionsJava = io.vertx.core.datagram.DatagramSocketOptions
  
  def apply() = {
    new DatagramSocketOptions(new DatagramSocketOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: DatagramSocketOptionsJava) = {
    if(t != null)
      new DatagramSocketOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DatagramSocketOptions = {
    if(json != null)
      new DatagramSocketOptions(new DatagramSocketOptionsJava(json))
    else
      null
  }
}
