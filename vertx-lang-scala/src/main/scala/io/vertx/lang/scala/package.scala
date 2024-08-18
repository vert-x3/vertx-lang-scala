package io.vertx.lang

import concurrent.{Future => ScalaFuture, Promise => ScalaPromise}
import util.{Try, Success, Failure}
import io.vertx.lang.scala.conv.{scalaFutureToVertxFuture, vertxFutureToScalaFuture, VertxFuture}
import io.vertx.core.{AsyncResult, DeploymentOptions, Handler, Vertx, Promise => VertxPromise}

package object scala {

  implicit class VertxFutureConverter[T](vertxFuture: VertxFuture[T]) {
    def asScala: ScalaFuture[T] = vertxFutureToScalaFuture(vertxFuture)
  }

  implicit class FutureConverter[T](scalaFuture: ScalaFuture[T]) {
    def asVertx: VertxFuture[T] = scalaFutureToVertxFuture(scalaFuture)
  }

  implicit class PromiseConverter[T](vertxPromise: VertxPromise[T]) {
    def asScala: ScalaPromise[T] = {
      val scalaPromise = ScalaPromise[T]()
      vertxPromise.future
        .onSuccess(scalaPromise.success(_))
        .onFailure(scalaPromise.failure(_))
      scalaPromise
    }
  }

  implicit class ScalaPromiseConverter[T](scalaPromise: ScalaPromise[T]) {
    def asVertx: VertxPromise[T] = {
      val vertxPromise = VertxPromise.promise[T]()
      scalaPromise.future.asVertx
        .onSuccess(vertxPromise.complete(_))
        .onFailure(vertxPromise.fail(_))
      vertxPromise
    }
  }

  /**
   * Turns a Vert.x callback function into a [[ScalaFuture]].
   * @param f the callback function; if there are more parameters than just `handler`, you may apply it partially
   */
  def handleInFuture[T](f: Handler[AsyncResult[T]] => Unit): ScalaFuture[T] = {
    val promise = ScalaPromise[T]()
    f(ar => if (ar.succeeded) promise.success(ar.result) else promise.failure(ar.cause))
    promise.future
  }

  implicit class VertxScala(val asJava: Vertx) extends AnyVal {
    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle): ScalaFuture[String] = {
      asJava.deployVerticle(verticle.asJava).asScala
    }

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): ScalaFuture[String] = {
      asJava.deployVerticle(verticle.asJava, options).asScala
    }

    /**
     * Safely execute some blocking code.
     *
     * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
     *
     * When the code is complete the returned Future will be completed with the result.
     *
     * @param blockingFunction function containing blocking code
     * @param ordered          if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
     * @return a Future representing the result of the blocking operation
     */
    def executeBlockingScala[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
      val h: Handler[VertxPromise[T]] = { p =>
        Try(blockingFunction()) match {
          case Success(s) => p.complete(s)
          case Failure(t) => p.fail(t)
        }
      }
      asJava.executeBlocking[T](h, ordered).asScala
    }

    /**
     * Set a default exception handler for [[io.vertx.core.Context]], set on [[io.vertx.core.Context#exceptionHandler]] at creation.
     * * @param handler the exception handler
     *
     * @return a reference to this, so the API can be used fluently
     */
    def exceptionHandler(handler: Option[Throwable => Unit]): Vertx =
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[Handler[java.lang.Throwable]]).orNull)

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: String): ScalaFuture[String] = asJava.deployVerticle(name).asScala

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: String, options: DeploymentOptions): ScalaFuture[String] =
      asJava.deployVerticle(name, options).asScala
  }
}
