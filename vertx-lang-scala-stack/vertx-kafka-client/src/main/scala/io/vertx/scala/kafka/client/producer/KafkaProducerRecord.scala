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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.kafka.client.producer.{KafkaProducerRecord => JKafkaProducerRecord}

/**
  * Vert.x Kafka producer record.
  */
class KafkaProducerRecord[K: TypeTag, V: TypeTag](private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the topic this record is being sent to
    */
  def topic(): String = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].topic().asInstanceOf[String]
  }

  /**
    * @return the key (or null if no key is specified)
    */
  def key(): K = {
    toScala[K](asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].key())
  }

  /**
    * @return the value
    */
  def value(): V = {
    toScala[V](asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].value())
  }

  /**
    * @return the timestamp of this record
    */
  def timestamp(): Long = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].timestamp().asInstanceOf[Long]
  }

  /**
    * @return the partition to which the record will be sent (or null if no partition was specified)
    */
  def partition(): Int = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].partition().asInstanceOf[Int]
  }

}

object KafkaProducerRecord {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaProducerRecord[_, _]) = new KafkaProducerRecord[K, V](asJava)  
  /**
    * Create a concrete instance of a Vert.x producer record
    * @param topic the topic this record is being sent to
    * @param key the key (or null if no key is specified)
    * @param value the value
    * @param timestamp the timestamp of this record
    * @param partition the partition to which the record will be sent (or null if no partition was specified)
    * @return Vert.x producer record
    */
  def create[K: TypeTag, V: TypeTag](topic: String, key: K, value: V, timestamp: Long, partition: Int): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[K](key), toJava[V](value), timestamp.asInstanceOf[java.lang.Long], partition.asInstanceOf[java.lang.Integer]))
  }

  /**
    * Create a concrete instance of a Vert.x producer record
    * @param topic the topic this record is being sent to
    * @param key the key (or null if no key is specified)
    * @param value the value
    * @return Vert.x producer record
    */
  def create[K: TypeTag, V: TypeTag](topic: String, key: K, value: V): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[K](key), toJava[V](value)))
  }

  /**
    * Create a concrete instance of a Vert.x producer record
    * @param topic the topic this record is being sent to
    * @param value the value
    * @return Vert.x producer record
    */
  def create[K: TypeTag, V: TypeTag](topic: String, value: V): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[V](value)))
  }

}
