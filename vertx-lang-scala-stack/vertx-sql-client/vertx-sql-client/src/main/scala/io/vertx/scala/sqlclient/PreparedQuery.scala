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
import io.vertx.sqlclient.{Row => JRow}
import io.vertx.sqlclient.{RowSet => JRowSet}
import io.vertx.sqlclient.{Query => JQuery}
import scala.reflect.runtime.universe._
import io.vertx.sqlclient.{Tuple => JTuple}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.sqlclient.{PreparedQuery => JPreparedQuery}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A query for a prepared statement allowing parameterized execution of the query, this query will use
  * a prepared statement.
  */

class PreparedQuery[T: TypeTag](private val _asJava: Object) extends Query[T] (_asJava) {






  /**
   * Execute the query.   * @param handler the handler receiving the response
   */
  override def execute (handler: Handler[AsyncResult[T]]): Unit = {
    asJava.asInstanceOf[JPreparedQuery[Object]].execute((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
  }

  /**
   * Execute the query.   * @param handler the handler receiving the response
   */
  def execute (tuple: Tuple, handler: Handler[AsyncResult[T]]): Unit = {
    asJava.asInstanceOf[JPreparedQuery[Object]].execute(tuple.asJava.asInstanceOf[JTuple], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
  }

  /**
   * Execute the query with a batch of tuples.   * @param batch the batch of tuples
   * @param handler the handler receiving the response
   */
  def executeBatch (batch: scala.collection.mutable.Buffer[Tuple], handler: Handler[AsyncResult[T]]): Unit = {
    asJava.asInstanceOf[JPreparedQuery[Object]].executeBatch(batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
  }

  /**
   * Use the specified `mapper` for mapping [[io.vertx.scala.sqlclient.Row]] to `<U>`.
   */
  override def mapping [U: TypeTag](mapper: Row => U): PreparedQuery[RowSet[U]] = {
    PreparedQuery[RowSet[U]](asJava.asInstanceOf[JPreparedQuery[Object]].mapping[Object]({x: JRow => toJava[U](mapper(Row(x)))}))
  }


 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  override def executeFuture (): scala.concurrent.Future[T] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => toScala[T](x))
    asJava.asInstanceOf[JPreparedQuery[Object]].execute(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeFuture (tuple: Tuple): scala.concurrent.Future[T] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => toScala[T](x))
    asJava.asInstanceOf[JPreparedQuery[Object]].execute(tuple.asJava.asInstanceOf[JTuple], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[executeBatch]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeBatchFuture (batch: scala.collection.mutable.Buffer[Tuple]): scala.concurrent.Future[T] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => toScala[T](x))
    asJava.asInstanceOf[JPreparedQuery[Object]].executeBatch(batch.map(x => x.asJava.asInstanceOf[JTuple]).asJava, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object PreparedQuery {
  def apply[T: TypeTag](asJava: JPreparedQuery[_]) = new PreparedQuery[T](asJava)

}
