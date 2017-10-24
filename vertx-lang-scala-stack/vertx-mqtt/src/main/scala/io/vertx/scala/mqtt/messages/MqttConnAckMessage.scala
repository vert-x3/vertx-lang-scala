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

package io.vertx.scala.mqtt.messages

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.netty.handler.codec.mqtt.MqttConnectReturnCode
import io.vertx.mqtt.messages.{MqttConnAckMessage => JMqttConnAckMessage}

/**
  * Represents an MQTT CONNACK message
  */
class MqttConnAckMessage(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[io.netty.handler.codec.mqtt.MqttConnectReturnCode] = None
  private var cached_1: Option[Boolean] = None


  /**
    * @return return code from the connection request
    */
  def code(): io.netty.handler.codec.mqtt.MqttConnectReturnCode = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JMqttConnAckMessage].code()
      cached_0 = Some(tmp)
    }
    cached_0.get
  }

  /**
    * @return is an old session is present
    */
  def isSessionPresent(): Boolean = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JMqttConnAckMessage].isSessionPresent()
      cached_1 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_1.get
  }

}

object MqttConnAckMessage {
  def apply(asJava: JMqttConnAckMessage) = new MqttConnAckMessage(asJava)  
  /**
    * Create a concrete instance of a Vert.x connack message
    * @param code return code from the connection request
    * @param isSessionPresent is an old session is present
    * @return 
    */
  def create(code: io.netty.handler.codec.mqtt.MqttConnectReturnCode, isSessionPresent: Boolean): MqttConnAckMessage = {
    MqttConnAckMessage(JMqttConnAckMessage.create(code, isSessionPresent.asInstanceOf[java.lang.Boolean]))
  }

}
