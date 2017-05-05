package io.vertx.lang.scala.streams

import io.vertx.scala.core.streams.{ReadStream, WriteStream}
import io.vertx.lang.scala.streams.api.{Sink, Source}
import io.vertx.lang.scala.streams.sink.WriteStreamSink
import io.vertx.lang.scala.streams.source.ReadStreamSource
import io.vertx.lang.scala.streams.stage.{FilterStage, MapStage, ProcessStage}

object Rs {

  implicit class ReadStreamSourceExtender[O](val rs: ReadStream[O]) {
    def toSource: Source[O] = new ReadStreamSource[O](rs)
  }

  implicit class WriteStreamSourceExtender[I](val ws: WriteStream[I]) {
    def toSink(batchSize: Long = 10): Sink[I] = new WriteStreamSink[I](ws, batchSize)
  }

  implicit class SourceExtender[I](val source:Source[I]) {
    def map[O](f: I => O):Source[O] = {
      val stage = new MapStage[I,O](f)
      source.subscribe(stage)
      stage
    }

    def filter(f: I => Boolean):Source[I] = {
      val stage = new FilterStage[I](f)
      source.subscribe(stage)
      stage
    }

    def process(f: I => Unit):Source[I] = {
      val stage = new ProcessStage[I](f)
      source.subscribe(stage)
      stage
    }

    def sink(sink: Sink[I]) = {
      source.subscribe(sink)
    }
  }
}
