package io.vertx.lang.scala

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.core.AsyncResult
import io.vertx.core.eventbus.Message
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends FlatSpec with Matchers {

  "TestVerticle" should "reply to a hello message" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    vertx.deployVerticle(classOf[TestVerticle].getName, res => cl.countDown())
    val delay = cl.await(100, TimeUnit.MILLISECONDS)
    assert(delay, "Deploy took longer than 100 ms")
    val cl2 = new CountDownLatch(1)
    vertx.eventBus.send[String]("hello", "msg", (reply:AsyncResult[Message[String]]) => {
      cl2.countDown()
    })
    assert(cl2.await(100, TimeUnit.MILLISECONDS), "No answer within 100 ms")
  }
}
