package io.vertx.lang.scala.verticle

import io.vertx.lang.scala.ScalaVerticle

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class TestVerticle extends ScalaVerticle{

  override def startFuture(): Future[Unit] = {
    Future.successful(())
    val promise = Promise[Unit]()
    vertx.eventBus
      .consumer[String]("hello")
      .handler(a => a.reply("world"))
      .completionFuture()
      .onComplete{
        case Success(_) => promise.success(())
        case Failure(t) => promise.failure(t)
      }
    promise.future
  }
}
