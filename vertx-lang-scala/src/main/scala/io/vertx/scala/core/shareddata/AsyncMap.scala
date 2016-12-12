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
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K: TypeTag, V: TypeTag](private val _asJava: JAsyncMap[Object, Object]) {

  def asJava: JAsyncMap[Object, Object] = _asJava

  /**
    * Get a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later with the async result.
    */
  def getFuture(k: K): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V]((x => x.asInstanceOf))
    asJava.get(toJava[K](k).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  /**
    * Put a value in the map, asynchronously.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been put
    */
  def putFuture(k: K, v: V): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.put(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  /**
    * Like [[io.vertx.scala.core.shareddata.AsyncMap#putFuture]] but specifying a time to live for the entry. Entry will expire and get evicted after the
    * ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the future
    */
  def putFuture(k: K, v: V, ttl: Long): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.put(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], ttl, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
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
    val promiseAndHandler = handlerForAsyncResultWithConversion[V]((x => x.asInstanceOf))
    asJava.putIfAbsent(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  /**
    * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsentFuture]] but specifying a time to live for the entry. Entry will expire and get evicted
    * after the ttl.
    * @param k the key
    * @param v the value
    * @param ttl The time to live (in ms) for the entry
    * @return the future
    */
  def putIfAbsentFuture(k: K, v: V, ttl: Long): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V]((x => x.asInstanceOf))
    asJava.putIfAbsent(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], ttl, promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  /**
    * Remove a value from the map, asynchronously.
    * @param k the key
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeFuture(k: K): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V]((x => x.asInstanceOf))
    asJava.remove(toJava[K](k).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
    promiseAndHandler._2.future
  }

  /**
    * Remove a value from the map, only if entry already exists with same value.
    * @param k the key
    * @param v the value
    * @return - this will be called some time later to signify the value has been removed
    */
  def removeIfPresentFuture(k: K, v: V): concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.removeIfPresent(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  /**
    * Replace the entry only if it is currently mapped to some value
    * @param k the key
    * @param v the new value
    * @return the result future will be passed the previous value
    */
  def replaceFuture(k: K, v: V): concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V]((x => x.asInstanceOf))
    asJava.replace(toJava[K](k).asInstanceOf[Object], toJava[V](v).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[Object]]])
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
    val promiseAndHandler = handlerForAsyncResultWithConversion[Boolean]((x => x.asInstanceOf))
    asJava.replaceIfPresent(toJava[K](k).asInstanceOf[Object], toJava[V](oldValue).asInstanceOf[Object], toJava[V](newValue).asInstanceOf[Object], promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Boolean]]])
    promiseAndHandler._2.future
  }

  /**
    * Clear all entries in the map
    * @return called on completion
    */
  def clearFuture(): concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Unit]((_ => ()))
    asJava.clear(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Void]]])
    promiseAndHandler._2.future
  }

  /**
    * Provide the number of entries in the map
    * @return future which will receive the number of entries
    */
  def sizeFuture(): concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Int]((x => x.asInstanceOf))
    asJava.size(promiseAndHandler._1.asInstanceOf[io.vertx.core.Handler[io.vertx.core.AsyncResult[java.lang.Integer]]])
    promiseAndHandler._2.future
  }

}

object AsyncMap {

  def apply[K: TypeTag, V: TypeTag](_asJava: JAsyncMap[Object, Object]): AsyncMap[K, V] =
    new AsyncMap(_asJava)

}
