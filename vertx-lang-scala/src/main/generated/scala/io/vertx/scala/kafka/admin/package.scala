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

import io.vertx.kafka.admin.{MemberAssignment => JMemberAssignment}
import io.vertx.kafka.client.common
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
package object admin{


  type ClusterDescription = io.vertx.kafka.admin.ClusterDescription
  object ClusterDescription {
    def apply() = new ClusterDescription()
    def apply(json: JsonObject) = new ClusterDescription(json)
    def apply( clusterId: java.lang.String = null, controller: io.vertx.kafka.client.common.Node = null, nodes: scala.collection.immutable.List[io.vertx.kafka.client.common.Node] = null): ClusterDescription = {
      val ret = new ClusterDescription(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (clusterId != null) ret.setClusterId(clusterId) 
      if (controller != null) ret.setController(controller) 
      if (nodes != null) ret.setNodes(nodes.asJava) 
      ret
    }
  }



  type Config = io.vertx.kafka.admin.Config
  object Config {
    def apply() = new Config()
    def apply(json: JsonObject) = new Config(json)
    def apply( entries: scala.collection.immutable.List[io.vertx.kafka.admin.ConfigEntry] = null): Config = {
      val ret = new Config(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (entries != null) ret.setEntries(entries.asJava) 
      ret
    }
  }



  type ConfigEntry = io.vertx.kafka.admin.ConfigEntry
  object ConfigEntry {
    def apply() = new ConfigEntry()
    def apply(json: JsonObject) = new ConfigEntry(json)
    def apply( default: java.lang.Boolean = null, name: java.lang.String = null, readOnly: java.lang.Boolean = null, sensitive: java.lang.Boolean = null, source: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource = null, synonyms: scala.collection.immutable.List[io.vertx.kafka.admin.ConfigSynonym] = null, value: java.lang.String = null): ConfigEntry = {
      val ret = new ConfigEntry(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (default != null) ret.setDefault(default) 
      if (name != null) ret.setName(name) 
      if (readOnly != null) ret.setReadOnly(readOnly) 
      if (sensitive != null) ret.setSensitive(sensitive) 
      if (source != null) ret.setSource(source) 
      if (synonyms != null) ret.setSynonyms(synonyms.asJava) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type ConfigSynonym = io.vertx.kafka.admin.ConfigSynonym
  object ConfigSynonym {
    def apply() = new ConfigSynonym()
    def apply(json: JsonObject) = new ConfigSynonym(json)
    def apply( name: java.lang.String = null, source: org.apache.kafka.clients.admin.ConfigEntry.ConfigSource = null, value: java.lang.String = null): ConfigSynonym = {
      val ret = new ConfigSynonym(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (name != null) ret.setName(name) 
      if (source != null) ret.setSource(source) 
      if (value != null) ret.setValue(value) 
      ret
    }
  }



  type ConsumerGroupDescription = io.vertx.kafka.admin.ConsumerGroupDescription
  object ConsumerGroupDescription {
    def apply() = new ConsumerGroupDescription()
    def apply(json: JsonObject) = new ConsumerGroupDescription(json)
    def apply( coordinator: io.vertx.kafka.client.common.Node = null, groupId: java.lang.String = null, members: scala.collection.immutable.List[io.vertx.kafka.admin.MemberDescription] = null, partitionAssignor: java.lang.String = null, simpleConsumerGroup: java.lang.Boolean = null, state: org.apache.kafka.common.ConsumerGroupState = null): ConsumerGroupDescription = {
      val ret = new ConsumerGroupDescription(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (coordinator != null) ret.setCoordinator(coordinator) 
      if (groupId != null) ret.setGroupId(groupId) 
      if (members != null) ret.setMembers(members.asJava) 
      if (partitionAssignor != null) ret.setPartitionAssignor(partitionAssignor) 
      if (simpleConsumerGroup != null) ret.setSimpleConsumerGroup(simpleConsumerGroup) 
      if (state != null) ret.setState(state) 
      ret
    }
  }



  type ConsumerGroupListing = io.vertx.kafka.admin.ConsumerGroupListing
  object ConsumerGroupListing {
    def apply() = new ConsumerGroupListing()
    def apply(json: JsonObject) = new ConsumerGroupListing(json)
    def apply( groupId: java.lang.String = null, simpleConsumerGroup: java.lang.Boolean = null): ConsumerGroupListing = {
      val ret = new ConsumerGroupListing(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (groupId != null) ret.setGroupId(groupId) 
      if (simpleConsumerGroup != null) ret.setSimpleConsumerGroup(simpleConsumerGroup) 
      ret
    }
  }



  type ListConsumerGroupOffsetsOptions = io.vertx.kafka.admin.ListConsumerGroupOffsetsOptions
  object ListConsumerGroupOffsetsOptions {
    def apply() = new ListConsumerGroupOffsetsOptions()
    def apply(json: JsonObject) = new ListConsumerGroupOffsetsOptions(json)

  }



  type ListOffsetsResultInfo = io.vertx.kafka.admin.ListOffsetsResultInfo
  object ListOffsetsResultInfo {
    def apply(json: JsonObject) = new ListOffsetsResultInfo(json)
    def apply( leaderEpoch: java.lang.Integer = null, offset: java.lang.Long = null, timestamp: java.lang.Long = null): ListOffsetsResultInfo = {
      val ret = new ListOffsetsResultInfo(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (leaderEpoch != null) ret.setLeaderEpoch(leaderEpoch) 
      if (offset != null) ret.setOffset(offset) 
      if (timestamp != null) ret.setTimestamp(timestamp) 
      ret
    }
  }



  type MemberAssignment = io.vertx.kafka.admin.MemberAssignment
  object MemberAssignment {
    def apply() = new MemberAssignment()
    def apply(json: JsonObject) = new MemberAssignment(json)
    def apply( topicPartitions: scala.collection.immutable.Set[io.vertx.kafka.client.common.TopicPartition] = null): MemberAssignment = {
      val ret = new MemberAssignment(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (topicPartitions != null) ret.setTopicPartitions(topicPartitions.asJava) 
      ret
    }
  }



  type MemberDescription = io.vertx.kafka.admin.MemberDescription
  object MemberDescription {
    def apply() = new MemberDescription()
    def apply(json: JsonObject) = new MemberDescription(json)
    def apply( assignment: io.vertx.kafka.admin.MemberAssignment = null, clientId: java.lang.String = null, consumerId: java.lang.String = null, host: java.lang.String = null): MemberDescription = {
      val ret = new MemberDescription(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (assignment != null) ret.setAssignment(assignment) 
      if (clientId != null) ret.setClientId(clientId) 
      if (consumerId != null) ret.setConsumerId(consumerId) 
      if (host != null) ret.setHost(host) 
      ret
    }
  }



  type NewTopic = io.vertx.kafka.admin.NewTopic
  object NewTopic {
    def apply() = new NewTopic()
    def apply(json: JsonObject) = new NewTopic(json)
    def apply( config: scala.collection.immutable.Map[String,java.lang.String] = null, name: java.lang.String = null, numPartitions: java.lang.Integer = null, replicationFactor: java.lang.Short = null): NewTopic = {
      val ret = new NewTopic(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (config != null) ret.setConfig(config.asJava) 
      if (name != null) ret.setName(name) 
      if (numPartitions != null) ret.setNumPartitions(numPartitions) 
      if (replicationFactor != null) ret.setReplicationFactor(replicationFactor) 
      ret
    }
  }



  type OffsetSpec = io.vertx.kafka.admin.OffsetSpec
  object OffsetSpec {
    def apply(json: JsonObject) = new OffsetSpec(json)
    def apply( spec: java.lang.Long = null): OffsetSpec = {
      val ret = new OffsetSpec(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (spec != null) ret.setSpec(spec) 
      ret
    }
  }



  type TopicDescription = io.vertx.kafka.admin.TopicDescription
  object TopicDescription {
    def apply() = new TopicDescription()
    def apply(json: JsonObject) = new TopicDescription(json)
    def apply( internal: java.lang.Boolean = null, name: java.lang.String = null, partitions: scala.collection.immutable.List[io.vertx.kafka.client.common.TopicPartitionInfo] = null): TopicDescription = {
      val ret = new TopicDescription(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (internal != null) ret.setInternal(internal) 
      if (name != null) ret.setName(name) 
      if (partitions != null) ret.setPartitions(partitions.asJava) 
      ret
    }
  }



}
