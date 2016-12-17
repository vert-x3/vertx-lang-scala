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

import io.vertx.core.file.{AsyncFile => JAsyncFile}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.streams.WriteStream
import io.vertx.core.streams.{WriteStream => JWriteStream}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}

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

  override def asJava = _asJava.asInstanceOf[JAsyncFile]
//methods returning a future
  def close(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

//cached methods
//fluent methods
  override def handler(handler: io.vertx.core.Handler[Buffer]):AsyncFile = {
    asJava.handler( )
    this
  }

  override def pause():AsyncFile = {
    asJava.pause( )
    this
  }

  override def resume():AsyncFile = {
    asJava.resume( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):AsyncFile = {
    asJava.endHandler( )
    this
  }

  override def write(data: Buffer):AsyncFile = {
    asJava.write( )
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):AsyncFile = {
    asJava.setWriteQueueMaxSize( )
    this
  }

  override def drainHandler(handler: io.vertx.core.Handler[Unit]):AsyncFile = {
    asJava.drainHandler( )
    this
  }

  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):AsyncFile = {
    asJava.exceptionHandler( )
    this
  }

  def write(buffer: Buffer,position: Long,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):AsyncFile = {
    asJava.write( )
    this
  }

  def read(buffer: Buffer,offset: Int,position: Long,length: Int,handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Buffer]]):AsyncFile = {
    asJava.read( )
    this
  }

  def flush():AsyncFile = {
    asJava.flush( )
    this
  }

  def flush(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):AsyncFile = {
    asJava.flush( )
    this
  }

  def setReadPos(readPos: Long):AsyncFile = {
    asJava.setReadPos( )
    this
  }

  def setWritePos(writePos: Long):AsyncFile = {
    asJava.setWritePos( )
    this
  }

  def setReadBufferSize(readBufferSize: Int):AsyncFile = {
    asJava.setReadBufferSize( )
    this
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.writeQueueFull( )
  }

  override def end():Unit = {
    asJava.end( )
  }

  def close():Unit = {
    asJava.close( )
  }

  def close(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.close( )
  }

}

object AsyncFile{
//in object!
//static methods
}
