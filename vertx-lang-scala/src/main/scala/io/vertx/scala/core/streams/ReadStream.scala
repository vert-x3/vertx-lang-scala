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

package io.vertx.scala.core.streams

import io.vertx.core.streams.{StreamBase => JStreamBase}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents a stream of items that can be read from.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from it
  * to a [[io.vertx.scala.core.streams.WriteStream]].
  * 
  * <h3>Streaming mode</h3>
  * The stream is either in <i>flowing</i> or <i>fetch</i> mode.
  * <ul>
  *   <i>Initially the stream is in <i>flowing</i> mode.</i>
  *   <li>When the stream is in <i>flowing</i> mode, elements are delivered to the `handler`.</li>
  *   <li>When the stream is in <i>fetch</i> mode, only the number of requested elements will be delivered to the `handler`.</li>
  * </ul>
  * The mode can be changed with the [[io.vertx.scala.core.streams.ReadStream#pause]], [[io.vertx.scala.core.streams.ReadStream#resume]] and [[io.vertx.scala.core.streams.ReadStream#fetch]] methods:
  * <ul>
  *   <li>Calling [[io.vertx.scala.core.streams.ReadStream#resume]] sets the <i>flowing</i> mode</li>
  *   <li>Calling [[io.vertx.scala.core.streams.ReadStream#pause]] sets the <i>fetch</i> mode and resets the demand to `0`</li>
  *   <li>Calling [[io.vertx.scala.core.streams.ReadStream#fetch]] requests a specific amount of elements and adds it to the actual demand</li>
  * </ul>
  */

trait ReadStream[T] extends StreamBase {
  def asJava: java.lang.Object

    /**
   * Set an exception handler on the read stream.   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
override def exceptionHandler ( handler: Handler[Throwable]): ReadStream[T]    /**
   * Set a data handler. As data is read, the handler will be called with the data.   * @return a reference to this, so the API can be used fluently
   */
def handler ( handler: Handler[T]): ReadStream[T]    /**
   * Pause the `ReadStream`, it sets the buffer in `fetch` mode and clears the actual demand.
   * 
   * While it's paused, no data will be sent to the data `handler`.   * @return a reference to this, so the API can be used fluently
   */
def pause ( ): ReadStream[T]    /**
   * Resume reading, and sets the buffer in `flowing` mode.
   * <p/>
   * If the `ReadStream` has been paused, reading will recommence on it.   * @return a reference to this, so the API can be used fluently
   */
def resume ( ): ReadStream[T]    /**
   * Fetch the specified `amount` of elements. If the `ReadStream` has been paused, reading will
   * recommence with the specified `amount` of items, otherwise the specified `amount` will
   * be added to the current stream demand.   * @return a reference to this, so the API can be used fluently
   */
def fetch ( amount: Long): ReadStream[T]    /**
   * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.   * @return a reference to this, so the API can be used fluently
   */
def endHandler ( endHandler: Handler[Unit]): ReadStream[T]    /**
   * Pause this stream and return a [[io.vertx.scala.core.streams.Pipe]] to transfer the elements of this stream to a destination [[io.vertx.scala.core.streams.WriteStream]].
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
def pipe ( ): Pipe[T]    /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
def pipeTo ( dst: WriteStream[T]): Unit    /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
def pipeTo ( dst: WriteStream[T], handler: Handler[AsyncResult[Unit]]): Unit

   /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
def pipeToFuture ( dst: WriteStream[T]): scala.concurrent.Future[Unit]
}

object ReadStream {
  def apply[T: TypeTag](asJava: JReadStream[_]): ReadStream[T] = new ReadStreamImpl[T](asJava)
    private class ReadStreamImpl[T: TypeTag](private val _asJava: Object) extends ReadStream[T] {
  def asJava = _asJava



  /**
   * Set an exception handler on the read stream.   * @param handler the exception handler
   * @return a reference to this, so the API can be used fluently
   */
  override 
  def exceptionHandler(handler: Handler[Throwable]): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   * Set a data handler. As data is read, the handler will be called with the data.   * @return a reference to this, so the API can be used fluently
   */
  
  def handler(handler: Handler[T]): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].handler((if (handler == null) null else new io.vertx.core.Handler[Object]{def handle(x: Object) {handler.handle(toScala[T](x))}}))
    this
  }

  /**
   * Pause the `ReadStream`, it sets the buffer in `fetch` mode and clears the actual demand.
   * 
   * While it's paused, no data will be sent to the data `handler`.   * @return a reference to this, so the API can be used fluently
   */
  
  def pause(): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].pause()
    this
  }

  /**
   * Resume reading, and sets the buffer in `flowing` mode.
   * <p/>
   * If the `ReadStream` has been paused, reading will recommence on it.   * @return a reference to this, so the API can be used fluently
   */
  
  def resume(): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].resume()
    this
  }

  /**
   * Fetch the specified `amount` of elements. If the `ReadStream` has been paused, reading will
   * recommence with the specified `amount` of items, otherwise the specified `amount` will
   * be added to the current stream demand.   * @return a reference to this, so the API can be used fluently
   */
  
  def fetch(amount: Long): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.   * @return a reference to this, so the API can be used fluently
   */
  
  def endHandler(endHandler: Handler[Unit]): ReadStream[T] = {
    asJava.asInstanceOf[JReadStream[Object]].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  /**
   * Pause this stream and return a [[io.vertx.scala.core.streams.Pipe]] to transfer the elements of this stream to a destination [[io.vertx.scala.core.streams.WriteStream]].
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  def pipe(): Pipe[T] = {
    Pipe[T](asJava.asInstanceOf[JReadStream[Object]].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  def pipeTo(dst: WriteStream[T]): Unit = {
    asJava.asInstanceOf[JReadStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  def pipeTo(dst: WriteStream[T], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JReadStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }



 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pipeToFuture (dst: WriteStream[T]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JReadStream[Object]].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Object]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
}
