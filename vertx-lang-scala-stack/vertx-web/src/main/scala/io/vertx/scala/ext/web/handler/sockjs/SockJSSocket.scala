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

package io.vertx.scala.ext.web.handler.sockjs

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.ext.auth.User
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.scala.core.net.SocketAddress

/**
  *
  * You interact with SockJS clients through instances of SockJS socket.
  * 
  * The API is very similar to [[io.vertx.scala.core.http.WebSocket]].
  * It implements both  and 
  * so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class SockJSSocket(private val _asJava: Object) 
    extends  ReadStream[io.vertx.core.buffer.Buffer] 
    with WriteStream[io.vertx.core.buffer.Buffer] {

  def asJava = _asJava

//io.vertx.core.Handler<java.lang.Throwable>
  override def exceptionHandler(handler: Handler[Throwable]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//io.vertx.core.Handler<io.vertx.core.buffer.Buffer>
  override def handler(handler: Handler[io.vertx.core.buffer.Buffer]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].handler({x: Buffer => handler.handle(x)})
    this
  }

  override def pause():SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].pause()
    this
  }

  override def resume():SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].resume()
    this
  }

//io.vertx.core.Handler<java.lang.Void>
  override def endHandler(endHandler: Handler[Unit]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

//io.vertx.core.buffer.Buffer
  override def write(data: io.vertx.core.buffer.Buffer):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].write(data)
    this
  }

//int
  override def setWriteQueueMaxSize(maxSize: Int):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

//io.vertx.core.Handler<java.lang.Void>
  override def drainHandler(handler: Handler[Unit]):SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def end(t: io.vertx.core.buffer.Buffer):Unit = {
    asJava.asInstanceOf[JSockJSSocket].end(t)
  }

  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JSockJSSocket].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
    * When a `SockJSSocket` is created it automatically registers an event handler with the event bus, the ID of that
    * handler is given by `writeHandlerID`.
    * 
    * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying socket. This
    * allows you to write data to other sockets which are owned by different event loops.
    */
  def writeHandlerID():String = {
    asJava.asInstanceOf[JSockJSSocket].writeHandlerID().asInstanceOf[String]
  }

  /**
    * Call [[io.vertx.scala.ext.web.handler.sockjs.SockJSSocket#end]].
    */
  override def end():Unit = {
    asJava.asInstanceOf[JSockJSSocket].end()
  }

  /**
    * Close it
    */
  def close():Unit = {
    asJava.asInstanceOf[JSockJSSocket].close()
  }

  /**
    * Return the remote address for this socket
    */
  def remoteAddress():SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].remoteAddress())
  }

  /**
    * Return the local address for this socket
    */
  def localAddress():SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].localAddress())
  }

  /**
    * Return the headers corresponding to the last request for this socket or the websocket handshake
    * Any cookie headers will be removed for security reasons
    */
  def headers():MultiMap = {
    MultiMap(asJava.asInstanceOf[JSockJSSocket].headers())
  }

  /**
    * Return the URI corresponding to the last request for this socket or the websocket handshake
    */
  def uri():String = {
    asJava.asInstanceOf[JSockJSSocket].uri().asInstanceOf[String]
  }

  /**
    * @return the Vert.x-Web session corresponding to this socket
    */
  def webSession():scala.Option[Session] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webSession()).map(Session(_))
  }

  /**
    * @return the Vert.x-Web user corresponding to this socket
    */
  def webUser():scala.Option[User] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webUser()).map(User(_))
  }

}

object SockJSSocket{
  def apply(asJava: JSockJSSocket) = new SockJSSocket(asJava)  
}
