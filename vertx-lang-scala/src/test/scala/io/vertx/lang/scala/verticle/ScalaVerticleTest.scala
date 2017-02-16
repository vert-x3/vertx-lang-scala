package io.vertx.lang.scala.verticle

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{AsyncFlatSpec, FlatSpec, Matchers}
import io.vertx.lang.scala.ScalaVerticle._
import io.vertx.lang.scala.VertxExecutionContext

import scala.util.{Failure, Success}

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends AsyncFlatSpec with Matchers {

  "TestVerticle" should "reply to a hello message" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[TestVerticle])
      .transformWith{
        case Failure(t) => fail(t)
        case Success(_) => vertx.eventBus.sendFuture[String]("hello", "msg")
      }
      .map(res => res.body() should equal("world"))
  }

  "nameForVerticle" should "generate the correct name to deploy a ScalaVerticle" in {
    nameForVerticle[TestVerticle] should equal("scala:io.vertx.lang.scala.verticle.TestVerticle")
  }
}
