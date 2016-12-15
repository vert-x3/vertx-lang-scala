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

package io.vertx.scala.core.net

import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{SocketAddress => JSocketAddress}

/**
  * Represents a socket-like interface to a TCP connection on either the
  * client or the server side.
  * 
  * Instances of this class are created on the client side by an [[io.vertx.scala.core.net.NetClient]]
  * when a connection to a server is made, or on the server side by a [[io.vertx.scala.core.net.NetServer]]
  * when a server accepts a connection.
  * 
  * It implements both  and  so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class NetSocket(private val _asJava: Object) 
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava: Object = _asJava

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    asJava.asInstanceOf[JNetSocket].end(t.asJava.asInstanceOf[JBuffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.net.NetSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JNetSocket].writeQueueFull()
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Buffer]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].handler(funcToMappedHandler[JBuffer, Buffer](Buffer.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  def pause(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].pause()
    this
  }

  def resume(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].resume()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  def write(data: Buffer): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): NetSocket = {
    asJava.asInstanceOf[JNetSocket].setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: io.vertx.core.Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].drainHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * When a `NetSocket` is created it automatically registers an event handler with the event bus, the ID of that
    * handler is given by `writeHandlerID`.
    * 
    * Given this ID, a different event loop can send a buffer to that event handler using the event bus and
    * that buffer will be received by this instance in its own event loop and written to the underlying connection. This
    * allows you to write data to other connections which are owned by different event loops.
    * @return the write handler ID
    */
  def writeHandlerID(): String = {
    asJava.asInstanceOf[JNetSocket].writeHandlerID()
  }

  /**
    * Write a String to the connection, encoded in UTF-8.
    * @param str the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str)
    this
  }

  /**
    * Write a String to the connection, encoded using the encoding `enc`.
    * @param str the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String, enc: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str, enc)
    this
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename)
    this
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @param offset offset
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename, offset)
    this
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @param offset offset
    * @param length length
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long, length: Long): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename, offset, length)
    this
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @return future
    */
  def sendFileFuture(filename: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.asInstanceOf[JNetSocket].sendFile(filename, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @return future
    */
  def sendFileFuture(filename: String, offset: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.asInstanceOf[JNetSocket].sendFile(filename, offset, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @param length length
    * @return future
    */
  def sendFileFuture(filename: String, offset: Long, length: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.asInstanceOf[JNetSocket].sendFile(filename, offset, length, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == null) {
      cached_0 = SocketAddress.apply(asJava.asInstanceOf[JNetSocket].remoteAddress()).asInstanceOf
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    if (cached_1 == null) {
      cached_1 = SocketAddress.apply(asJava.asInstanceOf[JNetSocket].localAddress()).asInstanceOf
    }
    cached_1
  }

  /**
    * Calls [[io.vertx.scala.core.net.NetSocket#close]]
    */
  def end(): Unit = {
    asJava.asInstanceOf[JNetSocket].end()
  }

  /**
    * Close the NetSocket
    */
  def close(): Unit = {
    asJava.asInstanceOf[JNetSocket].close()
  }

  /**
    * Set a handler that will be called when the NetSocket is closed
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: io.vertx.core.Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].closeHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.
    * @param handler the handler will be notified when it's upgraded
    * @return a reference to this, so the API can be used fluently
    */
  def upgradeToSsl(handler: io.vertx.core.Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].upgradeToSsl(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => handler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * @return true if this io.vertx.scala.core.net.NetSocket is encrypted via SSL/TLS.
    */
  def isSsl(): Boolean = {
    asJava.asInstanceOf[JNetSocket].isSsl()
  }

  private var cached_0: SocketAddress = _
  private var cached_1: SocketAddress = _
}

object NetSocket {

  def apply(_asJava: Object): NetSocket =
    new NetSocket(_asJava)

}
