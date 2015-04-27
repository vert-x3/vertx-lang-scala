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

package io.vertx.scala.core.shareddata;

import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: io.vertx.core.shareddata.Counter) {

  def asJava: java.lang.Object = _asJava

  /**
    * Get the current value of the counter
    * @return handler which will be passed the value
    */
  def get(): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.get(promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Increment the counter atomically and return the new count
    * @return handler which will be passed the value
    */
  def incrementAndGet(): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.incrementAndGet(promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @return handler which will be passed the value
    */
  def getAndIncrement(): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.getAndIncrement(promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Decrement the counter atomically and return the new count
    * @return handler which will be passed the value
    */
  def decrementAndGet(): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.decrementAndGet(promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @return handler which will be passed the value
    */
  def addAndGet(value: Long): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.addAndGet(value, promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @return handler which will be passed the value
    */
  def getAndAdd(value: Long): scala.concurrent.Future[Long] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Long]()
    _asJava.getAndAdd(value, promiseToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(promise))
    promise.future
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @return the handler will be passed true on success
    */
  def compareAndSet(expected: Long, value: Long): scala.concurrent.Future[Boolean] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Boolean]()
    _asJava.compareAndSet(expected, value, promiseToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(promise))
    promise.future
  }

}

object Counter {

  def apply(_asJava: io.vertx.core.shareddata.Counter): io.vertx.scala.core.shareddata.Counter =
    new io.vertx.scala.core.shareddata.Counter(_asJava)
}
