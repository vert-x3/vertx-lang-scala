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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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
class MessageConsumer[T:TypeTag](private val _asJava: Object) 
    extends ReadStream[Message[T]] {

  def asJava = _asJava

//io.vertx.core.Handler<java.lang.Throwable>
  override def exceptionHandler(handler: Handler[Throwable]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[Object]].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//io.vertx.core.Handler<io.vertx.core.eventbus.Message<T>>
  override def handler(handler: Handler[Message[T]]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[Object]].handler({x: JMessage[Object] => handler.handle(Message[T](x))})
    this
  }

  override def pause():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[Object]].pause()
    this
  }

  override def resume():MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[Object]].resume()
    this
  }

//io.vertx.core.Handler<java.lang.Void>
  override def endHandler(endHandler: Handler[Unit]):MessageConsumer[T] = {
    asJava.asInstanceOf[JMessageConsumer[Object]].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  /**
    * @return a read stream for the body of the message stream.
    */
  def bodyStream():ReadStream[T] = {
    ReadStream[T](asJava.asInstanceOf[JMessageConsumer[Object]].bodyStream())
  }

  /**
    * @return true if the current consumer is registered
    */
  def isRegistered():Boolean = {
    asJava.asInstanceOf[JMessageConsumer[Object]].isRegistered().asInstanceOf[Boolean]
  }

  /**
    * @return The address the handler was registered with.
    */
  def address():String = {
    asJava.asInstanceOf[JMessageConsumer[Object]].address().asInstanceOf[String]
  }

  /**
    * Set the number of messages this registration will buffer when this stream is paused. The default
    * value is <code>0</code>. When a new value is set, buffered messages may be discarded to reach
    * the new value.
    * @param maxBufferedMessages the maximum number of messages that can be buffered
    * @return this registration
    */
  def setMaxBufferedMessages(maxBufferedMessages: Int):MessageConsumer[T] = {
    MessageConsumer[T](asJava.asInstanceOf[JMessageConsumer[Object]].setMaxBufferedMessages(maxBufferedMessages.asInstanceOf[java.lang.Integer]))
  }

  /**
    * @return the maximum number of messages that can be buffered when this stream is paused
    */
  def getMaxBufferedMessages():Int = {
    asJava.asInstanceOf[JMessageConsumer[Object]].getMaxBufferedMessages().asInstanceOf[Int]
  }

  /**
    * Optional method which can be called to indicate when the registration has been propagated across the cluster.
    */
  def completionHandler(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer[Object]].completionHandler({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * Unregisters the handler which created this registration
    */
  def unregister():Unit = {
    asJava.asInstanceOf[JMessageConsumer[Object]].unregister()
  }

  /**
    * Unregisters the handler which created this registration
    */
  def unregister(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JMessageConsumer[Object]].unregister({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Optional method which can be called to indicate when the registration has been propagated across the cluster.
   * @return the completion future
   */
    def completionFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageConsumer[Object]].completionHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Unregisters the handler which created this registration
   * @return the future called when the unregister is done. For example in a cluster when all nodes of the event bus have been unregistered.
   */
    def unregisterFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageConsumer[Object]].unregister(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MessageConsumer{
  def apply[T:TypeTag](asJava: JMessageConsumer[_]) = new MessageConsumer[T](asJava)  
}
