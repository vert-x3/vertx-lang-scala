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

  override def end(t: Buffer):Unit

  override def writeQueueFull():Boolean

  override def exceptionHandler(handler: Handler[Throwable]):WebSocketBase

  override def handler(handler: Handler[Buffer]):WebSocketBase

  override def pause():WebSocketBase

  override def resume():WebSocketBase

  override def endHandler(endHandler: Handler[Unit]):WebSocketBase

  override def write(data: Buffer):WebSocketBase

  override def setWriteQueueMaxSize(maxSize: Int):WebSocketBase

  override def drainHandler(handler: Handler[Unit]):WebSocketBase

  def binaryHandlerID():String

  def textHandlerID():String

  def writeFrame(frame: WebSocketFrame):WebSocketBase

  def writeFinalTextFrame(text: String):WebSocketBase

  def writeFinalBinaryFrame(data: Buffer):WebSocketBase

  def writeBinaryMessage(data: Buffer):WebSocketBase

  def closeHandler(handler: Handler[Unit]):WebSocketBase

  def frameHandler(handler: Handler[WebSocketFrame]):WebSocketBase

  override def end():Unit

  def close():Unit

  def remoteAddress():SocketAddress

  def localAddress():SocketAddress

}
