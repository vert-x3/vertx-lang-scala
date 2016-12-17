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
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.eventbus.Message
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}

/**
  * Represents a stream of message that can be written to.
  * 
  */
class MessageProducer[T](private val _asJava: Object) 
    extends WriteStream[T](_asJava) {

  override def asJava = _asJava.asInstanceOf[JMessageProducer]
//methods returning a future
  def send(message: T,replyHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Message[R]]]):MessageProducer[T] = {
    asJava.send( )
  }

//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):MessageProducer[T] = {
    asJava.exceptionHandler( )
    this
  }

  override def write(data: T):MessageProducer[T] = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):MessageProducer[T] = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):MessageProducer[T] = {
    asJava.drainHandler( )
    this
  }

  def deliveryOptions(options: DeliveryOptions):MessageProducer[T] = {
    asJava.deliveryOptions( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  def send(message: T):MessageProducer[T] = {
    asJava.send( )
  }

  def send(message: T,replyHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Message[R]]]):MessageProducer[T] = {
    asJava.send( )
  }

  def address():String = {
    asJava.address( )
  }

  override def end():Unit = {
    asJava.end( )
  }

  def close():Unit = {
    asJava.close( )
  }

}

object MessageProducer{
//in object!
//static methods
}
