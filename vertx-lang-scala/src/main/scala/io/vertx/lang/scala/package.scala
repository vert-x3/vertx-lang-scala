package io.vertx.lang

import concurrent.{Future as ScalaFuture, Promise as ScalaPromise}
import util.{Try, Success, Failure}
import io.vertx.lang.scala.conv.{scalaFutureToVertxFuture, vertxFutureToScalaFuture}
import io.vertx.core.{AsyncResult, DeploymentOptions, Handler, Vertx, Future as VertxFuture, Promise as VertxPromise}
import java.util.concurrent.Callable

package object scala:

  extension[T] (vertxFuture: VertxFuture[T])
    def asScala: ScalaFuture[T] = vertxFutureToScalaFuture(vertxFuture)

  extension[T] (scalaFuture: ScalaFuture[T])
    def asVertx: VertxFuture[T] = scalaFutureToVertxFuture(scalaFuture)

  extension[T] (vertxPromise: VertxPromise[T])
    def asScala: ScalaPromise[T] =
      val scalaPromise = ScalaPromise[T]()
      vertxPromise.future
                  .onSuccess(scalaPromise.success(_))
                  .onFailure(scalaPromise.failure(_))
      scalaPromise

  extension[T] (scalaPromise: ScalaPromise[T])
    def asVertx: VertxPromise[T] =
      val vertxPromise = VertxPromise.promise[T]()
      scalaPromise.future.asVertx
                  .onSuccess(vertxPromise.complete(_))
                  .onFailure(vertxPromise.fail(_))
      vertxPromise

  /**
   * Turns a Vert.x callback function into a [[ScalaFuture]].
   * @param f the callback function; if there are more parameters than just `handler`, you may apply it partially
   */
  def handleInFuture[T](f: Handler[AsyncResult[T]] => Unit): ScalaFuture[T] =
    val promise = ScalaPromise[T]()
    f(ar => if ar.succeeded then promise.success(ar.result) else promise.failure(ar.cause))
    promise.future

  extension(asJava: Vertx)

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle): ScalaFuture[String] =
      asJava.deployVerticle(verticle.asJava).asScala

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): ScalaFuture[String] =
      asJava.deployVerticle(verticle.asJava, options).asScala

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
    def executeBlockingScala[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] =
      val c: Callable[T] = () => blockingFunction()
      asJava.executeBlocking[T](c, ordered).asScala


    /**
     * Set a default exception handler for [[io.vertx.core.Context]], set on [[io.vertx.core.Context#exceptionHandler]] at creation.     * @param handler the exception handler
     *
     * @return a reference to this, so the API can be used fluently
     */
    def exceptionHandler(handler: Option[Throwable => Unit]): Vertx =
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[Handler[java.lang.Throwable]]).orNull)

    /**
     * Like close from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture(): ScalaFuture[Unit] = asJava.close
                                                 .map((_: Void) => ())
                                                 .asScala

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: String): ScalaFuture[String] = asJava.deployVerticle(name).asScala

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: String, options: DeploymentOptions): ScalaFuture[String] =
      asJava.deployVerticle(name, options).asScala

    /**
     * Like undeploy from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def undeploy(deploymentID: String): ScalaFuture[Unit] =
      asJava.undeploy(deploymentID)
            .map(_ => ())
            .asScala
