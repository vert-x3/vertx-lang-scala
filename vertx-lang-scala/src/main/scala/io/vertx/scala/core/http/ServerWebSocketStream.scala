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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.ServerWebSocket]], used for
  * notifying web socket connections to a [[io.vertx.scala.core.http.HttpServer]].
  */
class ServerWebSocketStream(private val _asJava: io.vertx.core.http.ServerWebSocketStream) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.http.ServerWebSocket] {

  def asJava: io.vertx.core.http.ServerWebSocketStream = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.ServerWebSocketStream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.http.ServerWebSocket => Unit): io.vertx.scala.core.http.ServerWebSocketStream = {
    _asJava.handler(funcToMappedHandler(ServerWebSocket.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.ServerWebSocketStream = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.ServerWebSocketStream = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): io.vertx.scala.core.http.ServerWebSocketStream = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

}

object ServerWebSocketStream {

  def apply(_asJava: io.vertx.core.http.ServerWebSocketStream): io.vertx.scala.core.http.ServerWebSocketStream =
    new io.vertx.scala.core.http.ServerWebSocketStream(_asJava)

}
