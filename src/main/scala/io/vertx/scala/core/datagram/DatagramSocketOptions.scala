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
  def setBroadcast(value:Boolean) = {
    asJava.setBroadcast(value)
    this
  }
  def isBroadcast = {
    asJava.isBroadcast()
  }
  def setIpV6(value:Boolean) = {
    asJava.setIpV6(value)
    this
  }
  def isIpV6 = {
    asJava.isIpV6()
  }
  def setLogActivity(value:Boolean) = {
    asJava.setLogActivity(value)
    this
  }
  def getLogActivity = {
    asJava.getLogActivity()
  }
  def setLoopbackModeDisabled(value:Boolean) = {
    asJava.setLoopbackModeDisabled(value)
    this
  }
  def isLoopbackModeDisabled = {
    asJava.isLoopbackModeDisabled()
  }
  def setMulticastNetworkInterface(value:String) = {
    asJava.setMulticastNetworkInterface(value)
    this
  }
  def getMulticastNetworkInterface = {
    asJava.getMulticastNetworkInterface()
  }
  def setMulticastTimeToLive(value:Int) = {
    asJava.setMulticastTimeToLive(value)
    this
  }
  def getMulticastTimeToLive = {
    asJava.getMulticastTimeToLive()
  }
  def setReceiveBufferSize(value:Int) = {
    asJava.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    asJava.getReceiveBufferSize()
  }
  def setReuseAddress(value:Boolean) = {
    asJava.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    asJava.isReuseAddress()
  }
  def setSendBufferSize(value:Int) = {
    asJava.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    asJava.getSendBufferSize()
  }
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
