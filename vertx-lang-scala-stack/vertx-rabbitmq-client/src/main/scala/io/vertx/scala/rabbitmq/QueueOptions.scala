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

package io.vertx.scala.rabbitmq

import io.vertx.rabbitmq.{QueueOptions => JQueueOptions}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Aimed to specify queue consumer settings when calling [[io.vertx.scala.rabbitmq.RabbitMQClient]]

 */

class QueueOptions(private val _asJava: JQueueOptions) {
  def asJava = _asJava
  /**

   */
  def setAutoAck(value: Boolean) = {
    asJava.setAutoAck(value)
    this
  }

  def isAutoAck: Boolean = {
    asJava.isAutoAck().asInstanceOf[Boolean]
  }

  /**

   */
  def setKeepMostRecent(value: Boolean) = {
    asJava.setKeepMostRecent(value)
    this
  }

  def isKeepMostRecent: Boolean = {
    asJava.isKeepMostRecent().asInstanceOf[Boolean]
  }

  /**

   */
  def setMaxInternalQueueSize(value: Int) = {
    asJava.setMaxInternalQueueSize(value)
    this
  }

}


object QueueOptions {

  def apply() = {
    new QueueOptions(new JQueueOptions(emptyObj()))
  }

  def apply(t: JQueueOptions) = {
    if (t != null) {
      new QueueOptions(t)
    } else {
      new QueueOptions(new JQueueOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): QueueOptions = {
    if (json != null) {
      new QueueOptions(new JQueueOptions(json))
    } else {
      new QueueOptions(new JQueueOptions(emptyObj()))
    }
  }
}

