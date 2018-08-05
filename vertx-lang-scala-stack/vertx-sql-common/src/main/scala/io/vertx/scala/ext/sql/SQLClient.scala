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
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.lang.scala.Converter._
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._

/**
  * A common asynchronous client interface for interacting with SQL compliant database
  */

class SQLClient(private val _asJava: Object) extends SQLOperations {
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
    asJava.asInstanceOf[JSQLClient].querySingle(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))})
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
    asJava.asInstanceOf[JSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))})
    this
  }

  /**
   * Returns a connection that can be used to perform SQL operations on. It's important to remember
   * to close the connection when you are done, so it is returned to the pool.   * @param handler the handler which is called when the <code>JdbcConnection</code> object is ready for use.
   */
  
  def getConnection(handler: Handler[AsyncResult[SQLConnection]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].getConnection({x: AsyncResult[JSQLConnection] => handler.handle(AsyncResultWrapper[JSQLConnection, SQLConnection](x, a => SQLConnection(a)))})
    this
  }

  /**
   * Execute a single SQL statement, this method acquires a connection from the the pool and executes the SQL
   * statement and returns it back after the execution.   * @param sql the statement to execute
   * @param handler the result handler
   * @return self
   */
  override 
  def query(sql: String, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].query(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param handler the handler which is called once the operation completes. It will return a `SQLRowStream`.
   */
  override 
  def queryStream(sql: String, handler: Handler[AsyncResult[SQLRowStream]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].queryStream(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  /**
   * Executes the given SQL <code>SELECT</code> statement which returns the results of the query as a read stream.   * @param sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
   * @param params these are the parameters to fill the statement.
   * @param handler the handler which is called once the operation completes. It will return a `SQLRowStream`.
   */
  override 
  def queryStreamWithParams(sql: String, params: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[SQLRowStream]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream, SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  /**
   * Execute a single SQL prepared statement, this method acquires a connection from the the pool and executes the SQL
   * prepared statement and returns it back after the execution.   * @param sql the statement to execute
   * @param arguments the arguments to the statement
   * @param handler the result handler
   * @return self
   */
  override 
  def queryWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].queryWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }

  /**
   * Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement.   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param handler the handler which is called once the operation completes.
   */
  override 
  def update(sql: String, handler: Handler[AsyncResult[UpdateResult]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].update(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JUpdateResult] => handler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
   * Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
   * statement with the given parameters   * @param sql the SQL to execute. For example <code>INSERT INTO table ...</code>
   * @param params these are the parameters to fill the statement.
   * @param handler the handler which is called once the operation completes.
   */
  override 
  def updateWithParams(sql: String, params: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[UpdateResult]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].updateWithParams(sql.asInstanceOf[java.lang.String], params, {x: AsyncResult[JUpdateResult] => handler.handle(AsyncResultWrapper[JUpdateResult, UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  /**
   * Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.   * @param sql the SQL to execute. For example <code>{call getEmpName`</code>.
   * @param handler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def call(sql: String, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].call(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
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
   * @param handler the handler which is called once the operation completes. It will return a `ResultSet`.
   */
  override 
  def callWithParams(sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[ResultSet]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, {x: AsyncResult[JResultSet] => handler.handle(AsyncResultWrapper[JResultSet, ResultSet](x, a => ResultSet(a)))})
    this
  }



  /**
   * Close the client and release all resources.
   * Call the handler when close is complete.   * @param handler the handler that will be called when close is complete
   */
  def close (handler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSQLClient].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Close the client
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSQLClient].close()
  }


 /**
  * Like [[querySingle]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def querySingleFuture (sql: String): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JSQLClient].querySingle(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[querySingleWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def querySingleWithParamsFuture (sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getConnectionFuture (): scala.concurrent.Future[SQLConnection] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection, SQLConnection](x => SQLConnection(x))
    asJava.asInstanceOf[JSQLClient].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryFuture (sql: String): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryStream]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryStreamFuture (sql: String): scala.concurrent.Future[SQLRowStream] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLClient].queryStream(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryStreamWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryStreamWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[SQLRowStream] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => SQLRowStream(x))
    asJava.asInstanceOf[JSQLClient].queryStreamWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[queryWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def queryWithParamsFuture (sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].queryWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[update]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def updateFuture (sql: String): scala.concurrent.Future[UpdateResult] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLClient].update(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[updateWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def updateWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray): scala.concurrent.Future[UpdateResult] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => UpdateResult(x))
    asJava.asInstanceOf[JSQLClient].updateWithParams(sql.asInstanceOf[java.lang.String], params, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[call]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def callFuture (sql: String): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].call(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[callWithParams]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def callWithParamsFuture (sql: String, params: io.vertx.core.json.JsonArray, outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[ResultSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => ResultSet(x))
    asJava.asInstanceOf[JSQLClient].callWithParams(sql.asInstanceOf[java.lang.String], params, outputs, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLClient {
  def apply(asJava: JSQLClient) = new SQLClient(asJava)
  
}
