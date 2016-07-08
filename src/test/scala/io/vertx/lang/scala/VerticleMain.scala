package io.vertx.lang.scala

import io.vertx.scala.core.Vertx


class TestVerticle extends ScalaVerticle{
  override def start(): Unit =
    vertx.createHttpServer.requestHandler(req => req.response.end("hello world")).listen(8877)
}

object VerticleMain {
  def main(args: Array[String]) {
    Vertx.vertx.deployVerticle(classOf[TestVerticle].getName, res => println)
  }
}
