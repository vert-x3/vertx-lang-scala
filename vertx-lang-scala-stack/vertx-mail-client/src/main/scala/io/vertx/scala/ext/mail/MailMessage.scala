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
import io.vertx.ext.mail.{MailMessage => JMailMessage}

/**
  * represent a mail message that can be sent via the MailClient
  */
class MailMessage(private val _asJava: JMailMessage) {

  def asJava = _asJava

  /**
    * set the list of attachments of this mail
    */
  def setAttachment(value: scala.collection.mutable.Buffer[MailAttachment]) = {
    asJava.setAttachment(value.map(_.asJava).asJava)
    this
  }
  def getAttachment: scala.collection.mutable.Buffer[MailAttachment] = {
    asJava.getAttachment().asScala.map(x => MailAttachment(x))
  }

  /**
    * set list of bcc addresses
    */
  def setBcc(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setBcc(value.asJava)
    this
  }
  def getBcc: scala.collection.mutable.Buffer[String] = {
    asJava.getBcc().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * set bounce address of this mail
    */
  def setBounceAddress(value: String) = {
    asJava.setBounceAddress(value)
    this
  }
  def getBounceAddress: String = {
    asJava.getBounceAddress().asInstanceOf[String]
  }

  /**
    * set list of cc addresses
    */
  def setCc(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setCc(value.asJava)
    this
  }
  def getCc: scala.collection.mutable.Buffer[String] = {
    asJava.getCc().asScala.map(x => x.asInstanceOf[String])
  }

  /**
    * set whether our own headers should be the only headers added to the message
    */
  def setFixedHeaders(value: Boolean) = {
    asJava.setFixedHeaders(value)
    this
  }
  def isFixedHeaders: Boolean = {
    asJava.isFixedHeaders().asInstanceOf[Boolean]
  }

  /**
    * set from address of this mail
    */
  def setFrom(value: String) = {
    asJava.setFrom(value)
    this
  }
  def getFrom: String = {
    asJava.getFrom().asInstanceOf[String]
  }

  /**
    * Add a message header.
    */
  def addHeader(key: String, value: String) = {
    asJava.addHeader(key, value.asInstanceOf[java.lang.String])
    this
  }

  /**
    * set the html text of this mail
    */
  def setHtml(value: String) = {
    asJava.setHtml(value)
    this
  }
  def getHtml: String = {
    asJava.getHtml().asInstanceOf[String]
  }

  /**
    * set the list of inline attachments of this mail
    */
  def setInlineAttachment(value: scala.collection.mutable.Buffer[MailAttachment]) = {
    asJava.setInlineAttachment(value.map(_.asJava).asJava)
    this
  }
  def getInlineAttachment: scala.collection.mutable.Buffer[MailAttachment] = {
    asJava.getInlineAttachment().asScala.map(x => MailAttachment(x))
  }

  /**
    * set the subject of this mail
    */
  def setSubject(value: String) = {
    asJava.setSubject(value)
    this
  }
  def getSubject: String = {
    asJava.getSubject().asInstanceOf[String]
  }

  /**
    * set the plain text of this mail
    */
  def setText(value: String) = {
    asJava.setText(value)
    this
  }
  def getText: String = {
    asJava.getText().asInstanceOf[String]
  }

  /**
    * set list of to addresses
    */
  def setTo(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setTo(value.asJava)
    this
  }
  def getTo: scala.collection.mutable.Buffer[String] = {
    asJava.getTo().asScala.map(x => x.asInstanceOf[String])
  }
}

object MailMessage {
  
  def apply() = {
    new MailMessage(new JMailMessage(emptyObj()))
  }
  
  def apply(t: JMailMessage) = {
    if (t != null) {
      new MailMessage(t)
    } else {
      new MailMessage(new JMailMessage(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): MailMessage = {
    if (json != null) {
      new MailMessage(new JMailMessage(json))
    } else {
      new MailMessage(new JMailMessage(emptyObj()))
    }
  }
}
