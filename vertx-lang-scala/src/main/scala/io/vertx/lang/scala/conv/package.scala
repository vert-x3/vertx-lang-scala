package io.vertx.lang.scala

import io.vertx.core.{Future => VertxFuture}
import scala.compat.java8.FutureConverters._
import scala.language.implicitConversions

/**
 * Creating a package object scala that imports from the scala package is not possible.
 * That's why this class takes care of abstracting the necessary classes/conversions away so
 * we don't have to import from the scala package directly.
 */
package object conv {

  type ScalaFuture[T] = scala.concurrent.Future[T]
  type ScalaPromise[T] = scala.concurrent.Promise[T]
  type VertxFuture[T] = io.vertx.core.Future[T]
  type VertxPromise[T] = io.vertx.core.Promise[T]

  implicit def vertxFutureToScalaFuture[T](vertxFuture: VertxFuture[T]): ScalaFuture[T] =
    vertxFuture.toCompletionStage.toScala

  implicit def scalaFutureToVertxFuture[T](scalaFuture: ScalaFuture[T]): VertxFuture[T] =
    VertxFuture.fromCompletionStage(scalaFuture.toJava)
}
