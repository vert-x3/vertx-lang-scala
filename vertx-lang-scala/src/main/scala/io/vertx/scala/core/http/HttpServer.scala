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

import io.vertx.scala.core.http.HttpServerRequest
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.scala.core.http.ServerWebSocket
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.http.HttpServerRequestStream
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}
import io.vertx.core.http.{HttpServer => JHttpServer}
import io.vertx.scala.core.http.HttpConnection
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.scala.core.http.ServerWebSocketStream
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}

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
    extends Measured(_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpServer]
//methods returning a future
  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

//cached methods
  def requestStream():HttpServerRequestStream = {
    asJava.requestStream( )
  }

  def websocketStream():ServerWebSocketStream = {
    asJava.websocketStream( )
  }

//fluent methods
  def requestHandler(handler: io.vertx.core.Handler[HttpServerRequest]):HttpServer = {
    asJava.requestHandler( )
    this
  }

  def connectionHandler(handler: io.vertx.core.Handler[HttpConnection]):HttpServer = {
    asJava.connectionHandler( )
    this
  }

  def websocketHandler(handler: io.vertx.core.Handler[ServerWebSocket]):HttpServer = {
    asJava.websocketHandler( )
    this
  }

  def listen():HttpServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,host: String):HttpServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,host: String,listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServer]]):HttpServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int):HttpServer = {
    asJava.listen( )
    this
  }

  def listen(port: Int,listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServer]]):HttpServer = {
    asJava.listen( )
    this
  }

  def listen(listenHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[HttpServer]]):HttpServer = {
    asJava.listen( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def close():Unit = {
    asJava.close( )
  }

  def close(completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

  def actualPort():Int = {
    asJava.actualPort( )
  }

}

object HttpServer{
//in object!
//static methods
}
