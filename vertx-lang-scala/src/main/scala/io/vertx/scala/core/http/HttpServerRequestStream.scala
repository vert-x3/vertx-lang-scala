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
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.HttpServerRequest]], used for
  * notifying http request to a [[io.vertx.scala.core.http.HttpServer]].
  */
class HttpServerRequestStream(private val _asJava: Object) 
    extends ReadStream[HttpServerRequest](_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpServerRequestStream]
//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpServerRequestStream = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[HttpServerRequest]):HttpServerRequestStream = {
    asJava.handler( )
    this
  }

  override def pause():HttpServerRequestStream = {
    asJava.pause( )
    this
  }

  override def resume():HttpServerRequestStream = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):HttpServerRequestStream = {
    asJava.endHandler( )
    this
  }

//basic methods
}

object HttpServerRequestStream{
//in object!
//static methods
}
