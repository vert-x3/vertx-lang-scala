package io.vertx.lang.scala.streams.api

import io.vertx.lang.scala.ScalaLogger

/**
  * Basis for simple sinks. It takes care of handling tokens and all other basic operations.
  * Each time tokens run out a new set of tokens is issued to the subscriber. The amount of tokens issued
  * is governed by [[SimpleSink.batchSize]]
  *
  * @tparam I incoming event type
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
trait SimpleSink[I] extends Sink[I] {

  private val Log = ScalaLogger.getLogger(getClass.getName)

  protected var tokens: Long = 0
  protected var subscription: TokenSubscription = _

  def batchSize: Long

  def next(event: I): Unit

  protected def checkTokens(): Unit = {
    if (tokens == 0) {
      val bs: Long = batchSize
      tokens += bs
      subscription.request(bs)
    }
  }

  override def onNext(t: I): Unit = {
    if (tokens <= 0) {
      subscription.cancel()
      throw new RuntimeException("Received an event but receiveTokens are exhausted, cancelling TokenSubscription")
    }
    tokens -= 1
    next(t)
    checkTokens()
  }

  override def onSubscribe(s: TokenSubscription): Unit = {
    if (subscription == null) {
      subscription = s
      checkTokens()
    }
    else
      throw new RuntimeException("Sink already has a TokenSubscription")
  }

  override def onComplete(): Unit = {
    Log.info("Stream has ended, cancelling TokenSubscription")
    subscription.cancel()
  }

  override def onError(t: Throwable): Unit = {
    Log.error("Received an error, cancelling TokenSubscription", t)
    subscription.cancel()
  }
}
