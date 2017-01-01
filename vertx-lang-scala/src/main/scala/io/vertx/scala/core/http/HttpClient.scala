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
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.http.WebsocketVersion
import io.vertx.core.Handler
import io.vertx.core.http.{WebSocketStream => JWebSocketStream}
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}

/**
  * An asynchronous HTTP client.
  * 
  * It allows you to make requests to HTTP servers, and a single client can make requests to any server.
  * 
  * It also allows you to open WebSockets to servers.
  * 
  * The client can also pool HTTP connections.
  * 
  * For pooling to occur, keep-alive must be true on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is true).
  * In this case connections will be pooled and re-used if there are pending HTTP requests waiting to get a connection,
  * otherwise they will be closed.
  * 
  * This gives the benefits of keep alive when the client is loaded but means we don't keep connections hanging around
  * unnecessarily when there would be no benefits anyway.
  * 
  * The client also supports pipe-lining of requests. Pipe-lining means another request is sent on the same connection
  * before the response from the preceding one has returned. Pipe-lining is not appropriate for all requests.
  * 
  * To enable pipe-lining, it must be enabled on the <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a> (default is false).
  * 
  * When pipe-lining is enabled the connection will be automatically closed when all in-flight responses have returned
  * and there are no outstanding pending requests to write.
  * 
  * The client is designed to be reused between requests.
  */
class HttpClient(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava

//cached methods
//fluent methods
  def getNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def getNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def getNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def headNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def headNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def headNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def optionsNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def optionsNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def optionsNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

//default methods
//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JHttpClient].isMetricsEnabled().asInstanceOf[Boolean]
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI.asInstanceOf[java.lang.String]))
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI.asInstanceOf[java.lang.String]))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def get(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def get(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def get(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def get(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def get(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String]))
  }

  def get(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def getAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def getAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def post(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def post(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def post(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def post(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def post(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String]))
  }

  def post(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def postAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def postAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def head(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def head(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def head(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def head(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def head(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String]))
  }

  def head(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def headAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def headAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def options(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def options(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def options(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def options(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def options(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String]))
  }

  def options(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def optionsAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def optionsAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def put(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def put(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def put(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def put(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def put(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String]))
  }

  def put(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def putAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def putAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def delete(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def delete(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def delete(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def delete(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def delete(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String]))
  }

  def delete(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def deleteAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  def deleteAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  def websocketStream(port: Int,host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def websocketStream(host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  def websocketStream(requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String]))
  }

  def websocketStream(requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  def close():Unit = {
    asJava.asInstanceOf[JHttpClient].close()
  }

//future methods
}

  object HttpClient{
    def apply(asJava: Object) = new HttpClient(asJava)  
  //static methods
  }
