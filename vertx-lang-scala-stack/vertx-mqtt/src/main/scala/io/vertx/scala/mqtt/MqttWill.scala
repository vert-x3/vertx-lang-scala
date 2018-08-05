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

import io.vertx.mqtt.{MqttWill => JMqttWill}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Will information from the remote MQTT client

 */

class MqttWill(private val _asJava: JMqttWill) {
  def asJava = _asJava
  /**

   */
  /**

   */
}


object MqttWill {
  
  def apply() = {
    new MqttWill(new JMqttWill(emptyObj()))
  }
  
  def apply(t: JMqttWill) = {
    if (t != null) {
      new MqttWill(t)
    } else {
      new MqttWill(new JMqttWill(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MqttWill = {
    if (json != null) {
      new MqttWill(new JMqttWill(json))
    } else {
      new MqttWill(new JMqttWill(emptyObj()))
    }
  }
}

