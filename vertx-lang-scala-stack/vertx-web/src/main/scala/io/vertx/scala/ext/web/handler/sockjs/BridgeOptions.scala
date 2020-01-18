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

import io.vertx.scala.ext.bridge.PermittedOptions
import io.vertx.ext.web.handler.sockjs.{BridgeOptions => JBridgeOptions}
import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Options for configuring the event bus bridge.
 */

class BridgeOptions(private val _asJava: JBridgeOptions) {
  def asJava = _asJava
  def setInboundPermitted(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setInboundPermitted(value.map(_.asJava).asJava)
    this
  }

  def addInboundPermitted(value: PermittedOptions) = {
    asJava.addInboundPermitted(value.asJava)
    this
  }

  def getInboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getInboundPermitteds().asScala.map(x => PermittedOptions(x))
  }

  def setMaxAddressLength(value: Int) = {
    asJava.setMaxAddressLength(value)
    this
  }

  def getMaxAddressLength: Int = {
    asJava.getMaxAddressLength().asInstanceOf[Int]
  }

  def setMaxHandlersPerSocket(value: Int) = {
    asJava.setMaxHandlersPerSocket(value)
    this
  }

  def getMaxHandlersPerSocket: Int = {
    asJava.getMaxHandlersPerSocket().asInstanceOf[Int]
  }

  def setOutboundPermitted(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setOutboundPermitted(value.map(_.asJava).asJava)
    this
  }

  def addOutboundPermitted(value: PermittedOptions) = {
    asJava.addOutboundPermitted(value.asJava)
    this
  }

  def getOutboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getOutboundPermitteds().asScala.map(x => PermittedOptions(x))
  }

  def setPingTimeout(value: Long) = {
    asJava.setPingTimeout(value)
    this
  }

  def getPingTimeout: Long = {
    asJava.getPingTimeout().asInstanceOf[Long]
  }

  def setReplyTimeout(value: Long) = {
    asJava.setReplyTimeout(value)
    this
  }

  def getReplyTimeout: Long = {
    asJava.getReplyTimeout().asInstanceOf[Long]
  }

}


object BridgeOptions {

  def apply() = {
    new BridgeOptions(new JBridgeOptions(emptyObj()))
  }

  def apply(t: JBridgeOptions) = {
    if (t != null) {
      new BridgeOptions(t)
    } else {
      new BridgeOptions(new JBridgeOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): BridgeOptions = {
    if (json != null) {
      new BridgeOptions(new JBridgeOptions(json))
    } else {
      new BridgeOptions(new JBridgeOptions(emptyObj()))
    }
  }
}

