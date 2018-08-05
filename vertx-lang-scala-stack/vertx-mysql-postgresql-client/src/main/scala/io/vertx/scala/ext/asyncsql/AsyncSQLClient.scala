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

package io.vertx.scala.ext.asyncsql

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.json.JsonArray
import io.vertx.ext.sql.{SQLOperations => JSQLOperations}
import io.vertx.scala.ext.sql.SQLOperations
import scala.reflect.runtime.universe._
import io.vertx.ext.asyncsql.{AsyncSQLClient => JAsyncSQLClient}
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.core.AsyncResult
import io.vertx.scala.ext.sql.SQLClient
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents an asynchronous SQL client
  */

class AsyncSQLClient(private val _asJava: Object) extends SQLClient (_asJava) {





  override 
  def querySingle(sql: String, handler: Handler[AsyncResult[scala.Option[io.vertx.core.json.JsonArray]]]): SQLOperations = {
    asJava.asInstanceOf[JAsyncSQLClient].querySingle(sql.asInstanceOf[java.lang.String], {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))})
    this
  }


  override 
  def querySingleWithParams(sql: String, arguments: io.vertx.core.json.JsonArray, handler: Handler[AsyncResult[scala.Option[io.vertx.core.json.JsonArray]]]): SQLOperations = {
    asJava.asInstanceOf[JAsyncSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, {x: AsyncResult[JsonArray] => handler.handle(AsyncResultWrapper[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x, a => scala.Option(a)))})
    this
  }





  override def querySingleFuture (sql: String): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JAsyncSQLClient].querySingle(sql.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }


  override def querySingleWithParamsFuture (sql: String, arguments: io.vertx.core.json.JsonArray): scala.concurrent.Future[scala.Option[io.vertx.core.json.JsonArray]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JsonArray, scala.Option[io.vertx.core.json.JsonArray]](x => scala.Option(x))
    asJava.asInstanceOf[JAsyncSQLClient].querySingleWithParams(sql.asInstanceOf[java.lang.String], arguments, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncSQLClient {
  def apply(asJava: JAsyncSQLClient) = new AsyncSQLClient(asJava)
  
}
