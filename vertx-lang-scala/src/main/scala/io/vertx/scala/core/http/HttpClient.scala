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
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{WebSocketStream => JWebSocketStream}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.http.WebsocketVersion

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

  def asJava: Object = _asJava

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JHttpClient].isMetricsEnabled()
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
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, port, host, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the specified host and default port.
    * @param method the HTTP method
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, host, requestURI))
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
  def request(method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
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
  def request(method: io.vertx.core.http.HttpMethod, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port.
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, requestURI))
  }

  /**
    * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def request(method: io.vertx.core.http.HttpMethod, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].request(method, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].requestAbs(method, absoluteURI))
  }

  /**
    * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param method the HTTP method
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def requestAbs(method: io.vertx.core.http.HttpMethod, absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].requestAbs(method, absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(port, host, requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(host, requestURI))
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
  def get(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def get(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(requestURI))
  }

  /**
    * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def get(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].get(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI))
  }

  /**
    * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def getAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
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
  def getNow(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
  def getNow(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
    this
  }

  /**
    * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def getNow(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(port, host, requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(host, requestURI))
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
  def post(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def post(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(requestURI))
  }

  /**
    * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def post(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].post(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI))
  }

  /**
    * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def postAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(port, host, requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(host, requestURI))
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
  def head(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def head(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(requestURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def head(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].head(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI))
  }

  /**
    * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def headAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
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
  def headNow(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
  def headNow(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
    this
  }

  /**
    * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def headNow(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(port, host, requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(host, requestURI))
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
  def options(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def options(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(requestURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def options(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].options(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI))
  }

  /**
    * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def optionsAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
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
  def optionsNow(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
  def optionsNow(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
    this
  }

  /**
    * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return a reference to this, so the API can be used fluently
    */
  def optionsNow(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]])
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
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(port, host, requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(host, requestURI))
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
  def put(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def put(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(requestURI))
  }

  /**
    * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def put(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].put(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI))
  }

  /**
    * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def putAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and port.
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(port, host, requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port.
    * @param host the host
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(host, requestURI))
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
  def delete(port: Int, host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(port, host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
    * the response
    * @param host the host
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(host: String, requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(host, requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port.
    * @param requestURI the relative URI
    * @return an HTTP client request object
    */
  def delete(requestURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(requestURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
    * the response
    * @param requestURI the relative URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def delete(requestURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].delete(requestURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI
    * @param absoluteURI the absolute URI
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI))
  }

  /**
    * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
    * the response
    * @param absoluteURI the absolute URI
    * @param responseHandler the response handler
    * @return an HTTP client request object
    */
  def deleteAbs(absoluteURI: String, responseHandler: io.vertx.core.Handler[HttpClientResponse]): HttpClientRequest = {
    HttpClientRequest.apply(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI, funcToMappedHandler[JHttpClientResponse, HttpClientResponse](HttpClientResponse.apply)(responseHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpClientResponse]]))
  }

  /**
    * Connect a WebSocket to the specified port, host and relative request URI
    * @param port the port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(port: Int, host: String, requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(port: Int, host: String, requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  /**
    * Connect a WebSocket to the host and relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(host: String, requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(host: String, requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(port: Int, host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(host: String, requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port
    * @param requestURI the relative URI
    * @param wsConnect handler that will be called with the websocket when connected
    * @param failureHandler handler that will be called if websocket connection fails
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  /**
    * Connect a WebSocket at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @param wsConnect handler that will be called with the websocket when connected
    * @return a reference to this, so the API can be used fluently
    */
  def websocket(requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(requestURI: String, headers: MultiMap, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]])
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
  def websocket(requestURI: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: String, wsConnect: io.vertx.core.Handler[WebSocket], failureHandler: io.vertx.core.Handler[Throwable]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].websocket(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols, funcToMappedHandler[JWebSocket, WebSocket](WebSocket.apply)(wsConnect).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.WebSocket]], funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(failureHandler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(port, host, requestURI))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port
    * @param host the host
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String): WebSocketStream = {
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(host, requestURI))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap]))
  }

  /**
    * Create a WebSocket stream to the specified host, relative request URI and default port and with the specified headers
    * @param host the host
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(host: String, requestURI: String, headers: MultiMap): WebSocketStream = {
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap]))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(port, host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(host, requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String): WebSocketStream = {
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI))
  }

  /**
    * Create a WebSocket stream at the relative request URI using the default host and port and the specified headers
    * @param requestURI the relative URI
    * @param headers the headers
    * @return a reference to this, so the API can be used fluently
    */
  def websocketStream(requestURI: String, headers: MultiMap): WebSocketStream = {
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap]))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap], version))
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
    WebSocketStream.apply(asJava.asInstanceOf[JHttpClient].websocketStream(requestURI, headers.asJava.asInstanceOf[JMultiMap], version, subProtocols))
  }

  /**
    * Close the client. Closing will close down any pooled connections.
    * Clients should always be closed after use.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JHttpClient].close()
  }

}

object HttpClient {

  def apply(_asJava: Object): HttpClient =
    new HttpClient(_asJava)

}
