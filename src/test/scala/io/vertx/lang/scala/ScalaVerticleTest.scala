package io.vertx.lang.scala

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.core.Future
import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScalaVerticleTest extends FlatSpec with Matchers {
  val cl = new CountDownLatch(1)
  val vertx = Vertx.vertx
  vertx.deployVerticle(classOf[TestVerticle].getName, res => cl.countDown())
  val delay = cl.await(1000, TimeUnit.MILLISECONDS)
  "Deployment of ScalaVerticle" should "succeed in less than a second" in {
    assert(delay)
  }

  "Blu of ScalaVerticle" should "succeed in less than a second" in {
    val cl2 = new CountDownLatch(1)
    val t = (t: io.vertx.core.AsyncResult[io.vertx.core.eventbus.Message[String]]) => {println}
    vertx.eventBus.send[String]("hello", "msg", t)
    cl2.await(1000, TimeUnit.MILLISECONDS)
    println("success")
  }

  class TestVerticle extends ScalaVerticle{
    override def start(startFuture: Future[Void]): Unit = {
      vertx.eventBus.consumer[String]("hello")
        .handler(in => in.reply("world"))
        .completionHandler(c => startFuture.complete())
    }
  }
}
