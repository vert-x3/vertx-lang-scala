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

import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.scala.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.scala.core.http.HttpServerRequest#upgrade]]ed.
  */
class ServerWebSocket(private val _asJava: Object) 
    extends WebSocketBase(_asJava) {

  private var cached_0:SocketAddress = _
    private var cached_1:SocketAddress = _
    private var cached_2:MultiMap = _
  
//methods returning a future
//cached methods
  override def remoteAddress():SocketAddress = {
    if(cached_0 == null)
      cached_0 = SocketAddress(asJava.asInstanceOf[JServerWebSocket].remoteAddress())
    return cached_0
  }

  override def localAddress():SocketAddress = {
    if(cached_1 == null)
      cached_1 = SocketAddress(asJava.asInstanceOf[JServerWebSocket].localAddress())
    return cached_1
  }

  def headers():MultiMap = {
    if(cached_2 == null)
      cached_2 = MultiMap(asJava.asInstanceOf[JServerWebSocket].headers())
    return cached_2
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[Buffer]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].handler(handler))
    this
  }

  override def pause():ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].pause())
    this
  }

  override def resume():ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].endHandler(endHandler))
    this
  }

  override def write(data: Buffer):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].write(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].setWriteQueueMaxSize(maxSize))
    this
  }

  override def drainHandler(handler: Handler[Unit]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].drainHandler(handler))
    this
  }

  override def writeFrame(frame: WebSocketFrame):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame]))
    this
  }

  override def writeFinalTextFrame(text: String):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].writeFinalTextFrame(text))
    this
  }

  override def writeFinalBinaryFrame(data: Buffer):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def writeBinaryMessage(data: Buffer):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def closeHandler(handler: Handler[Unit]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].closeHandler(handler))
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]):ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JServerWebSocket].frameHandler(handler))
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JServerWebSocket].writeQueueFull()
  }

  override def binaryHandlerID():String = {
    asJava.asInstanceOf[JServerWebSocket].binaryHandlerID()
  }

  override def textHandlerID():String = {
    asJava.asInstanceOf[JServerWebSocket].textHandlerID()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JServerWebSocket].end()
  }

  override def close():Unit = {
    asJava.asInstanceOf[JServerWebSocket].close()
  }

  def uri():String = {
    asJava.asInstanceOf[JServerWebSocket].uri()
  }

  def path():String = {
    asJava.asInstanceOf[JServerWebSocket].path()
  }

  def query():String = {
    asJava.asInstanceOf[JServerWebSocket].query()
  }

  def reject():Unit = {
    asJava.asInstanceOf[JServerWebSocket].reject()
  }

}

object ServerWebSocket{
  def apply(asJava: JServerWebSocket) = new ServerWebSocket(asJava)//static methods
}
