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

import io.vertx.scala.core.metrics.Measured
import io.vertx.core.metrics.{Measured => JMeasured}
import io.vertx.scala.core.Future
import io.vertx.core.{Future => JFuture}

/**
  * An executor for executing blocking code in Vert.x .
  *
  * It provides the same <code>executeBlocking</code> operation than [[io.vertx.scala.core.Context]] and
  * [[io.vertx.scala.core.Vertx]] but on a separate worker pool.
  */
class WorkerExecutor(private val _asJava: Object) 
    extends Measured(_asJava) {

  override def asJava = _asJava.asInstanceOf[JWorkerExecutor]
//methods returning a future
  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],ordered: Boolean,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

//cached methods
//fluent methods
//basic methods
  override def isMetricsEnabled():Boolean = {
    asJava.isMetricsEnabled( )
  }

  def executeBlocking(blockingCodeHandler: io.vertx.core.Handler[Future[T]],ordered: Boolean,resultHandler: io.vertx.core.Handler[io.vertx.core.AsyncResult[T]]):Unit = {
    asJava.executeBlocking( )
  }

}

object WorkerExecutor{
//in object!
//static methods
}
