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
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A transaction that allows to control the transaction and receive events.

  */

class Transaction(private val _asJava: Object) extends SqlClient (_asJava) {




  /**
   * Create a prepared query.   * @param sql the sql
   * @param handler the handler notified with the prepared query asynchronously
   */
  
  def prepare(sql: String, handler: Handler[AsyncResult[PreparedQuery]]): Transaction = {
    asJava.asInstanceOf[JTransaction].prepare(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQuery]]{def handle(x: AsyncResult[JPreparedQuery]) {handler.handle(AsyncResultWrapper[JPreparedQuery, PreparedQuery](x, a => PreparedQuery(a)))}}))
    this
  }

  /**
   * Set an handler to be called when the transaction is aborted.   * @param handler the handler
   */
  
  def abortHandler(handler: Handler[Unit]): Transaction = {
    asJava.asInstanceOf[JTransaction].abortHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): Transaction = {
    asJava.asInstanceOf[JTransaction].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): Transaction = {
    asJava.asInstanceOf[JTransaction].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet[Row]]]): Transaction = {
    asJava.asInstanceOf[JTransaction].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet[Row]]]): Transaction = {
    asJava.asInstanceOf[JTransaction].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }



  /**
   * Commit the current transaction.
   */
  def commit (): Unit = {
    asJava.asInstanceOf[JTransaction].commit()
  }

  /**
   * Like [[io.vertx.scala.sqlclient.Transaction#commit]] with an handler to be notified when the transaction commit has completed
   */
  def commit (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JTransaction].commit((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Rollback the current transaction.
   */
  def rollback (): Unit = {
    asJava.asInstanceOf[JTransaction].rollback()
  }

  /**
   * Like [[io.vertx.scala.sqlclient.Transaction#rollback]] with an handler to be notified when the transaction rollback has completed
   */
  def rollback (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JTransaction].rollback((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Rollback the transaction and release the associated resources.
   */
  override def close (): Unit = {
    asJava.asInstanceOf[JTransaction].close()
  }


 /**
  * Like [[prepare]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def prepareFuture (sql: String): scala.concurrent.Future[PreparedQuery] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQuery, PreparedQuery](x => PreparedQuery(x))
    asJava.asInstanceOf[JTransaction].prepare(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def commitFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTransaction].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rollback]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rollbackFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JTransaction].rollback(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JTransaction].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JTransaction].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JTransaction].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JTransaction].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Transaction {
  def apply(asJava: JTransaction) = new Transaction(asJava)

}
