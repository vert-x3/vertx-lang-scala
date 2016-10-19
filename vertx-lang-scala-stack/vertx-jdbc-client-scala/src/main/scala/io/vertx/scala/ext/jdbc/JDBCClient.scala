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

package io.vertx.scala.ext.jdbc

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.core.json.JsonObject
import io.vertx.core.Handler

/**
  * An asynchronous client interface for interacting with a JDBC compliant database
  */
class JDBCClient(private val _asJava: io.vertx.ext.jdbc.JDBCClient) {

  def asJava: io.vertx.ext.jdbc.JDBCClient = _asJava

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember
    * to close the connection when you are done, so it is returned to the pool.
    * @return the future which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnectionFuture(): concurrent.Future[io.vertx.scala.ext.sql.SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.ext.sql.SQLConnection,io.vertx.scala.ext.sql.SQLConnection]((x => if (x == null) null else SQLConnection.apply(x)))
    _asJava.getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Close the client
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object JDBCClient {

  def apply(_asJava: io.vertx.ext.jdbc.JDBCClient): io.vertx.scala.ext.jdbc.JDBCClient =
    new io.vertx.scala.ext.jdbc.JDBCClient(_asJava)

  def createNonShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.jdbc.JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createNonShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject, dataSourceName: String): io.vertx.scala.ext.jdbc.JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config, dataSourceName))
  }

  def createShared(vertx: io.vertx.scala.core.Vertx, config: io.vertx.core.json.JsonObject): io.vertx.scala.ext.jdbc.JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createShared(vertx.asJava.asInstanceOf[io.vertx.core.Vertx], config))
  }

}
