---
sidebar_position: 1
---

# Intro

Vert.x for Scala provides utilities which help to use Vert.x in a more idiomatic way.

**Example:** Given two methods `loadConfig` and `requestUsers`, which return Vert.x `Future`s...

```scala
//{
import io.vertx.core.Future
import io.vertx.core.json.{JsonArray, JsonObject}
//}
def loadConfig: Future[JsonObject] = ???
def requestUsers(config: JsonObject): Future[JsonArray] = ???
```

...the below implementations would be viable. Using Vert.x for Scala, 
[Vert.x Futures](https://vertx.io/docs/apidocs/io/vertx/core/Future.html) can
be _implicitly converted_ into 
[Scala Futures](https://scala-lang.org/api/3.x/scala/concurrent/Future.html). 
That way we can express the chain of operations with a `for` comprehension, resulting 
in more concise code.

Before:

```scala
//{
import io.vertx.core.Future
import io.vertx.core.json.{JsonArray, JsonObject}
// dummy implementations to make this snippet work
def loadConfig: Future[JsonObject] = Future.succeededFuture(JsonObject())
def requestUsers(config: JsonObject) = Future.succeededFuture(JsonArray("""
[{ "name": "Ernie", "email": "ernie@sesame-street.com"}]
"""))
//}
val firstUserVertx = loadConfig
      .flatMap(config => requestUsers(config))
      .map(users => users.getJsonObject(0))
```

After:

```scala
//{
import io.vertx.core.Future
import io.vertx.core.json.{JsonArray, JsonObject}
// dummy implementations to make this snippet work
def loadConfig: Future[JsonObject] = Future.succeededFuture(JsonObject())
def requestUsers(config: JsonObject) = Future.succeededFuture(JsonArray("""
[{ "name": "Ernie", "email": "ernie@sesame-street.com"}]
"""))
//}
import scala.language.implicitConversions
import io.vertx.lang.scala.ImplicitConversions.vertxFutureToScalaFuture

val firstUserScala = for {
  config <- loadConfig
  users  <- requestUsers(config)
} yield users.getJsonObject(0)
```

> **Note** the `import`s which make the conversion explicit.

