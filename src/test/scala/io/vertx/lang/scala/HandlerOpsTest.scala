package io.vertx.lang.scala

import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps.{funcToHandler, funcToMappedHandler, handlerToFunc}
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}


@RunWith(classOf[JUnitRunner])
class HandlerOpsTest extends FlatSpec with Matchers {
  "A handler created by funcToHandler" should "use the provided function" in {
    var changeMe = "unchanged"
    val function = (event: String) => changeMe = event + "!"
    val handler = funcToHandler(function)
    handler.handle("changed")
    assert(changeMe == "changed!")
  }

  "A handler created by funcToMappedHandler" should "map the incoming value to that of the function and use the provided function" in {
    var changeMe = "unchanged"
    val function = (event: String) => changeMe = event.toString
    val handler = funcToMappedHandler[Int, String](a => a.toString)(function)
    handler.handle(1)
    assert(changeMe == "1")
  }

  "A function created by handlerToFunc" should "use the provided handler" in {
    var changeMe = "unchanged"
    val handler = new Handler[String] {
      override def handle(event: String): Unit = changeMe = event + "!"
    }
    val function = handlerToFunc(handler)
    function("changed")
    assert(changeMe == "changed!")
  }
}
