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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
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


//methods returning a future
  def completionHandler(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer].completionHandler(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def unregister(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer].unregister(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer].exceptionHandler(x => handler.handle(x))
    this
  }

  override def handler(handler: Handler[Message[T]]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer].handler(x => handler.handle(x.asJava.asInstanceOf[JMessage[T]]))
    this
  }

  override def pause():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer].pause()
    this
  }

  override def resume():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer].endHandler(x => endHandler.handle(x))
    this
  }

//basic methods
  def bodyStream():ReadStream[T] = {
    ReadStream<T>(asJava.asInstanceOf[JMessageConsumer].bodyStream())
  }

  def isRegistered():Boolean = {
    asJava.asInstanceOf[JMessageConsumer].isRegistered()
  }

  def address():String = {
    asJava.asInstanceOf[JMessageConsumer].address()
  }

  def setMaxBufferedMessages(maxBufferedMessages: Int):MessageConsumer[T] = {
    MessageConsumer<T>(asJava.asInstanceOf[JMessageConsumer].setMaxBufferedMessages(maxBufferedMessages))
  }

  def getMaxBufferedMessages():Int = {
    asJava.asInstanceOf[JMessageConsumer].getMaxBufferedMessages()
  }

  def completionHandler(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer].completionHandler(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

  def unregister():Unit = {
    asJava.asInstanceOf[JMessageConsumer].unregister()
  }

  def unregister(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer].unregister(x => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

}

object MessageConsumer{
  def apply(asJava: JMessageConsumer) = new MessageConsumer(asJava)
//static methods
}
