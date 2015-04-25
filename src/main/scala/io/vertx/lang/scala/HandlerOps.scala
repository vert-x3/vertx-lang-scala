package io.vertx.lang.scala

import scala.language.implicitConversions
import scala.util.Try
import scala.util.Success
import scala.util.Failure
import scala.collection.JavaConverters._
import io.vertx.core.Handler
import io.vertx.core.AsyncResult

object HandlerOps {

  def funcToHandler[J](f: J => Unit): Handler[J] =
      new Handler[J]() {
    override def handle(event: J): Unit = f(event)
  }

  def funcToMappedHandler[J, S](mapper: J => S)(f: S => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(mapper(event))
    }

  def funcToAsyncResultHandler[J](f: Try[J] => Unit): Handler[AsyncResult[J]] =
      funcToMappedHandler[AsyncResult[J], Try[J]](asyncResult =>
      if (asyncResult.succeeded()) {
        Success(asyncResult.result())
      } else {
        Failure(asyncResult.cause())
      })(f)

  def funcToMappedAsyncResultHandler[J, S](mapper: J => S)(f: Try[S] => Unit): Handler[AsyncResult[J]] =
    funcToMappedHandler[AsyncResult[J], Try[S]](asyncResult =>
        if (asyncResult.succeeded()) {
          Success(mapper(asyncResult.result()))
        } else {
          Failure(asyncResult.cause())
        })(f)

}
