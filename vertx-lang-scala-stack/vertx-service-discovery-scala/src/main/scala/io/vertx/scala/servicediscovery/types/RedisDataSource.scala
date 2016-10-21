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
import io.vertx.servicediscovery.types.DataSource
import io.vertx.core.json.JsonObject
import io.vertx.scala.redis.RedisClient
import io.vertx.servicediscovery.Record
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.Handler

/**
  * Service type for Redis data source.
  */
class RedisDataSource(private val _asJava: io.vertx.servicediscovery.types.RedisDataSource) {

  def asJava: io.vertx.servicediscovery.types.RedisDataSource = _asJava

}

object RedisDataSource {

  def apply(_asJava: io.vertx.servicediscovery.types.RedisDataSource): io.vertx.scala.servicediscovery.types.RedisDataSource =
    new io.vertx.scala.servicediscovery.types.RedisDataSource(_asJava)

  def createRecord(name: String, location: io.vertx.core.json.JsonObject, metadata: io.vertx.core.json.JsonObject): io.vertx.scala.servicediscovery.Record = {
    io.vertx.scala.servicediscovery.Record(io.vertx.servicediscovery.types.RedisDataSource.createRecord(name, location, metadata))
  }

  def getRedisClientFuture(discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.redis.RedisClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.redis.RedisClient,io.vertx.scala.redis.RedisClient]((x => if (x == null) null else RedisClient.apply(x)))
    io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], filter, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getRedisClientFuture(discovery: io.vertx.scala.servicediscovery.ServiceDiscovery, filter: io.vertx.core.json.JsonObject, consumerConfiguration: io.vertx.core.json.JsonObject): concurrent.Future[io.vertx.scala.redis.RedisClient] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.redis.RedisClient,io.vertx.scala.redis.RedisClient]((x => if (x == null) null else RedisClient.apply(x)))
    io.vertx.servicediscovery.types.RedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[io.vertx.servicediscovery.ServiceDiscovery], filter, consumerConfiguration, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}
