package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.concurrent.{ExecutionContext, Future}

class FutureStage[I,O](f: I => Future[O], ec:ExecutionContext) extends Stage[I,O]{
  override def next(value: I): Unit = f(value).map(sink.next)(ec)
}

