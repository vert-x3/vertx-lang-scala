package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.util.{Failure, Success, Try}

class ProcessStage[I](f: I => Unit) extends Stage[I,I]{
  override def next(value: I): Unit = {
    Try(f(value)) match {
      case Success(()) => sink.next(value)
      case Failure(t) => failureStrategy.onFailure(this, t)
    }
  }

  override def toString: String = s"ProcessStage using $f"
}
