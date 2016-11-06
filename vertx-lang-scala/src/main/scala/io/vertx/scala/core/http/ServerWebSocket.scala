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
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
      import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
  import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
  import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
  import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
      import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
  import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.scala.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.scala.core.http.HttpServerRequest#upgrade]]ed.
  */
class ServerWebSocket(private val _asJava: JServerWebSocket) 
    extends WebSocketBase {

  def asJava: JServerWebSocket = _asJava

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    _asJava.end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.ServerWebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
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
  def remoteAddress(): SocketAddress = {
    if (cached_0 == null) {
      cached_0=    SocketAddress.apply(_asJava.remoteAddress())
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    if (cached_1 == null) {
      cached_1=    SocketAddress.apply(_asJava.localAddress())
    }
    cached_1
  }

  def exceptionHandler(handler: Throwable => Unit): ServerWebSocket = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: Buffer => Unit): ServerWebSocket = {
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): ServerWebSocket = {
    _asJava.pause()
    this
  }

  def resume(): ServerWebSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): ServerWebSocket = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  def write(data: Buffer): ServerWebSocket = {
    _asJava.write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): ServerWebSocket = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): ServerWebSocket = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  def writeFrame(frame: WebSocketFrame): ServerWebSocket = {
    _asJava.writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  def writeFinalTextFrame(text: String): ServerWebSocket = {
    _asJava.writeFinalTextFrame(text)
    this
  }

  def writeFinalBinaryFrame(data: Buffer): ServerWebSocket = {
    _asJava.writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def writeBinaryMessage(data: Buffer): ServerWebSocket = {
    _asJava.writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def closeHandler(handler: () => Unit): ServerWebSocket = {
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  def frameHandler(handler: WebSocketFrame => Unit): ServerWebSocket = {
    _asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler))
    this
  }

  def uri(): String = {
    _asJava.uri()
  }

  /**
    * @return the WebSocket handshake path.
    */
  def path(): String = {
    _asJava.path()
  }

  /**
    * @return the WebSocket handshake query string.
    */
  def query(): scala.Option[String] = {
        scala.Option(_asJava.query())
  }

  /**
    * @return the headers in the WebSocket handshake
    */
  def headers(): MultiMap = {
    if (cached_2 == null) {
      cached_2=    MultiMap.apply(_asJava.headers())
    }
    cached_2
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
    _asJava.reject()
  }

  private var cached_0: SocketAddress = _
  private var cached_1: SocketAddress = _
  private var cached_2: MultiMap = _
}

object ServerWebSocket {

  def apply(_asJava: JServerWebSocket): ServerWebSocket =
    new ServerWebSocket(_asJava)

}
