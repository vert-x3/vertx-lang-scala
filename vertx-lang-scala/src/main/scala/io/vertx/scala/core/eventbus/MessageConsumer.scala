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

import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.eventbus.Message
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{MessageConsumer => JMessageConsumer}

/**
  * An event bus consumer object representing a stream of message to an [[io.vertx.scala.core.eventbus.EventBus]] address that can
  * be read from.
  * 
  * The [[io.vertx.scala.core.eventbus.EventBus#consumer]] or [[io.vertx.scala.core.eventbus.EventBus#localConsumer]]
  * creates a new consumer, the returned consumer is not yet registered against the event bus. Registration
  * is effective after the [[io.vertx.scala.core.eventbus.MessageConsumer#handler]] method is invoked.
  *
  * The consumer is unregistered from the event bus using the [[io.vertx.scala.core.eventbus.MessageConsumer#unregister]] method or by calling the
  * [[io.vertx.scala.core.eventbus.MessageConsumer#handler]] with a null value..
  */
class MessageConsumer[T](private val _asJava: Object) 
    extends ReadStream[Message[T]](_asJava) {

  override def asJava = _asJava.asInstanceOf[JMessageConsumer]
//methods returning a future
  def completionHandler(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.completionHandler( )
  }

  def unregister(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.unregister( )
  }

//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):MessageConsumer[T] = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Message[T]]):MessageConsumer[T] = {
    asJava.handler( )
    this
  }

  override def pause():MessageConsumer[T] = {
    asJava.pause( )
    this
  }

  override def resume():MessageConsumer[T] = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):MessageConsumer[T] = {
    asJava.endHandler( )
    this
  }

//basic methods
  def bodyStream():ReadStream[T] = {
    asJava.bodyStream( )
  }

  def isRegistered():Boolean = {
    asJava.isRegistered( )
  }

  def address():String = {
    asJava.address( )
  }

  def setMaxBufferedMessages(maxBufferedMessages: Int):MessageConsumer[T] = {
    asJava.setMaxBufferedMessages( )
  }

  def getMaxBufferedMessages():Int = {
    asJava.getMaxBufferedMessages( )
  }

  def completionHandler(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.completionHandler( )
  }

  def unregister():Unit = {
    asJava.unregister( )
  }

  def unregister(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.unregister( )
  }

}

object MessageConsumer{
//in object!
//static methods
}
