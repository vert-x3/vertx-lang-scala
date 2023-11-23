---
title: Writing Verticles
---

# Writing Scala Verticles

For Verticles to be written in Scala, the base class 
[[io.vertx.lang.scala.ScalaVerticle]] 

  - takes care of providing the correct [ExecutionContext](https://scala-lang.org/api/3.3.1/scala/concurrent/ExecutionContext.html)
  - provides Scala-specific `start` and `stop` functions
  - and adds some Scala-specific syntactic sugar

```scala
//{
import scala.concurrent.{Future, Promise}
import scala.util.Success

import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.ImplicitConversions.*
import scala.language.implicitConversions
//}

final class StartFutureVerticle extends ScalaVerticle:

  // start/stop with Scala Promises
  override def start(promise: Promise[Unit]): Unit =
    promise.complete(Success(()))
  override def stop(promise: Promise[Unit]): Unit =
    promise.complete(Success(()))

  // synchronous start/stop for simple initializations
  override def start(): Unit = {}
  override def stop(): Unit = {}

  // start/stop with Scala Futures
  override def asyncStart: Future[Unit] = Future.unit
  override def asyncStop: Future[Unit] = Future.unit
```


# Deploying Scala Verticles

[[io.vertx.lang.scala.ScalaVerticle]] cannot be deployed directly. Instead, we can either
use the Verticle's name or convert it to a regular `Verticle`, using the [[io.vertx.lang.scala.ScalaVerticle.asJava]] function. 


## Deploying via `asJava`

The following example shows how to deploy two `ScalaVerticles` via the `asJava` function:

```scala
//{
import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import io.vertx.lang.scala.ScalaVerticle
import scala.concurrent.{Future, Promise}
import scala.util.Success

final class MyVerticle1 extends ScalaVerticle:
  override def start(startPromise: Promise[Unit]): Unit =
    println("MyVerticle1 started")
    startPromise.complete(Success(()))
final class MyVerticle2 extends ScalaVerticle:
  override def start(startPromise: Promise[Unit]): Unit =
    println("MyVerticle2 started")
    startPromise.complete(Success(()))

final class MainVerticle extends ScalaVerticle:

  override def asyncStart: Future[Unit] =
//}
    for {
      _ <- vertx.deployVerticle(MyVerticle1())
      _ <- vertx.deployVerticle(MyVerticle2())
    } yield ()
```


## Deploying via Verticle name

Vertx for Scala brings a `VerticleFactory` which allows to deploy Scala Verticles by fully-qualified class name. Example:

```scala
//{
// package org.example
import io.vertx.core.Vertx
import io.vertx.lang.scala.ScalaVerticle
import io.vertx.lang.scala.ScalaVerticle.nameForVerticle
import scala.concurrent.{Future, Promise}
import scala.util.Success

val vertx = Vertx.vertx()
final class MyVerticle1 extends ScalaVerticle:
  override def start(startPromise: Promise[Unit]): Unit =
    println("MyVerticle1 started")
    startPromise.complete(Success(()))
final class MyVerticle2 extends ScalaVerticle:
  override def start(startPromise: Promise[Unit]): Unit =
    println("MyVerticle2 started")
    startPromise.complete(Success(()))

//}
val deploymentIds = for {
  deploymentId1 <- vertx.deployVerticle(nameForVerticle[MyVerticle1]())
  deploymentId2 <- vertx.deployVerticle("scala:org.example.MyVerticle2")
} yield (deploymentId1, deploymentId2)
```

# Vert.x without Verticles

Although we encourage writing Verticles to create [Reactive Applications](https://www.reactivemanifesto.org), Vert.x can also be used entirely without Verticles. Doing so in Scala is just as easy as in Java.

When dealing with Futures, Scala requires to define an `scala.concurrent.ExecutionContext` for operations like `map` or `filter`. Verticles, on the other hand, have their own context which they need so Vert.x can properly schedule all the tasks belonging to a Verticle, for example sending messages over the EventBus.

Vertx for Scala brings the [[io.vertx.lang.scala.VertxExecutionContext]] which takes care to move all tasks to the correct Vert.x thread bound by the Vert.x context. Typically, we define `VertxExecutionContext` as `given` (Scala 2: `implicit`).

The following examples shows how to bootstrap a simple Hello-World HTTP server in a simple main function.

```scala
//{
import io.vertx.core.Vertx
import io.vertx.lang.scala.*
import scala.concurrent.Future
import scala.util.{Failure, Success}

//}
@main def main: Unit =
  val vertx = Vertx.vertx
  given exec: VertxExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
  
  vertx
    .createHttpServer
    .requestHandler(_.response.end("Hello world!"))
    .listen(8080).asScala
    .onComplete {
      case Success(_) => println("Success")
      case Failure(_) => println("Failure")
    }
```

> Also note the call to the extension method `asScala` which is defined in package [[io.vertx.lang.scala]]. This is an alternative to the implicit conversion [[io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture]]. This can be used in situations where implicit conversions cannot be applied, for example the code above.