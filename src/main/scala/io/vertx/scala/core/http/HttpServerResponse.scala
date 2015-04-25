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

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.scala.core.MultiMap
import scala.util.Try
import io.vertx.core.Handler

/**
  * Represents a server-side HTTP response.
  * 
  * An instance of this is created and associated to every instance of
  * [[io.vertx.scala.core.http.HttpServerRequest]] that.
  * 
  * It allows the developer to control the HTTP response that is sent back to the
  * client for a particular HTTP request.
  * 
  * It contains methods that allow HTTP headers and trailers to be set, and for a body to be written out to the response.
  * 
  * It also allows files to be streamed by the kernel directly from disk to the
  * outgoing HTTP connection, bypassing user space altogether (where supported by
  * the underlying operating system). This is a very efficient way of
  * serving files from the server since buffers do not have to be read one by one
  * from the file and written to the outgoing socket.
  * 
  * It implements [[io.vertx.scala.core.streams.WriteStream]] so it can be used with
  * [[io.vertx.scala.core.streams.Pump]] to pump data with flow control.
  */
class HttpServerResponse(private val _asJava: io.vertx.core.http.HttpServerResponse) 
    extends io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.HttpServerResponse#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  /**
    * @return the HTTP status code of the response. The default is `200` representing `OK`.
    */
  def getStatusCode(): Int = {
    _asJava.getStatusCode()
  }

  /**
    * Set the status code. If the status message hasn't been explicitly set, a default status message corresponding
    * to the code will be looked-up and used.
    * @return a reference to this, so the API can be used fluently
    */
  def setStatusCode(statusCode: Int): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setStatusCode(statusCode)
    this
  }

  /**
    * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what
    * [[io.vertx.scala.core.http.HttpServerResponse#setStatusCode]] has been set to.
    */
  def getStatusMessage(): String = {
    _asJava.getStatusMessage()
  }

  /**
    * Set the status message
    * @return a reference to this, so the API can be used fluently
    */
  def setStatusMessage(statusMessage: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setStatusMessage(statusMessage)
    this
  }

  /**
    * If `chunked` is `true`, this response will use HTTP chunked encoding, and each call to write to the body
    * will correspond to a new HTTP chunk sent on the wire.
    * 
    * If chunked encoding is used the HTTP header `Transfer-Encoding` with a value of `Chunked` will be
    * automatically inserted in the response.
    * 
    * If `chunked` is `false`, this response will not use HTTP chunked encoding, and therefore the total size
    * of any data that is written in the respone body must be set in the `Content-Length` header <b>before</b> any
    * data is written out.
    * 
    * An HTTP chunked response is typically used when you do not know the total size of the request body up front.
    * @return a reference to this, so the API can be used fluently
    */
  def setChunked(chunked: Boolean): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setChunked(chunked)
    this
  }

  /**
    * @return is the response chunked?
    */
  def isChunked(): Boolean = {
    _asJava.isChunked()
  }

  /**
    * @return The HTTP headers
    */
  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  /**
    * Put an HTTP header
    * @param name the header name
    * @param value the header value.
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.putHeader(name, value)
    this
  }

  /**
    * @return The HTTP trailers
    */
  def trailers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.trailers())
  }

  /**
    * Put an HTTP trailer
    * @param name the trailer name
    * @param value the trailer value
    * @return a reference to this, so the API can be used fluently
    */
  def putTrailer(name: String, value: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.putTrailer(name, value)
    this
  }

  /**
    * Set a close handler for the response. This will be called if the underlying connection closes before the response
    * is complete.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  /**
    * Write a  to the response body, encoded using the encoding `enc`.
    * @param chunk the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String, enc: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(chunk, enc)
    this
  }

  /**
    * Write a  to the response body, encoded in UTF-8.
    * @param chunk the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(chunk)
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes a String in UTF-8 encoding before ending the response.
    * @param chunk the string to write before ending the response
    */
  def end(chunk: String): Unit = {
    _asJava.end(chunk)
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes a String with the specified encoding before ending the response.
    * @param chunk the string to write before ending the response
    * @param enc the encoding to use
    */
  def end(chunk: String, enc: String): Unit = {
    _asJava.end(chunk, enc)
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes some data to the response body before ending. If the response is not chunked and
    * no other data has been written then the @code{Content-Length} header will be automatically set.
    * @param chunk the buffer to write before ending the response
    */
  def end(chunk: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.end(chunk.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  /**
    * Ends the response. If no data has been written to the response body,
    * the actual response won't get written until this method gets called.
    * 
    * Once the response has ended, it cannot be used any more.
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Ask the OS to stream a file as specified by `filename` directly
    * from disk to the outgoing connection, bypassing userspace altogether
    * (where supported by the underlying operating system.
    * This is a very efficient way to serve files.
    * The actual serve is asynchronous and may not complete until some time after this method has returned.
    * @param filename path to the file to serve
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.sendFile(filename)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
    * written to the wire.
    * @param filename path to the file to serve
    * @param resultHandler handler that will be called on completion
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String)(resultHandler: Try[Unit] => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.sendFile(filename, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(resultHandler))
    this
  }

  /**
    * Close the underlying TCP connection corresponding to the request.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * @return has the response already ended?
    */
  def ended(): Boolean = {
    _asJava.ended()
  }

  /**
    * @return have the headers for the response already been written?
    */
  def headWritten(): Boolean = {
    _asJava.headWritten()
  }

  /**
    * Provide a handler that will be called just before the headers are written to the wire.
    * This provides a hook allowing you to add any more headers or do any more operations before this occurs.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def headersEndHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.headersEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  /**
    * Provide a handler that will be called just before the last part of the body is written to the wire
    * and the response is ended.
    * This provides a hook allowing you to do any more operations before this occurs.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def bodyEndHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.bodyEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

}

object HttpServerResponse {

  def apply(_asJava: io.vertx.core.http.HttpServerResponse): io.vertx.scala.core.http.HttpServerResponse =
    new io.vertx.scala.core.http.HttpServerResponse(_asJava)
}
