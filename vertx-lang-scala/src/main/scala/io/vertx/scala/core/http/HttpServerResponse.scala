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
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
      import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
  import io.vertx.core.http.{HttpFrame => JHttpFrame}
  import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
  import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
  import io.vertx.core.http.HttpMethod
  import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.{MultiMap => JMultiMap}
      
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
class HttpServerResponse(private val _asJava: JHttpServerResponse) 
    extends WriteStream[Buffer] {

  def asJava: JHttpServerResponse = _asJava

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.HttpServerResponse#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): HttpServerResponse = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: Buffer): HttpServerResponse = {
    _asJava.write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): HttpServerResponse = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): HttpServerResponse = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
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
  def setStatusCode(statusCode: Int): HttpServerResponse = {
    _asJava.setStatusCode(statusCode)
    this
  }

  /**
    * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what [[#setStatusCode]] has been set to.
    */
  def getStatusMessage(): String = {
    _asJava.getStatusMessage()
  }

  /**
    * Set the status message
    * @return a reference to this, so the API can be used fluently
    */
  def setStatusMessage(statusMessage: String): HttpServerResponse = {
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
  def setChunked(chunked: Boolean): HttpServerResponse = {
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
  def headers(): MultiMap = {
    if (cached_0 == null) {
      cached_0=    MultiMap.apply(_asJava.headers())
    }
    cached_0
  }

  /**
    * Put an HTTP header
    * @param name the header name
    * @param value the header value.
    * @return a reference to this, so the API can be used fluently
    */
  def putHeader(name: String, value: String): HttpServerResponse = {
    _asJava.putHeader(name, value)
    this
  }

  /**
    * @return The HTTP trailers
    */
  def trailers(): MultiMap = {
    if (cached_1 == null) {
      cached_1=    MultiMap.apply(_asJava.trailers())
    }
    cached_1
  }

  /**
    * Put an HTTP trailer
    * @param name the trailer name
    * @param value the trailer value
    * @return a reference to this, so the API can be used fluently
    */
  def putTrailer(name: String, value: String): HttpServerResponse = {
    _asJava.putTrailer(name, value)
    this
  }

  /**
    * Set a close handler for the response. This will be called if the underlying connection closes before the response
    * is complete.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def closeHandler(handler: () => Unit): HttpServerResponse = {
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Write a String to the response body, encoded using the encoding `enc`.
    * @param chunk the string to write
    * @param enc the encoding to use
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String, enc: String): HttpServerResponse = {
    _asJava.write(chunk, enc)
    this
  }

  /**
    * Write a String to the response body, encoded in UTF-8.
    * @param chunk the string to write
    * @return a reference to this, so the API can be used fluently
    */
  def write(chunk: String): HttpServerResponse = {
    _asJava.write(chunk)
    this
  }

  /**
    * Used to write an interim 100 Continue response to signify that the client should send the rest of the request.
    * Must only be used if the request contains an "Expect:100-Continue" header
    * @return a reference to this, so the API can be used fluently
    */
  def writeContinue(): HttpServerResponse = {
    _asJava.writeContinue()
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
    * no other data has been written then the `Content-Length` header will be automatically set.
    * @param chunk the buffer to write before ending the response
    */
  def end(chunk: Buffer): Unit = {
    _asJava.end(chunk.asJava.asInstanceOf[JBuffer])
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
    * Same as [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] using offset `0` which means starting from the beginning of the file.
    * @param filename path to the file to serve
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String): HttpServerResponse = {
    _asJava.sendFile(filename)
    this
  }

  /**
    * Same as [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] using length `Long.MAX_VALUE` which means until the end of the
    * file.
    * @param filename path to the file to serve
    * @param offset offset to start serving from
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long): HttpServerResponse = {
    _asJava.sendFile(filename, offset)
    this
  }

  /**
    * Ask the OS to stream a file as specified by `filename` directly
    * from disk to the outgoing connection, bypassing userspace altogether
    * (where supported by the underlying operating system.
    * This is a very efficient way to serve files.
    * The actual serve is asynchronous and may not complete until some time after this method has returned.
    * @param filename path to the file to serve
    * @param offset offset to start serving from
    * @param length length to serve to
    * @return a reference to this, so the API can be used fluently
    */
  def sendFile(filename: String, offset: Long, length: Long): HttpServerResponse = {
    _asJava.sendFile(filename, offset, length)
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
    * written to the wire.
    * @param filename path to the file to serve
    * @return future that will be called on completion
    */
  def sendFileFuture(filename: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.sendFile(filename, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
    * written to the wire.
    * @param filename path to the file to serve
    * @param offset the offset to serve from
    * @return future that will be called on completion
    */
  def sendFileFuture(filename: String, offset: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.sendFile(filename, offset, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been
    * completely written to the wire.
    * @param filename path to the file to serve
    * @param offset the offset to serve from
    * @param length the length to serve to
    * @return future that will be called on completion
    */
  def sendFileFuture(filename: String, offset: Long, length: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.sendFile(filename, offset, length, promiseAndHandler._1)
    promiseAndHandler._2.future
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
    * @return has the underlying TCP connection corresponding to the request already been closed?
    */
  def closed(): Boolean = {
    _asJava.closed()
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
  def headersEndHandler(handler: () => Unit): HttpServerResponse = {
    _asJava.headersEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * Provides a handler that will be called after the last part of the body is written to the wire.
    * The handler is called asynchronously of when the response has been received by the client.
    * This provides a hook allowing you to do more operations once the request has been sent over the wire
    * such as resource cleanup.
    * @param handler the handler
    * @return a reference to this, so the API can be used fluently
    */
  def bodyEndHandler(handler: () => Unit): HttpServerResponse = {
    _asJava.bodyEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  /**
    * @return the total number of bytes written for the body of the response.
    */
  def bytesWritten(): Long = {
    _asJava.bytesWritten()
  }

  /**
    * @return the id of the stream of this response, ` -1` for HTTP/1.x
    */
  def streamId(): Int = {
    _asJava.streamId()
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with no headers.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String): concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse,HttpServerResponse]((x => if (x == null) null else HttpServerResponse.apply(x)))
    HttpServerResponse.apply(_asJava.push(method, host, path, promiseAndHandler._1))
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with the host copied from the current request.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String, headers: MultiMap): concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse,HttpServerResponse]((x => if (x == null) null else HttpServerResponse.apply(x)))
    HttpServerResponse.apply(_asJava.push(method, path, headers.asJava.asInstanceOf[JMultiMap], promiseAndHandler._1))
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with the host copied from the current request.
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def pushFuture(method: io.vertx.core.http.HttpMethod, path: String): concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse,HttpServerResponse]((x => if (x == null) null else HttpServerResponse.apply(x)))
    _asJava.push(method, path, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Push a response to the client.<p/>
    *
    * The `handler` will be notified with a <i>success</i> when the push can be sent and with
    * a <i>failure</i> when the client has disabled push or reset the push before it has been sent.<p/>
    *
    * The `handler` may be queued if the client has reduced the maximum number of streams the server can push
    * concurrently.<p/>
    *
    * Push can be sent only for peer initiated streams and if the response is not ended.
    * @param method the method of the promised request
    * @param host the host of the promised request
    * @param path the path of the promised request
    * @param headers the headers of the promised request
    * @return the future notified when the response can be written
    */
  def pushFuture(method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: MultiMap): concurrent.Future[HttpServerResponse] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse,HttpServerResponse]((x => if (x == null) null else HttpServerResponse.apply(x)))
    _asJava.push(method, host, path, headers.asJava.asInstanceOf[JMultiMap], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reset this HTTP/2 stream with the error code `0`.
    */
  def reset(): Unit = {
    _asJava.reset()
  }

  /**
    * Reset this HTTP/2 stream with the error `code`.
    * @param code the error code
    */
  def reset(code: Long): Unit = {
    _asJava.reset(code)
  }

  /**
    * Write an HTTP/2 frame to the response, allowing to extend the HTTP/2 protocol.
    *
    * The frame is sent immediatly and is not subject to flow control.
    * @param type the 8-bit frame type
    * @param flags the 8-bit frame flags
    * @param payload the frame payload
    * @return a reference to this, so the API can be used fluently
    */
  def writeCustomFrame(`type`: Int, flags: Int, payload: Buffer): HttpServerResponse = {
    _asJava.writeCustomFrame(`type`, flags, payload.asJava.asInstanceOf[JBuffer])
    this
  }

  /**
    * Like [[io.vertx.scala.core.http.HttpServerResponse#writeCustomFrame]] but with an [[io.vertx.scala.core.http.HttpFrame]].
    * @param frame the frame to write
    */
  def writeCustomFrame(frame: HttpFrame): HttpServerResponse = {
    _asJava.writeCustomFrame(frame.asJava.asInstanceOf[JHttpFrame])
    this
  }

  private var cached_0: MultiMap = _
  private var cached_1: MultiMap = _
}

object HttpServerResponse {

  def apply(_asJava: JHttpServerResponse): HttpServerResponse =
    new HttpServerResponse(_asJava)

}
