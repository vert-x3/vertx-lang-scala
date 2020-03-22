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

import io.vertx.sqlclient
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.core
import io.vertx.mssqlclient.{MSSQLConnectOptions => JMSSQLConnectOptions}
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.sqlclient.{PoolOptions => JPoolOptions}
import io.vertx.sqlclient.{Pool => JPool}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.mssqlclient.{MSSQLPool => JMSSQLPool}
import io.vertx.core.{Vertx => JVertx}
package object mssqlclient{


  type MSSQLConnectOptions = io.vertx.mssqlclient.MSSQLConnectOptions
  object MSSQLConnectOptions {
    def apply() = new MSSQLConnectOptions()
    def apply(json: JsonObject) = new MSSQLConnectOptions(json)
  }




  /**
    * A connection to Microsoft SQL Server.

    */

  implicit class MSSQLConnectionScala(val asJava: io.vertx.mssqlclient.MSSQLConnection) extends AnyVal {


    /**
     * Like prepare from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def prepareFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.PreparedQuery] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.PreparedQuery]()
      asJava.prepare(s, new Handler[AsyncResult[io.vertx.sqlclient.PreparedQuery]] { override def handle(event: AsyncResult[io.vertx.sqlclient.PreparedQuery]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(s, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(s, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(s: java.lang.String,tuple: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(s, tuple, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedBatch from [[io.vertx.mssqlclient.MSSQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedBatchFuture(s: java.lang.String,list: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(s, list, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }




  /**
    * A  of [[io.vertx.mssqlclient.MSSQLConnection]].

    */

  implicit class MSSQLPoolScala(val asJava: io.vertx.mssqlclient.MSSQLPool) extends AnyVal {


    /**
     * Like preparedQuery from [[io.vertx.mssqlclient.MSSQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(s, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.mssqlclient.MSSQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(s: java.lang.String) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.query(s, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedQuery from [[io.vertx.mssqlclient.MSSQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedQueryFuture(s: java.lang.String,tuple: io.vertx.sqlclient.Tuple) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedQuery(s, tuple, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like preparedBatch from [[io.vertx.mssqlclient.MSSQLPool]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def preparedBatchFuture(s: java.lang.String,list: java.util.List[io.vertx.sqlclient.Tuple]) : scala.concurrent.Future[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]] = {
      val promise = concurrent.Promise[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]()
      asJava.preparedBatch(s, list, new Handler[AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]] { override def handle(event: AsyncResult[io.vertx.sqlclient.RowSet[io.vertx.sqlclient.Row]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



}
