package io.vertx.lang.scala.core

import io.vertx.core.{Promise, Vertx}
import io.vertx.lang.scala.*
import io.vertx.lang.scala.conv.ScalaFuture
import io.vertx.lang.scala.core.AbstractVerticle
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.flatspec.{AnyFlatSpec, AsyncFlatSpec}
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Seconds, Span}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class AbstractVerticleTest extends AsyncFlatSpec with Matchers {

  "AbstractVerticle" should "invoke asyncStart on start" in {
    val vertx = Vertx.vertx
    var startInvoked = false
    object TestVerticle extends AbstractVerticle {
      override def asyncStart: ScalaFuture[Unit] = Future {
        startInvoked = true
      }
    }
    vertx.deployVerticle(TestVerticle).asScala()
      .map(_ => startInvoked should be(true))
  }

  it should "invoke asyncStop on stop" in {
    val vertx = Vertx.vertx
    var stopInvoked = false
    object StopVerticle extends AbstractVerticle {
      override def asyncStop: ScalaFuture[Unit] = Future {
        stopInvoked = true
      }
    }
    vertx.deployVerticle(StopVerticle).asScala()
         .flatMap(vertx.undeploy(_).asScala())
         .map(_ => stopInvoked should be(true))
  }

  it should "fail on asyncStart failure" in {
    val vertx = Vertx.vertx
    object StartFailureVerticle extends AbstractVerticle {
      override def asyncStart: ScalaFuture[Unit] = throw new Exception("Boom!")
    }
    recoverToExceptionIf[Exception](vertx.deployVerticle(StartFailureVerticle).asScala())
         .map(ex => ex.getMessage should be("Boom!"))
  }

  it should "fail on asyncStop failure" in {
    val vertx = Vertx.vertx
    object StopFailureVerticle extends AbstractVerticle {
      override def asyncStop: ScalaFuture[Unit] = throw new Exception("Boom!")
    }
    val failingFuture = vertx.deployVerticle(StopFailureVerticle).asScala()
                             .flatMap(vertx.undeploy(_).asScala())
    recoverToExceptionIf[Exception](failingFuture)
      .map(ex => ex.getMessage should be("Boom!"))
  }

}
