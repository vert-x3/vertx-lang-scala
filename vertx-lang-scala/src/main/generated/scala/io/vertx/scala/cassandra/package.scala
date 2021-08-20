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

import io.vertx.cassandra.{CassandraClientOptions => JCassandraClientOptions}
import io.vertx.core.tracing.TracingPolicy
package object cassandra{


  type CassandraClientOptions = io.vertx.cassandra.CassandraClientOptions
  object CassandraClientOptions {
    def apply() = new CassandraClientOptions()
    def apply(json: JsonObject) = new CassandraClientOptions(json)
    def apply( keyspace: java.lang.String = null, password: java.lang.String = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, username: java.lang.String = null): CassandraClientOptions = {
      val ret = new CassandraClientOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (keyspace != null) ret.setKeyspace(keyspace) 
      if (password != null) ret.setPassword(password) 
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (username != null) ret.setUsername(username) 
      ret
    }
  }



}
