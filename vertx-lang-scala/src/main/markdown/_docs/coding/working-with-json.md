---
title: Working with JSON
---

# Extensions

The package [[io.vertx.lang.scala.json]] contains extensions for `io.vertx.core.json.JsonObject`, providing

  - [[io.vertx.lang.scala.json.package.asMap]] - to easily convert from a `JsonObject` to a Scala `Map`
  - [[io.vertx.lang.scala.json.package.asList]] - to easily convert from  a `JsonArray` to a Scala `List`

# Builders & Interpolators

The [[io.vertx.lang.scala.json.Json]] object provides builders for a more fluent and Scala-like construction
of JSON objects and arrays.

## JsonObject

`JsonObjects` can be built via a builder or via an interpolator:

```scala
//{

import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.json
//}
// Json.obj takes...
// ...a vararg of Scala Tuples
val fromVararg = Json.obj(
  "foo" -> "foo text",
  "bar" -> 3.45d,
  "baz" -> false,
  "myInt" -> Integer.MAX_VALUE)

// ...or a Scala Map
val fromMap = Json.obj(Map("foo" -> "foo text", "bar" -> 3.45d))

// ...or a String
val fromString = Json.obj(
  """
    |{
    |  "foo": "foo text",
    |  "bar": 3.45,
    |  "baz": false,
    |  "myInt": 2147483647
    |}
  """.stripMargin)

// Additionally, the json interpolator can be used:
val fromInterpolator =
  json"""
        {
          "foo": "foo text",
          "bar": 3.45,
          "baz": false,
          "myInt": 2147483647
        }"""
```

## JsonArray

JSON arrays are built similarly:

```scala
//{
import collection.immutable.SortedSet
import io.vertx.lang.scala.json.Json.arr
import io.vertx.lang.scala.json.jsonArray
//}
// Json.arr takes...
// a vararg of values
val fromVararg = arr("4", "8", "15", "16", "23", "42")

// ...or a Seq
val fromSeq = arr(List("108", "216"))

// ...or a Set
val fromSet = arr(SortedSet(4, 8, 15, 16, 23, 42))

// ...or a String
val fromString = arr("[4, 8, 15, 16, 23, 42]")

// Additionally, the jsonArray interpolator can be used:
val fromInterpolator = jsonArray"[4, 8, 15, 16, 23, 42]"
```

## Nesting

Any `Iterable` can be nested to create a `JsonObject` containing a `JsonArray`. Also any `Map` can be nested
in order to create a `JsonArray` containing `JsonObjects`:

```scala
//{
import io.vertx.lang.scala.json.Json.*
//}
// Nesting a JsonArray in a JsonObject
val nestedArray = obj("k1" -> 42, "k2" -> List(3, 2, 1))
// res1: JsonObject = {"k1":42,"k2":[3,2,1]}

// ...and vice versa
val nestedObject = arr(1, 2, 3, Map("k1" -> 42, "k2" -> "bar"))
// res2: JsonArray = [1,2,3,{"k1":42,"k2":"bar"}]
```

Deep nesting can be achieved by subsequent usage of `Json.obj()` or `Json.arr()`:

```scala
//{
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json
import io.vertx.lang.scala.json.Json.{arr, obj}
//}
Json.obj(
        "webappconf" -> obj(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Vector(1, 2, obj("next" -> List(3, 4))),
          "some_list" -> arr(1, 2, Vector(3, 4)),
          "inbound_permitted" -> List(
            obj(
              "address" -> "acme.bar",
              "match" -> obj(
                "action" -> "foo")),
            obj(
              "address" -> "acme.baz",
              "match" -> obj(
                "action" -> "index"))),
          "outbound_permitted" -> Array(new JsonObject())))
```
