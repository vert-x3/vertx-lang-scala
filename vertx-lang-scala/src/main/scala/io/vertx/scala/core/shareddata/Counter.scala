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
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JCounter]
//methods returning a future
  def get(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.get( )
  }

  def incrementAndGet(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.incrementAndGet( )
  }

  def getAndIncrement(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.getAndIncrement( )
  }

  def decrementAndGet(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.decrementAndGet( )
  }

  def addAndGet(value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.addAndGet( )
  }

  def getAndAdd(value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.getAndAdd( )
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.compareAndSet( )
  }

//cached methods
//fluent methods
//basic methods
  def get(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.get( )
  }

  def incrementAndGet(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.incrementAndGet( )
  }

  def getAndIncrement(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.getAndIncrement( )
  }

  def decrementAndGet(resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.decrementAndGet( )
  }

  def addAndGet(value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.addAndGet( )
  }

  def getAndAdd(value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Long]]):Unit = {
    asJava.getAndAdd( )
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[Boolean]]):Unit = {
    asJava.compareAndSet( )
  }

}

object Counter{
//in object!
//static methods
}
