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
import io.vertx.scala.sqlclient.PreparedQuery
import io.vertx.mysqlclient.{MySQLConnection => JMySQLConnection}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.mysqlclient.{MySQLConnectOptions => JMySQLConnectOptions}
import io.vertx.scala.core.Vertx
import io.vertx.scala.sqlclient.SqlConnection
import io.vertx.core.{Vertx => JVertx}
import io.vertx.lang.scala.Converter._
import io.vertx.scala.sqlclient.Tuple
import io.vertx.scala.sqlclient.Transaction
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.mysqlclient.MySQLSetOption
import io.vertx.sqlclient.{SqlConnection => JSqlConnection}
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A connection to MySQL server.

  */

class MySQLConnection(private val _asJava: Object) extends SqlConnection (_asJava) {





  override 
  def prepare(sql: String, handler: Handler[AsyncResult[PreparedQuery]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].prepare(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedQuery]]{def handle(x: AsyncResult[JPreparedQuery]) {handler.handle(AsyncResultWrapper[JPreparedQuery, PreparedQuery](x, a => PreparedQuery(a)))}}))
    this
  }


  override 
  def exceptionHandler(handler: Handler[Throwable]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].exceptionHandler((if (handler == null) null else new io.vertx.core.Handler[Throwable]{def handle(x: Throwable) {handler.handle(x)}}))
    this
  }


  override 
  def closeHandler(handler: Handler[Unit]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].closeHandler((if (handler == null) null else new io.vertx.core.Handler[Void]{def handle(x: Void) {handler.handle(x)}}))
    this
  }


  override 
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }


  override 
  def query(sql: String, handler: Handler[AsyncResult[RowSet]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }


  override 
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Send a PING command to check if the server is alive.   * @param handler the handler notified when the server responses to client
   * @return a reference to this, so the API can be used fluently
   */
  
  def ping(handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].ping((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Send a INIT_DB command to change the default schema of the connection.   * @param schemaName name of the schema to change to
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def specifySchema(schemaName: String, handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].specifySchema(schemaName.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Send a STATISTICS command to get a human readable string of the server internal status.   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def getInternalStatistics(handler: Handler[AsyncResult[String]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].getInternalStatistics((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.lang.String]]{def handle(x: AsyncResult[java.lang.String]) {handler.handle(AsyncResultWrapper[java.lang.String, String](x, a => a.asInstanceOf[String]))}}))
    this
  }

  /**
   * Send a SET_OPTION command to set options for the current connection.   * @param option the options to set
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def setOption(option: io.vertx.mysqlclient.MySQLSetOption, handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].setOption(option, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Send a RESET_CONNECTION command to reset the session state.   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def resetConnection(handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].resetConnection((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Send a DEBUG command to dump debug information to the server's stdout.   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def debug(handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].debug((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Send a CHANGE_USER command to change the user of the current connection, this operation will also reset connection state.   * @param options authentication options, only username, password, database, charset and properties will be used. see <a href="../../../../../../cheatsheet/MySQLConnectOptions.html">MySQLConnectOptions</a>
   * @param handler the handler
   * @return a reference to this, so the API can be used fluently
   */
  
  def changeUser(options: MySQLConnectOptions, handler: Handler[AsyncResult[Unit]]): MySQLConnection = {
    asJava.asInstanceOf[JMySQLConnection].changeUser(options.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }





  override def prepareFuture (sql: String): scala.concurrent.Future[PreparedQuery] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedQuery, PreparedQuery](x => PreparedQuery(x))
    asJava.asInstanceOf[JMySQLConnection].prepare(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JMySQLConnection].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def queryFuture (sql: String): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JMySQLConnection].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JMySQLConnection].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def pingFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].ping(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[specifySchema]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def specifySchemaFuture (schemaName: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].specifySchema(schemaName.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getInternalStatistics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getInternalStatisticsFuture (): scala.concurrent.Future[String] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.String, String](x => x.asInstanceOf[String])
    asJava.asInstanceOf[JMySQLConnection].getInternalStatistics(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setOption]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setOptionFuture (option: io.vertx.mysqlclient.MySQLSetOption): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].setOption(option, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[resetConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def resetConnectionFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].resetConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[debug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def debugFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].debug(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[changeUser]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def changeUserFuture (options: MySQLConnectOptions): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JMySQLConnection].changeUser(options.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object MySQLConnection {
  def apply(asJava: JMySQLConnection) = new MySQLConnection(asJava)
  
  /**
   * Create a connection to MySQL server with the given `connectOptions`.   * @param vertx the vertx instance
   * @param connectOptions the options for the connection see <a href="../../../../../../cheatsheet/MySQLConnectOptions.html">MySQLConnectOptions</a>
   * @param handler the handler called with the connection or the failure
   */
  def connect(vertx: Vertx,connectOptions: MySQLConnectOptions,handler: Handler[AsyncResult[MySQLConnection]]): Unit = {
    JMySQLConnection.connect(vertx.asJava.asInstanceOf[JVertx], connectOptions.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JMySQLConnection]]{def handle(x: AsyncResult[JMySQLConnection]) {handler.handle(AsyncResultWrapper[JMySQLConnection, MySQLConnection](x, a => MySQLConnection(a)))}}))
  }

  /**
   * Like [[io.vertx.scala.mysqlclient.MySQLConnection#connect]] with options build from `connectionUri`.
   */
  def connect(vertx: Vertx,connectionUri: String,handler: Handler[AsyncResult[MySQLConnection]]): Unit = {
    JMySQLConnection.connect(vertx.asJava.asInstanceOf[JVertx], connectionUri.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JMySQLConnection]]{def handle(x: AsyncResult[JMySQLConnection]) {handler.handle(AsyncResultWrapper[JMySQLConnection, MySQLConnection](x, a => MySQLConnection(a)))}}))
  }

}
