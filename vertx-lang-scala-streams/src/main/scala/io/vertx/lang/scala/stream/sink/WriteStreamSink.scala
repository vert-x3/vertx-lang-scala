package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.Sink
import io.vertx.scala.core.streams.WriteStream

class WriteStreamSink[T](ws: WriteStream[T]) extends Sink[T] {
  override def next(value: T): Unit = {
    ws.write(value)
    source.request(1)
  }
  override def skip(ns: Long): Unit = source.request(1)

  override def toString: String = s"WriteStreamSink using $ws"
}
