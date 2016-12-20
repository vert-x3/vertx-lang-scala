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

import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.Handler
import io.vertx.core.{TimeoutStream => JTimeoutStream}

/**
  * A timeout stream is triggered by a timer, the scala-function will be call when the timer is fired,
  * it can be once or several times depending on the nature of the timer related to this stream. The
  *  will be called after the timer handler has been called.
  * 
  * Pausing the timer inhibits the timer shots until the stream is resumed. Setting a null handler callback cancels
  * the timer.
  */
class TimeoutStream(private val _asJava: Object) 
    extends ReadStream[Long] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Long]):TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].handler({x: java.lang.Long => handler.handle(x)})
    this
  }

  override def pause():TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].pause()
    this
  }

  override def resume():TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):TimeoutStream = {
    asJava.asInstanceOf[JTimeoutStream].endHandler({x: Void => endHandler.handle(x)})
    this
  }

//default methods
//basic methods
  def cancel():Unit = {
    asJava.asInstanceOf[JTimeoutStream].cancel()
  }

}

  object TimeoutStream{
    def apply(asJava: JTimeoutStream) = new TimeoutStream(asJava)  
  //static methods
  }
