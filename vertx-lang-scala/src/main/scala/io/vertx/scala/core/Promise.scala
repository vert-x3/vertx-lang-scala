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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Promise => JPromise}
import scala.reflect.runtime.universe._
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Represents the writable side of an action that may, or may not, have occurred yet.
  * 
  * The [[io.vertx.scala.core.Promise#future]] method returns the [[io.vertx.scala.core.Future]] associated with a promise, the future
  * can be used for getting notified of the promise completion and retrieve its value.
  * 
  * A promise extends `Handler<AsyncResult<T>>` so it can be used as a callback.
  */

class Promise[T: TypeTag](private val _asJava: Object) {
  def asJava = _asJava
  private var cached_0: Option[Future[T]] = None


  /**
   * @return the Future associated with this promise, it can be used to be aware of the promise completion
   */
  def future(): Future[T] = {
    if (cached_0 == None) {
      val tmp = asJava.asInstanceOf[JPromise[Object]].future()
      cached_0 = Some(Future[T](tmp))
    }
    cached_0.get
  }




  /**
   * Set the result. Any handler will be called, if there is one, and the promise will be marked as completed.
   * <p/>
   * Any handler set on the associated promise will be called.   * @param result the result
   */
  def complete (result: T): Unit = {
    asJava.asInstanceOf[JPromise[Object]].complete(toJava[T](result))
  }

  /**
   * Calls `complete(null)`   */
  def complete (): Unit = {
    asJava.asInstanceOf[JPromise[Object]].complete()
  }

  /**
   * Set the failure. Any handler will be called, if there is one, and the future will be marked as completed.   * @param cause the failure cause
   */
  def fail (cause: Throwable): Unit = {
    asJava.asInstanceOf[JPromise[Object]].fail(cause)
  }

  /**
   * Calls [[io.vertx.scala.core.Promise#fail]] with the `message`.   * @param message the failure message
   */
  def fail (message: String): Unit = {
    asJava.asInstanceOf[JPromise[Object]].fail(message.asInstanceOf[java.lang.String])
  }

  /**
   * Like [[io.vertx.scala.core.Promise#complete]] but returns `false` when the promise is already completed instead of throwing
   * an IllegalStateException, it returns `true` otherwise.   * @param result the result
   * @return `false` when the future is already completed
   */
  def tryComplete (result: T): Boolean = {
    asJava.asInstanceOf[JPromise[Object]].tryComplete(toJava[T](result)).asInstanceOf[Boolean]
  }

  /**
   * Calls `tryComplete(null)`.   * @return `false` when the future is already completed
   */
  def tryComplete (): Boolean = {
    asJava.asInstanceOf[JPromise[Object]].tryComplete().asInstanceOf[Boolean]
  }

  /**
   * Like [[io.vertx.scala.core.Promise#fail]] but returns `false` when the promise is already completed instead of throwing
   * an IllegalStateException, it returns `true` otherwise.   * @param cause the failure cause
   * @return `false` when the future is already completed
   */
  def tryFail (cause: Throwable): Boolean = {
    asJava.asInstanceOf[JPromise[Object]].tryFail(cause).asInstanceOf[Boolean]
  }

  /**
   * Calls [[io.vertx.scala.core.Promise#fail]] with the `message`.   * @param message the failure message
   * @return false when the future is already completed
   */
  def tryFail (message: String): Boolean = {
    asJava.asInstanceOf[JPromise[Object]].tryFail(message.asInstanceOf[java.lang.String]).asInstanceOf[Boolean]
  }


}

object Promise {
  def apply[T: TypeTag](asJava: JPromise[_]) = new Promise[T](asJava)

  /**
   * Create a promise that hasn't completed yet   * @return the promise
   */
  def promise[T: TypeTag](): Promise[T] = {
    Promise[T](JPromise.promise[Object]())//2 promise
  }

}
