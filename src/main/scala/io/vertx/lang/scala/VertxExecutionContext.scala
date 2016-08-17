package io.vertx.lang.scala

import io.vertx.scala.core.Context

import scala.concurrent.ExecutionContext

/**
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
