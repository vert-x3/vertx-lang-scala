package io.vertx.lang.scala.stream.source

import io.vertx.lang.scala.stream.api.Source
import io.vertx.scala.core.streams.ReadStream

class ReadStreamSource[T](rs: ReadStream[T]) extends Source[T] {

  var tokens = 0l

  rs.handler(sink.next(_))
  rs.pause()

  override def cancel(): Unit = tokens = 0

  override def request(nr: Long): Unit = {
    if(tokens == 0 && nr > 0)
      rs.resume()
    tokens = tokens + nr
  }

  override def toString: String = s"ReadStreamSource using $rs"
}

object ReadStreamSource {
  def apply[T](rs: ReadStream[T]): ReadStreamSource[T] = new ReadStreamSource(rs)
}
