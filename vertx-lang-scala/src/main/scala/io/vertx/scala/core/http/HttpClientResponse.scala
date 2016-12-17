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

import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import scala.collection.JavaConverters._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler

/**
  * Represents a client-side HTTP response.
  * 
  * Vert.x provides you with one of these via the handler that was provided when creating the [[io.vertx.scala.core.http.HttpClientRequest]]
  * or that was set on the [[io.vertx.scala.core.http.HttpClientRequest]] instance.
  * 
  * It implements [[io.vertx.scala.core.streams.ReadStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class HttpClientResponse(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) {

  private var cached_0:MultiMap = _
    private var cached_1:MultiMap = _
    private var cached_2:scala.collection.mutable.Buffer[String] = _
    private var cached_3:NetSocket = _
  
//methods returning a future
//cached methods
  def headers():MultiMap = {
    if(cached_0 == null)
      cached_0 = MultiMap(asJava.asInstanceOf[JHttpClientResponse].headers())
    return cached_0
  }

  def trailers():MultiMap = {
    if(cached_1 == null)
      cached_1 = MultiMap(asJava.asInstanceOf[JHttpClientResponse].trailers())
    return cached_1
  }

  def cookies():scala.collection.mutable.Buffer[String] = {
    if(cached_2 == null)
      cached_2 = asJava.asInstanceOf[JHttpClientResponse].cookies().map(x => x)
    return cached_2
  }

  def netSocket():NetSocket = {
    if(cached_3 == null)
      cached_3 = NetSocket(asJava.asInstanceOf[JHttpClientResponse].netSocket())
    return cached_3
  }

//fluent methods
  override def resume():HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].resume())
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[Buffer]):HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].handler(handler))
    this
  }

  override def pause():HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].pause())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].endHandler(endHandler))
    this
  }

  def bodyHandler(bodyHandler: Handler[Buffer]):HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].bodyHandler(bodyHandler))
    this
  }

  def customFrameHandler(handler: Handler[HttpFrame]):HttpClientResponse = {
    HttpClientResponse(asJava.asInstanceOf[JHttpClientResponse].customFrameHandler(handler))
    this
  }

//basic methods
  def version():io.vertx.core.http.HttpVersion = {
    asJava.asInstanceOf[JHttpClientResponse].version()
  }

  def statusCode():Int = {
    asJava.asInstanceOf[JHttpClientResponse].statusCode()
  }

  def statusMessage():String = {
    asJava.asInstanceOf[JHttpClientResponse].statusMessage()
  }

  def getHeader(headerName: String):String = {
    asJava.asInstanceOf[JHttpClientResponse].getHeader(headerName)
  }

  def getTrailer(trailerName: String):String = {
    asJava.asInstanceOf[JHttpClientResponse].getTrailer(trailerName)
  }

}

object HttpClientResponse{
  def apply(asJava: JHttpClientResponse) = new HttpClientResponse(asJava)//static methods
}
