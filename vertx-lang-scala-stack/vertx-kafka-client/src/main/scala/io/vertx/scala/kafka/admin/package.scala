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

import io.vertx.core
import io.vertx.kafka.admin.{ConsumerGroupListing => JConsumerGroupListing}
import io.vertx.kafka.admin.{NewTopic => JNewTopic}
import io.vertx.kafka.admin.{ConsumerGroupDescription => JConsumerGroupDescription}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
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
     * Like [[listTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listTopicsFuture(): scala.concurrent.Future[java.util.Set[java.lang.String]] = {
      val promise = Promise[java.util.Set[java.lang.String]]()
      asJava.listTopics({a:AsyncResult[java.util.Set[java.lang.String]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[describeTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def describeTopicsFuture(topicNames: java.util.List[java.lang.String]): scala.concurrent.Future[java.util.Map[String, io.vertx.kafka.admin.TopicDescription]] = {
      val promise = Promise[java.util.Map[String, io.vertx.kafka.admin.TopicDescription]]()
      asJava.describeTopics(topicNames, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.TopicDescription]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[createTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def createTopicsFuture(topics: java.util.List[io.vertx.kafka.admin.NewTopic]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.createTopics(topics, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deleteTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def deleteTopicsFuture(topicNames: java.util.List[java.lang.String]): scala.concurrent.Future[Unit] = {
      val promise = Promise[Unit]()
      asJava.deleteTopics(topicNames, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[listConsumerGroups]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def listConsumerGroupsFuture(): scala.concurrent.Future[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]] = {
      val promise = Promise[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]]()
      asJava.listConsumerGroups({a:AsyncResult[java.util.List[io.vertx.kafka.admin.ConsumerGroupListing]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[describeConsumerGroups]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def describeConsumerGroupsFuture(groupIds: java.util.List[java.lang.String]): scala.concurrent.Future[java.util.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]] = {
      val promise = Promise[java.util.Map[String, io.vertx.kafka.admin.ConsumerGroupDescription]]()
      asJava.describeConsumerGroups(groupIds, {a:AsyncResult[java.util.Map[java.lang.String,io.vertx.kafka.admin.ConsumerGroupDescription]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
