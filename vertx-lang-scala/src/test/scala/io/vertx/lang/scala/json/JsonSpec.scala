/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.lang.scala.json

import io.vertx.core.json.{JsonArray, JsonObject}
import java.lang.Boolean.FALSE
import org.scalatest.Inside
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers


class JsonSpec extends AnyFlatSpec, Matchers, Inside:

  "Json.obj()" should "construct an empty JsonObject" in {
    val jsonObject = Json.obj()
    jsonObject.isEmpty should be(true)
    jsonObject.encode should equal("{}")
  }


  it should "construct a flat JsonObject" in {
    val enc = """{"foo":"foo text","bar":3.45,"baz":false,"myInt":2147483647}"""

    val obj: JsonObject =
      Json.obj(
        "foo" -> "foo text",
        "bar" -> 3.45d,
        "baz" -> false,
        "myInt" -> Integer.MAX_VALUE)

    obj.getString("foo") should equal("foo text")
    obj.getDouble("bar") should equal(3.45d)
    obj.getBoolean("baz") should equal(false)
    obj.getInteger("myInt") should equal(Integer.MAX_VALUE)
    obj.encode should equal(enc)
  }


  it should "support at least 3 levels of nesting" in {
    val obj = Json.obj(
      "webappconf" -> Json.obj(
        "port" -> 8080,
        "ssl" -> false,
        "bridge" -> true,
        "some_nested" -> Json.arr(1, 2, Json.obj("next" -> Json.arr(3, 4))),
        "some_list" -> Json.arr(1, 2, Json.arr(3, 4)),
        "inbound_permitted" -> Json.arr(
          Json.obj(
            "address" -> "acme.bar",
            "match" -> Json.obj("action" -> "foo")),
          Json.obj(
            "address" -> "acme.baz",
            "match" -> Json.obj("action" -> "index"))
        ),
        "outbound_permitted" -> Json.arr(new JsonObject())))
    obj.encode() should equal(jsonString)
  }


  it should "convert nested List to JsonArray" in {
    val obj = Json.obj(
      "webappconf" -> Json.obj(
        "port" -> 8080,
        "ssl" -> false,
        "bridge" -> true,
        "some_nested" -> List(1, 2, Json.obj("next" -> List(3, 4))),
        "some_list" -> List(1, 2, List(3, 4)),
        "inbound_permitted" -> List(
          Json.obj(
            "address" -> "acme.bar",
            "match" -> Json.obj("action" -> "foo")),
          Json.obj(
            "address" -> "acme.baz",
            "match" -> Json.obj("action" -> "index"))
        ),
        "outbound_permitted" -> List(new JsonObject())))
    obj.getJsonObject("webappconf").getJsonArray("some_list").size should be(3)
    obj.encode() should equal(jsonString)
  }


  it should "convert nested Array to JsonArray" in {
    val obj = Json.obj(
      "webappconf" -> Json.obj(
        "port" -> 8080,
        "ssl" -> false,
        "bridge" -> true,
        "some_nested" -> Array(1, 2, Json.obj("next" -> Array(3, 4))),
        "some_list" -> Array(1, 2, Array(3, 4)),
        "inbound_permitted" -> Array(
          Json.obj(
            "address" -> "acme.bar",
            "match" -> Json.obj("action" -> "foo")),
          Json.obj(
            "address" -> "acme.baz",
            "match" -> Json.obj("action" -> "index"))
        ),
        "outbound_permitted" -> Array(new JsonObject())))
    obj.getJsonObject("webappconf").getJsonArray("some_list").size should be(3)
    obj.encode() should equal(jsonString)
  }


  it should "convert mixed nested Arrays/Lists to JsonArray" in {
    val obj = Json.obj(
      "webappconf" -> Json.obj(
        "port" -> 8080,
        "ssl" -> false,
        "bridge" -> true,
        "some_nested" -> Vector(1, 2, Json.obj("next" -> List(3, 4))),
        "some_list" -> Json.arr(1, 2, Vector(3, 4)),
        "inbound_permitted" -> List(
          Json.obj(
            "address" -> "acme.bar",
            "match" -> Json.obj("action" -> "foo")),
          Json.obj(
            "address" -> "acme.baz",
            "match" -> Json.obj("action" -> "index"))),
        "outbound_permitted" -> Array(new JsonObject())))
    val someList = obj.getJsonObject("webappconf").getJsonArray("some_list")
    someList.size should be(3)
    someList.getJsonArray(2).size should be(2)
    obj.encode() should equal(jsonString)
  }


  "Json.arr()" should "construct an empty JsonArray" in {
    val jsonArray = Json.arr()
    jsonArray.isEmpty should be(true)
    jsonArray.encode() should equal("[]")
  }

  it should "construct a JsonArray of discrete values" in {
    val enc = """["f",3,"b",7,35.4,true]"""
    val array = Json.arr("f", 3, "b", 7, 35.4f, true)

    array.size should be(6)
    array.encode should equal(enc)
  }

  it should "construct a JsonArray from a List" in {
    val enc = s"""["A","B","C","D","E","F","G"]"""
    val list = List("A", "B", "C", "D", "E", "F", "G")
    val jsonArray = Json.arr(list)

    jsonArray.size should be(7)
    jsonArray.encode should equal(enc)
  }

  it should "construct a JsonArray from a Seq" in {
    val enc = """[1,2,3,4,5,6,7]"""
    val seq = Seq(1, 2, 3, 4, 5, 6, 7)
    val jsonArray = Json.arr(seq)

    jsonArray.size should be(7)
    jsonArray.encode should equal(enc)
  }

  "JsonObject.asMap" should "return a Map representation of some JsonObject" in :
    val jsonObject = JsonObject.of("foo", "foo text", "optional", true)
    jsonObject.asMap("foo") should equal("foo text")
    jsonObject.asMap("optional") should equal(true)


  "JsonArray.asList" should "return a List representation of some JsonArray" in :
    val jsonArray = JsonArray.of(1, 2, 3)
    jsonArray.asList should contain inOrderOnly(1, 2, 3)

  "json interpolator" should "be able to construct an empty JsonObject" in {
    json"{}" should equal(JsonObject())
  }

  it should "be able to construct a flat JsonObject" in {
    val json = json"""{ "foo":  "foo text", "bar":  3.45, "baz":  false, "myInt":  23 }"""

    inside(json) { case j: JsonObject =>
      j.getString("foo") should equal("foo text")
      j.getFloat("bar") should equal(3.45f)
      j.getBoolean("baz") should be(FALSE)
      j.getInteger("myInt") should be(23)
    }
  }

  it should "interpolate variables" in {
    val myInt = Int.MaxValue
    val json = json"""{ "myInt": $myInt }"""

    inside(json) { case j: JsonObject =>
      j.getInteger("myInt") should equal(myInt)
    }
  }

  it should "be able to create nested JsonObjects" in {
    val json =
      json"""{
               "foo": {
                 "bar": {
                   "baz": [4, 8, 15, 16, 23, 42]
                  }
                }
              }"""

    inside(json) { case j: JsonObject =>
      j.getJsonObject("foo")
        .getJsonObject("bar")
        .getJsonArray("baz") should equal(JsonArray("[4, 8, 15, 16, 23, 42]"))
    }
  }

  "jsonArray interpolator" should "return an empty JsonArray" in {
    jsonArray"[]" should equal(JsonArray())
  }

  it should "be able to construct a flat JsonArray" in {
    inside(jsonArray"[4, 8, 15, 16, 23, 42]") { case a: JsonArray =>
      a.asList should contain allElementsOf List(4, 8, 15, 16, 23, 42)
    }
  }

  it should "be able to construct a JsonArray of JsonObjects" in {
    val json =
      jsonArray"""[{
                "location":  "Marseille",
                "weather": "fine"
              },
              {
                "location": "London",
                "weather": "rainy"
              }
            ]"""
    inside(json) { case a: JsonArray =>
      a.getJsonObject(0).getString("location") should equal("Marseille")
      a.getJsonObject(1).getString("location") should equal("London")
    }
  }


  private def jsonString = {
    """
      |{
      |  "webappconf" : {
      |          "port": 8080,
      |          "ssl": false,
      |          "bridge": true,
      |          "some_nested": [1, 2, { "next": [3, 4] }],
      |          "some_list": [1, 2, [3, 4]],
      |          "inbound_permitted": [
      |            {
      |              "address" : "acme.bar",
      |              "match" : {
      |                "action" : "foo"
      |              }
      |            },
      |
      |            {
      |              "address" : "acme.baz",
      |              "match" : {
      |                "action" : "index"
      |              }
      |            }
      |          ],
      |
      |          "outbound_permitted": [
      |            {}
      |          ]
      |        }
      |}
    """.stripMargin.replaceAll("\\s", "")
  }

