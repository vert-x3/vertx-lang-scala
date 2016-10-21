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

package io.vertx.scala.ext.unit

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.scala.core.Future

/**
  * A completion object that emits completion notifications either <i>succeeded</i> or <i>failed</i>.
  */
class Completion[T](private val _asJava: io.vertx.ext.unit.Completion[T]) {

  def asJava: io.vertx.ext.unit.Completion[T] = _asJava

  /**
    * Completes the future upon completion, otherwise fails it.
    * @param future the future to resolve
    */
  def resolve(future: io.vertx.scala.core.Future[T]): Unit = {
    _asJava.resolve(future.asJava.asInstanceOf[io.vertx.core.Future[T]])
  }

  /**
    * @return true if this completion is completed
    */
  def isCompleted(): Boolean = {
    _asJava.isCompleted()
  }

  /**
    * @return true if the this completion is completed succeeded
    */
  def isSucceeded(): Boolean = {
    _asJava.isSucceeded()
  }

  /**
    * @return true if the this completion is completed and failed
    */
  def isFailed(): Boolean = {
    _asJava.isFailed()
  }

  /**
    * Completion handler to receive a completion signal when this completions completes.
    * @return the completion future
    */
  def handlerFuture(): concurrent.Future[T] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[T,T]((x => x))
    _asJava.handler(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Cause the current thread to wait until thi completion completes.<p/>
    *
    * If the current thread is interrupted, an exception will be thrown.
    */
  def await(): Unit = {
    _asJava.await()
  }

  /**
    * Cause the current thread to wait until this completion completes with a configurable timeout.<p/>
    *
    * If completion times out or the current thread is interrupted, an exception will be thrown.
    * @param timeoutMillis the timeout in milliseconds
    */
  def await(timeoutMillis: Long): Unit = {
    _asJava.await(timeoutMillis)
  }

  /**
    * Cause the current thread to wait until this completion completes and succeeds.<p/>
    *
    * If the current thread is interrupted or the suite fails, an exception will be thrown.
    */
  def awaitSuccess(): Unit = {
    _asJava.awaitSuccess()
  }

  /**
    * Cause the current thread to wait until this completion completes and succeeds with a configurable timeout.<p/>
    *
    * If completion times out or the current thread is interrupted or the suite fails, an exception will be thrown.
    * @param timeoutMillis the timeout in milliseconds
    */
  def awaitSuccess(timeoutMillis: Long): Unit = {
    _asJava.awaitSuccess(timeoutMillis)
  }

}

object Completion {

  def apply[T](_asJava: io.vertx.ext.unit.Completion[T]): io.vertx.scala.ext.unit.Completion[T] =
    new io.vertx.scala.ext.unit.Completion(_asJava)

}
