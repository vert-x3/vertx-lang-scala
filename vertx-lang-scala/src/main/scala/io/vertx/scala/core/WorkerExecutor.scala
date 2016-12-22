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
import io.vertx.lang.scala.AsyncResultWrapper
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.core.{Future => JFuture}
import io.vertx.core.{WorkerExecutor => JWorkerExecutor}
import io.vertx.scala.core.metrics.Measured
import io.vertx.core.AsyncResult
import io.vertx.core.Handler

/**
  * An executor for executing blocking code in Vert.x .
  *
  * It provides the same <code>executeBlocking</code> operation than [[io.vertx.scala.core.Context]] and
  * [[io.vertx.scala.core.Vertx]] but on a separate worker pool.
  */
class WorkerExecutor(private val _asJava: Object) 
    extends Measured {

  def asJava = _asJava

//cached methods
//fluent methods
//default methods
  override def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JWorkerExecutor].executeBlocking[T]({x: JFuture[T] => blockingCodeHandler.handle(Future[T](x))},{x: AsyncResult[T] => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a))})
  }

  override def close():Unit = {
    asJava.asInstanceOf[JWorkerExecutor].close()
  }

//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JWorkerExecutor].isMetricsEnabled()
  }

  def executeBlocking[T](blockingCodeHandler: Handler[Future[T]],ordered: Boolean,resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JWorkerExecutor].executeBlocking[T]({x: JFuture[T] => blockingCodeHandler.handle(Future[T](x))},ordered,{x: AsyncResult[T] => resultHandler.handle(AsyncResultWrapper[T,T](x, a => a))})
  }

}

  object WorkerExecutor{
    def apply(asJava: JWorkerExecutor) = new WorkerExecutor(asJava)  
  //static methods
  }
