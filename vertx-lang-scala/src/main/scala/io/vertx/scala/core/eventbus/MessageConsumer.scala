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
import scala.reflect.runtime.universe._
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
class MessageConsumer[T:TypeTag](private val _asJava: Object, private val _useTypeTags:Boolean = false) 
    extends ReadStream[Message[T]] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[T]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Message[T]]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[T]].handler({x: JMessage[T] => handler.handle(Message[T](x))})
    this
  }

  override def pause():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[T]].pause()
    this
  }

  override def resume():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[T]].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[T]].endHandler({x: Void => endHandler.handle(x)})
    this
  }

//default methods
//basic methods
  def bodyStream():ReadStream[T] = {
    ReadStream[T](asJava.asInstanceOf[JMessageConsumer[T]].bodyStream())
  }

  def isRegistered():Boolean = {
    asJava.asInstanceOf[JMessageConsumer[T]].isRegistered().asInstanceOf[Boolean]
  }

  def address():String = {
    asJava.asInstanceOf[JMessageConsumer[T]].address().asInstanceOf[String]
  }

  def setMaxBufferedMessages(maxBufferedMessages: Int):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JMessageConsumer[T]].setMaxBufferedMessages(maxBufferedMessages.asInstanceOf[java.lang.Integer]))
  }

  def getMaxBufferedMessages():Int = {
    asJava.asInstanceOf[JMessageConsumer[T]].getMaxBufferedMessages().asInstanceOf[Int]
  }

  def completionHandler(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer[T]].completionHandler({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def unregister():Unit = {
    asJava.asInstanceOf[JMessageConsumer[T]].unregister()
  }

  def unregister(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer[T]].unregister({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

//future methods
  def completionFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMessageConsumer[T]].completionHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def unregisterFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JMessageConsumer[T]].unregister(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object MessageConsumer{
    def apply[T:TypeTag](asJava: Object, useTypeTags:Boolean = false) = new MessageConsumer[T](asJava, useTypeTags)  
  //static methods
  }
