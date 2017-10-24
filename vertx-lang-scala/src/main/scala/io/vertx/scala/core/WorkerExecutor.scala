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
    extends  Measured  {

  def asJava = _asJava


   /**
    * Safely execute some blocking code.
    *
    * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
    *
    * When the code is complete the returned Future will be completed with the result.
    *
    * @param blockingFunction function containing blocking code
    * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
    * @return a Future representing the result of the blocking operation
    */
  def executeBlocking[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
    val promise = concurrent.Promise[T]
    val h: Handler[io.vertx.core.Future[T]] = {f => util.Try(blockingFunction()) match {
      case util.Success(s) => f.complete(s)
      case util.Failure(t) => f.fail(t)
    }}
    asJava.asInstanceOf[JWorkerExecutor].executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
    promise.future
  }

   /**
    * Close the executor.
    */
  def close(): Unit = {
    asJava.asInstanceOf[JWorkerExecutor].close()
  }

  /**
    * Whether the metrics are enabled for this measured object
    * @return true if the metrics are enabled
    */
  override def isMetricsEnabled(): Boolean = {
    asJava.asInstanceOf[JWorkerExecutor].isMetricsEnabled().asInstanceOf[Boolean]
  }

}

object WorkerExecutor {
  def apply(asJava: JWorkerExecutor) = new WorkerExecutor(asJava)  
}
