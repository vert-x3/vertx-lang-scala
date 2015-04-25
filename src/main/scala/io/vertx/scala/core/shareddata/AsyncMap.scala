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

import scala.util.Try
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
    * @param resultHandler - this will be called some time later with the async result.
    */
  def get(k: K)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.get(k, funcToAsyncResultHandler(resultHandler))
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @param completionHandler - this will be called some time later to signify the value has been put
    */
  def put(k: K, v: V)(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.put(k, v, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.AsyncMap#put]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param timeout the timoeout, in ms
    * @param completionHandler the handler
    */
  def put(k: K, v: V, timeout: Long)(completionHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.put(k, v, timeout, funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(completionHandler))
  }

  /**
    * Put the entry only if there is no entry with the key already present. If key already present then the existing
    * value will be returned to the handler, otherwise null.
    * @param k the key
    * @param v the value
    * @param completionHandler the handler
    */
  def putIfAbsent(k: K, v: V)(completionHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.putIfAbsent(k, v, funcToAsyncResultHandler(completionHandler))
  }

  /**
    * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsent]] but specifying a timeout. If the value cannot be put within the timeout a
    * failure will be passed to the handler
    * @param k the key
    * @param v the value
    * @param timeout the timeout, in ms
    * @param completionHandler the handler
    */
  def putIfAbsent(k: K, v: V, timeout: Long)(completionHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.putIfAbsent(k, v, timeout, funcToAsyncResultHandler(completionHandler))
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @param resultHandler - this will be called some time later to signify the value has been removed
    */
  def remove(k: K)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.remove(k, funcToAsyncResultHandler(resultHandler))
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @param resultHandler - this will be called some time later to signify the value has been removed
    */
  def removeIfPresent(k: K, v: V)(resultHandler: Try[Boolean] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.removeIfPresent(k, v, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(resultHandler))
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @param resultHandler the result handler will be passed the previous value
    */
  def replace(k: K, v: V)(resultHandler: Try[V] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.replace(k, v, funcToAsyncResultHandler(resultHandler))
  }

  /**
    * Replace the entry only if it is currently mapped to a specific value
    * @param k the key
    * @param oldValue the existing value
    * @param newValue the new value
    * @param resultHandler the result handler
    */
  def replaceIfPresent(k: K, oldValue: V, newValue: V)(resultHandler: Try[Boolean] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.replaceIfPresent(k, oldValue, newValue, funcToMappedAsyncResultHandler[java.lang.Boolean, Boolean](x => x)(resultHandler))
  }

  /**
    * Clear all entries in the map
    * @param resultHandler called on completion
    */
  def clear(resultHandler: Try[Unit] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.clear(funcToMappedAsyncResultHandler[java.lang.Void, Unit](x => x.asInstanceOf[Unit])(resultHandler))
  }

  /**
    * Provide the number of entries in the map
    * @param resultHandler handler which will receive the number of entries
    */
  def size(resultHandler: Try[Int] => Unit): Unit = {
    import io.vertx.lang.scala.HandlerOps._
    import scala.collection.JavaConverters._
    _asJava.size(funcToMappedAsyncResultHandler[java.lang.Integer, Int](x => x)(resultHandler))
  }

}

object AsyncMap {

  def apply[K, V](_asJava: io.vertx.core.shareddata.AsyncMap[K,V]): io.vertx.scala.core.shareddata.AsyncMap[K, V] =
    new io.vertx.scala.core.shareddata.AsyncMap[K, V](_asJava)
}
