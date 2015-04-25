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

import io.vertx.scala.core.streams.ReadStream
import scala.util.Try
import io.vertx.core.Handler

class MessageConsumer[T](private val _asJava: io.vertx.core.eventbus.MessageConsumer[T]) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.eventbus.Message[T]] {

  def asJava: java.lang.Object = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.eventbus.Message[T] => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(Message.apply[T])(handler))
    this
  }

  def pause(): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def bodyStream(): io.vertx.scala.core.streams.ReadStream[T] = {
    ReadStream.apply[T](_asJava.bodyStream())
  }

  def isRegistered(): Boolean = {
    _asJava.isRegistered()
  }

  def address(): String = {
    _asJava.address()
  }

  def setMaxBufferedMessages(maxBufferedMessages: Int): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.setMaxBufferedMessages(maxBufferedMessages))
  }

  def getMaxBufferedMessages(): Int = {
    _asJava.getMaxBufferedMessages()
  }

  def completionHandler(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.completionHandler(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  def unregister(): Unit = {
    _asJava.unregister()
  }

  def unregister(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.unregister(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

}

object MessageConsumer {

  def apply[T](_asJava: io.vertx.core.eventbus.MessageConsumer[T]): io.vertx.scala.core.eventbus.MessageConsumer[T] =
    new io.vertx.scala.core.eventbus.MessageConsumer[T](_asJava)
}
