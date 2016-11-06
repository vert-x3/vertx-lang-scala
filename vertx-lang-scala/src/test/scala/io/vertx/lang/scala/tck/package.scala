package io.vertx.lang.scala

import org.scalatest.concurrent.Waiters.{Waiter, _}

/**
  * Easier handling of Waiters.
  */
package object tck {

  def exec(dis:Int = 1)(fun: Waiter => Unit): Unit = {
    val w = new Waiter
    fun(w)
    w.await(dismissals(dis))
  }

  val exec1 = exec(1) _
}
