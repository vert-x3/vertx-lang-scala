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

import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress

/**
  * Represents a server-side HTTP request.
  * 
  * Instances are created for each request and passed to the user via a handler.
  * 
  * Each instance of this class is associated with a corresponding [[io.vertx.scala.core.http.HttpServerResponse]] instance via
  * [[io.vertx.scala.core.http.HttpServerRequest#response]].
  * It implements [[io.vertx.scala.core.streams.ReadStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  * 
  */
class HttpServerRequest(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) {

  private var cached_0:HttpServerResponse = _
    private var cached_1:MultiMap = _
    private var cached_2:MultiMap = _
    private var cached_3:SocketAddress = _
    private var cached_4:SocketAddress = _
    private var cached_5:NetSocket = _
    private var cached_6:MultiMap = _
    private var cached_7:HttpConnection = _
  
//methods returning a future
//cached methods
  def response():HttpServerResponse = {
    if(cached_0 == null)
      cached_0 = HttpServerResponse(asJava.asInstanceOf[JHttpServerRequest].response())
    return cached_0
  }

  def headers():MultiMap = {
    if(cached_1 == null)
      cached_1 = MultiMap(asJava.asInstanceOf[JHttpServerRequest].headers())
    return cached_1
  }

  def params():MultiMap = {
    if(cached_2 == null)
      cached_2 = MultiMap(asJava.asInstanceOf[JHttpServerRequest].params())
    return cached_2
  }

  def remoteAddress():SocketAddress = {
    if(cached_3 == null)
      cached_3 = SocketAddress(asJava.asInstanceOf[JHttpServerRequest].remoteAddress())
    return cached_3
  }

  def localAddress():SocketAddress = {
    if(cached_4 == null)
      cached_4 = SocketAddress(asJava.asInstanceOf[JHttpServerRequest].localAddress())
    return cached_4
  }

  def netSocket():NetSocket = {
    if(cached_5 == null)
      cached_5 = NetSocket(asJava.asInstanceOf[JHttpServerRequest].netSocket())
    return cached_5
  }

  def formAttributes():MultiMap = {
    if(cached_6 == null)
      cached_6 = MultiMap(asJava.asInstanceOf[JHttpServerRequest].formAttributes())
    return cached_6
  }

  def connection():HttpConnection = {
    if(cached_7 == null)
      cached_7 = HttpConnection(asJava.asInstanceOf[JHttpServerRequest].connection())
    return cached_7
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].exceptionHandler(handler))
    this
  }

  override def handler(handler: Handler[Buffer]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].handler(handler))
    this
  }

  override def pause():HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].pause())
    this
  }

  override def resume():HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].endHandler(endHandler))
    this
  }

  def bodyHandler(bodyHandler: Handler[Buffer]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].bodyHandler(bodyHandler))
    this
  }

  def setExpectMultipart(expect: Boolean):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].setExpectMultipart(expect))
    this
  }

  def uploadHandler(uploadHandler: Handler[HttpServerFileUpload]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].uploadHandler(uploadHandler))
    this
  }

  def customFrameHandler(handler: Handler[HttpFrame]):HttpServerRequest = {
    HttpServerRequest(asJava.asInstanceOf[JHttpServerRequest].customFrameHandler(handler))
    this
  }

//basic methods
  def version():io.vertx.core.http.HttpVersion = {
    asJava.asInstanceOf[JHttpServerRequest].version()
  }

  def method():io.vertx.core.http.HttpMethod = {
    asJava.asInstanceOf[JHttpServerRequest].method()
  }

  def rawMethod():String = {
    asJava.asInstanceOf[JHttpServerRequest].rawMethod()
  }

  def isSSL():Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isSSL()
  }

  def scheme():String = {
    asJava.asInstanceOf[JHttpServerRequest].scheme()
  }

  def uri():String = {
    asJava.asInstanceOf[JHttpServerRequest].uri()
  }

  def path():String = {
    asJava.asInstanceOf[JHttpServerRequest].path()
  }

  def query():String = {
    asJava.asInstanceOf[JHttpServerRequest].query()
  }

  def host():String = {
    asJava.asInstanceOf[JHttpServerRequest].host()
  }

  def getHeader(headerName: String):String = {
    asJava.asInstanceOf[JHttpServerRequest].getHeader(headerName)
  }

  def getParam(paramName: String):String = {
    asJava.asInstanceOf[JHttpServerRequest].getParam(paramName)
  }

  def absoluteURI():String = {
    asJava.asInstanceOf[JHttpServerRequest].absoluteURI()
  }

  def isExpectMultipart():Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isExpectMultipart()
  }

  def getFormAttribute(attributeName: String):String = {
    asJava.asInstanceOf[JHttpServerRequest].getFormAttribute(attributeName)
  }

  def upgrade():ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JHttpServerRequest].upgrade())
  }

  def isEnded():Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isEnded()
  }

}

object HttpServerRequest{
  def apply(asJava: JHttpServerRequest) = new HttpServerRequest(asJava)//static methods
}
