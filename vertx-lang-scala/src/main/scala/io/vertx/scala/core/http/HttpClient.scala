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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.http.{HttpClient => JHttpClient}
    import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
  import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
  import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
  import io.vertx.core.http.HttpMethod
  import io.vertx.core.http.{WebSocketStream => JWebSocketStream}
  import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
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
class HttpClient(private val _asJava: JHttpClient) 
    extends Measured {

  def asJava: JHttpClient = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    _asJava.isMetricsEnabled()
  }

  /**
    * Create an HTTP request to send to the server at the specified host and port.
    * @param method the HTTP method
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port.
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, host, requestURI))
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
  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
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
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port.
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.request(method, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.requestAbs(method, absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(port, host, requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(host, requestURI))
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
  def get(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.get(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.getAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Sends an HTTP GET request to the server at the specified host and port, specifying a response handler to receive
    * the response
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.getNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
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
  def getNow(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.getNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.getNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(port, host, requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(host, requestURI))
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
  def post(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.post(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.postAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(port, host, requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(host, requestURI))
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
  def head(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.head(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.headAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
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
  def headNow(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.headNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
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
  def headNow(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.headNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.headNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(port, host, requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(host, requestURI))
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
  def options(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.options(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.optionsAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
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
  def optionsNow(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.optionsNow(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
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
  def optionsNow(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.optionsNow(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClient = {
    _asJava.optionsNow(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler))
    this
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(port, host, requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(host, requestURI))
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
  def put(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.put(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.putAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(host, requestURI))
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
  def delete(port: Int, host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(port, host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(host, requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(requestURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.delete(requestURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String, responseHandler: HttpClientResponse => Unit): HttpClientRequest = {
    HttpClientRequest.apply(_asJava.deleteAbs(absoluteURI, funcToMappedHandler(HttpClientResponse.apply)(responseHandler)))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: Int, host: String, requestURI: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(port: Int, host: String, requestURI: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(host: String, requestURI: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(requestURI, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(requestURI: String, headers: MultiMap, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect))
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: WebSocket => Unit, failureHandler: Throwable => Unit): HttpClient = {
    _asJava.websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler(WebSocket.apply)(wsConnect), funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler))
    this
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI))
  }

  /**
    * Create a WebSocket stream to the specified port, host and relative request URI, and with the specified headers
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(port: Int, host: String, requestURI: String, headers: MultiMap): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String, headers: MultiMap): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap]))
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
  def websocketStream(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
  def websocketStream(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
  def websocketStream(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
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
  def websocketStream(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: MultiMap): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port, the specified headers and the
    * specified version of WebSockets
    * @param requestURI the relative URI
    * @param headers the headers
    * @param version the websocket version
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
  def websocketStream(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String): WebSocketStream = {
    WebSocketStream.apply(_asJava.websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
  }

  /**
    * Close the client. Closing will close down any pooled connections.
    * Clients should always be closed after use.
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object HttpClient {

  def apply(_asJava: JHttpClient): HttpClient =
    new HttpClient(_asJava)

}
