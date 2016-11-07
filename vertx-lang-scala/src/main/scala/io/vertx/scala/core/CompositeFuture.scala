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

package io.vertx.scala.core

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.{Future => JFuture}
import java.util.function.{Function => JFunction}
import java.util.function.Function

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future futures]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: JCompositeFuture) 
    extends  {

  def asJava: JCompositeFuture = _asJava

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: CompositeFuture): Unit = {
    _asJava.complete(result.asJava.asInstanceOf[JCompositeFuture])
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): CompositeFuture = {
    CompositeFuture.apply(_asJava.result())
  }

  /**
    * Compose this future with a provided `next` future.
    *
    * When this (the one on which `compose` is called) future succeeds, the `handler` will be called with
    * the completed value, this handler should complete the next future.
    *
    * If the `handler` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the `next` future and the `handler`
    * will not be called.
    * @param handler the handler
    * @param next the next future
    * @return the next future, used for chaining
    */
  def compose[U](handler: CompositeFuture => Unit, next: Future[U]): Future[U] = {
    Future.apply[U](_asJava.compose(funcToMappedHandler(CompositeFuture.apply)(handler), next.asJava.asInstanceOf[JFuture[U]]))
  }

  /**
    * Compose this future with a `mapper` function.
    *
    * When this future (the one on which `compose` is called) succeeds, the `mapper` will be called with
    * the completed value and this mapper returns another future object. This returned future completion will complete
    * the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the composed future
    */
  def compose[U](mapper: JCompositeFuture => JFuture[U]): Future[U] = {
    Future.apply[U](_asJava.compose(asJavaFunction(mapper)))
  }

  /**
    * Apply a `mapper` function on this future.
    *
    * When this future succeeds, the `mapper` will be called with the completed value and this mapper
    * returns a value. This value will complete the future returned by this method call.
    *
    * If the `mapper` throws an exception, the returned future will be failed with this exception.
    *
    * When this future fails, the failure will be propagated to the returned future and the `mapper`
    * will not be called.
    * @param mapper the mapper function
    * @return the mapped future
    */
  def map[U](mapper: JCompositeFuture => U): Future[U] = {
    Future.apply[U](_asJava.map(asJavaFunction(mapper)))
  }

  /**
    * @return an handler completing this future
    */
  def completer(): io.vertx.core.AsyncResult [CompositeFuture] => Unit = {
    if (cached_0 == null) {
      cached_0=    handlerToMappedFunction[io.vertx.core.AsyncResult[io.vertx.core.CompositeFuture], io.vertx.core.AsyncResult[CompositeFuture]](s => if (s.failed()) io.vertx.lang.scala.ScalaAsyncResult(cause = s.cause()) else io.vertx.lang.scala.ScalaAsyncResult(result = s.result.asJava)) (_asJava.completer())
    }
    cached_0
  }

  def setFuture(): concurrent.Future[CompositeFuture] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCompositeFuture,CompositeFuture]((x => if (x == null) null else CompositeFuture.apply(x)))
    _asJava.setHandler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Returns a cause of a wrapped future
    * @param index the wrapped future index
    */
  def cause(index: Int): Throwable = {
    _asJava.cause(index)
  }

  /**
    * Returns true if a wrapped future is succeeded
    * @param index the wrapped future index
    */
  def succeeded(index: Int): Boolean = {
    _asJava.succeeded(index)
  }

  /**
    * Returns true if a wrapped future is failed
    * @param index the wrapped future index
    */
  def failed(index: Int): Boolean = {
    _asJava.failed(index)
  }

  /**
    * Returns true if a wrapped future is completed
    * @param index the wrapped future index
    */
  def isComplete(index: Int): Boolean = {
    _asJava.isComplete(index)
  }

  /**
    * Returns the result of a wrapped future
    * @param index the wrapped future index
    */
  def resultAt[T](index: Int): T = {
    _asJava.resultAt(index)
  }

  /**
    * @return the number of wrapped future
    */
  def size(): Int = {
    _asJava.size()
  }

  private var cached_0: io.vertx.core.AsyncResult [CompositeFuture] => Unit = _
}

object CompositeFuture {

  def apply(_asJava: JCompositeFuture): CompositeFuture =
    new CompositeFuture(_asJava)

  def all[T1, T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def all[T1, T2, T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def all[T1, T2, T3, T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def all[T1, T2, T3, T4, T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def all[T1, T2, T3, T4, T5, T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]], f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def all(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(futures.map(x => if (x == null) null else x.asJava).asJava))
  }

  def any[T1, T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def any[T1, T2, T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def any[T1, T2, T3, T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def any[T1, T2, T3, T4, T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def any[T1, T2, T3, T4, T5, T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]], f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def any(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(futures.map(x => if (x == null) null else x.asJava).asJava))
  }

  def join[T1, T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def join[T1, T2, T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def join[T1, T2, T3, T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def join[T1, T2, T3, T4, T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def join[T1, T2, T3, T4, T5, T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]], f2.asJava.asInstanceOf[JFuture[T2]], f3.asJava.asInstanceOf[JFuture[T3]], f4.asJava.asInstanceOf[JFuture[T4]], f5.asJava.asInstanceOf[JFuture[T5]], f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def join(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(futures.map(x => if (x == null) null else x.asJava).asJava))
  }

}
