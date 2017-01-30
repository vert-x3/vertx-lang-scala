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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.servicediscovery.{Record => JRecord}
import io.vertx.servicediscovery.{ServiceDiscovery => JServiceDiscovery}
import io.vertx.servicediscovery.types.{RedisDataSource => JRedisDataSource}
import io.vertx.redis.{RedisClient => JRedisClient}
import io.vertx.scala.servicediscovery.ServiceDiscovery
import io.vertx.core.json.JsonObject
import io.vertx.scala.redis.RedisClient
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.scala.servicediscovery.Record

/**
  * Service type for Redis data source.
  */
class RedisDataSource(private val _asJava: Object) {

  def asJava = _asJava

}

object RedisDataSource{
  def apply(asJava: JRedisDataSource) = new RedisDataSource(asJava)  
  /**
    * Convenient method to create a record for a Redis data source.
    * @param name the service name
    * @param location the location of the service (e.g. url, port...)
    * @param metadata additional metadata
    * @return the created recordsee <a href="../../../../../../../cheatsheet/Record.html">Record</a>
    */
  def createRecord(name: String,location: io.vertx.core.json.JsonObject,metadata: io.vertx.core.json.JsonObject): Record = {
    Record(JRedisDataSource.createRecord(name.asInstanceOf[java.lang.String],location,metadata))
  }

  /**
    * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.scala.redis.RedisClient]].
    * The async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    */
  def getRedisClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[RedisClient]]): Unit = {
    JRedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,{x: AsyncResult[JRedisClient] => resultHandler.handle(AsyncResultWrapper[JRedisClient,RedisClient](x, a => RedisClient(a)))})
  }

  /**
    * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.scala.redis.RedisClient]].
    * The async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, cannot be `null`
    */
  def getRedisClient(discovery: ServiceDiscovery,filter: Record => Boolean,resultHandler: Handler[AsyncResult[RedisClient]]): Unit = {
    JRedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},{x: AsyncResult[JRedisClient] => resultHandler.handle(AsyncResultWrapper[JRedisClient,RedisClient](x, a => RedisClient(a)))})
  }

  /**
    * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.scala.redis.RedisClient]].
    * The async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, optional
    * @param consumerConfiguration The additional consumer configuration
    */
  def getRedisClient(discovery: ServiceDiscovery,filter: io.vertx.core.json.JsonObject,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[RedisClient]]): Unit = {
    JRedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery],filter,consumerConfiguration,{x: AsyncResult[JRedisClient] => resultHandler.handle(AsyncResultWrapper[JRedisClient,RedisClient](x, a => RedisClient(a)))})
  }

  /**
    * Convenient method that looks for a Redis data source and provides the configured [[io.vertx.scala.redis.RedisClient]].
    * The async result is marked as failed is there are no matching services, or if the lookup fails.
    * @param discovery The service discovery instance
    * @param filter The filter, cannot be `null`
    * @param consumerConfiguration The additional consumer configuration
    */
  def getRedisClient(discovery: ServiceDiscovery,filter: Record => Boolean,consumerConfiguration: io.vertx.core.json.JsonObject,resultHandler: Handler[AsyncResult[RedisClient]]): Unit = {
    JRedisDataSource.getRedisClient(discovery.asJava.asInstanceOf[JServiceDiscovery],{x: JRecord => filter(Record(x)).asInstanceOf[java.lang.Boolean]},consumerConfiguration,{x: AsyncResult[JRedisClient] => resultHandler.handle(AsyncResultWrapper[JRedisClient,RedisClient](x, a => RedisClient(a)))})
  }

}
