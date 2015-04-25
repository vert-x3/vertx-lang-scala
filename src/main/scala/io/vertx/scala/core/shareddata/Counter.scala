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

import scala.util.Try
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: io.vertx.core.shareddata.Counter) {

  def asJava: java.lang.Object = _asJava

  /**
    * Get the current value of the counter
    * @param resultHandler handler which will be passed the value
    */
  def get(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.get(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Increment the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def incrementAndGet(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.incrementAndGet(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Increment the counter atomically and return the value before the increment.
    * @param resultHandler handler which will be passed the value
    */
  def getAndIncrement(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getAndIncrement(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Decrement the counter atomically and return the new count
    * @param resultHandler handler which will be passed the value
    */
  def decrementAndGet(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.decrementAndGet(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the new count
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def addAndGet(value: Long)(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.addAndGet(value, funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Add the value to the counter atomically and return the value before the add
    * @param value the value to add
    * @param resultHandler handler which will be passed the value
    */
  def getAndAdd(value: Long)(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getAndAdd(value, funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  /**
    * Set the counter to the specified value only if the current value is the expectec value. This happens
    * atomically.
    * @param expected the expected value
    * @param value the new value
    * @param resultHandler the handler will be passed true on success
    */
  def compareAndSet(expected: Long, value: Long)(resultHandler: Try[Boolean] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.compareAndSet(expected, value, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(resultHandler))
  }

}

object Counter {

  def apply(_asJava: io.vertx.core.shareddata.Counter): io.vertx.scala.core.shareddata.Counter =
    new io.vertx.scala.core.shareddata.Counter(_asJava)
}
