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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
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
    extends WebSocketBase {

  def asJava = _asJava
  private var cached_0:SocketAddress = _
  private var cached_1:SocketAddress = _

//cached methods
  override def remoteAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JWebSocket].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  override def localAddress():SocketAddress = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JWebSocket].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Buffer]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].handler({x: JBuffer => handler.handle(Buffer(x))})
    this
  }

  override def pause():WebSocket = {
    asJava.asInstanceOf[JWebSocket].pause()
    this
  }

  override def resume():WebSocket = {
    asJava.asInstanceOf[JWebSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):WebSocket = {
    asJava.asInstanceOf[JWebSocket].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):WebSocket = {
    asJava.asInstanceOf[JWebSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def writeFrame(frame: WebSocketFrame):WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  override def writeFinalTextFrame(text: String):WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  override def writeFinalBinaryFrame(data: Buffer):WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def writeBinaryMessage(data: Buffer):WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def closeHandler(handler: Handler[Unit]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].closeHandler({x: Void => handler.handle(x)})
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]):WebSocket = {
    asJava.asInstanceOf[JWebSocket].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JWebSocket].end(t.asJava.asInstanceOf[JBuffer])
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JWebSocket].writeQueueFull().asInstanceOf[Boolean]
  }

  override def binaryHandlerID():String = {
    asJava.asInstanceOf[JWebSocket].binaryHandlerID().asInstanceOf[String]
  }

  override def textHandlerID():String = {
    asJava.asInstanceOf[JWebSocket].textHandlerID().asInstanceOf[String]
  }

  override def end():Unit = {
    asJava.asInstanceOf[JWebSocket].end()
  }

  override def close():Unit = {
    asJava.asInstanceOf[JWebSocket].close()
  }

//future methods
}

  object WebSocket{
    def apply(asJava: Object) = new WebSocket(asJava)  
  //static methods
  }
