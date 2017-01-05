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

import scala.compat.java8.FunctionConverters._
import io.vertx.lang.scala.HandlerOps._
import io.vertx.lang.scala.Converter._
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.{Future => JFuture}
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
class Future[T:TypeTag](private val _asJava: Object, objectToT: Option[Object => T] = None) {

  def asJava = _asJava
  private var cached_0:Handler[AsyncResult[T]] = _

//cached methods
  def completer():Handler[AsyncResult[T]] = {
    if(cached_0 == null) {
      var tmp = asJava.asInstanceOf[JFuture[Object]].completer()
      cached_0 = {x: AsyncResult[T] => tmp.handle(AsyncResultWrapper[T,Object](x, a => toJava[T](a)))}
    }
    cached_0
  }

//fluent methods
  def setHandler(handler: Handler[AsyncResult[T]]):Future[T] = {
    asJava.asInstanceOf[JFuture[Object]].setHandler({x: AsyncResult[Object] => handler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
    this
  }

//default methods
  //io.vertx.core.Future
  def compose[U:TypeTag](handler: Handler[T],next: Future[U]):Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => handler.handle(toScala[T](x))},next.asJava.asInstanceOf[JFuture[Object]]))
  }

  //io.vertx.core.Future
  def compose[U:TypeTag](mapper: T => Future[U]):Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].compose[Object]({x: Object => mapper(toScala[T](x)).asJava.asInstanceOf[JFuture[Object]]}))
  }

  //io.vertx.core.Future
  def map[U:TypeTag](mapper: T => U):Future[U] = {
    Future[U](asJava.asInstanceOf[JFuture[Object]].map[Object]({x: Object => toJava[U](mapper(toScala[T](x)))}))
  }

  //io.vertx.core.Future
  def map[V:TypeTag](value: V):Future[V] = {
    Future[V](asJava.asInstanceOf[JFuture[Object]].map[Object](toJava[V](value)))
  }

//basic methods
  def isComplete():Boolean = {
    asJava.asInstanceOf[JFuture[Object]].isComplete().asInstanceOf[Boolean]
  }

  def complete(result: T):Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete(toJava[T](result))
  }

  def complete():Unit = {
    asJava.asInstanceOf[JFuture[Object]].complete()
  }

  def fail(throwable: Throwable):Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(throwable)
  }

  def fail(failureMessage: String):Unit = {
    asJava.asInstanceOf[JFuture[Object]].fail(failureMessage.asInstanceOf[java.lang.String])
  }

  def result():T = {
    toScala[T](asJava.asInstanceOf[JFuture[Object]].result())
  }

  def cause():Throwable = {
    asJava.asInstanceOf[JFuture[Object]].cause()
  }

  def succeeded():Boolean = {
    asJava.asInstanceOf[JFuture[Object]].succeeded().asInstanceOf[Boolean]
  }

  def failed():Boolean = {
    asJava.asInstanceOf[JFuture[Object]].failed().asInstanceOf[Boolean]
  }

//future methods
}

  object Future{
    def apply[T:TypeTag](asJava: JFuture[_], objectToT: Option[Object => T] = None) = new Future[T](asJava, objectToT)  
  //static methods
    def future[T:TypeTag]():Future[T] = {
      Future[T](JFuture.future[Object]())
    }

    def succeededFuture[T:TypeTag]():Future[T] = {
      Future[T](JFuture.succeededFuture[Object]())
    }

    def succeededFuture[T:TypeTag](result: T):Future[T] = {
      Future[T](JFuture.succeededFuture[Object](toJava[T](result)))
    }

    def failedFuture[T:TypeTag](t: Throwable):Future[T] = {
      Future[T](JFuture.failedFuture[Object](t))
    }

    def failedFuture[T:TypeTag](failureMessage: String):Future[T] = {
      Future[T](JFuture.failedFuture[Object](failureMessage.asInstanceOf[java.lang.String]))
    }

  }
