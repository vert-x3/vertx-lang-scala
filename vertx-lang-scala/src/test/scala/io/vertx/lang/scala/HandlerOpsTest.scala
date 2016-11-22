package io.vertx.lang.scala

import io.vertx.core.Handler
import io.vertx.lang.scala.HandlerOps._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, Matchers}

/**
  * @author <a href="mailto:jochen.mader@codecentric.de">Jochen Mader</a
  */
@RunWith(classOf[JUnitRunner])
class HandlerOpsTest extends FlatSpec with Matchers {

  "A handler created by funcToMappedHandler" should "map the incoming value to that of the function and use the provided function" in {
    var changeMe = "unchanged"
    val function:Handler[String] = (event: String) => changeMe = event.toString
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

  "A function created by handlerToMappedFunction" should "map the incoming value to that of the handler and use the provided handler" in {
    var changeMe = 0
    val handler = new Handler[Int] {
      override def handle(event: Int): Unit = changeMe = event
    }
    val function = handlerToMappedFunction[Int, String](a => a.toInt)(handler)
    function.handle("1")
    assert(changeMe == 1)
  }

}
