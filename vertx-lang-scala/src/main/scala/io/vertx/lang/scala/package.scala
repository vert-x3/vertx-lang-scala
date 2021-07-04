package io.vertx.lang

import io.vertx.lang.scala.conv.{ScalaFuture, ScalaOption, ScalaPromise, ScalaSuccess, newPromise, scalaFutureToVertxFuture, succScalaSuccess, vertxFutureToScalaFuture}
import io.vertx.core.{AsyncResult, DeploymentOptions, Handler, Future => VertxFuture, Promise => VertxPromise}

package object scala {

  implicit class VertxFutureConverter[T](vertxFuture: VertxFuture[T]) {
    def asScala(): ScalaFuture[T] = vertxFutureToScalaFuture(vertxFuture)
  }

  implicit class FutureConverter[T](future: ScalaFuture[T]) {
    def asVertx(): VertxFuture[T] = scalaFutureToVertxFuture(future)
  }

  implicit class PromiseConverter[T](promise: ScalaPromise[T]) {
    def asVertx(): VertxPromise[T] = {
      new VertxPromise[T] {
        override def tryComplete(result: T): Boolean = promise.tryComplete(succScalaSuccess(result))

        override def tryFail(cause: Throwable): Boolean = promise.tryFailure(cause)

        override def future(): VertxFuture[T] = scalaFutureToVertxFuture(promise.future)
      }
    }
  }

  implicit class ScalaPromiseConverter[T](promise: VertxPromise[T])(implicit executor: VertxExecutionContext) {
    def asScala(): ScalaPromise[T] = {
      val scalaPromise = newPromise[T]()

      scalaPromise.future.onComplete(scalaTry => {
        //Not doing pattern matching because of import shenanigans when
        // getting stuff from scala-package
        try {
          promise.complete(scalaTry.get)
        } catch {
          case e: Throwable => promise.fail(e)
        }
      })

      scalaPromise
    }
  }

  implicit class VertxScala(val asJava: io.vertx.core.Vertx) extends AnyVal {

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle): ScalaFuture[String] = {
      val promise = concurrent.Promise[String]()
      asJava.deployVerticle(verticle.asJava(), {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): ScalaFuture[String] = {
      val promise = concurrent.Promise[String]()
      asJava.deployVerticle(verticle.asJava(),options , {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Safely execute some blocking code.
     *
     * Executes the blocking code in the handler `blockingCodeHandler` using a thread from the worker pool.
     *
     * When the code is complete the returned Future will be completed with the result.
     *
     * @param blockingFunction function containing blocking code
     * @param ordered if true then if executeBlocking is called several times on the same context, the executions for that context will be executed serially, not in parallel. if false then they will be no ordering guarantees
     * @return a Future representing the result of the blocking operation
     */
    def executeBlockingScala[T](blockingFunction: () => T, ordered: Boolean = true): concurrent.Future[T] = {
      val promise = concurrent.Promise[T]()
      val h: Handler[io.vertx.core.Promise[T]] = { f => util.Try(blockingFunction()) match {
        case util.Success(s) => f.complete(s)
        case util.Failure(t) => f.fail(t)
      }}
      asJava.executeBlocking[T](h, ordered, {h:AsyncResult[T] => {if (h.succeeded()) promise.success(h.result()) else promise.failure(h.cause());()} })
      promise.future
    }



    /**
     * Set a default exception handler for [[io.vertx.core.Context]], set on [[io.vertx.core.Context#exceptionHandler]] at creation.     * @param handler the exception handler
     * @return a reference to this, so the API can be used fluently
     */
    def exceptionHandler(handler: ScalaOption[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
    }

    /**
     * Like close from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture() : ScalaFuture[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: java.lang.String) : ScalaFuture[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: java.lang.String, options: io.vertx.core.DeploymentOptions) : ScalaFuture[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like undeploy from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def undeploy(deploymentID: java.lang.String) : ScalaFuture[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.undeploy(deploymentID, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

  }
}
