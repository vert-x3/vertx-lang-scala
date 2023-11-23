---
title: Working with Futures
---

Almost every function of the Vert.x API wraps the result `T` of an operation in a `io.vertx.core.Future[T]`. This is very similar to Scala APIs returning`scala.concurrent.Future[T]`. Working with Scala Futures, however, bears some differences:

  - _chaining_ Scala Futures can be expressed in an elegant way using `for`-comprehensions
  - operations like `map` or `filter` require a (`given`) `ExecutionContext`

This page explains how Vert.x Futures can be converted to Scala Futures and how we deal with the `ExecutionContext`.


# Implicit Conversion

The object [[io.vertx.lang.scala.ImplicitConversions]] provides _implicit conversions_. To use them, we need two imports:

```scala
import io.vertx.lang.scala.ImplicitConversions.*
import scala.language.implicitConversions
```

The import `scala.language.implicitConversions` is required to indicate our will to use implicit conversions in the current scope, thus avoiding compiler warnings.

After that, the Scala compiler applies the conversion automatically if possible. 

The following example loads a file from the file system and sends it over the Event Bus. There is an implicit conversion applied here, because 

  1. loading a file with `vertx.fileSystem.readFile` results in a `io.vertx.core.Future[Buffer]`
  2. the `for`-comprehension requires a `scala.concurrent.Future[_]` 
  3. the implicit conversion `vertxFutureToScalaFuture` is in scope 

```scala
//{
import io.vertx.lang.scala.ScalaVerticle
//}
import scala.concurrent.Future
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture
import scala.language.implicitConversions

final class MyVerticle extends ScalaVerticle:

  override def asyncStart: Future[Unit] =
    for {
      configBuffer <- vertx.fileSystem.readFile("myconfig")
      config = configBuffer.toString
      _ = vertx.eventBus.send("org.example.hosts", config)
    } yield ()
```

As explained in [The Scala 3 Reference](https://docs.scala-lang.org/scala3/reference/contextual/conversions.html), implicit conversions can not always be applied by the compiler. That's when we might want to use an explicit conversion.


# Explicit Conversion

When implicit conversions are not applicable and we still want to use Scala Futures, we can use extension methods. 

The following example shows usage of the extension method `asScala` which is defined on `io.vertx.core.Future` in the package object [[io.vertx.lang.scala]]:

```scala
//{
import io.vertx.lang.scala.ScalaVerticle
//}
import scala.concurrent.Future
import io.vertx.lang.scala.*

final class MyVerticle extends ScalaVerticle:

  override def asyncStart: Future[Unit] =
    for {
      configBuffer <- vertx.fileSystem.readFile("myconfig").asScala
      config = configBuffer.toString
      _ = vertx.eventBus.send("org.example.hosts", config)
    } yield ()
```


# Working with the `ExecutionContext`

Interaction with Vert.x APIs is normally done in the scope of a Verticle. The base class [[io.vertx.lang.scala.ScalaVerticle]] already has a `given` `ExecutionContext`, so it is provided to any API requiring it as an implicit parameter. This means, as long as we are in the scope of a `ScalaVerticle`, we do not have to deal with the `ExecutionContext`.

For rare situations in which it is not possible to access `ScalaVerticle`'s `ExecutionContext`, we can construct one by our own:

```scala
//{
import scala.concurrent.ExecutionContext
import io.vertx.core.Vertx
val vertx = Vertx.vertx
//}
import io.vertx.lang.scala.VertxExecutionContext

given ec: ExecutionContext = VertxExecutionContext(vertx, vertx.getOrCreateContext())
```

The `io.vertx.core.Context` is important for Vert.x in order to properly schedule asynchronous tasks, like accessing a database. Remember: All tasks started on the same Vert.x context, are also running on the same _thread_, which is good as it reduces expensive thread context switching and error-prone sharing of state.