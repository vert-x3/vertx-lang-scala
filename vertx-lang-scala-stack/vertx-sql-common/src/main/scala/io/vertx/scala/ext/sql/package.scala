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

package io.vertx.scala.ext

import scala.collection.JavaConverters._
import io.vertx.core.json.JsonObject
import io.vertx.core.json.JsonArray
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import scala.concurrent.Promise

import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{SQLOperations => JSQLOperations}
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

package object sql{


  type ResultSet = io.vertx.ext.sql.ResultSet
  object ResultSet {
    def apply() = new ResultSet()
    def apply(json: JsonObject) = new ResultSet(json)
  }




  /**
    * A common asynchronous client interface for interacting with SQL compliant database
    */

  implicit class SQLClientScala(val asJava: io.vertx.ext.sql.SQLClient) extends AnyVal {

    /**
     * Like querySingle from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like getConnection from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getConnectionFuture(): scala.concurrent.Future[io.vertx.ext.sql.SQLConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLConnection]()
      asJava.getConnection({a:AsyncResult[io.vertx.ext.sql.SQLConnection] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like query from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, arguments, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like update from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like call from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * Represents a connection to a SQL database
    */

  implicit class SQLConnectionScala(val asJava: io.vertx.ext.sql.SQLConnection) extends AnyVal {

    /**
     * Like querySingle from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like setAutoCommit from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def setAutoCommitFuture(autoCommit: java.lang.Boolean): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setAutoCommit(autoCommit, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like execute from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def executeFuture(sql: java.lang.String): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.execute(sql, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like query from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like update from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like call from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like commit from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def commitFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commit({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like rollback from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def rollbackFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.rollback({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like batch from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def batchFuture(sqlStatements: java.util.List[java.lang.String]): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.Integer]]()
      asJava.batch(sqlStatements, {a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like batchWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def batchWithParamsFuture(sqlStatement: java.lang.String,args: java.util.List[io.vertx.core.json.JsonArray]): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.Integer]]()
      asJava.batchWithParams(sqlStatement, args, {a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like batchCallableWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def batchCallableWithParamsFuture(sqlStatement: java.lang.String,inArgs: java.util.List[io.vertx.core.json.JsonArray],outArgs: java.util.List[io.vertx.core.json.JsonArray]): scala.concurrent.Future[java.util.List[java.lang.Integer]] = {
      val promise = concurrent.Promise[java.util.List[java.lang.Integer]]()
      asJava.batchCallableWithParams(sqlStatement, inArgs, outArgs, {a:AsyncResult[java.util.List[java.lang.Integer]] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like setTransactionIsolation from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def setTransactionIsolationFuture(isolation: io.vertx.ext.sql.TransactionIsolation): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setTransactionIsolation(isolation, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like getTransactionIsolation from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def getTransactionIsolationFuture(): scala.concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.TransactionIsolation]()
      asJava.getTransactionIsolation({a:AsyncResult[io.vertx.ext.sql.TransactionIsolation] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  /**
    * Represents a SQL query interface to a database
    */

  implicit class SQLOperationsScala(val asJava: io.vertx.ext.sql.SQLOperations) extends AnyVal {

    /**
     * Like query from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.SQLRowStream] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like querySingle from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, {a:AsyncResult[io.vertx.core.json.JsonArray] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like update from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, {a:AsyncResult[io.vertx.ext.sql.UpdateResult] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like call from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callFuture(sql: java.lang.String): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray): scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, {a:AsyncResult[io.vertx.ext.sql.ResultSet] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type SQLOptions = io.vertx.ext.sql.SQLOptions
  object SQLOptions {
    def apply() = new SQLOptions()
    def apply(json: JsonObject) = new SQLOptions(json)
  }




  /**
    * A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
    * close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
    * full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
    * resources.
    *
    * The interface is minimal in order to support all SQL clients not just JDBC.

    */

  implicit class SQLRowStreamScala(val asJava: io.vertx.ext.sql.SQLRowStream) extends AnyVal {


    def exceptionHandler(handler: scala.Option[Throwable => Unit]): io.vertx.ext.sql.SQLRowStream = {
      asJava.exceptionHandler(handler match {case Some(t) => p:Throwable => t(p); case None => null})
    }


    def handler(handler: scala.Option[io.vertx.core.json.JsonArray => Unit]): io.vertx.ext.sql.SQLRowStream = {
      asJava.handler(handler match {case Some(t) => p:io.vertx.core.json.JsonArray => t(p); case None => null})
    }


    def endHandler(endHandler: scala.Option[Void => Unit]): io.vertx.ext.sql.SQLRowStream = {
      asJava.endHandler(endHandler match {case Some(t) => p:Void => t(p); case None => null})
    }

    def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.json.JsonArray]): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, {a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like close from [[io.vertx.ext.sql.SQLRowStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close({a:AsyncResult[java.lang.Void] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

  }



  type UpdateResult = io.vertx.ext.sql.UpdateResult
  object UpdateResult {
    def apply() = new UpdateResult()
    def apply(json: JsonObject) = new UpdateResult(json)
  }



}
