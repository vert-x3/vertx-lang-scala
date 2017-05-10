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
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
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
    extends  WebSocketBase {

  def asJava = _asJava
  private var cached_0: Option[SocketAddress] = None
  private var cached_1: Option[SocketAddress] = None
  private var cached_2: Option[MultiMap] = None

  /**
    * @return the remote address for this socket
    */
  override def remoteAddress(): SocketAddress = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JServerWebSocket].remoteAddress()
      cached_0 = Some(SocketAddress(tmp))
    }
    cached_0.get
  }

  /**
    * @return the local address for this socket
    */
  override def localAddress(): SocketAddress = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JServerWebSocket].localAddress()
      cached_1 = Some(SocketAddress(tmp))
    }
    cached_1.get
  }

  /**
    * @return the headers in the WebSocket handshake
    */
  def headers(): MultiMap = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JServerWebSocket].headers()
      cached_2 = Some(MultiMap(tmp))
    }
    cached_2.get
  }

  /**
    * Writes a (potentially large) piece of text data to the connection. This data might be written as multiple frames
    * if it exceeds the maximum WebSocket frame size.
    * @param text the data to write
    * @return a reference to this, so the API can be used fluently
    */
  override def writeTextMessage(text: String): WebSocketBase = {
    asJava.asInstanceOf[JServerWebSocket].writeTextMessage(text.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Set a text message handler on the connection. This handler will be called similar to the
    * , but the buffer will be converted to a String first
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  override def textMessageHandler(handler: Handler[String]): WebSocketBase = {
    asJava.asInstanceOf[JServerWebSocket].textMessageHandler({x: java.lang.String => handler.handle(x.asInstanceOf[String])})
    this
  }

  /**
    * Set a binary message handler on the connection. This handler serves a similar purpose to [[io.vertx.scala.core.http.ServerWebSocket#handler]]
    * except that if a message comes into the socket in multiple frames, the data from the frames will be aggregated
    * into a single buffer before calling the handler (using [[io.vertx.scala.core.http.WebSocketFrame#isFinal]] to find the boundaries).
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  override def binaryMessageHandler(handler: Handler[io.vertx.core.buffer.Buffer]): WebSocketBase = {
    asJava.asInstanceOf[JServerWebSocket].binaryMessageHandler({x: Buffer => handler.handle(x)})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[io.vertx.core.buffer.Buffer]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].handler({x: Buffer => handler.handle(x)})
    this
  }

  override def pause(): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].pause()
    this
  }

  override def resume(): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: io.vertx.core.buffer.Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].write(data)
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def writeFrame(frame: WebSocketFrame): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  override def writeFinalTextFrame(text: String): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  override def writeFinalBinaryFrame(data: io.vertx.core.buffer.Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalBinaryFrame(data)
    this
  }

  override def writeBinaryMessage(data: io.vertx.core.buffer.Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeBinaryMessage(data)
    this
  }

  override def closeHandler(handler: Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].closeHandler({x: Void => handler.handle(x)})
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  override def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JServerWebSocket].end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.ServerWebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  override def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JServerWebSocket].writeQueueFull().asInstanceOf[Boolean]
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
    asJava.asInstanceOf[JServerWebSocket].binaryHandlerID().asInstanceOf[String]
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
    asJava.asInstanceOf[JServerWebSocket].textHandlerID().asInstanceOf[String]
  }

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  override def end(): Unit = {
    asJava.asInstanceOf[JServerWebSocket].end()
  }

  /**
    * Close the WebSocket.
    */
  override def close(): Unit = {
    asJava.asInstanceOf[JServerWebSocket].close()
  }

  /**
    * @return true if this io.vertx.scala.core.http.HttpConnection is encrypted via SSL/TLS.
    */
  override def isSsl(): Boolean = {
    asJava.asInstanceOf[JServerWebSocket].isSsl().asInstanceOf[Boolean]
  }

  def uri(): String = {
    asJava.asInstanceOf[JServerWebSocket].uri().asInstanceOf[String]
  }

  /**
    * @return the WebSocket handshake path.
    */
  def path(): String = {
    asJava.asInstanceOf[JServerWebSocket].path().asInstanceOf[String]
  }

  /**
    * @return the WebSocket handshake query string.
    */
  def query(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JServerWebSocket].query().asInstanceOf[String])
  }

  /**
    * Reject the WebSocket.
    * 
    * Calling this method from the websocket handler when it is first passed to you gives you the opportunity to reject
    * the websocket, which will cause the websocket handshake to fail by returning
    * a 404 response code.
    * 
    * You might use this method, if for example you only want to accept WebSockets with a particular path.
    */
  def reject(): Unit = {
    asJava.asInstanceOf[JServerWebSocket].reject()
  }

}

object ServerWebSocket {
  def apply(asJava: JServerWebSocket) = new ServerWebSocket(asJava)  
}
