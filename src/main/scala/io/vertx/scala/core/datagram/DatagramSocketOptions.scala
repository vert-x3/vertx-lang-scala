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

class DatagramSocketOptions(val java: io.vertx.core.datagram.DatagramSocketOptions) {
  def setBroadcast(value:Boolean) = {
    java.setBroadcast(value)
    this
  }
  def isBroadcast = {
    java.isBroadcast()
  }
  def setIpV6(value:Boolean) = {
    java.setIpV6(value)
    this
  }
  def isIpV6 = {
    java.isIpV6()
  }
  def setLogActivity(value:Boolean) = {
    java.setLogActivity(value)
    this
  }
  def getLogActivity = {
    java.getLogActivity()
  }
  def setLoopbackModeDisabled(value:Boolean) = {
    java.setLoopbackModeDisabled(value)
    this
  }
  def isLoopbackModeDisabled = {
    java.isLoopbackModeDisabled()
  }
  def setMulticastNetworkInterface(value:String) = {
    java.setMulticastNetworkInterface(value)
    this
  }
  def getMulticastNetworkInterface = {
    java.getMulticastNetworkInterface()
  }
  def setMulticastTimeToLive(value:Int) = {
    java.setMulticastTimeToLive(value)
    this
  }
  def getMulticastTimeToLive = {
    java.getMulticastTimeToLive()
  }
  def setReceiveBufferSize(value:Int) = {
    java.setReceiveBufferSize(value)
    this
  }
  def getReceiveBufferSize = {
    java.getReceiveBufferSize()
  }
  def setReuseAddress(value:Boolean) = {
    java.setReuseAddress(value)
    this
  }
  def isReuseAddress = {
    java.isReuseAddress()
  }
  def setSendBufferSize(value:Int) = {
    java.setSendBufferSize(value)
    this
  }
  def getSendBufferSize = {
    java.getSendBufferSize()
  }
  def setTrafficClass(value:Int) = {
    java.setTrafficClass(value)
    this
  }
  def getTrafficClass = {
    java.getTrafficClass()
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
