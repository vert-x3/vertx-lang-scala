package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.Sink

class FunctionSink[T](f: T => Unit) extends Sink[T] {
  override def next(value: T): Unit = f(value)
}
