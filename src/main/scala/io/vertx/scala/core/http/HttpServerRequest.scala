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

package io.vertx.scala.core.http;

import io.vertx.scala.core.MultiMap
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress
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
class HttpServerRequest(private val _asJava: io.vertx.core.http.HttpServerRequest) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  /**
    * @return the HTTP version of the request
    */
  def version(): io.vertx.core.http.HttpVersion = {
    _asJava.version()
  }

  /**
    * @return the HTTP method for the request.
    */
  def method(): io.vertx.core.http.HttpMethod = {
    _asJava.method()
  }

  /**
    * @return the URI of the request. This is usually a relative URI
    */
  def uri(): String = {
    _asJava.uri()
  }

  /**
    * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
    */
  def path(): String = {
    _asJava.path()
  }

  /**
    * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
    */
  def query(): String = {
    _asJava.query()
  }

  /**
    * @return the response. Each instance of this class has an [[io.vertx.scala.core.http.HttpServerResponse]] instance attached to it. This is used
    * to send the response back to the client.
    */
  def response(): io.vertx.scala.core.http.HttpServerResponse = {
    HttpServerResponse.apply(_asJava.response())
  }

  /**
    * @return the headers in the request.
    */
  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  /**
    * Return the first header value with the specified name
    * @param headerName the header name
    * @return the header value
    */
  def getHeader(headerName: String): String = {
    _asJava.getHeader(headerName)
  }

  /**
    * @return the query parameters in the request
    */
  def params(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.params())
  }

  /**
    * Return the first param value with the specified name
    * @param paramName the param name
    * @return the param value
    */
  def getParam(paramName: String): String = {
    _asJava.getParam(paramName)
  }

  /**
    * @return the remote (client side) address of the request
    */
  def remoteAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.remoteAddress())
  }

  /**
    * @return the local (server side) address of the server that handles the request
    */
  def localAddress(): io.vertx.scala.core.net.SocketAddress = {
    SocketAddress.apply(_asJava.localAddress())
  }

  /**
    * @return the absolute URI corresponding to the the HTTP request
    */
  def absoluteURI(): String = {
    _asJava.absoluteURI()
  }

  /**
    * Convenience method for receiving the entire request body in one piece.
    * 
    * This saves the user having to manually setting a data and end handler and append the chunks of the body until
    * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.
    * @param bodyHandler This handler will be called after all the body has been received
    */
  def bodyHandler(bodyHandler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.bodyHandler(funcToMappedHandler(Buffer.apply)(bodyHandler))
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
  def netSocket(): io.vertx.scala.core.net.NetSocket = {
    NetSocket.apply(_asJava.netSocket())
  }

  /**
    * Call this with true if you are expecting a multi-part body to be submitted in the request.
    * This must be called before the body of the request has been received
    * @param expect true - if you are expecting a multi-part body
    * @return a reference to this, so the API can be used fluently
    */
  def setExpectMultipart(expect: Boolean): io.vertx.scala.core.http.HttpServerRequest = {
    _asJava.setExpectMultipart(expect)
    this
  }

  /**
    * @return  true if we are expecting a multi-part body for this request. See [[io.vertx.scala.core.http.HttpServerRequest#setExpectMultipart]].
    */
  def isExpectMultipart(): Boolean = {
    _asJava.isExpectMultipart()
  }

  /**
    * Set an upload handler. The handler will get notified once a new file upload was received to allow you to deal
    * with the file upload.
    * @return a reference to this, so the API can be used fluently
    */
  def uploadHandler(uploadHandler: io.vertx.scala.core.http.HttpServerFileUpload => Unit): io.vertx.scala.core.http.HttpServerRequest = {
    import io.vertx.lang.scala.HandlerOps._
    _asJava.uploadHandler(funcToMappedHandler(HttpServerFileUpload.apply)(uploadHandler))
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
  def formAttributes(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.formAttributes())
  }

  /**
    * Return the first form attribute value with the specified name
    * @param attributeName the attribute name
    * @return the attribute value
    */
  def getFormAttribute(attributeName: String): String = {
    _asJava.getFormAttribute(attributeName)
  }

  /**
    * Upgrade the connection to a WebSocket connection.
    * 
    * This is an alternative way of handling WebSockets and can only be used if no websocket handlers are set on the
    * Http server, and can only be used during the upgrade request during the WebSocket handshake.
    * @return the WebSocket
    */
  def upgrade(): io.vertx.scala.core.http.ServerWebSocket = {
    ServerWebSocket.apply(_asJava.upgrade())
  }

  /**
    * Has the request ended? I.e. has the entire request, including the body been read?
    * @return true if ended
    */
  def isEnded(): Boolean = {
    _asJava.isEnded()
  }

}

object HttpServerRequest {

  def apply(_asJava: io.vertx.core.http.HttpServerRequest): io.vertx.scala.core.http.HttpServerRequest =
    new io.vertx.scala.core.http.HttpServerRequest(_asJava)
}
