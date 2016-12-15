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
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.scala.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.scala.core.http.HttpServerRequest#upgrade]]ed.
  */
class ServerWebSocket(private val _asJava: Object) 
    extends WebSocketBase {

  def asJava: Object = _asJava

  /**
    * Same as [[io.vertx.scala.core.http.WebSocketBase#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    asJava.asInstanceOf[JServerWebSocket].end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.ServerWebSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JServerWebSocket].writeQueueFull()
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
    asJava.asInstanceOf[JServerWebSocket].binaryHandlerID()
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
    asJava.asInstanceOf[JServerWebSocket].textHandlerID()
  }

  /**
    * Calls [[io.vertx.scala.core.http.WebSocketBase#close]]
    */
  def end(): Unit = {
    asJava.asInstanceOf[JServerWebSocket].end()
  }

  /**
    * Close the WebSocket.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JServerWebSocket].close()
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == null) {
      cached_0 = SocketAddress.apply(asJava.asInstanceOf[JServerWebSocket].remoteAddress()).asInstanceOf
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    if (cached_1 == null) {
      cached_1 = SocketAddress.apply(asJava.asInstanceOf[JServerWebSocket].localAddress()).asInstanceOf
    }
    cached_1
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Buffer]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].handler(funcToMappedHandler[JBuffer, Buffer](Buffer.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  def pause(): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].pause()
    this
  }

  def resume(): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].resume()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  def write(data: Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: io.vertx.core.Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].drainHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  def writeFrame(frame: WebSocketFrame): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  def writeFinalTextFrame(text: String): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalTextFrame(text)
    this
  }

  def writeFinalBinaryFrame(data: Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def writeBinaryMessage(data: Buffer): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def closeHandler(handler: io.vertx.core.Handler[Unit]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].closeHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  def frameHandler(handler: io.vertx.core.Handler[WebSocketFrame]): ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].frameHandler(funcToMappedHandler[JWebSocketFrame, WebSocketFrame](WebSocketFrame.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocketFrame]])
    this
  }

  def uri(): String = {
    asJava.asInstanceOf[JServerWebSocket].uri()
  }

  /**
    * @return the WebSocket handshake path.
    */
  def path(): String = {
    asJava.asInstanceOf[JServerWebSocket].path()
  }

  /**
    * @return the WebSocket handshake query string.
    */
  def query(): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JServerWebSocket].query())
  }

  /**
    * @return the headers in the WebSocket handshake
    */
  def headers(): MultiMap = {
    if (cached_2 == null) {
      cached_2 = MultiMap.apply(asJava.asInstanceOf[JServerWebSocket].headers()).asInstanceOf
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
    asJava.asInstanceOf[JServerWebSocket].reject()
  }

  private var cached_0: SocketAddress = _
  private var cached_1: SocketAddress = _
  private var cached_2: MultiMap = _
}

object ServerWebSocket {

  def apply(_asJava: Object): ServerWebSocket =
    new ServerWebSocket(_asJava)

}
