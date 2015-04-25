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

import scala.annotation.implicitNotFound

@implicitNotFound(msg = "Cannot find add operations for type ${T}")
trait JsonElemOps[T] {
  def addToObj(o: JsonObject, key: String, v: T): JsonObject
  def addToArr(a: JsonArray, v: T): JsonArray
}

object JsonElemOps {
  implicit object JsonStringElem extends JsonElemOps[String] {
    def addToObj(o: JsonObject, key: String, v: String): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: String): JsonArray = a.add(v)
  }
  implicit object JsonIntElem extends JsonElemOps[Int] {
    def addToObj(o: JsonObject, key: String, v: Int): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: Int): JsonArray = a.add(v)
  }
  implicit object JsonBoolElem extends JsonElemOps[Boolean] {
    def addToObj(o: JsonObject, key: String, v: Boolean): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: Boolean): JsonArray = a.add(v)
  }
  implicit object JsonFloatElem extends JsonElemOps[Float] {
    def addToObj(o: JsonObject, key: String, v: Float): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: Float): JsonArray = a.add(v)
  }
  implicit object JsonJsObjectElem extends JsonElemOps[JsonObject] {
    def addToObj(o: JsonObject, key: String, v: JsonObject): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: JsonObject): JsonArray = a.add(v)
  }
  implicit object JsonJsArrayElem extends JsonElemOps[JsonArray] {
    def addToObj(o: JsonObject, key: String, v: JsonArray): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: JsonArray): JsonArray = a.add(v)
  }
  implicit object JsonBinaryElem extends JsonElemOps[Array[Byte]] {
    def addToObj(o: JsonObject, key: String, v: Array[Byte]): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: Array[Byte]): JsonArray = a.add(v)
  }
  implicit object JsonAnyElem extends JsonElemOps[Any] {
    def addToObj(o: JsonObject, key: String, v: Any): JsonObject = o.put(key, v)
    def addToArr(a: JsonArray, v: Any): JsonArray = a.add(v)
  }
}

/**
 * Helper to construct JsonObjects and JsonArrays.
 *
 * @author Edgar Chan
 * @author <a href="http://www.campudus.com/">Joern Bernhardt</a>
 */
object Json {

  /**
   * Creates a JsonArray from an encoded JSON string.
   *
   * @param json The JSON string.
   * @return The decoded JsonArray.
   */
  def fromArrayString(json: String): JsonArray = new JsonArray(json)

  /**
   * Creates a JsonObject from an encoded JSON string.
   * @param json The JSON string.
   * @return The decoded JsonObject.
   */
  def fromObjectString(json: String): JsonObject = new JsonObject(json)

  /**
   * Creates an empty JsonArray.
   *
   * @return An empty JsonArray.
   */
  def emptyArr(): JsonArray = new JsonArray()

  /**
   * Creates an empty JsonObject.
   *
   * @return An empty JsonObject.
   */
  def emptyObj(): JsonObject = new JsonObject()

  /**
   * Constructs a JsonObject from a fieldName -> value pairs.
   *
   * @param fields The fieldName -> value pairs
   * @return A JsonObject containing the name -> value pairs.
   */
  def obj(fields: (String, Any)*): JsonObject = {
    val o = new JsonObject()
    fields.foreach {
      case (key, l: Array[_]) => addToObject(o, key, listToJsArr(l))
      case (key, l: Seq[_]) => addToObject(o, key, listToJsArr(l))
      case (key, value) => addToObject(o, key, value)
    }
    o
  }

  /**
   * Creates a JsonArray from a sequence of values.
   *
   * @param fields The elements to put into the JsonArray.
   * @return A JsonArray containing the provided elements.
   */
  def arr(fields: Any*): JsonArray = {
    val a = new JsonArray()
    fields.foreach {
      case array: Array[_] => addToArray(a, listToJsArr(array))
      case seq: Seq[_] => addToArray(a, listToJsArr(seq))
      case f => addToArray(a, f)
    }
    a
  }

  private def listToJsArr(a: Seq[_]) = Json.arr(a: _*)
  private def addToArray[T: JsonElemOps](a: JsonArray, fieldValue: T) = {
    implicitly[JsonElemOps[T]].addToArr(a, fieldValue)
  }

  private def addToObject[T: JsonElemOps](o: JsonObject, fieldName: String, fieldValue: T) = {
    implicitly[JsonElemOps[T]].addToObj(o, fieldName, fieldValue)
  }

}