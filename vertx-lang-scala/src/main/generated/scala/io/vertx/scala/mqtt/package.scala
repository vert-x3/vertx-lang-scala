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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import java.util.concurrent.TimeUnit
import io.vertx.core.buffer.Buffer
import io.vertx.mqtt.{MqttServerOptions => JMqttServerOptions}
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.http.ClientAuth
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net
import io.vertx.core.net.{JksOptions => JJksOptions}
import io.vertx.core.net.{NetServerOptions => JNetServerOptions}
package object mqtt{


  type MqttAuth = io.vertx.mqtt.MqttAuth
  object MqttAuth {
    def apply(json: JsonObject) = new MqttAuth(json)
  }



  type MqttClientOptions = io.vertx.mqtt.MqttClientOptions
  object MqttClientOptions {
    def apply() = new MqttClientOptions()
    def apply(json: JsonObject) = new MqttClientOptions(json)
  }



  type MqttServerOptions = io.vertx.mqtt.MqttServerOptions
  object MqttServerOptions {
    def apply() = new MqttServerOptions()
    def apply(json: JsonObject) = new MqttServerOptions(json)
  }



  type MqttWill = io.vertx.mqtt.MqttWill
  object MqttWill {
    def apply(json: JsonObject) = new MqttWill(json)
  }



}
