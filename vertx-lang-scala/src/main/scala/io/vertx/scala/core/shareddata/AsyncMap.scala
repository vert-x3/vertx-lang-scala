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


/**
  *
  * An asynchronous map.
  */
class AsyncMap[K,V](private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JAsyncMap]
//methods returning a future
  def get(k: K,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.get( )
  }

  def put(k: K,v: V,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.put( )
  }

  def put(k: K,v: V,ttl: Long,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.put( )
  }

  def putIfAbsent(k: K,v: V,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.putIfAbsent( )
  }

  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.putIfAbsent( )
  }

  def remove(k: K,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.remove( )
  }

  def removeIfPresent(k: K,v: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.removeIfPresent( )
  }

  def replace(k: K,v: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.replace( )
  }

  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.replaceIfPresent( )
  }

  def clear(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.clear( )
  }

  def size(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Int]]):Unit = {
    asJava.size( )
  }

//cached methods
//fluent methods
//basic methods
  def get(k: K,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.get( )
  }

  def put(k: K,v: V,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.put( )
  }

  def put(k: K,v: V,ttl: Long,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.put( )
  }

  def putIfAbsent(k: K,v: V,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.putIfAbsent( )
  }

  def putIfAbsent(k: K,v: V,ttl: Long,completionHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.putIfAbsent( )
  }

  def remove(k: K,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.remove( )
  }

  def removeIfPresent(k: K,v: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.removeIfPresent( )
  }

  def replace(k: K,v: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[V]]):Unit = {
    asJava.replace( )
  }

  def replaceIfPresent(k: K,oldValue: V,newValue: V,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.replaceIfPresent( )
  }

  def clear(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Unit]]):Unit = {
    asJava.clear( )
  }

  def size(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Int]]):Unit = {
    asJava.size( )
  }

}

object AsyncMap{
//in object!
//static methods
}
