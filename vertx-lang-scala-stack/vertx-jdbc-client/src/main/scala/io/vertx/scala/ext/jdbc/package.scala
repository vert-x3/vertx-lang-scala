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
import io.vertx.core
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.core.json.JsonObject
import io.vertx.core.AsyncResult
import io.vertx.ext.sql
import io.vertx.core.Handler
import io.vertx.ext.jdbc.{JDBCClient => JJDBCClient}
import io.vertx.core.{Vertx => JVertx}
package object jdbc{



  /**
    * An asynchronous client interface for interacting with a JDBC compliant database
    */

  implicit class JDBCClientScala(val asJava: io.vertx.ext.jdbc.JDBCClient) extends AnyVal {


def querySingleFuture(sql: java.lang.String) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingle(sql, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}
def querySingleWithParamsFuture(sql: java.lang.String,arguments: io.vertx.core.json.JsonArray) : scala.concurrent.Future[io.vertx.core.json.JsonArray] = {
      val promise = concurrent.Promise[io.vertx.core.json.JsonArray]()
      asJava.querySingleWithParams(sql, arguments, new Handler[AsyncResult[io.vertx.core.json.JsonArray]] { override def handle(event: AsyncResult[io.vertx.core.json.JsonArray]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
}  }



}
