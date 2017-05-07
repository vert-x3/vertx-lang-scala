package io.vertx.lang.scala

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.concurrent.Promise

@RunWith(classOf[JUnitRunner])
class WorkerExecutorExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions {

  "Executing inside a WorkerExecutorExecutionContex" should "work" in {
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    val exec = WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor("mytest"))
    val promise = Promise[String]
    exec.execute(() => promise.success(Thread.currentThread().getName))
    promise.future
      .map(res => res should startWith("mytest-"))
  }

  "A failing execution" should "not impede further executions" in {
    val vertx = Vertx.vertx
    val ctx = vertx.getOrCreateContext()
    val exec = WorkerExecutorExecutionContext(vertx.createSharedWorkerExecutor("mytest"))
    val promise = Promise[String]
    exec.execute(() => throw new RuntimeException)
    exec.execute(() => promise.success(Thread.currentThread().getName))
    promise.future
      .map(res => res should startWith("mytest-"))
  }

}
