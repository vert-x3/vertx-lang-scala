package io.vertx.lang.scala.http

import io.vertx.core.{Vertx, http}
import io.vertx.core.http.HttpMethod.GET
import io.vertx.lang.scala._
import org.scalatest.flatspec.AsyncFlatSpec
import org.scalatest.matchers.should.Matchers

class HttpClientTest extends AsyncFlatSpec, Matchers:

  "Http client" should "access body through flatMap" in {
    val port = 1234
    val payload = "Hello"
    val vertx = Vertx.vertx
    for {
      _    <- vertx.createHttpServer.requestHandler(req => req.response.end(payload)).listen(port).asScala
      req  <- vertx.createHttpClient.request(GET, port, "127.0.0.1", "/").asScala
      res  <- req.send.asScala
      body <- res.body.asScala
      assertion = body.toString should equal(payload)
    } yield assertion
  }

