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
    asJava.asInstanceOf[JSharedData].getClusterWideMap[K,V](name,{x: AsyncResult[JAsyncMap[K,V]] => resultHandler.handle(AsyncResultWrapper[JAsyncMap[K,V],AsyncMap[K, V]](x, a => AsyncMap[K,V](a)))})
  }

  def getLock(name: String,resultHandler: Handler[AsyncResult[Lock]]):Unit = {
    asJava.asInstanceOf[JSharedData].getLock(name,{x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock,Lock](x, a => Lock(a)))})
  }

  def getLockWithTimeout(name: String,timeout: Long,resultHandler: Handler[AsyncResult[Lock]]):Unit = {
    asJava.asInstanceOf[JSharedData].getLockWithTimeout(name,timeout,{x: AsyncResult[JLock] => resultHandler.handle(AsyncResultWrapper[JLock,Lock](x, a => Lock(a)))})
  }

  def getCounter(name: String,resultHandler: Handler[AsyncResult[Counter]]):Unit = {
    asJava.asInstanceOf[JSharedData].getCounter(name,{x: AsyncResult[JCounter] => resultHandler.handle(AsyncResultWrapper[JCounter,Counter](x, a => Counter(a)))})
  }

  def getLocalMap[K, V](name: String):LocalMap[K, V] = {
    LocalMap[K,V](asJava.asInstanceOf[JSharedData].getLocalMap[K,V](name))
  }

}

  object SharedData{
    def apply(asJava: JSharedData) = new SharedData(asJava)  
  //static methods
  }
