package io.vertx.lang.scala.testing

import io.vertx.lang.scala.{ScalaVerticle, _}

import scala.concurrent.Promise
import scala.util.{Failure, Success}

class MainVerticle extends ScalaVerticle{
  override def start(promise: Promise[Unit]): Unit = {
    vertx
      .createHttpServer()
      .requestHandler(req => {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      })
      .listen(8888, "0.0.0.0")
      .asScala()
      .onComplete{
        case Success(_) => promise.complete(Success(()))
        case Failure(e) => promise.complete(Failure(e))
      }
  }
}
