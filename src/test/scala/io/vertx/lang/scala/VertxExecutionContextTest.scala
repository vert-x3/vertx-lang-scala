package io.vertx.lang.scala

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.core.Future
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.concurrent.Promise

@RunWith(classOf[JUnitRunner])
class VertxExecutionContextTest extends FlatSpec with Matchers {
  val vertx = Vertx
  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    vertx.deployVerticleWithHandler(classOf[PromiseTestVerticle].getName)(r => cl.countDown())
    val delay = cl.await(100, TimeUnit.MILLISECONDS)
    assert(delay, "Deploy took longer than 100 ms")
  }
}

class PromiseTestVerticle extends ScalaVerticle {

  override def start(startFuture: Future[Void]): Unit = {
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val p1 = Promise[String]()
    val f1 = p1.future
    val p2 = Promise[String]()
    val f2 = p2.future

    vertx.eventBus().consumerWithHandler[String]("asd")(a => println(a)).completionHandler(a => p1.success("1"))
    vertx.eventBus().consumerWithHandler[String]("asd2")(a => println(a)).completionHandler(a => p2.success("2"))
    val res = for {
      a1 <- f1
      a2 <- f2
    } yield (a1 + " " + a2)
    res.map(a => startFuture.complete())
  }
}
