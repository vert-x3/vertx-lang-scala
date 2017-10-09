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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a client-side WebSocket.
  */
class WebSocket(private val _asJava: Object)
    extends  WebSocketBase  {

  def asJava = _asJava
  private var cached_0: Option[SocketAddress] = None
  private var cached_1: Option[SocketAddress] = None

  /**
    * @return the remote address for this socket
    */
  override def remoteAddress(): SocketAddress = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JWebSocket].remoteAddress()
      cached_0 = Some(SocketAddress(tmp))
    }
    cached_0.get
  }

  /**
    * @return the local address for this socket
    */
  override def localAddress(): SocketAddress = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JWebSocket].localAddress()
      cached_1 = Some(SocketAddress(tmp))
    }
    cached_1.get
  }

  /**
    * Writes a ping to the connection. This will be written in a single frame. Ping frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no pingHandler because RFC 6455 section 5.5.2 clearly states that the only response to a ping is a pong
    * with identical contents.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  override def writePing(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocket].writePing(data)
    this
  }

  /**
    * Writes a pong to the connection. This will be written in a single frame. Pong frames may be at most 125 bytes (octets).
    * 
    * This method should not be used to write application data and should only be used for implementing a keep alive or
    * to ensure the client is still responsive, see RFC 6455 Section 5.5.2.
    * 
    * There is no need to manually write a Pong, as the server and client both handle responding to a ping with a pong
    * automatically and this is exposed to users.RFC 6455 Section 5.5.3 states that pongs may be sent unsolicited in order
    * to implement a one way heartbeat.
    * @param data the data to write, may be at most 125 bytes
    * @return a reference to this, so the API can be used fluently
    */
  override def writePong(data: io.vertx.core.buffer.Buffer): WebSocketBase = {
    asJava.asInstanceOf[JWebSocket].writePong(data)
    this
  }

  /**
    * Set a text message handler on the connection. This handler will be called similar to the
    * , but the buffer will be converted to a String first
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  override def textMessageHandler(handler: Handler[String]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocket].textMessageHandler({x: java.lang.String => handler.handle(x.asInstanceOf[String])})
    this
  }

  /**
    * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.scala.core.http.WebSocket#handler]]
    * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
    * into a single buffer before calling the handler (using [[io.vertx.scala.core.http.WebSocketFrame#isFinal]] to find the boundaries).
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  override def binaryMessageHandler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocket].binaryMessageHandler({x: Buffer => handler.handle(x)})
    this
  }

  /**
    * Set a pong message handler on the connection.  This handler will be invoked every time a pong message is received
    * on the server, and can be used by both clients and servers since the RFC 6455 Sections 5.5.2 and 5.5.3 do not
    * specify whether the client or server sends a ping.
    * 
    * Pong frames may be at most 125 bytes (octets).
    * 
    * There is no ping handler since pings should immediately be responded to with a pong with identical content
    * 
    * Pong frames may be received unsolicited.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  override def pongHandler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JWebSocket].pongHandler({x: Buffer => handler.handle(x)})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].handler({x: Buffer => handler.handle(x)})
    this
  }

  override def pause(): WebSocket = {
    asJava.asInstanceOf[JWebSocket].pause()
    this
  }

  override def resume(): WebSocket = {
    asJava.asInstanceOf[JWebSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: io.vertx.core.buffer.Buffer): WebSocket = {
    asJava.asInstanceOf[JWebSocket].write(data)
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int): WebSocket = {
    asJava.asInstanceOf[JWebSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def writeFrame(frame: WebSocketFrame): WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  override def writeFinalTextFrame(text: String): WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  override def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeFinalBinaryFrame(data)
    this
  }

  override def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeBinaryMessage(data)
    this
  }

  override def writeTextMessage(text: String): WebSocket = {
    asJava.asInstanceOf[JWebSocket].writeTextMessage(text.asInstanceOf[java.lang.String])
    this
  }

  override def closeHandler(handler: Handler[Unit]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].closeHandler({x: Void => handler.handle(x)})
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]): WebSocket = {
    asJava.asInstanceOf[JWebSocket].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  override def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JWebSocket].end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.WebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  override def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JWebSocket].writeQueueFull().asInstanceOf[Boolean]
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
  override def binaryHandlerID(): String = {
    asJava.asInstanceOf[JWebSocket].binaryHandlerID().asInstanceOf[String]
  }

  /**
    * When a `Websocket` is created it automatically registers an event handler with the eventbus, the ID of that
    * handler is given by `textHandlerID`.
    * 
    * Given this ID, a different event loop can send a text frame to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other WebSockets which are owned by different event loops.
    */
  override def textHandlerID(): String = {
    asJava.asInstanceOf[JWebSocket].textHandlerID().asInstanceOf[String]
  }

  /**
    * Returns the websocket sub protocol selected by the websocket handshake.
    * <p/>
    * On the server, the value will be `null` when the handler receives the websocket callback as the
    * handshake will not be completed yet.
    */
  override def subProtocol(): String = {
    asJava.asInstanceOf[JWebSocket].subProtocol().asInstanceOf[String]
  }

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  override def end(): Unit = {
    asJava.asInstanceOf[JWebSocket].end()
  }

  /**
    * Close the WebSocket.
    */
  override def close(): Unit = {
    asJava.asInstanceOf[JWebSocket].close()
  }

  /**
    * @return true if this io.vertx.scala.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  override def isSsl(): Boolean = {
    asJava.asInstanceOf[JWebSocket].isSsl().asInstanceOf[Boolean]
  }

}

object WebSocket {
  def apply(asJava: JWebSocket) = new WebSocket(asJava)  
}
