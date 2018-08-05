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

package io.vertx.scala.kafka.client.producer

import io.vertx.core.buffer.Buffer
import scala.reflect.runtime.universe._
import io.vertx.kafka.client.producer.{KafkaHeader => JKafkaHeader}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Vert.x Kafka producer record header.

  */

class KafkaHeader(private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[String] = None
  private var cached_1: Option[io.vertx.core.buffer.Buffer] = None


  /**
   * @return the buffer key
   */
  def key(): String = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JKafkaHeader].key()
      cached_0 = Some(tmp.asInstanceOf[String])
    }
    cached_0.get
  }

  /**
   * @return the buffer value
   */
  def value(): io.vertx.core.buffer.Buffer = {
    if (cached_1 == None) {
      val tmp = asJava.asInstanceOf[JKafkaHeader].value()
      cached_1 = Some(tmp)
    }
    cached_1.get
  }





}

object KafkaHeader {
  def apply(asJava: JKafkaHeader) = new KafkaHeader(asJava)
  

  def header(key: String,value: io.vertx.core.buffer.Buffer): KafkaHeader = {
    KafkaHeader(JKafkaHeader.header(key.asInstanceOf[java.lang.String], value))
  }


  def header(key: String,value: String): KafkaHeader = {
    KafkaHeader(JKafkaHeader.header(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String]))
  }

}
