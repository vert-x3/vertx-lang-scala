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

package io.vertx.scala.core.http;

import io.vertx.scala.core.buffer.Buffer
import io.vertx.scala.core.streams.WriteStream
import io.vertx.scala.core.MultiMap
import scala.util.Try
import io.vertx.core.Handler

class HttpServerResponse(private val _asJava: io.vertx.core.http.HttpServerResponse) 
    extends io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def getStatusCode(): Int = {
    _asJava.getStatusCode()
  }

  def setStatusCode(statusCode: Int): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setStatusCode(statusCode)
    this
  }

  def getStatusMessage(): String = {
    _asJava.getStatusMessage()
  }

  def setStatusMessage(statusMessage: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setStatusMessage(statusMessage)
    this
  }

  def setChunked(chunked: Boolean): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.setChunked(chunked)
    this
  }

  def isChunked(): Boolean = {
    _asJava.isChunked()
  }

  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  def putHeader(name: String, value: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.putHeader(name, value)
    this
  }

  def trailers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.trailers())
  }

  def putTrailer(name: String, value: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.putTrailer(name, value)
    this
  }

  def closeHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.closeHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def write(chunk: String, enc: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(chunk, enc)
    this
  }

  def write(chunk: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.write(chunk)
    this
  }

  def end(chunk: String): Unit = {
    _asJava.end(chunk)
  }

  def end(chunk: String, enc: String): Unit = {
    _asJava.end(chunk, enc)
  }

  def end(chunk: io.vertx.scala.core.buffer.Buffer): Unit = {
    _asJava.end(chunk.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
  }

  def end(): Unit = {
    _asJava.end()
  }

  def sendFile(filename: String): io.vertx.scala.core.http.HttpServerResponse = {
    _asJava.sendFile(filename)
    this
  }

  def sendFile(filename: String)(resultHandler: Try[Unit] => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.sendFile(filename, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(resultHandler))
    this
  }

  def close(): Unit = {
    _asJava.close()
  }

  def ended(): Boolean = {
    _asJava.ended()
  }

  def headWritten(): Boolean = {
    _asJava.headWritten()
  }

  def headersEndHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.headersEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def bodyEndHandler(handler: => Unit): io.vertx.scala.core.http.HttpServerResponse = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.bodyEndHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

}

object HttpServerResponse {

  def apply(_asJava: io.vertx.core.http.HttpServerResponse): io.vertx.scala.core.http.HttpServerResponse =
    new io.vertx.scala.core.http.HttpServerResponse(_asJava)
}
