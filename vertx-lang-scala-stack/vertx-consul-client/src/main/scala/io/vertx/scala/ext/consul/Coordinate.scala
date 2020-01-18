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

package io.vertx.scala.ext.consul

import io.vertx.core.json.JsonObject
import io.vertx.lang.scala.json.Json._
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{Coordinate => JCoordinate}

/**
 * Holds network coordinates of node
 */

class Coordinate(private val _asJava: JCoordinate) {
  def asJava = _asJava
  /**
   * Set adjustment
   */
  def setAdj(value: Float) = {
    asJava.setAdj(value)
    this
  }

  def getAdj: Float = {
    asJava.getAdj().asInstanceOf[Float]
  }

  /**
   * Set error
   */
  def setErr(value: Float) = {
    asJava.setErr(value)
    this
  }

  def getErr: Float = {
    asJava.getErr().asInstanceOf[Float]
  }

  /**
   * Set height
   */
  def setHeight(value: Float) = {
    asJava.setHeight(value)
    this
  }

  def getHeight: Float = {
    asJava.getHeight().asInstanceOf[Float]
  }

  /**
   * Set name of node
   */
  def setNode(value: String) = {
    asJava.setNode(value)
    this
  }

  def getNode: String = {
    asJava.getNode().asInstanceOf[String]
  }

  /**
   * Set vector
   */
  def setVec(value: scala.collection.mutable.Buffer[Float]) = {
    asJava.setVec(value.map(Float.box).asJava)
    this
  }

  def getVec: scala.collection.mutable.Buffer[Float] = {
    asJava.getVec().asScala.map(x => x.asInstanceOf[Float])
  }

}


object Coordinate {

  def apply() = {
    new Coordinate(new JCoordinate(emptyObj()))
  }

  def apply(t: JCoordinate) = {
    if (t != null) {
      new Coordinate(t)
    } else {
      new Coordinate(new JCoordinate(emptyObj()))
    }
  }

  def fromJson(json: JsonObject): Coordinate = {
    if (json != null) {
      new Coordinate(new JCoordinate(json))
    } else {
      new Coordinate(new JCoordinate(emptyObj()))
    }
  }
}

