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

package io.vertx.scala.core.shareddata

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: io.vertx.core.shareddata.Counter) {

  def asJava: io.vertx.core.shareddata.Counter = _asJava

  /**
    * Get the current value of the counter
    * @return a future WUHUUU    */
  def getFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.get(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the counter atomically and return the new count
    * @return a future WUHUUU    */
  def incrementAndGetFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.incrementAndGet(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @return a future WUHUUU    */
  def getAndIncrementFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.getAndIncrement(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Decrement the counter atomically and return the new count
    * @return a future WUHUUU    */
  def decrementAndGetFuture(): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.decrementAndGet(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @return a future WUHUUU    */
  def addAndGetFuture(value: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.addAndGet(value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @return a future WUHUUU    */
  def getAndAddFuture(value: Long): concurrent.Future[Long] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Long,Long]((x => x))
    _asJava.getAndAdd(value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @return a future WUHUUU    */
  def compareAndSetFuture(expected: Long, value: Long): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.compareAndSet(expected, value, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object Counter {

  def apply(_asJava: io.vertx.core.shareddata.Counter): io.vertx.scala.core.shareddata.Counter =
    new io.vertx.scala.core.shareddata.Counter(_asJava)

}
