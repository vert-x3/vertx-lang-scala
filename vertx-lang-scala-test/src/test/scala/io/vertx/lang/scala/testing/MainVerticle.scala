package io.vertx.lang.scala.testing

import io.vertx.lang.scala.{ScalaVerticle, *}
import io.vertx.lang.scala.json.Json
import io.vertx.ext.web.Router

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class MainVerticle extends ScalaVerticle:

  val log: Logger = LoggerFactory.getLogger(classOf[MainVerticle])

  override def asyncStart: Future[Unit] =
    log.debug("asyncStart!")
    val router = Router.router(vertx)
    router.get("/ping").handler(_.json(Json.obj("""{ "message": "pong" }""")))
    router.route.handler(_.response.putHeader("content-type", "text/plain").end("Hello from Vert.x!"))
    vertx
      .createHttpServer
      .requestHandler(router)
      .listen(8888, "0.0.0.0")
      .map(_ => ())
      .asScala
