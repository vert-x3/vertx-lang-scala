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

class SharedData(private val _asJava: io.vertx.core.shareddata.SharedData) {

  def asJava: java.lang.Object = _asJava

  def getClusterWideMap[K, V](name: String)(resultHandler: Try[io.vertx.scala.core.shareddata.AsyncMap[K, V]] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getClusterWideMap(name, funcToMappedAsyncResultHandler(AsyncMap.apply[K,V])(resultHandler))
  }

  def getLock(name: String)(resultHandler: Try[io.vertx.scala.core.shareddata.Lock] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getLock(name, funcToMappedAsyncResultHandler(Lock.apply)(resultHandler))
  }

  def getLockWithTimeout(name: String, timeout: Long)(resultHandler: Try[io.vertx.scala.core.shareddata.Lock] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getLockWithTimeout(name, timeout, funcToMappedAsyncResultHandler(Lock.apply)(resultHandler))
  }

  def getCounter(name: String)(resultHandler: Try[io.vertx.scala.core.shareddata.Counter] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.getCounter(name, funcToMappedAsyncResultHandler(Counter.apply)(resultHandler))
  }

  def getLocalMap[K, V](name: String): io.vertx.scala.core.shareddata.LocalMap[K, V] = {
    LocalMap.apply[K,V](_asJava.getLocalMap(name))
  }

}

object SharedData {

  def apply(_asJava: io.vertx.core.shareddata.SharedData): io.vertx.scala.core.shareddata.SharedData =
    new io.vertx.scala.core.shareddata.SharedData(_asJava)
}
