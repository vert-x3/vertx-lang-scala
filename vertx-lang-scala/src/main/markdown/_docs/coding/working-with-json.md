---
title: Working with JSON
---

# Working with JSON

JSON is widely used throughout HTTP APIs nowadays and it is also one of the most commonly used data formats
for the Vert.x EventBus. That makes good JSON support essential. This page describes how to construct, read
and alter JSON objects and arrays with the Vert.x for Scala API.

## Builders & Interpolators

Creating `JsonObject` and `JsonArray` instances is easily done using either the builder API in
[[io.vertx.lang.scala.json.Json]] or the custom
[String Interpolator](https://docs.scala-lang.org/scala3/book/string-interpolation.html) in the
package object [[io.vertx.lang.scala.json]].

### JsonObject

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
val bar = 3.45
val myInt = 2147483647
val fromInterpolator =
  json"""
        {
          "foo": "foo text",
          "bar": $bar,
          "baz": false,
          "myInt": $myInt
        }"""
```

### JsonArray

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
val fortytwo = 42
val fromInterpolator = jsonArray"[4, 8, 15, 16, 23, $fortytwo]"
```

### Nesting

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

## From JsonObject and JsonArray to Map and List

Converting from existing `JsonObject` or `JsonArray` instances to Scala `Map` or `List` is supported by
extension methods defined in the package [[io.vertx.lang.scala.json]]:

  - [[io.vertx.lang.scala.json.package.asMap]] - to recursively convert from a `JsonObject` to a Scala `Map`
  - [[io.vertx.lang.scala.json.package.asList]] - to recursively convert from  a `JsonArray` to a Scala `List`


## Json Pointers

Vert.x for Scala provides the [[io.vertx.lang.scala.json.JsonPointer]], which is a Scala wrapper for
`io.vertx.core.json.pointer.JsonPointer` from core Vert.x. The wrapper's benefits are typesafe as well as
immutable operations.

To build a `JsonPointer`, use its `apply` method:

```scala
//{
import io.vertx.lang.scala.json.JsonPointer
//}
val pointer1 = JsonPointer("/hello/world")
val pointer2 = JsonPointer() // root pointer
  .appended("hello")
  .appended("world")
```

### Querying

After instantiation, the `query` method can be used to query a value from a `JsonObject` or
`JsonArray`.

Note: The type argument must be supplied when calling this method to indicate the desired return type:

```scala
//{
import io.vertx.lang.scala.json.*
//}
val json =
  json"""{
    "hello": {
      "world": "¡Hola, mundo!"
    },
    "numbers": [4, 8, 15, 16, 23, 42]
  }"""
val worldPtr = JsonPointer("/hello/world")
val numbrPtr = JsonPointer("/numbers/5")
val spanish  = worldPtr.query[String](json).getOrElse("¡Perdón!") // "¡Hola, mundo!"
val fortytwo = numbrPtr.query[Double](json).getOrElse(0)          // 42
// the following query won't work because the expected return type is wrong
val wontwork = numbrPtr.query[String](json)                       // None
```

### Writing

The `write` method can be used to add or update values in a `JsonObject` or `JsonArray`.

Note: For `JsonArrays` values can only be _added_. It is currently impossible to _change_ a value. If
required, create a new array.

Note: The `write` method will return a new `JsonObject` or `JsonArray`. The original one will be
left untouched.

```scala
//{
import io.vertx.lang.scala.json.*
//}
val json =
  json"""{
    "hello": {
      "world": "¡Hola, mundo!"
    },
    "numbers": [4, 8, 15, 16, 23, 42]
  }"""
val moonPtr      = JsonPointer("/hello/moon")
val firstElement = JsonPointer("/numbers/0")
val arrayPtr     = JsonPointer("/numbers")
moonPtr.write(json, "¡Hola, Luna!")                   // adds "moon": "¡Hola, Luna!"
firstElement.write(json, 0)                           // adds 0, resulting in [0, 4, 8, 15, 16, 23, 42]
arrayPtr.write(json, Json.arr(0, 8, 15, 16, 23, 42))  // replaces 4 with 0, resulting [0, 8, 15, 16, 23, 42]
```
