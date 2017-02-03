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
import io.vertx.mqtt.{MqttWill => JMqttWill}

/**
  * Will information from the remote MQTT client
  */
class MqttWill(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Boolean = _
  private var cached_1: String = _
  private var cached_2: String = _
  private var cached_3: Int = _
  private var cached_4: Boolean = _

  /**
    * @return Will flag for indicating the will message presence
    */
  def isWillFlag(): Boolean = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JMqttWill].isWillFlag()
      cached_0 = tmp.asInstanceOf[Boolean]
    }
    cached_0
  }

  /**
    * @return Topic for the will as provided by the remote MQTT client
    */
  def willTopic(): String = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JMqttWill].willTopic()
      cached_1 = tmp.asInstanceOf[String]
    }
    cached_1
  }

  /**
    * @return Payload for the will as provided by the remote MQTT client
    */
  def willMessage(): String = {
    if (cached_2 == null) {
      val tmp = asJava.asInstanceOf[JMqttWill].willMessage()
      cached_2 = tmp.asInstanceOf[String]
    }
    cached_2
  }

  /**
    * @return QoS level for the will as provided by the remote MQTT client
    */
  def willQos(): Int = {
    if (cached_3 == null) {
      val tmp = asJava.asInstanceOf[JMqttWill].willQos()
      cached_3 = tmp.asInstanceOf[Int]
    }
    cached_3
  }

  /**
    * @return If the will must be retained as provided by the remote MQTT client
    */
  def isWillRetain(): Boolean = {
    if (cached_4 == null) {
      val tmp = asJava.asInstanceOf[JMqttWill].isWillRetain()
      cached_4 = tmp.asInstanceOf[Boolean]
    }
    cached_4
  }

}

object MqttWill {
  def apply(asJava: JMqttWill) = new MqttWill(asJava)  
}
