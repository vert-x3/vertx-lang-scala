package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.Sink
import io.vertx.scala.core.streams.WriteStream

class WriteStreamSink[T](ws: WriteStream[T]) extends Sink[T] {
  ws.drainHandler(_ => source.request(1))
  override def next(value: T): Unit = {
    if(!ws.writeQueueFull()) {
      ws.write(value)
      if(!ws.writeQueueFull()) {
        source.request(1)
      }
    }
    if(ws.writeQueueFull()) {
      source.cancel()
    }
  }
  override def skip(ns: Long): Unit = source.request(1)

  override def toString: String = s"WriteStreamSink using $ws"
}
