package io.vertx.lang.scala.json

import io.vertx.core.Future
import io.vertx.lang.scala.ScalaVerticle

/**
  * Created by jochen on 07.07.16.
  */
class TestVerticle extends ScalaVerticle{
  override def start(startFuture: Future[Void]): Unit = {
    println("DOOONE")
    vertx.createHttpServer.requestHandler(req => req.response.end("hello world")).listen(8877, println)
    startFuture.complete()
  }
}
