package io.vertx.lang.scala

import io.vertx.core.{AbstractVerticle, Future, Verticle}
import io.vertx.scala.core.{Context, Vertx}

class ScalaVerticle extends Verticle {

  protected var jvertx: io.vertx.core.Vertx = null
  // TODO: we need an asJava() method to get the java version
  protected var vertx: Vertx = null
  protected var ctx: Context = null

  override def init(vertx: io.vertx.core.Vertx, context: io.vertx.core.Context): Unit = {
    this.jvertx = vertx
    this.vertx = new Vertx(vertx)
    this.ctx = new Context(context)
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
