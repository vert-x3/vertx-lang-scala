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

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions._

/**
 * @author Edgar Chan
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
class JsonTest {

  @Test
  def jsonObjectTest(): Unit = {

    val enc = """{"foo":"foo text","bar":3.45,"baz":false,"myInt":2147483647}"""

    val obj: JsonObject =
      Json.obj(
        "foo" -> "foo text",
        "bar" -> 3.45d,
        "baz" -> false,
        "myInt" -> Integer.MAX_VALUE)

    assertEquals("foo text", obj.getString("foo"))
    assertEquals(3.45d, obj.getDouble("bar"), 1e-15)
    assertEquals(false, obj.getBoolean("baz"))
    assertEquals(Integer.MAX_VALUE, obj.getInteger("myInt"))
    assertEquals(enc, obj.encode())

  }

  @Test
  def wrapperConversionTest(): Unit =  {

    val obj = Json.obj("foo" -> "foo text", "optional" -> true)

    val wrapped: JsObject = obj
    val scalaMapFields: scala.collection.Map[String, AnyRef] = wrapped.asMap

    //Get the original object
    val obj2: JsonObject = wrapped

    assertEquals("foo text", scalaMapFields("foo"))
    assertEquals(true, obj2.getBoolean("optional"))

  }

  @Test
  def jsonArrayTest(): Unit =  {

    val enc = """["f",3,"b",7,35.4,true]"""
    val array = Json.arr("f", 3, "b", 7, 35.4f, true)

    assertEquals(6, array.size())
    assertEquals(enc, array.encode())
  }
/*
  @Test @Ignore("https://groups.google.com/forum/?fromgroups=#!topic/vertx/TJ2B3D_1zrA and https://groups.google.com/forum/?fromgroups=#!topic/vertx/lOmoB96w8hc")
  def customObjTest() {
    import java.util.Date

    case class Custom(date: Date, other: Boolean)
    val info = Custom(new Date(), false)
    val obj1 = Json.obj("custom" -> info)

    assertEquals(info, obj1.getValue[Custom]("custom"))
  }
*/
  @Test
  def nestedObjectsTest(): Unit =  {
    val obj =
      Json.obj(
        "webappconf" -> Json.obj(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Json.arr(1, 2, Json.obj("next" -> Json.arr(3, 4))),
          "some_list" -> Json.arr(1, 2, Json.arr(3, 4)),
          "inbound_permitted" -> Json.arr(
            Json.obj(
              "address" -> "acme.bar",
              "match" -> Json.obj(
                "action" -> "foo")),
            Json.obj(
              "address" -> "acme.baz",
              "match" -> Json.obj(
                "action" -> "index"))),
          "outbound_permitted" -> Json.arr(
            new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def nestedObjectsWithListsTest(): Unit =  {
    val obj =
      Json.obj(
        "webappconf" -> Json.obj(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> List(1, 2, Json.obj("next" -> List(3, 4))),
          "some_list" -> List(1, 2, List(3, 4)),
          "inbound_permitted" -> List(
            Json.obj(
              "address" -> "acme.bar",
              "match" -> Json.obj(
                "action" -> "foo")),
            Json.obj(
              "address" -> "acme.baz",
              "match" -> Json.obj(
                "action" -> "index"))),
          "outbound_permitted" -> List(new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def nestedObjectsWithArraysTest(): Unit =  {
    val obj =
      Json.obj(
        "webappconf" -> Json.obj(
          "port" -> 8080,
          "ssl" -> false,
          "bridge" -> true,
          "some_nested" -> Array(1, 2, Json.obj("next" -> Array(3, 4))),
          "some_list" -> Array(1, 2, Array(3, 4)),
          "inbound_permitted" -> Array(
            Json.obj(
              "address" -> "acme.bar",
              "match" -> Json.obj(
                "action" -> "foo")),
            Json.obj(
              "address" -> "acme.baz",
              "match" -> Json.obj(
                "action" -> "index"))),
          "outbound_permitted" -> Array(new JsonObject())))

    assertEquals(jsonString, obj.encode())
  }

  @Test
  def mixedNestedObjectsTest(): Unit =  {
    val obj =
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

    assertEquals(jsonString, obj.encode())
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

}
