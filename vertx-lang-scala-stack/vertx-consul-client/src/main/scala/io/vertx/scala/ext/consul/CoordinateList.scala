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

import io.vertx.lang.scala.json.Json._
import io.vertx.core.json.JsonObject
import scala.collection.JavaConverters._
import io.vertx.ext.consul.{CoordinateList => JCoordinateList}

/**
  * Holds result of network coordinates query
  */
class CoordinateList(private val _asJava: JCoordinateList) {

  def asJava = _asJava

  /**
    * Set Consul index, a unique identifier representing the current state of the requested coordinates
    */
  def setIndex(value: Long) = {
    asJava.setIndex(value)
    this
  }
  def getIndex: Long = {
    asJava.getIndex().asInstanceOf[Long]
  }

  /**
    * Set list of coordinates
    */
  def setList(value: scala.collection.mutable.Buffer[Coordinate]) = {
    asJava.setList(value.map(_.asJava).asJava)
    this
  }
  def getList: scala.collection.mutable.Buffer[Coordinate] = {
    asJava.getList().asScala.map(x => Coordinate(x))
  }
}

object CoordinateList {
  
  def apply() = {
    new CoordinateList(new JCoordinateList(emptyObj()))
  }
  
  def apply(t: JCoordinateList) = {
    if (t != null) {
      new CoordinateList(t)
    } else {
      new CoordinateList(new JCoordinateList(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): CoordinateList = {
    if (json != null) {
      new CoordinateList(new JCoordinateList(json))
    } else {
      new CoordinateList(new JCoordinateList(emptyObj()))
    }
  }
}
