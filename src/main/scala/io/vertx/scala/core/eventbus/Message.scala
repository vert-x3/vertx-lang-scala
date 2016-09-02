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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.scala.core.MultiMap
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
class Message[T](private val _asJava: io.vertx.core.eventbus.Message[T]) {

  def asJava: io.vertx.core.eventbus.Message[T] = _asJava

  /**
    * The address the message was sent to
    */
  def address(): String = {
    _asJava.address()
  }

  /**
    * Multi-map of message headers. Can be empty
    * @return the headers
    */
  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  /**
    * The body of the message. Can be null.
    * @return the body, or null.
    */
  def body(): T = {
    if(cached_0 == null) {
      cached_0=    _asJava.body()
    }
    cached_0
  }

  /**
    * The reply address. Can be null.
    * @return the reply address, or null, if message was sent without a reply handler.
    */
  def replyAddress(): scala.Option[String] = {
        scala.Option(_asJava.replyAddress())
  }

  /**
    * Reply to this message.
    * 
    * If the message was sent specifying a reply handler, that handler will be
    * called when it has received a reply. If the message wasn't sent specifying a receipt handler
    * this method does nothing.
    * @param message the message to reply with.
    */
  def reply(message: AnyRef): Unit = {
    _asJava.reply(message)
  }

  /**
    * The same as `reply(R message)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the message to reply with.
    * @return the reply future for the reply.
    */
  def replyFuture[R](message: AnyRef): concurrent.Future[io.vertx.scala.core.eventbus.Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.eventbus.Message[R],io.vertx.scala.core.eventbus.Message[R]]((x => if (x == null) null else Message.apply[R](x)))
    _asJava.reply(message, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Link [[io.vertx.scala.core.eventbus.Message#reply]] but allows you to specify delivery options for the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    */
  def reply(message: AnyRef, options: io.vertx.scala.core.eventbus.DeliveryOptions): Unit = {
    _asJava.reply(message, options.asJava)
  }

  /**
    * The same as `reply(R message, DeliveryOptions)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return the reply future for the reply.
    */
  def replyFuture[R](message: AnyRef, options: io.vertx.scala.core.eventbus.DeliveryOptions): concurrent.Future[io.vertx.scala.core.eventbus.Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.eventbus.Message[R],io.vertx.scala.core.eventbus.Message[R]]((x => if (x == null) null else Message.apply[R](x)))
    _asJava.reply(message, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Signal to the sender that processing of this message failed.
    * 
    * If the message was sent specifying a result handler
    * the handler will be called with a failure corresponding to the failure code and message specified here.
    * @param failureCode A failure code to pass back to the sender
    * @param message A message to pass back to the sender
    */
  def fail(failureCode: Int, message: String): Unit = {
    _asJava.fail(failureCode, message)
  }

  private var cached_0: T = _
}

object Message {

  def apply[T](_asJava: io.vertx.core.eventbus.Message[T]): io.vertx.scala.core.eventbus.Message[T] =
    new io.vertx.scala.core.eventbus.Message(_asJava)

}
