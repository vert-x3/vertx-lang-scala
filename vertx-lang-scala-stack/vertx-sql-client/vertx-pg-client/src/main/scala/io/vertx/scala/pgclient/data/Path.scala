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

import io.vertx.pgclient.data.{Path => JPath}
import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._

/**
 * Path data type in Postgres represented by lists of connected points.
 * Paths can be open, where the first and last points in the list are considered not connected,
 * or closed, where the first and last points are considered connected.

 */

class Path(private val _asJava: JPath) {
  def asJava = _asJava
  def setOpen(value: Boolean) = {
    asJava.setOpen(value)
    this
  }

  def isOpen: Boolean = {
    asJava.isOpen().asInstanceOf[Boolean]
  }

  def setPoints(value: scala.collection.mutable.Buffer[Point]) = {
    asJava.setPoints(value.map(_.asJava).asJava)
    this
  }

  def getPoints: scala.collection.mutable.Buffer[Point] = {
    asJava.getPoints().asScala.map(x => Point(x))
  }

}


object Path {
  
  def apply() = {
    new Path(new JPath(emptyObj()))
  }
  
  def apply(t: JPath) = {
    if (t != null) {
      new Path(t)
    } else {
      new Path(new JPath(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Path = {
    if (json != null) {
      new Path(new JPath(json))
    } else {
      new Path(new JPath(emptyObj()))
    }
  }
}

