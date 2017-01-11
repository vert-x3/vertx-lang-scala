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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.amqpbridge.{AmqpBridgeOptions => JAmqpBridgeOptions}
import io.vertx.amqpbridge.{AmqpBridge => JAmqpBridge}
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.scala.core.eventbus.MessageConsumer
import io.vertx.scala.core.eventbus.MessageProducer
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}

/**
  * Vert.x AMQP Bridge. Facilitates sending and receiving AMQP 1.0 messages.
  */
class AmqpBridge(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Starts the bridge, establishing the underlying connection.
    * @param hostname the host name to connect to
    * @param port the port to connect to
    * @param username the username
    * @param password the password
    */
  def start(hostname: String,port: Int,username: String,password: String,resultHandler: Handler[AsyncResult[AmqpBridge]]):Unit = {
    asJava.asInstanceOf[JAmqpBridge].start(hostname.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],{x: AsyncResult[JAmqpBridge] => resultHandler.handle(AsyncResultWrapper[JAmqpBridge,AmqpBridge](x, a => AmqpBridge(a)))})
  }

  /**
    * Starts the bridge, establishing the underlying connection.
    * @param hostname the host name to connect to
    * @param port the port to connect to
    */
  def start(hostname: String,port: Int,resultHandler: Handler[AsyncResult[AmqpBridge]]):Unit = {
    asJava.asInstanceOf[JAmqpBridge].start(hostname.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JAmqpBridge] => resultHandler.handle(AsyncResultWrapper[JAmqpBridge,AmqpBridge](x, a => AmqpBridge(a)))})
  }

  /**
    * Creates a consumer on the given AMQP address.
    *
    * This method MUST be called from the bridge Context thread, as used in the result handler callback from the start
    * methods. The bridge MUST be successfully started before the method is called.
    * @param amqpAddress the address to consume from
    * @return the consumer
    */
  def createConsumer[T:TypeTag](amqpAddress: String):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JAmqpBridge].createConsumer[Object](amqpAddress.asInstanceOf[java.lang.String]))
  }

  /**
    * Creates a producer to the given AMQP address.
    *
    * This method MUST be called from the bridge Context thread, as used in the result handler callback from the start
    * methods. The bridge MUST be successfully started before the method is called.
    * @param amqpAddress the address to produce to
    * @return the producer
    */
  def createProducer[T:TypeTag](amqpAddress: String):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JAmqpBridge].createProducer[Object](amqpAddress.asInstanceOf[java.lang.String]))
  }

  /**
    * Shuts the bridge down, closing the underlying connection.
    */
  def close(resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAmqpBridge].close({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Starts the bridge, establishing the underlying connection.
   * @param hostname the host name to connect to
   * @param port the port to connect to
   * @param username the username
   * @param password the password
   * @return the result future
   */
  def startFuture(hostname: String,port: Int,username: String,password: String):scala.concurrent.Future[AmqpBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAmqpBridge, AmqpBridge](x => AmqpBridge(x))
    asJava.asInstanceOf[JAmqpBridge].start(hostname.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],username.asInstanceOf[java.lang.String],password.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Starts the bridge, establishing the underlying connection.
   * @param hostname the host name to connect to
   * @param port the port to connect to
   * @return the result future
   */
  def startFuture(hostname: String,port: Int):scala.concurrent.Future[AmqpBridge] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAmqpBridge, AmqpBridge](x => AmqpBridge(x))
    asJava.asInstanceOf[JAmqpBridge].start(hostname.asInstanceOf[java.lang.String],port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Shuts the bridge down, closing the underlying connection.
   * @return the result future
   */
  def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAmqpBridge].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AmqpBridge{
  def apply(asJava: JAmqpBridge) = new AmqpBridge(asJava)  
  /**
    * Creates a Bridge.
    * @param vertx the vertx instance to use
    * @return the (not-yet-started) bridge.
    */
  def create(vertx: Vertx):AmqpBridge = {
    AmqpBridge(JAmqpBridge.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
    * Creates a Bridge with the given options.
    * @param vertx the vertx instance to use
    * @param options the optionssee <a href="../../../../../../cheatsheet/AmqpBridgeOptions.html">AmqpBridgeOptions</a>
    * @return the (not-yet-started) bridge.
    */
  def create(vertx: Vertx,options: AmqpBridgeOptions):AmqpBridge = {
    AmqpBridge(JAmqpBridge.create(vertx.asJava.asInstanceOf[JVertx],options.asJava))
  }

}
