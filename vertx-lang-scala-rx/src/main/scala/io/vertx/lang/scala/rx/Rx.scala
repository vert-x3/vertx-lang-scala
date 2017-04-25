package io.vertx.lang.scala.rx

import io.vertx.core.Handler
import io.vertx.lang.scala.{VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.rx.java.{ObservableHandler => JObservableHandler}
import io.vertx.scala.core.Vertx
import rx.lang.scala.schedulers.ExecutionContextScheduler
import rx.lang.scala.{Observable, Scheduler}

object Rx{
  implicit class RxVertx(vertx: Vertx) {
    def vertxScheduler():Scheduler = ExecutionContextScheduler(VertxExecutionContext(vertx.getOrCreateContext()))
    def workerScheduler(name: String) = ExecutionContextScheduler(WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor(name)))
  }

  def observableHandler[T](): ObservableHandler[T] = new ObservableHandler[T](new JObservableHandler[T]())

}

class ObservableHandler[T](val asJavaObservable: JObservableHandler[T]) extends Observable[T] {
  def toHandler():Handler[T] = asJavaObservable.toHandler
}

