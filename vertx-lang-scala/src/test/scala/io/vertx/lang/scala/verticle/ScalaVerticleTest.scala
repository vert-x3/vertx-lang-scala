package io.vertx.lang.scala.verticle

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}
import io.vertx.lang.scala.ScalaVerticle._
import io.vertx.lang.scala.VertxExecutionContext

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends FlatSpec with Matchers {

  "TestVerticle" should "reply to a hello message" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    vertx.deployVerticleFuture(nameForVerticle[TestVerticle]).onComplete(t => cl.countDown())
    cl.await()
    val cl2 = new CountDownLatch(1)
    vertx.eventBus.sendFuture[String]("hello", "msg").onComplete(t => cl2.countDown())
    assert(cl2.await(100, TimeUnit.MILLISECONDS), "No answer within 100 ms")
  }
}
