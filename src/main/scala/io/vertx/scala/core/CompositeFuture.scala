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

import io.vertx.lang.scala.HandlerOps._
import scala.compat.java8.FunctionConverters._
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future futures]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: io.vertx.core.CompositeFuture) {

  def asJava: io.vertx.core.CompositeFuture = _asJava

  def setHandler(handler: io.vertx.core.AsyncResult [io.vertx.scala.core.CompositeFuture] => Unit): io.vertx.scala.core.CompositeFuture = {
    _asJava.setHandler(funcToMappedHandler[io.vertx.core.AsyncResult[io.vertx.core.CompositeFuture], io.vertx.core.AsyncResult [io.vertx.scala.core.CompositeFuture]](x => io.vertx.lang.scala.AsyncResult[io.vertx.core.CompositeFuture, io.vertx.scala.core.CompositeFuture](x,(x => if (x == null) null else CompositeFuture.apply(x))))(handler))
    this
  }

  /**
    * Returns a cause of a wrapped future
    * @param index the wrapped future index
    */
  def cause(index: Int): Throwable = {
    _asJava.cause(index)
  }

  /**
    * Returns true if a wrapped future is succeeded
    * @param index the wrapped future index
    */
  def succeeded(index: Int): Boolean = {
    _asJava.succeeded(index)
  }

  /**
    * Returns true if a wrapped future is failed
    * @param index the wrapped future index
    */
  def failed(index: Int): Boolean = {
    _asJava.failed(index)
  }

  /**
    * Returns true if a wrapped future is completed
    * @param index the wrapped future index
    */
  def isComplete(index: Int): Boolean = {
    _asJava.isComplete(index)
  }

  /**
    * Returns the result of a wrapped future
    * @param index the wrapped future index
    */
  def result[T](index: Int): T = {
    _asJava.result(index)
  }

  /**
    * @return the number of wrapped future
    */
  def size(): Int = {
    _asJava.size()
  }

}

object CompositeFuture {

  def apply(_asJava: io.vertx.core.CompositeFuture): io.vertx.scala.core.CompositeFuture =
    new io.vertx.scala.core.CompositeFuture(_asJava)

  def all[T1, T2](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]]))
  }

  def all[T1, T2, T3](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]]))
  }

  def all[T1, T2, T3, T4](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]]))
  }

  def all[T1, T2, T3, T4, T5](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4], f5: io.vertx.scala.core.Future[T5]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]], f5.asJava.asInstanceOf[io.vertx.core.Future[T5]]))
  }

  def all[T1, T2, T3, T4, T5, T6](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4], f5: io.vertx.scala.core.Future[T5], f6: io.vertx.scala.core.Future[T6]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]], f5.asJava.asInstanceOf[io.vertx.core.Future[T5]], f6.asJava.asInstanceOf[io.vertx.core.Future[T6]]))
  }

  def all(futures: scala.collection.mutable.Buffer[io.vertx.scala.core.Future[_]]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.all(futures.map(x => if(x == null) null else x.asJava).asJava))
  }

  def any[T1, T2](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]]))
  }

  def any[T1, T2, T3](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]]))
  }

  def any[T1, T2, T3, T4](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]]))
  }

  def any[T1, T2, T3, T4, T5](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4], f5: io.vertx.scala.core.Future[T5]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]], f5.asJava.asInstanceOf[io.vertx.core.Future[T5]]))
  }

  def any[T1, T2, T3, T4, T5, T6](f1: io.vertx.scala.core.Future[T1], f2: io.vertx.scala.core.Future[T2], f3: io.vertx.scala.core.Future[T3], f4: io.vertx.scala.core.Future[T4], f5: io.vertx.scala.core.Future[T5], f6: io.vertx.scala.core.Future[T6]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(f1.asJava.asInstanceOf[io.vertx.core.Future[T1]], f2.asJava.asInstanceOf[io.vertx.core.Future[T2]], f3.asJava.asInstanceOf[io.vertx.core.Future[T3]], f4.asJava.asInstanceOf[io.vertx.core.Future[T4]], f5.asJava.asInstanceOf[io.vertx.core.Future[T5]], f6.asJava.asInstanceOf[io.vertx.core.Future[T6]]))
  }

  def any(futures: scala.collection.mutable.Buffer[io.vertx.scala.core.Future[_]]): io.vertx.scala.core.CompositeFuture = {
    CompositeFuture.apply(io.vertx.core.CompositeFuture.any(futures.map(x => if(x == null) null else x.asJava).asJava))
  }

}
