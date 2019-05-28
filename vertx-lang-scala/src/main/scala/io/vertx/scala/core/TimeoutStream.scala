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

package io.vertx.scala.core

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
  * it can be once or several times depending on the nature of the timer related to this stream. The
  *  will be called after the timer handler has been called.
  * 
  * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
  * the timer.
  */

class TimeoutStream(private val _asJava: Object) extends ReadStream[Long] {
  def asJava = _asJava




  override 
  def exceptionHandler(handler: Handler[Throwable]): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[Long]): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].handler((if (handler == null) null else new io.vertx.core.Handler[java.lang.Long]{def handle(x: java.lang.Long) {handler.handle(x.asInstanceOf[Long])}}))
    this
  }


  override 
  def pause(): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].pause()
    this
  }


  override 
  def resume(): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].resume()
    this
  }


  override 
  def fetch(amount: Long): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[Long] = {
    Pipe[Long](asJava.asInstanceOf[JTimeoutStream].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[Long]): Unit = {
    asJava.asInstanceOf[JTimeoutStream].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.Long]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  override def pipeTo(dst: WriteStream[Long], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JTimeoutStream].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.Long]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * Cancels the timeout. Note this has the same effect as calling [[io.vertx.scala.core.TimeoutStream#handler]] with a null
   * argument.
   */
  def cancel (): Unit = {
    asJava.asInstanceOf[JTimeoutStream].cancel()
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[Long]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTimeoutStream].pipeTo(dst.asJava.asInstanceOf[JWriteStream[java.lang.Long]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object TimeoutStream {
  def apply(asJava: JTimeoutStream) = new TimeoutStream(asJava)
  
}
