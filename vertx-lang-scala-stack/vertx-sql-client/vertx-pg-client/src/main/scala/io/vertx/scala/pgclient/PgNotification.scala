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

package io.vertx.scala.pgclient

import io.vertx.core.json.JsonObject
import io.vertx.pgclient.{PgNotification => JPgNotification}
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * A notification emited by Postgres.

 */

class PgNotification(private val _asJava: JPgNotification) {
  def asJava = _asJava
  /**
   * Set the channel value.
   */
  def setChannel(value: String) = {
    asJava.setChannel(value)
    this
  }

  def getChannel: String = {
    asJava.getChannel().asInstanceOf[String]
  }

  /**
   * Set the payload value.
   */
  def setPayload(value: String) = {
    asJava.setPayload(value)
    this
  }

  def getPayload: String = {
    asJava.getPayload().asInstanceOf[String]
  }

  /**
   * Set the process id.
   */
  def setProcessId(value: Int) = {
    asJava.setProcessId(value)
    this
  }

  def getProcessId: Int = {
    asJava.getProcessId().asInstanceOf[Int]
  }

}


object PgNotification {
  
  def apply() = {
    new PgNotification(new JPgNotification(emptyObj()))
  }
  
  def apply(t: JPgNotification) = {
    if (t != null) {
      new PgNotification(t)
    } else {
      new PgNotification(new JPgNotification(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): PgNotification = {
    if (json != null) {
      new PgNotification(new JPgNotification(json))
    } else {
      new PgNotification(new JPgNotification(emptyObj()))
    }
  }
}

