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

import io.vertx.lang.scala.AsyncResultWrapper
import scala.reflect.runtime.universe._
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._

/**
  * An asynchronous map.
  * 
  * [[io.vertx.scala.core.shareddata.AsyncMap]] does <em>not</em> allow `null` to be used as a key or value.
  */

class AsyncMap[K: TypeTag, V: TypeTag](private val _asJava: Object) {
  def asJava = _asJava





  /**
   * Get a value from the map, asynchronously.   * @param k the key
   * @param resultHandler - this will be called some time later with the async result.
   */
  def get (k: K, resultHandler: Handler[AsyncResult[scala.Option[V]]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].get(toJava[K](k), {x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object, scala.Option[V]](x, a => scala.Option(toScala[V](a))))})
  }

  /**
   * Put a value in the map, asynchronously.   * @param k the key
   * @param v the value
   * @param completionHandler - this will be called some time later to signify the value has been put
   */
  def put (k: K, v: V, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].put(toJava[K](k), toJava[V](v), {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Like [[io.vertx.scala.core.shareddata.AsyncMap#put]] but specifying a time to live for the entry. Entry will expire and get evicted after the
   * ttl.   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   * @param completionHandler the handler
   */
  def put (k: K, v: V, ttl: Long, completionHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].put(toJava[K](k), toJava[V](v), ttl.asInstanceOf[java.lang.Long], {x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Put the entry only if there is no entry with the key already present. If key already present then the existing
   * value will be returned to the handler, otherwise null.   * @param k the key
   * @param v the value
   * @param completionHandler the handler
   */
  def putIfAbsent (k: K, v: V, completionHandler: Handler[AsyncResult[scala.Option[V]]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].putIfAbsent(toJava[K](k), toJava[V](v), {x: AsyncResult[Object] => completionHandler.handle(AsyncResultWrapper[Object, scala.Option[V]](x, a => scala.Option(toScala[V](a))))})
  }

  /**
   * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsent]] but specifying a time to live for the entry. Entry will expire and get evicted
   * after the ttl.   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   * @param completionHandler the handler
   */
  def putIfAbsent (k: K, v: V, ttl: Long, completionHandler: Handler[AsyncResult[scala.Option[V]]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].putIfAbsent(toJava[K](k), toJava[V](v), ttl.asInstanceOf[java.lang.Long], {x: AsyncResult[Object] => completionHandler.handle(AsyncResultWrapper[Object, scala.Option[V]](x, a => scala.Option(toScala[V](a))))})
  }

  /**
   * Remove a value from the map, asynchronously.   * @param k the key
   * @param resultHandler - this will be called some time later to signify the value has been removed
   */
  def remove (k: K, resultHandler: Handler[AsyncResult[scala.Option[V]]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].remove(toJava[K](k), {x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object, scala.Option[V]](x, a => scala.Option(toScala[V](a))))})
  }

  /**
   * Remove a value from the map, only if entry already exists with same value.   * @param k the key
   * @param v the value
   * @param resultHandler - this will be called some time later to signify the value has been removed
   */
  def removeIfPresent (k: K, v: V, resultHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].removeIfPresent(toJava[K](k), toJava[V](v), {x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
   * Replace the entry only if it is currently mapped to some value   * @param k the key
   * @param v the new value
   * @param resultHandler the result handler will be passed the previous value
   */
  def replace (k: K, v: V, resultHandler: Handler[AsyncResult[scala.Option[V]]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].replace(toJava[K](k), toJava[V](v), {x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object, scala.Option[V]](x, a => scala.Option(toScala[V](a))))})
  }

  /**
   * Replace the entry only if it is currently mapped to a specific value   * @param k the key
   * @param oldValue the existing value
   * @param newValue the new value
   * @param resultHandler the result handler
   */
  def replaceIfPresent (k: K, oldValue: V, newValue: V, resultHandler: Handler[AsyncResult[Boolean]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].replaceIfPresent(toJava[K](k), toJava[V](oldValue), toJava[V](newValue), {x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean, Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

  /**
   * Clear all entries in the map   * @param resultHandler called on completion
   */
  def clear (resultHandler: Handler[AsyncResult[Unit]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].clear({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void, Unit](x, a => a))})
  }

  /**
   * Provide the number of entries in the map   * @param resultHandler handler which will receive the number of entries
   */
  def size (resultHandler: Handler[AsyncResult[Int]]): Unit = {
    asJava.asInstanceOf[JAsyncMap[Object, Object]].size({x: AsyncResult[java.lang.Integer] => resultHandler.handle(AsyncResultWrapper[java.lang.Integer, Int](x, a => a.asInstanceOf[Int]))})
  }


 /**
  * Like [[get]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def getFuture (k: K): scala.concurrent.Future[scala.Option[V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, scala.Option[V]](x => scala.Option(toScala[V](x)))
    asJava.asInstanceOf[JAsyncMap[Object, Object]].get(toJava[K](k), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (k: K, v: V): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[Object, Object]].put(toJava[K](k), toJava[V](v), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[put]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putFuture (k: K, v: V, ttl: Long): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[Object, Object]].put(toJava[K](k), toJava[V](v), ttl.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putIfAbsentFuture (k: K, v: V): scala.concurrent.Future[scala.Option[V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, scala.Option[V]](x => scala.Option(toScala[V](x)))
    asJava.asInstanceOf[JAsyncMap[Object, Object]].putIfAbsent(toJava[K](k), toJava[V](v), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[putIfAbsent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def putIfAbsentFuture (k: K, v: V, ttl: Long): scala.concurrent.Future[scala.Option[V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, scala.Option[V]](x => scala.Option(toScala[V](x)))
    asJava.asInstanceOf[JAsyncMap[Object, Object]].putIfAbsent(toJava[K](k), toJava[V](v), ttl.asInstanceOf[java.lang.Long], promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[remove]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def removeFuture (k: K): scala.concurrent.Future[scala.Option[V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, scala.Option[V]](x => scala.Option(toScala[V](x)))
    asJava.asInstanceOf[JAsyncMap[Object, Object]].remove(toJava[K](k), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[removeIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def removeIfPresentFuture (k: K, v: V): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JAsyncMap[Object, Object]].removeIfPresent(toJava[K](k), toJava[V](v), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[replace]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def replaceFuture (k: K, v: V): scala.concurrent.Future[scala.Option[V]] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, scala.Option[V]](x => scala.Option(toScala[V](x)))
    asJava.asInstanceOf[JAsyncMap[Object, Object]].replace(toJava[K](k), toJava[V](v), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[replaceIfPresent]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def replaceIfPresentFuture (k: K, oldValue: V, newValue: V): scala.concurrent.Future[Boolean] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JAsyncMap[Object, Object]].replaceIfPresent(toJava[K](k), toJava[V](oldValue), toJava[V](newValue), promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[clear]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def clearFuture (): scala.concurrent.Future[Unit] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[Object, Object]].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
  * Like [[size]] but returns a [[scala.concurrent.Future]] instead of taking an AsyncResultHandler.
  */
  def sizeFuture (): scala.concurrent.Future[Int] = {
    //TODO: https://github.com/vert-x3/vertx-codegen/issues/111
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x.asInstanceOf[Int])
    asJava.asInstanceOf[JAsyncMap[Object, Object]].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncMap {
  def apply[K: TypeTag, V: TypeTag](asJava: JAsyncMap[_, _]) = new AsyncMap[K, V](asJava)
  
}
