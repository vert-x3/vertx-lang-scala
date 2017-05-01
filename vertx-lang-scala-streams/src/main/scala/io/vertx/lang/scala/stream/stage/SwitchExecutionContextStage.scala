package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

import scala.concurrent.ExecutionContext

class SwitchExecutionContextStage[I]( ec: ExecutionContext) extends Stage[I, I] {
  override def next(value: I): Unit = ec.execute(() => sink.next(value))
}
