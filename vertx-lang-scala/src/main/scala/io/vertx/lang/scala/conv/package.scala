package io.vertx.lang.scala

import io.vertx.core.{Future => VertxFuture}

import scala.concurrent.Promise
import scala.jdk.FutureConverters._
import scala.util.Success

/**
 * Creating a package object scala that imports from the scala package is not possible.
 * That's why this class takes care of abstracting the necessary classes/conversions away so
 * we don't have to import from the scala package directly.
 */
package object conv:

  type ScalaFuture[T] = scala.concurrent.Future[T]
  type ScalaPromise[T] = scala.concurrent.Promise[T]

  def vertxFutureToScalaFuture[T](vertxFuture: VertxFuture[T]): ScalaFuture[T] =
    vertxFuture.toCompletionStage.asScala

  def scalaFutureToVertxFuture[T](scalaFuture: ScalaFuture[T]): VertxFuture[T] =
    VertxFuture.fromCompletionStage(scalaFuture.asJava)
