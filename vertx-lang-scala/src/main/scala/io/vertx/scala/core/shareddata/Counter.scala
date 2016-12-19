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
import io.vertx.core.shareddata.{Counter => JCounter}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An asynchronous counter that can be used to across the cluster to maintain a consistent count.
  * 
  */
class Counter(private val _asJava: Object) {

  def asJava = _asJava

//cached methods
//fluent methods
//basic methods
  def get(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].get(x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def incrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].incrementAndGet(x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def getAndIncrement(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndIncrement(x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def decrementAndGet(resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].decrementAndGet(x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def addAndGet(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].addAndGet(value,x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def getAndAdd(value: Long,resultHandler: Handler[AsyncResult[Long]]):Unit = {
    asJava.asInstanceOf[JCounter].getAndAdd(value,x => resultHandler.handle(AsyncResultWrapper[Long,Long](x, a => a)))
  }

  def compareAndSet(expected: Long,value: Long,resultHandler: Handler[AsyncResult[Boolean]]):Unit = {
    asJava.asInstanceOf[JCounter].compareAndSet(expected,value,x => resultHandler.handle(AsyncResultWrapper[Boolean,Boolean](x, a => a)))
  }

}

object Counter{
  def apply(asJava: JCounter) = new Counter(asJava)
//static methods
}
