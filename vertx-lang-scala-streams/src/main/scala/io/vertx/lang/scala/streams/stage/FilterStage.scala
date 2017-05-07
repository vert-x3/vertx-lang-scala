package io.vertx.lang.scala.streams.stage

import io.vertx.lang.scala.streams.api.SimpleStage

/**
  * A Stage that will only allow events matching a certain predicate to pass.
  * If an event doesn't match it is discarded and a new token is propagated upstream to compensate the loss of a
  * token.
  * @param f the predicate
  * @tparam I incoming event type
  */
class FilterStage[I](f: I => Boolean) extends SimpleStage[I,I]{
  override def next(event: I): Unit = {
    if(f(event))
      subscriber.onNext(event)
    else
      receiveSubscription.request(1)
  }
}
