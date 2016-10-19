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

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Options for configuring the event bus bridge.
  */

class BridgeOptions(val asJava: io.vertx.ext.web.handler.sockjs.BridgeOptions) {
  def setInboundPermitted(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.web.handler.sockjs.PermittedOptions]) = {
    asJava.setInboundPermitted(value.map(_.asJava))
    this
  }
  def addInboundPermitted(value:io.vertx.scala.ext.web.handler.sockjs.PermittedOptions) = {
    asJava.addInboundPermitted(value.asJava)
    this
  }
  def getInboundPermitteds = {
    asJava.getInboundPermitteds()
  }
  def setMaxAddressLength(value:Int) = {
    asJava.setMaxAddressLength(value)
    this
  }
  def getMaxAddressLength = {
    asJava.getMaxAddressLength()
  }
  def setMaxHandlersPerSocket(value:Int) = {
    asJava.setMaxHandlersPerSocket(value)
    this
  }
  def getMaxHandlersPerSocket = {
    asJava.getMaxHandlersPerSocket()
  }
  def setOutboundPermitted(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.web.handler.sockjs.PermittedOptions]) = {
    asJava.setOutboundPermitted(value.map(_.asJava))
    this
  }
  def addOutboundPermitted(value:io.vertx.scala.ext.web.handler.sockjs.PermittedOptions) = {
    asJava.addOutboundPermitted(value.asJava)
    this
  }
  def getOutboundPermitteds = {
    asJava.getOutboundPermitteds()
  }
  def setPingTimeout(value:Long) = {
    asJava.setPingTimeout(value)
    this
  }
  def getPingTimeout = {
    asJava.getPingTimeout()
  }
  def setReplyTimeout(value:Long) = {
    asJava.setReplyTimeout(value)
    this
  }
  def getReplyTimeout = {
    asJava.getReplyTimeout()
  }
}

object BridgeOptions {
  type BridgeOptionsJava = io.vertx.ext.web.handler.sockjs.BridgeOptions
  
  def apply() = {
    new BridgeOptions(new BridgeOptionsJava(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: BridgeOptionsJava) = {
    if(t != null)
      new BridgeOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):BridgeOptions = {
    if(json != null)
      new BridgeOptions(new BridgeOptionsJava(json))
    else
      null
  }
}
