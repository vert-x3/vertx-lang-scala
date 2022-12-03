package io.vertx.lang.scala.core

import io.vertx.core.{Context, Promise, Vertx}
import io.vertx.lang.scala.VertxExecutionContext
import io.vertx.lang.scala.conv.{ScalaFuture, ScalaPromise, VertxPromise}

import scala.concurrent.{ExecutionContext, Future}
import scala.util.{Failure, Success}

class AbstractVerticle extends io.vertx.core.AbstractVerticle {

  protected implicit var ec: ExecutionContext = _

  /**
   * Initialise the verticle.
   * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
   *
   * @param vertx   the deploying Vert.x instance
   * @param context the context of the verticle
   */
  override def init(vertx: Vertx, context: Context): Unit = {
    super.init(vertx, context)
    this.ec = VertxExecutionContext(vertx, context)
  }

  /**
   * Start the verticle.
   * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
   * <p>
   * If your verticle does things in its startup which take some time then you can override this method
   * and call the `startPromise` some time later when start up is complete.
   *
   * <strong>NOTE:</strong> Using [[asyncStart]] is recommended.
   *
   * @param startPromise a promise which should be called when verticle start-up is complete.
   */
  override def start(startPromise: VertxPromise[Void]): Unit = {
    fulfill(asyncStart, startPromise)
  }

  /**
   * Stop the verticle.
   * <p>
   * This is called by Vert.x when the verticle instance is un-deployed. Don't call it yourself.
   * If your verticle does things in its shut-down which take some time then you can override this method
   * and call the `stopPromise` some time later when clean-up is complete.
   *
   * <strong>NOTE:</strong> Using [[asyncStop]] is recommended.
   *
   * @param stopPromise a promise which should be called when verticle clean-up is complete.
   */
  override def stop(stopPromise: VertxPromise[Void]): Unit = {
    fulfill(asyncStop, stopPromise)
  }

  private def fulfill(future: ScalaFuture[Unit], promise: VertxPromise[Void]): Unit = {
    future onComplete {
      case Success(_)  => promise.complete()
      case Failure(ex) => promise.fail(ex)
    }
  }

  /**
   * Start the verticle.
   * This is called by Vert.x when the verticle instance is deployed. Don't call it yourself.
   * <p>
   * If your verticle does things in its startup which take some time then you can override this method
   * and returns a [[ScalaFuture]] completed with the start up is complete. Propagating a failure fails the deployment
   * of the verticle
   *
   * @return a [[ScalaFuture]] completed when the start up completes, or failed if the verticle cannot be started.
   */
  def asyncStart: ScalaFuture[Unit] = Future.unit

  /**
   * Stop the verticle.
   * <p>
   * This is called by Vert.x when the verticle instance is un-deployed. Don't call it yourself.
   *
   * If your verticle does things in its shut-down which take some time then you can override this method
   * and returns a [[ScalaFuture]] completed when the clean-up is complete.
   *
   * @return a [[ScalaFuture]], completed when the clean-up completes, or failed if the verticle cannot be stopped gracefully.
   */
  def asyncStop: ScalaFuture[Unit] = Future.unit

}
