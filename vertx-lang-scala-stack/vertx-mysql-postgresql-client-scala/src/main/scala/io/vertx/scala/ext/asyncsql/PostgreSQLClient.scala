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

package io.vertx.scala.ext.asyncsql

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

/**
  * Represents an PostgreSQL client
  */
class PostgreSQLClient(private val _asJava: io.vertx.ext.asyncsql.PostgreSQLClient) {

  def asJava: io.vertx.ext.asyncsql.PostgreSQLClient = _asJava

}

object PostgreSQLClient {

  def apply(_asJava: io.vertx.ext.asyncsql.PostgreSQLClient): io.vertx.scala.ext.asyncsql.PostgreSQLClient =
    new io.vertx.scala.ext.asyncsql.PostgreSQLClient(_asJava)

  def createNonShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.asyncsql.AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.PostgreSQLClient.createNonShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject, poolName: String): io.vertx.scala.ext.asyncsql.AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.PostgreSQLClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config, poolName))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.asyncsql.AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.PostgreSQLClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

}
