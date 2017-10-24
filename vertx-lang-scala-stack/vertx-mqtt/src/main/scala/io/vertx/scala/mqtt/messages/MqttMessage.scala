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

/**
  * Represent the interface for each MQTT message
  */
trait MqttMessage {

  def asJava: java.lang.Object

  /**
    * @return Message identifier
    */
  def messageId(): Int

}

object MqttMessage {
  def apply(asJava: JMqttMessage): MqttMessage = new MqttMessageImpl(asJava)
    private class MqttMessageImpl(private val _asJava: Object) extends MqttMessage {

      def asJava = _asJava
  private var cached_0: Option[Int] = None


  /**
    * @return Message identifier
    */
  def messageId(): Int = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JMqttMessage].messageId()
      cached_0 = Some(tmp.asInstanceOf[Int])
    }
    cached_0.get
  }

}
}
