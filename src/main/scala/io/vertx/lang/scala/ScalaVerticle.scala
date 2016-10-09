package io.vertx.lang.scala

import io.vertx.core.{AbstractVerticle, Future, Verticle}
import io.vertx.scala.core.{Context, Vertx}

import scala.concurrent.{ExecutionContext, Promise}
import scala.util.{Failure, Success}

/**
  * Base class for verticle implementiations.
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
class ScalaVerticle {
  protected implicit var executionContext:ExecutionContext = _
  protected var vertx: Vertx = _
  protected var ctx: Context = _

  def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
    this.vertx = new Vertx(vertx)
    this.ctx = new Context(context)
    this.executionContext = VertxExecutionContext(this.vertx.getOrCreateContext())
  }

  def stop(): Unit = {}

  def start(): Unit = {}

  def stop(stopPromise: concurrent.Promise[Unit]): Unit = {
    println("WUWUU1")
    stop()
    stopPromise.complete(Success())
  }

  def start(startPromise: concurrent.Promise[Unit]): Unit = {
    println("WUWUU2")
    start()
    startPromise.complete(Success())
  }

  def asJava(): Verticle = new AbstractVerticle {
    val that = ScalaVerticle.this
    override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
      super.init(vertx, context)
      ScalaVerticle.this.init(vertx, context)
    }

    override def start(startFuture: Future[Void]) = {
      val promise = Promise[Unit]()
      promise.future.onComplete{
        case Success(_) => startFuture.complete()
        case Failure(throwable) => startFuture.fail(throwable)
      }
      that.start(promise)
    }

    override def stop(stopFuture: Future[Void]) = {
      val promise = Promise[Unit]()
      promise.future.onComplete{
        case Success(_) => stopFuture.complete()
        case Failure(throwable) => stopFuture.fail(throwable)
      }
      that.stop(promise)
    }
  }
}
