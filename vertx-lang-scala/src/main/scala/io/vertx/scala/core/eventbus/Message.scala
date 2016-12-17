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

import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{Message => JMessage}
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
  
//methods returning a future
  def reply[R](message: AnyRef,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage].reply(message,replyHandler)
  }

  def reply[R](message: AnyRef,options: DeliveryOptions,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage].reply(message,options.asJava.asInstanceOf[JDeliveryOptions],replyHandler)
  }

//cached methods
  def body():T = {
    if(cached_0 == null)
      cached_0 = asJava.asInstanceOf[JMessage].body()
    return cached_0
  }

//fluent methods
//basic methods
  def address():String = {
    asJava.asInstanceOf[JMessage].address()
  }

  def headers():MultiMap = {
    MultiMap(asJava.asInstanceOf[JMessage].headers())
  }

  def replyAddress():String = {
    asJava.asInstanceOf[JMessage].replyAddress()
  }

  def reply(message: AnyRef):Unit = {
    asJava.asInstanceOf[JMessage].reply(message)
  }

  def reply[R](message: AnyRef,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage].reply(message,replyHandler)
  }

  def reply(message: AnyRef,options: DeliveryOptions):Unit = {
    asJava.asInstanceOf[JMessage].reply(message,options.asJava.asInstanceOf[JDeliveryOptions])
  }

  def reply[R](message: AnyRef,options: DeliveryOptions,replyHandler: Handler[AsyncResult[Message[R]]]):Unit = {
    asJava.asInstanceOf[JMessage].reply(message,options.asJava.asInstanceOf[JDeliveryOptions],replyHandler)
  }

  def fail(failureCode: Int,message: String):Unit = {
    asJava.asInstanceOf[JMessage].fail(failureCode,message)
  }

}

object Message{
  def apply(asJava: JMessage) = new Message(asJava)//static methods
}
