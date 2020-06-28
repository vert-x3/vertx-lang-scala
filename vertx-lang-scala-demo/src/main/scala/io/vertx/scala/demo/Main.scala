package io.vertx.scala.demo

import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.scala.core._
import io.vertx.scala.ext.web._

import scala.util.{Failure, Success}

object Main {
  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx()
    val router = Router.router(vertx)
    router.get("/").handler(r => r.end("hello world"))

    implicit val ec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx
      .createHttpServer()
      .requestHandler(router)
      .listenFuture(6667)
      .onComplete {
        case Success(_) => println("Started")
        case Failure(exception) => println("Failure")
      }
  }
}
