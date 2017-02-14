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

package io.vertx.scala.kafka.client.consumer

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.kafka.client.consumer.{KafkaConsumerRecord => JKafkaConsumerRecord}
import org.apache.kafka.common.record.TimestampType

/**
  * Vert.x Kafka consumer record
  */
class KafkaConsumerRecord[K: TypeTag, V: TypeTag](private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the topic this record is received from
    */
  def topic(): String = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].topic().asInstanceOf[String]
  }

  /**
    * @return the partition from which this record is received
    */
  def partition(): Int = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].partition().asInstanceOf[Int]
  }

  /**
    * @return the position of this record in the corresponding Kafka partition.
    */
  def offset(): Long = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].offset().asInstanceOf[Long]
  }

  /**
    * @return the timestamp of this record
    */
  def timestamp(): Long = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].timestamp().asInstanceOf[Long]
  }

  /**
    * @return the timestamp type of this record
    */
  def timestampType(): org.apache.kafka.common.record.TimestampType = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].timestampType()
  }

  /**
    * @return the checksum (CRC32) of the record.
    */
  def checksum(): Long = {
    asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].checksum().asInstanceOf[Long]
  }

  /**
    * @return the key (or null if no key is specified)
    */
  def key(): K = {
    toScala[K](asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].key())
  }

  /**
    * @return the value
    */
  def value(): V = {
    toScala[V](asJava.asInstanceOf[JKafkaConsumerRecord[Object, Object]].value())
  }

}

object KafkaConsumerRecord {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaConsumerRecord[_, _]) = new KafkaConsumerRecord[K, V](asJava)  
}
