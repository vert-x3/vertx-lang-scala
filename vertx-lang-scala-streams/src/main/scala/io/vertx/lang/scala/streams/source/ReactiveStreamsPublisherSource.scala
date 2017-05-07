package io.vertx.lang.scala.streams.source

import java.util.concurrent.atomic.AtomicReference

import io.vertx.lang.scala.streams.api.{Sink, Source, TokenSubscription}
import org.reactivestreams.{Publisher, Subscriber, Subscription}

import scala.concurrent.ExecutionContext

class ReactiveStreamsPublisherSource[O](publisher: Publisher[O])(implicit ec: ExecutionContext) extends Source[O] {
  protected var subscription: TokenSubscription = _
  protected var subscriber: Sink[O] = _

  private val reactiveStreamsSubscription = new AtomicReference[Subscription]()

  publisher.subscribe(new Subscriber[O] {
    override def onError(t: Throwable): Unit = ec.execute(() => subscriber.onError(t))

    override def onComplete(): Unit = ec.execute(() => subscriber.onComplete())

    override def onNext(t: O): Unit = ec.execute(() => subscriber.onNext(t))

    override def onSubscribe(s: Subscription): Unit = reactiveStreamsSubscription.set(s)
  })

  override def subscribe(s: Sink[O]): Unit = {
    if (subscription != null)
      throw new IllegalArgumentException("This Source only supports one TokenSubscription at a time")
    subscriber = s
    subscription = new TokenSubscription {
      override def cancel(): Unit = reactiveStreamsSubscription.get().cancel()

      override def request(n: Long): Unit = {
        reactiveStreamsSubscription.get().request(n)
      }
    }
    subscriber.onSubscribe(subscription)
  }
}

