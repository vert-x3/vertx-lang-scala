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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.sqlclient.{RowSet => JRowSet}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.sqlclient.{Pool => JPool}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{SqlConnection => JSqlConnection}
import io.vertx.lang.scala.HandlerOps._

/**
  * A pool of SQL connections.
  */

class Pool(private val _asJava: Object) extends SqlClient (_asJava) {





  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): Pool = {
    asJava.asInstanceOf[JPool].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): Pool = {
    asJava.asInstanceOf[JPool].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet[Row]]]): Pool = {
    asJava.asInstanceOf[JPool].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet[Row]]]): Pool = {
    asJava.asInstanceOf[JPool].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }



  /**
   * Get a connection from the pool.   * @param handler the handler that will get the connection result
   */
  def getConnection (handler: Handler[AsyncResult[SqlConnection]]): Unit = {
    asJava.asInstanceOf[JPool].getConnection((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JSqlConnection]]{def handle(x: AsyncResult[JSqlConnection]) {handler.handle(AsyncResultWrapper[JSqlConnection, SqlConnection](x, a => SqlConnection(a)))}}))
  }

  /**
   * Borrow a connection from the pool and begin a transaction, the underlying connection will be returned
   * to the pool when the transaction ends.   */
  def begin (handler: Handler[AsyncResult[Transaction]]): Unit = {
    asJava.asInstanceOf[JPool].begin((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JTransaction]]{def handle(x: AsyncResult[JTransaction]) {handler.handle(AsyncResultWrapper[JTransaction, Transaction](x, a => Transaction(a)))}}))
  }

  /**
   * Close the pool and release the associated resources.
   */
  override def close (): Unit = {
    asJava.asInstanceOf[JPool].close()
  }



  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPool].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPool].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPool].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPool].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getConnectionFuture (): scala.concurrent.Future[SqlConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSqlConnection, SqlConnection](x => SqlConnection(x))
    asJava.asInstanceOf[JPool].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[begin]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def beginFuture (): scala.concurrent.Future[Transaction] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JTransaction, Transaction](x => Transaction(x))
    asJava.asInstanceOf[JPool].begin(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Pool {
  def apply(asJava: JPool) = new Pool(asJava)

}
