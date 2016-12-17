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

import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.scala.core.Future
import io.vertx.core.{Future => JFuture}

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: Object) 
    extends Future[CompositeFuture](_asJava) {

  override def asJava = _asJava.asInstanceOf[JCompositeFuture]
//methods returning a future
//cached methods
  override def completer():io.vertx.core.Handler[io.vertx.core.AsyncResult[CompositeFuture]] = {
    asJava.completer( )
  }

//fluent methods
  override def setHandler(handler: io.vertx.core.Handler[io.vertx.core.AsyncResult[CompositeFuture]]):CompositeFuture = {
    asJava.setHandler( )
    this
  }

//basic methods
  override def complete(result: CompositeFuture):Unit = {
    asJava.complete( )
  }

  override def result():CompositeFuture = {
    asJava.result( )
  }

  def cause(index: Int):Throwable = {
    asJava.cause( )
  }

  def succeeded(index: Int):Boolean = {
    asJava.succeeded( )
  }

  def failed(index: Int):Boolean = {
    asJava.failed( )
  }

  def isComplete(index: Int):Boolean = {
    asJava.isComplete( )
  }

  def resultAt(index: Int):T = {
    asJava.resultAt( )
  }

  def size():Int = {
    asJava.size( )
  }

}

object CompositeFuture{
//in object!
//static methods
  def all[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def all[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def all[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def all[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def all[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def all(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    JCompositeFuture.all( )
  }

  def any[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def any[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def any[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def any[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def any[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def any(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    JCompositeFuture.any( )
  }

  def join[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    JCompositeFuture.join( )
  }

  def join[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    JCompositeFuture.join( )
  }

  def join[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    JCompositeFuture.join( )
  }

  def join[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    JCompositeFuture.join( )
  }

  def join[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    JCompositeFuture.join( )
  }

  def join(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    JCompositeFuture.join( )
  }

}
