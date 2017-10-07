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
import io.vertx.ext.sql.{SQLOperations => JSQLOperations}
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}

/**
  * A common asynchronous client interface for interacting with SQL compliant database
  */
class SQLClient(private val _asJava: Object)
    extends  SQLOperations  {

  def asJava = _asJava

  /**
    * Execute a one shot SQL statement that returns a single SQL row. This method will reduce the boilerplate code by
    * getting a connection from the pool (this object) and return it back after the execution. Only the first result
    * from the result set is returned.
    * @param sql the statement to execute
    * @param handler the result handler
    * @return self
    */
  override def querySingle(sql: String, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): SQLOperations = {
    asJava.asInstanceOf[JSQLClient].querySingle(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Execute a one shot SQL statement with arguments that returns a single SQL row. This method will reduce the
    * boilerplate code by getting a connection from the pool (this object) and return it back after the execution.
    * Only the first result from the result set is returned.
    * @param sql the statement to execute
    * @param arguments the arguments
    * @param handler the result handler
    * @return self
    */
  override def querySingleWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[io.vertx.core.json.JsonArray]]): SQLOperations = {
    asJava.asInstanceOf[JSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, io.vertx.core.json.JsonArray](x, a => a))})
    this
  }

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember
    * to close the connection when you are done, so it is returned to the pool.
    * @param handler the handler which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnection(handler: Handler[AsyncResult[SQLConnection]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].getConnection({x: AsyncResult[JSQLConnection] => handler.handle(AsyncResultWrapper[JSQLConnection, SQLConnection](x, a => SQLConnection(a)))})
    this
  }

  /**
    * Execute a single SQL statement, this method acquires a connection from the the pool and executes the SQL
    * statement and returns it back after the execution.
    * @param sql the statement to execute
    * @param handler the result handler
    * @return self
    */
  override def query(sql: String, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].query(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
    * Execute a single SQL prepared statement, this method acquires a connection from the the pool and executes the SQL
    * prepared statement and returns it back after the execution.
    * @param sql the statement to execute
    * @param arguments the arguments to the statement
    * @param handler the result handler
    * @return self
    */
  override def queryWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].queryWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
    * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement.
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param handler the handler which is called once the operation completes.
    */
  override def update(sql: String, handler: Handler[AsyncResult[UpdateResult]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].update(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JUpdateResult] => handler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
    * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    * statement with the given parameters
    * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    * @param params these are the parameters to fill the statement.
    * @param handler the handler which is called once the operation completes.
    */
  override def updateWithParams(sql: String, params: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[UpdateResult]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].updateWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JUpdateResult] => handler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
    * Close the client and release all resources.
    * Call the handler when close is complete.
    * @param handler the handler that will be called when close is complete
    */
  def close(handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSQLClient].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Close the client
    */
  def close(): Unit = {
    asJava.asInstanceOf[JSQLClient].close()
  }

 /**
   * Like [[querySingle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def querySingleFuture(sql: String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JSQLClient].querySingle(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[querySingleWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def querySingleWithParamsFuture(sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, io.vertx.core.json.JsonArray](x => x)
    asJava.asInstanceOf[JSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[getConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getConnectionFuture(): scala.concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection, SQLConnection](x => SQLConnection(x))
    asJava.asInstanceOf[JSQLClient].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def queryFuture(sql: String): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[queryWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def queryWithParamsFuture(sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].queryWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def updateFuture(sql: String): scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLClient].update(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[updateWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  override def updateWithParamsFuture(sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLClient].updateWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLClient {
  def apply(asJava: JSQLClient) = new SQLClient(asJava)  
}
