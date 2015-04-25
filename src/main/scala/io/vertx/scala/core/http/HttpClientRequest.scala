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
import io.vertx.core.http.HttpMethod
import io.vertx.scala.core.streams.ReadStream
import io.vertx.scala.core.MultiMap
import io.vertx.core.Handler

class HttpClientRequest(private val _asJava: io.vertx.core.http.HttpClientRequest) 
    extends io.vertx.scala.core.streams.WriteStream[io.vertx.scala.core.buffer.Buffer] 
    with io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.http.HttpClientResponse] {

  def asJava: java.lang.Object = _asJava

  def writeQueueFull(): Boolean = {
    _asJava.writeQueueFull()
  }

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def write(data: io.vertx.scala.core.buffer.Buffer): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(data.asJava.asInstanceOf[io.vertx.core.buffer.Buffer])
    this
  }

  def setWriteQueueMaxSize(maxSize: Int): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setWriteQueueMaxSize(maxSize)
    this
  }

  def drainHandler(handler: => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.drainHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def handler(handler: io.vertx.scala.core.http.HttpClientResponse => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(HttpClientResponse.apply)(handler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.resume()
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def setChunked(chunked: Boolean): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setChunked(chunked)
    this
  }

  def isChunked(): Boolean = {
    _asJava.isChunked()
  }

  def method(): io.vertx.core.http.HttpMethod = {
    _asJava.method()
  }

  def uri(): String = {
    _asJava.uri()
  }

  def headers(): io.vertx.scala.core.MultiMap = {
    MultiMap.apply(_asJava.headers())
  }

  def putHeader(name: String, value: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.putHeader(name, value)
    this
  }

  def write(chunk: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(chunk)
    this
  }

  def write(chunk: String, enc: String): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.write(chunk, enc)
    this
  }

  def continueHandler(handler: => Unit): io.vertx.scala.core.http.HttpClientRequest = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.continueHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>handler))
    this
  }

  def sendHead(): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.sendHead()
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

  def setTimeout(timeoutMs: Long): io.vertx.scala.core.http.HttpClientRequest = {
    _asJava.setTimeout(timeoutMs)
    this
  }

}

object HttpClientRequest {

  def apply(_asJava: io.vertx.core.http.HttpClientRequest): io.vertx.scala.core.http.HttpClientRequest =
    new io.vertx.scala.core.http.HttpClientRequest(_asJava)
}
