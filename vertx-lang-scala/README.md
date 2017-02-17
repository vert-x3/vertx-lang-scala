Disclaimer
==========
The code in here is currently in an early preview state following the principle of 'First make it work, then make it beautiful'*[]: 
__It has not yet been optimized for performance and contains a lot of boilerplate.__


Using it
========

After building this project you can start using it with the following prototype:

[Vert.x Scala Lang SBT-starter](https://github.com/codepitbull/vertx-scala-sbt)

If you want to play with Vert.x-web and the security modules check out and build:

[Vert.x Scala Lang Stack](https://github.com/codepitbull/vertx-lang-scala-stack)

Diversions from Vert.x-API
==========================

Futures, Promises and the VertxExecutionContext
===============================================
Scala has built in Promises/Futures. They're a perfect replacement for completionHandlers and so on.
To use them we needed an _implicit VertxExectionContext_ which is available inside every Verticle deriving from 
 ScalaVerticle.
 
Using Scala-Futures removes the need for the Vert.x-CompositeFuture and makes for a more fluent programming experience:  
```
class PromiseTestVerticle extends ScalaVerticle {

  override def startFuture(): Future[Unit] = {
    Future.sequence(Seq(
      vertx.eventBus().consumer[String]("asd").handler(a => println(a)).completionFuture(),
      vertx.eventBus().consumer[String]("asd2").handler(a => println(a)).completionFuture())
    )
  }
}
```

