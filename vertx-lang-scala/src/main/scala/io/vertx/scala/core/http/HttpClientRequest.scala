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
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.http.{HttpConnection => JHttpConnection}
import scala.reflect.runtime.universe._
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.{StreamPriority => JStreamPriority}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpVersion
import io.vertx.core.http.HttpMethod
import io.vertx.core.http.{HttpClientResponse => JHttpClientResponse}
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.core.http.{HttpClientRequest => JHttpClientRequest}
import io.vertx.lang.scala.HandlerOps._

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

class HttpClientRequest(private val _asJava: Object) extends WriteStream[io.vertx.core.buffer.Buffer]with ReadStream[HttpClientResponse] {
  def asJava = _asJava
  private var cached_0: Option[MultiMap] = None
  private var cached_1: Option[HttpConnection] = None


  /**
   * @return The HTTP headers
   */
  def headers(): MultiMap = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpClientRequest].headers()
      cached_0 = Some(MultiMap(tmp))
    }
    cached_0.get
  }

  /**
   * @return the HttpConnection associated with this request
   */
  def connection(): HttpConnection = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpClientRequest].connection()
      cached_1 = Some(HttpConnection(tmp))
    }
    cached_1.get
  }



  override 
  def exceptionHandler(handler: Handler[Throwable]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   */
  override 
  def write(data: io.vertx.core.buffer.Buffer): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(data)
    this
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#write]] but with an `handler` called when the operation completes
   */
  override 
  def write(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(data, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].drainHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   */
  override 
  def handler(handler: Handler[HttpClientResponse]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].handler((if (handler == null) null else new io.vertx.core.Handler[JHttpClientResponse]{def handle(x: JHttpClientResponse) {handler.handle(HttpClientResponse(x))}}))
    this
  }

  /**
   */
  override 
  def pause(): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].pause()
    this
  }

  /**
   */
  override 
  def resume(): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].resume()
    this
  }

  /**
   */
  override 
  def fetch(amount: Long): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   */
  override 
  def endHandler(endHandler: Handler[Unit]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }

  /**
   * Set the request to follow HTTP redirects up to <a href="../../../../../../../cheatsheet/HttpClientOptions.html">HttpClientOptions</a>.   * @param followRedirects `true` to follow HTTP redirects
   * @return a reference to this, so the API can be used fluently
   */
  
  def setFollowRedirects(followRedirects: Boolean): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setFollowRedirects(followRedirects.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set the max number of HTTP redirects this request will follow. The default is `0` which means
   * no redirects.   * @param maxRedirects the number of HTTP redirect to follow
   * @return a reference to this, so the API can be used fluently
   */
  
  def setMaxRedirects(maxRedirects: Int): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setMaxRedirects(maxRedirects.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * If chunked is true then the request will be set into HTTP chunked mode   * @param chunked true if chunked encoding
   * @return a reference to this, so the API can be used fluently
   */
  
  def setChunked(chunked: Boolean): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setChunked(chunked.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Set the value the method to send when the method  is used.   * @param method the raw method
   * @return a reference to this, so the API can be used fluently
   */
  
  def setRawMethod(method: String): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setRawMethod(method.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set the request host.<p/>
   *
   * For HTTP/2 it sets the  pseudo header otherwise it sets the  header
   */
  
  def setHost(host: String): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setHost(host.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Put an HTTP header   * @param name The header name
   * @param value The header value
   * @return a reference to this, so the API can be used fluently
   */
  
  def putHeader(name: String, value: String): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].putHeader(name.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Write a String to the request body, encoded as UTF-8.   * @return @return a reference to this, so the API can be used fluently
   */
  
  def write(chunk: String): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#write]] but with an `handler` called when the operation completes
   */
  
  def write(chunk: String, handler: Handler[AsyncResult[Unit]]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Write a String to the request body, encoded using the encoding `enc`.   * @return @return a reference to this, so the API can be used fluently
   */
  
  def write(chunk: String, enc: String): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#write]] but with an `handler` called when the operation completes
   */
  
  def write(chunk: String, enc: String, handler: Handler[AsyncResult[Unit]]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * If you send an HTTP request with the header `Expect` set to the value `100-continue`
   * and the server responds with an interim HTTP response with a status code of `100` and a continue handler
   * has been set using this method, then the `handler` will be called.
   * 
   * You can then continue to write data to the request body and later end it. This is normally used in conjunction with
   * the [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] method to force the request header to be written before the request has ended.   * @return a reference to this, so the API can be used fluently
   */
  
  def continueHandler(handler: Handler[Unit]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].continueHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }

  /**
   * Forces the head of the request to be written before [[io.vertx.scala.core.http.HttpClientRequest#end]] is called on the request or any data is
   * written to it.
   * 
   * This is normally used to implement HTTP 100-continue handling, see  for
   * more information.   * @return a reference to this, so the API can be used fluently
   */
  
  def sendHead(): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].sendHead()
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] but with an handler after headers have been sent. The handler will be called with
   * the [[io.vertx.core.http.HttpVersion]] if it can be determined or null otherwise.
   */
  
  def sendHead(completionHandler: Handler[io.vertx.core.http.HttpVersion]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].sendHead((if (completionHandler == null) null else new io.vertx.core.Handler[HttpVersion]{def handle(x: HttpVersion) {completionHandler.handle(x)}}))
    this
  }

  /**
   * Set's the amount of time after which if the request does not return any data within the timeout period an
   * TimeoutException will be passed to the exception handler (if provided) and
   * the request will be closed.
   * 
   * Calling this method more than once has the effect of canceling any existing timeout and starting
   * the timeout from scratch.   * @param timeoutMs The quantity of time in milliseconds.
   * @return a reference to this, so the API can be used fluently
   */
  
  def setTimeout(timeoutMs: Long): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setTimeout(timeoutMs.asInstanceOf[java.lang.Long])
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
   * process the response.<p/>   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def pushHandler(handler: Handler[HttpClientRequest]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].pushHandler((if (handler == null) null else new io.vertx.core.Handler[JHttpClientRequest]{def handle(x: JHttpClientRequest) {handler.handle(HttpClientRequest(x))}}))
    this
  }

  /**
   * Set a connection handler called when an HTTP connection has been established.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def connectionHandler(handler: Handler[HttpConnection]): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].connectionHandler((if (handler == null) null else new io.vertx.core.Handler[JHttpConnection]{def handle(x: JHttpConnection) {handler.handle(HttpConnection(x))}}))
    this
  }

  /**
   * Write an HTTP/2 frame to the request, allowing to extend the HTTP/2 protocol.
   *
   * The frame is sent immediatly and is not subject to flow control.
   *
   * This method must be called after the request headers have been sent and only for the protocol HTTP/2.
   * The [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] should be used for this purpose.   * @param type the 8-bit frame type
   * @param flags the 8-bit frame flags
   * @param payload the frame payload
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeCustomFrame(`type`: Int, flags: Int, payload: io.vertx.core.buffer.Buffer): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].writeCustomFrame(`type`.asInstanceOf[java.lang.Integer], flags.asInstanceOf[java.lang.Integer], payload)
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpClientRequest#writeCustomFrame]] but with an [[io.vertx.scala.core.http.HttpFrame]].   * @param frame the frame to write
   */
  
  def writeCustomFrame(frame: HttpFrame): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].writeCustomFrame(frame.asJava.asInstanceOf[JHttpFrame])
    this
  }

  /**
   * Sets the priority of the associated stream.
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param streamPriority the priority of this request's stream see <a href="../../../../../../../cheatsheet/StreamPriority.html">StreamPriority</a>
   */
  
  def setStreamPriority(streamPriority: StreamPriority): HttpClientRequest = {
    asJava.asInstanceOf[JHttpClientRequest].setStreamPriority(streamPriority.asJava)
    this
  }


  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[HttpClientResponse] = {
    Pipe[HttpClientResponse](asJava.asInstanceOf[JHttpClientRequest].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[HttpClientResponse]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JHttpClientResponse]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  override def pipeTo(dst: WriteStream[HttpClientResponse], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JHttpClientResponse]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Reset this stream with the error code `0`.   */
  def reset(): Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].reset().asInstanceOf[Boolean]
  }

  /**
   * @return the id of the stream of this response, ` -1` when it is not yet determined, i.e the request has not been yet sent or it is not supported HTTP/1.x
   */
  def streamId(): Int = {
    asJava.asInstanceOf[JHttpClientRequest].streamId().asInstanceOf[Int]
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.HttpClientRequest#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * @return Is the request chunked?
   */
  def isChunked (): Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].isChunked().asInstanceOf[Boolean]
  }

  /**
   * The HTTP method for the request.
   */
  def method (): io.vertx.core.http.HttpMethod = {
    asJava.asInstanceOf[JHttpClientRequest].method()
  }

  /**
   * @return the raw value of the method this request sends
   */
  def getRawMethod (): String = {
    asJava.asInstanceOf[JHttpClientRequest].getRawMethod().asInstanceOf[String]
  }

  /**
   * @return the absolute URI corresponding to the the HTTP request
   */
  def absoluteURI (): String = {
    asJava.asInstanceOf[JHttpClientRequest].absoluteURI().asInstanceOf[String]
  }

  /**
   * @return The URI of the request.
   */
  def uri (): String = {
    asJava.asInstanceOf[JHttpClientRequest].uri().asInstanceOf[String]
  }

  /**
   * @return The path part of the uri. For example /somepath/somemorepath/someresource.foo
   */
  def path (): String = {
    asJava.asInstanceOf[JHttpClientRequest].path().asInstanceOf[String]
  }

  /**
   * @return the query part of the uri. For example someparam=32&amp;someotherparam=x
   */
  def query (): String = {
    asJava.asInstanceOf[JHttpClientRequest].query().asInstanceOf[String]
  }

  /**
   * @return the request host. For HTTP/2 it returns the ` :authority` pseudo header otherwise it returns the ` Host` header
   */
  def getHost (): String = {
    asJava.asInstanceOf[JHttpClientRequest].getHost().asInstanceOf[String]
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes a String in UTF-8 encoding   */
  def end (chunk: String): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String])
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but with an `handler` called when the operation completes
   */
  def end (chunk: String, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes a String with the specified encoding   */
  def end (chunk: String, enc: String): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but with an `handler` called when the operation completes
   */
  def end (chunk: String, enc: String, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but writes some data to the request body before ending. If the request is not chunked and
   * no other data has been written then the `Content-Length` header will be automatically set   */
  override def end (chunk: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk)
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but with an `handler` called when the operation completes
   */
  override def end (chunk: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end(chunk, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Ends the request. If no data has been written to the request body, and [[io.vertx.scala.core.http.HttpClientRequest#sendHead]] has not been called then
   * the actual request won't get written until this method gets called.
   * 
   * Once the request has ended, it cannot be used any more,   */
  override def end (): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end()
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpClientRequest#end]] but with an `handler` called when the operation completes
   */
  override def end (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpClientRequest].end((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Reset this request:
   * <p/>
   * <ul>
   *   <li>for HTTP/2, this performs send an HTTP/2 reset frame with the specified error `code`</li>
   *   <li>for HTTP/1.x, this closes the connection when the current request is inflight</li>
   * </ul>
   * <p/>
   * When the request has not yet been sent, the request will be aborted and false is returned as indicator.
   * <p/>   * @param code the error code
   * @return true when reset has been performed
   */
  def reset (code: Long): Boolean = {
    asJava.asInstanceOf[JHttpClientRequest].reset(code.asInstanceOf[java.lang.Long]).asInstanceOf[Boolean]
  }

  /**
   * @return the priority of the associated HTTP/2 stream for HTTP/2 otherwise `null`see <a href="../../../../../../../cheatsheet/StreamPriority.html">StreamPriority</a>
   */
  def getStreamPriority (): StreamPriority = {
    StreamPriority(asJava.asInstanceOf[JHttpClientRequest].getStreamPriority())
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[HttpClientResponse]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].pipeTo(dst.asJava.asInstanceOf[JWriteStream[JHttpClientResponse]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def writeFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].write(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def writeFuture (chunk: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def writeFuture (chunk: String, enc: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].write(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def endFuture (chunk: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def endFuture (chunk: String, enc: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].end(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (chunk: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].end(chunk, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpClientRequest].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpClientRequest {
  def apply(asJava: JHttpClientRequest) = new HttpClientRequest(asJava)

}
