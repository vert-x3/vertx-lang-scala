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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import io.vertx.core.shareddata.{Lock => JLock}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.core.shareddata.{SharedData => JSharedData}

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
class SharedData(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
      def getClusterWideMap[K, V](name: String,resultHandler: Handler[AsyncResult[AsyncMap[K, V]]]):Unit = {
    asJava.asInstanceOf[JSharedData].getClusterWideMap[K,V](name.asInstanceOf[java.lang.String],{x: AsyncResult[JAsyncMap[K,V]] => resultHandler.handle(AsyncResultWrapper[JAsyncMap[K,V],AsyncMap[K, V]](x, a => AsyncMap[K,V](a)))})
  }

      def getLock(name: String,resultHandler: Handler[AsyncResult[Lock]]):Unit = {
    asJava.asInstanceOf[JSharedData].getLock(name.asInstanceOf[java.lang.String],{x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock,Lock](x, a => Lock(a)))})
  }

      def getLockWithTimeout(name: String,timeout: Long,resultHandler: Handler[AsyncResult[Lock]]):Unit = {
    asJava.asInstanceOf[JSharedData].getLockWithTimeout(name.asInstanceOf[java.lang.String],timeout.asInstanceOf[java.lang.Long],{x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock,Lock](x, a => Lock(a)))})
  }

      def getCounter(name: String,resultHandler: Handler[AsyncResult[Counter]]):Unit = {
    asJava.asInstanceOf[JSharedData].getCounter(name.asInstanceOf[java.lang.String],{x: AsyncResult[JCounter] => resultHandler.handle(AsyncResultWrapper[JCounter,Counter](x, a => Counter(a)))})
  }

      def getLocalMap[K, V](name: String):LocalMap[K, V] = {
    LocalMap[K,V](asJava.asInstanceOf[JSharedData].getLocalMap[K,V](name.asInstanceOf[java.lang.String]))
  }

//future methods
  def getClusterWideMapFuture[K, V](name: String):scala.concurrent.Future[AsyncMap[K, V]] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JAsyncMap[K,V], AsyncMap[K, V]](x => if (x == null) null.asInstanceOf[AsyncMap[K, V]] else AsyncMap[K,V](x))
    asJava.asInstanceOf[JSharedData].getClusterWideMap[K,V](name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getLockFuture(name: String):scala.concurrent.Future[Lock] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JLock, Lock](x => if (x == null) null.asInstanceOf[Lock] else Lock(x))
    asJava.asInstanceOf[JSharedData].getLock(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getLockWithTimeoutFuture(name: String,timeout: Long):scala.concurrent.Future[Lock] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JLock, Lock](x => if (x == null) null.asInstanceOf[Lock] else Lock(x))
    asJava.asInstanceOf[JSharedData].getLockWithTimeout(name.asInstanceOf[java.lang.String],timeout.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def getCounterFuture(name: String):scala.concurrent.Future[Counter] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[JCounter, Counter](x => if (x == null) null.asInstanceOf[Counter] else Counter(x))
    asJava.asInstanceOf[JSharedData].getCounter(name.asInstanceOf[java.lang.String],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object SharedData{
    def apply(asJava: JSharedData) = new SharedData(asJava)  
  //static methods
  }
