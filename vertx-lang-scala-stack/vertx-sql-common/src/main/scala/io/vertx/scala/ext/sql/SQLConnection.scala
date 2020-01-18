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

package io.vertx.scala.ext.sql

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.sql.{SQLOperations => JSQLOperations}
import scala.reflect.runtime.universe._
import io.vertx.ext.sql.TransactionIsolation
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import scala.collection.JavaConverters._
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{SQLOptions => JSQLOptions}
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * Represents a connection to a SQL database
  */

class SQLConnection(private val _asJava: Object) extends SQLOperations {
  def asJava = _asJava



  /**
   * Execute a one shot SQL statement that returns a single SQL row. This method will reduce the boilerplate code by
   * getting a connection from the pool (this object) and return it back after the execution. Only the first result
   * from the result set is returned.   * @param sql the statement to execute
   * @param handler the result handler
   * @return self
   */
  override 
  def querySingle(sql: String, handler: Handler[AsyncResult[scala.Option[io.vertx.core.json.JsonArray]]]): SQLOperations = {
    asJava.asInstanceOf[JSQLConnection].querySingle(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))}}))
    this
  }

  /**
   * Execute a one shot SQL statement with arguments that returns a single SQL row. This method will reduce the
   * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
   * Only the first result from the result set is returned.   * @param sql the statement to execute
   * @param arguments the arguments
   * @param handler the result handler
   * @return self
   */
  override 
  def querySingleWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[scala.Option[io.vertx.core.json.JsonArray]]]): SQLOperations = {
    asJava.asInstanceOf[JSQLConnection].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JsonArray]]{def handle(x: AsyncResult[JsonArray]) {handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))}}))
    this
  }

  /**
   * Sets the desired options to be applied to the current connection when statements are executed.
   *
   * The options are not applied globally but applicable to the current connection. For example changing the transaction
   * isolation level will only affect statements run on this connection and not future or current connections acquired
   * from the connection pool.
   *
   * This method is not async in nature since the apply will only happen at the moment a query is run.   * @param options the options to modify the unwrapped connection. see <a href="../../../../../../../cheatsheet/SQLOptions.html">SQLOptions</a>
   */
  
  def setOptions(options: SQLOptions): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setOptions(options.asJava)
    this
  }

  /**
   * Sets the auto commit flag for this connection. True by default.   * @param autoCommit the autoCommit flag, true by default.
   * @param resultHandler the handler which is called once this operation completes.
   */
  
  def setAutoCommit(autoCommit: Boolean, resultHandler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Executes the given SQL statement   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @param resultHandler the handler which is called once this operation completes.
   */
  
  def execute(sql: String, resultHandler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def query(sql: String, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JResultSet]]{def handle(x: AsyncResult[JResultSet]) {resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))}}))
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param handler the handler which is called once the operation completes. It will return a `SQLRowStream`.
   */
  override 
  def queryStream(sql: String, handler: Handler[AsyncResult[SQLRowStream]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JSQLRowStream]]{def handle(x: AsyncResult[JSQLRowStream]) {handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))}}))
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def queryWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String], params, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JResultSet]]{def handle(x: AsyncResult[JResultSet]) {resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))}}))
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @param handler the handler which is called once the operation completes. It will return a `SQLRowStream`.
   */
  override 
  def queryStreamWithParams(sql: String, params: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[SQLRowStream]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JSQLRowStream]]{def handle(x: AsyncResult[JSQLRowStream]) {handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))}}))
    this
  }

  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param resultHandler the handler which is called once the operation completes.
   */
  override 
  def update(sql: String, resultHandler: Handler[AsyncResult[UpdateResult]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JUpdateResult]]{def handle(x: AsyncResult[JUpdateResult]) {resultHandler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))}}))
    this
  }

  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @param resultHandler the handler which is called once the operation completes.
   */
  override 
  def updateWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[UpdateResult]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String], params, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JUpdateResult]]{def handle(x: AsyncResult[JUpdateResult]) {resultHandler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))}}))
    this
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.   * @param sql the SQL to execute. For example <code>{call getEmpName`</code>.
   * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def call(sql: String, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String], (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JResultSet]]{def handle(x: AsyncResult[JResultSet]) {resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))}}))
    this
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   *
   * The index of params and outputs are important for both arrays, for example when dealing with a prodecure that
   * takes the first 2 arguments as input values and the 3 arg as an output then the arrays should be like:
   *
   * <pre>
   *   params = [VALUE1, VALUE2, null]
   *   outputs = [null, null, "VARCHAR"]
   * </pre>   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
   * @param params these are the parameters to fill the statement.
   * @param outputs these are the outputs to fill the statement.
   * @param resultHandler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def callWithParams(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, (if (resultHandler == null) null else new io.vertx.core.Handler[AsyncResult[JResultSet]]{def handle(x: AsyncResult[JResultSet]) {resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))}}))
    this
  }

  /**
   * Commits all changes made since the previous commit/rollback.   * @param handler the handler called when this operation completes.
   */
  
  def commit(handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].commit((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Rolls back all changes made since the previous commit/rollback.   * @param handler the handler called when this operation completes.
   */
  
  def rollback(handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].rollback((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Sets a connection wide query timeout.
   *
   * It can be over written at any time and becomes active on the next query call.   * @param timeoutInSeconds the max amount of seconds the query can take to execute.
   */
  
  def setQueryTimeout(timeoutInSeconds: Int): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setQueryTimeout(timeoutInSeconds.asInstanceOf[java.lang.Integer])
    this
  }

  /**
   * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.   * @param sqlStatements sql statement
   * @param handler the result handler
   */
  
  def batch(sqlStatements: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.Integer]]]{def handle(x: AsyncResult[java.util.List[java.lang.Integer]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))}}))
    this
  }

  /**
   * Batch a prepared statement with all entries from the args list. Each entry is a batch.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.   * @param sqlStatement sql statement
   * @param args the prepared statement arguments
   * @param handler the result handler
   */
  
  def batchWithParams(sqlStatement: String, args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String], args.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.Integer]]]{def handle(x: AsyncResult[java.util.List[java.lang.Integer]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))}}))
    this
  }

  /**
   * Batch a callable statement with all entries from the args list. Each entry is a batch.
   * The size of the lists inArgs and outArgs MUST be the equal.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.   * @param sqlStatement sql statement
   * @param inArgs the callable statement input arguments
   * @param outArgs the callable statement output arguments
   * @param handler the result handler
   */
  
  def batchCallableWithParams(sqlStatement: String, inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String], inArgs.asJava, outArgs.asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[java.util.List[java.lang.Integer]]]{def handle(x: AsyncResult[java.util.List[java.lang.Integer]]) {handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))}}))
    this
  }

  /**
   * Attempts to change the transaction isolation level for this Connection object to the one given.
   *
   * The constants defined in the interface Connection are the possible transaction isolation levels.   * @param isolation the level of isolation
   * @param handler the handler called when this operation completes.
   */
  
  def setTransactionIsolation(isolation: io.vertx.ext.sql.TransactionIsolation, handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
    this
  }

  /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.   * @param handler the handler called when this operation completes.
   */
  
  def getTransactionIsolation(handler: Handler[AsyncResult[io.vertx.ext.sql.TransactionIsolation]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[TransactionIsolation]]{def handle(x: AsyncResult[TransactionIsolation]) {handler.handle(AsyncResultWrapper[TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x, a => a))}}))
    this
  }



  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.   * @param handler the handler called when this operation completes.
   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSQLConnection].close((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }

  /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSQLConnection].close()
  }


 /**
  * Like [[querySingle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def querySingleFuture (sql: String): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JSQLConnection].querySingle(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[querySingleWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def querySingleWithParamsFuture (sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JSQLConnection].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setAutoCommit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setAutoCommitFuture (autoCommit: Boolean): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeFuture (sql: String): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryFuture (sql: String): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryStream]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryStreamFuture (sql: String): scala.concurrent.Future[SQLRowStream] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryStreamWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryStreamWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[SQLRowStream] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def updateFuture (sql: String): scala.concurrent.Future[UpdateResult] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updateWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def updateWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[UpdateResult] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[call]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def callFuture (sql: String): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[callWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def callWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[commit]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def commitFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[rollback]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def rollbackFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].rollback(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchFuture (sqlStatements: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batchWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchWithParamsFuture (sqlStatement: String, args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String], args.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batchCallableWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchCallableWithParamsFuture (sqlStatement: String, inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String], inArgs.asJava, outArgs.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[setTransactionIsolation]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def setTransactionIsolationFuture (isolation: io.vertx.ext.sql.TransactionIsolation): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getTransactionIsolation]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getTransactionIsolationFuture (): scala.concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x => x)
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLConnection {
  def apply(asJava: JSQLConnection) = new SQLConnection(asJava)

}
