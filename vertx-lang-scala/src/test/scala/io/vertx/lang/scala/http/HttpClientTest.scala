package io.vertx.lang.scala.http

import io.vertx.core.{Vertx, http}
import io.vertx.lang.scala.conv._
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
      .listen(port)
      .asScala()
      .flatMap { _ =>
        vertx.createHttpClient()
          .request(http.HttpMethod.GET, port, "127.0.0.1", "/")
          .asScala()
          .flatMap(req => req.send().asScala())
          .flatMap(_.body().asScala())
          .map(_.toString() should equal(payload))
      }
  }

}
