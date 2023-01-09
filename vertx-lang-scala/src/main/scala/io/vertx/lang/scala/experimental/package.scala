package io.vertx.lang.scala

import io.vertx.core.{AsyncResult, Vertx, Future as VertxFuture, Promise as VertxPromise}
import io.vertx.lang.scala.*

import scala.concurrent.{Future as ScalaFuture, Promise as ScalaPromise}
import scala.jdk.FutureConverters.*

package object experimental:

  given vertxFutureToScalaFuture[T]: Conversion[VertxFuture[T], ScalaFuture[T]] with
    override def apply(vertxFuture: VertxFuture[T]): ScalaFuture[T] = vertxFuture.asScala

  given scalaFutureToVertxFuture[T]: Conversion[ScalaFuture[T], VertxFuture[T]] with
    override def apply(scalaFuture: ScalaFuture[T]): VertxFuture[T] = scalaFuture.asVertx

  given vertxPromiseToScalaPromise[T]: Conversion[VertxPromise[T], ScalaPromise[T]] with
    override def apply(vertxPromise: VertxPromise[T]): ScalaPromise[T] = vertxPromise.asScala
  given scalaPromiseToVertxPromise[T]: Conversion[ScalaPromise[T], VertxPromise[T]] with
    override def apply(scalaPromise: ScalaPromise[T]): VertxPromise[T] = scalaPromise.asVertx
