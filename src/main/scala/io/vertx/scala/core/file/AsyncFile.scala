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

package io.vertx.scala.core.file;

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.scala.core.streams.ReadStream
import scala.util.Try
import io.vertx.core.Handler

class AsyncFile(private val _asJava: io.vertx.core.file.AsyncFile) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] 
    with io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.file.AsyncFile = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.file.AsyncFile = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.file.AsyncFile = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.file.AsyncFile = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

  def close(handler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.close(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
  }

  def write(buffer: io.vertx.scala.core.buffer.Buffer, position: Long)(handler: Try[Unit] => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.write(buffer.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], position, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def read(buffer: io.vertx.scala.core.buffer.Buffer, offset: Int, position: Long, length: Int)(handler: Try[io.vertx.scala.core.buffer.Buffer] => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.read(buffer.asJava.asInstanceOf[io.vertx.core.buffer.Buffer], offset, position, length, funcToMappedAsyncResultHandler(Buffer.apply)(handler))
    this
  }

  def flush(): io.vertx.scala.core.file.AsyncFile = {
    _asJava.flush()
    this
  }

  def flush(handler: Try[Unit] => Unit): io.vertx.scala.core.file.AsyncFile = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.flush(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(handler))
    this
  }

  def setReadPos(readPos: Long): io.vertx.scala.core.file.AsyncFile = {
    _asJava.setReadPos(readPos)
    this
  }

  def setWritePos(writePos: Long): io.vertx.scala.core.file.AsyncFile = {
    _asJava.setWritePos(writePos)
    this
  }

}

object AsyncFile {

  def apply(_asJava: io.vertx.core.file.AsyncFile): io.vertx.scala.core.file.AsyncFile =
    new io.vertx.scala.core.file.AsyncFile(_asJava)
}
