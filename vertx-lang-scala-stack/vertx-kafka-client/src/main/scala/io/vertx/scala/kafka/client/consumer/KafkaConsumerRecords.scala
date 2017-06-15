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
import io.vertx.kafka.client.consumer.{KafkaConsumerRecords => JKafkaConsumerRecords}
import io.vertx.kafka.client.consumer.{KafkaConsumerRecord => JKafkaConsumerRecord}

/**
  * Vert.x Kafka consumer records
  */
class KafkaConsumerRecords[K: TypeTag, V: TypeTag](private val _asJava: Object) {

  def asJava = _asJava

  /**
    * @return the total number of records in this batch
    */
  def size(): Int = {
    asJava.asInstanceOf[JKafkaConsumerRecords[Object, Object]].size().asInstanceOf[Int]
  }

  /**
    * @return whether this batch contains any records
    */
  def isEmpty(): Boolean = {
    asJava.asInstanceOf[JKafkaConsumerRecords[Object, Object]].isEmpty().asInstanceOf[Boolean]
  }

  /**
    * Get the record at the given index
    * @param index the index of the record to get
    */
  def recordAt(index: Int): KafkaConsumerRecord[K, V] = {
    KafkaConsumerRecord[K, V](asJava.asInstanceOf[JKafkaConsumerRecords[Object, Object]].recordAt(index.asInstanceOf[java.lang.Integer]))
  }

}

object KafkaConsumerRecords {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaConsumerRecords[_, _]) = new KafkaConsumerRecords[K, V](asJava)  
}
