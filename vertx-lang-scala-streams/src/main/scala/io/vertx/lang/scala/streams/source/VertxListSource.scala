package io.vertx.lang.scala.streams.source

import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.streams.api.SimpleSource

class VertxListSource[O](list: List[O])(implicit ec:VertxExecutionContext) extends SimpleSource[O]{
  private var index: Int = 0
  override def start(): Unit = {
    if(remainingTokens > 0) {
      subscriber.onNext(list(index))
      index += 1
      remainingTokens -= 1
      if(index == list.size) {
        remainingTokens = 0
        subscriber.onComplete()
      }
      else if(remainingTokens > 0)
        ec.execute(() => start())
    }
  }

}
