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

package io.vertx.scala.ext.bridge

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._

/**
  * Specify the event bus bridge options.
  */

class BridgeOptions(val asJava: io.vertx.ext.bridge.BridgeOptions) {

  /**
    * Sets the list of inbound permitted options.
    */
  def addInboundPermitted(value:io.vertx.scala.ext.bridge.PermittedOptions) = {
    asJava.addInboundPermitted(value.asJava)
    this
  }
  def setInboundPermitteds(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.bridge.PermittedOptions]) = {
    asJava.setInboundPermitteds(value.map(_.asJava))
    this
  }
  def getInboundPermitteds = {
    asJava.getInboundPermitteds()
  }

  /**
    * Sets the list of outbound permitted options.
    */
  def addOutboundPermitted(value:io.vertx.scala.ext.bridge.PermittedOptions) = {
    asJava.addOutboundPermitted(value.asJava)
    this
  }
  def setOutboundPermitteds(value:scala.collection.mutable.Buffer[io.vertx.scala.ext.bridge.PermittedOptions]) = {
    asJava.setOutboundPermitteds(value.map(_.asJava))
    this
  }
  def getOutboundPermitteds = {
    asJava.getOutboundPermitteds()
  }
}

object BridgeOptions {
  type BridgeOptionsJava = io.vertx.ext.bridge.BridgeOptions
  
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
