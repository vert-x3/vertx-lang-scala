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


package io.vertx.scala.ext

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.ext.mail.{MailMessage => JMailMessage}
package object mail{


  type DKIMSignOptions = io.vertx.ext.mail.DKIMSignOptions
  object DKIMSignOptions {
    def apply() = new DKIMSignOptions()
    def apply(json: JsonObject) = new DKIMSignOptions(json)
  }



  type MailConfig = io.vertx.ext.mail.MailConfig
  object MailConfig {
    def apply() = new MailConfig()
    def apply(json: JsonObject) = new MailConfig(json)
    def apply(str: String) = new MailConfig(str)
  }



  type MailMessage = io.vertx.ext.mail.MailMessage
  object MailMessage {
    def apply() = new MailMessage()
    def apply(json: JsonObject) = new MailMessage(json)
  }



  type MailResult = io.vertx.ext.mail.MailResult
  object MailResult {
    def apply() = new MailResult()
    def apply(json: JsonObject) = new MailResult(json)
  }



}
