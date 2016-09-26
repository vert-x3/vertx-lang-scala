package io.vertx.lang.scala

import io.vertx.core.{AbstractVerticle, Future, Verticle}
import io.vertx.scala.core.{Context, Vertx}

import scala.concurrent.ExecutionContext
import scala.util.{Failure, Success, Try}

/**
  * Base class for verticle implementiations.
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class ScalaVerticle extends Verticle {
  protected implicit var executionContext:ExecutionContext = null
  protected var jvertx: io.vertx.core.Vertx = null
  protected var vertx: Vertx = null
  protected var ctx: Context = null

  override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
    this.jvertx = vertx
    this.vertx = new Vertx(vertx)
    this.ctx = new Context(context)
    this.executionContext = VertxExecutionContext(this.vertx.getOrCreateContext())
  }

  override def getVertx: io.vertx.core.Vertx = jvertx

  def stop(): Unit = {}

  def start(): Unit = {}

  override def stop(stopFuture: Future[Void]): Unit = {
    stop()
    stopFuture.complete()
  }

  override def start(startFuture: Future[Void]): Unit = {
    start()
    startFuture.complete()
    vertx.deployVerticleFuture("").onComplete{
      case Success(deploymentId) => startFuture.complete()
      case Failure(throwable) => startFuture.fail(throwable)
    }
  }

  def asJava(): Verticle = new AbstractVerticle {
    override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
      super.init(vertx, context)
      ScalaVerticle.this.init(vertx, context)
    }

    override def start(startFuture: Future[Void]) = ScalaVerticle.this.start(startFuture)

    override def stop(stopFuture: Future[Void]) = ScalaVerticle.this.stop(stopFuture)
  }
}
