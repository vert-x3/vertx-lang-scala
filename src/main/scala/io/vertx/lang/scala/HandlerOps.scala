package io.vertx.lang.scala

import io.vertx.core
import io.vertx.core.{AsyncResult, Handler}
import io.vertx.core.logging.LoggerFactory

import scala.concurrent.{Future, Promise}
import scala.language.implicitConversions

/**
  * Conversions between handlers and functions
  *
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
object HandlerOps {

  //Can't include ScalaLogger here as I had to separate the builds for Java and Scala-code
  //See the associated Scalac-Bug https://issues.scala-lang.org/browse/SI-9853
  val log = LoggerFactory.getLogger(HandlerOps.getClass.getName)

  /**
    * Create a Scala-Function from the given Vert.x-Handler
    *
    * @param handler Vert.x-Handler used by the resulting Scala-Function
    * @tparam J Event-type the Handler supports
    * @return a scala-Function that uses the given handler to do its job
    */
  def handlerToFunc[J](handler: Handler[J]): J => Unit = {
    if(handler == null)
      (pa: J) => {}
    else
      (pa: J) => handler.handle(pa)
  }

  /**
    * Create a Vert.x-Handler from the given Scala-Function
    *
    * @param f Scala-Function used by the resulting Vert.x-Handler
    * @tparam J Event-type the Function supports
    * @return a Vert.x-Handler that uses the given function to do its job
    */
  def funcToHandler[J](f: J => Unit): Handler[J] = {
    if(f == null)
      null
    else
      new Handler[J]() {
        override def handle(event: J): Unit = f(event)
      }
  }



  /**
    * Create a Vert.x-Void-Handler from the given parameterless Scala-Function
    *
    * @param f Scala-Function used by the resulting Vert.x-Handler
    * @return a Vert.x-Handler that uses the given function to do its job
    */
  def parameterlessFuncToVoidHandler(f: () => Unit): Handler[Void] = {
    if (f == null)
      new Handler[Void]() {
        override def handle(event: Void): Unit = {}
      }
    else
      new Handler[Void]() {
        override def handle(event: Void): Unit = f()
     }
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
    if(f == null) {
      null
    }
    else
      new Handler[J]() {
        override def handle(event: J): Unit = {
          //TODO: this sucks but there is no easy way around, maybe mark dangerous conversions?
          if(null != event)
            f(mapper(event))
          else
            log.error("Null value encountered in {}", "funcToMappedHandler")
        }
      }
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
  if(h == null)
    (event:S) => {}
  else
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

  /**
    * Null-save conversion of Java-Booleans into Scala-Options. Required as implicit-conversions will break on null-values.
    * @param number a possible null-value
    * @tparam T target of the conversion
    * @return Option-value representing the conversion-result
    */
  def nullsafeConvToOption[T](number:java.lang.Boolean): Option[T] = {
    if(number == null)
      None
    else
      Some(number.asInstanceOf[T])
  }

  /**
    * Null-save conversion of Java-Character into Scala-Options. Required as implicit-conversions will break on null-values.
    * @param number a possible null-value
    * @tparam T target of the conversion
    * @return Option-value representing the conversion-result
    */
  def nullsafeConvToOption[T](number:java.lang.Character): Option[T] = {
    if(number == null)
      None
    else
      Some(number.asInstanceOf[T])
  }

  /**
    *
    * val promiseAndHandler = handlerForAsyncResult[Void]
    * _asJava.close(promiseAndHandler._1)
    * promiseAndHandler._2.future
    *
    * @tparam T
    * @return
    */
  def handlerForAsyncResult[T]() = {
    val promise = Promise[T]()
    val handler = new Handler[core.AsyncResult[T]] {
      override def handle(event: core.AsyncResult[T]): Unit = {
        if(event.failed())
          promise.failure(event.cause())
        else
          promise.success(event.result())
      }
    }
    (handler,promise)
  }
  /**
    *
    *
    * @param conversion convert from Java type to Scala type
    * @tparam J incoming Java type
    * @tparam S outgoing Scala type
    * @return
    */
  def handlerForAsyncResultWithConversion[J,S](conversion: J => S) = {
    val promise = Promise[S]()
    val handler = new Handler[core.AsyncResult[J]] {
      override def handle(event: core.AsyncResult[J]): Unit = {
        if(event.failed())
          promise.failure(event.cause())
        else {
          try {
            promise.success(conversion(event.result()))
          }
          catch {
            case npe:NullPointerException => promise.failure(npe)
          }
        }
      }
    }
    (handler,promise)
  }
}
