package io.vertx.lang.scala.testing

import io.vertx.lang.scala._
import io.vertx.lang.scala.ScalaVerticle

import scala.concurrent.{Future, Promise}

class MainVerticle extends ScalaVerticle {
  override def asyncStart: Future[Unit] =
    vertx
      .createHttpServer
      .requestHandler(req => {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      })
      .listen(8888, "0.0.0.0")
      .asScala
      .map(_ => ())
}
