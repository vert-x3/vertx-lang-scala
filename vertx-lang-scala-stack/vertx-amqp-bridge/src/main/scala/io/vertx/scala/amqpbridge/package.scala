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

import io.vertx.amqpbridge.{AmqpBridgeOptions => JAmqpBridgeOptions}
import io.vertx.amqpbridge.{AmqpBridge => JAmqpBridge}
import io.vertx.core
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}
package object amqpbridge{



  /**
    * Vert.x AMQP Bridge. Facilitates sending and receiving AMQP 1.0 messages.

    */

  implicit class AmqpBridgeScala(val asJava: io.vertx.amqpbridge.AmqpBridge) extends AnyVal {


    /**
     * Like start from [[io.vertx.amqpbridge.AmqpBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def startFuture(hostname: java.lang.String,port: java.lang.Integer,username: java.lang.String,password: java.lang.String) : scala.concurrent.Future[io.vertx.amqpbridge.AmqpBridge] = {
      val promise = concurrent.Promise[io.vertx.amqpbridge.AmqpBridge]()
      asJava.start(hostname, port, username, password, new Handler[AsyncResult[io.vertx.amqpbridge.AmqpBridge]] { override def handle(event: AsyncResult[io.vertx.amqpbridge.AmqpBridge]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like start from [[io.vertx.amqpbridge.AmqpBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def startFuture(hostname: java.lang.String,port: java.lang.Integer) : scala.concurrent.Future[io.vertx.amqpbridge.AmqpBridge] = {
      val promise = concurrent.Promise[io.vertx.amqpbridge.AmqpBridge]()
      asJava.start(hostname, port, new Handler[AsyncResult[io.vertx.amqpbridge.AmqpBridge]] { override def handle(event: AsyncResult[io.vertx.amqpbridge.AmqpBridge]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like close from [[io.vertx.amqpbridge.AmqpBridge]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



  type AmqpBridgeOptions = io.vertx.amqpbridge.AmqpBridgeOptions
  object AmqpBridgeOptions {
    def apply() = new AmqpBridgeOptions()
    def apply(json: JsonObject) = new AmqpBridgeOptions(json)
  }



}
