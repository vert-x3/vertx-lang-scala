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

  "Transforming events in a Verticle " should "work" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("result")
      .handler(m => result.success(m.body()))

    vertx
      .deployVerticleFuture(nameForVerticle[NiceApiVerticle])
      .map(s => vertx.eventBus().send("testAddress", "World"))
    result.future.map(r => r should equal("Hello World"))
  }

}

class NiceApiVerticle extends ScalaVerticle {
  override def startFuture() = {
    val consumer = vertx.eventBus().consumer[String]("testAddress")
    val producer = vertx.eventBus().sender[String]("result")

    consumer.bodyStream()
      .toSource
      .map((a:String) => s"Hello $a")
      .sink(producer.toSink())

    consumer.completionFuture()
  }
}
