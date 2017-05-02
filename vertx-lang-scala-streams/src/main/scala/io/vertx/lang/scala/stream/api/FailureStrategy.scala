package io.vertx.lang.scala.stream.api

trait FailureStrategy {
  def onFailure(source: StreamComponent, t:Throwable): Unit
}
