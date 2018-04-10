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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.ext.web.multipart.{FormDataPart => JFormDataPart}

/**
  * A form data part of a [[io.vertx.scala.ext.web.multipart.MultipartForm]].
  */
class FormDataPart(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[String] = None
  private var cached_1: Option[Boolean] = None
  private var cached_2: Option[Boolean] = None
  private var cached_3: Option[String] = None
  private var cached_4: Option[String] = None
  private var cached_5: Option[String] = None
  private var cached_6: Option[String] = None
  private var cached_7: Option[Boolean] = None


  /**
    * @return the name
    */
  def name(): String = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].name()
      cached_0 = Some(tmp.asInstanceOf[String])
    }
    cached_0.get
  }

  /**
    * @return `true` when this part is an attribute
    */
  def isAttribute(): Boolean = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].isAttribute()
      cached_1 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_1.get
  }

  /**
    * @return `true` when this part is a file upload
    */
  def isFileUpload(): Boolean = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].isFileUpload()
      cached_2 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_2.get
  }

  /**
    * @return the value when the part for a form attribute otherwise `null`
    */
  def value(): String = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].value()
      cached_3 = Some(tmp.asInstanceOf[String])
    }
    cached_3.get
  }

  /**
    * @return the filename when this part is a file upload otherwise `null`
    */
  def filename(): String = {
    if (cached_4 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].filename()
      cached_4 = Some(tmp.asInstanceOf[String])
    }
    cached_4.get
  }

  /**
    * @return the pathname when this part is a file upload otherwise `null`
    */
  def pathname(): String = {
    if (cached_5 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].pathname()
      cached_5 = Some(tmp.asInstanceOf[String])
    }
    cached_5.get
  }

  /**
    * @return the media type when this part is a file upload otherwise `null`
    */
  def mediaType(): String = {
    if (cached_6 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].mediaType()
      cached_6 = Some(tmp.asInstanceOf[String])
    }
    cached_6.get
  }

  /**
    * @return whether the file upload is text or binary when this part is a file upload otherwise `null`
    */
  def isText(): Boolean = {
    if (cached_7 == None) {
      val tmp = asJava.asInstanceOf[JFormDataPart].isText()
      cached_7 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_7.get
  }

}

object FormDataPart {
  def apply(asJava: JFormDataPart) = new FormDataPart(asJava)  
}
