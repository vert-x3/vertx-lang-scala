package io.vertx.lang.scala.json

import org.scalatest.Inside
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers

import java.net.URI

class JsonPointerSpec extends AnyFunSpec, Matchers, Inside:

  describe("JsonPointer") {
    it("should be constructable from a String") {
      JsonPointer("/foo/bar") shouldBe a[JsonPointer]
      an [IllegalArgumentException] should be thrownBy JsonPointer("|foo|bar")
    }

    it("should be constructable from a String, returning Option for safety") {
      JsonPointer.fromOption("/foo/bar") should matchPattern { case Some(_) => }
      JsonPointer.fromOption("|foo|bar") should matchPattern { case None => }
    }

    it("should be constructable from an URI") {
      JsonPointer(URI("/foo/bar")) shouldBe a[JsonPointer]
      an [IllegalArgumentException] should be thrownBy JsonPointer(URI("https://vertx.io/docs/vertx-core/java/#_json_pointers"))
    }

    it("should be constructable from an URI, returning Option for safety") {
      JsonPointer.fromURIOption(URI("/foo/bar")) should matchPattern { case Some(_) => }
      JsonPointer.fromURIOption(URI("https://vertx.io/docs/vertx-core/java/#_json_pointers")) should matchPattern { case None => }
    }

    it("should be copy-able") {
      JsonPointer.fromOption("/foo/bar") match
        case Some(orig) =>
          val copy = orig.copy()
          copy should not be theSameInstanceAs(orig)
          copy should equal(orig)
        case None       => fail("should not be None")
    }

    it("should return the stringified pointer") {
      JsonPointer.fromOption("/foo/bar").map(_.toString) match
        case Some(str) => str should be("/foo/bar")
        case None      => fail("should not be None")
    }

    it("should determine if it is a root pointer") {
      JsonPointer().isRootPointer should be(true)
      JsonPointer("/foo/bar").isRootPointer should be(false)
    }

    it("should determine if it is a local pointer") {
      JsonPointer("/foo/bar").isLocalPointer should be(true)
      JsonPointer(URI("/foo/bar")).isLocalPointer should be(false)
    }

    it("should determine if it is the parent of another pointer") {
      JsonPointer("/foo").isParent(JsonPointer("/foo/bar")) should be(true)
      JsonPointer("/foo").isParent(JsonPointer("/foo")) should be(false)
    }

    it("should calculate the parent pointer") {
      val pointer = JsonPointer("/foo/bar/baz/qux")
      pointer.parent.toString should be("/foo/bar/baz")
      pointer.toString should be("/foo/bar/baz/qux")
    }
  }

  describe("Appending to a JsonPointer") {
    val pointer = JsonPointer("/foo/bar")

    it("should append an unescaped String") {
      // See RFC 6901, No. 5:
      // Note that before processing a JSON string as a JSON Pointer,
      // backslash escape sequences must be unescaped
      val appended = pointer.appended("baz")
      appended.toString should be("/foo/bar/baz")
      pointer.toString should be("/foo/bar")
    }

    it("should append a sequence of String tokens") {
      val appended = pointer.appended("baz", "qux", "qax")
      appended.toString should be("/foo/bar/baz/qux/qax")
      pointer.toString should be("/foo/bar")
    }

    it("should append an index") {
      val appended = pointer.appended(23)
      appended.toString should be("/foo/bar/23")
      pointer.toString should be("/foo/bar")
    }

    it("should append another JsonPointer") {
      val appended = pointer.appended(JsonPointer("/baz/qux"))
      appended.toString should be("/foo/bar/baz/qux")
      pointer.toString should be("/foo/bar")
    }
  }

  describe("Querying") {}
