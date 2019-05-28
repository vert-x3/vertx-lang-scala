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
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.file.AsyncFile
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents an file upload from an HTML FORM.
  */

class HttpServerFileUpload(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava




  override 
  def exceptionHandler(handler: Handler[Throwable]): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].handler((if (handler == null) null else new io.vertx.core.Handler[Buffer]{def handle(x: Buffer) {handler.handle(x)}}))
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].endHandler((if (endHandler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {endHandler.handle(x)}}))
    this
  }


  override 
  def pause(): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].pause()
    this
  }


  override 
  def resume(): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].resume()
    this
  }


  override 
  def fetch(amount: Long): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Stream the content of this upload to the given file on storage.   * @param filename the name of the file
   */
  
  def streamToFileSystem(filename: String): HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].streamToFileSystem(filename.asInstanceOf[java.lang.String])
    this
  }


  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JHttpServerFileUpload].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JHttpServerFileUpload].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
  }

  /**
   * Pipe this `ReadStream` to the `WriteStream`.
   * 
   * Elements emitted by this stream will be written to the write stream until this stream ends or fails.
   * 
   * Once this stream has ended or failed, the write stream will be ended and the `handler` will be
   * called with the result.   * @param dst the destination write stream
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer], handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JHttpServerFileUpload].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


  /**
   * @return the filename which was used when upload the file.
   */
  def filename (): String = {
    asJava.asInstanceOf[JHttpServerFileUpload].filename().asInstanceOf[String]
  }

  /**
   * @return the name of the attribute
   */
  def name (): String = {
    asJava.asInstanceOf[JHttpServerFileUpload].name().asInstanceOf[String]
  }

  /**
   * @return the content type for the upload
   */
  def contentType (): String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentType().asInstanceOf[String]
  }

  /**
   * @return the contentTransferEncoding for the upload
   */
  def contentTransferEncoding (): String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentTransferEncoding().asInstanceOf[String]
  }

  /**
   * @return the charset for the upload
   */
  def charset (): String = {
    asJava.asInstanceOf[JHttpServerFileUpload].charset().asInstanceOf[String]
  }

  /**
   * The size of the upload may not be available until it is all read.
   * Check [[io.vertx.scala.core.http.HttpServerFileUpload#isSizeAvailable]] to determine this   * @return the size of the upload (in bytes)
   */
  def size (): Long = {
    asJava.asInstanceOf[JHttpServerFileUpload].size().asInstanceOf[Long]
  }

  /**
   * @return `true` if the size of the upload can be retrieved via #size().
   */
  def isSizeAvailable (): Boolean = {
    asJava.asInstanceOf[JHttpServerFileUpload].isSizeAvailable().asInstanceOf[Boolean]
  }

  /**
   * @return the async uploaded file when #streamToFileSystem has been used
   */
  def file (): AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JHttpServerFileUpload].file())
  }


 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JHttpServerFileUpload].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object HttpServerFileUpload {
  def apply(asJava: JHttpServerFileUpload) = new HttpServerFileUpload(asJava)
  
}
