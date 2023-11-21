---
title: Writing Verticles
---

For Verticles to be written in Scala, the base class 
[[io.vertx.lang.scala.ScalaVerticle]]

`ScalaVerticle` takes care of providing the correct [ExecutionContext](https://scala-lang.org/api/3.3.1/scala/concurrent/ExecutionContext.html) and adds some Scala-specific syntactic sugar.

```scala
//{
import scala.concurrent.{Future, Promise}
import scala.util.Success

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.*
//}

class StartFutureVerticle extends ScalaVerticle
  override def start(promise: Promise[Unit]): Unit =
    promise.complete(Success(()))
  override def stop(promise: Promise[Unit]): Unit =
    promise.complete(Success(()))

  override def start(): Unit = {
  }
  override def stop(): Unit = {
  }

  override def asyncStart: Future[Unit] = Future.unit
  override def asyncStop: Future[Unit] = Future.unit
```

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