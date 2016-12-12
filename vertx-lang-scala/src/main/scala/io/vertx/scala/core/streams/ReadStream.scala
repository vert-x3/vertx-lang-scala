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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.{StreamBase => JStreamBase}

/**
  * Represents a stream of items that can be read from.
  * 
  * Any class that implements this interface can be used by a [[io.vertx.scala.core.streams.Pump]] to pump data from it
  * to a [[io.vertx.scala.core.streams.WriteStream]].
  */
trait ReadStream[T] 
    extends StreamBase {

  def asJava: java.lang.Object

  /**
  * Set an exception handler on the read stream.
  * @param handler the exception handler
  * @return a reference to this, so the API can be used fluently
  */
  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): ReadStream[T]

  /**
  * Set a data handler. As data is read, the handler will be called with the data.
  * @return a reference to this, so the API can be used fluently
  */
  def handler(handler: io.vertx.core.Handler[T]): ReadStream[T]

  /**
  * Pause the `ReadSupport`. While it's paused, no data will be sent to the `dataHandler`
  * @return a reference to this, so the API can be used fluently
  */
  def pause(): ReadStream[T]

  /**
  * Resume reading. If the `ReadSupport` has been paused, reading will recommence on it.
  * @return a reference to this, so the API can be used fluently
  */
  def resume(): ReadStream[T]

  /**
  * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
  * @return a reference to this, so the API can be used fluently
  */
  def endHandler(endHandler: io.vertx.core.Handler[Unit]): ReadStream[T]

}

object ReadStream {

  def apply[T: TypeTag](_asJava: JReadStream[Object]): ReadStream[T] =
    new ReadStreamImpl[T](_asJava)

  private class ReadStreamImpl[T: TypeTag](private val _asJava: JReadStream[Object]) extends ReadStream[T] {

  def asJava: JReadStream[Object] = _asJava

  /**
    * Set an exception handler on the read stream.
    * @param handler the exception handler
    * @return a reference to this, so the API can be used fluently
    */
  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): ReadStream[T] = {
    asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  /**
    * Set a data handler. As data is read, the handler will be called with the data.
    * @return a reference to this, so the API can be used fluently
    */
  def handler(handler: io.vertx.core.Handler[T]): ReadStream[T] = {
    asJava.handler((handler).asInstanceOf[io.vertx.core.Handler[Object]])
    this
  }

  /**
    * Pause the `ReadSupport`. While it's paused, no data will be sent to the `dataHandler`
    * @return a reference to this, so the API can be used fluently
    */
  def pause(): ReadStream[T] = {
    asJava.pause()
    this
  }

  /**
    * Resume reading. If the `ReadSupport` has been paused, reading will recommence on it.
    * @return a reference to this, so the API can be used fluently
    */
  def resume(): ReadStream[T] = {
    asJava.resume()
    this
  }

  /**
    * Set an end handler. Once the stream has ended, and there is no more data to be read, this handler will be called.
    * @return a reference to this, so the API can be used fluently
    */
  def endHandler(endHandler: io.vertx.core.Handler[Unit]): ReadStream[T] = {
    asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  }

}
