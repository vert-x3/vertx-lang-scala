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

import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.http.HttpFrame
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.net.{NetSocket => JNetSocket}

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

  override def asJava = _asJava.asInstanceOf[JHttpClientResponse]
//methods returning a future
//cached methods
  def headers():MultiMap = {
    asJava.headers( )
  }

  def trailers():MultiMap = {
    asJava.trailers( )
  }

  def cookies():scala.collection.mutable.Buffer[String] = {
    asJava.cookies( )
  }

  def netSocket():NetSocket = {
    asJava.netSocket( )
  }

//fluent methods
  override def resume():HttpClientResponse = {
    asJava.resume( )
    this
  }

  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpClientResponse = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Buffer]):HttpClientResponse = {
    asJava.handler( )
    this
  }

  override def pause():HttpClientResponse = {
    asJava.pause( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):HttpClientResponse = {
    asJava.endHandler( )
    this
  }

  def bodyHandler(bodyHandler: io.vertx.core.Handler[Buffer]):HttpClientResponse = {
    asJava.bodyHandler( )
    this
  }

  def customFrameHandler(handler: io.vertx.core.Handler[HttpFrame]):HttpClientResponse = {
    asJava.customFrameHandler( )
    this
  }

//basic methods
  def version():io.vertx.core.http.HttpVersion = {
    asJava.version( )
  }

  def statusCode():Int = {
    asJava.statusCode( )
  }

  def statusMessage():String = {
    asJava.statusMessage( )
  }

  def getHeader(headerName: String):String = {
    asJava.getHeader( )
  }

  def getTrailer(trailerName: String):String = {
    asJava.getTrailer( )
  }

}

object HttpClientResponse{
//in object!
//static methods
}
