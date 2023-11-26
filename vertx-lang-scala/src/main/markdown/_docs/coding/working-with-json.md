---
title: Working with JSON
---

# Extensions

The package [[io.vertx.lang.scala.json]] contains extensions for `io.vertx.core.json.JsonObject`, providing

  - [[io.vertx.lang.scala.json.package.JsObject.asMap]] - to easily convert from a `JsonObject` to a Scala `Map`

# Utilities

The `Json` utility class helps building JSON objects more Scala-like. The following example shows a simple `JsonObject` being created.

```scala
//{
import io.vertx.lang.scala.json.Json
//}
Json.obj(
        "foo" -> "foo text",
        "bar" -> 3.45d,
        "baz" -> false,
        "myInt" -> Integer.MAX_VALUE)

// or...
Json.obj("""
  |{
  |  "foo": "foo text",
  |  "bar": 3.45,
  |  "baz": false,
  |  "myInt": 2147483647
  |}
  """.stripMargin)
```

Deep nesting can be achieved by subsequent usage of `Json.obj()`:

```scala
//{
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json
//}
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
```
