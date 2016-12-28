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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.shareddata.{AsyncMap => JAsyncMap}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K,V](private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
//basic methods
  def get(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].get(k,{x: AsyncResult[V] => resultHandler.handle(AsyncResultWrapper[V,V](x, a => a))})
  }

  def put(k: K,v: V,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].put(k,v,{x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def put(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].put(k,v,ttl,{x: AsyncResult[Void] => completionHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def putIfAbsent(k: K,v: V,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].putIfAbsent(k,v,{x: AsyncResult[V] => completionHandler.handle(AsyncResultWrapper[V,V](x, a => a))})
  }

  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].putIfAbsent(k,v,ttl,{x: AsyncResult[V] => completionHandler.handle(AsyncResultWrapper[V,V](x, a => a))})
  }

  def remove(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].remove(k,{x: AsyncResult[V] => resultHandler.handle(AsyncResultWrapper[V,V](x, a => a))})
  }

  def removeIfPresent(k: K,v: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].removeIfPresent(k,v,{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a))})
  }

  def replace(k: K,v: V,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].replace(k,v,{x: AsyncResult[V] => resultHandler.handle(AsyncResultWrapper[V,V](x, a => a))})
  }

  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].replaceIfPresent(k,oldValue,newValue,{x: AsyncResult[java.lang.Boolean] => resultHandler.handle(AsyncResultWrapper[java.lang.Boolean,Boolean](x, a => a))})
  }

  def clear(resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].clear({x: AsyncResult[Void] => resultHandler.handle(AsyncResultWrapper[Void,Unit](x, a => a))})
  }

  def size(resultHandler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JAsyncMap[K,V]].size({x: AsyncResult[java.lang.Integer] => resultHandler.handle(AsyncResultWrapper[java.lang.Integer,Int](x, a => a))})
  }

//future methods
  def getFuture(k: K):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V, V](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].get(k,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def putFuture(k: K,v: V):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].put(k,v,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def putFuture(k: K,v: V,ttl: Long):scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].put(k,v,ttl,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def putIfAbsentFuture(k: K,v: V):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V, V](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].putIfAbsent(k,v,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def putIfAbsentFuture(k: K,v: V,ttl: Long):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V, V](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].putIfAbsent(k,v,ttl,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeFuture(k: K):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V, V](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].remove(k,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def removeIfPresentFuture(k: K,v: V):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].removeIfPresent(k,v,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceFuture(k: K,v: V):scala.concurrent.Future[V] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[V, V](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].replace(k,v,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def replaceIfPresentFuture(k: K,oldValue: V,newValue: V):scala.concurrent.Future[Boolean] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Boolean, Boolean](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].replaceIfPresent(k,oldValue,newValue,promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def clearFuture():scala.concurrent.Future[Unit] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[Void, Unit](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].clear(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

  def sizeFuture():scala.concurrent.Future[Int] = {
    val promiseAndHandler = handlerForAsyncResultWithConversion[java.lang.Integer, Int](x => x)
    asJava.asInstanceOf[JAsyncMap[K,V]].size(promiseAndHandler._1)
    promiseAndHandler._2.future
  }

}

  object AsyncMap{
    def apply[K,V](asJava: JAsyncMap[K,V]) = new AsyncMap[K,V](asJava)  
  //static methods
  }
