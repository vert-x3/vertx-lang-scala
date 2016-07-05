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

import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K, V](private val _asJava: io.vertx.core.shareddata.AsyncMap[K, V]) {

  def asJava: java.lang.Object = _asJava

  /**
    * Get a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later with the async result.
    */
  def get(k: K): scala.concurrent.Future[V] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[V]()
    _asJava.get(k, promiseToAsyncResultHandler(promise))
    promise.future
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been put
    */
  def put(k: K, v: V): scala.concurrent.Future[Unit] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Unit]()
    _asJava.put(k, v, promiseToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(promise))
    promise.future
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.AsyncMap#put]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the handler
    */
  def put(k: K, v: V, ttl: Long): scala.concurrent.Future[Unit] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Unit]()
    _asJava.put(k, v, ttl, promiseToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(promise))
    promise.future
  }

  /**
    * Put the entry only if there is no entry with the key already present. If key already present then the existing
    * value will be returned to the handler, otherwise null.
    * @param k the key
    * @param v the value
    * @return the handler
    */
  def putIfAbsent(k: K, v: V): scala.concurrent.Future[V] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[V]()
    _asJava.putIfAbsent(k, v, promiseToAsyncResultHandler(promise))
    promise.future
  }

  /**
    * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsent]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the handler
    */
  def putIfAbsent(k: K, v: V, ttl: Long): scala.concurrent.Future[V] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[V]()
    _asJava.putIfAbsent(k, v, ttl, promiseToAsyncResultHandler(promise))
    promise.future
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later to signify the value has been removed
    */
  def remove(k: K): scala.concurrent.Future[V] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[V]()
    _asJava.remove(k, promiseToAsyncResultHandler(promise))
    promise.future
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeIfPresent(k: K, v: V): scala.concurrent.Future[Boolean] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Boolean]()
    _asJava.removeIfPresent(k, v, promiseToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(promise))
    promise.future
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @return the result handler will be passed the previous value
    */
  def replace(k: K, v: V): scala.concurrent.Future[V] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[V]()
    _asJava.replace(k, v, promiseToAsyncResultHandler(promise))
    promise.future
  }

  /**
    * Replace the entry only if it is currently mapped to a specific value
    * @param k the key
    * @param oldValue the existing value
    * @param newValue the new value
    * @return the result handler
    */
  def replaceIfPresent(k: K, oldValue: V, newValue: V): scala.concurrent.Future[Boolean] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Boolean]()
    _asJava.replaceIfPresent(k, oldValue, newValue, promiseToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(promise))
    promise.future
  }

  /**
    * Clear all entries in the map
    * @return called on completion
    */
  def clear(): scala.concurrent.Future[Unit] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Unit]()
    _asJava.clear(promiseToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(promise))
    promise.future
  }

  /**
    * Provide the number of entries in the map
    * @return handler which will receive the number of entries
    */
  def size(): scala.concurrent.Future[Int] = {
    import io.vertx.lang.scala.HandlerOps._
    val promise = scala.concurrent.Promise[Int]()
    _asJava.size(promiseToMappedAsyncResultHandler[java.lang.Integer, Int](x => x)(promise))
    promise.future
  }

}

object AsyncMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.AsyncMap[K, V]): io.vertx.scala.core.shareddata.AsyncMap[K, V] =
    new io.vertx.scala.core.shareddata.AsyncMap(_asJava)
}
