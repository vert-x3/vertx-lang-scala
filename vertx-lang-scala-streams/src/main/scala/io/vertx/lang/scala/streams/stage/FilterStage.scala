package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.SimpleStage

class FilterStage[I](f: I => Boolean) extends SimpleStage[I,I]{
  override def next(event: I): Unit = {
    if(f(event))
      subscriber.onNext(event)
    else
      receiveSubscription.request(1)
  }
}
