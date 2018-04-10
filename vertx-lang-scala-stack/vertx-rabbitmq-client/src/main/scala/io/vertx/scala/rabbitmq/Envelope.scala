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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.rabbitmq.{Envelope => JEnvelope}

/**
  * Like Envelope.
  */
class Envelope(private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Option[Long] = None
  private var cached_1: Option[Boolean] = None
  private var cached_2: Option[String] = None
  private var cached_3: Option[String] = None


  /**
    * Get the delivery tag included in this parameter envelope
    * @return the delivery tag
    */
  def deliveryTag(): Long = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JEnvelope].deliveryTag()
      cached_0 = Some(tmp.asInstanceOf[Long])
    }
    cached_0.get
  }

  /**
    * Get the redelivery flag included in this parameter envelope. This is a
    * hint as to whether this message may have been delivered before (but not
    * acknowledged). If the flag is not set, the message definitely has not
    * been delivered before. If it is set, it may have been delivered before.
    * @return the redelivery flag
    */
  def isRedelivery(): Boolean = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JEnvelope].isRedelivery()
      cached_1 = Some(tmp.asInstanceOf[Boolean])
    }
    cached_1.get
  }

  /**
    * Get the name of the exchange included in this parameter envelope
    * @return the exchange
    */
  def exchange(): String = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JEnvelope].exchange()
      cached_2 = Some(tmp.asInstanceOf[String])
    }
    cached_2.get
  }

  /**
    * Get the routing key included in this parameter envelope
    * @return the routing key
    */
  def routingKey(): String = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JEnvelope].routingKey()
      cached_3 = Some(tmp.asInstanceOf[String])
    }
    cached_3.get
  }

}

object Envelope {
  def apply(asJava: JEnvelope) = new Envelope(asJava)  
}
