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

import io.vertx.amqp.{AmqpSenderOptions => JAmqpSenderOptions}
package object amqp{


  type AmqpClientOptions = io.vertx.amqp.AmqpClientOptions
  object AmqpClientOptions {
    def apply() = new AmqpClientOptions()
    def apply(json: JsonObject) = new AmqpClientOptions(json)
  }



  type AmqpReceiverOptions = io.vertx.amqp.AmqpReceiverOptions
  object AmqpReceiverOptions {
    def apply() = new AmqpReceiverOptions()
    def apply(json: JsonObject) = new AmqpReceiverOptions(json)
  }



  type AmqpSenderOptions = io.vertx.amqp.AmqpSenderOptions
  object AmqpSenderOptions {
    def apply() = new AmqpSenderOptions()
    def apply(json: JsonObject) = new AmqpSenderOptions(json)
  }



}
