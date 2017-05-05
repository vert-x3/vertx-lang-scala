package io.vertx.lang.scala.streams.sink

import io.vertx.lang.scala.streams.api.{Sink, TokenSubscription}
import io.vertx.lang.scala.{ScalaLogger, VertxExecutionContext}
import org.reactivestreams.{Subscriber, Subscription}

class ReactiveStreamsSubscriberSink[I](subscriber: Subscriber[I])(ec: VertxExecutionContext) extends Sink[I]{

  private val Log = ScalaLogger.getLogger(getClass.getName)

  private var subscription: TokenSubscription = _

  private val reactiveStreamsSubscription = new Subscription {
    override def cancel(): Unit = ec.execute(() => subscription.cancel())

    override def request(n: Long): Unit = ec.execute(() => subscription.request(n))
  }

  override def onNext(t: I): Unit = {
    subscriber.onNext(t)
  }

  override def onSubscribe(s: TokenSubscription): Unit = {
    if(subscription == null) {
      subscription = s
    }
    else
      throw new RuntimeException("Sink already has a TokenSubscription")
  }

  override def onComplete(): Unit = {
    Log.info("Stream has ended, cancelling TokenSubscription")
    subscriber.onComplete()
  }

  override def onError(t: Throwable): Unit = {
    Log.error("Received an error, cancelling TokenSubscription", t)
    subscriber.onError(t)
  }
}
