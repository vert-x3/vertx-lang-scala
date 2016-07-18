package io.vertx.lang.scala

import io.vertx.core.{AsyncResult, Handler}

import scala.concurrent.Promise
import scala.language.implicitConversions

/**
  * Conversions between handlers and functions
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
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
    * Create a Vert.x-Void-Handler from the given parameterless Scala-Function
    *
    * @param f Scala-Function used by the resulting Vert.x-Handler
    * @return a Vert.x-Handler that uses the given function to do its job
    */
  def parameterlessFuncToVoidHandler(f: () => Unit): Handler[Void] =
    new Handler[Void]() {
      override def handle(event: Void): Unit = f()
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
  def funcToMappedHandler[J, S](mapper: J => S)(f: S => Unit): Handler[J] = {
    //TODO: handlers can be set to null, there must be a better way so I avoid returning null here
    if(f != null)
      new Handler[J]() {
        override def handle(event: J): Unit = f(mapper(event))
      }
    else
     null
  }

  /**
    * Create a Scala-Function from the given Vert.x-Handler. It also maps the Functions type to
    * one the Handler understands.
    *
    * @param mapper a function to map the functions event-type to that of the given Handler
    * @param h the Handler  to be used by the Function
    * @tparam J type the Handler consumes
    * @tparam S type the Function consumes
    * @return the resulting Function
    */
  def handlerToMappedFunction[J, S](mapper: S => J)(h: Handler[J]): S => Unit =
    (event:S) => h.handle(mapper(event))

  /**
    * Null-save conversion of Java-numbers into Scala-Options. Required as implicit-conversions will break on null-values.
    * @param number a possible null-value
    * @tparam T target of the conversion
    * @return Option-value representing the conversion-result
    */
  def nullsafeConvToOption[T](number:java.lang.Number): Option[T] = {
    if(number == null)
      None
    else
      Some(number.asInstanceOf[T])
  }

  def nullsafeConvToOption[T](number:java.lang.Boolean): Option[T] = {
    if(number == null)
      None
    else
      Some(number.asInstanceOf[T])
  }

  def nullsafeConvToOption[T](number:java.lang.Character): Option[T] = {
    if(number == null)
      None
    else
      Some(number.asInstanceOf[T])
  }
}
