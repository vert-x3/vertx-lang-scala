package io.vertx.lang.scala.verticle

import io.vertx.core.json.Json
import io.vertx.lang.scala.ScalaVerticle._
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.concurrent.ScalaFutures.whenReady
import org.scalatest.junit.JUnitRunner
import org.scalatest.{AsyncFlatSpec, Matchers}

import scala.concurrent.{Future, Promise}

@RunWith(classOf[JUnitRunner])
class JsonToCaseClassTest extends AsyncFlatSpec with Matchers{

  "An encoded case class sent through the eventbus" should "decode back to the case class" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[Hello]
    vertx.eventBus()
      .localConsumer[String]("startMethod")
      .handler(m => {
        println(m.body())
        result.success(Json.decodeValue(m.body(), classOf[Hello]))
      })
    vertx.deployVerticle(nameForVerticle[JsonVerticle])
    whenReady(result.future) {_ should equal(Hello("hallo"))}
  }
}

class JsonVerticle extends ScalaVerticle{
  override def startFuture(): Future[Unit] = {
    vertx.eventBus
      .send("startMethod", Json.encode(Hello("hallo")))
    Future.successful()
  }
}

case class Hello(msg: String)
