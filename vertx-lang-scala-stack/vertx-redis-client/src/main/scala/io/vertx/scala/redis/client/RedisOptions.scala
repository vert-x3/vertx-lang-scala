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

package io.vertx.scala.redis.client

import io.vertx.redis.client.{RedisOptions => JRedisOptions}
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.scala.core.net.NetClientOptions
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Redis Client Configuration options.
 */

class RedisOptions(private val _asJava: JRedisOptions) {
  def asJava = _asJava
  /**
   * Sets a single connection string (endpoint) to use while connecting to the redis server.
   * Will replace the previously configured connection strings.
   * 
   * Does not support rediss (redis over ssl scheme) for now.
   */
  def setConnectionString(value: String) = {
    asJava.setConnectionString(value)
    this
  }

  /**
   * Adds a connection string (endpoint) to use while connecting to the redis server. Only the cluster mode will
   * consider more than 1 element. If more are provided, they are not considered by the client when in single server mode.
   * 
   * Does not support rediss (redis over ssl scheme) for now.
   */
  def addConnectionString(value: String) = {
    asJava.addConnectionString(value)
    this
  }

  /**
   * Sets a single connection string to use while connecting to the redis server.
   * Will replace the previously configured connection strings.
   */
  def setEndpoint(value: String) = {
    asJava.setEndpoint(value)
    this
  }

  def getEndpoint: String = {
    asJava.getEndpoint().asInstanceOf[String]
  }

  /**
   * Set the endpoints to use while connecting to the redis server. Only the cluster mode will consider more than
   * 1 element. If more are provided, they are not considered by the client when in single server mode.
   */
  def addEndpoint(value: String) = {
    asJava.addEndpoint(value)
    this
  }

  def setEndpoints(value: scala.collection.mutable.Buffer[String]) = {
    asJava.setEndpoints(value.asJava)
    this
  }

  def getEndpoints: scala.collection.mutable.Buffer[String] = {
    asJava.getEndpoints().asScala.map(x => x.asInstanceOf[String])
  }

  /**
   * Set the master name (only considered in HA mode).
   */
  def setMasterName(value: String) = {
    asJava.setMasterName(value)
    this
  }

  def getMasterName: String = {
    asJava.getMasterName().asInstanceOf[String]
  }

  /**
   * Tune how much nested arrays are allowed on a redis response. This affects the parser performance.
   */
  def setMaxNestedArrays(value: Int) = {
    asJava.setMaxNestedArrays(value)
    this
  }

  def getMaxNestedArrays: Int = {
    asJava.getMaxNestedArrays().asInstanceOf[Int]
  }

  /**
   * Tune the maximum size of the connection pool. When working with cluster or sentinel
   * this value should be atleast the total number of cluster member (or number of sentinels + 1)
   */
  def setMaxPoolSize(value: Int) = {
    asJava.setMaxPoolSize(value)
    this
  }

  def getMaxPoolSize: Int = {
    asJava.getMaxPoolSize().asInstanceOf[Int]
  }

  /**
   * Tune the maximum waiting requests for a connection from the pool.
   */
  def setMaxPoolWaiting(value: Int) = {
    asJava.setMaxPoolWaiting(value)
    this
  }

  def getMaxPoolWaiting: Int = {
    asJava.getMaxPoolWaiting().asInstanceOf[Int]
  }

  /**
   * The client will always work on pipeline mode, this means that messages can start queueing. You can control how much
   * backlog you're willing to accept. This methods sets how much handlers is the client willing to queue.
   */
  def setMaxWaitingHandlers(value: Int) = {
    asJava.setMaxWaitingHandlers(value)
    this
  }

  def getMaxWaitingHandlers: Int = {
    asJava.getMaxWaitingHandlers().asInstanceOf[Int]
  }

  /**
   * Set the net client options to be used while connecting to the redis server. Use this to tune your connection.
   */
  def setNetClientOptions(value: NetClientOptions) = {
    asJava.setNetClientOptions(value.asJava)
    this
  }

  def getNetClientOptions: NetClientOptions = {
    NetClientOptions(asJava.getNetClientOptions())
  }

  /**
   * Tune how often in milliseconds should the connection pool cleaner execute.
   */
  def setPoolCleanerInterval(value: Int) = {
    asJava.setPoolCleanerInterval(value)
    this
  }

  def getPoolCleanerInterval: Int = {
    asJava.getPoolCleanerInterval().asInstanceOf[Int]
  }

  /**
   * Tune when a connection should be recycled in milliseconds.
   */
  def setPoolRecycleTimeout(value: Int) = {
    asJava.setPoolRecycleTimeout(value)
    this
  }

  def getPoolRecycleTimeout: Int = {
    asJava.getPoolRecycleTimeout().asInstanceOf[Int]
  }

  /**
   * Set the role name (only considered in HA mode).
   */
  def setRole(value: io.vertx.redis.client.RedisRole) = {
    asJava.setRole(value)
    this
  }

  def getRole: io.vertx.redis.client.RedisRole = {
    asJava.getRole()
  }

  /**
   * Set the desired client type to be created.
   */
  def setType(value: io.vertx.redis.client.RedisClientType) = {
    asJava.setType(value)
    this
  }

  def getType: io.vertx.redis.client.RedisClientType = {
    asJava.getType()
  }

  /**
   * Set whether or not to use slave nodes (only considered in Cluster mode).
   */
  def setUseSlave(value: io.vertx.redis.client.RedisSlaves) = {
    asJava.setUseSlave(value)
    this
  }

  def getUseSlave: io.vertx.redis.client.RedisSlaves = {
    asJava.getUseSlave()
  }

}


object RedisOptions {

  def apply() = {
    new RedisOptions(new JRedisOptions(emptyObj()))
  }

  def apply(t: JRedisOptions) = {
    if (t != null) {
      new RedisOptions(t)
    } else {
      new RedisOptions(new JRedisOptions(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): RedisOptions = {
    if (json != null) {
      new RedisOptions(new JRedisOptions(json))
    } else {
      new RedisOptions(new JRedisOptions(emptyObj()))
    }
  }
}

