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
      case (key, l: Array[_]) => o.put(key, listToJsArr(l))
      case (key, l: Seq[_]) => o.put(key, listToJsArr(l))
      case (key, value) => o.put(key, value)
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
      case array: Array[_] => a.add(listToJsArr(array))
      case seq: Seq[_] => a.add(listToJsArr(seq))
      case f => a.add(f)
    }
    a
  }

  private def listToJsArr(a: Seq[_]) = Json.arr(a: _*)
}