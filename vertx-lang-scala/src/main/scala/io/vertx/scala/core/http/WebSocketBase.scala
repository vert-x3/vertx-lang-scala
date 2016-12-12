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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
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

  /**
  * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
  */
  def end(t: Buffer): Unit

  /**
  * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
  * @return true if write queue is full
  */
  def writeQueueFull(): Boolean

    def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): WebSocketBase

    def handler(handler: io.vertx.core.Handler[Buffer]): WebSocketBase

    def pause(): WebSocketBase

    def resume(): WebSocketBase

    def endHandler(endHandler: io.vertx.core.Handler[Unit]): WebSocketBase

    def write(data: Buffer): WebSocketBase

    def setWriteQueueMaxSize(maxSize: Int): WebSocketBase

    def drainHandler(handler: io.vertx.core.Handler[Unit]): WebSocketBase

  /**
  * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
  * handler is given by this method.
  * 
  * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
  * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
  * allows you to write data to other WebSockets which are owned by different event loops.
  * @return the binary handler id
  */
  def binaryHandlerID(): String

  /**
  * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
  * handler is given by `textHandlerID`.
  * 
  * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
  * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
  * allows you to write data to other WebSockets which are owned by different event loops.
  */
  def textHandlerID(): String

  /**
  * Write a WebSocket frame to the connection
  * @param frame the frame to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeFrame(frame: WebSocketFrame): WebSocketBase

  /**
  * Write a final WebSocket text frame to the connection
  * @param text The text to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeFinalTextFrame(text: String): WebSocketBase

  /**
  * Write a final WebSocket binary frame to the connection
  * @param data The data to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeFinalBinaryFrame(data: Buffer): WebSocketBase

  /**
  * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
  * if it exceeds the maximum WebSocket frame size.
  * @param data the data to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeBinaryMessage(data: Buffer): WebSocketBase

  /**
  * Set a close handler. This will be called when the WebSocket is closed.
  * @param handler the handler
  * @return a reference to this, so the API can be used fluently
  */
  def closeHandler(handler: io.vertx.core.Handler[Unit]): WebSocketBase

  /**
  * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
  * @param handler the handler
  * @return a reference to this, so the API can be used fluently
  */
  def frameHandler(handler: io.vertx.core.Handler[WebSocketFrame]): WebSocketBase

  /**
  * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
  */
  def end(): Unit

  /**
  * Close the WebSocket.
  */
  def close(): Unit

  /**
  * @return the remote address for this socket
  */
  def remoteAddress(): SocketAddress

  /**
  * @return the local address for this socket
  */
  def localAddress(): SocketAddress

}

object WebSocketBase {

  def apply(_asJava: JWebSocketBase): WebSocketBase =
    new WebSocketBaseImpl(_asJava)

  private class WebSocketBaseImpl(private val _asJava: JWebSocketBase) extends WebSocketBase {

  def asJava: JWebSocketBase = _asJava

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    asJava.end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.writeQueueFull()
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): WebSocketBase = {
    asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Buffer]): WebSocketBase = {
    asJava.handler(funcToMappedHandler(Buffer.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  def pause(): WebSocketBase = {
    asJava.pause()
    this
  }

  def resume(): WebSocketBase = {
    asJava.resume()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): WebSocketBase = {
    asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  def write(data: Buffer): WebSocketBase = {
    asJava.write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): WebSocketBase = {
    asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: io.vertx.core.Handler[Unit]): WebSocketBase = {
    asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID(): String = {
    asJava.binaryHandlerID()
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID(): String = {
    asJava.textHandlerID()
  }

  /**
    * Write a WebSocket frame to the connection
    * @param frame the frame to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFrame(frame: WebSocketFrame): WebSocketBase = {
    asJava.writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  /**
    * Write a final WebSocket text frame to the connection
    * @param text The text to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalTextFrame(text: String): WebSocketBase = {
    asJava.writeFinalTextFrame(text)
    this
  }

  /**
    * Write a final WebSocket binary frame to the connection
    * @param data The data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalBinaryFrame(data: Buffer): WebSocketBase = {
    asJava.writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeBinaryMessage(data: Buffer): WebSocketBase = {
    asJava.writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Set a close handler. This will be called when the WebSocket is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: io.vertx.core.Handler[Unit]): WebSocketBase = {
    asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def frameHandler(handler: io.vertx.core.Handler[WebSocketFrame]): WebSocketBase = {
    asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocketFrame]])
    this
  }

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  def end(): Unit = {
    asJava.end()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    asJava.close()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == null) {
      cached_0 = SocketAddress.apply(asJava.remoteAddress()).asInstanceOf
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    if (cached_1 == null) {
      cached_1 = SocketAddress.apply(asJava.localAddress()).asInstanceOf
    }
    cached_1
  }

  private var cached_0: SocketAddress = _
  private var cached_1: SocketAddress = _
  }

}
