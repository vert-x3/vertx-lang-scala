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


package io.vertx.scala.kafka

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.kafka.client.consumer.{OffsetAndMetadata => JOffsetAndMetadata}
package object client{


  type ConfigResource = io.vertx.kafka.client.common.ConfigResource
  object ConfigResource {
    def apply() = new ConfigResource()
    def apply(json: JsonObject) = new ConfigResource(json)
  }



  type KafkaClientOptions = io.vertx.kafka.client.common.KafkaClientOptions
  object KafkaClientOptions {
    def apply() = new KafkaClientOptions()
    def apply(json: JsonObject) = new KafkaClientOptions(json)
  }



  type Node = io.vertx.kafka.client.common.Node
  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
  }



  type OffsetAndMetadata = io.vertx.kafka.client.consumer.OffsetAndMetadata
  object OffsetAndMetadata {
    def apply() = new OffsetAndMetadata()
    def apply(json: JsonObject) = new OffsetAndMetadata(json)
  }



  type OffsetAndTimestamp = io.vertx.kafka.client.consumer.OffsetAndTimestamp
  object OffsetAndTimestamp {
    def apply() = new OffsetAndTimestamp()
    def apply(json: JsonObject) = new OffsetAndTimestamp(json)
  }



  type PartitionInfo = io.vertx.kafka.client.common.PartitionInfo
  object PartitionInfo {
    def apply() = new PartitionInfo()
    def apply(json: JsonObject) = new PartitionInfo(json)
  }



  type RecordMetadata = io.vertx.kafka.client.producer.RecordMetadata
  object RecordMetadata {
    def apply() = new RecordMetadata()
    def apply(json: JsonObject) = new RecordMetadata(json)
  }



  type TopicPartition = io.vertx.kafka.client.common.TopicPartition
  object TopicPartition {
    def apply() = new TopicPartition()
    def apply(json: JsonObject) = new TopicPartition(json)
  }



  type TopicPartitionInfo = io.vertx.kafka.client.common.TopicPartitionInfo
  object TopicPartitionInfo {
    def apply() = new TopicPartitionInfo()
    def apply(json: JsonObject) = new TopicPartitionInfo(json)
  }



}
