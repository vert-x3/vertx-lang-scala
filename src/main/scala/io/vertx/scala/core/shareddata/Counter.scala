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

class Counter(private val _asJava: io.vertx.core.shareddata.Counter) {

  def asJava: java.lang.Object = _asJava

  def get(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.get(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  def incrementAndGet(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.incrementAndGet(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  def getAndIncrement(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getAndIncrement(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  def decrementAndGet(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.decrementAndGet(funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  def addAndGet(value: Long)(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.addAndGet(value, funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

  def getAndAdd(value: Long)(resultHandler: Try[Long] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getAndAdd(value, funcToMappedAsyncResultHandler[java.lang.Long, Long](x => x)(resultHandler))
  }

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
