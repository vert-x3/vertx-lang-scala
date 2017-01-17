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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.core.http.{HttpServerFileUpload => JHttpServerFileUpload}
import io.vertx.scala.core.streams.ReadStream
import io.vertx.core.buffer.Buffer
import io.vertx.core.streams.{ReadStream => JReadStream}
import io.vertx.core.Handler

/**
  * Represents an file upload from an HTML FORM.
  */
class HttpServerFileUpload(private val _asJava: Object) 
    extends  ReadStream[io.vertx.core.buffer.Buffer] {

  def asJava = _asJava

  override def exceptionHandler(handler: Handler[Throwable]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].exceptionHandler({x: Throwable => handler.handle(x)})
    this
  }

  override def handler(handler: Handler[io.vertx.core.buffer.Buffer]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].handler({x: Buffer => handler.handle(x)})
    this
  }

  override def endHandler(endHandler: Handler[Unit]):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].endHandler({x: Void => endHandler.handle(x)})
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

  /**
    * Stream the content of this upload to the given file on storage.
    * @param filename the name of the file
    */
  def streamToFileSystem(filename: String):HttpServerFileUpload = {
    asJava.asInstanceOf[JHttpServerFileUpload].streamToFileSystem(filename.asInstanceOf[java.lang.String])
    this
  }

  /**
    * @return the filename which was used when upload the file.
    */
  def filename():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].filename().asInstanceOf[String]
  }

  /**
    * @return the name of the attribute
    */
  def name():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].name().asInstanceOf[String]
  }

  /**
    * @return the content type for the upload
    */
  def contentType():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentType().asInstanceOf[String]
  }

  /**
    * @return the contentTransferEncoding for the upload
    */
  def contentTransferEncoding():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].contentTransferEncoding().asInstanceOf[String]
  }

  /**
    * @return the charset for the upload
    */
  def charset():String = {
    asJava.asInstanceOf[JHttpServerFileUpload].charset().asInstanceOf[String]
  }

  /**
    * The size of the upload may not be available until it is all read.
    * Check [[io.vertx.scala.core.http.HttpServerFileUpload#isSizeAvailable]] to determine this
    * @return the size of the upload (in bytes)
    */
  def size():Long = {
    asJava.asInstanceOf[JHttpServerFileUpload].size().asInstanceOf[Long]
  }

  /**
    * @return true if the size of the upload can be retrieved via #size().
    */
  def isSizeAvailable():Boolean = {
    asJava.asInstanceOf[JHttpServerFileUpload].isSizeAvailable().asInstanceOf[Boolean]
  }

}

object HttpServerFileUpload{
  def apply(asJava: JHttpServerFileUpload) = new HttpServerFileUpload(asJava)  
}
