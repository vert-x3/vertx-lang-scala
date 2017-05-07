package examples

import io.vertx.lang.scala.{ScalaVerticle, WorkerExecutorExecutionContext}
import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.lang.scala.streams.Rs._
import io.vertx.scala.core.Vertx

/**
  * A [[ScalaVerticle]] that spawns a webserver. All incoming requests go through a sync operation and reply
  * a eventbus address.
  */
class VertxStreamVerticle extends ScalaVerticle{
  override def start(): Unit = {
    implicit val wec:WorkerExecutorExecutionContext = vertx.createSharedWorkerExecutor("test")
    val logs = vertx.eventBus().sender[String]("logAddress")

    val server = vertx.createHttpServer()

    server
      .requestStream().toSource
      .process(a => logs.send("A request has arrived"))
      .sync(r => {
        Thread.sleep(400)
        (r, s"I ran on ${Thread.currentThread().getName} and waited a while")
      })
      .sink(e => e._1.response().end(e._2), 10)

    server.listen(8080)
  }
}

object VertxStreamVerticleRunner {
  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx()
    vertx.eventBus().consumer[String]("logAddress").handler(a => println(s"Received ${a.body()}"))
    vertx.deployVerticle(nameForVerticle[VertxStreamVerticle])
  }
}
