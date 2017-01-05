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
    extends ReadStream[Buffer] {

  def asJava = _asJava
  private var cached_0:MultiMap = _
  private var cached_1:MultiMap = _
  private var cached_2:scala.collection.mutable.Buffer[String] = _
  private var cached_3:NetSocket = _

  /**
    * @return the headers
    */
  def headers():MultiMap = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientResponse].headers()
      cached_0 = MultiMap(tmp)
    }
    cached_0
  }

  /**
    * @return the trailers
    */
  def trailers():MultiMap = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientResponse].trailers()
      cached_1 = MultiMap(tmp)
    }
    cached_1
  }

  /**
    * @return the Set-Cookie headers (including trailers)
    */
  def cookies():scala.collection.mutable.Buffer[String] = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientResponse].cookies()
      cached_2 = tmp.asScala.map(x => x.asInstanceOf[String])
    }
    cached_2
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
  def netSocket():NetSocket = {
    if(cached_3 == null) {
      var tmp = asJava.asInstanceOf[JHttpClientResponse].netSocket()
      cached_3 = NetSocket(tmp)
    }
    cached_3
  }

  override def resume():HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].resume()
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[Buffer]):HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].handler({x: JBuffer => handler.handle(Buffer(x))})
    this
  }

  override def pause():HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].pause()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves you having to manually set a dataHandler and an endHandler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: Handler[Buffer]):HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].bodyHandler({x: JBuffer => bodyHandler.handle(Buffer(x))})
    this
  }

  /**
    * Set an custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
    * frame. HTTP/2 permits extension of the protocol.
    * @return a reference to this, so the API can be used fluently
    */
  def customFrameHandler(handler: Handler[HttpFrame]):HttpClientResponse = {
    asJava.asInstanceOf[JHttpClientResponse].customFrameHandler({x: JHttpFrame => handler.handle(HttpFrame(x))})
    this
  }

  /**
    * @return the version of the response
    */
  def version():io.vertx.core.http.HttpVersion = {
    asJava.asInstanceOf[JHttpClientResponse].version()
  }

  /**
    * @return the status code of the response
    */
  def statusCode():Int = {
    asJava.asInstanceOf[JHttpClientResponse].statusCode().asInstanceOf[Int]
  }

  /**
    * @return the status message of the response
    */
  def statusMessage():String = {
    asJava.asInstanceOf[JHttpClientResponse].statusMessage().asInstanceOf[String]
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpClientResponse].getHeader(headerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
    * Return the first trailer value with the specified name
    * @param trailerName the trailer name
    * @return the trailer value
    */
  def getTrailer(trailerName: String):scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpClientResponse].getTrailer(trailerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

}

object HttpClientResponse{
  def apply(asJava: JHttpClientResponse) = new HttpClientResponse(asJava)  
}
