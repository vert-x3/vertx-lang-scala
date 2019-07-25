/*
 * Copyright 2014 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package io.vertx.scala.pgclient.data

import io.vertx.pgclient.data.{Polygon => JPolygon}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Polygon data type in Postgres represented by lists of points (the vertexes of the polygon).
 * Polygons are very similar to closed paths, but are stored differently and have their own set of support routines.

 */

class Polygon(private val _asJava: JPolygon) {
  def asJava = _asJava
  def setPoints(value: scala.collection.mutable.Buffer[Point]) = {
    asJava.setPoints(value.map(_.asJava).asJava)
    this
  }

  def getPoints: scala.collection.mutable.Buffer[Point] = {
    asJava.getPoints().asScala.map(x => Point(x))
  }

}


object Polygon {
  
  def apply() = {
    new Polygon(new JPolygon(emptyObj()))
  }
  
  def apply(t: JPolygon) = {
    if (t != null) {
      new Polygon(t)
    } else {
      new Polygon(new JPolygon(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Polygon = {
    if (json != null) {
      new Polygon(new JPolygon(json))
    } else {
      new Polygon(new JPolygon(emptyObj()))
    }
  }
}

