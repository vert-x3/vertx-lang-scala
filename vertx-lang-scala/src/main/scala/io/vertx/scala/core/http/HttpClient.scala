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

import io.vertx.scala.core.http.HttpClientRequest
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.scala.core.http.HttpClientResponse
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.http.WebSocketStream
import io.vertx.core.http.{WebSocketStream => JWebSocketStream}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.http.WebSocket
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.http.WebsocketVersion
import io.vertx.core.http.{HttpClient => JHttpClient}

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

  override def asJava = _asJava.asInstanceOf[JHttpClient]
//methods returning a future
//cached methods
//fluent methods
  def getNow(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.getNow( )
    this
  }

  def getNow(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.getNow( )
    this
  }

  def getNow(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.getNow( )
    this
  }

  def headNow(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.headNow( )
    this
  }

  def headNow(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.headNow( )
    this
  }

  def headNow(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.headNow( )
    this
  }

  def optionsNow(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.optionsNow( )
    this
  }

  def optionsNow(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.optionsNow( )
    this
  }

  def optionsNow(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClient = {
    asJava.optionsNow( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket]):HttpClient = {
    asJava.websocket( )
    this
  }

  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: io.vertx.core.Handler[WebSocket],failureHandler: io.vertx.core.Handler[Throwable]):HttpClient = {
    asJava.websocket( )
    this
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.request( )
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String):HttpClientRequest = {
    asJava.request( )
  }

  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.request( )
  }

  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.request( )
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String):HttpClientRequest = {
    asJava.request( )
  }

  def request(method: io.vertx.core.http.HttpMethod,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.request( )
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String):HttpClientRequest = {
    asJava.requestAbs( )
  }

  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.requestAbs( )
  }

  def get(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.get( )
  }

  def get(host: String,requestURI: String):HttpClientRequest = {
    asJava.get( )
  }

  def get(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.get( )
  }

  def get(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.get( )
  }

  def get(requestURI: String):HttpClientRequest = {
    asJava.get( )
  }

  def get(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.get( )
  }

  def getAbs(absoluteURI: String):HttpClientRequest = {
    asJava.getAbs( )
  }

  def getAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.getAbs( )
  }

  def post(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.post( )
  }

  def post(host: String,requestURI: String):HttpClientRequest = {
    asJava.post( )
  }

  def post(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.post( )
  }

  def post(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.post( )
  }

  def post(requestURI: String):HttpClientRequest = {
    asJava.post( )
  }

  def post(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.post( )
  }

  def postAbs(absoluteURI: String):HttpClientRequest = {
    asJava.postAbs( )
  }

  def postAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.postAbs( )
  }

  def head(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.head( )
  }

  def head(host: String,requestURI: String):HttpClientRequest = {
    asJava.head( )
  }

  def head(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.head( )
  }

  def head(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.head( )
  }

  def head(requestURI: String):HttpClientRequest = {
    asJava.head( )
  }

  def head(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.head( )
  }

  def headAbs(absoluteURI: String):HttpClientRequest = {
    asJava.headAbs( )
  }

  def headAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.headAbs( )
  }

  def options(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.options( )
  }

  def options(host: String,requestURI: String):HttpClientRequest = {
    asJava.options( )
  }

  def options(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.options( )
  }

  def options(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.options( )
  }

  def options(requestURI: String):HttpClientRequest = {
    asJava.options( )
  }

  def options(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.options( )
  }

  def optionsAbs(absoluteURI: String):HttpClientRequest = {
    asJava.optionsAbs( )
  }

  def optionsAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.optionsAbs( )
  }

  def put(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.put( )
  }

  def put(host: String,requestURI: String):HttpClientRequest = {
    asJava.put( )
  }

  def put(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.put( )
  }

  def put(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.put( )
  }

  def put(requestURI: String):HttpClientRequest = {
    asJava.put( )
  }

  def put(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.put( )
  }

  def putAbs(absoluteURI: String):HttpClientRequest = {
    asJava.putAbs( )
  }

  def putAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.putAbs( )
  }

  def delete(port: Int,host: String,requestURI: String):HttpClientRequest = {
    asJava.delete( )
  }

  def delete(host: String,requestURI: String):HttpClientRequest = {
    asJava.delete( )
  }

  def delete(port: Int,host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.delete( )
  }

  def delete(host: String,requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.delete( )
  }

  def delete(requestURI: String):HttpClientRequest = {
    asJava.delete( )
  }

  def delete(requestURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.delete( )
  }

  def deleteAbs(absoluteURI: String):HttpClientRequest = {
    asJava.deleteAbs( )
  }

  def deleteAbs(absoluteURI: String,responseHandler: io.vertx.core.Handler[HttpClientResponse]):HttpClientRequest = {
    asJava.deleteAbs( )
  }

  def websocketStream(port: Int,host: String,requestURI: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(host: String,requestURI: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(requestURI: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(requestURI: String,headers: MultiMap):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    asJava.websocketStream( )
  }

  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    asJava.websocketStream( )
  }

  def close():Unit = {
    asJava.close( )
  }

}

object HttpClient{
//in object!
//static methods
}
