package io.vertx.lang.scala.testing

import io.vertx.lang.scala._
import io.vertx.scala.core._
import org.scalatest.matchers.should.Matchers

class MainVerticleSpec extends VerticleTesting[MainVerticle] with Matchers {

  "MainVerticle" should "bind to 8888 and answer with 'Hello from Vert.x!'" in {
    val client = vertx.createHttpClient()

    client
      .request(RequestOptions(absoluteURI = "http://127.0.0.1:8888", method = io.vertx.core.http.HttpMethod.GET))
      .asScala()
      .flatMap(req => req.send().asScala())
      .flatMap(res => res.body().asScala())
      .map(b => b.toString("UTF-8") should equal("Hello from Vert.x!"))
  }

}
