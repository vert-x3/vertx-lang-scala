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

package io.vertx.scala.sqlclient

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.sqlclient.{RowSet => JRowSet}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.sqlclient.{PreparedStatement => JPreparedStatement}
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Cursor => JCursor}
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{RowStream => JRowStream}
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._

/**
  * A prepared statement, the statement is pre-compiled and it's more efficient to execute the statement for multiple times.
  * In addition, this kind of statement provides protection against SQL injection attacks.
  *
  * From a prepared statement you can
  *
  * <ul>
  *   <li>use [[io.vertx.scala.sqlclient.PreparedStatement#query]] to create and execute a [[io.vertx.scala.sqlclient.PreparedQuery]]</li>
  *   <li>use [[io.vertx.scala.sqlclient.PreparedStatement#cursor]] to create a [[io.vertx.scala.sqlclient.Cursor]]</li>
  *   <li>use [[io.vertx.scala.sqlclient.PreparedStatement#createStream]] to create a [[io.vertx.scala.sqlclient.RowStream]]</li>
  * </ul>
  */

class PreparedStatement(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * Like [[io.vertx.scala.sqlclient.PreparedStatement#cursor]] but with empty arguments.
   */
  def cursor(): Cursor = {
    Cursor(asJava.asInstanceOf[JPreparedStatement].cursor())
  }

  /**
   * Like [[io.vertx.scala.sqlclient.PreparedStatement#createStream]] but with empty arguments.
   */
  def createStream(fetch: Int): RowStream[Row] = {
    RowStream[Row](asJava.asInstanceOf[JPreparedStatement].createStream(fetch.asInstanceOf[java.lang.Integer]))
  }


  /**
   * Create a prepared query for this statement.   * @return the prepared query
   */
  def query (): PreparedQuery[RowSet[Row]] = {
    PreparedQuery[RowSet[Row]](asJava.asInstanceOf[JPreparedStatement].query())
  }

  /**
   * Create a cursor with the provided `arguments`.   * @param args the list of arguments
   * @return the query
   */
  def cursor (args: Tuple): Cursor = {
    Cursor(asJava.asInstanceOf[JPreparedStatement].cursor(args.asJava.asInstanceOf[JTuple]))
  }

  /**
   * Execute the prepared query with a cursor and createStream the result. The createStream opens a cursor
   * with a `fetch` size to fetch the results.
   * <p/>
   * Note: this requires to be in a transaction, since cursors require it.   * @param fetch the cursor fetch size
   * @param args the prepared query arguments
   * @return the createStream
   */
  def createStream (fetch: Int, args: Tuple): RowStream[Row] = {
    RowStream[Row](asJava.asInstanceOf[JPreparedStatement].createStream(fetch.asInstanceOf[java.lang.Integer], args.asJava.asInstanceOf[JTuple]))
  }

  /**
   * Close the prepared query and release its resources.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JPreparedStatement].close()
  }

  /**
   * Like [[io.vertx.scala.sqlclient.PreparedStatement#close]] but notifies the `completionHandler` when it's closed.
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JPreparedStatement].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPreparedStatement].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PreparedStatement {
  def apply(asJava: JPreparedStatement) = new PreparedStatement(asJava)

}
