package io.vertx.lang.scala

import scala.language.implicitConversions
import scala.concurrent.Promise
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.AsyncResult

object HandlerOps {

  def handlerToFunc[J](handler: Handler[J]): J => Unit =
    (pa:J) => handler.handle(pa)

  def funcToHandler[J](f: J => Unit): Handler[J] =
      new Handler[J]() {
    override def handle(event: J): Unit = f(event)
  }

  def funcToMappedHandler[J, S](mapper: J => S)(f: S => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(mapper(event))
    }

  def promiseToAsyncResultHandler[J](p: Promise[J]): Handler[AsyncResult[J]] =
    funcToHandler[AsyncResult[J]](asyncResult =>
      if (asyncResult.succeeded()) {
        p.success(asyncResult.result())
      } else {
        p.failure(asyncResult.cause())
      })

  def promiseToMappedAsyncResultHandler[J, S](mapper: J => S)(p: Promise[S]): Handler[AsyncResult[J]] =
    funcToHandler[AsyncResult[J]](asyncResult =>
        if (asyncResult.succeeded()) {
          p.success(mapper(asyncResult.result()))
        } else {
          p.failure(asyncResult.cause())
        })

}
