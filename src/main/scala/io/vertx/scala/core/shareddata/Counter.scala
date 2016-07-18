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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import scala.util.Try
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: io.vertx.core.shareddata.Counter) {

  def asJava: io.vertx.core.shareddata.Counter = _asJava

  /**
    * Get the current value of the counter
    * @return handler which will be passed the value
    */
  def get(resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.get(funcToHandler(resultHandler))
  }

  /**
    * Increment the counter atomically and return the new count
    * @return handler which will be passed the value
    */
  def incrementAndGet(resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.incrementAndGet(funcToHandler(resultHandler))
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @return handler which will be passed the value
    */
  def getAndIncrement(resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.getAndIncrement(funcToHandler(resultHandler))
  }

  /**
    * Decrement the counter atomically and return the new count
    * @return handler which will be passed the value
    */
  def decrementAndGet(resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.decrementAndGet(funcToHandler(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @return handler which will be passed the value
    */
  def addAndGet(value: Long, resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.addAndGet(value, funcToHandler(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @return handler which will be passed the value
    */
  def getAndAdd(value: Long, resultHandler: io.vertx.core.AsyncResult[java.lang.Long] => Unit): Unit = {
    _asJava.getAndAdd(value, funcToHandler(resultHandler))
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @return the handler will be passed true on success
    */
  def compareAndSet(expected: Long, value: Long, resultHandler: io.vertx.core.AsyncResult[java.lang.Boolean] => Unit): Unit = {
    _asJava.compareAndSet(expected, value, funcToHandler(resultHandler))
  }

}

object Counter {

  def apply(_asJava: io.vertx.core.shareddata.Counter): io.vertx.scala.core.shareddata.Counter =
    new io.vertx.scala.core.shareddata.Counter(_asJava)
}
