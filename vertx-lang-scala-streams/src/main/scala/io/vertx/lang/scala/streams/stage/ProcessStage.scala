package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.{SimpleStage, Stage}

/**
  * A [[Stage]] to execute a given function as a side effect without changing the stream.
  * @param f the function to execute
  * @tparam I the incoming event type
  */
class ProcessStage[I](f: I => Unit) extends SimpleStage[I,I]{
  override def next(event: I): Unit = {
    f(event)
    subscriber.onNext(event)
  }
}
