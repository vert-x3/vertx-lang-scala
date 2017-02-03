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

package io.vertx.scala.ext.stomp

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.scala.ext.bridge.{BridgeOptions => ExtBridgeOptions}
import io.vertx.scala.ext.bridge.PermittedOptions
import io.vertx.ext.stomp.{BridgeOptions => JBridgeOptions}
import io.vertx.ext.bridge.{PermittedOptions => JPermittedOptions}

/**
  * Specify the event bus bridge options.
  */
class BridgeOptions(private val _asJava: JBridgeOptions) 
    extends ExtBridgeOptions(_asJava) {

  override def asJava = _asJava
  override def addInboundPermitted(value: PermittedOptions) = {
    asJava.addInboundPermitted(value.asJava)
    this
  }
  override def setInboundPermitteds(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setInboundPermitteds(value.map(_.asJava).asJava)
    this
  }
  override def getInboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getInboundPermitteds().asScala.map(x => PermittedOptions(x))
  }
  override def addOutboundPermitted(value: PermittedOptions) = {
    asJava.addOutboundPermitted(value.asJava)
    this
  }
  override def setOutboundPermitteds(value: scala.collection.mutable.Buffer[PermittedOptions]) = {
    asJava.setOutboundPermitteds(value.map(_.asJava).asJava)
    this
  }
  override def getOutboundPermitteds: scala.collection.mutable.Buffer[PermittedOptions] = {
    asJava.getOutboundPermitteds().asScala.map(x => PermittedOptions(x))
  }
  def setPointToPoint(value: Boolean) = {
    asJava.setPointToPoint(value)
    this
  }
  def isPointToPoint: Boolean = {
    asJava.isPointToPoint().asInstanceOf[Boolean]
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
      null
    }
  }
  
  def fromJson(json: JsonObject): BridgeOptions = {
    if (json != null) {
      new BridgeOptions(new JBridgeOptions(json))
    } else {
      null
    }
  }
}
