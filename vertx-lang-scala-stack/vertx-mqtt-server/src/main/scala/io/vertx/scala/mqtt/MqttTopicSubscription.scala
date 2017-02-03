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

package io.vertx.scala.mqtt

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.netty.handler.codec.mqtt.MqttQoS
import io.vertx.mqtt.{MqttTopicSubscription => JMqttTopicSubscription}

/**
  * Represents a subscription to a topic
  */
class MqttTopicSubscription(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: String = _
  private var cached_1: io.netty.handler.codec.mqtt.MqttQoS = _

  /**
    * @return Subscription topic name
    */
  def topicName(): String = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JMqttTopicSubscription].topicName()
      cached_0 = tmp.asInstanceOf[String]
    }
    cached_0
  }

  /**
    * @return Quality of Service level for the subscription
    */
  def qualityOfService(): io.netty.handler.codec.mqtt.MqttQoS = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JMqttTopicSubscription].qualityOfService()
      cached_1 = tmp
    }
    cached_1
  }

}

object MqttTopicSubscription {
  def apply(asJava: JMqttTopicSubscription) = new MqttTopicSubscription(asJava)  
}
