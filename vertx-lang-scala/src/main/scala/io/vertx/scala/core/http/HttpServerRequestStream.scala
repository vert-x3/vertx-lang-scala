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
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.HttpServerRequest]], used for
  * notifying http request to a [[io.vertx.scala.core.http.HttpServer]].
  */
class HttpServerRequestStream(private val _asJava: JHttpServerRequestStream) 
    extends ReadStream[HttpServerRequest] {

  def asJava: JHttpServerRequestStream = _asJava

  def exceptionHandler(handler: Throwable => Unit): HttpServerRequestStream = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: HttpServerRequest => Unit): HttpServerRequestStream = {
    _asJava.handler(funcToMappedHandler(HttpServerRequest.apply)(handler))
    this
  }

  def pause(): HttpServerRequestStream = {
    _asJava.pause()
    this
  }

  def resume(): HttpServerRequestStream = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): HttpServerRequestStream = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

}

object HttpServerRequestStream {

  def apply(_asJava: JHttpServerRequestStream): HttpServerRequestStream =
    new HttpServerRequestStream(_asJava)

}
