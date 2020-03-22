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
import io.vertx.core.{Future => JFuture}
import io.vertx.kafka.admin.{ConsumerGroupListing => JConsumerGroupListing}
import io.vertx.kafka.admin.{NewTopic => JNewTopic}
import io.vertx.kafka.admin.{ConsumerGroupDescription => JConsumerGroupDescription}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.admin.{KafkaAdminClient => JKafkaAdminClient}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.kafka.admin.{TopicDescription => JTopicDescription}

package object admin{


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
     */def listTopicsFuture() : scala.concurrent.Future[scala.collection.mutable.Set[java.lang.String]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Set[java.lang.String]]()
      asJava.listTopics(new Handler[AsyncResult[java.util.Set[java.lang.String]]] { override def handle(event: AsyncResult[java.util.Set[java.lang.String]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like describeTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def describeTopicsFuture(topicNames: java.util.List[java.lang.String]) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.kafka.admin.TopicDescription]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.kafka.admin.TopicDescription]]()
      asJava.describeTopics(topicNames, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like createTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def createTopicsFuture(topics: java.util.List[io.vertx.kafka.admin.NewTopic]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.createTopics(topics, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like deleteTopics from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def deleteTopicsFuture(topicNames: java.util.List[java.lang.String]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.deleteTopics(topicNames, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like listConsumerGroups from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def listConsumerGroupsFuture() : scala.concurrent.Future[scala.collection.mutable.Buffer[io.vertx.kafka.admin.ConsumerGroupListing]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[io.vertx.kafka.admin.ConsumerGroupListing]]()
      asJava.listConsumerGroups(new Handler[AsyncResult[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]]] { override def handle(event: AsyncResult[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

    /**
     * Like describeConsumerGroups from [[io.vertx.kafka.admin.KafkaAdminClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def describeConsumerGroupsFuture(groupIds: java.util.List[java.lang.String]) : scala.concurrent.Future[scala.collection.mutable.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]]()
      asJava.describeConsumerGroups(groupIds, new Handler[AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription]]] { override def handle(event: AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}

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
