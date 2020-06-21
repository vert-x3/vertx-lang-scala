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

import io.vertx.sqlclient
import io.vertx.core
import io.vertx.mssqlclient.{MSSQLConnectOptions => JMSSQLConnectOptions}
import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
import io.vertx.sqlclient.{Pool => JPool}
import io.vertx.mssqlclient.{MSSQLPool => JMSSQLPool}
import io.vertx.core.{Vertx => JVertx}
package object mssqlclient{


  type MSSQLConnectOptions = io.vertx.mssqlclient.MSSQLConnectOptions
  object MSSQLConnectOptions {
    def apply() = new MSSQLConnectOptions()
    def apply(json: JsonObject) = new MSSQLConnectOptions(json)
  }




  /**
    * A connection to Microsoft SQL Server.

    */

  implicit class MSSQLConnectionScala(val asJava: io.vertx.mssqlclient.MSSQLConnection) extends AnyVal {


    /**
     * Like prepare from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def prepareFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedStatement] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedStatement]/*io.vertx.sqlclient.PreparedStatement API*/()
      asJava.prepare(s, new Handler[AsyncResult[io.vertx.sqlclient.PreparedStatement]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedStatement]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object MSSQLPool {
    /**
     * Create a connection pool to the SQL server configured with the given `connectOptions` and `poolOptions`.     * @param connectOptions the options for the connection see <a href="../../../../../../cheatsheet/MSSQLConnectOptions.html">MSSQLConnectOptions</a>
     * @param poolOptions the options for creating the pool see <a href="../../../../../../cheatsheet/PoolOptions.html">PoolOptions</a>
     * @return the connection pool
     */
  def pool(connectOptions: io.vertx.mssqlclient.MSSQLConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mssqlclient.MSSQLPool.pool(connectOptions, poolOptions)
  }

    /**
     * Like [[io.vertx.mssqlclient.MSSQLPool#pool]] with a specific  instance.
     */
  def pool(vertx: io.vertx.core.Vertx, connectOptions: io.vertx.mssqlclient.MSSQLConnectOptions, poolOptions: io.vertx.sqlclient.PoolOptions) = {
      io.vertx.mssqlclient.MSSQLPool.pool(vertx, connectOptions, poolOptions)
  }
  }


}
