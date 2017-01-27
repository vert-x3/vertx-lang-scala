package io.vertx.lang.scala

import java.util.concurrent.{CountDownLatch, TimeUnit}

import io.vertx.scala.core.Vertx
import org.junit.runner.RunWith
import org.scalatest.{FlatSpec, Matchers}
import org.scalatest.junit.JUnitRunner
import org.scalatest.concurrent.Waiters.{Waiter, _}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class VertxTest extends FlatSpec with Matchers {
  "Vert.x executeBlocking" should "should perform on a different thread" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val waiter = new Waiter()
    vertx.executeBlocking[Long](() => Thread.currentThread().getId).onComplete(s => {
      assert(s.get != Thread.currentThread().getId)
      waiter.dismiss()
    })
    waiter.await(dismissals(1))
  }
}
