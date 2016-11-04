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

package io.vertx.scala.core.eventbus

import io.vertx.core.json.JsonObject
import scala.collection.JavaConversions._
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}

/**
  * Delivery options are used to configure message delivery.
  * 
  * Delivery options allow to configure delivery timeout and message codec name, and to provide any headers
  * that you wish to send with the message.
  */

class DeliveryOptions(val asJava: JDeliveryOptions) {

  /**
    * Set the codec name.
    */
  def setCodecName(value:String) = {
    asJava.setCodecName(value)
    this
  }
  def getCodecName = {
    asJava.getCodecName()
  }

  /**
    * Add a message header.
    * 
    * Message headers can be sent with any message and will be accessible with [[io.vertx.scala.core.eventbus.Message]]
    * at the recipient.
    */
  def addHeader(key: String, value:String) = {
    asJava.addHeader(key, value)
    this
  }

  /**
    * Set the send timeout.
    */
  def setSendTimeout(value:Long) = {
    asJava.setSendTimeout(value)
    this
  }
  def getSendTimeout = {
    asJava.getSendTimeout()
  }
}

object DeliveryOptions {
  
  def apply() = {
    new DeliveryOptions(new JDeliveryOptions(io.vertx.lang.scala.json.Json.emptyObj()))
  }
  
  def apply(t: JDeliveryOptions) = {
    if(t != null)
      new DeliveryOptions(t)
    else
      null
  }
  
  def fromJson(json: JsonObject):DeliveryOptions = {
    if(json != null)
      new DeliveryOptions(new JDeliveryOptions(json))
    else
      null
  }
}
