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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.net.{NetServer => JNetServer}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.scala.core.metrics.Measured
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents a TCP server
  */

class NetServer(private val _asJava: Object) extends Measured {
  def asJava = _asJava



  /**
   * Start listening on the port and host as configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
   * creating the server.
   * 
   * The server may not be listening until some time after the call to listen has returned.   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(): NetServer = {
    asJava.asInstanceOf[JNetServer].listen()
    this
  }

  /**
   * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(listenHandler: Handler[AsyncResult[NetServer]]): NetServer = {
    asJava.asInstanceOf[JNetServer].listen((if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetServer]]{def handle(x: AsyncResult[JNetServer]) {listenHandler.handle(AsyncResultWrapper[JNetServer, NetServer](x, a => NetServer(a)))}}))
    this
  }

  /**
   * Start listening on the specified port and host, ignoring port and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
   * creating the server.
   * 
   * Port `0` can be specified meaning "choose an random port".
   * 
   * Host `0.0.0.0` can be specified meaning "listen on all available interfaces".
   * 
   * The server may not be listening until some time after the call to listen has returned.   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, host: String): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.   * @param port the port to listen on
   * @param host the host to listen on
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, host: String, listenHandler: Handler[AsyncResult[NetServer]]): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetServer]]{def handle(x: AsyncResult[JNetServer]) {listenHandler.handle(AsyncResultWrapper[JNetServer, NetServer](x, a => NetServer(a)))}}))
    this
  }

  /**
   * Start listening on the specified port and host "0.0.0.0", ignoring port and host configured in the
   * <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when creating the server.
   * 
   * Port `0` can be specified meaning "choose an random port".
   * 
   * The server may not be listening until some time after the call to listen has returned.   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.   * @param port the port to listen on
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, listenHandler: Handler[AsyncResult[NetServer]]): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetServer]]{def handle(x: AsyncResult[JNetServer]) {listenHandler.handle(AsyncResultWrapper[JNetServer, NetServer](x, a => NetServer(a)))}}))
    this
  }

  /**
   * Start listening on the specified local address, ignoring port and host configured in the <a href="../../../../../../../cheatsheet/NetServerOptions.html">NetServerOptions</a> used when
   * creating the server.
   * 
   * The server may not be listening until some time after the call to listen has returned.   * @param localAddress the local address to listen on
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(localAddress: SocketAddress): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(localAddress.asJava.asInstanceOf[JSocketAddress])
    this
  }

  /**
   * Like [[io.vertx.scala.core.net.NetServer#listen]] but providing a handler that will be notified when the server is listening, or fails.   * @param localAddress the local address to listen on
   * @param listenHandler handler that will be notified when listening or failed
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(localAddress: SocketAddress, listenHandler: Handler[AsyncResult[NetServer]]): NetServer = {
    asJava.asInstanceOf[JNetServer].listen(localAddress.asJava.asInstanceOf[JSocketAddress], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JNetServer]]{def handle(x: AsyncResult[JNetServer]) {listenHandler.handle(AsyncResultWrapper[JNetServer, NetServer](x, a => NetServer(a)))}}))
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JNetServer].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Return the connect stream for this server. The server can only have at most one handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.scala.core.net.NetSocket]] and passes it to the
   * connect stream .   * @return the connect stream
   */
  def connectStream (): ReadStream[NetSocket] = {
    ReadStream[NetSocket](asJava.asInstanceOf[JNetServer].connectStream())
  }

  /**
   * Supply a connect handler for this server. The server can only have at most one connect handler at any one time.
   * As the server accepts TCP or SSL connections it creates an instance of [[io.vertx.scala.core.net.NetSocket]] and passes it to the
   * connect handler.   * @return a reference to this, so the API can be used fluently
   */
  def connectHandler (handler: Handler[NetSocket]): NetServer = {
    NetServer(asJava.asInstanceOf[JNetServer].connectHandler((if (handler == null) null else new io.vertx.core.Handler[JNetSocket]{def handle(x: JNetSocket) {handler.handle(NetSocket(x))}})))
  }

  /**
   * Close the server. This will close any currently open connections. The close may not complete until after this
   * method has returned.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JNetServer].close()
  }

  /**
   * Like [[io.vertx.scala.core.net.NetServer#close]] but supplying a handler that will be notified when close is complete.   * @param completionHandler the handler
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JNetServer].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
   * signifying an ephemeral port   * @return the actual port the server is listening on.
   */
  def actualPort (): Int = {
    asJava.asInstanceOf[JNetServer].actualPort().asInstanceOf[Int]
  }


 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (): scala.concurrent.Future[NetServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int, host: String): scala.concurrent.Future[NetServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int): scala.concurrent.Future[NetServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(port.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (localAddress: SocketAddress): scala.concurrent.Future[NetServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JNetServer, NetServer](x => NetServer(x))
    asJava.asInstanceOf[JNetServer].listen(localAddress.asJava.asInstanceOf[JSocketAddress], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JNetServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object NetServer {
  def apply(asJava: JNetServer) = new NetServer(asJava)

}
