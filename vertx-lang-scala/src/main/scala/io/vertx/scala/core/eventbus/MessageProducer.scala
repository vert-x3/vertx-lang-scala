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
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.eventbus.{Message => JMessage}
import scala.reflect.runtime.universe._
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents a stream of message that can be written to.
  * 
  */

class MessageProducer[T: TypeTag](private val _asJava: Object) extends WriteStream[T] {
  def asJava = _asJava




  override 
  def exceptionHandler(handler: Handler[Throwable]): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def write(data: T): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].write(toJava[T](data))
    this
  }


  override 
  def write(data: T, handler: Handler[AsyncResult[Unit]]): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].write(toJava[T](data), (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].drainHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Update the delivery options of this producer.   * @param options the new options see <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
   * @return this producer object
   */
  
  def deliveryOptions(options: DeliveryOptions): MessageProducer[T] = {
    asJava.asInstanceOf[JMessageProducer[Object]].deliveryOptions(options.asJava)
    this
  }


  /**
   * Same as [[io.vertx.scala.core.eventbus.MessageProducer#end]] but writes some data to the stream before ending.   * @param data the data to write
   */
  override def end(data: T): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].end(toJava[T](data))
  }

  /**
   * Same as  but with an `handler` called when the operation completes
   */
  override def end(data: T, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].end(toJava[T](data), (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.eventbus.MessageProducer#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JMessageProducer[Object]].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * This method actually sends a message using the send semantic regardless this producer
   * is a sender or a publisher.   * @param message the message to send
   * @return reference to this for fluency
   */
  def send (message: T): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JMessageProducer[Object]].send(toJava[T](message)))
  }

  /**
   * Like [[io.vertx.scala.core.eventbus.MessageProducer#send]] but specifying a `replyHandler` that will be called if the recipient
   * subsequently replies to the message.   * @param message the message to send
   * @param replyHandler reply handler will be called when any reply from the recipient is received, may be `null`
   * @return reference to this for fluency
   */
  def send [R: TypeTag](message: T, replyHandler: Handler[AsyncResult[Message[R]]]): MessageProducer[T] = {
    MessageProducer[T](asJava.asInstanceOf[JMessageProducer[Object]].send[Object](toJava[T](message), (if (replyHandler == null) null else new io.vertx.core.Handler[AsyncResult[JMessage[Object]]]{def handle(x: AsyncResult[JMessage[Object]]) {replyHandler.handle(AsyncResultWrapper[JMessage[Object], Message[R]](x, a => Message[R](a)))}})))
  }

  /**
   * @return The address to which the producer produces messages.
   */
  def address (): String = {
    asJava.asInstanceOf[JMessageProducer[Object]].address().asInstanceOf[String]
  }

  /**
   * Closes the producer, calls [[io.vertx.scala.core.eventbus.MessageProducer#close]]
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].end()
  }

  /**
   * Closes the producer, calls [[io.vertx.scala.core.eventbus.MessageProducer#close]]
   */
  override def end (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].end((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Closes the producer, this method should be called when the message producer is not used anymore.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].close()
  }

  /**
   * Same as [[io.vertx.scala.core.eventbus.MessageProducer#close]] but with an `handler` called when the operation completes
   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JMessageProducer[Object]].close((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (data: T): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageProducer[Object]].end(toJava[T](data), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[send]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFuture [R: TypeTag](message: T): scala.concurrent.Future[Message[R]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMessage[Object], Message[R]](x => Message[R](x))
    asJava.asInstanceOf[JMessageProducer[Object]].send[Object](toJava[T](message), promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def writeFuture (data: T): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageProducer[Object]].write(toJava[T](data), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageProducer[Object]].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMessageProducer[Object]].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MessageProducer {
  def apply[T: TypeTag](asJava: JMessageProducer[_]) = new MessageProducer[T](asJava)
  
}
