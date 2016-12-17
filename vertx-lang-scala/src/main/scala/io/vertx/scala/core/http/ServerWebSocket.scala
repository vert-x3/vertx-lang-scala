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

import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.scala.core.http.WebSocketBase
import io.vertx.core.http.{WebSocketBase => JWebSocketBase}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.http.WebSocketFrame
import io.vertx.core.http.{WebSocketFrame => JWebSocketFrame}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

/**
  * Represents a server side WebSocket.
  * 
  * Instances of this class are passed into a [[io.vertx.scala.core.http.HttpServer#websocketHandler]] or provided
  * when a WebSocket handshake is manually [[io.vertx.scala.core.http.HttpServerRequest#upgrade]]ed.
  */
class ServerWebSocket(private val _asJava: Object) 
    extends WebSocketBase(_asJava) {

  override def asJava = _asJava.asInstanceOf[JServerWebSocket]
//methods returning a future
//cached methods
  override def remoteAddress():SocketAddress = {
    asJava.remoteAddress( )
  }

  override def localAddress():SocketAddress = {
    asJava.localAddress( )
  }

  def headers():MultiMap = {
    asJava.headers( )
  }

//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):ServerWebSocket = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Buffer]):ServerWebSocket = {
    asJava.handler( )
    this
  }

  override def pause():ServerWebSocket = {
    asJava.pause( )
    this
  }

  override def resume():ServerWebSocket = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):ServerWebSocket = {
    asJava.endHandler( )
    this
  }

  override def write(data: Buffer):ServerWebSocket = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):ServerWebSocket = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):ServerWebSocket = {
    asJava.drainHandler( )
    this
  }

  override def writeFrame(frame: WebSocketFrame):ServerWebSocket = {
    asJava.writeFrame( )
    this
  }

  override def writeFinalTextFrame(text: String):ServerWebSocket = {
    asJava.writeFinalTextFrame( )
    this
  }

  override def writeFinalBinaryFrame(data: Buffer):ServerWebSocket = {
    asJava.writeFinalBinaryFrame( )
    this
  }

  override def writeBinaryMessage(data: Buffer):ServerWebSocket = {
    asJava.writeBinaryMessage( )
    this
  }

  override def closeHandler(handler: io.vertx.core.Handler[Unit]):ServerWebSocket = {
    asJava.closeHandler( )
    this
  }

  override def frameHandler(handler: io.vertx.core.Handler[WebSocketFrame]):ServerWebSocket = {
    asJava.frameHandler( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  override def binaryHandlerID():String = {
    asJava.binaryHandlerID( )
  }

  override def textHandlerID():String = {
    asJava.textHandlerID( )
  }

  override def end():Unit = {
    asJava.end( )
  }

  override def close():Unit = {
    asJava.close( )
  }

  def uri():String = {
    asJava.uri( )
  }

  def path():String = {
    asJava.path( )
  }

  def query():String = {
    asJava.query( )
  }

  def reject():Unit = {
    asJava.reject( )
  }

}

object ServerWebSocket{
//in object!
//static methods
}
