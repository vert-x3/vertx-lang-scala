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
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.streams.{ReadStream => JReadStream}

/**
  * Represents an file upload from an HTML FORM.
  */
class HttpServerFileUpload(private val _asJava: Object) 
    extends ReadStream[Buffer](_asJava) {

  override def asJava = _asJava.asInstanceOf[JHttpServerFileUpload]
//methods returning a future
//cached methods
//fluent methods
  override def exceptionHandler(handler: io.vertx.core.Handler[Throwable]):HttpServerFileUpload = {
    asJava.exceptionHandler( )
    this
  }

  override def handler(handler: io.vertx.core.Handler[Buffer]):HttpServerFileUpload = {
    asJava.handler( )
    this
  }

  override def endHandler(endHandler: io.vertx.core.Handler[Unit]):HttpServerFileUpload = {
    asJava.endHandler( )
    this
  }

  override def pause():HttpServerFileUpload = {
    asJava.pause( )
    this
  }

  override def resume():HttpServerFileUpload = {
    asJava.resume( )
    this
  }

  def streamToFileSystem(filename: String):HttpServerFileUpload = {
    asJava.streamToFileSystem( )
    this
  }

//basic methods
  def filename():String = {
    asJava.filename( )
  }

  def name():String = {
    asJava.name( )
  }

  def contentType():String = {
    asJava.contentType( )
  }

  def contentTransferEncoding():String = {
    asJava.contentTransferEncoding( )
  }

  def charset():String = {
    asJava.charset( )
  }

  def size():Long = {
    asJava.size( )
  }

  def isSizeAvailable():Boolean = {
    asJava.isSizeAvailable( )
  }

}

object HttpServerFileUpload{
//in object!
//static methods
}
