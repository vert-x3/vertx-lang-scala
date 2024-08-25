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

import io.vertx.scala.core.{JsonArray, JsonObject}

import java.util
import scala.collection.JavaConverters.*

/**
 * Builder for constructing [[JsonObject JsonObjects]] and [[JsonArray JsonArrays]].
 */
object Json {

  /**
   * Creates a JsonArray from an encoded JSON string.
   *
   * @param json The JSON string.
   * @return The decoded JsonArray.
   */
  def arr(json: String): JsonArray = new JsonArray(json)

  /**
   * Creates a JsonObject from an encoded JSON string.
   *
   * @param json The JSON string.
   * @return The decoded JsonObject.
   */
  def obj(json: String): JsonObject = new JsonObject(json)

  /**
   * Creates an empty JsonArray.
   */
  def arr(): JsonArray = new JsonArray()

  /**
   * Creates an empty JsonObject.
   */
  def obj(): JsonObject = new JsonObject()

  /**
   * Constructs a JsonObject from a [[Map Scala Map]].
   */
  def obj(map: collection.Map[String, Any]): JsonObject = obj(map.toSeq: _*)

  /**
   * Constructs a JsonObject from a [[java.util.Map Java Map]].
   */
  def obj(map: util.Map[String, Object]): JsonObject = new JsonObject(map)

  /**
   * Constructs a JsonObject from a fieldName -> value pairs.
   */
  def obj(fields: (String, Any)*): JsonObject = {
    val o = new JsonObject()
    fields.foreach {
      case (key, l: Array[_]) => o.put(key, listToJsArr(l.toIndexedSeq))
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
    if (fields.length == 1) fields(0) match {
      case array: Array[_]       => listToJsArr(array.toIndexedSeq)
      case iterable: Iterable[_] => listToJsArr(iterable)
      case value                 => arr().add(value)
    } else {
      fields.foldLeft(JsonArray()) {
        case (a, array: Array[_])       => a.add(arr(array))
        case (a, map: Map[String, _])   => a.add(obj(map))
        case (a, iterable: Iterable[_]) => a.add(arr(iterable))
        case (a, f)                     => a.add(f)
      }
    }
  }

  private def listToJsArr(a: Iterable[_]) = Json.arr(a.toSeq *)

  implicit class JsArray(val internal: JsonArray) extends AnyVal {

    /**
     * @deprecated see extension for JsonArray in [[io.vertx.lang.scala.package]]
     */
    def list: List[Any] = {
      internal.getList.asScala.toList
    }
  }
}
