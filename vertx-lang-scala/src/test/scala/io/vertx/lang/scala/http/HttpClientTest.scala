package io.vertx.lang.scala.http

import io.vertx.core.{Vertx, http}
import io.vertx.core.http.HttpMethod.GET
import io.vertx.lang.scala.*
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers
import scala.language.implicitConversions


class HttpClientTest extends AsyncFlatSpec, Matchers:

  "Http client" should "access body through flatMap" in {
    val port = 1234
    val payload = "Hello"
    val vertx = Vertx.vertx
    for {
      _    <- vertx.createHttpServer.requestHandler(_.response.end(payload)).listen(port)
      req  <- vertx.createHttpClient.request(GET, port, "127.0.0.1", "/")
      res  <- req.send
      body <- res.body
      assertion = body.toString should equal(payload)
    } yield assertion
  }

