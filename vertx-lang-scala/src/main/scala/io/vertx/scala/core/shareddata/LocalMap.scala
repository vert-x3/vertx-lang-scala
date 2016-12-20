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

import io.vertx.core.shareddata.{LocalMap => JLocalMap}

/**
  * Local maps can be used to share data safely in a single Vert.x instance.
  * 
  * The map only allows immutable keys and values in the map, OR certain mutable objects such as [[io.vertx.scala.core.buffer.Buffer]]
  * instances which will be copied when they are added to the map.
  * 
  * This ensures there is no shared access to mutable state from different threads (e.g. different event loops) in the
  * Vert.x instance, and means you don't have to protect access to that state using synchronization or locks.
  */
class LocalMap[K,V](private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def get(key: K):V = {
    asJava.asInstanceOf[JLocalMap[K,V]].get(key)
  }

  def put(key: K,value: V):V = {
    asJava.asInstanceOf[JLocalMap[K,V]].put(key,value)
  }

  def remove(key: K):V = {
    asJava.asInstanceOf[JLocalMap[K,V]].remove(key)
  }

  def clear():Unit = {
    asJava.asInstanceOf[JLocalMap[K,V]].clear()
  }

  def size():Int = {
    asJava.asInstanceOf[JLocalMap[K,V]].size()
  }

  def isEmpty():Boolean = {
    asJava.asInstanceOf[JLocalMap[K,V]].isEmpty()
  }

  def putIfAbsent(key: K,value: V):V = {
    asJava.asInstanceOf[JLocalMap[K,V]].putIfAbsent(key,value)
  }

  def removeIfPresent(key: K,value: V):Boolean = {
    asJava.asInstanceOf[JLocalMap[K,V]].removeIfPresent(key,value)
  }

  def replaceIfPresent(key: K,oldValue: V,newValue: V):Boolean = {
    asJava.asInstanceOf[JLocalMap[K,V]].replaceIfPresent(key,oldValue,newValue)
  }

  def replace(key: K,value: V):V = {
    asJava.asInstanceOf[JLocalMap[K,V]].replace(key,value)
  }

  def close():Unit = {
    asJava.asInstanceOf[JLocalMap[K,V]].close()
  }

}

  object LocalMap{
    def apply[K,V](asJava: JLocalMap[K,V]) = new LocalMap[K,V](asJava)  
  //static methods
  }
