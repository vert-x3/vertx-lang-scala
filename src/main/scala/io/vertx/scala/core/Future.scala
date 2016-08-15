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
import io.vertx.core.Handler
import java.util.function.Function

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
class Future[T](private val _asJava: io.vertx.core.Future[T]) {

  def asJava: io.vertx.core.Future[T] = _asJava

  /**
    * Has the future completed?
    * 
    * It's completed if it's either succeeded or failed.
    * @return true if completed, false if not
    */
  def isComplete(): Boolean = {
    _asJava.isComplete()
  }

  /**
    * Set a handler for the result.
    * 
    * If the future has already been completed it will be called immediately. Otherwise it will be called when the
    * future is completed.
    * @param handler the Handler that will be called with the result
    * @return a reference to this, so it can be used fluently
    */
  def setHandler(handler: io.vertx.core.AsyncResult [T] => Unit): io.vertx.scala.core.Future[T] = {
    _asJava.setHandler(funcToMappedHandler[io.vertx.core.AsyncResult[T], io.vertx.core.AsyncResult [T]](x => io.vertx.lang.scala.AsyncResult[T, T](x,(x => x)))(handler))
    this
  }

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: T): Unit = {
    _asJava.complete(result)
  }

  /**
    * Set a null result. Any handler will be called, if there is one, and the future will be marked as completed.
    */
  def complete(): Unit = {
    _asJava.complete()
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param throwable the failure cause
    */
  def fail(throwable: Throwable): Unit = {
    _asJava.fail(throwable)
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param failureMessage the failure message
    */
  def fail(failureMessage: String): Unit = {
    _asJava.fail(failureMessage)
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): T = {
    _asJava.result()
  }

  /**
    * A Throwable describing failure. This will be null if the operation succeeded.
    * @return the cause or null if the operation succeeded.
    */
  def cause(): Throwable = {
    _asJava.cause()
  }

  /**
    * Did it succeed?
    * @return true if it succeded or false otherwise
    */
  def succeeded(): Boolean = {
    _asJava.succeeded()
  }

  /**
    * Did it fail?
    * @return true if it failed or false otherwise
    */
  def failed(): Boolean = {
    _asJava.failed()
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
  def compose[U](handler: T => Unit, next: io.vertx.scala.core.Future[U]): io.vertx.scala.core.Future[U] = {
    Future.apply[U](_asJava.compose(funcToHandler(handler), next.asJava.asInstanceOf[io.vertx.core.Future[U]]))
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
  def compose[U](mapper: T => io.vertx.core.Future[U]): io.vertx.scala.core.Future[U] = {
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
  def map[U](mapper: T => U): io.vertx.scala.core.Future[U] = {
    Future.apply[U](_asJava.map(asJavaFunction(mapper)))
  }

  /**
    * Map the result of a future to a specific `value`.
    *
    * When this future succeeds, this `value` will complete the future returned by this method call.
    *
    * When this future fails, the failure will be propagated to the returned future.
    * @param value the value that eventually completes the mapped future
    * @return the mapped future
    */
  def map[V](value: V): io.vertx.scala.core.Future[V] = {
    Future.apply[V](_asJava.map(value))
  }

  /**
    * @return an handler completing this future
    */
  def completer(): io.vertx.core.AsyncResult [T] => Unit = {
    if(cached_0 == null) {
      cached_0=        handlerToFunc[io.vertx.core.AsyncResult [T]](_asJava.completer())
    }
    cached_0
  }

  private var cached_0: io.vertx.core.AsyncResult [T] => Unit = _
}

object Future {

  def apply[T](_asJava: io.vertx.core.Future[T]): io.vertx.scala.core.Future[T] =
    new io.vertx.scala.core.Future(_asJava)

  def future[T](): io.vertx.scala.core.Future[T] = {
    Future.apply[T](io.vertx.core.Future.future())
  }

  def succeededFuture[T](): io.vertx.scala.core.Future[T] = {
    Future.apply[T](io.vertx.core.Future.succeededFuture())
  }

  def succeededFuture[T](result: T): io.vertx.scala.core.Future[T] = {
    Future.apply[T](io.vertx.core.Future.succeededFuture(result))
  }

  def failedFuture[T](failureMessage: String): io.vertx.scala.core.Future[T] = {
    Future.apply[T](io.vertx.core.Future.failedFuture(failureMessage))
  }

}
