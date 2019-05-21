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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.http.{RequestOptions => JRequestOptions}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import scala.reflect.runtime.universe._
import io.vertx.core.http.{WebSocketConnectOptions => JWebSocketConnectOptions}
import io.vertx.scala.core.Future
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.http.WebsocketVersion
import scala.collection.JavaConverters._
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.http.HttpMethod
import io.vertx.core.{Future => JFuture}
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.http.{WebSocket => JWebSocket}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

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

class HttpClient(private val _asJava: Object) extends Measured {
  def asJava = _asJava



  /**
   * Sends an HTTP GET request to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def getNow(options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP GET request to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def getNow(port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP GET request to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def getNow(host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP GET request  to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def getNow(requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].getNow(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP HEAD request to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def headNow(options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP HEAD request to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def headNow(port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP HEAD request to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def headNow(host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP HEAD request  to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def headNow(requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].headNow(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP OPTIONS request to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def optionsNow(options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP OPTIONS request to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def optionsNow(port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP OPTIONS request to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def optionsNow(host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Sends an HTTP OPTIONS request  to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def optionsNow(requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))})
    this
  }

  /**
   * Set a connection handler for the client. This handler is called when a new connection is established.   * @return a reference to this, so the API can be used fluently
   */
  
  def connectionHandler(handler: Handler[HttpConnection]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].connectionHandler({x: JHttpConnection => handler.handle(HttpConnection(x))})
    this
  }

  /**
   * Set a redirect handler for the http client.
   * 
   * The redirect handler is called when a `3xx` response is received and the request is configured to
   * follow redirects with [[io.vertx.scala.core.http.HttpClientRequest#setFollowRedirects]].
   * 
   * The redirect handler is passed the [[io.vertx.scala.core.http.HttpClientResponse]], it can return an [[io.vertx.scala.core.http.HttpClientRequest]] or `null`.
   * <ul>
   *   <li>when null is returned, the original response is processed by the original request response handler</li>
   *   <li>when a new `Future<HttpClientRequest>` is returned, the client will send this new request</li>
   * </ul>
   * The new request will get a copy of the previous request headers unless headers are set. In this case,
   * the client assumes that the redirect handler exclusively managers the headers of the new request.
   * 
   * The handler must return a `Future<HttpClientRequest>` unsent so the client can further configure it and send it.   * @param handler the new redirect handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def redirectHandler(handler: HttpClientResponse => Future[HttpClientRequest]): HttpClient = {
    asJava.asInstanceOf[JHttpClient].redirectHandler({x: JHttpClientResponse => handler(HttpClientResponse(x)).asJava.asInstanceOf[JFuture[JHttpClientRequest]]})
    this
  }


  /**
   * Whether the metrics are enabled for this measured object   * @return `true` if metrics are enabled
   */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JHttpClient].isMetricsEnabled().asInstanceOf[Boolean]
  }


  /**
   * Like [[io.vertx.scala.core.http.HttpClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `options` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], options.asJava))
  }

  /**
   * Create an HTTP request to send to the server with the specified options.   * @param method the HTTP method
   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, options.asJava))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and port.   * @param method the HTTP method
   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `host` and `port` parameters.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and default port.   * @param method the HTTP method
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server with the specified options, specifying a response handler to receive   * @param method the HTTP method
   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `options` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param method the HTTP method
   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `host` and `port` parameters.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param method the HTTP method
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP request to send to the server at the default host and port.   * @param method the HTTP method
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param method the HTTP method
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].request(method, requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP request to send to the server using an absolute URI   * @param method the HTTP method
   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method, absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClient#requestAbs]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `absoluteURI` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method, serverAddress.asJava.asInstanceOf[JSocketAddress], absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param method the HTTP method
   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method, absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClient#requestAbs]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `absoluteURI` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].requestAbs(method, serverAddress.asJava.asInstanceOf[JSocketAddress], absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP GET request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def get (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(options.asJava))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def get (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def get (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def get (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP GET request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def get (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP GET request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def getAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def getAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP POST request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def post (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(options.asJava))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def post (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def post (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def post (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP POST request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def post (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP POST request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def postAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def postAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP HEAD request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def head (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(options.asJava))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def head (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def head (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def head (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def head (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP HEAD request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def headAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def headAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def options (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(options.asJava))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def options (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def options (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def options (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def options (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def options (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def options (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def options (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def optionsAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP OPTIONS request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def optionsAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP PUT request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def put (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(options.asJava))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def put (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def put (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def put (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP PUT request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def put (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP PUT request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def putAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def putAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP DELETE request to send to the server with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def delete (options: RequestOptions): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(options.asJava))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (port: Int, host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (host: String, requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server with the specified options, specifying a response handler to receive
   * the response   * @param options the request options see <a href="../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def delete (options: RequestOptions, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(options.asJava, {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and port, specifying a response handler to receive
   * the response   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def delete (port: Int, host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and default port, specifying a response handler to receive
   * the response   * @param host the host
   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def delete (host: String, requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (requestURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the default host and port, specifying a response handler to receive
   * the response   * @param requestURI the relative URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def delete (requestURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Create an HTTP DELETE request to send to the server using an absolute URI   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def deleteAbs (absoluteURI: String): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @param responseHandler the response handler
   * @return an HTTP client request object
   */
  def deleteAbs (absoluteURI: String, responseHandler: Handler[AsyncResult[HttpClientResponse]]): HttpClientRequest = {
    HttpClientRequest(asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpClientResponse] => responseHandler.handle(AsyncResultWrapper[JHttpClientResponse, HttpClientResponse](x, a => HttpClientResponse(a)))}))
  }

  /**
   * Connect a WebSocket to the specified port, host and relative request URI   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @param handler handler that will be called with the websocket when connected
   */
  def webSocket (port: Int, host: String, requestURI: String, handler: Handler[AsyncResult[WebSocket]]): Unit = {
    asJava.asInstanceOf[JHttpClient].webSocket(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JWebSocket] => handler.handle(AsyncResultWrapper[JWebSocket, WebSocket](x, a => WebSocket(a)))})
  }

  /**
   * Connect a WebSocket to the host and relative request URI and default port   * @param host the host
   * @param requestURI the relative URI
   * @param handler handler that will be called with the websocket when connected
   */
  def webSocket (host: String, requestURI: String, handler: Handler[AsyncResult[WebSocket]]): Unit = {
    asJava.asInstanceOf[JHttpClient].webSocket(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JWebSocket] => handler.handle(AsyncResultWrapper[JWebSocket, WebSocket](x, a => WebSocket(a)))})
  }

  /**
   * Connect a WebSocket at the relative request URI using the default host and port   * @param requestURI the relative URI
   * @param handler handler that will be called with the websocket when connected
   */
  def webSocket (requestURI: String, handler: Handler[AsyncResult[WebSocket]]): Unit = {
    asJava.asInstanceOf[JHttpClient].webSocket(requestURI.asInstanceOf[java.lang.String], {x: AsyncResult[JWebSocket] => handler.handle(AsyncResultWrapper[JWebSocket, WebSocket](x, a => WebSocket(a)))})
  }

  /**
   * Connect a WebSocket with the specified options.   * @param options the request options see <a href="../../../../../../../cheatsheet/WebSocketConnectOptions.html">WebSocketConnectOptions</a>
   */
  def webSocket (options: WebSocketConnectOptions, handler: Handler[AsyncResult[WebSocket]]): Unit = {
    asJava.asInstanceOf[JHttpClient].webSocket(options.asJava, {x: AsyncResult[JWebSocket] => handler.handle(AsyncResultWrapper[JWebSocket, WebSocket](x, a => WebSocket(a)))})
  }

  /**
   * Connect a WebSocket with the specified absolute url, with the specified headers, using
   * the specified version of WebSockets, and the specified websocket sub protocols.   * @param url the absolute url
   * @param headers the headers
   * @param version the websocket version
   * @param subProtocols the subprotocols to use
   * @param handler handler that will be called if websocket connection fails
   */
  def webSocketAbs (url: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[WebSocket]]): Unit = {
    asJava.asInstanceOf[JHttpClient].webSocketAbs(url.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], version, subProtocols.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[JWebSocket] => handler.handle(AsyncResultWrapper[JWebSocket, WebSocket](x, a => WebSocket(a)))})
  }

  /**
   * Close the client. Closing will close down any pooled connections.
   * Clients should always be closed after use.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JHttpClient].close()
  }


 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[request]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestFuture (method: io.vertx.core.http.HttpMethod, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].request(method, requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[requestAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestAbsFuture (method: io.vertx.core.http.HttpMethod, absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].requestAbs(method, absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[requestAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def requestAbsFuture (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].requestAbs(method, serverAddress.asJava.asInstanceOf[JSocketAddress], absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].get(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].get(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].get(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].get(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].getAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getNowFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].getNow(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getNowFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].getNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getNowFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].getNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getNowFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].getNow(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].post(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].post(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].post(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[post]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].post(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[postAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def postAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].postAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].head(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].head(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].head(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[head]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].head(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[headAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].headAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headNowFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].headNow(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headNowFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].headNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headNowFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].headNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[headNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def headNowFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].headNow(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].options(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].options(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].options(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[options]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].options(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[optionsAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].optionsAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsNowFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].optionsNow(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsNowFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].optionsNow(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsNowFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].optionsNow(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[optionsNow]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def optionsNowFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].optionsNow(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].put(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].put(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].put(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].put(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[putAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].putAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteFuture (options: RequestOptions): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].delete(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].delete(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteFuture (host: String, requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].delete(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[delete]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteFuture (requestURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].delete(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteAbsFuture (absoluteURI: String): scala.concurrent.Future[HttpClientResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpClientResponse, HttpClientResponse](x => HttpClientResponse(x))
    asJava.asInstanceOf[JHttpClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def webSocketFuture (port: Int, host: String, requestURI: String): scala.concurrent.Future[WebSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebSocket, WebSocket](x => WebSocket(x))
    asJava.asInstanceOf[JHttpClient].webSocket(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def webSocketFuture (host: String, requestURI: String): scala.concurrent.Future[WebSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebSocket, WebSocket](x => WebSocket(x))
    asJava.asInstanceOf[JHttpClient].webSocket(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def webSocketFuture (requestURI: String): scala.concurrent.Future[WebSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebSocket, WebSocket](x => WebSocket(x))
    asJava.asInstanceOf[JHttpClient].webSocket(requestURI.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[webSocket]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def webSocketFuture (options: WebSocketConnectOptions): scala.concurrent.Future[WebSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebSocket, WebSocket](x => WebSocket(x))
    asJava.asInstanceOf[JHttpClient].webSocket(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[webSocketAbs]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def webSocketAbsFuture (url: String, headers: MultiMap, version: io.vertx.core.http.WebsocketVersion, subProtocols: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[WebSocket] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JWebSocket, WebSocket](x => WebSocket(x))
    asJava.asInstanceOf[JHttpClient].webSocketAbs(url.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], version, subProtocols.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpClient {
  def apply(asJava: JHttpClient) = new HttpClient(asJava)
  
}
