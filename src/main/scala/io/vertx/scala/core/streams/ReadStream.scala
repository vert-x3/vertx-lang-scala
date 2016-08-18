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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * Represents a stream of items that can be read from.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from it
  * to a [[io.vertx.scala.core.streams.WriteStream]].
  */
trait ReadStream[T] 
    extends io.vertx.scala.core.streams.StreamBase {

  def asJava: java.lang.Object

  /**
  * Set an exception handler on the read stream.
  * @param handler the exception handler
  * @return a reference to this, so the API can be used fluently
  */
  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.streams.ReadStream[T]

  /**
  * Set a data handler. As data is read, the handler will be called with the data.
  * @return a reference to this, so the API can be used fluently
  */
  def handler(handler: T => Unit): io.vertx.scala.core.streams.ReadStream[T]

  /**
  * Pause the `ReadSupport`. While it's paused, no data will be sent to the `dataHandler`
  * @return a reference to this, so the API can be used fluently
  */
  def pause(): io.vertx.scala.core.streams.ReadStream[T]

  /**
  * Resume reading. If the `ReadSupport` has been paused, reading will recommence on it.
  * @return a reference to this, so the API can be used fluently
  */
  def resume(): io.vertx.scala.core.streams.ReadStream[T]

  /**
  * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
  * @return a reference to this, so the API can be used fluently
  */
  def endHandler(endHandler: () => Unit): io.vertx.scala.core.streams.ReadStream[T]

}

object ReadStream {

  def apply[T](_asJava: io.vertx.core.streams.ReadStream[T]): io.vertx.scala.core.streams.ReadStream[T] =
    new ReadStreamImpl[T](_asJava)

  private class ReadStreamImpl[T](private val _asJava: io.vertx.core.streams.ReadStream[T]) extends ReadStream[T] {

    def asJava: io.vertx.core.streams.ReadStream[T] = _asJava

    /**
      * Set an exception handler on the read stream.
      * @param handler the exception handler
      * @return a reference to this, so the API can be used fluently
      */
    def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
        _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
      this
    }

    /**
      * Set a data handler. As data is read, the handler will be called with the data.
      * @return a reference to this, so the API can be used fluently
      */
    def handler(handler: T => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
        _asJava.handler(funcToHandler(handler))
      this
    }

    /**
      * Pause the `ReadSupport`. While it's paused, no data will be sent to the `dataHandler`
      * @return a reference to this, so the API can be used fluently
      */
    def pause(): io.vertx.scala.core.streams.ReadStream[T] = {
        _asJava.pause()
      this
    }

    /**
      * Resume reading. If the `ReadSupport` has been paused, reading will recommence on it.
      * @return a reference to this, so the API can be used fluently
      */
    def resume(): io.vertx.scala.core.streams.ReadStream[T] = {
        _asJava.resume()
      this
    }

    /**
      * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
      * @return a reference to this, so the API can be used fluently
      */
    def endHandler(endHandler: () => Unit): io.vertx.scala.core.streams.ReadStream[T] = {
        _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
      this
    }

  }

}
