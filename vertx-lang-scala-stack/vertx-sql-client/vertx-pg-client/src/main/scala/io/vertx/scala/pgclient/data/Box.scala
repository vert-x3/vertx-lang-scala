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

import io.vertx.pgclient.data.{Box => JBox}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Rectangular box data type in Postgres represented by pairs of <a href="../../../../../../../cheatsheet/Point.html">Point</a>s that are opposite corners of the box.

 */

class Box(private val _asJava: JBox) {
  def asJava = _asJava
  def setLowerLeftCorner(value: Point) = {
    asJava.setLowerLeftCorner(value.asJava)
    this
  }

  def getLowerLeftCorner: Point = {
    Point(asJava.getLowerLeftCorner())
  }

  def setUpperRightCorner(value: Point) = {
    asJava.setUpperRightCorner(value.asJava)
    this
  }

  def getUpperRightCorner: Point = {
    Point(asJava.getUpperRightCorner())
  }

}


object Box {
  
  def apply() = {
    new Box(new JBox(emptyObj()))
  }
  
  def apply(t: JBox) = {
    if (t != null) {
      new Box(t)
    } else {
      new Box(new JBox(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Box = {
    if (json != null) {
      new Box(new JBox(json))
    } else {
      new Box(new JBox(emptyObj()))
    }
  }
}

