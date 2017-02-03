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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

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
    extends  ReadStream[io.vertx.core.buffer.Buffer] 
    with WriteStream[io.vertx.core.buffer.Buffer] {

  def asJava = _asJava
  private var cached_0: SocketAddress = _
  private var cached_1: SocketAddress = _

  /**
    * @return the remote address for this socket
    */
  def remoteAddress(): SocketAddress = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JNetSocket].remoteAddress()
      cached_0 = SocketAddress(tmp)
    }
    cached_0
  }

  /**
    * @return the local address for this socket
    */
  def localAddress(): SocketAddress = {
    if (cached_1 == null) {
      val tmp = asJava.asInstanceOf[JNetSocket].localAddress()
      cached_1 = SocketAddress(tmp)
    }
    cached_1
  }

  override def exceptionHandler(handler: Handler[Throwable]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[io.vertx.core.buffer.Buffer]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].handler({x: Buffer => handler.handle(x)})
    this
  }

  override def pause(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].pause()
    this
  }

  override def resume(): NetSocket = {
    asJava.asInstanceOf[JNetSocket].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: io.vertx.core.buffer.Buffer): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(data)
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int): NetSocket = {
    asJava.asInstanceOf[JNetSocket].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].drainHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Write a String to the connection, encoded in UTF-8.
    * @param str the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Write a String to the connection, encoded using the encoding `enc`.
    * @param str the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(str: String, enc: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].write(str.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Tell the operating system to stream a file as specified by `filename` directly from disk to the outgoing connection,
    * bypassing userspace altogether (where supported by the underlying operating system. This is a very efficient way to stream files.
    * @param filename file name of the file to send
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String])
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
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long])
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
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long])
    this
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#sendFile]] but also takes a handler that will be called when the send has completed or
    * a failure has occurred
    * @param filename file name of the file to send
    * @param offset offset
    * @param length length
    * @param resultHandler handler
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long, length: Long, resultHandler: Handler[AsyncResult[Unit]]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Set a handler that will be called when the NetSocket is closed
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
    * Upgrade channel to use SSL/TLS. Be aware that for this to work SSL must be configured.
    * @param handler the handler will be notified when it's upgraded
    * @return a reference to this, so the API can be used fluently
    */
  def upgradeToSsl(handler: Handler[Unit]): NetSocket = {
    asJava.asInstanceOf[JNetSocket].upgradeToSsl({x: Void => handler.handle(x)})
    this
  }

  /**
    * Same as [[io.vertx.scala.core.net.NetSocket#end]] but writes some data to the stream before ending.
    */
  override def end(t: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JNetSocket].end(t)
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.net.NetSocket#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  override def writeQueueFull(): Boolean = {
    asJava.asInstanceOf[JNetSocket].writeQueueFull().asInstanceOf[Boolean]
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
    asJava.asInstanceOf[JNetSocket].writeHandlerID().asInstanceOf[String]
  }

  /**
    * Calls [[io.vertx.scala.core.net.NetSocket#close]]
    */
  override def end(): Unit = {
    asJava.asInstanceOf[JNetSocket].end()
  }

  /**
    * Close the NetSocket
    */
  def close(): Unit = {
    asJava.asInstanceOf[JNetSocket].close()
  }

  /**
    * @return true if this io.vertx.scala.core.net.NetSocket is encrypted via SSL/TLS.
    */
  def isSsl(): Boolean = {
    asJava.asInstanceOf[JNetSocket].isSsl().asInstanceOf[Boolean]
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: Long): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def sendFileFuture(filename: String, offset: Long, length: Long): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetSocket].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object NetSocket {
  def apply(asJava: JNetSocket) = new NetSocket(asJava)  
}
