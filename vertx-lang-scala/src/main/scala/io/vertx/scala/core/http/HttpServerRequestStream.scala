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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.Handler
import io.vertx.core.http.{HttpServerRequestStream => JHttpServerRequestStream}

/**
  * A [[io.vertx.scala.core.streams.ReadStream]] of [[io.vertx.scala.core.http.HttpServerRequest]], used for
  * notifying http request to a [[io.vertx.scala.core.http.HttpServer]].
  */
class HttpServerRequestStream(private val _asJava: Object) 
    extends  ReadStream[HttpServerRequest] {

  def asJava = _asJava

//io.vertx.core.Handler<java.lang.Throwable>
  override def exceptionHandler(handler: Handler[Throwable]):HttpServerRequestStream = {
    asJava.asInstanceOf[JHttpServerRequestStream].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

//io.vertx.core.Handler<io.vertx.core.http.HttpServerRequest>
  override def handler(handler: Handler[HttpServerRequest]):HttpServerRequestStream = {
    asJava.asInstanceOf[JHttpServerRequestStream].handler({x: JHttpServerRequest => handler.handle(HttpServerRequest(x))})
    this
  }

  override def pause():HttpServerRequestStream = {
    asJava.asInstanceOf[JHttpServerRequestStream].pause()
    this
  }

  override def resume():HttpServerRequestStream = {
    asJava.asInstanceOf[JHttpServerRequestStream].resume()
    this
  }

//io.vertx.core.Handler<java.lang.Void>
  override def endHandler(endHandler: Handler[Unit]):HttpServerRequestStream = {
    asJava.asInstanceOf[JHttpServerRequestStream].endHandler({x: Void => endHandler.handle(x)})
    this
  }

}

object HttpServerRequestStream{
  def apply(asJava: JHttpServerRequestStream) = new HttpServerRequestStream(asJava)  
}
