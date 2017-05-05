package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.ScalaLogger
import io.vertx.lang.scala.streams.api.SimpleStage

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class FutureStage[I, O](f: I => Future[O], failureHandler: (I, Throwable) => Unit = (a: I, t: Throwable) => {})(implicit ec: ExecutionContext) extends SimpleStage[I, O] {
  protected val Log = ScalaLogger.getLogger(getClass.getName)

  override def next(event: I): Unit = {
    f(event).onComplete {
      case Success(i) => subscriber.onNext(i)
      case Failure(t) => {
        Log.warn(s"Failed future for $event", t)
        receiveSubscription.request(1)
        failureHandler(event, t)
      }
    }
  }
}
