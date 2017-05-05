package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.SimpleStage

class ProcessStage[I](f: I => Unit) extends SimpleStage[I,I]{
  override def next(event: I): Unit = {
    f(event)
    subscriber.onNext(event)
  }
}
