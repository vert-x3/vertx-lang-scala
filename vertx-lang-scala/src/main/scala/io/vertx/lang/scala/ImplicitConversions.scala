package io.vertx.lang.scala

import io.vertx.core.{Future as VertxFuture, Promise as VertxPromise, Verticle}
import scala.concurrent.{Future as ScalaFuture, Promise as ScalaPromise}
import io.vertx.lang.scala.*
import scala.language.implicitConversions

object ImplicitConversions:

  given vertxFutureToScalaFuture[T]: Conversion[VertxFuture[T], ScalaFuture[T]] = _.asScala

  given vertxFutureVoidToScalaFutureUnit: Conversion[VertxFuture[Void], ScalaFuture[Unit]] = _.map(_ => ())

  given scalaFutureToVertxFuture[T]: Conversion[ScalaFuture[T], VertxFuture[T]] = _.asVertx

  given vertxPromiseToScalaPromise[T]: Conversion[VertxPromise[T], ScalaPromise[T]] = _.asScala

  given scalaPromiseToVertxPromise[T]: Conversion[ScalaPromise[T], VertxPromise[T]] = _.asVertx

  given scalaVerticleToJavaVerticle: Conversion[ScalaVerticle, Verticle] = _.asJava
