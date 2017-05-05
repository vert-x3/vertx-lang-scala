package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.SimpleStage

class MapStage[I,O](f: I => O) extends SimpleStage[I,O]{
  override def next(event: I): Unit = {
    subscriber.onNext(f(event))
  }
}
