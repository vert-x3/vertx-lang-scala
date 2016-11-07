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

package io.vertx.scala.ext.web

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.web.{FileUpload => JFileUpload}

/**
  * Represents a file-upload from an HTTP multipart form submission.
  * 
  */
class FileUpload(private val _asJava: JFileUpload) {

  def asJava: JFileUpload = _asJava

  /**
    * @return the name of the upload as provided in the form submission
    */
  def name(): String = {
    _asJava.name()
  }

  /**
    * @return the actual temporary file name on the server where the file was uploaded to.
    */
  def uploadedFileName(): String = {
    _asJava.uploadedFileName()
  }

  /**
    * @return the file name of the upload as provided in the form submission
    */
  def fileName(): String = {
    _asJava.fileName()
  }

  /**
    * @return the size of the upload, in bytes
    */
  def size(): Long = {
    _asJava.size()
  }

  /**
    * @return the content type (MIME type) of the upload
    */
  def contentType(): String = {
    _asJava.contentType()
  }

  /**
    * @return the content transfer encoding of the upload - this describes how the upload was encoded in the form submission.
    */
  def contentTransferEncoding(): String = {
    _asJava.contentTransferEncoding()
  }

  /**
    * @return the charset of the upload
    */
  def charSet(): String = {
    _asJava.charSet()
  }

}

object FileUpload {

  def apply(_asJava: JFileUpload): FileUpload =
    new FileUpload(_asJava)

}
