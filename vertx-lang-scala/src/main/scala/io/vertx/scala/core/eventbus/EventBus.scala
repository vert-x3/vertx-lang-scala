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

import io.vertx.scala.core.eventbus.DeliveryOptions
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{EventBus => JEventBus}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.eventbus.SendContext
import io.vertx.core.eventbus.{SendContext => JSendContext}
import io.vertx.scala.core.eventbus.Message
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.scala.core.eventbus.MessageConsumer
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}
import io.vertx.scala.core.eventbus.MessageProducer
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}

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
    extends Measured(_asJava) {

  override def asJava = _asJava.asInstanceOf[JEventBus]
//methods returning a future
//cached methods
//fluent methods
  def send(address: String,message: AnyRef):EventBus = {
    asJava.send( )
    this
  }

  def send(address: String,message: AnyRef,replyHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Message[T]]]):EventBus = {
    asJava.send( )
    this
  }

  def send(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.send( )
    this
  }

  def send(address: String,message: AnyRef,options: DeliveryOptions,replyHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Message[T]]]):EventBus = {
    asJava.send( )
    this
  }

  def publish(address: String,message: AnyRef):EventBus = {
    asJava.publish( )
    this
  }

  def publish(address: String,message: AnyRef,options: DeliveryOptions):EventBus = {
    asJava.publish( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def consumer(address: String):MessageConsumer[T] = {
    asJava.consumer( )
  }

  def consumer(address: String,handler: io.vertx.core.Handler[Message[T]]):MessageConsumer[T] = {
    asJava.consumer( )
  }

  def localConsumer(address: String):MessageConsumer[T] = {
    asJava.localConsumer( )
  }

  def localConsumer(address: String,handler: io.vertx.core.Handler[Message[T]]):MessageConsumer[T] = {
    asJava.localConsumer( )
  }

  def sender(address: String):MessageProducer[T] = {
    asJava.sender( )
  }

  def sender(address: String,options: DeliveryOptions):MessageProducer[T] = {
    asJava.sender( )
  }

  def publisher(address: String):MessageProducer[T] = {
    asJava.publisher( )
  }

  def publisher(address: String,options: DeliveryOptions):MessageProducer[T] = {
    asJava.publisher( )
  }

  def addInterceptor(interceptor: io.vertx.core.Handler[SendContext]):EventBus = {
    asJava.addInterceptor( )
  }

  def removeInterceptor(interceptor: io.vertx.core.Handler[SendContext]):EventBus = {
    asJava.removeInterceptor( )
  }

}

object EventBus{
//in object!
//static methods
}
