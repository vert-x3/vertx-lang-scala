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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.ext.sql.TransactionIsolation
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}

/**
  * Represents a connection to a SQL database
  */
class SQLConnection(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Sets the auto commit flag for this connection. True by default.
    * @param autoCommit the autoCommit flag, true by default.
    */
  def setAutoCommit(autoCommit: Boolean, resultHandler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Executes the given SQL statement
    * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
    */
  def execute(sql: String, resultHandler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String], {x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    */
  def query(sql: String, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    */
  def queryStream(sql: String, handler: Handler[AsyncResult[SQLRowStream]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param params these are the parameters to fill the statement.
    */
  def queryWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param params these are the parameters to fill the statement.
    */
  def queryStreamWithParams(sql: String, params: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[SQLRowStream]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  /**
    * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement.
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    */
  def update(sql: String, resultHandler: Handler[AsyncResult[UpdateResult]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JUpdateResult] => resultHandler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
    * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement with the given parameters
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param params these are the parameters to fill the statement.
    */
  def updateWithParams(sql: String, params: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[UpdateResult]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JUpdateResult] => resultHandler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
    * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    * @param sql the SQL to execute. For example <code>{call getEmpName`</code>.
    */
  def call(sql: String, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
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
    * </pre>
    * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
    * @param params these are the parameters to fill the statement.
    * @param outputs these are the outputs to fill the statement.
    */
  def callWithParams(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray, resultHandler: Handler[AsyncResult[ResultSet]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, {x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
    * Commits all changes made since the previous commit/rollback.
    */
  def commit(handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].commit({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Rolls back all changes made since the previous commit/rollback.
    */
  def rollback(handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].rollback({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Sets a connection wide query timeout.
    *
    * It can be over written at any time and becomes active on the next query call.
    * @param timeoutInSeconds the max amount of seconds the query can take to execute.
    */
  def setQueryTimeout(timeoutInSeconds: Int): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setQueryTimeout(timeoutInSeconds.asInstanceOf[java.lang.Integer])
    this
  }

  /**
    * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
    * @param sqlStatements sql statement
    */
  def batch(sqlStatements: scala.collection.mutable.Buffer[String], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava, {x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  /**
    * Batch a prepared statement with all entries from the args list. Each entry is a batch.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param args the prepared statement arguments
    */
  def batchWithParams(sqlStatement: String, args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String], args.asJava, {x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  /**
    * Batch a callable statement with all entries from the args list. Each entry is a batch.
    * The size of the lists inArgs and outArgs MUST be the equal.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param inArgs the callable statement input arguments
    * @param outArgs the callable statement output arguments
    */
  def batchCallableWithParams(sqlStatement: String, inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String], inArgs.asJava, outArgs.asJava, {x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  /**
    * Attempts to change the transaction isolation level for this Connection object to the one given.
    *
    * The constants defined in the interface Connection are the possible transaction isolation levels.
    * @param isolation the level of isolation
    */
  def setTransactionIsolation(isolation: io.vertx.ext.sql.TransactionIsolation, handler: Handler[AsyncResult[Unit]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation, {x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
    this
  }

  /**
    * Attempts to return the transaction isolation level for this Connection object to the one given.
    */
  def getTransactionIsolation(handler: Handler[AsyncResult[io.vertx.ext.sql.TransactionIsolation]]): SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation({x: AsyncResult[TransactionIsolation] => handler.handle(AsyncResultWrapper[TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x, a => a))})
    this
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    */
  def close(handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSQLConnection].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JSQLConnection].close()
  }

 /**
   * Sets the auto commit flag for this connection. True by default.
   * @param autoCommit the autoCommit flag, true by default.
   * @return the future which is called once this operation completes.
   */
  def setAutoCommitFuture(autoCommit: Boolean): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL statement
   * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
   * @return the future which is called once this operation completes.
   */
  def executeFuture(sql: String): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @return the future which is called once the operation completes. It will return a `ResultSet`.
   */
  def queryFuture(sql: String): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @return the future which is called once the operation completes. It will return a `SQLRowStream`.
   */
  def queryStreamFuture(sql: String): scala.concurrent.Future[SQLRowStream] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @return the future which is called once the operation completes. It will return a `ResultSet`.
   */
  def queryWithParamsFuture(sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.
   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @return the future which is called once the operation completes. It will return a `SQLRowStream`.
   */
  def queryStreamWithParamsFuture(sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[SQLRowStream] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @return the future which is called once the operation completes.
   */
  def updateFuture(sql: String): scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters
   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @return the future which is called once the operation completes.
   */
  def updateWithParamsFuture(sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
   * @param sql the SQL to execute. For example <code>{call getEmpName`</code>.
   * @return the future which is called once the operation completes. It will return a `ResultSet`.
   */
  def callFuture(sql: String): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
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
   * </pre>
   * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
   * @param params these are the parameters to fill the statement.
   * @param outputs these are the outputs to fill the statement.
   * @return the future which is called once the operation completes. It will return a `ResultSet`.
   */
  def callWithParamsFuture(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
   * @return the future called when this operation completes.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Commits all changes made since the previous commit/rollback.
   * @return the future called when this operation completes.
   */
  def commitFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Rolls back all changes made since the previous commit/rollback.
   * @return the future called when this operation completes.
   */
  def rollbackFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].rollback(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
   * @param sqlStatements sql statement
   * @return the result future
   */
  def batchFuture(sqlStatements: scala.collection.mutable.Buffer[String]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Batch a prepared statement with all entries from the args list. Each entry is a batch.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   * @param sqlStatement sql statement
   * @param args the prepared statement arguments
   * @return the result future
   */
  def batchWithParamsFuture(sqlStatement: String, args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String], args.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Batch a callable statement with all entries from the args list. Each entry is a batch.
   * The size of the lists inArgs and outArgs MUST be the equal.
   * The operation completes with the execution of the batch where the async result contains a array of Integers.
   * @param sqlStatement sql statement
   * @param inArgs the callable statement input arguments
   * @param outArgs the callable statement output arguments
   * @return the result future
   */
  def batchCallableWithParamsFuture(sqlStatement: String, inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray], outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]): scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String], inArgs.asJava, outArgs.asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Attempts to change the transaction isolation level for this Connection object to the one given.
   *
   * The constants defined in the interface Connection are the possible transaction isolation levels.
   * @param isolation the level of isolation
   * @return the future called when this operation completes.
   */
  def setTransactionIsolationFuture(isolation: io.vertx.ext.sql.TransactionIsolation): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Attempts to return the transaction isolation level for this Connection object to the one given.
   * @return the future called when this operation completes.
   */
  def getTransactionIsolationFuture(): scala.concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x => x)
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLConnection {
  def apply(asJava: JSQLConnection) = new SQLConnection(asJava)  
}
