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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.redis.client.{RedisOptions => JRedisOptions}
import io.vertx.core.net.{NetClientOptions => JNetClientOptions}
import io.vertx.core.net
package object redis{


  type RedisOptions = io.vertx.redis.client.RedisOptions
  object RedisOptions {
    def apply() = new RedisOptions()
    def apply(json: JsonObject) = new RedisOptions(json)
    def apply( connectionString: java.lang.String = null, endpoint: java.lang.String = null, endpoints: scala.collection.immutable.List[java.lang.String] = null, masterName: java.lang.String = null, maxNestedArrays: java.lang.Integer = null, maxPoolSize: java.lang.Integer = null, maxPoolWaiting: java.lang.Integer = null, maxWaitingHandlers: java.lang.Integer = null, netClientOptions: io.vertx.core.net.NetClientOptions = null, password: java.lang.String = null, poolCleanerInterval: java.lang.Integer = null, poolName: java.lang.String = null, poolRecycleTimeout: java.lang.Integer = null, protocolNegotiation: java.lang.Boolean = null, role: io.vertx.redis.client.RedisRole = null, `type`: io.vertx.redis.client.RedisClientType = null, useReplicas: io.vertx.redis.client.RedisReplicas = null): RedisOptions = {
      val ret = new RedisOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (connectionString != null) ret.setConnectionString(connectionString) 
      if (endpoint != null) ret.setEndpoint(endpoint) 
      if (endpoints != null) ret.setEndpoints(endpoints.asJava) 
      if (masterName != null) ret.setMasterName(masterName) 
      if (maxNestedArrays != null) ret.setMaxNestedArrays(maxNestedArrays) 
      if (maxPoolSize != null) ret.setMaxPoolSize(maxPoolSize) 
      if (maxPoolWaiting != null) ret.setMaxPoolWaiting(maxPoolWaiting) 
      if (maxWaitingHandlers != null) ret.setMaxWaitingHandlers(maxWaitingHandlers) 
      if (netClientOptions != null) ret.setNetClientOptions(netClientOptions) 
      if (password != null) ret.setPassword(password) 
      if (poolCleanerInterval != null) ret.setPoolCleanerInterval(poolCleanerInterval) 
      if (poolName != null) ret.setPoolName(poolName) 
      if (poolRecycleTimeout != null) ret.setPoolRecycleTimeout(poolRecycleTimeout) 
      if (protocolNegotiation != null) ret.setProtocolNegotiation(protocolNegotiation) 
      if (role != null) ret.setRole(role) 
      if (`type` != null) ret.setType(`type`) 
      if (useReplicas != null) ret.setUseReplicas(useReplicas) 
      ret
    }
  }



}
