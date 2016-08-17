package io.vertx.lang.scala

import io.vertx.scala.core.Context

import scala.concurrent.ExecutionContext

/**
  * A scala [[ExecutionContext]] binds [[scala.concurrent.Promise]]/[[scala.concurrent.Future]] to a thread.
  * In the case of Vert.x we have to make sure that they execute on the right context. A context could be that
  * of a worker or a standard verticle. This execution context implementation runs all Runnables on the associated
  * [[Context]].
  *
  * Taken from the original Vert.x-impl
  * https://github.com/vert-x/mod-lang-scala/blob/master/src/main/scala/org/vertx/scala/core/VertxExecutionContext.scala
  *
  */
class VertxExecutionContext(val ctx:Context) extends ExecutionContext{
  override def execute(runnable: Runnable): Unit = {
    runnable.run()
  }

  override def reportFailure(cause: Throwable): Unit = {
    cause.printStackTrace()
  }
}

object VertxExecutionContext {
  def apply(ctx: Context): VertxExecutionContext = new VertxExecutionContext(ctx)
}
