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

package io.vertx.scala.core

import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
class Future[T](private val _asJava: Object) {

  def asJava = _asJava
  private var cached_0:Handler[AsyncResult[T]] = _

//cached methods
  def completer():Handler[AsyncResult[T]] = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JFuture[T]].completer()
      cached_0 = {x: AsyncResult[T] => tmp.handle(AsyncResultWrapper[T,T](x, a => a))}
    }
    cached_0
  }

//fluent methods
  def setHandler(handler: Handler[AsyncResult[T]]):Future[T] = {
    asJava.asInstanceOf[JFuture[T]].setHandler({x: AsyncResult[T] => handler.handle(AsyncResultWrapper[T,T](x, a => a))})
    this
  }

//basic methods
  def isComplete():Boolean = {
    asJava.asInstanceOf[JFuture[T]].isComplete()
  }

  def complete(result: T):Unit = {
    asJava.asInstanceOf[JFuture[T]].complete(result)
  }

  def complete():Unit = {
    asJava.asInstanceOf[JFuture[T]].complete()
  }

  def fail(throwable: Throwable):Unit = {
    asJava.asInstanceOf[JFuture[T]].fail(throwable)
  }

  def fail(failureMessage: String):Unit = {
    asJava.asInstanceOf[JFuture[T]].fail(failureMessage)
  }

  def result():T = {
    asJava.asInstanceOf[JFuture[T]].result()
  }

  def cause():Throwable = {
    asJava.asInstanceOf[JFuture[T]].cause()
  }

  def succeeded():Boolean = {
    asJava.asInstanceOf[JFuture[T]].succeeded()
  }

  def failed():Boolean = {
    asJava.asInstanceOf[JFuture[T]].failed()
  }

}

object Future{
  def apply[T](asJava: JFuture[T]) = new Future[T](asJava)
//static methods
  def future[T]():Future[T] = {
    Future[T](JFuture.future[T]())
  }

  def succeededFuture[T]():Future[T] = {
    Future[T](JFuture.succeededFuture[T]())
  }

  def succeededFuture[T](result: T):Future[T] = {
    Future[T](JFuture.succeededFuture[T](result))
  }

  def failedFuture[T](t: Throwable):Future[T] = {
    Future[T](JFuture.failedFuture[T](t))
  }

  def failedFuture[T](failureMessage: String):Future[T] = {
    Future[T](JFuture.failedFuture[T](failureMessage))
  }

}
