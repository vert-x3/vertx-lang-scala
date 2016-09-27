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
  * Shared data allows you to share data safely between different parts of your application in a safe way.
  * 
  * Shared data provides:
  * <ul>
  *   <li>Cluster wide maps which can be accessed from any node of the cluster</li>
  *   <li>Cluster wide locks which can be used to give exclusive access to resources across the cluster</li>
  *   <li>Cluster wide counters used to maintain counts consistently across the cluster</li>
  *   <li>Local maps for sharing data safely in the same Vert.x instance</li>
  * </ul>
  * 
  * Please see the documentation for more information.
  */
class SharedData(private val _asJava: io.vertx.core.shareddata.SharedData) {

  def asJava: io.vertx.core.shareddata.SharedData = _asJava

  /**
    * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
    * put into the map from any node is visible to to any other node.
    * @param name the name of the map
    * @return the map will be returned asynchronously in this future
    */
  def getClusterWideMapFuture[K, V](name: String): concurrent.Future[io.vertx.scala.core.shareddata.AsyncMap[K, V]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.shareddata.AsyncMap[K,V],io.vertx.scala.core.shareddata.AsyncMap[K, V]]((x => if (x == null) null else AsyncMap.apply[K,V](x)))
    _asJava.getClusterWideMap(name, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get a cluster wide lock with the specified name. The lock will be passed to the handler when it is available.
    * @param name the name of the lock
    * @return the future
    */
  def getLockFuture(name: String): concurrent.Future[io.vertx.scala.core.shareddata.Lock] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.shareddata.Lock,io.vertx.scala.core.shareddata.Lock]((x => if (x == null) null else Lock.apply(x)))
    _asJava.getLock(name, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.SharedData#getLock]] but specifying a timeout. If the lock is not obtained within the timeout
    * a failure will be sent to the handler
    * @param name the name of the lock
    * @param timeout the timeout in ms
    * @return the future
    */
  def getLockWithTimeoutFuture(name: String, timeout: Long): concurrent.Future[io.vertx.scala.core.shareddata.Lock] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.shareddata.Lock,io.vertx.scala.core.shareddata.Lock]((x => if (x == null) null else Lock.apply(x)))
    _asJava.getLockWithTimeout(name, timeout, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Get a cluster wide counter. The counter will be passed to the handler.
    * @param name the name of the counter.
    * @return the future
    */
  def getCounterFuture(name: String): concurrent.Future[io.vertx.scala.core.shareddata.Counter] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[io.vertx.core.shareddata.Counter,io.vertx.scala.core.shareddata.Counter]((x => if (x == null) null else Counter.apply(x)))
    _asJava.getCounter(name, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Return a `LocalMap` with the specific `name`.
    * @param name the name of the map
    * @return the msp
    */
  def getLocalMap[K, V](name: String): io.vertx.scala.core.shareddata.LocalMap[K, V] = {
    LocalMap.apply[K,V](_asJava.getLocalMap(name))
  }

}

object SharedData {

  def apply(_asJava: io.vertx.core.shareddata.SharedData): io.vertx.scala.core.shareddata.SharedData =
    new io.vertx.scala.core.shareddata.SharedData(_asJava)

}
