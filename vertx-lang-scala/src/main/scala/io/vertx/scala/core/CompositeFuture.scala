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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: Object)
    extends Future[CompositeFuture](_asJava)  {

  private var cached_0: Handler[AsyncResult[CompositeFuture]] = _

  /**
    * @return an handler completing this future
    */
  override def completer(): Handler[AsyncResult[CompositeFuture]] = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JCompositeFuture].completer()
      cached_0 = {x: AsyncResult[CompositeFuture] => tmp.handle(AsyncResultWrapper[CompositeFuture,JCompositeFuture](x, a => a.asJava.asInstanceOf[JCompositeFuture]))}
    }
    cached_0
  }

  override def setHandler(handler: Handler[AsyncResult[CompositeFuture]]): CompositeFuture = {
    asJava.asInstanceOf[JCompositeFuture].setHandler({x: AsyncResult[JCompositeFuture] => handler.handle(AsyncResultWrapper[JCompositeFuture,CompositeFuture](x, a => CompositeFuture(a)))})
    this
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
  override def compose[U: TypeTag](handler: Handler[CompositeFuture], next: Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JCompositeFuture].compose[Object]({x: JCompositeFuture => handler.handle(CompositeFuture(x))},next.asJava.asInstanceOf[JFuture[Object]]))
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
  override def compose[U: TypeTag](mapper: CompositeFuture => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JCompositeFuture].compose[Object]({x: JCompositeFuture => mapper(CompositeFuture(x)).asJava.asInstanceOf[JFuture[Object]]}))
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
  override def map[U: TypeTag](mapper: CompositeFuture => U): Future[U] = {
    Future[U](asJava.asInstanceOf[JCompositeFuture].map[Object]({x: JCompositeFuture => toJava[U](mapper(CompositeFuture(x)))}))
  }

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  override def complete(result: CompositeFuture): Unit = {
    asJava.asInstanceOf[JCompositeFuture].complete(result.asJava.asInstanceOf[JCompositeFuture])
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  override def result(): CompositeFuture = {
    CompositeFuture(asJava.asInstanceOf[JCompositeFuture].result())
  }

  /**
    * Returns a cause of a wrapped future
    * @param index the wrapped future index
    */
  def cause(index: Int): Throwable = {
    asJava.asInstanceOf[JCompositeFuture].cause(index.asInstanceOf[java.lang.Integer])
  }

  /**
    * Returns true if a wrapped future is succeeded
    * @param index the wrapped future index
    */
  def succeeded(index: Int): Boolean = {
    asJava.asInstanceOf[JCompositeFuture].succeeded(index.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
    * Returns true if a wrapped future is failed
    * @param index the wrapped future index
    */
  def failed(index: Int): Boolean = {
    asJava.asInstanceOf[JCompositeFuture].failed(index.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
    * Returns true if a wrapped future is completed
    * @param index the wrapped future index
    */
  def isComplete(index: Int): Boolean = {
    asJava.asInstanceOf[JCompositeFuture].isComplete(index.asInstanceOf[java.lang.Integer]).asInstanceOf[Boolean]
  }

  /**
    * Returns the result of a wrapped future
    * @param index the wrapped future index
    */
  def resultAt[T: TypeTag](index: Int): T = {
    toScala[T](asJava.asInstanceOf[JCompositeFuture].resultAt[Object](index.asInstanceOf[java.lang.Integer]))
  }

  /**
    * @return the number of wrapped future
    */
  def size(): Int = {
    asJava.asInstanceOf[JCompositeFuture].size().asInstanceOf[Int]
  }

}

object CompositeFuture {
  def apply(asJava: JCompositeFuture) = new CompositeFuture(asJava)  
  /**
    * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
    * <p/>
    * The returned future fails as soon as one of `f1` or `f2` fails.
    * @param f1 future
    * @param f2 future
    * @return the composite future
    */
  def all[T1,T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all[Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#all]] but with 3 futures.
    */
  def all[T1,T2,T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all[Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#all]] but with 4 futures.
    */
  def all[T1,T2,T3,T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all[Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#all]] but with 5 futures.
    */
  def all[T1,T2,T3,T4,T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all[Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#all]] but with 6 futures.
    */
  def all[T1,T2,T3,T4,T5,T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all[Object,Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]],f6.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#all]] but with a list of futures.
    *
    * When the list is empty, the returned future will be already completed.
    */
  def all(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

  /**
    * Return a composite future, succeeded when any futures is succeeded, failed when all futures are failed.
    * <p/>
    * The returned future succeeds as soon as one of `f1` or `f2` succeeds.
    * @param f1 future
    * @param f2 future
    * @return the composite future
    */
  def any[T1,T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any[Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#any]] but with 3 futures.
    */
  def any[T1,T2,T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any[Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#any]] but with 4 futures.
    */
  def any[T1,T2,T3,T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any[Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#any]] but with 5 futures.
    */
  def any[T1,T2,T3,T4,T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any[Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#any]] but with 6 futures.
    */
  def any[T1,T2,T3,T4,T5,T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any[Object,Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]],f6.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#any]] but with a list of futures.
    *
    * When the list is empty, the returned future will be already completed.
    */
  def any(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

  /**
    * Return a composite future, succeeded when all futures are succeeded, failed when any future is failed.
    * <p/>
    * It always wait until all its futures are completed and will not fail as soon as one of `f1` or `f2` fails.
    * @param f1 future
    * @param f2 future
    * @return the composite future
    */
  def join[T1,T2](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join[Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#join]] but with 3 futures.
    */
  def join[T1,T2,T3](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join[Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#join]] but with 4 futures.
    */
  def join[T1,T2,T3,T4](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join[Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#join]] but with 5 futures.
    */
  def join[T1,T2,T3,T4,T5](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join[Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#join]] but with 6 futures.
    */
  def join[T1,T2,T3,T4,T5,T6](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join[Object,Object,Object,Object,Object,Object](f1.asJava.asInstanceOf[JFuture[Object]],f2.asJava.asInstanceOf[JFuture[Object]],f3.asJava.asInstanceOf[JFuture[Object]],f4.asJava.asInstanceOf[JFuture[Object]],f5.asJava.asInstanceOf[JFuture[Object]],f6.asJava.asInstanceOf[JFuture[Object]]))
  }

  /**
    * Like [[io.vertx.scala.core.CompositeFuture#join]] but with a list of futures.
    *
    * When the list is empty, the returned future will be already completed.
    */
  def join(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

}
