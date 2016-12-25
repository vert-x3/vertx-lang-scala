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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.net.SocketAddress

/**
  * Base WebSocket implementation.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
trait WebSocketBase 
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava: java.lang.Object

  override def end(t: Buffer):Unit

  override def writeQueueFull():Boolean

  override def exceptionHandler(handler: Option[Handler[Throwable]]):WebSocketBase

  override def handler(handler: Option[Handler[Buffer]]):WebSocketBase

  override def pause():WebSocketBase

  override def resume():WebSocketBase

  override def endHandler(endHandler: Option[Handler[Unit]]):WebSocketBase

  override def write(data: Buffer):WebSocketBase

  override def setWriteQueueMaxSize(maxSize: Int):WebSocketBase

  override def drainHandler(handler: Option[Handler[Unit]]):WebSocketBase

  def binaryHandlerID():String

  def textHandlerID():String

  def writeFrame(frame: WebSocketFrame):WebSocketBase

  def writeFinalTextFrame(text: String):WebSocketBase

  def writeFinalBinaryFrame(data: Buffer):WebSocketBase

  def writeBinaryMessage(data: Buffer):WebSocketBase

  def closeHandler(handler: Option[Handler[Unit]]):WebSocketBase

  def frameHandler(handler: Option[Handler[WebSocketFrame]]):WebSocketBase

  override def end():Unit

  def close():Unit

  def remoteAddress():SocketAddress

  def localAddress():SocketAddress

}

  object WebSocketBase{
    def apply(asJava: JWebSocketBase):WebSocketBase = new WebSocketBaseImpl(asJava)    
      private class WebSocketBaseImpl(private val _asJava: JWebSocketBase) extends WebSocketBase {

        def asJava = _asJava
  private var cached_0:SocketAddress = _
  private var cached_1:SocketAddress = _

//cached methods
  def remoteAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketBase].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  def localAddress():SocketAddress = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketBase].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

//fluent methods
  override def exceptionHandler(handler: Option[Handler[Throwable]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Option[Handler[Buffer]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].handler({x: JBuffer => handler.handle(Buffer(x))})
    this
  }

  override def pause():WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].pause()
    this
  }

  override def resume():WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].resume()
    this
  }

  override def endHandler(endHandler: Option[Handler[Unit]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].setWriteQueueMaxSize(maxSize)
    this
  }

  override def drainHandler(handler: Option[Handler[Unit]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].drainHandler({x: Void => handler.handle(x)})
    this
  }

  def writeFrame(frame: WebSocketFrame):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  def writeFinalTextFrame(text: String):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalTextFrame(text)
    this
  }

  def writeFinalBinaryFrame(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def writeBinaryMessage(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def closeHandler(handler: Option[Handler[Unit]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].closeHandler({x: Void => handler.handle(x)})
    this
  }

  def frameHandler(handler: Option[Handler[WebSocketFrame]]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JWebSocketBase].end(t.asJava.asInstanceOf[JBuffer])
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JWebSocketBase].writeQueueFull()
  }

  def binaryHandlerID():String = {
    asJava.asInstanceOf[JWebSocketBase].binaryHandlerID()
  }

  def textHandlerID():String = {
    asJava.asInstanceOf[JWebSocketBase].textHandlerID()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JWebSocketBase].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JWebSocketBase].close()
  }

}
  }
