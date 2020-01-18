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

package io.vertx.scala.mysqlclient

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.sqlclient.RowSet
import io.vertx.sqlclient.{RowSet => JRowSet}
import scala.reflect.runtime.universe._
import io.vertx.scala.sqlclient.Pool
import io.vertx.scala.sqlclient.PoolOptions
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.scala.sqlclient.Row
import io.vertx.mysqlclient.{MySQLConnectOptions => JMySQLConnectOptions}
import io.vertx.sqlclient.{Pool => JPool}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.scala.sqlclient.Tuple
import io.vertx.mysqlclient.{MySQLPool => JMySQLPool}
import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * A pool of MySQL connections.

  */

class MySQLPool(private val _asJava: Object) extends Pool (_asJava) {





  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): MySQLPool = {
    asJava.asInstanceOf[JMySQLPool].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): MySQLPool = {
    asJava.asInstanceOf[JMySQLPool].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet[Row]]]): MySQLPool = {
    asJava.asInstanceOf[JMySQLPool].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet[Row]]]): MySQLPool = {
    asJava.asInstanceOf[JMySQLPool].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }





  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JMySQLPool].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JMySQLPool].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JMySQLPool].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JMySQLPool].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MySQLPool {
  def apply(asJava: JMySQLPool) = new MySQLPool(asJava)

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLPool#pool]] with a default `poolOptions`.
   */
  def pool(connectionUri: String): MySQLPool = {
    MySQLPool(JMySQLPool.pool(connectionUri.asInstanceOf[java.lang.String]))//2 pool
  }

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLPool#pool]] with `connectOptions` build from `connectionUri`.
   */
  def pool(connectionUri: String,poolOptions: PoolOptions): MySQLPool = {
    MySQLPool(JMySQLPool.pool(connectionUri.asInstanceOf[java.lang.String], poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLPool#pool]] with a default `poolOptions`..
   */
  def pool(vertx: Vertx,connectionUri: String): MySQLPool = {
    MySQLPool(JMySQLPool.pool(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String]))//2 pool
  }

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLPool#pool]] with `connectOptions` build from `connectionUri`.
   */
  def pool(vertx: Vertx,connectionUri: String,poolOptions: PoolOptions): MySQLPool = {
    MySQLPool(JMySQLPool.pool(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String], poolOptions.asJava))//2 pool
  }

  /**
   * Create a connection pool to the MySQL server configured with the given `connectOptions` and `poolOptions`.   * @param connectOptions the options for the connection see <a href="../../../../../../cheatsheet/MySQLConnectOptions.html">MySQLConnectOptions</a>
   * @param poolOptions the options for creating the pool see <a href="../../../../../../cheatsheet/PoolOptions.html">PoolOptions</a>
   * @return the connection pool
   */
  def pool(connectOptions: MySQLConnectOptions,poolOptions: PoolOptions): MySQLPool = {
    MySQLPool(JMySQLPool.pool(connectOptions.asJava, poolOptions.asJava))//2 pool
  }

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLPool#pool]] with a specific  instance.
   */
  def pool(vertx: Vertx,connectOptions: MySQLConnectOptions,poolOptions: PoolOptions): MySQLPool = {
    MySQLPool(JMySQLPool.pool(vertx.asJava.asInstanceOf[JVertx], connectOptions.asJava, poolOptions.asJava))//2 pool
  }

}
