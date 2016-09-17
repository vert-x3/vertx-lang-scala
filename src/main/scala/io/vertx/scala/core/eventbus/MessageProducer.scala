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
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.Handler

/**
  * Represents a stream of message that can be written to.
  * 
  */
class MessageProducer[T](private val _asJava: io.vertx.core.eventbus.MessageProducer[T]) 
    extends io.vertx.scala.core.streams.WriteStream[T] {

  def asJava: io.vertx.core.eventbus.MessageProducer[T] = _asJava

  /**
    * Same as [[io.vertx.scala.core.eventbus.MessageProducer#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit = {
    _asJava.end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.eventbus.MessageProducer#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  /**
    * Synonym for [[io.vertx.scala.core.eventbus.MessageProducer#write]].
    * @param message the message to send
    * @return reference to this for fluency
    */
  def send(message: T): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    MessageProducer.apply[T](_asJava.send(message))
  }

  def sendFuture[R](message: T): concurrent.Future[io.vertx.scala.core.eventbus.Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.eventbus.Message[R],io.vertx.scala.core.eventbus.Message[R]]((x => if (x == null) null else Message.apply[R](x)))
    MessageProducer.apply[T](_asJava.send(message, promiseAndHandler._1))
    promiseAndHandler._2.future
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: T): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    _asJava.write(data)
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Update the delivery options of this producer.
    * @param options the new optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return this producer object
    */
  def deliveryOptions(options: io.vertx.scala.core.eventbus.DeliveryOptions): io.vertx.scala.core.eventbus.MessageProducer[T] = {
    _asJava.deliveryOptions(options.asJava)
    this
  }

  /**
    * @return The address to which the producer produces messages.
    */
  def address(): String = {
    _asJava.address()
  }

  /**
    * Closes the producer, calls [[io.vertx.scala.core.eventbus.MessageProducer#close]]
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Closes the producer, this method should be called when the message producer is not used anymore.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object MessageProducer {

  def apply[T](_asJava: io.vertx.core.eventbus.MessageProducer[T]): io.vertx.scala.core.eventbus.MessageProducer[T] =
    new io.vertx.scala.core.eventbus.MessageProducer(_asJava)

}
