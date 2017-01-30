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

package io.vertx.scala.ext.mail

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.mail.{MailAttachment => JMailAttachment}
import io.vertx.core.buffer.Buffer

/**
  * Represent a mail attachment that can be used in a MailMessage.
  */
class MailAttachment(private val _asJava: JMailAttachment) {

  def asJava = _asJava

  /**
    * set the Content-ID field to be used in the attachment
    */
  def setContentId(value: String) = {
    asJava.setContentId(value)
    this
  }
  def getContentId: String = {
    asJava.getContentId().asInstanceOf[String]
  }

  /**
    * set the Content-Type
    */
  def setContentType(value: String) = {
    asJava.setContentType(value)
    this
  }
  def getContentType: String = {
    asJava.getContentType().asInstanceOf[String]
  }

  /**
    * set the data
    */
  def setData(value: io.vertx.core.buffer.Buffer) = {
    asJava.setData(value)
    this
  }
  def getData: io.vertx.core.buffer.Buffer = {
    asJava.getData()
  }

  /**
    * set the description field to be used in the attachment
    */
  def setDescription(value: String) = {
    asJava.setDescription(value)
    this
  }
  def getDescription: String = {
    asJava.getDescription().asInstanceOf[String]
  }

  /**
    * set the disposition field to be used in the attachment
    */
  def setDisposition(value: String) = {
    asJava.setDisposition(value)
    this
  }
  def getDisposition: String = {
    asJava.getDisposition().asInstanceOf[String]
  }

  /**
    * Add an header to this attachment.
    */
  def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * set the name
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName: String = {
    asJava.getName().asInstanceOf[String]
  }
}

object MailAttachment {
  
  def apply() = {
    new MailAttachment(new JMailAttachment(emptyObj()))
  }
  
  def apply(t: JMailAttachment) = {
    if(t != null)
      new MailAttachment(t)
    else
      null
  }
  
  def fromJson(json: JsonObject): MailAttachment = {
    if(json != null)
      new MailAttachment(new JMailAttachment(json))
    else
      null
  }
}
