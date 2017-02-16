package io.vertx.lang.scala

import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Assertions, AsyncFlatSpec, Matchers}

import scala.concurrent.Future
import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class VertxExecutionContextTest extends AsyncFlatSpec with Matchers with Assertions {

  "Using Promise to complete a Vertx-Future" should "work with a VertxExecutionContext" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[SuccessVerticle])
      .map(res => res should not be empty)
  }

  "A deployment" should "fail if the deployed verticle fails" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[FailVerticle])
      .transformWith {
        case Failure(t) => t.getMessage should equal("wuha")
        case Success(_) => fail("Deployment shouldn't succeed!")
      }
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
