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
package io.vertx.lang.scala

import io.vertx.core.json.{JsonArray, JsonObject}

import scala.collection.Map
import scala.collection.JavaConverters.*
/**
 * Scala extensions for more idiomatic handling of [[io.vertx.core.json.JsonObject]]
 * and [[io.vertx.core.json.JsonArray]].
 */
package object json {

  import scala.language.implicitConversions

  implicit def toJsonObject(js: JsObject): JsonObject = js.internal

  implicit class JsObject(val internal: JsonObject) {

    def asMap: Map[String, AnyRef] =
      (for {
        (key, value) <- internal.getMap.asScala
        mappedValue = value match {
          case j: JsonObject => j.asMap
          case a: JsonArray => a.asList
          case _ => value
        }
      }
      yield (key, mappedValue)).toMap
  }

  implicit class JsArray(val internal: JsonArray) {
    /**
     * Get the underlying List as an immutable [[List]]. Unlike
     * Vert.x core's [[io.vertx.core.json.JsonArray.getList]], this method guarantees
     * to convert every contained [[JsonObject]] or [[JsonArray]] into a [[Map]] or [[List]],
     * respectively. That's done, however, at the cost of one pass through each contained
     * [[JsonObject]] or [[JsonArray]].
     */
    def asList: List[Any] = (
      for {
        value <- internal.getList.asScala
        mappedValue = value match {
          case j: JsonObject => j.asMap
          case a: JsonArray  => a.asList
          case _             => value
        }
      }
      yield mappedValue
    ).toList
  }

  implicit class JsonString(val sc: StringContext) {
    /**
     * Interpolates the given String as a [[JsonObject]].
     */
    def json(args: Any*): JsonObject = {
      new JsonObject(interpolated(sc.parts, args))
    }

    /**
     * Interpolates the given String as a [[JsonArray]].
     */
    def jsonArray(args: Any*): JsonArray = {
      new JsonArray(interpolated(sc.parts, args))
    }
  }

  private def interpolated(stringParts: Seq[String], args: Seq[Any]): String = {
    val stringBuilder = new StringBuilder()
    for (
      (stringPart, argument) <- stringParts.zipAll(args, "", "")
    ) {
      stringBuilder.append(stringPart).append(argument.toString)
    }
    stringBuilder.toString.trim
  }

}
