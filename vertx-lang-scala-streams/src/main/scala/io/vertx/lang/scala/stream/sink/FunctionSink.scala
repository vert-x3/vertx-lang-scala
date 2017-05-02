package io.vertx.lang.scala.stream.sink

import io.vertx.lang.scala.stream.api.Sink

class FunctionSink[T](f: T => Unit) extends Sink[T] {
  override def next(value: T): Unit = {
    f(value)
    source.request(1)
  }
  override def skip(ns: Long): Unit = source.request(1)

  override def toString: String = s"FunctionSink using $f"

}
