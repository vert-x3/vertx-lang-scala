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

package io.vertx.scala.core.eventbus;

import io.vertx.core.eventbus.DeliveryOptions
import io.vertx.scala.core.MultiMap
import scala.util.Try
import io.vertx.core.Handler

class Message[T](private val _asJava: io.vertx.core.eventbus.Message[T]) {

  def asJava: java.lang.Object = _asJava

  def address(): String = {
    _asJava.address()
  }

  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  def body(): T = {
    _asJava.body()
  }

  def replyAddress(): String = {
    _asJava.replyAddress()
  }

  def reply(message: AnyRef): Unit = {
    _asJava.reply(message)
  }

  def reply[R](message: AnyRef)(replyHandler: Try[io.vertx.scala.core.eventbus.Message[R]] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.reply(message, funcToMappedAsyncResultHandler(Message.apply[R])(replyHandler))
  }

  def reply(message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions): Unit = {
    _asJava.reply(message, options)
  }

  def reply[R](message: AnyRef, options: io.vertx.core.eventbus.DeliveryOptions)(replyHandler: Try[io.vertx.scala.core.eventbus.Message[R]] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.reply(message, options, funcToMappedAsyncResultHandler(Message.apply[R])(replyHandler))
  }

  def fail(failureCode: Int, message: String): Unit = {
    _asJava.fail(failureCode, message)
  }

}

object Message {

  def apply[T](_asJava: io.vertx.core.eventbus.Message[T]): io.vertx.scala.core.eventbus.Message[T] =
    new io.vertx.scala.core.eventbus.Message[T](_asJava)
}
