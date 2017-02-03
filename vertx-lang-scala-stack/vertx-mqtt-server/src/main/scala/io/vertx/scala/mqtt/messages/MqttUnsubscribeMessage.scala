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
import io.vertx.mqtt.messages.{MqttMessage => JMqttMessage}
import scala.collection.JavaConverters._
import io.vertx.mqtt.messages.{MqttUnsubscribeMessage => JMqttUnsubscribeMessage}

/**
  * Represents an MQTT UNSUBSCRIBE message
  */
class MqttUnsubscribeMessage(private val _asJava: Object)
    extends  MqttMessage {

  def asJava = _asJava
  private var cached_0: Int = _
  private var cached_1: scala.collection.mutable.Buffer[String] = _

  /**
    * @return Message identifier
    */
  override def messageId(): Int = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JMqttUnsubscribeMessage].messageId()
      cached_0 = tmp.asInstanceOf[Int]
    }
    cached_0
  }

  /**
    * @return List of topics to unsubscribe
    */
  def topics(): scala.collection.mutable.Buffer[String] = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JMqttUnsubscribeMessage].topics()
      cached_1 = tmp.asScala.map(x => x.asInstanceOf[String])
    }
    cached_1
  }

}

object MqttUnsubscribeMessage {
  def apply(asJava: JMqttUnsubscribeMessage) = new MqttUnsubscribeMessage(asJava)  
}
