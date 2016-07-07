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

import io.vertx.lang.scala.HandlerOps._
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K, V](private val _asJava: io.vertx.core.shareddata.AsyncMap[K, V]) {

  def asJava: io.vertx.core.shareddata.AsyncMap[K, V] = _asJava

  /**
    * Get a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later with the async result.
    */
  def get(k: K, resultHandler: io.vertx.core.AsyncResult[V] => Unit): Unit = {
    _asJava.get(k, funcToHandler(resultHandler))
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been put
    */
  def put(k: K, v: V, completionHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.put(k, v, funcToHandler(completionHandler))
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.AsyncMap#put]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the handler
    */
  def put(k: K, v: V, ttl: Long, completionHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.put(k, v, ttl, funcToHandler(completionHandler))
  }

  /**
    * Put the entry only if there is no entry with the key already present. If key already present then the existing
    * value will be returned to the handler, otherwise null.
    * @param k the key
    * @param v the value
    * @return the handler
    */
  def putIfAbsent(k: K, v: V, completionHandler: io.vertx.core.AsyncResult[V] => Unit): Unit = {
    _asJava.putIfAbsent(k, v, funcToHandler(completionHandler))
  }

  /**
    * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsent]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the handler
    */
  def putIfAbsent(k: K, v: V, ttl: Long, completionHandler: io.vertx.core.AsyncResult[V] => Unit): Unit = {
    _asJava.putIfAbsent(k, v, ttl, funcToHandler(completionHandler))
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later to signify the value has been removed
    */
  def remove(k: K, resultHandler: io.vertx.core.AsyncResult[V] => Unit): Unit = {
    _asJava.remove(k, funcToHandler(resultHandler))
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeIfPresent(k: K, v: V, resultHandler: io.vertx.core.AsyncResult[java.lang.Boolean] => Unit): Unit = {
    _asJava.removeIfPresent(k, v, funcToHandler(resultHandler))
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @return the result handler will be passed the previous value
    */
  def replace(k: K, v: V, resultHandler: io.vertx.core.AsyncResult[V] => Unit): Unit = {
    _asJava.replace(k, v, funcToHandler(resultHandler))
  }

  /**
    * Replace the entry only if it is currently mapped to a specific value
    * @param k the key
    * @param oldValue the existing value
    * @param newValue the new value
    * @return the result handler
    */
  def replaceIfPresent(k: K, oldValue: V, newValue: V, resultHandler: io.vertx.core.AsyncResult[java.lang.Boolean] => Unit): Unit = {
    _asJava.replaceIfPresent(k, oldValue, newValue, funcToHandler(resultHandler))
  }

  /**
    * Clear all entries in the map
    * @return called on completion
    */
  def clear(resultHandler: io.vertx.core.AsyncResult[java.lang.Void] => Unit): Unit = {
    _asJava.clear(funcToHandler(resultHandler))
  }

  /**
    * Provide the number of entries in the map
    * @return handler which will receive the number of entries
    */
  def size(resultHandler: io.vertx.core.AsyncResult[java.lang.Integer] => Unit): Unit = {
    _asJava.size(funcToHandler(resultHandler))
  }

}

object AsyncMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.AsyncMap[K, V]): io.vertx.scala.core.shareddata.AsyncMap[K, V] =
    new io.vertx.scala.core.shareddata.AsyncMap(_asJava)
}