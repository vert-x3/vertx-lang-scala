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
import io.vertx.sqlclient.{PreparedStatement => JPreparedStatement}
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.sqlclient.{Query => JQuery}
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
  
  def prepare(sql: String, handler: Handler[AsyncResult[PreparedStatement]]): SqlConnection = {
    asJava.asInstanceOf[JSqlConnection].prepare(sql.asInstanceOf[java.lang.String], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JPreparedStatement]]{def handle(x: AsyncResult[JPreparedStatement]) {handler.handle(AsyncResultWrapper[JPreparedStatement, PreparedStatement](x, a => PreparedStatement(a)))}}))
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
  def prepareFuture (sql: String): scala.concurrent.Future[PreparedStatement] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JPreparedStatement, PreparedStatement](x => PreparedStatement(x))
    asJava.asInstanceOf[JSqlConnection].prepare(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SqlConnection {
  def apply(asJava: JSqlConnection) = new SqlConnection(asJava)

}
