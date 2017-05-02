package io.vertx.lang.scala.stream.api

/**
  * Base trait to prevent further additions and to allow easy handling in collections.
  */
sealed trait StreamComponent {
  private[this] var _failureStrategy: FailureStrategy = _

  def failureStrategy: FailureStrategy = _failureStrategy
  def failureStrategy_=(f: FailureStrategy): Unit = _failureStrategy = f

  /**
    * Called when the component should be destroyed
    */
  def destroy(): Unit = {}
}

/**
  * A Sink is a consumer for events.
  * @tparam T the type of events this sink consumes.
  */
trait Sink[T] extends StreamComponent{
  private[this] var _source: Source[T] = _

  /**
    * @return The [[Source]] this sink is connected to.
    */
  def source: Source[T] = _source
  def source_=(s: Source[T]): Unit = _source = s

  /**
    * Called each time the connected Source produces an event
    * @param value
    */
  def next(value: T): Unit

  /**
    * Used to report that the stream skip 1 or more events.
    * @param ns
    */
  def skip(ns: Long): Unit
  /**
    * Called after construction of the whole stream to start processing.
    */
  def start():Unit = {
    source.request(1)
  }
}

/**
  * A Source is an event producer. It is connected to a Sink to deliver events.
  * @tparam T
  */
trait Source[T] extends StreamComponent{
  private[this] var _sink: Sink[T] = _

  /**
    * @return The [[Sink]] this Source is connected to.
    */
  def sink: Sink[T] = _sink
  def sink_=(s: Sink[T]): Unit = _sink = s

  /**
    * Called from downstream [[Sink]]s to signal demand.
    * @param nr tokens issued from downstream
    */
  def request(nr: Long): Unit
  def cancel() : Unit
}

/**
  * A Stage sits between [[Source]]s and [[Sink]]s to allow further processing.
  * @tparam I incoming event type
  * @tparam O outgoing event type
  */
trait Stage[I,O] extends Sink[I] with Source[O]{
  override def request(nr: Long): Unit = source.request(nr)
  override def cancel(): Unit = source.cancel()
  override def start(): Unit = ()
  override def skip(ns: Long): Unit = sink.skip(ns)
}

trait FailureStrategy {
  def onFailure(source: StreamComponent, t:Throwable): Unit
}
