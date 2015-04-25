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

package io.vertx.scala.core.http;

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

trait WebSocketBase 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] 
    with io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object

def writeQueueFull(): Boolean

def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.WebSocketBase

def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.WebSocketBase

def pause(): io.vertx.scala.core.http.WebSocketBase

def resume(): io.vertx.scala.core.http.WebSocketBase

def endHandler(endHandler: => Unit): io.vertx.scala.core.http.WebSocketBase

def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase

def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.WebSocketBase

def drainHandler(handler: => Unit): io.vertx.scala.core.http.WebSocketBase

def binaryHandlerID(): String

def textHandlerID(): String

def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocketBase

def writeMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase

def closeHandler(handler: => Unit): io.vertx.scala.core.http.WebSocketBase

def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.WebSocketBase

def close(): Unit

def remoteAddress(): io.vertx.scala.core.net.SocketAddress

def localAddress(): io.vertx.scala.core.net.SocketAddress

}

object WebSocketBase {

  def apply(_asJava: io.vertx.core.http.WebSocketBase): io.vertx.scala.core.http.WebSocketBase =
    new WebSocketBaseImpl(_asJava)

  private class WebSocketBaseImpl(private val _asJava: io.vertx.core.http.WebSocketBase) extends WebSocketBase { 
  def asJava: java.lang.Object = _asJava

  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
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

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
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

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def binaryHandlerID(): String = {
    _asJava.binaryHandlerID()
  }

  def textHandlerID(): String = {
    _asJava.textHandlerID()
  }

  def writeFrame(frame: io.vertx.scala.core.http.WebSocketFrame): io.vertx.scala.core.http.WebSocketBase = {
    _asJava.writeFrame(frame.asJava.asInstanceOf[io.vertx.core.http.WebSocketFrame])
    this
  }

  def writeMessage(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.WebSocketBase = {
    _asJava.writeMessage(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def closeHandler(handler: => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def frameHandler(handler: io.vertx.scala.core.http.WebSocketFrame => Unit): io.vertx.scala.core.http.WebSocketBase = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.frameHandler(funcToMappedHandler(WebSocketFrame.apply)(handler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

  def remoteAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.remoteAddress())
  }

  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }
  }

}
