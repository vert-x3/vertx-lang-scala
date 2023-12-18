package io.vertx.lang.scala.json

import org.scalatest.Inside
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.net.URI

class JsonPointerSpec extends AnyFlatSpec, Matchers, Inside:

  "JsonPointer" should "have an isRootPointer function" in :
    JsonPointer().isRootPointer should be(true)

  it should "be constructable from a String" in :
    JsonPointer.from("/foo/bar") should matchPattern { case Some(_) => }
    JsonPointer.from("|foo|bar") should matchPattern { case None => }

  it should "be constructable from a URI" in :
    JsonPointer.fromURI(URI("/foo/bar")) should matchPattern { case Some(_) => }
    JsonPointer.fromURI(URI("https://vertx.io/docs/vertx-core/java/#_json_pointers")) should matchPattern { case None => }

  it should "support the copy() function" in :
    JsonPointer.from("/foo/bar") match
      case Some(orig) =>
        val copy = orig.copy()
        copy should not be theSameInstanceAs(orig)
        copy should equal(orig)
      case None       => fail("should not be None")

  it should """return "/foo/bar" when toString is called""" in :
    JsonPointer.from("/foo/bar").map(_.toString) match
      case Some(str) => str should be("/foo/bar")
      case None      => fail("should not be None")
