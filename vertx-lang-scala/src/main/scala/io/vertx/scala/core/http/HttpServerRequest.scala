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

import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import scala.reflect.runtime.universe._
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.http.{HttpServerRequest => JHttpServerRequest}
import io.vertx.core.net.{NetSocket => JNetSocket}
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.{ServerWebSocket => JServerWebSocket}
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.net.NetSocket
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.core.net.{SocketAddress => JSocketAddress}
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler
import io.vertx.scala.core.net.SocketAddress
import io.vertx.lang.scala.HandlerOps._

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

class HttpServerRequest(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava
  private var cached_0: Option[HttpServerResponse] = None
  private var cached_1: Option[MultiMap] = None
  private var cached_2: Option[MultiMap] = None
  private var cached_3: Option[SocketAddress] = None
  private var cached_4: Option[SocketAddress] = None
  private var cached_5: Option[NetSocket] = None
  private var cached_6: Option[MultiMap] = None
  private var cached_7: Option[HttpConnection] = None


  /**
   * @return the response. Each instance of this class has an HttpServerResponse instance attached to it. This is used to send the response back to the client.
   */
  def response(): HttpServerResponse = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].response()
      cached_0 = Some(HttpServerResponse(tmp))
    }
    cached_0.get
  }

  /**
   * @return the headers in the request.
   */
  def headers(): MultiMap = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].headers()
      cached_1 = Some(MultiMap(tmp))
    }
    cached_1.get
  }

  /**
   * @return the query parameters in the request
   */
  def params(): MultiMap = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].params()
      cached_2 = Some(MultiMap(tmp))
    }
    cached_2.get
  }

  /**
   * @return the remote (client side) address of the request
   */
  def remoteAddress(): SocketAddress = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].remoteAddress()
      cached_3 = Some(SocketAddress(tmp))
    }
    cached_3.get
  }

  /**
   * @return the local (server side) address of the server that handles the request
   */
  def localAddress(): SocketAddress = {
    if (cached_4 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].localAddress()
      cached_4 = Some(SocketAddress(tmp))
    }
    cached_4.get
  }

  /**
   * Get a net socket for the underlying connection of this request.
   * <p/>
   * This method must be called before the server response is ended.
   * <p/>
   * With `CONNECT` requests, a `200` response is sent with no `content-length` header set
   * before returning the socket.
   * <p/>
   * <pre>
   * server.requestHandler(req -> {
   *   if (req.method() == HttpMethod.CONNECT) {
   *     // Send a 200 response to accept the connect
   *     NetSocket socket = req.netSocket();
   *     socket.handler(buff -> {
   *       socket.write(buff);
   *     `);
   *   `
   *   ...
   * `);
   * </pre>
   * <p/>
   * For other HTTP/1 requests once you have called this method, you must handle writing to the connection yourself using
   * the net socket, the server request instance will no longer be usable as normal. USE THIS WITH CAUTION! Writing to the socket directly if you don't know what you're
   * doing can easily break the HTTP protocol.
   * <p/>
   * With HTTP/2, a `200` response is always sent with no `content-length` header set before returning the socket
   * like in the `CONNECT` case above.
   * <p/>   * @return the net socket
   */
  def netSocket(): NetSocket = {
    if (cached_5 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].netSocket()
      cached_5 = Some(NetSocket(tmp))
    }
    cached_5.get
  }

  /**
   * Returns a map of all form attributes in the request.
   * 
   * Be aware that the attributes will only be available after the whole body has been received, i.e. after
   * the request end handler has been called.
   * 
   * [[io.vertx.scala.core.http.HttpServerRequest#setExpectMultipart]] must be called first before trying to get the form attributes.   * @return the form attributes
   */
  def formAttributes(): MultiMap = {
    if (cached_6 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].formAttributes()
      cached_6 = Some(MultiMap(tmp))
    }
    cached_6.get
  }

  /**
   * @return the HttpConnection associated with this request
   */
  def connection(): HttpConnection = {
    if (cached_7 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerRequest].connection()
      cached_7 = Some(HttpConnection(tmp))
    }
    cached_7.get
  }



  override 
  def exceptionHandler(handler: Handler[Throwable]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].handler({x: Buffer => handler.handle(x)})
    this
  }


  override 
  def pause(): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].pause()
    this
  }


  override 
  def resume(): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].resume()
    this
  }


  override 
  def fetch(amount: Long): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  /**
   * Convenience method for receiving the entire request body in one piece.
   * 
   * This saves the user having to manually setting a data and end handler and append the chunks of the body until
   * the whole body received. Don't use this if your request body is large - you could potentially run out of RAM.   * @param bodyHandler This handler will be called after all the body has been received
   */
  
  def bodyHandler(bodyHandler: Handler[io.vertx.core.buffer.Buffer]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].bodyHandler({x: Buffer => bodyHandler.handle(x)})
    this
  }

  /**
   * Call this with true if you are expecting a multi-part body to be submitted in the request.
   * This must be called before the body of the request has been received   * @param expect true - if you are expecting a multi-part body
   * @return a reference to this, so the API can be used fluently
   */
  
  def setExpectMultipart(expect: Boolean): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].setExpectMultipart(expect.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set an upload handler. The handler will get notified once a new file upload was received to allow you to deal
   * with the file upload.   * @return a reference to this, so the API can be used fluently
   */
  
  def uploadHandler(uploadHandler: Handler[HttpServerFileUpload]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].uploadHandler({x: JHttpServerFileUpload => uploadHandler.handle(HttpServerFileUpload(x))})
    this
  }

  /**
   * Set a custom frame handler. The handler will get notified when the http stream receives an custom HTTP/2
   * frame. HTTP/2 permits extension of the protocol.   * @return a reference to this, so the API can be used fluently
   */
  
  def customFrameHandler(handler: Handler[HttpFrame]): HttpServerRequest = {
    asJava.asInstanceOf[JHttpServerRequest].customFrameHandler({x: JHttpFrame => handler.handle(HttpFrame(x))})
    this
  }



  /**
   * @return the HTTP version of the request
   */
  def version (): io.vertx.core.http.HttpVersion = {
    asJava.asInstanceOf[JHttpServerRequest].version()
  }

  /**
   * @return the HTTP method for the request.
   */
  def method (): io.vertx.core.http.HttpMethod = {
    asJava.asInstanceOf[JHttpServerRequest].method()
  }

  /**
   * @return the HTTP method as sent by the client
   */
  def rawMethod (): String = {
    asJava.asInstanceOf[JHttpServerRequest].rawMethod().asInstanceOf[String]
  }

  /**
   * @return true if this io.vertx.scala.core.net.NetSocket is encrypted via SSL/TLS
   */
  def isSSL (): Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isSSL().asInstanceOf[Boolean]
  }

  /**
   * @return the scheme of the request
   */
  def scheme (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].scheme().asInstanceOf[String])
  }

  /**
   * @return the URI of the request. This is usually a relative URI
   */
  def uri (): String = {
    asJava.asInstanceOf[JHttpServerRequest].uri().asInstanceOf[String]
  }

  /**
   * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
   */
  def path (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].path().asInstanceOf[String])
  }

  /**
   * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
   */
  def query (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].query().asInstanceOf[String])
  }

  /**
   * @return the request host. For HTTP2 it returns the ` :authority` pseudo header otherwise it returns the ` Host` header
   */
  def host (): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].host().asInstanceOf[String])
  }

  /**
   * @return the total number of bytes read for the body of the request.
   */
  def bytesRead (): Long = {
    asJava.asInstanceOf[JHttpServerRequest].bytesRead().asInstanceOf[Long]
  }

  /**
   * Return the first header value with the specified name   * @param headerName the header name
   * @return the header value
   */
  def getHeader (headerName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].getHeader(headerName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
   * Return the first param value with the specified name   * @param paramName the param name
   * @return the param value
   */
  def getParam (paramName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].getParam(paramName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
   * @return the absolute URI corresponding to the the HTTP request
   */
  def absoluteURI (): String = {
    asJava.asInstanceOf[JHttpServerRequest].absoluteURI().asInstanceOf[String]
  }

  /**
   * @return true if we are expecting a multi-part body for this request. See #setExpectMultipart.
   */
  def isExpectMultipart (): Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isExpectMultipart().asInstanceOf[Boolean]
  }

  /**
   * Return the first form attribute value with the specified name   * @param attributeName the attribute name
   * @return the attribute value
   */
  def getFormAttribute (attributeName: String): scala.Option[String] = {
    scala.Option(asJava.asInstanceOf[JHttpServerRequest].getFormAttribute(attributeName.asInstanceOf[java.lang.String]).asInstanceOf[String])
  }

  /**
   * Upgrade the connection to a WebSocket connection.
   * 
   * This is an alternative way of handling WebSockets and can only be used if no websocket handlers are set on the
   * Http server, and can only be used during the upgrade request during the WebSocket handshake.   * @return the WebSocket
   */
  def upgrade (): ServerWebSocket = {
    ServerWebSocket(asJava.asInstanceOf[JHttpServerRequest].upgrade())
  }

  /**
   * Has the request ended? I.e. has the entire request, including the body been read?   * @return true if ended
   */
  def isEnded (): Boolean = {
    asJava.asInstanceOf[JHttpServerRequest].isEnded().asInstanceOf[Boolean]
  }


}

object HttpServerRequest {
  def apply(asJava: JHttpServerRequest) = new HttpServerRequest(asJava)
  
}
