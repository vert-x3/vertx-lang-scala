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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.eventbus.{Message => JMessage}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap

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
class Message[T: TypeTag](private val _asJava: Object) {

  def asJava: Object = _asJava

  /**
    * The address the message was sent to
    */
  def address(): String = {
    asJava.asInstanceOf[JMessage[Object]].address()
  }

  /**
    * Multi-map of message headers. Can be empty
    * @return the headers
    */
  def headers(): MultiMap = {
    MultiMap.apply(asJava.asInstanceOf[JMessage[Object]].headers())
  }

  /**
    * The body of the message. Can be null.
    * @return the body, or null.
    */
  def body(): T = {
    if (cached_0 == null) {
      cached_0 = toScala[T](asJava.asInstanceOf[JMessage[Object]].body()).asInstanceOf
    }
    cached_0
  }

  /**
    * The reply address. Can be null.
    * @return the reply address, or null, if message was sent without a reply handler.
    */
  def replyAddress(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JMessage[Object]].replyAddress())
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
    asJava.asInstanceOf[JMessage[Object]].reply(toJava[java.lang.Object](message).asInstanceOf[Object])
  }

  /**
    * The same as `reply(R message)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the message to reply with.
    * @return the reply future for the reply.
    */
  def replyFuture[R: TypeTag](message: AnyRef): concurrent.Future[Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Message[R]]((x => if (x == null) null else Message.apply[R](x.asInstanceOf)))
    asJava.asInstanceOf[JMessage[Object]].reply(toJava[java.lang.Object](message).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[Object]]]])
    promiseAndHandler._2.future
  }

  /**
    * Link [[io.vertx.scala.core.eventbus.Message#reply]] but allows you to specify delivery options for the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    */
  def reply(message: AnyRef, options: DeliveryOptions): Unit = {
    asJava.asInstanceOf[JMessage[Object]].reply(toJava[java.lang.Object](message).asInstanceOf[Object], options.asJava)
  }

  /**
    * The same as `reply(R message, DeliveryOptions)` but you can specify handler for the reply - i.e.
    * to receive the reply to the reply.
    * @param message the reply message
    * @param options the delivery optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return the reply future for the reply.
    */
  def replyFuture[R: TypeTag](message: AnyRef, options: DeliveryOptions): concurrent.Future[Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Message[R]]((x => if (x == null) null else Message.apply[R](x.asInstanceOf)))
    asJava.asInstanceOf[JMessage[Object]].reply(toJava[java.lang.Object](message).asInstanceOf[Object], options.asJava, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[Object]]]])
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
    asJava.asInstanceOf[JMessage[Object]].fail(failureCode, message)
  }

  private var cached_0: T = _
}

object Message {

  def apply[T: TypeTag](_asJava: Object): Message[T] =
    new Message(_asJava)

}
