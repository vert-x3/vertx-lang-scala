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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
    import io.vertx.core.json.JsonArray
    import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
  import io.vertx.ext.sql.{ResultSet => JResultSet}
  import io.vertx.ext.sql.TransactionIsolation
  import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
          
/**
  * Represents a connection to a SQL database
  */
class SQLConnection(private val _asJava: JSQLConnection) {

  def asJava: JSQLConnection = _asJava

  /**
    * Sets the auto commit flag for this connection. True by default.
    * @param autoCommit the autoCommit flag, true by default.
    * @return the future which is called once this operation completes.
    */
  def setAutoCommitFuture(autoCommit: Boolean): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.setAutoCommit(autoCommit, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Executes the given SQL statement
    * @param sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
    * @return the future which is called once this operation completes.
    */
  def executeFuture(sql: String): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.execute(sql, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @return the future which is called once the operation completes. It will return a `ResultSet`.
    */
  def queryFuture(sql: String): concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet,ResultSet]((x => io.vertx.scala.ext.sql.ResultSet(x)))
    _asJava.query(sql, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
    * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    * @param params these are the parameters to fill the statement.
    * @return the future which is called once the operation completes. It will return a `ResultSet`.
    */
  def queryWithParamsFuture(sql: String, params: JsonArray): concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet,ResultSet]((x => io.vertx.scala.ext.sql.ResultSet(x)))
    _asJava.queryWithParams(sql, params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement.
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @return the future which is called once the operation completes.
    */
  def updateFuture(sql: String): concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult,UpdateResult]((x => io.vertx.scala.ext.sql.UpdateResult(x)))
    _asJava.update(sql, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement with the given parameters
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param params these are the parameters to fill the statement.
    * @return the future which is called once the operation completes.
    */
  def updateWithParamsFuture(sql: String, params: JsonArray): concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult,UpdateResult]((x => io.vertx.scala.ext.sql.UpdateResult(x)))
    _asJava.updateWithParams(sql, params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    * @param sql the SQL to execute. For example <code>{call getEmpName (?, ?)`</code>.
    * @return the future which is called once the operation completes. It will return a `ResultSet`.
    */
  def callFuture(sql: String): concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet,ResultSet]((x => io.vertx.scala.ext.sql.ResultSet(x)))
    _asJava.call(sql, promiseAndHandler._1)
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
  def callWithParamsFuture(sql: String, params: JsonArray, outputs: JsonArray): concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet,ResultSet]((x => io.vertx.scala.ext.sql.ResultSet(x)))
    _asJava.callWithParams(sql, params, outputs, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    * @return the future called when this operation completes.
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Commits all changes made since the previous commit/rollback.
    * @return the future called when this operation completes.
    */
  def commitFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Rolls back all changes made since the previous commit/rollback.
    * @return the future called when this operation completes.
    */
  def rollbackFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.rollback(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Sets a connection wide query timeout.
    *
    * It can be over written at any time and becomes active on the next query call.
    * @param timeoutInSeconds the max amount of seconds the query can take to execute.
    */
  def setQueryTimeout(timeoutInSeconds: Int): SQLConnection = {
    _asJava.setQueryTimeout(timeoutInSeconds)
    this
  }

  /**
    * Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
    * @param sqlStatements sql statement
    * @return the result future
    */
  def batchFuture(sqlStatements: scala.collection.mutable.Buffer[String]): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asScala.map(x => x:Int)))
    _asJava.batch(sqlStatements.map(x => if (x == null) null else x:java.lang.String).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Batch a prepared statement with all entries from the args list. Each entry is a batch.
    * The operation completes with the execution of the batch where the async result contains a array of Integers.
    * @param sqlStatement sql statement
    * @param args the prepared statement arguments
    * @return the result future
    */
  def batchWithParamsFuture(sqlStatement: String, args: scala.collection.mutable.Buffer[JsonArray]): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asScala.map(x => x:Int)))
    _asJava.batchWithParams(sqlStatement, args.map(x => if (x == null) null else x:io.vertx.core.json.JsonArray).asJava, promiseAndHandler._1)
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
  def batchCallableWithParamsFuture(sqlStatement: String, inArgs: scala.collection.mutable.Buffer[JsonArray], outArgs: scala.collection.mutable.Buffer[JsonArray]): concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]]((x => if (x == null) null else x.asScala.map(x => x:Int)))
    _asJava.batchCallableWithParams(sqlStatement, inArgs.map(x => if (x == null) null else x:io.vertx.core.json.JsonArray).asJava, outArgs.map(x => if (x == null) null else x:io.vertx.core.json.JsonArray).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Attempts to change the transaction isolation level for this Connection object to the one given.
    *
    * The constants defined in the interface Connection are the possible transaction isolation levels.
    * @param isolation the level of isolation
    * @return the future called when this operation completes.
    */
  def setTransactionIsolationFuture(isolation: io.vertx.ext.sql.TransactionIsolation): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.setTransactionIsolation(isolation, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Attempts to return the transaction isolation level for this Connection object to the one given.
    * @return the future called when this operation completes.
    */
  def getTransactionIsolationFuture(): concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TransactionIsolation,io.vertx.ext.sql.TransactionIsolation]((x => x))
    _asJava.getTransactionIsolation(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLConnection {

  def apply(_asJava: JSQLConnection): SQLConnection =
    new SQLConnection(_asJava)

}
