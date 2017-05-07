package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.SimpleStage
import io.vertx.lang.scala.{VertxExecutionContext, WorkerExecutorExecutionContext}

import scala.concurrent.Promise
import scala.util.{Failure, Success, Try}

class SyncStage[I, O](f: I => O, failureHandler: (I, Throwable) => Unit = (a: I, t: Throwable) => {})(implicit val wec: WorkerExecutorExecutionContext, implicit val vec: VertxExecutionContext) extends SimpleStage[I, O] {
  override def next(event: I): Unit = {
    val promise = Promise[O]()
    wec.execute(() => {
      promise.complete(Try(f(event)))
    })

    promise.future.onComplete{
      case Success(e) => subscriber.onNext(e)
      case Failure(t) => {
        receiveSubscription.request(1)
        failureHandler(event, t)
      }
    }(vec)
  }
}
