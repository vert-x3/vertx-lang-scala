package io.vertx.lang.scala.streams.api

import io.vertx.lang.scala.ScalaLogger

trait SimpleStage[I,O] extends Stage[I,O]{
  private val Log = ScalaLogger.getLogger(this.getClass.getName)

  private var startTokens = 0l
  protected var receiveSubscription: Subscription = _
  protected var sendSubscription: Subscription = _
  protected var subscriber: Sink[O] = _

  def next(event:I): Unit

  override def onNext(t: I): Unit = {
    next(t)
  }

  override def onSubscribe(s: Subscription): Unit = {
    if(receiveSubscription == null) {
      receiveSubscription = s
      receiveSubscription.request(startTokens)
    }
    else
      throw new RuntimeException("Sink already has a Subscription")
  }

  override def onComplete(): Unit = {
    Log.info("Stream has ended, cancelling Subscription")
    receiveSubscription.cancel()
  }

  override def onError(t: Throwable): Unit = {
    Log.error("Received an error, cancelling Subscription", t)
    receiveSubscription.cancel()
  }

  override def subscribe(s: Sink[O]): Unit = {
    if (sendSubscription != null)
      throw new IllegalArgumentException("This Source only supports one Subscription at a time")
    subscriber = s
    sendSubscription = new Subscription {
      override def cancel(): Unit = receiveSubscription.cancel()

      override def request(n: Long): Unit = {
        if(receiveSubscription != null)
          receiveSubscription.request(n)
        else
          startTokens = n
      }
    }
    subscriber.onSubscribe(sendSubscription)
  }
}
