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

import scala.reflect.runtime.universe._
import io.vertx.core.shareddata.{LocalMap => JLocalMap}
import scala.collection.JavaConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * Local maps can be used to share data safely in a single Vert.x instance.
  * 
  * By default the map allows immutable keys and values.
  * Custom keys and values should implement [[io.vertx.scala.core.shareddata.Shareable]] interface. The map returns their copies.
  * 
  * This ensures there is no shared access to mutable state from different threads (e.g. different event loops) in the
  * Vert.x instance, and means you don't have to protect access to that state using synchronization or locks.
  * 
  *
  * Since the version 3.4, this class extends the  interface. However some methods are only accessible in Java.
  */

class LocalMap[K: TypeTag, V: TypeTag](private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Get a value from the map   * @param key the key
   * @return the value, or null if none
   */
  def get (key: AnyRef): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].get(key))
  }

  /**
   * Put an entry in the map   * @param key the key
   * @param value the value
   * @return return the old value, or null if none
   */
  def put (key: K, value: V): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].put(toJava[K](key), toJava[V](value)))
  }

  /**
   * Remove an entry from the map   * @param key the key
   * @return the old value
   */
  def remove (key: AnyRef): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].remove(key))
  }

  /**
   * Clear all entries in the map
   */
  def clear (): Unit = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].clear()
  }

  /**
   * Get the size of the map   * @return the number of entries in the map
   */
  def size (): Int = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].size().asInstanceOf[Int]
  }

  /**
   * @return true if there are zero entries in the map
   */
  def isEmpty (): Boolean = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].isEmpty().asInstanceOf[Boolean]
  }

  /**
   * Put the entry only if there is no existing entry for that key   * @param key the key
   * @param value the value
   * @return the old value or null, if none
   */
  def putIfAbsent (key: K, value: V): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].putIfAbsent(toJava[K](key), toJava[V](value)))
  }

  /**
   * Remove the entry only if there is an entry with the specified key and value.
   * 
   * This method is the poyglot version of [[io.vertx.scala.core.shareddata.LocalMap#remove]].   * @param key the key
   * @param value the value
   * @return true if removed
   */
  def removeIfPresent (key: K, value: V): Boolean = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].removeIfPresent(toJava[K](key), toJava[V](value)).asInstanceOf[Boolean]
  }

  /**
   * Replace the entry only if there is an existing entry with the specified key and value.
   * 
   * This method is the polyglot version of [[io.vertx.scala.core.shareddata.LocalMap#replace]].   * @param key the key
   * @param oldValue the old value
   * @param newValue the new value
   * @return true if removed
   */
  def replaceIfPresent (key: K, oldValue: V, newValue: V): Boolean = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].replaceIfPresent(toJava[K](key), toJava[V](oldValue), toJava[V](newValue)).asInstanceOf[Boolean]
  }

  /**
   * Replace the entry only if there is an existing entry with the key   * @param key the key
   * @param value the new value
   * @return the old value
   */
  def replace (key: K, value: V): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].replace(toJava[K](key), toJava[V](value)))
  }

  /**
   * Close and release the map
   */
  def close (): Unit = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].close()
  }

  /**
   * Returns `true` if this map contains a mapping for the specified
   * key.   * @param key key whose presence in this map is to be tested
   * @return `true` if this map contains a mapping for the specified key
   */
  def containsKey (key: AnyRef): Boolean = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].containsKey(key).asInstanceOf[Boolean]
  }

  /**
   * Returns @{code true` if this map maps one or more keys to the
   * specified value.   * @param value value whose presence in this map is to be tested
   * @return @{code true` if this map maps one or more keys to the specified value
   */
  def containsValue (value: AnyRef): Boolean = {
    asJava.asInstanceOf[JLocalMap[Object, Object]].containsValue(value).asInstanceOf[Boolean]
  }

  /**
   * Returns the value to which the specified key is mapped, or
   * `defaultValue` if this map contains no mapping for the key.   * @param key the key whose associated value is to be returned
   * @param defaultValue the default mapping of the key
   * @return the value to which the specified key is mapped, or `defaultValue` if this map contains no mapping for the key
   */
  def getOrDefault (key: AnyRef, defaultValue: V): V = {
    toScala[V](asJava.asInstanceOf[JLocalMap[Object, Object]].getOrDefault(key, toJava[V](defaultValue)))
  }


}

object LocalMap {
  def apply[K: TypeTag, V: TypeTag](asJava: JLocalMap[_, _]) = new LocalMap[K, V](asJava)

}
