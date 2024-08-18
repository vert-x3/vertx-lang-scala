package io.vertx.lang.scala

import io.vertx.core.Verticle
import conv.{VertxFuture,VertxPromise}
import scala.concurrent.{Promise, Future}
import scala.language.implicitConversions

object ImplicitConversions {

  implicit def vertxFutureVoidToScalaFutureUnit(f: VertxFuture[Void]): Future[Unit] = f.map({}).asInstanceOf[VertxFuture[Unit]].asScala

  implicit def vertxPromiseToScalaPromise[T](p: VertxPromise[T]): Promise[T] = p.asScala

  implicit def scalaPromiseToVertxPromise[T](p:Promise[T]): VertxPromise[T] = p.asVertx

  implicit def scalaVerticleToJavaVerticle(scalaVert: ScalaVerticle): Verticle = scalaVert.asJava

}
