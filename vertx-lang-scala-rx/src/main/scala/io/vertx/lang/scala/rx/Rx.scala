package io.vertx.lang.scala.rx

import io.vertx.lang.scala.{VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.scala.core.Vertx
import rx.lang.scala.Scheduler
import rx.lang.scala.schedulers.ExecutionContextScheduler

object Rx{
  implicit class RxVerticleScala(vertx: Vertx) {
    def vertxScheduler():Scheduler = ExecutionContextScheduler(VertxExecutionContext(vertx.getOrCreateContext()))
    def workerScheduler(name: String) = ExecutionContextScheduler(WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor(name)))
  }
}

