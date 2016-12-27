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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Represents a stream of message that can be written to.
  * 
  */
class MessageProducer[T](private val _asJava: Object) 
    extends WriteStream[T] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[T]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def write(data: T):MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[T]].write(data)
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[T]].setWriteQueueMaxSize(maxSize)
    this
  }

  override def drainHandler(handler: Handler[Unit]):MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[T]].drainHandler({x: Void => handler.handle(x)})
    this
  }

  def deliveryOptions(options: DeliveryOptions):MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[T]].deliveryOptions(options.asJava)
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: T):Unit = {
    asJava.asInstanceOf[JMessageProducer[T]].end(t)
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JMessageProducer[T]].writeQueueFull()
  }

  def send(message: T):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JMessageProducer[T]].send(message))
  }

  def send[R](message: T,replyHandler: Handler[AsyncResult[Message[R]]]):MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JMessageProducer[T]].send[R](message,{x: AsyncResult[JMessage[R]] => replyHandler.handle(AsyncResultWrapper[JMessage[R],Message[R]](x, a => Message[R](a)))}))
  }

  def address():String = {
    asJava.asInstanceOf[JMessageProducer[T]].address()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JMessageProducer[T]].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JMessageProducer[T]].close()
  }

}

  object MessageProducer{
    def apply[T](asJava: JMessageProducer[T]) = new MessageProducer[T](asJava)  
  //static methods
  }
