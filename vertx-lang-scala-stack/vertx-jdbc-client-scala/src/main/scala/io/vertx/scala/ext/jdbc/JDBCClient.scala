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
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
  import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
  import io.vertx.core.{Vertx => JVertx}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
  import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
  import io.vertx.core.json.JsonObject
      
/**
  * An asynchronous client interface for interacting with a JDBC compliant database
  */
class JDBCClient(private val _asJava: JJDBCClient) {

  def asJava: JJDBCClient = _asJava

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember
    * to close the connection when you are done, so it is returned to the pool.
    * @return the future which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnectionFuture(): concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection,SQLConnection]((x => if (x == null) null else SQLConnection.apply(x)))
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

  def apply(_asJava: JJDBCClient): JDBCClient =
    new JDBCClient(_asJava)

  def createNonShared(vertx: Vertx, config: JsonObject): JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createNonShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

  def createShared(vertx: Vertx, config: JsonObject, dataSourceName: String): JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createShared(vertx.asJava.asInstanceOf[JVertx], config, dataSourceName))
  }

  def createShared(vertx: Vertx, config: JsonObject): JDBCClient = {
    JDBCClient.apply(io.vertx.ext.jdbc.JDBCClient.createShared(vertx.asJava.asInstanceOf[JVertx], config))
  }

}
