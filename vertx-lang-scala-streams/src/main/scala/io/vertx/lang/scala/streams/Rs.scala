package io.vertx.lang.scala.streams

import io.vertx.lang.scala.streams.api.{Sink, Source}
import io.vertx.lang.scala.streams.sink.{FunctionSink, ReactiveStreamsSubscriberSink, WriteStreamSink}
import io.vertx.lang.scala.streams.source.{ReactiveStreamsPublisherSource, ReadStreamSource}
import io.vertx.lang.scala.streams.stage._
import io.vertx.lang.scala.{VertxExecutionContext, WorkerExecutorExecutionContext}
import io.vertx.scala.core.WorkerExecutor
import io.vertx.scala.core.streams.{ReadStream, WriteStream}
import org.reactivestreams.{Publisher, Subscriber}

import scala.concurrent.Future

/**
  * All sorts of helpers and extensions to allow easy creations of Streams.
  */
object Rs {

  /**
    * Converts a [[WorkerExecutor]] to a [[WorkerExecutorExecutionContext]] for easier usage in streams.
    * @param we the executer to wrap
    * @return
    */
  implicit def workerExecutorToExecutionContext(we: WorkerExecutor): WorkerExecutorExecutionContext = new WorkerExecutorExecutionContext(we)

  /**
    * Extends [[ReadStream]]s with a toSource-method to provide a convenient entry-point for streams.
    * @param rs the ReadStream to extends
    * @tparam O type of elements produced by the stream
    */
  implicit class ReadStreamSourceExtender[O](val rs: ReadStream[O]) {
    /**
      * Convert the stream to a [[Source]]
      * @return
      */
    def toSource: Source[O] = new ReadStreamSource[O](rs)
  }

  /**
    * Extends [[WriteStream]]s with a toSink-method to provide a convenient entry-point for streams.
    * @param ws the WriteStream to extend
    * @tparam I input type for the WriteStream
    */
  implicit class WriteStreamSourceExtender[I](val ws: WriteStream[I]) {
    /**
      * Convert the stream to a [[Sink]]
      * @return
      */
    def toSink(batchSize: Long = 10): Sink[I] = new WriteStreamSink[I](ws, batchSize)
  }

  /**
    * Extends [[Publisher]]s with a toSource-method to provide a convenient entry-point for streams.
    * @param pub the [[Publisher]] to extend
    * @param ec the [[VertxExecutionContext]] all operations run on
    * @tparam O the output type of the [[Publisher]]
    */
  implicit class PublisherExtender[O](val pub: Publisher[O])(implicit ec:VertxExecutionContext) {
    /**
      * Convert the [[Publisher]] to a [[Source]]
      * @return
      */
    def toSource: Source[O] = new ReactiveStreamsPublisherSource[O](pub)
  }

  /**
    * Extends [[Subscriber]]s with a toSink-method to provide a convenient exit-point for streams.
    * @param s the [[Subscriber]] to extend
    * @param ec the [[VertxExecutionContext]] all operations run on
    * @tparam I the input type of the [[Subscriber]]
    */
  implicit class SubscriberExtender[I](val s: Subscriber[I])(implicit ec:VertxExecutionContext) {
    /**
      * Convert the [[Subscriber]] to a [[Sink]]
      * @return
      */
    def toSink: Sink[I] = new ReactiveStreamsSubscriberSink[I](s)
  }

  /**
    * Extend all [[Source]]s with a set of methods to fluentyl create a stream.
    * @param source the starting point of the stream
    * @tparam I type of events produced by the [[Source]]
    */
  implicit class SourceExtender[I](val source: Source[I]) {
    /**
      * Map from one event rype to another.
      * @param f mapping function
      * @tparam O outgoing event type
      * @return a new source to attach further operations to
      */
    def map[O](f: I => O): Source[O] = {
      val stage = new MapStage[I, O](f)
      source.subscribe(stage)
      stage
    }

    /**
      * Remove all events from the stream that don't match a given predicate
      * @param f predicate function
      * @return a new source to attach further operations to
      */
    def filter(f: I => Boolean): Source[I] = {
      val stage = new FilterStage[I](f)
      source.subscribe(stage)
      stage
    }

    /**
      * Incoming events are mapped to a [[Future]]. The resulting [[Future]] is evaluated and its result propagated to
      * the stream.
      * @param f fucntion to map incoming value to a [[Future]]
      * @param failureHandler called if the [[Future]] fails
      * @param ec male sure all operations run on the [[VertxExecutionContext]]
      * @tparam O type of resulting events
      * @return a new source to attach further operations to
      */
    def future[O](f: I => Future[O], failureHandler: (I, Throwable) => Unit = (a: I, t: Throwable) => {})(implicit ec: VertxExecutionContext): Source[O] = {
      val stage = new FutureStage[I, O](f)
      source.subscribe(stage)
      stage
    }

    /**
      * Execute the given function on a given [[WorkerExecutorExecutionContext]] and propagate the result to the stream.
      * @param f function to be executed in a different thread.
      * @param failureHandler called if the function fails
      * @param wec [[WorkerExecutorExecutionContext]] to be used for the operation
      * @param vec male sure all operations run on the [[VertxExecutionContext]]
      * @tparam O output event type
      * @return a new source to attach further operations to
      */
    def sync[O](f: I => O, failureHandler: (I, Throwable) => Unit = (a: I, t: Throwable) => {})(implicit wec: WorkerExecutorExecutionContext, vec: VertxExecutionContext): Source[O] = {
      val stage = new SyncStage[I, O](f)
      source.subscribe(stage)
      stage
    }

    /**
      * Execute a given function as a side effect.
      * @param f the function to execute as a side effect
      * @return a new source to attach further operations to
      */
    def process(f: I => Unit): Source[I] = {
      val stage = new ProcessStage[I](f)
      source.subscribe(stage)
      stage
    }

    /**
      * Create an endpoint for the stream from a given function.
      * @param f a function to receive all events from the stream
      */
    def sink(f: I => Unit, batchSize: Long = 1): Unit = {
      val sink = new FunctionSink(f, batchSize)
      source.subscribe(sink)
    }

    /**
      * Create an endpoint for the stream from a given [[WriteStream]].
      * @param ws a [[WriteStream]] to receive all events from the stream
      */
    def sink(ws: WriteStream[I]): Unit = {
      val sink = new WriteStreamSink[I](ws)
      source.subscribe(sink)
    }

    /**
      * Create an endpoint for the stream from a given [[Sink]].
      * @param sink a [[Sink]] to receive all events from the stream
      */
    def sink(sink: Sink[I]):Unit = {
      source.subscribe(sink)
    }
  }

}
