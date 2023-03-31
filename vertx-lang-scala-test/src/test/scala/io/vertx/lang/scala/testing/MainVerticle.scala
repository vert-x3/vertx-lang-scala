package io.vertx.lang.scala.testing

import io.vertx.lang.scala.{ScalaVerticle, *}

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainVerticle extends ScalaVerticle:

  val log: Logger = LoggerFactory.getLogger(classOf[MainVerticle])

  override def asyncStart: Future[Unit] =
    log.debug("asyncStart!")
    vertx
      .createHttpServer
      .requestHandler(req => {
        req.response()
          .putHeader("content-type", "text/plain")
          .end("Hello from Vert.x!")
      })
      .listen(8888, "0.0.0.0")
      .map(_ => ())
      .asScala
