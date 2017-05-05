package io.vertx.lang.scala.streams.api

import io.vertx.lang.scala.ScalaLogger

trait SimpleSink[I] extends Sink[I]{

  private val Log = ScalaLogger.getLogger(this.getClass.getName)

  protected var tokens:Long = 0
  protected var subscription: Subscription = _

  def batchSize:Long

  def next(event:I): Unit

  protected def checkTokens(): Unit = {
    if(tokens == 0) {
      val bs:Long = batchSize
      tokens += bs
      subscription.request(bs)
    }
  }


  override def onNext(t: I): Unit = {
    if(tokens <= 0) {
      subscription.cancel()
      throw new RuntimeException("Received an event but receiveTokens are exhausted, cancelling Subscription")
    }
    tokens -= 1
    next(t)
    checkTokens()
  }

  override def onSubscribe(s: Subscription): Unit = {
    if(subscription == null) {
      subscription = s
      checkTokens()
    }
    else
      throw new RuntimeException("Sink already has a Subscription")
  }

  override def onComplete(): Unit = {
    Log.info("Stream has ended, cancelling Subscription")
    subscription.cancel()
  }

  override def onError(t: Throwable): Unit = {
    Log.error("Received an error, cancelling Subscription", t)
    subscription.cancel()
  }
}
