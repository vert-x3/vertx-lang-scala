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

import io.vertx.jdbcclient.{JDBCConnectOptions => JJDBCConnectOptions}
import io.vertx.core.tracing.TracingPolicy
package object jdbcclient{


  type JDBCConnectOptions = io.vertx.jdbcclient.JDBCConnectOptions
  object JDBCConnectOptions {
    def apply() = new JDBCConnectOptions()
    def apply(json: JsonObject) = new JDBCConnectOptions(json)
    def apply( connectTimeout: java.lang.Integer = null, dataSourceImplementation: java.lang.String = null, database: java.lang.String = null, idleTimeout: java.lang.Integer = null, jdbcUrl: java.lang.String = null, metricsEnabled: java.lang.Boolean = null, password: java.lang.String = null, tracingPolicy: io.vertx.core.tracing.TracingPolicy = null, user: java.lang.String = null): JDBCConnectOptions = {
      val ret = new JDBCConnectOptions(new io.vertx.core.json.JsonObject(java.util.Collections.emptyMap[java.lang.String,java.lang.Object]()))
      if (connectTimeout != null) ret.setConnectTimeout(connectTimeout) 
      if (dataSourceImplementation != null) ret.setDataSourceImplementation(dataSourceImplementation) 
      if (database != null) ret.setDatabase(database) 
      if (idleTimeout != null) ret.setIdleTimeout(idleTimeout) 
      if (jdbcUrl != null) ret.setJdbcUrl(jdbcUrl) 
      if (metricsEnabled != null) ret.setMetricsEnabled(metricsEnabled) 
      if (password != null) ret.setPassword(password) 
      if (tracingPolicy != null) ret.setTracingPolicy(tracingPolicy) 
      if (user != null) ret.setUser(user) 
      ret
    }
  }



}
