package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class FilterStage[I](f: I => Boolean) extends Stage[I,I]{
  override def next(value: I): Unit = if(f(value)) sink.next(value) else sink.skip(1)
  override def toString: String = s"FilterStage using $f"
}

