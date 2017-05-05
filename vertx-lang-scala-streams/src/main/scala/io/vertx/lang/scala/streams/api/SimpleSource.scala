package io.vertx.lang.scala.streams.api

trait SimpleSource[O] extends Source[O]{
  protected var subscription: TokenSubscription = _
  protected var subscriber: Sink[O] = _
  protected var remainingTokens:Long = 0

  override def subscribe(s: Sink[O]): Unit = {
    if (subscription != null)
      throw new IllegalArgumentException("This Source only supports one TokenSubscription at a time")
    subscriber = s
    subscription = new TokenSubscription {
      override def cancel(): Unit = remainingTokens = 0

      override def request(n: Long): Unit = {
        val oldValue = remainingTokens
        remainingTokens += n
        if(oldValue == 0)
          start()
      }
    }
    subscriber.onSubscribe(subscription)
    start()
  }

  /**
    * Will be called right after starting the streams and then each time we ran out of receiveTokens
    * and received new ones.
    */
  def start(): Unit
}
