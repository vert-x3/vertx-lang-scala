package io.vertx.lang.scala.streams.source

import io.vertx.lang.scala.streams.api.SimpleSource
import io.vertx.scala.core.streams.ReadStream

class ReadStreamSource[O](rs: ReadStream[O]) extends SimpleSource[O]{

  private var paused = false

  rs.handler(event => {
    subscriber.onNext(event)
    remainingTokens -= 1
    if(remainingTokens == 0){
      rs.pause()
      paused = true
    }
  })

  override def start(): Unit = {
    if(paused) {
      rs.resume()
      paused = false
    }
  }

}
