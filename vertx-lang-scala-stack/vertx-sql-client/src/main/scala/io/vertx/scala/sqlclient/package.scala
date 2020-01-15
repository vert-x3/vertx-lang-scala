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

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.core
import io.vertx.core.{Future => JFuture}
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}

package object sqlclient{


  /**
    * A cursor that reads progressively rows from the database, it is useful for reading very large result sets.

    */

  implicit class CursorScala(val asJava: io.vertx.sqlclient.Cursor) extends AnyVal {

    /**
     * Like read from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def readFuture(count: java.lang.Integer): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.read(count, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * A pool of SQL connections.
    */

  implicit class PoolScala(val asJava: io.vertx.sqlclient.Pool) extends AnyVal {

    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like getConnection from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getConnectionFuture(): scala.concurrent.Future[io.vertx.sqlclient.SqlConnection] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.SqlConnection]()
      asJava.getConnection({a:AsyncResult[io.vertx.sqlclient.SqlConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like begin from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def beginFuture(): scala.concurrent.Future[io.vertx.sqlclient.Transaction] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.Transaction]()
      asJava.begin({a:AsyncResult[io.vertx.sqlclient.Transaction] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type PoolOptions = io.vertx.sqlclient.PoolOptions
  object PoolOptions {
    def apply() = new PoolOptions()
    def apply(json: JsonObject) = new PoolOptions(json)
  }




  /**
    * A prepared query.
    */

  implicit class PreparedQueryScala(val asJava: io.vertx.sqlclient.PreparedQuery) extends AnyVal {

    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def executeFuture(): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.execute({a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def executeFuture(args: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.execute(args, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like batch from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def batchFuture(argsList: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.batch(argsList, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }











  /**
    * A row oriented stream.

    */

  implicit class RowStreamScala[T](val asJava: io.vertx.sqlclient.RowStream[T]) extends AnyVal {


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.sqlclient.RowStream[T] = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[T => Unit]): io.vertx.sqlclient.RowStream[T] = {
      asJava.handler(handler match {case Some(t) => p:T => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.sqlclient.RowStream[T] = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[T]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.sqlclient.RowStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * Defines the client operations with a database server.
    */

  implicit class SqlClientScala(val asJava: io.vertx.sqlclient.SqlClient) extends AnyVal {

    /**
     * Like query from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like preparedBatch from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }







  /**
    * A connection to database server.
    */

  implicit class SqlConnectionScala(val asJava: io.vertx.sqlclient.SqlConnection) extends AnyVal {

    /**
     * Like prepare from [[io.vertx.sqlclient.SqlConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def prepareFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, {a:AsyncResult[io.vertx.sqlclient.PreparedQuery] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }





  /**
    * A transaction that allows to control the transaction and receive events.

    */

  implicit class TransactionScala(val asJava: io.vertx.sqlclient.Transaction) extends AnyVal {

    /**
     * Like prepare from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def prepareFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, {a:AsyncResult[io.vertx.sqlclient.PreparedQuery] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like commit from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def commitFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commit({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like rollback from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def rollbackFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.rollback({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]): scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, {a:AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
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
    def wrap(list: java.util.List[AnyRef]) = {
      io.vertx.sqlclient.Tuple.wrap(list)
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
    def of(elt1: AnyRef,elt2: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2)
    }
    /**
     * Create a tuple of three elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @param elt3 the third value
     * @return the tuple
     */
    def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3)
    }
    /**
     * Create a tuple of four elements.     * @param elt1 the first value
     * @param elt2 the second value
     * @param elt3 the third value
     * @param elt4 the fourth value
     * @return the tuple
     */
    def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef) = {
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
    def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef) = {
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
    def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef,elt6: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4, elt5, elt6)
    }
    /**
     * Create a tuple with the provided `elements` list.
     * <p/>
     * The `elements` list is not modified.     * @param elements the list of elements
     * @return the tuple
     */
    def tuple(elements: java.util.List[AnyRef]) = {
      io.vertx.sqlclient.Tuple.tuple(elements)
    }
  }


}
