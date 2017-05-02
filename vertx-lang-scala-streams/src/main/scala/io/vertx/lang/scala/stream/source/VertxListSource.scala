package io.vertx.lang.scala.stream.source

import io.vertx.lang.scala.stream.api.Source
import io.vertx.scala.core.Context

class VertxListSource[O](ctx: Context, val list: List[O]) extends Source[O]{
  var tokens = 0l
  var offset = 0

  override def cancel(): Unit = tokens = 0
  override def request(nr: Long): Unit = {
    if(nr > 0)
      tokens += nr
    exec()
  }

  def exec():Unit =
    ctx.runOnContext(_ => {
      if(list.size == offset - 1)
        offset = 0
      else {
        sink.next(list(offset))
        offset += 1
        tokens -= 1
        if(tokens > 0)
          exec()
      }

    })

  override def toString: String = s"VertxListSource using list"
}
