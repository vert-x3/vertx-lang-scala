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
import scala.collection.JavaConverters._
import io.vertx.kafka.client.producer.{KafkaHeader => JKafkaHeader}
import io.vertx.kafka.client.producer.{KafkaProducerRecord => JKafkaProducerRecord}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Vert.x Kafka producer record.

  */

class KafkaProducerRecord[K: TypeTag, V: TypeTag](private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[scala.collection.mutable.Buffer[KafkaHeader]] = None


  /**
   * @return the headers of this record
   */
  def headers(): scala.collection.mutable.Buffer[KafkaHeader] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].headers()
      cached_0 = Some(tmp.asScala.map(x => KafkaHeader(x)))
    }
    cached_0.get
  }


  /**
   * Like [[io.vertx.scala.kafka.client.producer.KafkaProducerRecord#addHeader]] but with a key/value pair
   */
  
  def addHeader(key: String, value: String): KafkaProducerRecord[K, V] = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].addHeader(key.asInstanceOf[java.lang.String], value.asInstanceOf[java.lang.String])
    this
  }

  /**
   * Like [[io.vertx.scala.kafka.client.producer.KafkaProducerRecord#addHeader]] but with a key/value pair
   */
  
  def addHeader(key: String, value: io.vertx.core.buffer.Buffer): KafkaProducerRecord[K, V] = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].addHeader(key.asInstanceOf[java.lang.String], value)
    this
  }

  /**
   * Add an header to this record.   * @param header the header
   * @return current KafkaProducerRecord instance
   */
  
  def addHeader(header: KafkaHeader): KafkaProducerRecord[K, V] = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].addHeader(header.asJava.asInstanceOf[JKafkaHeader])
    this
  }

  /**
   * Add a list of headers to this record.   * @param headers the headers
   * @return current KafkaProducerRecord instance
   */
  
  def addHeaders(headers: scala.collection.mutable.Buffer[KafkaHeader]): KafkaProducerRecord[K, V] = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].addHeaders(headers.map(x => x.asJava.asInstanceOf[JKafkaHeader]).asJava)
    this
  }



  /**
   * @return the topic this record is being sent to
   */
  def topic (): String = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].topic().asInstanceOf[String]
  }

  /**
   * @return the key (or null if no key is specified)
   */
  def key (): K = {
    toScala[K](asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].key())
  }

  /**
   * @return the value
   */
  def value (): V = {
    toScala[V](asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].value())
  }

  /**
   * @return the timestamp of this record
   */
  def timestamp (): Long = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].timestamp().asInstanceOf[Long]
  }

  /**
   * @return the partition to which the record will be sent (or null if no partition was specified)
   */
  def partition (): Int = {
    asJava.asInstanceOf[JKafkaProducerRecord[Object, Object]].partition().asInstanceOf[Int]
  }


}

object KafkaProducerRecord {
  def apply[K: TypeTag, V: TypeTag](asJava: JKafkaProducerRecord[_, _]) = new KafkaProducerRecord[K, V](asJava)

  /**
   * Create a concrete instance of a Vert.x producer record   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @param timestamp the timestamp of this record
   * @param partition the partition to which the record will be sent (or null if no partition was specified)
   * @return Vert.x producer record
   */
  def create[K: TypeTag, V: TypeTag](topic: String,key: K,value: V,timestamp: Long,partition: Int): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[K](key), toJava[V](value), timestamp.asInstanceOf[java.lang.Long], partition.asInstanceOf[java.lang.Integer]))//2 create
  }

  /**
   * Create a concrete instance of a Vert.x producer record   * @param topic the topic this record is being sent to
   * @param key the key (or null if no key is specified)
   * @param value the value
   * @return Vert.x producer record
   */
  def create[K: TypeTag, V: TypeTag](topic: String,key: K,value: V): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[K](key), toJava[V](value)))//2 create
  }

  /**
   * Create a concrete instance of a Vert.x producer record   * @param topic the topic this record is being sent to
   * @param value the value
   * @return Vert.x producer record
   */
  def create[K: TypeTag, V: TypeTag](topic: String,value: V): KafkaProducerRecord[K, V] = {
    KafkaProducerRecord[K, V](JKafkaProducerRecord.create[Object, Object](topic.asInstanceOf[java.lang.String], toJava[V](value)))//2 create
  }

}
