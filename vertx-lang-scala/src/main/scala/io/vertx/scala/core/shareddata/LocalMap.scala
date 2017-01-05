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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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
class LocalMap[K:TypeTag,V:TypeTag](private val _asJava: Object, objectToK: Option[Object => K] = None, objectToV: Option[Object => V] = None) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def get(key: K):V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object,Object]].get(toJava[K](key)))
  }

  def put(key: K,value: V):V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object,Object]].put(toJava[K](key),toJava[V](value)))
  }

  def remove(key: K):V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object,Object]].remove(toJava[K](key)))
  }

  def clear():Unit = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].clear()
  }

  def size():Int = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].size().asInstanceOf[Int]
  }

  def isEmpty():Boolean = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].isEmpty().asInstanceOf[Boolean]
  }

  def putIfAbsent(key: K,value: V):V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object,Object]].putIfAbsent(toJava[K](key),toJava[V](value)))
  }

  def removeIfPresent(key: K,value: V):Boolean = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].removeIfPresent(toJava[K](key),toJava[V](value)).asInstanceOf[Boolean]
  }

  def replaceIfPresent(key: K,oldValue: V,newValue: V):Boolean = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].replaceIfPresent(toJava[K](key),toJava[V](oldValue),toJava[V](newValue)).asInstanceOf[Boolean]
  }

  def replace(key: K,value: V):V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object,Object]].replace(toJava[K](key),toJava[V](value)))
  }

  def close():Unit = {
    asJava.asInstanceOf[JLocalMap[Object,Object]].close()
  }

//future methods
}

  object LocalMap{
    def apply[K:TypeTag,V:TypeTag](asJava: JLocalMap[_,_], objectToK: Option[Object => K] = None, objectToV: Option[Object => V] = None) = new LocalMap[K,V](asJava, objectToK, objectToV)  
  //static methods
  }
