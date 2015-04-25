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
import scala.util.Try
import io.vertx.core.Handler

class HttpServer(private val _asJava: io.vertx.core.http.HttpServer) 
    extends io.vertx.scala.core.metrics.Measured {

  def asJava: java.lang.Object = _asJava

  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  def requestStream(): io.vertx.scala.core.http.HttpServerRequestStream = {
    HttpServerRequestStream.apply(_asJava.requestStream())
  }

  def requestHandler(handler: io.vertx.scala.core.http.HttpServerRequest => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpServer.apply(_asJava.requestHandler(funcToMappedHandler(HttpServerRequest.apply)(handler)))
  }

  def websocketStream(): io.vertx.scala.core.http.ServerWebSocketStream = {
    ServerWebSocketStream.apply(_asJava.websocketStream())
  }

  def websocketHandler(handler: io.vertx.scala.core.http.ServerWebSocket => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    HttpServer.apply(_asJava.websocketHandler(funcToMappedHandler(ServerWebSocket.apply)(handler)))
  }

  def listen(): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen()
    this
  }

  def listen(port: Int, host: String): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port, host)
    this
  }

  def listen(port: Int, host: String)(listenHandler: Try[io.vertx.scala.core.http.HttpServer] => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(port, host, funcToMappedAsyncResultHandler(HttpServer.apply)(listenHandler))
    this
  }

  def listen(port: Int): io.vertx.scala.core.http.HttpServer = {
    _asJava.listen(port)
    this
  }

  def listen(port: Int)(listenHandler: Try[io.vertx.scala.core.http.HttpServer] => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(port, funcToMappedAsyncResultHandler(HttpServer.apply)(listenHandler))
    this
  }

  def listen(listenHandler: Try[io.vertx.scala.core.http.HttpServer] => Unit): io.vertx.scala.core.http.HttpServer = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.listen(funcToMappedAsyncResultHandler(HttpServer.apply)(listenHandler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

  def close(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

}

object HttpServer {

  def apply(_asJava: io.vertx.core.http.HttpServer): io.vertx.scala.core.http.HttpServer =
    new io.vertx.scala.core.http.HttpServer(_asJava)
}
