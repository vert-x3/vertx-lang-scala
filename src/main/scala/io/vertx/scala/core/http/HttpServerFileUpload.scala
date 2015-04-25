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
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.Handler

class HttpServerFileUpload(private val _asJava: io.vertx.core.http.HttpServerFileUpload) 
    extends io.vertx.scala.core.streams.ReadStream[io.vertx.scala.core.buffer.Buffer] {

  def asJava: java.lang.Object = _asJava

  def exceptionHandler(handler: Throwable => Unit): io.vertx.scala.core.http.HttpServerFileUpload = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.exceptionHandler(funcToMappedHandler[java.lang.Throwable, Throwable](x => x)(handler))
    this
  }

  def handler(handler: io.vertx.scala.core.buffer.Buffer => Unit): io.vertx.scala.core.http.HttpServerFileUpload = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.handler(funcToMappedHandler(Buffer.apply)(handler))
    this
  }

  def endHandler(endHandler: => Unit): io.vertx.scala.core.http.HttpServerFileUpload = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.endHandler(funcToMappedHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(_ =>endHandler))
    this
  }

  def pause(): io.vertx.scala.core.http.HttpServerFileUpload = {
    _asJava.pause()
    this
  }

  def resume(): io.vertx.scala.core.http.HttpServerFileUpload = {
    _asJava.resume()
    this
  }

  def streamToFileSystem(filename: String): io.vertx.scala.core.http.HttpServerFileUpload = {
    _asJava.streamToFileSystem(filename)
    this
  }

  def filename(): String = {
    _asJava.filename()
  }

  def name(): String = {
    _asJava.name()
  }

  def contentType(): String = {
    _asJava.contentType()
  }

  def contentTransferEncoding(): String = {
    _asJava.contentTransferEncoding()
  }

  def charset(): String = {
    _asJava.charset()
  }

  def size(): Long = {
    _asJava.size()
  }

  def isSizeAvailable(): Boolean = {
    _asJava.isSizeAvailable()
  }

}

object HttpServerFileUpload {

  def apply(_asJava: io.vertx.core.http.HttpServerFileUpload): io.vertx.scala.core.http.HttpServerFileUpload =
    new io.vertx.scala.core.http.HttpServerFileUpload(_asJava)
}
