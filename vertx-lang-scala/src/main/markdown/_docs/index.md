# Vert.x for Scala

If you are using Maven or Gradle, add the following dependency to the _dependencies_ section of your
project descriptor to access the Vert.x Core API and enable the Scala support:

* Maven (in your `pom.xml`):

[source,xml,subs="+attributes"]
----
<dependency>
 <groupId>io.vertx</groupId>
 <artifactId>vertx-core</artifactId>
 <version>${maven.version}</version>
</dependency>
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-lang-scala3</artifactId>
  <version>${maven.version}</version>
</dependency>
<dependency>
  <groupId>io.vertx</groupId>
  <artifactId>vertx-lang-scala3-test</artifactId>
  <version>${maven.version}</version>
</dependency>
----

Or go to [https://start.vertx.io/](https://start.vertx.io/) to generate a fully functional project.

* Gradle (in your `build.gradle` file):

[source,groovy,subs="+attributes"]
----
compile "io.vertx:vertx-core:${maven.version}"
compile "io.vertx:vertx-lang-scala3:${maven.version}"
compile "io.vertx:vertx-lang-scala3-test:${maven.version}"
----

And like with Maven, go to [https://start.vertx.io/](https://start.vertx.io/) and generate a project.
It even comes with hot-reloading during development time.

* SBT (in your `build.sbt` file):

[source,scala,subs="+attributes"]
----
libraryDependencies += "io.vertx" % "vertx-core" % "${maven.version}"
libraryDependencies += "io.vertx" %% "vertx-lang-scala" % "${maven.version}"
libraryDependencies += "io.vertx" %% "vertx-lang-scala-test" % "${maven.version}"
----

But things get a lot simpler by using out Giter8 template.
Get [sbt](https://www.scala-sbt.org/) installed and run the following command to get a fully functional project:

----
sbt new vert-x3/vertx4-scala.g8
----

== Vert.x and Scala
The Scala integration for Vert.x has a strict focus on being low in overhead


== Helpers

Whether you are using Verticles or plain Vert.x, when using Scala you should always have *io.vertx.lang.scala._* imported.



That package provides conversions between VertxFutures and their Scala counterparts.

== Verticles

For Scala-based verticles use {@link io.vertx.lang.scala.ScalaVerticle} as their base class.
This will take care of providing the correct [ExecutionContext](https://scala-lang.org/api/3.1.1/scala/concurrent/ExecutionContext.html) and adds some Scala-specific syntactic sugar.

[source, scala]
----
import scala.concurrent.Future

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala._

class StartFutureVerticle extends ScalaVerticle{
  override def start(promise: Promise[Unit]): Unit = {
    promise.complete(Success(()))
  }

  override def stop(promise: Promise[Unit]): Unit = {
    promise.complete(Success(()))
  }

  override def start(): Unit = {
  }

  override def stop(): Unit = {
  }
}
----

You might have noticed the following import:

[source, scala]
----
import io.vertx.lang.scala._
----

This package provides several converters, especially for converting back and forth between *io.vertx.core.Future* and *scala.concurrent.Future*.

== Vert.x without Verticles

Vert.x can be used without Verticles and doing so in Scala is just as easy as in Java.
The most important thing is to declare an implicit ExecutionContext for Scala.
There is the *io.vertx.lang.scala.VertxExecutionContext* which you should use. It takes care to move all code to the correct Vert.x thread bound by the Vert.x-context.
The following examples shows how to bootstrap a simple Hello-World-HTTP-server without the use of Verticles.

[source, scala]
----
import io.vertx.scala.core.HttpServerOptions
import io.vertx.lang.scala._
object VertxDemo {
  def main(args: Array[String]): Unit = {
    val vertx = Vertx.vertx
    implicit val exec = VertxExecutionContext(vertx, vertx.getOrCreateContext())
    vertx
      .createHttpServer(HttpServerOptions(port = 8080))
      .requestHandler(req => {
        req.response().end("Hello world!")
      })
      .listen().asScala()
      .onComplete{
        case Success(_) => println("Success")
        case Failure(_) => println("Failure")
      }
  }
}
----

== Data Objects with a Scala flavor
Data objects are heavily used all across the Vert.x API. To make things feel more native to Scala devs we generated their Scala counterparts with some additional functions.
For each Vert.x module the included data objects have been extended and can be found by simply adding a *scala* to the package name:

----
io.vertx.core => io.vertx.scala.core
----

Here is a quick example for PemKeyCertOptions.
[source, scala]
----
import io.vertx.scala.PemKeyCertOptions

PemKeyCertOptions() //Generate PemKeyCertOptions with default values
PemKeyCertOptions(json) // Generate PemKeyCertOptions from a Json-object
PemKeyCertOptions(certPath = "/tmp/certs") // Generate PemKeyCertOptions with default values but change certPath to /tmp/certs
----

The resulting instances can be used like regular data objects.

== JSON

The package *io.vertx.lang.scala.json* contains extensions for *io.vertx.core.json.JsonObject*, adding asMap to easily convert from a JsonObject to a Scala map.
On top of that you get more Scala-like way of building JSON objects.
The following example shows a simple JsonObject being creatred.
[source, scala]
----
Json.obj(
        "foo" -> "foo text",
        "bar" -> 3.45d,
        "baz" -> false,
        "myInt" -> Integer.MAX_VALUE)
----

It is also possible to apply some deep nesting.
[source, scala]
----
Json.obj(
        "webappconf" -> Json.obj(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Vector(1, 2, Json.obj("next" -> List(3, 4))),
          "some_list" -> Json.arr(1, 2, Vector(3, 4)),
          "inbound_permitted" -> List(
            Json.obj(
              "address" -> "acme.bar",
              "match" -> Json.obj(
                "action" -> "foo")),
            Json.obj(
              "address" -> "acme.baz",
              "match" -> Json.obj(
                "action" -> "index"))),
          "outbound_permitted" -> Array(new JsonObject())))
----


