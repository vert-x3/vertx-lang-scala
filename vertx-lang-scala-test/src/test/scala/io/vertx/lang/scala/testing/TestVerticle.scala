package io.vertx.lang.scala.testing

import io.vertx.ext.web.Router
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.json.json
import io.vertx.lang.scala.*
import org.slf4j.{Logger, LoggerFactory}

import scala.concurrent.Future
import scala.language.implicitConversions

class TestVerticle extends ScalaVerticle:

  val log: Logger = LoggerFactory.getLogger(classOf[TestVerticle])

  override def asyncStart: Future[Unit] =
    log.debug("asyncStart!")
    val router = Router.router(vertx)
    router
      .get("/ping")
      .handler(_.json(json"""{ "message": "pong" }"""))
    router
      .get("/hello")
      .handler(_.response.putHeader("content-type", "text/plain").end("Hello from Vert.x!"))
    router
      .delete("/account")
      .handler(_.json(json"""{ "message":  "ok" }"""))
    vertx.createHttpServer
      .requestHandler(router)
      .listen(8888, "0.0.0.0")
      .mapEmpty
