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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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
    extends  Measured {

  def asJava = _asJava

  /**
    * Sends an HTTP GET request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def getNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def getNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def getNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def headNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP HEAD request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def headNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def headNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def optionsNow(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP OPTIONS request to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def optionsNow(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.HttpClientResponse>
  def optionsNow(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(port: Int,host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(host: String,requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified host,relative request UR, and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(host: String,requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//int
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(requestURI: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(requestURI: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(requestURI: String,headers: MultiMap,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))})
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
//java.lang.String
//io.vertx.core.MultiMap
//io.vertx.core.http.WebsocketVersion
//java.lang.String
//io.vertx.core.Handler<io.vertx.core.http.WebSocket>
//io.vertx.core.Handler<java.lang.Throwable>
  def websocket(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String,wsConnect: Handler[WebSocket],failureHandler: Handler[Throwable]):HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String],{x: JWebSocket => wsConnect.handle(WebSocket(x))},{x: Throwable => failureHandler.handle(x)})
    this
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JHttpClient].isMetricsEnabled().asInstanceOf[Boolean]
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port.
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port.
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port.
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method,requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod,absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method,absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(port: Int,host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(host: String,requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(port: Int,host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(host: String,requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(requestURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(requestURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String,responseHandler: Handler[HttpClientResponse]):HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String],{x: JHttpClientResponse => responseHandler.handle(HttpClientResponse(x))}))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int,host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String,requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String,requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers and using
    * the specified version of WebSockets
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers and using
    * the specified version of WebSockets
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int,host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(port.asInstanceOf[java.lang.Integer],host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port, with the specified headers, using
    * the specified version of WebSockets, and the specified websocket sub protocols
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols to use
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String,requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(host.asInstanceOf[java.lang.String],requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String,headers: MultiMap):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers, the
    * specified version of WebSockets and the specified sub protocols
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @param subProtocols the subprotocols
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String,headers: MultiMap,version: io.vertx.core.http.WebsocketVersion,subProtocols: String):WebSocketStream = {
    WebSocketStream(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI.asInstanceOf[java.lang.String],headers.asJava.asInstanceOf[JMultiMap],version,subProtocols.asInstanceOf[java.lang.String]))
  }

  /**
    * Close the client. Closing will close down any pooled connections.
    * Clients should always be closed after use.
    */
  def close():Unit = {
    asJava.asInstanceOf[JHttpClient].close()
  }

}

object HttpClient{
  def apply(asJava: JHttpClient) = new HttpClient(asJava)  
}
