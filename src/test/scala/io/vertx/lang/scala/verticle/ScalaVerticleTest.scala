package io.vertx.lang.scala.verticle

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends FlatSpec with Matchers {

  "TestVerticle" should "reply to a hello message" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    vertx.deployVerticleWithHandler(classOf[TestVerticle].getName)(r => cl.countDown())
    val delay = cl.await(100, TimeUnit.MILLISECONDS)
    assert(delay, "Deploy took longer than 100 ms")
    val cl2 = new CountDownLatch(1)
    vertx.eventBus.sendWithHandler[String]("hello", "msg")( r => cl2.countDown())
    assert(cl2.await(100, TimeUnit.MILLISECONDS), "No answer within 100 ms")
  }
}
