package io.vertx.lang.scala

/**
  * Implementation of @see [[io.vertx.core.AsyncResult]]
  */
class ScalaAsyncResult[T](_result:T, _cause:Throwable) extends io.vertx.core.AsyncResult[T]{

  override def result(): T = _result

  override def cause(): Throwable = _cause

  override def succeeded(): Boolean = _result != null

  override def failed(): Boolean = _cause != null
}

object ScalaAsyncResult{
  def apply[T](result: T = null, cause: Throwable = null): ScalaAsyncResult[T] = new ScalaAsyncResult(result, cause)
}
