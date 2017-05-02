package io.vertx.lang.scala.stream.builder

import io.vertx.lang.scala.stream.api._
import io.vertx.lang.scala.stream.failurestrategy.SkipStrategy

class StreamBuilder[I](private val toBuild: List[() => StreamComponent], val failureStrategy:FailureStrategy) {

  def next[O](sc: () => StreamComponent):StreamBuilder[O] = new StreamBuilder[O](toBuild :+ sc, failureStrategy)

  def start(): StreamBuilder[I] = {
    val components = toBuild.map(a => a())
    if(components.size < 2)
      throw new RuntimeException("Not enough elements")
    components.sliding(3, 1).foreach(l => {
      l.head.failureStrategy = failureStrategy
      l.head.asInstanceOf[Source[Any]].sink = l(1).asInstanceOf[Sink[Any]]
      l(1).failureStrategy = failureStrategy
      l(1).asInstanceOf[Sink[Any]].source = l.head.asInstanceOf[Source[Any]]
      if(l.size == 3) {
        l(1).failureStrategy = failureStrategy
        l(1).asInstanceOf[Source[Any]].sink = l(2).asInstanceOf[Sink[Any]]
        l(2).failureStrategy = failureStrategy
        l(2).asInstanceOf[Sink[Any]].source = l(1).asInstanceOf[Source[Any]]
      }
    })
    components.last.asInstanceOf[Sink[Any]].start()
    this
  }
}

object StreamBuilder{
  def apply[I](sc: () => StreamComponent, failureStrategy:FailureStrategy): StreamBuilder[I] = new StreamBuilder(sc :: Nil, failureStrategy)
  def apply[I](failureStrategy:FailureStrategy): StreamBuilder[I] = new StreamBuilder(Nil, failureStrategy)
}
