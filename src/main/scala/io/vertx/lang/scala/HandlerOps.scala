package io.vertx.lang.scala

import io.vertx.core.Handler

object HandlerOps {

  def funcToMappedHandler[J, S](mapper: J => S)(f: S => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(mapper(event))
    }

  implicit def funcToHandler[J](f: J => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(event)
    }

  implicit def funcToVoidHandler(action: => Unit): Handler[Void] =
    funcToMappedHandler[Void, Unit](x => x.asInstanceOf[Unit])(_ => action)

  implicit def funcToLongHandler(action: Long => Unit): Handler[java.lang.Long] =
    funcToMappedHandler[java.lang.Long, Long](x => x)(l => action(l))

}
