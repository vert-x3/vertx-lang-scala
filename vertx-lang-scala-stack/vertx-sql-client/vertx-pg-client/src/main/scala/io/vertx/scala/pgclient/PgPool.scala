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

package io.vertx.scala.pgclient

import io.vertx.scala.sqlclient.RowSet
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.scala.sqlclient.PreparedQuery
import scala.reflect.runtime.universe._
import io.vertx.scala.sqlclient.Pool
import io.vertx.scala.sqlclient.PoolOptions
import io.vertx.scala.sqlclient.Row
import io.vertx.sqlclient.{Pool => JPool}
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{Query => JQuery}
import io.vertx.pgclient.{PgConnectOptions => JPgConnectOptions}
import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
import io.vertx.pgclient.{PgPool => JPgPool}
import io.vertx.scala.sqlclient.Query
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A pool of PostgreSQL connections.
  */

class PgPool(private val _asJava: Object) extends Pool (_asJava) {







}

object PgPool {
  def apply(asJava: JPgPool) = new PgPool(asJava)

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with a default `poolOptions`.
   */
  def pool(): PgPool = {
    PgPool(JPgPool.pool())//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with `connectOptions` build from the environment variables.
   */
  def pool(poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with a default `poolOptions`.
   */
  def pool(connectionUri: String): PgPool = {
    PgPool(JPgPool.pool(connectionUri.asInstanceOf[java.lang.String]))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with `connectOptions` build from `connectionUri`.
   */
  def pool(connectionUri: String,poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(connectionUri.asInstanceOf[java.lang.String], poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with a default `poolOptions`.
   */
  def pool(vertx: Vertx,connectionUri: String): PgPool = {
    PgPool(JPgPool.pool(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String]))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with `connectOptions` build from the environment variables.
   */
  def pool(vertx: Vertx,poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(vertx.asJava.asInstanceOf[JVertx], poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with `connectOptions` build from `connectionUri`.
   */
  def pool(vertx: Vertx,connectionUri: String,poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String], poolOptions.asJava))//2 pool
  }

  /**
   * Create a connection pool to the database configured with the given `connectOptions` and `poolOptions`.   * @param poolOptions the options for creating the pool see <a href="../../../../../../cheatsheet/PoolOptions.html">PoolOptions</a>
   * @return the connection pool
   */
  def pool(connectOptions: PgConnectOptions,poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(connectOptions.asJava, poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgPool#pool]] with a specific  instance.
   */
  def pool(vertx: Vertx,connectOptions: PgConnectOptions,poolOptions: PoolOptions): PgPool = {
    PgPool(JPgPool.pool(vertx.asJava.asInstanceOf[JVertx], connectOptions.asJava, poolOptions.asJava))//2 pool
  }

}
