package io.vertx.lang.scala.verticle

import io.vertx.core.Future
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.scala.core.eventbus.Message

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class TestVerticle extends ScalaVerticle{
  override def start(startFuture: Future[Void]): Unit = {
    vertx.eventBus.consumer("hello", (in:Message[String]) => in.reply("wuhu")).completionHandler(c => startFuture.complete())
  }
}
