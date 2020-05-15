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
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A query.
  */

class Query[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Execute the query.   * @param handler the handler receiving the response
   */
  def execute (handler: Handler[AsyncResult[T]]): Unit = {
    asJava.asInstanceOf[JQuery[Object]].execute((if (handler == null) null else new io.vertx.core.Handler[AsyncResult[Object]]{def handle(x: AsyncResult[Object]) {handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))}}))
  }

  /**
   * Use the specified `mapper` for mapping [[io.vertx.scala.sqlclient.Row]] to `<U>`.
   */
  def mapping [U: TypeTag](mapper: Row => U): Query[RowSet[U]] = {
    Query[RowSet[U]](asJava.asInstanceOf[JQuery[Object]].mapping[Object]({x: JRow => toJava[U](mapper(Row(x)))}))
  }


 /**
  * Like [[execute]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def executeFuture (): scala.concurrent.Future[T] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, T](x => toScala[T](x))
    asJava.asInstanceOf[JQuery[Object]].execute(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Query {
  def apply[T: TypeTag](asJava: JQuery[_]) = new Query[T](asJava)

}
