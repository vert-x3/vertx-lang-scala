package io.vertx.lang.scala

import io.vertx.core.{Future => VertxFuture}

import scala.concurrent.Promise
import scala.compat.java8.FutureConverters._
import scala.util.Success

/**
 * Creating a package object scala that imports from the scala package is not possible.
 * That's why this class takes care of abstracting the necessary classes/conversions away so
 * we don't have to import from the scala package directly.
 */
package object conv {

  type ScalaFuture[T] = scala.concurrent.Future[T]
  type ScalaPromise[T] = scala.concurrent.Promise[T]
  type ScalaOption[T] = scala.Option[T]
  type ScalaSuccess[T] = scala.util.Success[T]
  type ScalaFailure[T] = scala.util.Failure[T]

  def succScalaSuccess[T](s: T): Success[T] = {
    Success(s)
  }

  def vertxFutureToScalaFuture[T](vertxFuture: VertxFuture[T]): ScalaFuture[T] = {
    vertxFuture.toCompletionStage.toScala
  }

  def scalaFutureToVertxFuture[T](scalaFuture: ScalaFuture[T]): VertxFuture[T] = {
    VertxFuture.fromCompletionStage(scalaFuture.toJava)
  }

  def newPromise[T](): ScalaPromise[T] = {
    Promise[T]()
  }
}
