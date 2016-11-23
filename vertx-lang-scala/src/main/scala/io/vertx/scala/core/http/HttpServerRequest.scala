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
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].response()
      cached_0 = HttpServerResponse(tmp)
    }
    return cached_0
  }

  def headers():MultiMap = {
    if(cached_1 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].headers()
      cached_1 = MultiMap(tmp)
    }
    return cached_1
  }

  def params():MultiMap = {
    if(cached_2 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].params()
      cached_2 = MultiMap(tmp)
    }
    return cached_2
  }

  def remoteAddress():SocketAddress = {
    if(cached_3 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].remoteAddress()
      cached_3 = SocketAddress(tmp)
    }
    return cached_3
  }

  def localAddress():SocketAddress = {
    if(cached_4 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].localAddress()
      cached_4 = SocketAddress(tmp)
    }
    return cached_4
  }

  def netSocket():NetSocket = {
    if(cached_5 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].netSocket()
      cached_5 = NetSocket(tmp)
    }
    return cached_5
  }

  def formAttributes():MultiMap = {
    if(cached_6 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].formAttributes()
      cached_6 = MultiMap(tmp)
    }
    return cached_6
  }

  def connection():HttpConnection = {
    if(cached_7 == null) {
      var tmp = asJava.asInstanceOf[JHttpServerRequest].connection()
      cached_7 = HttpConnection(tmp)
    }
    return cached_7
  }

//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].exceptionHandler(x => handler.handle(x))
    this
  }

  override def handler(handler: Handler[Buffer]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].handler(x => handler.handle(x.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def pause():HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].pause()
    this
  }

  override def resume():HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].endHandler(x => endHandler.handle(x))
    this
  }

  def bodyHandler(bodyHandler: Handler[Buffer]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].bodyHandler(x => bodyHandler.handle(x.asJava.asInstanceOf[JBuffer]))
    this
  }

  def setExpectMultipart(expect: Boolean):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].setExpectMultipart(expect)
    this
  }

  def uploadHandler(uploadHandler: Handler[HttpServerFileUpload]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].uploadHandler(x => uploadHandler.handle(x.asJava.asInstanceOf[JHttpServerFileUpload]))
    this
  }

  def customFrameHandler(handler: Handler[HttpFrame]):HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].customFrameHandler(x => handler.handle(x.asJava.asInstanceOf[JHttpFrame]))
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
  def apply(asJava: JHttpServerRequest) = new HttpServerRequest(asJava)
//static methods
}
