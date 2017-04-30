package io.vertx.lang.scala.stream.builder

import io.vertx.lang.scala.stream.api._

class StreamBuilder[I](private val toBuild: List[StreamComponent]) {

  def next[O](sc: StreamComponent):StreamBuilder[O] = new StreamBuilder[O](toBuild :+ sc)

  def start(): Unit = {
    if(toBuild.size < 2)
      throw new RuntimeException("Not enough elements")
    toBuild.sliding(3, 1).foreach(l => {
      l.head.asInstanceOf[Source[Any]].sink = l(1).asInstanceOf[Sink[Any]]
      l(1).asInstanceOf[Sink[Any]].source = l.head.asInstanceOf[Source[Any]]
      if(l.size == 3) {
        l(1).asInstanceOf[Source[Any]].sink = l(2).asInstanceOf[Sink[Any]]
        l(2).asInstanceOf[Sink[Any]].source = l(1).asInstanceOf[Source[Any]]
      }
    })
    toBuild.last.asInstanceOf[Sink[Any]].start()
  }
}

object StreamBuilder{
  def apply[I](sc: StreamComponent): StreamBuilder[I] = new StreamBuilder(sc :: Nil)
  def apply[I](): StreamBuilder[I] = new StreamBuilder(Nil)
}
