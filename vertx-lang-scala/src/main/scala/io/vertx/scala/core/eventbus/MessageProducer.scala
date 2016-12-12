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
import io.vertx.core.eventbus.{MessageProducer => JMessageProducer}
import io.vertx.core.eventbus.{DeliveryOptions => JDeliveryOptions}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.eventbus.{Message => JMessage}

/**
  * Represents a stream of message that can be written to.
  * 
  */
class MessageProducer[T: TypeTag](private val _asJava: JMessageProducer[Object]) 
    extends WriteStream[T] {

  def asJava: JMessageProducer[Object] = _asJava

  /**
    * Same as [[io.vertx.scala.core.eventbus.MessageProducer#end]] but writes some data to the stream before ending.
    */
  def end(t: T): Unit = {
    asJava.end(toJava[T](t).asInstanceOf[Object])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.eventbus.MessageProducer#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.writeQueueFull()
  }

  /**
    * Synonym for [[io.vertx.scala.core.eventbus.MessageProducer#write]].
    * @param message the message to send
    * @return reference to this for fluency
    */
  def send(message: T): MessageProducer[T] = {
    MessageProducer.apply[T](asJava.send(toJava[T](message).asInstanceOf[Object]))
  }

  def sendFuture[R: TypeTag](message: T): concurrent.Future[Message[R]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Message[R]]((x => if (x == null) null else Message.apply[R](x.asInstanceOf)))
    MessageProducer.apply[T](asJava.send(toJava[T](message).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[Object]]]]))
    promiseAndHandler._2.future
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): MessageProducer[T] = {
    asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def write(data: T): MessageProducer[T] = {
    asJava.write(toJava[T](data).asInstanceOf[Object])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): MessageProducer[T] = {
    asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: io.vertx.core.Handler[Unit]): MessageProducer[T] = {
    asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * Update the delivery options of this producer.
    * @param options the new optionssee <a href="../../../../../../../cheatsheet/DeliveryOptions.html">DeliveryOptions</a>
    * @return this producer object
    */
  def deliveryOptions(options: DeliveryOptions): MessageProducer[T] = {
    asJava.deliveryOptions(options.asJava)
    this
  }

  /**
    * @return The address to which the producer produces messages.
    */
  def address(): String = {
    asJava.address()
  }

  /**
    * Closes the producer, calls [[io.vertx.scala.core.eventbus.MessageProducer#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Closes the producer, this method should be called when the message producer is not used anymore.
    */
  def close(): Unit = {
    asJava.close()
  }

}

object MessageProducer {

  def apply[T: TypeTag](_asJava: JMessageProducer[Object]): MessageProducer[T] =
    new MessageProducer(_asJava)

}
