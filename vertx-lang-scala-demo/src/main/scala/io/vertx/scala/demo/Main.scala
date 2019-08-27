package io.vertx.scala.demo

import io.vertx.core.Vertx
import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.scala.core._

import scala.util.{Failure, Success}

object Main {
  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx()
    implicit val ec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx
      .createHttpServer()
      .requestHandler(r => {
        r.response().end("bye")
      })
      .listenFuture(6667)
      .onComplete {
        case Success(_) => println("Started")
        case Failure(exception) => println("Failure")
      }
  }
}
