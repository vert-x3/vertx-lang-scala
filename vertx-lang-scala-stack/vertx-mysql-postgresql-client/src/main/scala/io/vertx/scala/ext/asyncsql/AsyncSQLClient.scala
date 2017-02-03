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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.asyncsql.{AsyncSQLClient => JAsyncSQLClient}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}

/**
  * Represents an asynchronous SQL client
  */
class AsyncSQLClient(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Close the client and release all resources.
    * Note that closing is asynchronous.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JAsyncSQLClient].close()
  }

  /**
    * Close the client and release all resources.
    * Call the handler when close is complete.
    */
  def close(whenDone: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncSQLClient].close({x: AsyncResult[Void] => whenDone.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember to close the
    * connection when you are done, so it is returned to the pool.
    */
  def getConnection(handler: Handler[AsyncResult[SQLConnection]]): Unit = {
    asJava.asInstanceOf[JAsyncSQLClient].getConnection({x: AsyncResult[JSQLConnection] => handler.handle(AsyncResultWrapper[JSQLConnection, SQLConnection](x, a => SQLConnection(a)))})
  }

 /**
   * Close the client and release all resources.
   * Call the handler when close is complete.
   * @return future that will be called when close is complete
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncSQLClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Returns a connection that can be used to perform SQL operations on. It's important to remember to close the
   * connection when you are done, so it is returned to the pool.
   * @return the future which is called when the <code>JdbcConnection</code> object is ready for use.
   */
  def getConnectionFuture(): scala.concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection, SQLConnection](x => SQLConnection(x))
    asJava.asInstanceOf[JAsyncSQLClient].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncSQLClient {
  def apply(asJava: JAsyncSQLClient) = new AsyncSQLClient(asJava)  
}
