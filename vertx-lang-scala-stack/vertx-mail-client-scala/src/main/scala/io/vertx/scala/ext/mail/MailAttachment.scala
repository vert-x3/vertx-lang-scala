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

import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.lang.scala.json.Json._
import io.vertx.ext.mail.{MailAttachment => JMailAttachment}
import io.vertx.core.buffer.{Buffer => JBuffer}
import io.vertx.scala.core.buffer.Buffer
import io.vertx.core.buffer.{Buffer => JBuffer}

/**
  * Represent a mail attachment that can be used in a MailMessage.
  */

class MailAttachment(val asJava: JMailAttachment) {

  /**
    * set the Content-ID field to be used in the attachment
    */
  def setContentId(value: String) = {
    asJava.setContentId(value)
    this
  }
  def getContentId = {
    asJava.getContentId()
  }

  /**
    * set the Content-Type
    */
  def setContentType(value: String) = {
    asJava.setContentType(value)
    this
  }
  def getContentType = {
    asJava.getContentType()
  }

  /**
    * set the data
    */
  def setData(value: JBuffer) = {
    asJava.setData(value)
    this
  }
  def getData = {
    asJava.getData()
  }

  /**
    * set the description field to be used in the attachment
    */
  def setDescription(value: String) = {
    asJava.setDescription(value)
    this
  }
  def getDescription = {
    asJava.getDescription()
  }

  /**
    * set the disposition field to be used in the attachment
    */
  def setDisposition(value: String) = {
    asJava.setDisposition(value)
    this
  }
  def getDisposition = {
    asJava.getDisposition()
  }

  /**
    * Add an header to this attachment.
    */
  def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value)
    this
  }

  /**
    * set the name
    */
  def setName(value: String) = {
    asJava.setName(value)
    this
  }
  def getName = {
    asJava.getName()
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
  
  def fromJson(json: JsonObject):MailAttachment = {
    if(json != null)
      new MailAttachment(new JMailAttachment(json))
    else
      null
  }
}
