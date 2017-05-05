package io.vertx.lang.scala.streams.api

/**
  * The whole API tries to follow the concepts of Reactive Streams.
  * The notable exception and reason why I didn't use the Reactive Streams API directly is
  * that it will be used inside Vert.x. Using the Reactive Streams API would require a lot of
  * additional syncing for interactions between streams components as operations are expected to
  * be executed by different threads.
  * In the case of Vert.x we always run on one thread and syncs are not required. I therefore decided
  * to provide this API for our internal implementation and provide adapters to connect to existing
  * Reactive Streams implementations (e.g. Akka)
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a>
  */

sealed trait Component

/**
  * Modelled after [[org.reactivestreams.Processor]]
  * @tparam I incoming event type
  * @tparam O outgoing event type
  */
trait Stage[I,O] extends Sink[I] with Source[O] with Component

/**
  * Modelled after [[org.reactivestreams.Subscriber]]
  * @tparam I incoming event type
  */
trait Sink[I] extends Component{
  def onError(t: Throwable): Unit
  def onComplete(): Unit
  def onNext(t: I): Unit
  def onSubscribe(s: TokenSubscription): Unit
}

/**
  * Modelled after [[org.reactivestreams.Subscription]]
  */
trait TokenSubscription extends Component{
  def cancel(): Unit
  def request(n: Long): Unit
}

/**
  * Modelled after [[org.reactivestreams.Publisher]]
  * @tparam O outgoing event type
  */
trait Source[O] extends Component{
  def subscribe(s: Sink[O]): Unit
}
