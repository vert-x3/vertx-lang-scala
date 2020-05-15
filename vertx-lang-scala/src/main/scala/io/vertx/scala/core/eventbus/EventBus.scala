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

package io.vertx.scala.core.eventbus

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import scala.reflect.runtime.universe._
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.eventbus.{DeliveryContext => JDeliveryContext}
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}
import io.vertx.lang.scala.Converter._
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.lang.scala.HandlerOps._

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

class EventBus(private val _asJava: Object) extends Measured {
  def asJava = _asJava

  import io.vertx.core.eventbus.MessageCodec
  
  /**
   * Register a message codec.
   * <p>
   * You can register a message codec if you want to send any non standard message across the event bus.
   * E.g. you might want to send POJOs directly across the event bus.
   * <p>
   * To use a message codec for a send, you should specify it in the delivery options.
   *
   * @param codec  the message codec to register
   * @return a reference to this, so the API can be used fluently
   */
  def registerCodec(codec: MessageCodec[_,_]): EventBus  = {
    asJava.asInstanceOf[JEventBus].registerCodec(codec)
    this
  }

  /**
   * Register a default message codec.
   * <p>
   * You can register a message codec if you want to send any non standard message across the event bus.
   * E.g. you might want to send POJOs directly across the event bus.
   * <p>
   * Default message codecs will be used to serialise any messages of the specified type on the event bus without
   * the codec having to be specified in the delivery options.
   *
   * @param clazz  the class for which to use this codec
   * @param codec  the message codec to register
   * @return a reference to this, so the API can be used fluently
   */
  def registerDefaultCodec[T](clazz:Class[T] , codec: MessageCodec[T, _]): EventBus  = {
    asJava.asInstanceOf[JEventBus].registerDefaultCodec(clazz, codec)
    this
  }

  /**
   * Unregister a default message codec.
   * <p>
   * @param clazz  the class for which the codec was registered
   * @return a reference to this, so the API can be used fluently
   */
  def unregisterDefaultCodec(clazz: Class[_]): EventBus  = {
    asJava.asInstanceOf[JEventBus].unregisterDefaultCodec(clazz)
    this
  }



  /**
   * Sends a message.
   * 
   * The message will be delivered to at most one of the handlers registered to the address.   * @param address the address to send it to
   * @param message the message, may be `null`
   * @return a reference to this, so the API can be used fluently
   */
  
  def send(address: String, message: scala.Option[AnyRef]): EventBus = {
    asJava.asInstanceOf[JEventBus].send(address.asInstanceOf[java.lang.String], message.orNull)
    this
  }

  /**
   * Like  but specifying a `replyHandler` that will be called if the recipient
   * subsequently replies to the message.   * @param address the address to send it to
   * @param message the message, may be `null`
   * @param replyHandler reply handler will be called when any reply from the recipient is received, may be `null`
   * @return a reference to this, so the API can be used fluently
   */
  
  def send[T: TypeTag](address: String, message: scala.Option[AnyRef], replyHandler: Handler[AsyncResult[Message[T]]]): EventBus = {
    asJava.asInstanceOf[JEventBus].send[Object](address.asInstanceOf[java.lang.String], message.orNull, (if (replyHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMessage[Object]]]{def handle(x: AsyncResult[JMessage[Object]]) {replyHandler.handle(AsyncResultWrapper[JMessage[Object], Message[T]](x, a => Message[T](a)))}}))
    this
  }

  /**
   * Like  but specifying `options` that can be used to configure the delivery.   * @param address the address to send it to
   * @param message the message, may be `null`
   * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @return a reference to this, so the API can be used fluently
   */
  
  def send(address: String, message: scala.Option[AnyRef], options: DeliveryOptions): EventBus = {
    asJava.asInstanceOf[JEventBus].send(address.asInstanceOf[java.lang.String], message.orNull, options.asJava)
    this
  }

  /**
   * Like  but specifying a `replyHandler` that will be called if the recipient
   * subsequently replies to the message.   * @param address the address to send it to
   * @param message the message, may be `null`
   * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @param replyHandler reply handler will be called when any reply from the recipient is received, may be `null`
   * @return a reference to this, so the API can be used fluently
   */
  
  def send[T: TypeTag](address: String, message: scala.Option[AnyRef], options: DeliveryOptions, replyHandler: Handler[AsyncResult[Message[T]]]): EventBus = {
    asJava.asInstanceOf[JEventBus].send[Object](address.asInstanceOf[java.lang.String], message.orNull, options.asJava, (if (replyHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMessage[Object]]]{def handle(x: AsyncResult[JMessage[Object]]) {replyHandler.handle(AsyncResultWrapper[JMessage[Object], Message[T]](x, a => Message[T](a)))}}))
    this
  }

  /**
   * Sends a message and and specify a `replyHandler` that will be called if the recipient
   * subsequently replies to the message.
   * 
   * The message will be delivered to at most one of the handlers registered to the address.   * @param address the address to send it to
   * @param message the message body, may be `null`
   * @param replyHandler reply handler will be called when any reply from the recipient is received
   * @return a reference to this, so the API can be used fluently
   */
  
  def request[T: TypeTag](address: String, message: scala.Option[AnyRef], replyHandler: Handler[AsyncResult[Message[T]]]): EventBus = {
    asJava.asInstanceOf[JEventBus].request[Object](address.asInstanceOf[java.lang.String], message.orNull, (if (replyHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMessage[Object]]]{def handle(x: AsyncResult[JMessage[Object]]) {replyHandler.handle(AsyncResultWrapper[JMessage[Object], Message[T]](x, a => Message[T](a)))}}))
    this
  }

  /**
   * Like  but specifying `options` that can be used to configure the delivery.   * @param address the address to send it to
   * @param message the message body, may be `null`
   * @param options delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @param replyHandler reply handler will be called when any reply from the recipient is received
   * @return a reference to this, so the API can be used fluently
   */
  
  def request[T: TypeTag](address: String, message: scala.Option[AnyRef], options: DeliveryOptions, replyHandler: Handler[AsyncResult[Message[T]]]): EventBus = {
    asJava.asInstanceOf[JEventBus].request[Object](address.asInstanceOf[java.lang.String], message.orNull, options.asJava, (if (replyHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMessage[Object]]]{def handle(x: AsyncResult[JMessage[Object]]) {replyHandler.handle(AsyncResultWrapper[JMessage[Object], Message[T]](x, a => Message[T](a)))}}))
    this
  }

  /**
   * Publish a message.
   * The message will be delivered to all handlers registered to the address.   * @param address the address to publish it to
   * @param message the message, may be `null`
   * @return a reference to this, so the API can be used fluently
   */
  
  def publish(address: String, message: scala.Option[AnyRef]): EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address.asInstanceOf[java.lang.String], message.orNull)
    this
  }

  /**
   * Like  but specifying `options` that can be used to configure the delivery.   * @param address the address to publish it to
   * @param message the message, may be `null`
   * @param options the delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @return a reference to this, so the API can be used fluently
   */
  
  def publish(address: String, message: scala.Option[AnyRef], options: DeliveryOptions): EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address.asInstanceOf[java.lang.String], message.orNull, options.asJava)
    this
  }

  /**
   * Add an interceptor that will be called whenever a message is sent from Vert.x   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  
  def addOutboundInterceptor[T: TypeTag](interceptor: Handler[DeliveryContext[T]]): EventBus = {
    asJava.asInstanceOf[JEventBus].addOutboundInterceptor[Object]((if (interceptor == null) null else new io.vertx.core.Handler[JDeliveryContext[Object]]{def handle(x: JDeliveryContext[Object]) {interceptor.handle(DeliveryContext[T](x))}}))
    this
  }

  /**
   * Remove an interceptor that was added by [[io.vertx.scala.core.eventbus.EventBus#addOutboundInterceptor]]   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  
  def removeOutboundInterceptor[T: TypeTag](interceptor: Handler[DeliveryContext[T]]): EventBus = {
    asJava.asInstanceOf[JEventBus].removeOutboundInterceptor[Object]((if (interceptor == null) null else new io.vertx.core.Handler[JDeliveryContext[Object]]{def handle(x: JDeliveryContext[Object]) {interceptor.handle(DeliveryContext[T](x))}}))
    this
  }

  /**
   * Add an interceptor that will be called whenever a message is received by Vert.x   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  
  def addInboundInterceptor[T: TypeTag](interceptor: Handler[DeliveryContext[T]]): EventBus = {
    asJava.asInstanceOf[JEventBus].addInboundInterceptor[Object]((if (interceptor == null) null else new io.vertx.core.Handler[JDeliveryContext[Object]]{def handle(x: JDeliveryContext[Object]) {interceptor.handle(DeliveryContext[T](x))}}))
    this
  }

  /**
   * Remove an interceptor that was added by [[io.vertx.scala.core.eventbus.EventBus#addInboundInterceptor]]   * @param interceptor the interceptor
   * @return a reference to this, so the API can be used fluently
   */
  
  def removeInboundInterceptor[T: TypeTag](interceptor: Handler[DeliveryContext[T]]): EventBus = {
    asJava.asInstanceOf[JEventBus].removeInboundInterceptor[Object]((if (interceptor == null) null else new io.vertx.core.Handler[JDeliveryContext[Object]]{def handle(x: JDeliveryContext[Object]) {interceptor.handle(DeliveryContext[T](x))}}))
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JEventBus].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Create a message consumer against the specified address.
   * 
   * The returned consumer is not yet registered
   * at the address, registration will be effective when [[io.vertx.scala.core.eventbus.MessageConsumer#handler]]
   * is called.   * @param address the address that it will register it at
   * @return the event bus message consumer
   */
  def consumer [T: TypeTag](address: String): MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[Object](address.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a consumer and register it against the specified address.   * @param address the address that will register it at
   * @param handler the handler that will process the received messages
   * @return the event bus message consumer
   */
  def consumer [T: TypeTag](address: String, handler: Handler[Message[T]]): MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[Object](address.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[JMessage[Object]]{def handle(x: JMessage[Object]) {handler.handle(Message[T](x))}})))
  }

  /**
   * Like [[io.vertx.scala.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.   * @param address the address to register it at
   * @return the event bus message consumer
   */
  def localConsumer [T: TypeTag](address: String): MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[Object](address.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.eventbus.EventBus#consumer]] but the address won't be propagated across the cluster.   * @param address the address that will register it at
   * @param handler the handler that will process the received messages
   * @return the event bus message consumer
   */
  def localConsumer [T: TypeTag](address: String, handler: Handler[Message[T]]): MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[Object](address.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[JMessage[Object]]{def handle(x: JMessage[Object]) {handler.handle(Message[T](x))}})))
  }

  /**
   * Create a message sender against the specified address.
   * 
   * The returned sender will invoke the 
   * method when the stream [[io.vertx.scala.core.streams.WriteStream#write]] method is called with the sender
   * address and the provided data.   * @param address the address to send it to
   * @return The sender
   */
  def sender [T: TypeTag](address: String): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[Object](address.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.eventbus.EventBus#sender]] but specifying delivery options that will be used for configuring the delivery of
   * the message.   * @param address the address to send it to
   * @param options the delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @return The sender
   */
  def sender [T: TypeTag](address: String, options: DeliveryOptions): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[Object](address.asInstanceOf[java.lang.String], options.asJava))
  }

  /**
   * Create a message publisher against the specified address.
   * 
   * The returned publisher will invoke the 
   * method when the stream [[io.vertx.scala.core.streams.WriteStream#write]] method is called with the publisher
   * address and the provided data.   * @param address The address to publish it to
   * @return The publisher
   */
  def publisher [T: TypeTag](address: String): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[Object](address.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.eventbus.EventBus#publisher]] but specifying delivery options that will be used for configuring the delivery of
   * the message.   * @param address the address to publish it to
   * @param options the delivery options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @return The publisher
   */
  def publisher [T: TypeTag](address: String, options: DeliveryOptions): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[Object](address.asInstanceOf[java.lang.String], options.asJava))
  }


 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture [T: TypeTag](address: String, message: scala.Option[AnyRef]): scala.concurrent.Future[Message[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[Object], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].send[Object](address.asInstanceOf[java.lang.String], message.orNull, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture [T: TypeTag](address: String, message: scala.Option[AnyRef], options: DeliveryOptions): scala.concurrent.Future[Message[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[Object], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].send[Object](address.asInstanceOf[java.lang.String], message.orNull, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture [T: TypeTag](address: String, message: scala.Option[AnyRef]): scala.concurrent.Future[Message[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[Object], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].request[Object](address.asInstanceOf[java.lang.String], message.orNull, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture [T: TypeTag](address: String, message: scala.Option[AnyRef], options: DeliveryOptions): scala.concurrent.Future[Message[T]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[Object], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].request[Object](address.asInstanceOf[java.lang.String], message.orNull, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object EventBus {
  def apply(asJava: JEventBus) = new EventBus(asJava)

}
