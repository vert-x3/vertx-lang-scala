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

import io.vertx.scala.core.shareddata.AsyncMap
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.scala.core.shareddata.Lock
import io.vertx.core.shareddata.{Lock => JLock}
import io.vertx.scala.core.shareddata.LocalMap
import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import io.vertx.scala.core.shareddata.Counter
import io.vertx.core.shareddata.{Counter => JCounter}

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

def asJava = _asJava.asInstanceOf[JSharedData]
//methods returning a future
  def getClusterWideMap(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[AsyncMap[K, V]]]):Unit = {
    asJava.getClusterWideMap( )
  }

  def getLock(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Lock]]):Unit = {
    asJava.getLock( )
  }

  def getLockWithTimeout(name: String,timeout: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Lock]]):Unit = {
    asJava.getLockWithTimeout( )
  }

  def getCounter(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Counter]]):Unit = {
    asJava.getCounter( )
  }

//cached methods
//fluent methods
//basic methods
  def getClusterWideMap(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[AsyncMap[K, V]]]):Unit = {
    asJava.getClusterWideMap( )
  }

  def getLock(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Lock]]):Unit = {
    asJava.getLock( )
  }

  def getLockWithTimeout(name: String,timeout: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Lock]]):Unit = {
    asJava.getLockWithTimeout( )
  }

  def getCounter(name: String,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Counter]]):Unit = {
    asJava.getCounter( )
  }

  def getLocalMap(name: String):LocalMap[K, V] = {
    asJava.getLocalMap( )
  }

}

object SharedData{
//in object!
//static methods
}
