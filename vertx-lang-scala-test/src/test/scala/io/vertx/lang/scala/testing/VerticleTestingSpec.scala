package io.vertx.lang.scala.testing

import io.vertx.core.http.HttpClient
import io.vertx.lang.scala.*
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.json.{json, Json}
import io.vertx.scala.core.*
import org.scalatest.FutureOutcome
import org.scalatest.matchers.should.Matchers

import scala.compiletime.uninitialized
import scala.language.implicitConversions

class VerticleTestingSpec extends VerticleTesting[TestVerticle], Matchers:

  var httpClient: HttpClient = uninitialized

  override def withFixture(test: NoArgAsyncTest): FutureOutcome = {
    httpClient = vertx.createHttpClient()
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
    summon[VertxExecutionContext] should not be null
  }

  "TestVerticle" should "bind to 8888 and answer with 'Hello from Vert.x!'" in {
    for {
      req  <- httpClient.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888/hello"))
      res  <- req.send
      body <- res.body
      assertion = body.toString("UTF-8") should equal("Hello from Vert.x!")
    } yield assertion
  }

  it should "answer with a pong when pinged" in {
    for {
      req  <- httpClient.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888/ping"))
      res  <- req.send
      body <- res.body
      assertion = body.toJsonValue should equal(Json.obj("""{ "message": "pong" }"""))
    } yield assertion
  }

  it should "answer with ok when DELETE /account is called" in {
    for {
      req  <- httpClient.request(HttpMethod("DELETE"), 8888, "127.0.0.1", "/account")
      res  <- req.send
      body <- res.body
      assertion = body.toJsonValue should equal(json"""{ "message":  "ok" }""")
    } yield assertion
  }
