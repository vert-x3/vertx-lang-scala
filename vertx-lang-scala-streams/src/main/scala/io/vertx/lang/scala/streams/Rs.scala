package io.vertx.lang.scala.streams

import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.streams.api.{Sink, Source}
import io.vertx.lang.scala.streams.sink.{ReactiveStreamsSubscriberSink, WriteStreamSink}
import io.vertx.lang.scala.streams.source.{ReactiveStreamsPublisherSource, ReadStreamSource}
import io.vertx.lang.scala.streams.stage.{FilterStage, FutureStage, MapStage, ProcessStage}
import io.vertx.scala.core.streams.{ReadStream, WriteStream}
import org.reactivestreams.{Publisher, Subscriber}

import scala.concurrent.{ExecutionContext, Future}

object Rs {

  implicit class ReadStreamSourceExtender[O](val rs: ReadStream[O]) {
    def toSource: Source[O] = new ReadStreamSource[O](rs)
  }

  implicit class WriteStreamSourceExtender[I](val ws: WriteStream[I]) {
    def toSink(batchSize: Long = 10): Sink[I] = new WriteStreamSink[I](ws, batchSize)
  }

  implicit class PublisherExtender[O](val pub: Publisher[O])(implicit ec:ExecutionContext) {
    def toSource: Source[O] = new ReactiveStreamsPublisherSource[O](pub)
  }

  implicit class SubscriberExtender[I](val s: Subscriber[I])(implicit ec:VertxExecutionContext) {
    def toSink: Sink[I] = new ReactiveStreamsSubscriberSink[I](s)
  }

  implicit class SourceExtender[I](val source: Source[I]) {
    def map[O](f: I => O): Source[O] = {
      val stage = new MapStage[I, O](f)
      source.subscribe(stage)
      stage
    }

    def filter(f: I => Boolean): Source[I] = {
      val stage = new FilterStage[I](f)
      source.subscribe(stage)
      stage
    }

    def future[O](f: I => Future[O], failureHandler: (I, Throwable) => Unit = (a: I, t: Throwable) => {})(implicit ec: ExecutionContext): Source[O] = {
      val stage = new FutureStage[I, O](f)
      source.subscribe(stage)
      stage
    }

    def process(f: I => Unit): Source[I] = {
      val stage = new ProcessStage[I](f)
      source.subscribe(stage)
      stage
    }

    def sink(sink: Sink[I]) = {
      source.subscribe(sink)
    }
  }

}
