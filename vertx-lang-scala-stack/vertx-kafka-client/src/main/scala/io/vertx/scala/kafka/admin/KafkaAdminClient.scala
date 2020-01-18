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

package io.vertx.scala.kafka.admin

import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.kafka.admin.{ConsumerGroupListing => JConsumerGroupListing}
import io.vertx.kafka.admin.{NewTopic => JNewTopic}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.kafka.admin.{KafkaAdminClient => JKafkaAdminClient}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Vert.x Kafka Admin client implementation

  */

class KafkaAdminClient(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * List the topics available in the cluster with the default options.   * @param completionHandler handler called on operation completed with the topics set
   */
  def listTopics (completionHandler: Handler[AsyncResult[scala.collection.mutable.Set[String]]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].listTopics((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.Set[java.lang.String]]]{def handle(x: AsyncResult[java.util.Set[java.lang.String]]) {completionHandler.handle(AsyncResultWrapper[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x, a => a.asScala.map(x => x.asInstanceOf[String])))}}))
  }

  /**
   * Creates a batch of new Kafka topics   * @param topics topics to create
   * @param completionHandler handler called on operation completed
   */
  def createTopics (topics: scala.collection.mutable.Buffer[NewTopic], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].createTopics(topics.map(x => x.asJava).asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Deletes a batch of Kafka topics   * @param topicNames the names of the topics to delete
   * @param completionHandler handler called on operation completed
   */
  def deleteTopics (topicNames: scala.collection.mutable.Buffer[String], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].deleteTopics(topicNames.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Get the the consumer groups available in the cluster with the default options   * @param completionHandler handler called on operation completed with the consumer groups ids
   */
  def listConsumerGroups (completionHandler: Handler[AsyncResult[scala.collection.mutable.Buffer[ConsumerGroupListing]]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].listConsumerGroups((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[JConsumerGroupListing]]]{def handle(x: AsyncResult[java.util.List[JConsumerGroupListing]]) {completionHandler.handle(AsyncResultWrapper[java.util.List[JConsumerGroupListing], scala.collection.mutable.Buffer[ConsumerGroupListing]](x, a => a.asScala.map(x => ConsumerGroupListing(x))))}}))
  }


 /**
  * Like [[listTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listTopicsFuture (): scala.concurrent.Future[scala.collection.mutable.Set[String]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.Set[java.lang.String], scala.collection.mutable.Set[String]](x => x.asScala.map(x => x.asInstanceOf[String]))
    asJava.asInstanceOf[JKafkaAdminClient].listTopics(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createTopicsFuture (topics: scala.collection.mutable.Buffer[NewTopic]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].createTopics(topics.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteTopics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteTopicsFuture (topicNames: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].deleteTopics(topicNames.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[listConsumerGroups]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def listConsumerGroupsFuture (): scala.concurrent.Future[scala.collection.mutable.Buffer[ConsumerGroupListing]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[JConsumerGroupListing], scala.collection.mutable.Buffer[ConsumerGroupListing]](x => x.asScala.map(x => ConsumerGroupListing(x)))
    asJava.asInstanceOf[JKafkaAdminClient].listConsumerGroups(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object KafkaAdminClient {
  def apply(asJava: JKafkaAdminClient) = new KafkaAdminClient(asJava)

  /**
   * Create a new KafkaAdminClient instance   * @param vertx Vert.x instance to use
   * @param config Kafka admin client configuration
   * @return an instance of the KafkaAdminClient
   */
  def create(vertx: Vertx,config: scala.collection.mutable.Map[String, String]): KafkaAdminClient = {
    KafkaAdminClient(JKafkaAdminClient.create(vertx.asJava.asInstanceOf[JVertx], config.mapValues(x => x.asInstanceOf[java.lang.String]).asJava))//2 create
  }

}
