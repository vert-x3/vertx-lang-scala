package io.vertx.lang.scala.testing

import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.scala.core.*
import org.scalatest.matchers.should.Matchers
import scala.language.implicitConversions

class MainVerticleSpec extends VerticleTesting[MainVerticle], Matchers:

  "MainVerticle" should "bind to 8888 and answer with 'Hello from Vert.x!'" in {
    val client = vertx.createHttpClient()

    for {
      req  <- client.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888"))
      res  <- req.send
      body <- res.body
      assertion = body.toString("UTF-8") should equal("Hello from Vert.x!")
    } yield assertion
  }

  "MainVerticle" should "answer with a pong when ping-ed" in {
    val client = vertx.createHttpClient()

    for {
      req  <- client.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888/ping"))
      res  <- req.send
      body <- res.body
      assertion = body.toJson should equal(Json.obj("""{ "message": "pong" }"""))
    } yield assertion
  }

