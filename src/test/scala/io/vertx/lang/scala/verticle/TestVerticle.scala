package io.vertx.lang.scala.verticle

import io.vertx.core.Future
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.Types._

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class TestVerticle extends ScalaVerticle{
  override def start(startFuture: Future[Void]): Unit = {
    vertx.eventBus
      .consumer[String]("hello")
      .handler(a => a.reply("world"))
      .completionFuture()
      .foreach(c => startFuture.complete())
  }
}
