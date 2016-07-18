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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler

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
class MessageConsumer[T](private val _asJava: io.vertx.core.eventbus.MessageConsumer[T]) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.eventbus.Message[T]] {

  def asJava: io.vertx.core.eventbus.MessageConsumer[T] = _asJava

  def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)((if(handler.isDefined) handler.get else null)))
    this
  }

  def handler(handler: scala.Option[io.vertx.scala.core.eventbus.Message[T] => Unit]): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    _asJava.handler(funcToMappedHandler(Message.apply[T])((if(handler.isDefined) handler.get else null)))
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

  def endHandler(endHandler: scala.Option[() => Unit]): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => (if(endHandler.isDefined) endHandler.get else null)()))
    this
  }

  /**
    * @return a read stream for the body of the message stream.
    */
  def bodyStream(): io.vertx.scala.core.streams.ReadStream[T] = {
    ReadStream.apply[T](_asJava.bodyStream())
  }

  /**
    * @return true if the current consumer is registered
    */
  def isRegistered(): Boolean = {
    _asJava.isRegistered()
  }

  /**
    * @return The address the handler was registered with.
    */
  def address(): String = {
    _asJava.address()
  }

  /**
    * Set the number of messages this registration will buffer when this stream is paused. The default
    * value is <code>0</code>. When a new value is set, buffered messages may be discarded to reach
    * the new value.
    * @param maxBufferedMessages the maximum number of messages that can be buffered
    * @return this registration
    */
  def setMaxBufferedMessages(maxBufferedMessages: Int): io.vertx.scala.core.eventbus.MessageConsumer[T] = {
    MessageConsumer.apply[T](_asJava.setMaxBufferedMessages(maxBufferedMessages))
  }

  /**
    * @return the maximum number of messages that can be buffered when this stream is paused
    */
  def getMaxBufferedMessages(): Int = {
    _asJava.getMaxBufferedMessages()
  }

  /**
    * Optional method which can be called to indicate when the registration has been propagated across the cluster.
    * @return the completion handler
    */
  def completionHandler(completionHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.completionHandler(funcToHandler(completionHandler))
  }

  /**
    * Unregisters the handler which created this registration
    */
  def unregister(): Unit = {
    _asJava.unregister()
  }

  /**
    * Unregisters the handler which created this registration
    * @return the handler called when the unregister is done. For example in a cluster when all nodes of the event bus have been unregistered.
    */
  def unregister(completionHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.unregister(funcToHandler(completionHandler))
  }

}

object MessageConsumer {

  def apply[T](_asJava: io.vertx.core.eventbus.MessageConsumer[T]): io.vertx.scala.core.eventbus.MessageConsumer[T] =
    new io.vertx.scala.core.eventbus.MessageConsumer(_asJava)
}
