---
title: Working with DataObjects
---

# Data Objects with a Scala flavor

Data objects are heavily used all across the Vert.x API. To make things feel more native to Scala developers we generated their Scala counterparts with some additional functions.

For each Vert.x module the included data objects have been extended and can be found by simply adding `scala` to the package name:

> `io.vertx.core => io.vertx.scala.core`

Here is a quick example for the Data Object `HttpServerOptions`:

```scala
//{
import io.vertx.lang.scala.json.Json
val json = Json.obj("{}")
//}
import io.vertx.scala.core.HttpServerOptions

// Generate PemKeyCertOptions with default values:
HttpServerOptions()
// Generate PemKeyCertOptions from a Json-object
HttpServerOptions(json)
// Generate PemKeyCertOptions with default values but change certPath to /tmp/certs
HttpServerOptions(port = 8080)
```

The resulting instances can be used like regular data objects.