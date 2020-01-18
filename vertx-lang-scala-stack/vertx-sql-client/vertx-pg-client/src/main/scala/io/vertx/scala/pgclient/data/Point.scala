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
import io.vertx.pgclient.data.{Point => JPoint}

/**
 * A Postgresql point.

 */

class Point(private val _asJava: JPoint) {
  def asJava = _asJava
  def setX(value: Double) = {
    asJava.setX(value)
    this
  }

  def getX: Double = {
    asJava.getX().asInstanceOf[Double]
  }

  def setY(value: Double) = {
    asJava.setY(value)
    this
  }

  def getY: Double = {
    asJava.getY().asInstanceOf[Double]
  }

}


object Point {

  def apply() = {
    new Point(new JPoint(emptyObj()))
  }

  def apply(t: JPoint) = {
    if (t != null) {
      new Point(t)
    } else {
      new Point(new JPoint(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): Point = {
    if (json != null) {
      new Point(new JPoint(json))
    } else {
      new Point(new JPoint(emptyObj()))
    }
  }
}

