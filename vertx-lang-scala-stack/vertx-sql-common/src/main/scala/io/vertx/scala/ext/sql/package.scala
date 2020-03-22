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

import scala.jdk.CollectionConverters._
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
def querySingleFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getConnection from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getConnectionFuture() : scala.concurrent.Future[io.vertx.ext.sql.SQLConnection] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLConnection]()
      asJava.getConnection(new Handler[AsyncResult[io.vertx.ext.sql.SQLConnection]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLConnection]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like close from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, arguments, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like update from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like call from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLClient]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }




  /**
    * Represents a connection to a SQL database
    */

  implicit class SQLConnectionScala(val asJava: io.vertx.ext.sql.SQLConnection) extends AnyVal {


    /**
     * Like querySingle from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def querySingleFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like setAutoCommit from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setAutoCommitFuture(autoCommit: java.lang.Boolean) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setAutoCommit(autoCommit, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like execute from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def executeFuture(sql: java.lang.String) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.execute(sql, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like query from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like update from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like call from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like close from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like commit from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def commitFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.commit(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like rollback from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def rollbackFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.rollback(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like batch from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def batchFuture(sqlStatements: java.util.List[java.lang.String]) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.batch(sqlStatements, new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like batchWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def batchWithParamsFuture(sqlStatement: java.lang.String,args: java.util.List[io.vertx.core.json.JsonArray]) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.batchWithParams(sqlStatement, args, new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like batchCallableWithParams from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def batchCallableWithParamsFuture(sqlStatement: java.lang.String,inArgs: java.util.List[io.vertx.core.json.JsonArray],outArgs: java.util.List[io.vertx.core.json.JsonArray]) : scala.concurrent.Future[scala.collection.mutable.Buffer[java.lang.Integer]] = {
      val promise = concurrent.Promise[scala.collection.mutable.Buffer[java.lang.Integer]]()
      asJava.batchCallableWithParams(sqlStatement, inArgs, outArgs, new Handler[AsyncResult[java.util.List[java.lang.Integer]]] { override def handle(event: AsyncResult[java.util.List[java.lang.Integer]]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result().asScala)}})
      promise.future
}
    /**
     * Like setTransactionIsolation from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def setTransactionIsolationFuture(isolation: io.vertx.ext.sql.TransactionIsolation) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.setTransactionIsolation(isolation, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like getTransactionIsolation from [[io.vertx.ext.sql.SQLConnection]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def getTransactionIsolationFuture() : scala.concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.TransactionIsolation]()
      asJava.getTransactionIsolation(new Handler[AsyncResult[io.vertx.ext.sql.TransactionIsolation]] { override def handle(event: AsyncResult[io.vertx.ext.sql.TransactionIsolation]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }




  /**
    * Represents a SQL query interface to a database
    */

  implicit class SQLOperationsScala(val asJava: io.vertx.ext.sql.SQLOperations) extends AnyVal {


    /**
     * Like query from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.query(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.queryWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStream from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStream(sql, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like queryStreamWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def queryStreamWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.SQLRowStream] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.SQLRowStream]()
      asJava.queryStreamWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.SQLRowStream]] { override def handle(event: AsyncResult[io.vertx.ext.sql.SQLRowStream]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like querySingle from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def querySingleFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like querySingleWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like update from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.update(sql, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like updateWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def updateWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.UpdateResult] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.UpdateResult]()
      asJava.updateWithParams(sql, params, new Handler[AsyncResult[io.vertx.ext.sql.UpdateResult]] { override def handle(event: AsyncResult[io.vertx.ext.sql.UpdateResult]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like call from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.call(sql, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like callWithParams from [[io.vertx.ext.sql.SQLOperations]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def callWithParamsFuture(sql: java.lang.String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.ext.sql.ResultSet] = {
      val promise = concurrent.Promise[io.vertx.ext.sql.ResultSet]()
      asJava.callWithParams(sql, params, outputs, new Handler[AsyncResult[io.vertx.ext.sql.ResultSet]] { override def handle(event: AsyncResult[io.vertx.ext.sql.ResultSet]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



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

def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      scala.Option(asJava.exceptionHandler(handler.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]))
}
def handler(handler: scala.Option[io.vertx.core.json.JsonArray => Unit]) = {
      scala.Option(asJava.handler(handler.asInstanceOf[io.vertx.core.Handler[io.vertx.core.json.JsonArray]]))
}
def endHandler(endHandler: scala.Option[Void => Unit]) = {
      scala.Option(asJava.endHandler(endHandler.asInstanceOf[io.vertx.core.Handler[java.lang.Void]]))
}
def pipeToFuture(dst: io.vertx.core.streams.WriteStream[io.vertx.core.json.JsonArray]) : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.pipeTo(dst, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
    /**
     * Like close from [[io.vertx.ext.sql.SQLRowStream]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
def closeFuture() : scala.concurrent.Future[Unit] = {
      val promise = concurrent.Promise[Unit]()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



    type UpdateResult = io.vertx.ext.sql.UpdateResult
  object UpdateResult {
    def apply() = new UpdateResult()
    def apply(json: JsonObject) = new UpdateResult(json)
  }



}
