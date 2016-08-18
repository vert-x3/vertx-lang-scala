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
import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Base WebSocket implementation.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
trait WebSocketBase 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] 
    with io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object

  /**
  * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
  */
  def end(t: io.vertx.scala.core.buffer.Buffer): Unit

  /**
  * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
  * @return true if write queue is full
  */
  def writeQueueFull(): Boolean

    def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.WebSocketBase

    def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.WebSocketBase

    def pause(): io.vertx.scala.core.http.WebSocketBase

    def resume(): io.vertx.scala.core.http.WebSocketBase

    def endHandler(endHandler: () => Unit): io.vertx.scala.core.http.WebSocketBase

    def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase

    def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.WebSocketBase

    def drainHandler(handler: () => Unit): io.vertx.scala.core.http.WebSocketBase

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
  def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocketBase

  /**
  * Write a final WebSocket text frame to the connection
  * @param text The text to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeFinalTextFrame(text: String): io.vertx.scala.core.http.WebSocketBase

  /**
  * Write a final WebSocket binary frame to the connection
  * @param data The data to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeFinalBinaryFrame(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase

  /**
  * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
  * if it exceeds the maximum WebSocket frame size.
  * @param data the data to write
  * @return a reference to this, so the API can be used fluently
  */
  def writeBinaryMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase

  /**
  * Set a close handler. This will be called when the WebSocket is closed.
  * @param handler the handler
  * @return a reference to this, so the API can be used fluently
  */
  def closeHandler(handler: () => Unit): io.vertx.scala.core.http.WebSocketBase

  /**
  * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
  * @param handler the handler
  * @return a reference to this, so the API can be used fluently
  */
  def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.WebSocketBase

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
  def remoteAddress(): io.vertx.scala.core.net.SocketAddress

  /**
  * @return the local address for this socket
  */
  def localAddress(): io.vertx.scala.core.net.SocketAddress

}

object WebSocketBase {

  def apply(_asJava: io.vertx.core.http.WebSocketBase): io.vertx.scala.core.http.WebSocketBase =
    new WebSocketBaseImpl(_asJava)

  private class WebSocketBaseImpl(private val _asJava: io.vertx.core.http.WebSocketBase) extends WebSocketBase {

    def asJava: io.vertx.core.http.WebSocketBase = _asJava

    /**
      * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
      */
    def end(t: io.vertx.scala.core.buffer.Buffer): Unit = {
        _asJava.end(t.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    }

    /**
      * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocketBase#setWriteQueueMaxSize]]
      * @return true if write queue is full
      */
    def writeQueueFull(): Boolean = {
        _asJava.writeQueueFull()
    }

    def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
      this
    }

    def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
      this
    }

    def pause(): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.pause()
      this
    }

    def resume(): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.resume()
      this
    }

    def endHandler(endHandler: () => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
      this
    }

    def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
      this
    }

    def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.setWriteQueueMaxSize(maxSize)
      this
    }

    def drainHandler(handler: () => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
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
        _asJava.binaryHandlerID()
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
        _asJava.textHandlerID()
    }

    /**
      * Write a WebSocket frame to the connection
      * @param frame the frame to write
      * @return a reference to this, so the API can be used fluently
      */
    def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.writeFrame(frame.asJava.asInstanceOf[io.vertx.core.http.WebSocketFrame])
      this
    }

    /**
      * Write a final WebSocket text frame to the connection
      * @param text The text to write
      * @return a reference to this, so the API can be used fluently
      */
    def writeFinalTextFrame(text: String): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.writeFinalTextFrame(text)
      this
    }

    /**
      * Write a final WebSocket binary frame to the connection
      * @param data The data to write
      * @return a reference to this, so the API can be used fluently
      */
    def writeFinalBinaryFrame(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.writeFinalBinaryFrame(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
      this
    }

    /**
      * Writes a (potentially large) piece of binary data to the connection. This data might be written as multiple frames
      * if it exceeds the maximum WebSocket frame size.
      * @param data the data to write
      * @return a reference to this, so the API can be used fluently
      */
    def writeBinaryMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.writeBinaryMessage(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
      this
    }

    /**
      * Set a close handler. This will be called when the WebSocket is closed.
      * @param handler the handler
      * @return a reference to this, so the API can be used fluently
      */
    def closeHandler(handler: () => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
      this
    }

    /**
      * Set a frame handler on the connection. This handler will be called when frames are read on the connection.
      * @param handler the handler
      * @return a reference to this, so the API can be used fluently
      */
    def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.WebSocketBase = {
        _asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler))
      this
    }

    /**
      * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
      */
    def end(): Unit = {
        _asJava.end()
    }

    /**
      * Close the WebSocket.
      */
    def close(): Unit = {
        _asJava.close()
    }

    /**
      * @return the remote address for this socket
      */
    def remoteAddress(): io.vertx.scala.core.net.SocketAddress = {
      if(cached_0 == null) {
        cached_0=        SocketAddress.apply(_asJava.remoteAddress())
      }
      cached_0
    }

    /**
      * @return the local address for this socket
      */
    def localAddress(): io.vertx.scala.core.net.SocketAddress = {
      if(cached_1 == null) {
        cached_1=        SocketAddress.apply(_asJava.localAddress())
      }
      cached_1
    }

  private var cached_0: io.vertx.scala.core.net.SocketAddress = _
  private var cached_1: io.vertx.scala.core.net.SocketAddress = _
  }

}
