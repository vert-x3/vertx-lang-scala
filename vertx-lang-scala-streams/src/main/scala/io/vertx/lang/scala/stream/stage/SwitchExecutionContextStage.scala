package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

class SwitchExecutionContextStage[I]( ec: ExecutionContext) extends Stage[I, I] {
  override def next(value: I): Unit = Try(ec.execute(() => sink.next(value))) match {
    case Success(_) => ()
    case Failure(t) => failureStrategy.onFailure(source, t)
  }

  override def toString: String = s"SwitchExecutionContextStage using $ec"
}
