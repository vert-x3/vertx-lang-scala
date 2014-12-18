package io.vertx.lang.scala

import io.vertx.core.Handler

object HandlerOps {

  def funcToMappedHandler[S, J](mapper: J => S)(f: S => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(mapper(event))
    }

  implicit def funcToHandler[J](f: J => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(event)
    }

  implicit def funcToVoidHandler(action: => Unit): Handler[Void] =
    funcToMappedHandler[Unit, Void](x => x)(_ => action)
//    new Handler[Void]() {
//      override def handle(event: Void) = action
//    }


}
