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

package io.vertx.scala.core.eventbus;

import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.Handler

/**
  * A Vert.x event-bus is a light-weight distributed messaging system which allows different parts of your application,
  * or different applications and services to communicate with each in a loosely coupled way.
  * 
  * An event-bus supports publish-subscribe messaging, point-to-point messaging and request-response messaging.
  * 
  * Message delivery is best-effort and messages can be lost if failure of all or part of the event bus occurs.
  * 
  * Please refer to the documentation for more information on the event bus.
  */
class EventBus(private val _asJava: io.vertx.core.eventbus.EventBus) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#send]] but specifying a `replyHandler` that will be called if the recipient
    * subsequently replies to the message.
    * @param address the address to send it to
    * @param message the message, may be {@code null}
    * @return reply handler will be called when any reply from the recipient is received, may be {@code null}
    */
  def send[T](address: String, message: AnyRef): scala.concurrent.Future[io.vertx.scala.core.eventbus.Message[T]] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.eventbus.Message[T]]()
    _asJava.send(address, message, promiseToMappedAsyncResultHandler(Message.apply[T])(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#send]] but specifying a `replyHandler` that will be called if the recipient
    * subsequently replies to the message.
    * @param address the address to send it to
    * @param message the message, may be {@code null}
    * @param options delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return reply handler will be called when any reply from the recipient is received, may be {@code null}
    */
  def send[T](address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): scala.concurrent.Future[io.vertx.scala.core.eventbus.Message[T]] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.eventbus.Message[T]]()
    _asJava.send(address, message, options, promiseToMappedAsyncResultHandler(Message.apply[T])(promise))
    promise.future
  }

  /**
    * Publish a message.
    * The message will be delivered to all handlers registered to the address.
    * @param address the address to publish it to
    * @param message the message, may be {@code null}
    * @return a reference to this, so the API can be used fluently
    */
  def publish(address: String, message: AnyRef): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.publish(address, message)
    this
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#publish]] but specifying `options` that can be used to configure the delivery.
    * @param address the address to publish it to
    * @param message the message, may be {@code null}
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return a reference to this, so the API can be used fluently
    */
  def publish(address: String, message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.EventBus = {
    _asJava.publish(address, message, options)
    this
  }

  /**
    * Create a message consumer against the specified address.
    * 
    * The returned consumer is not yet registered
    * at the address, registration will be effective when [[io.vertx.scala.core.eventbus.MessageConsumer#handler]]
    * is called.
    * @param address the address that it will register it at
    * @return the event bus message consumer
    */
  def consumer[T](address: String): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.consumer(address))
  }

  /**
    * Create a consumer and register it against the specified address.
    * @param address the address that will register it at
    * @param handler the handler that will process the received messages
    * @return the event bus message consumer
    */
  def consumer[T](address: String)(handler: io.vertx.scala.core.eventbus.Message[T] => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    MessageConsumer.apply[T](_asJava.consumer(address, funcToMappedHandler(Message.apply[T])(handler)))
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.
    * @param address the address to register it at
    * @return the event bus message consumer
    */
  def localConsumer[T](address: String): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.localConsumer(address))
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.
    * @param address the address that will register it at
    * @param handler the handler that will process the received messages
    * @return the event bus message consumer
    */
  def localConsumer[T](address: String)(handler: io.vertx.scala.core.eventbus.Message[T] => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    MessageConsumer.apply[T](_asJava.localConsumer(address, funcToMappedHandler(Message.apply[T])(handler)))
  }

  /**
    * Create a message sender against the specified address.
    * 
    * The returned sender will invoke the [[io.vertx.scala.core.eventbus.EventBus#send]]
    * method when the stream [[io.vertx.scala.core.streams.WriteStream#write]] method is called with the sender
    * address and the provided data.
    * @param address the address to send it to
    * @return The sender
    */
  def sender[T](address: String): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.sender(address))
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#sender]] but specifying delivery options that will be used for configuring the delivery of
    * the message.
    * @param address the address to send it to
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return The sender
    */
  def sender[T](address: String, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.sender(address, options))
  }

  /**
    * Create a message publisher against the specified address.
    * 
    * The returned publisher will invoke the [[io.vertx.scala.core.eventbus.EventBus#publish]]
    * method when the stream [[io.vertx.scala.core.streams.WriteStream#write]] method is called with the publisher
    * address and the provided data.
    * @param address The address to publish it to
    * @return The publisher
    */
  def publisher[T](address: String): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.publisher(address))
  }

  /**
    * Like [[io.vertx.scala.core.eventbus.EventBus#publisher]] but specifying delivery options that will be used for configuring the delivery of
    * the message.
    * @param address the address to publish it to
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return The publisher
    */
  def publisher[T](address: String, options: io.vertx.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.publisher(address, options))
  }

  /**
    * Add an interceptor that will be called whenever a message is sent from Vert.x
    * @param interceptor the interceptor
    * @return a reference to this, so the API can be used fluently
    */
  def addInterceptor[T](interceptor: io.vertx.scala.core.eventbus.SendContext[T] => Unit): io.vertx.scala.core.eventbus.EventBus = {
    import io.vertx.lang.scala.HandlerOps._
    EventBus.apply(_asJava.addInterceptor(funcToMappedHandler(SendContext.apply)(interceptor)))
  }

  /**
    * Remove an interceptor
    * @param interceptor the interceptor
    * @return a reference to this, so the API can be used fluently
    */
  def removeInterceptor(interceptor: io.vertx.scala.core.eventbus.SendContext => Unit): io.vertx.scala.core.eventbus.EventBus = {
    import io.vertx.lang.scala.HandlerOps._
    EventBus.apply(_asJava.removeInterceptor(funcToMappedHandler(SendContext.apply)(interceptor)))
  }

}

object EventBus {

  def apply(_asJava: io.vertx.core.eventbus.EventBus): io.vertx.scala.core.eventbus.EventBus =
    new io.vertx.scala.core.eventbus.EventBus(_asJava)
}
