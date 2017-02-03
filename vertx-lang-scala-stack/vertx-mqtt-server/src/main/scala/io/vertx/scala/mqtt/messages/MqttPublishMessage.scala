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
import io.netty.handler.codec.mqtt.MqttQoS
import io.vertx.core.buffer.Buffer
import io.vertx.mqtt.messages.{MqttMessage => JMqttMessage}
import io.vertx.mqtt.messages.{MqttPublishMessage => JMqttPublishMessage}

/**
  * Represents an MQTT PUBLISH message
  */
class MqttPublishMessage(private val _asJava: Object)
    extends  MqttMessage {

  def asJava = _asJava
  private var cached_0: Int = _
  private var cached_1: io.netty.handler.codec.mqtt.MqttQoS = _
  private var cached_2: Boolean = _
  private var cached_3: Boolean = _
  private var cached_4: String = _
  private var cached_5: io.vertx.core.buffer.Buffer = _

  /**
    * @return Message identifier
    */
  override def messageId(): Int = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].messageId()
      cached_0 = tmp.asInstanceOf[Int]
    }
    cached_0
  }

  /**
    * @return Quality of service level
    */
  def qosLevel(): io.netty.handler.codec.mqtt.MqttQoS = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].qosLevel()
      cached_1 = tmp
    }
    cached_1
  }

  /**
    * @return If the message is a duplicate
    */
  def isDup(): Boolean = {
    if (cached_2 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].isDup()
      cached_2 = tmp.asInstanceOf[Boolean]
    }
    cached_2
  }

  /**
    * @return If the message needs to be retained
    */
  def isRetain(): Boolean = {
    if (cached_3 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].isRetain()
      cached_3 = tmp.asInstanceOf[Boolean]
    }
    cached_3
  }

  /**
    * @return Topic on which the message was published
    */
  def topicName(): String = {
    if (cached_4 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].topicName()
      cached_4 = tmp.asInstanceOf[String]
    }
    cached_4
  }

  /**
    * @return Payload message
    */
  def payload(): io.vertx.core.buffer.Buffer = {
    if (cached_5 == null) {
      val tmp = asJava.asInstanceOf[JMqttPublishMessage].payload()
      cached_5 = tmp
    }
    cached_5
  }

}

object MqttPublishMessage {
  def apply(asJava: JMqttPublishMessage) = new MqttPublishMessage(asJava)  
}
