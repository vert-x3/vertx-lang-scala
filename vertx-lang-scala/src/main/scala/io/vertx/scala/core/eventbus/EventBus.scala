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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
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
    asJava.asInstanceOf[JEventBus].send(address.asInstanceOf[java.lang.String],message)
    this
  }

  def send[T](address: String,message: AnyRef,replyHandler: Handler[AsyncResult[Message[T]]]):EventBus = {
    asJava.asInstanceOf[JEventBus].send[T](address.asInstanceOf[java.lang.String],message,{x: AsyncResult[JMessage[T]] => replyHandler.handle(AsyncResultWrapper[JMessage[T],Message[T]](x, a => Message[T](a)))})
    this
  }

  def send(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.asInstanceOf[JEventBus].send(address.asInstanceOf[java.lang.String],message,options.asJava)
    this
  }

  def send[T](address: String,message: AnyRef,options: DeliveryOptions,replyHandler: Handler[AsyncResult[Message[T]]]):EventBus = {
    asJava.asInstanceOf[JEventBus].send[T](address.asInstanceOf[java.lang.String],message,options.asJava,{x: AsyncResult[JMessage[T]] => replyHandler.handle(AsyncResultWrapper[JMessage[T],Message[T]](x, a => Message[T](a)))})
    this
  }

  def publish(address: String,message: AnyRef):EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address.asInstanceOf[java.lang.String],message)
    this
  }

  def publish(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.asInstanceOf[JEventBus].publish(address.asInstanceOf[java.lang.String],message,options.asJava)
    this
  }

//default methods
//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JEventBus].isMetricsEnabled()
  }

  def consumer[T](address: String):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[T](address.asInstanceOf[java.lang.String]))
  }

  def consumer[T](address: String,handler: Handler[Message[T]]):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].consumer[T](address.asInstanceOf[java.lang.String],{x: JMessage[T] => handler.handle(Message[T](x))}))
  }

  def localConsumer[T](address: String):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[T](address.asInstanceOf[java.lang.String]))
  }

  def localConsumer[T](address: String,handler: Handler[Message[T]]):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JEventBus].localConsumer[T](address.asInstanceOf[java.lang.String],{x: JMessage[T] => handler.handle(Message[T](x))}))
  }

  def sender[T](address: String):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[T](address.asInstanceOf[java.lang.String]))
  }

  def sender[T](address: String,options: DeliveryOptions):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].sender[T](address.asInstanceOf[java.lang.String],options.asJava))
  }

  def publisher[T](address: String):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[T](address.asInstanceOf[java.lang.String]))
  }

  def publisher[T](address: String,options: DeliveryOptions):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JEventBus].publisher[T](address.asInstanceOf[java.lang.String],options.asJava))
  }

//future methods
def sendFuture[T](address: String,message: AnyRef):scala.concurrent.Future[Message[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[T], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].send[T](address.asInstanceOf[java.lang.String],message,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def sendFuture[T](address: String,message: AnyRef,options: DeliveryOptions):scala.concurrent.Future[Message[T]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[T], Message[T]](x => Message[T](x))
    asJava.asInstanceOf[JEventBus].send[T](address.asInstanceOf[java.lang.String],message,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object EventBus{
    def apply(asJava: JEventBus) = new EventBus(asJava)  
  //static methods
  }
