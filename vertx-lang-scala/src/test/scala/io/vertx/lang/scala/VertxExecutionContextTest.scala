package io.vertx.lang.scala

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, FlatSpec, Matchers}

import scala.concurrent.duration.DurationLong
import scala.concurrent.{Await, Future}

@RunWith(classOf[JUnitRunner])
class VertxExecutionContextTest extends FlatSpec with Matchers with Assertions {

  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val res = Await.result(vertx.deployVerticleFuture(nameForVerticle[SuccessVerticle]), 10000 millis)
    res should not be empty
  }

  "A deployment" should "fail if the deployed verticle fails" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val exc = intercept[Exception] {
      Await.result(vertx.deployVerticleFuture(nameForVerticle[FailVerticle]), 10000 millis)
    }
    exc.getMessage should equal("wuha")
  }
}

class SuccessVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionFuture())
    ).map(_ => ())
  }
}

class FailVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      Future.failed(new java.lang.Exception("wuha")))
    ).map(_ => ())
  }
}
