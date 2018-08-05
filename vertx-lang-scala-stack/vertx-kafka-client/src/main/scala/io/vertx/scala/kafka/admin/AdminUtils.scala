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

import io.vertx.kafka.admin.{AdminUtils => JAdminUtils}
import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Provides a wrapper around important methods in Kafka's AdminUtils, namely
  */

class AdminUtils(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Creates a new Kafka topic on all Brokers managed by the given Zookeeper instance(s)   * @param topicName Name of the to-be-created topic
   * @param partitionCount Number of partitions
   * @param replicationFactor Number of replicates. Must be lower or equal to the number of available Brokers
   * @param completionHandler vert.x callback
   */
  def createTopic (topicName: String, partitionCount: Int, replicationFactor: Int, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].createTopic(topicName.asInstanceOf[java.lang.String], partitionCount.asInstanceOf[java.lang.Integer], replicationFactor.asInstanceOf[java.lang.Integer], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Creates a new Kafka topic on all Brokers managed by the given Zookeeper instance(s). In contrast
   * to @see [[io.vertx.scala.kafka.admin.AdminUtils#createTopic]], one can pass in additional configuration
   * parameters as a map (String -> String).   * @param topicName Name of the to-be-created topic
   * @param partitionCount Number of partitions
   * @param replicationFactor Number of replicates. Must be lower or equal to the number of available Brokers
   * @param topicConfig map with additional topic configuration parameters
   * @param completionHandler vert.x callback
   */
  def createTopic (topicName: String, partitionCount: Int, replicationFactor: Int, topicConfig: scala.collection.mutable.Map[String, String], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].createTopic(topicName.asInstanceOf[java.lang.String], partitionCount.asInstanceOf[java.lang.Integer], replicationFactor.asInstanceOf[java.lang.Integer], topicConfig.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Delete the Kafka topic given by the topicName.   * @param topicName Name of the topic to be deleted
   * @param completionHandler vert.x callback
   */
  def deleteTopic (topicName: String, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].deleteTopic(topicName.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Checks if the Kafka topic given by topicName does exist.   * @param topicName Name of the topic
   * @param completionHandler vert.x callback
   */
  def topicExists (topicName: String, completionHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].topicExists(topicName.asInstanceOf[java.lang.String], {x: AsyncResult[java.lang.Boolean] => completionHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
   * Updates the configuration of the topic given by topicName. Configuration parameters
   * are passed in as a Map (Key -> Value) of Strings.   * @param topicName topic to be configured
   * @param topicConfig Map with configuration items
   * @param completionHandler vert.x callback
   */
  def changeTopicConfig (topicName: String, topicConfig: scala.collection.mutable.Map[String, String], completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].changeTopicConfig(topicName.asInstanceOf[java.lang.String], topicConfig.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Closes the underlying connection to Zookeeper. It is required to call the method for cleanup
   * purposes if AdminUtils was not created with autoClose set to true.   * @param completionHandler vert.x callback
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAdminUtils].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }


 /**
  * Like [[createTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createTopicFuture (topicName: String, partitionCount: Int, replicationFactor: Int): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAdminUtils].createTopic(topicName.asInstanceOf[java.lang.String], partitionCount.asInstanceOf[java.lang.Integer], replicationFactor.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[createTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def createTopicFuture (topicName: String, partitionCount: Int, replicationFactor: Int, topicConfig: scala.collection.mutable.Map[String, String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAdminUtils].createTopic(topicName.asInstanceOf[java.lang.String], partitionCount.asInstanceOf[java.lang.Integer], replicationFactor.asInstanceOf[java.lang.Integer], topicConfig.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[deleteTopic]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def deleteTopicFuture (topicName: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAdminUtils].deleteTopic(topicName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[topicExists]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def topicExistsFuture (topicName: String): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JAdminUtils].topicExists(topicName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[changeTopicConfig]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def changeTopicConfigFuture (topicName: String, topicConfig: scala.collection.mutable.Map[String, String]): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAdminUtils].changeTopicConfig(topicName.asInstanceOf[java.lang.String], topicConfig.mapValues(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAdminUtils].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AdminUtils {
  def apply(asJava: JAdminUtils) = new AdminUtils(asJava)
  
  /**
   * Create a new AdminUtils instance   * @param vertx Vert.x instance to use
   * @param zookeeperHosts comma-separated list of Zookeeper server, e.g. localhost:2181,localhost:2182
   * @return an instance of the AdminUtilWrapper
   */
  def create(vertx: Vertx,zookeeperHosts: String): AdminUtils = {
    AdminUtils(JAdminUtils.create(vertx.asJava.asInstanceOf[JVertx], zookeeperHosts.asInstanceOf[java.lang.String]))
  }

  /**
   * Create a new AdminUtils instance   * @param vertx Vert.x instance to use
   * @param zookeeperHosts comma-separated list of Zookeeper server, e.g. localhost:2181,localhost:2182
   * @param autoClose If set to true, the client will auto-close the connection after a command
   * @return an instance of the AdminUtilWrapper
   */
  def create(vertx: Vertx,zookeeperHosts: String,autoClose: Boolean): AdminUtils = {
    AdminUtils(JAdminUtils.create(vertx.asJava.asInstanceOf[JVertx], zookeeperHosts.asInstanceOf[java.lang.String], autoClose.asInstanceOf[java.lang.Boolean]))
  }

  /**
   * Create a new AdminUtils instance   * @param vertx Vert.x instance to use
   * @param zookeeperHosts comma-separated list of Zookeeper server, e.g. localhost:2181,localhost:2182
   * @param connectionTimeoutMs Maximum time in ms to wait for the client to connect to Zookeeper
   * @param isSecure If set to true, ZkUtils will perform security checks, i.e. ACL checks
   * @param autoClose If set to true, the client will auto-close the connection after a command
   * @return an instance of the AdminUtilWrapper
   */
  def create(vertx: Vertx,zookeeperHosts: String,connectionTimeoutMs: Int,isSecure: Boolean,autoClose: Boolean): AdminUtils = {
    AdminUtils(JAdminUtils.create(vertx.asJava.asInstanceOf[JVertx], zookeeperHosts.asInstanceOf[java.lang.String], connectionTimeoutMs.asInstanceOf[java.lang.Integer], isSecure.asInstanceOf[java.lang.Boolean], autoClose.asInstanceOf[java.lang.Boolean]))
  }

}
