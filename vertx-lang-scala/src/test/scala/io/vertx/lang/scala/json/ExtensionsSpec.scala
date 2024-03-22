package io.vertx.lang.scala.json

import org.scalatest.Inside
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers
import io.vertx.core.json.{JsonArray, JsonObject}
import java.lang.Boolean.FALSE

class ExtensionsSpec extends AnyFunSpec, Matchers, Inside:
  describe("JsonObject.asMap extension") {
    it("should return a Map representation of some JsonObject") {
      val jsonObject = JsonObject.of("foo", "foo text", "optional", true)
      jsonObject.asMap("foo") should equal("foo text")
      jsonObject.asMap("optional") should equal(true)
    }

    it("should convert nested JsonObjects and JsonArrays") {
      val jsonObject = JsonObject.of(
        "foo", "bar",
        "baz", JsonObject.of(
          "qux", "qax",
          "foobar", "foobaz",
          "fooqux", JsonObject.of(
            "barfoo", "barbar",
            "barbar", "barbaz",
            "barqux", JsonArray.of(1, 2, 3, 4)
          )))
      val map = jsonObject.asMap
      map("foo") should equal("bar")
      map("baz") shouldBe a[Map[String, ?]]
      val bazMap = map("baz").asInstanceOf[Map[String, ?]]
      bazMap("fooqux") shouldBe a[Map[String, ?]]
      val fooquxMap = bazMap("fooqux").asInstanceOf[Map[String, ?]]
      fooquxMap("barqux") shouldBe a[List[?]]
    }
  }


  describe("JsonArray.asList extension") {
    it("should return a List representation of some JsonArray") {
      val jsonArray = JsonArray.of(1, 2, 3)
      jsonArray.asList should contain inOrderOnly(1, 2, 3)
    }

    it("convert nested JsonObjects and JsonArrays") {
      val jsonArray = JsonArray.of(0,
        1,
        2,
        JsonArray.of(true, false),
        4,
        JsonArray.of(0, 1, JsonArray.of(0, 1, JsonArray.of(0, 1, 2))),
        6,
        JsonObject.of("foo", "bar"),
      )
      val list = jsonArray.asList
      list(3) shouldBe a[List[?]]
      list(3).asInstanceOf[List[?]].length should be(2)
      list(5) shouldBe a[List[?]]
      list(5).asInstanceOf[List[?]](2).asInstanceOf[List[?]](2) shouldBe a[List[?]]
      list(7) shouldBe a[Map[String, ?]]
    }
  }


  describe("json String interpolator") {
    it("should be able to construct an empty JsonObject") {
      json"{}" should equal(JsonObject())
    }

    it("should be able to construct a flat JsonObject") {
      val json = json"""{ "foo":  "foo text", "bar":  3.45, "baz":  false, "myInt":  23 }"""

      inside(json) { case j: JsonObject =>
        j.getString("foo") should equal("foo text")
        j.getFloat("bar") should equal(3.45f)
        j.getBoolean("baz") should be(FALSE)
        j.getInteger("myInt") should be(23)
      }
    }

    it("should interpolate variables") {
      val myInt = Int.MaxValue
      val json = json"""{ "myInt": $myInt }"""

      inside(json) { case j: JsonObject =>
        j.getInteger("myInt") should equal(myInt)
      }
    }

    it("should be able to create nested JsonObjects") {
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
  }


  describe("jsonArray String interpolator") {
    it("should return an empty JsonArray") {
      jsonArray"[]" should equal(JsonArray())
    }

    it("be able to construct a flat JsonArray") {
      inside(jsonArray"[4, 8, 15, 16, 23, 42]") { case a: JsonArray =>
        a.asList should contain allElementsOf List(4, 8, 15, 16, 23, 42)
      }
    }

    it("should be able to construct a JsonArray of JsonObjects") {
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
  }


