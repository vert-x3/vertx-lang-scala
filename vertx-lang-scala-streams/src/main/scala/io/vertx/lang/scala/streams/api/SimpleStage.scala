package io.vertx.lang.scala.streams.api

import io.vertx.lang.scala.ScalaLogger

/**
  * Several [[Stage]]s sit between a [[Source]] and [[Sink]]. This class provides a basic implementation that
  * coordinates token handling between the two. 
  * @tparam I incoming event type
  * @tparam O outgoing event type
  */
trait SimpleStage[I,O] extends Stage[I,O]{
  private val Log = ScalaLogger.getLogger(getClass.getName)

  private var startTokens = 0l
  protected var receiveSubscription: TokenSubscription = _
  protected var sendSubscription: TokenSubscription = _
  protected var subscriber: Sink[O] = _

  def next(event:I): Unit

  override def onNext(t: I): Unit = {
    next(t)
  }

  override def onSubscribe(s: TokenSubscription): Unit = {
    if(receiveSubscription == null) {
      receiveSubscription = s
      if(startTokens > 0)
        receiveSubscription.request(startTokens)
    }
    else
      throw new RuntimeException("Sink already has a TokenSubscription")
  }

  override def onComplete(): Unit = {
    Log.info("Stream has ended, cancelling TokenSubscription")
    receiveSubscription.cancel()
  }

  override def onError(t: Throwable): Unit = {
    Log.error("Received an error, cancelling TokenSubscription", t)
    receiveSubscription.cancel()
  }

  override def subscribe(s: Sink[O]): Unit = {
    if (sendSubscription != null)
      throw new IllegalArgumentException("This Source only supports one TokenSubscription at a time")
    subscriber = s
    sendSubscription = new TokenSubscription {
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
