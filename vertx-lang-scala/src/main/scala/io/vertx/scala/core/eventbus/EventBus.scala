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
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}

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
class EventBus(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava

//cached methods
//fluent methods
  def send(address: String,message: AnyRef):EventBus = {
    asJava.asInstanceOf[JEventBus].send(address,message)
    this
  }

  def send[T](address: String,message: AnyRef,replyHandler: Handler[AsyncResult[Message[T]]]):EventBus = {
    asJava.asInstanceOf[JEventBus].send[T](address,message,{x: AsyncResult[JMessage[T]] => replyHandler.handle(AsyncResultWrapper[JMessage[T],Message[T]](x, a => Message[T](a)))})
    this
  }

  def send(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.asInstanceOf[JEventBus].send(address,message,options.asJava)
    this
  }

  def send[T](address: String,message: AnyRef,options: DeliveryOptions,replyHandler: Handler[AsyncResult[Message[T]]]):EventBus = {
    asJava.asInstanceOf[JEventBus].send[T](address,message,options.asJava,{x: AsyncResult[JMessage[T]] => replyHandler.handle(AsyncResultWrapper[JMessage[T],Message[T]](x, a => Message[T](a)))})
    this
  }

  def publish(address: String,message: AnyRef):EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address,message)
    this
  }

  def publish(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address,message,options.asJava)
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JEventBus].isMetricsEnabled()
  }

  def consumer[T](address: String):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[T](address))
  }

  def consumer[T](address: String,handler: Handler[Message[T]]):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[T](address,{x: JMessage[T] => handler.handle(Message[T](x))}))
  }

  def localConsumer[T](address: String):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[T](address))
  }

  def localConsumer[T](address: String,handler: Handler[Message[T]]):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[T](address,{x: JMessage[T] => handler.handle(Message[T](x))}))
  }

  def sender[T](address: String):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[T](address))
  }

  def sender[T](address: String,options: DeliveryOptions):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[T](address,options.asJava))
  }

  def publisher[T](address: String):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[T](address))
  }

  def publisher[T](address: String,options: DeliveryOptions):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[T](address,options.asJava))
  }

  def addInterceptor(interceptor: Handler[SendContext]):EventBus = {
    EventBus(asJava.asInstanceOf[JEventBus].addInterceptor({x: JSendContext[T] => interceptor.handle(SendContext(x))}))
  }

  def removeInterceptor(interceptor: Handler[SendContext]):EventBus = {
    EventBus(asJava.asInstanceOf[JEventBus].removeInterceptor({x: JSendContext[T] => interceptor.handle(SendContext(x))}))
  }

}

object EventBus{
  def apply(asJava: JEventBus) = new EventBus(asJava)
//static methods
}
