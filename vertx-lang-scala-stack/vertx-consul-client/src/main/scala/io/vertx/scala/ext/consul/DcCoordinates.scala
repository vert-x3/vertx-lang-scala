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
import io.vertx.ext.consul.{DcCoordinates => JDcCoordinates}

/**
 * Holds coordinates of servers in datacenter
 */

class DcCoordinates(private val _asJava: JDcCoordinates) {
  def asJava = _asJava
  /**
   * Set datacenter
   */
  def setDatacenter(value: String) = {
    asJava.setDatacenter(value)
    this
  }

  def getDatacenter: String = {
    asJava.getDatacenter().asInstanceOf[String]
  }

  /**
   * Set list of servers in datacenter
   */
  def setServers(value: scala.collection.mutable.Buffer[Coordinate]) = {
    asJava.setServers(value.map(_.asJava).asJava)
    this
  }

  def getServers: scala.collection.mutable.Buffer[Coordinate] = {
    asJava.getServers().asScala.map(x => Coordinate(x))
  }

}


object DcCoordinates {
  
  def apply() = {
    new DcCoordinates(new JDcCoordinates(emptyObj()))
  }
  
  def apply(t: JDcCoordinates) = {
    if (t != null) {
      new DcCoordinates(t)
    } else {
      new DcCoordinates(new JDcCoordinates(emptyObj()))
    }
  }
  
  def fromJson(json: JsonObject): DcCoordinates = {
    if (json != null) {
      new DcCoordinates(new JDcCoordinates(json))
    } else {
      new DcCoordinates(new JDcCoordinates(emptyObj()))
    }
  }
}

