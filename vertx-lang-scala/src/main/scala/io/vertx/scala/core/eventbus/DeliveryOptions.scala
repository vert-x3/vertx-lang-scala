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

import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Delivery options are used to configure message delivery.
 * 
 * Delivery options allow to configure delivery timeout and message codec name, and to provide any headers
 * that you wish to send with the message.
 */

class DeliveryOptions(private val _asJava: JDeliveryOptions) {
  def asJava = _asJava
  /**
   * Set the codec name.
   */
  def setCodecName(value: String) = {
    asJava.setCodecName(value)
    this
  }

  def getCodecName: String = {
    asJava.getCodecName().asInstanceOf[String]
  }

  /**
   * Add a message header.
   * 
   * Message headers can be sent with any message and will be accessible with [[io.vertx.scala.core.eventbus.Message]]
   * at the recipient.
   */
  def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Whether a message should be delivered to local consumers only. Defaults to `false`.
   *
   * 
   * <strong>This option is effective in clustered mode only and does not apply to reply messages</strong>.
   */
  def setLocalOnly(value: Boolean) = {
    asJava.setLocalOnly(value)
    this
  }

  def isLocalOnly: Boolean = {
    asJava.isLocalOnly().asInstanceOf[Boolean]
  }

  /**
   * Set the send timeout.
   */
  def setSendTimeout(value: Long) = {
    asJava.setSendTimeout(value)
    this
  }

  def getSendTimeout: Long = {
    asJava.getSendTimeout().asInstanceOf[Long]
  }

}


object DeliveryOptions {
  
  def apply() = {
    new DeliveryOptions(new JDeliveryOptions(emptyObj()))
  }
  
  def apply(t: JDeliveryOptions) = {
    if (t != null) {
      new DeliveryOptions(t)
    } else {
      new DeliveryOptions(new JDeliveryOptions(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DeliveryOptions = {
    if (json != null) {
      new DeliveryOptions(new JDeliveryOptions(json))
    } else {
      new DeliveryOptions(new JDeliveryOptions(emptyObj()))
    }
  }
}

