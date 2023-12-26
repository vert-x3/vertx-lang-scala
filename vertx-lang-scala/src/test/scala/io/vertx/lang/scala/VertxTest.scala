package io.vertx.lang.scala

import io.vertx.core.{DeploymentOptions, ThreadingModel, Vertx}
import org.scalatest.concurrent.PatienceConfiguration.Timeout
import org.scalatest.concurrent.Waiters.{Waiter, *}
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers
import org.scalatest.time.{Millis, Span}

import scala.util.{Failure, Success}

/**
  * @author <a href="mailto:jochen@codepitbull.de">Jochen Mader</a
  */
class VertxTest extends AnyFlatSpec, Matchers:

  "Vert.x executeBlocking" should "should perform on a different thread" in {
    val vertx = Vertx.vertx
    given exec: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    vertx.executeBlockingScala[Long](() => Thread.currentThread().getId).onComplete(s => {
      assert(s.get != Thread.currentThread().getId)
      Thread.sleep(1000)
      waiter.dismiss()
    })
    waiter.await(Timeout(Span(1100, Millis)), dismissals(1))
  }

  "Vert.x" should "deploy a pre-instantiated ScalaVerticle with DefaultOptions" in {
    val vertx = Vertx.vertx()
    val waiter = new Waiter()
    vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        waiter.dismiss()
      }
    })
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a pre-instantiated ScalaVerticle using the provided options" in {
    val vertx = Vertx.vertx()
    val waiter = new Waiter()
    vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        if(this.vertx.getOrCreateContext().isWorkerContext) {
          waiter.dismiss()
        }
      }
    }, new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER))
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a pre-instantiated ScalaVerticle and return a Future" in {
    val vertx = Vertx.vertx()
    given ctx: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    val futureWaiter = new Waiter()

    val future = vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        waiter.dismiss()
      }
    })
    future.onComplete {
      case Success(_) => futureWaiter.dismiss()
      case Failure(t) => t.printStackTrace()
    }
    futureWaiter.await(dismissals(1))
    waiter.await(dismissals(1))
  }

  "Vert.x" should "deploy a preinstantiated ScalaVerticle using the provided options and return a Future" in {
    val vertx = Vertx.vertx()
    given ctx: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    val waiter = new Waiter()
    val futureWaiter = new Waiter()

    val future = vertx.deployVerticle(new ScalaVerticle {
      override def start(): Unit = {
        if(this.vertx.getOrCreateContext().isWorkerContext) {
          waiter.dismiss()
        }
      }
    }, new DeploymentOptions().setThreadingModel(ThreadingModel.WORKER))
    future.onComplete {
      case Success(_) => futureWaiter.dismiss()
      case Failure(t) => t.printStackTrace()
    }
    futureWaiter.await(dismissals(1))
    waiter.await(dismissals(1))
  }
