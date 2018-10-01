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

package io.vertx.scala.ext.web.multipart

import io.vertx.ext.web.multipart.{FormDataPart => JFormDataPart}
import io.vertx.ext.web.multipart.{MultipartForm => JMultipartForm}
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A multipart form.
  */

class MultipartForm(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Add an attribute form data part.   * @param name the name of the attribute
   * @param value the value of the attribute
   * @return a reference to this, so the API can be used fluently
   */
  
  def attribute(name: String, value: String): MultipartForm = {
    asJava.asInstanceOf[JMultipartForm].attribute(name.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a text file upload form data part.   * @param name name of the parameter
   * @param filename filename of the file
   * @param pathname the pathname of the file
   * @param mediaType the MIME type of the file
   * @return a reference to this, so the API can be used fluently
   */
  
  def textFileUpload(name: String, filename: String, pathname: String, mediaType: String): MultipartForm = {
    asJava.asInstanceOf[JMultipartForm].textFileUpload(name.asInstanceOf[java.lang.String], filename.asInstanceOf[java.lang.String], pathname.asInstanceOf[java.lang.String], mediaType.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Add a binary file upload form data part.   * @param name name of the parameter
   * @param filename filename of the file
   * @param pathname the pathname of the file
   * @param mediaType the MIME type of the file
   * @return a reference to this, so the API can be used fluently
   */
  
  def binaryFileUpload(name: String, filename: String, pathname: String, mediaType: String): MultipartForm = {
    asJava.asInstanceOf[JMultipartForm].binaryFileUpload(name.asInstanceOf[java.lang.String], filename.asInstanceOf[java.lang.String], pathname.asInstanceOf[java.lang.String], mediaType.asInstanceOf[java.lang.String])
    this
  }




}

object MultipartForm {
  def apply(asJava: JMultipartForm) = new MultipartForm(asJava)
  
  /**
   * @return a multipart form instance
   */
  def create(): MultipartForm = {
    MultipartForm(JMultipartForm.create())
  }

}
