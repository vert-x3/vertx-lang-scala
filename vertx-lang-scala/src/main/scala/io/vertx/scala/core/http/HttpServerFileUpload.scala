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

package io.vertx.scala.core.http

import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.Handler

/**
  * Represents an file upload from an HTML FORM.
  */
class HttpServerFileUpload(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) {

  def asJava = _asJava


//cached methods
//fluent methods
  override def exceptionHandler(handler: Handler[Throwable]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].exceptionHandler(x => handler.handle(x))
    this
  }

  override def handler(handler: Handler[Buffer]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].handler(x => handler.handle(x.asJava!!.asInstanceOf[JBuffer]))
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].endHandler(x => endHandler.handle(x))
    this
  }

  override def pause():HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].pause()
    this
  }

  override def resume():HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].resume()
    this
  }

  def streamToFileSystem(filename: String):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].streamToFileSystem(filename)
    this
  }

//basic methods
  def filename():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].filename()
  }

  def name():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].name()
  }

  def contentType():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentType()
  }

  def contentTransferEncoding():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentTransferEncoding()
  }

  def charset():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].charset()
  }

  def size():Long = {
    asJava.asInstanceOf[JHttpServerFileUpload].size()
  }

  def isSizeAvailable():Boolean = {
    asJava.asInstanceOf[JHttpServerFileUpload].isSizeAvailable()
  }

}

object HttpServerFileUpload{
  def apply(asJava: JHttpServerFileUpload) = new HttpServerFileUpload(asJava)
//static methods
}
