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

import io.vertx.sqlclient.{Cursor => JCursor}
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.sqlclient.{RowSet => JRowSet}
import scala.reflect.runtime.universe._
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * A cursor that reads progressively rows from the database, it is useful for reading very large result sets.

  */

class Cursor(private val _asJava: Object) {
  def asJava = _asJava




  /**
   * Release the cursor.
   * <p/>
   * It should be called for prepared queries executed with a fetch size.
   */
  def close(): Unit = {
    asJava.asInstanceOf[JCursor].close()
  }


  /**
   * Read rows from the cursor, the result is provided asynchronously to the `handler`.   * @param count the amount of rows to read
   * @param handler the handler for the result
   */
  def read (count: Int, handler: Handler[AsyncResult[RowSet]]): Unit = {
    asJava.asInstanceOf[JCursor].read(count.asInstanceOf[java.lang.Integer], (if (handler == null) null else new io.vertx.core.Handler[AsyncResult[JRowSet]]{def handle(x: AsyncResult[JRowSet]) {handler.handle(AsyncResultWrapper[JRowSet, RowSet](x, a => RowSet(a)))}}))
  }

  /**
   * Returns `true` when the cursor has results in progress and the [[io.vertx.scala.sqlclient.Cursor#read]] should be called to retrieve
   * them.   * @return whether the cursor has more results,
   */
  def hasMore (): Boolean = {
    asJava.asInstanceOf[JCursor].hasMore().asInstanceOf[Boolean]
  }

  /**
   * Like [[io.vertx.scala.sqlclient.Cursor#close]] but with a `completionHandler` called when the cursor has been released.
   */
  def close (completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JCursor].close((if (completionHandler == null) null else new io.vertx.core.Handler[AsyncResult[Void]]{def handle(x: AsyncResult[Void]) {completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))}}))
  }


 /**
  * Like [[read]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def readFuture (count: Int): scala.concurrent.Future[RowSet] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JRowSet, RowSet](x => RowSet(x))
    asJava.asInstanceOf[JCursor].read(count.asInstanceOf[java.lang.Integer], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[close]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def closeFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JCursor].close(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Cursor {
  def apply(asJava: JCursor) = new Cursor(asJava)
  
}
