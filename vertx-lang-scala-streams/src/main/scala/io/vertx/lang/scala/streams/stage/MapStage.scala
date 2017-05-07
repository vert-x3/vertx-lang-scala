package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.{SimpleStage, Stage}

/**
  * A [[Stage]] for mapping incoming events to different outgoing events.
  * @param f the mapping function
  * @tparam I incoming event type
  * @tparam O outgoing event type produced by the mapping function
  */
class MapStage[I,O](f: I => O) extends SimpleStage[I,O]{
  override def next(event: I): Unit = {
    subscriber.onNext(f(event))
  }
}
