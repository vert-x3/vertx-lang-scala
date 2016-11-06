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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.mail.{MailClient => JMailClient}
  import io.vertx.ext.mail.{MailConfig => JMailConfig}
  import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
  import io.vertx.ext.mail.{MailClient => JMailClient}
        import io.vertx.ext.mail.{MailMessage => JMailMessage}
  import io.vertx.ext.mail.{MailResult => JMailResult}

/**
  * SMTP mail client for Vert.x
  * 
  * A simple asynchronous API for sending mails from Vert.x applications
  */
class MailClient(private val _asJava: JMailClient) {

  def asJava: JMailClient = _asJava

  /**
    * send a single mail via MailClient
    * @param email MailMessage object containing the mail text, from/to, attachments etcsee <a href="../../../../../../../cheatsheet/MailMessage.html">MailMessage</a>
    * @return will be called when the operation is finished or it fails (may be null to ignore the result)
    */
  def sendMailFuture(email: MailMessage): concurrent.Future[MailResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JMailResult,MailResult]((x => io.vertx.scala.ext.mail.MailResult(x)))
    _asJava.sendMail(email.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * close the MailClient
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object MailClient {

  def apply(_asJava: JMailClient): MailClient =
    new MailClient(_asJava)

  def createNonShared(vertx: Vertx, config: MailConfig): MailClient = {
    MailClient.apply(io.vertx.ext.mail.MailClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config.asJava))
  }

  def createShared(vertx: Vertx, config: MailConfig, poolName: String): MailClient = {
    MailClient.apply(io.vertx.ext.mail.MailClient.createShared(vertx.asJava.asInstanceOf[JVertx], config.asJava, poolName))
  }

  def createShared(vertx: Vertx, config: MailConfig): MailClient = {
    MailClient.apply(io.vertx.ext.mail.MailClient.createShared(vertx.asJava.asInstanceOf[JVertx], config.asJava))
  }

}
