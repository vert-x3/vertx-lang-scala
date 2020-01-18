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

import scala.reflect.runtime.universe._
import io.vertx.ext.web.{FileUpload => JFileUpload}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents a file-upload from an HTTP multipart form submission.
  * 
  */

class FileUpload(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * @return the name of the upload as provided in the form submission
   */
  def name (): String = {
    asJava.asInstanceOf[JFileUpload].name().asInstanceOf[String]
  }

  /**
   * @return the actual temporary file name on the server where the file was uploaded to.
   */
  def uploadedFileName (): String = {
    asJava.asInstanceOf[JFileUpload].uploadedFileName().asInstanceOf[String]
  }

  /**
   * @return the file name of the upload as provided in the form submission
   */
  def fileName (): String = {
    asJava.asInstanceOf[JFileUpload].fileName().asInstanceOf[String]
  }

  /**
   * @return the size of the upload, in bytes
   */
  def size (): Long = {
    asJava.asInstanceOf[JFileUpload].size().asInstanceOf[Long]
  }

  /**
   * @return the content type (MIME type) of the upload
   */
  def contentType (): String = {
    asJava.asInstanceOf[JFileUpload].contentType().asInstanceOf[String]
  }

  /**
   * @return the content transfer encoding of the upload - this describes how the upload was encoded in the form submission.
   */
  def contentTransferEncoding (): String = {
    asJava.asInstanceOf[JFileUpload].contentTransferEncoding().asInstanceOf[String]
  }

  /**
   * @return the charset of the upload
   */
  def charSet (): String = {
    asJava.asInstanceOf[JFileUpload].charSet().asInstanceOf[String]
  }


}

object FileUpload {
  def apply(asJava: JFileUpload) = new FileUpload(asJava)

}
