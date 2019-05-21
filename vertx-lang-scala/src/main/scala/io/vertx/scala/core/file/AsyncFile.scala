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

package io.vertx.scala.core.file

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.core.streams.Pipe
import io.vertx.core.streams.{ReadStream => JReadStream}
import scala.reflect.runtime.universe._
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{Pipe => JPipe}
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents a file on the file-system which can be read from, or written to asynchronously.
  * 
  * This class also implements [[io.vertx.scala.core.streams.ReadStream]] and
  * [[io.vertx.scala.core.streams.WriteStream]]. This allows the data to be pumped to and from
  * other streams, e.g. an [[io.vertx.scala.core.http.HttpClientRequest]] instance,
  * using the [[io.vertx.scala.core.streams.Pump]] class
  */

class AsyncFile(private val _asJava: Object) extends ReadStream[io.vertx.core.buffer.Buffer]with WriteStream[io.vertx.core.buffer.Buffer] {
  def asJava = _asJava




  override 
  def handler(handler: Handler[io.vertx.core.buffer.Buffer]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].handler({x: Buffer => handler.handle(x)})
    this
  }


  override 
  def pause(): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].pause()
    this
  }


  override 
  def resume(): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].resume()
    this
  }


  override 
  def endHandler(endHandler: Handler[Unit]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].endHandler({x: Void => endHandler.handle(x)})
    this
  }


  override 
  def write(data: io.vertx.core.buffer.Buffer): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(data)
    this
  }

  /**
   * Same as [[io.vertx.scala.core.file.AsyncFile#write]] but with an `handler` called when the operation completes
   */
  override 
  def write(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(data, {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }


  override 
  def setWriteQueueMaxSize(maxSize: Int): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }


  override 
  def drainHandler(handler: Handler[Unit]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].drainHandler({x: Void => handler.handle(x)})
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }


  override 
  def fetch(amount: Long): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].fetch(amount.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Write a [[io.vertx.scala.core.buffer.Buffer]] to the file at position `position` in the file, asynchronously.
   * 
   * If `position` lies outside of the current size
   * of the file, the file will be enlarged to encompass it.
   * 
   * When multiple writes are invoked on the same file
   * there are no guarantees as to order in which those writes actually occur
   * 
   * The handler will be called when the write is complete, or if an error occurs.   * @param buffer the buffer to write
   * @param position the position in the file to write it at
   * @param handler the handler to call when the write is complete
   * @return a reference to this, so the API can be used fluently
   */
  
  def write(buffer: io.vertx.core.buffer.Buffer, position: Long, handler: Handler[AsyncResult[Unit]]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(buffer, position.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Reads `length` bytes of data from the file at position `position` in the file, asynchronously.
   * 
   * The read data will be written into the specified `Buffer buffer` at position `offset`.
   * 
   * If data is read past the end of the file then zero bytes will be read.
   * When multiple reads are invoked on the same file there are no guarantees as to order in which those reads actually occur.
   * 
   * The handler will be called when the close is complete, or if an error occurs.   * @param buffer the buffer to read into
   * @param offset the offset into the buffer where the data will be read
   * @param position the position in the file where to start reading
   * @param length the number of bytes to read
   * @param handler the handler to call when the write is complete
   * @return a reference to this, so the API can be used fluently
   */
  
  def read(buffer: io.vertx.core.buffer.Buffer, offset: Int, position: Long, length: Int, handler: Handler[AsyncResult[io.vertx.core.buffer.Buffer]]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].read(buffer, offset.asInstanceOf[java.lang.Integer], position.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Integer], {x: AsyncResult[Buffer] => handler.handle(AsyncResultWrapper[Buffer, io.vertx.core.buffer.Buffer](x, a => a))})
    this
  }

  /**
   * Flush any writes made to this file to underlying persistent storage.
   * 
   * If the file was opened with `flush` set to `true` then calling this method will have no effect.
   * 
   * The actual flush will happen asynchronously.   * @return a reference to this, so the API can be used fluently
   */
  
  def flush(): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush()
    this
  }

  /**
   * Same as [[io.vertx.scala.core.file.AsyncFile#flush]] but the handler will be called when the flush is complete or if an error occurs
   */
  
  def flush(handler: Handler[AsyncResult[Unit]]): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
   * Sets the position from which data will be read from when using the file as a [[io.vertx.scala.core.streams.ReadStream]].   * @param readPos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  
  def setReadPos(readPos: Long): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadPos(readPos.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Sets the position from which data will be written when using the file as a [[io.vertx.scala.core.streams.WriteStream]].   * @param writePos the position in the file
   * @return a reference to this, so the API can be used fluently
   */
  
  def setWritePos(writePos: Long): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWritePos(writePos.asInstanceOf[java.lang.Long])
    this
  }

  /**
   * Sets the buffer size that will be used to read the data from the file. Changing this value will impact how much
   * the data will be read at a time from the file system.   * @param readBufferSize the buffer size
   * @return a reference to this, so the API can be used fluently
   */
  
  def setReadBufferSize(readBufferSize: Int): AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadBufferSize(readBufferSize.asInstanceOf[java.lang.Integer])
    this
  }


  /**
   * Same as [[io.vertx.scala.core.file.AsyncFile#end]] but writes some data to the stream before ending.   * @param data the data to write
   */
  override def end(data: io.vertx.core.buffer.Buffer): Unit = {
    asJava.asInstanceOf[JAsyncFile].end(data)
  }

  /**
   * Same as  but with an `handler` called when the operation completes
   */
  override def end(data: io.vertx.core.buffer.Buffer, handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncFile].end(data, {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Pause this stream and return a  to transfer the elements of this stream to a destination .
   * <p/>
   * The stream will be resumed when the pipe will be wired to a `WriteStream`.   * @return a pipe
   */
  override def pipe(): Pipe[io.vertx.core.buffer.Buffer] = {
    Pipe[io.vertx.core.buffer.Buffer](asJava.asInstanceOf[JAsyncFile].pipe())
  }

  /**
   * Like [[io.vertx.scala.core.streams.ReadStream#pipeTo]] but with no completion handler.
   */
  override def pipeTo(dst: WriteStream[io.vertx.core.buffer.Buffer]): Unit = {
    asJava.asInstanceOf[JAsyncFile].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]])
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
    asJava.asInstanceOf[JAsyncFile].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


  /**
   * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.file.AsyncFile#setWriteQueueMaxSize]]   * @return true if write queue is full
   */
  override def writeQueueFull (): Boolean = {
    asJava.asInstanceOf[JAsyncFile].writeQueueFull().asInstanceOf[Boolean]
  }

  /**
   * Close the file, see [[io.vertx.scala.core.file.AsyncFile#close]].
   */
  override def end (): Unit = {
    asJava.asInstanceOf[JAsyncFile].end()
  }

  /**
   * Close the file, see [[io.vertx.scala.core.file.AsyncFile#close]].
   */
  override def end (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncFile].end({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Close the file. The actual close happens asynchronously.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JAsyncFile].close()
  }

  /**
   * Close the file. The actual close happens asynchronously.
   * The handler will be called when the close is complete, or an error occurs.   * @param handler the handler
   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncFile].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * @return the current write position the file is at
   */
  def getWritePos (): Long = {
    asJava.asInstanceOf[JAsyncFile].getWritePos().asInstanceOf[Long]
  }


 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].end(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[pipeTo]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def pipeToFuture (dst: WriteStream[io.vertx.core.buffer.Buffer]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].pipeTo(dst.asJava.asInstanceOf[JWriteStream[Buffer]], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def writeFuture (data: io.vertx.core.buffer.Buffer): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].write(data, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[end]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def endFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].end(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[write]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def writeFuture (buffer: io.vertx.core.buffer.Buffer, position: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].write(buffer, position.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[read]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def readFuture (buffer: io.vertx.core.buffer.Buffer, offset: Int, position: Long, length: Int): scala.concurrent.Future[io.vertx.core.buffer.Buffer] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Buffer, io.vertx.core.buffer.Buffer](x => x)
    asJava.asInstanceOf[JAsyncFile].read(buffer, offset.asInstanceOf[java.lang.Integer], position.asInstanceOf[java.lang.Long], length.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[flush]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def flushFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncFile].flush(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncFile {
  def apply(asJava: JAsyncFile) = new AsyncFile(asJava)
  
}
