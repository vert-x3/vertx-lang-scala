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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.HttpVersion
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.net.NetSocket

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
    extends ReadStream[Buffer] {

  def asJava: Object = _asJava

  def resume(): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].resume()
    this
  }

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Buffer]): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].handler(funcToMappedHandler[JBuffer, Buffer](Buffer.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  def pause(): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].pause()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * @return the version of the response
    */
  def version(): io.vertx.core.http.HttpVersion = {
    asJava.asInstanceOf[JHttpClientResponse].version()
  }

  /**
    * @return the status code of the response
    */
  def statusCode(): Int = {
    asJava.asInstanceOf[JHttpClientResponse].statusCode()
  }

  /**
    * @return the status message of the response
    */
  def statusMessage(): String = {
    asJava.asInstanceOf[JHttpClientResponse].statusMessage()
  }

  /**
    * @return the headers
    */
  def headers(): MultiMap = {
    if (cached_0 == null) {
      cached_0 = MultiMap.apply(asJava.asInstanceOf[JHttpClientResponse].headers()).asInstanceOf
    }
    cached_0
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpClientResponse].getHeader(headerName))
  }

  /**
    * Return the first trailer value with the specified name
    * @param trailerName the trailer name
    * @return the trailer value
    */
  def getTrailer(trailerName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpClientResponse].getTrailer(trailerName))
  }

  /**
    * @return the trailers
    */
  def trailers(): MultiMap = {
    if (cached_1 == null) {
      cached_1 = MultiMap.apply(asJava.asInstanceOf[JHttpClientResponse].trailers()).asInstanceOf
    }
    cached_1
  }

  /**
    * @return the Set-Cookie headers (including trailers)
    */
  def cookies(): scala.collection.mutable.Buffer[String] = {
    if (cached_2 == null) {
      cached_2 = asJava.asInstanceOf[JHttpClientResponse].cookies().asScala.map(x => x:String).asInstanceOf
    }
    cached_2
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves you having to manually set a dataHandler and an endHandler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: io.vertx.core.Handler[Buffer]): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].bodyHandler(funcToMappedHandler[JBuffer, Buffer](Buffer.apply)(bodyHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  /**
    * Set an custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
    * frame. HTTP/2 permits extension of the protocol.
    * @return a reference to this, so the API can be used fluently
    */
  def customFrameHandler(handler: io.vertx.core.Handler[HttpFrame]): HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].customFrameHandler(funcToMappedHandler[JHttpFrame, HttpFrame](HttpFrame.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpFrame]])
    this
  }

  /**
    * Get a net socket for the underlying connection of this request.
    * 
    * USE THIS WITH CAUTION! Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol
    * 
    * One valid use-case for calling this is to receive the [[io.vertx.scala.core.net.NetSocket]] after a HTTP CONNECT was issued to the
    * remote peer and it responded with a status code of 200.
    * @return the net socket
    */
  def netSocket(): NetSocket = {
    if (cached_3 == null) {
      cached_3 = NetSocket.apply(asJava.asInstanceOf[JHttpClientResponse].netSocket()).asInstanceOf
    }
    cached_3
  }

  private var cached_0: MultiMap = _
  private var cached_1: MultiMap = _
  private var cached_2: scala.collection.mutable.Buffer[String] = _
  private var cached_3: NetSocket = _
}

object HttpClientResponse {

  def apply(_asJava: Object): HttpClientResponse =
    new HttpClientResponse(_asJava)

}
