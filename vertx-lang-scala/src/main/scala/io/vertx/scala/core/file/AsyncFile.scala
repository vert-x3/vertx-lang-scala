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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.Handler

/**
  * Represents a file on the file-system which can be read from, or written to asynchronously.
  * 
  * This class also implements [[io.vertx.scala.core.streams.ReadStream]] and
  * [[io.vertx.scala.core.streams.WriteStream]]. This allows the data to be pumped to and from
  * other streams, e.g. an [[io.vertx.scala.core.http.HttpClientRequest]] instance,
  * using the [[io.vertx.scala.core.streams.Pump]] class
  */
class AsyncFile(private val _asJava: io.vertx.core.file.AsyncFile) 
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava: io.vertx.core.file.AsyncFile = _asJava

  /**
    * Same as [[io.vertx.scala.core.file.AsyncFile#end]] but writes some data to the stream before ending.
    */
  def end(t: Buffer): Unit = {
    _asJava.end(t.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  /**
    * This will return `true` if there are more bytes in the write queue than the value set using [[io.vertx.scala.core.file.AsyncFile#setWriteQueueMaxSize]]
    * @return true if write queue is full
    */
  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def handler(handler: Buffer => Unit): AsyncFile = {
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): AsyncFile = {
    _asJava.pause()
    this
  }

  def resume(): AsyncFile = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: () => Unit): AsyncFile = {
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => endHandler()))
    this
  }

  def write(data: Buffer): AsyncFile = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): AsyncFile = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: () => Unit): AsyncFile = {
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ => handler()))
    this
  }

  def exceptionHandler(handler: Throwable => Unit): AsyncFile = {
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  /**
    * Close the file, see [[io.vertx.scala.core.file.AsyncFile#close]].
    */
  def end(): Unit = {
    _asJava.end()
  }

  /**
    * Close the file. The actual close happens asynchronously.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Close the file. The actual close happens asynchronously.
    * The handler will be called when the close is complete, or an error occurs.
    * @return the future
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
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
    * The handler will be called when the write is complete, or if an error occurs.
    * @param buffer the buffer to write
    * @param position the position in the file to write it at
    * @return the future to call when the write is complete
    */
  def writeFuture(buffer: Buffer, position: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.write(buffer.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], position, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Reads `length` bytes of data from the file at position `position` in the file, asynchronously.
    * 
    * The read data will be written into the specified `Buffer buffer` at position `offset`.
    * 
    * If data is read past the end of the file then zero bytes will be read.
    * When multiple reads are invoked on the same file there are no guarantees as to order in which those reads actually occur.
    * 
    * The handler will be called when the close is complete, or if an error occurs.
    * @param buffer the buffer to read into
    * @param offset the offset into the buffer where the data will be read
    * @param position the position in the file where to start reading
    * @param length the number of bytes to read
    * @return the future to call when the write is complete
    */
  def readFuture(buffer: Buffer, offset: Int, position: Long, length: Int): concurrent.Future[Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.buffer.Buffer,Buffer]((x => if (x == null) null else Buffer.apply(x)))
    _asJava.read(buffer.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], offset, position, length, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Flush any writes made to this file to underlying persistent storage.
    * 
    * If the file was opened with `flush` set to `true` then calling this method will have no effect.
    * 
    * The actual flush will happen asynchronously.
    * @return a reference to this, so the API can be used fluently
    */
  def flush(): AsyncFile = {
    _asJava.flush()
    this
  }

  /**
    * Same as [[io.vertx.scala.core.file.AsyncFile#flush]] but the handler will be called when the flush is complete or if an error occurs
WARNING: THIS METHOD NEEDS BETTER DOCUMENTATION THAT ADHERES TO OUR CONVENTIONS. THIS ONE LACKS A PARAM-TAG FOR THE HANDLER    */
  def flushFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.flush(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Sets the position from which data will be read from when using the file as a [[io.vertx.scala.core.streams.ReadStream]].
    * @param readPos the position in the file
    * @return a reference to this, so the API can be used fluently
    */
  def setReadPos(readPos: Long): AsyncFile = {
    _asJava.setReadPos(readPos)
    this
  }

  /**
    * Sets the position from which data will be written when using the file as a [[io.vertx.scala.core.streams.WriteStream]].
    * @param writePos the position in the file
    * @return a reference to this, so the API can be used fluently
    */
  def setWritePos(writePos: Long): AsyncFile = {
    _asJava.setWritePos(writePos)
    this
  }

  /**
    * Sets the buffer size that will be used to read the data from the file. Changing this value will impact how much
    * the data will be read at a time from the file system.
    * @param readBufferSize the buffer size
    * @return a reference to this, so the API can be used fluently
    */
  def setReadBufferSize(readBufferSize: Int): AsyncFile = {
    _asJava.setReadBufferSize(readBufferSize)
    this
  }

}

object AsyncFile {

  def apply(_asJava: io.vertx.core.file.AsyncFile): AsyncFile =
    new AsyncFile(_asJava)

}
