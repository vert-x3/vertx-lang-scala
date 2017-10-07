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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.mqtt.{MqttAuth => JMqttAuth}

/**
  * MQTT authentication information
  */
class MqttAuth(private val _asJava: JMqttAuth) {

  def asJava = _asJava
}

object MqttAuth {
  
  def apply() = {
    new MqttAuth(new JMqttAuth(emptyObj()))
  }
  
  def apply(t: JMqttAuth) = {
    if (t != null) {
      new MqttAuth(t)
    } else {
      new MqttAuth(new JMqttAuth(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MqttAuth = {
    if (json != null) {
      new MqttAuth(new JMqttAuth(json))
    } else {
      new MqttAuth(new JMqttAuth(emptyObj()))
    }
  }
}
