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

import io.vertx.scala.core.http.ServerWebSocket
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{ServerWebSocketStream => JServerWebSocketStream}

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.ServerWebSocket]], used for
  * notifying web socket connections to a [[io.vertx.scala.core.http.HttpServer]].
  */
class ServerWebSocketStream(private val _asJava: Object) 
    extends ReadStream[ServerWebSocket](_asJava) {

  override def asJava = _asJava.asInstanceOf[JServerWebSocketStream]
//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):ServerWebSocketStream = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[ServerWebSocket]):ServerWebSocketStream = {
    asJava.handler( )
    this
  }

  override def pause():ServerWebSocketStream = {
    asJava.pause( )
    this
  }

  override def resume():ServerWebSocketStream = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):ServerWebSocketStream = {
    asJava.endHandler( )
    this
  }

//basic methods
}

object ServerWebSocketStream{
//in object!
//static methods
}
