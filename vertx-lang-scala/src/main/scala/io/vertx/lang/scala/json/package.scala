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

import scala.jdk.CollectionConverters.*
import scala.collection.*

/**
 * @author swilliams
 * @author Edgar Chan
 */
package object json {

  type JsonArray = io.vertx.core.json.JsonArray
  type JsonObject = io.vertx.core.json.JsonObject

  extension (internal: JsonObject)
    /**
      * Get the underlying Map as `mutable.Map`. This map may contain
      * values that are not the types returned by the JsonObject and with
      * an unpredictable representation of the value, e.g you might get a
      * JSON object as a [[io.vertx.core.json.JsonObject]] or as a Map.
      *
      * @return the underlying Map
      */
    def asMap: mutable.Map[String, AnyRef] = internal.getMap.asScala


  extension (internal: JsonArray)
    /**
      * Get the underlying List as `mutable.ListBuffer`.
      *
      * This list may contain values that are not the types returned by the
      * JsonArray and with an unpredictable representation of the value, e.g
      * you might get a JSON object as a JsonObject or as a Map.
      *
      * @return the underlying List
      */
    def asList: List[Any] = internal.getList.asScala.toList

}
