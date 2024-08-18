package io.vertx.lang.scala.testing

import io.vertx.lang.scala._
import io.vertx.scala.core._
import org.scalatest.matchers.should.Matchers

class MainVerticleSpec extends VerticleTesting[MainVerticle] with Matchers {

  "MainVerticle" should "bind to 8888 and answer with 'Hello from Vert.x!'" in {
    val client = vertx.createHttpClient()

    for {
      req  <- client.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888")).asScala
      res  <- req.send.asScala
      body <- res.body.asScala
      assertion = body.toString("UTF-8") should equal("Hello from Vert.x!")
    } yield assertion
  }
}
