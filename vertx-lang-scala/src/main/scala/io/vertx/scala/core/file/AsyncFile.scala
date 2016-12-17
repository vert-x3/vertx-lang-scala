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
    asJava.asInstanceOf[JAsyncFile].close(handler)
  }

//cached methods
//fluent methods
  override def handler(handler: Handler[Buffer]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].handler(handler))
    this
  }

  override def pause():AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].pause())
    this
  }

  override def resume():AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].resume())
    this
  }

  override def endHandler(endHandler: Handler[Unit]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].endHandler(endHandler))
    this
  }

  override def write(data: Buffer):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].write(data.asJava.asInstanceOf[JBuffer]))
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].setWriteQueueMaxSize(maxSize))
    this
  }

  override def drainHandler(handler: Handler[Unit]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].drainHandler(handler))
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].exceptionHandler(handler))
    this
  }

  def write(buffer: Buffer,position: Long,handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].write(buffer.asJava.asInstanceOf[JBuffer],position,handler))
    this
  }

  def read(buffer: Buffer,offset: Int,position: Long,length: Int,handler: Handler[AsyncResult[Buffer]]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].read(buffer.asJava.asInstanceOf[JBuffer],offset,position,length,handler))
    this
  }

  def flush():AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].flush())
    this
  }

  def flush(handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].flush(handler))
    this
  }

  def setReadPos(readPos: Long):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].setReadPos(readPos))
    this
  }

  def setWritePos(writePos: Long):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].setWritePos(writePos))
    this
  }

  def setReadBufferSize(readBufferSize: Int):AsyncFile = {
    AsyncFile(asJava.asInstanceOf[JAsyncFile].setReadBufferSize(readBufferSize))
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
    asJava.asInstanceOf[JAsyncFile].close(handler)
  }

}

object AsyncFile{
  def apply(asJava: JAsyncFile) = new AsyncFile(asJava)//static methods
}
