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
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents a message that is received from the event bus in a handler.
  * 
  * Messages have a [[io.vertx.scala.core.eventbus.Message#body]], which can be null, and also [[io.vertx.scala.core.eventbus.Message#headers]], which can be empty.
  * 
  * If the message was sent specifying a reply handler it will also have a [[io.vertx.scala.core.eventbus.Message#replyAddress]]. In that case the message
  * can be replied to using that reply address, or, more simply by just using [[io.vertx.scala.core.eventbus.Message#reply]].
  * 
  * If you want to notify the sender that processing failed, then [[io.vertx.scala.core.eventbus.Message#fail]] can be called.
  */
class Message[T](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:T = _

//cached methods
  def body():T = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JMessage[T]].body()
      cached_0 = tmp
    }
    cached_0
  }

//fluent methods
//default methods
//basic methods
  def address():String = {
    asJava.asInstanceOf[JMessage[T]].address().asInstanceOf[String]
  }

  def headers():MultiMap = {
    MultiMap(asJava.asInstanceOf[JMessage[T]].headers())
  }

  def replyAddress():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JMessage[T]].replyAddress().asInstanceOf[ String])
  }

  def isSend():Boolean = {
    asJava.asInstanceOf[JMessage[T]].isSend().asInstanceOf[Boolean]
  }

  def reply(message: AnyRef):Unit = {
    asJava.asInstanceOf[JMessage[T]].reply(message)
  }

  def reply[R](message: AnyRef,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage[T]].reply[R](message,{x: AsyncResult[JMessage[R]] => replyHandler.handle(AsyncResultWrapper[JMessage[R],Message[R]](x, a => Message[R](a)))})
  }

  def reply(message: AnyRef,options: DeliveryOptions):Unit = {
    asJava.asInstanceOf[JMessage[T]].reply(message,options.asJava)
  }

  def reply[R](message: AnyRef,options: DeliveryOptions,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage[T]].reply[R](message,options.asJava,{x: AsyncResult[JMessage[R]] => replyHandler.handle(AsyncResultWrapper[JMessage[R],Message[R]](x, a => Message[R](a)))})
  }

  def fail(failureCode: Int,message: String):Unit = {
    asJava.asInstanceOf[JMessage[T]].fail(failureCode.asInstanceOf[java.lang.Integer],message.asInstanceOf[java.lang.String])
  }

//future methods
def replyFuture[R](message: AnyRef):scala.concurrent.Future[Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[R], Message[R]](x => Message[R](x))
    asJava.asInstanceOf[JMessage[T]].reply[R](message,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

def replyFuture[R](message: AnyRef,options: DeliveryOptions):scala.concurrent.Future[Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[R], Message[R]](x => Message[R](x))
    asJava.asInstanceOf[JMessage[T]].reply[R](message,options.asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object Message{
    def apply[T](asJava: JMessage[T]) = new Message[T](asJava)  
  //static methods
  }
