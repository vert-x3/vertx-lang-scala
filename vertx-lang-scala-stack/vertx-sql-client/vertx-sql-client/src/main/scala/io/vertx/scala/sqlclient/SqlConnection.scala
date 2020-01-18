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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{SqlConnection => JSqlConnection}
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A connection to database server.
  */

class SqlConnection(private val _asJava: Object) extends SqlClient (_asJava) {




  /**
   * Create a prepared query.   * @param sql the sql
   * @param handler the handler notified with the prepared query asynchronously
   */
  
  def prepare(sql: String, handler: Handler[AsyncResult[PreparedQuery]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].prepare(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQuery]]{def handle(x: AsyncResult[JPreparedQuery]) {handler.handle(AsyncResultWrapper[JPreparedQuery, PreparedQuery](x, a => PreparedQuery(a)))}}))
    this
  }

  /**
   * Set an handler called with connection errors.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def exceptionHandler(handler: Handler[Throwable]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }

  /**
   * Set an handler called when the connection is closed.   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def closeHandler(handler: Handler[Unit]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet[Row]]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet[Row]]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }



  /**
   * Begin a transaction and returns a [[io.vertx.scala.sqlclient.Transaction]] for controlling and tracking
   * this transaction.
   * <p/>
   * When the connection is explicitely closed, any inflight transaction is rollbacked.   * @return the transaction instance
   */
  def begin (): Transaction = {
    Transaction(asJava.asInstanceOf[JSqlConnection].begin())
  }

  /**
   * @return whether the connection uses SSL
   */
  def isSSL (): Boolean = {
    asJava.asInstanceOf[JSqlConnection].isSSL().asInstanceOf[Boolean]
  }

  /**
   * Close the current connection after all the pending commands have been processed.
   */
  override def close (): Unit = {
    asJava.asInstanceOf[JSqlConnection].close()
  }


 /**
  * Like [[prepare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def prepareFuture (sql: String): scala.concurrent.Future[PreparedQuery] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQuery, PreparedQuery](x => PreparedQuery(x))
    asJava.asInstanceOf[JSqlConnection].prepare(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JSqlConnection].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JSqlConnection].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JSqlConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JSqlConnection].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SqlConnection {
  def apply(asJava: JSqlConnection) = new SqlConnection(asJava)

}
