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

import io.vertx.core.{TimeoutStream => JTimeoutStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}

/**
  * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
  * it can be once or several times depending on the nature of the timer related to this stream. The
  *  will be called after the timer handler has been called.
  * 
  * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
  * the timer.
  */
class TimeoutStream(private val _asJava: Object) 
    extends ReadStream[Long](_asJava) {

  override def asJava = _asJava.asInstanceOf[JTimeoutStream]
//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):TimeoutStream = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Long]):TimeoutStream = {
    asJava.handler( )
    this
  }

  override def pause():TimeoutStream = {
    asJava.pause( )
    this
  }

  override def resume():TimeoutStream = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):TimeoutStream = {
    asJava.endHandler( )
    this
  }

//basic methods
  def cancel():Unit = {
    asJava.cancel( )
  }

}

object TimeoutStream{
//in object!
//static methods
}
