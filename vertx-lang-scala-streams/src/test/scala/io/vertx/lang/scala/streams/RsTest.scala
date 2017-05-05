package io.vertx.lang.scala.streams

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.lang.scala.streams.Rs._
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.concurrent.Promise

@RunWith(classOf[JUnitRunner])
class RsTest extends AsyncFlatSpec with Matchers with Assertions {

  "Transforming events in a stream" should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val sinkAddress = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("sinkAddress")
      .handler(m => sinkAddress.success(m.body()))

    vertx
      .deployVerticleFuture(nameForVerticle[NiceApiVerticle])
      .map(s => vertx.eventBus().send("sourceAddress", "World"))
    sinkAddress.future.map(r => r should equal("Hello World"))
  }

  "Using Futures in a stream" should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val sinkAddress = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("sinkAddress")
      .handler(m => sinkAddress.success(m.body()))

    vertx.eventBus()
      .localConsumer[String]("stageAddress")
      .handler(m => m.reply(s"saw ${m.body()}"))

    vertx
      .deployVerticleFuture(nameForVerticle[FutureTestVerticle])
      .map(s => vertx.eventBus().send("sourceAddress", "World"))
    sinkAddress.future.map(r => r should equal("saw World"))
  }

}

class NiceApiVerticle extends ScalaVerticle {
  override def startFuture() = {
    val consumer = vertx.eventBus().consumer[String]("sourceAddress")
    val producer = vertx.eventBus().sender[String]("sinkAddress")

    consumer.bodyStream()
      .toSource
      .map((a:String) => s"Hello $a")
      .sink(producer.toSink())

    consumer.completionFuture()
  }
}

class FutureTestVerticle extends ScalaVerticle {
  override def startFuture() = {
    val consumer = vertx.eventBus().consumer[String]("sourceAddress")
    val producer = vertx.eventBus().sender[String]("sinkAddress")

    consumer.bodyStream()
      .toSource
      .future((a:String) => vertx.eventBus().sendFuture[String]("stageAddress", a))
      .map(a => a.body())
      .sink(producer.toSink())

    consumer.completionFuture()
  }
}
