package io.vertx.lang.scala.rx

import io.vertx.core.Handler
import io.vertx.lang.scala.{VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.rx.java.{ObservableReadStream, ObservableHandler => JObservableHandler}
import io.vertx.scala.core.Vertx
import io.vertx.scala.core.streams.ReadStream
import rx.lang.scala.schedulers.ExecutionContextScheduler
import rx.lang.scala.{Observable, Scheduler}

object Rx{
  implicit class RxVertx(vertx: Vertx) {
    def vertxScheduler():Scheduler = ExecutionContextScheduler(VertxExecutionContext(vertx.getOrCreateContext()))
    def workerScheduler(name: String) = ExecutionContextScheduler(WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor(name)))
  }

  def observableHandler[T](): ObservableHandler[T] = new ObservableHandler[T](new JObservableHandler[T]())

//  def rxReadStream[T](readStream: ReadStream[T]): ObservableReadStream[T] = new ObservableReadStream[T](readStream.asJava.asInstanceOf[ReadStream[T]])
}

class ObservableHandler[T](val asJavaObservable: JObservableHandler[T]) extends Observable[T] {
  def toHandler():Handler[T] = asJavaObservable.toHandler
}

