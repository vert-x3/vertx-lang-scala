package io.vertx.lang.scala.stream.failurestrategy

import io.vertx.lang.scala.ScalaLogger
import io.vertx.lang.scala.stream.api.{FailureStrategy, Sink, Source, StreamComponent}

class SkipStrategy extends FailureStrategy{
  private val Log = ScalaLogger.getLogger(getClass.getName)

  override def onFailure(source: StreamComponent, t: Throwable): Unit = {
    source match {
      case sink:Sink[_] =>
        Log.warn(s"Skipping event from $source", t)
        sink.skip(1)
      case source:Source[_] =>
        Log.error(s"Source $source emitted an error", t)
    }
  }
}

object SkipStrategy {
  def apply(): SkipStrategy = new SkipStrategy()
}
