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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.streams.{WriteStream => JWriteStream}

/**
  * Represents a file on the file-system which can be read from, or written to asynchronously.
  * 
  * This class also implements [[io.vertx.scala.core.streams.ReadStream]] and
  * [[io.vertx.scala.core.streams.WriteStream]]. This allows the data to be pumped to and from
  * other streams, e.g. an [[io.vertx.scala.core.http.HttpClientRequest]] instance,
  * using the [[io.vertx.scala.core.streams.Pump]] class
  */
class AsyncFile(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) 
    with WriteStream[Buffer](_asJava) {


//methods returning a future
  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncFile].close(x => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

//cached methods
//fluent methods
  override def handler(handler: Handler[Buffer]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].handler(x => handler.handle(x.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def pause():AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].pause()
    this
  }

  override def resume():AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].resume()
    this
  }

  override def endHandler(endHandler: Handler[Unit]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].endHandler(x => endHandler.handle(x))
    this
  }

  override def write(data: Buffer):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWriteQueueMaxSize(maxSize)
    this
  }

  override def drainHandler(handler: Handler[Unit]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].drainHandler(x => handler.handle(x))
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].exceptionHandler(x => handler.handle(x))
    this
  }

  def write(buffer: Buffer,position: Long,handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(buffer.asJava.asInstanceOf[JBuffer],position,x => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
    this
  }

  def read(buffer: Buffer,offset: Int,position: Long,length: Int,handler: Handler[AsyncResult[Buffer]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].read(buffer.asJava.asInstanceOf[JBuffer],offset,position,length,x => handler.handle(AsyncResultWrapper[JBuffer,Buffer](x, a => Buffer(a))))
    this
  }

  def flush():AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush()
    this
  }

  def flush(handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush(x => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
    this
  }

  def setReadPos(readPos: Long):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadPos(readPos)
    this
  }

  def setWritePos(writePos: Long):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWritePos(writePos)
    this
  }

  def setReadBufferSize(readBufferSize: Int):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadBufferSize(readBufferSize)
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JAsyncFile].writeQueueFull()
  }

  override def end():Unit = {
    asJava.asInstanceOf[JAsyncFile].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JAsyncFile].close()
  }

  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncFile].close(x => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a)))
  }

}

object AsyncFile{
  def apply(asJava: JAsyncFile) = new AsyncFile(asJava)
//static methods
}
