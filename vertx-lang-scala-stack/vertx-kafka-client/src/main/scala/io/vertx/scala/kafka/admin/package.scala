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

import io.vertx.core
import io.vertx.kafka.admin.{ConsumerGroupListing => JConsumerGroupListing}
import io.vertx.kafka.admin.{NewTopic => JNewTopic}
import io.vertx.kafka.client.common
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.core.{Future => JFuture}
import io.vertx.kafka.admin.{ConsumerGroupDescription => JConsumerGroupDescription}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.admin.{ClusterDescription => JClusterDescription}
import io.vertx.kafka.admin.{KafkaAdminClient => JKafkaAdminClient}
import io.vertx.kafka.admin.{TopicDescription => JTopicDescription}
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




  /**
    * Vert.x Kafka Admin client implementation

    */

  implicit class KafkaAdminClientScala(val asJava: io.vertx.kafka.admin.KafkaAdminClient) extends AnyVal {


    /**
     * Like listTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listTopicsFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]/*java.util.Set[java.lang.String] SET*/()
      asJava.listTopics(new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like describeTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def describeTopicsFuture(topicNames: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.kafka.admin.TopicDescription]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.kafka.admin.TopicDescription]]/*java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription] MAP*/()
      asJava.describeTopics(topicNames.asJava, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like createTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def createTopicsFuture(topics: scala.collection.mutable.Buffer[io.vertx.kafka.admin.NewTopic]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.createTopics(topics.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deleteTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteTopicsFuture(topicNames: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.deleteTopics(topicNames.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like listConsumerGroups from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def listConsumerGroupsFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.kafka.admin.ConsumerGroupListing]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.kafka.admin.ConsumerGroupListing]]/*java.util.List[io.vertx.kafka.admin.ConsumerGroupListing] LIST*/()
      asJava.listConsumerGroups(new Handler[AsyncResult[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like describeConsumerGroups from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def describeConsumerGroupsFuture(groupIds: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]]/*java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription] MAP*/()
      asJava.describeConsumerGroups(groupIds.asJava, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
  }

    /**
     * Like describeCluster from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def describeClusterFuture() : scala.concurrent.Future[io.vertx.kafka.admin.ClusterDescription] = {
      val promise = concurrent.Promise[io.vertx.kafka.admin.ClusterDescription]/*io.vertx.kafka.admin.ClusterDescription OTHER*/()
      asJava.describeCluster(new Handler[AsyncResult[io.vertx.kafka.admin.ClusterDescription]] { override def handle(event: AsyncResult[io.vertx.kafka.admin.ClusterDescription]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deleteConsumerGroups from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteConsumerGroupsFuture(groupIds: scala.collection.mutable.Buffer[java.lang.String]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.deleteConsumerGroups(groupIds.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like deleteConsumerGroupOffsets from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def deleteConsumerGroupOffsetsFuture(groupId: java.lang.String, partitions: scala.collection.mutable.Set[io.vertx.kafka.client.common.TopicPartition]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.deleteConsumerGroupOffsets(groupId, partitions.asJava, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type ListConsumerGroupOffsetsOptions = io.vertx.kafka.admin.ListConsumerGroupOffsetsOptions
  object ListConsumerGroupOffsetsOptions {
    def apply() = new ListConsumerGroupOffsetsOptions()
    def apply(json: JsonObject) = new ListConsumerGroupOffsetsOptions(json)
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



  type TopicDescription = io.vertx.kafka.admin.TopicDescription
  object TopicDescription {
    def apply() = new TopicDescription()
    def apply(json: JsonObject) = new TopicDescription(json)
  }



}
