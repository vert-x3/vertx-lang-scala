package io.vertx.lang.scala.verticle

import io.vertx.scala.core._
import io.vertx.core.Vertx
import org.junit.runner.RunWith
import org.scalatestplus.junit.JUnitRunner
import org.scalatest.{AsyncFlatSpec, Matchers}
import io.vertx.lang.scala.ScalaVerticle._
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.concurrent.ScalaFutures.whenReady
import org.scalatest.time.{Millis, Seconds, Span}

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends AsyncFlatSpec with Matchers with ScalaFutures{

  implicit val defaultPatience =
    PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  "StartFutureVerticle" should "use startFuture to start" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("startMethod")
      .handler(m => result.success(m.body()))
    vertx.deployVerticle(nameForVerticle[StartFutureVerticle])
    whenReady(result.future) {_ should equal("startFuture")}
  }

  "StartVerticle" should "use start to start" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("startMethod")
      .handler(m => result.success(m.body()))

    vertx.deployVerticle(nameForVerticle[StartFutureVerticle])
    whenReady(result.future) {_ should equal("startFuture")}
  }

  "StartFailVerticle" should "fail correctly if start throws an exception" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val result = Promise[String]

    vertx.deployVerticleFuture(nameForVerticle[StartFailVerticle])
      .transformWith{
        case Success(_) => fail("Shouldn't succeed")
        case Failure(t) => t.getMessage should equal("Failed in start")
      }
  }

  "StopFutureVerticle" should "use stopFuture to stop" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("stopMethod")
      .handler(m => result.success(m.body()))

    vertx.deployVerticleFuture(nameForVerticle[StopFutureVerticle])
        .map(depId => vertx.undeploy(depId))
    whenReady(result.future) {_ should equal("stopFuture")}
  }

  "StopVerticle" should "use stop to stop" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val result = Promise[String]
    vertx.eventBus()
      .localConsumer[String]("stopMethod")
      .handler(m => result.success(m.body()))

    vertx.deployVerticleFuture(nameForVerticle[StopVerticle])
      .map(depId => vertx.undeploy(depId))
    whenReady(result.future) {_ should equal("stop")}
  }

  "StopFailVerticle" should "fail correctly if stop throws an exception" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())

    vertx.deployVerticleFuture(nameForVerticle[StopFailVerticle])
      .transformWith{
        case Success(s) => vertx.undeployFuture(s)
      }
      .transformWith{
        case Failure(t) => t.getMessage should equal("Failed in stop")
      }
  }

  "nameForVerticle" should "generate the correct name to deploy a ScalaVerticle" in {
    nameForVerticle[StartFutureVerticle] should equal("scala:io.vertx.lang.scala.verticle.StartFutureVerticle")
  }
}

class StartFutureVerticle extends ScalaVerticle{
  override def startFuture(): Future[Unit] = {
    vertx.eventBus
      .send("startMethod", "startFuture")
    Future.successful()
  }
}

class StartVerticle extends ScalaVerticle{
  override def start(): Unit = {
    vertx.eventBus
      .send("startMethod", "start")
  }
}
class StartFailVerticle extends ScalaVerticle{
  override def start(): Unit = {
    throw new RuntimeException("Failed in start")
  }
}

class StopFutureVerticle extends ScalaVerticle{
  override def stopFuture(): Future[Unit] = {
    vertx.eventBus
      .send("stopMethod", "stopFuture")
    Future.successful()
  }
}

class StopVerticle extends ScalaVerticle{
  override def stop(): Unit = {
    vertx.eventBus
      .send("stopMethod", "stop")
  }
}

class StopFailVerticle extends ScalaVerticle{
  override def stop(): Unit = {
    throw new RuntimeException("Failed in stop")
  }
}
