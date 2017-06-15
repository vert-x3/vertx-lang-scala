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

import io.vertx.lang.scala.HandlerOps._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.ext.sql.{SQLClient => JSQLClient}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}

/**
  * A common asynchronous client interface for interacting with SQL compliant database
  */
class SQLClient(private val _asJava: Object) {

  def asJava = _asJava

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember
    * to close the connection when you are done, so it is returned to the pool.
    * @param handler the handler which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnection(handler: Handler[AsyncResult[SQLConnection]]): SQLClient = {
    asJava.asInstanceOf[JSQLClient].getConnection({x: AsyncResult[JSQLConnection] => handler.handle(AsyncResultWrapper[JSQLConnection, SQLConnection](x, a => SQLConnection(a)))})
    this
  }

  /**
    * Close the client and release all resources.
    * Call the handler when close is complete.
    * @param completionHandler the handler that will be called when close is complete
    */
  def close(completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JSQLClient].close({x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
    * Close the client
    */
  def close(): Unit = {
    asJava.asInstanceOf[JSQLClient].close()
  }

 /**
   * Like [[getConnection]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def getConnectionFuture(): scala.concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection, SQLConnection](x => SQLConnection(x))
    asJava.asInstanceOf[JSQLClient].getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
   */
  def closeFuture(): scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JSQLClient].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SQLClient {
  def apply(asJava: JSQLClient) = new SQLClient(asJava)  
}
