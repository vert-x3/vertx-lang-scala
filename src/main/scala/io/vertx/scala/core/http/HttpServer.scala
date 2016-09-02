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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.Handler

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.scala.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.scala.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */
class HttpServer(private val _asJava: io.vertx.core.http.HttpServer) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: io.vertx.core.http.HttpServer = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Return the request stream for the server. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to the stream .
    * @return the request stream
    */
  def requestStream(): io.vertx.scala.core.http.HttpServerRequestStream = {
    if(cached_0 == null) {
      cached_0=    HttpServerRequestStream.apply(_asJava.requestStream())
    }
    cached_0
  }

  /**
    * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to this handler.
    * @return a reference to this, so the API can be used fluently
    */
  def requestHandler(handler: io.vertx.scala.core.http.HttpServerRequest => Unit): io.vertx.scala.core.http.HttpServer = {
    _asJava.requestHandler(funcToMappedHandler(HttpServerRequest.apply)(handler))
    this
  }

  /**
    * Set a connection handler for the server.
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: io.vertx.scala.core.http.HttpConnection => Unit): io.vertx.scala.core.http.HttpServer = {
    _asJava.connectionHandler(funcToMappedHandler(HttpConnection.apply)(handler))
    this
  }

  /**
    * Return the websocket stream for the server. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream .
    * @return the websocket stream
    */
  def websocketStream(): io.vertx.scala.core.http.ServerWebSocketStream = {
    if(cached_1 == null) {
      cached_1=    ServerWebSocketStream.apply(_asJava.websocketStream())
    }
    cached_1
  }

  /**
    * Set the websocket handler for the server to `wsHandler`. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.
    * @return a reference to this, so the API can be used fluently
    */
  def websocketHandler(handler: io.vertx.scala.core.http.ServerWebSocket => Unit): io.vertx.scala.core.http.HttpServer = {
    _asJava.websocketHandler(funcToMappedHandler(ServerWebSocket.apply)(handler))
    this
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified in the
    * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen(): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen()
    this
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified here,
    * ignoring any value set in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @param port the port to listen on
    * @param host the host to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int, host: String): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port, host)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
    * listening (or has failed).
    * @param port the port to listen on
    * @param host the host to listen on
    * @return the listen future
    */
  def listenFuture(port: Int, host: String): concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.http.HttpServer,io.vertx.scala.core.http.HttpServer]((x => if (x == null) null else HttpServer.apply(x)))
    _asJava.listen(port, host, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but the server will listen on host "0.0.0.0" and port specified here ignoring
    * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * @param port the port to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param port the port to listen on
    * @return the listen future
    */
  def listenFuture(port: Int): concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.http.HttpServer,io.vertx.scala.core.http.HttpServer]((x => if (x == null) null else HttpServer.apply(x)))
    _asJava.listen(port, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @return the listen future
    */
  def listenFuture(): concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.http.HttpServer,io.vertx.scala.core.http.HttpServer]((x => if (x == null) null else HttpServer.apply(x)))
    _asJava.listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the server. Any open HTTP connections will be closed.
    * 
    * The close happens asynchronously and the server may not be closed until some time after the call has returned.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
    * @return the future
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort(): Int = {
    _asJava.actualPort()
  }

  private var cached_0: io.vertx.scala.core.http.HttpServerRequestStream = _
  private var cached_1: io.vertx.scala.core.http.ServerWebSocketStream = _
}

object HttpServer {

  def apply(_asJava: io.vertx.core.http.HttpServer): io.vertx.scala.core.http.HttpServer =
    new io.vertx.scala.core.http.HttpServer(_asJava)

}
