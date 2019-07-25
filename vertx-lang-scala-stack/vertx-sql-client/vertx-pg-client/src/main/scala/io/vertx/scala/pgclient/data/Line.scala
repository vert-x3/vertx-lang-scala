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
import io.vertx.pgclient.data.{Line => JLine}

/**
 * Line data type in Postgres represented by the linear equation Ax + By + C = 0, where A and B are not both zero.

 */

class Line(private val _asJava: JLine) {
  def asJava = _asJava
  def setA(value: Double) = {
    asJava.setA(value)
    this
  }

  def getA: Double = {
    asJava.getA().asInstanceOf[Double]
  }

  def setB(value: Double) = {
    asJava.setB(value)
    this
  }

  def getB: Double = {
    asJava.getB().asInstanceOf[Double]
  }

  def setC(value: Double) = {
    asJava.setC(value)
    this
  }

  def getC: Double = {
    asJava.getC().asInstanceOf[Double]
  }

}


object Line {
  
  def apply() = {
    new Line(new JLine(emptyObj()))
  }
  
  def apply(t: JLine) = {
    if (t != null) {
      new Line(t)
    } else {
      new Line(new JLine(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): Line = {
    if (json != null) {
      new Line(new JLine(json))
    } else {
      new Line(new JLine(emptyObj()))
    }
  }
}

