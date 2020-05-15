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
import io.vertx.sqlclient.{Pool => JPool}
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.sqlclient.{Query => JQuery}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{SqlConnection => JSqlConnection}
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A pool of SQL connections.
  */

class Pool(private val _asJava: Object) extends SqlClient (_asJava) {






  /**
   * Get a connection from the pool.   * @param handler the handler that will get the connection result
   */
  def getConnection (handler: Handler[AsyncResult[SqlConnection]]): Unit = {
    asJava.asInstanceOf[JPool].getConnection((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JSqlConnection]]{def handle(x: AsyncResult[JSqlConnection]) {handler.handle(AsyncResultWrapper[JSqlConnection, SqlConnection](x, a => SqlConnection(a)))}}))
  }

  /**
   * 
   *
   * A connection is borrowed from the connection pool when the query is executed and then immediately returned
   * to the pool after it completes.
   */
  override def query (sql: String): Query[RowSet[Row]] = {
    Query[RowSet[Row]](asJava.asInstanceOf[JPool].query(sql.asInstanceOf[java.lang.String]))
  }

  /**
   * 
   *
   * A connection is borrowed from the connection pool when the query is executed and then immediately returned
   * to the pool after it completes.
   */
  override def preparedQuery (sql: String): PreparedQuery[RowSet[Row]] = {
    PreparedQuery[RowSet[Row]](asJava.asInstanceOf[JPool].preparedQuery(sql.asInstanceOf[java.lang.String]))
  }

  /**
   * Borrow a connection from the pool and begin a transaction, the underlying connection will be returned
   * to the pool when the transaction ends.
   */
  def begin (handler: Handler[AsyncResult[Transaction]]): Unit = {
    asJava.asInstanceOf[JPool].begin((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JTransaction]]{def handle(x: AsyncResult[JTransaction]) {handler.handle(AsyncResultWrapper[JTransaction, Transaction](x, a => Transaction(a)))}}))
  }

  /**
   * Close the pool and release the associated resources.
   */
  override def close (): Unit = {
    asJava.asInstanceOf[JPool].close()
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
