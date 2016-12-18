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

import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.{HttpClient => JHttpClient}
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
    extends Measured(_asJava) {


//methods returning a future
//cached methods
//fluent methods
  def getNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def getNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def getNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def headNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def headNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def headNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def optionsNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def optionsNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def optionsNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse]))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],version,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]))
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols,x => wsConnect.handle(x.asJava.asInstanceOf[JWebSocket]),x => failureHandler.handle(x))
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JHttpClient].isMetricsEnabled()
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port,host,requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host,requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI))
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI))
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def get(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port,host,requestURI))
  }

  def get(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host,requestURI))
  }

  def get(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def get(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def get(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI))
  }

  def get(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def getAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI))
  }

  def getAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def post(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port,host,requestURI))
  }

  def post(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host,requestURI))
  }

  def post(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def post(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def post(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI))
  }

  def post(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def postAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI))
  }

  def postAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def head(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port,host,requestURI))
  }

  def head(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host,requestURI))
  }

  def head(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def head(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def head(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI))
  }

  def head(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def headAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI))
  }

  def headAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def options(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port,host,requestURI))
  }

  def options(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host,requestURI))
  }

  def options(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def options(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def options(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI))
  }

  def options(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def optionsAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI))
  }

  def optionsAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def put(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port,host,requestURI))
  }

  def put(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host,requestURI))
  }

  def put(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def put(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def put(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI))
  }

  def put(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def putAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI))
  }

  def putAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def delete(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port,host,requestURI))
  }

  def delete(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host,requestURI))
  }

  def delete(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port,host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def delete(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host,requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def delete(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI))
  }

  def delete(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def deleteAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI))
  }

  def deleteAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI,x => responseHandler.handle(x.asJava.asInstanceOf[JHttpClientResponse])))
  }

  def websocketStream(port: Int,host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port,host,requestURI))
  }

  def websocketStream(host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host,requestURI))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host,requestURI,headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port,host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols))
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host,requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols))
  }

  def websocketStream(requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI))
  }

  def websocketStream(requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI,headers.asJava.asInstanceOf[JMultiMap]))
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI,headers.asJava.asInstanceOf[JMultiMap],version))
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI,headers.asJava.asInstanceOf[JMultiMap],version,subProtocols))
  }

  def close():Unit = {
    asJava.asInstanceOf[JHttpClient].close()
  }

}

object HttpClient{
  def apply(asJava: JHttpClient) = new HttpClient(asJava)//static methods
}
