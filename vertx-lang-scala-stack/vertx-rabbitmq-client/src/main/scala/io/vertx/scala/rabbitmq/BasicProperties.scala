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

import io.vertx.rabbitmq.{BasicProperties => JBasicProperties}
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Like BasicProperties

  */

class BasicProperties(private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[String] = None
  private var cached_1: Option[String] = None
  private var cached_2: Option[Int] = None
  private var cached_3: Option[Int] = None
  private var cached_4: Option[String] = None
  private var cached_5: Option[String] = None
  private var cached_6: Option[String] = None
  private var cached_7: Option[String] = None
  private var cached_8: Option[Long] = None
  private var cached_9: Option[String] = None
  private var cached_10: Option[String] = None
  private var cached_11: Option[String] = None
  private var cached_12: Option[String] = None


  /**
   * @return contentType of a message, or `null` if it has not been set.
   */
  def contentType(): String = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].contentType()
      cached_0 = Some(tmp.asInstanceOf[String])
    }
    cached_0.get
  }

  /**
   * @return contentEncoding of a message, or `null` if it has not been set.
   */
  def contentEncoding(): String = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].contentEncoding()
      cached_1 = Some(tmp.asInstanceOf[String])
    }
    cached_1.get
  }

  /**
   * @return deliveryMode of a message, or `null` if it has not been set.
   */
  def deliveryMode(): Int = {
    if (cached_2 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].deliveryMode()
      cached_2 = Some(tmp.asInstanceOf[Int])
    }
    cached_2.get
  }

  /**
   * Retrieve the value in the priority field.   * @return priority of a message, or `null` if it has not been set.
   */
  def priority(): Int = {
    if (cached_3 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].priority()
      cached_3 = Some(tmp.asInstanceOf[Int])
    }
    cached_3.get
  }

  /**
   * @return correlationId of a message, or `null` if it has not been set.
   */
  def correlationId(): String = {
    if (cached_4 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].correlationId()
      cached_4 = Some(tmp.asInstanceOf[String])
    }
    cached_4.get
  }

  /**
   * @return replyTo address, or `null` if it has not been set.
   */
  def replyTo(): String = {
    if (cached_5 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].replyTo()
      cached_5 = Some(tmp.asInstanceOf[String])
    }
    cached_5.get
  }

  /**
   * @return expiration of a message, or `null` if it has not been set.
   */
  def expiration(): String = {
    if (cached_6 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].expiration()
      cached_6 = Some(tmp.asInstanceOf[String])
    }
    cached_6.get
  }

  /**
   * @return messageId, or `null` if it has not been set.
   */
  def messageId(): String = {
    if (cached_7 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].messageId()
      cached_7 = Some(tmp.asInstanceOf[String])
    }
    cached_7.get
  }

  /**
   * @return timestamp of a message, or `null` if it has not been set.
   */
  def timestamp(): Long = {
    if (cached_8 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].timestamp()
      cached_8 = Some(tmp.asInstanceOf[Long])
    }
    cached_8.get
  }

  /**
   * @return type of a message, or `null` if it has not been set.
   */
  def `type`(): String = {
    if (cached_9 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].`type`()
      cached_9 = Some(tmp.asInstanceOf[String])
    }
    cached_9.get
  }

  /**
   * @return userId, or `null` if it has not been set.
   */
  def userId(): String = {
    if (cached_10 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].userId()
      cached_10 = Some(tmp.asInstanceOf[String])
    }
    cached_10.get
  }

  /**
   * @return appId, or `null` if it has not been set.
   */
  def appId(): String = {
    if (cached_11 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].appId()
      cached_11 = Some(tmp.asInstanceOf[String])
    }
    cached_11.get
  }

  /**
   * @return clusterId, or `null` if it has not been set.
   */
  def clusterId(): String = {
    if (cached_12 == None) {
      val tmp = asJava.asInstanceOf[JBasicProperties].clusterId()
      cached_12 = Some(tmp.asInstanceOf[String])
    }
    cached_12.get
  }





}

object BasicProperties {
  def apply(asJava: JBasicProperties) = new BasicProperties(asJava)
  
}
