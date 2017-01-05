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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}
import io.vertx.core.Handler

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.ServerWebSocket]], used for
  * notifying web socket connections to a [[io.vertx.scala.core.http.HttpServer]].
  */
class ServerWebSocketStream(private val _asJava: Object) 
    extends ReadStream[ServerWebSocket] {

  def asJava = _asJava

  override def exceptionHandler(handler: Handler[Throwable]):ServerWebSocketStream = {
    asJava.asInstanceOf[JServerWebSocketStream].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[ServerWebSocket]):ServerWebSocketStream = {
    asJava.asInstanceOf[JServerWebSocketStream].handler({x: JServerWebSocket => handler.handle(ServerWebSocket(x))})
    this
  }

  override def pause():ServerWebSocketStream = {
    asJava.asInstanceOf[JServerWebSocketStream].pause()
    this
  }

  override def resume():ServerWebSocketStream = {
    asJava.asInstanceOf[JServerWebSocketStream].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):ServerWebSocketStream = {
    asJava.asInstanceOf[JServerWebSocketStream].endHandler({x: Void => endHandler.handle(x)})
    this
  }

}

object ServerWebSocketStream{
  def apply(asJava: JServerWebSocketStream) = new ServerWebSocketStream(asJava)  
}
