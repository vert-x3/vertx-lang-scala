package io.vertx.lang.scala

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a>
  */
class AsyncResult[J,S](val _java: io.vertx.core.AsyncResult[J], val converter: J => S) extends io.vertx.core.AsyncResult[S]{

  lazy val result:S = converter(_java.result())

  override def cause(): Throwable = _java.cause()

  override def succeeded(): Boolean = _java.succeeded()

  override def failed(): Boolean = _java.failed()
}

object AsyncResult {
  def apply[J,S](asyncResult: io.vertx.core.AsyncResult[J], converter: J => S): io.vertx.core.AsyncResult[S] =
    new AsyncResult(asyncResult, converter)
}
