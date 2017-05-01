package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.{Sink, Source}

class DevNull[T] extends Sink[T] {
  override def next(value: T): Unit = println(s"DevNull received $value")
}
