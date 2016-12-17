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

import io.vertx.core.{Future => JFuture}

/**
  * Represents the result of an action that may, or may not, have occurred yet.
  * 
  */
class Future[T](private val _asJava: Object) {

def asJava = _asJava.asInstanceOf[JFuture]
//methods returning a future
//cached methods
  def completer():io.vertx.core.Handler[io.vertx.core.AsyncResult[T]] = {
    asJava.completer( )
  }

//fluent methods
  def setHandler(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Future[T] = {
    asJava.setHandler( )
    this
  }

//basic methods
  def isComplete():Boolean = {
    asJava.isComplete( )
  }

  def complete(result: T):Unit = {
    asJava.complete( )
  }

  def complete():Unit = {
    asJava.complete( )
  }

  def fail(throwable: Throwable):Unit = {
    asJava.fail( )
  }

  def fail(failureMessage: String):Unit = {
    asJava.fail( )
  }

  def result():T = {
    asJava.result( )
  }

  def cause():Throwable = {
    asJava.cause( )
  }

  def succeeded():Boolean = {
    asJava.succeeded( )
  }

  def failed():Boolean = {
    asJava.failed( )
  }

}

object Future{
//in object!
//static methods
  def future[T]():Future[T] = {
    JFuture.future( )
  }

  def succeededFuture[T]():Future[T] = {
    JFuture.succeededFuture( )
  }

  def succeededFuture[T](result: T):Future[T] = {
    JFuture.succeededFuture( )
  }

  def failedFuture[T](t: Throwable):Future[T] = {
    JFuture.failedFuture( )
  }

  def failedFuture[T](failureMessage: String):Future[T] = {
    JFuture.failedFuture( )
  }

}
