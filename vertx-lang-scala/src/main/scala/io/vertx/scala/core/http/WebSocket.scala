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

import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a client-side WebSocket.
  */
class WebSocket(private val _asJava: Object) 
    extends WebSocketBase(_asJava) {

  private var cached_0:SocketAddress = _
    private var cached_1:SocketAddress = _
  
//methods returning a future
//cached methods
  override def remoteAddress():SocketAddress = {
    if(cached_0 == null)
      cached_0 = SocketAddress(asJava.asInstanceOf[JWebSocket].remoteAddress())
    return cached_0
  }

  override def localAddress():SocketAddress = {
    if(cached_1 == null)
      cached_1 = SocketAddress(asJava.asInstanceOf[JWebSocket].localAddress())
    return cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[Buffer]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].handler(handler))
    this
  }

  override def pause():WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].pause())
    this
  }

  override def resume():WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].endHandler(endHandler))
    this
  }

  override def write(data: Buffer):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].write(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].setWriteQueueMaxSize(maxSize))
    this
  }

  override def drainHandler(handler: Handler[Unit]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].drainHandler(handler))
    this
  }

  override def writeFrame(frame: WebSocketFrame):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame]))
    this
  }

  override def writeFinalTextFrame(text: String):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].writeFinalTextFrame(text))
    this
  }

  override def writeFinalBinaryFrame(data: Buffer):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def writeBinaryMessage(data: Buffer):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def closeHandler(handler: Handler[Unit]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].closeHandler(handler))
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]):WebSocket = {
    WebSocket(asJava.asInstanceOf[JWebSocket].frameHandler(handler))
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JWebSocket].writeQueueFull()
  }

  override def binaryHandlerID():String = {
    asJava.asInstanceOf[JWebSocket].binaryHandlerID()
  }

  override def textHandlerID():String = {
    asJava.asInstanceOf[JWebSocket].textHandlerID()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JWebSocket].end()
  }

  override def close():Unit = {
    asJava.asInstanceOf[JWebSocket].close()
  }

}

object WebSocket{
  def apply(asJava: JWebSocket) = new WebSocket(asJava)//static methods
}
