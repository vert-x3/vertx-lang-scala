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

package io.vertx.scala.sqlclient

import io.vertx.scala.core.net.PemKeyCertOptions
import io.vertx.core.net.{PfxOptions => JPfxOptions}
import io.vertx.scala.core.net.PemTrustOptions
import io.vertx.lang.scala.json.Json._
import io.vertx.scala.core.net.PfxOptions
import scala.collection.JavaConverters._
import java.util.concurrent.TimeUnit
import io.vertx.scala.core.net.{NetClientOptions => ExtNetClientOptions}
import io.vertx.scala.core.net.JdkSSLEngineOptions
import io.vertx.sqlclient.{SqlConnectOptions => JSqlConnectOptions}
import io.vertx.core.buffer.Buffer
import io.vertx.scala.core.net.JksOptions
import io.vertx.core.net.{OpenSSLEngineOptions => JOpenSSLEngineOptions}
import io.vertx.core.net.{JdkSSLEngineOptions => JJdkSSLEngineOptions}
import io.vertx.scala.core.net.OpenSSLEngineOptions
import io.vertx.core.net.{PemTrustOptions => JPemTrustOptions}
import io.vertx.scala.core.net.ProxyOptions
import io.vertx.core.json.JsonObject
import io.vertx.core.net.{PemKeyCertOptions => JPemKeyCertOptions}
import io.vertx.core.net.{ProxyOptions => JProxyOptions}
import io.vertx.core.net.{JksOptions => JJksOptions}

/**
 * Connect options for configuring [[io.vertx.scala.sqlclient.SqlConnection]] or [[io.vertx.scala.sqlclient.Pool]].

 */

abstract class SqlConnectOptions(private val _asJava: JSqlConnectOptions) extends ExtNetClientOptions(_asJava) {

  /**
   * Set whether prepared statements cache should be enabled.
   */
  def setCachePreparedStatements(value: Boolean): SqlConnectOptions

  def getCachePreparedStatements: Boolean

  /**
   * Specify the default database for the connection.
   */
  def setDatabase(value: String): SqlConnectOptions

  def getDatabase: String

  /**
   * Specify the host for connecting to the server.
   */
  def setHost(value: String): SqlConnectOptions

  def getHost: String

  /**
   * Specify the user password to be used for the authentication.
   */
  def setPassword(value: String): SqlConnectOptions

  def getPassword: String

  /**
   * Specify the port for connecting to the server.
   */
  def setPort(value: Int): SqlConnectOptions

  def getPort: Int

  /**
   * Set the maximum number of prepared statements that the connection will cache.
   */
  def setPreparedStatementCacheMaxSize(value: Int): SqlConnectOptions

  def getPreparedStatementCacheMaxSize: Int

  /**
   * Set the maximum length of prepared statement SQL string that the connection will cache.
   */
  def setPreparedStatementCacheSqlLimit(value: Int): SqlConnectOptions

  def getPreparedStatementCacheSqlLimit: Int

  /**
   * Set properties for this client, which will be sent to server at the connection start.
   */
  def setProperties(value: Map[String, String]): SqlConnectOptions

  def getProperties: scala.collection.mutable.Map[String, String]

  /**
   * Specify the user account to be used for the authentication.
   */
  def setUser(value: String): SqlConnectOptions

  def getUser: String

}
