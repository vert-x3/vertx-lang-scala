package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.util.{Failure, Success, Try}

class MapStage[I,O](f: I => O) extends Stage[I,O]{
  override def next(value: I): Unit = Try(f(value)) match {
    case Success(s) => sink.next(s)
    case Failure(t) => failureStrategy.onFailure(this, t)
  }

  override def toString: String = s"MapStage using $f"
}
