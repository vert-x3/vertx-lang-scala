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

import io.vertx.sqlclient
import io.vertx.sqlclient.{PropertyKind => JPropertyKind}
import io.vertx.mysqlclient.{MySQLClient => JMySQLClient}

package object mysqlclient{


  type MySQLAuthOptions = io.vertx.mysqlclient.MySQLAuthOptions
  object MySQLAuthOptions {
    def apply() = new MySQLAuthOptions()
    def apply(json: JsonObject) = new MySQLAuthOptions(json)
  }






  type MySQLConnectOptions = io.vertx.mysqlclient.MySQLConnectOptions
  object MySQLConnectOptions {
    def apply() = new MySQLConnectOptions()
    def apply(json: JsonObject) = new MySQLConnectOptions(json)
  }




  /**
    * A connection to MySQL server.

    */

  implicit class MySQLConnectionScala(val asJava: io.vertx.mysqlclient.MySQLConnection) extends AnyVal {

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

    /**
     * Like [[ping]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def pingFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.ping({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[specifySchema]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def specifySchemaFuture(schemaName: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.specifySchema(schemaName, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[getInternalStatistics]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def getInternalStatisticsFuture(): scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.getInternalStatistics({a:AsyncResult[java.lang.String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[setOption]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def setOptionFuture(option: io.vertx.mysqlclient.MySQLSetOption): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setOption(option, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[resetConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def resetConnectionFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.resetConnection({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[debug]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def debugFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.debug({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[changeUser]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
     */
    def changeUserFuture(options: io.vertx.mysqlclient.MySQLAuthOptions): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.changeUser(options, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * A pool of MySQL connections.

    */

  implicit class MySQLPoolScala(val asJava: io.vertx.mysqlclient.MySQLPool) extends AnyVal {

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


}
