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
import io.vertx.core.http.{HttpServerResponse => JHttpServerResponse}
import scala.reflect.runtime.universe._
import io.vertx.core.http.{HttpFrame => JHttpFrame}
import io.vertx.core.http.{StreamPriority => JStreamPriority}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.http.HttpMethod
import io.vertx.core.{MultiMap => JMultiMap}
import io.vertx.scala.core.MultiMap
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

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

class HttpServerResponse(private val _asJava: Object) extends WriteStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava
  private var cached_0: Option[MultiMap] = None
  private var cached_1: Option[MultiMap] = None


  /**
   * @return The HTTP headers
   */
  def headers(): MultiMap = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerResponse].headers()
      cached_0 = Some(MultiMap(tmp))
    }
    cached_0.get
  }

  /**
   * @return The HTTP trailers
   */
  def trailers(): MultiMap = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JHttpServerResponse].trailers()
      cached_1 = Some(MultiMap(tmp))
    }
    cached_1.get
  }



  override 
  def exceptionHandler(handler: Handler[Throwable]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(data)
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].drainHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Set the status code. If the status message hasn't been explicitly set, a default status message corresponding
   * to the code will be looked-up and used.   * @return a reference to this, so the API can be used fluently
   */
  
  def setStatusCode(statusCode: Int): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusCode(statusCode.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Set the status message   * @return a reference to this, so the API can be used fluently
   */
  
  def setStatusMessage(statusMessage: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStatusMessage(statusMessage.asInstanceOf[java.lang.String])
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
   * An HTTP chunked response is typically used when you do not know the total size of the request body up front.   * @return a reference to this, so the API can be used fluently
   */
  
  def setChunked(chunked: Boolean): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setChunked(chunked.asInstanceOf[java.lang.Boolean])
    this
  }

  /**
   * Put an HTTP header   * @param name the header name
   * @param value the header value.
   * @return a reference to this, so the API can be used fluently
   */
  
  def putHeader(name: String, value: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putHeader(name.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Put an HTTP trailer   * @param name the trailer name
   * @param value the trailer value
   * @return a reference to this, so the API can be used fluently
   */
  
  def putTrailer(name: String, value: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].putTrailer(name.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Set a close handler for the response, this is called when the underlying connection is closed and the response
   * was still using the connection.
   * 
   * For HTTP/1.x it is called when the connection is closed before `end()` is called, therefore it is not
   * guaranteed to be called.
   * 
   * For HTTP/2 it is called when the related stream is closed, and therefore it will be always be called.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].closeHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Set an end handler for the response. This will be called when the response is disposed to allow consistent cleanup
   * of the response.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def endHandler(handler: Handler[Unit]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].endHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Write a String to the response body, encoded using the encoding `enc`.   * @param chunk the string to write
   * @param enc the encoding to use
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(chunk: String, enc: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Write a String to the response body, encoded in UTF-8.   * @param chunk the string to write
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(chunk: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].write(chunk.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Used to write an interim 100 Continue response to signify that the client should send the rest of the request.
   * Must only be used if the request contains an "Expect:100-Continue" header   * @return a reference to this, so the API can be used fluently
   */
  
  def writeContinue(): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeContinue()
    this
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] using offset `0` which means starting from the beginning of the file.   * @param filename path to the file to serve
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] using length `Long.MAX_VALUE` which means until the end of the
   * file.   * @param filename path to the file to serve
   * @param offset offset to start serving from
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Ask the OS to stream a file as specified by `filename` directly
   * from disk to the outgoing connection, bypassing userspace altogether
   * (where supported by the underlying operating system.
   * This is a very efficient way to serve files.
   * The actual serve is asynchronous and may not complete until some time after this method has returned.   * @param filename path to the file to serve
   * @param offset offset to start serving from
   * @param length the number of bytes to send
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, length: Long): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
   * written to the wire.   * @param filename path to the file to serve
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, resultHandler: Handler[AsyncResult[Unit]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been completely
   * written to the wire.   * @param filename path to the file to serve
   * @param offset the offset to serve from
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, resultHandler: Handler[AsyncResult[Unit]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#sendFile]] but providing a handler which will be notified once the file has been
   * completely written to the wire.   * @param filename path to the file to serve
   * @param offset the offset to serve from
   * @param length the length to serve to
   * @param resultHandler handler that will be called on completion
   * @return a reference to this, so the API can be used fluently
   */
  
  def sendFile(filename: String, offset: Long, length: Long, resultHandler: Handler[AsyncResult[Unit]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Provide a handler that will be called just before the headers are written to the wire.
   * This provides a hook allowing you to add any more headers or do any more operations before this occurs.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def headersEndHandler(handler: Handler[Unit]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].headersEndHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Provides a handler that will be called after the last part of the body is written to the wire.
   * The handler is called asynchronously of when the response has been received by the client.
   * This provides a hook allowing you to do more operations once the request has been sent over the wire
   * such as resource cleanup.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def bodyEndHandler(handler: Handler[Unit]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].bodyEndHandler({x: Void => handler.handle(x)})
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with no headers.
   */
  
  def push(method: io.vertx.core.http.HttpMethod, host: String, path: String, handler: Handler[AsyncResult[HttpServerResponse]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method, host.asInstanceOf[java.lang.String], path.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse, HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with the host copied from the current request.
   */
  
  def push(method: io.vertx.core.http.HttpMethod, path: String, headers: MultiMap, handler: Handler[AsyncResult[HttpServerResponse]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method, path.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], {x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse, HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#push]] with the host copied from the current request.
   */
  
  def push(method: io.vertx.core.http.HttpMethod, path: String, handler: Handler[AsyncResult[HttpServerResponse]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method, path.asInstanceOf[java.lang.String], {x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse, HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
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
   * Push can be sent only for peer initiated streams and if the response is not ended.   * @param method the method of the promised request
   * @param host the host of the promised request
   * @param path the path of the promised request
   * @param headers the headers of the promised request
   * @param handler the handler notified when the response can be written
   * @return a reference to this, so the API can be used fluently
   */
  
  def push(method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: MultiMap, handler: Handler[AsyncResult[HttpServerResponse]]): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].push(method, host.asInstanceOf[java.lang.String], path.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], {x: AsyncResult[JHttpServerResponse] => handler.handle(AsyncResultWrapper[JHttpServerResponse, HttpServerResponse](x, a => HttpServerResponse(a)))})
    this
  }

  /**
   * Write an HTTP/2 frame to the response, allowing to extend the HTTP/2 protocol.
   *
   * The frame is sent immediatly and is not subject to flow control.   * @param type the 8-bit frame type
   * @param flags the 8-bit frame flags
   * @param payload the frame payload
   * @return a reference to this, so the API can be used fluently
   */
  
  def writeCustomFrame(`type`: Int, flags: Int, payload: io.vertx.core.buffer.Buffer): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeCustomFrame(`type`.asInstanceOf[java.lang.Integer], flags.asInstanceOf[java.lang.Integer], payload)
    this
  }

  /**
   * Like [[io.vertx.scala.core.http.HttpServerResponse#writeCustomFrame]] but with an [[io.vertx.scala.core.http.HttpFrame]].   * @param frame the frame to write
   */
  
  def writeCustomFrame(frame: HttpFrame): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].writeCustomFrame(frame.asJava.asInstanceOf[JHttpFrame])
    this
  }

  /**
   * Sets the priority of the associated stream
   * <p/>
   * This is not implemented for HTTP/1.x.   * @param streamPriority the priority for this request's stream see <a href="../../../../../../../cheatsheet/StreamPriority.html">StreamPriority</a>
   */
  
  def setStreamPriority(streamPriority: StreamPriority): HttpServerResponse = {
    asJava.asInstanceOf[JHttpServerResponse].setStreamPriority(streamPriority.asJava)
    this
  }


  /**
   * Reset this HTTP/2 stream with the error code `0`.
   */
  def reset(): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].reset()
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.http.HttpServerResponse#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * @return the HTTP status code of the response. The default is `200` representing `OK`.
   */
  def getStatusCode (): Int = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusCode().asInstanceOf[Int]
  }

  /**
   * @return the HTTP status message of the response. If this is not specified a default value will be used depending on what #setStatusCode has been set to.
   */
  def getStatusMessage (): String = {
    asJava.asInstanceOf[JHttpServerResponse].getStatusMessage().asInstanceOf[String]
  }

  /**
   * @return is the response chunked?
   */
  def isChunked (): Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].isChunked().asInstanceOf[Boolean]
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes a String in UTF-8 encoding before ending the response.   * @param chunk the string to write before ending the response
   */
  def end (chunk: String): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk.asInstanceOf[java.lang.String])
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes a String with the specified encoding before ending the response.   * @param chunk the string to write before ending the response
   * @param enc the encoding to use
   */
  def end (chunk: String, enc: String): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk.asInstanceOf[java.lang.String], enc.asInstanceOf[java.lang.String])
  }

  /**
   * Same as [[io.vertx.scala.core.http.HttpServerResponse#end]] but writes some data to the response body before ending. If the response is not chunked and
   * no other data has been written then the `Content-Length` header will be automatically set.   * @param chunk the buffer to write before ending the response
   */
  override def end (chunk: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end(chunk)
  }

  /**
   * Ends the response. If no data has been written to the response body,
   * the actual response won't get written until this method gets called.
   * 
   * Once the response has ended, it cannot be used any more.
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].end()
  }

  /**
   * Close the underlying TCP connection corresponding to the request.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].close()
  }

  /**
   * @return has the response already ended?
   */
  def ended (): Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].ended().asInstanceOf[Boolean]
  }

  /**
   * @return has the underlying TCP connection corresponding to the request already been closed?
   */
  def closed (): Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].closed().asInstanceOf[Boolean]
  }

  /**
   * @return have the headers for the response already been written?
   */
  def headWritten (): Boolean = {
    asJava.asInstanceOf[JHttpServerResponse].headWritten().asInstanceOf[Boolean]
  }

  /**
   * @return the total number of bytes written for the body of the response.
   */
  def bytesWritten (): Long = {
    asJava.asInstanceOf[JHttpServerResponse].bytesWritten().asInstanceOf[Long]
  }

  /**
   * @return the id of the stream of this response, ` -1` for HTTP/1.x
   */
  def streamId (): Int = {
    asJava.asInstanceOf[JHttpServerResponse].streamId().asInstanceOf[Int]
  }

  /**
   * Reset this HTTP/2 stream with the error `code`.   * @param code the error code
   */
  def reset (code: Long): Unit = {
    asJava.asInstanceOf[JHttpServerResponse].reset(code.asInstanceOf[java.lang.Long])
  }


 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String, offset: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[sendFile]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sendFileFuture (filename: String, offset: Long, length: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServerResponse].sendFile(filename.asInstanceOf[java.lang.String], offset.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pushFuture (method: io.vertx.core.http.HttpMethod, host: String, path: String): scala.concurrent.Future[HttpServerResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method, host.asInstanceOf[java.lang.String], path.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pushFuture (method: io.vertx.core.http.HttpMethod, path: String, headers: MultiMap): scala.concurrent.Future[HttpServerResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method, path.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pushFuture (method: io.vertx.core.http.HttpMethod, path: String): scala.concurrent.Future[HttpServerResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method, path.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[push]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pushFuture (method: io.vertx.core.http.HttpMethod, host: String, path: String, headers: MultiMap): scala.concurrent.Future[HttpServerResponse] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JHttpServerResponse, HttpServerResponse](x => HttpServerResponse(x))
    asJava.asInstanceOf[JHttpServerResponse].push(method, host.asInstanceOf[java.lang.String], path.asInstanceOf[java.lang.String], headers.asJava.asInstanceOf[JMultiMap], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpServerResponse {
  def apply(asJava: JHttpServerResponse) = new HttpServerResponse(asJava)
  
}
