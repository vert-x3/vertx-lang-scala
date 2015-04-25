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


class LocalMap[K, V](private val _asJava: io.vertx.core.shareddata.LocalMap[K, V]) {

  def asJava: java.lang.Object = _asJava

  def get(key: K): V = {
    _asJava.get(key)
  }

  def put(key: K, value: V): V = {
    _asJava.put(key, value)
  }

  def remove(key: K): V = {
    _asJava.remove(key)
  }

  def clear(): Unit = {
    _asJava.clear()
  }

  def size(): Int = {
    _asJava.size()
  }

  def isEmpty(): Boolean = {
    _asJava.isEmpty()
  }

  def putIfAbsent(key: K, value: V): V = {
    _asJava.putIfAbsent(key, value)
  }

  def removeIfPresent(key: K, value: V): Boolean = {
    _asJava.removeIfPresent(key, value)
  }

  def replaceIfPresent(key: K, oldValue: V, newValue: V): Boolean = {
    _asJava.replaceIfPresent(key, oldValue, newValue)
  }

  def replace(key: K, value: V): V = {
    _asJava.replace(key, value)
  }

  def close(): Unit = {
    _asJava.close()
  }

}

object LocalMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.LocalMap[K,V]): io.vertx.scala.core.shareddata.LocalMap[K, V] =
    new io.vertx.scala.core.shareddata.LocalMap[K, V](_asJava)
}
