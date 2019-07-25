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
import scala.collection.JavaConverters._
import io.vertx.lang.scala.Converter._
import io.vertx.sqlclient.{Cursor => JCursor}
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.sqlclient.{RowStream => JRowStream}
import io.vertx.lang.scala.HandlerOps._

/**
  * A prepared query.
  */

class PreparedQuery(private val _asJava: Object) {
  def asJava = _asJava



  /**
   * Calls [[io.vertx.scala.sqlclient.PreparedQuery#execute]] with an empty tuple argument.
   */
  
  def execute(handler: Handler[AsyncResult[RowSet]]): PreparedQuery = {
    asJava.asInstanceOf[JPreparedQuery].execute((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Create a cursor with the provided `arguments`.   * @param args the list of arguments
   * @return the query
   */
  
  def execute(args: Tuple, handler: Handler[AsyncResult[RowSet]]): PreparedQuery = {
    asJava.asInstanceOf[JPreparedQuery].execute(args.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }

  /**
   * Execute a batch.   * @param argsList the list of tuple for the batch
   * @return the createBatch
   */
  
  def batch(argsList: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[RowSet]]): PreparedQuery = {
    asJava.asInstanceOf[JPreparedQuery].batch(argsList.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
    this
  }


  /**
   * @return create a query cursor with a `fetch` size and empty arguments
   */
  def cursor(): Cursor = {
    Cursor(asJava.asInstanceOf[JPreparedQuery].cursor())
  }


  /**
   * Create a cursor with the provided `arguments`.   * @param args the list of arguments
   * @return the query
   */
  def cursor (args: Tuple): Cursor = {
    Cursor(asJava.asInstanceOf[JPreparedQuery].cursor(args.asJava.asInstanceOf[JTuple]))
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
    RowStream[Row](asJava.asInstanceOf[JPreparedQuery].createStream(fetch.asInstanceOf[java.lang.Integer], args.asJava.asInstanceOf[JTuple]))
  }

  /**
   * Close the prepared query and release its resources.
   */
  def close (): Unit = {
    asJava.asInstanceOf[JPreparedQuery].close()
  }

  /**
   * Like [[io.vertx.scala.sqlclient.PreparedQuery#close]] but notifies the `completionHandler` when it's closed.
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JPreparedQuery].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeFuture (): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JPreparedQuery].execute(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeFuture (args: Tuple): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JPreparedQuery].execute(args.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[batch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def batchFuture (argsList: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JPreparedQuery].batch(argsList.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JPreparedQuery].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PreparedQuery {
  def apply(asJava: JPreparedQuery) = new PreparedQuery(asJava)
  
}
