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

package io.vertx.scala.servicediscovery.types

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.servicediscovery.types.{RedisDataSource => JRedisDataSource}
import io.vertx.servicediscovery.types.{DataSource => JDataSource}
import io.vertx.core.json.JsonObject
import io.vertx.redis.{RedisClient => JRedisClient}
import io.vertx.scala.redis.RedisClient
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.scala.servicediscovery.Record
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.scala.servicediscovery.ServiceDiscovery

/**
  * Service type for Redis data source.
  */
class RedisDataSource(private val _asJava: JRedisDataSource) {

  def asJava: JRedisDataSource = _asJava

}

object RedisDataSource {

  def apply(_asJava: JRedisDataSource): RedisDataSource =
    new RedisDataSource(_asJava)

  def createRecord(name: String, location: JsonObject, metadata: JsonObject): Record = {
    Record(io.vertx.servicediscovery.types.RedisDataSource.createRecord(name, location, metadata))
  }

  def getRedisClientFuture(discovery: ServiceDiscovery, filter: JsonObject): concurrent.Future[RedisClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRedisClient,RedisClient]((x => if (x == null) null else RedisClient.apply(x)))
    io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getRedisClientFuture(discovery: ServiceDiscovery, filter: JsonObject, consumerConfiguration: JsonObject): concurrent.Future[RedisClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRedisClient,RedisClient]((x => if (x == null) null else RedisClient.apply(x)))
    io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery], filter, consumerConfiguration, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
