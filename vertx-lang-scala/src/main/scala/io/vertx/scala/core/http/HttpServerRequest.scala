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
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.net.SocketAddress
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.scala.core.net.NetSocket

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
class HttpServerRequest(private val _asJava: JHttpServerRequest) 
    extends ReadStream[Buffer] {

  def asJava: JHttpServerRequest = _asJava

  def exceptionHandler(handler: io.vertx.core.Handler[Throwable]): HttpServerRequest = {
    asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler).asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]])
    this
  }

  def handler(handler: io.vertx.core.Handler[Buffer]): HttpServerRequest = {
    asJava.handler(funcToMappedHandler(Buffer.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  def pause(): HttpServerRequest = {
    asJava.pause()
    this
  }

  def resume(): HttpServerRequest = {
    asJava.resume()
    this
  }

  def endHandler(endHandler: io.vertx.core.Handler[Unit]): HttpServerRequest = {
    asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](_ => ())(_ => endHandler.handle()).asInstanceOf[io.vertx.core.Handler[java.lang.Void]])
    this
  }

  /**
    * @return the HTTP version of the request
    */
  def version(): io.vertx.core.http.HttpVersion = {
    asJava.version()
  }

  /**
    * @return the HTTP method for the request.
    */
  def method(): io.vertx.core.http.HttpMethod = {
    asJava.method()
  }

  /**
    * @return the HTTP method as sent by the client
    */
  def rawMethod(): String = {
    asJava.rawMethod()
  }

  /**
    * @return true if this io.vertx.scala.core.net.NetSocket is encrypted via SSL/TLS
    */
  def isSSL(): Boolean = {
    asJava.isSSL()
  }

  /**
    * @return the scheme of the request
    */
  def scheme(): scala.Option[String] = {
    scala.Option(asJava.scheme())
  }

  /**
    * @return the URI of the request. This is usually a relative URI
    */
  def uri(): String = {
    asJava.uri()
  }

  /**
    * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
    */
  def path(): scala.Option[String] = {
    scala.Option(asJava.path())
  }

  /**
    * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
    */
  def query(): scala.Option[String] = {
    scala.Option(asJava.query())
  }

  /**
    * @return the request host. For HTTP2 it returns the ` :authority` pseudo header otherwise it returns the ` Host` header
    */
  def host(): scala.Option[String] = {
    scala.Option(asJava.host())
  }

  /**
    * @return the response. Each instance of this class has an HttpServerResponse instance attached to it. This is used to send the response back to the client.
    */
  def response(): HttpServerResponse = {
    if (cached_0 == null) {
      cached_0 = HttpServerResponse.apply(asJava.response()).asInstanceOf
    }
    cached_0
  }

  /**
    * @return the headers in the request.
    */
  def headers(): MultiMap = {
    if (cached_1 == null) {
      cached_1 = MultiMap.apply(asJava.headers()).asInstanceOf
    }
    cached_1
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): scala.Option[String] = {
    scala.Option(asJava.getHeader(headerName))
  }

  /**
    * @return the query parameters in the request
    */
  def params(): MultiMap = {
    if (cached_2 == null) {
      cached_2 = MultiMap.apply(asJava.params()).asInstanceOf
    }
    cached_2
  }

  /**
    * Return the first param value with the specified name
    * @param paramName the param name
    * @return the param value
    */
  def getParam(paramName: String): scala.Option[String] = {
    scala.Option(asJava.getParam(paramName))
  }

  /**
    * @return the remote (client side) address of the request
    */
  def remoteAddress(): SocketAddress = {
    if (cached_3 == null) {
      cached_3 = SocketAddress.apply(asJava.remoteAddress()).asInstanceOf
    }
    cached_3
  }

  /**
    * @return the local (server side) address of the server that handles the request
    */
  def localAddress(): SocketAddress = {
    if (cached_4 == null) {
      cached_4 = SocketAddress.apply(asJava.localAddress()).asInstanceOf
    }
    cached_4
  }

  /**
    * @return the absolute URI corresponding to the the HTTP request
    */
  def absoluteURI(): String = {
    asJava.absoluteURI()
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves the user having to manually setting a data and end handler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: io.vertx.core.Handler[Buffer]): HttpServerRequest = {
    asJava.bodyHandler(funcToMappedHandler(Buffer.apply)(bodyHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.buffer.Buffer]])
    this
  }

  /**
    * Get a net socket for the underlying connection of this request.
    * 
    * USE THIS WITH CAUTION!
    * 
    * Once you have called this method, you must handle writing to the connection yourself using the net socket,
    * the server request instance will no longer be usable as normal.
    * Writing to the socket directly if you don't know what you're doing can easily break the HTTP protocol.
    * @return the net socket
    */
  def netSocket(): NetSocket = {
    if (cached_5 == null) {
      cached_5 = NetSocket.apply(asJava.netSocket()).asInstanceOf
    }
    cached_5
  }

  /**
    * Call this with true if you are expecting a multi-part body to be submitted in the request.
    * This must be called before the body of the request has been received
    * @param expect true - if you are expecting a multi-part body
    * @return a reference to this, so the API can be used fluently
    */
  def setExpectMultipart(expect: Boolean): HttpServerRequest = {
    asJava.setExpectMultipart(expect)
    this
  }

  /**
    * @return true if we are expecting a multi-part body for this request. See #setExpectMultipart.
    */
  def isExpectMultipart(): Boolean = {
    asJava.isExpectMultipart()
  }

  /**
    * Set an upload handler. The handler will get notified once a new file upload was received to allow you to deal
    * with the file upload.
    * @return a reference to this, so the API can be used fluently
    */
  def uploadHandler(uploadHandler: io.vertx.core.Handler[HttpServerFileUpload]): HttpServerRequest = {
    asJava.uploadHandler(funcToMappedHandler(HttpServerFileUpload.apply)(uploadHandler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpServerFileUpload]])
    this
  }

  /**
    * Returns a map of all form attributes in the request.
    * 
    * Be aware that the attributes will only be available after the whole body has been received, i.e. after
    * the request end handler has been called.
    * 
    * [[io.vertx.scala.core.http.HttpServerRequest#setExpectMultipart]] must be called first before trying to get the form attributes.
    * @return the form attributes
    */
  def formAttributes(): MultiMap = {
    if (cached_6 == null) {
      cached_6 = MultiMap.apply(asJava.formAttributes()).asInstanceOf
    }
    cached_6
  }

  /**
    * Return the first form attribute value with the specified name
    * @param attributeName the attribute name
    * @return the attribute value
    */
  def getFormAttribute(attributeName: String): scala.Option[String] = {
    scala.Option(asJava.getFormAttribute(attributeName))
  }

  /**
    * Upgrade the connection to a WebSocket connection.
    * 
    * This is an alternative way of handling WebSockets and can only be used if no websocket handlers are set on the
    * Http server, and can only be used during the upgrade request during the WebSocket handshake.
    * @return the WebSocket
    */
  def upgrade(): ServerWebSocket = {
    ServerWebSocket.apply(asJava.upgrade())
  }

  /**
    * Has the request ended? I.e. has the entire request, including the body been read?
    * @return true if ended
    */
  def isEnded(): Boolean = {
    asJava.isEnded()
  }

  /**
    * Set a custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
    * frame. HTTP/2 permits extension of the protocol.
    * @return a reference to this, so the API can be used fluently
    */
  def customFrameHandler(handler: io.vertx.core.Handler[HttpFrame]): HttpServerRequest = {
    asJava.customFrameHandler(funcToMappedHandler(HttpFrame.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.http.HttpFrame]])
    this
  }

  /**
    * @return the HttpConnection associated with this request
    */
  def connection(): HttpConnection = {
    if (cached_7 == null) {
      cached_7 = HttpConnection.apply(asJava.connection()).asInstanceOf
    }
    cached_7
  }

  private var cached_0: HttpServerResponse = _
  private var cached_1: MultiMap = _
  private var cached_2: MultiMap = _
  private var cached_3: SocketAddress = _
  private var cached_4: SocketAddress = _
  private var cached_5: NetSocket = _
  private var cached_6: MultiMap = _
  private var cached_7: HttpConnection = _
}

object HttpServerRequest {

  def apply(_asJava: JHttpServerRequest): HttpServerRequest =
    new HttpServerRequest(_asJava)

}
