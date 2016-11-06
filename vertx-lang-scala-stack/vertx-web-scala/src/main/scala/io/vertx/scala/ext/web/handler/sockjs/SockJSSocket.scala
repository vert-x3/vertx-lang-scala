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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
  import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
      import io.vertx.ext.web.{Session => JSession}
import io.vertx.scala.ext.web.Session
import io.vertx.ext.web.{Session => JSession}
  import io.vertx.ext.auth.{User => JUser}
import io.vertx.scala.ext.auth.User
import io.vertx.ext.auth.{User => JUser}
  import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
  import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
  import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
  import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
      import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{SocketAddress => JSocketAddress}

/**
  *
  * You interact with SockJS clients through instances of SockJS socket.
  * 
  * The API is very similar to [[io.vertx.scala.core.http.WebSocket]].
  * It implements both  and 
  * so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class SockJSSocket(private val _asJava: JSockJSSocket) 
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava: JSockJSSocket = _asJava

  def end(t: Buffer): Unit = {
    _asJava.end(t.asJava.asInstanceOf[JBuffer])
  }

  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): SockJSSocket = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: Buffer => Unit): SockJSSocket = {
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): SockJSSocket = {
    _asJava.pause()
    this
  }

  def resume(): SockJSSocket = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): SockJSSocket = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  def write(data: Buffer): SockJSSocket = {
    _asJava.write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): SockJSSocket = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): SockJSSocket = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * When a `SockJSSocket` is created it automatically registers an event handler with the event bus, the ID of that
    * handler is given by `writeHandlerID`.
    * 
    * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying socket. This
    * allows you to write data to other sockets which are owned by different event loops.
    */
  def writeHandlerID(): String = {
    _asJava.writeHandlerID()
  }

  /**
    * Call [[io.vertx.scala.ext.web.handler.sockjs.SockJSSocket#end]].
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Close it
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Return the remote address for this socket
    */
  def remoteAddress(): SocketAddress = {
    SocketAddress.apply(_asJava.remoteAddress())
  }

  /**
    * Return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }

  /**
    * Return the headers corresponding to the last request for this socket or the websocket handshake
    * Any cookie headers will be removed for security reasons
    */
  def headers(): MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  /**
    * Return the URI corresponding to the last request for this socket or the websocket handshake
    */
  def uri(): String = {
    _asJava.uri()
  }

  /**
    * @return the Vert.x-Web session corresponding to this socket
    */
  def webSession(): scala.Option[Session] = {
        scala.Option(Session.apply(_asJava.webSession()))
  }

  /**
    * @return the Vert.x-Web user corresponding to this socket
    */
  def webUser(): scala.Option[User] = {
        scala.Option(User.apply(_asJava.webUser()))
  }

}

object SockJSSocket {

  def apply(_asJava: JSockJSSocket): SockJSSocket =
    new SockJSSocket(_asJava)

}
