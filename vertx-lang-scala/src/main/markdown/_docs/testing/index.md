---
title: Testing
---

Vert.x for Scala also brings a test support artifact, which helps to write [ScalaTest](https://www.scalatest.org) specifications. This section shows how to install it and how to use it when writing specs.


# Installation

To install, add the `vertx-lang-scala-test_3` artifact to your build descriptor. This module does not pin to a specific version of ScalaTest. That's why we additionally need to specify the ScalaTest version we desire:

## sbt

```sbt
libraryDependencies ++= Seq(
  "io.vertx" %% "vertx-lang-scala-test" % "{{projectVersion}}" % Test,
  "org.scalatest" %% "scalatest" % Version.scalaTest % Test,
)
```

## Gradle

```groovy title="build.gradle"
testImplementation "io.vertx:vertx-lang-scala-test_3:{{projectVersion}}"
testImplementation "org.scalatest:scalatest_3:$scalatestVersion"
```

## Maven

```xml title="pom.xml"
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-lang-scala-test_3</artifactId>
  <version>{{projectVersion}}</version>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.scalatest</groupId>
  <artifactId>scalatest_3</artifactId>
  <version>${scalatest.version}</version>
  <scope>test</scope>
</dependency>
```


# Writing Verticle Tests

Let's assume we have written a Verticle like this:

```scala
//{
import io.vertx.ext.web.Router
import io.vertx.lang.scala.*
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.lang.scala.json.Json
import scala.concurrent.Future
import scala.language.implicitConversions
//}

final class MyWebVerticle extends ScalaVerticle:
  override def asyncStart: Future[Unit] =
    val router = Router.router(vertx)
    router.get("/ping").handler(_.json(Json.obj("""{ "message": "pong" }""")))
    vertx.createHttpServer()
      .requestHandler(router)
      .listen(8080)
      .mapEmpty[Unit]()
```

Using `vertx-lang-scala-test`, we can write a ScalaTest spec like this:

```scala sc:nocompile
//{
import io.vertx.lang.scala.*
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.testing.VerticleTesting
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import io.vertx.scala.core.*
import org.scalatest.matchers.should.Matchers
import scala.language.implicitConversions
//}
final class MyWebVerticleSpec extends VerticleTesting[MyWebVerticle], Matchers:

  "MyWebVerticle" should "pong" in {
    val client = vertx.createHttpClient()

    for {
      req  <- client.request(RequestOptions(absoluteURI = "http://127.0.0.1:8888/ping"))
      res  <- req.send
      body <- res.body
      assertion = body.toJson should equal(Json.obj("""{ "message": "pong" }"""))
    } yield assertion
  }
```

That's it, `vertx-lang-scala-test` takes care of deploying `MyVerticle` to a `Vertx` instance and makes it ready for testing.
