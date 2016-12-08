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
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
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
class LocalMap[K: TypeTag, V: TypeTag](private val _asJava: JLocalMap[Object, Object]) {

  def asJava: JLocalMap[Object, Object] = _asJava

  /**
    * Get a value from the map
    * @param key the key
    * @return the value, or null if none
    */
  def get(key: K): V = {
    toScala(_asJava.get(toJava(key).asInstanceOf))
  }

  /**
    * Put an entry in the map
    * @param key the key
    * @param value the value
    * @return return the old value, or null if none
    */
  def put(key: K, value: V): V = {
    toScala(_asJava.put(toJava(key).asInstanceOf, toJava(value).asInstanceOf))
  }

  /**
    * Remove an entry from the map
    * @param key the key
    * @return the old value
    */
  def remove(key: K): V = {
    toScala(_asJava.remove(toJava(key).asInstanceOf))
  }

  /**
    * Clear all entries in the map
    */
  def clear(): Unit = {
    _asJava.clear()
  }

  /**
    * Get the size of the map
    * @return the number of entries in the map
    */
  def size(): Int = {
    _asJava.size()
  }

  /**
    * @return true if there are zero entries in the map
    */
  def isEmpty(): Boolean = {
    _asJava.isEmpty()
  }

  /**
    * Put the entry only if there is no existing entry for that key
    * @param key the key
    * @param value the value
    * @return the old value or null, if none
    */
  def putIfAbsent(key: K, value: V): V = {
    toScala(_asJava.putIfAbsent(toJava(key).asInstanceOf, toJava(value).asInstanceOf))
  }

  /**
    * Remove the entry only if there is an entry with the specified key and value
    * @param key the key
    * @param value the value
    * @return true if removed
    */
  def removeIfPresent(key: K, value: V): Boolean = {
    _asJava.removeIfPresent(toJava(key).asInstanceOf, toJava(value).asInstanceOf)
  }

  /**
    * Replace the entry only if there is an existing entry with the specified key and value
    * @param key the key
    * @param oldValue the old value
    * @param newValue the new value
    * @return true if removed
    */
  def replaceIfPresent(key: K, oldValue: V, newValue: V): Boolean = {
    _asJava.replaceIfPresent(toJava(key).asInstanceOf, toJava(oldValue).asInstanceOf, toJava(newValue).asInstanceOf)
  }

  /**
    * Replace the entry only if there is an existing entry with the key
    * @param key the key
    * @param value the new value
    * @return the old value
    */
  def replace(key: K, value: V): V = {
    toScala(_asJava.replace(toJava(key).asInstanceOf, toJava(value).asInstanceOf))
  }

  /**
    * Close and release the map
    */
  def close(): Unit = {
    _asJava.close()
  }

}

object LocalMap {

  def apply[K: TypeTag, V: TypeTag](_asJava: JLocalMap[Object, Object]): LocalMap[K, V] =
    new LocalMap(_asJava)

}
