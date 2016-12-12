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

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream

/**
  * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
  * it can be once or several times depending on the nature of the timer related to this stream. The
  *  will be called after the timer handler has been called.
  * 
  * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
  * the timer.
  */
class TimeoutStream(private val _asJava: JTimeoutStream) 
    extends ReadStream[Long] {

  def asJava: JTimeoutStream = _asJava

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): TimeoutStream = {
    asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Long]): TimeoutStream = {
    asJava.handler(funcToMappedHandler[java.lang.Long, Long](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Long]])
    this
  }

  def pause(): TimeoutStream = {
    asJava.pause()
    this
  }

  def resume(): TimeoutStream = {
    asJava.resume()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): TimeoutStream = {
    asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * Cancels the timeout. Note this has the same effect as calling [[io.vertx.scala.core.TimeoutStream#handler]] with a null
    * argument.
    */
  def cancel(): Unit = {
    asJava.cancel()
  }

}

object TimeoutStream {

  def apply(_asJava: JTimeoutStream): TimeoutStream =
    new TimeoutStream(_asJava)

}
