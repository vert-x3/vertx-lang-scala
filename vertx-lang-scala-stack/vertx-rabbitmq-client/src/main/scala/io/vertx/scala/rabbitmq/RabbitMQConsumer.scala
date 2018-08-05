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

package io.vertx.scala.rabbitmq

import io.vertx.rabbitmq.{RabbitMQConsumer => JRabbitMQConsumer}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.rabbitmq.{RabbitMQMessage => JRabbitMQMessage}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A stream of messages from a rabbitmq queue.

  */

class RabbitMQConsumer(private val _asJava: Object) extends ReadStream[RabbitMQMessage] {
  def asJava = _asJava



  /**
   * Set an exception handler on the read stream.   * @param exceptionHandler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def exceptionHandler(exceptionHandler: Handler[Throwable]): RabbitMQConsumer = {
    asJava.asInstanceOf[JRabbitMQConsumer].exceptionHandler({x: Throwable => exceptionHandler.handle(x)})
    this
  }

  /**
   * Set a message handler. As message appear in a queue, the handler will be called with the message.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def handler(messageArrived: Handler[RabbitMQMessage]): RabbitMQConsumer = {
    asJava.asInstanceOf[JRabbitMQConsumer].handler({x: JRabbitMQMessage => messageArrived.handle(RabbitMQMessage(x))})
    this
  }

  /**
   * Pause the stream of incoming messages from queue.
   * 
   * The messages will continue to arrive, but they will be stored in a internal queue.
   * If the queue size would exceed the limit provided by , then incoming messages will be discarded.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def pause(): RabbitMQConsumer = {
    asJava.asInstanceOf[JRabbitMQConsumer].pause()
    this
  }

  /**
   * Resume reading from a queue. Flushes internal queue.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def resume(): RabbitMQConsumer = {
    asJava.asInstanceOf[JRabbitMQConsumer].resume()
    this
  }

  /**
   * Set an end handler. Once the stream has canceled successfully, the handler will be called.   * @return a reference to this, so the API can be used fluently
   */
  override 
  def endHandler(endHandler: Handler[Unit]): RabbitMQConsumer = {
    asJava.asInstanceOf[JRabbitMQConsumer].endHandler({x: Void => endHandler.handle(x)})
    this
  }



  /**
   * @return a consumer tag
   */
  def consumerTag (): String = {
    asJava.asInstanceOf[JRabbitMQConsumer].consumerTag().asInstanceOf[String]
  }

  /**
   * Stop message consumption from a queue.
   * 
   * The operation is asynchronous. When consumption will be stopped, you can by notified via [[io.vertx.scala.rabbitmq.RabbitMQConsumer#endHandler]]
   */
  def cancel (): Unit = {
    asJava.asInstanceOf[JRabbitMQConsumer].cancel()
  }

  /**
   * Stop message consumption from a queue.
   * 
   * The operation is asynchronous. When consumption will be stopped, you can by notified via [[io.vertx.scala.rabbitmq.RabbitMQConsumer#endHandler]]   * @param cancelResult contains information about operation status: success/fail.
   */
  def cancel (cancelResult: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JRabbitMQConsumer].cancel({x: AsyncResult[Void] => cancelResult.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * @return is the stream paused?
   */
  def isPaused (): Boolean = {
    asJava.asInstanceOf[JRabbitMQConsumer].isPaused().asInstanceOf[Boolean]
  }


 /**
  * Like [[cancel]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def cancelFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JRabbitMQConsumer].cancel(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object RabbitMQConsumer {
  def apply(asJava: JRabbitMQConsumer) = new RabbitMQConsumer(asJava)
  
}
