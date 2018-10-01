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

import io.vertx.rabbitmq.{Envelope => JEnvelope}
import io.vertx.core.buffer.Buffer
import io.vertx.rabbitmq.{BasicProperties => JBasicProperties}
import scala.reflect.runtime.universe._
import io.vertx.rabbitmq.{RabbitMQMessage => JRabbitMQMessage}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represent a message received message received in a rabbitmq-queue.

  */

class RabbitMQMessage(private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[io.vertx.core.buffer.Buffer] = None
  private var cached_1: Option[String] = None
  private var cached_2: Option[Envelope] = None
  private var cached_3: Option[BasicProperties] = None


  /**
   * @return the message body
   */
  def body(): io.vertx.core.buffer.Buffer = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JRabbitMQMessage].body()
      cached_0 = Some(tmp)
    }
    cached_0.get
  }

  /**
   * @return the <i>consumer tag</i> associated with the consumer
   */
  def consumerTag(): String = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JRabbitMQMessage].consumerTag()
      cached_1 = Some(tmp.asInstanceOf[String])
    }
    cached_1.get
  }

  /**
   * @return packaging data for the message
   */
  def envelope(): Envelope = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JRabbitMQMessage].envelope()
      cached_2 = Some(Envelope(tmp))
    }
    cached_2.get
  }

  /**
   * @return content header data for the message
   */
  def properties(): BasicProperties = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JRabbitMQMessage].properties()
      cached_3 = Some(BasicProperties(tmp))
    }
    cached_3.get
  }





}

object RabbitMQMessage {
  def apply(asJava: JRabbitMQMessage) = new RabbitMQMessage(asJava)
  
}
