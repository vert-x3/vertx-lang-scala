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
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
class Future[T: TypeTag](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0: Handler[AsyncResult[T]] = _

  /**
    * @return an handler completing this future
    */
  def completer(): Handler[AsyncResult[T]] = {
    if (cached_0 == null) {
      val tmp = asJava.asInstanceOf[JFuture[Object]].completer()
      cached_0 = {x: AsyncResult[T] => tmp.handle(AsyncResultWrapper[T, Object](x, a => toJava[T](a)))}
    }
    cached_0
  }

  /**
    * Set a handler for the result.
    * 
    * If the future has already been completed it will be called immediately. Otherwise it will be called when the
    * future is completed.
    * @param handler the Handler that will be called with the result
    * @return a reference to this, so it can be used fluently
    */
  def setHandler(handler: Handler[AsyncResult[T]]): Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].setHandler({x: AsyncResult[Object] => handler.handle(AsyncResultWrapper[Object, T](x, a => toScala[T](a)))})
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
  def compose[U: TypeTag](handler: Handler[T], next: Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => handler.handle(toScala[T](x))}, next.asJava.asInstanceOf[JFuture[Object]]))
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
  def compose[U: TypeTag](mapper: T => Future[U]): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => mapper(toScala[T](x)).asJava.asInstanceOf[JFuture[Object]]}))
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
  def map[U: TypeTag](mapper: T => U): Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].map[Object]({x: Object => toJava[U](mapper(toScala[T](x)))}))
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
  def map[V: TypeTag](value: V): Future[V] = {
    Future[V](asJava.asInstanceOf[JFuture[Object]].map[Object](toJava[V](value)))
  }

  /**
    * Handles a failure of this Future by returning the result of another Future.
    * If the mapper fails, then the returned future will be failed with this failure.
    * @param mapper A function which takes the exception of a failure and returns a new future.
    * @return A recovered future
    */
  def recover(mapper: Throwable => Future[T]): Future[T] = {
    Future[T](asJava.asInstanceOf[JFuture[Object]].recover({x: Throwable => mapper(x).asJava.asInstanceOf[JFuture[Object]]}))
  }

  /**
    * Has the future completed?
    * 
    * It's completed if it's either succeeded or failed.
    * @return true if completed, false if not
    */
  def isComplete(): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].isComplete().asInstanceOf[Boolean]
  }

  /**
    * Set the result. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param result the result
    */
  def complete(result: T): Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete(toJava[T](result))
  }

  /**
    * Set a null result. Any handler will be called, if there is one, and the future will be marked as completed.
    */
  def complete(): Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete()
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param throwable the failure cause
    */
  def fail(throwable: Throwable): Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(throwable)
  }

  /**
    * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.
    * @param failureMessage the failure message
    */
  def fail(failureMessage: String): Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(failureMessage.asInstanceOf[java.lang.String])
  }

  /**
    * The result of the operation. This will be null if the operation failed.
    * @return the result or null if the operation failed.
    */
  def result(): T = {
    toScala[T](asJava.asInstanceOf[JFuture[Object]].result())
  }

  /**
    * A Throwable describing failure. This will be null if the operation succeeded.
    * @return the cause or null if the operation succeeded.
    */
  def cause(): Throwable = {
    asJava.asInstanceOf[JFuture[Object]].cause()
  }

  /**
    * Did it succeed?
    * @return true if it succeded or false otherwise
    */
  def succeeded(): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].succeeded().asInstanceOf[Boolean]
  }

  /**
    * Did it fail?
    * @return true if it failed or false otherwise
    */
  def failed(): Boolean = {
    asJava.asInstanceOf[JFuture[Object]].failed().asInstanceOf[Boolean]
  }

}

object Future {
  def apply[T: TypeTag](asJava: JFuture[_]) = new Future[T](asJava)  
  /**
    * Create a future that hasn't completed yet
    * @return the future
    */
  def future[T: TypeTag](): Future[T] = {
    Future[T](JFuture.future[Object]())
  }

  /**
    * Create a succeeded future with a null result
    * @return the future
    */
  def succeededFuture[T: TypeTag](): Future[T] = {
    Future[T](JFuture.succeededFuture[Object]())
  }

  /**
    * Created a succeeded future with the specified result.
    * @param result the result
    * @return the future
    */
  def succeededFuture[T: TypeTag](result: T): Future[T] = {
    Future[T](JFuture.succeededFuture[Object](toJava[T](result)))
  }

  /**
    * Create a failed future with the specified failure cause.
    * @param t the failure cause as a Throwable
    * @return the future
    */
  def failedFuture[T: TypeTag](t: Throwable): Future[T] = {
    Future[T](JFuture.failedFuture[Object](t))
  }

  /**
    * Create a failed future with the specified failure message.
    * @param failureMessage the failure message
    * @return the future
    */
  def failedFuture[T: TypeTag](failureMessage: String): Future[T] = {
    Future[T](JFuture.failedFuture[Object](failureMessage.asInstanceOf[java.lang.String]))
  }

}
