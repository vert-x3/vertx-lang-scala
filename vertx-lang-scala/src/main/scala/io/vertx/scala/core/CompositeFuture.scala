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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.{Future => JFuture}
import java.util.function.{Function => JFunction}

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: JCompositeFuture) {

  def asJava: JCompositeFuture = _asJava

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: CompositeFuture): Unit = {
    asJava.complete(result.asJava.asInstanceOf[JCompositeFuture])
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): CompositeFuture = {
    CompositeFuture.apply(asJava.result())
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
  def compose[U: TypeTag](handler: io.vertx.core.Handler[CompositeFuture], next: Future[U]): Future[U] = {
    Future.apply[U](asJava.compose(funcToMappedHandler(CompositeFuture.apply)(handler).asInstanceOf[io.vertx.core.Handler[io.vertx.core.CompositeFuture]], next.asJava.asInstanceOf[JFuture[U]].asInstanceOf[io.vertx.core.Future[Object]]))
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
  def compose[U: TypeTag](mapper: JCompositeFuture => JFuture[U]): Future[U] = {
    Future.apply[U](asJava.compose(asJavaFunction(mapper).asInstanceOf[java.util.function.Function[io.vertx.core.CompositeFuture,io.vertx.core.Future[Object]]]))
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
  def map[U: TypeTag](mapper: JCompositeFuture => U): Future[U] = {
    Future.apply[U](asJava.map(asJavaFunction(mapper).asInstanceOf[java.util.function.Function[io.vertx.core.CompositeFuture,Object]]))
  }

  /**
    * @return an handler completing this future
    */
  def completer(): io.vertx.core.Handler[io.vertx.core.AsyncResult[CompositeFuture]] = {
    if (cached_0 == null) {
      cached_0 = handlerToMappedFunction[io.vertx.core.AsyncResult[io.vertx.core.CompositeFuture], io.vertx.core.AsyncResult[CompositeFuture]](s => if (s.failed()) io.vertx.lang.scala.ScalaAsyncResult(cause = s.cause()) else io.vertx.lang.scala.ScalaAsyncResult(result = s.result.asJava)) (asJava.completer()).asInstanceOf
    }
    cached_0
  }

  def setFuture(): concurrent.Future[CompositeFuture] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[CompositeFuture]((x => if (x == null) null else CompositeFuture.apply(x.asInstanceOf)))
    asJava.setHandler(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[io.vertx.core.CompositeFuture]]])
    promiseAndHandler._2.future
  }

  /**
    * Returns a cause of a wrapped future
    * @param index the wrapped future index
    */
  def cause(index: Int): Throwable = {
    asJava.cause(index)
  }

  /**
    * Returns true if a wrapped future is succeeded
    * @param index the wrapped future index
    */
  def succeeded(index: Int): Boolean = {
    asJava.succeeded(index)
  }

  /**
    * Returns true if a wrapped future is failed
    * @param index the wrapped future index
    */
  def failed(index: Int): Boolean = {
    asJava.failed(index)
  }

  /**
    * Returns true if a wrapped future is completed
    * @param index the wrapped future index
    */
  def isComplete(index: Int): Boolean = {
    asJava.isComplete(index)
  }

  /**
    * Returns the result of a wrapped future
    * @param index the wrapped future index
    */
  def resultAt[T: TypeTag](index: Int): T = {
    toScala[T](asJava.resultAt(index))
  }

  /**
    * @return the number of wrapped future
    */
  def size(): Int = {
    asJava.size()
  }

  private var cached_0: io.vertx.core.Handler[io.vertx.core.AsyncResult[CompositeFuture]] = _
}

object CompositeFuture {

  def apply(_asJava: JCompositeFuture): CompositeFuture =
    new CompositeFuture(_asJava)

  def all[T1: TypeTag, T2: TypeTag](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def all[T1: TypeTag, T2: TypeTag, T3: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def all[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def all[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def all[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag, T6: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]], f6.asJava.asInstanceOf[JFuture[T6]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def all(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(futures.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.core.Future[_]]]))
  }

  def any[T1: TypeTag, T2: TypeTag](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def any[T1: TypeTag, T2: TypeTag, T3: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def any[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def any[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def any[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag, T6: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]], f6.asJava.asInstanceOf[JFuture[T6]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def any(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(futures.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.core.Future[_]]]))
  }

  def join[T1: TypeTag, T2: TypeTag](f1: Future[T1], f2: Future[T2]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def join[T1: TypeTag, T2: TypeTag, T3: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def join[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def join[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def join[T1: TypeTag, T2: TypeTag, T3: TypeTag, T4: TypeTag, T5: TypeTag, T6: TypeTag](f1: Future[T1], f2: Future[T2], f3: Future[T3], f4: Future[T4], f5: Future[T5], f6: Future[T6]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]].asInstanceOf[io.vertx.core.Future[Object]], f2.asJava.asInstanceOf[JFuture[T2]].asInstanceOf[io.vertx.core.Future[Object]], f3.asJava.asInstanceOf[JFuture[T3]].asInstanceOf[io.vertx.core.Future[Object]], f4.asJava.asInstanceOf[JFuture[T4]].asInstanceOf[io.vertx.core.Future[Object]], f5.asJava.asInstanceOf[JFuture[T5]].asInstanceOf[io.vertx.core.Future[Object]], f6.asJava.asInstanceOf[JFuture[T6]].asInstanceOf[io.vertx.core.Future[Object]]))
  }

  def join(futures: scala.collection.mutable.Buffer[Future[_]]): CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.join(futures.map(x => if (x == null) null else x.asJava).asJava.asInstanceOf[java.util.List[io.vertx.core.Future[_]]]))
  }

}
