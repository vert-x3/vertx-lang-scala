package io.vertx.lang.scala.http

import io.vertx.core.Vertx
import io.vertx.scala.core._
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class HttpClientTest extends AsyncFlatSpec with Matchers {

  "Http client" should "access body through flatMap" in {
    val port = 1234
    val payload = "Hello"
    val vertx = Vertx.vertx
    vertx
      .createHttpServer()
      .requestHandler(req => req.response().end(payload))
      .listenFuture(port)
      .flatMap { _ =>
        vertx.createHttpClient()
          .getFuture(port, "127.0.0.1", "/")
          .flatMap(_.bodyFuture())
          .map(_.toString("UTF-8") should equal(payload))
      }
  }

}
