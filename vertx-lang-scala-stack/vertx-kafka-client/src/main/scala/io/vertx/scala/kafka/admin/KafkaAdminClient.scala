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
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.kafka.client.common.{TopicPartition => JTopicPartition}
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.kafka.admin.{ClusterDescription => JClusterDescription}
import io.vertx.kafka.admin.{KafkaAdminClient => JKafkaAdminClient}
import io.vertx.scala.kafka.client.common.TopicPartition
import io.vertx.lang.scala.HandlerOps._

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
   * Close the admin client
   */
  def close (): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].close()
  }

  /**
   * Describe the nodes in the cluster with the default options   * @param completionHandler handler called on operation completed with the cluster description
   */
  def describeCluster (completionHandler: Handler[AsyncResult[ClusterDescription]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].describeCluster((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[JClusterDescription]]{def handle(x: AsyncResult[JClusterDescription]) {completionHandler.handle(AsyncResultWrapper[JClusterDescription, ClusterDescription](x, a => ClusterDescription(a)))}}))
  }

  /**
   * Delete consumer groups from the cluster.   * @param groupIds the ids of the groups to delete
   * @param completionHandler handler called on operation completed
   */
  def deleteConsumerGroups (groupIds: scala.collection.mutable.Buffer[String], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].deleteConsumerGroups(groupIds.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Delete committed offsets for a set of partitions in a consumer group. This will
   * succeed at the partition level only if the group is not actively subscribed
   * to the corresponding topic.   * @param groupId The group id of the group whose offsets will be listed
   * @param partitions The set of partitions in the consumer group whose offsets will be deleted
   */
  def deleteConsumerGroupOffsets (groupId: String, partitions: scala.collection.mutable.Set[TopicPartition], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].deleteConsumerGroupOffsets(groupId.asInstanceOf[java.lang.String], partitions.map(x => x.asJava).asJava, (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Close the admin client   * @param completionHandler handler called on operation completed
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Close the admin client   * @param timeout timeout to wait for closing
   * @param completionHandler handler called on operation completed
   */
  def close (timeout: Long, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JKafkaAdminClient].close(timeout.asInstanceOf[java.lang.Long], (if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
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

 /**
  * Like [[describeCluster]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def describeClusterFuture (): scala.concurrent.Future[ClusterDescription] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JClusterDescription, ClusterDescription](x => ClusterDescription(x))
    asJava.asInstanceOf[JKafkaAdminClient].describeCluster(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteConsumerGroups]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteConsumerGroupsFuture (groupIds: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].deleteConsumerGroups(groupIds.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteConsumerGroupOffsets]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteConsumerGroupOffsetsFuture (groupId: String, partitions: scala.collection.mutable.Set[TopicPartition]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].deleteConsumerGroupOffsets(groupId.asInstanceOf[java.lang.String], partitions.map(x => x.asJava).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (timeout: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JKafkaAdminClient].close(timeout.asInstanceOf[java.lang.Long], promiseAndHandler._1)
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
