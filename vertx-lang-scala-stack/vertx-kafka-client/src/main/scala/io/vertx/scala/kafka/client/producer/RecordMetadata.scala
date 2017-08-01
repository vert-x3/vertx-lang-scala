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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.kafka.client.producer.{RecordMetadata => JRecordMetadata}

/**
  * Metadata related to a Kafka record
  */
class RecordMetadata(private val _asJava: JRecordMetadata) {

  def asJava = _asJava

  /**
    * Set the checksum (CRC32) of the record.
    */
  def setChecksum(value: Long) = {
    asJava.setChecksum(value)
    this
  }

  /**
    * Set the offset of the record in the topic/partition.
    */
  def setOffset(value: Long) = {
    asJava.setOffset(value)
    this
  }
  def getOffset: Long = {
    asJava.getOffset().asInstanceOf[Long]
  }

  /**
    * Set the partition the record was sent to
    */
  def setPartition(value: Int) = {
    asJava.setPartition(value)
    this
  }
  def getPartition: Int = {
    asJava.getPartition().asInstanceOf[Int]
  }

  /**
    * Set the timestamp of the record in the topic/partition
    */
  def setTimestamp(value: Long) = {
    asJava.setTimestamp(value)
    this
  }
  def getTimestamp: Long = {
    asJava.getTimestamp().asInstanceOf[Long]
  }

  /**
    * Set the topic the record was appended to
    */
  def setTopic(value: String) = {
    asJava.setTopic(value)
    this
  }
  def getTopic: String = {
    asJava.getTopic().asInstanceOf[String]
  }
}

object RecordMetadata {
  
  def apply() = {
    new RecordMetadata(new JRecordMetadata(emptyObj()))
  }
  
  def apply(t: JRecordMetadata) = {
    if (t != null) {
      new RecordMetadata(t)
    } else {
      new RecordMetadata(new JRecordMetadata(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): RecordMetadata = {
    if (json != null) {
      new RecordMetadata(new JRecordMetadata(json))
    } else {
      new RecordMetadata(new JRecordMetadata(emptyObj()))
    }
  }
}
