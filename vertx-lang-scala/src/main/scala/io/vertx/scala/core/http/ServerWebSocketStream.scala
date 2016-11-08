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
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.ServerWebSocket]], used for
  * notifying web socket connections to a [[io.vertx.scala.core.http.HttpServer]].
  */
class ServerWebSocketStream(private val _asJava: JServerWebSocketStream) 
    extends ReadStream[ServerWebSocket] {

  def asJava: JServerWebSocketStream = _asJava

  def exceptionHandler(handler: Throwable => Unit): ServerWebSocketStream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: ServerWebSocket => Unit): ServerWebSocketStream = {
    _asJava.handler(funcToMappedHandler(ServerWebSocket.apply)(handler))
    this
  }

  def pause(): ServerWebSocketStream = {
    _asJava.pause()
    this
  }

  def resume(): ServerWebSocketStream = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): ServerWebSocketStream = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

}

object ServerWebSocketStream {

  def apply(_asJava: JServerWebSocketStream): ServerWebSocketStream =
    new ServerWebSocketStream(_asJava)

}
