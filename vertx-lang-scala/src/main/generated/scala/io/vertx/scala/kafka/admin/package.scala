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
  }



  type Config = io.vertx.kafka.admin.Config
  object Config {
    def apply() = new Config()
    def apply(json: JsonObject) = new Config(json)
  }



  type ConfigEntry = io.vertx.kafka.admin.ConfigEntry
  object ConfigEntry {
    def apply() = new ConfigEntry()
    def apply(json: JsonObject) = new ConfigEntry(json)
  }



  type ConfigSynonym = io.vertx.kafka.admin.ConfigSynonym
  object ConfigSynonym {
    def apply() = new ConfigSynonym()
    def apply(json: JsonObject) = new ConfigSynonym(json)
  }



  type ConsumerGroupDescription = io.vertx.kafka.admin.ConsumerGroupDescription
  object ConsumerGroupDescription {
    def apply() = new ConsumerGroupDescription()
    def apply(json: JsonObject) = new ConsumerGroupDescription(json)
  }



  type ConsumerGroupListing = io.vertx.kafka.admin.ConsumerGroupListing
  object ConsumerGroupListing {
    def apply() = new ConsumerGroupListing()
    def apply(json: JsonObject) = new ConsumerGroupListing(json)
  }



  type ListConsumerGroupOffsetsOptions = io.vertx.kafka.admin.ListConsumerGroupOffsetsOptions
  object ListConsumerGroupOffsetsOptions {
    def apply() = new ListConsumerGroupOffsetsOptions()
    def apply(json: JsonObject) = new ListConsumerGroupOffsetsOptions(json)
  }



  type ListOffsetsResultInfo = io.vertx.kafka.admin.ListOffsetsResultInfo
  object ListOffsetsResultInfo {
    def apply(json: JsonObject) = new ListOffsetsResultInfo(json)
  }



  type MemberAssignment = io.vertx.kafka.admin.MemberAssignment
  object MemberAssignment {
    def apply() = new MemberAssignment()
    def apply(json: JsonObject) = new MemberAssignment(json)
  }



  type MemberDescription = io.vertx.kafka.admin.MemberDescription
  object MemberDescription {
    def apply() = new MemberDescription()
    def apply(json: JsonObject) = new MemberDescription(json)
  }



  type NewTopic = io.vertx.kafka.admin.NewTopic
  object NewTopic {
    def apply() = new NewTopic()
    def apply(json: JsonObject) = new NewTopic(json)
  }



  type OffsetSpec = io.vertx.kafka.admin.OffsetSpec
  object OffsetSpec {
    def apply(json: JsonObject) = new OffsetSpec(json)
  }



  type TopicDescription = io.vertx.kafka.admin.TopicDescription
  object TopicDescription {
    def apply() = new TopicDescription()
    def apply(json: JsonObject) = new TopicDescription(json)
  }



}
