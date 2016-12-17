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
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: Object) {

  def asJava = _asJava

//methods returning a future
  def get(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].get(resultHandler)
  }

  def incrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].incrementAndGet(resultHandler)
  }

  def getAndIncrement(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndIncrement(resultHandler)
  }

  def decrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].decrementAndGet(resultHandler)
  }

  def addAndGet(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].addAndGet(value,resultHandler)
  }

  def getAndAdd(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndAdd(value,resultHandler)
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JCounter].compareAndSet(expected,value,resultHandler)
  }

//cached methods
//fluent methods
//basic methods
  def get(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].get(resultHandler)
  }

  def incrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].incrementAndGet(resultHandler)
  }

  def getAndIncrement(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndIncrement(resultHandler)
  }

  def decrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].decrementAndGet(resultHandler)
  }

  def addAndGet(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].addAndGet(value,resultHandler)
  }

  def getAndAdd(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndAdd(value,resultHandler)
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JCounter].compareAndSet(expected,value,resultHandler)
  }

}

object Counter{
  def apply(asJava: JCounter) = new Counter(asJava)//static methods
}
