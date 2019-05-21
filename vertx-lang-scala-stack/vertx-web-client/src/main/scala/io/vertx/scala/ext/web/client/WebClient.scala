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

package io.vertx.scala.ext.web.client

import io.vertx.scala.core.http.HttpClient
import io.vertx.core.http.{RequestOptions => JRequestOptions}
import io.vertx.ext.web.client.{WebClient => JWebClient}
import scala.reflect.runtime.universe._
import io.vertx.ext.web.client.{HttpRequest => JHttpRequest}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.http.RequestOptions
import io.vertx.core.http.{HttpClient => JHttpClient}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.client.{WebClientOptions => JWebClientOptions}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

/**
  * An asynchronous HTTP / HTTP/2 client called `WebClient`.
  * 
  * The web client makes easy to do HTTP request/response interactions with a web server, and provides advanced
  * features like:
  * <ul>
  *   <li>Json body encoding / decoding</li>
  *   <li>request/response pumping</li>
  *   <li>error handling</li>
  * </ul>
  * 
  * The web client does not deprecate the , it is actually based on it and therefore inherits
  * its configuration and great features like pooling. The `HttpClient` should be used when fine grained control over the HTTP
  * requests/response is necessary.
  */

class WebClient(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Create an HTTP request to send to the server at the specified host and port.   * @param method the HTTP method
   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.WebClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `port` and `host` parameters.
   * 
   * The request host header will still be created from the `port` and `host` parameters.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and default port.   * @param method the HTTP method
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.WebClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the default port and `host` parameter.
   * 
   * The request host header will still be created from the default port and `host` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server at the default host and port.   * @param method the HTTP method
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.WebClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the default port and default host.
   * 
   * The request host header will still be created from the default port and default host.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP request to send to the server at the specified host and port.   * @param method the HTTP method
   * @param options the request options see <a href="../../../../../../../../cheatsheet/RequestOptions.html">RequestOptions</a>
   * @return an HTTP client request object
   */
  def request (method: io.vertx.core.http.HttpMethod, options: RequestOptions): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, options.asJava))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.WebClient#request]] using the `serverAddress` parameter to connect to the
   * server instead of the `options` parameter.
   * 
   * The request host header will still be created from the `options` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def request (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, options: RequestOptions): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].request(method, serverAddress.asJava.asInstanceOf[JSocketAddress], options.asJava))
  }

  /**
   * Create an HTTP request to send to the server using an absolute URI   * @param method the HTTP method
   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].requestAbs(method, absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Like [[io.vertx.scala.ext.web.client.WebClient#requestAbs]] using the `serverAddress` parameter to connect to the
   * server instead of the `absoluteURI` parameter.
   * 
   * The request host header will still be created from the `absoluteURI` parameter.
   * 
   * Use  to connect to a unix domain socket server.
   */
  def requestAbs (method: io.vertx.core.http.HttpMethod, serverAddress: SocketAddress, absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].requestAbs(method, serverAddress.asJava.asInstanceOf[JSocketAddress], absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].get(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].get(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def get (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].get(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP GET request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def getAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].getAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].post(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].post(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def post (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].post(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP POST request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def postAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].postAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].put(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].put(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def put (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].put(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PUT request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def putAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].putAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].delete(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].delete(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def delete (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].delete(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP DELETE request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def deleteAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].deleteAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PATCH request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def patch (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].patch(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PATCH request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def patch (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].patch(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PATCH request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def patch (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].patch(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP PATCH request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def patchAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].patchAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the default host and port.   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].head(requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and port.   * @param port the port
   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (port: Int, host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].head(port.asInstanceOf[java.lang.Integer], host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server at the specified host and default port.   * @param host the host
   * @param requestURI the relative URI
   * @return an HTTP client request object
   */
  def head (host: String, requestURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].head(host.asInstanceOf[java.lang.String], requestURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Create an HTTP HEAD request to send to the server using an absolute URI, specifying a response handler to receive
   * the response   * @param absoluteURI the absolute URI
   * @return an HTTP client request object
   */
  def headAbs (absoluteURI: String): HttpRequest[io.vertx.core.buffer.Buffer] = {
    HttpRequest[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JWebClient].headAbs(absoluteURI.asInstanceOf[java.lang.String]))
  }

  /**
   * Close the client. Closing will close down any pooled connections.
   * Clients should always be closed after use.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JWebClient].close()
  }


}

object WebClient {
  def apply(asJava: JWebClient) = new WebClient(asJava)
  
  /**
   * Create a web client using the provided `vertx` instance and default options.   * @param vertx the vertx instance
   * @return the created web client
   */
  def create(vertx: Vertx): WebClient = {
    WebClient(JWebClient.create(vertx.asJava.asInstanceOf[JVertx]))
  }

  /**
   * Create a web client using the provided `vertx` instance.   * @param vertx the vertx instance
   * @param options the Web Client options see <a href="../../../../../../../../cheatsheet/WebClientOptions.html">WebClientOptions</a>
   * @return the created web client
   */
  def create(vertx: Vertx,options: WebClientOptions): WebClient = {
    WebClient(JWebClient.create(vertx.asJava.asInstanceOf[JVertx], options.asJava))
  }

  /**
   * Wrap an `httpClient` with a web client and default options.   * @param httpClient the HttpClient to wrap
   * @return the web client
   */
  def wrap(httpClient: HttpClient): WebClient = {
    WebClient(JWebClient.wrap(httpClient.asJava.asInstanceOf[JHttpClient]))
  }

  /**
   * Wrap an `httpClient` with a web client and default options.
   * 
   * Only the specific web client portion of the `options` is used, the <a href="../../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>
   * of the `httpClient` is reused.   * @param httpClient the HttpClient to wrap
   * @param options the Web Client options see <a href="../../../../../../../../cheatsheet/WebClientOptions.html">WebClientOptions</a>
   * @return the web client
   */
  def wrap(httpClient: HttpClient,options: WebClientOptions): WebClient = {
    WebClient(JWebClient.wrap(httpClient.asJava.asInstanceOf[JHttpClient], options.asJava))
  }

}
