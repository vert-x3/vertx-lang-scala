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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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
    extends ReadStream[Buffer] 
    with WriteStream[Buffer] {

  def asJava = _asJava

//cached methods
//fluent methods
  override def handler(handler: Handler[Buffer]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].handler({x: JBuffer => handler.handle(Buffer(x))})
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
    asJava.asInstanceOf[JAsyncFile].endHandler({x: Void => endHandler.handle(x)})
    this
  }

  override def write(data: Buffer):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(data.asJava.asInstanceOf[JBuffer])
    this
  }

  override def setWriteQueueMaxSize(maxSize: Int):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWriteQueueMaxSize(maxSize.asInstanceOf[java.lang.Integer])
    this
  }

  override def drainHandler(handler: Handler[Unit]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].drainHandler({x: Void => handler.handle(x)})
    this
  }

  override def exceptionHandler(handler: Handler[Throwable]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  def write(buffer: Buffer,position: Long,handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].write(buffer.asJava.asInstanceOf[JBuffer],position.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def read(buffer: Buffer,offset: Int,position: Long,length: Int,handler: Handler[AsyncResult[Buffer]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].read(buffer.asJava.asInstanceOf[JBuffer],offset.asInstanceOf[java.lang.Integer],position.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Integer],{x: AsyncResult[JBuffer] => handler.handle(AsyncResultWrapper[JBuffer,Buffer](x, a => Buffer(a)))})
    this
  }

  def flush():AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush()
    this
  }

  def flush(handler: Handler[AsyncResult[Unit]]):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].flush({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def setReadPos(readPos: Long):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadPos(readPos.asInstanceOf[java.lang.Long])
    this
  }

  def setWritePos(writePos: Long):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setWritePos(writePos.asInstanceOf[java.lang.Long])
    this
  }

  def setReadBufferSize(readBufferSize: Int):AsyncFile = {
    asJava.asInstanceOf[JAsyncFile].setReadBufferSize(readBufferSize.asInstanceOf[java.lang.Integer])
    this
  }

//default methods
  //io.vertx.core.streams.WriteStream
  override def end(t: Buffer):Unit = {
    asJava.asInstanceOf[JAsyncFile].end(t.asJava.asInstanceOf[JBuffer])
  }

//basic methods
  override def writeQueueFull():Boolean = {
    asJava.asInstanceOf[JAsyncFile].writeQueueFull().asInstanceOf[Boolean]
  }

  override def end():Unit = {
    asJava.asInstanceOf[JAsyncFile].end()
  }

  def close():Unit = {
    asJava.asInstanceOf[JAsyncFile].close()
  }

  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncFile].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

//future methods
    def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncFile].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def writeFuture(buffer: Buffer,position: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncFile].write(buffer.asJava.asInstanceOf[JBuffer],position.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def readFuture(buffer: Buffer,offset: Int,position: Long,length: Int):scala.concurrent.Future[Buffer] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JBuffer, Buffer](x => if (x == null) null.asInstanceOf[Buffer] else Buffer(x))
    asJava.asInstanceOf[JAsyncFile].read(buffer.asJava.asInstanceOf[JBuffer],offset.asInstanceOf[java.lang.Integer],position.asInstanceOf[java.lang.Long],length.asInstanceOf[java.lang.Integer],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def flushFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncFile].flush(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object AsyncFile{
    def apply(asJava: JAsyncFile) = new AsyncFile(asJava)  
  //static methods
  }
