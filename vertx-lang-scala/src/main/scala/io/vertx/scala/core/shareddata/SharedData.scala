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

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{Counter => JCounter}
import scala.reflect.runtime.universe._
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import io.vertx.core.shareddata.{Lock => JLock}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.shareddata.{SharedData => JSharedData}
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Shared data allows you to share data safely between different parts of your application in a safe way.
  * 
  * Shared data provides:
  * <ul>
  *   <li>synchronous shared maps (local)</li>
  *   <li>asynchronous maps (local or cluster-wide)</li>
  *   <li>asynchronous locks (local or cluster-wide)</li>
  *   <li>asynchronous counters (local or cluster-wide)</li>
  * </ul>
  * 
  * 
  *   <strong>WARNING</strong>: In clustered mode, asynchronous maps/locks/counters rely on distributed data structures provided by the cluster manager.
  *   Beware that the latency relative to asynchronous maps/locks/counters operations can be much higher in clustered than in local mode.
  * </p>
  * Please see the documentation for more information.
  */

class SharedData(private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Get the cluster wide map with the specified name. The map is accessible to all nodes in the cluster and data
   * put into the map from any node is visible to to any other node.   * @param name the name of the map
   * @param resultHandler the map will be returned asynchronously in this handler
   */
  def getClusterWideMap [K: TypeTag, V: TypeTag](name: String, resultHandler: Handler[AsyncResult[AsyncMap[K, V]]]): Unit = {
    asJava.asInstanceOf[JSharedData].getClusterWideMap[Object, Object](name.asInstanceOf[java.lang.String], {x: AsyncResult[JAsyncMap[Object, Object]] => resultHandler.handle(AsyncResultWrapper[JAsyncMap[Object, Object], AsyncMap[K, V]](x, a => AsyncMap[K, V](a)))})
  }

  /**
   * Get the [[io.vertx.scala.core.shareddata.AsyncMap]] with the specified name. When clustered, the map is accessible to all nodes in the cluster
   * and data put into the map from any node is visible to to any other node.
   * 
   *   <strong>WARNING</strong>: In clustered mode, asynchronous shared maps rely on distributed data structures provided by the cluster manager.
   *   Beware that the latency relative to asynchronous shared maps operations can be much higher in clustered than in local mode.
   * </p>   * @param name the name of the map
   * @param resultHandler the map will be returned asynchronously in this handler
   */
  def getAsyncMap [K: TypeTag, V: TypeTag](name: String, resultHandler: Handler[AsyncResult[AsyncMap[K, V]]]): Unit = {
    asJava.asInstanceOf[JSharedData].getAsyncMap[Object, Object](name.asInstanceOf[java.lang.String], {x: AsyncResult[JAsyncMap[Object, Object]] => resultHandler.handle(AsyncResultWrapper[JAsyncMap[Object, Object], AsyncMap[K, V]](x, a => AsyncMap[K, V](a)))})
  }

  /**
   * Get an asynchronous lock with the specified name. The lock will be passed to the handler when it is available.
   * 
   *   In general lock acquision is unordered, so that sequential attempts to acquire a lock,
   *   even from a single thread, can happen in non-sequential order.
   * </p>   * @param name the name of the lock
   * @param resultHandler the handler
   */
  def getLock (name: String, resultHandler: Handler[AsyncResult[Lock]]): Unit = {
    asJava.asInstanceOf[JSharedData].getLock(name.asInstanceOf[java.lang.String], {x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock, Lock](x, a => Lock(a)))})
  }

  /**
   * Like [[io.vertx.scala.core.shareddata.SharedData#getLock]] but specifying a timeout. If the lock is not obtained within the timeout
   * a failure will be sent to the handler.
   * 
   *   In general lock acquision is unordered, so that sequential attempts to acquire a lock,
   *   even from a single thread, can happen in non-sequential order.
   * </p>   * @param name the name of the lock
   * @param timeout the timeout in ms
   * @param resultHandler the handler
   */
  def getLockWithTimeout (name: String, timeout: Long, resultHandler: Handler[AsyncResult[Lock]]): Unit = {
    asJava.asInstanceOf[JSharedData].getLockWithTimeout(name.asInstanceOf[java.lang.String], timeout.asInstanceOf[java.lang.Long], {x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock, Lock](x, a => Lock(a)))})
  }

  /**
   * Get an asynchronous counter. The counter will be passed to the handler.   * @param name the name of the counter.
   * @param resultHandler the handler
   */
  def getCounter (name: String, resultHandler: Handler[AsyncResult[Counter]]): Unit = {
    asJava.asInstanceOf[JSharedData].getCounter(name.asInstanceOf[java.lang.String], {x: AsyncResult[JCounter] => resultHandler.handle(AsyncResultWrapper[JCounter, Counter](x, a => Counter(a)))})
  }

  /**
   * Return a `LocalMap` with the specific `name`.   * @param name the name of the map
   * @return the msp
   */
  def getLocalMap [K: TypeTag, V: TypeTag](name: String): LocalMap[K, V] = {
    LocalMap[K, V](asJava.asInstanceOf[JSharedData].getLocalMap[Object, Object](name.asInstanceOf[java.lang.String]))
  }


 /**
  * Like [[getClusterWideMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getClusterWideMapFuture [K: TypeTag, V: TypeTag](name: String): scala.concurrent.Future[AsyncMap[K, V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncMap[Object, Object], AsyncMap[K, V]](x => AsyncMap[K, V](x))
    asJava.asInstanceOf[JSharedData].getClusterWideMap[Object, Object](name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getAsyncMap]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getAsyncMapFuture [K: TypeTag, V: TypeTag](name: String): scala.concurrent.Future[AsyncMap[K, V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncMap[Object, Object], AsyncMap[K, V]](x => AsyncMap[K, V](x))
    asJava.asInstanceOf[JSharedData].getAsyncMap[Object, Object](name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getLock]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getLockFuture (name: String): scala.concurrent.Future[Lock] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JLock, Lock](x => Lock(x))
    asJava.asInstanceOf[JSharedData].getLock(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getLockWithTimeout]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getLockWithTimeoutFuture (name: String, timeout: Long): scala.concurrent.Future[Lock] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JLock, Lock](x => Lock(x))
    asJava.asInstanceOf[JSharedData].getLockWithTimeout(name.asInstanceOf[java.lang.String], timeout.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[getCounter]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getCounterFuture (name: String): scala.concurrent.Future[Counter] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCounter, Counter](x => Counter(x))
    asJava.asInstanceOf[JSharedData].getCounter(name.asInstanceOf[java.lang.String], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object SharedData {
  def apply(asJava: JSharedData) = new SharedData(asJava)
  
}
