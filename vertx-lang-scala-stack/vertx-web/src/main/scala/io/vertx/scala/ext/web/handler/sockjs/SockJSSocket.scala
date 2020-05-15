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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.ext.web.handler.sockjs.{SockJSSocket => JSockJSSocket}
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.auth.User
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.ext.auth.{User => JUser}
import io.vertx.ext.web.{Session => JSession}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.ext.web.Session
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

/**
  *
  * You interact with SockJS clients through instances of SockJS socket.
  * 
  * The API is very similar to [[io.vertx.scala.core.http.WebSocket]].
  * It implements both  and 
  * so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */

class SockJSSocket(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer]with WriteStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava




  override 
  def fetch(arg0: Long): ReadStream[io.vertx.core.buffer.Buffer] = {
    asJava.asInstanceOf[JSockJSSocket].fetch(arg0.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].handler((if (handler == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {handler.handle(x)}}))
    this
  }


  override 
  def pause(): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].pause()
    this
  }


  override 
  def resume(): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].resume()
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].write(data)
    this
  }

  /**
   * Write a String to the socket, encoded in UTF-8.   * @param data the string to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(data: String): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].write(data.asInstanceOf[java.lang.String])
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].write(data, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): SockJSSocket = {
    asJava.asInstanceOf[JSockJSSocket].drainHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }



  override def end(data: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JSockJSSocket].end(data)
  }


  override def end(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSockJSSocket].end(data, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JSockJSSocket].pipe())
  }


  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JSockJSSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
  }


  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSockJSSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  def write(data: String, handler: Handler[AsyncResult[Unit]]): SockJSSocket = {
    SockJSSocket(asJava.asInstanceOf[JSockJSSocket].write(data.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}})))
  }

  /**
   * Close it giving a status code and reason. Only Applicable to RawWebSocket will downgrade to plain close for
   * other transports.
   */
  def close(statusCode: Int, reason: String): Unit = {
    asJava.asInstanceOf[JSockJSSocket].close(statusCode.asInstanceOf[java.lang.Integer], reason.asInstanceOf[java.lang.String])
  }



  override def end (arg0: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSockJSSocket].end((if (arg0 == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {arg0.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  override def writeQueueFull (): Boolean = {
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
  def writeHandlerID (): String = {
    asJava.asInstanceOf[JSockJSSocket].writeHandlerID().asInstanceOf[String]
  }

  /**
   * Call [[io.vertx.scala.ext.web.handler.sockjs.SockJSSocket#end]].
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JSockJSSocket].end()
  }

  /**
   * Close it
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSockJSSocket].close()
  }

  /**
   * Return the remote address for this socket
   */
  def remoteAddress (): SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].remoteAddress())
  }

  /**
   * Return the local address for this socket
   */
  def localAddress (): SocketAddress = {
    SocketAddress(asJava.asInstanceOf[JSockJSSocket].localAddress())
  }

  /**
   * Return the headers corresponding to the last request for this socket or the websocket handshake
   * Any cookie headers will be removed for security reasons
   */
  def headers (): MultiMap = {
    MultiMap(asJava.asInstanceOf[JSockJSSocket].headers())
  }

  /**
   * Return the URI corresponding to the last request for this socket or the websocket handshake
   */
  def uri (): String = {
    asJava.asInstanceOf[JSockJSSocket].uri().asInstanceOf[String]
  }

  /**
   * @return the Vert.x-Web session corresponding to this socket
   */
  def webSession (): scala.Option[Session] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webSession()).map(Session(_))
  }

  /**
   * @return the Vert.x-Web user corresponding to this socket
   */
  def webUser (): scala.Option[User] = {
    scala.Option(asJava.asInstanceOf[JSockJSSocket].webUser()).map(User(_))
  }



  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSockJSSocket].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def endFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSockJSSocket].end(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSockJSSocket].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  def writeFuture (data: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSockJSSocket].write(data.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def writeFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSockJSSocket].write(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SockJSSocket {
  def apply(asJava: JSockJSSocket) = new SockJSSocket(asJava)

}
