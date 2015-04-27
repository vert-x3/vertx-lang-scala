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

  def asJava: java.lang.Object = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Return the request stream for the server. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to the stream [[io.vertx.scala.core.streams.ReadStream#handler]].
    * @return the request stream
    */
  def requestStream(): io.vertx.scala.core.http.HttpServerRequestStream = {
    HttpServerRequestStream.apply(_asJava.requestStream())
  }

  /**
    * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to this handler.
    * @return a reference to this, so the API can be used fluently
    */
  def requestHandler(handler: io.vertx.scala.core.http.HttpServerRequest => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    HttpServer.apply(_asJava.requestHandler(funcToMappedHandler(HttpServerRequest.apply)(handler)))
  }

  /**
    * Return the websocket stream for the server. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream [[io.vertx.scala.core.streams.ReadStream#handler]].
    * @return the websocket stream
    */
  def websocketStream(): io.vertx.scala.core.http.ServerWebSocketStream = {
    ServerWebSocketStream.apply(_asJava.websocketStream())
  }

  /**
    * Set the websocket handler for the server to `wsHandler`. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.
    * @return a reference to this, so the API can be used fluently
    */
  def websocketHandler(handler: io.vertx.scala.core.http.ServerWebSocket => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    HttpServer.apply(_asJava.websocketHandler(funcToMappedHandler(ServerWebSocket.apply)(handler)))
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
    * listening (or has failed).
    * @param port the port to listen on
    * @param host the host to listen on
    * @return the listen handler
    */
  def listen(port: Int, host: String): scala.concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.http.HttpServer]()
    _asJava.listen(port, host, promiseToMappedAsyncResultHandler(HttpServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param port the port to listen on
    * @return the listen handler
    */
  def listen(port: Int): scala.concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.http.HttpServer]()
    _asJava.listen(port, promiseToMappedAsyncResultHandler(HttpServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @return the listen handler
    */
  def listen(): scala.concurrent.Future[io.vertx.scala.core.http.HttpServer] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[io.vertx.scala.core.http.HttpServer]()
    _asJava.listen(promiseToMappedAsyncResultHandler(HttpServer.apply)(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
    * @return the handler
    */
  def close(): scala.concurrent.Future[Unit] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Unit]()
    _asJava.close(promiseToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(promise))
    promise.future
  }

}

object HttpServer {

  def apply(_asJava: io.vertx.core.http.HttpServer): io.vertx.scala.core.http.HttpServer =
    new io.vertx.scala.core.http.HttpServer(_asJava)
}
