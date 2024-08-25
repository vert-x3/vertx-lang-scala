package io.vertx.lang.scala.testing

import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpMethod.{DELETE, GET}
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.*
import io.vertx.scala.core.{HttpClientOptions, RequestOptions}
import org.scalatest.FutureOutcome
import org.scalatest.matchers.should.Matchers
import TestVerticle.port

import scala.language.implicitConversions

class VerticleTestingSpec extends VerticleTesting[TestVerticle] with Matchers {

  var httpClient: HttpClient = _

  override def withFixture(test: NoArgAsyncTest): FutureOutcome = {
    httpClient = vertx.createHttpClient(HttpClientOptions(defaultPort = port))
    complete {
      super.withFixture(test)
    } lastly {
      httpClient.close()
    }
  }

  "VerticleTesting" should "provide a Vertx instance" in {
    vertx should not be null
  }

  it should "provide a given VertxExecutionContext instance" in {
    implicitly [VertxExecutionContext] should not be null
  }

  "TestVerticle" should "bind to 8888 and answer with 'Hello from Vert.x!'" in {
    for {
      req <- httpClient.request(RequestOptions(absoluteURI = s"http://127.0.0.1:$port/hello")).asScala
      res  <- req.send.asScala
      body <- res.body.asScala
      assertion = body.toString("UTF-8") should equal("Hello from Vert.x!")
    } yield assertion
  }

  it should "answer with a pong when pinged" in {
    for {
      req <- httpClient.request(GET,s"http://127.0.0.1/ping").asScala
      res <- req.send.asScala
      body <- res.body.asScala
      assertion = body.toJsonValue should equal(Json.obj("""{ "message": "pong" }"""))
    } yield assertion
  }

  it should "answer with ok when DELETE /account is called" in {
    for {
      req <- httpClient.request(DELETE, port, "127.0.0.1", "/account").asScala
      res <- req.send.asScala
      body <- res.body.asScala
      assertion = body.toJsonValue should equal(json"""{ "message":  "ok" }""")
    } yield assertion
  }
}
