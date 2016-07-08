package io.vertx.lang.scala

import io.vertx.core.{AsyncResult, Handler}

import scala.concurrent.Promise
import scala.language.implicitConversions

object HandlerOps {

  /**
    * Create a Scala-Function from the given Vert.x-Handler
    *
    * @param handler Vert.x-Handler used by the resulting Scala-Function
    * @tparam J Event-type the Handler supports
    * @return a scala-Function that uses the given handler to do its job
    */
  def handlerToFunc[J](handler: Handler[J]): J => Unit =
    (pa: J) => handler.handle(pa)

  /**
    * Create a Vert.x-Handler from the given Scala-Function
    *
    * @param f Scala-Function used by the resulting Vert.x-Handler
    * @tparam J Event-type the Function supports
    * @return a Vert.x-Handler that uses the given function to do its job
    */
  def funcToHandler[J](f: J => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(event)
    }

  /**
    * Create a Vert.x-Handler from the given Scala-Function. It also maps the Handlers type to
    * one the function understands.
    *
    * @param mapper a function to map the Handlers event-type to that of the given Scala-function
    * @param f the Scala-Function to be used by the Handler
    * @tparam J type the Handler consumes
    * @tparam S type the Function consumes
    * @return the resulting Handler
    */
  def funcToMappedHandler[J, S](mapper: J => S)(f: S => Unit): Handler[J] =
    new Handler[J]() {
      override def handle(event: J): Unit = f(mapper(event))
    }

}
