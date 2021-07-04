package io.vertx.lang.scala.verticle

import io.vertx.lang.scala._
import io.vertx.core.Vertx
import io.vertx.lang.scala.ScalaVerticle._
import io.vertx.lang.scala.{ScalaVerticle, VertxExecutionContext}
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}

import scala.concurrent.{Future, Promise}
import scala.util.{Failure, Success}

class ScalaVerticleTest extends AsyncFlatSpec with Matchers with ScalaFutures {

  implicit val defaultPatience =
    PatienceConfig(timeout = Span(5, Seconds), interval = Span(500, Millis))

  "StartFutureVerticle" should "use startFuture to start" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())

    val result = Promise[String]()
    vertx.eventBus()
      .localConsumer[String]("startMethod")
      .handler(m => result.success(m.body()))
    vertx.deployVerticle(nameForVerticle[StartFutureVerticle]())
    whenReady(result.future) {_ should equal("startFuture")}
  }

  "StartVerticle" should "use start to start" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())

    val result = Promise[String]()
    vertx.eventBus()
      .localConsumer[String]("startMethod")
      .handler(m => result.success(m.body()))

    vertx.deployVerticle(nameForVerticle[StartFutureVerticle]())
    whenReady(result.future) {_ should equal("startFuture")}
  }

  "StartFailVerticle" should "fail correctly if start throws an exception" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val result = Promise[String]()

    vertx.deployVerticle(nameForVerticle[StartFailVerticle]())
      .asScala()
      .transformWith{
        case Success(_) => fail("Shouldn't succeed")
        case Failure(t) => t.getMessage should equal("Failed in start")
      }
  }

  "StopFutureVerticle" should "use stopFuture to stop" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val result = Promise[String]()
    vertx.eventBus()
      .localConsumer[String]("stopMethod")
      .handler(m => result.success(m.body())
      )

    vertx.deployVerticle(nameForVerticle[StopFutureVerticle]())
      .asScala()
      .map(depId => vertx.undeploy(depId))
    whenReady(result.future) {_ should equal("stopFuture")}
  }

  "StopVerticle" should "use stop to stop" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val result = Promise[String]()
    vertx.eventBus()
      .localConsumer[String]("stopMethod")
      .handler(m => result.success(m.body()))

    vertx.deployVerticle(nameForVerticle[StopVerticle]())
      .asScala()
      .map(depId => vertx.undeploy(depId))
    whenReady(result.future) {_ should equal("stop")}
  }

  "StopFailVerticle" should "fail correctly if stop throws an exception" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())

    vertx.deployVerticle(nameForVerticle[StopFailVerticle]())
      .asScala()
      .transformWith{
        case Success(s) => vertx.undeploy(s).asScala()
        case Failure(t) => Future.failed(t)
      }
      .transformWith{
        case Failure(t) => t.getMessage should equal("Failed in stop")
        case Success(_) => fail("This should have failed")
      }
  }

  "nameForVerticle" should "generate the correct name to deploy a ScalaVerticle" in {
    nameForVerticle[StartFutureVerticle]() should equal("scala:io.vertx.lang.scala.verticle.StartFutureVerticle")
  }
}

class StartFutureVerticle extends ScalaVerticle{

  override def start(promise: Promise[Unit]): Unit = {
    vertx.eventBus
      .send("startMethod", "startFuture")
    promise.complete(Success())
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

  /**
   * Stop the verticle.
   */
  override def stop(promise: Promise[Unit]): Unit = {
    vertx.eventBus
      .send("stopMethod", "stopFuture")
    promise.complete(Success())
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
