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


package io.vertx.scala

import scala.jdk.CollectionConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.sqlclient.spi.{DatabaseMetadata => JDatabaseMetadata}
package object sqlclient{



  /**
    * A cursor that reads progressively rows from the database, it is useful for reading very large result sets.

    */

  implicit class CursorScala(val asJava: io.vertx.sqlclient.Cursor) extends AnyVal {


    /**
     * Like read from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def readFuture(count: java.lang.Integer) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]/*io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row] API*/()
      asJava.read(count, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * A connection pool which reuses a number of SQL connections.
    */

  implicit class PoolScala(val asJava: io.vertx.sqlclient.Pool) extends AnyVal {


    /**
     * Like getConnection from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def getConnectionFuture() : scala.concurrent.Future[io.vertx.sqlclient.SqlConnection] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.SqlConnection]/*io.vertx.sqlclient.SqlConnection API*/()
      asJava.getConnection(new Handler[AsyncResult[io.vertx.sqlclient.SqlConnection]] { override def handle(event: AsyncResult[io.vertx.sqlclient.SqlConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like withTransaction from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def withTransactionFuture[T](function: io.vertx.sqlclient.SqlClient => io.vertx.core.Future[T]) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]/*T OBJECT*/()
      asJava.withTransaction[T]({x: io.vertx.sqlclient.SqlClient => function(x)}, new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type PoolOptions = io.vertx.sqlclient.PoolOptions
  object PoolOptions {
    def apply() = new PoolOptions()
    def apply(json: JsonObject) = new PoolOptions(json)
  }




  /**
    * A query for a prepared statement allowing parameterized execution of the query, this query will use
    * a prepared statement.
    */

  implicit class PreparedQueryScala[T](val asJava: io.vertx.sqlclient.PreparedQuery[T]) extends AnyVal {


    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def executeFuture() : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]/*T OBJECT*/()
      asJava.execute(new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def executeFuture(tuple: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]/*T OBJECT*/()
      asJava.execute(tuple, new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like executeBatch from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def executeBatchFuture(batch: scala.collection.mutable.Buffer[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]/*T OBJECT*/()
      asJava.executeBatch(batch.asJava, new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * A prepared statement, the statement is pre-compiled and it's more efficient to execute the statement for multiple times.
    * In addition, this kind of statement provides protection against SQL injection attacks.
    *
    * From a prepared statement you can
    *
    * <ul>
    *   <li>use [[io.vertx.sqlclient.PreparedStatement#query]] to create and execute a [[io.vertx.sqlclient.PreparedQuery]]</li>
    *   <li>use [[io.vertx.sqlclient.PreparedStatement#cursor]] to create a [[io.vertx.sqlclient.Cursor]]</li>
    *   <li>use [[io.vertx.sqlclient.PreparedStatement#createStream]] to create a [[io.vertx.sqlclient.RowStream]]</li>
    * </ul>
    */

  implicit class PreparedStatementScala(val asJava: io.vertx.sqlclient.PreparedStatement) extends AnyVal {


    /**
     * Like close from [[io.vertx.sqlclient.PreparedStatement]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * A query.
    */

  implicit class QueryScala[T](val asJava: io.vertx.sqlclient.Query[T]) extends AnyVal {


    /**
     * Like execute from [[io.vertx.sqlclient.Query]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def executeFuture() : scala.concurrent.Future[T] = {
      val promise = concurrent.Promise[T]/*T OBJECT*/()
      asJava.execute(new Handler[AsyncResult[T]] { override def handle(event: AsyncResult[T]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }










  /**
    * A row oriented stream.

    */

  implicit class RowStreamScala[T](val asJava: io.vertx.sqlclient.RowStream[T]) extends AnyVal {

  def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
  }

  def handler(handler: scala.Option[T => Unit]) = {
      asJava.handler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[T]]).getOrElse(null))
  }

  def endHandler(endHandler: scala.Option[Void => Unit]) = {
      asJava.endHandler(endHandler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]).getOrElse(null))
  }

  def pipeToFuture(dst: io.vertx.core.streams.WriteStream[T]) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.sqlclient.RowStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }




  /**
    * Defines common SQL client operations with a database server.
    */

  implicit class SqlClientScala(val asJava: io.vertx.sqlclient.SqlClient) extends AnyVal {


    /**
     * Like close from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  type SqlConnectOptions = io.vertx.sqlclient.SqlConnectOptions
  object SqlConnectOptions {
    def apply() = new SqlConnectOptions()
    def apply(json: JsonObject) = new SqlConnectOptions(json)
  }




  /**
    * A connection to the database server.
    */

  implicit class SqlConnectionScala(val asJava: io.vertx.sqlclient.SqlConnection) extends AnyVal {


    /**
     * Like prepare from [[io.vertx.sqlclient.SqlConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedStatement] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedStatement]/*io.vertx.sqlclient.PreparedStatement API*/()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedStatement]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedStatement]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like begin from [[io.vertx.sqlclient.SqlConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def beginFuture() : scala.concurrent.Future[io.vertx.sqlclient.Transaction] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.Transaction]/*io.vertx.sqlclient.Transaction API*/()
      asJava.begin(new Handler[AsyncResult[io.vertx.sqlclient.Transaction]] { override def handle(event: AsyncResult[io.vertx.sqlclient.Transaction]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like close from [[io.vertx.sqlclient.SqlConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }






  /**
    * A transaction.

    */

  implicit class TransactionScala(val asJava: io.vertx.sqlclient.Transaction) extends AnyVal {


    /**
     * Like commit from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def commitFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.commit(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }

    /**
     * Like rollback from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
  def rollbackFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.rollback(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
  }


  }



  object Tuple {
    /**
     * @return a new empty tuple
     */
  def tuple() = {
      io.vertx.sqlclient.Tuple.tuple()
  }

    /**
     * Wrap the provided `list` with a tuple.
     * <br/>
     * The list is not copied and is used as store for tuple elements.     * @return the list wrapped as a tuple
     */
  def wrap(list: scala.collection.mutable.Buffer[AnyRef]) = {
      io.vertx.sqlclient.Tuple.wrap(list.asJava)
  }

    /**
     * Create a tuple of one element.     * @param elt1 the first value
     * @return the tuple
     */
  def of(elt1: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1)
  }

    /**
     * Create a tuple of two elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @return the tuple
     */
  def of(elt1: AnyRef, elt2: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2)
  }

    /**
     * Create a tuple of three elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @param elt3 the third value
     * @return the tuple
     */
  def of(elt1: AnyRef, elt2: AnyRef, elt3: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3)
  }

    /**
     * Create a tuple of four elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @param elt3 the third value
     * @param elt4 the fourth value
     * @return the tuple
     */
  def of(elt1: AnyRef, elt2: AnyRef, elt3: AnyRef, elt4: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4)
  }

    /**
     * Create a tuple of five elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @param elt3 the third value
     * @param elt4 the fourth value
     * @param elt5 the fifth value
     * @return the tuple
     */
  def of(elt1: AnyRef, elt2: AnyRef, elt3: AnyRef, elt4: AnyRef, elt5: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4, elt5)
  }

    /**
     * Create a tuple of six elements.     * @param elt1 the first value
     * @param elt2 the second valueg
     * @param elt3 the third value
     * @param elt4 the fourth value
     * @param elt5 the fifth value
     * @param elt6 the sixth value
     * @return the tuple
     */
  def of(elt1: AnyRef, elt2: AnyRef, elt3: AnyRef, elt4: AnyRef, elt5: AnyRef, elt6: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4, elt5, elt6)
  }

    /**
     * Create a tuple with the provided `elements` list.
     * <p/>
     * The `elements` list is not modified.     * @param elements the list of elements
     * @return the tuple
     */
  def tuple(elements: scala.collection.mutable.Buffer[AnyRef]) = {
      io.vertx.sqlclient.Tuple.tuple(elements.asJava)
  }
  }


}
