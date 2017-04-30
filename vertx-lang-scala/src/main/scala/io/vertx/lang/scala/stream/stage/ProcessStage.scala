package io.vertx.lang.scala.stream.stage

import io.vertx.lang.scala.stream.api.Stage

class ProcessStage[I](f: I => Unit) extends Stage[I,I]{
  override def next(value: I): Unit = {
    f(value)
    sink.next(value)
  }
}
