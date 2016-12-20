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

import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.Handler
import io.vertx.core.http.{WebSocketStream => JWebSocketStream}

/**
  * A stream for [[io.vertx.scala.core.http.HttpClient]] WebSocket connection.
  * 
  * When the connection attempt is successful, the stream handler is called back with the [[io.vertx.scala.core.http.WebSocket]]
  * argument, immediately followed by a call to the end handler. When the connection attempt fails, the exception handler is invoked.
  * 
  * The connection occurs when the [[io.vertx.scala.core.http.WebSocketStream#handler]] method is called with a non null handler, the other handlers should be
  * set before setting the handler.
  */
class WebSocketStream(private val _asJava: Object) 
    extends ReadStream[WebSocket] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):WebSocketStream = {
    asJava.asInstanceOf[JWebSocketStream].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[WebSocket]):WebSocketStream = {
    asJava.asInstanceOf[JWebSocketStream].handler({x: JWebSocket => handler.handle(WebSocket(x))})
    this
  }

  override def pause():WebSocketStream = {
    asJava.asInstanceOf[JWebSocketStream].pause()
    this
  }

  override def resume():WebSocketStream = {
    asJava.asInstanceOf[JWebSocketStream].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):WebSocketStream = {
    asJava.asInstanceOf[JWebSocketStream].endHandler({x: Void => endHandler.handle(x)})
    this
  }

//default methods
//basic methods
}

  object WebSocketStream{
    def apply(asJava: JWebSocketStream) = new WebSocketStream(asJava)  
  //static methods
  }
