/*
 * Copyright (c) 2011-2016 The original author or authors
 * ------------------------------------------------------
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Apache License v2.0 which accompanies this distribution.
 *
 *     The Eclipse Public License is available at
 *     http://www.eclipse.org/legal/epl-v10.html
 *
 *     The Apache License v2.0 is available at
 *     http://www.opensource.org/licenses/apache2.0.php
 *
 * You may elect to redistribute this code under either of these licenses.
 */

package io.vertx.lang.scala

import io.vertx.core.{Context, Vertx}

import scala.concurrent.ExecutionContext

/**
  * A scala [[scala.concurrent.ExecutionContext]] binds [[scala.concurrent.Promise]]/[[scala.concurrent.Future]] to a thread.
  * In the case of Vert.x we have to make sure that they execute on the right context. A context could be that
  * of a worker or a standard verticle. This execution context implementation runs all Runnables on the associated
  * [[io.vertx.core.Context]].
  *
  * Taken from the original Vert.x-impl
  * https://github.com/vert-x/mod-lang-scala/blob/master/src/main/scala/org/vertx/scala/core/VertxExecutionContext.scala
  *
  */
class VertxExecutionContext(val vertx: Vertx, val ctx: Context) extends ExecutionContext:
  override def execute(runnable: Runnable): Unit =
    if vertx.getOrCreateContext() != ctx
    then ctx.runOnContext((_:Void) => runnable.run())
    else runnable.run()

  override def reportFailure(cause: Throwable): Unit = cause.printStackTrace()

end VertxExecutionContext

object VertxExecutionContext:
  def apply(vertx: Vertx, ctx: Context): VertxExecutionContext = new VertxExecutionContext(vertx, ctx)

