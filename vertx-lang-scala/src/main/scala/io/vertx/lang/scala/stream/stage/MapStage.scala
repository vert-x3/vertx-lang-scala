package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

class MapStage[I,O](f: I => O) extends Stage[I,O]{
  override def next(value: I): Unit = sink.next(f(value))
}
