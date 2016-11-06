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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.ext.asyncsql.{AsyncSQLClient => JAsyncSQLClient}
    import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
import io.vertx.scala.ext.sql.SQLConnection
import io.vertx.ext.sql.{SQLConnection => JSQLConnection}
    
/**
  * Represents an asynchronous SQL client
  */
class AsyncSQLClient(private val _asJava: JAsyncSQLClient) {

  def asJava: JAsyncSQLClient = _asJava

  /**
    * Close the client and release all resources.
    * Note that closing is asynchronous.
    */
  def close(): Unit = {
    _asJava.close()
  }

  /**
    * Close the client and release all resources.
    * Call the handler when close is complete.
    * @return future that will be called when close is complete
    */
  def closeFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns a connection that can be used to perform SQL operations on. It's important to remember to close the
    * connection when you are done, so it is returned to the pool.
    * @return the future which is called when the <code>JdbcConnection</code> object is ready for use.
    */
  def getConnectionFuture(): concurrent.Future[SQLConnection] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JSQLConnection,SQLConnection]((x => if (x == null) null else SQLConnection.apply(x)))
    _asJava.getConnection(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncSQLClient {

  def apply(_asJava: JAsyncSQLClient): AsyncSQLClient =
    new AsyncSQLClient(_asJava)

}
