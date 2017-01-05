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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{ResultSet => JResultSet}
import io.vertx.ext.sql.TransactionIsolation
import io.vertx.ext.sql.{UpdateResult => JUpdateResult}
import io.vertx.ext.sql.{SQLRowStream => JSQLRowStream}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}

/**
  * Represents a connection to a SQL database
  */
class SQLConnection(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
  def setAutoCommit(autoCommit: Boolean,resultHandler: Handler[AsyncResult[Unit]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def execute(sql: String,resultHandler: Handler[AsyncResult[Unit]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String],{x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def query(sql: String,resultHandler: Handler[AsyncResult[ResultSet]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String],{x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet,ResultSet](x, a => ResultSet(a)))})
    this
  }

  def queryStream(sql: String,handler: Handler[AsyncResult[SQLRowStream]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String],{x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream,SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  def queryWithParams(sql: String,params: io.vertx.core.json.JsonArray,resultHandler: Handler[AsyncResult[ResultSet]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String],params,{x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet,ResultSet](x, a => ResultSet(a)))})
    this
  }

  def queryStreamWithParams(sql: String,params: io.vertx.core.json.JsonArray,handler: Handler[AsyncResult[SQLRowStream]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String],params,{x: AsyncResult[JSQLRowStream] => handler.handle(AsyncResultWrapper[JSQLRowStream,SQLRowStream](x, a => SQLRowStream(a)))})
    this
  }

  def update(sql: String,resultHandler: Handler[AsyncResult[UpdateResult]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String],{x: AsyncResult[JUpdateResult] => resultHandler.handle(AsyncResultWrapper[JUpdateResult,UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  def updateWithParams(sql: String,params: io.vertx.core.json.JsonArray,resultHandler: Handler[AsyncResult[UpdateResult]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String],params,{x: AsyncResult[JUpdateResult] => resultHandler.handle(AsyncResultWrapper[JUpdateResult,UpdateResult](x, a => UpdateResult(a)))})
    this
  }

  def call(sql: String,resultHandler: Handler[AsyncResult[ResultSet]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String],{x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet,ResultSet](x, a => ResultSet(a)))})
    this
  }

  def callWithParams(sql: String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray,resultHandler: Handler[AsyncResult[ResultSet]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String],params,outputs,{x: AsyncResult[JResultSet] => resultHandler.handle(AsyncResultWrapper[JResultSet,ResultSet](x, a => ResultSet(a)))})
    this
  }

  def commit(handler: Handler[AsyncResult[Unit]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].commit({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def rollback(handler: Handler[AsyncResult[Unit]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].rollback({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def setQueryTimeout(timeoutInSeconds: Int):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setQueryTimeout(timeoutInSeconds.asInstanceOf[java.lang.Integer])
    this
  }

  def batch(sqlStatements: scala.collection.mutable.Buffer[String],handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava,{x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  def batchWithParams(sqlStatement: String,args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray],handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String],args.map(x => x).asJava,{x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  def batchCallableWithParams(sqlStatement: String,inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray],outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray],handler: Handler[AsyncResult[scala.collection.mutable.Buffer[Int]]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String],inArgs.map(x => x).asJava,outArgs.map(x => x).asJava,{x: AsyncResult[java.util.List[java.lang.Integer]] => handler.handle(AsyncResultWrapper[java.util.List[java.lang.Integer],scala.collection.mutable.Buffer[Int]](x, a => a.asScala.map(x => x.asInstanceOf[Int])))})
    this
  }

  def setTransactionIsolation(isolation: io.vertx.ext.sql.TransactionIsolation,handler: Handler[AsyncResult[Unit]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation,{x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
    this
  }

  def getTransactionIsolation(handler: Handler[AsyncResult[io.vertx.ext.sql.TransactionIsolation]]):SQLConnection = {
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation({x: AsyncResult[TransactionIsolation] => handler.handle(AsyncResultWrapper[TransactionIsolation,io.vertx.ext.sql.TransactionIsolation](x, a => a))})
    this
  }

//default methods
//basic methods
  def close(handler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JSQLConnection].close({x: AsyncResult[Void] => handler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def close():Unit = {
    asJava.asInstanceOf[JSQLConnection].close()
  }

//future methods
    def setAutoCommitFuture(autoCommit: Boolean):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].setAutoCommit(autoCommit.asInstanceOf[java.lang.Boolean],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def executeFuture(sql: String):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].execute(sql.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def queryFuture(sql: String):scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => if (x == null) null.asInstanceOf[ResultSet] else ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].query(sql.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def queryStreamFuture(sql: String):scala.concurrent.Future[SQLRowStream] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => if (x == null) null.asInstanceOf[SQLRowStream] else SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStream(sql.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def queryWithParamsFuture(sql: String,params: io.vertx.core.json.JsonArray):scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => if (x == null) null.asInstanceOf[ResultSet] else ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].queryWithParams(sql.asInstanceOf[java.lang.String],params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def queryStreamWithParamsFuture(sql: String,params: io.vertx.core.json.JsonArray):scala.concurrent.Future[SQLRowStream] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLRowStream, SQLRowStream](x => if (x == null) null.asInstanceOf[SQLRowStream] else SQLRowStream(x))
    asJava.asInstanceOf[JSQLConnection].queryStreamWithParams(sql.asInstanceOf[java.lang.String],params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateFuture(sql: String):scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => if (x == null) null.asInstanceOf[UpdateResult] else UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].update(sql.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def updateWithParamsFuture(sql: String,params: io.vertx.core.json.JsonArray):scala.concurrent.Future[UpdateResult] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JUpdateResult, UpdateResult](x => if (x == null) null.asInstanceOf[UpdateResult] else UpdateResult(x))
    asJava.asInstanceOf[JSQLConnection].updateWithParams(sql.asInstanceOf[java.lang.String],params,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def callFuture(sql: String):scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => if (x == null) null.asInstanceOf[ResultSet] else ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].call(sql.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def callWithParamsFuture(sql: String,params: io.vertx.core.json.JsonArray,outputs: io.vertx.core.json.JsonArray):scala.concurrent.Future[ResultSet] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JResultSet, ResultSet](x => if (x == null) null.asInstanceOf[ResultSet] else ResultSet(x))
    asJava.asInstanceOf[JSQLConnection].callWithParams(sql.asInstanceOf[java.lang.String],params,outputs,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def closeFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def commitFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].commit(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def rollbackFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].rollback(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def batchFuture(sqlStatements: scala.collection.mutable.Buffer[String]):scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[Int]] else x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batch(sqlStatements.map(x => x.asInstanceOf[java.lang.String]).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def batchWithParamsFuture(sqlStatement: String,args: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]):scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[Int]] else x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchWithParams(sqlStatement.asInstanceOf[java.lang.String],args.map(x => x).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def batchCallableWithParamsFuture(sqlStatement: String,inArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray],outArgs: scala.collection.mutable.Buffer[io.vertx.core.json.JsonArray]):scala.concurrent.Future[scala.collection.mutable.Buffer[Int]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.util.List[java.lang.Integer], scala.collection.mutable.Buffer[Int]](x => if (x == null) null.asInstanceOf[scala.collection.mutable.Buffer[Int]] else x.asScala.map(x => x.asInstanceOf[Int]))
    asJava.asInstanceOf[JSQLConnection].batchCallableWithParams(sqlStatement.asInstanceOf[java.lang.String],inArgs.map(x => x).asJava,outArgs.map(x => x).asJava,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def setTransactionIsolationFuture(isolation: io.vertx.ext.sql.TransactionIsolation):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JSQLConnection].setTransactionIsolation(isolation,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

    def getTransactionIsolationFuture():scala.concurrent.Future[io.vertx.ext.sql.TransactionIsolation] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[TransactionIsolation, io.vertx.ext.sql.TransactionIsolation](x => if (x == null) null.asInstanceOf[io.vertx.ext.sql.TransactionIsolation] else x)
    asJava.asInstanceOf[JSQLConnection].getTransactionIsolation(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object SQLConnection{
    def apply(asJava: JSQLConnection) = new SQLConnection(asJava)  
  //static methods
  }
