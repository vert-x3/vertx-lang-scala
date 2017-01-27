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
import scala.reflect.runtime.universe._
import io.vertx.lang.scala.Converter._
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
    extends  Measured {

  def asJava = _asJava

  /**
    * Like [[io.vertx.scala.core.WorkerExecutor#executeBlockingFuture]] called with ordered = true.
    */
  def executeBlocking[T:TypeTag](blockingCodeHandler: Handler[Future[T]],resultHandler: Handler[AsyncResult[T]]):Unit = {
    asJava.asInstanceOf[JWorkerExecutor].executeBlocking[Object]({x: JFuture[Object] => blockingCodeHandler.handle(Future[T](x))},{x: AsyncResult[Object] => resultHandler.handle(AsyncResultWrapper[Object,T](x, a => toScala[T](a)))})
  }

  /**
    * Close the executor.
    */
  def close():Unit = {
    asJava.asInstanceOf[JWorkerExecutor].close()
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  override def isMetricsEnabled():Boolean = {
    asJava.asInstanceOf[JWorkerExecutor].isMetricsEnabled().asInstanceOf[Boolean]
  }

}

object WorkerExecutor{
  def apply(asJava: JWorkerExecutor) = new WorkerExecutor(asJava)  
}
