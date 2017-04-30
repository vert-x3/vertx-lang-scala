package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.Sink
import io.vertx.scala.core.streams.WriteStream

class WriteStreamSink[T](ws: WriteStream[T]) extends Sink[T] {
  override def next(value: T): Unit = ws.write(value)
}
