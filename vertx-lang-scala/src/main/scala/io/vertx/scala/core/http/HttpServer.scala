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

import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import scala.reflect.runtime.universe._
import io.vertx.scala.core.metrics.Measured
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.scala.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.scala.core.http.HttpServer#webSocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */

class HttpServer(private val _asJava: Object) extends Measured {
  def asJava = _asJava
  private var cached_0: Option[ReadStream[HttpServerRequest]] = None
  private var cached_1: Option[ReadStream[ServerWebSocket]] = None
  private var cached_2: Option[ReadStream[ServerWebSocket]] = None


  /**
   * Return the request stream for the server. As HTTP requests are received by the server,
   * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to the stream [[io.vertx.scala.core.streams.ReadStream#handler]].   * @return the request stream
   */
  def requestStream(): ReadStream[HttpServerRequest] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpServer].requestStream()
      cached_0 = Some(ReadStream[HttpServerRequest](tmp))
    }
    cached_0.get
  }

  /**
   * Return the WebSocket stream for the server. If a webSocket connect handshake is successful a
   * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream [[io.vertx.scala.core.streams.ReadStream#handler]].   * @return the WebSocket stream
   */
  def websocketStream(): ReadStream[ServerWebSocket] = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpServer].websocketStream()
      cached_1 = Some(ReadStream[ServerWebSocket](tmp))
    }
    cached_1.get
  }

  /**
   * Return the WebSocket stream for the server. If a WebSocket connect handshake is successful a
   * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream [[io.vertx.scala.core.streams.ReadStream#handler]].   * @return the WebSocket stream
   */
  def webSocketStream(): ReadStream[ServerWebSocket] = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JHttpServer].webSocketStream()
      cached_2 = Some(ReadStream[ServerWebSocket](tmp))
    }
    cached_2.get
  }


  /**
   * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
   * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to this handler.   * @return a reference to this, so the API can be used fluently
   */
  
  def requestHandler(handler: Handler[HttpServerRequest]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].requestHandler((if (handler == null) null else new io.vertx.core.Handler[JHttpServerRequest]{def handle(x: JHttpServerRequest) {handler.handle(HttpServerRequest(x))}}))
    this
  }

  /**
   * Set a connection handler for the server.   * @return a reference to this, so the API can be used fluently
   */
  
  def connectionHandler(handler: Handler[HttpConnection]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].connectionHandler((if (handler == null) null else new io.vertx.core.Handler[JHttpConnection]{def handle(x: JHttpConnection) {handler.handle(HttpConnection(x))}}))
    this
  }

  /**
   * Set an exception handler called for socket errors happening before the HTTP connection
   * is established, e.g during the TLS handshake.   * @param handler the handler to set
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(handler: Handler[Throwable]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   * Set the WebSocket handler for the server to `wsHandler`. If a WebSocket connect handshake is successful a
   * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.   * @return a reference to this, so the API can be used fluently
   */
  
  def websocketHandler(handler: Handler[ServerWebSocket]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].websocketHandler((if (handler == null) null else new io.vertx.core.Handler[JServerWebSocket]{def handle(x: JServerWebSocket) {handler.handle(ServerWebSocket(x))}}))
    this
  }

  /**
   * Set the WebSocket handler for the server to `wsHandler`. If a WebSocket connect handshake is successful a
   * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.   * @return a reference to this, so the API can be used fluently
   */
  
  def webSocketHandler(handler: Handler[ServerWebSocket]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].webSocketHandler((if (handler == null) null else new io.vertx.core.Handler[JServerWebSocket]{def handle(x: JServerWebSocket) {handler.handle(ServerWebSocket(x))}}))
    this
  }

  /**
   * Tell the server to start listening. The server will listen on the port and host specified in the
   * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * 
   * The listen happens asynchronously and the server may not be listening until some time after the call has returned.   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen()
    this
  }

  /**
   * Tell the server to start listening. The server will listen on the port and host specified here,
   * ignoring any value set in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
   * 
   * The listen happens asynchronously and the server may not be listening until some time after the call has returned.   * @param port the port to listen on
   * @param host the host to listen on
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int, host: String): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
   * listening (or has failed).   * @param port the port to listen on
   * @param host the host to listen on
   * @param listenHandler the listen handler
   */
  
  def listen(port: Int, host: String, listenHandler: Handler[AsyncResult[HttpServer]]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpServer]]{def handle(x: AsyncResult[JHttpServer]) {listenHandler.handle(AsyncResultWrapper[JHttpServer, HttpServer](x, a => HttpServer(a)))}}))
    this
  }

  /**
   * Tell the server to start listening on the given address supplying
   * a handler that will be called when the server is actually
   * listening (or has failed).   * @param address the address to listen on
   * @param listenHandler the listen handler
   */
  
  def listen(address: SocketAddress, listenHandler: Handler[AsyncResult[HttpServer]]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(address.asJava.asInstanceOf[JSocketAddress], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpServer]]{def handle(x: AsyncResult[JHttpServer]) {listenHandler.handle(AsyncResultWrapper[JHttpServer, HttpServer](x, a => HttpServer(a)))}}))
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but the server will listen on host "0.0.0.0" and port specified here ignoring
   * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.   * @param port the port to listen on
   * @return a reference to this, so the API can be used fluently
   */
  
  def listen(port: Int): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).   * @param port the port to listen on
   * @param listenHandler the listen handler
   */
  
  def listen(port: Int, listenHandler: Handler[AsyncResult[HttpServer]]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer], (if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpServer]]{def handle(x: AsyncResult[JHttpServer]) {listenHandler.handle(AsyncResultWrapper[JHttpServer, HttpServer](x, a => HttpServer(a)))}}))
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).   * @param listenHandler the listen handler
   */
  
  def listen(listenHandler: Handler[AsyncResult[HttpServer]]): HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen((if (listenHandler == null) null else new io.vertx.core.Handler[AsyncResult[JHttpServer]]{def handle(x: AsyncResult[JHttpServer]) {listenHandler.handle(AsyncResultWrapper[JHttpServer, HttpServer](x, a => HttpServer(a)))}}))
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JHttpServer].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Close the server. Any open HTTP connections will be closed.
   * 
   * The close happens asynchronously and the server may not be closed until some time after the call has returned.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JHttpServer].close()
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).   * @param completionHandler the handler
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpServer].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
   * signifying an ephemeral port   * @return the actual port the server is listening on.
   */
  def actualPort (): Int = {
    asJava.asInstanceOf[JHttpServer].actualPort().asInstanceOf[Int]
  }


 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int, host: String): scala.concurrent.Future[HttpServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (address: SocketAddress): scala.concurrent.Future[HttpServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(address.asJava.asInstanceOf[JSocketAddress], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (port: Int): scala.concurrent.Future[HttpServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listen]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listenFuture (): scala.concurrent.Future[HttpServer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpServer {
  def apply(asJava: JHttpServer) = new HttpServer(asJava)

}
