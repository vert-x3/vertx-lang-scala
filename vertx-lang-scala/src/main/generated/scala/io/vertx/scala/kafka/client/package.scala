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

import scala.collection.JavaConverters._
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
    def apply( default: java.lang.Boolean = null, name: java.lang.String = null, `type`: org.apache.kafka.common.config.ConfigResource.Type = null): ConfigResource = {
      val ret = new ConfigResource(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (default != null) ret.setDefault(default) 
      if (name != null) ret.setName(name) 
      if (`type` != null) ret.setType(`type`) 
      ret
    }
  }



  type KafkaClientOptions = io.vertx.kafka.client.common.KafkaClientOptions
  object KafkaClientOptions {
    def apply() = new KafkaClientOptions()
    def apply(json: JsonObject) = new KafkaClientOptions(json)
    def apply( config: scala.collection.immutable.Map[String,java.lang.Object] = null, tracePeerAddress: java.lang.String = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null): KafkaClientOptions = {
      val ret = new KafkaClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (config != null) ret.setConfig(config.asJava) 
      if (tracePeerAddress != null) ret.setTracePeerAddress(tracePeerAddress) 
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      ret
    }
  }



  type Node = io.vertx.kafka.client.common.Node
  object Node {
    def apply() = new Node()
    def apply(json: JsonObject) = new Node(json)
    def apply( empty: java.lang.Boolean = null, hasRack: java.lang.Boolean = null, host: java.lang.String = null, id: java.lang.Integer = null, idString: java.lang.String = null, isEmpty: java.lang.Boolean = null, port: java.lang.Integer = null, rack: java.lang.String = null): Node = {
      val ret = new Node(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (hasRack != null) ret.setHasRack(hasRack) 
      if (host != null) ret.setHost(host) 
      if (id != null) ret.setId(id) 
      if (idString != null) ret.setIdString(idString) 
      if (isEmpty != null) ret.setIsEmpty(isEmpty) 
      if (port != null) ret.setPort(port) 
      if (rack != null) ret.setRack(rack) 
      ret
    }
  }



  type OffsetAndMetadata = io.vertx.kafka.client.consumer.OffsetAndMetadata
  object OffsetAndMetadata {
    def apply() = new OffsetAndMetadata()
    def apply(json: JsonObject) = new OffsetAndMetadata(json)
    def apply( metadata: java.lang.String = null, offset: java.lang.Long = null): OffsetAndMetadata = {
      val ret = new OffsetAndMetadata(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (metadata != null) ret.setMetadata(metadata) 
      if (offset != null) ret.setOffset(offset) 
      ret
    }
  }



  type OffsetAndTimestamp = io.vertx.kafka.client.consumer.OffsetAndTimestamp
  object OffsetAndTimestamp {
    def apply() = new OffsetAndTimestamp()
    def apply(json: JsonObject) = new OffsetAndTimestamp(json)
    def apply( offset: java.lang.Long = null, timestamp: java.lang.Long = null): OffsetAndTimestamp = {
      val ret = new OffsetAndTimestamp(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (offset != null) ret.setOffset(offset) 
      if (timestamp != null) ret.setTimestamp(timestamp) 
      ret
    }
  }



  type PartitionInfo = io.vertx.kafka.client.common.PartitionInfo
  object PartitionInfo {
    def apply() = new PartitionInfo()
    def apply(json: JsonObject) = new PartitionInfo(json)
    def apply( inSyncReplicas: scala.collection.immutable.List[io.vertx.kafka.client.common.Node] = null, leader: io.vertx.kafka.client.common.Node = null, partition: java.lang.Integer = null, replicas: scala.collection.immutable.List[io.vertx.kafka.client.common.Node] = null, topic: java.lang.String = null): PartitionInfo = {
      val ret = new PartitionInfo(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (inSyncReplicas != null) ret.setInSyncReplicas(inSyncReplicas.asJava) 
      if (leader != null) ret.setLeader(leader) 
      if (partition != null) ret.setPartition(partition) 
      if (replicas != null) ret.setReplicas(replicas.asJava) 
      if (topic != null) ret.setTopic(topic) 
      ret
    }
  }



  type RecordMetadata = io.vertx.kafka.client.producer.RecordMetadata
  object RecordMetadata {
    def apply() = new RecordMetadata()
    def apply(json: JsonObject) = new RecordMetadata(json)
    def apply( checksum: java.lang.Long = null, offset: java.lang.Long = null, partition: java.lang.Integer = null, timestamp: java.lang.Long = null, topic: java.lang.String = null): RecordMetadata = {
      val ret = new RecordMetadata(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (checksum != null) ret.setChecksum(checksum) 
      if (offset != null) ret.setOffset(offset) 
      if (partition != null) ret.setPartition(partition) 
      if (timestamp != null) ret.setTimestamp(timestamp) 
      if (topic != null) ret.setTopic(topic) 
      ret
    }
  }



  type TopicPartition = io.vertx.kafka.client.common.TopicPartition
  object TopicPartition {
    def apply() = new TopicPartition()
    def apply(json: JsonObject) = new TopicPartition(json)
    def apply( partition: java.lang.Integer = null, topic: java.lang.String = null): TopicPartition = {
      val ret = new TopicPartition(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (partition != null) ret.setPartition(partition) 
      if (topic != null) ret.setTopic(topic) 
      ret
    }
  }



  type TopicPartitionInfo = io.vertx.kafka.client.common.TopicPartitionInfo
  object TopicPartitionInfo {
    def apply() = new TopicPartitionInfo()
    def apply(json: JsonObject) = new TopicPartitionInfo(json)
    def apply( isr: scala.collection.immutable.List[io.vertx.kafka.client.common.Node] = null, leader: io.vertx.kafka.client.common.Node = null, partition: java.lang.Integer = null, replicas: scala.collection.immutable.List[io.vertx.kafka.client.common.Node] = null): TopicPartitionInfo = {
      val ret = new TopicPartitionInfo(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (isr != null) ret.setIsr(isr.asJava) 
      if (leader != null) ret.setLeader(leader) 
      if (partition != null) ret.setPartition(partition) 
      if (replicas != null) ret.setReplicas(replicas.asJava) 
      ret
    }
  }



}
