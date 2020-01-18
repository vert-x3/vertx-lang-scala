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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.scala.sqlclient.RowSet
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.scala.sqlclient.PreparedQuery
import scala.reflect.runtime.universe._
import io.vertx.pgclient.{PgConnection => JPgConnection}
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.scala.sqlclient.Row
import io.vertx.pgclient.{PgNotification => JPgNotification}
import scala.collection.JavaConverters._
import io.vertx.scala.core.Vertx
import io.vertx.scala.sqlclient.SqlConnection
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.sqlclient.Tuple
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.scala.sqlclient.Transaction
import io.vertx.pgclient.{PgConnectOptions => JPgConnectOptions}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{SqlConnection => JSqlConnection}
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A connection to Postgres.
  */

class PgConnection(private val _asJava: Object) extends SqlConnection (_asJava) {




  /**
   * Set an handler called when the connection receives notification on a channel.
   * <p/>
   * The handler is called with the <a href="../../../../../../cheatsheet/PgNotification.html">PgNotification</a> and has access to the channel name
   * and the notification payload.   * @param handler the handler
   * @return the transaction instance
   */
  
  def notificationHandler(handler: Handler[PgNotification]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].notificationHandler((if (handler == null) null else new io.vertx.core.Handler[JPgNotification]{def handle(x: JPgNotification) {handler.handle(PgNotification(x))}}))
    this
  }


  override 
  def prepare(sql: String, handler: Handler[AsyncResult[PreparedQuery]]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].prepare(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQuery]]{def handle(x: AsyncResult[JPreparedQuery]) {handler.handle(AsyncResultWrapper[JPreparedQuery, PreparedQuery](x, a => PreparedQuery(a)))}}))
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def closeHandler(handler: Handler[Unit]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet[Row]]]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet[Row]]]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }


  override 
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet[Row]]]): PgConnection = {
    asJava.asInstanceOf[JPgConnection].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet[JRow]]]{def handle(x: AsyncResult[JRowSet[JRow]]) {handler.handle(AsyncResultWrapper[JRowSet[JRow], RowSet[Row]](x, a => RowSet[Row](a)))}}))
    this
  }



  /**
   * Send a request cancellation message to tell the server to cancel processing request in this connection.
   * <br>Note: Use this with caution because the cancellation signal may or may not have any effect.   * @param handler the handler notified if cancelling request is sent
   * @return a reference to this, so the API can be used fluently
   */
  def cancelRequest (handler: Handler[AsyncResult[Unit]]): PgConnection = {
    PgConnection(asJava.asInstanceOf[JPgConnection].cancelRequest((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}})))
  }

  /**
   * @return The process ID of the target backend
   */
  def processId (): Int = {
    asJava.asInstanceOf[JPgConnection].processId().asInstanceOf[Int]
  }

  /**
   * @return The secret key for the target backend
   */
  def secretKey (): Int = {
    asJava.asInstanceOf[JPgConnection].secretKey().asInstanceOf[Int]
  }


 /**
  * Like [[cancelRequest]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def cancelRequestFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPgConnection].cancelRequest(promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def prepareFuture (sql: String): scala.concurrent.Future[PreparedQuery] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQuery, PreparedQuery](x => PreparedQuery(x))
    asJava.asInstanceOf[JPgConnection].prepare(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPgConnection].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPgConnection].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPgConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet[Row]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet[JRow], RowSet[Row]](x => RowSet[Row](x))
    asJava.asInstanceOf[JPgConnection].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PgConnection {
  def apply(asJava: JPgConnection) = new PgConnection(asJava)

  /**
   * Connects to the database and returns the connection if that succeeds.
   * <p/>
   * The connection interracts directly with the database is not a proxy, so closing the
   * connection will close the underlying connection to the database.   * @param vertx the vertx instance
   * @param options the connect options see <a href="../../../../../../cheatsheet/PgConnectOptions.html">PgConnectOptions</a>
   * @param handler the handler called with the connection or the failure
   */
  def connect(vertx: Vertx,options: PgConnectOptions,handler: Handler[AsyncResult[PgConnection]]): Unit = {
    JPgConnection.connect(vertx.asJava.asInstanceOf[JVertx], options.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPgConnection]]{def handle(x: AsyncResult[JPgConnection]) {handler.handle(AsyncResultWrapper[JPgConnection, PgConnection](x, a => PgConnection(a)))}}))//2 connect
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgConnection#connect]] with options build from the environment variables.
   */
  def connect(vertx: Vertx,handler: Handler[AsyncResult[PgConnection]]): Unit = {
    JPgConnection.connect(vertx.asJava.asInstanceOf[JVertx], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPgConnection]]{def handle(x: AsyncResult[JPgConnection]) {handler.handle(AsyncResultWrapper[JPgConnection, PgConnection](x, a => PgConnection(a)))}}))//2 connect
  }

  /**
   * Like [[io.vertx.scala.pgclient.PgConnection#connect]] with options build from `connectionUri`.
   */
  def connect(vertx: Vertx,connectionUri: String,handler: Handler[AsyncResult[PgConnection]]): Unit = {
    JPgConnection.connect(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPgConnection]]{def handle(x: AsyncResult[JPgConnection]) {handler.handle(AsyncResultWrapper[JPgConnection, PgConnection](x, a => PgConnection(a)))}}))//2 connect
  }

}
