package io.vertx.lang.scala.core.eventbus

object Message {
  /**
   * Unwraps the `body` of a [[io.vertx.core.eventbus.Message]] for use in pattern matching expressions.
   *
   * @param m the [[io.vertx.core.eventbus.Message]]
   * @tparam T the type of the body
   * @return an [[Option]] holding the body if present or [[None]]
   */
  def unapply[T](m: io.vertx.core.eventbus.Message[T]): Option[T] = Option(m.body)
}
