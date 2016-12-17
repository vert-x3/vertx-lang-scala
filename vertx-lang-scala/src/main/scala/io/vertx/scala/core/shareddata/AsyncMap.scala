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

import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  *
  * An asynchronous map.
  */
class AsyncMap[K,V](private val _asJava: Object) {

  def asJava = _asJava

//methods returning a future
  def get(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].get(k,resultHandler)
  }

  def put(k: K,v: V,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].put(k,v,completionHandler)
  }

  def put(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].put(k,v,ttl,completionHandler)
  }

  def putIfAbsent(k: K,v: V,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].putIfAbsent(k,v,completionHandler)
  }

  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].putIfAbsent(k,v,ttl,completionHandler)
  }

  def remove(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].remove(k,resultHandler)
  }

  def removeIfPresent(k: K,v: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].removeIfPresent(k,v,resultHandler)
  }

  def replace(k: K,v: V,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].replace(k,v,resultHandler)
  }

  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].replaceIfPresent(k,oldValue,newValue,resultHandler)
  }

  def clear(resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].clear(resultHandler)
  }

  def size(resultHandler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].size(resultHandler)
  }

//cached methods
//fluent methods
//basic methods
  def get(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].get(k,resultHandler)
  }

  def put(k: K,v: V,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].put(k,v,completionHandler)
  }

  def put(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].put(k,v,ttl,completionHandler)
  }

  def putIfAbsent(k: K,v: V,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].putIfAbsent(k,v,completionHandler)
  }

  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].putIfAbsent(k,v,ttl,completionHandler)
  }

  def remove(k: K,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].remove(k,resultHandler)
  }

  def removeIfPresent(k: K,v: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].removeIfPresent(k,v,resultHandler)
  }

  def replace(k: K,v: V,resultHandler: Handler[AsyncResult[V]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].replace(k,v,resultHandler)
  }

  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].replaceIfPresent(k,oldValue,newValue,resultHandler)
  }

  def clear(resultHandler: Handler[AsyncResult[Unit]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].clear(resultHandler)
  }

  def size(resultHandler: Handler[AsyncResult[Int]]):Unit = {
    asJava.asInstanceOf[JAsyncMap].size(resultHandler)
  }

}

object AsyncMap{
  def apply(asJava: JAsyncMap) = new AsyncMap(asJava)//static methods
}
