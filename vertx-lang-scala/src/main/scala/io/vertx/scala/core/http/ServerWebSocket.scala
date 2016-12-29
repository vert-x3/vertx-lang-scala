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
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.buffer.Buffer
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
class ServerWebSocket(private val _asJava: Object, private val _useTypeTags:Boolean = false) 
    extends WebSocketBase {

  def asJava = _asJava
  private var cached_0:SocketAddress = _
  private var cached_1:SocketAddress = _
  private var cached_2:MultiMap = _

//cached methods
  override def remoteAddress():SocketAddress = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JServerWebSocket].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  override def localAddress():SocketAddress = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JServerWebSocket].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

  def headers():MultiMap = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JServerWebSocket].headers()
      cached_2 = MultiMap(tmp)
    }
    cached_2
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Buffer]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].handler({x: JBuffer => handler.handle(Buffer(x))})
    this
  }

  override def pause():ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].pause()
    this
  }

  override def resume():ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def writeFrame(frame: WebSocketFrame):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFrame(frame.asJava.asInstanceOf[JWebSocketFrame])
    this
  }

  override def writeFinalTextFrame(text: String):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalTextFrame(text.asInstanceOf[java.lang.String])
    this
  }

  override def writeFinalBinaryFrame(data: Buffer):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeFinalBinaryFrame(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def writeBinaryMessage(data: Buffer):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].writeBinaryMessage(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def closeHandler(handler: Handler[Unit]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].closeHandler({x: Void => handler.handle(x)})
    this
  }

  override def frameHandler(handler: Handler[WebSocketFrame]):ServerWebSocket = {
    asJava.asInstanceOf[JServerWebSocket].frameHandler({x: JWebSocketFrame => handler.handle(WebSocketFrame(x))})
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JServerWebSocket].end(t.asJava.asInstanceOf[JBuffer])
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JServerWebSocket].writeQueueFull().asInstanceOf[Boolean]
  }

  override def binaryHandlerID():String = {
    asJava.asInstanceOf[JServerWebSocket].binaryHandlerID().asInstanceOf[String]
  }

  override def textHandlerID():String = {
    asJava.asInstanceOf[JServerWebSocket].textHandlerID().asInstanceOf[String]
  }

  override def end():Unit = {
    asJava.asInstanceOf[JServerWebSocket].end()
  }

  override def close():Unit = {
    asJava.asInstanceOf[JServerWebSocket].close()
  }

  def uri():String = {
    asJava.asInstanceOf[JServerWebSocket].uri().asInstanceOf[String]
  }

  def path():String = {
    asJava.asInstanceOf[JServerWebSocket].path().asInstanceOf[String]
  }

  def query():scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JServerWebSocket].query().asInstanceOf[String])
  }

  def reject():Unit = {
    asJava.asInstanceOf[JServerWebSocket].reject()
  }

//future methods
}

  object ServerWebSocket{
    def apply(asJava: Object, useTypeTags:Boolean = false) = new ServerWebSocket(asJava, useTypeTags)  
  //static methods
  }
