package io.vertx.lang.scala.verticle

import io.vertx.lang.scala.ScalaVerticle

import scala.concurrent.Promise

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class TestVerticle extends ScalaVerticle{

  override def start(startPromise: Promise[Unit]): Unit = {
    vertx.eventBus
      .consumer[String]("hello")
      .handler(a => a.reply("world"))
      .completionFuture()
      .foreach(c => startPromise.success(()))
  }
}
