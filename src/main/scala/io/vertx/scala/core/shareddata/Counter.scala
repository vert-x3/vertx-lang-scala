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
    * @param resultHandler handler which will be passed the value
    */
  def get(resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.get(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Increment the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def incrementAndGet(resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.incrementAndGet(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @param resultHandler handler which will be passed the value
    */
  def getAndIncrement(resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.getAndIncrement(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Decrement the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def decrementAndGet(resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.decrementAndGet(funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def addAndGetWithHandler(value: Long)( resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.addAndGet(value, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def getAndAddWithHandler(value: Long)( resultHandler: io.vertx.core.AsyncResult [Long] => Unit): Unit = {
    _asJava.getAndAdd(value, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Long], io.vertx.core.AsyncResult [Long]](x => io.vertx.lang.scala.AsyncResult[java.lang.Long, Long](x,(x => x)))(resultHandler))
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @param resultHandler the handler will be passed true on success
    */
  def compareAndSetWithHandler(expected: Long, value: Long)( resultHandler: io.vertx.core.AsyncResult [Boolean] => Unit): Unit = {
    _asJava.compareAndSet(expected, value, funcToMappedHandler[io.vertx.core.AsyncResult[java.lang.Boolean], io.vertx.core.AsyncResult [Boolean]](x => io.vertx.lang.scala.AsyncResult[java.lang.Boolean, Boolean](x,(x => x)))(resultHandler))
  }

}

object Counter {

  def apply(_asJava: io.vertx.core.shareddata.Counter): io.vertx.scala.core.shareddata.Counter =
    new io.vertx.scala.core.shareddata.Counter(_asJava)

}
