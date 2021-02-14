package io.vertx.lang.scala

import io.vertx.core.{AsyncResult, DeploymentOptions, Handler, Future => VertxFuture, Promise => VertxPromise}

import scala.concurrent.{Future, Promise}
import scala.jdk.FutureConverters._
import scala.util.Success


package object conv {
  implicit class VertxFutureConverter[T](vertxFuture: VertxFuture[T]) {
    def asScala(): Future[T] = vertxFuture.toCompletionStage.asScala
  }

  implicit class FutureConverter[T](future: Future[T]) {
    def asVertx(): VertxFuture[T] = VertxFuture.fromCompletionStage(future.asJava)
  }

  implicit class PromiseConverter[T](promise: Promise[T]) {
    def asVertx(): VertxPromise[T] = {
      new VertxPromise[T] {
        override def tryComplete(result: T): Boolean = promise.tryComplete(Success(result))

        override def tryFail(cause: Throwable): Boolean = promise.tryFailure(cause)

        override def future(): VertxFuture[T] = VertxFuture.fromCompletionStage(promise.future.asJava)
      }
    }
  }

  implicit class VertxScala(val asJava: io.vertx.core.Vertx) extends AnyVal {

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle): scala.concurrent.Future[String] = {
      val promise = concurrent.Promise[String]()
      asJava.deployVerticle(verticle.asJava(), {a:AsyncResult[String] => if(a.failed) promise.failure(a.cause) else promise.success(a.result());()})
      promise.future
    }

    /**
     * Like [[deployVerticle]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(verticle: ScalaVerticle, options: DeploymentOptions): scala.concurrent.Future[String] = {
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
      val promise = concurrent.Promise[T]
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
    def exceptionHandler(handler: scala.Option[Throwable => Unit]) = {
      asJava.exceptionHandler(handler.map(hdlr => hdlr.asInstanceOf[io.vertx.core.Handler[java.lang.Throwable]]).getOrElse(null))
    }

    /**
     * Like close from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def closeFuture() : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]/*java.lang.Void VOID*/()
      asJava.close(new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: java.lang.String) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like deployVerticle from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def deployVerticle(name: java.lang.String, options: io.vertx.core.DeploymentOptions) : scala.concurrent.Future[java.lang.String] = {
      val promise = concurrent.Promise[java.lang.String]()
      asJava.deployVerticle(name, options, new Handler[AsyncResult[java.lang.String]] { override def handle(event: AsyncResult[java.lang.String]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }

    /**
     * Like undeploy from [[io.vertx.core.Vertx]] but returns a Scala Future instead of taking an AsyncResultHandler.
     */
    def undeploy(deploymentID: java.lang.String) : scala.concurrent.Future[Void] = {
      val promise = concurrent.Promise[Void]()
      asJava.undeploy(deploymentID, new Handler[AsyncResult[java.lang.Void]] { override def handle(event: AsyncResult[java.lang.Void]): Unit = { if(event.failed) promise.failure(event.cause) else promise.success(event.result())}})
      promise.future
    }


  }

}
