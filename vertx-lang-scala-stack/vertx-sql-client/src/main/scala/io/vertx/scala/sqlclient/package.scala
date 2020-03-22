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

import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.sqlclient.{SqlClient => JSqlClient}
import io.vertx.core
import io.vertx.core.{Future => JFuture}
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.sqlclient.{Transaction => JTransaction}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}

package object sqlclient{


  /**
    * A cursor that reads progressively rows from the database, it is useful for reading very large result sets.

    */

  implicit class CursorScala(val asJava: io.vertx.sqlclient.Cursor) extends AnyVal {

    /**
     * Like read from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def readFuture(count: java.lang.Integer) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.read(count, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like close from [[io.vertx.sqlclient.Cursor]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  /**
    * A connection pool which reuses a number of SQL connections.
    */

  implicit class PoolScala(val asJava: io.vertx.sqlclient.Pool) extends AnyVal {

    /**
     * Like query from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedBatch from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like getConnection from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def getConnectionFuture() : scala.concurrent.Future[io.vertx.sqlclient.SqlConnection] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.SqlConnection]()
      asJava.getConnection(new Handler[AsyncResult[io.vertx.sqlclient.SqlConnection]] { override def handle(event: AsyncResult[io.vertx.sqlclient.SqlConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like begin from [[io.vertx.sqlclient.Pool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def beginFuture() : scala.concurrent.Future[io.vertx.sqlclient.Transaction] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.Transaction]()
      asJava.begin(new Handler[AsyncResult[io.vertx.sqlclient.Transaction]] { override def handle(event: AsyncResult[io.vertx.sqlclient.Transaction]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  type PoolOptions = io.vertx.sqlclient.PoolOptions
  object PoolOptions {
    def apply() = new PoolOptions()
    def apply(json: JsonObject) = new PoolOptions(json)
  }




  /**
    * A prepared statement, the statement is pre-compiled and
    * it's more efficient to execute the statement for multiple times.
    * In addition, this kind of statement provides protection against SQL injection attacks.
    */

  implicit class PreparedQueryScala(val asJava: io.vertx.sqlclient.PreparedQuery) extends AnyVal {

    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def executeFuture() : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.execute(new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like execute from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def executeFuture(args: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.execute(args, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like batch from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def batchFuture(argsList: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.batch(argsList, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like close from [[io.vertx.sqlclient.PreparedQuery]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }











  /**
    * A row oriented stream.

    */

  implicit class RowStreamScala[T](val asJava: io.vertx.sqlclient.RowStream[T]) extends AnyVal {

def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      scala.Option(asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]))
}

def handler(handler: scala.Option[T => Unit]) = {
      scala.Option(asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[T]]))
}

def endHandler(endHandler: scala.Option[Void => Unit]) = {
      scala.Option(asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]))
}

def pipeToFuture(dst: io.vertx.core.streams.WriteStream[T]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like close from [[io.vertx.sqlclient.RowStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }



  /**
    * Defines common SQL client operations with a database server.
    */

  implicit class SqlClientScala(val asJava: io.vertx.sqlclient.SqlClient) extends AnyVal {

    /**
     * Like query from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedQuery from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like preparedBatch from [[io.vertx.sqlclient.SqlClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }







  /**
    * A connection to the database server.
    */

  implicit class SqlConnectionScala(val asJava: io.vertx.sqlclient.SqlConnection) extends AnyVal {

    /**
     * Like prepare from [[io.vertx.sqlclient.SqlConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedQuery]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedQuery]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }





  /**
    * A transaction that allows to control the transaction and receive events.

    */

  implicit class TransactionScala(val asJava: io.vertx.sqlclient.Transaction) extends AnyVal {

    /**
     * Like prepare from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def prepareFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(sql, new Handler[AsyncResult[io.vertx.sqlclient.PreparedQuery]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedQuery]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like commit from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def commitFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commit(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

    /**
     * Like rollback from [[io.vertx.sqlclient.Transaction]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def rollbackFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.rollback(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedQueryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedQueryFuture(sql: java.lang.String,arguments: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(sql, arguments, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

def preparedBatchFuture(sql: java.lang.String,batch: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(sql, batch, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}

  }


  object Tuple {
    /**
     * Like tuple from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def tuple() = {
      io.vertx.sqlclient.Tuple.tuple()
}
    /**
     * Like wrap from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def wrap(list: java.util.List[AnyRef]) = {
      io.vertx.sqlclient.Tuple.wrap(list)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef,elt2: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4, elt5)
}
    /**
     * Like of from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def of(elt1: AnyRef,elt2: AnyRef,elt3: AnyRef,elt4: AnyRef,elt5: AnyRef,elt6: AnyRef) = {
      io.vertx.sqlclient.Tuple.of(elt1, elt2, elt3, elt4, elt5, elt6)
}
    /**
     * Like tuple from [[io.vertx.sqlclient.Tuple]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */def tuple(elements: java.util.List[AnyRef]) = {
      io.vertx.sqlclient.Tuple.tuple(elements)
}
  }


}
