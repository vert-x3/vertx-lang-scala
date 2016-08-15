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
import io.vertx.scala.core.MultiMap
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler

/**
  * Represents a client-side HTTP request.
  * 
  * Instances are created by an [[io.vertx.scala.core.http.HttpClient]] instance, via one of the methods corresponding to the
  * specific HTTP methods, or the generic request methods. On creation the request will not have been written to the
  * wire.
  * 
  * Once a request has been obtained, headers can be set on it, and data can be written to its body if required. Once
  * you are ready to send the request, one of the [[io.vertx.scala.core.http.HttpClientRequest#end]] methods should be called.
  * 
  * Nothing is actually sent until the request has been internally assigned an HTTP connection.
  * 
  * The [[io.vertx.scala.core.http.HttpClient]] instance will return an instance of this class immediately, even if there are no HTTP
  * connections available in the pool. Any requests sent before a connection is assigned will be queued
  * internally and actually sent when an HTTP connection becomes available from the pool.
  * 
  * The headers of the request are queued for writing either when the [[io.vertx.scala.core.http.HttpClientRequest#end]] method is called, or, when the first
  * part of the body is written, whichever occurs first.
  * 
  * This class supports both chunked and non-chunked HTTP.
  * 
  * It implements [[io.vertx.scala.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  * 
  * An example of using this class is as follows:
  * 
  */
class HttpClientRequest(private val _asJava: io.vertx.core.http.HttpClientRequest) 
    extends io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] 
    with io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.http.HttpClientResponse] {

  def asJava: io.vertx.core.http.HttpClientRequest = _asJava

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.HttpClientRequest#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  /**
    * @throws java.lang.IllegalStateException when no response handler is set
    */
  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  def handler(handler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.handler(funcToMappedHandler(HttpClientResponse.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  /**
    * If chunked is true then the request will be set into HTTP chunked mode
    * @param chunked true if chunked encoding
    * @return a reference to this, so the API can be used fluently
    */
  def setChunked(chunked: Boolean): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setChunked(chunked)
    this
  }

  /**
    * @return Is the request chunked?
    */
  def isChunked(): Boolean = {
    _asJava.isChunked()
  }

  /**
    * The HTTP method for the request.
    */
  def method(): io.vertx.core.http.HttpMethod = {
    _asJava.method()
  }

  /**
    * @return the raw value of the method this request sends
    */
  def getRawMethod(): String = {
    _asJava.getRawMethod()
  }

  /**
    * Set the value the method to send when the method  is used.
    * @param method the raw method
    * @return a reference to this, so the API can be used fluently
    */
  def setRawMethod(method: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setRawMethod(method)
    this
  }

  /**
    * @return The URI of the request.
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
    * Set the request host.<p/>
    *
    * For HTTP2 it sets the  pseudo header otherwise it sets the  header
    */
  def setHost(host: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setHost(host)
    this
  }

  /**
    * @return the request host. For HTTP2 it returns the  pseudo header otherwise it returns the  header
    */
  def getHost(): String = {
    _asJava.getHost()
  }

  /**
    * @return The HTTP headers
    */
  def headers(): io.vertx.scala.core.MultiMap = {
    if(cached_0 == null) {
      cached_0=    MultiMap.apply(_asJava.headers())
    }
    cached_0
  }

  /**
    * Put an HTTP header
    * @param name The header name
    * @param value The header value
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.putHeader(name, value)
    this
  }

  /**
    * Write a String to the request body, encoded as UTF-8.
    * @return @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(chunk)
    this
  }

  /**
    * Write a String to the request body, encoded using the encoding `enc`.
    * @return @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String, enc: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(chunk, enc)
    this
  }

  /**
    * If you send an HTTP request with the header `Expect` set to the value `100-continue`
    * and the server responds with an interim HTTP response with a status code of `100` and a continue handler
    * has been set using this method, then the `handler` will be called.
    * 
    * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
    * the [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] method to force the request header to be written before the request has ended.
    * @return a reference to this, so the API can be used fluently
    */
  def continueHandler(handler: () => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.continueHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Forces the head of the request to be written before [[io.vertx.scala.core.http.HttpClientRequest#end]] is called on the request or any data is
    * written to it.
    * 
    * This is normally used to implement HTTP 100-continue handling, see  for
    * more information.
    * @return a reference to this, so the API can be used fluently
    */
  def sendHead(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.sendHead()
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] but with an handler after headers have been sent. The handler will be called with
    * the [[io.vertx.core.http.HttpVersion]] if it can be determined or null otherwise.
    */
  def sendHead(completionHandler: io.vertx.core.http.HttpVersion => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.sendHead(funcToHandler(completionHandler))
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes a String in UTF-8 encoding
    */
  def end(chunk: String): Unit = {
    _asJava.end(chunk)
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes a String with the specified encoding
    */
  def end(chunk: String, enc: String): Unit = {
    _asJava.end(chunk, enc)
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes some data to the request body before ending. If the request is not chunked and
    * no other data has been written then the `Content-Length` header will be automatically set
    */
  def end(chunk: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.end(chunk.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  /**
    * Ends the request. If no data has been written to the request body, and [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] has not been called then
    * the actual request won't get written until this method gets called.
    * 
    * Once the request has ended, it cannot be used any more,
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Set's the amount of time after which if the request does not return any data within the timeout period an
    * TimeoutException will be passed to the exception handler (if provided) and
    * the request will be closed.
    * 
    * Calling this method more than once has the effect of canceling any existing timeout and starting
    * the timeout from scratch.
    * @param timeoutMs The quantity of time in milliseconds.
    * @return a reference to this, so the API can be used fluently
    */
  def setTimeout(timeoutMs: Long): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setTimeout(timeoutMs)
    this
  }

  /**
    * Set a push handler for this request.<p/>
    *
    * The handler is called when the client receives a <i>push promise</i> from the server. The handler can be called
    * multiple times, for each push promise.<p/>
    *
    * The handler is called with a <i>read-only</i> [[io.vertx.scala.core.http.HttpClientRequest]], the following methods can be called:<p/>
    *
    * <ul>
    *   <li>[[io.vertx.scala.core.http.HttpClientRequest#method]]</li>
    *   <li>[[io.vertx.scala.core.http.HttpClientRequest#uri]]</li>
    *   <li>[[io.vertx.scala.core.http.HttpClientRequest#headers]]</li>
    *   <li>[[io.vertx.scala.core.http.HttpClientRequest#getHost]]</li>
    * </ul>
    *
    * In addition the handler should call the [[io.vertx.scala.core.http.HttpClientRequest#handler]] method to set an handler to
    * process the response.<p/>
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def pushHandler(handler: io.vertx.scala.core.http.HttpClientRequest => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.pushHandler(funcToMappedHandler(HttpClientRequest.apply)(handler))
    this
  }

  /**
    * Reset this stream with the error code `0`.
    */
  def reset(): Unit = {
    _asJava.reset()
  }

  /**
    * Reset this stream with the error `code`.
    * @param code the error code
    */
  def reset(code: Long): Unit = {
    _asJava.reset(code)
  }

  /**
    * @return the [[io.vertx.scala.core.http.HttpConnection]] associated with this request
    */
  def connection(): io.vertx.scala.core.http.HttpConnection = {
    if(cached_1 == null) {
      cached_1=    HttpConnection.apply(_asJava.connection())
    }
    cached_1
  }

  /**
    * Set a connection handler called when an HTTP connection has been established.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def connectionHandler(handler: io.vertx.scala.core.http.HttpConnection => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.connectionHandler(funcToMappedHandler(HttpConnection.apply)(handler))
    this
  }

  /**
    * Write an HTTP/2 frame to the request, allowing to extend the HTTP/2 protocol.
    *
    * The frame is sent immediatly and is not subject to flow control.
    *
    * This method must be called after the request headers have been sent and only for the protocol HTTP/2.
    * The [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] should be used for this purpose.
    * @param type the 8-bit frame type
    * @param flags the 8-bit frame flags
    * @param payload the frame payload
    * @return a reference to this, so the API can be used fluently
    */
  def writeCustomFrame(`type`: Int, flags: Int, payload: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.writeCustomFrame(`type`, flags, payload.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  /**
    * @return the id of the stream of this response,  when it is not yet determined, i.e
    *         the request has not been yet sent or it is not supported HTTP/1.x
    */
  def streamId(): Int = {
    _asJava.streamId()
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpClientRequest#writeCustomFrame]] but with an [[io.vertx.scala.core.http.HttpFrame]].
    * @param frame the frame to write
    */
  def writeCustomFrame(frame: io.vertx.scala.core.http.HttpFrame): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.writeCustomFrame(frame.asJava.asInstanceOf[io.vertx.core.http.HttpFrame])
    this
  }

  private var cached_0: io.vertx.scala.core.MultiMap = _
  private var cached_1: io.vertx.scala.core.http.HttpConnection = _
}

object HttpClientRequest {

  def apply(_asJava: io.vertx.core.http.HttpClientRequest): io.vertx.scala.core.http.HttpClientRequest =
    new io.vertx.scala.core.http.HttpClientRequest(_asJava)

}
