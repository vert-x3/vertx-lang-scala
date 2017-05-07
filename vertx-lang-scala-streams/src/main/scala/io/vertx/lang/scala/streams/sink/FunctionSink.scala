package io.vertx.lang.scala.streams.sink

import io.vertx.lang.scala.streams.api.SimpleSink

/**
  * A [[io.vertx.lang.scala.streams.api.Sink]]-implementation that will invoke the given function for each incoming
  * event.
  * @param f function to invoke for each event
  * @tparam I incoming event type
  *
  */
class FunctionSink[I](f: I => Unit, _batchSize: Long = 1) extends SimpleSink[I]{
  override def batchSize: Long = _batchSize
  override def next(event: I): Unit = f(event)
}
