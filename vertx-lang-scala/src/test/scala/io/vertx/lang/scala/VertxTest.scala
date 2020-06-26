package io.vertx.lang.scala

import java.util.concurrent.CountDownLatch

import io.vertx.core.Vertx
import io.vertx.scala.core._
import org.scalatest.FlatSpec
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.concurrent.Waiters.{Waiter, _}
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Span}

import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
class VertxTest extends FlatSpec with Matchers {

  "Vert.x executeBlocking" should "should perform on a different thread" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    vertx.executeBlockingFuture[Long](() => Thread.currentThread().getId).onComplete(s => {
      assert(s.get != Thread.currentThread().getId)
      Thread.sleep(1000)
      waiter.dismiss()
    })
    waiter.await(Timeout(Span(1100, Millis)), dismissals(1))
  }

  "Vert.x" should "deploy a preinstantiated ScalaVerticle with DefaultOptions" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx()
    val waiter = new Waiter()
    vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        waiter.dismiss()
      }
    })
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a preinstantiated ScalaVerticle using the provided options" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx()
    val waiter = new Waiter()
    vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        if(vertx.getOrCreateContext().isWorkerContext()) {
          waiter.dismiss()
        }
      }
    }, DeploymentOptions().setWorker(true))
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a preinstantiated ScalaVerticle and return a Future" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx()
    implicit val ctx = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    val futureWaiter = new Waiter()

    val future = vertx.deployVerticleFuture(new ScalaVerticle {
      override def start(): Unit = {
        waiter.dismiss()
      }
    })
    future.onComplete {
      case Success(s) => futureWaiter.dismiss()
      case Failure(t) => t.printStackTrace()
    }
    futureWaiter.await(dismissals(1))
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a preinstantiated ScalaVerticle using the provided options and return a Future" in {
    val cl = new CountDownLatch(1)
    val vertx = Vertx.vertx()
    implicit val ctx = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    val futureWaiter = new Waiter()

    val future = vertx.deployVerticleFuture(new ScalaVerticle {
      override def start(): Unit = {
        if(vertx.getOrCreateContext().isWorkerContext()) {
          waiter.dismiss()
        }
      }
    }, DeploymentOptions().setWorker(true))
    future.onComplete {
      case Success(s) => futureWaiter.dismiss()
      case Failure(t) => t.printStackTrace()
    }
    futureWaiter.await(dismissals(1))
    waiter.await(dismissals(1))
  }
}
