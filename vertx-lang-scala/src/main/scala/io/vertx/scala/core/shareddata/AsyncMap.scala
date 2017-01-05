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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K:TypeTag,V:TypeTag](private val _asJava: Object) {

  def asJava = _asJava

 /**
   * Get a value from the map, asynchronously.
   * @param k the key
   */
  def get(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].get(toJava[K](k),{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,V](x, a => toScala[V](a)))})
  }

 /**
   * Put a value in the map, asynchronously.
   * @param k the key
   * @param v the value
   */
  def put(k: K,v: V,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].put(toJava[K](k),toJava[V](v),{x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Like [[io.vertx.scala.core.shareddata.AsyncMap#putFuture]] but specifying a time to live for the entry. Entry will expire and get evicted after the
   * ttl.
   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   */
  def put(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].put(toJava[K](k),toJava[V](v),ttl.asInstanceOf[java.lang.Long],{x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Put the entry only if there is no entry with the key already present. If key already present then the existing
   * value will be returned to the handler, otherwise null.
   * @param k the key
   * @param v the value
   */
  def putIfAbsent(k: K,v: V,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].putIfAbsent(toJava[K](k),toJava[V](v),{x: AsyncResult[Object] => completionHandler.handle(AsyncResultWrapper[Object,V](x, a => toScala[V](a)))})
  }

 /**
   * Link [[io.vertx.scala.core.shareddata.AsyncMap#putIfAbsentFuture]] but specifying a time to live for the entry. Entry will expire and get evicted
   * after the ttl.
   * @param k the key
   * @param v the value
   * @param ttl The time to live (in ms) for the entry
   */
  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].putIfAbsent(toJava[K](k),toJava[V](v),ttl.asInstanceOf[java.lang.Long],{x: AsyncResult[Object] => completionHandler.handle(AsyncResultWrapper[Object,V](x, a => toScala[V](a)))})
  }

 /**
   * Remove a value from the map, asynchronously.
   * @param k the key
   */
  def remove(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].remove(toJava[K](k),{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,V](x, a => toScala[V](a)))})
  }

 /**
   * Remove a value from the map, only if entry already exists with same value.
   * @param k the key
   * @param v the value
   */
  def removeIfPresent(k: K,v: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].removeIfPresent(toJava[K](k),toJava[V](v),{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

 /**
   * Replace the entry only if it is currently mapped to some value
   * @param k the key
   * @param v the new value
   */
  def replace(k: K,v: V,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].replace(toJava[K](k),toJava[V](v),{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,V](x, a => toScala[V](a)))})
  }

 /**
   * Replace the entry only if it is currently mapped to a specific value
   * @param k the key
   * @param oldValue the existing value
   * @param newValue the new value
   */
  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].replaceIfPresent(toJava[K](k),toJava[V](oldValue),toJava[V](newValue),{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a.asInstanceOf[Boolean]))})
  }

 /**
   * Clear all entries in the map
   */
  def clear(resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].clear({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

 /**
   * Provide the number of entries in the map
   */
  def size(resultHandler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[Object,Object]].size({x: AsyncResult[java.lang.Integer] => resultHandler.handle(AsyncResultWrapper[java.lang.Integer,Int](x, a => a.asInstanceOf[Int]))})
  }

 /**
   * Get a value from the map, asynchronously.
   * @param k the key
   * @return - this will be called some time later with the async result.
   */
    def getFuture(k: K):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, V](x => if (x == null) null.asInstanceOf[V] else toScala[V](x))
    asJava.asInstanceOf[JAsyncMap[Object,Object]].get(toJava[K](k),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Put a value in the map, asynchronously.
   * @param k the key
   * @param v the value
   * @return - this will be called some time later to signify the value has been put
   */
    def putFuture(k: K,v: V):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncMap[Object,Object]].put(toJava[K](k),toJava[V](v),promiseAndHandler._1)
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
    def putFuture(k: K,v: V,ttl: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncMap[Object,Object]].put(toJava[K](k),toJava[V](v),ttl.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Put the entry only if there is no entry with the key already present. If key already present then the existing
   * value will be returned to the handler, otherwise null.
   * @param k the key
   * @param v the value
   * @return the future
   */
    def putIfAbsentFuture(k: K,v: V):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, V](x => if (x == null) null.asInstanceOf[V] else toScala[V](x))
    asJava.asInstanceOf[JAsyncMap[Object,Object]].putIfAbsent(toJava[K](k),toJava[V](v),promiseAndHandler._1)
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
    def putIfAbsentFuture(k: K,v: V,ttl: Long):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, V](x => if (x == null) null.asInstanceOf[V] else toScala[V](x))
    asJava.asInstanceOf[JAsyncMap[Object,Object]].putIfAbsent(toJava[K](k),toJava[V](v),ttl.asInstanceOf[java.lang.Long],promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a value from the map, asynchronously.
   * @param k the key
   * @return - this will be called some time later to signify the value has been removed
   */
    def removeFuture(k: K):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, V](x => if (x == null) null.asInstanceOf[V] else toScala[V](x))
    asJava.asInstanceOf[JAsyncMap[Object,Object]].remove(toJava[K](k),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Remove a value from the map, only if entry already exists with same value.
   * @param k the key
   * @param v the value
   * @return - this will be called some time later to signify the value has been removed
   */
    def removeIfPresentFuture(k: K,v: V):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JAsyncMap[Object,Object]].removeIfPresent(toJava[K](k),toJava[V](v),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace the entry only if it is currently mapped to some value
   * @param k the key
   * @param v the new value
   * @return the result future will be passed the previous value
   */
    def replaceFuture(k: K,v: V):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Object, V](x => if (x == null) null.asInstanceOf[V] else toScala[V](x))
    asJava.asInstanceOf[JAsyncMap[Object,Object]].replace(toJava[K](k),toJava[V](v),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Replace the entry only if it is currently mapped to a specific value
   * @param k the key
   * @param oldValue the existing value
   * @param newValue the new value
   * @return the result future
   */
    def replaceIfPresentFuture(k: K,oldValue: V,newValue: V):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => if (x == null) null.asInstanceOf[Boolean] else x.asInstanceOf[Boolean])
    asJava.asInstanceOf[JAsyncMap[Object,Object]].replaceIfPresent(toJava[K](k),toJava[V](oldValue),toJava[V](newValue),promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Clear all entries in the map
   * @return called on completion
   */
    def clearFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => if (x == null) null.asInstanceOf[Unit] else x)
    asJava.asInstanceOf[JAsyncMap[Object,Object]].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

 /**
   * Provide the number of entries in the map
   * @return future which will receive the number of entries
   */
    def sizeFuture():scala.concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => if (x == null) null.asInstanceOf[Int] else x.asInstanceOf[Int])
    asJava.asInstanceOf[JAsyncMap[Object,Object]].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

object AsyncMap{
  def apply[K:TypeTag,V:TypeTag](asJava: JAsyncMap[_,_]) = new AsyncMap[K,V](asJava)  
}
