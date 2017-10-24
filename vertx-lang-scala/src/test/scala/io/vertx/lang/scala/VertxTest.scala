package io.vertx.lang.scala

import java.util.concurrent.CountDownLatch

import io.vertx.scala.core.{DeploymentOptions, Vertx}
import org.junit.runner.RunWith
import org.scalatest.concurrent.Waiters.{Waiter, _}
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class VertxTest extends FlatSpec with Matchers {

  "Vert.x executeBlocking" should "should perform on a different thread" in {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx.getOrCreateContext())
    val waiter = new Waiter()
    vertx.executeBlocking[Long](() => Thread.currentThread().getId).onComplete(s => {
      assert(s.get != Thread.currentThread().getId)
      waiter.dismiss()
    })
    waiter.await(dismissals(1))
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
    implicit val ctx = VertxExecutionContext(vertx.getOrCreateContext())
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
    implicit val ctx = VertxExecutionContext(vertx.getOrCreateContext())
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
