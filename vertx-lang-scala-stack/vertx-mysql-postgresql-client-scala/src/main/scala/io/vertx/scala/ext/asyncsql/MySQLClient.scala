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
import io.vertx.ext.asyncsql.{MySQLClient => JMySQLClient}
import io.vertx.ext.asyncsql.{AsyncSQLClient => JAsyncSQLClient}
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.json.JsonObject

/**
  * Represents an asynchronous MySQL client
  */
class MySQLClient(private val _asJava: JMySQLClient) 
    extends  {

  def asJava: JMySQLClient = _asJava

}

object MySQLClient {

  def apply(_asJava: JMySQLClient): MySQLClient =
    new MySQLClient(_asJava)

  def createNonShared(vertx: Vertx, config: JsonObject): AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.MySQLClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

  def createShared(vertx: Vertx, config: JsonObject, poolName: String): AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.MySQLClient.createShared(vertx.asJava.asInstanceOf[JVertx], config, poolName))
  }

  def createShared(vertx: Vertx, config: JsonObject): AsyncSQLClient = {
    AsyncSQLClient.apply(io.vertx.ext.asyncsql.MySQLClient.createShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
