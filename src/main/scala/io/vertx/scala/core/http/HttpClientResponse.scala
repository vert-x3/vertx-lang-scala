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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.core.net.NetSocket

class HttpClientResponse(private val _asJava: io.vertx.core.http.HttpClientResponse) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def resume(): io.vertx.scala.core.http.HttpClientResponse = {
    _asJava.resume()
    this
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpClientResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpClientResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpClientResponse = {
    _asJava.pause()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.HttpClientResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def statusCode(): Int = {
    _asJava.statusCode()
  }

  def statusMessage(): String = {
    _asJava.statusMessage()
  }

  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  def getHeader(headerName: String): String = {
    _asJava.getHeader(headerName)
  }

  def getTrailer(trailerName: String): String = {
    _asJava.getTrailer(trailerName)
  }

  def trailers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.trailers())
  }

  def cookies(): List[String] = {
    import scala.collection.JavaConverters._
    _asJava.cookies().asScala.map(x => x:String).toList
  }

  def bodyHandler(bodyHandler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpClientResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.bodyHandler(funcToMappedHandler(Buffer.apply)(bodyHandler))
    this
  }

  def netSocket(): io.vertx.scala.core.net.NetSocket = {
    NetSocket.apply(_asJava.netSocket())
  }

}

object HttpClientResponse {

  def apply(_asJava: io.vertx.core.http.HttpClientResponse): io.vertx.scala.core.http.HttpClientResponse =
    new io.vertx.scala.core.http.HttpClientResponse(_asJava)
}
