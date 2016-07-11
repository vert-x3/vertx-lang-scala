package io.vertx.lang.scala

import io.vertx.core.Future
import io.vertx.scala.core.eventbus.Message

/**
  * Created by jochen on 11.07.16.
  */
class TestVerticle extends ScalaVerticle{
  override def start(startFuture: Future[Void]): Unit = {
    vertx.eventBus.consumer("hello", (in:Message[String]) => in.reply("wuhu")).completionHandler(c => startFuture.complete())
  }
}
