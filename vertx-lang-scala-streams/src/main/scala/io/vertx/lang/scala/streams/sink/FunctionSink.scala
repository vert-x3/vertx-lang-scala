package io.vertx.lang.scala.streams.sink

import io.vertx.lang.scala.streams.api.SimpleSink

class FunctionSink[I](f: I => Unit) extends SimpleSink[I]{
  override def batchSize: Long = 1
  override def next(event: I): Unit = f(event)
}
