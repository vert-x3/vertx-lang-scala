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
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Defines the client operations with a database server.
  */

class SqlClient(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Execute a simple query.   * @param sql the query SQL
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def query(sql: String, handler: Handler[AsyncResult[RowSet]]): SqlClient = {
    asJava.asInstanceOf[JSqlClient].query(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Prepare and execute a query.   * @param sql the prepared query SQL
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def preparedQuery(sql: String, handler: Handler[AsyncResult[RowSet]]): SqlClient = {
    asJava.asInstanceOf[JSqlClient].preparedQuery(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Prepare and execute a query.   * @param sql the prepared query SQL
   * @param arguments the list of arguments
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def preparedQuery(sql: String, arguments: Tuple, handler: Handler[AsyncResult[RowSet]]): SqlClient = {
    asJava.asInstanceOf[JSqlClient].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Prepare and execute a createBatch.   * @param sql the prepared query SQL
   * @param batch the batch of tuples
   * @param handler the handler notified with the execution result
   * @return a reference to this, so the API can be used fluently
   */
  
  def preparedBatch(sql: String, batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet]]): SqlClient = {
    asJava.asInstanceOf[JSqlClient].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }



  /**
   * Close the client and release the associated resources.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JSqlClient].close()
  }


 /**
  * Like [[query]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def queryFuture (sql: String): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JSqlClient].query(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[preparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def preparedQueryFuture (sql: String): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JSqlClient].preparedQuery(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[preparedQuery]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def preparedQueryFuture (sql: String, arguments: Tuple): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JSqlClient].preparedQuery(sql.asInstanceOf[java.lang.String], arguments.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[preparedBatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def preparedBatchFuture (sql: String, batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JSqlClient].preparedBatch(sql.asInstanceOf[java.lang.String], batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SqlClient {
  def apply(asJava: JSqlClient) = new SqlClient(asJava)
  
}
