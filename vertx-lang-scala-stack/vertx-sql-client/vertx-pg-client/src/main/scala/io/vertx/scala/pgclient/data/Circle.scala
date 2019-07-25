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
import io.vertx.pgclient.data.{Circle => JCircle}

/**
 * Circle data type in Postgres represented by a center <a href="../../../../../../../cheatsheet/Point.html">Point</a> and radius.

 */

class Circle(private val _asJava: JCircle) {
  def asJava = _asJava
  def setCenterPoint(value: Point) = {
    asJava.setCenterPoint(value.asJava)
    this
  }

  def getCenterPoint: Point = {
    Point(asJava.getCenterPoint())
  }

  def setRadius(value: Double) = {
    asJava.setRadius(value)
    this
  }

  def getRadius: Double = {
    asJava.getRadius().asInstanceOf[Double]
  }

}


object Circle {
  
  def apply() = {
    new Circle(new JCircle(emptyObj()))
  }
  
  def apply(t: JCircle) = {
    if (t != null) {
      new Circle(t)
    } else {
      new Circle(new JCircle(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Circle = {
    if (json != null) {
      new Circle(new JCircle(json))
    } else {
      new Circle(new JCircle(emptyObj()))
    }
  }
}

