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

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.pgclient.data.{LineSegment => JLineSegment}

/**
 * Finite line segment data type in Postgres represented by pairs of <a href="../../../../../../../cheatsheet/Point.html">Point</a>s that are the endpoints of the segment.

 */

class LineSegment(private val _asJava: JLineSegment) {
  def asJava = _asJava
  def setP1(value: Point) = {
    asJava.setP1(value.asJava)
    this
  }

  def getP1: Point = {
    Point(asJava.getP1())
  }

  def setP2(value: Point) = {
    asJava.setP2(value.asJava)
    this
  }

  def getP2: Point = {
    Point(asJava.getP2())
  }

}


object LineSegment {

  def apply() = {
    new LineSegment(new JLineSegment(emptyObj()))
  }

  def apply(t: JLineSegment) = {
    if (t != null) {
      new LineSegment(t)
    } else {
      new LineSegment(new JLineSegment(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): LineSegment = {
    if (json != null) {
      new LineSegment(new JLineSegment(json))
    } else {
      new LineSegment(new JLineSegment(emptyObj()))
    }
  }
}

