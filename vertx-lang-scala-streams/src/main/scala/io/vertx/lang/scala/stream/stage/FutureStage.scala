package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class FutureStage[I,O](f: I => Future[O], ec:ExecutionContext) extends Stage[I,O]{
  override def next(value: I): Unit = f(value).onComplete{
    case Success(s) => sink.next(s)
    case Failure(t) => failureStrategy.onFailure(this, t)
  }(ec)

  override def toString: String = s"FutureStage using $f running on $ec"
}

