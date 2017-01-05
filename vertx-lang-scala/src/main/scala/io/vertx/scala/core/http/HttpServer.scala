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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}

/**
  * An HTTP and WebSockets server.
  * 
  * You receive HTTP requests by providing a [[io.vertx.scala.core.http.HttpServer#requestHandler]]. As requests arrive on the server the handler
  * will be called with the requests.
  * 
  * You receive WebSockets by providing a [[io.vertx.scala.core.http.HttpServer#websocketHandler]]. As WebSocket connections arrive on the server, the
  * WebSocket is passed to the handler.
  */
class HttpServer(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava
  private var cached_0:HttpServerRequestStream = _
  private var cached_1:ServerWebSocketStream = _

  /**
    * Return the request stream for the server. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to the stream .
    * @return the request stream
    */
  def requestStream():HttpServerRequestStream = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpServer].requestStream()
      cached_0 = HttpServerRequestStream(tmp)
    }
    cached_0
  }

  /**
    * Return the websocket stream for the server. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the stream .
    * @return the websocket stream
    */
  def websocketStream():ServerWebSocketStream = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpServer].websocketStream()
      cached_1 = ServerWebSocketStream(tmp)
    }
    cached_1
  }

  /**
    * Set the request handler for the server to `requestHandler`. As HTTP requests are received by the server,
    * instances of [[io.vertx.scala.core.http.HttpServerRequest]] will be created and passed to this handler.
    * @return a reference to this, so the API can be used fluently
    */
  def requestHandler(handler: Handler[HttpServerRequest]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].requestHandler({x: JHttpServerRequest => handler.handle(HttpServerRequest(x))})
    this
  }

  /**
    * Set a connection handler for the server.
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: Handler[HttpConnection]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].connectionHandler({x: JHttpConnection => handler.handle(HttpConnection(x))})
    this
  }

  /**
    * Set the websocket handler for the server to `wsHandler`. If a websocket connect handshake is successful a
    * new [[io.vertx.scala.core.http.ServerWebSocket]] instance will be created and passed to the handler.
    * @return a reference to this, so the API can be used fluently
    */
  def websocketHandler(handler: Handler[ServerWebSocket]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].websocketHandler({x: JServerWebSocket => handler.handle(ServerWebSocket(x))})
    this
  }

  /**
    * Tell the server to start listening. The server will listen on the port and host specified in the
    * <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * 
    * The listen happens asynchronously and the server may not be listening until some time after the call has returned.
    * @return a reference to this, so the API can be used fluently
    */
  def listen():HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen()
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
  def listen(port: Int,host: String):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String])
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
    * listening (or has failed).
    * @param port the port to listen on
    * @param host the host to listen on
    */
  def listen(port: Int,host: String,listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],{x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but the server will listen on host "0.0.0.0" and port specified here ignoring
    * any value in the <a href="../../../../../../../cheatsheet/HttpServerOptions.html">HttpServerOptions</a> that was used when creating the server.
    * @param port the port to listen on
    * @return a reference to this, so the API can be used fluently
    */
  def listen(port: Int):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    * @param port the port to listen on
    */
  def listen(port: Int,listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],{x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
    */
  def listen(listenHandler: Handler[AsyncResult[HttpServer]]):HttpServer = {
    asJava.asInstanceOf[JHttpServer].listen({x: AsyncResult[JHttpServer] => listenHandler.handle(AsyncResultWrapper[JHttpServer,HttpServer](x, a => HttpServer(a)))})
    this
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JHttpServer].isMetricsEnabled().asInstanceOf[Boolean]
  }

  /**
    * Close the server. Any open HTTP connections will be closed.
    * 
    * The close happens asynchronously and the server may not be closed until some time after the call has returned.
    */
  def close():Unit = {
    asJava.asInstanceOf[JHttpServer].close()
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JHttpServer].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  /**
    * The actual port the server is listening on. This is useful if you bound the server specifying 0 as port number
    * signifying an ephemeral port
    * @return the actual port the server is listening on.
    */
  def actualPort():Int = {
    asJava.asInstanceOf[JHttpServer].actualPort().asInstanceOf[Int]
  }

 /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually
   * listening (or has failed).
   * @param port the port to listen on
   * @param host the host to listen on
   * @return the listen future
   */
    def listenFuture(port: Int,host: String):scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
   * @param port the port to listen on
   * @return the listen future
   */
    def listenFuture(port: Int):scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(port.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.core.http.HttpServer#listen]] but supplying a handler that will be called when the server is actually listening (or has failed).
   * @return the listen future
   */
    def listenFuture():scala.concurrent.Future[HttpServer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServer, HttpServer](x => HttpServer(x))
    asJava.asInstanceOf[JHttpServer].listen(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[io.vertx.scala.core.http.HttpServer#close]] but supplying a handler that will be called when the server is actually closed (or has failed).
   * @return the future
   */
    def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServer].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpServer{
  def apply(asJava: JHttpServer) = new HttpServer(asJava)  
}
