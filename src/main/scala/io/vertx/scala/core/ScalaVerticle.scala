package io.vertx.scala.core

import io.vertx.core.{AbstractVerticle, Future, Verticle}

/**
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
class ScalaVerticle extends Verticle {

  protected var vertx: Vertx = null

  override def getVertx: Vertx = vertx

  override def setVertx(vertx: io.vertx.core.Vertx): Unit = this.vertx = new Vertx(vertx)

  override def stop(stopFuture: Future[Void]): Unit = stopFuture.setResult(null)

  override def start(startFuture: Future[Void]): Unit = startFuture.setResult(null)

  def asJava(): Verticle = new AbstractVerticle {

    override def setVertx(vertx: io.vertx.core.Vertx) = {
      super.setVertx(vertx)
      ScalaVerticle.this.setVertx(vertx)
    }

    override def start(startFuture: Future[Void]) = ScalaVerticle.this.start(startFuture)

    override def stop(stopFuture: Future[Void]) = ScalaVerticle.this.stop(stopFuture)
  }
}
