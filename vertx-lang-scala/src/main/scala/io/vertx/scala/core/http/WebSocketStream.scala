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

package io.vertx.scala.core.http

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{WebSocketStream => JWebSocketStream}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.Handler

/**
  * A stream for [[io.vertx.scala.core.http.HttpClient]] WebSocket connection.
  * 
  * When the connection attempt is successful, the stream handler is called back with the [[io.vertx.scala.core.http.WebSocket]]
  * argument, immediately followed by a call to the end handler. When the connection attempt fails, the exception handler is invoked.
  * 
  * The connection occurs when the [[io.vertx.scala.core.http.WebSocketStream#handler]] method is called with a non null handler, the other handlers should be
  * set before setting the handler.
  */
class WebSocketStream(private val _asJava: io.vertx.core.http.WebSocketStream) 
    extends ReadStream[WebSocket] {

  def asJava: io.vertx.core.http.WebSocketStream = _asJava

  def exceptionHandler(handler: Throwable => Unit): WebSocketStream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: WebSocket => Unit): WebSocketStream = {
    _asJava.handler(funcToMappedHandler(WebSocket.apply)(handler))
    this
  }

  def pause(): WebSocketStream = {
    _asJava.pause()
    this
  }

  def resume(): WebSocketStream = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): WebSocketStream = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

}

object WebSocketStream {

  def apply(_asJava: io.vertx.core.http.WebSocketStream): WebSocketStream =
    new WebSocketStream(_asJava)

}
