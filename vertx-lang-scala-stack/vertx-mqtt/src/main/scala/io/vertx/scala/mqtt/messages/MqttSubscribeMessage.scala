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
import io.vertx.mqtt.messages.{MqttSubscribeMessage => JMqttSubscribeMessage}
import io.vertx.scala.mqtt.MqttTopicSubscription
import io.vertx.mqtt.{MqttTopicSubscription => JMqttTopicSubscription}
import io.vertx.mqtt.messages.{MqttMessage => JMqttMessage}
import scala.collection.JavaConverters._

/**
  * Represents an MQTT SUBSCRIBE message
  */
class MqttSubscribeMessage(private val _asJava: Object)
    extends  MqttMessage  {

  def asJava = _asJava
  private var cached_0: Option[Int] = None
  private var cached_1: Option[scala.collection.mutable.Buffer[MqttTopicSubscription]] = None

  /**
    * @return Message identifier
    */
  override def messageId(): Int = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JMqttSubscribeMessage].messageId()
      cached_0 = Some(tmp.asInstanceOf[Int])
    }
    cached_0.get
  }

  /**
    * @return List with topics and related quolity of service levels
    */
  def topicSubscriptions(): scala.collection.mutable.Buffer[MqttTopicSubscription] = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JMqttSubscribeMessage].topicSubscriptions()
      cached_1 = Some(tmp.asScala.map(x => MqttTopicSubscription(x)))
    }
    cached_1.get
  }

}

object MqttSubscribeMessage {
  def apply(asJava: JMqttSubscribeMessage) = new MqttSubscribeMessage(asJava)  
}
