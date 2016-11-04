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
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
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
  def getFuture(k: K): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V,V]((x => x))
    _asJava.get(k, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been put
    */
  def putFuture(k: K, v: V): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.put(k, v, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.AsyncMap#put]] but specifying a time to live for the entry. Entry will expire and get evicted after the
    * ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the future
    */
  def putFuture(k: K, v: V, ttl: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.put(k, v, ttl, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Put the entry only if there is no entry with the key already present. If key already present then the existing
    * value will be returned to the handler, otherwise null.
    * @param k the key
    * @param v the value
    * @return the future
    */
  def putIfAbsentFuture(k: K, v: V): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V,V]((x => x))
    _asJava.putIfAbsent(k, v, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsent]] but specifying a time to live for the entry. Entry will expire and get evicted
    * after the ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the future
    */
  def putIfAbsentFuture(k: K, v: V, ttl: Long): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V,V]((x => x))
    _asJava.putIfAbsent(k, v, ttl, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeFuture(k: K): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V,V]((x => x))
    _asJava.remove(k, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeIfPresentFuture(k: K, v: V): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.removeIfPresent(k, v, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @return the result future will be passed the previous value
    */
  def replaceFuture(k: K, v: V): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V,V]((x => x))
    _asJava.replace(k, v, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Replace the entry only if it is currently mapped to a specific value
    * @param k the key
    * @param oldValue the existing value
    * @param newValue the new value
    * @return the result future
    */
  def replaceIfPresentFuture(k: K, oldValue: V, newValue: V): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean,Boolean]((x => x))
    _asJava.replaceIfPresent(k, oldValue, newValue, promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Clear all entries in the map
    * @return called on completion
    */
  def clearFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Void,Unit]((x => ()))
    _asJava.clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  /**
    * Provide the number of entries in the map
    * @return future which will receive the number of entries
    */
  def sizeFuture(): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer,Int]((x => x))
    _asJava.size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.AsyncMap[K, V]): AsyncMap[K, V] =
    new AsyncMap(_asJava)

}
