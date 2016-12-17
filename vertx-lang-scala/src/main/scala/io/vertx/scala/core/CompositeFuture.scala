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
import io.vertx.core.{CompositeFuture => JCompositeFuture}
import io.vertx.core.AsyncResult
import scala.collection.JavaConverters._
import io.vertx.core.Handler

/**
  * The composite future wraps a list of [[io.vertx.scala.core.Future]], it is useful when several futures
  * needs to be coordinated.
  */
class CompositeFuture(private val _asJava: Object) 
    extends Future[CompositeFuture](_asJava) {

  private var cached_0:Handler[AsyncResult[CompositeFuture]] = _
  
//methods returning a future
//cached methods
  override def completer():Handler[AsyncResult[CompositeFuture]] = {
    if(cached_0 == null)
      cached_0 = asJava.asInstanceOf[JCompositeFuture].completer()
    return cached_0
  }

//fluent methods
  override def setHandler(handler: Handler[AsyncResult[CompositeFuture]]):CompositeFuture = {
    CompositeFuture(asJava.asInstanceOf[JCompositeFuture].setHandler(handler))
    this
  }

//basic methods
  override def complete(result: CompositeFuture):Unit = {
    asJava.asInstanceOf[JCompositeFuture].complete(result.asJava.asInstanceOf[JCompositeFuture])
  }

  override def result():CompositeFuture = {
    CompositeFuture(asJava.asInstanceOf[JCompositeFuture].result())
  }

  def cause(index: Int):Throwable = {
    asJava.asInstanceOf[JCompositeFuture].cause(index)
  }

  def succeeded(index: Int):Boolean = {
    asJava.asInstanceOf[JCompositeFuture].succeeded(index)
  }

  def failed(index: Int):Boolean = {
    asJava.asInstanceOf[JCompositeFuture].failed(index)
  }

  def isComplete(index: Int):Boolean = {
    asJava.asInstanceOf[JCompositeFuture].isComplete(index)
  }

  def resultAt[T](index: Int):T = {
    asJava.asInstanceOf[JCompositeFuture].resultAt(index)
  }

  def size():Int = {
    asJava.asInstanceOf[JCompositeFuture].size()
  }

}

object CompositeFuture{
  def apply(asJava: JCompositeFuture) = new CompositeFuture(asJava)//static methods
  def all[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def all[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def all[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def all[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def all[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]],f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def all(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.all(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

  def any[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def any[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def any[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def any[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def any[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]],f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def any(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.any(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

  def join[T1,T2](f1: Future[T1],f2: Future[T2]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]]))
  }

  def join[T1,T2,T3](f1: Future[T1],f2: Future[T2],f3: Future[T3]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]]))
  }

  def join[T1,T2,T3,T4](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]]))
  }

  def join[T1,T2,T3,T4,T5](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]]))
  }

  def join[T1,T2,T3,T4,T5,T6](f1: Future[T1],f2: Future[T2],f3: Future[T3],f4: Future[T4],f5: Future[T5],f6: Future[T6]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(f1.asJava.asInstanceOf[JFuture[T1]],f2.asJava.asInstanceOf[JFuture[T2]],f3.asJava.asInstanceOf[JFuture[T3]],f4.asJava.asInstanceOf[JFuture[T4]],f5.asJava.asInstanceOf[JFuture[T5]],f6.asJava.asInstanceOf[JFuture[T6]]))
  }

  def join(futures: scala.collection.mutable.Buffer[Future[_]]):CompositeFuture = {
    CompositeFuture(JCompositeFuture.join(futures.map(x => x.asJava.asInstanceOf[JFuture[_]]).asJava))
  }

}
