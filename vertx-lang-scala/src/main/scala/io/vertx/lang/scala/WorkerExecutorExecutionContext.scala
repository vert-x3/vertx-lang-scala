package io.vertx.lang.scala

import io.vertx.scala.core.WorkerExecutor

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success}


/**
  * Created by jochen on 24.04.17.
  */
class WorkerExecutorExecutionContext(val ctx: WorkerExecutor) extends ExecutionContext {
  private val Log = ScalaLogger.getLogger(classOf[VertxExecutionContext].getName)

  override def execute(runnable: Runnable): Unit = {
    ctx.executeBlocking[Unit](() => runnable.run()).onComplete{
      case Success(_) => ()
      case Failure(t) => Log.error("Failed executing", t)
    }(this)
  }

  override def reportFailure(cause: Throwable): Unit = {
    Log.error("Failed executing on contet", cause)
  }
}

object WorkerExecutorExecutionContext {
  def apply(ctx: WorkerExecutor): WorkerExecutorExecutionContext = new WorkerExecutorExecutionContext(ctx)
}
