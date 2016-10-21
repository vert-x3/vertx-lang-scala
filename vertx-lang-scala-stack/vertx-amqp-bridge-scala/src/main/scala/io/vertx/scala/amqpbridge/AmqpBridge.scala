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

package io.vertx.scala.amqpbridge

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.Handler
import io.vertx.scala.core.eventbus.MessageConsumer
import io.vertx.scala.core.eventbus.MessageProducer
import io.vertx.amqpbridge.AmqpBridgeOptions

/**
  * Vert.x AMQP Bridge. Facilitates sending and receiving AMQP 1.0 messages.
  */
class AmqpBridge(private val _asJava: io.vertx.amqpbridge.AmqpBridge) {

  def asJava: io.vertx.amqpbridge.AmqpBridge = _asJava

  /**
    * Starts the bridge, establishing the underlying connection.
    * @param hostname the host name to connect to
    * @param port the port to connect to
    * @param username the username
    * @param password the password
    * @return the result future
    */
  def startFuture(hostname: String, port: Int, username: String, password: String): concurrent.Future[io.vertx.scala.amqpbridge.AmqpBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.amqpbridge.AmqpBridge,io.vertx.scala.amqpbridge.AmqpBridge]((x => if (x == null) null else AmqpBridge.apply(x)))
    _asJava.start(hostname, port, username, password, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Starts the bridge, establishing the underlying connection.
    * @param hostname the host name to connect to
    * @param port the port to connect to
    * @return the result future
    */
  def startFuture(hostname: String, port: Int): concurrent.Future[io.vertx.scala.amqpbridge.AmqpBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.amqpbridge.AmqpBridge,io.vertx.scala.amqpbridge.AmqpBridge]((x => if (x == null) null else AmqpBridge.apply(x)))
    _asJava.start(hostname, port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Creates a consumer on the given AMQP address.
    *
    * This method MUST be called from the bridge Context thread, as used in the result handler callback from the start
    * methods. The bridge MUST be successfully started before the method is called.
    * @param amqpAddress the address to consume from
    * @return the consumer
    */
  def createConsumer[T](amqpAddress: String): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.createConsumer(amqpAddress))
  }

  /**
    * Creates a producer to the given AMQP address.
    *
    * This method MUST be called from the bridge Context thread, as used in the result handler callback from the start
    * methods. The bridge MUST be successfully started before the method is called.
    * @param amqpAddress the address to produce to
    * @return the producer
    */
  def createProducer[T](amqpAddress: String): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.createProducer(amqpAddress))
  }

  /**
    * Shuts the bridge down, closing the underlying connection.
    * @return the result future
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AmqpBridge {

  def apply(_asJava: io.vertx.amqpbridge.AmqpBridge): io.vertx.scala.amqpbridge.AmqpBridge =
    new io.vertx.scala.amqpbridge.AmqpBridge(_asJava)

  def create(vertx: io.vertx.scala.core.Vertx): io.vertx.scala.amqpbridge.AmqpBridge = {
    AmqpBridge.apply(io.vertx.amqpbridge.AmqpBridge.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx]))
  }

  def create(vertx: io.vertx.scala.core.Vertx, options: io.vertx.scala.amqpbridge.AmqpBridgeOptions): io.vertx.scala.amqpbridge.AmqpBridge = {
    AmqpBridge.apply(io.vertx.amqpbridge.AmqpBridge.create(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], options.asJava))
  }

}
