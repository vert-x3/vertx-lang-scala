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
import io.vertx.lang.scala.Converter._
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

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  override def end(t: Buffer):Unit

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  override def writeQueueFull():Boolean

  override def exceptionHandler(handler: Handler[Throwable]):WebSocketBase

  override def handler(handler: Handler[Buffer]):WebSocketBase

  override def pause():WebSocketBase

  override def resume():WebSocketBase

  override def endHandler(endHandler: Handler[Unit]):WebSocketBase

  override def write(data: Buffer):WebSocketBase

  override def setWriteQueueMaxSize(maxSize: Int):WebSocketBase

  override def drainHandler(handler: Handler[Unit]):WebSocketBase

  /**
    * When a `Websocket` is created it automatically registers an event handler with the event bus - the ID of that
    * handler is given by this method.
    * 
    * Given this ID, a different event loop can send a binary frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    * @return the binary handler id
    */
  def binaryHandlerID():String

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID():String

  /**
    * Write a WebSocket frame to the connection
    * @param frame the frame to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFrame(frame: WebSocketFrame):WebSocketBase

  /**
    * Write a final WebSocket text frame to the connection
    * @param text The text to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalTextFrame(text: String):WebSocketBase

  /**
    * Write a final WebSocket binary frame to the connection
    * @param data The data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalBinaryFrame(data: Buffer):WebSocketBase

  /**
    * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeBinaryMessage(data: Buffer):WebSocketBase

  /**
    * Set a close handler. This will be called when the WebSocket is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: Handler[Unit]):WebSocketBase

  /**
    * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def frameHandler(handler: Handler[WebSocketFrame]):WebSocketBase

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  override def end():Unit

  /**
    * Close the WebSocket.
    */
  def close():Unit

  /**
    * @return the remote address for this socket
    */
  def remoteAddress():SocketAddress

  /**
    * @return the local address for this socket
    */
  def localAddress():SocketAddress

}

object WebSocketBase{
  def apply(asJava: JWebSocketBase):WebSocketBase = new WebSocketBaseImpl(asJava)
    private class WebSocketBaseImpl(private val _asJava: Object) extends WebSocketBase {

      def asJava = _asJava
  private var cached_0:SocketAddress = _
  private var cached_1:SocketAddress = _

  /**
    * @return the remote address for this socket
    */
  def remoteAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketBase].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress():SocketAddress = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JWebSocketBase].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

  override def exceptionHandler(handler: Handler[Throwable]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Buffer]):WebSocketBase = {
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

  override def endHandler(endHandler: Handler[Unit]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].drainHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Write a WebSocket frame to the connection
    * @param frame the frame to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFrame(frame: WebSocketFrame):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  /**
    * Write a final WebSocket text frame to the connection
    * @param text The text to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalTextFrame(text: String):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Write a final WebSocket binary frame to the connection
    * @param data The data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeFinalBinaryFrame(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param data the data to write
    * @return a reference to this, so the API can be used fluently
    */
  def writeBinaryMessage(data: Buffer):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Set a close handler. This will be called when the WebSocket is closed.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: Handler[Unit]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def frameHandler(handler: Handler[WebSocketFrame]):WebSocketBase = {
    asJava.asInstanceOf[JWebSocketBase].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JWebSocketBase].end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JWebSocketBase].writeQueueFull().asInstanceOf[Boolean]
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
  def binaryHandlerID():String = {
    asJava.asInstanceOf[JWebSocketBase].binaryHandlerID().asInstanceOf[String]
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  def textHandlerID():String = {
    asJava.asInstanceOf[JWebSocketBase].textHandlerID().asInstanceOf[String]
  }

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  override def end():Unit = {
    asJava.asInstanceOf[JWebSocketBase].end()
  }

  /**
    * Close the WebSocket.
    */
  def close():Unit = {
    asJava.asInstanceOf[JWebSocketBase].close()
  }

}
}
